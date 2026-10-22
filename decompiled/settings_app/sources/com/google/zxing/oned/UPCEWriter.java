package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class UPCEWriter extends UPCEANWriter {
    private static final int CODE_WIDTH = 51;

    public UPCEWriter() {
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String r2, BarcodeFormat r3, int r4, int r5, Map<EncodeHintType, ?> r6) throws WriterException {
        if (r3 != BarcodeFormat.UPC_E) goto L7;
        return super.encode(r2, r3, r4, r5, r6);
    L7:
        throw new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(r3)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String r9) {
        int r8 = r9.length();
        if (r8 != 7) goto L5;
        r9 = r9 + UPCEANReader.getStandardUPCEANChecksum(UPCEReader.convertUPCEtoUPCA(r9));
    L17:
        int r1 = Character.digit(r9.charAt(0), 10);
        if (r1 == 0) goto L23;
        if (r1 == 1) goto L23;
        throw new IllegalArgumentException("Number system must be 0 or 1");
    L23:
        int r0 = UPCEReader.NUMSYS_AND_CHECK_DIGIT_PATTERNS[r1][Character.digit(r9.charAt(7), 10)];
        boolean[] r2 = new boolean[51];
        int r4 = appendPattern(r2, 0, UPCEANReader.START_END_PATTERN, true) + 0;
        int r5 = 1;
    L25:
        if (r5 > 6) goto L30;
        int r6 = Character.digit(r9.charAt(r5), 10);
        if (((r0 >> (6 - r5)) & 1) != 1) goto L29;
        r6 = r6 + 10;
    L29:
        r4 = r4 + appendPattern(r2, r4, UPCEANReader.L_AND_G_PATTERNS[r6], false);
        r5 = r5 + 1;
        goto L25
    L30:
        appendPattern(r2, r4, UPCEANReader.END_PATTERN, false);
        return r2;
    L32:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L5:
        if (r8 != 8) goto L14;
        if (UPCEANReader.checkStandardUPCEANChecksum(r9) == true) goto L17;
        throw new IllegalArgumentException("Contents do not pass checksum");     // Catch: FormatException -> L11
    L12:
        throw new IllegalArgumentException("Illegal contents");
    L14:
        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(r8)));
    }
}
