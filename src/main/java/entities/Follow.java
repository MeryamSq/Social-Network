package entities;



public class Follow {
	private int id_flw;
	private int id_emet;
	private int id_recu;

	private String statu;
	public Follow() {
		super();
	}
	public Follow(int id_flw, int id_emet, int id_recu, String statu) {
		super();
		this.id_flw = id_flw;
		this.id_emet = id_emet;
		this.id_recu = id_recu;
		this.statu = statu;
	}
	public int getId_flw() {
		return id_flw;
	}
	public void setId_flw(int id_flw) {
		this.id_flw = id_flw;
	}
	public int getId_emet() {
		return id_emet;
	}
	public void setId_emet(int id_emet) {
		this.id_emet = id_emet;
	}
	public int getId_recu() {
		return id_recu;
	}
	public void setId_recu(int id_recu) {
		this.id_recu = id_recu;
	}

	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	
	

}
