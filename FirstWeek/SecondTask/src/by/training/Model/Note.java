package by.training.Model;

import java.util.Date;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class Note {

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

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note1 = (Note) o;

        if (note != null ? !note.equals(note1.note) : note1.note != null) return false;
        return date != null ? date.equals(note1.date) : note1.date == null;

    }

    @Override
    public int hashCode() {
        int result = note != null ? note.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override

    public String toString() {
        return "Note{" +
                "note='" + note + '\'' +
                ", date=" + date +
                '}';
    }
}
