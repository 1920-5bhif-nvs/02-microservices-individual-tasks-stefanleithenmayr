package at.htl.services.boundary;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cardealer")
public class CarDealerResource {
    @Inject
    @RestClient
    CarDealerRequest carDealerRequest;

    @GET
    @Path("/getCars")
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(name = "requestAmount", description = "Amount of Requests")
    @Timed(name = "responseTimer", description = "Response Time", unit = MetricUnits.MILLISECONDS)
    @Retry(maxRetries = 2)
    @Fallback(fallbackMethod = "noFreeCars")
    public Response getFreeCars() {
        return Response.ok().entity(carDealerRequest.getFreeCars()).build();
    }

    public Response noFreeCars(){
        return Response.ok().entity(Json.createArrayBuilder().build()).build();
    }
}