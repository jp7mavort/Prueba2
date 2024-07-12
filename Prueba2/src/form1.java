import javax.swing.*;
import java.sql.*;

public class form1 {
    private JPanel MainPanel;
    private JTextField usuarioTextField;
    private JPasswordField contraseñaPasswordField;
    private JButton IngresarButton;
    private JButton VentanaDeBusquedaButton;

    private static final String url = "jdbc:mysql://localhost:3306/productos_cp";
    private static final String user = "root";
    private static final String password = "123456";

    public form1() {
        IngresarButton.addActionListener(e -> authenticate());
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public JButton getIngresarButton() {
        return IngresarButton;
    }

    public JButton getVentanaDeBusquedaButton() {
        return VentanaDeBusquedaButton;
    }

    public boolean authenticate() {
        String username = usuarioTextField.getText();
        String pass = new String(contraseñaPasswordField.getPassword());

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM USUARIO WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return true;
            } else {

                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
