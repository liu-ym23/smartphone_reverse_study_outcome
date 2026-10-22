package com.bytedance.common.utility;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f3261a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f3262b = false;

    static {
        new HashMap();
    }

    public static boolean a() {
        if (f3262b == true) goto L10;
        if (Class.forName("miui.os.Build") == null) goto L8;
        f3261a = true;     // Catch: Exception -> L11
    L8:
        f3262b = true;
    L10:
        return f3261a;
    }
}
