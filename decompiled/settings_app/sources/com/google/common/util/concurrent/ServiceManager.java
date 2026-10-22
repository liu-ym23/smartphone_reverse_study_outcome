package com.google.common.util.concurrent;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class ServiceManager implements ServiceManagerBridge {
    private static final ListenerCallQueue.Event<Listener> HEALTHY_EVENT = null;
    private static final ListenerCallQueue.Event<Listener> STOPPED_EVENT = null;
    private static final Logger logger = null;
    private final ImmutableList<Service> services;
    private final ServiceManagerState state;

    private static final class EmptyServiceManagerWarning extends Throwable {
        private EmptyServiceManagerWarning() {
        }

        /* synthetic */ EmptyServiceManagerWarning(AnonymousClass1 r1) {
            this();
        }
    }

    private static final class FailedService extends Throwable {
        FailedService(Service r3) {
            super(r3.toString(), r3.failureCause(), false, false);
        }
    }

    public static abstract class Listener {
        public void failure(Service r1) {
        }

        public void healthy() {
        }

        public void stopped() {
        }

        public Listener() {
        }
    }

    private static final class NoOpService extends AbstractService {
        private NoOpService() {
        }

        /* synthetic */ NoOpService(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected void doStart() {
            notifyStarted();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected void doStop() {
            notifyStopped();
        }
    }

    private static final class ServiceListener extends Service.Listener {
        final Service service;
        final WeakReference<ServiceManagerState> state;

        ServiceListener(Service r1, WeakReference<ServiceManagerState> r2) {
            this.service = r1;
            this.state = r2;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void starting() {
            ServiceManagerState r0 = this.state.get();
            if (r0 == null) goto L8;
            r0.transitionService(this.service, Service.State.NEW, Service.State.STARTING);
            if ((this.service instanceof NoOpService) == true) goto L9;
            ServiceManager.access$200().log(Level.FINE, "Starting {0}.", this.service);
            return;
        L9:
            return;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void running() {
            ServiceManagerState r0 = this.state.get();
            if (r0 == null) goto L6;
            r0.transitionService(this.service, Service.State.STARTING, Service.State.RUNNING);
            return;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void stopping(Service.State r3) {
            ServiceManagerState r0 = this.state.get();
            if (r0 == null) goto L6;
            r0.transitionService(this.service, r3, Service.State.STOPPING);
            return;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void terminated(Service.State r7) {
            ServiceManagerState r0 = this.state.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if ((this.service instanceof NoOpService) == true) goto L7;
            ServiceManager.access$200().log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.service, r7});
        L7:
            r0.transitionService(this.service, r7, Service.State.TERMINATED);
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void failed(Service.State r8, Throwable r9) {
            ServiceManagerState r0 = this.state.get();
            if (r0 == null) goto L13;
            boolean r2 = true;
            boolean r1 = !(this.service instanceof NoOpService);
            if (r8 != Service.State.STARTING) goto L9;
            r2 = false;
        L9:
            if ((r1 & r2) == false) goto L11;
            Logger r3 = ServiceManager.access$200();
            Level r4 = Level.SEVERE;
            String r5 = String.valueOf(this.service);
            String r6 = String.valueOf(r8);
            r3.log(r4, new StringBuilder((String.valueOf(r5).length() + 34) + String.valueOf(r6).length()).append("Service ").append(r5).append(" has failed in the ").append(r6).append(" state.").toString(), r9);
        L11:
            r0.transitionService(this.service, r8, Service.State.FAILED);
            return;
        }
    }

    private static final class ServiceManagerState {
        final Monitor.Guard awaitHealthGuard;
        final ListenerCallQueue<Listener> listeners;
        final Monitor monitor;
        final int numberOfServices;
        boolean ready;
        final SetMultimap<Service.State, Service> servicesByState;
        final Map<Service, Stopwatch> startupTimers;
        final Multiset<Service.State> states;
        final Monitor.Guard stoppedGuard;
        boolean transitioned;

        final class AwaitHealthGuard extends Monitor.Guard {
            final /* synthetic */ ServiceManagerState this$0;

            AwaitHealthGuard(ServiceManagerState r1) {
                this.this$0 = r1;
                super(r1.monitor);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            public boolean isSatisfied() {
                if (this.this$0.states.count(Service.State.RUNNING) != this.this$0.numberOfServices) goto L5;
            L12:
                return true;
            L5:
                if (this.this$0.states.contains(Service.State.STOPPING) == true) goto L12;
                if (this.this$0.states.contains(Service.State.TERMINATED) == true) goto L12;
                if (this.this$0.states.contains(Service.State.FAILED) == true) goto L12;
                return false;
            }
        }

        final class StoppedGuard extends Monitor.Guard {
            final /* synthetic */ ServiceManagerState this$0;

            StoppedGuard(ServiceManagerState r1) {
                this.this$0 = r1;
                super(r1.monitor);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            public boolean isSatisfied() {
                if ((this.this$0.states.count(Service.State.TERMINATED) + this.this$0.states.count(Service.State.FAILED)) != this.this$0.numberOfServices) goto L5;
                return true;
            L5:
                return false;
            }
        }

        ServiceManagerState(ImmutableCollection<Service> r3) {
            this.monitor = new Monitor();
            SetMultimap<Service.State, Service> r0 = MultimapBuilder.enumKeys(Service.State.class).linkedHashSetValues().build();
            this.servicesByState = r0;
            this.states = r0.keys();
            this.startupTimers = Maps.newIdentityHashMap();
            this.awaitHealthGuard = new AwaitHealthGuard(this);
            this.stoppedGuard = new StoppedGuard(this);
            this.listeners = new ListenerCallQueue();
            this.numberOfServices = r3.size();
            r0.putAll(Service.State.NEW, r3);
        }

        void tryStartTiming(Service r3) {
            this.monitor.enter();
        L8:
            th = move-exception;
            this.monitor.leave();
            throw th;
        L4:
            if (this.startupTimers.get(r3) != null) goto L6;
            this.startupTimers.put(r3, Stopwatch.createStarted());     // Catch: Throwable -> L8
        L6:
            this.monitor.leave();
        }

        void markReady() {
            this.monitor.enter();
        L16:
            th = move-exception;
            this.monitor.leave();
            throw th;
        L4:
            if (this.transitioned == true) goto L8;
            this.ready = true;     // Catch: Throwable -> L16
            this.monitor.leave();
            return;
        L8:
            ArrayList r0 = Lists.newArrayList();     // Catch: Throwable -> L16
            UnmodifiableIterator<Service> r1 = servicesByState().values().iterator();     // Catch: Throwable -> L16
        L10:
            if (r1.hasNext() == false) goto L14;
            Service r2 = r1.next();     // Catch: Throwable -> L16
            if (r2.state() == Service.State.NEW) goto L10;
            r0.add(r2);     // Catch: Throwable -> L16
            goto L10
        L14:
            String r3 = String.valueOf(r0);     // Catch: Throwable -> L16
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(r3).length() + 89).append("Services started transitioning asynchronously before the ServiceManager was constructed: ").append(r3).toString());     // Catch: Throwable -> L16
        }

        void addListener(Listener r1, Executor r2) {
            this.listeners.addListener(r1, r2);
        }

        void awaitHealthy() {
            this.monitor.enterWhenUninterruptibly(this.awaitHealthGuard);
            checkHealthy();     // Catch: Throwable -> L6
            this.monitor.leave();
            return;
        L6:
            th = move-exception;
            this.monitor.leave();
            throw th;
        }

        void awaitHealthy(long r3, TimeUnit r5) throws TimeoutException {
            this.monitor.enter();
        L10:
            th = move-exception;
            this.monitor.leave();
            throw th;
        L4:
            if (this.monitor.waitForUninterruptibly(this.awaitHealthGuard, r3, r5) == false) goto L8;
            checkHealthy();     // Catch: Throwable -> L10
            this.monitor.leave();
            return;
        L8:
            String r4 = String.valueOf(Multimaps.filterKeys(this.servicesByState, Predicates.in(ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));     // Catch: Throwable -> L10
            throw new TimeoutException(new StringBuilder(String.valueOf(r4).length() + 93).append("Timeout waiting for the services to become healthy. The following services have not started: ").append(r4).toString());     // Catch: Throwable -> L10
        }

        void awaitStopped() {
            this.monitor.enterWhenUninterruptibly(this.stoppedGuard);
            this.monitor.leave();
        }

        void awaitStopped(long r3, TimeUnit r5) throws TimeoutException {
            this.monitor.enter();
        L9:
            th = move-exception;
            this.monitor.leave();
            throw th;
        L4:
            if (this.monitor.waitForUninterruptibly(this.stoppedGuard, r3, r5) == false) goto L7;
            this.monitor.leave();
            return;
        L7:
            String r4 = String.valueOf(Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.in(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));     // Catch: Throwable -> L9
            throw new TimeoutException(new StringBuilder(String.valueOf(r4).length() + 83).append("Timeout waiting for the services to stop. The following services have not stopped: ").append(r4).toString());     // Catch: Throwable -> L9
        }

        ImmutableSetMultimap<Service.State, Service> servicesByState() {
            ImmutableSetMultimap.Builder r0 = ImmutableSetMultimap.builder();
            this.monitor.enter();
            Iterator<Map.Entry<Service.State, Service>> r1 = this.servicesByState.entries().iterator();     // Catch: Throwable -> L12
        L5:
            if (r1.hasNext() == false) goto L10;
            Map.Entry<Service.State, Service> r2 = r1.next();     // Catch: Throwable -> L12
            if ((r2.getValue() instanceof NoOpService) == true) goto L5;
            r0.put(r2);     // Catch: Throwable -> L12
            goto L5
        L10:
            this.monitor.leave();
            return r0.build();
        L12:
            th = move-exception;
            this.monitor.leave();
            throw th;
        }

        ImmutableMap<Service, Long> startupTimes() {
            this.monitor.enter();
            ArrayList r0 = Lists.newArrayListWithCapacity(this.startupTimers.size());     // Catch: Throwable -> L14
            Iterator<Map.Entry<Service, Stopwatch>> r1 = this.startupTimers.entrySet().iterator();     // Catch: Throwable -> L14
        L5:
            if (r1.hasNext() == false) goto L12;
            Map.Entry<Service, Stopwatch> r2 = r1.next();     // Catch: Throwable -> L14
            Service r3 = r2.getKey();     // Catch: Throwable -> L14
            Stopwatch r4 = r2.getValue();     // Catch: Throwable -> L14
            if (r4.isRunning() == true) goto L5;
            if ((r3 instanceof NoOpService) == true) goto L5;
            r0.add(Maps.immutableEntry(r3, Long.valueOf(r4.elapsed(TimeUnit.MILLISECONDS))));     // Catch: Throwable -> L14
            goto L5
        L12:
            this.monitor.leave();
            Collections.sort(r0, Ordering.natural().onResultOf(new AnonymousClass1(this)));
            return ImmutableMap.copyOf(r0);
        L14:
            th = move-exception;
            this.monitor.leave();
            throw th;
        }

        void transitionService(Service r7, Service.State r8, Service.State r9) {
            Preconditions.checkNotNull(r7);
            if (r8 == r9) goto L5;
            boolean r2 = true;
        L6:
            Preconditions.checkArgument(r2);
            this.monitor.enter();
            this.transitioned = true;     // Catch: Throwable -> L32
            if (this.ready == true) goto L11;
            this.monitor.leave();
            dispatchListenerEvents();
            return;
        L11:
            Preconditions.checkState(this.servicesByState.remove(r8, r7), "Service %s not at the expected location in the state map %s", r7, r8);     // Catch: Throwable -> L32
            Preconditions.checkState(this.servicesByState.put(r9, r7), "Service %s in the state map unexpectedly at %s", r7, r9);     // Catch: Throwable -> L32
            Stopwatch r10 = this.startupTimers.get(r7);     // Catch: Throwable -> L32
            if (r10 != null) goto L15;
            r10 = Stopwatch.createStarted();     // Catch: Throwable -> L32
            this.startupTimers.put(r7, r10);     // Catch: Throwable -> L32
        L15:
            if (r9.compareTo(Service.State.RUNNING) < 0) goto L22;
            if (r10.isRunning() == false) goto L22;
            r10.stop();     // Catch: Throwable -> L32
            if ((r7 instanceof NoOpService) == true) goto L22;
            ServiceManager.access$200().log(Level.FINE, "Started {0} in {1}.", new Object[]{r7, r10});     // Catch: Throwable -> L32
        L22:
            if (r9 != Service.State.FAILED) goto L25;
            enqueueFailedEvent(r7);     // Catch: Throwable -> L32
        L25:
            if (this.states.count(Service.State.RUNNING) != this.numberOfServices) goto L28;
            enqueueHealthyEvent();     // Catch: Throwable -> L32
        L30:
            this.monitor.leave();
            dispatchListenerEvents();
            return;
        L28:
            if ((this.states.count(Service.State.TERMINATED) + this.states.count(Service.State.FAILED)) != this.numberOfServices) goto L30;
            enqueueStoppedEvent();     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            this.monitor.leave();
            dispatchListenerEvents();
            throw th;
        L5:
            r2 = false;
            goto L6
        }

        void enqueueStoppedEvent() {
            this.listeners.enqueue(ServiceManager.access$300());
        }

        void enqueueHealthyEvent() {
            this.listeners.enqueue(ServiceManager.access$400());
        }

        void enqueueFailedEvent(final Service r3) {
            this.listeners.enqueue(new AnonymousClass2(this, r3));
        }

        void dispatchListenerEvents() {
            Preconditions.checkState(!this.monitor.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
            this.listeners.dispatch();
        }

        void checkHealthy() {
            if (this.states.count(Service.State.RUNNING) == this.numberOfServices) goto L9;
            String r1 = String.valueOf(Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.equalTo(Service.State.RUNNING))));
            IllegalStateException r0 = new IllegalStateException(new StringBuilder(String.valueOf(r1).length() + 79).append("Expected to be healthy after starting. The following services are not running: ").append(r1).toString());
            Iterator<Service> r4 = this.servicesByState.get(Service.State.FAILED).iterator();
        L6:
            if (r4.hasNext() == false) goto L8;
            r0.addSuppressed(new FailedService(r4.next()));
            goto L6
        L8:
            throw r0;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$Kr77I-r1gBsiOW-GR0wXOcWl8hw, reason: not valid java name */
    public static /* synthetic */ Duration m914$r8$lambda$Kr77Ir1gBsiOWGR0wXOcWl8hw(long r0) {
        return Duration.ofMillis(r0);
    }

    @Override // com.google.common.util.concurrent.ServiceManagerBridge
    public /* bridge */ /* synthetic */ ImmutableMultimap servicesByState() {
        return servicesByState();
    }

    static /* synthetic */ Logger access$200() {
        return logger;
    }

    static /* synthetic */ ListenerCallQueue.Event access$300() {
        return STOPPED_EVENT;
    }

    static /* synthetic */ ListenerCallQueue.Event access$400() {
        return HEALTHY_EVENT;
    }

    static {
        logger = Logger.getLogger(ServiceManager.class.getName());
        HEALTHY_EVENT = new AnonymousClass1();
        STOPPED_EVENT = new AnonymousClass2();
    }

    public ServiceManager(Iterable<? extends Service> r5) {
        ImmutableList<Service> r6 = ImmutableList.copyOf(r5);
        if (r6.isEmpty() == false) goto L5;
        AnonymousClass1 r2 = null;
        logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", new EmptyServiceManagerWarning(r2));
        r6 = ImmutableList.of(new NoOpService(r2));
    L5:
        ServiceManagerState r0 = new ServiceManagerState(r6);
        this.state = r0;
        this.services = r6;
        WeakReference r1 = new WeakReference(r0);
        UnmodifiableIterator<Service> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L13;
        Service r3 = r7.next();
        r3.addListener(new ServiceListener(r3, r1), MoreExecutors.directExecutor());
        if (r3.state() != Service.State.NEW) goto L11;
        boolean r4 = true;
    L12:
        Preconditions.checkArgument(r4, "Can only manage NEW services, %s", r3);
        goto L7
    L11:
        r4 = false;
        goto L12
    L13:
        this.state.markReady();
    }

    public void addListener(Listener r1, Executor r2) {
        this.state.addListener(r1, r2);
    }

    public ServiceManager startAsync() {
        UnmodifiableIterator<Service> r0 = this.services.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Service r1 = r0.next();
        Service.State r2 = r1.state();
        if (r2 != Service.State.NEW) goto L8;
        boolean r3 = true;
    L9:
        Preconditions.checkState(r3, "Service %s is %s, cannot start it.", r1, r2);
        goto L4
    L8:
        r3 = false;
        goto L9
    L10:
        UnmodifiableIterator<Service> r4 = this.services.iterator();
    L12:
        if (r4.hasNext() == false) goto L18;
        Service r5 = r4.next();
        this.state.tryStartTiming(r5);     // Catch: IllegalStateException -> L16
        r5.startAsync();     // Catch: IllegalStateException -> L16
    L16:
        e = move-exception;
        Logger r6 = logger;
        Level r7 = Level.WARNING;
        String r8 = String.valueOf(r5);
        r6.log(r7, new StringBuilder(String.valueOf(r8).length() + 24).append("Unable to start Service ").append(r8).toString(), e);
        goto L12
    L18:
        return this;
    }

    public void awaitHealthy() {
        this.state.awaitHealthy();
    }

    public void awaitHealthy(Duration r3) throws TimeoutException {
        awaitHealthy(Internal.toNanosSaturated(r3), TimeUnit.NANOSECONDS);
    }

    public void awaitHealthy(long r1, TimeUnit r3) throws TimeoutException {
        this.state.awaitHealthy(r1, r3);
    }

    public ServiceManager stopAsync() {
        UnmodifiableIterator<Service> r0 = this.services.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().stopAsync();
        goto L4
    L6:
        return this;
    }

    public void awaitStopped() {
        this.state.awaitStopped();
    }

    public void awaitStopped(Duration r3) throws TimeoutException {
        awaitStopped(Internal.toNanosSaturated(r3), TimeUnit.NANOSECONDS);
    }

    public void awaitStopped(long r1, TimeUnit r3) throws TimeoutException {
        this.state.awaitStopped(r1, r3);
    }

    public boolean isHealthy() {
        UnmodifiableIterator<Service> r1 = this.services.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().isRunning() == true) goto L4;
        return false;
    L9:
        return true;
    }

    @Override // com.google.common.util.concurrent.ServiceManagerBridge
    public ImmutableSetMultimap<Service.State, Service> servicesByState() {
        return this.state.servicesByState();
    }

    public ImmutableMap<Service, Long> startupTimes() {
        return this.state.startupTimes();
    }

    public ImmutableMap<Service, Duration> startupDurations() {
        return ImmutableMap.copyOf(Maps.transformValues(startupTimes(), new ServiceManager$$ExternalSyntheticLambda0()));
    }

    public String toString() {
        return MoreObjects.toStringHelper(ServiceManager.class).add("services", Collections2.filter(this.services, Predicates.not(Predicates.instanceOf(NoOpService.class)))).toString();
    }
}
