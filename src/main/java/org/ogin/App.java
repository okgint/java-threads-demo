package org.ogin;


import org.ogin.downloader.Downloader;
import org.ogin.downloader.IDownloader;
import org.ogin.downloader.LoggerDownloadCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) throws MalformedURLException, ExecutionException, InterruptedException {

        String url = "http://www.detik.com";
        logger.info("URL : " + url);

        IDownloader downloader = new Downloader(new URL(url));
        downloader.download(new LoggerDownloadCallback());
    }
}
