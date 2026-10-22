package com.google.zxing.common;

import com.google.zxing.FormatException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final enum CharacterSetECI extends Enum<CharacterSetECI> {
    private static final /* synthetic */ CharacterSetECI[] $VALUES = null;
    public static final CharacterSetECI ASCII = null;
    public static final CharacterSetECI Big5 = null;
    public static final CharacterSetECI Cp1250 = null;
    public static final CharacterSetECI Cp1251 = null;
    public static final CharacterSetECI Cp1252 = null;
    public static final CharacterSetECI Cp1256 = null;
    public static final CharacterSetECI Cp437 = null;
    public static final CharacterSetECI EUC_KR = null;
    public static final CharacterSetECI GB18030 = null;
    public static final CharacterSetECI ISO8859_1 = null;
    public static final CharacterSetECI ISO8859_10 = null;
    public static final CharacterSetECI ISO8859_11 = null;
    public static final CharacterSetECI ISO8859_13 = null;
    public static final CharacterSetECI ISO8859_14 = null;
    public static final CharacterSetECI ISO8859_15 = null;
    public static final CharacterSetECI ISO8859_16 = null;
    public static final CharacterSetECI ISO8859_2 = null;
    public static final CharacterSetECI ISO8859_3 = null;
    public static final CharacterSetECI ISO8859_4 = null;
    public static final CharacterSetECI ISO8859_5 = null;
    public static final CharacterSetECI ISO8859_6 = null;
    public static final CharacterSetECI ISO8859_7 = null;
    public static final CharacterSetECI ISO8859_8 = null;
    public static final CharacterSetECI ISO8859_9 = null;
    private static final Map<String, CharacterSetECI> NAME_TO_ECI = null;
    public static final CharacterSetECI SJIS = null;
    public static final CharacterSetECI UTF8 = null;
    public static final CharacterSetECI UnicodeBigUnmarked = null;
    private static final Map<Integer, CharacterSetECI> VALUE_TO_ECI = null;
    private final String[] otherEncodingNames;
    private final int[] values;

    public static CharacterSetECI valueOf(String r1) {
        return (CharacterSetECI) Enum.valueOf(CharacterSetECI.class, r1);
    }

    public static CharacterSetECI[] values() {
        return (CharacterSetECI[]) $VALUES.clone();
    }

    static {
        CharacterSetECI r0 = new CharacterSetECI("Cp437", 0, new int[]{0, 2}, new String[0]);
        Cp437 = r0;
        CharacterSetECI r2 = new CharacterSetECI("ISO8859_1", 1, new int[]{1, 3}, new String[]{"ISO-8859-1"});
        ISO8859_1 = r2;
        CharacterSetECI r4 = new CharacterSetECI("ISO8859_2", 2, 4, new String[]{"ISO-8859-2"});
        ISO8859_2 = r4;
        CharacterSetECI r5 = new CharacterSetECI("ISO8859_3", 3, 5, new String[]{"ISO-8859-3"});
        ISO8859_3 = r5;
        CharacterSetECI r6 = new CharacterSetECI("ISO8859_4", 4, 6, new String[]{"ISO-8859-4"});
        ISO8859_4 = r6;
        CharacterSetECI r9 = new CharacterSetECI("ISO8859_5", 5, 7, new String[]{"ISO-8859-5"});
        ISO8859_5 = r9;
        CharacterSetECI r10 = new CharacterSetECI("ISO8859_6", 6, 8, new String[]{"ISO-8859-6"});
        ISO8859_6 = r10;
        CharacterSetECI r13 = new CharacterSetECI("ISO8859_7", 7, 9, new String[]{"ISO-8859-7"});
        ISO8859_7 = r13;
        CharacterSetECI r12 = new CharacterSetECI("ISO8859_8", 8, 10, new String[]{"ISO-8859-8"});
        ISO8859_8 = r12;
        CharacterSetECI r14 = new CharacterSetECI("ISO8859_9", 9, 11, new String[]{"ISO-8859-9"});
        ISO8859_9 = r14;
        CharacterSetECI r11 = new CharacterSetECI("ISO8859_10", 10, 12, new String[]{"ISO-8859-10"});
        ISO8859_10 = r11;
        CharacterSetECI r8 = new CharacterSetECI("ISO8859_11", 11, 13, new String[]{"ISO-8859-11"});
        ISO8859_11 = r8;
        CharacterSetECI r7 = new CharacterSetECI("ISO8859_13", 12, 15, new String[]{"ISO-8859-13"});
        ISO8859_13 = r7;
        CharacterSetECI r3 = new CharacterSetECI("ISO8859_14", 13, 16, new String[]{"ISO-8859-14"});
        ISO8859_14 = r3;
        CharacterSetECI r15 = new CharacterSetECI("ISO8859_15", 14, 17, new String[]{"ISO-8859-15"});
        ISO8859_15 = r15;
        CharacterSetECI r1 = new CharacterSetECI("ISO8859_16", 15, 18, new String[]{"ISO-8859-16"});
        ISO8859_16 = r1;
        CharacterSetECI r16 = new CharacterSetECI(StringUtils.SHIFT_JIS, 16, 20, new String[]{"Shift_JIS"});
        SJIS = r16;
        CharacterSetECI r17 = new CharacterSetECI("Cp1250", 17, 21, new String[]{"windows-1250"});
        Cp1250 = r17;
        CharacterSetECI r18 = new CharacterSetECI("Cp1251", 18, 22, new String[]{"windows-1251"});
        Cp1251 = r18;
        CharacterSetECI r19 = new CharacterSetECI("Cp1252", 19, 23, new String[]{"windows-1252"});
        Cp1252 = r19;
        CharacterSetECI r20 = new CharacterSetECI("Cp1256", 20, 24, new String[]{"windows-1256"});
        Cp1256 = r20;
        CharacterSetECI r21 = new CharacterSetECI("UnicodeBigUnmarked", 21, 25, new String[]{"UTF-16BE", "UnicodeBig"});
        UnicodeBigUnmarked = r21;
        CharacterSetECI r22 = new CharacterSetECI("UTF8", 22, 26, new String[]{"UTF-8"});
        UTF8 = r22;
        CharacterSetECI r23 = new CharacterSetECI("ASCII", 23, new int[]{27, 170}, new String[]{"US-ASCII"});
        ASCII = r23;
        CharacterSetECI r24 = new CharacterSetECI("Big5", 24, 28);
        Big5 = r24;
        CharacterSetECI r25 = new CharacterSetECI("GB18030", 25, 29, new String[]{StringUtils.GB2312, "EUC_CN", "GBK"});
        GB18030 = r25;
        CharacterSetECI r26 = new CharacterSetECI("EUC_KR", 26, 30, new String[]{"EUC-KR"});
        EUC_KR = r26;
        $VALUES = new CharacterSetECI[]{r0, r2, r4, r5, r6, r9, r10, r13, r12, r14, r11, r8, r7, r3, r15, r1, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26};
        VALUE_TO_ECI = new HashMap();
        NAME_TO_ECI = new HashMap();
        CharacterSetECI[] r27 = values();
        int r28 = r27.length;
        int r29 = 0;
    L3:
        if (r29 >= r28) goto L11;
        CharacterSetECI r30 = r27[r29];
        int[] r31 = r30.values;
        int r32 = r31.length;
        int r33 = 0;
    L5:
        if (r33 >= r32) goto L7;
        VALUE_TO_ECI.put(Integer.valueOf(r31[r33]), r30);
        r33 = r33 + 1;
        goto L5
    L7:
        NAME_TO_ECI.put(r30.name(), r30);
        String[] r34 = r30.otherEncodingNames;
        int r35 = r34.length;
        int r36 = 0;
    L8:
        if (r36 >= r35) goto L10;
        NAME_TO_ECI.put(r34[r36], r30);
        r36 = r36 + 1;
        goto L8
    L10:
        r29 = r29 + 1;
        goto L3
    }

    private CharacterSetECI(String r3, int r4, int r5) {
        this(r3, r4, new int[]{r5}, new String[0]);
    }

    private CharacterSetECI(String r1, int r2, int r3, String... r4) {
        super(r1, r2);
        this.values = new int[]{r3};
        this.otherEncodingNames = r4;
    }

    private CharacterSetECI(String r1, int r2, int[] r3, String... r4) {
        super(r1, r2);
        this.values = r3;
        this.otherEncodingNames = r4;
    }

    public int getValue() {
        return this.values[0];
    }

    public static CharacterSetECI getCharacterSetECIByValue(int r1) throws FormatException {
        if (r1 < 0) goto L8;
        if (r1 >= 900) goto L8;
        return VALUE_TO_ECI.get(Integer.valueOf(r1));
    L8:
        throw FormatException.getFormatInstance();
    }

    public static CharacterSetECI getCharacterSetECIByName(String r1) {
        return NAME_TO_ECI.get(r1);
    }
}
