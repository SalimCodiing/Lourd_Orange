package controller;

import java.sql.Blob;

public class GroupePublic {
	private int idGroupe, groupeFkIdUser,groupePublicNbUsers, groupePublicidUser;
	private boolean groupeMasquer;
	private String groupeName, groupeDescription, groupePrivacy, groupeTypeImg , groupeTypeBanner ;
	private Blob groupeImg,groupeBanner;
	
	public GroupePublic(int idGroupe, int groupeFkIdUser, int groupePublicNbUsers, int groupePublicidUser,
			boolean groupeMasquer, String groupeName, String groupeDescription, String groupePrivacy,
			String groupeTypeImg, String groupeTypeBanner, Blob groupeImg, Blob groupeBanner) {
		this.idGroupe = idGroupe;
		this.groupeFkIdUser = groupeFkIdUser;
		this.groupePublicNbUsers = groupePublicNbUsers;
		this.groupePublicidUser = groupePublicidUser;
		this.groupeMasquer = groupeMasquer;
		this.groupeName = groupeName;
		this.groupeDescription = groupeDescription;
		this.groupePrivacy = groupePrivacy;
		this.groupeTypeImg = groupeTypeImg;
		this.groupeTypeBanner = groupeTypeBanner;
		this.groupeImg = groupeImg;
		this.groupeBanner = groupeBanner;
	}
	public GroupePublic(int groupeFkIdUser, int groupePublicNbUsers, int groupePublicidUser,
			boolean groupeMasquer, String groupeName, String groupeDescription, String groupePrivacy,
			String groupeTypeImg, String groupeTypeBanner, Blob groupeImg, Blob groupeBanner) {
		this.idGroupe = 0;
		this.groupeFkIdUser = groupeFkIdUser;
		this.groupePublicNbUsers = groupePublicNbUsers;
		this.groupePublicidUser = groupePublicidUser;
		this.groupeMasquer = groupeMasquer;
		this.groupeName = groupeName;
		this.groupeDescription = groupeDescription;
		this.groupePrivacy = groupePrivacy;
		this.groupeTypeImg = groupeTypeImg;
		this.groupeTypeBanner = groupeTypeBanner;
		this.groupeImg = groupeImg;
		this.groupeBanner = groupeBanner;
	}
	public GroupePublic() {
		this.idGroupe = 0;
		this.groupeFkIdUser = 0;
		this.groupePublicNbUsers = 0;
		this.groupePublicidUser = 0;
		this.groupeMasquer = false;
		this.groupeName = "";
		this.groupeDescription = "";
		this.groupePrivacy = "";
		this.groupeTypeImg = "";
		this.groupeTypeBanner = "";
		this.groupeImg = null;
		this.groupeBanner = null;
	}
	
	
	
	
	public int getIdGroupe() {
		return idGroupe;
	}
	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}
	public int getGroupeFkIdUser() {
		return groupeFkIdUser;
	}
	public void setGroupeFkIdUser(int groupeFkIdUser) {
		this.groupeFkIdUser = groupeFkIdUser;
	}
	public int getGroupePublicNbUsers() {
		return groupePublicNbUsers;
	}
	public void setGroupePublicNbUsers(int groupePublicNbUsers) {
		this.groupePublicNbUsers = groupePublicNbUsers;
	}
	public int getGroupePublicidUser() {
		return groupePublicidUser;
	}
	public void setGroupePublicidUser(int groupePublicidUser) {
		this.groupePublicidUser = groupePublicidUser;
	}
	public boolean isGroupeMasquer() {
		return groupeMasquer;
	}
	public void setGroupeMasquer(boolean groupeMasquer) {
		this.groupeMasquer = groupeMasquer;
	}
	public String getGroupeName() {
		return groupeName;
	}
	public void setGroupeName(String groupeName) {
		this.groupeName = groupeName;
	}
	public String getGroupeDescription() {
		return groupeDescription;
	}
	public void setGroupeDescription(String groupeDescription) {
		this.groupeDescription = groupeDescription;
	}
	public String getGroupePrivacy() {
		return groupePrivacy;
	}
	public void setGroupePrivacy(String groupePrivacy) {
		this.groupePrivacy = groupePrivacy;
	}
	public String getGroupeTypeImg() {
		return groupeTypeImg;
	}
	public void setGroupeTypeImg(String groupeTypeImg) {
		this.groupeTypeImg = groupeTypeImg;
	}
	public String getGroupeTypeBanner() {
		return groupeTypeBanner;
	}
	public void setGroupeTypeBanner(String groupeTypeBanner) {
		this.groupeTypeBanner = groupeTypeBanner;
	}
	public Blob getGroupeImg() {
		return groupeImg;
	}
	public void setGroupeImg(Blob groupeImg) {
		this.groupeImg = groupeImg;
	}
	public Blob getGroupeBanner() {
		return groupeBanner;
	}
	public void setGroupeBanner(Blob groupeBanner) {
		this.groupeBanner = groupeBanner;
	}
	
	
	


	
	
	
	
	
	
	
	
	
	
}
