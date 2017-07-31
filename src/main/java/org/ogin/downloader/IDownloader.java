package org.ogin.downloader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Future;

/**
 * @author ogin
 */
public interface IDownloader {
    String downloadContents () throws IOException;

    Future<String> startDownloading();

    void download(DownloadCallback downloadCallback) throws MalformedURLException;
}
