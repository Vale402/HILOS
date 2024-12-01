package modelo;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Método sincronizado para depósitos
    public synchronized void depositar(double monto) {
        saldo += monto;
        System.out.println("Depósito de: $" + monto + " | Saldo actual: $" + saldo);
    }

    // Método sincronizado para retiros
    public synchronized boolean retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            System.out.println("Retiro de: $" + monto + " | Saldo actual: $" + saldo);
            return true;
        } else {
            System.out.println("Fondos insuficientes para retirar: $" + monto);
            return false;
        }
    }

    public synchronized double getSaldo() {
        return saldo;
    }
}