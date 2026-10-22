package d.b.u;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Deque<Runnable> f15052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f15053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15054c;

    public g() {
        this(200);
    }

    public g(int r3) {
        this.f15052a = new LinkedList();
        this.f15053b = new AtomicBoolean(false);
        this.f15054c = r3;
    }

    public boolean a() {
        if (this.f15052a.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void b() {
        monitor-enter(this);
        this.f15053b.set(true);     // Catch: Throwable -> L9
    L5:
        if (this.f15052a.size() <= 0) goto L7;
        this.f15052a.pop().run();     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void c(Runnable r3) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f15053b.get() == false) goto L7;
        r3.run();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L7:
        if (this.f15052a.size() >= this.f15054c) goto L9;
        this.f15052a.add(r3);     // Catch: Throwable -> L12
        goto L10
    L9:
        d.b.u.x.b.b("throw task " + r3 + ", because there are too many tasks in queue");     // Catch: Throwable -> L12
        goto L10
    }
}
