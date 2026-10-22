package com.loc;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private t5 f7951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7952c;

    public x0(Context r1, t5 r2, String r3) {
        this.f7950a = r1.getApplicationContext();
        this.f7951b = r2;
        this.f7952c = r3;
    }

    private static String a(Context r2, t5 r3, String r4) {
        StringBuilder r0 = new StringBuilder();
        r0.append("\"sdkversion\":\"");     // Catch: Throwable -> L5
        r0.append(r3.f());     // Catch: Throwable -> L5
        r0.append("\",\"product\":\"");     // Catch: Throwable -> L5
        r0.append(r3.a());     // Catch: Throwable -> L5
        r0.append("\",\"nt\":\"");     // Catch: Throwable -> L5
        r0.append(l5.y(r2));     // Catch: Throwable -> L5
        r0.append("\",\"details\":");     // Catch: Throwable -> L5
        r0.append(r4);     // Catch: Throwable -> L5
    L8:
        return r0.toString();
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    final byte[] b() {
        return u5.o(a(this.f7950a, this.f7951b, this.f7952c));
    }
}
