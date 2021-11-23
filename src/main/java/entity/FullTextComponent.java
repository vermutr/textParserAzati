package entity;


import java.util.List;

public class FullTextComponent {

    private List<ChapterComponent> chapterComponentList;
    private String fullText;

    public FullTextComponent(String fullText) {
        this.fullText = fullText;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public List<ChapterComponent> getChapterComponentList() {
        return chapterComponentList;
    }

    public void setChapterComponentList(List<ChapterComponent> chapterComponentList) {
        this.chapterComponentList = chapterComponentList;
    }
}
