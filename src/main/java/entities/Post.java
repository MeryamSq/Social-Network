package entities;


import java.sql.Timestamp;


public class Post {
private int id_post;
private int id_user;
private String desc;
private String body;
private  Timestamp post_time;
private int nbr_like;
private int nbr_cmt;



public Post() {
	super();
}



public Post(int id_post, int id_user, String desc, String body, Timestamp date) {
	super();
	this.id_post = id_post;
	this.id_user = id_user;
	this.desc = desc;
	this.body = body;
	this.post_time=date;
	
}



public int getId_post() {
	return id_post;
}



public void setId_post(int id_post) {
	this.id_post = id_post;
}



public int getId_user() {
	return id_user;
}



public void setId_user(int id_user) {
	this.id_user = id_user;
}



public String getDesc() {
	return desc;
}



public void setDesc(String desc) {
	this.desc = desc;
}



public String getBody() {
	return body;
}



public void setBody(String body) {
	this.body = body;
}







public Timestamp getPost_time() {
	return post_time;
}



public void setPost_time(Timestamp post_time) {
	this.post_time = post_time;
}



public int getNbr_like() {
	return nbr_like;
}



public void setNbr_like(int nbr_like) {
	this.nbr_like = nbr_like;
}



public int getNbr_cmt() {
	return nbr_cmt;
}



public void setNbr_cmt(int nbr_cmt) {
	this.nbr_cmt = nbr_cmt;
}




}
