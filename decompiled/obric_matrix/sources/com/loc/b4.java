package com.loc;

import com.ttnet.org.chromium.net.NetError;

/* JADX INFO: loaded from: classes2.dex */
public final class b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f7188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7192i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7193j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7194k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7195l;
    public short m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public int s;
    public long t;

    public b4(int r5, boolean r6) {
        this.f7184a = 0;
        this.f7185b = 0;
        this.f7186c = 0;
        this.f7187d = 0;
        this.f7188e = 0;
        this.f7189f = 0;
        this.f7190g = 0;
        this.f7191h = 0;
        this.f7192i = 0;
        this.f7193j = 0;
        this.f7194k = NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH;
        this.f7195l = 0;
        this.m = 0;
        this.n = false;
        this.o = 32767;
        this.p = Integer.MAX_VALUE;
        this.q = Integer.MAX_VALUE;
        this.r = true;
        this.s = 99;
        this.t = 0;
        this.f7195l = r5;
        this.n = r6;
    }

    private String e() {
        int r0 = this.f7195l;
        return this.f7195l + "#" + this.f7184a + "#" + this.f7185b + "#0#" + a();
    }

    private String f() {
        return this.f7195l + "#" + this.f7191h + "#" + this.f7192i + "#" + this.f7193j;
    }

    public final long a() {
        if (this.f7195l != 5) goto L7;
        return this.f7188e;
    L7:
        return this.f7187d;
    }

    public final String b() {
        int r0 = this.f7195l;
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L15;
        if (r0 == 3) goto L17;
        if (r0 == 4) goto L17;
        if (r0 == 5) goto L17;
        return null;
    L15:
        return f();
    L17:
        return e();
    }

    public final String c() {
        String r0 = b();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.length() > 0) goto L7;
        return "";
    L7:
        return (this.r ? 1 : 0) + "#" + r0;
    }

    protected final /* synthetic */ Object clone() {
        return d();
    }

    protected final b4 d() {
        b4 r0 = new b4(this.f7195l, this.n);
        r0.f7184a = this.f7184a;
        r0.f7185b = this.f7185b;
        r0.f7186c = this.f7186c;
        r0.f7187d = this.f7187d;
        r0.f7188e = this.f7188e;
        r0.f7189f = this.f7189f;
        r0.f7190g = this.f7190g;
        r0.f7191h = this.f7191h;
        r0.f7192i = this.f7192i;
        r0.f7193j = this.f7193j;
        r0.f7194k = this.f7194k;
        r0.m = this.m;
        r0.o = this.o;
        r0.p = this.p;
        r0.q = this.q;
        r0.r = this.r;
        r0.s = this.s;
        r0.t = this.t;
        return r0;
    }

    public final boolean equals(Object r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if ((r8 instanceof b4) == false) goto L72;
        b4 r9 = (b4) r8;
        int r1 = r9.f7195l;
        if (r1 == 1) goto L63;
        if (r1 == 2) goto L52;
        if (r1 == 3) goto L41;
        if (r1 == 4) goto L30;
        if (r1 == 5) goto L19;
        return false;
    L19:
        if (this.f7195l == 5) goto L22;
        return false;
    L22:
        if (r9.f7186c == this.f7186c) goto L24;
    L28:
        return false;
    L24:
        if (r9.f7188e != this.f7188e) goto L28;
        if (r9.q != this.q) goto L28;
        return true;
    L30:
        if (this.f7195l == 4) goto L33;
        return false;
    L33:
        if (r9.f7186c == this.f7186c) goto L35;
    L39:
        return false;
    L35:
        if (r9.f7187d != this.f7187d) goto L39;
        if (r9.f7185b != this.f7185b) goto L39;
        return true;
    L41:
        if (this.f7195l == 3) goto L44;
        return false;
    L44:
        if (r9.f7186c == this.f7186c) goto L46;
    L50:
        return false;
    L46:
        if (r9.f7187d != this.f7187d) goto L50;
        if (r9.f7185b != this.f7185b) goto L50;
        return true;
    L52:
        if (this.f7195l == 2) goto L55;
        return false;
    L55:
        if (r9.f7193j == this.f7193j) goto L57;
    L61:
        return false;
    L57:
        if (r9.f7192i != this.f7192i) goto L61;
        if (r9.f7191h != this.f7191h) goto L61;
        return true;
    L63:
        if (this.f7195l == 1) goto L66;
        return false;
    L66:
        if (r9.f7186c != this.f7186c) goto L72;
        if (r9.f7187d != this.f7187d) goto L72;
        if (r9.f7185b != this.f7185b) goto L72;
        return true;
    L72:
        return false;
    }

    public final int hashCode() {
        int r0 = String.valueOf(this.f7195l).hashCode();
        if (this.f7195l != 2) goto L5;
        int r1 = String.valueOf(this.f7193j).hashCode() + String.valueOf(this.f7192i).hashCode();
        int r3 = this.f7191h;
    L7:
        return r0 + (r1 + String.valueOf(r3).hashCode());
    L5:
        r1 = String.valueOf(this.f7186c).hashCode() + String.valueOf(this.f7187d).hashCode();
        r3 = this.f7185b;
        goto L7
    }
}
