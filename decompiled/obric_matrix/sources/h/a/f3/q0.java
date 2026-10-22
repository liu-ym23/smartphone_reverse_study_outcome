package h.a.f3;

import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\tj\u0002`\n2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0005\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\tj\u0002`\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/internal/WeakMapCtorCache;", "Lkotlinx/coroutines/internal/CtorCache;", "()V", "cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "get", "key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class q0 extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q0 f17407a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ReentrantReadWriteLock f17408b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final WeakHashMap<Class<? extends Throwable>, kotlin.n0.c.l<Throwable, Throwable>> f17409c = null;

    static {
        f17407a = new q0();
        f17408b = new ReentrantReadWriteLock();
        f17409c = new WeakHashMap();
    }

    private q0() {
    }

    @Override // h.a.f3.h
    public kotlin.n0.c.l<Throwable, Throwable> a(Class<? extends Throwable> r6) {
        ReentrantReadWriteLock r5 = f17408b;
        ReentrantReadWriteLock.ReadLock r0 = r5.readLock();
        r0.lock();
        kotlin.n0.c.l<Throwable, Throwable> r1 = f17409c.get(r6);     // Catch: Throwable -> L31
        r0.unlock();
        if (r1 != null) goto L30;
        ReentrantReadWriteLock.ReadLock r2 = r5.readLock();
        int r3 = 0;
        if (r5.getWriteHoldCount() != 0) goto L9;
        int r4 = r5.getReadHoldCount();
    L10:
        int r7 = 0;
    L11:
        if (r7 >= r4) goto L13;
        r7 = r7 + 1;
        r2.unlock();
        goto L11
    L13:
        ReentrantReadWriteLock.WriteLock r8 = r5.writeLock();
        r8.lock();
        WeakHashMap<Class<? extends Throwable>, kotlin.n0.c.l<Throwable, Throwable>> r9 = f17409c;     // Catch: Throwable -> L25
        kotlin.n0.c.l<Throwable, Throwable> r10 = r9.get(r6);     // Catch: Throwable -> L25
        if (r10 != null) goto L21;
        kotlin.n0.c.l<Throwable, Throwable> r11 = k.a(r6);     // Catch: Throwable -> L25
        r9.put(r6, r11);     // Catch: Throwable -> L25
    L17:
        if (r3 >= r4) goto L19;
        r3 = r3 + 1;
        r2.lock();
        goto L17
    L19:
        r8.unlock();
        return r11;
    L21:
        if (r3 >= r4) goto L23;
        r3 = r3 + 1;
        r2.lock();
        goto L21
    L23:
        r8.unlock();
        return r10;
    L25:
        th = move-exception;
    L26:
        if (r3 >= r4) goto L28;
        r3 = r3 + 1;
        r2.lock();
        goto L26
    L28:
        r8.unlock();
        throw th;
    L9:
        r4 = 0;
        goto L10
    L30:
        return r1;
    L31:
        th = move-exception;
        r0.unlock();
        throw th;
    }
}
