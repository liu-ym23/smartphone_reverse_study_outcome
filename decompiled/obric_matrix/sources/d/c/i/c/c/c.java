package d.c.i.c.c;

import androidx.core.view.PointerIconCompat;
import d.c.c.d.j;
import d.c.i.e.h;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.b.a.d f15886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h<d.c.b.a.d, d.c.i.l.c> f15887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h.e<d.c.b.a.d> f15888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedHashSet<d.c.b.a.d> f15889d;

    class a implements h.e<d.c.b.a.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f15890a;

        a(c r1) {
            this.f15890a = r1;
        }

        @Override // d.c.i.e.h.e
        public /* bridge */ /* synthetic */ void a(d.c.b.a.d r1, boolean r2) {
            b(r1, r2);
        }

        public void b(d.c.b.a.d r1, boolean r2) {
            this.f15890a.h(r1, r2);
        }
    }

    class b implements j<d.c.b.a.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f15891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f15892b;

        b(c r1, int r2) {
            this.f15892b = r1;
            this.f15891a = r2;
        }

        public boolean a(d.c.b.a.d r3) {
            if (new C0427c(c.a(this.f15892b), this.f15891a).equals(r3) == false) goto L6;
            return true;
        L6:
            return false;
        }

        @Override // d.c.c.d.j
        public /* bridge */ /* synthetic */ boolean apply(d.c.b.a.d r1) {
            return a(r1);
        }
    }

    /* JADX INFO: renamed from: d.c.i.c.c.c$c, reason: collision with other inner class name */
    static class C0427c implements d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d.c.b.a.d f15893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f15894b;

        public C0427c(d.c.b.a.d r1, int r2) {
            this.f15893a = r1;
            this.f15894b = r2;
        }

        @Override // d.c.b.a.d
        public String a() {
            return null;
        }

        @Override // d.c.b.a.d
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0427c) == false) goto L14;
            C0427c r6 = (C0427c) r5;
            if (this.f15894b != r6.f15894b) goto L13;
            if (this.f15893a.equals(r6.f15893a) == false) goto L13;
            return true;
        L13:
            return false;
        L14:
            return false;
        }

        @Override // d.c.b.a.d
        public int hashCode() {
            return (this.f15893a.hashCode() * PointerIconCompat.TYPE_ALL_SCROLL) + this.f15894b;
        }

        @Override // d.c.b.a.d
        public String toString() {
            d.c.c.d.h.b r0 = d.c.c.d.h.d(this);
            r0.b("imageCacheKey", this.f15893a);
            r0.a("frameIndex", this.f15894b);
            return r0.toString();
        }
    }

    public c(d.c.b.a.d r1, h<d.c.b.a.d, d.c.i.l.c> r2) {
        this.f15886a = r1;
        this.f15887b = r2;
        this.f15889d = new LinkedHashSet();
        this.f15888c = new a(this);
    }

    static /* synthetic */ d.c.b.a.d a(c r0) {
        return r0.f15886a;
    }

    private C0427c g(int r2) {
        return new C0427c(this.f15886a, r2);
    }

    private synchronized d.c.b.a.d i() {
        monitor-enter(this);
        d.c.b.a.d r0 = null;
        Iterator<d.c.b.a.d> r1 = this.f15889d.iterator();     // Catch: Throwable -> L9
        if (r1.hasNext() == false) goto L7;
        r0 = r1.next();     // Catch: Throwable -> L9
        r1.remove();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return r0;
    L9:
        th = move-exception;
        throw th;
    }

    public d.c.c.h.a<d.c.i.l.c> b(int r2, d.c.c.h.a<d.c.i.l.c> r3) {
        return this.f15887b.d(g(r2), r3, this.f15888c);
    }

    public void c(int r3) {
        if (r3 != (-1)) goto L5;
        return;
    L5:
        this.f15887b.x(new b(this, r3));
    }

    public boolean d(int r2) {
        return this.f15887b.g(g(r2));
    }

    public d.c.c.h.a<d.c.i.l.c> e(int r2) {
        return this.f15887b.get(g(r2));
    }

    public d.c.c.h.a<d.c.i.l.c> f() {
    L2:
        d.c.b.a.d r0 = i();
        if (r0 == null) goto L4;
        d.c.c.h.a<d.c.i.l.c> r1 = this.f15887b.y(r0);
        if (r1 == null) goto L2;
        return r1;
    L4:
        return null;
    }

    public synchronized void h(d.c.b.a.d r1, boolean r2) {
        monitor-enter(this);
        if (r2 == false) goto L5;
        this.f15889d.add(r1);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L5:
        this.f15889d.remove(r1);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }
}
