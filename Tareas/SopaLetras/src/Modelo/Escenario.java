package Modelo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
/**
 *
 * @author Giacomo
 */
public class Escenario extends JPanel{
    private int n;
    private char[][] letras;
    private JPanel grid;
    private JPanel margenIzquierdo;
    private JPanel margenDerecho;
    
    public Escenario(char[][] letras) {
        this.letras = letras;
        this.n = letras.length;

        setLayout(new BorderLayout());
        margenIzquierdo  = new JPanel();
        margenDerecho = new JPanel();

        // Panel central con la cuadrícula n x n
        grid = new JPanel(new GridLayout(n, n, 1, 1));
        grid.setBackground(Color.BLACK);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                JLabel lbl = new JLabel(String.valueOf(letras[i][j]), SwingConstants.CENTER);
                lbl.setOpaque(true);
                lbl.setBackground(Color.WHITE);
                lbl.setBorder(new LineBorder(Color.BLACK));
                grid.add(lbl);
            }
        }

        add(margenIzquierdo,  BorderLayout.WEST);
        add(grid,  BorderLayout.CENTER);
        add(margenDerecho, BorderLayout.EAST);

        // Cuando cambie de tamaño, reajustamos para que gridPanel quede cuadrado y centrado
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeComponents();
            }
        });
    }

    private void resizeComponents() {
        int W = getWidth();
        int H = getHeight();
        // Queremos que el panel de letras sea un cuadrado de lado = min(W, H)
        int gridSize = Math.min(W, H);
        int sideWidth = (W - gridSize) / 2;

        margenIzquierdo.setPreferredSize(new Dimension(sideWidth, H));
        margenDerecho.setPreferredSize(new Dimension(sideWidth, H));
        grid.setPreferredSize(new Dimension(gridSize, gridSize));

        revalidate();
        repaint();
    }
    
    
}
