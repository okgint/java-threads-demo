package org.ogin.thread.parser.paragraphV1;

/**
 * @author ogin
 */
public interface Sentence extends TextElement{
    String getContent();
    void setContent(String content);
    void addContent(String content);
}
