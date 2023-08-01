package com.github.thomasandre84.apihub.gw.api.resource.v1;

import com.github.thomasandre84.apihub.common.rest.FileProviderResourceIf;
import com.github.thomasandre84.apihub.gw.core.service.FileProviderService;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.InputStream;
import java.util.List;

@Slf4j
@Path(FileProviderResourceIf.BASE_URL)
@RequiredArgsConstructor
public class FileProviderResource implements FileProviderResourceIf {

    private final FileProviderService fileProviderService;
    @Override
    public List<String> listFiles() {
        return fileProviderService.listFiles();
    }

    @Override
    public File getFile(String fileName) {
        return fileProviderService.getFile(fileName);
    }

    @Override
    public InputStream getFileStream(String fileName) {
        return fileProviderService.getFileStream(fileName);
    }
}
