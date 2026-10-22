package androidx.tracing;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class Trace {
    static final String TAG = "Trace";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    private Trace() {
    }

    @SuppressLint({"NewApi"})
    public static void beginAsyncSection(@NonNull String r1, int r2) {
        if (sAsyncTraceBeginMethod != null) goto L6;
        TraceApi29Impl.beginAsyncSection(r1, r2);     // Catch: Throwable -> L8
        return;
    L6:
        beginAsyncSectionFallback(r1, r2);
    }

    private static void beginAsyncSectionFallback(@NonNull String r9, int r10) {
        if (Build.VERSION.SDK_INT < 18) goto L14;
    L9:
        e = move-exception;
        handleException("asyncTraceBegin", e);
        return;
    L5:
        if (sAsyncTraceBeginMethod != null) goto L7;
        sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L9
    L7:
        sAsyncTraceBeginMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r9, Integer.valueOf(r10)});     // Catch: Exception -> L9
        return;
    }

    public static void beginSection(@NonNull String r2) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        TraceApi18Impl.beginSection(r2);
        return;
    }

    @SuppressLint({"NewApi"})
    public static void endAsyncSection(@NonNull String r1, int r2) {
        if (sAsyncTraceEndMethod != null) goto L6;
        TraceApi29Impl.endAsyncSection(r1, r2);     // Catch: Throwable -> L8
        return;
    L6:
        endAsyncSectionFallback(r1, r2);
    }

    private static void endAsyncSectionFallback(@NonNull String r9, int r10) {
        if (Build.VERSION.SDK_INT < 18) goto L14;
    L9:
        e = move-exception;
        handleException("asyncTraceEnd", e);
        return;
    L5:
        if (sAsyncTraceEndMethod != null) goto L7;
        sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L9
    L7:
        sAsyncTraceEndMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r9, Integer.valueOf(r10)});     // Catch: Exception -> L9
        return;
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        TraceApi18Impl.endSection();
        return;
    }

    private static void handleException(@NonNull String r2, @NonNull Exception r3) {
        if ((r3 instanceof InvocationTargetException) == false) goto L10;
        Throwable r4 = r3.getCause();
        if ((r4 instanceof RuntimeException) == false) goto L9;
        throw ((RuntimeException) r4);
    L9:
        throw new RuntimeException(r4);
    L10:
        Log.v(TAG, "Unable to call " + r2 + " via reflection", r3);
    }

    @SuppressLint({"NewApi"})
    public static boolean isEnabled() {
        if (sIsTagEnabledMethod != null) goto L7;
        return android.os.Trace.isEnabled();
    L7:
        return isEnabledFallback();
    }

    private static boolean isEnabledFallback() {
        if (Build.VERSION.SDK_INT >= 18) goto L12;
    L11:
        return false;
    L12:
    L9:
        e = move-exception;
        handleException("isTagEnabled", e);
        goto L11
    L5:
        if (sIsTagEnabledMethod != null) goto L7;
        sTraceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);     // Catch: Exception -> L9
        sIsTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});     // Catch: Exception -> L9
    L7:
        return ((Boolean) sIsTagEnabledMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp)})).booleanValue();
    }

    @SuppressLint({"NewApi"})
    public static void setCounter(@NonNull String r1, int r2) {
        if (sTraceCounterMethod != null) goto L6;
        TraceApi29Impl.setCounter(r1, r2);     // Catch: Throwable -> L8
        return;
    L6:
        setCounterFallback(r1, r2);
    }

    private static void setCounterFallback(@NonNull String r9, int r10) {
        if (Build.VERSION.SDK_INT < 18) goto L14;
    L9:
        e = move-exception;
        handleException("traceCounter", e);
        return;
    L5:
        if (sTraceCounterMethod != null) goto L7;
        sTraceCounterMethod = android.os.Trace.class.getMethod("traceCounter", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L9
    L7:
        sTraceCounterMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r9, Integer.valueOf(r10)});     // Catch: Exception -> L9
        return;
    }
}
