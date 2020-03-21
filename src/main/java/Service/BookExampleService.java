package Service;

import DAO.BookExampleDAO;
import Entity.Author;
import Entity.BookExample;

import java.util.Collection;
import java.util.List;

public class BookExampleService {

    private BookExampleDAO bookExampleDAO = new BookExampleDAO(BookExample.class);

    public BookExampleService(){}

    public void add(BookExample bookExample){
        bookExampleDAO.add(bookExample);
    }

    public boolean update(BookExample bookExample){
        if(bookExampleDAO.get(bookExample.getBookExample_ID()).isPresent()){
            bookExampleDAO.update(bookExample);
            return true;
        }
        else return false;

    }

    public BookExample get(long id){
        return bookExampleDAO.get(id).get();
    }

    public Collection<BookExample> getAll(){
        return bookExampleDAO.getAll();
    }

    public void delete(BookExample bookExample){
        bookExampleDAO.delete(bookExample);
    }

    public Long getBookExamplesCountDuringIndependence(){
        return bookExampleDAO.getBookExamplesCountDuringIndependence();
    }

    public List<Long> getBookExampleInfoByBookName(String name){
        return bookExampleDAO.getBookExampleInfoByBookName(name);
    }







}
