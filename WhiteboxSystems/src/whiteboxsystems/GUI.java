package whiteboxsystems;
import java.util.ArrayList;
import java.util.Collection;

import orderinfo.CustomerInfo;
import orderinfo.OrderDetails;
import orderinfo.PaymentInfo;
import orderinfo.ProductInfo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import javax.swing.event.*;


public class GUI {
	
	DatabaseController databaseController;
	JFrame mainFrame;
	JPanel orderPanel;
	JPanel buttonPanel;
	JButton Jbutton;
	JTable orderTable;
	JScrollPane scrollTable;
	
	public GUI(DatabaseController databaseController){
		this.databaseController = databaseController;

	}
	
	// on start and after submitting new order
	public void displayExistingOrders(ArrayList<OrderDetails> existingOrders){
		// TODO display existingOrders in swing
		// TODO create button "New Order" that calls displayNewOrderForm()
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
        mainFrame.add(orderPanel, BorderLayout.NORTH);
        mainFrame.add(buttonPanel, BorderLayout.SOUTH);
        
        mainFrame.pack();
        mainFrame.setResizable(true);
        mainFrame.setVisible(true);
    }
    
    public void createOrderPanel(ArrayList<OrderDetails> existingOrders){
		//Order Panel
        orderPanel = new JPanel();
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.X_AXIS));
        orderPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        orderPanel.setBorder(BorderFactory.createTitledBorder("Order Details"));
        
       //Order Table
      //TODO import fields from OrderDetails
        String colName[] = {"BuildID", "Name", "Email", "Phone Number", "Address", "Deliver Date", "Payment Method", "Total Value", "Delivery Confimation"
        						, "Component Type", "Manufacturer", "Description", "Model Number", "Serial Number", "Rebate Value", "Price", "Warranty Period",
        						"Warranty Expiry", "Invoice Date", "Invoice Number", "Sales Order Number", "Item SKU"
        					}; 
        DefaultTableModel tableModel = new DefaultTableModel(colName, 0);

        for (OrderDetails orderDetails: existingOrders){
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
        	
        	if(!components.isEmpty()){
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
        	Object[] row = {buildID, name, email, phoneNum, address, deliveryDate, paymentMethod, totalValue, deliveryConfirmaionFile,
        					componentType, manufacturer, description, modelNum, serialNum, rebateValue, price, warrantyPeriod, 
        					warrantyExpiry, invoiceDate, invoiceNum, saleOrderNum, itemSKU
        					};
        	tableModel.addRow(row);
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
    
	// on pressing "New Order" on displayExistingOrders view
	public void displayNewOrderForm(){
		// TODO display form with empty fields
		// TODO create button "Submit New Order" that calls submitNewOrderForm()
	}
	

}

class ButtonListener implements ActionListener {
	private GUI gui;
	
	ButtonListener(GUI gui) {
		this.gui = gui;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Create Order")) {
			NewOrder order = new NewOrder(gui.databaseController);
			order.setVisible(true);
		}
	}
}
