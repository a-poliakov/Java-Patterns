package structural_patterns.Proxy;

import java.net.URL;

/**
 * Прокси-объект изображения.
 * До момента показа реальное изображение в память не загружается, храниться только url изображения
 * @since 04.07.2017
 * @author apolyakov
 */
public class ProxyImage implements Image {
    private URL url;

    public ProxyImage(URL url) {
        this.url = url;
    }

    public void display() {
        RealImage image = new RealImage(url);
        image.display();
    }
}
