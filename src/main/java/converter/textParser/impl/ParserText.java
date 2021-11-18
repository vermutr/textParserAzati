package converter.textParser.impl;

import converter.textParser.Parsable;
import entity.TextComponent;
import entity.impl.ChapterComponent;
import entity.impl.ParagraphComponent;
import entity.impl.SentenceComponent;
import entity.impl.sentenseSymbol.PunctuationComponent;
import entity.impl.sentenseSymbol.SpacerComponent;
import entity.impl.sentenseSymbol.WordComponent;
import utils.regax.Regex;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserText implements Parsable<TextComponent> {

    @Override
    public List<TextComponent> doParse(String text) {

        List<ChapterComponent> chapterComponents = parseFromTextToChapters(text);
        List<ParagraphComponent> paragraphComponents = parseFromChapterToParagraphs(chapterComponents);
        List<SentenceComponent> sentenceComponents = parseFromParagraphsToSentences(paragraphComponents);
        List<SentenceComponent> sentenceComponentsExtended = parseFromSentencesToWordAndPunctuation(sentenceComponents);

        return Stream.of(chapterComponents,
                        paragraphComponents,
                        sentenceComponents,
                        sentenceComponentsExtended)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<ChapterComponent> parseFromTextToChapters(String text) {
        return Arrays.stream(text.split(Regex.parseRegexChapter))
                .map(ChapterComponent::new)
                .collect(Collectors.toList());

    }

    private List<ParagraphComponent> parseFromChapterToParagraphs(List<ChapterComponent> chapters) {
        return chapters.stream()
                .map(text -> text.getTextComponent().split(Regex.parseRegexParagraphs))
                .flatMap(Arrays::stream)
                .map(ParagraphComponent::new)
                .collect(Collectors.toList());
    }

    private List<SentenceComponent> parseFromParagraphsToSentences(List<ParagraphComponent> paragraphs) {
        return paragraphs.stream()
                .map(text -> text.getTextComponent().split(Regex.parseRegexSentence))
                .flatMap(Arrays::stream)
                .map(SentenceComponent::new)
                .collect(Collectors.toList());
    }

    private List<SentenceComponent> parseFromSentencesToWordAndPunctuation(List<SentenceComponent> sentenceComponents) {
        return sentenceComponents.stream()
                .map(text -> text.getTextComponent().split(Regex.parseRegexSymbols))
                .flatMap(Arrays::stream)
                .map(createWordSpacerPunctuationObject())
                .collect(Collectors.toList());
    }

    private Function<String, SentenceComponent> createWordSpacerPunctuationObject() {
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
