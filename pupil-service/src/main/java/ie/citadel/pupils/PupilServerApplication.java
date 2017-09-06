package ie.citadel.pupils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;

@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
@RefreshScope
public class PupilServerApplication implements CommandLineRunner{
	
  @Bean
  public Sampler defaultSampler() {
    return new AlwaysSampler();
  }	

  @Bean
  public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext oauth2ClientContext, OAuth2ProtectedResourceDetails details) {
      return new OAuth2RestTemplate(details, oauth2ClientContext);
  }

  public static void main(String[] args) {
        SpringApplication.run(PupilServerApplication.class, args);
  }
  
  @Override
  public void run(String... args) throws Exception {
      System.out.println("Running PupilServerApplication ...");

  }

}
