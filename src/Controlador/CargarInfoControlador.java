
package Controlador;

import Modelo.CargarInfoDAO;
import Vista.VAdministrador;

public class CargarInfoControlador {
    
    public CargarInfoDAO Cargar = new CargarInfoDAO();
    
    /**
     * Cargar Información*
     * @param ea
     */
    
    public void CargarInfo(VAdministrador ea){
        Cargar.LoadAll(ea);
    }
    
    /**
     * Buscar Localizacion*
     */
    
    
    
    /**
     * Buscar Area*
     */
    
    
    
    /**
     * Buscar Autor*
     */
    
    
    
    /**
     * Buscar Editorial*
     */
}
