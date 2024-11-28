package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    private JTextField txtNombre;
    private JComboBox<String> cbbCalificacion;
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante()
    {
        JLabel lblNombre = new JLabel("Nombre del Restaurante:");
        txtNombre = new JTextField(20);
        
        JLabel lblCalificacion = new JLabel("Calificación:");
        String[] calificaciones = {"1", "2", "3", "4", "5"};
        cbbCalificacion = new JComboBox<>(calificaciones);
        
        JLabel lblVisitado = new JLabel("Visitado:");
        String[] opcionesVisitado = {"Sí", "No"};
        cbbVisitado = new JComboBox<>(opcionesVisitado);
        
        setLayout(new GridLayout(3, 2));
        add(lblNombre);
        add(txtNombre);
        add(lblCalificacion);
        add(cbbCalificacion);
        add(lblVisitado);
        add(cbbVisitado);
    }

    public boolean getVisitado()
    {
        return cbbVisitado.getSelectedItem().equals("Sí");
    }

    public int getCalificacion()
    {
        String calif = (String) cbbCalificacion.getSelectedItem();
        return Integer.parseInt(calif);
    }

    public String getNombre()
    {
        return txtNombre.getText();
    }
}
