package ie.citadel.zuulsvr;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;


@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulServerApplication implements CommandLineRunner{
	
    @Bean
    public Sampler defaultSampler() {
        return new AlwaysSampler();
    }

	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){
	      return new RestTemplate();
	}


    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running ZuulServerApplication ...");

    }
}

