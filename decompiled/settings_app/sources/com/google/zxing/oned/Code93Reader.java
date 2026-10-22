package com.google.zxing.oned;

import android.icu.lang.UCharacter;
import com.android.settings.applications.RunningProcessesView;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.google.common.base.Ascii;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.obric.oui.utils.AnimTokens;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class Code93Reader extends OneDReader {
    private static final char[] ALPHABET = null;
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    private static final int ASTERISK_ENCODING = 0;
    static final int[] CHARACTER_ENCODINGS = null;
    private final int[] counters;
    private final StringBuilder decodeRowResult;

    static {
        ALPHABET = ALPHABET_STRING.toCharArray();
        int[] r0 = {UCharacter.UnicodeBlock.MASARAM_GONDI_ID, 328, 324, 322, 296, 292, 290, 336, UCharacter.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_F_ID, UCharacter.UnicodeBlock.GLAGOLITIC_SUPPLEMENT_ID, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, UCharacter.UnicodeBlock.DOGRA_ID, 344, 332, 326, 300, UCharacter.UnicodeBlock.SOYOMBO_ID, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, RunningProcessesView.ViewHolder.NAME_MAX_WIDTH_PERSIST, 306, AnimTokens.OUI_ANIMATION_DURATION_MEDIUM_3};
        CHARACTER_ENCODINGS = r0;
        ASTERISK_ENCODING = r0[47];
    }

    public Code93Reader() {
        this.decodeRowResult = new StringBuilder(20);
        this.counters = new int[6];
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int r11, BitArray r12, Map<DecodeHintType, ?> r13) throws NotFoundException, ChecksumException, FormatException {
        int[] r14 = findAsteriskPattern(r12);
        int r1 = r12.getNextSet(r14[1]);
        int r2 = r12.getSize();
        int[] r3 = this.counters;
        Arrays.fill(r3, 0);
        StringBuilder r10 = this.decodeRowResult;
        r10.setLength(0);
    L3:
        recordPattern(r12, r1, r3);
        int r5 = toPattern(r3);
        if (r5 < 0) goto L26;
        char r6 = patternToChar(r5);
        r10.append(r6);
        int r7 = r3.length;
        int r8 = r1;
        int r9 = 0;
    L6:
        if (r9 >= r7) goto L8;
        r8 = r8 + r3[r9];
        r9 = r9 + 1;
        goto L6
    L8:
        int r15 = r12.getNextSet(r8);
        if (r6 == '*') goto L10;
        r1 = r15;
        goto L3
    L10:
        r10.deleteCharAt(r10.length() - 1);
        int r16 = r3.length;
        int r17 = 0;
        int r18 = 0;
    L11:
        if (r17 >= r16) goto L13;
        r18 = r18 + r3[r17];
        r17 = r17 + 1;
        goto L11
    L13:
        if (r15 == r2) goto L23;
        if (r12.get(r15) == false) goto L23;
        if (r10.length() < 2) goto L21;
        checkChecksums(r10);
        r10.setLength(r10.length() - 2);
        float r19 = r11;
        return new Result(decodeExtended(r10), null, new ResultPoint[]{new ResultPoint((r14[1] + r14[0]) / 2.0f, r19), new ResultPoint(r1 + (r18 / 2.0f), r19)}, BarcodeFormat.CODE_93);
    L21:
        throw NotFoundException.getNotFoundInstance();
    L23:
        throw NotFoundException.getNotFoundInstance();
    L26:
        throw NotFoundException.getNotFoundInstance();
    }

    private int[] findAsteriskPattern(BitArray r12) throws NotFoundException {
        int r0 = r12.getSize();
        int r2 = r12.getNextSet(0);
        Arrays.fill(this.counters, 0);
        int[] r11 = this.counters;
        int r3 = r11.length;
        boolean r5 = false;
        int r6 = 0;
        int r4 = r2;
    L3:
        if (r2 >= r0) goto L18;
        if (r12.get(r2) == r5) goto L8;
        r11[r6] = r11[r6] + 1;
    L16:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r6 == (r3 - 1)) goto L10;
        r6 = r6 + 1;
    L15:
        r11[r6] = 1;
        r5 = !r5;
        goto L16
    L10:
        if (toPattern(r11) == ASTERISK_ENCODING) goto L12;
        r4 = r4 + (r11[0] + r11[1]);
        int r7 = r6 - 1;
        System.arraycopy(r11, 2, r11, 0, r7);
        r11[r7] = 0;
        r11[r6] = 0;
        r6 = r6 - 1;
        goto L15
    L12:
        return new int[]{r4, r2};
    L18:
        throw NotFoundException.getNotFoundInstance();
    }

    private static int toPattern(int[] r7) {
        int r0 = r7.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r3 = r3 + r7[r2];
        r2 = r2 + 1;
        goto L3
    L5:
        int r1 = r7.length;
        int r4 = 0;
        int r5 = 0;
    L6:
        if (r4 >= r1) goto L21;
        int r6 = Math.round((r7[r4] * 9.0f) / r3);
        if (r6 <= 0) goto L19;
        if (r6 > 4) goto L28;
        if ((r4 & 1) != 0) goto L17;
        int r8 = 0;
    L15:
        if (r8 >= r6) goto L18;
        r5 = (r5 << 1) | 1;
        r8 = r8 + 1;
    L18:
        r4 = r4 + 1;
        goto L6
    L17:
        r5 = r5 << r6;
        goto L18
    L28:
        return -1;
    L19:
        return -1;
    L21:
        return r5;
    }

    private static char patternToChar(int r3) throws NotFoundException {
        int r0 = 0;
    L3:
        int[] r1 = CHARACTER_ENCODINGS;
        if (r0 >= r1.length) goto L11;
        if (r1[r0] == r3) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        return ALPHABET[r0];
    L11:
        throw NotFoundException.getNotFoundInstance();
    }

    private static String decodeExtended(CharSequence r9) throws FormatException {
        int r0 = r9.length();
        StringBuilder r1 = new StringBuilder(r0);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L61;
        char r4 = r9.charAt(r3);
        if (r4 >= 'a') goto L7;
    L58:
        r1.append(r4);
    L59:
        r3 = r3 + 1;
        goto L3
    L7:
        if (r4 > 'd') goto L58;
        if (r3 >= (r0 - 1)) goto L57;
        r3 = r3 + 1;
        char r5 = r9.charAt(r3);
        switch(r4) {
            case 97: goto L49;
            case 98: goto L25;
            case 99: goto L18;
            case 100: goto L13;
            default: goto L12;
        };
    L12:
        char r6 = 0;
    L55:
        r1.append(r6);
        goto L59
    L13:
        if (r5 < 'A') goto L17;
        if (r5 > 'Z') goto L17;
        int r7 = r5 + TokenParser.SP;
    L52:
        r6 = (char) r7;
    L17:
        throw FormatException.getFormatInstance();
    L18:
        if (r5 < 'A') goto L21;
        if (r5 > 'O') goto L21;
        r7 = r5 - ' ';
    L21:
        if (r5 != 'Z') goto L24;
        r6 = AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR;
        goto L55
    L24:
        throw FormatException.getFormatInstance();
    L25:
        if (r5 < 'A') goto L30;
        if (r5 > 'E') goto L30;
        r7 = r5 - '&';
    L30:
        if (r5 < 'F') goto L35;
        if (r5 > 'J') goto L35;
        r7 = r5 - 11;
    L35:
        if (r5 < 'K') goto L39;
        if (r5 > 'O') goto L39;
        r7 = r5 + 16;
    L39:
        if (r5 < 'P') goto L44;
        if (r5 > 'S') goto L44;
        r7 = r5 + '+';
    L44:
        if (r5 < 'T') goto L48;
        if (r5 > 'Z') goto L48;
        r6 = Ascii.MAX;
    L48:
        throw FormatException.getFormatInstance();
    L49:
        if (r5 < 'A') goto L54;
        if (r5 > 'Z') goto L54;
        r7 = r5 - '@';
    L54:
        throw FormatException.getFormatInstance();
    L57:
        throw FormatException.getFormatInstance();
    L61:
        return r1.toString();
    }

    private static void checkChecksums(CharSequence r3) throws ChecksumException {
        int r0 = r3.length();
        checkOneChecksum(r3, r0 - 2, 20);
        checkOneChecksum(r3, r0 - 1, 15);
    }

    private static void checkOneChecksum(CharSequence r6, int r7, int r8) throws ChecksumException {
        int r0 = r7 - 1;
        int r2 = 0;
        int r3 = 1;
    L3:
        if (r0 < 0) goto L9;
        r2 = r2 + (ALPHABET_STRING.indexOf(r6.charAt(r0)) * r3);
        r3 = r3 + 1;
        if (r3 <= r8) goto L7;
        r3 = 1;
    L7:
        r0 = r0 - 1;
        goto L3
    L9:
        if (r6.charAt(r7) != ALPHABET[r2 % 47]) goto L12;
        return;
    L12:
        throw ChecksumException.getChecksumInstance();
    }
}
