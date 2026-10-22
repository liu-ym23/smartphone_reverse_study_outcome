package com.bytedance.apm6.util;

import android.os.Trace;

/* JADX INFO: loaded from: classes.dex */
public class TraceUtils {
    public TraceUtils() {
    }

    public static void beginSection(String r1) {
        if (ApmBaseContext.isSystraceMode() == false) goto L6;
        Trace.beginSection(r1);
        return;
    }

    public static void endSection() {
        if (ApmBaseContext.isSystraceMode() == false) goto L6;
        Trace.endSection();
        return;
    }
}
