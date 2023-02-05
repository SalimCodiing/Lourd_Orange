package controller;

import java.sql.Blob;

public class UserSimple {
	private int idUser,userLevel;
	private int userSimpleCanModify;
	private String  userSimplePlateforme,userNom, userPrenom, userAge, userBio, userNaissance
	,userPseudo, userMail, userPassword, userRole, userDateInscription;
	
	public UserSimple(int idUser, int userLevel, int userSimpleCanModify, String userSimplePlateforme, String userNom,
			String userPrenom, String userAge, String userBio, String userNaissance, String userPseudo, String userMail,
			String userPassword, String userRole, String userDateInscription) {
		this.idUser = idUser;
		this.userLevel = userLevel;
		this.userSimpleCanModify = userSimpleCanModify;
		this.userSimplePlateforme = userSimplePlateforme;
		this.userNom = userNom;
		this.userPrenom = userPrenom;
		this.userAge = userAge;
		this.userBio = userBio;
		this.userNaissance = userNaissance;
		this.userPseudo = userPseudo;
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.userDateInscription = userDateInscription;
	}
	public UserSimple(int userLevel, int userSimpleCanModify, String userSimplePlateforme, String userNom,
			String userPrenom, String userAge, String userBio, String userNaissance, String userPseudo, String userMail,
			String userPassword, String userRole, String userDateInscription) {
		this.idUser = 0;
		this.userLevel = userLevel;
		this.userSimpleCanModify = userSimpleCanModify;
		this.userSimplePlateforme = userSimplePlateforme;
		this.userNom = userNom;
		this.userPrenom = userPrenom;
		this.userAge = userAge;
		this.userBio = userBio;
		this.userNaissance = userNaissance;
		this.userPseudo = userPseudo;
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.userDateInscription = userDateInscription;
	}

	public UserSimple() {
		this.idUser = 0;
		this.userLevel = 0;
		this.userSimpleCanModify = 0;
		this.userSimplePlateforme = "";
		this.userNom = "";
		this.userPrenom = "";
		this.userAge = "";
		this.userBio = "";
		this.userNaissance = "";
		this.userPseudo = "";
		this.userMail = "";
		this.userPassword = "";
		this.userRole = "";
		this.userDateInscription = "";
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
	public int getUserSimpleCanModify() {
		return userSimpleCanModify;
	}
	public void setUserSimpleCanModify(int userSimpleCanModify) {
		this.userSimpleCanModify = userSimpleCanModify;
	}
	public String getUserSimplePlateforme() {
		return userSimplePlateforme;
	}
	public void setUserSimplePlateforme(String userSimplePlateforme) {
		this.userSimplePlateforme = userSimplePlateforme;
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
	public String getUserNaissance() {
		return userNaissance;
	}
	public void setUserNaissance(String userNaissance) {
		this.userNaissance = userNaissance;
	}
	public String getUserPseudo() {
		return userPseudo;
	}
	public void setUserPseudo(String userPseudo) {
		this.userPseudo = userPseudo;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
