package whiteboxsystems;
import java.util.ArrayList;
import orderinfo.OrderDetails;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
		createOrderPanel();
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
    
    public void createOrderPanel(){
		//Order Panel
        orderPanel = new JPanel();
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.X_AXIS));
        orderPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        orderPanel.setBorder(BorderFactory.createTitledBorder("Order Details"));
        
       //Order Table
      //TODO import fields from OrderDetails
        String colName[] = {"BuildID", "Name", "Email", "Phone Number"}; 
        String rowValue[][] = 
        	{
        			{"1234", "Ahmed Omar", "ahmed@gmail.com", "6138545975"},
        			{"1243", "Gaith Dalla-Ali", "ghaith@gmail.com", "61385552468"},
        			{"2222", "Hassain Saeed", "hussain@gmail.com", "6135478596"},
        			{"6984", "Jordan Edgecombe", "jordan@gmail.com", "6135874963"},
        	};
        orderTable = new JTable( rowValue, colName );
        orderTable.setPreferredScrollableViewportSize(new Dimension(500,80));
        orderTable.setFillsViewportHeight(true);
        scrollTable = new JScrollPane( orderTable );
        orderPanel.add(scrollTable);
    }
    
    public void createButtonPanel(){
    	buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
    	Jbutton = new JButton("Create Order");
    	Jbutton.addActionListener(new ButtonListener());
    	buttonPanel.add(Jbutton);
    }

    
	// on pressing "New Order" on displayExistingOrders view
	public void displayNewOrderForm(){
		// TODO display form with empty fields
		// TODO create button "Submit New Order" that calls submitNewOrderForm()
	}
	
	// on pressing "Submit New Order" button
	public void submitNewOrderForm(){
		// TODO populate orderDetails from fields in displayNewOrderForm
		OrderDetails orderDetails = new OrderDetails(-1);
		databaseController.createNewOrder(orderDetails);
	}
}

class ButtonListener implements ActionListener {
	  ButtonListener() {
	  }

	  public void actionPerformed(ActionEvent e) {
	    if (e.getActionCommand().equals("Create Order")) {
	      NewOrder order = new NewOrder();
	      order.setVisible(true);
	  }
	}
}
