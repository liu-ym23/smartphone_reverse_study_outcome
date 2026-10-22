package com.google.zxing.qrcode;

import android.icu.util.ULocale;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class QRCodeWriter implements Writer {
    private static final int QUIET_ZONE_SIZE = 4;

    public QRCodeWriter() {
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r7, BarcodeFormat r8, int r9, int r10) throws WriterException {
        return encode(r7, r8, r9, r10, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r2, BarcodeFormat r3, int r4, int r5, Map<EncodeHintType, ?> r6) throws WriterException {
        if (r2.isEmpty() == true) goto L23;
        if (r3 != BarcodeFormat.QR_CODE) goto L21;
        if (r4 < 0) goto L19;
        if (r5 < 0) goto L19;
        ErrorCorrectionLevel r1 = ErrorCorrectionLevel.L;
        int r7 = 4;
        if (r6 == null) goto L17;
        if (r6.containsKey(EncodeHintType.ERROR_CORRECTION) == false) goto L14;
        r1 = ErrorCorrectionLevel.valueOf(r6.get(EncodeHintType.ERROR_CORRECTION).toString());
    L14:
        if (r6.containsKey(EncodeHintType.MARGIN) == false) goto L17;
        r7 = Integer.parseInt(r6.get(EncodeHintType.MARGIN).toString());
    L17:
        return renderResult(Encoder.encode(r2, r1, r6), r4, r5, r7);
    L19:
        throw new IllegalArgumentException("Requested dimensions are too small: " + r4 + ULocale.PRIVATE_USE_EXTENSION + r5);
    L21:
        throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(r3)));
    L23:
        throw new IllegalArgumentException("Found empty contents");
    }

    private static BitMatrix renderResult(QRCode r9, int r10, int r11, int r12) {
        ByteMatrix r13 = r9.getMatrix();
        if (r13 == null) goto L15;
        int r0 = r13.getWidth();
        int r1 = r13.getHeight();
        int r14 = r12 << 1;
        int r3 = r0 + r14;
        int r15 = r14 + r1;
        int r16 = Math.max(r10, r3);
        int r17 = Math.max(r11, r15);
        int r18 = Math.min(r16 / r3, r17 / r15);
        int r4 = (r16 - (r0 * r18)) / 2;
        int r5 = (r17 - (r1 * r18)) / 2;
        BitMatrix r6 = new BitMatrix(r16, r17);
        int r19 = 0;
    L5:
        if (r19 >= r1) goto L13;
        int r7 = 0;
        int r8 = r4;
    L7:
        if (r7 >= r0) goto L12;
        if (r13.get(r7, r19) != 1) goto L11;
        r6.setRegion(r8, r5, r18, r18);
    L11:
        r7 = r7 + 1;
        r8 = r8 + r18;
        goto L7
    L12:
        r19 = r19 + 1;
        r5 = r5 + r18;
        goto L5
    L13:
        return r6;
    L15:
        throw new IllegalStateException();
    }
}
