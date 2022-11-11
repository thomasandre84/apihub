package com.github.thomasandre84.apihub.gw.api.resource.v1.filter;

import lombok.extern.slf4j.Slf4j;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;

@Slf4j
@Provider
@Logged
public class LoggerFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
      log.info("Doing request: {}", requestContext.getUriInfo().getAbsolutePath());
    }
}
