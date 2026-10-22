package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;

/* JADX INFO: loaded from: classes4.dex */
final class UPCEANExtensionSupport {
    private static final int[] EXTENSION_START_PATTERN = null;
    private final UPCEANExtension5Support fiveSupport;
    private final UPCEANExtension2Support twoSupport;

    UPCEANExtensionSupport() {
        this.twoSupport = new UPCEANExtension2Support();
        this.fiveSupport = new UPCEANExtension5Support();
    }

    static {
        EXTENSION_START_PATTERN = new int[]{1, 1, 2};
    }

    Result decodeRow(int r3, BitArray r4, int r5) throws NotFoundException {
        int[] r6 = UPCEANReader.findGuardPattern(r4, r5, false, EXTENSION_START_PATTERN);
        return this.fiveSupport.decodeRow(r3, r4, r6);
    L6:
        return this.twoSupport.decodeRow(r3, r4, r6);
    }
}
