package com.loc;

import android.content.Context;
import android.os.Build;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class g1 extends i1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f7314d = 13;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f7315e = 6;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f7316c;

    static {
    }

    public g1(Context r1, i1 r2) {
        super(r2);
        this.f7316c = r1;
    }

    private static byte[] d(Context r5) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r2 = new byte[0];
        u5.k(r0, "1.2." + f7314d + "." + f7315e);     // Catch: Throwable -> L8
        u5.k(r0, LocationInfoConst.SYSTEM);     // Catch: Throwable -> L8
        u5.k(r0, l5.P());     // Catch: Throwable -> L8
        u5.k(r0, l5.I());     // Catch: Throwable -> L8
        u5.k(r0, l5.F(r5));     // Catch: Throwable -> L8
        u5.k(r0, Build.MANUFACTURER);     // Catch: Throwable -> L8
        u5.k(r0, Build.MODEL);     // Catch: Throwable -> L8
        u5.k(r0, Build.DEVICE);     // Catch: Throwable -> L8
        u5.k(r0, l5.U());     // Catch: Throwable -> L8
        u5.k(r0, i5.g(r5));     // Catch: Throwable -> L8
        u5.k(r0, i5.h(r5));     // Catch: Throwable -> L8
        u5.k(r0, i5.j(r5));     // Catch: Throwable -> L8
        r0.write(new byte[]{0});     // Catch: Throwable -> L8
        r2 = r0.toByteArray();     // Catch: Throwable -> L8
        r0.close();     // Catch: Throwable -> L6
    L20:
    L11:
        return r2;
    L6:
        th = move-exception;
        th.printStackTrace();
    L8:
        th = move-exception;
        v.m(th, "sm", "gh");     // Catch: Throwable -> L12
        r0.close();     // Catch: Throwable -> L6
    L12:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L15
    L17:
        throw th;
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    @Override // com.loc.i1
    protected final byte[] b(byte[] r4) {
        byte[] r3 = d(this.f7316c);
        byte[] r0 = new byte[r3.length + r4.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        System.arraycopy(r4, 0, r0, r3.length, r4.length);
        return r0;
    }
}
