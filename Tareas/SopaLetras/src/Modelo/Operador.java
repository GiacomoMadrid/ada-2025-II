package Modelo;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Giacomo
 */
public class Operador {
    //Crear lista de palabras
    private static ArrayList<String> listaPalabras = new ArrayList<>();
    
    public static void llenarLista(){
        Operador.listaPalabras.add("ESTO");
        Operador.listaPalabras.add("ESE");
        Operador.listaPalabras.add("PATO");
        Operador.listaPalabras.add("ESTE");
    }
    
    
    private static final int[][] DIRECCIONES = {
        { 0,  1},  // derecha
        { 1,  0},  // abajo
        { 0, -1},  // izquierda
        {-1,  0},  // arriba
        { 1,  1},  // diagonal ↓→
        { 1, -1},  // diagonal ↓←
        {-1,  1},  // diagonal ↑→
        {-1, -1}   // diagonal ↑←
    };
    
    public static Point[] buscarPalabra(char[][] matriz, String palabra) {
        int filas = matriz.length;
        int cols  = matriz[0].length;
        int L = palabra.length();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                if (matriz[i][j] != palabra.charAt(0)) continue;

                // probamos cada dirección
                for (int[] dir : DIRECCIONES) {
                    int dx = dir[0], dy = dir[1];
                    int k;

                    for (k = 0; k < L; k++) {
                        int nx = i + dx * k;
                        int ny = j + dy * k;
                        if (nx < 0 || ny < 0 || nx >= filas || ny >= cols
                         || matriz[nx][ny] != palabra.charAt(k)) {
                            break;
                        }
                    }

                    if (k == L) {
                        // palabra completa encontrada
                        Point inicio = new Point(i, j);
                        Point fin    = new Point(i + dx * (L-1), j + dy * (L-1));
                        return new Point[]{ inicio, fin };
                    }
                }
            }
        }
        return null;
    }
     
    public static void mostrarResultado(char[][] sopa, JTextArea txtResultado){
        for(String palabra : listaPalabras){        
            Point[] resultado = Operador.buscarPalabra(sopa, palabra);
            if (resultado != null) {
                txtResultado.append("Inicio: (" + (resultado[0].x+1) + ", " + (resultado[0].y+1) + "). ");
                txtResultado.append("Fin: (" + (resultado[1].x+1) + ", " + (resultado[1].y+1) + "). \n");
            } else {
                txtResultado.append("Palabra: " + palabra + " no encontrada \n");
            }
        }
    }
}
    

