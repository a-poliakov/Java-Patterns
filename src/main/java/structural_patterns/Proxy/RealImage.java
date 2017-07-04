package structural_patterns.Proxy;

import java.net.URL;

/**
 * Created by admin on 04.07.2017.
 */
public class RealImage implements Image {
    public RealImage(URL url) {
        loadImage(url);
    }

    public void display() {
        // Рисуем изображение на экране
    }

    private void loadImage(URL url){
        // Загружаем изображение по указанному URL
    }
}
