
package Classes.Beans;

public class EditorialBean implements java.io.Serializable{
    
    private int idEditorial;
    private String nombre;
    private String estatus;
    
    public EditorialBean(){}
    
//    Setters for class EditorialBean

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
//    Getters for class EditorialBean

    public int getIdEditorial() {
        return idEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstatus() {
        return estatus;
    }
}
