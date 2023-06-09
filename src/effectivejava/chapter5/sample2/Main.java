package effectivejava.chapter5.sample2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Favorites favorites = new Favorites();

        favorites.putFavorite(String.class, "AAAA");
        favorites.putFavorite(Integer.class, 1);
        favorites.putFavorite(String.class, "BBBB");

        System.out.println(favorites.getFavorite(String.class));
    }
}