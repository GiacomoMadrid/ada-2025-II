package Modelo;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Giacomo
 */
public class Operador {
    //Crear lista de palabras
    private static ArrayList<String> listaPalabras = new ArrayList<>();
    
    public static void llenarLista(ArrayList<String> l){
        for(String palabra: l){
            Operador.listaPalabras.add(palabra);
        }
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
    
    public static void mostrarResultado(char[][] sopa, JTextArea txtResultado, Escenario esc) {
        int R=255;
        int G=255;
        int B=0;
        Color colorResultado = new Color(R,G,B);
        
        for (String palabra : listaPalabras) {
            Point[] resultado = Operador.buscarPalabra(sopa, palabra);
            
            if (resultado != null) {
                int x1 = resultado[0].x;
                int y1 = resultado[0].y;
                int x2 = resultado[1].x;
                int y2 = resultado[1].y;

                txtResultado.append(palabra + ": Inicio: (" + x1 + ", " + y1 + "). ");
                txtResultado.append("Fin: (" + x2 + ", " + y2 + "). \n");

                // Determinar dirección de movimiento
                int dx = Integer.compare(x2, x1); // 1, 0 o -1
                int dy = Integer.compare(y2, y1); // 1, 0 o -1

                int pasos = palabra.length();

                for (int k = 0; k < pasos; k++) {
                    int fila = x1 + dx * k;
                    int col  = y1 + dy * k;

                    JLabel lbl = esc.getCelda(fila, col);
                    lbl.setOpaque(true);  // Necesario para que el fondo se pinte
                    lbl.setBackground(colorResultado);
                }
                R = R-25;
                B = B+20;
                G = G-10;
                colorResultado = new Color(R,G,B);

            } else {
                txtResultado.append("Palabra: " + palabra + " no encontrada\n");
            }
        }
    }
    
    /*
    public static void mostrarResultado(char[][] sopa, JTextArea txtResultado, Escenario esc){
        for(String palabra : listaPalabras){        
            Point[] resultado = Operador.buscarPalabra(sopa, palabra);            
            if (resultado != null) {
                txtResultado.append(palabra +": Inicio: (" + (resultado[0].x) + ", " + (resultado[0].y) + "). ");
                txtResultado.append("Fin: (" + (resultado[1].x) + ", " + (resultado[1].y) + "). \n");
                                
            } else {
                txtResultado.append("Palabra: " + palabra + " no encontrada \n");
            }
        }
    }*/
}
    

