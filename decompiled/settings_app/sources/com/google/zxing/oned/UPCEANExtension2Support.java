package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class UPCEANExtension2Support {
    private final int[] decodeMiddleCounters;
    private final StringBuilder decodeRowStringBuffer;

    UPCEANExtension2Support() {
        this.decodeMiddleCounters = new int[4];
        this.decodeRowStringBuffer = new StringBuilder();
    }

    Result decodeRow(int r8, BitArray r9, int[] r10) throws NotFoundException {
        StringBuilder r0 = this.decodeRowStringBuffer;
        r0.setLength(0);
        int r7 = decodeMiddle(r9, r10, r0);
        String r11 = r0.toString();
        Map<ResultMetadataType, Object> r1 = parseExtensionString(r11);
        float r12 = r8;
        Result r2 = new Result(r11, null, new ResultPoint[]{new ResultPoint((r10[0] + r10[1]) / 2.0f, r12), new ResultPoint(r7, r12)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (r1 == null) goto L5;
        r2.putAllMetadata(r1);
    L5:
        return r2;
    }

    private int decodeMiddle(BitArray r11, int[] r12, StringBuilder r13) throws NotFoundException {
        int[] r10 = this.decodeMiddleCounters;
        r10[0] = 0;
        r10[1] = 0;
        r10[2] = 0;
        r10[3] = 0;
        int r3 = r11.getSize();
        int r14 = r12[1];
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= 2) goto L15;
        if (r14 >= r3) goto L15;
        int r6 = UPCEANReader.decodeDigit(r11, r10, r14, UPCEANReader.L_AND_G_PATTERNS);
        r13.append((char) ((r6 % 10) + 48));
        int r7 = r10.length;
        int r8 = 0;
    L6:
        if (r8 >= r7) goto L9;
        r14 = r14 + r10[r8];
        r8 = r8 + 1;
        goto L6
    L9:
        if (r6 < 10) goto L11;
        r5 = r5 | (1 << (1 - r4));
    L11:
        if (r4 == 1) goto L13;
        r14 = r11.getNextUnset(r11.getNextSet(r14));
    L13:
        r4 = r4 + 1;
    L15:
        if (r13.length() != 2) goto L22;
        if ((Integer.parseInt(r13.toString()) % 4) != r5) goto L20;
        return r14;
    L20:
        throw NotFoundException.getNotFoundInstance();
    L22:
        throw NotFoundException.getNotFoundInstance();
    }

    private static Map<ResultMetadataType, Object> parseExtensionString(String r2) {
        if (r2.length() == 2) goto L6;
        return null;
    L6:
        EnumMap r0 = new EnumMap(ResultMetadataType.class);
        r0.put(ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(r2));
        return r0;
    }
}
