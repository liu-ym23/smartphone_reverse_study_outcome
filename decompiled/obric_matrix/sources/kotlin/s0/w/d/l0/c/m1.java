package kotlin.s0.w.d.l0.c;

import androidx.core.os.EnvironmentCompat;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m1 f18886a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<n1, Integer> f18887b = null;

    public static final class a extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f18888c = null;

        static {
            f18888c = new a();
        }

        private a() {
            super("inherited", false);
        }
    }

    public static final class b extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f18889c = null;

        static {
            f18889c = new b();
        }

        private b() {
            super("internal", false);
        }
    }

    public static final class c extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f18890c = null;

        static {
            f18890c = new c();
        }

        private c() {
            super("invisible_fake", false);
        }
    }

    public static final class d extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f18891c = null;

        static {
            f18891c = new d();
        }

        private d() {
            super("local", false);
        }
    }

    public static final class e extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f18892c = null;

        static {
            f18892c = new e();
        }

        private e() {
            super("private", false);
        }
    }

    public static final class f extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f18893c = null;

        static {
            f18893c = new f();
        }

        private f() {
            super("private_to_this", false);
        }

        @Override // kotlin.s0.w.d.l0.c.n1
        public String b() {
            return "private/*private to this*/";
        }
    }

    public static final class g extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f18894c = null;

        static {
            f18894c = new g();
        }

        private g() {
            super("protected", true);
        }
    }

    public static final class h extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f18895c = null;

        static {
            f18895c = new h();
        }

        private h() {
            super("public", true);
        }
    }

    public static final class i extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i f18896c = null;

        static {
            f18896c = new i();
        }

        private i() {
            super(EnvironmentCompat.MEDIA_UNKNOWN, false);
        }
    }

    static {
        f18886a = new m1();
        Map r0 = kotlin.i0.m0.c();
        r0.put(f.f18893c, 0);
        r0.put(e.f18892c, 0);
        r0.put(b.f18889c, 1);
        r0.put(g.f18894c, 1);
        r0.put(h.f18895c, 2);
        f18887b = kotlin.i0.m0.b(r0);
    }

    private m1() {
    }

    public final Integer a(n1 r1, n1 r2) {
        kotlin.n0.d.o.f(r1, "first");
        kotlin.n0.d.o.f(r2, "second");
        if (r1 == r2) goto L5;
        Map<n1, Integer> r0 = f18887b;
        Integer r3 = r0.get(r1);
        Integer r4 = r0.get(r2);
        if (r3 == null) goto L13;
        if (r4 == null) goto L13;
        if (kotlin.n0.d.o.a(r3, r4) == true) goto L13;
        return Integer.valueOf(r3.intValue() - r4.intValue());
    L13:
        return null;
    L5:
        return 0;
    }

    public final boolean b(n1 r1) {
        kotlin.n0.d.o.f(r1, "visibility");
        if (r1 != e.f18892c) goto L5;
    L8:
        return true;
    L5:
        if (r1 == f.f18893c) goto L8;
        return false;
    }
}
