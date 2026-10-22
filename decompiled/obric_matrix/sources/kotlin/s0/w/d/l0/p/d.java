package kotlin.s0.w.d.l0.p;

import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.c.p;
import kotlin.n0.c.q;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final l<Object, Boolean> f21274a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final q<Object, Object, Object, f0> f21275b = null;

    static final class a extends kotlin.n0.d.q implements l {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f21276f = null;

        static {
            f21276f = new a();
        }

        a() {
            super(1);
        }

        public final Void a(Object r1) {
            return null;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a(r1);
        }
    }

    static final class b extends kotlin.n0.d.q implements l<Object, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f21277f = null;

        static {
            f21277f = new b();
        }

        b() {
            super(1);
        }

        public final Boolean a(Object r1) {
            return Boolean.TRUE;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(Object r1) {
            return a(r1);
        }
    }

    static final class c extends kotlin.n0.d.q implements l<Object, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f21278f = null;

        static {
            f21278f = new c();
        }

        c() {
            super(1);
        }

        public final void a(Object r1) {
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Object r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.p.d$d, reason: collision with other inner class name */
    static final class C0586d extends kotlin.n0.d.q implements p<Object, Object, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0586d f21279f = null;

        static {
            f21279f = new C0586d();
        }

        C0586d() {
            super(2);
        }

        public final void a(Object r1, Object r2) {
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ f0 invoke(Object r1, Object r2) {
            a(r1, r2);
            return f0.f18324a;
        }
    }

    static final class e extends kotlin.n0.d.q implements q<Object, Object, Object, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f21280f = null;

        static {
            f21280f = new e();
        }

        e() {
            super(3);
        }

        public final void a(Object r1, Object r2, Object r3) {
        }

        @Override // kotlin.n0.c.q
        public /* bridge */ /* synthetic */ f0 f(Object r1, Object r2, Object r3) {
            a(r1, r2, r3);
            return f0.f18324a;
        }
    }

    static final class f extends kotlin.n0.d.q implements l<Object, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f21281f = null;

        static {
            f21281f = new f();
        }

        f() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public final Object invoke(Object r1) {
            return r1;
        }
    }

    static {
        f r0 = f.f21281f;
        f21274a = b.f21277f;
        a r1 = a.f21276f;
        c r2 = c.f21278f;
        C0586d r3 = C0586d.f21279f;
        f21275b = e.f21280f;
    }

    public static final <T> l<T, Boolean> a() {
        return (l<T, Boolean>) f21274a;
    }

    public static final q<Object, Object, Object, f0> b() {
        return f21275b;
    }
}
