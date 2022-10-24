package metier;

public class Product {

	private int id ;
	private double price; 
	private String name ;
	private int quantity ;
	
	public Product(double price, String name, int quanity) {
		
		this.price = price;
		this.name = name;
		this.quantity = quanity;
	}
	
	
	public Product() {
	}
	
	// getter and setters 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuanity(int quanity) {
		this.quantity = quanity;
	}
	//
	
	@Override 
	public String toString() {
		return "product [" 
				+"id: " +this.id +","
				+"name: " +this.name +","
				+ "price: " +this.price +"," 
				+ "quantity: " +this.quantity +"]";
	}
	
	
}
