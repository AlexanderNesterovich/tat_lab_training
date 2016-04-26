package by.training.service;

import by.training.model.Note;
import by.training.model.NoteBook;
import org.junit.Before;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/26/2016.
 */
public class NoteBookServiceTest {

    private NoteBook noteBook;
    private NoteBookService noteBookService = new NoteBookService();

    @BeforeClass
    public void setUp() {
        noteBook.addNote(new Note("Какой-то тестовый текст", new Date(1915,15,15)));
        noteBook.addNote(new Note("Some text wow", new Date(1915,1900,15)));
        noteBook.addNote(new Note("something tested wow", new Date(1900,15,15)));
        noteBook.addNote(new Note("something tested wow", new Date(1923,10,15)));
        noteBook.addNote(new Note("something tested wow", new Date(1923,10,15)));
        noteBook.addNote(new Note("something tested wow", new Date(1923,10,15)));

    }

    @DataProvider(name = "PositiveSearchByContentProvider")
    public  Object[][] PositiveData() {
        return new Object[][] {
                {"ok"},
                {"ok"},
                {"ok"},
                {"ok"},
                {"ok"}
        };
    }

    @Test(dataProvider = "PositiveSearchByContentProvider")
    public void PositiveTestSearchByContent(String s) throws Exception {

    }

    @DataProvider(name = "NegativeSearchByContentProvider")
    public  Object[][] NegativeData() {
        return new Object[][] {
                {"ok"},
                {"ok"},
                {"ok"},
                {"ok"},
                {"ok"}
        };
    }

    @Test(dataProvider = "NegativeSearchByContentProvider")
    public void NegativeTestSearchByContent(String s) throws Exception {

    }

    @Test
    public void testSearchByDate() throws Exception {

    }

    @Test
    public void testAddNote() throws Exception {

    }

    @Test
    public void testNewNoteBook() throws Exception {

    }

    @Test
    public void testReadFromFile() throws Exception {

    }

    @Test
    public void testWriteToFile() throws Exception {

    }

    @Test
    public void testGetCatalog() throws Exception {

    }

}