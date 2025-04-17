package Controlador;
import Modelo.Escenario;
import Vista.frmPrincipal;
import java.awt.BorderLayout;
/**
 *
 * @author Giacomo
 */
public class ControladorPrincipal {
    protected frmPrincipal vista;
    private char[][] sopa;
    private Escenario escenario;
    
    //*********************** Constructor **************************************
    public ControladorPrincipal(frmPrincipal v, char[][] sopa){
        this.vista = v;
        this.sopa = sopa;
        this.escenario = new Escenario(sopa);
                
        this.vista.panEscenario.setLayout(new BorderLayout());
        this.vista.panEscenario.add(escenario, BorderLayout.CENTER);
        
        
    }
    
    //************************* Métodos ****************************************
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        limpiarComponentes();
    }
    
    public void limpiarComponentes(){
        this.vista.txtRespuesta.setText("");
    }
    
}
