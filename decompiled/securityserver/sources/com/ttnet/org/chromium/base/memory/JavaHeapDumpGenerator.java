package com.ttnet.org.chromium.base.memory;

import a.a;
import android.os.Debug;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class JavaHeapDumpGenerator {
    private static final String TAG = "JavaHprofGenerator";

    private JavaHeapDumpGenerator() {
    }

    @CalledByNative
    public static boolean generateHprof(String r3) {
        Debug.dumpHprofData(r3);     // Catch: IOException -> L5
        return true;
    L5:
        e = move-exception;
        StringBuilder r4 = a.u("Error writing to file ", r3, ". Error: ");
        r4.append(e.getMessage());
        Log.i(TAG, r4.toString(), new Object[0]);
        return false;
    }
}
