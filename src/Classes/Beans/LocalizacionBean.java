package Classes.Beans;

public class LocalizacionBean implements java.io.Serializable {

    private int idLocalización;
    private String pasillo;
    private String Estatus;

    public LocalizacionBean() {
    }

//    Setters for class LocalizacionBean
    public void setIdLocalización(int idLocalización) {
        this.idLocalización = idLocalización;
    }

    public void setPasillo(String pasillo) {
        this.pasillo = pasillo;
    }
    
    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
    }

//    Getters for class LocalizacionBean
    public int getIdLocalización() {
        return idLocalización;
    }

    public String getPasillo() {
        return pasillo;
    }
    
    public String getEstatus() {
        return Estatus;
    }
}
