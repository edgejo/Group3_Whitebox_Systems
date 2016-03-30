package whiteboxsystems;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewOrder extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel textPanel;
	private JTextArea nameArea;
	private JTextArea emailArea;
	private JTextArea numberArea;
	private JTextField buildID;
	private JTextField name;
	private JTextField email;
	private JTextField phoneNumber;
	private JButton submit;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewOrder frame = new NewOrder();
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
	public NewOrder() {
		setTitle("WhiteBox Systems");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
//		createTextPanel();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
//		contentPane.add(textPanel);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{64, 61, 0, 0, 157, 28, 61, 0};
		gbl_contentPane.rowHeights = new int[]{26, 26, 26, 26, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("BuildID");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		buildID = new JTextField();

		GridBagConstraints gbc_buildID = new GridBagConstraints();
		gbc_buildID.anchor = GridBagConstraints.NORTHEAST;
		gbc_buildID.insets = new Insets(0, 0, 5, 5);
		gbc_buildID.gridwidth = 4;
		gbc_buildID.gridx = 1;
		gbc_buildID.gridy = 0;
		contentPane.add(buildID, gbc_buildID);
		buildID.setColumns(15);
		
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		name = new JTextField();
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.anchor = GridBagConstraints.NORTHEAST;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.gridwidth = 4;
		gbc_name.gridx = 1;
		gbc_name.gridy = 1;
		contentPane.add(name, gbc_name);
		name.setColumns(15);
		
		JLabel lblNewLabel_2 = new JLabel("Email Address");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		email = new JTextField();
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.anchor = GridBagConstraints.NORTHEAST;
		gbc_email.insets = new Insets(0, 0, 5, 5);
		gbc_email.gridwidth = 4;
		gbc_email.gridx = 1;
		gbc_email.gridy = 2;
		contentPane.add(email, gbc_email);
		email.setColumns(15);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		phoneNumber = new JTextField();
		GridBagConstraints gbc_phoneNumber = new GridBagConstraints();
		gbc_phoneNumber.anchor = GridBagConstraints.EAST;
		gbc_phoneNumber.gridwidth = 3;
		gbc_phoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_phoneNumber.gridx = 2;
		gbc_phoneNumber.gridy = 3;
		contentPane.add(phoneNumber, gbc_phoneNumber);
		phoneNumber.setColumns(15);
		
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 buildID.getText();
				 name.getText();
				 email.getText();
				 phoneNumber.getText();
			}
		});
		GridBagConstraints gbc_submit = new GridBagConstraints();
		gbc_submit.insets = new Insets(0, 0, 5, 5);
		gbc_submit.gridx = 4;
		gbc_submit.gridy = 4;
		contentPane.add(submit, gbc_submit);
		
	}
}
