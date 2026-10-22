package com.obric.oui.indexscrollbar;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AlphabetsConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0005J\u0016\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0005R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/oui/indexscrollbar/AlphabetsConfig;", "", "()V", "ENGLISH_ALPHABETS", "", "", "[Ljava/lang/String;", "JAPAN_ALPHABETS", "KOREA_ALPHABETS", "RUSSIAN_ALPHABETS", "SURNAME_LETTER", "", "SURNAME_WORD", "mNorussian", "", "alphabetsByLanguage", "language", "(Ljava/lang/String;)[Ljava/lang/String;", "isAlphabetsSupportedByLanguage", "isDisabled", "alphabet", "isJapaneseAlphabet", "isKoreaAlphabet", "isPlaceholder", "isRussianAlphabet", "isSurnameSupportedByLanguage", "isSymbol", "numRowsByLanguage", "", "setRussianAlphabetWithEnglish", "", "surnameTypeSupportedByLanguage", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AlphabetsConfig {
    private static final String[] ENGLISH_ALPHABETS = null;
    public static final AlphabetsConfig INSTANCE = null;
    private static final String[] JAPAN_ALPHABETS = null;
    private static final String[] KOREA_ALPHABETS = null;
    private static String[] RUSSIAN_ALPHABETS = null;
    public static final int SURNAME_LETTER = 0;
    public static final int SURNAME_WORD = 1;
    private static boolean mNorussian;

    private AlphabetsConfig() {
    }

    static {
        INSTANCE = new AlphabetsConfig();
        ENGLISH_ALPHABETS = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", ".>"};
        KOREA_ALPHABETS = new String[]{"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", ".~", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", ".>"};
        JAPAN_ALPHABETS = new String[]{"あ", "い", "う", "え", "お", "か", "き", "く", "け", "こ", "さ", "し", "す", "せ", "そ", "た", "ち", "つ", "て", "と", "な", "に", "ぬ", "ね", "の", "は", "ひ", "ふ", "へ", "ほ", "ま", "み", "む", "め", "も", "や", "*い", "ゆ", "*え", "よ", "ら", "り", "る", "れ", "ろ", "わ", "*い", "*う", "*え", "を", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", ".~", ".~", ".~", ".>"};
        RUSSIAN_ALPHABETS = new String[]{"А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я", ".~", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", ".>"};
    }

    public final float numRowsByLanguage(String r3) {
        Intrinsics.checkNotNullParameter(r3, "language");
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r3) == false) goto L6;
        return 9.0f;
    L6:
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r3) == false) goto L9;
    L12:
        return 12.5f;
    L9:
        if (Intrinsics.areEqual("ru", r3) == true) goto L11;
        return 9.0f;
    L11:
        if (mNorussian == false) goto L12;
        return 9.0f;
    }

    public final String[] alphabetsByLanguage(String r1) {
        Intrinsics.checkNotNullParameter(r1, "language");
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r1) == false) goto L6;
        return KOREA_ALPHABETS;
    L6:
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r1) == false) goto L9;
        return JAPAN_ALPHABETS;
    L9:
        if (Intrinsics.areEqual("ru", r1) == false) goto L12;
        return RUSSIAN_ALPHABETS;
    L12:
        return ENGLISH_ALPHABETS;
    }

    public final boolean isAlphabetsSupportedByLanguage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "language");
        if (Intrinsics.areEqual(Locale.CHINESE.getLanguage(), r2) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(Locale.ENGLISH.getLanguage(), r2) == false) goto L9;
        return true;
    L9:
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r2) == false) goto L12;
        return true;
    L12:
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r2) == false) goto L15;
        return true;
    L15:
        if (Intrinsics.areEqual("ru", r2) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final boolean isSurnameSupportedByLanguage(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "language");
        Intrinsics.checkNotNullParameter(r5, "alphabet");
        if (Intrinsics.areEqual(Locale.CHINESE.getLanguage(), r4) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(Locale.ENGLISH.getLanguage(), r4) == false) goto L9;
        return true;
    L9:
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r4) == false) goto L15;
        if (isKoreaAlphabet(r5) == false) goto L23;
        return true;
    L23:
        return false;
    L15:
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r4) == false) goto L20;
        if (isJapaneseAlphabet(r5) == false) goto L23;
        return true;
    L20:
        if (Intrinsics.areEqual("ru", r4) == false) goto L23;
        if (isRussianAlphabet(r5) == false) goto L23;
        return true;
    }

    public final int surnameTypeSupportedByLanguage(String r3) {
        Intrinsics.checkNotNullParameter(r3, "language");
        if (Intrinsics.areEqual(Locale.CHINESE.getLanguage(), r3) == false) goto L6;
        return 0;
    L6:
        if (Intrinsics.areEqual(Locale.ENGLISH.getLanguage(), r3) == false) goto L9;
    L17:
        return 1;
    L9:
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r3) == false) goto L12;
        return 0;
    L12:
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r3) == true) goto L17;
        if (Intrinsics.areEqual("ru", r3) == true) goto L17;
        return 0;
    }

    public final boolean isSymbol(String r1) {
        Intrinsics.checkNotNullParameter(r1, "alphabet");
        return Intrinsics.areEqual(".>", r1);
    }

    public final boolean isPlaceholder(String r1) {
        Intrinsics.checkNotNullParameter(r1, "alphabet");
        return Intrinsics.areEqual(".~", r1);
    }

    public final boolean isDisabled(String r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r4, "*", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isRussianAlphabet(String r3) {
        Intrinsics.checkNotNullParameter(r3, "alphabet");
        String[] r2 = (String[]) Arrays.copyOfRange(RUSSIAN_ALPHABETS, 0, 32);
        return Arrays.asList(Arrays.copyOf(r2, r2.length)).contains(r3);
    }

    private final boolean isKoreaAlphabet(String r3) {
        String[] r2 = (String[]) Arrays.copyOfRange(KOREA_ALPHABETS, 0, 14);
        return Arrays.asList(Arrays.copyOf(r2, r2.length)).contains(r3);
    }

    public final boolean isJapaneseAlphabet(String r3) {
        Intrinsics.checkNotNullParameter(r3, "alphabet");
        String[] r2 = (String[]) Arrays.copyOfRange(JAPAN_ALPHABETS, 0, 50);
        return Arrays.asList(Arrays.copyOf(r2, r2.length)).contains(r3);
    }

    public final void setRussianAlphabetWithEnglish() {
        RUSSIAN_ALPHABETS = ENGLISH_ALPHABETS;
        mNorussian = true;
    }
}
