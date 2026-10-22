package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f4788a;

    public static String a(Context r2) {
        if (f4788a != null) goto L6;
        String r3 = d.b.i.a.b.i.e.a(r2).replace(r2.getPackageName(), "p").replace(":", "_");
        f4788a = r3;
        f4788a = r3.replace(".", "_");
    L6:
        return f4788a;
    }
}
