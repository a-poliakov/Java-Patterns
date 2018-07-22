package structural_patterns.Proxy;

import java.net.URL;
import java.util.List;

/**
 * Менеджер изображений
 * @since 04.07.2017
 * @author apolyakov
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
