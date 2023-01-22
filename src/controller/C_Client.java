package controller;



import java.util.ArrayList;

import models.ModeleClient;

public class C_Client {
	public static void insertClient(Client unClient) {
		//on crontrolles les données
		ModeleClient.insertClient(unClient);
	}
	public static ArrayList<Client> selectAllClients(){
		return ModeleClient.selectAllClients();
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
}
