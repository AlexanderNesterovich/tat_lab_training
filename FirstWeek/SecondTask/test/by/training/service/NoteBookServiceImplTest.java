package by.training.service;

import by.training.dao.NoteBookProvider;
import by.training.model.Note;
import by.training.model.NoteBook;
import by.training.service.impl.NoteBookServiceImpl;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.assertEquals;


/**
 * Created by Aliaksandr_Nestsiarovich on 4/26/2016.
 */
public class NoteBookServiceImplTest {

    private NoteBookServiceImpl noteBookService = new NoteBookServiceImpl();

    @BeforeTest
    public void setUp() {
        NoteBook noteBook = new NoteBook();
        noteBook.addNote(new Note("something tested wow", new Date("1900/12/15")));
        noteBook.addNote(new Note("something tested Wow", new Date("1900/12/15")));
        noteBook.addNote(new Note("something Tested wow", new Date("1854/01/01")));
        noteBook.addNote(new Note("something tested wow", new Date("1854/01/02")));
        noteBook.addNote(new Note("Какой-то тестовый текст", new Date(1915, 15, 15)));
        noteBook.addNote(new Note("Some text wow", new Date(1915, 1900, 15)));
        NoteBookProvider.setNew(noteBook);
    }

    @AfterTest
    public void tearDown() {
        NoteBookProvider.getNew();
    }

    @DataProvider(name = "PositiveSearchByContentProvider")
    public Object[][] PositiveContentData() {
        return new Object[][]{
                {"some", 0, 4},
                {"Some", 5, 6},
                {"Какой-то", 4, 5},
                {"текст", 4, 5},
                {"тестовый", 4, 5},
                {"", 0, 6},
                {" ", 0, 6}
        };
    }

    @Test(dataProvider = "PositiveSearchByContentProvider")
    public void PositiveTestSearchByContent(String s, int startIndex, int endIndex) throws Exception {
        List<Note> list = noteBookService.searchByContent(s);
        List<Note> expList = NoteBookProvider.getInstance().getNotes().subList(startIndex, endIndex);
        assertEquals(list, expList);
    }

    @DataProvider(name = "NegativeSearchByContentProvider")
    public Object[][] NegativeContentData() {
        return new Object[][]{
                {"Тестовый"},
                {"somethingelse"},
                {"123123123"},
                {"!"},
                {"@"}
        };
    }

    @Test(dataProvider = "NegativeSearchByContentProvider")
    public void NegativeTestSearchByContent(String s) throws Exception {
        List<Note> list = noteBookService.searchByContent(s);
        assertEquals(list.size(), 0);
    }


    @DataProvider(name = "PositiveTestSearchByDateProvider")
    public Object[][] PositiveDateData() {
        return new Object[][]{
                {"1900-12-15", 0, 2},
                {"1854-01-01", 2, 3},
                {"1854-01-02", 3, 4},
        };
    }

    @Test(dataProvider = "PositiveTestSearchByDateProvider")
    public void PositiveTestSearchByDate(String s, int startIndex, int endIndex) throws Exception {
        List<Note> list = noteBookService.searchByDate(s);
        List<Note> expList = NoteBookProvider.getInstance().getNotes().subList(startIndex, endIndex);
        System.out.println(expList);
        assertEquals(list, expList);
    }

    @DataProvider(name = "NegativeTestSearchByDateProvider")
    public Object[][] NegativeDateData() {
        return new Object[][]{
                {"some"},
                {""},
                {" "},
                {"1923/5/5"},
                {"1234.23.31"},
        };
    }

    @Test(dataProvider = "NegativeTestSearchByDateProvider", expectedExceptions = ParseException.class)
    public void NegativeTestSearchByDate(String s) throws Exception {
        noteBookService.searchByDate(s);
    }

    @DataProvider(name = "addNoteProvider")
    public Object[][] AddData() {
        return new Object[][]{
                {"some", new Date()},
                {"asdasd", new Date()},
                {"какакафваы", new Date()},
        };
    }

    @Test(dataProvider = "addNoteProvider")
    public void testAddNote(String s, Date d) throws Exception {
        Note note = new Note(s, d);
        noteBookService.addNote(s, d);
        assertEquals(note, NoteBookProvider.getInstance().getNotes().get(NoteBookProvider.getInstance().getNotes().size() - 1));
    }

    @Test
    public void testNewNoteBook() throws Exception {
        NoteBook noteBook = new NoteBook();
        assertEquals(noteBook, NoteBookProvider.getNew());
    }

    @Test
    public void testReadWriteFromFile() throws Exception {
        NoteBook noteBook = NoteBookProvider.getInstance();
        noteBookService.writeToFile("test3");
        NoteBookProvider.getNew();
        assertEquals(NoteBookProvider.getInstance(), new NoteBook());
        noteBookService.readFromFile("test3");
        assertEquals(NoteBookProvider.getInstance(), noteBook);
    }

    @Test
    public void testGetCatalog() throws Exception {
        assertEquals(NoteBookProvider.getInstance().getNotes(), noteBookService.getCatalog());
    }

}