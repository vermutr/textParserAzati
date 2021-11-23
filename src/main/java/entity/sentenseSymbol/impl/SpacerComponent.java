package entity.sentenseSymbol.impl;

import entity.sentenseSymbol.PartsOfSentence;

public class SpacerComponent implements PartsOfSentence {

    private String spacer;

    public SpacerComponent(String spacer){
        this.spacer = spacer;
    }

    public String getSpacer() {
        return spacer;
    }

    public void setSpacer(String spacer) {
        this.spacer = spacer;
    }
}
