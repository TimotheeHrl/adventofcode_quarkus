package org.acme;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

return "Hello from RESTEasy Reactive";
    }
// basic post request that returns a string
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String post(String joueur1) {
        switch (joueur1) {
            case "A":
                return "Y";
            case "B":
                return "X";
            default:
                return "Z ";
        }
    }

}


