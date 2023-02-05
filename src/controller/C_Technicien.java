package controller;

import java.util.ArrayList;

import models.ModeleClient;
import models.ModeleTechnicien;

public class C_Technicien {
	public static void insertTechnicien(Technicien unTechnicien) {
		//on crontrolles les données
		ModeleTechnicien.insertTechnicien(unTechnicien);
	}
	public static ArrayList<Technicien> selectAllTechniciens(String mot){
		return ModeleTechnicien.selectAllTechniciens(mot);
	}
	public static void deleteTechnicien(int idtechnicien) {
		ModeleTechnicien.deleteTechnicien(idtechnicien);
	}
	public static void updateTechnicien(Technicien unTechnicien) {
		ModeleTechnicien.updateTechnicien(unTechnicien);
	}
	public static Technicien selectWhereTechnicien(int idtechnicien) {
		return ModeleTechnicien.selectWhereTechnicien(idtechnicien);
	}
	public static Technicien selectWhereTechnicien(String email, String mdp) {
		return ModeleTechnicien.selectWhereTechnicien(email, mdp);
	}
}
