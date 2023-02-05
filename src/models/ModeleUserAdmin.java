package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.UserAdmin;

public class ModeleUserAdmin {
	private static Bdd uneBdd = new Bdd("localhost","leveling2","root","");
	
	public static void insertUserAdmin(UserAdmin unUserAdmin) {
		String  requete ="call insertUserAdmin('"+unUserAdmin.getUserAdminGrade()+"','"
				+unUserAdmin.getUserAdminFonction()+"','"+unUserAdmin.isUserCanModify()+"','"+unUserAdmin.getUserNom()+"','"
				+unUserAdmin.getUserPrenom()+"','"+unUserAdmin.getUserAge()+"','"+unUserAdmin.getUserBio()+"','"+unUserAdmin.getUserNaissance()+"','"
				+unUserAdmin.getUserLevel()+"','"+unUserAdmin.getUserPseudo()+"','"+unUserAdmin.getUserMail()+"','"
				+unUserAdmin.getUserPassword()+"','"+unUserAdmin.getUserRole()+"','"+unUserAdmin.getUserDateInscription()+"','"
				+unUserAdmin.getUserAdminImg()+"','"+unUserAdmin.getUserAdminTypeImg()+"','"+unUserAdmin.getUserAdminBanner()+"','"
				+unUserAdmin.getUserAdminTypeBanner()+"');";
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

	public static ArrayList<UserAdmin> selectAllUsersAdmins(){
		String requete="select * from tblusersadmin ;";
		ArrayList<UserAdmin> lesUsersAdmins = new ArrayList<UserAdmin>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			//parcourir tous les userAdmin et en faire des objets, il faut respecter l'ordre dans le constructeur
			while(desResultats.next()) {
				UserAdmin unUserAdmin = new UserAdmin(
						desResultats.getInt("idUser"),
						desResultats.getInt("userLevel"),
						desResultats.getBoolean("userCanModify"),	
						desResultats.getString("userAdminGrade"),
						desResultats.getString("userAdminFonction"),
						desResultats.getString("userNom"),
						desResultats.getString("userPrenom"),
						desResultats.getString("userAge"),
						desResultats.getString("userBio"),
						desResultats.getString("userPseudo"),
						desResultats.getString("userNaissance"),
						desResultats.getString("userMail"),
						desResultats.getString("userPassword"),
						desResultats.getString("userRole"),
						desResultats.getString("userDateInscription"),
						desResultats.getString("userAdminTypeImg"),	
						desResultats.getString("userAdminTypeBanner"),
						desResultats.getBlob("userAdminImg"),
						desResultats.getBlob("userAdminBanner")); 
				lesUsersAdmins.add(unUserAdmin);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur d'execution de : "+ requete);
		}
		
		return lesUsersAdmins;
	}
	
	public static void deleteUserAdmin(int idUser) {
		String requete = "call deleteUserAdmin('"+idUser+"');";
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
	
	public static void updateUserAdmin(UserAdmin unUserAdmin) {
		String  requete ="call updateUserAdmin('"+unUserAdmin.getIdUser()+"','"+unUserAdmin.getUserAdminGrade()+"','"
				+unUserAdmin.getUserAdminFonction()+"','"+unUserAdmin.isUserCanModify()+"','"+unUserAdmin.getUserNom()+"','"
				+unUserAdmin.getUserPrenom()+"','"+unUserAdmin.getUserAge()+"','"+unUserAdmin.getUserBio()+"','"+unUserAdmin.getUserNaissance()+"','"
				+unUserAdmin.getUserLevel()+"','"+unUserAdmin.getUserPseudo()+"','"+unUserAdmin.getUserMail()+"','"
				+unUserAdmin.getUserPassword()+"','"+unUserAdmin.getUserRole()+"','"+unUserAdmin.getUserDateInscription()+"','"
				+unUserAdmin.getUserAdminImg()+"','"+unUserAdmin.getUserAdminTypeImg()+"','"+unUserAdmin.getUserAdminBanner()+"','"
				+unUserAdmin.getUserAdminTypeBanner()+"');";
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
	public static UserAdmin selectWhereUserAdmin(int idUser) {
		String requete ="select * from tblusersadmin where idUser ="+idUser+";";
		UserAdmin unUserAdmin = null;
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet unResultat = unStat.executeQuery(requete);
				//si il y a un useradmin resultat
				if(unResultat.next()) {
					unUserAdmin = new UserAdmin(
							unResultat.getInt("idUser"),
							unResultat.getInt("userLevel"),
							unResultat.getBoolean("userCanModify"),	
							unResultat.getString("userAdminGrade"),
							unResultat.getString("userAdminFonction"),
							unResultat.getString("userNom"),
							unResultat.getString("userPrenom"),
							unResultat.getString("userAge"),
							unResultat.getString("userBio"),
							unResultat.getString("userPseudo"),
							unResultat.getString("userNaissance"),
							unResultat.getString("userMail"),
							unResultat.getString("userPassword"),
							unResultat.getString("userRole"),
							unResultat.getString("userDateInscription"),
							unResultat.getString("userAdminTypeImg"),	
							unResultat.getString("userAdminTypeBanner"),
							unResultat.getBlob("userAdminImg"),
							unResultat.getBlob("userAdminBanner"));
							
				}
				
				unStat.close();
				uneBdd.seDeconnecter();
			}catch (SQLException exp) {
				System.out.println("Erreur d'execution de : "+ requete);
				
			}
			return unUserAdmin;
	}
	public static UserAdmin selectWhereUserAdmin(String email, String mdp) {
		String requete ="select * from tblusersadmin where userMail ='"+email+"' and userPassword ='"+mdp+"';";
		UserAdmin unUserAdmin = null;
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet unResultat = unStat.executeQuery(requete);
				//si il y a un d'un user admin resultat
				if(unResultat.next()) {
					unUserAdmin = new UserAdmin(
							unResultat.getInt("idUser"),
							unResultat.getInt("userLevel"),
							unResultat.getBoolean("userCanModify"),	
							unResultat.getString("userAdminGrade"),
							unResultat.getString("userAdminFonction"),
							unResultat.getString("userNom"),
							unResultat.getString("userPrenom"),
							unResultat.getString("userAge"),
							unResultat.getString("userBio"),
							unResultat.getString("userPseudo"),
							unResultat.getString("userNaissance"),
							unResultat.getString("userMail"),
							unResultat.getString("userPassword"),
							unResultat.getString("userRole"),
							unResultat.getString("userDateInscription"),
							unResultat.getString("userAdminTypeImg"),	
							unResultat.getString("userAdminTypeBanner"),
							unResultat.getBlob("userAdminImg"),
							unResultat.getBlob("userAdminBanner"));
							
				}
				
				unStat.close();
				uneBdd.seDeconnecter();
			}catch (SQLException exp) {
				System.out.println("Erreur d'execution de : "+ requete);
				
			}
			return unUserAdmin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
