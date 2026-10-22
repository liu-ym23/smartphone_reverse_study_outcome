package d.b.l.a.h;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class c {

    static class a implements e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f14116f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f14117g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Runnable f14118h;

        a(String r1, b r2, Runnable r3) {
            this.f14116f = r1;
            this.f14117g = r2;
            this.f14118h = r3;
        }

        @Override // d.b.l.a.h.e
        public b S() {
            return this.f14117g;
        }

        @Override // d.b.l.a.h.e
        public String X() {
            return this.f14116f;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable r0 = this.f14118h;     // Catch: Throwable -> L12
            if (r0 == null) goto L17;
            r0.run();     // Catch: Throwable -> L12
            d r1 = c.a();     // Catch: Throwable -> L12
            if (r1 != null) goto L7;
            return;
        L7:
            if (r1.j() != null) goto L9;
            return;
        L9:
            if (r1.j().isDebug() == false) goto L20;
            c.c(r1.j(), "AsyncTaskUtil", "task execute: " + this.f14117g + "  /  " + this.f14116f);     // Catch: Throwable -> L12
            return;
        L20:
            return;
        L17:
            return;
        L12:
            th = move-exception;
            c.a().a(th, "APM_INNER_ERROR_async_task");
        }
    }

    public static d a() {
        return d.b.l.a.h.a.n();
    }

    public static String b(e r2) {
        if (r2 != null) goto L6;
        return "null";
    L6:
        return r2.X() + ", " + r2.S();
    }

    public static void c(f r4, String r5, String r6) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isDebug() == false) goto L8;
        String r0 = Thread.currentThread().getName();
        r4.a(r5, String.format(Locale.CHINA, "[callerThread: %s] \n %s", new Object[]{r0, r6}));
        return;
    }

    public static e d(String r1, Runnable r2) {
        return f(b.f14112f, r1, r2);
    }

    public static e e(String r1, Runnable r2) {
        return f(b.f14114h, r1, r2);
    }

    public static e f(b r1, String r2, Runnable r3) {
        return new a(r2, r1, r3);
    }
}
