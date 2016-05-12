package by.training.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class Book implements Serializable {

    private String title;
    private Date publicationDate;
    private Date editionDate;
    private String author;
    private String genre;
    private String isbn;
    private Languages languague;
    private int pageCount;
    private List<Paragraph> paragraphList = new ArrayList<>();

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
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

    public Languages getLanguague() {
        return languague;
    }

    public void setLanguague(Languages languague) {
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

}
