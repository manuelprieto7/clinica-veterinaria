package prieto.manuel.maven.peluqueriacanina.igu;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

public class Principal extends JFrame {

    // Componentes de la ventana declarados como atributos
    // para que todos los metodos de la clase puedan accederlos
    private JLabel lblTitulo;
    private JButton btnNuevaMascota;
    private JButton btnVerMascotas;
    private JButton btnSalir;
    private JPanel panelPrincipal;

    public Principal() {
        // todos los componentes visuales de la ventana
        initComponents();
    }

    private void initComponents() {
        // Inicialización de componentes
        panelPrincipal = new JPanel();
        lblTitulo = new JLabel("Peluqueria Canina");
        btnNuevaMascota = new JButton("Nueva Mascota");
        btnVerMascotas = new JButton("Ver Mascotas");
        btnSalir = new JButton("Salir");

        lblTitulo.setFont(new Font("Dialog", Font.BOLD, 28));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        // Al cerrar la ventana principal, termina el proceso Java completo
        // En ventanas secundarias usaremos DISPOSE_ON_CLOSE en cambio
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Peluqueria Canina");
        setResizable(false);
        // EVENTOS 
        btnNuevaMascota.addActionListener(e -> abrirCargaDatos());
        btnVerMascotas.addActionListener(e -> abrirVerDatos());
        btnSalir.addActionListener(e -> {
            prieto.manuel.maven.peluqueriacanina.persistencia.JpaUtil.cerrar();
            System.exit(0);
        });

        GroupLayout layout = new GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(lblTitulo)
                        .addComponent(btnNuevaMascota, 200, 200, 200)
                        .addComponent(btnVerMascotas, 200, 200, 200)
                        .addComponent(btnSalir, 200, 200, 200)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevaMascota, 40, 40, 40)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerMascotas, 40, 40, 40)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, 40, 40, 40)
        );

        getContentPane().add(panelPrincipal);
        pack();
    }

    private void abrirCargaDatos() {
        // Implementamos cuando CargaDatos esté creada
    }

    private void abrirVerDatos() {
        // Implementamos cuando VerDatos esté creada
    }
}
