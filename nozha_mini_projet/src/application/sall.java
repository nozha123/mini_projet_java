package application;

import java.util.ArrayList;
import java.util.List;


public class sall {
	private static List<salarie> imports;
	private List<salarie> exports;

    salaireService s= new salaireService();

		public sall() {
			
			 imports= new ArrayList<salarie>();
			 for(salarie s :s.findAll())
				 imports.add(new salarie(s.getMat(),s.getNom(),s.getEmail(),s.getRecrutement(),s.getSalairefixe(),s.getCategorie()));
		
			     exports = new ArrayList<salarie>(); 
		} 
    	
    	
		public static List<salarie> getImports() {
			return imports;
		}


		public void setImports(List<salarie> imports) {
			this.imports = imports;
		}


		public List<salarie> getExports() {
			return exports;
		}


		public void setExports(List<salarie> exports) {
			this.exports.addAll(exports);
			for(salarie p :this.exports)
				System.out.println(p); 
		}


	

}
