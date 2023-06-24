package org.poli.ingsoft.DAOs;

public class DaoFactory {
    public enum DaoType{
        EMPLEADO
    }

    public static IDao getDao(DaoType daoType){
        IDao dao = null;
        switch (daoType){
            case EMPLEADO -> dao = new EmpleadoDAO();
        }
        return dao;
    }
}
