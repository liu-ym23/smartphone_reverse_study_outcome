package com.android.settings.bluetooth;

import android.os.ParcelUuid;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothUuidEnhance {
    public BluetoothUuidEnhance() {
    }

    public static boolean isUuidPresent(ParcelUuid[] r5, ParcelUuid r6) {
        if (r5 != null) goto L5;
    L6:
        if (r6 != null) goto L9;
        return true;
    L9:
        if (r5 != null) goto L11;
        return false;
    L11:
        int r2 = r5.length;
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L17;
        if (r5[r3].equals(r6) == true) goto L15;
        r3 = r3 + 1;
        goto L12
    L15:
        return true;
    L17:
        return false;
    L5:
        if (r5.length != 0) goto L9;
        goto L6
    }
}
