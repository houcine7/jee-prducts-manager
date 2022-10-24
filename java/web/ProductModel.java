package web;

import java.util.List;

import metier.Product;

public class ProductModel {
	
	private String keyWord ;
	private List<Product> products  ;
	
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
