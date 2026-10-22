package com.bytedance.apm.f0;

import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Handler f1503a;

    static {
        new HashSet();
        f1503a = new Handler(Looper.getMainLooper());
    }

    public static Handler a() {
        return f1503a;
    }
}
