package ie.citadel.authentication.config;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ServiceConfig {
  
  //TODO : figure out why value is not being taken from config server/githuv	
  //@Value("${signing.key}")
  //private String jwtSigningKey="";
	private String jwtSigningKey="kqk00";	


  public String getJwtSigningKey() {
    return jwtSigningKey;
  }

}
