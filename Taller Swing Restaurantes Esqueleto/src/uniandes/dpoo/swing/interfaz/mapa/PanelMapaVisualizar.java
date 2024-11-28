package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel
{
    // Etiqueta que mostrará el mapa de fondo
    private JLabel labMapa;
    
    // Lista de restaurantes que se deben visualizar en el mapa
    private List<Restaurante> restaurantes;

    // Constructor que inicializa el panel y configura el mapa de fondo
    public PanelMapaVisualizar()
    {
        // Configura el layout del panel con BorderLayout
        setLayout(new BorderLayout());
        
        // Carga la imagen del mapa y la asigna a la etiqueta labMapa
        this.labMapa = new JLabel(new ImageIcon("./imagenes/mapa.png"));
        
        // Establece un borde alrededor del mapa para mejorar la apariencia
        labMapa.setBorder(new LineBorder(Color.DARK_GRAY));
        
        // Agrega la etiqueta con el mapa al centro del panel
        add(labMapa, BorderLayout.CENTER);
    }

    // Método de sobrescritura para pintar el panel, incluyendo el mapa y los restaurantes
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        // Convierte el objeto Graphics a Graphics2D para más opciones de dibujo
        Graphics2D g2d = (Graphics2D) g;
        
        // Dibuja el mapa de fondo en las coordenadas (0, 0) del panel
        g2d.drawImage(new ImageIcon("./imagenes/mapa.png").getImage(), 0, 0, this);

        // Si la lista de restaurantes no es nula, dibuja los restaurantes sobre el mapa
        if (restaurantes != null)
        {
            // Itera sobre la lista de restaurantes
            for (Restaurante r : restaurantes)
            {
                // Obtiene las coordenadas del restaurante (x, y)
                int x = r.getX();
                int y = r.getY();
                
                // Establece el color rojo para marcar la ubicación del restaurante
                g2d.setColor(Color.RED);
                
                // Dibuja un círculo pequeño en el mapa representando al restaurante
                g2d.fillOval(x - 3, y - 3, 7, 7);
                
                // Dibuja el nombre del restaurante cerca de su ubicación
                g2d.drawString(r.getNombre(), x + 5, y);
            }
        }
    }

    // Método que actualiza la lista de restaurantes y vuelve a pintar el mapa
    public void actualizarMapa(List<Restaurante> nuevosRestaurantes)
    {
        // Actualiza la lista de restaurantes
        this.restaurantes = nuevosRestaurantes;
        
        // Llama a repaint() para que se redibuje el mapa con las nuevas ubicaciones
        repaint();
    }
}
