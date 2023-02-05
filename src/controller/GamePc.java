package controller;

public class GamePc {

	private int idGame;
	private float gamePcPrix, gamePcTaille;
	private String  gamePcModeleEco, gamePcOs, gamePcProc, gamePcCg, gameName,
	gameDescription, gameGenre, gameAvis, gameClassification, gameMode, gameImg, gameTrailer,gameImgOther;
	
	
	public GamePc(int idGame, float gamePcPrix, float gamePcTaille, String gamePcModeleEco, String gamePcOs,
			String gamePcProc, String gamePcCg, String gameName, String gameDescription, String gameGenre,
			String gameAvis, String gameClassification, String gameMode, String gameImg, String gameTrailer,
			String gameImgOther) {
		this.idGame = idGame;
		this.gamePcPrix = gamePcPrix;
		this.gamePcTaille = gamePcTaille;
		this.gamePcModeleEco = gamePcModeleEco;
		this.gamePcOs = gamePcOs;
		this.gamePcProc = gamePcProc;
		this.gamePcCg = gamePcCg;
		this.gameName = gameName;
		this.gameDescription = gameDescription;
		this.gameGenre = gameGenre;
		this.gameAvis = gameAvis;
		this.gameClassification = gameClassification;
		this.gameMode = gameMode;
		this.gameImg = gameImg;
		this.gameTrailer = gameTrailer;
		this.gameImgOther = gameImgOther;
	}
	
	public GamePc(float gamePcPrix, float gamePcTaille, String gamePcModeleEco, String gamePcOs,
			String gamePcProc, String gamePcCg, String gameName, String gameDescription, String gameGenre,
			String gameAvis, String gameClassification, String gameMode, String gameImg, String gameTrailer,
			String gameImgOther) {
		this.idGame = 0;
		this.gamePcPrix = gamePcPrix;
		this.gamePcTaille = gamePcTaille;
		this.gamePcModeleEco = gamePcModeleEco;
		this.gamePcOs = gamePcOs;
		this.gamePcProc = gamePcProc;
		this.gamePcCg = gamePcCg;
		this.gameName = gameName;
		this.gameDescription = gameDescription;
		this.gameGenre = gameGenre;
		this.gameAvis = gameAvis;
		this.gameClassification = gameClassification;
		this.gameMode = gameMode;
		this.gameImg = gameImg;
		this.gameTrailer = gameTrailer;
		this.gameImgOther = gameImgOther;
	}
	public GamePc() {
		this.idGame = 0;
		this.gamePcPrix = 0;
		this.gamePcTaille = 0;
		this.gamePcModeleEco = "";
		this.gamePcOs = "";
		this.gamePcProc = "";
		this.gamePcCg = "";
		this.gameName = "";
		this.gameDescription = "";
		this.gameGenre = "";
		this.gameAvis = "";
		this.gameClassification = "";
		this.gameMode = "";
		this.gameImg = "";
		this.gameTrailer = "";
		this.gameImgOther = "";
	}

	public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	public float getGamePcPrix() {
		return gamePcPrix;
	}

	public void setGamePcPrix(float gamePcPrix) {
		this.gamePcPrix = gamePcPrix;
	}

	public float getGamePcTaille() {
		return gamePcTaille;
	}

	public void setGamePcTaille(float gamePcTaille) {
		this.gamePcTaille = gamePcTaille;
	}

	public String getGamePcModeleEco() {
		return gamePcModeleEco;
	}

	public void setGamePcModeleEco(String gamePcModeleEco) {
		this.gamePcModeleEco = gamePcModeleEco;
	}

	public String getGamePcOs() {
		return gamePcOs;
	}

	public void setGamePcOs(String gamePcOs) {
		this.gamePcOs = gamePcOs;
	}

	public String getGamePcProc() {
		return gamePcProc;
	}

	public void setGamePcProc(String gamePcProc) {
		this.gamePcProc = gamePcProc;
	}

	public String getGamePcCg() {
		return gamePcCg;
	}

	public void setGamePcCg(String gamePcCg) {
		this.gamePcCg = gamePcCg;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameDescription() {
		return gameDescription;
	}

	public void setGameDescription(String gameDescription) {
		this.gameDescription = gameDescription;
	}

	public String getGameGenre() {
		return gameGenre;
	}

	public void setGameGenre(String gameGenre) {
		this.gameGenre = gameGenre;
	}

	public String getGameAvis() {
		return gameAvis;
	}

	public void setGameAvis(String gameAvis) {
		this.gameAvis = gameAvis;
	}

	public String getGameClassification() {
		return gameClassification;
	}

	public void setGameClassification(String gameClassification) {
		this.gameClassification = gameClassification;
	}

	public String getGameMode() {
		return gameMode;
	}

	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}

	public String getGameImg() {
		return gameImg;
	}

	public void setGameImg(String gameImg) {
		this.gameImg = gameImg;
	}

	public String getGameTrailer() {
		return gameTrailer;
	}

	public void setGameTrailer(String gameTrailer) {
		this.gameTrailer = gameTrailer;
	}

	public String getGameImgOther() {
		return gameImgOther;
	}

	public void setGameImgOther(String gameImgOther) {
		this.gameImgOther = gameImgOther;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
