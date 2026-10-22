package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Trace;

/* JADX INFO: loaded from: classes2.dex */
@d
@TargetApi(18)
class Api18TraceUtils {
    Api18TraceUtils() {
    }

    public static void a(String r0) {
        Trace.beginSection(r0);
    }

    public static void b() {
        Trace.endSection();
    }
}
