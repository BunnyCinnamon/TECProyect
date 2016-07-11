package Classes.Beans;

public class EjemplarBean implements java.io.Serializable {

    private int idEjemplar;
    private String existencias;
    private String estante;
    private int Libro_idLibro;

    public EjemplarBean() {
    }

//    Setters for class EjemplarBean
    public void setIdEjemplar(int idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public void setExistencias(String existencias) {
        this.existencias = existencias;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

//    Getters for class EjemplarBean
    public int getIdEjemplar() {
        return idEjemplar;
    }

    public String getExistencias() {
        return existencias;
    }

    public String getEstante() {
        return estante;
    }
}
