package Service;

import DAO.UserDAO;
import Entity.Author;
import Entity.User;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;

public class UserService {

    private UserDAO userDAO = new UserDAO(User.class);

    public UserService() {
    }

    public void add(User user) {
        userDAO.add(user);
    }

    public boolean update(User user) {
        if (userDAO.get(user.getUser_ID()).isPresent()) {
            userDAO.update(user);
            return true;
        } else return false;

    }

    public User get(long id) {
        return userDAO.get(id).get();
    }

    public Collection<User> getAll() {
        return userDAO.getAll();
    }

    public void delete(User user) {
        userDAO.delete(user);
    }

    public double getUserAverageAge() {
        return userDAO.getUserAverageAge();
    }

    public ArrayList<String> getBooksUsedByUser(int id) {
        return userDAO.getBooksUsedByUser(id);
    }

    public ArrayList<String> getBooksUsingByUser(int id) {
        return userDAO.getBooksUsingByUser(id);
    }

    public Period getPeriodOfLibraryUsing(int id) {
        return userDAO.getPeriodOfLibraryUsing(id);
    }

    public double getUserAverageAgeByBook(String name) {
        return userDAO.getUserAverageAgeByBook(name);
    }

    public double getUserAverageAgeByAuthor(String name, String surname) {
        return userDAO.getUserAverageAgeByAuthor(name, surname);
    }

    public ArrayList<String> getDebtorsInPast(long t) {
        return userDAO.getDebtorsInPast(t);
    }

    public ArrayList<String> getTodayDebtors(long t) {
        return userDAO.getTodayDebtors(t);
    }


}
