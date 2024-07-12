import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        form1 loginForm = new form1();
        frame.setContentPane(loginForm.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        loginForm.getIngresarButton().addActionListener(e -> {
            if (loginForm.authenticate()) {
                JFrame frame2 = new JFrame();
                form2 productRegistrationForm = new form2();
                frame2.setContentPane(productRegistrationForm.getMainPanel());
                frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame2.pack();
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);

                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos");
            }
        });


        loginForm.getVentanaDeBusquedaButton().addActionListener(e -> {
            JFrame frame3 = new JFrame();
            form3 productSearchForm = new form3();
            frame3.setContentPane(productSearchForm.getMainPanel());
            frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame3.pack();
            frame3.setLocationRelativeTo(null);
            frame3.setVisible(true);

            frame.dispose();
        });
    }
}
