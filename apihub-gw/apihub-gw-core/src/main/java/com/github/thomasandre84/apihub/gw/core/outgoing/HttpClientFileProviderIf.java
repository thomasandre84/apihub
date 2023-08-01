package com.github.thomasandre84.apihub.gw.core.outgoing;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public interface HttpClientFileProviderIf {

    List<String> listFiles();

    File getFile(String fileName);

    InputStream getFileStream(String fileName);
}
