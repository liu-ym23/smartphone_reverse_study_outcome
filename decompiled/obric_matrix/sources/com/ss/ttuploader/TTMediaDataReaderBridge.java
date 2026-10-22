package com.ss.ttuploader;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class TTMediaDataReaderBridge {
    private static final String TAG = "ttmn";

    public TTMediaDataReaderBridge() {
    }

    int close(Object r1, int r2) {
        if (r1 == null) goto L7;
        if (r2 < 0) goto L7;
        return ((TTMediaDataReader) r1).close(r2);
    L7:
        Log.e(TAG, "try to close fail");
        return 0;
    }

    long getValue(Object r1, int r2, int r3) {
        if (r1 != null) goto L6;
        Log.e(TAG, "try to get value fail");
        return -1;
    L6:
        return ((TTMediaDataReader) r1).getValue(r2, r3);
    }

    int open(Object r1, int r2) {
        if (r1 != null) goto L6;
        Log.e(TAG, "try to open failed");
        return 0;
    L6:
        return ((TTMediaDataReader) r1).open(r2);
    }

    int read(Object r7, int r8, long r9, byte[] r11, int r12) {
        if (r7 == null) goto L8;
        if (r11 == null) goto L8;
        if (r12 == 0) goto L8;
        return ((TTMediaDataReader) r7).read(r8, r9, r11, r12);
    L8:
        Log.e(TAG, "try to read end fail");
        return 0;
    }
}
