package com.bytedance.apm.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2057a;

    static {
    }

    @Nullable
    public static String a(Context r1) {
        String r2 = f2057a;
        if (TextUtils.isEmpty(r2) == true) goto L5;
        return r2;
    L5:
        String r3 = b();
        f2057a = r3;
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    }

    @Nullable
    private static String b() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r2 = new StringBuilder(32);     // Catch: Throwable -> L14
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L14
        if (r3 <= 0) goto L8;
        r2.append((char) r3);     // Catch: Throwable -> L14
        goto L5
    L8:
        String r0 = r2.toString();     // Catch: Throwable -> L14
        d.b.l.a.d.b(r1);
        return r0;
    L12:
        d.b.l.a.d.b(r1);
        return null;
    L11:
        r1 = null;
        goto L12
    }
}
