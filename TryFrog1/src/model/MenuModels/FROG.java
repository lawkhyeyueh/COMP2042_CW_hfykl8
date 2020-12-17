package model.MenuModels;

public enum FROG {
	
	frogA("view/resources/levelchooser/FrogA.png"),
	frogB("view/resources/levelchooser/FrogB.png"),
	frogC("view/resources/levelchooser/FrogC.png"),
	frogD("view/resources/levelchooser/FrogD.png");
	
	private String urlFrog;
	
	private FROG(String urlFrog) {
		this.urlFrog = urlFrog;
	}
	
	public String getUrl() {
		return this.urlFrog;
	}
	
}
