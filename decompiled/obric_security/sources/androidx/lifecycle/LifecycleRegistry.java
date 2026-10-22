package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {
    private int mAddingObserverCounter;
    private final boolean mEnforceMainThread;
    private boolean mHandlingEvent;
    private final WeakReference<LifecycleOwner> mLifecycleOwner;
    private boolean mNewEventOccurred;
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> mObserverMap;
    private ArrayList<Lifecycle.State> mParentStates;
    private Lifecycle.State mState;

    static class ObserverWithState {
        LifecycleEventObserver mLifecycleObserver;
        Lifecycle.State mState;

        ObserverWithState(LifecycleObserver r1, Lifecycle.State r2) {
            this.mLifecycleObserver = Lifecycling.lifecycleEventObserver(r1);
            this.mState = r2;
        }

        void dispatchEvent(LifecycleOwner r3, Lifecycle.Event r4) {
            Lifecycle.State r0 = r4.getTargetState();
            this.mState = LifecycleRegistry.min(this.mState, r0);
            this.mLifecycleObserver.onStateChanged(r3, r4);
            this.mState = r0;
        }
    }

    public LifecycleRegistry(LifecycleOwner r2) {
        this(r2, true);
    }

    private LifecycleRegistry(LifecycleOwner r2, boolean r3) {
        this.mObserverMap = new FastSafeIterableMap();
        this.mAddingObserverCounter = 0;
        this.mHandlingEvent = false;
        this.mNewEventOccurred = false;
        this.mParentStates = new ArrayList();
        this.mLifecycleOwner = new WeakReference(r2);
        this.mState = Lifecycle.State.INITIALIZED;
        this.mEnforceMainThread = r3;
    }

    @Deprecated
    public void markState(Lifecycle.State r2) {
        enforceMainThreadIfNeeded("markState");
        setCurrentState(r2);
    }

    public void setCurrentState(Lifecycle.State r2) {
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(r2);
    }

    public void handleLifecycleEvent(Lifecycle.Event r2) {
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(r2.getTargetState());
    }

    private void moveToState(Lifecycle.State r3) {
        Lifecycle.State r0 = this.mState;
        if (r0 != r3) goto L6;
        return;
    L6:
        if (r0 == Lifecycle.State.INITIALIZED) goto L8;
    L12:
        this.mState = r3;
        if (this.mHandlingEvent == false) goto L15;
    L21:
        this.mNewEventOccurred = true;
        return;
    L15:
        if (this.mAddingObserverCounter != 0) goto L21;
        this.mHandlingEvent = true;
        sync();
        this.mHandlingEvent = false;
        if (this.mState != Lifecycle.State.DESTROYED) goto L23;
        this.mObserverMap = new FastSafeIterableMap();
        return;
    L23:
        return;
    L8:
        if (r3 != Lifecycle.State.DESTROYED) goto L12;
        throw new IllegalStateException("no event down from " + this.mState);
    }

    private boolean isSynced() {
        if (this.mObserverMap.size() != 0) goto L5;
        return true;
    L5:
        Lifecycle.State r0 = this.mObserverMap.eldest().getValue().mState;
        Lifecycle.State r2 = this.mObserverMap.newest().getValue().mState;
        if (r0 == r2) goto L8;
    L10:
        return false;
    L8:
        if (this.mState != r2) goto L10;
        return true;
    }

    private Lifecycle.State calculateTargetState(LifecycleObserver r3) {
        Map.Entry<LifecycleObserver, ObserverWithState> r4 = this.mObserverMap.ceil(r3);
        Lifecycle.State r0 = null;
        if (r4 == null) goto L5;
        Lifecycle.State r5 = r4.getValue().mState;
    L7:
        if (this.mParentStates.isEmpty() == true) goto L10;
        ArrayList<Lifecycle.State> r1 = this.mParentStates;
        r0 = r1.get(r1.size() - 1);
    L10:
        return min(min(this.mState, r5), r0);
    L5:
        r5 = null;
        goto L7
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver r7) {
        enforceMainThreadIfNeeded("addObserver");
        if (this.mState != Lifecycle.State.DESTROYED) goto L5;
        Lifecycle.State r0 = Lifecycle.State.DESTROYED;
    L6:
        ObserverWithState r1 = new ObserverWithState(r7, r0);
        if (this.mObserverMap.putIfAbsent(r7, r1) == null) goto L9;
        return;
    L9:
        LifecycleOwner r2 = this.mLifecycleOwner.get();
        if (r2 != null) goto L13;
        return;
    L13:
        if (this.mAddingObserverCounter == 0) goto L15;
    L18:
        boolean r3 = true;
    L19:
        Lifecycle.State r4 = calculateTargetState(r7);
        this.mAddingObserverCounter++;
    L21:
        if (r1.mState.compareTo(r4) >= 0) goto L29;
        if (this.mObserverMap.contains(r7) == false) goto L29;
        pushParentState(r1.mState);
        Lifecycle.Event r5 = Lifecycle.Event.upFrom(r1.mState);
        if (r5 == null) goto L28;
        r1.dispatchEvent(r2, r5);
        popParentState();
        r4 = calculateTargetState(r7);
        goto L21
    L28:
        throw new IllegalStateException("no event up from " + r1.mState);
    L29:
        if (r3 == true) goto L31;
        sync();
    L31:
        this.mAddingObserverCounter--;
        return;
    L15:
        if (this.mHandlingEvent == true) goto L18;
        r3 = false;
        goto L19
    L5:
        r0 = Lifecycle.State.INITIALIZED;
        goto L6
    }

    private void popParentState() {
        ArrayList<Lifecycle.State> r1 = this.mParentStates;
        r1.remove(r1.size() - 1);
    }

    private void pushParentState(Lifecycle.State r1) {
        this.mParentStates.add(r1);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(LifecycleObserver r2) {
        enforceMainThreadIfNeeded("removeObserver");
        this.mObserverMap.remove(r2);
    }

    public int getObserverCount() {
        enforceMainThreadIfNeeded("getObserverCount");
        return this.mObserverMap.size();
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State getCurrentState() {
        return this.mState;
    }

    private void forwardPass(LifecycleOwner r6) {
        SafeIterableMap<LifecycleObserver, ObserverWithState>.IteratorWithAdditions r0 = this.mObserverMap.iteratorWithAdditions();
    L4:
        if (r0.hasNext() == false) goto L19;
        if (this.mNewEventOccurred == true) goto L27;
        Map.Entry r1 = r0.next();
        ObserverWithState r2 = (ObserverWithState) r1.getValue();
    L9:
        if (r2.mState.compareTo(this.mState) >= 0) goto L4;
        if (this.mNewEventOccurred == true) goto L4;
        if (this.mObserverMap.contains((LifecycleObserver) r1.getKey()) == false) goto L4;
        pushParentState(r2.mState);
        Lifecycle.Event r3 = Lifecycle.Event.upFrom(r2.mState);
        if (r3 == null) goto L18;
        r2.dispatchEvent(r6, r3);
        popParentState();
        goto L9
    L18:
        throw new IllegalStateException("no event up from " + r2.mState);
    L27:
        return;
    }

    private void backwardPass(LifecycleOwner r6) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> r0 = this.mObserverMap.descendingIterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        if (this.mNewEventOccurred == true) goto L27;
        Map.Entry<LifecycleObserver, ObserverWithState> r1 = r0.next();
        ObserverWithState r2 = r1.getValue();
    L9:
        if (r2.mState.compareTo(this.mState) <= 0) goto L4;
        if (this.mNewEventOccurred == true) goto L4;
        if (this.mObserverMap.contains(r1.getKey()) == false) goto L4;
        Lifecycle.Event r3 = Lifecycle.Event.downFrom(r2.mState);
        if (r3 == null) goto L18;
        pushParentState(r3.getTargetState());
        r2.dispatchEvent(r6, r3);
        popParentState();
        goto L9
    L18:
        throw new IllegalStateException("no event down from " + r2.mState);
    L27:
        return;
    }

    private void sync() {
        LifecycleOwner r0 = this.mLifecycleOwner.get();
        if (r0 == null) goto L18;
    L5:
        if (isSynced() == true) goto L15;
        this.mNewEventOccurred = false;
        if (this.mState.compareTo(this.mObserverMap.eldest().getValue().mState) >= 0) goto L9;
        backwardPass(r0);
    L9:
        Map.Entry<LifecycleObserver, ObserverWithState> r1 = this.mObserverMap.newest();
        if (this.mNewEventOccurred == true) goto L5;
        if (r1 == null) goto L5;
        if (this.mState.compareTo(r1.getValue().mState) <= 0) goto L5;
        forwardPass(r0);
        goto L5
    L15:
        this.mNewEventOccurred = false;
        return;
    L18:
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    private void enforceMainThreadIfNeeded(String r3) {
        if (this.mEnforceMainThread == true) goto L5;
        return;
    L5:
        if (ArchTaskExecutor.getInstance().isMainThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Method " + r3 + " must be called on the main thread");
    }

    public static LifecycleRegistry createUnsafe(LifecycleOwner r2) {
        return new LifecycleRegistry(r2, false);
    }

    static Lifecycle.State min(Lifecycle.State r1, Lifecycle.State r2) {
        if (r2 != null) goto L4;
        return r1;
    L4:
        if (r2.compareTo(r1) < 0) goto L6;
        return r1;
    L6:
        return r2;
    }
}
