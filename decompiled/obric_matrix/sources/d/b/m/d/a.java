package d.b.m.d;

import android.util.Log;
import com.bytedance.mpaas.alog.IALogService;
import com.bytedance.news.common.service.manager.d;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static IALogService f14145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f14146b;

    /* JADX INFO: renamed from: d.b.m.d.a$a, reason: collision with other inner class name */
    static class C0379a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static C0379a f14147e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static int f14148f = 16;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final Object f14149g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final StringBuilder f14150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Throwable f14151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        C0379a f14152c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f14153d;

        static {
            f14149g = new Object();
        }

        private C0379a() {
            this.f14150a = new StringBuilder(32);
            this.f14153d = 0;
        }

        static C0379a a() {
            Object r0 = f14149g;
            monitor-enter(r0);
            C0379a r1 = f14147e;     // Catch: Throwable -> L12
            if (r1 == null) goto L7;
            f14147e = r1.f14152c;     // Catch: Throwable -> L12
            r1.f14152c = null;     // Catch: Throwable -> L12
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L12
            if (r1 == null) goto L11;
            return r1;
        L11:
            return new C0379a();
        L7:
            r1 = null;
        L12:
            th = move-exception;
            throw th;
        }

        void b() {
            StringBuilder r0 = this.f14150a;
            r0.delete(0, r0.length());
            this.f14151b = null;
            Object r1 = f14149g;
            monitor-enter(r1);
            int r2 = this.f14153d;     // Catch: Throwable -> L9
            if (r2 >= f14148f) goto L7;
            this.f14152c = f14147e;     // Catch: Throwable -> L9
            f14147e = this;     // Catch: Throwable -> L9
            this.f14153d = r2 + 1;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r1);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    private static C0379a a(Object... r7) {
        C0379a r0 = C0379a.a();
        int r1 = r7.length;
        int r2 = r1 - 1;
        Object r3 = r7[r2];
        int r6 = 0;
        if ((r3 instanceof Throwable) == false) goto L8;
        r0.f14151b = (Throwable) r3;
    L5:
        if (r6 >= r2) goto L7;
        StringBuilder r4 = r0.f14150a;
        r4.append(r7[r6]);
        r4.append(" ");
        r6 = r6 + 1;
        goto L5
    L7:
        StringBuilder r8 = r0.f14150a;
        r8.append("\n");
        r8.append(Log.getStackTraceString(r0.f14151b));
    L10:
        return r0;
    L8:
        if (r6 >= r1) goto L10;
        StringBuilder r5 = r0.f14150a;
        r5.append(r7[r6]);
        r5.append(" ");
        r6 = r6 + 1;
        goto L8
    }

    public static void b(String r2, Object... r3) {
        if (d(0) == true) goto L5;
        return;
    L5:
        C0379a r4 = a(r3);
        String r0 = r4.f14150a.toString();
        if (e() == null) goto L8;
        e().logD(r2, r0);
    L9:
        r4.b();
        return;
    L8:
        Log.d(r2, r0);
        goto L9
    }

    public static void c(String r2, Object... r3) {
        if (d(3) == true) goto L5;
        return;
    L5:
        C0379a r4 = a(r3);
        String r0 = r4.f14150a.toString();
        if (e() == null) goto L8;
        e().logE(r2, r0);
    L9:
        r4.b();
        return;
    L8:
        Log.e(r2, r0);
        goto L9
    }

    static boolean d(int r1) {
        if (r1 < f14146b) goto L6;
        return true;
    L6:
        return false;
    }

    private static IALogService e() {
        if (f14145a != null) goto L6;
        f14145a = (IALogService) d.a(IALogService.class);
    L6:
        return f14145a;
    }

    public static void f(int r0) {
        f14146b = r0;
    }

    public static void g(String r2, Object... r3) {
        if (d(2) == true) goto L5;
        return;
    L5:
        C0379a r4 = a(r3);
        String r0 = r4.f14150a.toString();
        if (e() == null) goto L8;
        e().logW(r2, r0);
    L9:
        r4.b();
        return;
    L8:
        Log.w(r2, r0);
        goto L9
    }
}
