package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes6.dex */
public class EventBus {
    private static final EventBusBuilder DEFAULT_BUILDER = null;
    public static String TAG = "EventBus";
    static volatile EventBus defaultInstance;
    private static final Map<Class<?>, List<Class<?>>> eventTypesCache = null;
    private final AsyncPoster asyncPoster;
    private final BackgroundPoster backgroundPoster;
    private final ThreadLocal<PostingThreadState> currentPostingThreadState;
    private final boolean eventInheritance;
    private final ExecutorService executorService;
    private final int indexCount;
    private final boolean logNoSubscriberMessages;
    private final boolean logSubscriberExceptions;
    private final Logger logger;
    private final Poster mainThreadPoster;
    private final MainThreadSupport mainThreadSupport;
    private final boolean sendNoSubscriberEvent;
    private final boolean sendSubscriberExceptionEvent;
    private final Map<Class<?>, Object> stickyEvents;
    private final SubscriberMethodFinder subscriberMethodFinder;
    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;
    private final boolean throwSubscriberException;
    private final Map<Object, List<Class<?>>> typesBySubscriber;

    /* JADX INFO: renamed from: org.greenrobot.eventbus.EventBus$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$greenrobot$eventbus$ThreadMode = null;

        static {
            int[] r0 = new int[ThreadMode.values().length];
            $SwitchMap$org$greenrobot$eventbus$ThreadMode = r0;
            r0[ThreadMode.POSTING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.MAIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.MAIN_ORDERED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.BACKGROUND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.ASYNC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    interface PostCallback {
        void onPostCompleted(List<SubscriberExceptionEvent> r1);
    }

    static final class PostingThreadState {
        boolean canceled;
        Object event;
        final List<Object> eventQueue;
        boolean isMainThread;
        boolean isPosting;
        Subscription subscription;

        PostingThreadState() {
            this.eventQueue = new ArrayList();
        }
    }

    static {
        DEFAULT_BUILDER = new EventBusBuilder();
        eventTypesCache = new HashMap();
    }

    public static EventBus getDefault() {
        if (defaultInstance != null) goto L15;
        monitor-enter(EventBus.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (defaultInstance != null) goto L9;
        defaultInstance = new EventBus();     // Catch: Throwable -> L11
    L9:
        monitor-exit(EventBus.class);     // Catch: Throwable -> L11
    L15:
        return defaultInstance;
    }

    public static EventBusBuilder builder() {
        return new EventBusBuilder();
    }

    public static void clearCaches() {
        SubscriberMethodFinder.clearCaches();
        eventTypesCache.clear();
    }

    public EventBus() {
        this(DEFAULT_BUILDER);
    }

    EventBus(EventBusBuilder r5) {
        this.currentPostingThreadState = new AnonymousClass1(this);
        this.logger = r5.getLogger();
        this.subscriptionsByEventType = new HashMap();
        this.typesBySubscriber = new HashMap();
        this.stickyEvents = new ConcurrentHashMap();
        MainThreadSupport r0 = r5.getMainThreadSupport();
        this.mainThreadSupport = r0;
        if (r0 == null) goto L5;
        Poster r1 = r0.createPoster(this);
    L6:
        this.mainThreadPoster = r1;
        this.backgroundPoster = new BackgroundPoster(this);
        this.asyncPoster = new AsyncPoster(this);
        if (r5.subscriberInfoIndexes == null) goto L9;
        int r2 = r5.subscriberInfoIndexes.size();
    L10:
        this.indexCount = r2;
        this.subscriberMethodFinder = new SubscriberMethodFinder(r5.subscriberInfoIndexes, r5.strictMethodVerification, r5.ignoreGeneratedIndex);
        this.logSubscriberExceptions = r5.logSubscriberExceptions;
        this.logNoSubscriberMessages = r5.logNoSubscriberMessages;
        this.sendSubscriberExceptionEvent = r5.sendSubscriberExceptionEvent;
        this.sendNoSubscriberEvent = r5.sendNoSubscriberEvent;
        this.throwSubscriberException = r5.throwSubscriberException;
        this.eventInheritance = r5.eventInheritance;
        this.executorService = r5.executorService;
        return;
    L9:
        r2 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public void register(Object r3) {
        Class<?> r0 = r3.getClass();
        List<SubscriberMethod> r1 = this.subscriberMethodFinder.findSubscriberMethods(r0);
        monitor-enter(this);
        Iterator<SubscriberMethod> r2 = r1.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        subscribe(r3, r2.next());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void subscribe(Object r8, SubscriberMethod r9) {
        Class<?> r0 = r9.eventType;
        Subscription r1 = new Subscription(r8, r9);
        CopyOnWriteArrayList<Subscription> r2 = this.subscriptionsByEventType.get(r0);
        if (r2 != null) goto L6;
        r2 = new CopyOnWriteArrayList();
        this.subscriptionsByEventType.put(r0, r2);
    L7:
        int r3 = r2.size();
        int r4 = 0;
    L8:
        if (r4 > r3) goto L15;
        if (r4 == r3) goto L14;
        if (r9.priority > r2.get(r4).subscriberMethod.priority) goto L14;
        r4 = r4 + 1;
    L14:
        r2.add(r4, r1);
    L15:
        List<Class<?>> r5 = this.typesBySubscriber.get(r8);
        if (r5 != null) goto L18;
        r5 = new ArrayList();
        this.typesBySubscriber.put(r8, r5);
    L18:
        r5.add(r0);
        if (r9.sticky == true) goto L21;
        return;
    L21:
        if (this.eventInheritance == false) goto L28;
        Iterator<Map.Entry<Class<?>, Object>> r10 = this.stickyEvents.entrySet().iterator();
    L24:
        if (r10.hasNext() == false) goto L41;
        Map.Entry<Class<?>, Object> r11 = r10.next();
        if (r0.isAssignableFrom(r11.getKey()) == false) goto L24;
        checkPostStickyEventToSubscription(r1, r11.getValue());
        goto L24
    L41:
        return;
    L28:
        checkPostStickyEventToSubscription(r1, this.stickyEvents.get(r0));
        return;
    L6:
        if (r2.contains(r1) == false) goto L7;
        throw new EventBusException("Subscriber " + r8.getClass() + " already registered to event " + r0);
    }

    private void checkPostStickyEventToSubscription(Subscription r2, Object r3) {
        if (r3 == null) goto L5;
        postToSubscription(r2, r3, isMainThread());
        return;
    }

    private boolean isMainThread() {
        MainThreadSupport r0 = this.mainThreadSupport;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.isMainThread();
    }

    public synchronized boolean isRegistered(Object r2) {
        monitor-enter(this);
        boolean r3 = this.typesBySubscriber.containsKey(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    private void unsubscribeByEventType(Object r5, Class<?> r6) {
        CopyOnWriteArrayList<Subscription> r4 = this.subscriptionsByEventType.get(r6);
        if (r4 == null) goto L10;
        int r7 = r4.size();
        int r1 = 0;
    L5:
        if (r1 >= r7) goto L14;
        Subscription r2 = r4.get(r1);
        if (r2.subscriber != r5) goto L9;
        r2.active = false;
        r4.remove(r1);
        r1 = r1 - 1;
        r7 = r7 - 1;
    L9:
        r1 = r1 + 1;
        goto L5
    L14:
        return;
    }

    public synchronized void unregister(Object r5) {
        monitor-enter(this);
        List<Class<?>> r1 = this.typesBySubscriber.get(r5);     // Catch: Throwable -> L14
        if (r1 == null) goto L11;
        Iterator<Class<?>> r0 = r1.iterator();     // Catch: Throwable -> L14
    L8:
        if (r0.hasNext() == false) goto L10;
        unsubscribeByEventType(r5, r0.next());     // Catch: Throwable -> L14
        goto L8
    L10:
        this.typesBySubscriber.remove(r5);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L11:
        this.logger.log(Level.WARNING, "Subscriber to unregister was not registered before: " + r5.getClass());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public void post(Object r4) {
        PostingThreadState r0 = this.currentPostingThreadState.get();
        List<Object> r1 = r0.eventQueue;
        r1.add(r4);
        if (r0.isPosting == true) goto L17;
        r0.isMainThread = isMainThread();
        r0.isPosting = true;
        if (r0.canceled == true) goto L16;
    L18:
    L12:
        th = move-exception;
        r0.isPosting = false;
        r0.isMainThread = false;
        throw th;
    L8:
        if (r1.isEmpty() == true) goto L11;
        postSingleEvent(r1.remove(0), r0);     // Catch: Throwable -> L12
        goto L18
    L11:
        r0.isPosting = false;
        r0.isMainThread = false;
        return;
    L16:
        throw new EventBusException("Internal error. Abort state was not reset");
    }

    public void cancelEventDelivery(Object r2) {
        PostingThreadState r1 = this.currentPostingThreadState.get();
        if (r1.isPosting == false) goto L18;
        if (r2 == null) goto L16;
        if (r1.event != r2) goto L14;
        if (r1.subscription.subscriberMethod.threadMode != ThreadMode.POSTING) goto L12;
        r1.canceled = true;
        return;
    L12:
        throw new EventBusException(" event handlers may only abort the incoming event");
    L14:
        throw new EventBusException("Only the currently handled event may be aborted");
    L16:
        throw new EventBusException("Event may not be null");
    L18:
        throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
    }

    public void postSticky(Object r4) {
        Map<Class<?>, Object> r0 = this.stickyEvents;
        monitor-enter(r0);
        this.stickyEvents.put(r4.getClass(), r4);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        post(r4);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public <T> T getStickyEvent(Class<T> r2) {
        Map<Class<?>, Object> r0 = this.stickyEvents;
        monitor-enter(r0);
        T r1 = r2.cast(this.stickyEvents.get(r2));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public <T> T removeStickyEvent(Class<T> r2) {
        Map<Class<?>, Object> r0 = this.stickyEvents;
        monitor-enter(r0);
        T r1 = r2.cast(this.stickyEvents.remove(r2));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean removeStickyEvent(Object r4) {
        Map<Class<?>, Object> r0 = this.stickyEvents;
        monitor-enter(r0);
        Class<?> r1 = r4.getClass();     // Catch: Throwable -> L13
        if (r4.equals(this.stickyEvents.get(r1)) == false) goto L10;
        this.stickyEvents.remove(r1);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return false;
    L13:
        th = move-exception;
        throw th;
    }

    public void removeAllStickyEvents() {
        Map<Class<?>, Object> r0 = this.stickyEvents;
        monitor-enter(r0);
        this.stickyEvents.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean hasSubscriberForEvent(Class<?> r6) {
        List<Class<?>> r7 = lookupAllEventTypes(r6);
        if (r7 == null) goto L19;
        int r1 = r7.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L19;
        Class<?> r3 = r7.get(r2);
        monitor-enter(this);
        CopyOnWriteArrayList<Subscription> r4 = this.subscriptionsByEventType.get(r3);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        if (r4 == null) goto L15;
        if (r4.isEmpty() == true) goto L15;
        return true;
    L15:
        r2 = r2 + 1;
    L16:
        th = move-exception;
        throw th;
    L19:
        return false;
    }

    private void postSingleEvent(Object r7, PostingThreadState r8) throws Error {
        Class<?> r0 = r7.getClass();
        if (this.eventInheritance == false) goto L7;
        List<Class<?>> r1 = lookupAllEventTypes(r0);
        int r2 = r1.size();
        int r3 = 0;
        boolean r4 = false;
    L5:
        if (r3 >= r2) goto L8;
        r4 = r4 | postSingleEventForEventType(r7, r8, r1.get(r3));
        r3 = r3 + 1;
    L8:
        if (r4 == false) goto L10;
        return;
    L10:
        if (this.logNoSubscriberMessages == false) goto L13;
        this.logger.log(Level.FINE, "No subscribers registered for event " + r0);
    L13:
        if (this.sendNoSubscriberEvent == true) goto L15;
        return;
    L15:
        if (r0 != NoSubscriberEvent.class) goto L17;
        return;
    L17:
        if (r0 == SubscriberExceptionEvent.class) goto L24;
        post(new NoSubscriberEvent(this, r7));
        return;
    L24:
        return;
    L7:
        r4 = postSingleEventForEventType(r7, r8, r0);
        goto L8
    }

    private boolean postSingleEventForEventType(Object r5, PostingThreadState r6, Class<?> r7) {
        monitor-enter(this);
        CopyOnWriteArrayList<Subscription> r8 = this.subscriptionsByEventType.get(r7);     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        if (r8 != null) goto L8;
    L22:
        return false;
    L8:
        if (r8.isEmpty() == true) goto L22;
        Iterator<Subscription> r9 = r8.iterator();
    L11:
        if (r9.hasNext() == false) goto L20;
        Subscription r1 = r9.next();
        r6.event = r5;
        r6.subscription = r1;
        postToSubscription(r1, r5, r6.isMainThread);     // Catch: Throwable -> L17
        boolean r2 = r6.canceled;     // Catch: Throwable -> L17
        r6.event = null;
        r6.subscription = null;
        r6.canceled = false;
        if (r2 == false) goto L11;
        return true;
    L17:
        th = move-exception;
        r6.event = null;
        r6.subscription = null;
        r6.canceled = false;
        throw th;
    L20:
        return true;
    L23:
        th = move-exception;
        throw th;
    }

    private void postToSubscription(Subscription r3, Object r4, boolean r5) {
        int r0 = AnonymousClass2.$SwitchMap$org$greenrobot$eventbus$ThreadMode[r3.subscriberMethod.threadMode.ordinal()];
        if (r0 != 1) goto L5;
        invokeSubscriber(r3, r4);
        return;
    L5:
        if (r0 != 2) goto L7;
        if (r5 == false) goto L24;
        invokeSubscriber(r3, r4);
        return;
    L24:
        this.mainThreadPoster.enqueue(r3, r4);
        return;
    L7:
        if (r0 != 3) goto L9;
        Poster r6 = this.mainThreadPoster;
        if (r6 == null) goto L21;
        r6.enqueue(r3, r4);
        return;
    L21:
        invokeSubscriber(r3, r4);
        return;
    L9:
        if (r0 != 4) goto L11;
        if (r5 == false) goto L17;
        this.backgroundPoster.enqueue(r3, r4);
        return;
    L17:
        invokeSubscriber(r3, r4);
        return;
    L11:
        if (r0 != 5) goto L14;
        this.asyncPoster.enqueue(r3, r4);
        return;
    L14:
        throw new IllegalStateException("Unknown thread mode: " + r3.subscriberMethod.threadMode);
    }

    private static List<Class<?>> lookupAllEventTypes(Class<?> r4) {
        Map<Class<?>, List<Class<?>>> r0 = eventTypesCache;
        monitor-enter(r0);
        List<Class<?>> r1 = r0.get(r4);     // Catch: Throwable -> L12
        if (r1 != null) goto L10;
        r1 = new ArrayList();     // Catch: Throwable -> L12
        Class<?> r2 = r4;
    L7:
        if (r2 == null) goto L9;
        r1.add(r2);     // Catch: Throwable -> L12
        addInterfaces(r1, r2.getInterfaces());     // Catch: Throwable -> L12
        r2 = r2.getSuperclass();     // Catch: Throwable -> L12
        goto L7
    L9:
        eventTypesCache.put(r4, r1);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L12:
        th = move-exception;
        throw th;
    }

    static void addInterfaces(List<Class<?>> r4, Class<?>[] r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Class<?> r2 = r5[r1];
        if (r4.contains(r2) == true) goto L7;
        r4.add(r2);
        addInterfaces(r4, r2.getInterfaces());
    L7:
        r1 = r1 + 1;
        goto L3
    }

    void invokeSubscriber(PendingPost r3) {
        Object r0 = r3.event;
        Subscription r1 = r3.subscription;
        PendingPost.releasePendingPost(r3);
        if (r1.active == false) goto L6;
        invokeSubscriber(r1, r0);
        return;
    }

    void invokeSubscriber(Subscription r5, Object r6) {
        r5.subscriberMethod.method.invoke(r5.subscriber, new Object[]{r6});     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L7
    L12:
        return;
    L4:
        e = move-exception;
        throw new IllegalStateException("Unexpected exception", e);
    L7:
        e = move-exception;
        handleSubscriberException(r5, r6, e.getCause());
    }

    private void handleSubscriberException(Subscription r5, Object r6, Throwable r7) {
        if ((r6 instanceof SubscriberExceptionEvent) == false) goto L8;
        if (this.logSubscriberExceptions == false) goto L18;
        this.logger.log(Level.SEVERE, "SubscriberExceptionEvent subscriber " + r5.subscriber.getClass() + " threw an exception", r7);
        SubscriberExceptionEvent r8 = (SubscriberExceptionEvent) r6;
        this.logger.log(Level.SEVERE, "Initial event " + r8.causingEvent + " caused exception in " + r8.causingSubscriber, r8.throwable);
        return;
    L18:
        return;
    L8:
        if (this.throwSubscriberException == true) goto L17;
        if (this.logSubscriberExceptions == false) goto L13;
        this.logger.log(Level.SEVERE, "Could not dispatch event: " + r6.getClass() + " to subscribing class " + r5.subscriber.getClass(), r7);
    L13:
        if (this.sendSubscriberExceptionEvent == false) goto L20;
        post(new SubscriberExceptionEvent(this, r7, r6, r5.subscriber));
        return;
    L20:
        return;
    L17:
        throw new EventBusException("Invoking subscriber failed", r7);
    }

    ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public String toString() {
        return "EventBus[indexCount=" + this.indexCount + ", eventInheritance=" + this.eventInheritance + "]";
    }
}
