package application;



public class employe extends salarie{
	private double Hsupp ;
	private double PHsupp ;

	



	public employe(int mat, String nom, String email, double recrutement, double salairefixe, String categorie,
			double hsupp, double pHsupp) {
		super(mat, nom, email, recrutement, salairefixe, categorie);
		Hsupp = hsupp;
		PHsupp = pHsupp;
	}
	public double getHsupp() {
		return Hsupp;
	}
	public void setHsupp(Double hsupp) {
		Hsupp = hsupp;
	}
	public double getPHsupp() {
		return PHsupp;
	}
	public void setPHsupp(Double pHsupp) {
		PHsupp = pHsupp;
	}

	public void setSalairefixe () {
		if (this.getRecrutement()<=2005) {
			this.salairefixe = 400 + this.PHsupp;
		}else {
			this.salairefixe = 280 + this.PHsupp;
		}
	}
	@Override
	public String toString() {
		return "employe [Hsupp=" + Hsupp + ", PHsupp=" + PHsupp + ", getMat()=" + getMat() + ", getNom()=" + getNom()
				+ ", getEmail()=" + getEmail() + ", getRecrutement()=" + getRecrutement() + ", getSalairefixe()="
				+ getSalairefixe() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	

}
