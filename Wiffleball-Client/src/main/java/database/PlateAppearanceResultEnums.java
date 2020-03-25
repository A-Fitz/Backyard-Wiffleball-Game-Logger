package database;

import java.util.HashMap;
import java.util.Map;

public class PlateAppearanceResultEnums {
    public static final String WALK = "WALK";
    public static final String STRIKEOUT = "STRIKEOUT";
    public static final String FIELDOUT = "FIELDOUT";
    public static final String SINGLE = "SINGLE";
    public static final String DOUBLE = "DOUBLE";
    public static final String TRIPLE = "TRIPLE";
    public static final String HOMERUN = "HOMERUN";

    public static Map<String, Integer> RESULT_TYPE_TO_RESULT_ID_MAP;
    static {
        RESULT_TYPE_TO_RESULT_ID_MAP = new HashMap<>();
        RESULT_TYPE_TO_RESULT_ID_MAP.put(WALK, 1);
        RESULT_TYPE_TO_RESULT_ID_MAP.put(STRIKEOUT, 2);
        RESULT_TYPE_TO_RESULT_ID_MAP.put(FIELDOUT, 3);
        RESULT_TYPE_TO_RESULT_ID_MAP.put(SINGLE, 4);
        RESULT_TYPE_TO_RESULT_ID_MAP.put(DOUBLE, 5);
        RESULT_TYPE_TO_RESULT_ID_MAP.put(TRIPLE, 6);
        RESULT_TYPE_TO_RESULT_ID_MAP.put(HOMERUN, 7);
    }

    public static Map<Integer, String> RESULT_ID_TO_RESULT_TYPE_MAP;
    static {
        RESULT_ID_TO_RESULT_TYPE_MAP = new HashMap<>();
        RESULT_ID_TO_RESULT_TYPE_MAP.put(1, WALK);
        RESULT_ID_TO_RESULT_TYPE_MAP.put(2, STRIKEOUT);
        RESULT_ID_TO_RESULT_TYPE_MAP.put(3, FIELDOUT);
        RESULT_ID_TO_RESULT_TYPE_MAP.put(4, SINGLE);
        RESULT_ID_TO_RESULT_TYPE_MAP.put(5, DOUBLE);
        RESULT_ID_TO_RESULT_TYPE_MAP.put(6, TRIPLE);
        RESULT_ID_TO_RESULT_TYPE_MAP.put(7, HOMERUN);
    }
}
