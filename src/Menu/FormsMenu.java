package Menu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Customerform.Customerform;
import Myaddressform.Addressform;
import Mycustomer.Customer;
import Myfeedbackform.Feedbackform;
import Myorderform.Orderform;
import Myproductform.Productform;

public class FormsMenu  extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu customermenu;
    private JMenu feedbackmenu;
    private JMenu ordersmenu;
    private JMenu addressmenu;
    private JMenu productsmenu;
    private JMenu Logoutmenu;
    


	public FormsMenu() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem customerItem;
    private JMenuItem feedbackItem;
    private JMenuItem ordersItem;
    private JMenuItem addressItem;
    private JMenuItem productsItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public FormsMenu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        customermenu = new JMenu("customer");
        feedbackmenu = new JMenu("feedback");
        ordersmenu= new JMenu("orders");
        addressmenu = new JMenu("address ");
        productsmenu = new JMenu("products");
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(customermenu);
        customerItem = new JMenuItem("Customerform");
        customerItem.addActionListener(this);
        
        menuBar.add(feedbackmenu);
        feedbackItem = new JMenuItem("Feedbackform");
        feedbackItem.addActionListener(this);
        
        menuBar.add(ordersmenu);
        ordersItem = new JMenuItem("Orderform");
        ordersItem.addActionListener(this);
        
        menuBar.add(addressmenu);
        addressItem = new JMenuItem("Addressform");
        addressItem.addActionListener(this);
        
        menuBar.add(productsmenu);
        productsItem = new JMenuItem("Productform");
        productsItem.addActionListener(this);

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        customermenu.add(customerItem);
        feedbackmenu.add(feedbackItem);
        ordersmenu.add(ordersItem);
        addressmenu.add(addressItem);
        productsmenu.add(productsItem);
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel with background image
        JPanel dashboardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the image
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\mahoro chany\\Desktop\\New folder\\Bluesky.jpg");
                // Draw the image
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };



        // Initialize dashboard panel
        JPanel dashboardPanel1 = new JPanel();
        dashboardPanel1.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel1.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel1);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customerItem) {
            new Customerform();
        
        } else if (e.getSource() == feedbackItem) {
            new Feedbackform();
        
        } else if (e.getSource() == ordersItem) {
            new Orderform();
       
        } else if (e.getSource() == addressItem) {
           new Addressform();
        
        } else if (e.getSource() == productsItem) {
           new Productform();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormsMenu("TO PROJECT"));
    }
}





