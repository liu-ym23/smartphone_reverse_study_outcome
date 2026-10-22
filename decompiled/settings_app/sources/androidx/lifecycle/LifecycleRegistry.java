package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.slice.core.SliceHints;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LifecycleRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 42\u00020\u0001:\u000245B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0003J\u0010\u0010)\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u0010\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u000bH\u0002J\b\u00100\u001a\u00020\"H\u0002J\u0010\u00101\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u00102\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0016J\b\u00103\u001a\u00020\"H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u001fj\b\u0012\u0004\u0012\u00020\u000b` X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/Lifecycle;", "provider", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "enforceMainThread", "", "(Landroidx/lifecycle/LifecycleOwner;Z)V", "addingObserverCounter", "", "state", "Landroidx/lifecycle/Lifecycle$State;", "currentState", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "setCurrentState", "(Landroidx/lifecycle/Lifecycle$State;)V", "handlingEvent", "isSynced", "()Z", "lifecycleOwner", "Ljava/lang/ref/WeakReference;", "newEventOccurred", "observerCount", "getObserverCount", "()I", "observerMap", "Landroidx/arch/core/internal/FastSafeIterableMap;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "parentStates", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addObserver", "", "observer", "backwardPass", "calculateTargetState", "enforceMainThreadIfNeeded", "methodName", "", "forwardPass", "handleLifecycleEvent", "event", "Landroidx/lifecycle/Lifecycle$Event;", "markState", "moveToState", "next", "popParentState", "pushParentState", "removeObserver", "sync", "Companion", "ObserverWithState", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class LifecycleRegistry extends Lifecycle {
    public static final Companion Companion = null;
    private int addingObserverCounter;
    private final boolean enforceMainThread;
    private boolean handlingEvent;
    private final WeakReference<LifecycleOwner> lifecycleOwner;
    private boolean newEventOccurred;
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> observerMap;
    private ArrayList<Lifecycle.State> parentStates;
    private Lifecycle.State state;

    /* JADX INFO: compiled from: LifecycleRegistry.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001f\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry$Companion;", "", "()V", "createUnsafe", "Landroidx/lifecycle/LifecycleRegistry;", "owner", "Landroidx/lifecycle/LifecycleOwner;", SliceHints.SUBTYPE_MIN, "Landroidx/lifecycle/Lifecycle$State;", "state1", "state2", "min$lifecycle_runtime_release", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LifecycleRegistry createUnsafe(LifecycleOwner r3) {
            Intrinsics.checkNotNullParameter(r3, "owner");
            return new LifecycleRegistry(r3, false, null);
        }

        @JvmStatic
        public final Lifecycle.State min$lifecycle_runtime_release(Lifecycle.State r1, Lifecycle.State r2) {
            Intrinsics.checkNotNullParameter(r1, "state1");
            if (r2 != null) goto L5;
            return r1;
        L5:
            if (r2.compareTo(r1) < 0) goto L7;
            return r1;
        L7:
            return r2;
        }
    }

    /* JADX INFO: compiled from: LifecycleRegistry.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "initialState", "Landroidx/lifecycle/Lifecycle$State;", "(Landroidx/lifecycle/LifecycleObserver;Landroidx/lifecycle/Lifecycle$State;)V", "lifecycleObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "getLifecycleObserver", "()Landroidx/lifecycle/LifecycleEventObserver;", "setLifecycleObserver", "(Landroidx/lifecycle/LifecycleEventObserver;)V", "state", "getState", "()Landroidx/lifecycle/Lifecycle$State;", "setState", "(Landroidx/lifecycle/Lifecycle$State;)V", "dispatchEvent", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ObserverWithState {
        private LifecycleEventObserver lifecycleObserver;
        private Lifecycle.State state;

        public ObserverWithState(LifecycleObserver r2, Lifecycle.State r3) {
            Intrinsics.checkNotNullParameter(r3, "initialState");
            Intrinsics.checkNotNull(r2);
            this.lifecycleObserver = Lifecycling.lifecycleEventObserver(r2);
            this.state = r3;
        }

        public final Lifecycle.State getState() {
            return this.state;
        }

        public final void setState(Lifecycle.State r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.state = r2;
        }

        public final LifecycleEventObserver getLifecycleObserver() {
            return this.lifecycleObserver;
        }

        public final void setLifecycleObserver(LifecycleEventObserver r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.lifecycleObserver = r2;
        }

        public final void dispatchEvent(LifecycleOwner r4, Lifecycle.Event r5) {
            Intrinsics.checkNotNullParameter(r5, "event");
            Lifecycle.State r0 = r5.getTargetState();
            this.state = LifecycleRegistry.Companion.min$lifecycle_runtime_release(this.state, r0);
            LifecycleEventObserver r1 = this.lifecycleObserver;
            Intrinsics.checkNotNull(r4);
            r1.onStateChanged(r4, r5);
            this.state = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ LifecycleRegistry(LifecycleOwner r1, boolean r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @JvmStatic
    public static final LifecycleRegistry createUnsafe(LifecycleOwner r1) {
        return Companion.createUnsafe(r1);
    }

    @JvmStatic
    public static final Lifecycle.State min$lifecycle_runtime_release(Lifecycle.State r1, Lifecycle.State r2) {
        return Companion.min$lifecycle_runtime_release(r1, r2);
    }

    private LifecycleRegistry(LifecycleOwner r1, boolean r2) {
        this.enforceMainThread = r2;
        this.observerMap = new FastSafeIterableMap();
        this.state = Lifecycle.State.INITIALIZED;
        this.parentStates = new ArrayList();
        this.lifecycleOwner = new WeakReference(r1);
    }

    public LifecycleRegistry(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this(r2, true);
    }

    @Deprecated(message = "Override [currentState].")
    public void markState(Lifecycle.State r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        enforceMainThreadIfNeeded("markState");
        setCurrentState(r2);
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State getCurrentState() {
        return this.state;
    }

    public void setCurrentState(Lifecycle.State r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(r2);
    }

    public void handleLifecycleEvent(Lifecycle.Event r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(r2.getTargetState());
    }

    private final void moveToState(Lifecycle.State r5) {
        Lifecycle.State r0 = this.state;
        if (r0 != r5) goto L6;
        return;
    L6:
        if (r0 == Lifecycle.State.INITIALIZED) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L25;
        this.state = r5;
        if (this.handlingEvent == false) goto L16;
    L22:
        this.newEventOccurred = true;
        return;
    L16:
        if (this.addingObserverCounter != 0) goto L22;
        this.handlingEvent = true;
        sync();
        this.handlingEvent = false;
        if (this.state != Lifecycle.State.DESTROYED) goto L26;
        this.observerMap = new FastSafeIterableMap();
        return;
    L26:
        return;
    L25:
        throw new IllegalStateException(("no event down from " + this.state + " in component " + this.lifecycleOwner.get()).toString());
    L8:
        if (r5 != Lifecycle.State.DESTROYED) goto L11;
        r1 = false;
        goto L12
    }

    private final boolean isSynced() {
        if (this.observerMap.size() != 0) goto L5;
        return true;
    L5:
        Map.Entry<LifecycleObserver, ObserverWithState> r0 = this.observerMap.eldest();
        Intrinsics.checkNotNull(r0);
        Lifecycle.State r1 = r0.getValue().getState();
        Map.Entry<LifecycleObserver, ObserverWithState> r2 = this.observerMap.newest();
        Intrinsics.checkNotNull(r2);
        Lifecycle.State r3 = r2.getValue().getState();
        if (r1 == r3) goto L8;
    L10:
        return false;
    L8:
        if (this.state != r3) goto L10;
        return true;
    }

    private final Lifecycle.State calculateTargetState(LifecycleObserver r3) {
        Map.Entry<LifecycleObserver, ObserverWithState> r4 = this.observerMap.ceil(r3);
        Lifecycle.State r0 = null;
        if (r4 == null) goto L7;
        ObserverWithState r5 = r4.getValue();
        if (r5 == null) goto L7;
        Lifecycle.State r6 = r5.getState();
    L9:
        if ((!this.parentStates.isEmpty()) == false) goto L11;
        ArrayList<Lifecycle.State> r1 = this.parentStates;
        r0 = r1.get(r1.size() - 1);
    L11:
        Companion r2 = Companion;
        return r2.min$lifecycle_runtime_release(r2.min$lifecycle_runtime_release(this.state, r6), r0);
    L7:
        r6 = null;
        goto L9
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver r7) {
        Intrinsics.checkNotNullParameter(r7, "observer");
        enforceMainThreadIfNeeded("addObserver");
        if (this.state != Lifecycle.State.DESTROYED) goto L5;
        Lifecycle.State r0 = Lifecycle.State.DESTROYED;
    L6:
        ObserverWithState r1 = new ObserverWithState(r7, r0);
        if (this.observerMap.putIfAbsent(r7, r1) == null) goto L9;
        return;
    L9:
        LifecycleOwner r2 = this.lifecycleOwner.get();
        if (r2 != null) goto L13;
        return;
    L13:
        if (this.addingObserverCounter == 0) goto L15;
    L18:
        boolean r3 = true;
    L19:
        Lifecycle.State r4 = calculateTargetState(r7);
        this.addingObserverCounter++;
    L21:
        if (r1.getState().compareTo(r4) >= 0) goto L29;
        if (this.observerMap.contains(r7) == false) goto L29;
        pushParentState(r1.getState());
        Lifecycle.Event r5 = Lifecycle.Event.Companion.upFrom(r1.getState());
        if (r5 == null) goto L28;
        r1.dispatchEvent(r2, r5);
        popParentState();
        r4 = calculateTargetState(r7);
        goto L21
    L28:
        throw new IllegalStateException("no event up from " + r1.getState());
    L29:
        if (r3 == true) goto L31;
        sync();
    L31:
        this.addingObserverCounter--;
        return;
    L15:
        if (this.handlingEvent == true) goto L18;
        r3 = false;
        goto L19
    L5:
        r0 = Lifecycle.State.INITIALIZED;
        goto L6
    }

    private final void popParentState() {
        ArrayList<Lifecycle.State> r1 = this.parentStates;
        r1.remove(r1.size() - 1);
    }

    private final void pushParentState(Lifecycle.State r1) {
        this.parentStates.add(r1);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(LifecycleObserver r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(r2);
    }

    public int getObserverCount() {
        enforceMainThreadIfNeeded("getObserverCount");
        return this.observerMap.size();
    }

    private final void forwardPass(LifecycleOwner r6) {
        SafeIterableMap<LifecycleObserver, ObserverWithState>.IteratorWithAdditions r0 = this.observerMap.iteratorWithAdditions();
        Intrinsics.checkNotNullExpressionValue(r0, "observerMap.iteratorWithAdditions()");
        SafeIterableMap<LifecycleObserver, ObserverWithState>.IteratorWithAdditions r1 = r0;
    L4:
        if (r1.hasNext() == false) goto L19;
        if (this.newEventOccurred == true) goto L27;
        Map.Entry r2 = r1.next();
        LifecycleObserver r3 = (LifecycleObserver) r2.getKey();
        ObserverWithState r4 = (ObserverWithState) r2.getValue();
    L9:
        if (r4.getState().compareTo(this.state) >= 0) goto L4;
        if (this.newEventOccurred == true) goto L4;
        if (this.observerMap.contains(r3) == false) goto L4;
        pushParentState(r4.getState());
        Lifecycle.Event r5 = Lifecycle.Event.Companion.upFrom(r4.getState());
        if (r5 == null) goto L18;
        r4.dispatchEvent(r6, r5);
        popParentState();
        goto L9
    L18:
        throw new IllegalStateException("no event up from " + r4.getState());
    L27:
        return;
    }

    private final void backwardPass(LifecycleOwner r6) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> r0 = this.observerMap.descendingIterator();
        Intrinsics.checkNotNullExpressionValue(r0, "observerMap.descendingIterator()");
    L4:
        if (r0.hasNext() == false) goto L19;
        if (this.newEventOccurred == true) goto L27;
        Map.Entry<LifecycleObserver, ObserverWithState> r1 = r0.next();
        Intrinsics.checkNotNullExpressionValue(r1, "next()");
        LifecycleObserver r2 = r1.getKey();
        ObserverWithState r3 = r1.getValue();
    L9:
        if (r3.getState().compareTo(this.state) <= 0) goto L4;
        if (this.newEventOccurred == true) goto L4;
        if (this.observerMap.contains(r2) == false) goto L4;
        Lifecycle.Event r4 = Lifecycle.Event.Companion.downFrom(r3.getState());
        if (r4 == null) goto L18;
        pushParentState(r4.getTargetState());
        r3.dispatchEvent(r6, r4);
        popParentState();
        goto L9
    L18:
        throw new IllegalStateException("no event down from " + r3.getState());
    L27:
        return;
    }

    private final void sync() {
        LifecycleOwner r0 = this.lifecycleOwner.get();
        if (r0 == null) goto L18;
    L5:
        if (isSynced() == true) goto L15;
        this.newEventOccurred = false;
        Lifecycle.State r1 = this.state;
        Map.Entry<LifecycleObserver, ObserverWithState> r2 = this.observerMap.eldest();
        Intrinsics.checkNotNull(r2);
        if (r1.compareTo(r2.getValue().getState()) >= 0) goto L9;
        backwardPass(r0);
    L9:
        Map.Entry<LifecycleObserver, ObserverWithState> r3 = this.observerMap.newest();
        if (this.newEventOccurred == true) goto L5;
        if (r3 == null) goto L5;
        if (this.state.compareTo(r3.getValue().getState()) <= 0) goto L5;
        forwardPass(r0);
        goto L5
    L15:
        this.newEventOccurred = false;
        return;
    L18:
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }

    private final void enforceMainThreadIfNeeded(String r2) {
        if (this.enforceMainThread == true) goto L5;
        return;
    L5:
        if (ArchTaskExecutor.getInstance().isMainThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException(("Method " + r2 + " must be called on the main thread").toString());
    }
}
