package com.github.thomasandre84.apihub.gw.http.client;

import com.github.thomasandre84.apihub.gw.core.outgoing.HttpClientFileProviderIf;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.io.File;
import java.io.InputStream;
import java.util.List;

@Slf4j
@ApplicationScoped
public class HttpClientFileProvider implements HttpClientFileProviderIf {

    private final FileProviderResourceClient clientFileProvider;

    public HttpClientFileProvider(@RestClient FileProviderResourceClient clientFileProvider) {
        this.clientFileProvider = clientFileProvider;
    }

    @Override
    public List<String> listFiles() {
        var files = clientFileProvider.listFiles();
        log.info("Listing Files: {}", files);
        return files;
    }

    @Override
    public File getFile(String fileName) {
        return clientFileProvider.getFile(fileName);
    }

    @Override
    public InputStream getFileStream(String fileName) {
        return clientFileProvider.getFileStream(fileName);
    }
}
