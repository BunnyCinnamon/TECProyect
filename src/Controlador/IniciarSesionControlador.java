
package Controlador;

import java.util.EventListener;
import Classes.Beans.AdministradorBean;
import Modelo.IniciarSesionDAO;
import Vista.VIniciarSesion;
import Vista.VOpciones;
import Vista.VIniciarSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IniciarSesionControlador implements ActionListener{
    
    public VIniciarSesion is = new VIniciarSesion();
    public VOpciones o = new VOpciones();
    public IniciarSesionDAO isd = new IniciarSesionDAO();

    public IniciarSesionControlador(VIniciarSesion n){
    this.is=n;
    this.is.JIngresar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent n) {
        AdministradorBean adm = new AdministradorBean();
        adm.setUsuario(is.JUsuarioInicio.getText());
        adm.setContraseña(is.JContraseñaInicio.getText());
    if(isd.CheckPassword(adm)){
        is.setVisible(false);
        o.setVisible(true);
        o.setLocationRelativeTo(null);
        }
    }
}
