package controller;



import java.util.ArrayList;

import models.ModeleClient;

public class C_Client {
	public static void insertClient(Client unClient) {
		//on crontrolles les données
		ModeleClient.insertClient(unClient);
	}
	public static ArrayList<Client> selectAllClients(String mot){
		return ModeleClient.selectAllClients(mot);
	}
	public static void deleteClien(int idclient) {
		ModeleClient.deleteClient(idclient);
	}
	public static void updateClient(Client unClient) {
		ModeleClient.updateClient(unClient);
	}
	public static Client selectWhereClient(int idclient) {
		return ModeleClient.selectWhereClient(idclient);
	}
	
	public static Client selectWhereClient(String email, String nom, String prenom) {
		return ModeleClient.selectWhereClient(email, nom, prenom);
	}
	
}
