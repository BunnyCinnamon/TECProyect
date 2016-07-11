package Classes.Beans;

public class AreaBean implements java.io.Serializable {

    private int idArea;
    private String seccion;
    private String estatus;

    public AreaBean() {
    }

//    Setters for class AreaBean
    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

//    Getters for class AreaBean
    public int getIdArea() {
        return idArea;
    }

    public String getSeccion() {
        return seccion;
    }

    public String getEstatus() {
        return estatus;
    }
}
