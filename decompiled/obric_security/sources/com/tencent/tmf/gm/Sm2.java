package com.tencent.tmf.gm;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Sm2 extends a {
    public static a.C0080a a(byte[] r3, byte[] r4, byte[] r5) {
        a.C0080a r0 = new a.C0080a();
        if (a.a(r3, 32) == true) goto L5;
    L17:
        r0.f32a = a.f31a;
        return r0;
    L5:
        if (a.a(r4, 32) == false) goto L17;
        if (r5 != null) goto L9;
    L15:
        r0.f32a = a.b;
        return r0;
    L9:
        if (r5.length == 0) goto L15;
        AtomicReference r1 = new AtomicReference();     // Catch: Throwable -> L13
        r0.f32a = doSm2Encrypt2(r3, r4, r5, r1);     // Catch: Throwable -> L13
        r0.b = (byte[]) r1.get();     // Catch: Throwable -> L13
        return r0;
    L13:
        r0.f32a = a.c;
        return r0;
    }

    private static native int doSm2Encrypt2(byte[] r0, byte[] r1, byte[] r2, AtomicReference<byte[]> r3);
}
