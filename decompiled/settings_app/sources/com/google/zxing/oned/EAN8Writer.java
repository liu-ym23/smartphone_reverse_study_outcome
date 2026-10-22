package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class EAN8Writer extends UPCEANWriter {
    private static final int CODE_WIDTH = 67;

    public EAN8Writer() {
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String r2, BarcodeFormat r3, int r4, int r5, Map<EncodeHintType, ?> r6) throws WriterException {
        if (r3 != BarcodeFormat.EAN_8) goto L7;
        return super.encode(r2, r3, r4, r5, r6);
    L7:
        throw new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(r3)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String r8) {
        int r7 = r8.length();
        if (r7 != 7) goto L5;
        r8 = r8 + UPCEANReader.getStandardUPCEANChecksum(r8);
    L17:
        boolean[] r9 = new boolean[67];
        int r1 = appendPattern(r9, 0, UPCEANReader.START_END_PATTERN, true) + 0;
        int r4 = 0;
    L19:
        if (r4 > 3) goto L21;
        r1 = r1 + appendPattern(r9, r1, UPCEANReader.L_PATTERNS[Character.digit(r8.charAt(r4), 10)], false);
        r4 = r4 + 1;
        goto L19
    L21:
        int r2 = r1 + appendPattern(r9, r1, UPCEANReader.MIDDLE_PATTERN, false);
        int r3 = 4;
    L22:
        if (r3 > 7) goto L24;
        r2 = r2 + appendPattern(r9, r2, UPCEANReader.L_PATTERNS[Character.digit(r8.charAt(r3), 10)], true);
        r3 = r3 + 1;
        goto L22
    L24:
        appendPattern(r9, r2, UPCEANReader.START_END_PATTERN, true);
        return r9;
    L26:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L5:
        if (r7 != 8) goto L14;
        if (UPCEANReader.checkStandardUPCEANChecksum(r8) == true) goto L17;
        throw new IllegalArgumentException("Contents do not pass checksum");     // Catch: FormatException -> L11
    L12:
        throw new IllegalArgumentException("Illegal contents");
    L14:
        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(r7)));
    }
}
