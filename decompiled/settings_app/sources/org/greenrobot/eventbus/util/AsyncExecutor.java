package org.greenrobot.eventbus.util;

import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes6.dex */
public class AsyncExecutor {
    private final EventBus eventBus;
    private final Constructor<?> failureEventConstructor;
    private final Object scope;
    private final Executor threadPool;

    public static class Builder {
        private EventBus eventBus;
        private Class<?> failureEventType;
        private Executor threadPool;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
        }

        public Builder threadPool(Executor r1) {
            this.threadPool = r1;
            return this;
        }

        public Builder failureEventType(Class<?> r1) {
            this.failureEventType = r1;
            return this;
        }

        public Builder eventBus(EventBus r1) {
            this.eventBus = r1;
            return this;
        }

        public AsyncExecutor build() {
            return buildForScope(null);
        }

        public AsyncExecutor buildForScope(Object r8) {
            if (this.eventBus != null) goto L6;
            this.eventBus = EventBus.getDefault();
        L6:
            if (this.threadPool != null) goto L9;
            this.threadPool = Executors.newCachedThreadPool();
        L9:
            if (this.failureEventType != null) goto L12;
            this.failureEventType = ThrowableFailureEvent.class;
        L12:
            return new AsyncExecutor(this.threadPool, this.eventBus, this.failureEventType, r8, null);
        }
    }

    public interface RunnableEx {
        void run() throws Exception;
    }

    /* synthetic */ AsyncExecutor(Executor r1, EventBus r2, Class r3, Object r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    static /* synthetic */ Constructor access$200(AsyncExecutor r0) {
        return r0.failureEventConstructor;
    }

    static /* synthetic */ EventBus access$300(AsyncExecutor r0) {
        return r0.eventBus;
    }

    static /* synthetic */ Object access$400(AsyncExecutor r0) {
        return r0.scope;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static AsyncExecutor create() {
        return new Builder(null).build();
    }

    private AsyncExecutor(Executor r1, EventBus r2, Class<?> r3, Object r4) {
        this.threadPool = r1;
        this.eventBus = r2;
        this.scope = r4;
        this.failureEventConstructor = r3.getConstructor(new Class[]{Throwable.class});     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e);
    }

    public void execute(final RunnableEx r3) {
        this.threadPool.execute(new AnonymousClass1(this, r3));
    }
}
