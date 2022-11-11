package com.github.thomasandre84.apihub.gw.api.resource.v1;

import com.github.thomasandre84.apihub.gw.api.resource.v1.filter.Logged;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path(ConsentResourceIf.BASE_URL)
@Logged
public interface ConsentResourceIf {
    String BASE_URL = "/api/v1/consents";
}
