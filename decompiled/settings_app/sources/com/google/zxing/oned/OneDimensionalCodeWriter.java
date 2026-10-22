package com.google.zxing.oned;

import android.icu.util.ULocale;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OneDimensionalCodeWriter implements Writer {
    public abstract boolean[] encode(String r1);

    public int getDefaultMargin() {
        return 10;
    }

    public OneDimensionalCodeWriter() {
    }

    @Override // com.google.zxing.Writer
    public final BitMatrix encode(String r7, BarcodeFormat r8, int r9, int r10) throws WriterException {
        return encode(r7, r8, r9, r10, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r2, BarcodeFormat r3, int r4, int r5, Map<EncodeHintType, ?> r6) throws WriterException {
        if (r2.isEmpty() == true) goto L16;
        if (r4 < 0) goto L14;
        if (r5 < 0) goto L14;
        int r7 = getDefaultMargin();
        if (r6 == null) goto L12;
        if (r6.containsKey(EncodeHintType.MARGIN) == false) goto L12;
        r7 = Integer.parseInt(r6.get(EncodeHintType.MARGIN).toString());
    L12:
        return renderResult(encode(r2), r4, r5, r7);
    L14:
        throw new IllegalArgumentException("Negative size is not allowed. Input: " + r4 + ULocale.PRIVATE_USE_EXTENSION + r5);
    L16:
        throw new IllegalArgumentException("Found empty contents");
    }

    private static BitMatrix renderResult(boolean[] r5, int r6, int r7, int r8) {
        int r0 = r5.length;
        int r9 = r8 + r0;
        int r10 = Math.max(r6, r9);
        int r11 = Math.max(1, r7);
        int r12 = r10 / r9;
        int r1 = (r10 - (r0 * r12)) / 2;
        BitMatrix r2 = new BitMatrix(r10, r11);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L8;
        if (r5[r3] == false) goto L7;
        r2.setRegion(r1, 0, r12, r11);
    L7:
        r3 = r3 + 1;
        r1 = r1 + r12;
        goto L3
    L8:
        return r2;
    }

    protected static int appendPattern(boolean[] r7, int r8, int[] r9, boolean r10) {
        int r0 = r9.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L8;
        int r4 = r9[r2];
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L7;
        r7[r8] = r10;
        r5 = r5 + 1;
        r8 = r8 + 1;
        goto L5
    L7:
        r3 = r3 + r4;
        r10 = !r10;
        r2 = r2 + 1;
        goto L3
    L8:
        return r3;
    }
}
