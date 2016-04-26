package by.training.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class Note implements Serializable{

    private String note;
    private Date date;

    public Note(String note) {
        this.note = note;
        this.date = new Date();
    }

    public Note(String note, Date date) {
        this.note = note;
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note1 = (Note) o;
        return Objects.equals(note, note1.note) &&
                Objects.equals(date, note1.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(note, date);
    }

    @Override
    public String toString() {
        return "Note{" +
                "note='" + note + '\'' +
                ", date=" + date +
                '}';
    }
}
