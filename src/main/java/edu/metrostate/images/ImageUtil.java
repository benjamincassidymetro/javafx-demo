package edu.metrostate.images;

import javafx.scene.image.Image;

import java.net.URL;

public class ImageUtil {

    public static Image keyboardImage() {
        URL url = ImageUtil.class.getResource("keyboard.png");
        return new Image(url.toString());
    }
}
