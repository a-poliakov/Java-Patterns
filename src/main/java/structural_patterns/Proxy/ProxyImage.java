package structural_patterns.Proxy;

import java.net.URL;

/**
 * Created by admin on 04.07.2017.
 */
public class ProxyImage implements Image{
    private URL url;

    public ProxyImage(URL url) {
        this.url = url;
    }

    public void display() {
        RealImage image = new RealImage(url);
        image.display();
    }
}
