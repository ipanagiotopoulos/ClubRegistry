package gr.hua.ds.club_registry;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@SpringBootApplication( exclude = {
        BatchAutoConfiguration.class,
        JmxAutoConfiguration.class
},
        excludeName = {
                "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration",
        })
public class ClubRegistryApplication {

    public static void main( String[] args ) {
        SpringApplication.run(ClubRegistryApplication.class , args);
    }

    @Configuration
    public class BeanConfig {

        @PersistenceUnit
        EntityManagerFactory emf;

    }

}
