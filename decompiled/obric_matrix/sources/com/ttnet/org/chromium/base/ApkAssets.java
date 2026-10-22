package com.ttnet.org.chromium.base;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class ApkAssets {
    private static final String LOGTAG = "ApkAssets";

    public ApkAssets() {
    }

    @CalledByNative
    public static long[] open(String r9, String r10) {
        AssetFileDescriptor r6 = null;
        Context r7 = ContextUtils.getApplicationContext();     // Catch: Throwable -> L15 IOException -> L17
        if (TextUtils.isEmpty(r10) == false) goto L6;
    L8:
        r6 = r7.getAssets().openNonAssetFd(r9);     // Catch: Throwable -> L15 IOException -> L17
        long[] r11 = {r6.getParcelFileDescriptor().detachFd(), r6.getStartOffset(), r6.getLength()};     // Catch: Throwable -> L15 IOException -> L17
        if (r6 != null) goto L38;
    L14:
        return r11;
    L38:
        r6.close();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
        goto L14
    L6:
        if (BundleUtils.isIsolatedSplitInstalled(r7, r10) == false) goto L8;
        r7 = BundleUtils.createIsolatedSplitContext(r7, r10);     // Catch: Throwable -> L15 IOException -> L17
    L15:
        th = move-exception;
        if (r6 != null) goto L36;
    L35:
        throw th;
    L36:
        r6.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
    L17:
        e = move-exception;
        if (e.getMessage().equals("") == false) goto L21;
    L23:
        long[] r12 = {-1, -1, -1};     // Catch: Throwable -> L15
        if (r6 != null) goto L41;
    L29:
        return r12;
    L41:
        r6.close();     // Catch: IOException -> L27
    L27:
        e = move-exception;
        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
        goto L29
    L21:
        if (e.getMessage().equals(r9) == true) goto L23;
        android.util.Log.e(LOGTAG, "Error while loading asset " + r9 + ": " + e);     // Catch: Throwable -> L15
        goto L23
    }
}
