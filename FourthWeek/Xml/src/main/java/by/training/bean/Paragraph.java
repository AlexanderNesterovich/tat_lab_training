package by.training.bean;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/11/2016.
 */
@XmlRootElement(name ="paragraph")
@XmlType(propOrder = { "title", "page"})
public class Paragraph implements Serializable {

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paragraph paragraph = (Paragraph) o;
        return page == paragraph.page &&
                Objects.equals(title, paragraph.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, page);
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "title='" + title + '\'' +
                ", page=" + page +
                '}';
    }
}
