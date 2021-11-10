package grsu.lection.start;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "grsu.lection")
@EntityScan("grsu.lection.model")
@ComponentScan(basePackages = "grsu.lection")
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class);
        ConsoleApp.run(context);
    }
}
