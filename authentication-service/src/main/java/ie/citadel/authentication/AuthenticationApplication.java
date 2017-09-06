package ie.citadel.authentication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableResourceServer
@EnableAuthorizationServer
public class AuthenticationApplication implements CommandLineRunner{

    //curl citadel:thisissecret@10.0.17.43:8763/auth/oauth/token -d grant_type=password -client_id=citadel  -d scope=webclient -d username=kevin.kelleher -d password=password1
    //curl -H "Authorization: Bearer 24fb9e40-21d4-4e78-b211-92edfa2fc514" http://10.0.17.43:8763/auth/user
	
    @RequestMapping(value = { "/user" }, produces = "application/json")
    public Map<String, Object> user(OAuth2Authentication user) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("user", user.getUserAuthentication().getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
        return userInfo;
    }


    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running AuthenticationApplication ...");

    }


}
