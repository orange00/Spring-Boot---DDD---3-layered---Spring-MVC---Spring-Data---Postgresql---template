package template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/**
 * The @EntityScan annotation indicates the package where the JPA classes (DAL entities) are.
 */
@EntityScan(basePackages = { "template.persistence.dal.entities" })
/**
 * @EnableJpaRepositories annotation indicates the package where the repository classes are.
 */
@EnableJpaRepositories(basePackages = { "template.persistence.dal" })
public class CalixApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalixApplication.class, args);
	}
}
