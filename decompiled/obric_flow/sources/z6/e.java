package z6;

import com.bytedance.monitor.util.thread.AsyncTaskType;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f23410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f23411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f23412c;
    public final Object d;

    static {
    }

    public e(String r5) {
        this.f23411b = new ConcurrentLinkedQueue();
        this.f23412c = new ConcurrentLinkedQueue();
        this.d = new Object();
        new ia.d(1, r5, this);
    }

    public static mg.c f(String r5, Runnable r10) {
        return new mg.c("AsyncEventManager-".concat(r5), AsyncTaskType.LIGHT_WEIGHT, r10);
    }

    public void a(c r5) {
        if (r5 == null) goto L21;
        CopyOnWriteArraySet r10 = (CopyOnWriteArraySet) this.d;
        if (r10.contains(r5) == true) goto L22;
        r10.add(r5);     // Catch: Throwable -> L16
        w5.b r11 = (w5.b) this.f23412c;
        mg.b r12 = (mg.b) this.f23411b;     // Catch: Throwable -> L16
        if (r12 != null) goto L17;
    L11:
        mg.b r13 = (mg.b) this.f23411b;     // Catch: Throwable -> L16
        if (r13 == null) goto L23;
        r13.g(r11, 30000);     // Catch: Throwable -> L16
        return;
    L23:
        return;
    L17:
        r12.a(r11).d(r11);     // Catch: Throwable -> L15
        goto L11
    L22:
        return;
    L24:
        return;
    }

    public void b(Runnable r5) {
        mg.b r10 = (mg.b) this.f23411b;
        if (r10 == null) goto L8;
        if (r5 == null) goto L9;
        r10.f(f("post", r5));
        return;
    L9:
        return;
    }

    public boolean c() {
        mg.b r5 = (mg.b) this.f23411b;
        if (r5 == null) goto L11;
        long r10 = Thread.currentThread().getId();
        AsyncTaskType r11 = AsyncTaskType.LIGHT_WEIGHT;
        Long r12 = (Long) r5.d.get(r11);
        if (r12 == null) goto L7;
        long r13 = r12.longValue();
    L9:
        if (r10 != r13) goto L11;
        return true;
    L7:
        r13 = -1;
    L11:
        return false;
    }

    public void d(Runnable r5) {
        mg.b r10 = (mg.b) this.f23411b;
        if (r10 == null) goto L7;
        if (r5 == null) goto L8;
        r10.f(f("post", r5));
        return;
    L8:
        return;
    }

    public void e(Runnable r5) {
        if (((ExecutorService) this.f23410a) != null) goto L17;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (((ExecutorService) this.f23410a) != null) goto L13;
        mg.b r10 = (mg.b) this.f23411b;     // Catch: Throwable -> L10
        if (r10 == null) goto L12;
        this.f23410a = r10.b();     // Catch: Throwable -> L10
        goto L13
    L12:
        this.f23410a = Executors.newFixedThreadPool(1, new com.bumptech.glide.load.engine.a(5));     // Catch: Throwable -> L10
    L13:
        monitor-exit(this);     // Catch: Throwable -> L10
    L17:
        ((ExecutorService) this.f23410a).submit(r5);
    }

    public e() {
        this.f23412c = new w5.b(this, 2);
        this.d = new CopyOnWriteArraySet();
        new CopyOnWriteArraySet();
        this.f23411b = mg.a.f20082a;
    }
}
