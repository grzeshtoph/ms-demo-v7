package ie.citadel.pupils.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig{

  @Value("${service.address.url}")
  private String urlAddressService="";


  public String getUrlAddressService(){
    return urlAddressService;
  }


}
