package org.ogin.downloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ogin
 */
public class LoggerDownloadCallback implements DownloadCallback {
    private Logger logger = LoggerFactory.getLogger(LoggerDownloadCallback.class);

    @Override
    public void onStart(long totalBytes) {
        logger.info("On Start : " + totalBytes);
    }

    @Override
    public void onSuccess(String filePath) {
        logger.info("Path : " + filePath);
    }

    @Override
    public void onFailure(Throwable throwable) {
        logger.info("Failure : " + throwable.getMessage());
    }
}
