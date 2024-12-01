package org.example;
import vista.VistaBanco;
import controlador.ControladorBanco;

public class Main {
    public static void main(String[] args) {
        VistaBanco vista = new VistaBanco();
        new ControladorBanco(vista, 5000.0);
        vista.setVisible(true)
    }
}