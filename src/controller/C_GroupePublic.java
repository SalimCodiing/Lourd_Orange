package controller;

import java.util.ArrayList;

import models.ModeleGroupePublic;

public class C_GroupePublic {

	
	public static void insertGroupePublic(GroupePublic unGroupePublic) {
		ModeleGroupePublic.insertGroupePublic(unGroupePublic);
	}
	public static ArrayList<GroupePublic> selectAllGroupesPublics(){
		return ModeleGroupePublic.selectAllGroupesPublics();
	}
	public static void deleteGroupePublic(int idGroupe) {
		ModeleGroupePublic.deleteGroupePublic(idGroupe);
	}
	public static void updateGroupePublic(GroupePublic unGroupePublic) {
		ModeleGroupePublic.updateGroupePublic(unGroupePublic);
	}
	public static GroupePublic selectWhereGroupePublic(int idGroupe) {
		return ModeleGroupePublic.selectWhereGroupePublic(idGroupe);
	}
}
