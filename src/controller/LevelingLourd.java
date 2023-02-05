package controller;

import vue.VueConnexion;
import vue.VueGenerale;

public class LevelingLourd {

	private static VueConnexion uneVueConnexion;
	private static VueGenerale uneVueGenerale;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		uneVueConnexion = new VueConnexion();
		
	}
	public static void gererVueConnexion(boolean action) {
		LevelingLourd.uneVueConnexion.setVisible(action);
	}
	public static void gererVueGenerale(boolean action , UserAdmin unUserAdmin) {
		//
		uneVueGenerale = new VueGenerale(unUserAdmin);
		// 
		LevelingLourd.uneVueGenerale.setVisible(action);
	}

}
