package d.c.i.g;

import android.content.Context;
import d.c.i.e.q;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f16076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.c.l.b.a f16077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f16078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.c.c.l.b f16079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f16080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f16081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f16082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f16083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f16084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f16085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f16086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f16087l;
    private final d m;
    private final d.c.c.d.l<Boolean> n;
    private final boolean o;
    private final boolean p;
    private final boolean q;

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f16088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d.c.c.l.b.a f16089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f16090c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d.c.c.l.b f16091d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f16092e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f16093f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f16094g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f16095h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f16096i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f16097j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f16098k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f16099l;
        private d m;
        public d.c.c.d.l<Boolean> n;
        public boolean o;
        public boolean p;
        public boolean q;

        public b(h.b r2) {
            this.f16088a = false;
            this.f16090c = false;
            this.f16092e = false;
            this.f16093f = false;
            this.f16094g = 0;
            this.f16095h = 0;
            this.f16096i = false;
            this.f16097j = 2048;
            this.f16098k = false;
            this.f16099l = false;
        }

        static /* synthetic */ boolean a(b r0) {
            return r0.f16088a;
        }

        static /* synthetic */ d.c.c.l.b.a b(b r0) {
            return r0.f16089b;
        }

        static /* synthetic */ boolean c(b r0) {
            return r0.f16099l;
        }

        static /* synthetic */ d d(b r0) {
            return r0.m;
        }

        static /* synthetic */ boolean e(b r0) {
            return r0.f16090c;
        }

        static /* synthetic */ d.c.c.l.b f(b r0) {
            return r0.f16091d;
        }

        static /* synthetic */ boolean g(b r0) {
            return r0.f16092e;
        }

        static /* synthetic */ boolean h(b r0) {
            return r0.f16093f;
        }

        static /* synthetic */ int i(b r0) {
            return r0.f16094g;
        }

        static /* synthetic */ int j(b r0) {
            return r0.f16095h;
        }

        static /* synthetic */ int k(b r0) {
            return r0.f16097j;
        }

        static /* synthetic */ boolean l(b r0) {
            return r0.f16098k;
        }

        public i m() {
            return new i(this, null);
        }
    }

    public static class c implements d {
        public c() {
        }

        @Override // d.c.i.g.i.d
        public l a(Context r24, d.c.c.g.a r25, d.c.i.i.c r26, d.c.i.i.f r27, boolean r28, boolean r29, boolean r30, e r31, d.c.c.g.i r32, q<d.c.b.a.d, d.c.i.l.c> r33, q<d.c.b.a.d, d.c.c.g.h> r34, d.c.i.e.e r35, d.c.i.e.e r36, HashMap<String, d.c.i.e.e> r37, d.c.i.e.f r38, d.c.i.d.f r39, int r40, int r41, boolean r42, int r43, boolean r44) {
            return new l(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44);
        }
    }

    public interface d {
        l a(Context r1, d.c.c.g.a r2, d.c.i.i.c r3, d.c.i.i.f r4, boolean r5, boolean r6, boolean r7, e r8, d.c.c.g.i r9, q<d.c.b.a.d, d.c.i.l.c> r10, q<d.c.b.a.d, d.c.c.g.h> r11, d.c.i.e.e r12, d.c.i.e.e r13, HashMap<String, d.c.i.e.e> r14, d.c.i.e.f r15, d.c.i.d.f r16, int r17, int r18, boolean r19, int r20, boolean r21);
    }

    private i(b r2) {
        this.f16076a = b.a(r2);
        this.f16077b = b.b(r2);
        this.f16078c = b.e(r2);
        this.f16079d = b.f(r2);
        this.f16080e = b.g(r2);
        this.f16081f = b.h(r2);
        this.f16082g = b.i(r2);
        this.f16083h = b.j(r2);
        this.f16084i = r2.f16096i;
        this.f16085j = b.k(r2);
        this.f16086k = b.l(r2);
        this.f16087l = b.c(r2);
        if (b.d(r2) != null) goto L5;
        d r0 = new c();
    L6:
        this.m = r0;
        this.n = r2.n;
        this.o = r2.o;
        this.p = r2.p;
        this.q = r2.q;
        return;
    L5:
        r0 = b.d(r2);
        goto L6
    }

    /* synthetic */ i(b r1, a r2) {
        this(r1);
    }

    public boolean a() {
        return this.f16084i;
    }

    public int b() {
        return this.f16083h;
    }

    public int c() {
        return this.f16082g;
    }

    public int d() {
        return this.f16085j;
    }

    public d e() {
        return this.m;
    }

    public boolean f() {
        return this.f16081f;
    }

    public boolean g() {
        return this.f16080e;
    }

    public d.c.c.l.b h() {
        return this.f16079d;
    }

    public d.c.c.l.b.a i() {
        return this.f16077b;
    }

    public boolean j() {
        return this.f16078c;
    }

    public boolean k() {
        return this.o;
    }

    public d.c.c.d.l<Boolean> l() {
        return this.n;
    }

    public boolean m() {
        return this.f16086k;
    }

    public boolean n() {
        return this.q;
    }

    public boolean o() {
        return this.f16087l;
    }

    public boolean p() {
        return this.p;
    }

    public boolean q() {
        return this.f16076a;
    }
}
