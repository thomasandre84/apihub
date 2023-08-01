package com.github.thomasandre84.apihub.gw.http.client;

import com.github.thomasandre84.apihub.common.rest.FileProviderResourceIf;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.io.File;
import java.io.InputStream;
import java.util.List;

@Path(FileProviderResourceIf.BASE_URL)
@RegisterRestClient(configKey = "file-provider")
public interface FileProviderResourceClient { // cannot extend the existing interface as ReSTClient
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
