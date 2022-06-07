package application;

public class salarie {

	private int mat ;
	private String nom ;
	private  String email ;
	private  double recrutement ;
	protected double salairefixe ;
	protected String categorie ;
	
	
	
	
	

	public salarie(int mat, String nom, String email, double recrutement, double salairefixe, String categorie) {
		
		this.mat = mat;
		this.nom = nom;
		this.email = email;
		this.recrutement = recrutement;
		this.salairefixe = salairefixe;
		this.categorie = categorie;
	}
	
	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getRecrutement() {
		return recrutement;
	}
	public void setRecrutement(double recrutement) {
		this.recrutement = recrutement;
	}

	public double getSalairefixe() {
		return salairefixe;
	}

	public void setSalairefixe(double salairefixe) {
		if (this.getRecrutement() <= 2005) {
			this.salairefixe = 400;
		}
		else {
			this.salairefixe = 280;
		}
	}



	
	
	
	
}
