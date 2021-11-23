package entity.sentenseSymbol.impl;

import entity.sentenseSymbol.PartsOfSentence;

public class PunctuationComponent implements PartsOfSentence{

    private String punctuation;

    public PunctuationComponent(String punctuation){
        this.punctuation = punctuation;
    }

    public String getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(String punctuation) {
        this.punctuation = punctuation;
    }
}
