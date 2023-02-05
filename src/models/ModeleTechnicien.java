package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Client;
import controller.Technicien;

public class ModeleTechnicien {
private static Bdd uneBdd = new Bdd("localhost","orange_250_2023","root","");
	
	public static void insertTechnicien(Technicien unTechnicien) {
		String requete ="insert into technicien values(null,'"+unTechnicien.getNom()+"','"+unTechnicien.getPrenom()+"','"+unTechnicien.getEmail()+"','"+unTechnicien.getMdp()+"','"+
				unTechnicien.getQualification()+"');";
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
	public static ArrayList<Technicien> selectAllTechniciens(String mot){
		String requete ="";
		if(mot.equals("")) {
			requete ="select * from technicien;";
		}else {
			requete = "select * from technicien where nom like '%"+mot+"%' or prenom like'%"+mot
					+"%' or email like '%"+mot+"%' or qualification like '%"+mot+"%';";
		}
		
		ArrayList<Technicien> lesTechniciens = new ArrayList<Technicien>();
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet desResultats = unStat.executeQuery(requete);
				//parcourir des résultats et construire des objets techniciens
				while(desResultats.next()) {
					Technicien unTechnicien = new Technicien(
							desResultats.getInt("idtechnicien"), desResultats.getString("nom"), desResultats.getString("prenom"), desResultats.getString("email"),
							desResultats.getString("mdp"),desResultats.getString("qualification")
							);
					// on ajoute  l'instance technicien dans l'Arraylist
					lesTechniciens.add(unTechnicien);
				}
				
				unStat.close();
				uneBdd.seDeconnecter();
			}catch (SQLException exp) {
				System.out.println("Erreur d'execution de : "+ requete);
				
			}
			return lesTechniciens;
		
	}
	public static void deleteTechnicien(int idtechnicien) {
		String requete = "delete from technicien where idtechnicien ='"+idtechnicien+"';";
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
	public static void updateTechnicien(Technicien unTechnicien) {
		String requete ="update technicien set nom='"+unTechnicien.getNom()+"', prenom ='"+unTechnicien.getPrenom()+"',email ='"+unTechnicien.getEmail()+"',mdp='"+unTechnicien.getMdp()+"',"
				+ "qualification="+ "'"+unTechnicien.getQualification()+"' where idtechnicien ="+unTechnicien.getIdtechnicien()+";";
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
	public static Technicien selectWhereTechnicien(int idtechnicien) {
        String requete="select * from technicien where idtechnicien='"+idtechnicien+"';";
        Technicien unTechnicien=null;
        try {
            uneBdd.seConnecter();
            Statement unStat= uneBdd.getMaConnexion().createStatement();
            ResultSet unResultat=unStat.executeQuery(requete);
            //Tester s'il y a un résultat
            if(unResultat.next()) {
                unTechnicien=new Technicien(
                    unResultat.getInt("idtechnicien"), unResultat.getString("nom"),
                    unResultat.getString("prenom"), unResultat.getString("email"),
                    unResultat.getString("mdp"), unResultat.getString("qualification"));
            }
            unStat.close();
            uneBdd.seDeconnecter();
        }
        catch(SQLException exp) {
            System.out.println("Erreur d'execution de: "+requete);
        }
        return unTechnicien;
    }
	public static Technicien selectWhereTechnicien(String email, String mdp) {
        String requete="select * from technicien where email='"+email+"' and mdp='"+mdp+"';";
        Technicien unTechnicien=null;
        try {
            uneBdd.seConnecter();
            Statement unStat= uneBdd.getMaConnexion().createStatement();
            ResultSet unResultat=unStat.executeQuery(requete);
            //Tester s'il y a un résultat
            if(unResultat.next()) {
                unTechnicien=new Technicien(
                    unResultat.getInt("idtechnicien"), unResultat.getString("nom"),
                    unResultat.getString("prenom"), unResultat.getString("email"),
                    unResultat.getString("mdp"), unResultat.getString("qualification"));
            }
            unStat.close();
            uneBdd.seDeconnecter();
        }
        catch(SQLException exp) {
            System.out.println("Erreur d'execution de: "+requete);
        }
        return unTechnicien;
    }
	
	
	
	
	
	
	
	
	
}
