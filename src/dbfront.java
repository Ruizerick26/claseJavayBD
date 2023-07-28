import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class dbfront {
    private JButton queryButton;
    private JTextArea info;
    private JPanel root;
    static final String db_URL="jdbc:mysql://localhost/POO1";
    static final String usser="root";
    static final String pass="root_bas3";
    static final String query="SELECT * from estudiantes";

    public dbfront() {
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(
                        Connection conn = DriverManager.getConnection(db_URL,usser,pass);
                        Statement stat = conn.createStatement();
                        ResultSet rs = stat.executeQuery(query);
                ){
                    while (rs.next()) {

                        System.out.println("id:" + rs.getString("IDest"));
                        System.out.println("Nombre:" + rs.getString("Nombreest"));
                        info.append("id:" + rs.getString("IDest") + "-Nombre:" + rs.getString("Nombreest")+ "-edad" + rs.getString("EdadEst") + "\n");


                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("dbfront");
        frame.setContentPane(new dbfront().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

