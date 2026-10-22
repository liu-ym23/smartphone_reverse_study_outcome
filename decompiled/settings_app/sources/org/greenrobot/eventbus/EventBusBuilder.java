package org.greenrobot.eventbus;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

/* JADX INFO: loaded from: classes6.dex */
public class EventBusBuilder {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = null;
    boolean eventInheritance;
    ExecutorService executorService;
    boolean ignoreGeneratedIndex;
    boolean logNoSubscriberMessages;
    boolean logSubscriberExceptions;
    Logger logger;
    MainThreadSupport mainThreadSupport;
    boolean sendNoSubscriberEvent;
    boolean sendSubscriberExceptionEvent;
    List<Class<?>> skipMethodVerificationForClasses;
    boolean strictMethodVerification;
    List<SubscriberInfoIndex> subscriberInfoIndexes;
    boolean throwSubscriberException;

    static {
        DEFAULT_EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    }

    EventBusBuilder() {
        this.logSubscriberExceptions = true;
        this.logNoSubscriberMessages = true;
        this.sendSubscriberExceptionEvent = true;
        this.sendNoSubscriberEvent = true;
        this.eventInheritance = true;
        this.executorService = DEFAULT_EXECUTOR_SERVICE;
    }

    public EventBusBuilder logSubscriberExceptions(boolean r1) {
        this.logSubscriberExceptions = r1;
        return this;
    }

    public EventBusBuilder logNoSubscriberMessages(boolean r1) {
        this.logNoSubscriberMessages = r1;
        return this;
    }

    public EventBusBuilder sendSubscriberExceptionEvent(boolean r1) {
        this.sendSubscriberExceptionEvent = r1;
        return this;
    }

    public EventBusBuilder sendNoSubscriberEvent(boolean r1) {
        this.sendNoSubscriberEvent = r1;
        return this;
    }

    public EventBusBuilder throwSubscriberException(boolean r1) {
        this.throwSubscriberException = r1;
        return this;
    }

    public EventBusBuilder eventInheritance(boolean r1) {
        this.eventInheritance = r1;
        return this;
    }

    public EventBusBuilder executorService(ExecutorService r1) {
        this.executorService = r1;
        return this;
    }

    public EventBusBuilder skipMethodVerificationFor(Class<?> r2) {
        if (this.skipMethodVerificationForClasses != null) goto L5;
        this.skipMethodVerificationForClasses = new ArrayList();
    L5:
        this.skipMethodVerificationForClasses.add(r2);
        return this;
    }

    public EventBusBuilder ignoreGeneratedIndex(boolean r1) {
        this.ignoreGeneratedIndex = r1;
        return this;
    }

    public EventBusBuilder strictMethodVerification(boolean r1) {
        this.strictMethodVerification = r1;
        return this;
    }

    public EventBusBuilder addIndex(SubscriberInfoIndex r2) {
        if (this.subscriberInfoIndexes != null) goto L5;
        this.subscriberInfoIndexes = new ArrayList();
    L5:
        this.subscriberInfoIndexes.add(r2);
        return this;
    }

    public EventBusBuilder logger(Logger r1) {
        this.logger = r1;
        return this;
    }

    Logger getLogger() {
        Logger r0 = this.logger;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (Logger.AndroidLogger.isAndroidLogAvailable() == false) goto L11;
        if (getAndroidMainLooperOrNull() == null) goto L11;
        return new Logger.AndroidLogger("EventBus");
    L11:
        return new Logger.SystemOutLogger();
    }

    MainThreadSupport getMainThreadSupport() {
        MainThreadSupport r0 = this.mainThreadSupport;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (Logger.AndroidLogger.isAndroidLogAvailable() == false) goto L12;
        Object r2 = getAndroidMainLooperOrNull();
        if (r2 != null) goto L11;
        return null;
    L11:
        return new MainThreadSupport.AndroidHandlerMainThreadSupport((Looper) r2);
    L12:
        return null;
    }

    Object getAndroidMainLooperOrNull() {
        return Looper.getMainLooper();
    L4:
        return null;
    }

    public EventBus installDefaultEventBus() {
        monitor-enter(EventBus.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (EventBus.defaultInstance != null) goto L10;
        EventBus.defaultInstance = build();     // Catch: Throwable -> L11
        EventBus r2 = EventBus.defaultInstance;     // Catch: Throwable -> L11
        monitor-exit(EventBus.class);     // Catch: Throwable -> L11
        return r2;
    L10:
        throw new EventBusException("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");     // Catch: Throwable -> L11
    }

    public EventBus build() {
        return new EventBus(this);
    }
}
