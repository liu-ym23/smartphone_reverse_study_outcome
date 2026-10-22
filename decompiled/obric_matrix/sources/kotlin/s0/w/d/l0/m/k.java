package kotlin.s0.w.d.l0.m;

import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
public interface k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20935a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f20936a = null;

        static {
            f20936a = new a();
        }

        private a() {
        }

        public final d a(Runnable r1, kotlin.n0.c.l<? super InterruptedException, f0> r2) {
            if (r1 == null) goto L6;
            if (r2 == null) goto L6;
            return new c(r1, r2);
        L6:
            return new d(null, 1, null);
        }
    }

    static {
        f20935a = a.f20936a;
    }

    void a();

    void b();
}
