package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f8016e;

    public z0(Context r3, String r4, String r5, String r6) {
        if (TextUtils.isEmpty(r6) == true) goto L9;
        if (r6.length() > 256) goto L9;
        this.f8012a = r3.getApplicationContext();
        this.f8014c = r4;
        this.f8015d = r5;
        this.f8013b = r6;
        return;
    L9:
        throw new h5("无效的参数 - IllegalArgumentException");
    }

    private static byte[] c(int r3) {
        return new byte[]{(byte) ((r3 >> 24) & 255), (byte) ((r3 >> 16) & 255), (byte) ((r3 >> 8) & 255), (byte) (r3 & 255)};
    }

    private byte[] d(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        byte[] r1 = u5.o(this.f8016e);
        if (r1 != null) goto L11;
        return new byte[]{0, 0};
    L11:
        return u5.n(r1.length);
    L5:
        return new byte[]{0, 0};
    }

    public final void a(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L9;
        if (r3.length() > 65536) goto L9;
        this.f8016e = r3;
        return;
    L9:
        throw new h5("无效的参数 - IllegalArgumentException");
    }

    public final byte[] b() {
        int r0 = 0;
        byte[] r1 = new byte[0];
        ByteArrayOutputStream r2 = null;
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();     // Catch: Throwable -> L14
        u5.k(r3, this.f8014c);     // Catch: Throwable -> L12
        u5.k(r3, this.f8015d);     // Catch: Throwable -> L12
        u5.k(r3, this.f8013b);     // Catch: Throwable -> L12
        u5.k(r3, String.valueOf(l5.M(this.f8012a)));     // Catch: Throwable -> L12
        r0 = (int) (System.currentTimeMillis() / 1000);
    L7:
        r3.write(c(r0));     // Catch: Throwable -> L12
        r3.write(d(this.f8016e));     // Catch: Throwable -> L12
        r3.write(u5.o(this.f8016e));     // Catch: Throwable -> L12
        r1 = r3.toByteArray();     // Catch: Throwable -> L12
        r3.close();     // Catch: Throwable -> L10
    L37:
    L18:
        return r1;
    L12:
        th = th;
        r2 = r3;
    L29:
        v.m(th, "se", "tds");     // Catch: Throwable -> L19
        if (r2 == null) goto L18;
        r2.close();     // Catch: Throwable -> L10
    L19:
        th = move-exception;
        if (r2 != null) goto L33;
    L25:
        throw th;
    L33:
        r2.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.printStackTrace();
    L14:
        th = th;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }
}
