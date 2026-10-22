package kotlin.s0.w.d.l0.f.a0.b;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f19878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f19879b;

        public a(String r2, String r3) {
            o.f(r2, "name");
            o.f(r3, "desc");
            super(null);
            this.f19878a = r2;
            this.f19879b = r3;
        }

        @Override // kotlin.s0.w.d.l0.f.a0.b.d
        public String a() {
            return c() + ':' + b();
        }

        @Override // kotlin.s0.w.d.l0.f.a0.b.d
        public String b() {
            return this.f19879b;
        }

        @Override // kotlin.s0.w.d.l0.f.a0.b.d
        public String c() {
            return this.f19878a;
        }

        public final String d() {
            return c();
        }

        public final String e() {
            return b();
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (o.a(c(), r6.c()) == true) goto L12;
            return false;
        L12:
            if (o.a(b(), r6.b()) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (c().hashCode() * 31) + b().hashCode();
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f19880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f19881b;

        public b(String r2, String r3) {
            o.f(r2, "name");
            o.f(r3, "desc");
            super(null);
            this.f19880a = r2;
            this.f19881b = r3;
        }

        @Override // kotlin.s0.w.d.l0.f.a0.b.d
        public String a() {
            return c() + b();
        }

        @Override // kotlin.s0.w.d.l0.f.a0.b.d
        public String b() {
            return this.f19881b;
        }

        @Override // kotlin.s0.w.d.l0.f.a0.b.d
        public String c() {
            return this.f19880a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (o.a(c(), r6.c()) == true) goto L12;
            return false;
        L12:
            if (o.a(b(), r6.b()) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (c().hashCode() * 31) + b().hashCode();
        }
    }

    private d() {
    }

    public /* synthetic */ d(kotlin.n0.d.g r1) {
        this();
    }

    public abstract String a();

    public abstract String b();

    public abstract String c();

    public final String toString() {
        return a();
    }
}
