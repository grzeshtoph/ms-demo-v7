package ie.citadel.address;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
public class AddressServerApplication implements CommandLineRunner{
	
    @Bean
    public Sampler defaultSampler() {
        return new AlwaysSampler();
    }
	
    public static void main(String[] args) {
        SpringApplication.run(AddressServerApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running AddressServerApplication ...");

    }

}
