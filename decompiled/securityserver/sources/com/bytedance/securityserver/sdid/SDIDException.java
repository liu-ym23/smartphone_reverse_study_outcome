package com.bytedance.securityserver.sdid;

import a.a;

/* JADX INFO: loaded from: classes.dex */
public class SDIDException extends Exception {
    public final int b;
    public final String c;

    public SDIDException(int r1, String r2) {
        super(r2);
        this.b = r1;
        this.c = r2;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder r0 = new StringBuilder("SDIDException{errCode=");
        r0.append(this.b);
        r0.append(", errMsg=");
        return a.o(r0, this.c, "}");
    }
}
