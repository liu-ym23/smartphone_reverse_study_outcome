package com.bytedance.securityserver.trustcircle;

/* JADX INFO: loaded from: classes.dex */
public class TrustCircleException extends Exception {
    public final int b;
    public final String c;

    public TrustCircleException(int r1, String r2) {
        super(r2);
        this.b = r1;
        this.c = r2;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder r0 = new StringBuilder("TrustCircleException{errCode=");
        r0.append(this.b);
        r0.append(", errMsg=");
        return a.a.o(r0, this.c, "}");
    }
}
