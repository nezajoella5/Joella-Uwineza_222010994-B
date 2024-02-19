package Myfeedbackform;

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

import feedback1.feedback;

public  class Feedbackform implements ActionListener{

	JFrame frame;
	JLabel fbid_lb=new JLabel("feedbackid");
	JLabel cid_lb=new JLabel("customerid");
	JLabel cm_lb=new JLabel("comments");
	JLabel dt_lb=new JLabel("date");


	JTextField fbid_txf=new JTextField();
	JTextField cid_txf=new JTextField();
	JTextField cm_txf=new JTextField();
	JTextField dt_txf=new JTextField();
	

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
	public Feedbackform() {
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
		frame.setTitle("FEEDBACK FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.green);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		fbid_lb.setBounds(10, 10, 130, 30);
		cid_lb.setBounds(10, 50, 150, 30);
		cm_lb.setBounds(10, 90, 150, 30);
		dt_lb.setBounds(10, 130, 150, 30);
		//ContactNmbr_lb.setBounds(10, 210, 170, 30);
		//gender_lb.setBounds(10, 250, 100, 30);
		
		fbid_txf.setBounds(200, 10, 170, 30);
		cid_txf.setBounds(200, 50, 170, 30);
		cm_txf.setBounds(200, 90, 170, 30);
		dt_txf.setBounds(200, 130, 170, 30);
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

		fbid_lb.setFont(font);
		cid_lb.setFont(font);
		cm_lb.setFont(font);
		dt_lb.setFont(font);
		//Email_lb.setFont(font);
		//genderBox.setFont(font);

		fbid_txf.setFont(font);
		cid_txf.setFont(font);
		cm_txf.setFont(font);
		dt_txf.setFont(font);
		
	
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(fbid_lb);
		frame.add(cid_lb);
		frame.add(cm_lb);
		frame.add(dt_lb);
		
		frame.add(fbid_txf);
		frame.add(cid_txf);
		frame.add(cm_txf);
		frame.add(dt_txf);
		
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		feedback fdb=new feedback();
		if(e.getSource()==insert_btn) {
			fdb.setCustomerid(cid_txf.getText());
			fdb.setComments(cm_txf.getText());
			fdb.setDate(dt_txf.getText());
			fdb.insertData();

		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("feedbackid");
            model.addColumn("customerid");
            model.addColumn("comments");
            model.addColumn("date");
           
            ResultSet resultSet =feedback.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),resultSet.getString(6), resultSet.getString(7)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(fbid_txf.getText());
	    	fdb.setCustomerid(cid_txf.getText());
			fdb.setComments(cm_txf.getText());
			fdb.setDate(dt_txf.getText());
			
			
			fdb.update(id);
	    }
	  else {
			int id=Integer.parseInt(fbid_txf.getText());
			fdb.delete(id);}

	  }	
		public static void main(String[] args) {
			Feedbackform fdb=new Feedbackform();
			System.out.println(fdb);
		
			
		}

	}
	
	




