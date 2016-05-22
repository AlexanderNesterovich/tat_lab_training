package by.training.bean;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/12/2016.
 */
public enum Genre {

    FANTASY("Fantasy"),
    SCIFI("Sci-Fi"),
    MEMOIR("Memoir"),
    BIOGRAPHY("Biography"),
    PHILOSOPHY("Philosophy");

    private static final Map<String, Genre> nameToValueMap;

    static {
        nameToValueMap = new HashMap<String, Genre>();
        for (Genre genre : EnumSet.allOf(Genre.class)) {
            nameToValueMap.put(genre.friendlyName, genre);
        }
    }

    private final String friendlyName;

    Genre(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public static Genre fromFriendlyName(String friendlyName) {
        return nameToValueMap.get(friendlyName);
    }

}
