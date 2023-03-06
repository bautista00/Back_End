package model;

public class Odontologo {

    private Integer ID;
    private String NUMERO_MATRICULA;
    private String NOMBRE;
    private String APELLIDO;

    public Odontologo(Integer ID, String NUMERO_MATRICULA, String NOMBRE, String APELLIDO) {
        this.ID = ID;
        this.NUMERO_MATRICULA = NUMERO_MATRICULA;
        this.NOMBRE = NOMBRE;
        this.APELLIDO = APELLIDO;
    }

    public Odontologo(String NUMERO_MATRICULA, String NOMBRE, String APELLIDO) {
        this.NUMERO_MATRICULA = NUMERO_MATRICULA;
        this.NOMBRE = NOMBRE;
        this.APELLIDO = APELLIDO;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNUMERO_MATRICULA() {
        return NUMERO_MATRICULA;
    }

    public void setNUMERO_MATRICULA(String NUMERO_MATRICULA) {
        this.NUMERO_MATRICULA = NUMERO_MATRICULA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "ID=" + ID +
                ", NUMERO_MATRICULA='" + NUMERO_MATRICULA + '\'' +
                ", NOMBRE='" + NOMBRE + '\'' +
                ", APELLIDO='" + APELLIDO + '\'' +
                '}';
    }
}
