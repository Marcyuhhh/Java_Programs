package ticketingSystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegisterConductor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel CondLogin;
	private JTextField textPlateNo;
	private JTextField textCodID;
	private JTextField textPass;
	static FileWriter fileWriter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 fileWriter = new FileWriter("C:\\Users\\personal\\workspace101\\oopPIT\\DATA\\ConductorData.csv",true);
					RegisterConductor frame = new RegisterConductor();
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
	public RegisterConductor() {
		setTitle("E.I JEEPNEY CONDUCTOR REGISTRATION");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\personal\\workspace101\\oopPIT\\PropFiles\\EURESE INDUSTRIES.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 560);
		CondLogin = new JPanel();
		CondLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(CondLogin);
		CondLogin.setLayout(null);
		
		
		JButton btnRegis = new JButton("REGISTER");
        btnRegis.setFont(new Font("SansSerif", Font.BOLD, 14));
        		btnRegis.addMouseListener(new MouseAdapter() {
        			@Override
        			public void mouseClicked(MouseEvent e) {
        				String id, jeep, pass, codStr;
        				
        				
        				try {
        					jeep =textPlateNo.getText();
        					id=textCodID.getText();
        				    pass =textPass.getText();			
        					if (!id.isEmpty() && !jeep.isEmpty() && !pass.isEmpty() ) // if no blank entries
        					{
        						
        						// backup display, for checking if input values are correctly obtained
        						System.out.println("Jeepney Plate No.: "+jeep);
        						System.out.println("Conductor Id:"+id);
        						System.out.println("Account Password:"+pass);
        					
        						// write the new student record into the csv file						 
        						codStr= jeep+","+id+","+pass;
        						System.out.println(codStr);
        						fileWriter.append(codStr);  //or you may use .write(studStr);          
        						fileWriter.append('\n');   // append a newline character to write the next student record on the next line
        						JOptionPane.showMessageDialog(null, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        					}
        					
        					else
        					{
        						JOptionPane.showMessageDialog(null,"Lacking data entry.","Error",JOptionPane.ERROR_MESSAGE);						
        					}
        					fileWriter.close();
        				}//try
        				catch (Exception err)
        				{				
        					
        				}
        						
        			}
        		});
        btnRegis.setBounds(276, 449, 127, 44);	
		CondLogin.add(btnRegis);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnExit.setBounds(136, 449, 125, 44);
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
}
