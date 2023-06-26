package org.poli.ingsoft.DAOs;

public class DaoFactory {
    public enum DaoType{
        EMPLEADO
    }

    /**
     * Allow to create instance and access to ConexionDB instance
     * @param daoType
     * @return
     */
    public static IDao getDao(DaoType daoType){
        IDao dao = null;
        switch (daoType){
            case EMPLEADO -> dao = new EmpleadoDAO();
        }
        return dao;
    }
}
