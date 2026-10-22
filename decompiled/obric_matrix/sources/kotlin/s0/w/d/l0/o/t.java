package kotlin.s0.w.d.l0.o;

import kotlin.s0.w.d.l0.c.y;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21266a;

    public static final class a extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f21267b;

        public a(int r3) {
            StringBuilder r0 = new StringBuilder();
            r0.append("must have at least ");
            r0.append(r3);
            r0.append(" value parameter");
            if (r3 <= 1) goto L5;
            String r1 = "s";
        L6:
            r0.append(r1);
            super(r0.toString(), null);
            this.f21267b = r3;
            return;
        L5:
            r1 = "";
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.o.f
        public boolean b(y r2) {
            kotlin.n0.d.o.f(r2, "functionDescriptor");
            if (r2.h().size() < this.f21267b) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class b extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f21268b;

        public b(int r3) {
            super("must have exactly " + r3 + " value parameters", null);
            this.f21268b = r3;
        }

        @Override // kotlin.s0.w.d.l0.o.f
        public boolean b(y r2) {
            kotlin.n0.d.o.f(r2, "functionDescriptor");
            if (r2.h().size() != this.f21268b) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class c extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f21269b = null;

        static {
            f21269b = new c();
        }

        private c() {
            super("must have no value parameters", null);
        }

        @Override // kotlin.s0.w.d.l0.o.f
        public boolean b(y r1) {
            kotlin.n0.d.o.f(r1, "functionDescriptor");
            return r1.h().isEmpty();
        }
    }

    public static final class d extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f21270b = null;

        static {
            f21270b = new d();
        }

        private d() {
            super("must have a single value parameter", null);
        }

        @Override // kotlin.s0.w.d.l0.o.f
        public boolean b(y r1) {
            kotlin.n0.d.o.f(r1, "functionDescriptor");
            if (r1.h().size() == 1) goto L7;
            return false;
        L7:
            return true;
        }
    }

    private t(String r1) {
        this.f21266a = r1;
    }

    public /* synthetic */ t(String r1, kotlin.n0.d.g r2) {
        this(r1);
    }

    @Override // kotlin.s0.w.d.l0.o.f
    public String a(y r1) {
        return f.a.a(this, r1);
    }

    @Override // kotlin.s0.w.d.l0.o.f
    public String getDescription() {
        return this.f21266a;
    }
}
