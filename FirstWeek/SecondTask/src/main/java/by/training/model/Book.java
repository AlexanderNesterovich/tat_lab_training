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
    private int isbn;
    private String languague;
    private int pageCount;
    private List<Paragraph> paragraphList = new ArrayList<>();

    private Book(Builder builder) {
        title = builder.title;
        publicationDate = builder.publicationDate;
        editionDate = builder.editionDate;
        author = builder.author;
        genre = builder.genre;
        isbn = builder.isbn;
        languague = builder.languague;
        pageCount = builder.pageCount;
        paragraphList = builder.paragraphList;
    }

    public String getTitle() {
        return title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public Date getEditionDate() {
        return editionDate;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getLanguague() {
        return languague;
    }

    public int getPageCount() {
        return pageCount;
    }

    public List<Paragraph> getParagraphList() {
        return paragraphList;
    }

    public static final class Builder {
        private String title;
        private Date publicationDate;
        private Date editionDate;
        private String author;
        private String genre;
        private int isbn;
        private String languague;
        private int pageCount;
        private List<Paragraph> paragraphList;

        public Builder() {
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder publicationDate(Date val) {
            publicationDate = val;
            return this;
        }

        public Builder editionDate(Date val) {
            editionDate = val;
            return this;
        }

        public Builder author(String val) {
            author = val;
            return this;
        }

        public Builder genre(String val) {
            genre = val;
            return this;
        }

        public Builder isbn(int val) {
            isbn = val;
            return this;
        }

        public Builder languague(String val) {
            languague = val;
            return this;
        }

        public Builder pageCount(int val) {
            pageCount = val;
            return this;
        }

        public Builder paragraphList(List<Paragraph> val) {
            paragraphList = val;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
