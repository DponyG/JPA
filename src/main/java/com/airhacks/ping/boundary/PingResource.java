package com.airhacks.ping.boundary;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
public class PingResource {

    @Inject
    String message;    

    @GET
    public String ping() {
        return this.message + " Jakarta EE with MicroProfile 2+!";
    }

}
