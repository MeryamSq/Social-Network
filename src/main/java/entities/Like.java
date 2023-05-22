package entities;

public class Like {
	private int id_like;
	private int id_user;
	private int id_post;
	public Like() {
		super();
	}
	public Like(int id_like, int id_user, int id_post) {
		super();
		this.id_like = id_like;
		this.id_user = id_user;
		this.id_post = id_post;
	}
	public int getId_like() {
		return id_like;
	}
	public void setId_like(int id_like) {
		this.id_like = id_like;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_post() {
		return id_post;
	}
	public void setId_post(int id_post) {
		this.id_post = id_post;
	}
	
	
	

}
