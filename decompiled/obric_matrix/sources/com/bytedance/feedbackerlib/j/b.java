package com.bytedance.feedbackerlib.j;

import androidx.annotation.NonNull;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.framwork.core.sdkmonitor.k;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static k f4151a;

    static {
    }

    public static void a() {
        b().B();
        b().D();
    }

    @NonNull
    public static k b() {
        if (f4151a != null) goto L6;
        f4151a = SDKMonitorUtils.b(String.valueOf(1925));
    L6:
        return f4151a;
    }
}
