package d.c.f.c;

import android.graphics.drawable.Animatable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f<INFO> extends c<INFO> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d<? super INFO>> f15599b;

    public f() {
        this.f15599b = new ArrayList(2);
    }

    private synchronized void m(String r2, Throwable r3) {
        monitor-enter(this);
        Log.e("FdingControllerListener", r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public void a(String r5, INFO r6) {
        int r0 = this.f15599b.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        d<? super INFO> r2 = this.f15599b.get(r1);     // Catch: Exception -> L8
        if (r2 == null) goto L10;
        r2.a(r5, r6);     // Catch: Exception -> L8
    L10:
        r1 = r1 + 1;
    L8:
        e = move-exception;
        m("InternalListener exception in onIntermediateImageSet", e);
        goto L10
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public synchronized void b(String r5, INFO r6, Animatable r7) {
        monitor-enter(this);
        int r0 = this.f15599b.size();     // Catch: Throwable -> L15
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        d<? super INFO> r2 = this.f15599b.get(r1);     // Catch: Exception -> L10 Throwable -> L15
        if (r2 == null) goto L12;
        r2.b(r5, r6, r7);     // Catch: Exception -> L10 Throwable -> L15
    L12:
        r1 = r1 + 1;
    L10:
        e = move-exception;
        m("InternalListener exception in onFinalImageSet", e);     // Catch: Throwable -> L15
        goto L12
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public synchronized void c(String r5, Throwable r6) {
        monitor-enter(this);
        int r0 = this.f15599b.size();     // Catch: Throwable -> L15
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        d<? super INFO> r2 = this.f15599b.get(r1);     // Catch: Exception -> L10 Throwable -> L15
        if (r2 == null) goto L12;
        r2.c(r5, r6);     // Catch: Exception -> L10 Throwable -> L15
    L12:
        r1 = r1 + 1;
    L10:
        e = move-exception;
        m("InternalListener exception in onFailure", e);     // Catch: Throwable -> L15
        goto L12
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public synchronized void d(String r5) {
        monitor-enter(this);
        int r0 = this.f15599b.size();     // Catch: Throwable -> L15
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        d<? super INFO> r2 = this.f15599b.get(r1);     // Catch: Exception -> L10 Throwable -> L15
        if (r2 == null) goto L12;
        r2.d(r5);     // Catch: Exception -> L10 Throwable -> L15
    L12:
        r1 = r1 + 1;
    L10:
        e = move-exception;
        m("InternalListener exception in onRelease", e);     // Catch: Throwable -> L15
        goto L12
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public synchronized void e(String r5, Object r6) {
        monitor-enter(this);
        int r0 = this.f15599b.size();     // Catch: Throwable -> L15
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        d<? super INFO> r2 = this.f15599b.get(r1);     // Catch: Exception -> L10 Throwable -> L15
        if (r2 == null) goto L12;
        r2.e(r5, r6);     // Catch: Exception -> L10 Throwable -> L15
    L12:
        r1 = r1 + 1;
    L10:
        e = move-exception;
        m("InternalListener exception in onSubmit", e);     // Catch: Throwable -> L15
        goto L12
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public void f(String r5, Throwable r6) {
        int r0 = this.f15599b.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        d<? super INFO> r2 = this.f15599b.get(r1);     // Catch: Exception -> L8
        if (r2 == null) goto L10;
        r2.f(r5, r6);     // Catch: Exception -> L8
    L10:
        r1 = r1 + 1;
    L8:
        e = move-exception;
        m("InternalListener exception in onIntermediateImageFailed", e);
        goto L10
    }

    @Override // d.c.f.c.c
    public void h(d.c.i.q.b r5, long r6) {
        int r0 = this.f15599b.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        d<? super INFO> r2 = this.f15599b.get(r1);     // Catch: Exception -> L10
        if (r2 == null) goto L12;
        if ((r2 instanceof c) == false) goto L12;
        ((c) r2).h(r5, r6);     // Catch: Exception -> L10
    L12:
        r1 = r1 + 1;
    L10:
        e = move-exception;
        m("InternalListener exception in onFinalImageSet", e);
        goto L12
    }

    @Override // d.c.f.c.c
    public void i(String r11, INFO r12, Animatable r13, d.c.i.q.b r14, Map r15) {
        int r0 = this.f15599b.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        d<? super INFO> r2 = this.f15599b.get(r1);     // Catch: Exception -> L11
        if (r2 == null) goto L13;
        if ((r2 instanceof c) == false) goto L9;
        ((c) r2).i(r11, r12, r13, r14, r15);     // Catch: Exception -> L11
        goto L13
    L9:
        r2.b(r11, r12, r13);     // Catch: Exception -> L11
    L13:
        r1 = r1 + 1;
    L11:
        e = move-exception;
        m("InternalListener exception in onFinalImageSet", e);
        goto L13
    }

    @Override // d.c.f.c.c
    public void j(String r5, INFO r6, Animatable r7) {
        int r0 = this.f15599b.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        d<? super INFO> r2 = this.f15599b.get(r1);     // Catch: Exception -> L8
        if ((r2 instanceof c) == false) goto L10;
        ((c) r2).j(r5, r6, r7);     // Catch: Exception -> L8
    L10:
        r1 = r1 + 1;
    L8:
        e = move-exception;
        m("InternalListener exception in onIntermediateImageSet", e);
        goto L10
    }

    public synchronized void k(d<? super INFO> r2) {
        monitor-enter(this);
        this.f15599b.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void l() {
        monitor-enter(this);
        this.f15599b.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void n(d<? super INFO> r3) {
        monitor-enter(this);
        int r4 = this.f15599b.indexOf(r3);     // Catch: Throwable -> L8
        if (r4 == (-1)) goto L6;
        this.f15599b.set(r4, null);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
