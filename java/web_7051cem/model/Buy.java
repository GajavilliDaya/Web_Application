package web_7051cem.model;

public class Buy extends Product_Details{
	
	private int o_id,u_id,quan;
	private String date;
	
	public Buy(int id, String name, String category, String img, double price, int o_id, int u_id, int quan,
			String date) {
		super(id, name, category, img, price);
		this.o_id = o_id;
		this.u_id = u_id;
		this.quan = quan;
		this.date = date;
	}
	
	
	public Buy() { }


	public Buy(int id, String name, String category, String img, double price, int u_id, int quan, String date) {
		super(id, name, category, img, price);
		this.u_id = u_id;
		this.quan = quan;
		this.date = date;
	}

	public Buy(int id, String name, String category, String img, double price) {
		super(id, name, category, img, price);
	}

	@Override
	public String toString() {
		return "Buy [o_id=" + o_id + ", u_id=" + u_id + ", quan=" + quan + ", date=" + date + "]";
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getQuan() {
		return quan;
	}

	public void setQuan(int quan) {
		this.quan = quan;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
