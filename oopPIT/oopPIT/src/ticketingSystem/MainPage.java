package ticketingSystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class MainPage {

	private JFrame frmEi;
	private static MainPage instance;
	    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frmEi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEi = new JFrame();
		frmEi.setTitle("E.I JEEPNEY SERVICES");
		frmEi.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\personal\\workspace101\\oopPIT\\PropFiles\\EURESE INDUSTRIES.png"));
		frmEi.setBounds(100, 100, 432, 560);
		frmEi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEi.getContentPane().setLayout(null);
		
		JButton btnRideNow = new JButton("PASSENGER");
		btnRideNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassengerNow newWindow = new PassengerNow();
				newWindow.setVisible();
				frmEi.dispose();
			}
		});
		btnRideNow.setForeground(new Color(255, 255, 255));
		btnRideNow.setBounds(84, 170, 244, 73);
		btnRideNow.setOpaque(false);
		btnRideNow.setContentAreaFilled(false);
		btnRideNow.setBorderPainted(false);
		btnRideNow.setFont(new Font("SansSerif", Font.BOLD, 16));
		frmEi.getContentPane().add(btnRideNow);
		
		JButton btnRegister = new JButton("NEW PASSENGER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPassenger newWindow = new NewPassenger();
				newWindow.setVisible();
				frmEi.dispose();
			}
		});
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setBounds(84, 170, 244, 73);
		btnRegister.setOpaque(false);
		btnRegister.setContentAreaFilled(false);
		btnRegister.setBorderPainted(false);
		btnRegister.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnRegister.setBounds(84, 261, 245, 73);
		frmEi.getContentPane().add(btnRegister);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(121, 356, 169, 41);
		btnExit.setOpaque(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnExit.setForeground(new Color(255, 255, 255));
		frmEi.getContentPane().add(btnExit);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon("C:\\Users\\personal\\workspace101\\oopPIT\\PropFiles\\10101.png"));
		lblBg.setBounds(0, 0, 416, 521);
		frmEi.getContentPane().add(lblBg);
	}

	    // Static method to return the instance of MainPage
	    public static MainPage getInstance() {
	        if (instance == null) {
	            instance = new MainPage();
	        }
	        return instance;
	    }

	    // Other methods remain unchanged
	    // ...

	    public void showWindow() {
	        frmEi.setVisible(true);
	    }
	}
