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
@XmlType(propOrder = { "name", "date", "books" }, name = "library")
public class Library implements Serializable {

    @XmlElementWrapper
    @XmlElement(name="book")
    private List<Book> books = new ArrayList<>();
    private String name;
    @XmlElement(name = "date", required = true)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date;

    public Library() {
    }

    public Library(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(books, library.books) &&
                Objects.equals(name, library.name) &&
                Objects.equals(date, library.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books, name, date);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
