package com.loc;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class k1 extends o1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7466c;

    public k1(String r1, o1 r2) {
        super(r2);
        this.f7465b = 30;
        this.f7466c = r1;
    }

    private static int f(String r3) {
        File r1 = new File(r3);     // Catch: Throwable -> L8
        if (r1.exists() == true) goto L6;
        return 0;
    L6:
        return r1.list().length;
    L8:
        th = move-exception;
        v.m(th, "fus", "gfn");
        return 0;
    }

    @Override // com.loc.o1
    protected final boolean c() {
        if (f(this.f7466c) >= this.f7465b) goto L6;
        return false;
    L6:
        return true;
    }
}
