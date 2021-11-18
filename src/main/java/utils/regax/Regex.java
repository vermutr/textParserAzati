package utils.regax;

public class Regex {

    public static final String parseRegexSentence = "(?<=[.!?]\\s*)";
    public static final String parseRegexChapter = "(?=\\nCHAPTER\\s\\d\\r\\n)";
    public static final String parseRegexParagraphs = "\n\r";
    public static final String parseRegexSymbols = "\\b";
    public static final String parseRegexCheckIsSpacer = "\\s";
    public static final String parseRegexCheckIsWord = "\\w+";

}