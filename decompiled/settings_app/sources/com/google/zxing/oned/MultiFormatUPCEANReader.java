package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class MultiFormatUPCEANReader extends OneDReader {
    private final UPCEANReader[] readers;

    public MultiFormatUPCEANReader(Map<DecodeHintType, ?> r3) {
        if (r3 != null) goto L5;
        Collection r4 = null;
    L6:
        ArrayList r0 = new ArrayList();
        if (r4 == null) goto L21;
        if (r4.contains(BarcodeFormat.EAN_13) == false) goto L12;
        r0.add(new EAN13Reader());
    L15:
        if (r4.contains(BarcodeFormat.EAN_8) == false) goto L18;
        r0.add(new EAN8Reader());
    L18:
        if (r4.contains(BarcodeFormat.UPC_E) == false) goto L21;
        r0.add(new UPCEReader());
        goto L21
    L12:
        if (r4.contains(BarcodeFormat.UPC_A) == false) goto L15;
        r0.add(new UPCAReader());
    L21:
        if (r0.isEmpty() == false) goto L23;
        r0.add(new EAN13Reader());
        r0.add(new EAN8Reader());
        r0.add(new UPCEReader());
    L23:
        this.readers = (UPCEANReader[]) r0.toArray(new UPCEANReader[r0.size()]);
        return;
    L5:
        r4 = (Collection) r3.get(DecodeHintType.POSSIBLE_FORMATS);
        goto L6
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int r11, BitArray r12, Map<DecodeHintType, ?> r13) throws NotFoundException {
        int[] r0 = UPCEANReader.findStartGuardPattern(r12);
        UPCEANReader[] r10 = this.readers;
        int r1 = r10.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L27;
        Result r4 = r10[r3].decodeRow(r11, r12, r0, r13);     // Catch: ReaderException -> L25
        if (r4.getBarcodeFormat() == BarcodeFormat.EAN_13) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r13 != null) goto L13;
        Collection r6 = null;
    L14:
        if (r6 != null) goto L16;
    L19:
        boolean r7 = true;
    L20:
        if (r5 == false) goto L24;
        if (r7 == false) goto L24;
        Result r8 = new Result(r4.getText().substring(1), r4.getRawBytes(), r4.getResultPoints(), BarcodeFormat.UPC_A);     // Catch: ReaderException -> L25
        r8.putAllMetadata(r4.getResultMetadata());     // Catch: ReaderException -> L25
        return r8;
    L24:
        return r4;
    L16:
        if (r6.contains(BarcodeFormat.UPC_A) == true) goto L19;
        r7 = false;
        goto L20
    L13:
        r6 = (Collection) r13.get(DecodeHintType.POSSIBLE_FORMATS);     // Catch: ReaderException -> L25
        goto L14
    L8:
        if (r4.getText().charAt(0) != '0') goto L10;
        r5 = true;
    L25:
        r3 = r3 + 1;
        goto L3
    L27:
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        UPCEANReader[] r3 = this.readers;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].reset();
        r1 = r1 + 1;
        goto L3
    }
}
