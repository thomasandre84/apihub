package com.github.thomasandre84.apihub.gw.core.service;

import com.github.thomasandre84.apihub.gw.core.outgoing.HttpClientFileProviderIf;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.InputStream;
import java.util.List;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class FileProviderService {

    private final HttpClientFileProviderIf httpClientFileProviderIf;

    public List<String> listFiles() {
        var files = httpClientFileProviderIf.listFiles();
        log.info("FileList in Server: {}", files);
        return files;
    }

    public File getFile(String fileName) {
        return httpClientFileProviderIf.getFile(fileName);
    }

    public InputStream getFileStream(String fileName) {
        return httpClientFileProviderIf.getFileStream(fileName);
    }
}
