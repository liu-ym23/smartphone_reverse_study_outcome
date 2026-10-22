package d.c.i.p;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Deque<Runnable> f16488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f16489c;

    class a extends ArrayDeque<Runnable> {
        a(z0 r1) {
        }

        public boolean a(Runnable r2) {
            if ((r2 instanceof u0) == false) goto L6;
            ((u0) r2).l();
        L6:
            return super.add(r2);
        }

        @Override // java.util.ArrayDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
        public /* bridge */ /* synthetic */ boolean add(Object r1) {
            return a((Runnable) r1);
        }

        public Runnable c() {
            Runnable r1 = (Runnable) super.pop();
            if ((r1 instanceof u0) == false) goto L5;
            ((u0) r1).k();
        L5:
            return r1;
        }

        @Override // java.util.ArrayDeque, java.util.Deque
        public /* bridge */ /* synthetic */ Object pop() {
            return c();
        }
    }

    public z0(Executor r2) {
        this.f16487a = false;
        d.c.c.d.i.g(r2);
        this.f16489c = r2;
        this.f16488b = new a(this);
    }

    public synchronized void a(Runnable r2) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f16487a == false) goto L6;
        this.f16488b.add(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        this.f16489c.execute(r2);     // Catch: Throwable -> L9
        goto L7
    }

    public synchronized void b(Runnable r2) {
        monitor-enter(this);
        this.f16488b.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
