package Service;

import DAO.AuthorDAO;
import Entity.Author;
import Entity.Book;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class AuthorService {

    private AuthorDAO authorDAO = new AuthorDAO(Author.class);

    public AuthorService() {
    }

    public void add(Author author) {
        authorDAO.add(author);
    }

    public boolean update(Author author) {
        if (authorDAO.get(author.getAuthor_ID()).isPresent()) {
            authorDAO.update(author);
            return true;
        } else return false;

    }

    public Author get(long id) {
        return authorDAO.get(id).get();
    }

    public Collection<Author> getAll() {
        return authorDAO.getAll();
    }

    public void delete(Author author) {
        authorDAO.delete(author);
    }

    public List<String> getBooksOfAuthor(String name, String surname) {
        return authorDAO.getBooksOfAuthor(name, surname);
    }

    public Set<Book> getBooksOfCoauthor(String name, String surname) {
        return authorDAO.getBooksOfCoauthor(name, surname);
    }


}
