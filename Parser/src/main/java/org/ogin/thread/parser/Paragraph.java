package org.ogin.thread.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ogin
 */
public class Paragraph {
    private List<Sentence> sentences = new ArrayList<Sentence>();

    public void addSentence(Sentence sentence) {
        this.sentences.add(sentence);
    }

    public void addSentence(String title) {
//        Sentence
    }
}
