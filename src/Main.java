import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String entrada = JOptionPane.showInputDialog(
                "Escriba 1 para dibujar rectángulos\n" +
                        "Escriba 2 para dibujar óvalos\n" +
                        "Escriba 3 para otro dibujo\n" +
                        "Escriba 4 para dibujar el nombre");

        int opcion = Integer.parseInt(entrada);
        Figuras panel = new Figuras(opcion);

        JFrame aplicacion = new JFrame();
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplicacion.add(panel);
        aplicacion.setSize(800, 600);
        aplicacion.setVisible(true);
    }
}
