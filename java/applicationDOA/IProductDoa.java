package applicationDOA;

import java.util.List;

import metier.Product;

// CRUD 

public interface IProductDoa {
	public Product save(Product p) ; // save product to db
	
	public Product searchById(int id) ; // search product by its id 
	
	public List<Product> searchByName(String name) ; // search product by name
	
	public boolean deleteProduct(int idProduct) ; // delete product 
	
	public Product updateProduct(Product id);  // update 	
	

}
