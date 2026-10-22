package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class UPCAWriter implements Writer {
    private final EAN13Writer subWriter;

    public UPCAWriter() {
        this.subWriter = new EAN13Writer();
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r7, BarcodeFormat r8, int r9, int r10) throws WriterException {
        return encode(r7, r8, r9, r10, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r8, BarcodeFormat r9, int r10, int r11, Map<EncodeHintType, ?> r12) throws WriterException {
        if (r9 != BarcodeFormat.UPC_A) goto L7;
        return this.subWriter.encode("0".concat(String.valueOf(r8)), BarcodeFormat.EAN_13, r10, r11, r12);
    L7:
        throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(r9)));
    }
}
