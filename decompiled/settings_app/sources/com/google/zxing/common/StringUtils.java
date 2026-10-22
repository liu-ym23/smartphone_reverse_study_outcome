package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS = false;
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING = null;
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";

    static {
        String r0 = Charset.defaultCharset().name();
        PLATFORM_DEFAULT_ENCODING = r0;
        if (SHIFT_JIS.equalsIgnoreCase(r0) == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        ASSUME_SHIFT_JIS = r1;
        return;
    L5:
        if (EUC_JP.equalsIgnoreCase(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private StringUtils() {
    }

    public static String guessEncoding(byte[] r19, Map<DecodeHintType, ?> r20) {
        byte[] r0 = r19;
        if (r20 != null) goto L5;
    L8:
        int r1 = r0.length;
        boolean r5 = true;
        int r6 = 0;
        if (r0.length > 3) goto L11;
    L17:
        boolean r2 = false;
    L18:
        boolean r7 = true;
        boolean r8 = true;
        int r3 = 0;
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
    L19:
        if (r9 >= r1) goto L94;
        if (r5 == true) goto L23;
        if (r7 == true) goto L23;
        if (r8 == false) goto L94;
    L23:
        int r4 = r0[r9] & 255;
        if (r8 == false) goto L44;
        if (r10 <= 0) goto L30;
        if ((r4 & 128) == 0) goto L42;
        r10 = r10 - 1;
    L42:
        r8 = false;
        goto L44
    L30:
        if ((r4 & 128) == 0) goto L44;
        if ((r4 & 64) == 0) goto L42;
        r10 = r10 + 1;
        if ((r4 & 32) != 0) goto L36;
        r12 = r12 + 1;
        goto L44
    L36:
        r10 = r10 + 1;
        if ((r4 & 16) != 0) goto L39;
        r13 = r13 + 1;
        goto L44
    L39:
        r10 = r10 + 1;
        if ((r4 & 8) != 0) goto L42;
        r14 = r14 + 1;
    L44:
        if (r5 == false) goto L58;
        if (r4 <= 127) goto L50;
        if (r4 >= 160) goto L50;
        r5 = false;
    L50:
        if (r4 <= 159) goto L58;
        if (r4 >= 192) goto L54;
    L57:
        r16 = r16 + 1;
        goto L58
    L54:
        if (r4 == 215) goto L57;
        if (r4 == 247) goto L57;
    L58:
        if (r7 == false) goto L93;
        if (r11 <= 0) goto L69;
        if (r4 >= 64) goto L63;
    L92:
        r7 = false;
        goto L93
    L63:
        if (r4 == 127) goto L92;
        if (r4 > 252) goto L92;
        r11 = r11 - 1;
        goto L93
    L69:
        if (r4 == 128) goto L92;
        if (r4 == 160) goto L92;
        if (r4 > 239) goto L92;
        if (r4 <= 160) goto L85;
        if (r4 >= 224) goto L85;
        r3 = r3 + 1;
        int r21 = r18 + 1;
        if (r21 <= r15) goto L82;
        r15 = r21;
        r18 = r15;
    L83:
        r17 = 0;
        goto L93
    L82:
        r18 = r21;
    L85:
        if (r4 <= 127) goto L90;
        r11 = r11 + 1;
        int r22 = r17 + 1;
        if (r22 <= r6) goto L89;
        r6 = r22;
        r17 = r6;
    L91:
        r18 = 0;
        goto L93
    L89:
        r17 = r22;
        goto L91
    L90:
        r17 = 0;
    L93:
        r9 = r9 + 1;
        r0 = r19;
    L94:
        if (r8 == false) goto L97;
        if (r10 <= 0) goto L97;
        r8 = false;
    L97:
        if (r7 == false) goto L101;
        if (r11 <= 0) goto L101;
        r7 = false;
    L101:
        if (r8 == false) goto L107;
        if (r2 == false) goto L104;
    L105:
        return UTF8;
    L104:
        if (((r12 + r13) + r14) > 0) goto L105;
    L107:
        if (r7 == false) goto L115;
        if (ASSUME_SHIFT_JIS == false) goto L111;
    L113:
        return SHIFT_JIS;
    L111:
        if (r15 >= 3) goto L113;
        if (r6 >= 3) goto L113;
    L115:
        if (r5 == false) goto L124;
        if (r7 == false) goto L124;
        if (r15 != 2) goto L121;
        if (r3 != 2) goto L121;
    L122:
        return SHIFT_JIS;
    L121:
        if ((r16 * 10) >= r1) goto L122;
        return ISO88591;
    L124:
        if (r5 == false) goto L126;
        return ISO88591;
    L126:
        if (r7 == false) goto L128;
        return SHIFT_JIS;
    L128:
        if (r8 == false) goto L131;
        return UTF8;
    L131:
        return PLATFORM_DEFAULT_ENCODING;
    L11:
        if (r0[0] != (-17)) goto L17;
        if (r0[1] != (-69)) goto L17;
        if (r0[2] != (-65)) goto L17;
        r2 = true;
        goto L18
    L5:
        if (r20.containsKey(DecodeHintType.CHARACTER_SET) == false) goto L8;
        return r20.get(DecodeHintType.CHARACTER_SET).toString();
    }
}
