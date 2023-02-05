package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import controller.GamePc;

public class ModeleGamePc {
	private static Bdd uneBdd = new Bdd("localhost","leveling2","root","");
	
	public static void insertGamePc(GamePc unJeuPc) {
		String  requete ="call insertJeuPc('"+unJeuPc.getGamePcModeleEco()+"','"
				+unJeuPc.getGamePcPrix()+"','"+unJeuPc.getGamePcOs()+"','"+unJeuPc.getGamePcProc()+"','"
				+unJeuPc.getGamePcCg()+"','"+unJeuPc.getGamePcTaille()+"','"+unJeuPc.getGameName()+"','"+unJeuPc.getGameDescription()+"','"
				+unJeuPc.getGameGenre()+"','"+unJeuPc.getGameAvis()+"','"+unJeuPc.getGameClassification()+"','"
				+unJeuPc.getGameMode()+"','"+unJeuPc.getGameImg()+"','"+unJeuPc.getGameTrailer()+"','"+unJeuPc.getGameImgOther()+"');";
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
	
	public static ArrayList<GamePc> selectAllGamesPc(){
		String requete="select * from tblgamespc ;";
		ArrayList<GamePc> lesGamesPcs = new ArrayList<GamePc>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			//parcourir tous les gamesPc et en faire des objets, il faut respecter l'ordre dans le constructeur
			while(desResultats.next()) {
				GamePc uneGamePc = new GamePc(
						desResultats.getInt("idGame"),
						desResultats.getFloat("gamePcPrix"),
						desResultats.getFloat("gamePcTaille"),	
						desResultats.getString("gamePcModeleEco"),
						desResultats.getString("gamePcOs"),
						desResultats.getString("gamePcProc"),
						desResultats.getString("gamePcCg"),
						desResultats.getString("gameName"),
						desResultats.getString("gameDescription"),
						desResultats.getString("gameGenre"),
						desResultats.getString("gameAvis"),
						desResultats.getString("gameClassification"),
						desResultats.getString("gameMode"),
						desResultats.getString("gameImg"),
						desResultats.getString("gameTrailer"),
						desResultats.getString("gameImgOther")); 
				lesGamesPcs.add(uneGamePc);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur d'execution de : "+ requete);
		}
		
		return lesGamesPcs;
	}
	
	public static void deleteGamePc(int idGame) {
		String requete = "call deleteJeuPc('"+idGame+"');";
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
	public static void updateGamePc(GamePc unJeuPc) {
		String requete ="call updateGamePc('"+unJeuPc.getIdGame()+"','"+unJeuPc.getGamePcModeleEco()+
				"','"+unJeuPc.getGamePcPrix()+"','"+unJeuPc.getGamePcOs()+"','"+unJeuPc.getGamePcProc()+
				"','"+unJeuPc.getGamePcCg()+"','"+unJeuPc.getGamePcTaille()+"','"+unJeuPc.getGameName()+"','"+unJeuPc.getGameDescription()+
				"','"+unJeuPc.getGameGenre()+"','"+unJeuPc.getGameAvis()+"','"+unJeuPc.getGameClassification()+
				"','"+unJeuPc.getGameMode()+"','"+unJeuPc.getGameImg()+"','"+unJeuPc.getGameTrailer()+
				"','"+unJeuPc.getGameImgOther()+"');";
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
	
	public static GamePc selectWhereGamePc(int idGame) {
		String requete ="select * from tblgamespc where idGame ="+idGame+";";
		GamePc uneGamePc = null;
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet unResultat = unStat.executeQuery(requete);
				//si il y a un consolepc resultat
				if(unResultat.next()) {
					uneGamePc = new GamePc(
							unResultat.getInt("idGame"),
							unResultat.getFloat("gamePcPrix"),
							unResultat.getFloat("gamePcTaille"),	
							unResultat.getString("gamePcModeleEco"),
							unResultat.getString("gamePcOs"),
							unResultat.getString("gamePcProc"),
							unResultat.getString("gamePcCg"),
							unResultat.getString("gameName"),
							unResultat.getString("gameDescription"),
							unResultat.getString("gameGenre"),
							unResultat.getString("gameAvis"),
							unResultat.getString("gameClassification"),
							unResultat.getString("gameMode"),
							unResultat.getString("gameImg"),
							unResultat.getString("gameTrailer"),
							unResultat.getString("gameImgOther")
							);
							
				}
				
				unStat.close();
				uneBdd.seDeconnecter();
			}catch (SQLException exp) {
				System.out.println("Erreur d'execution de : "+ requete);
				
			}
			return uneGamePc;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
