package kotlinx.coroutines.debug.internal;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DebugProbesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentWeakMap f393a = null;
    public static final Function1 b = null;
    public static final ConcurrentWeakMap c = null;

    @Metadata
    public static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {
        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public final CoroutineStackFrame e() {
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        public final CoroutineContext getContext() {
            throw null;
        }

        @Override // kotlin.coroutines.Continuation
        public final void k(Object r1) {
            ConcurrentWeakMap r2 = DebugProbesImpl.f393a;
            DebugProbesImpl.f393a.remove(this);
            throw null;
        }

        public final String toString() {
            throw null;
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public final StackTraceElement w() {
            return null;
        }
    }

    static {
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        f393a = new ConcurrentWeakMap(false);
        new DebugProbesImplSequenceNumberRefVolatile().sequenceNumber = 0;
        new ReentrantReadWriteLock();
        Object r2 = null;
        Object r1 = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(null);     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        TypeIntrinsics.b(1, r1);     // Catch: Throwable -> L6
        Object r3 = (Function1) r1;     // Catch: Throwable -> L6
    L12:
        if ((r3 instanceof Result.Failure) == true) goto L15;
        r2 = r3;
    L15:
        b = (Function1) r2;
        c = new ConcurrentWeakMap(true);
        AtomicLongFieldUpdater.newUpdater(DebugProbesImplSequenceNumberRefVolatile.class, "sequenceNumber");
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type (kotlin.Boolean) -> kotlin.Unit");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r3 = ResultKt.a(th);
        goto L12
    }
}
