package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class salaireService implements I<salarie> {

	@Override
	public boolean delete(salarie s) {
		// TODO Auto-generated method stub
		try {
            PreparedStatement ps = connexion.getCn().prepareStatement("delete from entreprise where mat=?");
            ps.setInt(1,s.getMat());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur ");
        }
		return false;
	}

	@Override
	public salarie findByMat(int mat) {
		// TODO Auto-generated method stub
		try {
            String req = "select * from entreprise where mat=" + mat;
            Statement stmt = connexion.getCn().createStatement();
            ResultSet r = stmt.executeQuery(req);
            if (r.next()) {
                return new salarie(r.getInt("mat"), r.getString("nom"), r.getString("email"), r.getDouble("recrutement"), r.getDouble("salairefixe"),r.getString("categorie"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur !");
        }
		return null;
	}

	@Override
	public List<salarie> findAll() {
		// TODO Auto-generated method stub
		  List<salarie> salaries = new ArrayList<>();
	        try {
	            String req = "select * from entreprise";
	            Statement st = connexion.getCn().createStatement();
	            ResultSet r = st.executeQuery(req);
	            while (r.next()) {
	                salaries.add(new salarie(r.getInt("mat"), r.getString("nom"), r.getString("email"), r.getDouble("recrutement"), r.getDouble("salairefixe"),r.getString("categorie")));
	            }
	 
	        } catch (SQLException ex) {
	            System.out.println("Erreur !");
	        }
		return null;
	}
	
	

}
