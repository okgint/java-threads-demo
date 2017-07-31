package org.ogin.thread.parser;

import org.ogin.thread.walker.FileDetails;

import java.util.List;

/**
 * @author ogin
 */
public class FileTxtProcessor implements Parser<String> {
    @Override
    public boolean hasNextRecord() {
        return false;
    }

    @Override
    public String nextRecord() {
        return null;
    }

    @Override
    public void close() {

    }
}
