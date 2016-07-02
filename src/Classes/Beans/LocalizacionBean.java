
package Classes.Beans;

public class LocalizacionBean implements java.io.Serializable{
    
    private int idLocalización;
    private int pasillo;
    
    public LocalizacionBean(){}
    
//    Setters for class LocalizacionBean

    public void setIdLocalización(int idLocalización) {
        this.idLocalización = idLocalización;
    }

    public void setPasillo(int pasillo) {
        this.pasillo = pasillo;
    }
    
//    Getters for class LocalizacionBean

    public int getIdLocalización() {
        return idLocalización;
    }

    public int getPasillo() {
        return pasillo;
    }
}
