package com.ttnet.org.chromium.base.memory;

import android.os.Debug;
import com.ttnet.org.chromium.base.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final class JavaHeapDumpGenerator {
    private static final String TAG = "JavaHprofGenerator";

    private JavaHeapDumpGenerator() {
    }

    public static boolean generateHprof(String r3) {
        Debug.dumpHprofData(r3);     // Catch: IOException -> L5
        return true;
    L5:
        e = move-exception;
        Log.i(TAG, "Error writing to file " + r3 + ". Error: " + e.getMessage(), new Object[0]);
        return false;
    }
}
