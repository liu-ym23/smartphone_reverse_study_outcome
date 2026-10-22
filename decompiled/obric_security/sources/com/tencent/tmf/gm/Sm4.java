package com.tencent.tmf.gm;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Sm4 extends a {
    public static a.C0080a a(byte[] r2, byte[] r3) {
        a.C0080a r0 = new a.C0080a();
        if (a.a(r2, 16) == true) goto L6;
        r0.f32a = a.f31a;
        return r0;
    L6:
        if (r3 != null) goto L8;
    L14:
        r0.f32a = a.b;
        return r0;
    L8:
        if (r3.length == 0) goto L14;
        AtomicReference r1 = new AtomicReference();     // Catch: Throwable -> L12
        r0.f32a = doSm4DecryptECB(r2, r3, r1);     // Catch: Throwable -> L12
        r0.b = (byte[]) r1.get();     // Catch: Throwable -> L12
        return r0;
    L12:
        r0.f32a = a.c;
        return r0;
    }

    public static a.C0080a b(byte[] r2, byte[] r3) {
        a.C0080a r0 = new a.C0080a();
        if (a.a(r2, 16) == true) goto L6;
        r0.f32a = a.f31a;
        return r0;
    L6:
        if (r3 != null) goto L8;
    L14:
        r0.f32a = a.b;
        return r0;
    L8:
        if (r3.length == 0) goto L14;
        AtomicReference r1 = new AtomicReference();     // Catch: Throwable -> L12
        r0.f32a = doSm4EncryptECB(r2, r3, r1);     // Catch: Throwable -> L12
        r0.b = (byte[]) r1.get();     // Catch: Throwable -> L12
        return r0;
    L12:
        r0.f32a = a.c;
        return r0;
    }

    private static native int doSm4DecryptECB(byte[] r0, byte[] r1, AtomicReference<byte[]> r2);

    private static native int doSm4EncryptECB(byte[] r0, byte[] r1, AtomicReference<byte[]> r2);
}
