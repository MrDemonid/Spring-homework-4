package mr.demonid.hw4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("mr.demonid.hw4.config")
public class SpringHomework4Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringHomework4Application.class, args);
    }

}
