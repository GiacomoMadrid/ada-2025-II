package Controlador;
import Vista.frmPrincipal;
/**
 *
 * @author Giacomo
 */
public class ControladorPrincipal {
    protected frmPrincipal vista;
    
    //*********************** Constructor **************************************
    public ControladorPrincipal(frmPrincipal v){
        this.vista = v;
        
        
        
        
    }
    
    //************************* Métodos ****************************************
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
    
}
