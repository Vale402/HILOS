package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaBanco;
import modelo.CuentaBancaria;
import modelo.Cliente;

public class ControladorBanco {
    private CuentaBancaria cuenta;
    private VistaBanco vista;

    public ControladorBanco(VistaBanco vista, double saldoInicial) {
        this.vista = vista;
        this.cuenta = new CuentaBancaria(saldoInicial);

        vista.getBotonIniciar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarTransacciones();
            }
        });
    }

    private void iniciarTransacciones() {
        // Aqui crearemos los clientes como hilos
        for (int i = 1; i <= 3; i++) {
            Cliente cliente = new Cliente("Cliente " + i, cuenta, vista);
            cliente.start();
        }
    }
}