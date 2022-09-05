package kafkatest.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
        return args -> {
            for(int i =0; i<1000; i++){
                kafkaTemplate.send("test", "Now:" + new Date());
                Thread.sleep(2000);
            }
//            kafkaTemplate.send("test", "Hello FSS, sunshine");
        };
    }
}
