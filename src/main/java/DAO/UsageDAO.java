package DAO;

import Entity.Usage;

import java.time.LocalDate;

public class UsageDAO extends ElementDAOImp<Usage> {
    public UsageDAO(Class<Usage> elementClass) {
        super(elementClass);
    }

    public UsageDAO(){}


}
