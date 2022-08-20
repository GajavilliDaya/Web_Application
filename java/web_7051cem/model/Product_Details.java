package web_7051cem.model;

public class Product_Details {
	
	private  int id;
	private String name, category, img;
	private double price;
	
	public Product_Details(int id, String name, String category, String img, double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.img = img;
		this.price = price;
	}
	
	public Product_Details() {
		super();
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Product_Details [id=" + id + ", name=" + name + ", category=" + category + ", img=" + img + ", price="
				+ price + "]";
	}

	public static Product_Details getSingleProduct(int id2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}