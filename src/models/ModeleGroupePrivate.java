package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.GroupePrivate;

public class ModeleGroupePrivate {
	
	private static Bdd uneBdd = new Bdd("localhost","leveling2","root","");
	
	public static void insertGroupePrivate(GroupePrivate unGroupePrivate) {
		String  requete ="call insertGroupePrivate('"+unGroupePrivate.isGroupeMasquer()+"','"
				+unGroupePrivate.getGroupePrivateNbUsers()+"','"+unGroupePrivate.getGroupePrivateIdUser()+"','"
				+unGroupePrivate.getGroupeName()+"','"+unGroupePrivate.getGroupeDescription()+"','"+unGroupePrivate.getGroupeFkIdUser()+"','"+unGroupePrivate.getGroupePrivacy()+"','"
				+unGroupePrivate.getGroupeImg()+"','"+unGroupePrivate.getGroupeTypeImg()+"','"+unGroupePrivate.getGroupeBanner()+"','"
				+unGroupePrivate.getGroupeTypeBanner()+"');";
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
	
	public static ArrayList<GroupePrivate> selectAllUsersPrivates(){
		String requete="select * from tblgroupsprivate ;";
		ArrayList<GroupePrivate> lesGroupesPrivates = new ArrayList<GroupePrivate>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			//parcourir tous les groupePrivate et en faire des objets, il faut respecter l'ordre dans le constructeur
			while(desResultats.next()) {
				GroupePrivate unGroupePrivate = new GroupePrivate(
						desResultats.getInt("idGroupe"),
						desResultats.getInt("groupeFkIdUser"),
						desResultats.getInt("groupePrivateNbUsers"),
						desResultats.getInt("groupePrivateIdUser"),
						desResultats.getBoolean("groupeMasquer"),	
						desResultats.getString("groupeName"),
						desResultats.getString("groupeDescription"),
						desResultats.getString("groupePrivacy"),
						desResultats.getString("groupeTypeImg"),
						desResultats.getString("groupeTypeBanner"),
						desResultats.getBlob("groupeImg"),
						desResultats.getBlob("groupeBanner")); 
				lesGroupesPrivates.add(unGroupePrivate);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur d'execution de : "+ requete);
		}
		
		return lesGroupesPrivates;
	}
	
	public static void deleteGroupePrivate(int idGroupe) {
		String requete = "call deleteGroupePrivate('"+idGroupe+"');";
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
	
	public static void updateGroupePrivate(GroupePrivate unGroupePrivate) {
		String  requete ="call updateGroupePrivate('"+unGroupePrivate.getIdGroupe()+"','"+unGroupePrivate.getIdGroupe()+"','"+unGroupePrivate.isGroupeMasquer()+"','"
				+unGroupePrivate.getGroupePrivateNbUsers()+"','"+unGroupePrivate.getGroupePrivateIdUser()+"','"
				+unGroupePrivate.getGroupeName()+"','"+unGroupePrivate.getGroupeDescription()+"','"+unGroupePrivate.getGroupeFkIdUser()+"','"+unGroupePrivate.getGroupePrivacy()+"','"
				+unGroupePrivate.getGroupeImg()+"','"+unGroupePrivate.getGroupeTypeImg()+"','"+unGroupePrivate.getGroupeBanner()+"','"
				+unGroupePrivate.getGroupeTypeBanner()+"');";
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
	
	public static GroupePrivate selectWhereGroupePrivate(int idGroupe) {
		String requete ="select * from tblgroupsprivate where idGroupe ="+idGroupe+";";
		GroupePrivate unGroupePrivate = null;
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet unResultat = unStat.executeQuery(requete);
				//si il y a un groupePrivate resultat
				if(unResultat.next()) {
					unGroupePrivate = new GroupePrivate(
							unResultat.getInt("idGroupe"),
							unResultat.getInt("groupeFkIdUser"),
							unResultat.getInt("groupePrivateNbUsers"),
							unResultat.getInt("groupePrivateIdUser"),
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
			return unGroupePrivate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
