package com.obric.matrix.deviceinfo;

import android.content.Context;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.obric.matrix.ostracker_api.b;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f9090c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<String> f9091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<String> f9092b;

    private a(Context r1) {
        this.f9091a = new AtomicReference();
        this.f9092b = new AtomicReference();
    }

    private String c() {
        return b.c();
    }

    private String d() {
        return b.e();
    }

    public static a e(Context r2) {
        a r0 = f9090c;
        if (r0 == null) goto L5;
    L14:
        return r0;
    L5:
        monitor-enter(a.class);
        r0 = f9090c;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = new a(r2.getApplicationContext());     // Catch: Throwable -> L11
        f9090c = r0;     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static boolean f(String r1) {
        if (r1 != null) goto L4;
    L10:
        return false;
    L4:
        if (r1.isEmpty() == true) goto L10;
        if (BDLocationException.ERROR_TIMEOUT.equals(r1) == true) goto L10;
        if ("-1".equals(r1) == true) goto L10;
        return true;
    }

    public String a() {
        String r0 = this.f9091a.get();
        if (r0 == null) goto L5;
        return r0;
    L5:
        monitor-enter(this);
        String r1 = this.f9091a.get();     // Catch: Throwable -> L18
        if (r1 == null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L18
        return r1;
    L10:
        String r2 = c();     // Catch: Throwable -> L18
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        if (f(r2) == false) goto L16;
        this.f9091a.set(r2);     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);     // Catch: Throwable -> L18
        return r2;
    L18:
        th = move-exception;
        throw th;
    }

    public String b() {
        String r0 = this.f9092b.get();
        if (r0 == null) goto L5;
        return r0;
    L5:
        monitor-enter(this);
        String r1 = this.f9092b.get();     // Catch: Throwable -> L18
        if (r1 == null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L18
        return r1;
    L10:
        String r2 = d();     // Catch: Throwable -> L18
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        if (f(r2) == false) goto L16;
        this.f9092b.set(r2);     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);     // Catch: Throwable -> L18
        return r2;
    L18:
        th = move-exception;
        throw th;
    }

    public void g(String r2) {
        if (f(r2) == false) goto L6;
        this.f9091a.set(r2);
        return;
    }

    public void h(String r2) {
        if (f(r2) == false) goto L6;
        this.f9092b.set(r2);
        return;
    }
}
