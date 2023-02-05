package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import controller.Stats;

public class ModeleStats {
	private static Bdd uneBdd = new Bdd("localhost","orange_250_2023","root","");
	
	public static ArrayList<Stats> selectAllInterventionsTech(){
		String requete ="select * from nbinterventionstech";
		
		ArrayList<Stats> lesStats = new ArrayList<Stats>();
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet desResultats = unStat.executeQuery(requete);
				//parcourir des résultats et construire des objets clients
				while(desResultats.next()) {
					Stats uneStats = new Stats(
							desResultats.getString("nom"),
							desResultats.getString("prenom"),
							desResultats.getInt("nb")
							);
					// on ajoute  l'instance client dans l'Arraylist
					lesStats.add(uneStats);
				}
				
				unStat.close();
				uneBdd.seDeconnecter();
			}catch (SQLException exp) {
				System.out.println("Erreur d'execution de : "+ requete);
				
			}
			return lesStats;
		
	}
}
