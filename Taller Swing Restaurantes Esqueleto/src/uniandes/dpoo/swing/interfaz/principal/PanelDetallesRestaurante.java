package uniandes.dpoo.swing.interfaz.principal;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelDetallesRestaurante extends JPanel
{
    private JLabel labNombre;
    private JLabel labCalificacion;
    private JCheckBox chkVisitado;
    

    public PanelDetallesRestaurante()
    {
        setLayout(new GridLayout(3, 1));
        setVisible(true);

        // Configura la etiqueta para el nombre
        labNombre = new JLabel();
        add(labNombre);

        // Configura la etiqueta para la calificación
        labCalificacion = new JLabel();
        add(labCalificacion);

        // Configura el checkbox para indicar si ya se visitó o no el restaurante
        chkVisitado = new JCheckBox();
        add(chkVisitado);
    }

    private void actualizarRestaurante(String nombre, int calificacion, boolean visitado)
    {
        labNombre.setText("  Nombre:   " + nombre);
        labCalificacion.setIcon(buscarIconoCalificacion(calificacion));
        chkVisitado.setText("visitado");
        chkVisitado.setSelected(visitado);
    }

    public void actualizarRestaurante(Restaurante r)
    {
        actualizarRestaurante(r.getNombre(), r.getCalificacion(), r.isVisitado());
    }

    private ImageIcon buscarIconoCalificacion(int calificacion)
    {
        String imagen = "./imagenes/stars" + calificacion + ".png";
        return new ImageIcon(imagen);
    }
}
