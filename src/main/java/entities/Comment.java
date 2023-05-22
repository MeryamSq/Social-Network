package entities;

public class Comment {
	private int id_cmt;
	private int id_user;
	private int id_post;
	private String contenu;
	public Comment() {
		super();
	}
	public Comment(int id_cmt, int id_user, int id_post, String contenu) {
		super();
		this.id_cmt = id_cmt;
		this.id_user = id_user;
		this.id_post = id_post;
		this.contenu = contenu;
	}
	public int getId_cmt() {
		return id_cmt;
	}
	public void setId_cmt(int id_cmt) {
		this.id_cmt = id_cmt;
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
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	

}
