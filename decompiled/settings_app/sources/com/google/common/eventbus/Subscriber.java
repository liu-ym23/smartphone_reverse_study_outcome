package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
class Subscriber {
    private EventBus bus;
    private final Executor executor;
    private final Method method;
    final Object target;

    static final class SynchronizedSubscriber extends Subscriber {
        /* synthetic */ SynchronizedSubscriber(EventBus r1, Object r2, Method r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        private SynchronizedSubscriber(EventBus r2, Object r3, Method r4) {
            super(r2, r3, r4, null);
        }

        @Override // com.google.common.eventbus.Subscriber
        void invokeSubscriberMethod(Object r1) throws InvocationTargetException {
            monitor-enter(this);
            super.invokeSubscriberMethod(r1);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    /* synthetic */ Subscriber(EventBus r1, Object r2, Method r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    static /* synthetic */ SubscriberExceptionContext access$100(Subscriber r0, Object r1) {
        return r0.context(r1);
    }

    static /* synthetic */ EventBus access$200(Subscriber r0) {
        return r0.bus;
    }

    static Subscriber create(EventBus r2, Object r3, Method r4) {
        if (isDeclaredThreadSafe(r4) == false) goto L6;
        return new Subscriber(r2, r3, r4);
    L6:
        return new SynchronizedSubscriber(r2, r3, r4, null);
    }

    private Subscriber(EventBus r1, Object r2, Method r3) {
        this.bus = r1;
        this.target = Preconditions.checkNotNull(r2);
        this.method = r3;
        r3.setAccessible(true);
        this.executor = r1.executor();
    }

    final void dispatchEvent(final Object r3) {
        this.executor.execute(new AnonymousClass1(this, r3));
    }

    void invokeSubscriberMethod(Object r5) throws InvocationTargetException {
        this.method.invoke(this.target, new Object[]{Preconditions.checkNotNull(r5)});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L10 IllegalArgumentException -> L13
        return;
    L10:
        e = move-exception;
        String r6 = String.valueOf(r5);
        throw new Error(new StringBuilder(String.valueOf(r6).length() + 28).append("Method became inaccessible: ").append(r6).toString(), e);
    L13:
        e = move-exception;
        String r7 = String.valueOf(r5);
        throw new Error(new StringBuilder(String.valueOf(r7).length() + 33).append("Method rejected target/argument: ").append(r7).toString(), e);
    L4:
        e = move-exception;
        if ((e.getCause() instanceof Error) == true) goto L8;
        throw e;
    L8:
        throw ((Error) e.getCause());
    }

    private SubscriberExceptionContext context(Object r4) {
        return new SubscriberExceptionContext(this.bus, r4, this.target, this.method);
    }

    public final int hashCode() {
        return ((this.method.hashCode() + 31) * 31) + System.identityHashCode(this.target);
    }

    public final boolean equals(@CheckForNull Object r4) {
        if ((r4 instanceof Subscriber) == false) goto L10;
        Subscriber r5 = (Subscriber) r4;
        if (this.target == r5.target) goto L7;
        return false;
    L7:
        if (this.method.equals(r5.method) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private static boolean isDeclaredThreadSafe(Method r1) {
        if (r1.getAnnotation(AllowConcurrentEvents.class) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
