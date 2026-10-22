package androidx.core.os;

import android.os.Trace;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    private TraceCompat() {
    }

    public static void beginAsyncSection(@NonNull String r0, int r1) {
        Trace.beginAsyncSection(r0, r1);
    }

    public static void beginSection(@NonNull String r0) {
        Trace.beginSection(r0);
    }

    public static void endAsyncSection(@NonNull String r0, int r1) {
        Trace.endAsyncSection(r0, r1);
    }

    public static void endSection() {
        Trace.endSection();
    }

    public static boolean isEnabled() {
        return Trace.isEnabled();
    }

    public static void setCounter(@NonNull String r2, int r3) {
        Trace.setCounter(r2, r3);
    }
}
