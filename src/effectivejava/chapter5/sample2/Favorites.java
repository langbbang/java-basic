package effectivejava.chapter5.sample2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Favorites {
    private final Map<Class<?>, Object> favorites = new HashMap<>();

    /**
     * Objects.requireNonNull(type) : type이 null 일 경우 NPE
     * instance가 동일 타입인지 확인 후 put
     */
    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

}
