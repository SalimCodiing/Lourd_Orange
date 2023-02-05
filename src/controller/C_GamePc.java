package controller;

import java.util.ArrayList;

import models.ModeleGamePc;

public class C_GamePc {

	public static void insertGamePc(GamePc unJeuPc) {
		ModeleGamePc.insertGamePc(unJeuPc);
	}
	public static ArrayList<GamePc> selectAllGamesPc(){
		return ModeleGamePc.selectAllGamesPc();
	}
	
	public static void deleteGamePc(int idGame) {
		ModeleGamePc.deleteGamePc(idGame);
	}
	public static void updateGamePc(GamePc unJeuPc) {
		ModeleGamePc.updateGamePc(unJeuPc);
	}
	public static GamePc selectWhereGamePc(int idGame) {
		return ModeleGamePc.selectWhereGamePc(idGame);
	}

		
}
