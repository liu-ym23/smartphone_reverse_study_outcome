package kotlin.s0.w.d.l0.d.b;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f19185a = null;

        static {
            f19185a = new a();
        }

        private a() {
        }

        @Override // kotlin.s0.w.d.l0.d.b.c
        public boolean a() {
            return false;
        }

        @Override // kotlin.s0.w.d.l0.d.b.c
        public void b(String r1, e r2, String r3, f r4, String r5) {
            o.f(r1, "filePath");
            o.f(r2, "position");
            o.f(r3, "scopeFqName");
            o.f(r4, "scopeKind");
            o.f(r5, "name");
        }
    }

    boolean a();

    void b(String r1, e r2, String r3, f r4, String r5);
}
