package application;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;




public class ControllerService implements Initializable{
	
	   @FXML
		private Button supp;
		@FXML
		private Button add;
		@FXML
		private Button edit;
		@FXML
		private Button importBt;
		@FXML
		private Button ExportBt;
		@FXML
		private Button select;
	
	
	@FXML
	TextField inputMat;
    
	@FXML 
	TextField inputnom ;
	
	@FXML 
	TextField inputemail ;
	
	@FXML
	TextField inputrecrutement ;
	
	@FXML 
	TextField inputcategorie ;
	
	@FXML 
	TextField inputsalaire ;

    @FXML
    private TableView <salarie> table;
    @FXML
    private TableColumn<salarie,Integer> mat;
    @FXML
    private TableColumn<salarie,String> nom;
    @FXML
    private TableColumn <salarie,String> email;
    @FXML
    private TableColumn<salarie,Double> recrutement;
    @FXML
    private TableColumn <salarie,Double> salairefixe;

    @FXML
    private TableColumn <salarie,String> categorie;
	private sall sal;
	
	salaireService ss = new salaireService();
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	sall  sal=new sall()	 ;
          mat.setCellValueFactory(new PropertyValueFactory<salarie,Integer>("mat"));
          nom.setCellValueFactory(new PropertyValueFactory<salarie,String>("nom"));
          email.setCellValueFactory(new PropertyValueFactory<salarie,String>("email"));
          recrutement.setCellValueFactory(new PropertyValueFactory<salarie,Double>("recrutement"));
          salairefixe.setCellValueFactory(new PropertyValueFactory<salarie,Double>("salairefixe"));
          categorie.setCellValueFactory(new PropertyValueFactory<salarie,String>("categorie"));
    
    }
	
    protected void Ajouter_entreprise()
	{ 
	            String req = "insert into entreprise values ('" + mat.getText() + "', '" + nom.getText()+ "', '" + email.getText() + "', '" + Double.parseDouble(recrutement.getText())+  "', '" + Double.parseDouble(salairefixe.getText())+  "', '" + categorie.getText()+"')";

	            Statement st;
				try {
					st = connexion.getCn().createStatement();
					 st.executeUpdate(req);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				 salarie ss = new salarie (Integer.parseInt(mat.getText()),nom.getText(),email.getText(),Double.parseDouble(salairefixe.getText()),Double.parseDouble(recrutement.getText()),categorie.getText());
			   		sall.getImports().add(ss);
			   		table.getItems().add(ss);
	}
    @FXML
	protected void Supprimer_entreprise()
{ 
		salarie ss = table.getSelectionModel().getSelectedItem();
		table.getItems().remove(ss);
	        ss.delete(ss.findByMa(ss.getMat()));
}
	
	@FXML
	protected void ImportSalarie()
	{ 
		   table.getItems().clear();	  
	 table.getItems().addAll(sal.getImports());

	}

	
	public void select() {
	
	    salarie s = table.getSelectionModel().getSelectedItem();
        mat.setText(String.valueOf(s.getMat()));
        nom.setText(s.getNom());
        email.setText(s.getEmail());
        recrutement.setText(String.valueOf(s.getSalairefixe()));
        salairefixe.setText(String.valueOf(s.getSalairefixe()));
        categorie.setText(s.getCategorie());
        table.getItems().remove(s);
	}
	
	public void update() {  
		
	    String req = "update entreprise set nom ='"+nom.getText()+"', email ='"+email.getText()+"',salaire ='"+ Double.parseDouble(recrutement.getText())+"' , recrutement ='"+Double.parseDouble(salairefixe.getText())+"',categorie ='"+categorie.getText()+"' where matricule = "+mat.getText();
        try {
			Statement st = connexion.getCn().createStatement();
			 st.executeUpdate(req);
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	 
        salarie s = new salarie (Integer.parseInt(mat.getText()),nom.getText(),email.getText(),Double.parseDouble(salairefixe.getText()),Double.parseDouble(recrutement.getText()),categorie.getText());
   		sal.getImports().add(s);
   		table.getItems().add(s);
	}
	
	@FXML
	protected void ExportSalarie()
	{ 
	 table.getItems().addAll(sal.getExports());
	 FileWriter writer = null;
	try {
		writer = new FileWriter("Liste_Salarie.txt");
	} catch (IOException e1) {
		e1.printStackTrace();
	} 
	 for(salarie sl: sal.getImports()) {
	   try {
		writer.write(sl + System.lineSeparator());
	} catch (IOException e) {
		e.printStackTrace();
	}
	 }
	
	}

	}




