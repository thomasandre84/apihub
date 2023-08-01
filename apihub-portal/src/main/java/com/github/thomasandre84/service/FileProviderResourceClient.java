package com.github.thomasandre84.service;

import com.github.thomasandre84.apihub.common.rest.FileProviderResourceIf;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.io.*;
import java.util.List;

@Path(FileProviderResourceIf.BASE_URL)
@RegisterRestClient(configKey = "file-provider")
public interface FileProviderResourceClient {
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
