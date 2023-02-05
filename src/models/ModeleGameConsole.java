package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.GameConsole;

public class ModeleGameConsole {

	private static Bdd uneBdd = new Bdd("localhost","leveling2","root","");
	
	public static void insertGameConsole(GameConsole unJeuCs) {
		String  requete ="call insertJeuConsole('"+unJeuCs.getGameCsSupport()+"','"
				+unJeuCs.getGameCsDateSortie()+"','"+unJeuCs.getGameCsPrix()+"','"+unJeuCs.getGameCsTaille()+"','"
				+unJeuCs.getGameCsModeleEco()+"','"+unJeuCs.getGameName()+"','"+unJeuCs.getGameDescription()+"','"
				+unJeuCs.getGameGenre()+"','"+unJeuCs.getGameAvis()+"','"+unJeuCs.getGameClassification()+"','"
				+unJeuCs.getGameMode()+"','"+unJeuCs.getGameImg()+"','"+unJeuCs.getGameTrailer()+"','"+unJeuCs.getGameImgOther()+"');";
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
	public static ArrayList<GameConsole> selectAllGamesConsoles(){
		String requete="select * from tblgamescs ;";
		ArrayList<GameConsole> lesGamesConsoles = new ArrayList<GameConsole>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			//parcourir tous les gamesConsole et en faire des objets, il faut respecter l'ordre dans le constructeur
			while(desResultats.next()) {
				GameConsole uneGameConsole = new GameConsole(
						desResultats.getInt("idGame"),
						desResultats.getFloat("gameCsPrix"),
						desResultats.getFloat("gameCsTaille"),
						desResultats.getString("gameCsSupport"),
						desResultats.getString("gameCsDateSortie"),
						desResultats.getString("gameCsModeleEco"),
						desResultats.getString("gameName"),
						desResultats.getString("gameDescription"),
						desResultats.getString("gameGenre"),
						desResultats.getString("gameAvis"),
						desResultats.getString("gameClassification"),
						desResultats.getString("gameMode"),
						desResultats.getString("gameImg"),
						desResultats.getString("gameTrailer"),
						desResultats.getString("gameImgOther")); 
						lesGamesConsoles.add(uneGameConsole);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur d'execution de : "+ requete);
		}
		
		return lesGamesConsoles;
	}
	
	public static void deleteGameConsole(int idGame) {
		String requete = "call deleteJeuConsole('"+idGame+"');";
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
	
	public static void updateGameConsole(GameConsole unJeuCs) {
		String requete ="call updateGameConsole('"+unJeuCs.getIdGame()+"','"+unJeuCs.getGameCsSupport()+
				"','"+unJeuCs.getGameCsDateSortie()+"','"+unJeuCs.getGameCsPrix()+"','"+unJeuCs.getGameCsTaille()+
				"','"+unJeuCs.getGameCsModeleEco()+"','"+unJeuCs.getGameName()+"','"+unJeuCs.getGameDescription()+
				"','"+unJeuCs.getGameGenre()+"','"+unJeuCs.getGameAvis()+"','"+unJeuCs.getGameClassification()+
				"','"+unJeuCs.getGameMode()+"','"+unJeuCs.getGameImg()+"','"+unJeuCs.getGameTrailer()+
				"','"+unJeuCs.getGameImgOther()+"');";
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
	public static GameConsole selectWhereGameConsole(int idGame) {
		String requete ="select * from tblgamescs where idGame ="+idGame+";";
		GameConsole uneGameConsole = null;
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet unResultat = unStat.executeQuery(requete);
				//si il y a un consolecs resultat
				if(unResultat.next()) {
					uneGameConsole = new GameConsole(
							unResultat.getInt("idGame"),
							unResultat.getFloat("gameCsPrix"),
							unResultat.getFloat("gameCsTaille"),
							unResultat.getString("gameCsSupport"),
							unResultat.getString("gameCsDateSortie"),
							unResultat.getString("gameCsModeleEco"),
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
			return uneGameConsole;
	}
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

