package d.b.b.o.l;

import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentLinkedQueue<T> f13055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC0345a<T> f13056c;

    /* JADX INFO: renamed from: d.b.b.o.l.a$a, reason: collision with other inner class name */
    public interface InterfaceC0345a<T> {
        void a(T r1);
    }

    public a(int r2) {
        this.f13055b = new ConcurrentLinkedQueue();
        this.f13054a = r2;
    }

    public boolean a() {
        return this.f13055b.isEmpty();
    }

    public T b() {
        return this.f13055b.poll();
    }

    public void c(T r2) {
        this.f13055b.add(r2);
        if (this.f13055b.size() <= this.f13054a) goto L8;
        T r3 = this.f13055b.poll();
        InterfaceC0345a<T> r1 = this.f13056c;
        if (r1 == null) goto L9;
        r1.a(r3);
        return;
    L9:
        return;
    }

    public void d(InterfaceC0345a<T> r1) {
        this.f13056c = r1;
    }
}
