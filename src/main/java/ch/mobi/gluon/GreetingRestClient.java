package ch.mobi.gluon;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped //default with reactive, but not with classic
@RegisterRestClient
public interface GreetingRestClient {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello();
}
