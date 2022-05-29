package dao;

import dao.SamplesDAO;
import dao.UserDAO;
import dao.impl.SamplesDAOImpl;
import dao.impl.UserDAOImpl;

public enum DAOOperator {

    INSTANCE;
    UserDAO userDAO;
    SamplesDAO samplesDAO;

    DAOOperator() {
        userDAO = new UserDAOImpl();
        samplesDAO = new SamplesDAOImpl();
    }

    public DAOOperator getInstance(){
        return INSTANCE;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public SamplesDAO getSamplesDAO() {
        return samplesDAO;
    }

    public void setSamplesDAO(SamplesDAO samplesDAO) {
        this.samplesDAO = samplesDAO;
    }
}
