package uniandes.dpoo.swing.interfaz.principal;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelLista extends JPanel implements ListSelectionListener
{
    private JList<Restaurante> listaDeRestaurantes;
    private DefaultListModel<Restaurante> dataModel;
    private VentanaPrincipal ventanaPrincipal;

    public PanelLista(VentanaPrincipal ventanaPrincipal)
    {
        this.ventanaPrincipal = ventanaPrincipal;
        setBorder(new TitledBorder("Restaurantes"));
        setLayout(new BorderLayout());

        dataModel = new DefaultListModel<>();
        listaDeRestaurantes = new JList<>(dataModel);
        listaDeRestaurantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaDeRestaurantes.addListSelectionListener(this);

        JScrollPane scroll = new JScrollPane(listaDeRestaurantes);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scroll);
    }

    public void actualizarRestaurantes(List<Restaurante> restaurantes)
    {
        List<Restaurante> nuevosRestaurantes = new ArrayList<>();
        for (Restaurante r : restaurantes)
        {
            if (!dataModel.contains(r))
                nuevosRestaurantes.add(r);
        }
        dataModel.addAll(nuevosRestaurantes);
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        Restaurante seleccionado = listaDeRestaurantes.getSelectedValue();
        ventanaPrincipal.cambiarRestauranteSeleccionado(seleccionado);
    }

    public void seleccionarRestaurante(Restaurante restaurante)
    {
        listaDeRestaurantes.setSelectedValue(restaurante, true);
    }
}
