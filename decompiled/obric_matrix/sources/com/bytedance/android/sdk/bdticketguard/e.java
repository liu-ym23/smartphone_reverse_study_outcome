package com.bytedance.android.sdk.bdticketguard;

/* JADX INFO: loaded from: classes.dex */
public final class e extends c0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i f707f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f708g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f709h;

    public e(i r2, int r3, String r4) {
        kotlin.n0.d.o.g(r2, "snapshot");
        kotlin.n0.d.o.g(r4, "logId");
        this.f707f = r2;
        this.f708g = r3;
        this.f709h = r4;
    }

    public final int a() {
        return this.f708g;
    }

    public final String b() {
        return this.f709h;
    }

    public final i c() {
        return this.f707f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
    L17:
        return true;
    L5:
        if ((r5 instanceof e) == false) goto L16;
        e r6 = (e) r5;
        if (kotlin.n0.d.o.a(this.f707f, r6.f707f) == false) goto L16;
        if (this.f708g != r6.f708g) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L16;
        if (kotlin.n0.d.o.a(this.f709h, r6.f709h) == false) goto L16;
    L11:
        r1 = false;
    L16:
        return false;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Attestation failed, error code: " + this.f708g + ", logId: " + this.f709h;
    }

    public int hashCode() {
        i r0 = this.f707f;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + Integer.hashCode(this.f708g)) * 31;
        String r4 = this.f709h;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "AttestationRemoteException(snapshot=" + this.f707f + ", errorCode=" + this.f708g + ", logId=" + this.f709h + ")";
    }
}
