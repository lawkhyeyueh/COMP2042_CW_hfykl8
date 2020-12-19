package Deleted_Discarded;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class only extends actor since it is using the setImage method. 
 * The setIMage method is from ImageView which actor extends
 * 
 * @author lawkhyeyueh
 * @version final 6.9
 * @since 2020-12-12
 *
 */

public class BackgroundImage extends ImageView{

	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
		
	}

}
