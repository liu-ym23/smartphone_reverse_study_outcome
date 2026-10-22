package p000j.k0.i;

import k.h;
import p000j.v;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f17933d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f17934e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h f17935f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h f17936g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h f17937h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final h f17938i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f17939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f17940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f17941c;

    interface a {
        void a(v r1);
    }

    static {
        f17933d = h.k(":");
        f17934e = h.k(":status");
        f17935f = h.k(":method");
        f17936g = h.k(":path");
        f17937h = h.k(":scheme");
        f17938i = h.k(":authority");
    }

    public c(String r1, String r2) {
        this(h.k(r1), h.k(r2));
    }

    public c(h r1, String r2) {
        this(r1, h.k(r2));
    }

    public c(h r1, h r2) {
        this.f17939a = r1;
        this.f17940b = r2;
        this.f17941c = (r1.size() + 32) + r2.size();
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof c) == false) goto L10;
        c r5 = (c) r4;
        if (this.f17939a.equals(r5.f17939a) == true) goto L7;
        return false;
    L7:
        if (this.f17940b.equals(r5.f17940b) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return ((527 + this.f17939a.hashCode()) * 31) + this.f17940b.hashCode();
    }

    public String toString() {
        return p000j.k0.c.r("%s: %s", new Object[]{this.f17939a.F(), this.f17940b.F()});
    }
}
