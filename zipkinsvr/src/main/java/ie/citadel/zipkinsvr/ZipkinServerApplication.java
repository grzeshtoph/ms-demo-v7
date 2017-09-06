package ie.citadel.zipkinsvr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerApplication implements CommandLineRunner{
	
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running ZipkinServerApplication ...");

    }
}