package controller;

import java.sql.Blob;

public class UserAdmin {

	private int  idUser, userLevel;
	private boolean userCanModify;
	private String userAdminGrade,userAdminFonction,userNom, userPrenom, userAge,
	userBio,userPseudo, userNaissance, userMail, userPassword, userRole, userDateInscription, userAdminTypeImg, userAdminTypeBanner ;
	private Blob userAdminImg, userAdminBanner;
	
	public UserAdmin(int idUser, int userLevel, boolean userCanModify, String userAdminGrade, String userAdminFonction,
			String userNom, String userPrenom, String userAge, String userBio, String userPseudo, String userNaissance,
			String userMail, String userPassword, String userRole, String userDateInscription, String userAdminTypeImg,
			String userAdminTypeBanner, Blob userAdminImg, Blob userAdminBanner) {
		this.idUser = idUser;
		this.userLevel = userLevel;
		this.userCanModify = userCanModify;
		this.userAdminGrade = userAdminGrade;
		this.userAdminFonction = userAdminFonction;
		this.userNom = userNom;
		this.userPrenom = userPrenom;
		this.userAge = userAge;
		this.userBio = userBio;
		this.userPseudo = userPseudo;
		this.userNaissance = userNaissance;
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.userDateInscription = userDateInscription;
		this.userAdminTypeImg = userAdminTypeImg;
		this.userAdminTypeBanner = userAdminTypeBanner;
		this.userAdminImg = userAdminImg;
		this.userAdminBanner = userAdminBanner;
	}
	
	public UserAdmin(int userLevel, boolean userCanModify, String userAdminGrade, String userAdminFonction,
			String userNom, String userPrenom, String userAge, String userBio, String userPseudo, String userNaissance,
			String userMail, String userPassword, String userRole, String userDateInscription, String userAdminTypeImg,
			String userAdminTypeBanner, Blob userAdminImg, Blob userAdminBanner) {
		this.idUser = 0;
		this.userLevel = userLevel;
		this.userCanModify = userCanModify;
		this.userAdminGrade = userAdminGrade;
		this.userAdminFonction = userAdminFonction;
		this.userNom = userNom;
		this.userPrenom = userPrenom;
		this.userAge = userAge;
		this.userBio = userBio;
		this.userPseudo = userPseudo;
		this.userNaissance = userNaissance;
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.userDateInscription = userDateInscription;
		this.userAdminTypeImg = userAdminTypeImg;
		this.userAdminTypeBanner = userAdminTypeBanner;
		this.userAdminImg = userAdminImg;
		this.userAdminBanner = userAdminBanner;
	}
	public UserAdmin() {
		this.idUser = 0;
		this.userLevel = 0;
		this.userCanModify = true;
		this.userAdminGrade = "";
		this.userAdminFonction = "";
		this.userNom = "";
		this.userPrenom = "";
		this.userAge = "";
		this.userBio = "";
		this.userPseudo = "";
		this.userNaissance = "";
		this.userMail = "";
		this.userPassword = "";
		this.userRole = "";
		this.userDateInscription = "";
		this.userAdminTypeImg = "";
		this.userAdminTypeBanner = "";
		this.userAdminImg = null;
		this.userAdminBanner = null;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public boolean isUserCanModify() {
		return userCanModify;
	}

	public void setUserCanModify(boolean userCanModify) {
		this.userCanModify = userCanModify;
	}

	public String getUserAdminGrade() {
		return userAdminGrade;
	}

	public void setUserAdminGrade(String userAdminGrade) {
		this.userAdminGrade = userAdminGrade;
	}

	public String getUserAdminFonction() {
		return userAdminFonction;
	}

	public void setUserAdminFonction(String userAdminFonction) {
		this.userAdminFonction = userAdminFonction;
	}

	public String getUserNom() {
		return userNom;
	}

	public void setUserNom(String userNom) {
		this.userNom = userNom;
	}

	public String getUserPrenom() {
		return userPrenom;
	}

	public void setUserPrenom(String userPrenom) {
		this.userPrenom = userPrenom;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getUserBio() {
		return userBio;
	}

	public void setUserBio(String userBio) {
		this.userBio = userBio;
	}

	public String getUserPseudo() {
		return userPseudo;
	}

	public void setUserPseudo(String userPseudo) {
		this.userPseudo = userPseudo;
	}

	public String getUserNaissance() {
		return userNaissance;
	}

	public void setUserNaissance(String userNaissance) {
		this.userNaissance = userNaissance;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserDateInscription() {
		return userDateInscription;
	}

	public void setUserDateInscription(String userDateInscription) {
		this.userDateInscription = userDateInscription;
	}

	public String getUserAdminTypeImg() {
		return userAdminTypeImg;
	}

	public void setUserAdminTypeImg(String userAdminTypeImg) {
		this.userAdminTypeImg = userAdminTypeImg;
	}

	public String getUserAdminTypeBanner() {
		return userAdminTypeBanner;
	}

	public void setUserAdminTypeBanner(String userAdminTypeBanner) {
		this.userAdminTypeBanner = userAdminTypeBanner;
	}

	public Blob getUserAdminImg() {
		return userAdminImg;
	}

	public void setUserAdminImg(Blob userAdminImg) {
		this.userAdminImg = userAdminImg;
	}

	public Blob getUserAdminBanner() {
		return userAdminBanner;
	}

	public void setUserAdminBanner(Blob userAdminBanner) {
		this.userAdminBanner = userAdminBanner;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
