package com.ss.ttuploader;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class TTExternFileReaderBridge {
    public TTExternFileReaderBridge() {
    }

    void cancel(Object r2) {
        Log.e("ttmn", "try to cancel");
        if (r2 != null) goto L7;
        String r3 = "try to cancel end fail";
    L5:
        Log.e("ttmn", r3);
        return;
    L7:
        ((TTExternFileReader) r2).cancel();
        r3 = "try to cancel end";
        goto L5
    }

    long getCrc32ByOffset(Object r2, long r3, int r5) {
        Log.e("ttmn", "try to read end");
        if (r2 != null) goto L6;
        Log.e("ttmn", "try to read end fail");
        return 0;
    L6:
        long r4 = ((TTExternFileReader) r2).getCrc32ByOffset(r3, r5);
        Log.e("ttmn", "try to read end");
        return r4;
    }

    long getValue(Object r2, int r3) {
        Log.e("ttmn", "try to get value");
        if (r2 != null) goto L6;
        Log.e("ttmn", "try to get value fail");
        return -1;
    L6:
        long r4 = ((TTExternFileReader) r2).getValue(r3);
        Log.e("ttmn", "try to get value end");
        return r4;
    }

    int readSlice(Object r2, int r3, byte[] r4, int r5) {
        Log.e("ttmn", "try to read end");
        if (r2 == null) goto L9;
        if (r4 == null) goto L9;
        if (r5 == 0) goto L9;
        int r6 = ((TTExternFileReader) r2).readSlice(r3, r4, r5);
        Log.e("ttmn", "try to read end");
        return r6;
    L9:
        Log.e("ttmn", "try to read end fail");
        return 0;
    }

    int readSliceByOffset(Object r8, long r9, byte[] r11, int r12, int r13) {
        Log.e("ttmn", "try to read end");
        if (r8 == null) goto L9;
        if (r11 == null) goto L9;
        if (r12 == 0) goto L9;
        int r10 = ((TTExternFileReader) r8).readSliceByOffset(r9, r11, r12, r13);
        Log.e("ttmn", "try to read end");
        return r10;
    L9:
        Log.e("ttmn", "try to read end fail");
        return 0;
    }
}
