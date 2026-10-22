package com.bytedance.android.sdk.bdticketguard;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i0 f718e;

    public f() {
        this(null, null, null, null, null, 31, null);
    }

    public f(String r2, String r3, String r4, String r5, i0 r6) {
        kotlin.n0.d.o.g(r2, "teePublicKey");
        kotlin.n0.d.o.g(r3, "reePublicKey");
        kotlin.n0.d.o.g(r4, "clientCert");
        kotlin.n0.d.o.g(r5, "certChain");
        this.f714a = r2;
        this.f715b = r3;
        this.f716c = r4;
        this.f717d = r5;
        this.f718e = r6;
    }

    public /* synthetic */ f(String r2, String r3, String r4, String r5, i0 r6, int r7, kotlin.n0.d.g r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = "";
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = null;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final i0 a() {
        return this.f718e;
    }

    public final String b() {
        return this.f717d;
    }

    public final String c() {
        return this.f716c;
    }

    public final String d() {
        return this.f715b;
    }

    public final String e() {
        return this.f714a;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L16;
        f r4 = (f) r3;
        if (kotlin.n0.d.o.a(this.f714a, r4.f714a) == true) goto L8;
        return false;
    L8:
        if (kotlin.n0.d.o.a(this.f715b, r4.f715b) == true) goto L10;
        return false;
    L10:
        if (kotlin.n0.d.o.a(this.f716c, r4.f716c) == true) goto L12;
        return false;
    L12:
        if (kotlin.n0.d.o.a(this.f717d, r4.f717d) == true) goto L14;
        return false;
    L14:
        if (kotlin.n0.d.o.a(this.f718e, r4.f718e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.f714a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.f715b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f716c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f717d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        i0 r13 = this.f718e;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AttestationRequest(teePublicKey=" + this.f714a + ", reePublicKey=" + this.f715b + ", clientCert=" + this.f716c + ", certChain=" + this.f717d + ", alternateParams=" + this.f718e + ")";
    }
}
