
package Modelo;

import Classes.Beans.AdministradorBean;

public class OpcionesDAO {
    
    public boolean CheckAdmin(AdministradorBean adb) {
            boolean ISADMIN = false;
            if(adb.getidAdministrador() == 0){
     ISADMIN = true;
            }
        return ISADMIN;
    }
}
