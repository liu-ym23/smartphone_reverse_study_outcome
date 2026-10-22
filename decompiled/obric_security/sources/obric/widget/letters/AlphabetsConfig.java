package obric.widget.letters;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class AlphabetsConfig {
    private static String[] ENGLISH_ALPHABETS = null;
    private static String[] JAPAN_ALPHABETS = null;
    private static String[] KOREA_ALPHABETS = null;
    private static String[] RUSSIAN_ALPHABETS = null;
    public static final int SURNAME_LETTER = 0;
    public static final int SURNAME_WORD = 1;
    private static boolean mNorussian = false;

    public AlphabetsConfig() {
    }

    static {
        ENGLISH_ALPHABETS = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", ".>"};
        KOREA_ALPHABETS = new String[]{"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", ".~", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", ".>"};
        JAPAN_ALPHABETS = new String[]{"あ", "い", "う", "え", "お", "か", "き", "く", "け", "こ", "さ", "し", "す", "せ", "そ", "た", "ち", "つ", "て", "と", "な", "に", "ぬ", "ね", "の", "は", "ひ", "ふ", "へ", "ほ", "ま", "み", "む", "め", "も", "や", "*い", "ゆ", "*え", "よ", "ら", "り", "る", "れ", "ろ", "わ", "*い", "*う", "*え", "を", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", ".~", ".~", ".~", ".>"};
        RUSSIAN_ALPHABETS = new String[]{"А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я", ".~", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", ".>"};
    }

    public static float numRowsByLanguage(String language) {
        if (Locale.KOREA.getLanguage().equals(language) == false) goto L6;
        return 9.0f;
    L6:
        if (Locale.JAPAN.getLanguage().equals(language) == false) goto L9;
        return 12.5f;
    L9:
        if ("ru".equals(language) == true) goto L11;
        return 9.0f;
    L11:
        if (mNorussian == false) goto L13;
        return 9.0f;
    L13:
        return 12.5f;
    }

    public static String[] alphabetsByLanguage(String language) {
        if (Locale.KOREA.getLanguage().equals(language) == false) goto L7;
        return KOREA_ALPHABETS;
    L7:
        if (Locale.JAPAN.getLanguage().equals(language) == false) goto L11;
        return JAPAN_ALPHABETS;
    L11:
        if ("ru".equals(language) == false) goto L15;
        return RUSSIAN_ALPHABETS;
    L15:
        return ENGLISH_ALPHABETS;
    }

    public static boolean isAlphabetsSupportedByLanguage(String language) {
        if (Locale.CHINESE.getLanguage().equals(language) == false) goto L6;
        return true;
    L6:
        if (Locale.ENGLISH.getLanguage().equals(language) == false) goto L9;
        return true;
    L9:
        if (Locale.KOREA.getLanguage().equals(language) == false) goto L12;
        return true;
    L12:
        if (Locale.JAPAN.getLanguage().equals(language) == false) goto L15;
        return true;
    L15:
        if ("ru".equals(language) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public static boolean isSurnameSupportedByLanguage(String language, String alphabet) {
        if (Locale.CHINESE.getLanguage().equals(language) == false) goto L6;
        return true;
    L6:
        if (Locale.ENGLISH.getLanguage().equals(language) == false) goto L9;
        return true;
    L9:
        if (Locale.KOREA.getLanguage().equals(language) == false) goto L15;
        if (isKoreaAlphabet(alphabet) == false) goto L13;
        return true;
    L13:
        return false;
    L15:
        if (Locale.JAPAN.getLanguage().equals(language) == false) goto L21;
        if (isJapaneseAlphabet(alphabet) == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        if ("ru".equals(language) == true) goto L23;
    L25:
        return false;
    L23:
        if (isRussianAlphabet(alphabet) == false) goto L25;
        return true;
    }

    public static int surnameTypeSupportedByLanguage(String language) {
        if (Locale.CHINESE.getLanguage().equals(language) == false) goto L6;
        return 0;
    L6:
        if (Locale.ENGLISH.getLanguage().equals(language) == false) goto L9;
        return 1;
    L9:
        if (Locale.KOREA.getLanguage().equals(language) == false) goto L12;
        return 0;
    L12:
        if (Locale.JAPAN.getLanguage().equals(language) == false) goto L15;
        return 1;
    L15:
        if ("ru".equals(language) == false) goto L17;
        return 1;
    L17:
        return 0;
    }

    public static boolean isSymbol(String alphabet) {
        return ".>".equals(alphabet);
    }

    public static boolean isPlaceholder(String alphabet) {
        return ".~".equals(alphabet);
    }

    public static boolean isDisabled(String alphabet) {
        if (alphabet != null) goto L4;
    L6:
        return false;
    L4:
        if (alphabet.startsWith("*") == false) goto L6;
        return true;
    }

    public static boolean isRussianAlphabet(String alphabet) {
        return Arrays.asList((String[]) Arrays.copyOfRange(RUSSIAN_ALPHABETS, 0, 32)).contains(alphabet);
    }

    private static boolean isKoreaAlphabet(String alphabet) {
        return Arrays.asList((String[]) Arrays.copyOfRange(KOREA_ALPHABETS, 0, 14)).contains(alphabet);
    }

    public static boolean isJapaneseAlphabet(String alphabet) {
        return Arrays.asList((String[]) Arrays.copyOfRange(JAPAN_ALPHABETS, 0, 50)).contains(alphabet);
    }

    public static void setRussianAlphabetWithEnglish() {
        RUSSIAN_ALPHABETS = ENGLISH_ALPHABETS;
        mNorussian = true;
    }
}
