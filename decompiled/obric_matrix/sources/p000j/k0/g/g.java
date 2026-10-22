package p000j.k0.g;

import java.util.List;
import p000j.d0;
import p000j.e;
import p000j.f0;
import p000j.j;
import p000j.k0.f.c;
import p000j.s;
import p000j.x;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements x.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<x> f17879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p000j.k0.f.g f17880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f17881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f17882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f17883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d0 f17884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e f17885g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final s f17886h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f17887i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f17888j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f17889k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f17890l;

    public g(List<x> r1, p000j.k0.f.g r2, c r3, c r4, int r5, d0 r6, e r7, s r8, int r9, int r10, int r11) {
        this.f17879a = r1;
        this.f17882d = r4;
        this.f17880b = r2;
        this.f17881c = r3;
        this.f17883e = r5;
        this.f17884f = r6;
        this.f17885g = r7;
        this.f17886h = r8;
        this.f17887i = r9;
        this.f17888j = r10;
        this.f17889k = r11;
    }

    @Override // j.x.a
    public int a() {
        return this.f17888j;
    }

    @Override // j.x.a
    public d0 b() {
        return this.f17884f;
    }

    @Override // j.x.a
    public int c() {
        return this.f17889k;
    }

    @Override // j.x.a
    public f0 d(d0 r4) {
        return j(r4, this.f17880b, this.f17881c, this.f17882d);
    }

    @Override // j.x.a
    public j e() {
        return this.f17882d;
    }

    @Override // j.x.a
    public int f() {
        return this.f17887i;
    }

    public e g() {
        return this.f17885g;
    }

    public s h() {
        return this.f17886h;
    }

    public c i() {
        return this.f17881c;
    }

    public f0 j(d0 r20, p000j.k0.f.g r21, c r22, c r23) {
        if (this.f17883e >= this.f17879a.size()) goto L37;
        this.f17890l++;
        if (this.f17881c == null) goto L12;
        if (this.f17882d.t(r20.k()) == true) goto L12;
        throw new IllegalStateException("network interceptor " + this.f17879a.get(this.f17883e - 1) + " must retain the same host and port");
    L12:
        if (this.f17881c != null) goto L14;
    L18:
        List<x> r15 = this.f17879a;
        int r14 = this.f17883e;
        g r1 = new g(r15, r21, r22, r23, r14 + 1, r20, this.f17885g, this.f17886h, this.f17887i, this.f17888j, this.f17889k);
        x r2 = r15.get(r14);
        f0 r4 = r2.a(r1);
        if (r22 == null) goto L28;
        if ((this.f17883e + 1) >= this.f17879a.size()) goto L28;
        if (r1.f17890l == 1) goto L28;
        throw new IllegalStateException("network interceptor " + r2 + " must call proceed() exactly once");
    L28:
        if (r4 == null) goto L35;
        if (r4.a() == null) goto L33;
        return r4;
    L33:
        throw new IllegalStateException("interceptor " + r2 + " returned a response with no body");
    L35:
        throw new NullPointerException("interceptor " + r2 + " returned null");
    L14:
        if (this.f17890l <= 1) goto L18;
        throw new IllegalStateException("network interceptor " + this.f17879a.get(this.f17883e - 1) + " must call proceed() exactly once");
    L37:
        throw new AssertionError();
    }

    public p000j.k0.f.g k() {
        return this.f17880b;
    }
}
