package org.ogin.thread.walker;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ogin
 */
public class FileProcMain {
    public static final String FILE = "D:\\Git-Imaging\\Java\\Thread-Varia\\TXT-Collection[Buat-Parser]\\jsearch-master\\src\\test\\resources\\it\\java";

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        final List<FileProcessor> todo = new ArrayList<>();
        Path rootDir = Paths.get(FILE);

        Files.walkFileTree(rootDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                String location = path.toString();
                todo.add(new FileProcessor(new File(location)));
                return FileVisitResult.CONTINUE;
            }
        });

        ExecutorService executor = Executors.newFixedThreadPool(8);
        List<Future<FileDetails>> futures = executor.invokeAll(todo);
        for (Future<FileDetails> future : futures) {
            System.out.println(future.get());
        }
        executor.shutdown();
    }
}
