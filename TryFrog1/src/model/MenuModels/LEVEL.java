package model.MenuModels;

//This is a class for different frog that can be choose by user.
public enum LEVEL {

	LAZY("view/ViewResources/levelchooser/FrogB.png"),
	AVERAGE("view/ViewResources/levelchooser/FrogA.png"),
	CRAZY("view/ViewResources/levelchooser/FrogC.png");
	
	
	private String urlLevel;
	
	private LEVEL(String urlLevel) {
		this.urlLevel= urlLevel;
	}
	
	public String getUrl() {
		return this.urlLevel;
	}
	
	public String getLevel() {
		return this.name();
	}
}

