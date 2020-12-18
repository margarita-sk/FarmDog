package main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("farm")
@ComponentScan("animal")
@ComponentScan("employee")
@ComponentScan("area")
@PropertySource("classpath:properties.properties")
public class SpringConfig {

}
