package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.InternalCoroutinesApi;

/* JADX INFO: loaded from: classes2.dex */
@InternalCoroutinesApi
@Metadata
public abstract class AtomicOp<T> extends OpDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f408a = null;
    private volatile Object _consensus;

    static {
        f408a = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    }

    public AtomicOp() {
        this._consensus = AtomicKt.f407a;
    }

    @Override // kotlinx.coroutines.internal.OpDescriptor
    public final AtomicOp a() {
        return this;
    }

    @Override // kotlinx.coroutines.internal.OpDescriptor
    public final Object c(Object r3) {
        Object r0 = this._consensus;
        if (r0 != AtomicKt.f407a) goto L5;
        r0 = e(i(r3));
    L5:
        d(r3, r0);
        return r0;
    }

    public abstract void d(Object r1, Object r2);

    public final Object e(Object r3) {
        boolean r0 = DebugKt.f370a;
        Object r1 = this._consensus;
        Symbol r2 = AtomicKt.f407a;
        if (r1 == r2) goto L6;
        return r1;
    L6:
        if (f408a.compareAndSet(this, r2, r3) == false) goto L9;
        return r3;
    L9:
        return this._consensus;
    }

    public final Object f() {
        return this._consensus;
    }

    public long g() {
        return 0;
    }

    public final boolean h() {
        if (this._consensus == AtomicKt.f407a) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract Object i(Object r1);
}
