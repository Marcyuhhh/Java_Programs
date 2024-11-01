package ticketingSystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PassengerNow {

    private JFrame frmTicketAPassenger;
    private JTextField textId;
    private JComboBox<String> comboBoxPickUp;
    private JComboBox<String> comboBoxDropOut;
    private JComboBox<String> comboBoxLugage;
    private JTextField textQuanLugage;
    private static int fileCounter = 0;
    private String jeepneyPlateNumber;
    double DiscountFactor;
    double totalFee = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PassengerNow window = new PassengerNow();
                    window.frmTicketAPassenger.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public PassengerNow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmTicketAPassenger = new JFrame();
        frmTicketAPassenger.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\personal\\workspace101\\oopPIT\\PropFiles\\EURESE INDUSTRIES.png"));
        frmTicketAPassenger.setBounds(100, 100, 432, 560);
        frmTicketAPassenger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmTicketAPassenger.setTitle("TICKET A PASSENGER");
        frmTicketAPassenger.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(16, 141, 383, 239);
        panel.setOpaque(false);
        panel.setBackground(new Color(0, 0, 0, 50));
        frmTicketAPassenger.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lbPassengerId = new JLabel("PASSENGER ID");
        lbPassengerId.setFont(new Font("SansSerif", Font.BOLD, 12));
        lbPassengerId.setBounds(10, 26, 162, 33);
        panel.add(lbPassengerId);

        textId = new JTextField();
        textId.setBounds(164, 27, 220, 33);
        panel.add(textId);
        textId.setColumns(10);

        JLabel lblPickUp = new JLabel("PICK UP POINT");
        lblPickUp.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblPickUp.setBounds(10, 80, 162, 33);
        panel.add(lblPickUp);

        comboBoxPickUp = new JComboBox<String>();
        comboBoxPickUp.setBounds(164, 80, 224, 33);
        comboBoxPickUp.addItem("Lumbia");
        comboBoxPickUp.addItem("SM Uptown");
        comboBoxPickUp.addItem("Carmen");
        panel.add(comboBoxPickUp);

        JLabel lblDropOut = new JLabel("DROP OUT POINT");
        lblDropOut.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblDropOut.setBounds(10, 123, 162, 33);
        panel.add(lblDropOut);

        comboBoxDropOut = new JComboBox<String>();
        comboBoxDropOut.setBounds(164, 124, 224, 33);
        comboBoxDropOut.addItem("SM Uptown");
        comboBoxDropOut.addItem("Carmen");
        comboBoxDropOut.addItem("Cogon");
        panel.add(comboBoxDropOut);

        JLabel lblLugage = new JLabel("LUGGAGES");
        lblLugage.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblLugage.setBounds(10, 168, 127, 33);
        panel.add(lblLugage);

        comboBoxLugage = new JComboBox<String>();
        comboBoxLugage.setBounds(250, 168, 138, 33);
        comboBoxLugage.addItem("small");
        comboBoxLugage.addItem("Medium");
        comboBoxLugage.addItem("Large");
        panel.add(comboBoxLugage);

        textQuanLugage = new JTextField();
        textQuanLugage.setBounds(164, 169, 76, 33);
        panel.add(textQuanLugage);
        textQuanLugage.setColumns(10);
        
    	JButton btnBack = new JButton("BACK");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainPage newWindow = new MainPage();
		        newWindow.showWindow();
		       frmTicketAPassenger.dispose();
			}
		});
		btnBack.setFont(new Font("Arial", Font.BOLD, 14));
		btnBack.setBounds(10, 402, 137, 45);
		frmTicketAPassenger.getContentPane().add(btnBack);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				   FileWriter fw;
				try {
					fw = new FileWriter("C:\\Users\\personal\\workspace101\\oopPIT\\DATA\\LoggedInPlateNumber.txt");
					fw.write("");
	                fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
                   
				System.exit(0);
			}
		});
		btnExit.setBounds(10, 459, 137, 36);
		btnExit.setFont(new Font("Arial", Font.BOLD, 14));
		frmTicketAPassenger.getContentPane().add(btnExit);
        
                JButton btnProceed = new JButton("PROCEED");
                btnProceed.setBounds(229, 402, 164, 48);
                frmTicketAPassenger.getContentPane().add(btnProceed);
                btnProceed.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String id = textId.getText();
                        String pick = (String) comboBoxPickUp.getSelectedItem();
                        String drop = (String) comboBoxDropOut.getSelectedItem();
                        String luggage = (String) comboBoxLugage.getSelectedItem();
                        int Lquan = Integer.parseInt(textQuanLugage.getText());

                        try {
                            // Read jeepney plate number from file and clear the file
                            FileReader fr = new FileReader("C:\\Users\\personal\\workspace101\\oopPIT\\DATA\\LoggedInPlateNumber.txt");
                            BufferedReader br = new BufferedReader(fr);
                            jeepneyPlateNumber = br.readLine();
                            br.close();

                            // Read the existing CSV file (assuming it's named "data.csv")
                            String csvFilePath = "C:\\Users\\personal\\workspace101\\oopPIT\\DATA\\passengerdata.csv";
                            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
                            String line;
                            while ((line = reader.readLine()) != null) {
                                String[] columns = line.split(",");
                                String existingId = columns[0].trim(); // Assuming ID is the first column
                                if (existingId.equals(id.trim())) {
                                    // Match found, extract passenger name and type
                                    String passengerName = columns[1].trim(); // Assuming name is the second column
                                    String passengerType = columns[4].trim(); // Assuming type is the fifth column

                                    // Calculate transportation fee
                                    int transportationFee;
                                    if (pick.equals("Lumbia") && drop.equals("Carmen")) {
                                        transportationFee = 25;
                                    } else if (pick.equals("SM Uptown") && drop.equals("Cogon")) {
                                        transportationFee = 25;
                                    } else if (pick.equals("Lumbia") && drop.equals("Cogon")) {
                                        transportationFee = 30;
                                    } else if (pick.equals("Lumbia") && drop.equals("SM Uptown")) {
                                        transportationFee = 20;
                                    } else {
                                        transportationFee = 0;
                                    }

                                    // Calculate luggage fee
                                    int luggageFee;
                                    if ("small".equalsIgnoreCase(luggage)) {
                                        luggageFee = 2;
                                    } else if ("Medium".equalsIgnoreCase(luggage)) {
                                        luggageFee = 4;
                                    } else if ("Large".equalsIgnoreCase(luggage)) {
                                        luggageFee = 8;
                                    } else {
                                        luggageFee = 0;
                                    }

                                    // Calculate total payment
                                    int TotalFee = (Lquan * luggageFee) + transportationFee;

                                    // Apply discount for seniors and students
                                    if ("student".equalsIgnoreCase(passengerType)) {
                                        DiscountFactor = 0.8;
                                    } else if ("senior citizen".equalsIgnoreCase(passengerType)) {
                                        DiscountFactor = 0.85;
                                    } else {
                                        DiscountFactor = 0;
                                    }

                                    double dis = TotalFee * (1 - DiscountFactor);
                                    double pay = TotalFee - dis;

                                    String formattedDiscount = String.format("%.2f", dis);
                                    String formattedTotalDiscountedPayment = String.format("%.2f", pay);

                                    fileCounter++;

                                    // Write to the text file
                                    String fileName = "C:\\Users\\personal\\workspace101\\oopPIT\\DATA\\RECEIPTS\\" + fileCounter + "_" + id + ".txt";
                                    FileWriter writer = new FileWriter(fileName);
                                    writer.write("Printed on: " + new Date() + "\n");
                                    writer.write("ID: " + id + "\n");
                                    writer.write("Passenger Name: " + passengerName + "\n");
                                    writer.write("Passenger Type: " + passengerType + "\n");
                                    writer.write("Pick Up Point: " + pick + "\n");
                                    writer.write("Drop Out Point: " + drop + "\n");
                                    writer.write("Luggage Quantity: " + Lquan + "\n");
                                    writer.write("Luggage Type: " + luggage + "\n");
                                    writer.write("Transportation Fee: " + transportationFee + " pesos\n");
                                    writer.write("Luggage Fee: " + (Lquan * luggageFee) + " pesos\n");
                                    writer.write("Total Payment: " + TotalFee + " pesos\n");
                                    writer.write("Discounted Amount: " + formattedDiscount + " pesos\n");
                                    writer.write("Total Discounted Payment: " + formattedTotalDiscountedPayment + " pesos\n");
                                    writer.write("Jeepney Plate Number: " + jeepneyPlateNumber + "\n");
                                    writer.close();

                                    System.out.println("Receipt generated successfully!");

                                    JOptionPane.showMessageDialog(null, "Reciept was successfully generated, please proceed to pay\n"
                                            + "Thank You!!");

                                    break;
                                }
                            }
                            reader.close();

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "You entered an invalid number.");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                        }
                    }
                });
                btnProceed.setFont(new Font("Arial", Font.BOLD, 14));
                btnProceed.setBackground(new Color(255, 255, 255));
                
                        JLabel lblNewLabel = new JLabel("");
                        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\personal\\workspace101\\oopPIT\\PropFiles\\2.png"));
                        lblNewLabel.setBounds(0, 0, 416, 536);
                        frmTicketAPassenger.getContentPane().add(lblNewLabel);
    }
    
    public void setVisible() {
		frmTicketAPassenger.setVisible(true);
		
	}
}
