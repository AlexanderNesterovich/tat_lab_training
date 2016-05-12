package by.training.model;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/11/2016.
 */
public class Paragraph {

    private String title;
    private int page;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "title='" + title + '\'' +
                ", page=" + page +
                '}';
    }

}
