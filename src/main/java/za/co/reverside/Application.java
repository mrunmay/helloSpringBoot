package za.co.reverside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;

@Controller
@ComponentScan
@EnableJpaRepositories
@EnableAutoConfiguration
public class Application
{
  public static void main(String[] args)
  {
    SpringApplication.run(Application.class, args);
  }
}
