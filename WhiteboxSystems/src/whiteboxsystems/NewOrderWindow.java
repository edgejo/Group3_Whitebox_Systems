package whiteboxsystems;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import orderinfo.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class NewOrderWindow extends JFrame {

	private GUIManager guiManager;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField buildIDTextField;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField phoneNumberTextField;
	private JButton submit;
	private JLabel lblDeliveryDate;
	private JTextField deliverDateTextField;
	private JLabel lblPaymentMethod;
	private JTextField paymentMethodTextField;
	private JLabel lblTotalValue;
	private JTextField totalValueTextField;
	private JLabel lblDeliveryConfirmationFile;
	private JTextField confirmationFileTextField;
	private JLabel IBComponentType;
	private JLabel IBManufacturer;
	private JLabel IBDescription;
	private JLabel IBModelNumber;
	private JLabel IBSerialNumber;
	private JLabel IBRebateValue;
	private JLabel IBprice;
	private JLabel WarrantyPeriodTextField;
	private JLabel lblWarrantyExpiry;
	private JTextField componentTypeTextField;
	private JTextField manufacturerTextField;
	private JTextField descriptionTextField;
	private JTextField modelNumTextField;
	private JTextField serialNumTextField;
	private JTextField rebateValueTextField;
	private JTextField priceTextField;
	private JTextField warantyPeriodTextField;
	private JTextField warantyExpiryTextField;
	private JTextField invoiceDateTextField;
	private JTextField InvoiceNumTextField;
	private JTextField salesTextField;
	private JTextField itemSKUTextField;
	private JLabel IBInvoiceDate;
	private JLabel IBInvoiceNumber;
	private JLabel IBsalesOrderNumber;
	private JLabel lblItemSku;
	private JLabel lblPaymentInformation;
	private JLabel lblCustomerInformation;
	private JLabel lblProductInformation;

	/**
	 * Create the frame.
	 */
	public NewOrderWindow(GUIManager guiManager) {
		this.guiManager = guiManager;
		
		setTitle("WhiteBox Systems");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{169, 61, 150, 61, 132, 61, 150, 0};
		gbl_contentPane.rowHeights = new int[]{26, 26, 26, 26, 29, 29, 29, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("BuildID");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		buildIDTextField = new JTextField();
		
		GridBagConstraints gbc_buildID = new GridBagConstraints();
		gbc_buildID.fill = GridBagConstraints.HORIZONTAL;
		gbc_buildID.anchor = GridBagConstraints.NORTH;
		gbc_buildID.insets = new Insets(0, 0, 5, 5);
		gbc_buildID.gridx = 2;
		gbc_buildID.gridy = 1;
		contentPane.add(buildIDTextField, gbc_buildID);
		buildIDTextField.setColumns(15);
		
		lblProductInformation = new JLabel("Product Information ");
		lblProductInformation.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblProductInformation.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblProductInformation = new GridBagConstraints();
		gbc_lblProductInformation.gridwidth = 3;
		gbc_lblProductInformation.insets = new Insets(0, 0, 5, 0);
		gbc_lblProductInformation.gridx = 4;
		gbc_lblProductInformation.gridy = 1;
		contentPane.add(lblProductInformation, gbc_lblProductInformation);
		
		lblCustomerInformation = new JLabel("Customer Information ");
		lblCustomerInformation.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblCustomerInformation.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblCustomerInformation = new GridBagConstraints();
		gbc_lblCustomerInformation.gridwidth = 3;
		gbc_lblCustomerInformation.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerInformation.gridx = 0;
		gbc_lblCustomerInformation.gridy = 2;
		contentPane.add(lblCustomerInformation, gbc_lblCustomerInformation);
		
		IBComponentType = new JLabel("Component Type");
		GridBagConstraints gbc_IBComponentType = new GridBagConstraints();
		gbc_IBComponentType.anchor = GridBagConstraints.WEST;
		gbc_IBComponentType.insets = new Insets(0, 0, 5, 5);
		gbc_IBComponentType.gridx = 4;
		gbc_IBComponentType.gridy = 2;
		contentPane.add(IBComponentType, gbc_IBComponentType);
		
		componentTypeTextField = new JTextField();
		componentTypeTextField.setColumns(15);
		GridBagConstraints gbc_componentTypeTextField = new GridBagConstraints();
		gbc_componentTypeTextField.insets = new Insets(0, 0, 5, 0);
		gbc_componentTypeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_componentTypeTextField.gridx = 6;
		gbc_componentTypeTextField.gridy = 2;
		contentPane.add(componentTypeTextField, gbc_componentTypeTextField);
		
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		nameTextField = new JTextField();
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_name.anchor = GridBagConstraints.NORTH;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.gridx = 2;
		gbc_name.gridy = 3;
		contentPane.add(nameTextField, gbc_name);
		nameTextField.setColumns(15);
		
		IBManufacturer = new JLabel("Manufacturer");
		GridBagConstraints gbc_IBManufacturer = new GridBagConstraints();
		gbc_IBManufacturer.anchor = GridBagConstraints.WEST;
		gbc_IBManufacturer.insets = new Insets(0, 0, 5, 5);
		gbc_IBManufacturer.gridx = 4;
		gbc_IBManufacturer.gridy = 3;
		contentPane.add(IBManufacturer, gbc_IBManufacturer);
		
		manufacturerTextField = new JTextField();
		manufacturerTextField.setColumns(15);
		GridBagConstraints gbc_manfucturerTextField = new GridBagConstraints();
		gbc_manfucturerTextField.insets = new Insets(0, 0, 5, 0);
		gbc_manfucturerTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_manfucturerTextField.gridx = 6;
		gbc_manfucturerTextField.gridy = 3;
		contentPane.add(manufacturerTextField, gbc_manfucturerTextField);
		
		JLabel lblNewLabel_2 = new JLabel("Email Address");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		emailTextField = new JTextField();
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_email.anchor = GridBagConstraints.NORTH;
		gbc_email.insets = new Insets(0, 0, 5, 5);
		gbc_email.gridx = 2;
		gbc_email.gridy = 4;
		contentPane.add(emailTextField, gbc_email);
		emailTextField.setColumns(15);
		
		IBDescription = new JLabel("Description ");
		GridBagConstraints gbc_IBDescription = new GridBagConstraints();
		gbc_IBDescription.anchor = GridBagConstraints.WEST;
		gbc_IBDescription.insets = new Insets(0, 0, 5, 5);
		gbc_IBDescription.gridx = 4;
		gbc_IBDescription.gridy = 4;
		contentPane.add(IBDescription, gbc_IBDescription);
		
		descriptionTextField = new JTextField();
		descriptionTextField.setColumns(15);
		GridBagConstraints gbc_descriptionTextField = new GridBagConstraints();
		gbc_descriptionTextField.insets = new Insets(0, 0, 5, 0);
		gbc_descriptionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_descriptionTextField.gridx = 6;
		gbc_descriptionTextField.gridy = 4;
		contentPane.add(descriptionTextField, gbc_descriptionTextField);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		phoneNumberTextField = new JTextField();
		GridBagConstraints gbc_phoneNumber = new GridBagConstraints();
		gbc_phoneNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_phoneNumber.gridx = 2;
		gbc_phoneNumber.gridy = 5;
		contentPane.add(phoneNumberTextField, gbc_phoneNumber);
		phoneNumberTextField.setColumns(15);
		
		IBModelNumber = new JLabel("Model Number ");
		GridBagConstraints gbc_IBModelNumber = new GridBagConstraints();
		gbc_IBModelNumber.anchor = GridBagConstraints.WEST;
		gbc_IBModelNumber.insets = new Insets(0, 0, 5, 5);
		gbc_IBModelNumber.gridx = 4;
		gbc_IBModelNumber.gridy = 5;
		contentPane.add(IBModelNumber, gbc_IBModelNumber);
		
		modelNumTextField = new JTextField();
		modelNumTextField.setColumns(15);
		GridBagConstraints gbc_modelNumTextField = new GridBagConstraints();
		gbc_modelNumTextField.insets = new Insets(0, 0, 5, 0);
		gbc_modelNumTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_modelNumTextField.gridx = 6;
		gbc_modelNumTextField.gridy = 5;
		contentPane.add(modelNumTextField, gbc_modelNumTextField);
		
		lblDeliveryDate = new JLabel("Delivery Date");
		GridBagConstraints gbc_lblDeliveryDate = new GridBagConstraints();
		gbc_lblDeliveryDate.anchor = GridBagConstraints.WEST;
		gbc_lblDeliveryDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeliveryDate.gridx = 0;
		gbc_lblDeliveryDate.gridy = 6;
		contentPane.add(lblDeliveryDate, gbc_lblDeliveryDate);
		
		submit = new JButton("Submit");
		submit.addActionListener(new ButtonListener(this));
		
		deliverDateTextField = new JTextField();
		deliverDateTextField.setColumns(15);
		GridBagConstraints gbc_txtDeliverdatetextfield = new GridBagConstraints();
		gbc_txtDeliverdatetextfield.insets = new Insets(0, 0, 5, 5);
		gbc_txtDeliverdatetextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDeliverdatetextfield.gridx = 2;
		gbc_txtDeliverdatetextfield.gridy = 6;
		contentPane.add(deliverDateTextField, gbc_txtDeliverdatetextfield);
		
		IBSerialNumber = new JLabel("Serial Number ");
		GridBagConstraints gbc_IBSerialNumber = new GridBagConstraints();
		gbc_IBSerialNumber.anchor = GridBagConstraints.WEST;
		gbc_IBSerialNumber.insets = new Insets(0, 0, 5, 5);
		gbc_IBSerialNumber.gridx = 4;
		gbc_IBSerialNumber.gridy = 6;
		contentPane.add(IBSerialNumber, gbc_IBSerialNumber);
		
		serialNumTextField = new JTextField();
		serialNumTextField.setColumns(15);
		GridBagConstraints gbc_serialNumTextField = new GridBagConstraints();
		gbc_serialNumTextField.insets = new Insets(0, 0, 5, 0);
		gbc_serialNumTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_serialNumTextField.gridx = 6;
		gbc_serialNumTextField.gridy = 6;
		contentPane.add(serialNumTextField, gbc_serialNumTextField);
		
		lblPaymentInformation = new JLabel("Payment Information ");
		lblPaymentInformation.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPaymentInformation.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblPaymentInformation = new GridBagConstraints();
		gbc_lblPaymentInformation.gridwidth = 3;
		gbc_lblPaymentInformation.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaymentInformation.gridx = 0;
		gbc_lblPaymentInformation.gridy = 7;
		contentPane.add(lblPaymentInformation, gbc_lblPaymentInformation);
		
		IBRebateValue = new JLabel("Rebate Value");
		GridBagConstraints gbc_IBRebateValue = new GridBagConstraints();
		gbc_IBRebateValue.anchor = GridBagConstraints.WEST;
		gbc_IBRebateValue.insets = new Insets(0, 0, 5, 5);
		gbc_IBRebateValue.gridx = 4;
		gbc_IBRebateValue.gridy = 7;
		contentPane.add(IBRebateValue, gbc_IBRebateValue);
		
		rebateValueTextField = new JTextField();
		rebateValueTextField.setColumns(15);
		GridBagConstraints gbc_rebateValTextField = new GridBagConstraints();
		gbc_rebateValTextField.insets = new Insets(0, 0, 5, 0);
		gbc_rebateValTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_rebateValTextField.gridx = 6;
		gbc_rebateValTextField.gridy = 7;
		contentPane.add(rebateValueTextField, gbc_rebateValTextField);
		
		lblPaymentMethod = new JLabel("Payment Method");
		GridBagConstraints gbc_lblPaymentMethod = new GridBagConstraints();
		gbc_lblPaymentMethod.anchor = GridBagConstraints.WEST;
		gbc_lblPaymentMethod.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaymentMethod.gridx = 0;
		gbc_lblPaymentMethod.gridy = 8;
		contentPane.add(lblPaymentMethod, gbc_lblPaymentMethod);
		
		paymentMethodTextField = new JTextField();
		paymentMethodTextField.setColumns(15);
		GridBagConstraints gbc_paymentMethodTextField = new GridBagConstraints();
		gbc_paymentMethodTextField.insets = new Insets(0, 0, 5, 5);
		gbc_paymentMethodTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_paymentMethodTextField.gridx = 2;
		gbc_paymentMethodTextField.gridy = 8;
		contentPane.add(paymentMethodTextField, gbc_paymentMethodTextField);
		
		IBprice = new JLabel("Price");
		GridBagConstraints gbc_IBprice = new GridBagConstraints();
		gbc_IBprice.anchor = GridBagConstraints.WEST;
		gbc_IBprice.insets = new Insets(0, 0, 5, 5);
		gbc_IBprice.gridx = 4;
		gbc_IBprice.gridy = 8;
		contentPane.add(IBprice, gbc_IBprice);
		
		priceTextField = new JTextField();
		priceTextField.setColumns(15);
		GridBagConstraints gbc_priceTextField = new GridBagConstraints();
		gbc_priceTextField.insets = new Insets(0, 0, 5, 0);
		gbc_priceTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_priceTextField.gridx = 6;
		gbc_priceTextField.gridy = 8;
		contentPane.add(priceTextField, gbc_priceTextField);
		
		lblTotalValue = new JLabel("Total Value");
		GridBagConstraints gbc_lblTotalValue = new GridBagConstraints();
		gbc_lblTotalValue.anchor = GridBagConstraints.WEST;
		gbc_lblTotalValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalValue.gridx = 0;
		gbc_lblTotalValue.gridy = 9;
		contentPane.add(lblTotalValue, gbc_lblTotalValue);
		
		totalValueTextField = new JTextField();
		totalValueTextField.setColumns(15);
		GridBagConstraints gbc_totalValueTextField = new GridBagConstraints();
		gbc_totalValueTextField.insets = new Insets(0, 0, 5, 5);
		gbc_totalValueTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalValueTextField.gridx = 2;
		gbc_totalValueTextField.gridy = 9;
		contentPane.add(totalValueTextField, gbc_totalValueTextField);
		
		WarrantyPeriodTextField = new JLabel("Warranty Period");
		GridBagConstraints gbc_WarrantyPeriodTextField = new GridBagConstraints();
		gbc_WarrantyPeriodTextField.anchor = GridBagConstraints.WEST;
		gbc_WarrantyPeriodTextField.insets = new Insets(0, 0, 5, 5);
		gbc_WarrantyPeriodTextField.gridx = 4;
		gbc_WarrantyPeriodTextField.gridy = 9;
		contentPane.add(WarrantyPeriodTextField, gbc_WarrantyPeriodTextField);
		
		warantyPeriodTextField = new JTextField();
		warantyPeriodTextField.setColumns(15);
		GridBagConstraints gbc_warantyPeriodTextField = new GridBagConstraints();
		gbc_warantyPeriodTextField.insets = new Insets(0, 0, 5, 0);
		gbc_warantyPeriodTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_warantyPeriodTextField.gridx = 6;
		gbc_warantyPeriodTextField.gridy = 9;
		contentPane.add(warantyPeriodTextField, gbc_warantyPeriodTextField);
		
		lblDeliveryConfirmationFile = new JLabel("Delivery Confirmation File");
		GridBagConstraints gbc_lblDeliveryConfirmationFile = new GridBagConstraints();
		gbc_lblDeliveryConfirmationFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeliveryConfirmationFile.gridx = 0;
		gbc_lblDeliveryConfirmationFile.gridy = 10;
		contentPane.add(lblDeliveryConfirmationFile, gbc_lblDeliveryConfirmationFile);
		
		confirmationFileTextField = new JTextField();
		confirmationFileTextField.setColumns(15);
		GridBagConstraints gbc_confirmationFileTextField = new GridBagConstraints();
		gbc_confirmationFileTextField.insets = new Insets(0, 0, 5, 5);
		gbc_confirmationFileTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_confirmationFileTextField.gridx = 2;
		gbc_confirmationFileTextField.gridy = 10;
		contentPane.add(confirmationFileTextField, gbc_confirmationFileTextField);
		
		lblWarrantyExpiry = new JLabel("Warranty Expiry");
		GridBagConstraints gbc_lblWarrantyExpiry = new GridBagConstraints();
		gbc_lblWarrantyExpiry.anchor = GridBagConstraints.WEST;
		gbc_lblWarrantyExpiry.insets = new Insets(0, 0, 5, 5);
		gbc_lblWarrantyExpiry.gridx = 4;
		gbc_lblWarrantyExpiry.gridy = 10;
		contentPane.add(lblWarrantyExpiry, gbc_lblWarrantyExpiry);
		
		warantyExpiryTextField = new JTextField();
		warantyExpiryTextField.setColumns(15);
		GridBagConstraints gbc_warantyExpTextField = new GridBagConstraints();
		gbc_warantyExpTextField.insets = new Insets(0, 0, 5, 0);
		gbc_warantyExpTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_warantyExpTextField.gridx = 6;
		gbc_warantyExpTextField.gridy = 10;
		contentPane.add(warantyExpiryTextField, gbc_warantyExpTextField);
		
		IBInvoiceDate = new JLabel("Invoice Date");
		GridBagConstraints gbc_IBInvoiceDate = new GridBagConstraints();
		gbc_IBInvoiceDate.anchor = GridBagConstraints.WEST;
		gbc_IBInvoiceDate.insets = new Insets(0, 0, 5, 5);
		gbc_IBInvoiceDate.gridx = 4;
		gbc_IBInvoiceDate.gridy = 11;
		contentPane.add(IBInvoiceDate, gbc_IBInvoiceDate);
		
		invoiceDateTextField = new JTextField();
		invoiceDateTextField.setColumns(15);
		GridBagConstraints gbc_invoiceDateTextField = new GridBagConstraints();
		gbc_invoiceDateTextField.insets = new Insets(0, 0, 5, 0);
		gbc_invoiceDateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_invoiceDateTextField.gridx = 6;
		gbc_invoiceDateTextField.gridy = 11;
		contentPane.add(invoiceDateTextField, gbc_invoiceDateTextField);
		
		IBInvoiceNumber = new JLabel("Invoice Number");
		GridBagConstraints gbc_IBInvoiceNumber = new GridBagConstraints();
		gbc_IBInvoiceNumber.anchor = GridBagConstraints.WEST;
		gbc_IBInvoiceNumber.insets = new Insets(0, 0, 5, 5);
		gbc_IBInvoiceNumber.gridx = 4;
		gbc_IBInvoiceNumber.gridy = 12;
		contentPane.add(IBInvoiceNumber, gbc_IBInvoiceNumber);
		
		InvoiceNumTextField = new JTextField();
		InvoiceNumTextField.setColumns(15);
		GridBagConstraints gbc_InvoiceNumTextField = new GridBagConstraints();
		gbc_InvoiceNumTextField.insets = new Insets(0, 0, 5, 0);
		gbc_InvoiceNumTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_InvoiceNumTextField.gridx = 6;
		gbc_InvoiceNumTextField.gridy = 12;
		contentPane.add(InvoiceNumTextField, gbc_InvoiceNumTextField);
		
		IBsalesOrderNumber = new JLabel("Sales Order Number");
		GridBagConstraints gbc_IBsalesOrderNumber = new GridBagConstraints();
		gbc_IBsalesOrderNumber.anchor = GridBagConstraints.WEST;
		gbc_IBsalesOrderNumber.insets = new Insets(0, 0, 5, 5);
		gbc_IBsalesOrderNumber.gridx = 4;
		gbc_IBsalesOrderNumber.gridy = 13;
		contentPane.add(IBsalesOrderNumber, gbc_IBsalesOrderNumber);
		
		salesTextField = new JTextField();
		salesTextField.setColumns(15);
		GridBagConstraints gbc_salesTextField = new GridBagConstraints();
		gbc_salesTextField.insets = new Insets(0, 0, 5, 0);
		gbc_salesTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_salesTextField.gridx = 6;
		gbc_salesTextField.gridy = 13;
		contentPane.add(salesTextField, gbc_salesTextField);
		
		lblItemSku = new JLabel("Item SKU");
		GridBagConstraints gbc_lblItemSku = new GridBagConstraints();
		gbc_lblItemSku.anchor = GridBagConstraints.WEST;
		gbc_lblItemSku.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemSku.gridx = 4;
		gbc_lblItemSku.gridy = 14;
		contentPane.add(lblItemSku, gbc_lblItemSku);
		
		itemSKUTextField = new JTextField();
		itemSKUTextField.setColumns(15);
		GridBagConstraints gbc_itemSKUTextField = new GridBagConstraints();
		gbc_itemSKUTextField.insets = new Insets(0, 0, 5, 0);
		gbc_itemSKUTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_itemSKUTextField.gridx = 6;
		gbc_itemSKUTextField.gridy = 14;
		contentPane.add(itemSKUTextField, gbc_itemSKUTextField);
		GridBagConstraints gbc_submit = new GridBagConstraints();
		gbc_submit.gridwidth = 3;
		gbc_submit.insets = new Insets(0, 0, 0, 5);
		gbc_submit.gridx = 2;
		gbc_submit.gridy = 16;
		contentPane.add(submit, gbc_submit);
		
		this.setVisible(true);
	}
	
	class ButtonListener implements ActionListener {
		private NewOrderWindow newOrderWindow;
		
		ButtonListener(NewOrderWindow newOrderWindow) {
			this.newOrderWindow = newOrderWindow;
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Submit")) {
				try {
					submitNewOrder();
				} catch (Exception exception){
					JOptionPane.showMessageDialog(newOrderWindow, "Invalid information");
				}
			}
		}
	}
	
	public void submitNewOrder() throws Exception{
		Integer buildID = Integer.parseInt(buildIDTextField.getText());
		if (buildID != null){
			OrderDetails orderDetails = new OrderDetails(buildID);
			
			// get customerInfo parameters from GUI
			CustomerInfo customerInfo = new CustomerInfo();
			String name = nameTextField.getText();
			String email = emailTextField.getText();
			String phoneNumber = phoneNumberTextField.getText();
			String deliverDate = deliverDateTextField.getText();
			
			//customerInfo Setters
			customerInfo.setName(name);
			customerInfo.setEmail(email);
			customerInfo.setPhoneNum(phoneNumber);
			customerInfo.setDeliveryDate(deliverDate);
			orderDetails.setCustomerInfo(customerInfo);
	
			// get paymentInfo parameters from GUI
			PaymentInfo paymentInfo = new PaymentInfo();
			String paymentMethod = paymentMethodTextField.getText();
			Double totalValue = Double.parseDouble(totalValueTextField.getText());
			String deliveryConfirmationFile = confirmationFileTextField.getText();
	
			// paymentInfo setters
			paymentInfo.setPaymentMethod(paymentMethod);
			paymentInfo.setTotalValue(totalValue);
			paymentInfo.setDeliveryConfirmationFile(deliveryConfirmationFile);
			orderDetails.setPaymentInfo(paymentInfo);
	
			// get component parameters from GUI
			ProductInfo productInfo = new ProductInfo();
			String componentType = componentTypeTextField.getText();
			String manufacturer = manufacturerTextField.getText();
			String description = descriptionTextField.getText();
			String modelNum = modelNumTextField.getText();
			String serialNum = serialNumTextField.getText();
			Double rebateValue = Double.parseDouble(rebateValueTextField.getText());
			Double price = Double.parseDouble(priceTextField.getText());
			String warrantyPeriod = warantyPeriodTextField.getText();
			String warrantyExpiry = warantyExpiryTextField.getText();
			String invoiceDate = invoiceDateTextField.getText();
			Integer invoiceNum = Integer.parseInt(InvoiceNumTextField.getText());
			Integer salesOrderNum = Integer.parseInt(salesTextField.getText());
			Integer itemSKU = Integer.parseInt(itemSKUTextField.getText());
			
			// productInfo Setters
			productInfo.setComponentType(componentType);
			productInfo.setComponentType(componentType);
			productInfo.setManufacturer(manufacturer);
			productInfo.setDescription(description);
			productInfo.setModelNum(modelNum);
			productInfo.setSerialNum(serialNum);
			productInfo.setRebateValue(rebateValue);
			productInfo.setPrice(price);
			productInfo.setWarrantyPeriod(warrantyPeriod);
			productInfo.setWarrantyExpiry(warrantyExpiry);
			productInfo.setInvoiceDate(invoiceDate);
			productInfo.setInvoiceNum(invoiceNum);
			productInfo.setSalesOrderNum(salesOrderNum);
			productInfo.setItemSKU(itemSKU);
			
			// add component(s) to orderDetails
			ArrayList<ProductInfo> components = new ArrayList<>();
			components.add(productInfo);
			orderDetails.setComponents(components);
			guiManager.submitNewOrder(orderDetails);
		}
	}
}

