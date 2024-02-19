package Myproduct;

public class product {
private int productid;
private String productname;
private int price;
public product(int productid,String productname,int price) {
	super ();
	this.productid=productid;
	this.productname=productname;
	this.price=price;	
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}



}
