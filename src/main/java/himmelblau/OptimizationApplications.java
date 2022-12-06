package himmelblau;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OptimizationApplications {
	
	public static void main(String[] args) {
		SpringApplication.run(OptimizationApplications.class, args);
	}
	
	
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx,HimmelblauService himmelBlau) {
		return args -> {
			himmelBlau.solveHimmelBlau();
		};
	}
}
