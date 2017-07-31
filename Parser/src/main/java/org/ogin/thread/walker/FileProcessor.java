package org.ogin.thread.walker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

/**
 * @author ogin
 */
public class FileProcessor implements Callable<FileDetails> {
    private File file;

    public FileProcessor(File file) {
        this.file = file;
    }

    @Override
    public FileDetails call() throws Exception {
        String fileName = file.getName();
        Path pat = Paths.get(file.getPath());
        int fileSize = getSizeManually();
        return new FileDetails(fileName, fileSize);
    }

    private int getSizeManually() throws IOException {
        int sum = 0;
        try (FileInputStream fis = new FileInputStream(file)) {
            while (fis.read() != -1) {
                sum++;
            }
        }
        return sum;
    }
}
