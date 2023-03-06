package dao;

import bd.BD;
import model.Odontologo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class OdontologoDaoH2 implements IDao<Odontologo>{

    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Registrando un nuevo: " + odontologo);
        Connection connection = null;
        try {
            connection = BD.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO ODONTOLOGOS (" +
            "NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, odontologo.getNUMERO_MATRICULA());
            ps.setString(2, odontologo.getNOMBRE());
            ps.setString(3, odontologo.getAPELLIDO());
            ps.execute();
            logger.info("Se guardo un " + odontologo);
            ResultSet rs= ps.getGeneratedKeys();
            while(rs.next()){
                odontologo.setID(rs.getInt(1));
            }
        }
        catch (Exception e){
                e.printStackTrace();
        }
        finally {
            try{
                connection.close();
        } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("Buscando a todos los odontologos");
        Connection connection = null;
        List<Odontologo> odontologoList = new ArrayList<>();
       try{
        connection=BD.getConnection();
        PreparedStatement ps= connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
        ResultSet rs= ps.executeQuery();
        while (rs.next()){
            odontologoList.add(new Odontologo(rs.getInt(1),rs.getString(2),
                    rs.getString(3),rs.getString(4)));
            logger.info("Se encontro el siguiente odontologo en la lista de odontologos: " + odontologoList);
        }
    }
        catch (Exception e){
        e.printStackTrace();
    }
        finally {
        try{
            connection.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
       }
        return odontologoList;
    }
}
