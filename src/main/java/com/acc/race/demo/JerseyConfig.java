package com.acc.race.demo;

import com.acc.race.demo.rest.CarEndpoint;
import com.acc.race.demo.rest.ScoreEndpoint;
import com.acc.race.demo.rest.TestEndpoint;
import com.acc.race.demo.rest.UserEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(TestEndpoint.class);
        register(UserEndpoint.class);
        register(CarEndpoint.class);
        register(ScoreEndpoint.class);
    }
}