package modelo;
import vista.VistaBanco;
import javax.swing.SwingUtilities;

public class Cliente extends Thread {
    private String nombre;
    private CuentaBancaria cuenta;
    private VistaBanco vista;

    public Cliente(String nombre, CuentaBancaria cuenta, VistaBanco vista) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.vista = vista;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep((int) (Math.random() * 1000)); // Simula tiempo de espera entre transacciones
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            double monto = Math.round(Math.random() * 1000); // para poder obtener un monto aleatorio

            if (Math.random() > 0.5) {
                cuenta.depositar(monto);
                registrarTransaccion("Depósito", monto);
            } else {
                boolean exito = cuenta.retirar(monto);
                registrarTransaccion(exito ? "Retiro" : "Error Retiro", monto);
            }
        }
    }

    private void registrarTransaccion(String tipo, double monto) {
        SwingUtilities.invokeLater(() -> {
            vista.getAreaTransacciones().append(nombre + " - " + tipo + ": $" + monto + "\n");
            vista.getEtiquetaSaldo().setText("Saldo actual: $" + cuenta.getSaldo());
        });
    }
}
