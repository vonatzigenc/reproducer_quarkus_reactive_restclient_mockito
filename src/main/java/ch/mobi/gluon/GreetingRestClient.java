package ch.mobi.gluon;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient
public interface GreetingRestClient {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello();
}
