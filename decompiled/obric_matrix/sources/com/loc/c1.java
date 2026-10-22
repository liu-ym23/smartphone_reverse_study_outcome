package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class c1 extends i1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ByteArrayOutputStream f7216c;

    public c1(i1 r1) {
        super(r1);
        this.f7216c = new ByteArrayOutputStream();
    }

    @Override // com.loc.i1
    protected final byte[] b(byte[] r2) {
        byte[] r3 = this.f7216c.toByteArray();
        this.f7216c.close();     // Catch: IOException -> L5
    L7:
        this.f7216c = new ByteArrayOutputStream();
        return r3;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.loc.i1
    public final void c(byte[] r1) {
        this.f7216c.write(r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
