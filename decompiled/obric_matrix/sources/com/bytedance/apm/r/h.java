package com.bytedance.apm.r;

import java.util.ConcurrentModificationException;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashSet<String> f1836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f1837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f1838c;

    static {
        f1836a = new HashSet();
        f1837b = "";
        f1838c = true;
    }

    public static void a(String r1) {
        f1838c = true;
        f1836a.add(r1);
    }

    public static String b() {
        if (f1838c == false) goto L6;
        f1837b = com.bytedance.apm.util.i.c(f1836a, ",");     // Catch: ConcurrentModificationException -> L7
        f1838c = false;     // Catch: ConcurrentModificationException -> L7
    L6:
        return f1837b;
    }

    public static void c(String r1) {
        f1838c = true;
        f1836a.remove(r1);
    }
}
