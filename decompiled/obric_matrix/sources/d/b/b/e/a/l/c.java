package d.b.b.e.a.l;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile c f12717f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<d> f12718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f12719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12722e;

    class a extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ c f12723i;

        a(c r1, long r2, long r4) {
            this.f12723i = r1;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            long r1 = System.currentTimeMillis();
            int r3 = c.a(this.f12723i);
            long r4 = (((long) c.b(this.f12723i)) * 1024) * 1024;
            HashMap r8 = new HashMap();
            if (d.b.b.o.a.c() == false) goto L5;
            d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "start weedOut:" + (r1 - (((long) r3) * 86400000)));
        L5:
            Iterator r9 = c.c(this.f12723i).iterator();
            long r14 = 0;
        L7:
            if (r9.hasNext() == false) goto L16;
            d r6 = (d) r9.next();
            d.b.b.e.a.l.a r7 = new d.b.b.e.a.l.a();
            r8.put(r6.getName(), r7);
            r7.g(r6.getName());
            r7.f(r6.a());
            if (d.b.b.o.a.c() == false) goto L12;
            d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "weedOut:name:" + r7.c() + " beforeSize:" + r7.b());
        L12:
            r6.b(r1 - (((long) r3) * 86400000));
            long r10 = r6.a();
            r7.e(r10);
            if (d.b.b.o.a.c() == false) goto L15;
            d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "weedOut:name:" + r7.c() + " afterSize:" + r7.a());
        L15:
            r14 = r14 + r10;
            r9 = r9;
            r8 = r8;
            goto L7
        L16:
            HashMap r19 = r8;
            int r5 = r3 - 1;
        L18:
            if (r14 <= r4) goto L28;
            if (r5 <= 0) goto L28;
            Iterator r11 = c.c(this.f12723i).iterator();
            r14 = 0;
        L22:
            if (r11.hasNext() == false) goto L27;
            d r12 = (d) r11.next();
            r12.b(r1 - (((long) r5) * 86400000));
            long r13 = r12.a();
            HashMap r15 = r19;
            d.b.b.e.a.l.a r16 = (d.b.b.e.a.l.a) r15.get(r12.getName());
            if (r16 == null) goto L26;
            r16.e(r13);
        L26:
            r14 = r14 + r12.a();
            r19 = r15;
            goto L22
        L27:
            r5 = r5 - 1;
        L28:
            HashMap r17 = r19;
            if (c.d(this.f12723i) <= 0) goto L45;
            long r2 = (((long) c.d(this.f12723i)) * 1024) * 1024;
            if (r14 <= r2) goto L45;
            Iterator r18 = c.c(this.f12723i).iterator();
        L34:
            if (r18.hasNext() == false) goto L45;
            d r20 = (d) r18.next();
            long r21 = r20.a();
            if (r21 <= 0) goto L34;
            r20.c(r2);
            long r110 = r20.a();
            d.b.b.e.a.l.a r22 = (d.b.b.e.a.l.a) r17.get(r20.getName());
            if (r22 == null) goto L34;
            if (d.b.b.o.a.c() == false) goto L42;
            d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "weedOut:name:" + r22.c() + " afterSize:" + r110 + " maxBytesToday clean: " + (r21 - r110));
        L42:
            r22.h(true);
            r22.e(r110);
        L45:
            if (c.e(this.f12723i) == null) goto L63;
            c.e(this.f12723i).a(new ArrayList(r17.values()));
            return;
        }
    }

    static {
        f12717f = new c();
    }

    public c() {
        this.f12718a = new HashSet();
        this.f12720c = 80;
        this.f12721d = 5;
        this.f12722e = -1;
    }

    static /* synthetic */ int a(c r0) {
        return r0.f12721d;
    }

    static /* synthetic */ int b(c r0) {
        return r0.f12720c;
    }

    static /* synthetic */ Set c(c r0) {
        return r0.f12718a;
    }

    static /* synthetic */ int d(c r0) {
        return r0.f12722e;
    }

    static /* synthetic */ b e(c r0) {
        return r0.f12719b;
    }

    public static c g() {
        return f12717f;
    }

    public synchronized void f(d r2) {
        monitor-enter(this);
        if (r2 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.f12718a.add(r2);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void h() {
        if (d.b.b.i.c.a.A() == true) goto L5;
        return;
    L5:
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13066f).c(new a(this, 0, 14400000));
    }

    public synchronized void i(b r1) {
        monitor-enter(this);
        this.f12719b = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void j(int r2, int r3, int r4) {
        if (r2 <= 0) goto L12;
        if (r3 <= 0) goto L14;
        this.f12720c = r2;
        this.f12721d = r3;
        int r0 = -1;
        if (r4 == (-1)) goto L8;
        r0 = Math.max(r4, 80);
    L8:
        this.f12722e = r0;
        if (d.b.b.o.a.c() == false) goto L13;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "weed out config:maxSizeMB:" + r2 + " keepDays:" + r3);
        return;
    L13:
        return;
    L14:
        return;
    }
}
