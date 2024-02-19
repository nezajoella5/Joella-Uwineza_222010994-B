package Myaddressform;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Myorderform.Orderform;
import myaddress.address;

public class Addressform implements ActionListener{
	JFrame frame;
	JLabel addid_lb=new JLabel("addressid");
	JLabel cid_lb=new JLabel("customerid");
	JLabel ct_lb=new JLabel("city");
	JLabel cy_lb=new JLabel("country");

	JTextField addid_txf=new JTextField();
	JTextField cid_txf=new JTextField();
	JTextField ct_txf=new JTextField();
	JTextField cy_txf=new JTextField();

	//String []gender={"Male", "Female"};
	//JComboBox<String> genderBox = new JComboBox<>(gender);

	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public Addressform() {
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
		frame.setTitle("ADDRESS FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.yellow);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		addid_lb.setBounds(10, 10, 130, 30);
		cid_lb.setBounds(10, 50, 150, 30);
		ct_lb.setBounds(10, 90, 150, 30);
		cy_lb.setBounds(10, 130, 150, 30);
		//ContactNmbr_lb.setBounds(10, 210, 170, 30);
		//gender_lb.setBounds(10, 250, 100, 30);
		
		addid_txf.setBounds(200, 10, 170, 30);
		cid_txf.setBounds(200, 50, 170, 30);
		ct_txf.setBounds(200, 90, 170, 30);
		cy_txf.setBounds(200, 130, 170, 30);
		//Email_txf.setBounds(200, 210, 170, 30);
		//genderBox.setBounds(200, 250, 170, 30);
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 10, 600, 240);

		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		addid_lb.setFont(font);
		cid_lb.setFont(font);
		ct_lb.setFont(font);
		cy_lb.setFont(font);
		//Email_lb.setFont(font);
		//genderBox.setFont(font);

		addid_txf.setFont(font);
		cid_txf.setFont(font);
		ct_txf.setFont(font);
		cy_txf.setFont(font);
		
	
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(addid_lb);
		frame.add(cid_lb);
		frame.add(ct_lb);
		frame.add(cy_lb);
		
		frame.add(addid_txf);
		frame.add(cid_txf);
		frame.add(ct_txf);
		frame.add(cy_txf);
		
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		address add=new address();
		if(e.getSource()==insert_btn) {
			add.setCustomerid(cid_txf.getText());
			add.setCity(ct_txf.getText());
			add.setCountry(cy_txf.getText());
			add.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("addressid");
            model.addColumn("customerid");
            model.addColumn("city");
            model.addColumn("country");
           
            ResultSet resultSet =address.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(addid_txf.getText());
	    	add.setCustomerid(cid_txf.getText());
			add.setCity(ct_txf.getText());
			add.setCountry(cy_txf.getText());
			
			add.update(id);
	    }
	  else {
			int id=Integer.parseInt(addid_txf.getText());
			add.delete(id);}

	  }		
		public static void main(String[] args) {
			Addressform add=new Addressform();
			System.out.println(add);
		
			
		}

	}