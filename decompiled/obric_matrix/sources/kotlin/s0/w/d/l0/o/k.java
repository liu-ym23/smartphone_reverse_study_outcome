package kotlin.s0.w.d.l0.o;

import kotlin.s0.w.d.l0.c.y;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21227a;

    public static final class a extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f21228b = null;

        static {
            f21228b = new a();
        }

        private a() {
            super("must be a member function", null);
        }

        @Override // kotlin.s0.w.d.l0.o.f
        public boolean b(y r1) {
            kotlin.n0.d.o.f(r1, "functionDescriptor");
            if (r1.f0() == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class b extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f21229b = null;

        static {
            f21229b = new b();
        }

        private b() {
            super("must be a member or an extension function", null);
        }

        @Override // kotlin.s0.w.d.l0.o.f
        public boolean b(y r1) {
            kotlin.n0.d.o.f(r1, "functionDescriptor");
            if (r1.f0() == null) goto L5;
        L8:
            return true;
        L5:
            if (r1.m0() != null) goto L8;
            return false;
        }
    }

    private k(String r1) {
        this.f21227a = r1;
    }

    public /* synthetic */ k(String r1, kotlin.n0.d.g r2) {
        this(r1);
    }

    @Override // kotlin.s0.w.d.l0.o.f
    public String a(y r1) {
        return f.a.a(this, r1);
    }

    @Override // kotlin.s0.w.d.l0.o.f
    public String getDescription() {
        return this.f21227a;
    }
}
