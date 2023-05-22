package entities;

public class User {
	private int Iduser;
	private String name;
	private String psw;
	private String email;
	private String number;
	private String image;
	
	
	public User() {
		super();
	}


	public User(int iduser, String name, String psw, String email, String number,String image) {
		super();
		Iduser = iduser;
		this.name = name;
		this.psw = psw;
		this.email = email;
		this.number = number;
		this.image=image;
	}


	public int getIduser() {
		return Iduser;
	}


	public void setIduser(int iduser) {
		Iduser = iduser;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPsw() {
		return psw;
	}


	public void setPsw(String psw) {
		this.psw = psw;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	

}
