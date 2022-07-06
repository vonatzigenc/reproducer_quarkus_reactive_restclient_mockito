package ch.mobi.gluon;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("indirect")
public class IndirectGreetingResource {

    @RestClient
    GreetingRestClient greetingRestClient;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("hello")
    public String hello() {
        return greetingRestClient.hello() + " (Indirect)";
    }
}
