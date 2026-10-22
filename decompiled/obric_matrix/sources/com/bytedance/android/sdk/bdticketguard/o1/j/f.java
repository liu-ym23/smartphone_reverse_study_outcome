package com.bytedance.android.sdk.bdticketguard.o1.j;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f1000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f1001e;

    public f(String r2, String r3, String r4, g r5, boolean r6) {
        o.g(r2, "teePublicKey");
        o.g(r3, "clientCert");
        o.g(r4, "reePublicKey");
        o.g(r5, "attestationAdapter");
        this.f997a = r2;
        this.f998b = r3;
        this.f999c = r4;
        this.f1000d = r5;
        this.f1001e = r6;
    }

    public final g a() {
        return this.f1000d;
    }

    public final String b() {
        return this.f998b;
    }

    public final String c() {
        return this.f999c;
    }

    public final boolean d() {
        return this.f1001e;
    }

    public final String e() {
        return this.f997a;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
    L21:
        return true;
    L5:
        if ((r5 instanceof f) == false) goto L20;
        f r6 = (f) r5;
        if (o.a(this.f997a, r6.f997a) == false) goto L20;
        if (o.a(this.f998b, r6.f998b) == false) goto L20;
        if (o.a(this.f999c, r6.f999c) == false) goto L20;
        if (o.a(this.f1000d, r6.f1000d) == false) goto L20;
        if (this.f1001e != r6.f1001e) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L20;
    L17:
        r4 = false;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        String r0 = this.f997a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.f998b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f999c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        g r10 = this.f1000d;
        if (r10 == null) goto L17;
        r1 = r10.hashCode();
    L17:
        int r11 = (r9 + r1) * 31;
        boolean r12 = this.f1001e;
        ?? r13 = r12;
        if (r12 == false) goto L21;
        r13 = 1;
    L21:
        return r11 + r13;
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
        return "AttestationInfo(teePublicKey=" + this.f997a + ", clientCert=" + this.f998b + ", reePublicKey=" + this.f999c + ", attestationAdapter=" + this.f1000d + ", regenerateKey=" + this.f1001e + ")";
    }
}
