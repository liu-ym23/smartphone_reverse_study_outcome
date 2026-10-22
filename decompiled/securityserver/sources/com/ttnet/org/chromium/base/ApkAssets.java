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
    public static long[] open(String r12, String r13) {
        AssetFileDescriptor r4 = null;
        Context r5 = ContextUtils.getApplicationContext();     // Catch: Throwable -> L8 IOException -> L10
        if (TextUtils.isEmpty(r13) == false) goto L6;
    L12:
        r4 = r5.getAssets().openNonAssetFd(r12);     // Catch: Throwable -> L8 IOException -> L10
        long[] r14 = {r4.getParcelFileDescriptor().detachFd(), r4.getStartOffset(), r4.getLength()};     // Catch: Throwable -> L8 IOException -> L10
        r4.close();     // Catch: IOException -> L15
    L17:
        return r14;
    L15:
        e = move-exception;
        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
        goto L17
    L6:
        if (BundleUtils.isIsolatedSplitInstalled(r5, r13) == false) goto L12;
        r5 = BundleUtils.createIsolatedSplitContext(r5, r13);     // Catch: Throwable -> L8 IOException -> L10
    L10:
        e = move-exception;
        if (e.getMessage().equals("") == false) goto L21;
    L23:
        long[] r15 = {-1, -1, -1};     // Catch: Throwable -> L8
        if (r4 != null) goto L38;
    L29:
        return r15;
    L38:
        r4.close();     // Catch: IOException -> L27
    L27:
        e = move-exception;
        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
        goto L29
    L21:
        if (e.getMessage().equals(r12) == true) goto L23;
        android.util.Log.e(LOGTAG, "Error while loading asset " + r12 + ": " + e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (r4 != null) goto L40;
    L35:
        throw th;
    L40:
        r4.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
        goto L35
    }
}
