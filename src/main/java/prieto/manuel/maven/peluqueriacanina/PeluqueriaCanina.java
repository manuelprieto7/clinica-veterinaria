/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package prieto.manuel.maven.peluqueriacanina;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import prieto.manuel.maven.peluqueriacanina.igu.Principal;
import prieto.manuel.maven.peluqueriacanina.persistencia.JpaUtil;

/**
 *
 * @author G513
 */
public class PeluqueriaCanina {

    public static void main(String[] args) {

        JFrame.setDefaultLookAndFeelDecorated(false);

        SwingUtilities.invokeLater(() -> {
            Principal ventana = new Principal();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                JpaUtil.cerrar();
            }));

        });
    }
}
