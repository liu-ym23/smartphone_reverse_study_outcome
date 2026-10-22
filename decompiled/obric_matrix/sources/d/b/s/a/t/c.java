package d.b.s.a.t;

import android.view.View;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.b.s.a.t.a f14917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.b.s.a.t.a f14918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f14919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View.OnClickListener f14920f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f14921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f14922b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private d.b.s.a.t.a f14923c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d.b.s.a.t.a f14924d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private e f14925e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f14926f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f14927g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private View.OnClickListener f14928h;

        public a() {
            this.f14925e = e.f14935f;
        }

        public final c a() {
            return new c(this.f14921a, this.f14922b, this.f14923c, this.f14924d, this.f14925e, this.f14926f, this.f14927g, this.f14928h, null);
        }

        public final a b(d.b.s.a.t.a r2) {
            o.g(r2, "buttonParams");
            this.f14923c = r2;
            return this;
        }

        public final a c(String r1) {
            this.f14922b = r1;
            return this;
        }

        public final a d(String r1) {
            this.f14921a = r1;
            return this;
        }

        public final boolean e() {
            return d.b.s.a.l0.b.f14847a.b(a());
        }
    }

    private c(String r1, String r2, d.b.s.a.t.a r3, d.b.s.a.t.a r4, e r5, boolean r6, boolean r7, View.OnClickListener r8) {
        this.f14915a = r1;
        this.f14916b = r2;
        this.f14917c = r3;
        this.f14918d = r4;
        this.f14919e = r7;
        this.f14920f = r8;
    }

    public /* synthetic */ c(String r1, String r2, d.b.s.a.t.a r3, d.b.s.a.t.a r4, e r5, boolean r6, boolean r7, View.OnClickListener r8, g r9) {
        this(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public final d.b.s.a.t.a a() {
        return this.f14917c;
    }

    public final String b() {
        return this.f14916b;
    }

    public final View.OnClickListener c() {
        return this.f14920f;
    }

    public final d.b.s.a.t.a d() {
        return this.f14918d;
    }

    public final String e() {
        return this.f14915a;
    }

    public final boolean f() {
        return this.f14919e;
    }
}
