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
            {'E','S','T','O','X'},
            {'S','T','T','M','X'},
            {'E','A','S','A','X'},
            {'P','R','N','E','X'},
            {'X','X','X','X','X'}
        };
        //Creamos la lista de plabras a buscar:
        ArrayList<String> lista = new ArrayList<>();
        
        lista.add("ESTO");
        lista.add("ESE");
        lista.add("PATO");
        lista.add("ESTE");
        
        frmPrincipal vista = new frmPrincipal();
        ControladorPrincipal cont = new ControladorPrincipal(vista, sopa);
        Operador.llenarLista(lista);
        Operador.mostrarResultado(sopa, vista.txtRespuesta);
        
        
    }
    
}
