package org.ogin.downloader;

import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ogin
 */
public class Downloader implements IDownloader {
    private final ExecutorService pool = Executors.newFixedThreadPool(10);
    private final URL url;

    public Downloader(URL url) {
        this.url = url;
    }

    @Override
    public String downloadContents() throws IOException {
        try (InputStream inputStream = url.openStream()) {
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public Future<String> startDownloading() {
        return pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try (InputStream input = url.openStream()) {
                    return IOUtils.toString(input, StandardCharsets.UTF_8);
                }
            }
        });
    }

    @Override
    public void download(final DownloadCallback downloadCallback) throws MalformedURLException {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(pool);

        ListenableFuture<String> listenableFuture = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try (InputStream input = url.openStream()) {
                    return IOUtils.toString(input, StandardCharsets.UTF_8);
                }
            }
        });

        final ListenableFuture<File> fileFuture = Futures.transform(listenableFuture, new Function<String, File>() {
            @Override
            public File apply(String input) {
                File tempFile = null;
                try {
                    tempFile = File.createTempFile("tmp", ".temp");
                    tempFile.deleteOnExit();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return tempFile;
            }
        });
        Futures.addCallback(fileFuture, new FutureCallback<File>() {
            @Override
            public void onSuccess(File result) {
                downloadCallback.onSuccess(result.getPath());
            }

            @Override
            public void onFailure(Throwable t) {
                downloadCallback.onFailure(t);
            }
        });
        pool.shutdown();
    }
}
