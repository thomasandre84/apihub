package com.github.thomasandre84.apihub.common.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.*;
import java.util.List;

//@RegisterRestClient(configKey="fileProvider")
public interface FileProviderResourceIf {
    static final String BASE_URL = "/files";
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<String> listFiles();

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/{fileName}")
    File getFile(@PathParam("fileName") String fileName);

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/stream/{fileName}")
    InputStream getFileStream(@PathParam("fileName") String fileName);
}
