package obric.widget.letters;

import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class LettersConfig {
    private static String[] ENGLISH_LETTERS;
    private static String[] JAPANESE_LETTERS;
    private static String[] KOREA_LETTERS;
    private static String[] RUSSIAN_LETTERS;

    public LettersConfig() {
    }

    static {
        ENGLISH_LETTERS = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "#"};
        KOREA_LETTERS = new String[]{"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ".B", "D", ".E", "G", ".H", "J", ".K", "M", ".N", "P", ".Q", ExifInterface.LATITUDE_SOUTH, ".T", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ".W", "Y", ".Z", "#"};
        JAPANESE_LETTERS = new String[]{"あ", "か", "さ", "た", "な", "は", "ま", "や", "ら", "わ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ".B", "D", ".E", "G", ".H", "J", ".K", "M", ".N", "P", ".Q", ExifInterface.LATITUDE_SOUTH, ".T", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ".W", "Y", ".Z", "#"};
        RUSSIAN_LETTERS = new String[]{"А", ".Б", "Г", ".Д", "З", ".И", "К", ".Л", "Н", ".О", "С", ".Т", "Ф", ".Х", "Ч", ".Ш", "ы", ".ь", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ".B", "D", ".E", "G", ".H", "J", ".K", "M", ".N", "P", ".Q", ExifInterface.LATITUDE_SOUTH, ".T", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ".W", "Y", ".Z", "#"};
    }

    public static String[] lettersByLanguage(String language) {
        if (Locale.KOREA.getLanguage().equals(language) == false) goto L7;
        return KOREA_LETTERS;
    L7:
        if (Locale.JAPAN.getLanguage().equals(language) == false) goto L11;
        return JAPANESE_LETTERS;
    L11:
        if ("ru".equals(language) == false) goto L15;
        return RUSSIAN_LETTERS;
    L15:
        return ENGLISH_LETTERS;
    }

    public static boolean isLocaleLetter(String language, int index) {
        if (Locale.KOREA.getLanguage().equals(language) == false) goto L10;
        if (index >= 14) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (Locale.JAPAN.getLanguage().equals(language) == false) goto L17;
        if (index >= 10) goto L15;
        return true;
    L15:
        return false;
    L17:
        if ("ru".equals(language) == true) goto L19;
        return false;
    L19:
        if (index >= 5) goto L22;
        return true;
    L22:
        return false;
    }

    public static void setRussianLetterWithEnglish() {
        RUSSIAN_LETTERS = ENGLISH_LETTERS;
    }
}
