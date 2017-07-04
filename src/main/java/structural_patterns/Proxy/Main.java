package structural_patterns.Proxy;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by admin on 04.07.2017.
 */
public class Main {
    public static void main(String[] args) throws MalformedURLException {
        Image proxy = new ProxyImage(new URL("http://yandex.ru"));
        ImageManager manager = new ImageManager(proxy, null);
        manager.renderImageList();
    }
}
