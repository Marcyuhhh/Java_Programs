package ticketingSystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConductorLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel CondLogin;
    private JTextField textPlateNo;
    private JTextField textCodID;
    private JTextField textPass;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConductorLogin frame = new ConductorLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ConductorLogin() {
        setTitle("E.I JEEPNEY LOG IN");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\personal\\workspace101\\oopPIT\\PropFiles\\EURESE INDUSTRIES.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 430, 560);
        CondLogin = new JPanel();
        CondLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(CondLogin);
        CondLogin.setLayout(null);

        JButton btnLogIn = new JButton("LOG IN");
        btnLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateInputFields()) {
                    MainPage newWindow = new MainPage();
                    newWindow.showWindow();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials. Please check your input.");
                }
            }
        });
        btnLogIn.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnLogIn.setBounds(211, 361, 125, 44);
        CondLogin.add(btnLogIn);

        JButton btnExit = new JButton("EXIT");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnExit.setBounds(76, 361, 125, 44);
        CondLogin.add(btnExit);

        textPlateNo = new JTextField();
        textPlateNo.setBounds(212, 174, 191, 35);
        CondLogin.add(textPlateNo);
        textPlateNo.setColumns(10);

        textCodID = new JTextField();
        textCodID.setColumns(10);
        textCodID.setBounds(212, 220, 191, 35);
        CondLogin.add(textCodID);

        textPass = new JTextField();
        textPass.setColumns(10);
        textPass.setBounds(212, 268, 191, 35);
        CondLogin.add(textPass);

        JLabel lblJeepNo = new JLabel("JEEPNEY PLATE NUMBER");
        lblJeepNo.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblJeepNo.setBounds(10, 174, 191, 35);
        CondLogin.add(lblJeepNo);

        JLabel lblCondId = new JLabel("CONDUCTOR ID");
        lblCondId.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblCondId.setBounds(10, 220, 133, 35);
        CondLogin.add(lblCondId);

        JLabel lblpass = new JLabel("PASSWORD");
        lblpass.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblpass.setBounds(10, 266, 133, 35);
        CondLogin.add(lblpass);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\personal\\workspace101\\oopPIT\\PropFiles\\2.png"));
        lblNewLabel.setBounds(0, 0, 414, 521);
        CondLogin.add(lblNewLabel);
    }

    private boolean validateInputFields() {
        String csvFile = "C:\\Users\\personal\\workspace101\\oopPIT\\DATA\\ConductorData.csv";
        String line;
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String inputPlateNo = textPlateNo.getText().trim();
            String inputCodID = textCodID.getText().trim();
            String inputPass = textPass.getText().trim();

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(delimiter);
                String plateNo = fields[0].trim();
                String codID = fields[1].trim();
                String password = fields[2].trim();

                if (plateNo.equals(inputPlateNo) && codID.equals(inputCodID) && password.equals(inputPass)) {
                    // Valid credentials, store the plate number
                    storeJeepneyPlateNumber(plateNo);
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Invalid credentials
    }

    private void storeJeepneyPlateNumber(String plateNumber) {
        // Store the plate number in a file
        try (FileWriter writer = new FileWriter("C:\\Users\\personal\\workspace101\\oopPIT\\DATA\\LoggedInPlateNumber.txt")) {
            writer.write(plateNumber);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
