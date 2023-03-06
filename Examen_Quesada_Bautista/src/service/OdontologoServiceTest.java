package service;

import bd.BD;
import dao.OdontologoDaoH2;
import model.Odontologo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class OdontologoServiceTest {

        Odontologo odontologo1 = new Odontologo("2324","Pedro","Gonzalez");
        Odontologo odontologo2 = new Odontologo("3463","Lucas","Perez");

        OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

        List<Odontologo> odontologolist = new ArrayList<>();

    @Test
    void guardar() throws Exception{
        BD.crearTablas();
        odontologoService.guardar(odontologo1);
        odontologoService.guardar(odontologo2);
        assertTrue(odontologo1.getNOMBRE().equals("Pedro"));
    }

    @Test
    void buscarTodos() throws Exception{
        BD.getConnection();
        odontologolist.add(odontologo1);
        odontologolist.add(odontologo2);
        odontologoService.buscarTodos();
        assertEquals(2,odontologolist.size());

    }
}