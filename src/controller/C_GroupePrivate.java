package controller;

import java.util.ArrayList;

import models.ModeleGroupePrivate;

public class C_GroupePrivate {
	

	public static void insertGroupePrivate(GroupePrivate unGroupePrivate) {
		ModeleGroupePrivate.insertGroupePrivate(unGroupePrivate);
	}
	public static ArrayList<GroupePrivate> selectAllUsersPrivates(){
		return ModeleGroupePrivate.selectAllUsersPrivates();
	}
	public static void deleteGroupePrivate(int idGroupe) {
		ModeleGroupePrivate.deleteGroupePrivate(idGroupe);
	}
	public static void updateGroupePrivate(GroupePrivate unGroupePrivate) {
		ModeleGroupePrivate.updateGroupePrivate(unGroupePrivate);
	}
	public static GroupePrivate selectWhereGroupePrivate(int idGroupe) {
		return ModeleGroupePrivate.selectWhereGroupePrivate(idGroupe);
	}

		
}
