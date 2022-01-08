package persistencia.T2.UI;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import persistencia.T2.Controller.CRUD;

@EntityScan("persistencia.T2.entity")
@EnableJpaRepositories("persistencia.T2.DAO")
@ComponentScan("persistencia.T2")
@SpringBootApplication
public class Main {
    public static void main(String[] args){
        SpringApplicationBuilder builder = new SpringApplicationBuilder(CRUD.class);
        builder.headless(false).run(args);
    }
}
