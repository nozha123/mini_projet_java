package application;

import java.util.Map;
import java.util.TreeMap;

public class entreprise {
	public int id ;
	String nomentreprise;
	double Salaire;
	Map <Integer, salarie> sal= new TreeMap<Integer,salarie>();
	public String getNomE() {
		return nomentreprise;
	}
	
    
	public String getNomentreprise() {
		return nomentreprise;
	}


	public void setNomentreprise(String nomentreprise) {
		this.nomentreprise = nomentreprise;
	}


	public Map<Integer, salarie> getSal() {
		return sal;
	}


	public void setSal(Map<Integer, salarie> sal) {
		this.sal = sal;
	}


	public double getSalaire() {
		return Salaire;
	}
	public void setSalaire(double salaire) {
		Salaire = salaire;
	}
	public Map<Integer, salarie> getSalarié() {
		return sal;
	}
	public void setSalaire(Map<Integer, salarie> sal) {
		this.sal = sal;
	}
	public entreprise(int id ,String nomentreprise) {
		this.id=id ;
		this.nomentreprise = nomentreprise;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}  


}
