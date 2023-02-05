package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import controller.UserSimple;

public class ModeleUserSimple {

	private static Bdd uneBdd = new Bdd("localhost","leveling2","root","");
	
	public static void insertUserSimple(UserSimple unUserSimple) {
		String  requete ="call insertUserSimple('"+unUserSimple.getUserSimplePlateforme()+"',"
				+unUserSimple.getUserSimpleCanModify()+",'"+unUserSimple.getUserNom()+"','"
				+unUserSimple.getUserPrenom()+"','"+unUserSimple.getUserAge()+"','"+unUserSimple.getUserBio()+"','"+unUserSimple.getUserNaissance()+"',"
				+unUserSimple.getUserLevel()+",'"+unUserSimple.getUserPseudo()+"','"+unUserSimple.getUserMail()+"','"
				+unUserSimple.getUserPassword()+"','"+unUserSimple.getUserRole()+"','"+unUserSimple.getUserDateInscription()+"','JAVAImg', null, 'JAVABanner', null );";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur d'execution de : "+requete);
		}
	}
	
	public static ArrayList<UserSimple> selectAllUsersSimples(String mot){
	String requete ="";
	if(mot.equals("")) {
		requete = "select * from tbluserssimple ;";
	}else {
		requete = "select * from tbluserssimple where userNom like '%"+mot+"%' or userPrenom like'%"+mot
				+"%' or userPseudo like '%"+mot+"%' or userMail like '%"+mot+"%';";
	}
		
	ArrayList<UserSimple> lesUsersSimples = new ArrayList<UserSimple>();
	try {
		uneBdd.seConnecter();
		Statement unStat= uneBdd.getMaConnexion().createStatement();
		ResultSet desResultats=unStat.executeQuery(requete);
		//parcourir tous les userSimple et en faire des objets, il faut respecter l'ordre dans le constructeur
		while(desResultats.next()) {
			UserSimple unUserSimple = new UserSimple(
					desResultats.getInt("idUser"),
					desResultats.getInt("userLevel"),
					desResultats.getInt("userSimpleCanModify"),	
					desResultats.getString("userSimplePlateforme"),
					desResultats.getString("userNom"),
					desResultats.getString("userPrenom"),
					desResultats.getString("userAge"),
					desResultats.getString("userBio"),
					desResultats.getString("userPseudo"),
					desResultats.getString("userNaissance"),
					desResultats.getString("userMail"),
					desResultats.getString("userPassword"),
					desResultats.getString("userRole"),
					desResultats.getString("userDateInscription")); 
			lesUsersSimples.add(unUserSimple);
		}
		unStat.close();
		uneBdd.seDeconnecter();
	}catch(SQLException exp) {
		System.out.println("Erreur d'execution de : "+ requete);
	}
	
	return lesUsersSimples;
}
	
	public static void deleteUserSimple(int idUser) {
		String requete = "call deleteUserSimple('"+idUser+"');";
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				unStat.execute(requete);
				unStat.close();
				uneBdd.seDeconnecter();	
			}catch (SQLException exp) {
				System.out.println("Erreur d'execution de : "+ requete);
				
			}
	}
	public static void updateUserSimple(UserSimple unUserSimple) {
		String  requete ="call updateUserSimple("+unUserSimple.getIdUser()+",'"+unUserSimple.getUserSimplePlateforme()+"',"
				+unUserSimple.getUserSimpleCanModify()+",'"+unUserSimple.getUserNom()+"','"
				+unUserSimple.getUserPrenom()+"','"+unUserSimple.getUserAge()+"','"+unUserSimple.getUserBio()+"','"+unUserSimple.getUserNaissance()+"',"
				+unUserSimple.getUserLevel()+",'"+unUserSimple.getUserPseudo()+"','"+unUserSimple.getUserMail()+"','"
				+unUserSimple.getUserPassword()+"','"+unUserSimple.getUserRole()+"','"+unUserSimple.getUserDateInscription()+"','JAVAImg', null, 'JAVABanner', null);";
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				unStat.execute(requete);
				unStat.close();
				uneBdd.seDeconnecter();
			}catch (SQLException exp) {
				System.out.println("Erreur d'execution de : "+ requete+" "+exp);
				
			}
	}
	
	public static UserSimple selectWhereUserSimple(int idUser) {
		String requete ="select * from tbluserssimple where idUser ="+idUser+";";
		UserSimple unUserSimple = null;
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet unResultat = unStat.executeQuery(requete);
				//si il y a un usersimple resultat
				if(unResultat.next()) {
					unUserSimple = new UserSimple(
							unResultat.getInt("idUser"),
							unResultat.getInt("userLevel"),
							unResultat.getInt("userSimpleCanModify"),	
							unResultat.getString("userSimplePlateforme"),
							unResultat.getString("userNom"),
							unResultat.getString("userPrenom"),
							unResultat.getString("userAge"),
							unResultat.getString("userBio"),
							unResultat.getString("userPseudo"),
							unResultat.getString("userNaissance"),
							unResultat.getString("userMail"),
							unResultat.getString("userPassword"),
							unResultat.getString("userRole"),
							unResultat.getString("userDateInscription")
							);
							
				}
				
				unStat.close();
				uneBdd.seDeconnecter();
			}catch (SQLException exp) {
				System.out.println("Erreur d'execution de : "+ requete);
				
			}
			return unUserSimple;
	}
	public static UserSimple selectWhereUserSimple(String mail, String nom, String prenom) {
		String requete ="select * from tbluserssimple where userMail ='"+mail+"' and userNom ='"+nom+"' and userPrenom = '"+prenom+"';";
		UserSimple unUserSimple = null;
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet unResultat = unStat.executeQuery(requete);
				//si il y a un usersimple resultat
				if(unResultat.next()) {
					unUserSimple = new UserSimple(
							unResultat.getInt("idUser"),
							unResultat.getInt("userLevel"),
							unResultat.getInt("userSimpleCanModify"),	
							unResultat.getString("userSimplePlateforme"),
							unResultat.getString("userNom"),
							unResultat.getString("userPrenom"),
							unResultat.getString("userAge"),
							unResultat.getString("userBio"),
							unResultat.getString("userPseudo"),
							unResultat.getString("userNaissance"),
							unResultat.getString("userMail"),
							unResultat.getString("userPassword"),
							unResultat.getString("userRole"),
							unResultat.getString("userDateInscription"));
							
				}
				
				unStat.close();
				uneBdd.seDeconnecter();
			}catch (SQLException exp) {
				System.out.println("Erreur d'execution de : "+ requete);
				
			}
			return unUserSimple;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
