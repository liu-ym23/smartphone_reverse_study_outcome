package com.google.zxing;

import com.google.zxing.aztec.AztecReader;
import com.google.zxing.datamatrix.DataMatrixReader;
import com.google.zxing.maxicode.MaxiCodeReader;
import com.google.zxing.oned.MultiFormatOneDReader;
import com.google.zxing.pdf417.PDF417Reader;
import com.google.zxing.qrcode.QRCodeReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class MultiFormatReader implements Reader {
    private Map<DecodeHintType, ?> hints;
    private Reader[] readers;

    public MultiFormatReader() {
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap r2) throws NotFoundException {
        setHints(null);
        return decodeInternal(r2);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap r1, Map<DecodeHintType, ?> r2) throws NotFoundException {
        setHints(r2);
        return decodeInternal(r1);
    }

    public Result decodeWithState(BinaryBitmap r2) throws NotFoundException {
        if (this.readers != null) goto L6;
        setHints(null);
    L6:
        return decodeInternal(r2);
    }

    public void setHints(Map<DecodeHintType, ?> r7) {
        this.hints = r7;
        boolean r0 = true;
        if (r7 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r7 != null) goto L10;
        Collection r3 = null;
    L11:
        ArrayList r4 = new ArrayList();
        if (r3 == null) goto L59;
        if (r3.contains(BarcodeFormat.UPC_A) == false) goto L16;
    L37:
        if (r0 == false) goto L41;
        if (r2 == true) goto L41;
        r4.add(new MultiFormatOneDReader(r7));
    L41:
        if (r3.contains(BarcodeFormat.QR_CODE) == false) goto L44;
        r4.add(new QRCodeReader());
    L44:
        if (r3.contains(BarcodeFormat.DATA_MATRIX) == false) goto L47;
        r4.add(new DataMatrixReader());
    L47:
        if (r3.contains(BarcodeFormat.AZTEC) == false) goto L50;
        r4.add(new AztecReader());
    L50:
        if (r3.contains(BarcodeFormat.PDF_417) == false) goto L53;
        r4.add(new PDF417Reader());
    L53:
        if (r3.contains(BarcodeFormat.MAXICODE) == false) goto L55;
        r4.add(new MaxiCodeReader());
    L55:
        if (r0 == false) goto L59;
        if (r2 == false) goto L59;
        r4.add(new MultiFormatOneDReader(r7));
        goto L59
    L16:
        if (r3.contains(BarcodeFormat.UPC_E) == true) goto L37;
        if (r3.contains(BarcodeFormat.EAN_13) == true) goto L37;
        if (r3.contains(BarcodeFormat.EAN_8) == true) goto L37;
        if (r3.contains(BarcodeFormat.CODABAR) == true) goto L37;
        if (r3.contains(BarcodeFormat.CODE_39) == true) goto L37;
        if (r3.contains(BarcodeFormat.CODE_93) == true) goto L37;
        if (r3.contains(BarcodeFormat.CODE_128) == true) goto L37;
        if (r3.contains(BarcodeFormat.ITF) == true) goto L37;
        if (r3.contains(BarcodeFormat.RSS_14) == true) goto L37;
        if (r3.contains(BarcodeFormat.RSS_EXPANDED) == true) goto L37;
        r0 = false;
    L59:
        if (r4.isEmpty() == false) goto L65;
        if (r2 == true) goto L62;
        r4.add(new MultiFormatOneDReader(r7));
    L62:
        r4.add(new QRCodeReader());
        r4.add(new DataMatrixReader());
        r4.add(new AztecReader());
        r4.add(new PDF417Reader());
        r4.add(new MaxiCodeReader());
        if (r2 == false) goto L65;
        r4.add(new MultiFormatOneDReader(r7));
    L65:
        this.readers = (Reader[]) r4.toArray(new Reader[r4.size()]);
        return;
    L10:
        r3 = (Collection) r7.get(DecodeHintType.POSSIBLE_FORMATS);
        goto L11
    L5:
        if (r7.containsKey(DecodeHintType.TRY_HARDER) == false) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.google.zxing.Reader
    public void reset() {
        Reader[] r3 = this.readers;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].reset();
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    private Result decodeInternal(BinaryBitmap r6) throws NotFoundException {
        Reader[] r0 = this.readers;
        if (r0 == null) goto L11;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L11;
        Reader r3 = r0[r2];
        return r3.decode(r6, this.hints);
    L9:
        r2 = r2 + 1;
    L11:
        throw NotFoundException.getNotFoundInstance();
    }
}
