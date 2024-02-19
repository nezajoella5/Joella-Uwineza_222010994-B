package Customerform;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Customerform implements ActionListener {
	

	JFrame frame;
	JLabel cid_lb=new JLabel("customerid");
	JLabel fname_lb=new JLabel("firstname");
	JLabel lname_lb=new JLabel("lastname");
	JLabel gn_lb=new JLabel("gender");
	JLabel eml_lb=new JLabel("email");

	JTextField cid_txf=new JTextField();
	JTextField fname_txf=new JTextField();
	JTextField lname_txf=new JTextField();
	JTextField gn_txf=new JTextField();
	JTextField eml_txf=new JTextField();

	//String []gender={"Male", "Female"};
	//JComboBox<String> genderBox = new JComboBox<>(gender);

	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public Customerform() {
		createForm();
		actionEvent();
		setFontforall();
		addComponentToFrame();
		setLocationandSize();
	}
	private void actionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_tbtn.addActionListener(this);
		delete_btn.addActionListener(this);
		//genderBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("CUSTOMER FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.blue);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		cid_lb.setBounds(10, 10, 130, 30);
		fname_lb.setBounds(10, 50, 150, 30);
		lname_lb.setBounds(10, 90, 150, 30);
		gn_lb.setBounds(10, 130, 100, 30);
		eml_lb.setBounds(10, 170, 100, 30);
		//ContactNmbr_lb.setBounds(10, 210, 170, 30);
		//gender_lb.setBounds(10, 250, 100, 30);
		
		cid_txf.setBounds(200, 10, 170, 30);
		fname_txf.setBounds(200, 50, 170, 30);
		lname_txf.setBounds(200, 90, 170, 30);
		gn_txf.setBounds(200, 130, 170, 30);
		eml_txf.setBounds(200, 170, 170, 30);
		//Email_txf.setBounds(200, 210, 170, 30);
		//genderBox.setBounds(200, 250, 170, 30);
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		cid_lb.setFont(font);
		fname_lb.setFont(font);
		lname_lb.setFont(font);
		gn_lb.setFont(font);
		eml_lb.setFont(font);
		//Email_lb.setFont(font);
		//genderBox.setFont(font);

		cid_txf.setFont(font);
		fname_txf.setFont(font);
		lname_txf.setFont(font);
		gn_txf.setFont(font);
		eml_txf.setFont(font);
	
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(cid_lb);
		frame.add(fname_lb);
		frame.add(lname_lb);
		frame.add(gn_lb);
		frame.add(eml_lb);
		
		frame.add(cid_txf);
		frame.add(fname_txf);
		frame.add(lname_txf);
		frame.add(gn_txf);
		frame.add(eml_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	

}
