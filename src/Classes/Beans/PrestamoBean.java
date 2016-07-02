
package Classes.Beans;

import java.util.Date;

public class PrestamoBean implements java.io.Serializable{
    
    private int idPrestamo;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private int Socio_idUsuario;
    private int Ejemplar_idEjemplar;
    
    public PrestamoBean(){}
    
//    Setters for class PrestamoBean

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
//    Getters for class PrestamoBean

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }
}
