package com.github.thomasandre84.service;

import com.github.thomasandre84.apihub.common.rest.FileProviderResourceIf;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.io.*;
import java.util.List;

@Slf4j
@ApplicationScoped
public class FileProviderService {

    private final FileProviderResourceClient resourceClient;

    public FileProviderService(@RestClient FileProviderResourceClient resourceClient) {
        this.resourceClient = resourceClient;
    }

    public List<String> listFiles() {
        var files = resourceClient.listFiles();
        log.info("Files: {}", files);
        return files;
    }

    public File getFile(String fileName) {
        var file = resourceClient.getFile(fileName);
        log.info("File {} received as fileName {}", file, file.getAbsoluteFile().getName());
        return file;
    }

    public InputStream getFileStream(String fileName) {
        var fileStream = resourceClient.getFileStream(fileName);
        log.info("FileStream {}", fileStream);
        return fileStream;
    }
}
