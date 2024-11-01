package ticketingSystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class NewPassenger {

	private JFrame frame;
	    private JTextField textId;
	    private JTextField textName;
	    private JTextField textContactNum;
	    private ButtonGroup bg = new ButtonGroup();
	    private ButtonGroup bgr = new ButtonGroup();
	    static FileWriter fileWriter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 fileWriter = new FileWriter("C:\\Users\\personal\\workspace101\\oopPIT\\DATA\\passengerdata.csv", true);
					NewPassenger window = new NewPassenger();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewPassenger() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\personal\\workspace101\\oopPIT\\PropFiles\\EURESE INDUSTRIES.png"));
		frame.setBounds(100, 100, 432, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("REGISTER NEW PASSENGER");
        frame.getContentPane().setLayout(null);
		
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 130, 383, 324);
        panel.setOpaque(false);
        panel.setBackground(new Color(0, 0, 0, 50));
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblID = new JLabel("ID");
        lblID.setBounds(10, 11, 135, 29);
        panel.add(lblID);
        lblID.setFont(new Font("SansSerif", Font.BOLD, 14));

        JLabel lblName = new JLabel("NAME");
        lblName.setBounds(10, 51, 135, 29);
        panel.add(lblName);
        lblName.setFont(new Font("SansSerif", Font.BOLD, 14));

        JLabel lblGender = new JLabel("GENDER");
        lblGender.setBounds(10, 91, 135, 29);
        panel.add(lblGender);
        lblGender.setFont(new Font("SansSerif", Font.BOLD, 14));

        JLabel lblContactNumber = new JLabel("CONTACT NUMBER");
        lblContactNumber.setBounds(10, 152, 135, 29);
        panel.add(lblContactNumber);
        lblContactNumber.setFont(new Font("SansSerif", Font.BOLD, 14));

        textId = new JTextField();
        textId.setBounds(166, 11, 193, 29);
        panel.add(textId);
        textId.setColumns(10);

        textName = new JTextField();
        textName.setBounds(166, 55, 193, 29);
        panel.add(textName);
        textName.setColumns(10);

        textContactNum = new JTextField();
        textContactNum.setBounds(166, 152, 193, 29);
        panel.add(textContactNum);
        textContactNum.setColumns(10);

        JRadioButton maleButton = new JRadioButton("MALE");
        maleButton.setBounds(166, 91, 128, 29);
        panel.add(maleButton);
        maleButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        maleButton.setOpaque(false);
		maleButton.setContentAreaFilled(false);
		maleButton.setBorderPainted(false);
		bg.add(maleButton);

        JRadioButton femaleButton = new JRadioButton("FEMALE");
        femaleButton.setBounds(166, 123, 128, 29);
        panel.add(femaleButton);
        femaleButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        femaleButton.setOpaque(false);
		femaleButton.setContentAreaFilled(false);
		femaleButton.setBorderPainted(false);

        bg.add(femaleButton);

        JLabel lblPassengerType = new JLabel("PASSENGER TYPE");
        lblPassengerType.setBounds(10, 192, 135, 29);
        panel.add(lblPassengerType);
        lblPassengerType.setFont(new Font("SansSerif", Font.BOLD, 14));

        JRadioButton rdbtnRegular = new JRadioButton("REGULAR");
        rdbtnRegular.setBounds(166, 188, 128, 29);
        panel.add(rdbtnRegular);
        rdbtnRegular.setFont(new Font("SansSerif", Font.BOLD, 14));
        rdbtnRegular.setOpaque(false);
		rdbtnRegular.setContentAreaFilled(false);
		rdbtnRegular.setBorderPainted(false);
		
		bgr.add(rdbtnRegular);

        JRadioButton rdbtnStudent = new JRadioButton("STUDENT");
        rdbtnStudent.setBounds(166, 220, 128, 29);
        panel.add(rdbtnStudent);
        rdbtnStudent.setFont(new Font("SansSerif", Font.BOLD, 14));
        rdbtnStudent.setOpaque(false);
		rdbtnStudent.setContentAreaFilled(false);
		rdbtnStudent.setBorderPainted(false);
		bgr.add(rdbtnStudent);

        JRadioButton rdbtnSeniorCitizen = new JRadioButton("SENIOR CITIZEN");
        rdbtnSeniorCitizen.setBounds(166, 252, 173, 29);
        panel.add(rdbtnSeniorCitizen);
        rdbtnSeniorCitizen.setFont(new Font("SansSerif", Font.BOLD, 14));
        rdbtnSeniorCitizen.setOpaque(false);
		rdbtnSeniorCitizen.setContentAreaFilled(false);
		rdbtnSeniorCitizen.setBorderPainted(false);
        bgr.add(rdbtnSeniorCitizen);

        JButton btnNewButton = new JButton("REGISTER");
        btnNewButton.setBounds(277, 446, 127, 50);
        btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String id, name, connum, gender, pastype, passen;

                try {
                    id = textId.getText();
                    name = textName.getText();
                    connum = textContactNum.getText();
                    gender = (femaleButton.isSelected()) ? femaleButton.getText() : maleButton.getText();
                    pastype = (rdbtnRegular.isSelected()) ? rdbtnRegular.getText() : (rdbtnStudent.isSelected()) ? rdbtnStudent.getText() : rdbtnSeniorCitizen.getText();

                    if (!id.isEmpty() && !name.isEmpty() && !connum.isEmpty() && !gender.isEmpty() && !pastype.isEmpty()) {
                        passen = id + "," + name + "," + connum + "," + gender + "," + pastype;
                        System.out.println(passen);

                        // Ensure FileWriter is properly initialized and closed
                        try (FileWriter fileWriter = new FileWriter("C:\\Users\\personal\\workspace101\\oopPIT\\DATA\\passengerdata.csv", true)) {
                            fileWriter.append(passen);
                            fileWriter.append('\n');
                            JOptionPane.showMessageDialog(null, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error writing to CSV file.", "Error", JOptionPane.ERROR_MESSAGE);
                            ex.printStackTrace();
                        }

                        // Clear text fields after successful registration
                        textId.setText("");
                        textName.setText("");
                        textContactNum.setText("");
                        bg.clearSelection();
                        bgr.clearSelection();

                    } else {
                        JOptionPane.showMessageDialog(null, "Lacking data entry.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception err) {
                    err.printStackTrace();
                }
            }
        });

        frame.getContentPane().add(btnNewButton);

        JButton btnBack = new JButton("BACK");
        btnBack.setBounds(119, 446, 127, 50);
        btnBack.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainPage.getInstance().showWindow(); // Show the existing instance
                frame.dispose(); //
        	}
        });
        frame.getContentPane().add(btnBack);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 416, 521);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\personal\\workspace101\\oopPIT\\PropFiles\\2.png"));
        frame.getContentPane().add(lblNewLabel);
    }

	public void setVisible() {
		frame.setVisible(true);
		
	}
}
