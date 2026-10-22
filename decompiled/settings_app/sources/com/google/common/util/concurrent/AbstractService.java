package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractService implements Service {
    private static final ListenerCallQueue.Event<Service.Listener> RUNNING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> STARTING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> STOPPING_FROM_RUNNING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> STOPPING_FROM_STARTING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_NEW_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_RUNNING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_STARTING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_STOPPING_EVENT = null;
    private final Monitor.Guard hasReachedRunning;
    private final Monitor.Guard isStartable;
    private final Monitor.Guard isStoppable;
    private final Monitor.Guard isStopped;
    private final ListenerCallQueue<Service.Listener> listeners;
    private final Monitor monitor;
    private volatile StateSnapshot snapshot;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractService$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$util$concurrent$Service$State = null;

        static {
            int[] r0 = new int[Service.State.values().length];
            $SwitchMap$com$google$common$util$concurrent$Service$State = r0;
            r0[Service.State.NEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.STARTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.RUNNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.STOPPING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.TERMINATED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    private final class HasReachedRunningGuard extends Monitor.Guard {
        final /* synthetic */ AbstractService this$0;

        HasReachedRunningGuard(AbstractService r1) {
            this.this$0 = r1;
            super(AbstractService.access$000(r1));
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            if (this.this$0.state().compareTo(Service.State.RUNNING) < 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private final class IsStartableGuard extends Monitor.Guard {
        final /* synthetic */ AbstractService this$0;

        IsStartableGuard(AbstractService r1) {
            this.this$0 = r1;
            super(AbstractService.access$000(r1));
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            if (this.this$0.state() != Service.State.NEW) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private final class IsStoppableGuard extends Monitor.Guard {
        final /* synthetic */ AbstractService this$0;

        IsStoppableGuard(AbstractService r1) {
            this.this$0 = r1;
            super(AbstractService.access$000(r1));
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            if (this.this$0.state().compareTo(Service.State.RUNNING) > 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private final class IsStoppedGuard extends Monitor.Guard {
        final /* synthetic */ AbstractService this$0;

        IsStoppedGuard(AbstractService r1) {
            this.this$0 = r1;
            super(AbstractService.access$000(r1));
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            if (this.this$0.state().compareTo(Service.State.TERMINATED) < 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private static final class StateSnapshot {

        @CheckForNull
        final Throwable failure;
        final boolean shutdownWhenStartupFinishes;
        final Service.State state;

        StateSnapshot(Service.State r3) {
            this(r3, false, null);
        }

        StateSnapshot(Service.State r5, boolean r6, @CheckForNull Throwable r7) {
            boolean r0 = false;
            if (r6 == true) goto L5;
        L8:
            boolean r2 = true;
        L9:
            Preconditions.checkArgument(r2, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", r5);
            if (r7 == null) goto L12;
            boolean r3 = true;
        L14:
            if (r5 != Service.State.FAILED) goto L16;
            boolean r4 = true;
        L17:
            if (r3 != r4) goto L19;
            r0 = true;
        L19:
            Preconditions.checkArgument(r0, "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", r5, r7);
            this.state = r5;
            this.shutdownWhenStartupFinishes = r6;
            this.failure = r7;
            return;
        L16:
            r4 = false;
            goto L17
        L12:
            r3 = false;
            goto L14
        L5:
            if (r5 == Service.State.STARTING) goto L8;
            r2 = false;
            goto L9
        }

        Service.State externalState() {
            if (this.shutdownWhenStartupFinishes == false) goto L9;
            if (this.state != Service.State.STARTING) goto L9;
            return Service.State.STOPPING;
        L9:
            return this.state;
        }

        Throwable failureCause() {
            if (this.state != Service.State.FAILED) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0, "failureCause() is only valid if the service has failed, service is %s", this.state);
            return (Throwable) Objects.requireNonNull(this.failure);
        L5:
            r0 = false;
            goto L6
        }
    }

    protected void doCancelStart() {
    }

    protected abstract void doStart();

    protected abstract void doStop();

    static /* synthetic */ Monitor access$000(AbstractService r0) {
        return r0.monitor;
    }

    static {
        STARTING_EVENT = new AnonymousClass1();
        RUNNING_EVENT = new AnonymousClass2();
        STOPPING_FROM_STARTING_EVENT = stoppingEvent(Service.State.STARTING);
        STOPPING_FROM_RUNNING_EVENT = stoppingEvent(Service.State.RUNNING);
        TERMINATED_FROM_NEW_EVENT = terminatedEvent(Service.State.NEW);
        TERMINATED_FROM_STARTING_EVENT = terminatedEvent(Service.State.STARTING);
        TERMINATED_FROM_RUNNING_EVENT = terminatedEvent(Service.State.RUNNING);
        TERMINATED_FROM_STOPPING_EVENT = terminatedEvent(Service.State.STOPPING);
    }

    private static ListenerCallQueue.Event<Service.Listener> terminatedEvent(final Service.State r1) {
        return new AnonymousClass3(r1);
    }

    private static ListenerCallQueue.Event<Service.Listener> stoppingEvent(final Service.State r1) {
        return new AnonymousClass4(r1);
    }

    protected AbstractService() {
        this.monitor = new Monitor();
        this.isStartable = new IsStartableGuard(this);
        this.isStoppable = new IsStoppableGuard(this);
        this.hasReachedRunning = new HasReachedRunningGuard(this);
        this.isStopped = new IsStoppedGuard(this);
        this.listeners = new ListenerCallQueue();
        this.snapshot = new StateSnapshot(Service.State.NEW);
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service startAsync() {
        if (this.monitor.enterIf(this.isStartable) == true) goto L17;
        String r3 = String.valueOf(this);
        throw new IllegalStateException(new StringBuilder(String.valueOf(r3).length() + 33).append("Service ").append(r3).append(" has already been started").toString());
    L17:
        this.snapshot = new StateSnapshot(Service.State.STARTING);     // Catch: Throwable -> L6
        enqueueStartingEvent();     // Catch: Throwable -> L6
        doStart();     // Catch: Throwable -> L6
    L8:
        this.monitor.leave();
        dispatchListenerEvents();
        return this;
    L6:
        th = move-exception;
        notifyFailed(th);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.monitor.leave();
        dispatchListenerEvents();
        throw th;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service stopAsync() {
        if (this.monitor.enterIf(this.isStoppable) == true) goto L22;
    L19:
        return this;
    L22:
        Service.State r0 = state();     // Catch: Throwable -> L13
        switch(AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[r0.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            default: goto L15;
        };     // Catch: Throwable -> L13
    L7:
        String r1 = String.valueOf(r0);     // Catch: Throwable -> L13
        throw new AssertionError(new StringBuilder(String.valueOf(r1).length() + 45).append("isStoppable is incorrectly implemented, saw: ").append(r1).toString());     // Catch: Throwable -> L13
    L9:
        this.snapshot = new StateSnapshot(Service.State.STOPPING);     // Catch: Throwable -> L13
        enqueueStoppingEvent(Service.State.RUNNING);     // Catch: Throwable -> L13
        doStop();     // Catch: Throwable -> L13
        goto L15
    L10:
        this.snapshot = new StateSnapshot(Service.State.STARTING, true, null);     // Catch: Throwable -> L13
        enqueueStoppingEvent(Service.State.STARTING);     // Catch: Throwable -> L13
        doCancelStart();     // Catch: Throwable -> L13
        goto L15
    L11:
        this.snapshot = new StateSnapshot(Service.State.TERMINATED);     // Catch: Throwable -> L13
        enqueueTerminatedEvent(Service.State.NEW);     // Catch: Throwable -> L13
    L15:
        this.monitor.leave();
        dispatchListenerEvents();
    L13:
        th = move-exception;
        notifyFailed(th);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.monitor.leave();
        dispatchListenerEvents();
        throw th;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.monitor.enterWhenUninterruptibly(this.hasReachedRunning);
        checkCurrentState(Service.State.RUNNING);     // Catch: Throwable -> L6
        this.monitor.leave();
        return;
    L6:
        th = move-exception;
        this.monitor.leave();
        throw th;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(Duration r1) throws TimeoutException {
        super.awaitRunning(r1);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long r3, TimeUnit r5) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.hasReachedRunning, r3, r5) == true) goto L12;
        String r2 = String.valueOf(this);
        throw new TimeoutException(new StringBuilder(String.valueOf(r2).length() + 50).append("Timed out waiting for ").append(r2).append(" to reach the RUNNING state.").toString());
    L12:
        checkCurrentState(Service.State.RUNNING);     // Catch: Throwable -> L7
        this.monitor.leave();
        return;
    L7:
        th = move-exception;
        this.monitor.leave();
        throw th;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.monitor.enterWhenUninterruptibly(this.isStopped);
        checkCurrentState(Service.State.TERMINATED);     // Catch: Throwable -> L6
        this.monitor.leave();
        return;
    L6:
        th = move-exception;
        this.monitor.leave();
        throw th;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(Duration r1) throws TimeoutException {
        super.awaitTerminated(r1);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long r3, TimeUnit r5) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.isStopped, r3, r5) == true) goto L12;
        String r4 = String.valueOf(this);
        String r2 = String.valueOf(state());
        throw new TimeoutException(new StringBuilder((String.valueOf(r4).length() + 65) + String.valueOf(r2).length()).append("Timed out waiting for ").append(r4).append(" to reach a terminal state. Current state: ").append(r2).toString());
    L12:
        checkCurrentState(Service.State.TERMINATED);     // Catch: Throwable -> L7
        this.monitor.leave();
        return;
    L7:
        th = move-exception;
        this.monitor.leave();
        throw th;
    }

    private void checkCurrentState(Service.State r7) {
        Service.State r0 = state();
        if (r0 != r7) goto L5;
        return;
    L5:
        if (r0 != Service.State.FAILED) goto L8;
        String r1 = String.valueOf(this);
        String r8 = String.valueOf(r7);
        throw new IllegalStateException(new StringBuilder((String.valueOf(r1).length() + 56) + String.valueOf(r8).length()).append("Expected the service ").append(r1).append(" to be ").append(r8).append(", but the service has FAILED").toString(), failureCause());
    L8:
        String r6 = String.valueOf(this);
        String r9 = String.valueOf(r7);
        String r2 = String.valueOf(r0);
        throw new IllegalStateException(new StringBuilder(((String.valueOf(r6).length() + 38) + String.valueOf(r9).length()) + String.valueOf(r2).length()).append("Expected the service ").append(r6).append(" to be ").append(r9).append(", but was ").append(r2).toString());
    }

    protected final void notifyStarted() {
        this.monitor.enter();
    L13:
        th = move-exception;
        this.monitor.leave();
        dispatchListenerEvents();
        throw th;
    L4:
        if (this.snapshot.state == Service.State.STARTING) goto L6;
        String r1 = String.valueOf(this.snapshot.state);     // Catch: Throwable -> L13
        IllegalStateException r0 = new IllegalStateException(new StringBuilder(String.valueOf(r1).length() + 43).append("Cannot notifyStarted() when the service is ").append(r1).toString());     // Catch: Throwable -> L13
        notifyFailed(r0);     // Catch: Throwable -> L13
        throw r0;     // Catch: Throwable -> L13
    L6:
        if (this.snapshot.shutdownWhenStartupFinishes == false) goto L8;
        this.snapshot = new StateSnapshot(Service.State.STOPPING);     // Catch: Throwable -> L13
        doStop();     // Catch: Throwable -> L13
    L9:
        this.monitor.leave();
        dispatchListenerEvents();
        return;
    L8:
        this.snapshot = new StateSnapshot(Service.State.RUNNING);     // Catch: Throwable -> L13
        enqueueRunningEvent();     // Catch: Throwable -> L13
        goto L9
    }

    protected final void notifyStopped() {
        this.monitor.enter();
        Service.State r0 = state();     // Catch: Throwable -> L11
        switch(AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[r0.ordinal()]) {
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L7;
            case 6: goto L7;
            default: goto L9;
        };     // Catch: Throwable -> L11
    L6:
        this.snapshot = new StateSnapshot(Service.State.TERMINATED);     // Catch: Throwable -> L11
        enqueueTerminatedEvent(r0);     // Catch: Throwable -> L11
        goto L9
    L7:
        String r1 = String.valueOf(r0);     // Catch: Throwable -> L11
        throw new IllegalStateException(new StringBuilder(String.valueOf(r1).length() + 43).append("Cannot notifyStopped() when the service is ").append(r1).toString());     // Catch: Throwable -> L11
    L9:
        this.monitor.leave();
        dispatchListenerEvents();
        return;
    L11:
        th = move-exception;
        this.monitor.leave();
        dispatchListenerEvents();
        throw th;
    }

    protected final void notifyFailed(Throwable r5) {
        Preconditions.checkNotNull(r5);
        this.monitor.enter();
        Service.State r0 = state();     // Catch: Throwable -> L19
        int r1 = AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[r0.ordinal()];     // Catch: Throwable -> L19
        if (r1 != 1) goto L6;
    L17:
        String r2 = String.valueOf(r0);     // Catch: Throwable -> L19
        throw new IllegalStateException(new StringBuilder(String.valueOf(r2).length() + 22).append("Failed while in state:").append(r2).toString(), r5);     // Catch: Throwable -> L19
    L6:
        if (r1 != 2) goto L8;
    L14:
        this.snapshot = new StateSnapshot(Service.State.FAILED, false, r5);     // Catch: Throwable -> L19
        enqueueFailedEvent(r0, r5);     // Catch: Throwable -> L19
    L15:
        this.monitor.leave();
        dispatchListenerEvents();
        return;
    L8:
        if (r1 == 3) goto L14;
        if (r1 == 4) goto L14;
        if (r1 == 5) goto L17;
    L19:
        th = move-exception;
        this.monitor.leave();
        dispatchListenerEvents();
        throw th;
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        if (state() != Service.State.RUNNING) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.snapshot.externalState();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.snapshot.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener r1, Executor r2) {
        this.listeners.addListener(r1, r2);
    }

    public String toString() {
        String r0 = getClass().getSimpleName();
        String r3 = String.valueOf(state());
        return new StringBuilder((String.valueOf(r0).length() + 3) + String.valueOf(r3).length()).append(r0).append(" [").append(r3).append("]").toString();
    }

    private void dispatchListenerEvents() {
        if (this.monitor.isOccupiedByCurrentThread() == true) goto L6;
        this.listeners.dispatch();
        return;
    }

    private void enqueueStartingEvent() {
        this.listeners.enqueue(STARTING_EVENT);
    }

    private void enqueueRunningEvent() {
        this.listeners.enqueue(RUNNING_EVENT);
    }

    private void enqueueStoppingEvent(Service.State r2) {
        if (r2 != Service.State.STARTING) goto L6;
        this.listeners.enqueue(STOPPING_FROM_STARTING_EVENT);
        return;
    L6:
        if (r2 != Service.State.RUNNING) goto L10;
        this.listeners.enqueue(STOPPING_FROM_RUNNING_EVENT);
        return;
    L10:
        throw new AssertionError();
    }

    private void enqueueTerminatedEvent(Service.State r2) {
        switch(AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[r2.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L6;
            default: goto L15;
        };
    L7:
        this.listeners.enqueue(TERMINATED_FROM_STOPPING_EVENT);
        return;
    L8:
        this.listeners.enqueue(TERMINATED_FROM_RUNNING_EVENT);
        return;
    L9:
        this.listeners.enqueue(TERMINATED_FROM_STARTING_EVENT);
        return;
    L10:
        this.listeners.enqueue(TERMINATED_FROM_NEW_EVENT);
        return;
    L15:
        return;
    L6:
        throw new AssertionError();
    }

    private void enqueueFailedEvent(final Service.State r3, final Throwable r4) {
        this.listeners.enqueue(new AnonymousClass5(this, r3, r4));
    }
}
