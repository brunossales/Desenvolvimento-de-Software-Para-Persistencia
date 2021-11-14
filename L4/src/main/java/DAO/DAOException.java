package DAO;

public class DAOException extends  RuntimeException{
    public DAOException(){ super();}
    public DAOException(String e){super(e);}
    public DAOException(String e, Throwable z){super(e, z);}
    public DAOException(Throwable z){super(z);}
}
