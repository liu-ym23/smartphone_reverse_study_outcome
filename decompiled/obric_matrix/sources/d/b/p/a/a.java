package d.b.p.a;

import android.app.Application;
import android.text.TextUtils;
import d.b.p.a.d.f;
import d.b.p.a.d.g;
import d.b.p.a.d.h;
import d.b.p.a.g.d;
import d.b.p.a.h.c;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f14203c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Application f14204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<String, d.b.p.a.g.a> f14205b;

    /* JADX INFO: renamed from: d.b.p.a.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0384a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Application f14206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HashMap<String, d.b.p.a.g.a> f14207b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private f f14208c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private h.c f14209d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private g f14210e;

        public b(Application r2) {
            this.f14207b = new HashMap();
            if (r2 == null) goto L7;
            this.f14206a = r2;
            return;
        L7:
            throw new RuntimeException("Godzilla init, application is null");
        }

        public a a() {
            return new a(this.f14206a, this.f14207b, this.f14208c, this.f14209d, this.f14210e, null);
        }

        public b b(d.b.p.a.g.a r5) {
            String r0 = r5.b();
            if (TextUtils.isEmpty(r0) == true) goto L11;
            if (this.f14207b.get(r0) != null) goto L9;
            this.f14207b.put(r0, r5);
            return this;
        L9:
            throw new RuntimeException(String.format("%s plugin is already exist", new Object[]{r0}));
        L11:
            throw new RuntimeException(String.format("%s plugin name is null", new Object[]{r5.getClass().getName()}));
        }
    }

    private a(Application r2, HashMap<String, d.b.p.a.g.a> r3, f r4, h.c r5, g r6) {
        this.f14204a = r2;
        this.f14205b = r3;
        d.b.p.a.b.f14211g.b(r2, r4, r5);
        Iterator<d.b.p.a.g.a> r7 = r3.values().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r7.next().c(this.f14204a);
        goto L4
    L6:
        c.b(r6);
    }

    /* synthetic */ a(Application r1, HashMap r2, f r3, h.c r4, g r5, C0384a r6) {
        this(r1, r2, r3, r4, r5);
    }

    public static a a(a r2) {
        if (r2 == null) goto L16;
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L6:
        if (f14203c != null) goto L8;
        f14203c = r2;     // Catch: Throwable -> L12
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L12
        return f14203c;
    L8:
        h.c("Godzilla", "Godzilla instance is already set. this invoking will be ignored");     // Catch: Throwable -> L12
        goto L9
    L16:
        throw new RuntimeException("Godzilla should not be null.");
    }

    public void b(d r5) {
        Iterator<d.b.p.a.g.a> r4 = this.f14205b.values().iterator();
        d.b.p.a.g.f r1 = null;
    L4:
        if (r4.hasNext() == false) goto L15;
        d.b.p.a.g.a r2 = r4.next();
        if ((r2 instanceof d.b.p.a.g.b) == true) goto L7;
        if (r2.e() != r5) goto L4;
        r2.d();
        if ((r2 instanceof d.b.p.a.g.f) == false) goto L4;
        r1 = (d.b.p.a.g.f) r2;
        goto L4
    L7:
        d.b.p.a.g.b r3 = (d.b.p.a.g.b) r2;
        r3.j(r5);
        if (r3.h() == null) goto L4;
        r1 = r3.h();
        r3.i(null);
        goto L4
    L15:
        if (r1 == null) goto L30;
        r1.g();
        return;
    }
}
