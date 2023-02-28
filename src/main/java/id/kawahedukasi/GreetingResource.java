package id.kawahedukasi;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "Hello Word GET";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String post() {
        return "Hello Word POST";
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String put() {
        return "Hello Word PUT";
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String delete() {
        return "Hello Word DELETE";
    }
}