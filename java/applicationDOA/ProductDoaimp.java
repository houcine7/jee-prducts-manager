package applicationDOA;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Product;





public class ProductDoaimp implements IProductDoa{
	
	
	
	// save a given product to db 
	@Override
	public Product save(Product p) {
		Connection con =CreateConnection.getConnection() ;
		
		//get product info 
		String name =p.getName() ;
		int quantity =p.getQuantity() ;
		double price = p.getPrice() ;
		
		// sql query 
		String sqlQuery ="INSERT INTO products(name,quantity,prix) VALUES(?,?,?)" ;
		
		
		try {
			// insert product in db 
			PreparedStatement ps =(PreparedStatement) con.prepareStatement(sqlQuery) ;
			ps.setString(1, name);
			ps.setInt(2, quantity);
			ps.setDouble(3, price);
			ps.executeUpdate() ;
			ps.close();
			
			//get this product id 
			String sqlQuery1 ="SELECT MAX(id) as idproduct FROM products" ;
			PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sqlQuery1) ;
			ResultSet result =ps1.executeQuery() ;
			
			// only one table row 
			if(result.next()) {
				int idProduct = result.getInt("idproduct") ;
				p.setId(idProduct);
			}
			return p;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return null ;
		}
		
	}

	// find an element by its id 
	@Override
	public Product searchById(int id) {
		try {
			Connection con =CreateConnection.getConnection() ;
			String querySQL ="SELECT * FROM products WHERE id=?" ;
			PreparedStatement ps =con.prepareStatement(querySQL) ;
			
			ps.setInt(1, id);
			ResultSet rs =ps.executeQuery() ;
			
			if(rs.next()) {
				Product p =new Product() ;
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("prix"));
				p.setQuanity(rs.getInt("quantity"));
				return p ;
			}
			return null; 
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
			
		}
	
	}

	
	// get elements by name 
	@Override
	public List<Product> searchByName(String name) {
		try {
			List<Product> products=new ArrayList<Product>() ;
			String querySQL ="SELECT * FROM products where name LIKE ?" ;
			//
			Connection con =CreateConnection.getConnection();
			PreparedStatement ps =con.prepareStatement(querySQL) ;
			ps.setString(1, name);
			ResultSet rs =ps.executeQuery() ;
			
			
			while(rs.next()) {
				Product p =new 
						Product(rs.getDouble("prix") ,rs.getString("name") ,rs.getInt("quantity")) ;
				p.setId(rs.getInt("id"));
				products.add(p) ;
			}
			return products ;
		}catch(SQLException e) {
			System.out.println(e.getMessage()) ;
			return null ;	
		}
	}

	
	// delete product from db
	@Override
	public boolean deleteProduct(int idProduct) {
		try {
			Connection con = CreateConnection.getConnection() ;
			String querySQL ="DELETE FROM products WHERE id=?" ;
			
			PreparedStatement ps =con.prepareStatement(querySQL) ;
			
			ps.setInt(1, idProduct);
			ps.executeUpdate() ;
			ps.close();
			return true ;
		}catch(SQLException e) {
			System.out.println(e.getMessage()) ;
			return false ;
		}
		
	}

	
	// update product 
	@Override
	public Product updateProduct(Product p) {
		try {
			Connection con =CreateConnection.getConnection() ;
			String querySQL= "UPDATE products SET name=? ,prix =? ,quantity=? WHERE id=?";
			PreparedStatement ps= con.prepareStatement(querySQL) ;
			
			// query variables 
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity()) ;
			ps.setInt(4, p.getId()) ;
			
			//execute query 
			ps.executeUpdate() ;
			ps.close();
			
			return p ;
		}catch(Exception e) {
			System.out.println(e.getMessage()) ;
			return null ;
		}
	}

}
