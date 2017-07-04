package structural_patterns.Proxy;

import java.net.URL;
import java.util.List;

/**
 * Created by admin on 04.07.2017.
 */
public class ImageManager {
    private Image image;
    private List<URL> urlsToShow;

    public ImageManager(Image image, List<URL> urlsToShow) {
        this.image = image;
        this.urlsToShow = urlsToShow;
    }

    public void renderImagePage(){

    }

    public void renderImageList(){

    }

    public void reactUserInput(){

    }
}
