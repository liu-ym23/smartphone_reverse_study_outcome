package kotlin.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@PublishedApi
public final class SafeContinuation<T> implements Continuation<T>, CoroutineStackFrame {
    public static final AtomicReferenceFieldUpdater b = null;

    @Nullable
    private volatile Object result;

    @Metadata
    public static final class Companion {
    }

    static {
        b = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame e() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        throw null;
    }

    @Override // kotlin.coroutines.Continuation
    public final void k(Object r4) {
    L2:
        Object r0 = this.result;
        CoroutineSingletons r1 = CoroutineSingletons.c;
        if (r0 == r1) goto L5;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        if (r0 != r2) goto L15;
        if (b.compareAndSet(this, r2, CoroutineSingletons.e) == false) goto L2;
        throw null;
    L15:
        throw new IllegalStateException("Already resumed");
    L5:
        if (b.compareAndSet(this, r1, r4) == false) goto L2;
    }

    public final String toString() {
        return "SafeContinuation for null";
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement w() {
        return null;
    }
}
