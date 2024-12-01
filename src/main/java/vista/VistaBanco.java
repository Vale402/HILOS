package vista;
import javax.swing.*;
import java.awt.*;

public class VistaBanco extends JFrame {
    private JTextArea areaTransacciones;
    private JButton botonIniciar;
    private JLabel etiquetaSaldo;

    public VistaBanco() {
        setTitle("Simulador de Cajero Bancario");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Área para mostrar las transacciones
        areaTransacciones = new JTextArea();
        areaTransacciones.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTransacciones);
        add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con saldo y botón
        JPanel panelInferior = new JPanel(new BorderLayout());
        etiquetaSaldo = new JLabel("Saldo actual: $0.0");
        panelInferior.add(etiquetaSaldo, BorderLayout.WEST);

        botonIniciar = new JButton("Iniciar Transacciones");
        panelInferior.add(botonIniciar, BorderLayout.EAST);

        add(panelInferior, BorderLayout.SOUTH);
    }

    public JTextArea getAreaTransacciones() {
        return areaTransacciones;
    }

    public JButton getBotonIniciar() {
        return botonIniciar;
    }

    public JLabel getEtiquetaSaldo() {
        return etiquetaSaldo;
    }
}
