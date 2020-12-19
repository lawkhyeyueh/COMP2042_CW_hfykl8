package model.MenuModels;

/**
 * This is a class for different frogs that can be chosen by the user
 * 
 * @author lawkhyeyueh
 * @version final 6.9
 * @since 2020-12-12
 *
 */

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

