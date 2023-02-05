package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.GroupePublic;

public class ModeleGroupePublic {

	
	private static Bdd uneBdd = new Bdd("localhost","leveling2","root","");
	
	
	public static void insertGroupePublic(GroupePublic unGroupePublic) {
		String  requete ="call insertGroupePublic('"+unGroupePublic.isGroupeMasquer()+"','"
				+unGroupePublic.getGroupePublicNbUsers()+"','"+unGroupePublic.getGroupePublicidUser()+"','"
				+unGroupePublic.getGroupeName()+"','"+unGroupePublic.getGroupeDescription()+"','"+unGroupePublic.getGroupeFkIdUser()+"','"+unGroupePublic.getGroupePrivacy()+"','"
				+unGroupePublic.getGroupeImg()+"','"+unGroupePublic.getGroupeTypeImg()+"','"+unGroupePublic.getGroupeBanner()+"','"
				+unGroupePublic.getGroupeTypeBanner()+"');";
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
	public static ArrayList<GroupePublic> selectAllGroupesPublics(){
		String requete="select * from tblgroupspublic ;";
		ArrayList<GroupePublic> lesGroupesPublics = new ArrayList<GroupePublic>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			//parcourir tous les groupePublic et en faire des objets, il faut respecter l'ordre dans le constructeur
			while(desResultats.next()) {
				GroupePublic unGroupePublic = new GroupePublic(
						desResultats.getInt("idGroupe"),
						desResultats.getInt("groupeFkIdUser"),
						desResultats.getInt("groupePublicNbUsers"),
						desResultats.getInt("groupePublicidUser"),
						desResultats.getBoolean("groupeMasquer"),	
						desResultats.getString("groupeName"),
						desResultats.getString("groupeDescription"),
						desResultats.getString("groupePrivacy"),
						desResultats.getString("groupeTypeImg"),
						desResultats.getString("groupeTypeBanner"),
						desResultats.getBlob("groupeImg"),
						desResultats.getBlob("groupeBanner")); 
				lesGroupesPublics.add(unGroupePublic);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur d'execution de : "+ requete);
		}
		
		return lesGroupesPublics;
	}
	
	public static void deleteGroupePublic(int idGroupe) {
		String requete = "call deleteGroupePublic('"+idGroupe+"');";
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
	
	public static void updateGroupePublic(GroupePublic unGroupePublic) {
		String  requete ="call updateGroupePublic('"+unGroupePublic.getIdGroupe()+"','"+unGroupePublic.isGroupeMasquer()+"','"
				+unGroupePublic.getGroupePublicNbUsers()+"','"+unGroupePublic.getGroupePublicidUser()+"','"
				+unGroupePublic.getGroupeName()+"','"+unGroupePublic.getGroupeDescription()+"','"+unGroupePublic.getGroupeFkIdUser()+"','"+unGroupePublic.getGroupePrivacy()+"','"
				+unGroupePublic.getGroupeImg()+"','"+unGroupePublic.getGroupeTypeImg()+"','"+unGroupePublic.getGroupeBanner()+"','"
				+unGroupePublic.getGroupeTypeBanner()+"');";
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
	
	public static GroupePublic selectWhereGroupePublic(int idGroupe) {
		String requete ="select * from tblgroupspublic where idGroupe ="+idGroupe+";";
		GroupePublic unGroupePublic = null;
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet unResultat = unStat.executeQuery(requete);
				//si il y a un groupePublic resultat
				if(unResultat.next()) {
					unGroupePublic = new GroupePublic(
							unResultat.getInt("idGroupe"),
							unResultat.getInt("groupeFkIdUser"),
							unResultat.getInt("groupePublicNbUsers"),
							unResultat.getInt("groupePublicidUser"),
							unResultat.getBoolean("groupeMasquer"),	
							unResultat.getString("groupeName"),
							unResultat.getString("groupeDescription"),
							unResultat.getString("groupePrivacy"),
							unResultat.getString("groupeTypeImg"),
							unResultat.getString("groupeTypeBanner"),
							unResultat.getBlob("groupeImg"),
							unResultat.getBlob("groupeBanner"));
				}
				
				unStat.close();
				uneBdd.seDeconnecter();
			}catch (SQLException exp) {
				System.out.println("Erreur d'execution de : "+ requete);
				
			}
			return unGroupePublic;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
