package ie.citadel.pupils.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;

import ie.citadel.pupils.config.ServiceConfig;
import ie.citadel.pupils.model.Address;

@Component
public class AddressRestTemplateClient {
	
	@Autowired
    OAuth2RestTemplate restTemplate;
	
	@Autowired
	ServiceConfig config;
	
    private static final Logger logger = LoggerFactory.getLogger(AddressRestTemplateClient.class);

    public Address getAddressFromEircode(String eircode){
    	
    	logger.info("About to call restTemplate exchange method");
    	
        ResponseEntity<Address> restExchange =
                restTemplate.exchange(
                		config.getUrlAddressService(),
                        HttpMethod.GET,
                        null, Address.class, eircode);

        return restExchange.getBody();
    }
}
