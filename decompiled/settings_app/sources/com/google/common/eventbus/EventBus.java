package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public class EventBus {
    private static final Logger logger = null;
    private final Dispatcher dispatcher;
    private final SubscriberExceptionHandler exceptionHandler;
    private final Executor executor;
    private final String identifier;
    private final SubscriberRegistry subscribers;

    static final class LoggingHandler implements SubscriberExceptionHandler {
        static final LoggingHandler INSTANCE = null;

        LoggingHandler() {
        }

        static {
            INSTANCE = new LoggingHandler();
        }

        @Override // com.google.common.eventbus.SubscriberExceptionHandler
        public void handleException(Throwable r2, SubscriberExceptionContext r3) {
            Logger r1 = logger(r3);
            if (r1.isLoggable(Level.SEVERE) == false) goto L6;
            r1.log(Level.SEVERE, message(r3), r2);
            return;
        }

        private static Logger logger(SubscriberExceptionContext r3) {
            String r0 = EventBus.class.getName();
            String r4 = r3.getEventBus().identifier();
            return Logger.getLogger(new StringBuilder((String.valueOf(r0).length() + 1) + String.valueOf(r4).length()).append(r0).append(".").append(r4).toString());
        }

        private static String message(SubscriberExceptionContext r5) {
            Method r0 = r5.getSubscriberMethod();
            String r1 = r0.getName();
            String r2 = r0.getParameterTypes()[0].getName();
            String r3 = String.valueOf(r5.getSubscriber());
            String r6 = String.valueOf(r5.getEvent());
            return new StringBuilder((((String.valueOf(r1).length() + 80) + String.valueOf(r2).length()) + String.valueOf(r3).length()) + String.valueOf(r6).length()).append("Exception thrown by subscriber method ").append(r1).append('(').append(r2).append(") on subscriber ").append(r3).append(" when dispatching event: ").append(r6).toString();
        }
    }

    static {
        logger = Logger.getLogger(EventBus.class.getName());
    }

    public EventBus() {
        this("default");
    }

    public EventBus(String r4) {
        this(r4, MoreExecutors.directExecutor(), Dispatcher.perThreadDispatchQueue(), LoggingHandler.INSTANCE);
    }

    public EventBus(SubscriberExceptionHandler r4) {
        this("default", MoreExecutors.directExecutor(), Dispatcher.perThreadDispatchQueue(), r4);
    }

    EventBus(String r2, Executor r3, Dispatcher r4, SubscriberExceptionHandler r5) {
        this.subscribers = new SubscriberRegistry(this);
        this.identifier = (String) Preconditions.checkNotNull(r2);
        this.executor = (Executor) Preconditions.checkNotNull(r3);
        this.dispatcher = (Dispatcher) Preconditions.checkNotNull(r4);
        this.exceptionHandler = (SubscriberExceptionHandler) Preconditions.checkNotNull(r5);
    }

    public final String identifier() {
        return this.identifier;
    }

    final Executor executor() {
        return this.executor;
    }

    void handleSubscriberException(Throwable r5, SubscriberExceptionContext r6) {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        this.exceptionHandler.handleException(r5, r6);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        logger.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", new Object[]{th, r5}), th);
    }

    public void register(Object r1) {
        this.subscribers.register(r1);
    }

    public void unregister(Object r1) {
        this.subscribers.unregister(r1);
    }

    public void post(Object r3) {
        Iterator<Subscriber> r0 = this.subscribers.getSubscribers(r3);
        if (r0.hasNext() == false) goto L6;
        this.dispatcher.dispatch(r3, r0);
        return;
    L6:
        if ((r3 instanceof DeadEvent) == true) goto L10;
        post(new DeadEvent(this, r3));
        return;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(this.identifier).toString();
    }
}
