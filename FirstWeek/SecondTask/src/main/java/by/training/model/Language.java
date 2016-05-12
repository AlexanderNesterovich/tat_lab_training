package by.training.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/12/2016.
 */
public enum Language {
    ENGLISH("English"),
    RUSSIAN("Russian"),
    SPANISH("Spanish");

    private static final Map<String, Language> nameToValueMap;

    static {
        nameToValueMap = new HashMap<String, Language>();
        for (Language lang : EnumSet.allOf(Language.class)) {
            nameToValueMap.put(lang.friendlyName, lang);
        }
    }

    private final String friendlyName;

    Language(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public static Language fromFriendlyName(String friendlyName) {
        return nameToValueMap.get(friendlyName);
    }
}
