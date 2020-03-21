package Service;

import DAO.UsageDAO;
import Entity.Author;
import Entity.Usage;

import java.util.Collection;

public class UsageService {

    private UsageDAO usageDAO = new UsageDAO(Usage.class);

    public UsageService() {
    }

    public void add(Usage usage) {
        usageDAO.add(usage);
    }

    public boolean update(Usage usage) {
        if (usageDAO.get(usage.getUsage_ID()).isPresent()) {
            usageDAO.update(usage);
            return true;
        } else return false;

    }

    public Usage get(long id) {
        return usageDAO.get(id).get();
    }

    public Collection<Usage> getAll() {
        return usageDAO.getAll();
    }

    public void delete(Usage usage) {
        usageDAO.delete(usage);
    }

    public int getCountOfUsagesOfPeriod(String start, String end) {
        return usageDAO.getCountOfUsagesOfPeriod(start, end);
    }
}
