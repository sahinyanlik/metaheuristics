package himmelblau;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


/** Himmelblau formula
 * z = ((x^2)+y-11)^2+(x+(y^2-7))^2
 * **/
@Service
public class HimmelblauService {

	private static final Integer M = 300;
	private static final Integer N=15;
	private static final Double alpha = 0.85;
	private static final Double k = 0.1;
	
	public void solveHimmelBlau(){
		Double x=2.0;
		Double y=1.0;
		Double T0=1000.0;
		Double objValCurrent = 0.0;
		for (int i=0;i<M;i++){
			for(int z=0;z<N;z++){
				Double tempX=0.0;
				Double tempY=0.0;
				Double stepSizeX=0.0;
				Double stepSizeY=0.0;
				
				Double randX1= Math.random();
				Double randX2= Math.random();
				Double randY1= Math.random();
				Double randY2= Math.random();
				
				if(randX1 >=0.5){
					stepSizeX=k*randX2;
				}else{
					stepSizeX = -k*randX2;
				}
				
				if(randY1>=0.5){
					stepSizeY=k*randY2;
				}else{
					stepSizeY=-k*randY2;
				}
				
				tempX=x+stepSizeX;
				tempY=y+stepSizeY;
				
				Double objValPossible = Math.pow((Math.pow(tempX,2)+tempY-11),2)+Math.pow(tempX+(Math.pow(tempY, 2)-7),2);
				objValCurrent = Math.pow((Math.pow(x,2)+y-11),2)+Math.pow(x+(Math.pow(y, 2)-7),2);
				
				Double rand = Math.random();
				Double formula = 1/(Math.exp((objValPossible-objValCurrent)/T0));
				
				if( objValPossible <= objValCurrent){
					x=tempX;
					y=tempY;
				}else if(rand <= formula){
					x=tempX;
					y=tempY;
				}
			}
			T0 = alpha*T0;
		}
		System.out.println(String.format("%,.3f", x));
		System.out.println(String.format("%,.3f", y));
		System.out.println(String.format("%,.3f", objValCurrent));
	}
			
	
}
