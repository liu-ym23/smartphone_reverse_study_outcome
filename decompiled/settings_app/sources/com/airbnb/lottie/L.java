package com.airbnb.lottie;

import androidx.core.os.TraceCompat;

/* JADX INFO: loaded from: classes.dex */
public class L {
    public static boolean DBG = false;
    private static final int MAX_DEPTH = 20;
    public static final String TAG = "LOTTIE";
    private static int depthPastMaxDepth = 0;
    private static String[] sections = null;
    private static long[] startTimeNs = null;
    private static int traceDepth = 0;
    private static boolean traceEnabled = false;

    static {
    }

    public L() {
    }

    public static void setTraceEnabled(boolean r1) {
        if (traceEnabled != r1) goto L5;
        return;
    L5:
        traceEnabled = r1;
        if (r1 == false) goto L9;
        sections = new String[20];
        startTimeNs = new long[20];
        return;
    }

    public static void beginSection(String r4) {
        if (traceEnabled == true) goto L5;
        return;
    L5:
        int r0 = traceDepth;
        if (r0 != 20) goto L9;
        depthPastMaxDepth++;
        return;
    L9:
        sections[r0] = r4;
        startTimeNs[r0] = System.nanoTime();
        TraceCompat.beginSection(r4);
        traceDepth++;
    }

    public static float endSection(String r4) {
        int r0 = depthPastMaxDepth;
        if (r0 <= 0) goto L7;
        depthPastMaxDepth = r0 - 1;
        return 0.0f;
    L7:
        if (traceEnabled == true) goto L9;
        return 0.0f;
    L9:
        int r1 = traceDepth - 1;
        traceDepth = r1;
        if (r1 == (-1)) goto L18;
        if (r4.equals(sections[r1]) == false) goto L16;
        TraceCompat.endSection();
        return (System.nanoTime() - startTimeNs[traceDepth]) / 1000000.0f;
    L16:
        throw new IllegalStateException("Unbalanced trace call " + r4 + ". Expected " + sections[traceDepth] + ".");
    L18:
        throw new IllegalStateException("Can't end trace section. There are none.");
    }
}
