package controller;

public class GameConsole {
	private int idGame;
	private float gameCsPrix, gameCsTaille;
	private String  gameCsSupport, gameCsDateSortie, gameCsModeleEco, gameName, gameDescription, gameGenre,
	gameAvis, gameClassification, gameMode, gameImg, gameTrailer,gameImgOther;
	
	
	public GameConsole(int idGame, float gameCsPrix, float gameCsTaille, String gameCsSupport, String gameCsDateSortie,
			String gameCsModeleEco, String gameName, String gameDescription, String gameGenre, String gameAvis,
			String gameClassification, String gameMode, String gameImg, String gameTrailer, String gameImgOther) {
		this.idGame = idGame;
		this.gameCsPrix = gameCsPrix;
		this.gameCsTaille = gameCsTaille;
		this.gameCsSupport = gameCsSupport;
		this.gameCsDateSortie = gameCsDateSortie;
		this.gameCsModeleEco = gameCsModeleEco;
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
	
	public GameConsole(float gameCsPrix, float gameCsTaille, String gameCsSupport, String gameCsDateSortie,
			String gameCsModeleEco, String gameName, String gameDescription, String gameGenre, String gameAvis,
			String gameClassification, String gameMode, String gameImg, String gameTrailer, String gameImgOther) {
		this.idGame = 0;
		this.gameCsPrix = gameCsPrix;
		this.gameCsTaille = gameCsTaille;
		this.gameCsSupport = gameCsSupport;
		this.gameCsDateSortie = gameCsDateSortie;
		this.gameCsModeleEco = gameCsModeleEco;
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
	
	public GameConsole() {
		this.idGame = 0;
		this.gameCsPrix = 0;
		this.gameCsTaille = 0;
		this.gameCsSupport = "";
		this.gameCsDateSortie = "";
		this.gameCsModeleEco = "";
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

	public float getGameCsPrix() {
		return gameCsPrix;
	}

	public void setGameCsPrix(float gameCsPrix) {
		this.gameCsPrix = gameCsPrix;
	}

	public float getGameCsTaille() {
		return gameCsTaille;
	}

	public void setGameCsTaille(float gameCsTaille) {
		this.gameCsTaille = gameCsTaille;
	}

	public String getGameCsSupport() {
		return gameCsSupport;
	}

	public void setGameCsSupport(String gameCsSupport) {
		this.gameCsSupport = gameCsSupport;
	}

	public String getGameCsDateSortie() {
		return gameCsDateSortie;
	}

	public void setGameCsDateSortie(String gameCsDateSortie) {
		this.gameCsDateSortie = gameCsDateSortie;
	}

	public String getGameCsModeleEco() {
		return gameCsModeleEco;
	}

	public void setGameCsModeleEco(String gameCsModeleEco) {
		this.gameCsModeleEco = gameCsModeleEco;
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
