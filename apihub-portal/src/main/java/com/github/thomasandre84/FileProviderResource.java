package com.github.thomasandre84;

import com.github.thomasandre84.apihub.common.rest.FileProviderResourceIf;
import com.github.thomasandre84.service.FileProviderResourceClient;
import com.github.thomasandre84.service.FileProviderService;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.io.*;
import java.util.List;

@RequiredArgsConstructor
@Path(FileProviderResourceIf.BASE_URL)
public class FileProviderResource implements FileProviderResourceIf {

    private final FileProviderService service;
    @Override
    public List<String> listFiles() {
        return service.listFiles();
    }

    @Override
    public File getFile(String fileName) {
        return service.getFile(fileName);
    }

    @Override
    public InputStream getFileStream(String fileName) {
        return service.getFileStream(fileName);
    }
}
