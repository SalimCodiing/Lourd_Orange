package controller;

import java.util.ArrayList;

import models.ModeleUserSimple;

public class C_UserSimple {

	public static void insertUserSimple(UserSimple unUserSimple) {
		ModeleUserSimple.insertUserSimple(unUserSimple);
	}
	public static ArrayList<UserSimple> selectAllUsersSimples(String mot){
		return ModeleUserSimple.selectAllUsersSimples(mot);
	}
	//public static ArrayList<UserSimple> selectAllUsersSimples(){
	//	return ModeleUserSimple.selectAllUsersSimples();
	//}
	
	
	public static void deleteUserSimple(int idUser) {
		ModeleUserSimple.deleteUserSimple(idUser);
	}
	public static void updateUserSimple(UserSimple unUserSimple) {
		ModeleUserSimple.updateUserSimple(unUserSimple);
	}
	public static UserSimple selectWhereUserSimple(int idUser) {
		return ModeleUserSimple.selectWhereUserSimple(idUser);
	}
	public static UserSimple selectWhereUserSimple(String mail, String nom, String prenom) {
		return ModeleUserSimple.selectWhereUserSimple(mail, nom, prenom);
	}
}
