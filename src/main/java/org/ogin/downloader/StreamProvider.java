package org.ogin.downloader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ogin
 * Ini Mah Resource !!
 */
public interface StreamProvider {
    String getUrl();
    File getFile() throws IOException;
    InputStream open() throws IOException;
}
