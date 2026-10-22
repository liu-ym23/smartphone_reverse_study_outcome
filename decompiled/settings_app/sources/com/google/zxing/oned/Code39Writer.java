package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class Code39Writer extends OneDimensionalCodeWriter {
    public Code39Writer() {
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String r2, BarcodeFormat r3, int r4, int r5, Map<EncodeHintType, ?> r6) throws WriterException {
        if (r3 != BarcodeFormat.CODE_39) goto L7;
        return super.encode(r2, r3, r4, r5, r6);
    L7:
        throw new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(r3)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String r12) {
        int r11 = r12.length();
        if (r11 > 80) goto L27;
        int r3 = 0;
    L6:
        if (r3 >= r11) goto L15;
        if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(r12.charAt(r3)) < 0) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        r12 = tryToConvertToExtendedMode(r12);
        r11 = r12.length();
        if (r11 <= 80) goto L15;
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + r11 + " (extended full ASCII mode)");
    L15:
        int[] r1 = new int[9];
        int r4 = r11 + 25;
        int r5 = 0;
    L16:
        if (r5 >= r11) goto L21;
        toIntArray(Code39Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(r12.charAt(r5))], r1);
        int r6 = 0;
    L18:
        if (r6 >= 9) goto L20;
        r4 = r4 + r1[r6];
        r6 = r6 + 1;
        goto L18
    L20:
        r5 = r5 + 1;
        goto L16
    L21:
        boolean[] r0 = new boolean[r4];
        toIntArray(148, r1);
        int r7 = appendPattern(r0, 0, r1, true);
        int[] r8 = {1};
        int r9 = r7 + appendPattern(r0, r7, r8, false);
        int r10 = 0;
    L22:
        if (r10 >= r11) goto L24;
        toIntArray(Code39Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(r12.charAt(r10))], r1);
        int r13 = r9 + appendPattern(r0, r9, r1, true);
        r9 = r13 + appendPattern(r0, r13, r8, false);
        r10 = r10 + 1;
        goto L22
    L24:
        toIntArray(148, r1);
        appendPattern(r0, r9, r1, true);
        return r0;
    L27:
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(r11)));
    }

    private static void toIntArray(int r3, int[] r4) {
        int r0 = 0;
    L4:
        if (r0 >= 9) goto L10;
        int r2 = 1;
        if (((1 << (8 - r0)) & r3) == 0) goto L9;
        r2 = 2;
    L9:
        r4[r0] = r2;
        r0 = r0 + 1;
        goto L4
    }

    private static String tryToConvertToExtendedMode(String r7) {
        int r0 = r7.length();
        StringBuilder r1 = new StringBuilder();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L55;
        char r3 = r7.charAt(r2);
        if (r3 != 0) goto L7;
        r1.append("%U");
    L53:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r3 != ' ') goto L9;
    L51:
        r1.append(r3);
        goto L53
    L9:
        if (r3 != '@') goto L11;
        r1.append("%V");
        goto L53
    L11:
        if (r3 != '`') goto L13;
        r1.append("%W");
        goto L53
    L13:
        if (r3 == '-') goto L51;
        if (r3 == '.') goto L51;
        if (r3 > 26) goto L20;
        r1.append('$');
        r1.append((char) ((r3 - 1) + 65));
        goto L53
    L20:
        if (r3 >= ' ') goto L23;
        r1.append('%');
        r1.append((char) ((r3 - 27) + 65));
        goto L53
    L23:
        if (r3 <= ',') goto L48;
        if (r3 == '/') goto L48;
        if (r3 == ':') goto L48;
        if (r3 > '9') goto L32;
        r1.append((char) ((r3 - '0') + 48));
        goto L53
    L32:
        if (r3 > '?') goto L35;
        r1.append('%');
        r1.append((char) ((r3 - ';') + 70));
        goto L53
    L35:
        if (r3 > 'Z') goto L38;
        r1.append((char) ((r3 - 'A') + 65));
        goto L53
    L38:
        if (r3 > '_') goto L41;
        r1.append('%');
        r1.append((char) ((r3 - '[') + 75));
        goto L53
    L41:
        if (r3 > 'z') goto L44;
        r1.append('+');
        r1.append((char) ((r3 - 'a') + 65));
        goto L53
    L44:
        if (r3 > 127) goto L47;
        r1.append('%');
        r1.append((char) ((r3 - '{') + 80));
        goto L53
    L47:
        throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + r7.charAt(r2) + "'");
    L48:
        r1.append(IOUtils.DIR_SEPARATOR_UNIX);
        r1.append((char) ((r3 - '!') + 65));
        goto L53
    L55:
        return r1.toString();
    }
}
