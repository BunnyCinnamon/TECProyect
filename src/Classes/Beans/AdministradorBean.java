
package Classes.Beans;

public class AdministradorBean implements java.io.Serializable{
    
    private int Administrador;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String usuario;
    private String contraseña;
    private int telefono;
    
    public AdministradorBean(){}
    
//    Setters for class AdministradorBean

    public void setAdministrador(int Administrador) {
        this.Administrador = Administrador;
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

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
//    Getters for class AdministadorBean

    public int getAdministrador() {
        return Administrador;
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

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getTelefono() {
        return telefono;
    }
}
