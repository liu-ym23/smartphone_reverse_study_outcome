package d.c.h;

import d.c.c.d.i;
import d.c.c.d.n;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static e f15833d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<d.a> f15835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.a f15836c;

    private e() {
        this.f15836c = new b();
        g();
    }

    public static d b(InputStream r1) {
        return d().a(r1);
    }

    public static d c(InputStream r0) {
        return b(r0);
    L4:
        e = move-exception;
        n.a(e);
        throw null;
    }

    public static synchronized e d() {
        monitor-enter(e.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f15833d != null) goto L7;
        f15833d = new e();     // Catch: Throwable -> L10
    L7:
        e r1 = f15833d;     // Catch: Throwable -> L10
        monitor-exit(e.class);
        return r1;
    }

    private static int f(int r2, InputStream r3, byte[] r4) {
        i.g(r3);
        i.g(r4);
        if (r4.length < r2) goto L5;
        boolean r0 = true;
    L6:
        i.b(r0);
        if (r3.markSupported() == false) goto L15;
        r3.mark(r2);     // Catch: Throwable -> L11
        int r5 = d.c.c.d.a.b(r3, r4, 0, r2);     // Catch: Throwable -> L11
        r3.reset();
        return r5;
    L11:
        th = move-exception;
        r3.reset();
        throw th;
    L15:
        return d.c.c.d.a.b(r3, r4, 0, r2);
    L5:
        r0 = false;
        goto L6
    }

    private void g() {
        this.f15834a = this.f15836c.a();
        List<d.a> r0 = this.f15835b;
        if (r0 == null) goto L8;
        Iterator<d.a> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        d.a r2 = r1.next();
        this.f15834a = Math.max(this.f15834a, r2.a());
        goto L6
    L10:
        return;
    }

    public d a(InputStream r5) {
        i.g(r5);
        int r0 = this.f15834a;
        byte[] r1 = new byte[r0];
        int r6 = f(r0, r5, r1);
        List<d.a> r2 = this.f15835b;
        if (r2 == null) goto L12;
        Iterator<d.a> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L12;
        d r4 = r3.next().b(r1, r6);
        if (r4 == null) goto L6;
        if (r4 == d.f15831b) goto L6;
        return r4;
    L12:
        d r7 = this.f15836c.b(r1, r6);
        if (r7 == null) goto L18;
        if (r7 == d.f15831b) goto L18;
        return r7;
    L18:
        return d.f15831b;
    }

    public int e() {
        return this.f15834a;
    }
}
