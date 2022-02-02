package cn.lakewater.saws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SawsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SawsApplication.class, args);
    }
}