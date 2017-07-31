package org.ogin.downloader;

import java.io.IOException;

/**
 * @author ogin
 * Take from : https://github.com/apache/karaf/blob/master/features/core/src/main/java/org/apache/karaf/features/internal/download/DownloadCallback.java
 */
public interface DownloadCallback {
    public void onStart(long totalBytes);

    public void onSuccess(String filePath);

    public void onFailure(Throwable throwable);
}
