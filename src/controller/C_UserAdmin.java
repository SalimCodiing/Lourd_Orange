package controller;

import java.util.ArrayList;

import models.ModeleUserAdmin;

public class C_UserAdmin {
	public static void insertUserAdmin(UserAdmin unUserAdmin) {
		ModeleUserAdmin.insertUserAdmin(unUserAdmin);
	}
	public static ArrayList<UserAdmin> selectAllUsersAdmins(){
		return ModeleUserAdmin.selectAllUsersAdmins();
	}
	public static void deleteUserAdmin(int idUser) {
		ModeleUserAdmin.deleteUserAdmin(idUser);
	}
	public static void updateUserAdmin(UserAdmin unUserAdmin) {
		ModeleUserAdmin.updateUserAdmin(unUserAdmin);
	}
	public static UserAdmin selectWhereUserAdmin(int idUser) {
		return ModeleUserAdmin.selectWhereUserAdmin(idUser);
	}
	public static UserAdmin selectWhereUserAdmin(String email, String mdp) {
		return ModeleUserAdmin.selectWhereUserAdmin(email, mdp);
	}
}