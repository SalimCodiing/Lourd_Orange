package controller;

import vue.VueConnexion;
import vue.VueGenerale;

public class Orange {
	private static VueConnexion uneVueConnexion;
	private static VueGenerale uneVueGenerale;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		uneVueConnexion = new VueConnexion();
		uneVueGenerale = new VueGenerale();
	}
	
	public static void gererVueConnexion(boolean action) {
		Orange.uneVueConnexion.setVisible(action);
	}
	public static void gererVueGenerale(boolean action) {
		Orange.uneVueGenerale.setVisible(action);
	}
}
