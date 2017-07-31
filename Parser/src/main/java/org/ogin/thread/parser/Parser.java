package org.ogin.thread.parser;

/**
 * @author ogin
 */
public interface Parser<T> {
    boolean hasNextRecord();
    T nextRecord();
    void close();
}
