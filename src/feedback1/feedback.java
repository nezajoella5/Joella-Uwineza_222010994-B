package feedback1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class feedback {
private int feedbackid;
private String customerid;
private String comments;
private String date;
public feedback(  int feedbackid,String customerid,String comments,String date) {
	super();
this.feedbackid=feedbackid;
this.customerid=customerid;
this.comments=comments;
this.date=date;
}
public feedback() {
	// TODO Auto-generated constructor stub
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getFeedbackid() {
	return feedbackid;
}
public void setFeedbackid(int feedbackid) {
	this.feedbackid = feedbackid;
}
public String getCustomerid() {
	return customerid;
}
public void setCustomerid(String customerid) {
	this.customerid = customerid;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}

public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/customer_feedback";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO feedback ( customerid, comments,date) VALUES (?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.customerid);
       preparedStatement.setString(2, this.comments);
       preparedStatement.setString(3, this.date);
       //preparedStatement.setString(6, this.gender);
       
          
        
        // Execute the query
        int rowsAffected = preparedStatement.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
        	System.out.println("Data insert successfully!");
            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to insert data.");
            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }}
 
		public static ResultSet viewData() {
	        String host = "jdbc:mysql://localhost/customer_feedback";
	        String user = "root";
	        String password = "";

	        String sql = "SELECT * FROM feedback";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputfeedbackid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/customer_feedback";
    String user = "root";
    String password = "";

    // SQL query to update data
    String sql = "UPDATE feedback SET  customerid=? comments=? date=?  WHERE feedbackid = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getCustomerid());
          stm.setString(2, this.getComments());
          stm.setString(3, this.getDate());
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(4, inputfeedbackid);
       
        // Execute the update
        int rowsAffected = stm.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully!");
            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to update data. No matching record found.");
            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }   
}
public void delete(int inputfeedbackid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/customer_feedback";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM feedback WHERE  feedbackid =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputfeedbackid); // Assuming there is a column named 'id' for the WHERE clause

        // Execute the delete
        int rowsAffected = pl.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data deleted successfully!");
            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to delete data. No matching record found.");
            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

}
}



