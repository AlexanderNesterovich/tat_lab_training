package by.training.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class Book implements Serializable {

    private String title;
    private Date publicationDate;
    private Date editionDate;
    private String author;
    private Genre genre;
    private String isbn;
    private Language languague;
    private int pageCount;
    private List<Paragraph> paragraphList = new ArrayList<>();

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

    public Language getLanguague() {
        return languague;
    }

    public void setLanguague(Language languague) {
        this.languague = languague;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<Paragraph> getParagraphList() {
        return paragraphList;
    }

    public void addParagraph(Paragraph p) {
        paragraphList.add(p);
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
                languague == book.languague &&
                Objects.equals(paragraphList, book.paragraphList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, publicationDate, editionDate, author, genre, isbn, languague, pageCount, paragraphList);
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
                ", languague=" + languague +
                ", pageCount=" + pageCount +
                ", paragraphList=" + paragraphList +
                '}';
    }
}
