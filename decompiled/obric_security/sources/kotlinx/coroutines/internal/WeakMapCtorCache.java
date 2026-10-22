package kotlinx.coroutines.internal;

import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ExceptionsConstructor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\tj\u0002`\n2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0005\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\tj\u0002`\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/internal/WeakMapCtorCache;", "Lkotlinx/coroutines/internal/CtorCache;", "()V", "cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "get", "key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class WeakMapCtorCache extends CtorCache {
    public static final WeakMapCtorCache INSTANCE = null;
    private static final ReentrantReadWriteLock cacheLock = null;
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> exceptionCtors = null;

    private WeakMapCtorCache() {
    }

    static {
        INSTANCE = new WeakMapCtorCache();
        cacheLock = new ReentrantReadWriteLock();
        exceptionCtors = new WeakHashMap();
    }

    @Override // kotlinx.coroutines.internal.CtorCache
    public Function1<Throwable, Throwable> get(Class<? extends Throwable> r6) {
        ReentrantReadWriteLock r5 = cacheLock;
        ReentrantReadWriteLock.ReadLock r0 = r5.readLock();
        r0.lock();
        Function1<Throwable, Throwable> r1 = exceptionCtors.get(r6);     // Catch: Throwable -> L31
        r0.unlock();
        if (r1 == null) goto L7;
        return r1;
    L7:
        ReentrantReadWriteLock.ReadLock r2 = r5.readLock();
        int r3 = 0;
        if (r5.getWriteHoldCount() != 0) goto L10;
        int r4 = r5.getReadHoldCount();
    L11:
        int r7 = 0;
    L12:
        if (r7 >= r4) goto L14;
        r2.unlock();
        r7 = r7 + 1;
        goto L12
    L14:
        ReentrantReadWriteLock.WriteLock r8 = r5.writeLock();
        r8.lock();
        WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> r9 = exceptionCtors;     // Catch: Throwable -> L26
        Function1<Throwable, Throwable> r10 = r9.get(r6);     // Catch: Throwable -> L26
        if (r10 == null) goto L21;
    L17:
        if (r3 >= r4) goto L19;
        r2.lock();
        r3 = r3 + 1;
        goto L17
    L19:
        r8.unlock();
        return r10;
    L21:
        Function1<Throwable, Throwable> r11 = ExceptionsConstructorKt.access$createConstructor(r6);     // Catch: Throwable -> L26
        r9.put(r6, r11);     // Catch: Throwable -> L26
    L22:
        if (r3 >= r4) goto L24;
        r2.lock();
        r3 = r3 + 1;
        goto L22
    L24:
        r8.unlock();
        return r11;
    L26:
        th = move-exception;
    L27:
        if (r3 >= r4) goto L29;
        r2.lock();
        r3 = r3 + 1;
        goto L27
    L29:
        r8.unlock();
        throw th;
    L10:
        r4 = 0;
    L31:
        th = move-exception;
        r0.unlock();
        throw th;
    }
}
