package application;

public class vendeurs extends salarie{
	private double vente ;
	private double pourcentage ;


	public vendeurs(int mat, String nom, String email, double recrutement, double salairefixe, String categorie,
			double vente, double pourcentage) {
		super(mat, nom, email, recrutement, salairefixe, categorie);
		this.vente = vente;
		this.pourcentage = pourcentage;
	}
	public double getVente() {
		return vente;
	}
	public void setVente(double vente) {
		this.vente = vente;
	}
	public double getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(double pourcentage) {
		this.pourcentage = this.vente * 0.2;
	}
	public void setsalairefixe () {
		if (this.getRecrutement()<=2005) {
			this.salairefixe = 400 + this.pourcentage;
		}else {
			this.salairefixe = 280 + this.pourcentage;
		}
	}

}
