
package Classes.Beans;

public class AutorBean implements java.io.Serializable{
    
    private int idAutor;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int status;
    
    public AutorBean(){}

//    Setters for class autor
    
    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public void setStatus(int status) {
        this.status = status;
    }

//    Getters for class autor

    public int getIdAutor() {
        return idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public int getStatus() {
        return status;
    }
}
