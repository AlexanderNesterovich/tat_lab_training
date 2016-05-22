package by.training.bean;

import by.training.dao.local_persistence.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "title", "author", "genre", "publicationDate", "editionDate", "isbn", "language", "pageCount", "paragraphs"}, name ="book")
public class Book implements Serializable {
    private String title;
    @XmlElement(name = "publicationDate", required = true)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date publicationDate;
    @XmlElement(name = "editionDate", required = true)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date editionDate;
    private String author;
    private Genre genre;
    private String isbn;
    private Language language;
    private int pageCount;
    @XmlElementWrapper
    @XmlElement(name="paragraph")
    private List<Paragraph> paragraphs = new ArrayList<>();

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(Date editionDate) {
        this.editionDate = editionDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void addParagraph(Paragraph p) {
        paragraphs.add(p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pageCount == book.pageCount &&
                Objects.equals(title, book.title) &&
                Objects.equals(publicationDate, book.publicationDate) &&
                Objects.equals(editionDate, book.editionDate) &&
                Objects.equals(author, book.author) &&
                genre == book.genre &&
                Objects.equals(isbn, book.isbn) &&
                language == book.language &&
                Objects.equals(paragraphs, book.paragraphs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, publicationDate, editionDate, author, genre, isbn, language, pageCount, paragraphs);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                ", editionDate=" + editionDate +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                ", isbn='" + isbn + '\'' +
                ", language=" + language +
                ", pageCount=" + pageCount +
                ", paragraphs=" + paragraphs +
                '}';
    }
}
