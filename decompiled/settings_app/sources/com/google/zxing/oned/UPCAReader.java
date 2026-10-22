package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class UPCAReader extends UPCEANReader {
    private final UPCEANReader ean13Reader;

    public UPCAReader() {
        this.ean13Reader = new EAN13Reader();
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public Result decodeRow(int r1, BitArray r2, int[] r3, Map<DecodeHintType, ?> r4) throws NotFoundException, FormatException, ChecksumException {
        return maybeReturnResult(this.ean13Reader.decodeRow(r1, r2, r3, r4));
    }

    @Override // com.google.zxing.oned.UPCEANReader, com.google.zxing.oned.OneDReader
    public Result decodeRow(int r1, BitArray r2, Map<DecodeHintType, ?> r3) throws NotFoundException, FormatException, ChecksumException {
        return maybeReturnResult(this.ean13Reader.decodeRow(r1, r2, r3));
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public Result decode(BinaryBitmap r1) throws NotFoundException, FormatException {
        return maybeReturnResult(this.ean13Reader.decode(r1));
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public Result decode(BinaryBitmap r1, Map<DecodeHintType, ?> r2) throws NotFoundException, FormatException {
        return maybeReturnResult(this.ean13Reader.decode(r1, r2));
    }

    @Override // com.google.zxing.oned.UPCEANReader
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.UPC_A;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    protected int decodeMiddle(BitArray r1, int[] r2, StringBuilder r3) throws NotFoundException {
        return this.ean13Reader.decodeMiddle(r1, r2, r3);
    }

    private static Result maybeReturnResult(Result r5) throws FormatException {
        String r0 = r5.getText();
        if (r0.charAt(0) != '0') goto L9;
        Result r1 = new Result(r0.substring(1), null, r5.getResultPoints(), BarcodeFormat.UPC_A);
        if (r5.getResultMetadata() == null) goto L7;
        r1.putAllMetadata(r5.getResultMetadata());
    L7:
        return r1;
    L9:
        throw FormatException.getFormatInstance();
    }
}
