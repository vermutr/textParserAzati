package entity;


import java.util.List;

public class ChapterComponent {

    private List<ParagraphComponent> paragraphComponentsList;
    private String chapter;

    public ChapterComponent(final String chapter) {
        this.chapter = chapter;
    }

    public List<ParagraphComponent> getParagraphComponentsList() {
        return paragraphComponentsList;
    }

    public void setParagraphComponentsList(List<ParagraphComponent> paragraphComponentsList) {
        this.paragraphComponentsList = paragraphComponentsList;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
}
