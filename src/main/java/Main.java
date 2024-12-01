import vista.VistaBanco;
import controlador.ControladorBanco;

public class Main {
    public static void main(String[] args) {
        // Creamos la vista
        VistaBanco vista = new VistaBanco();

        // Crea el controlador, pasando la vista y el saldo inicial de la cuenta
        new ControladorBanco(vista, 5000.0);

        // creamos  la ventana de la vista
        vista.setVisible(true);

}
}