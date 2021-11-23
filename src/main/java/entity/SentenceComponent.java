package entity;

import entity.sentenseSymbol.PartsOfSentence;

import java.util.List;

public class SentenceComponent{

    private List<PartsOfSentence> partsOfSentences;
    private String sentence;

    public SentenceComponent(final String sentence) {
        this.sentence = sentence;
    }

    public List<PartsOfSentence> getPartsOfSentences() {
        return partsOfSentences;
    }

    public void setPartsOfSentences(List<PartsOfSentence> partsOfSentences) {
        this.partsOfSentences = partsOfSentences;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
