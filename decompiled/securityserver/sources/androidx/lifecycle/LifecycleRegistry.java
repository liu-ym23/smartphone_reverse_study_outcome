package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {
    private int mAddingObserverCounter;
    private boolean mHandlingEvent;
    private final WeakReference<LifecycleOwner> mLifecycleOwner;
    private boolean mNewEventOccurred;
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> mObserverMap;
    private ArrayList<Lifecycle.State> mParentStates;
    private Lifecycle.State mState;

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleRegistry$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event = null;
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State = null;

        static {
            int[] r0 = new int[Lifecycle.State.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = r0;
            r0[Lifecycle.State.INITIALIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L37:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.CREATED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L43:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.STARTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L55:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.RESUMED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L39:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.DESTROYED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L12:
            int[] r5 = new int[Lifecycle.Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = r5;
            r5[Lifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L45:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L53:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L35:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L47:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_RESUME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
        L49:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L31
        L33:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L32
            return;
        }
    }

    public static class ObserverWithState {
        LifecycleEventObserver mLifecycleObserver;
        Lifecycle.State mState;

        public ObserverWithState(LifecycleObserver r1, Lifecycle.State r2) {
            this.mLifecycleObserver = Lifecycling.lifecycleEventObserver(r1);
            this.mState = r2;
        }

        public void dispatchEvent(LifecycleOwner r3, Lifecycle.Event r4) {
            Lifecycle.State r0 = LifecycleRegistry.getStateAfter(r4);
            this.mState = LifecycleRegistry.min(this.mState, r0);
            this.mLifecycleObserver.onStateChanged(r3, r4);
            this.mState = r0;
        }
    }

    public LifecycleRegistry(@NonNull LifecycleOwner r2) {
        this.mObserverMap = new FastSafeIterableMap();
        this.mAddingObserverCounter = 0;
        this.mHandlingEvent = false;
        this.mNewEventOccurred = false;
        this.mParentStates = new ArrayList();
        this.mLifecycleOwner = new WeakReference(r2);
        this.mState = Lifecycle.State.INITIALIZED;
    }

    private void backwardPass(LifecycleOwner r6) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> r0 = this.mObserverMap.descendingIterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        if (this.mNewEventOccurred == true) goto L22;
        Map.Entry<LifecycleObserver, ObserverWithState> r1 = r0.next();
        ObserverWithState r2 = r1.getValue();
    L9:
        if (r2.mState.compareTo(this.mState) <= 0) goto L4;
        if (this.mNewEventOccurred == true) goto L4;
        if (this.mObserverMap.contains(r1.getKey()) == false) goto L4;
        Lifecycle.Event r3 = downEvent(r2.mState);
        pushParentState(getStateAfter(r3));
        r2.dispatchEvent(r6, r3);
        popParentState();
        goto L9
    L22:
        return;
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

    private static Lifecycle.Event downEvent(Lifecycle.State r3) {
        int r0 = AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[r3.ordinal()];
        if (r0 == 1) goto L23;
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L19;
        if (r0 == 4) goto L17;
        if (r0 == 5) goto L15;
        throw new IllegalArgumentException("Unexpected state value " + r3);
    L15:
        throw new IllegalArgumentException();
    L17:
        return Lifecycle.Event.ON_PAUSE;
    L19:
        return Lifecycle.Event.ON_STOP;
    L21:
        return Lifecycle.Event.ON_DESTROY;
    L23:
        throw new IllegalArgumentException();
    }

    private void forwardPass(LifecycleOwner r6) {
        SafeIterableMap<LifecycleObserver, ObserverWithState>.IteratorWithAdditions r0 = this.mObserverMap.iteratorWithAdditions();
    L4:
        if (r0.hasNext() == false) goto L15;
        if (this.mNewEventOccurred == true) goto L22;
        Map.Entry r1 = r0.next();
        ObserverWithState r2 = (ObserverWithState) r1.getValue();
    L9:
        if (r2.mState.compareTo(this.mState) >= 0) goto L4;
        if (this.mNewEventOccurred == true) goto L4;
        if (this.mObserverMap.contains((LifecycleObserver) r1.getKey()) == false) goto L4;
        pushParentState(r2.mState);
        r2.dispatchEvent(r6, upEvent(r2.mState));
        popParentState();
        goto L9
    L22:
        return;
    }

    public static Lifecycle.State getStateAfter(Lifecycle.Event r3) {
        switch(AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[r3.ordinal()]) {
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException("Unexpected event value " + r3);
    L7:
        return Lifecycle.State.DESTROYED;
    L9:
        return Lifecycle.State.RESUMED;
    L11:
        return Lifecycle.State.STARTED;
    L13:
        return Lifecycle.State.CREATED;
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

    public static Lifecycle.State min(@NonNull Lifecycle.State r1, @Nullable Lifecycle.State r2) {
        if (r2 != null) goto L4;
        return r1;
    L4:
        if (r2.compareTo(r1) < 0) goto L6;
        return r1;
    L6:
        return r2;
    }

    private void moveToState(Lifecycle.State r2) {
        if (this.mState != r2) goto L5;
        return;
    L5:
        this.mState = r2;
        if (this.mHandlingEvent == false) goto L8;
    L12:
        this.mNewEventOccurred = true;
        return;
    L8:
        if (this.mAddingObserverCounter != 0) goto L12;
        this.mHandlingEvent = true;
        sync();
        this.mHandlingEvent = false;
    }

    private void popParentState() {
        ArrayList<Lifecycle.State> r1 = this.mParentStates;
        r1.remove(r1.size() - 1);
    }

    private void pushParentState(Lifecycle.State r1) {
        this.mParentStates.add(r1);
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

    private static Lifecycle.Event upEvent(Lifecycle.State r3) {
        int r0 = AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[r3.ordinal()];
        if (r0 == 1) goto L22;
        if (r0 == 2) goto L20;
        if (r0 == 3) goto L18;
        if (r0 == 4) goto L16;
        if (r0 == 5) goto L22;
        throw new IllegalArgumentException("Unexpected state value " + r3);
    L16:
        throw new IllegalArgumentException();
    L18:
        return Lifecycle.Event.ON_RESUME;
    L20:
        return Lifecycle.Event.ON_START;
    L22:
        return Lifecycle.Event.ON_CREATE;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(@NonNull LifecycleObserver r7) {
        Lifecycle.State r0 = this.mState;
        Lifecycle.State r1 = Lifecycle.State.DESTROYED;
        if (r0 == r1) goto L6;
        r1 = Lifecycle.State.INITIALIZED;
    L6:
        ObserverWithState r2 = new ObserverWithState(r7, r1);
        if (this.mObserverMap.putIfAbsent(r7, r2) == null) goto L9;
        return;
    L9:
        LifecycleOwner r3 = this.mLifecycleOwner.get();
        if (r3 != null) goto L13;
        return;
    L13:
        if (this.mAddingObserverCounter == 0) goto L15;
    L18:
        boolean r4 = true;
    L19:
        Lifecycle.State r5 = calculateTargetState(r7);
        this.mAddingObserverCounter++;
    L21:
        if (r2.mState.compareTo(r5) >= 0) goto L25;
        if (this.mObserverMap.contains(r7) == false) goto L25;
        pushParentState(r2.mState);
        r2.dispatchEvent(r3, upEvent(r2.mState));
        popParentState();
        r5 = calculateTargetState(r7);
    L25:
        if (r4 == true) goto L27;
        sync();
    L27:
        this.mAddingObserverCounter--;
        return;
    L15:
        if (this.mHandlingEvent == true) goto L18;
        r4 = false;
        goto L19
    }

    @Override // androidx.lifecycle.Lifecycle
    @NonNull
    public Lifecycle.State getCurrentState() {
        return this.mState;
    }

    public int getObserverCount() {
        return this.mObserverMap.size();
    }

    public void handleLifecycleEvent(@NonNull Lifecycle.Event r1) {
        moveToState(getStateAfter(r1));
    }

    @MainThread
    @Deprecated
    public void markState(@NonNull Lifecycle.State r1) {
        setCurrentState(r1);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(@NonNull LifecycleObserver r1) {
        this.mObserverMap.remove(r1);
    }

    @MainThread
    public void setCurrentState(@NonNull Lifecycle.State r1) {
        moveToState(r1);
    }
}
