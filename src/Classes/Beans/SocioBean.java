
package Classes.Beans;

public class SocioBean implements java.io.Serializable{
    
    private int idUsuario;
    private String normbre;
    private String apellidoP;
    private String apellidoM;
    private String estado;
    private String municipio;
    private String calle;
    private int numero;
    private int telefono;
    private String usuario;
    private String contraseña;
    
    public SocioBean(){}
    
//    Setters for class SocioBean

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNormbre(String normbre) {
        this.normbre = normbre;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
//    Getters for clas SocioBean

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNormbre() {
        return normbre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public String getEstado() {
        return estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
}
