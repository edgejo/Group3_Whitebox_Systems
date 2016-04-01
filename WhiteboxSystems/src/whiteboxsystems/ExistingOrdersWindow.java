package whiteboxsystems;
import java.util.ArrayList;

import orderinfo.CustomerInfo;
import orderinfo.OrderDetails;
import orderinfo.PaymentInfo;
import orderinfo.ProductInfo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ExistingOrdersWindow {
	GUIManager guiManager;
	JFrame mainFrame;
	JPanel orderPanel;
	JPanel buttonPanel;
	JButton Jbutton;
	JTable orderTable;
	JScrollPane scrollTable;
	
	public ExistingOrdersWindow(GUIManager guiManager){
		this.guiManager = guiManager;
	}
	
	// on start and after submitting new order
	public void displayExistingOrders(ArrayList<OrderDetails> existingOrders){
		if (mainFrame != null){
	        mainFrame.setVisible(false);
			mainFrame.dispose();
		}
	
		createButtonPanel();
		createOrderPanel(existingOrders);
		createWindow();
	}
	
    public void createWindow(){
    	//create Frame
        mainFrame = new JFrame("White Box Systems");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout()); 
        
        //add panels to frame
        mainFrame.add(orderPanel, BorderLayout.CENTER);
        mainFrame.add(buttonPanel, BorderLayout.SOUTH);
        
        mainFrame.pack();
        mainFrame.setResizable(true);
        
        // maximize the window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
        mainFrame.setLocationRelativeTo(null);
        
        mainFrame.setVisible(true);
    }
    
    public void createOrderPanel(ArrayList<OrderDetails> existingOrders){
		//Order Panel
        orderPanel = new JPanel();
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.X_AXIS));
        orderPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        orderPanel.setBorder(BorderFactory.createTitledBorder("Order Details"));
        
        //Order Table
        String colName[] = {"BuildID", "Name", "Email", "Phone Number", "Address", "Delivery Date", 
        					"Payment Method", "Total Value", "Delivery Confimation", "Component Type", 
        					"Manufacturer", "Description", "Model Number", "Serial Number", "Rebate Value", 
        					"Price", "Warranty Period", "Warranty Expiry", "Invoice Date", "Invoice Number",
        					"Sales Order Number", "Item SKU"};
        
        DefaultTableModel tableModel = new DefaultTableModel(colName, 0);

        // get orderDetails parameters
        for (OrderDetails orderDetails: existingOrders){
         // for (int i = 0; i < orderDetails.getComponents().size(); i++) {	
        	Integer buildID = orderDetails.getBuildID();
        	CustomerInfo customerInfo = orderDetails.getCustomerInfo();
        	PaymentInfo paymentInfo = orderDetails.getPaymentInfo();
        	ArrayList<ProductInfo> components = (ArrayList<ProductInfo>) orderDetails.getComponents();
        	
        	String name = customerInfo.getName();
        	String email = customerInfo.getEmail();
        	String phoneNum = customerInfo.getPhoneNum();
        	String address = customerInfo.getAddress();
        	String deliveryDate = customerInfo.getDeliveryDate();
        	String paymentMethod = paymentInfo.getPaymentMethod();
        	Double totalValue = paymentInfo.getTotalValue();
        	String deliveryConfirmaionFile = paymentInfo.getDeliveryConfirmationFile();
        	
        	String componentType = "";
        	String manufacturer = "";
        	String description = "";
        	String modelNum = "";
        	String serialNum = "";
        	Double rebateValue = 0.0;
        	Double price = 0.0;
        	String warrantyPeriod = "";
        	String warrantyExpiry = "";
        	String invoiceDate = "";
        	Integer invoiceNum = 0;
        	Integer saleOrderNum = 0;
        	Integer itemSKU = 0;
        	
        	if (!components.isEmpty()){
	        	//ProductInfo component = components.get(i);
        		ProductInfo component = components.get(0);
        		componentType = component.getComponentType();
	        	manufacturer = component.getManufacturer();
	        	description = component.getDescription();
	        	modelNum = component.getModelNum();
	        	serialNum = component.getSerialNum();
	        	rebateValue = component.getRebateValue();
	        	price = component.getPrice();
	        	warrantyPeriod = component.getWarrantyPeriod();
	        	warrantyExpiry = component.getWarrantyExpiry();
	        	invoiceDate = component.getInvoiceDate();
	        	invoiceNum = component.getInvoiceNum();
	        	saleOrderNum = component.getSalesOrderNum();
	        	itemSKU = component.getItemSKU();
        	}
        	
        	Object[] row = {buildID, name, email, phoneNum, address, deliveryDate, paymentMethod, totalValue, 
        					deliveryConfirmaionFile, componentType, manufacturer, description, modelNum, 
        					serialNum, rebateValue, price, warrantyPeriod, warrantyExpiry, invoiceDate, 
        					invoiceNum, saleOrderNum, itemSKU
        					};
        	tableModel.addRow(row);
          //}
        }

        orderTable = new JTable(tableModel);
        orderTable.setPreferredScrollableViewportSize(new Dimension(500,80));
        orderTable.setFillsViewportHeight(true);
        scrollTable = new JScrollPane( orderTable );
        orderPanel.add(scrollTable);
    }
    
    public void createButtonPanel(){
    	buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
    	Jbutton = new JButton("Create Order");
    	Jbutton.addActionListener(new ButtonListener(this));
    	buttonPanel.add(Jbutton);
    }
}

class ButtonListener implements ActionListener {
	private ExistingOrdersWindow viewOrdersWindow;
	
	ButtonListener(ExistingOrdersWindow gui) {
		this.viewOrdersWindow = gui;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Create Order")) {
			this.viewOrdersWindow.guiManager.displayNewOrderWindow();
		}
	}
}
