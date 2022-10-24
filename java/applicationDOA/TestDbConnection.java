package applicationDOA;

import java.sql.Connection;

import metier.Product;

public class TestDbConnection {
	
	public static void main(String[] ar) {
		//Connection con =CreateConnection.getConnection() ;
		ProductDoaimp  pDoa=new ProductDoaimp() ;
		
		
		
		Product myProduct =new Product(300,"aspire 1 acer" ,7) ;
		pDoa.save(myProduct) ; //save method already verified 
		
		
	}

}
