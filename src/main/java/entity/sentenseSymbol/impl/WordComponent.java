package entity.sentenseSymbol.impl;

import entity.sentenseSymbol.PartsOfSentence;

public class WordComponent implements PartsOfSentence {

    private String word;

    public WordComponent(String word){
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
