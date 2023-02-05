package controller;

import java.util.ArrayList;

import models.ModeleGameConsole;

public class C_GameConsole {
	
	public static void insertGameConsole(GameConsole unJeuCs) {
		ModeleGameConsole.insertGameConsole(unJeuCs);
	}
	public static ArrayList<GameConsole> selectAllGamesConsoles(){
		return ModeleGameConsole.selectAllGamesConsoles();
	}
	public static void deleteGameConsole(int idGame) {
		ModeleGameConsole.deleteGameConsole(idGame);
	}
	public static void updateGameConsole(GameConsole unJeuCs) {
		ModeleGameConsole.updateGameConsole(unJeuCs);
	}
	public static GameConsole selectWhereGameConsole(int idGame) {
		return ModeleGameConsole.selectWhereGameConsole(idGame);
	}
}
