package Classes.Beans;

public class PenalizacionBean implements java.io.Serializable {

    private int idPenalizacion;
    private String descripcion;
    private float costo;
    private int Prestamo_idPrestamo;

    public PenalizacionBean() {
    }

//    Setters for class PenalizacionBean
    public void setIdPenalizacion(int idPenalizacion) {
        this.idPenalizacion = idPenalizacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

//    Getters for class PenalizacionBean
    public int getIdPenalizacion() {
        return idPenalizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getCosto() {
        return costo;
    }
}
