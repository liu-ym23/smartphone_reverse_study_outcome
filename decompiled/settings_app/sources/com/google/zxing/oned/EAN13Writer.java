package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class EAN13Writer extends UPCEANWriter {
    private static final int CODE_WIDTH = 95;

    public EAN13Writer() {
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String r2, BarcodeFormat r3, int r4, int r5, Map<EncodeHintType, ?> r6) throws WriterException {
        if (r3 != BarcodeFormat.EAN_13) goto L7;
        return super.encode(r2, r3, r4, r5, r6);
    L7:
        throw new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(r3)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String r10) {
        int r9 = r10.length();
        if (r9 != 12) goto L5;
        r10 = r10 + UPCEANReader.getStandardUPCEANChecksum(r10);
    L17:
        int r1 = EAN13Reader.FIRST_DIGIT_ENCODINGS[Character.digit(r10.charAt(0), 10)];
        boolean[] r3 = new boolean[95];
        int r4 = appendPattern(r3, 0, UPCEANReader.START_END_PATTERN, true) + 0;
        int r6 = 1;
    L19:
        if (r6 > 6) goto L24;
        int r7 = Character.digit(r10.charAt(r6), 10);
        if (((r1 >> (6 - r6)) & 1) != 1) goto L23;
        r7 = r7 + 10;
    L23:
        r4 = r4 + appendPattern(r3, r4, UPCEANReader.L_AND_G_PATTERNS[r7], false);
        r6 = r6 + 1;
        goto L19
    L24:
        int r5 = r4 + appendPattern(r3, r4, UPCEANReader.MIDDLE_PATTERN, false);
        int r11 = 7;
    L25:
        if (r11 > 12) goto L27;
        r5 = r5 + appendPattern(r3, r5, UPCEANReader.L_PATTERNS[Character.digit(r10.charAt(r11), 10)], true);
        r11 = r11 + 1;
        goto L25
    L27:
        appendPattern(r3, r5, UPCEANReader.START_END_PATTERN, true);
        return r3;
    L29:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L5:
        if (r9 != 13) goto L14;
        if (UPCEANReader.checkStandardUPCEANChecksum(r10) == true) goto L17;
        throw new IllegalArgumentException("Contents do not pass checksum");     // Catch: FormatException -> L11
    L12:
        throw new IllegalArgumentException("Illegal contents");
    L14:
        throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(r9)));
    }
}
