package tarea_17;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Torre extends JFrame {
    private JTextField txtDiscos;
    private JTextArea txtAreaPasos;

    public Torre() {
        setTitle("Torre de Hanói");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblDiscos = new JLabel("Cantidad de discos:");
        lblDiscos.setBounds(20, 20, 150, 30);
        add(lblDiscos);

        txtDiscos = new JTextField();
        txtDiscos.setBounds(150, 20, 50, 30);
        add(txtDiscos);

        JButton btnResolver = new JButton("Resolver");
        btnResolver.setBounds(220, 20, 100, 30);
        add(btnResolver);

        txtAreaPasos = new JTextArea();
        txtAreaPasos.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtAreaPasos);
        scroll.setBounds(20, 70, 340, 250);
        add(scroll);

        btnResolver.addActionListener(e -> {
            try {
                int cantidad = Integer.parseInt(txtDiscos.getText());
                TorreHanoiData data = new TorreHanoiData(cantidad);
                txtAreaPasos.setText("");
                resolverHanoi(data.getDiscos(), "A", "C", "B");
            } catch (NumberFormatException ex) {
                txtAreaPasos.setText("Por favor, ingresa un número válido.");
            }
        });

        setVisible(true);
    }

    private void resolverHanoi(int n, String origen, String destino, String auxiliar) {
        if (n == 1) {
            txtAreaPasos.append("Mover disco de " + origen + " a " + destino + "\n");
        } else {
            resolverHanoi(n - 1, origen, auxiliar, destino);
            txtAreaPasos.append("Mover disco de " + origen + " a " + destino + "\n");
            resolverHanoi(n - 1, auxiliar, destino, origen);
        }
    }

    public static void main(String[] args) {
        new Torre();
    }
}