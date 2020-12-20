package cybersoft.java10.service;

import java.util.ArrayList;
import java.util.List;

import cybersoft.java10.model.Product;

public class ProductService {
	//properties
	public List<Product> productList;
	
	//constructor
	public ProductService() {
		productList = new ArrayList<Product>();
		productList.add(new Product(1, "Tivi LG 24inch", "LG24", "Tivi LG", 300));
		productList.add(new Product(2, "Tivi LG 25inch", "LG25", "Tivi LG", 500));
		productList.add(new Product(3, "Tivi LG 26inch", "LG26", "Tivi LG", 700));
		productList.add(new Product(4, "Tivi LG 27inch", "LG27", "Tivi LG", 1000));
		productList.add(new Product(5, "Tivi LG 28inch", "LG28", "Tivi LG", 550));
		productList.add(new Product(6, "Tivi LG 29inch", "LG29", "Tivi LG", 700));
		productList.add(new Product(7, "Tivi LG 30inch", "LG30", "Tivi LG", 800));
		productList.add(new Product(8, "Tivi LG 31inch", "LG31", "Tivi LG", 900));
		productList.add(new Product(9, "Tivi LG 32inch", "LG32", "Tivi LG", 1200));

	}
	
	//method
	public List<Product> getAllProduct(){
		return productList;
	}
	
	public boolean add(Product product) {
		if ("".equals(product.name) || "".equals(product.code) || 0 == product.id || 0 == product.price)
			return false;
		if (loop(product.id))
			return false;
		return productList.add(product);
	}
	
	private boolean loop(int id) {
		// check loop 
		for (Product product : productList) {
			if (product.getId() == id) 
				return true;
				break;
			
				
		}
		
		return false;
	}

	public boolean remove(int id) {
		for (Product product : productList) {
			if (product.id == id) {
				productList.remove(product);
				return true;
			}
		}
		//nếu k thấy id return fasle
		return false;
	}
	
	public void update(int id, Product productEdit) {
		for (int i = 0; i < productList.size(); i++) {
			if(productList.get(i).id != id)
				continue;
			// when product's id equals param id
			productList.set(i, productEdit);
		}
	}

}
