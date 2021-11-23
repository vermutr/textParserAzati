package converter.textParser.impl;

import converter.textParser.Parsable;
import entity.*;
import entity.sentenseSymbol.PartsOfSentence;
import entity.sentenseSymbol.impl.PunctuationComponent;
import entity.sentenseSymbol.impl.SpacerComponent;
import entity.sentenseSymbol.impl.WordComponent;
import utils.regax.Regex;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParserText implements Parsable {


    @Override
    public FullTextComponent doParse(FullTextComponent fullTextComponent) {
        parseFromTextToChapters(fullTextComponent);
        parseFromChapterToParagraphs(fullTextComponent.getChapterComponentList());
        parseFromParagraphsToSentences(fullTextComponent.getChapterComponentList());
        parseFromSentencesToWordAndPunctuation(fullTextComponent.getChapterComponentList());
        return fullTextComponent;

    }

    private void parseFromTextToChapters(FullTextComponent fullTextComponent) {
        List<ChapterComponent> chapterComponents =
                Arrays.stream(fullTextComponent.getFullText().split(Regex.parseRegexChapter))
                .map(ChapterComponent::new)
                .collect(Collectors.toList());
        fullTextComponent.setChapterComponentList(chapterComponents);
    }

    private void parseFromChapterToParagraphs(List<ChapterComponent> chapterComponentList) {
        for(ChapterComponent chapterComponent: chapterComponentList){
            List<ParagraphComponent> paragraphComponents =
                    Arrays.stream(chapterComponent.getChapter().split(Regex.parseRegexParagraphs))
                    .map(ParagraphComponent::new)
                    .collect(Collectors.toList());
            chapterComponent.setParagraphComponentsList(paragraphComponents);
        }
    }

    private void parseFromParagraphsToSentences(List<ChapterComponent> chapterComponentList) {
        for (ChapterComponent chapterComponent: chapterComponentList){
            for(ParagraphComponent paragraphComponent : chapterComponent.getParagraphComponentsList()){
                List<SentenceComponent> sentenceComponents =
                        Arrays.stream(paragraphComponent.getParagraph().split(Regex.parseRegexSentence))
                        .map(SentenceComponent::new)
                        .collect(Collectors.toList());
                paragraphComponent.setSentenceComponentList(sentenceComponents);
            }
        }
    }

    private void parseFromSentencesToWordAndPunctuation(List<ChapterComponent> chapterComponentList) {
        for(ChapterComponent chapterComponent: chapterComponentList){
            for (ParagraphComponent paragraphComponent: chapterComponent.getParagraphComponentsList()){
                for (SentenceComponent sentenceComponent: paragraphComponent.getSentenceComponentList()){
                    List<PartsOfSentence> partsOfSentences =
                            Arrays.stream(sentenceComponent.getSentence().split(Regex.parseRegexSymbols))
                            .map(createWordSpacerPunctuationObject())
                            .collect(Collectors.toList());
                    sentenceComponent.setPartsOfSentences(partsOfSentences);
                }
            }
        }
    }

    private Function<String, PartsOfSentence> createWordSpacerPunctuationObject() {
        return symbol -> {
            if (symbol.matches(Regex.parseRegexCheckIsSpacer)) {
                return new SpacerComponent(symbol);
            } else if (symbol.matches(Regex.parseRegexCheckIsWord)) {
                return new WordComponent(symbol);
            } else {
                return new PunctuationComponent(symbol);
            }
        };

    }

}
