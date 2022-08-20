package web_7051cem.model;

public class User_Details {
	
	private String Name;
	private int id;
	private String Email;
	private String Password;
	
	public User_Details(int id,String Name, String Email, String Password) {
		super();
		this.Name = Name;
		this.Email = Email;
		this.id=id;
		this.Password = Password;

	}

	public User_Details() {
		super();
	}

	public String getName() {
		return Name;
	}


	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public void setName(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "User_Details [Name=" + Name + ", id=" + id + ", Email=" + Email + ", Password=" + Password + "]";
	}
	
	
	
}
