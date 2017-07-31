package org.ogin.thread.parser;

/**
 * @author ogin
 */
public interface Sentence extends TextElement{
    String getContent();
    void setContent(String content);
    void addContent(String content);
}
