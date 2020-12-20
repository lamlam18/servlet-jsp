package cybersoft.java10.model;

public class Product {
	//properties
	public int 	id;
	public	String	name;
	public	String	code;
	public	String	description;
	public	float	price;
	
	//get-set
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	//construction
	public Product() {
		id			=0;
		name		="";
		code		="";
		description	="";
		price		=0;
	}

	public Product(int id, String name, String code, String description, float price) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
		this.price = price;
	}
	
	//methods
	

}
