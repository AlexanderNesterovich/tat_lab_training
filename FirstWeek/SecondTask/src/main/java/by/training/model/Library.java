package by.training.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class Library implements Serializable {

    private List<Book> bookList = new ArrayList<>();
    private String name;
    private Date date;

    public List<Book> getBookList() {
        return bookList;
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
        bookList.add(book);
    }

    public List<Book> getNotes() {
        return bookList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(bookList, library.bookList) &&
                Objects.equals(name, library.name) &&
                Objects.equals(date, library.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookList, name, date);
    }

    @Override
    public String toString() {
        return "Library{" +
                "bookList=" + bookList +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
