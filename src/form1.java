import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form1 {
    public JPanel panel1;
    private JButton borrarButton;
    private JButton AGREGARButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public form1() {
        AGREGARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiantes2024";
                String user = "root";
                String password = "123456";
                estudiante clase = new estudiante();


                String cedula = textField1.getText();
                String nombre = textField2.getText();
                Double nota1 = Double.parseDouble(textField3.getText());
                Double nota2 = Double.parseDouble(textField4.getText());

                clase.setCedula(cedula);
                clase.setNombre(nombre);
                clase.setNota1(nota1);
                clase.setNota2(nota2);

                String sql = "INSERT INTO estudiantes (cedula, nombre, b1, b2) VALUES (?, ?, ?, ?)";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    PreparedStatement cadena = connection.prepareStatement(sql);

                    cadena.setString(1, clase.getCedula());
                    cadena.setString(2, clase.getNombre());
                    cadena.setDouble(3, clase.getNota1());
                    cadena.setDouble(4, clase.getNota2());
                    cadena.executeUpdate();

                } catch (SQLException E) {
                    JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + E.getMessage());
                    E.printStackTrace();
                }

                System.out.println("Nombre: " + clase.getNombre());
                System.out.println("Cédula: " + clase.getCedula());
                System.out.println("Nota 1: " + clase.getNota1());
                System.out.println("Nota 2: " + clase.getNota2());



            }

        });
    }
}
