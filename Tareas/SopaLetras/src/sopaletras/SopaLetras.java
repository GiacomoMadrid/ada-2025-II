/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sopaletras;
import Controlador.ControladorPrincipal;
import Modelo.Operador;
import Vista.frmPrincipal;
import java.util.ArrayList;

/**
 *
 * @author Giacomo
 */
public class SopaLetras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creamos la sopa de letras
        char[][] sopa = {
            {'X','1','2','3','4'},
            {'1','E','S','T','O'},
            {'2','S','T','T','M'},
            {'3','E','A','S','A'},
            {'4','P','R','N','E'}
        };
        
        //Creamos la lista de plabras a buscar:
        ArrayList<String> lista = new ArrayList<>();        
        lista.add("ESTO");
        lista.add("ESE");
        lista.add("PATO");
        lista.add("ESTE");
        
        //Main Code
        frmPrincipal vista = new frmPrincipal();
        ControladorPrincipal cont = new ControladorPrincipal(vista, sopa);
        cont.iniciar();
        Operador.llenarLista(lista);
        Operador.mostrarResultado(sopa, vista.txtRespuesta, cont.getEscenario());
        
        
    }
    
}
