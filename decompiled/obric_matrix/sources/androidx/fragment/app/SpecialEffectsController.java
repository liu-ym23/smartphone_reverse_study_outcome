package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class SpecialEffectsController {
    private final ViewGroup mContainer;
    boolean mIsContainerPostponed;
    boolean mOperationDirectionIsPop;
    final ArrayList<Operation> mPendingOperations;
    final ArrayList<Operation> mRunningOperations;

    /* JADX INFO: renamed from: androidx.fragment.app.SpecialEffectsController$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact = null;
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = null;

        static {
            int[] r0 = new int[Operation.LifecycleImpact.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact = r0;
            r0[Operation.LifecycleImpact.ADDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[Operation.LifecycleImpact.REMOVING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L27:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[Operation.LifecycleImpact.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            int[] r3 = new int[Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = r3;
            r3[Operation.State.REMOVED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L33:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[Operation.State.VISIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L21:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[Operation.State.GONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L25:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[Operation.State.INVISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    private static class FragmentStateManagerOperation extends Operation {

        @NonNull
        private final FragmentStateManager mFragmentStateManager;

        FragmentStateManagerOperation(@NonNull Operation.State r2, @NonNull Operation.LifecycleImpact r3, @NonNull FragmentStateManager r4, @NonNull CancellationSignal r5) {
            super(r2, r3, r4.getFragment(), r5);
            this.mFragmentStateManager = r4;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void complete() {
            super.complete();
            this.mFragmentStateManager.moveToExpectedState();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        void onStart() {
            if (getLifecycleImpact() != Operation.LifecycleImpact.ADDING) goto L19;
            Fragment r0 = this.mFragmentStateManager.getFragment();
            View r1 = r0.mView.findFocus();
            if (r1 == null) goto L9;
            r0.setFocusedView(r1);
            if (FragmentManager.isLoggingEnabled(2) == false) goto L9;
            Log.v(FragmentManager.TAG, "requestFocus: Saved focused view " + r1 + " for Fragment " + r0);
        L9:
            View r2 = getFragment().requireView();
            if (r2.getParent() != null) goto L13;
            this.mFragmentStateManager.addViewToContainer();
            r2.setAlpha(0.0f);
        L13:
            if (r2.getAlpha() == 0.0f) goto L15;
        L17:
            r2.setAlpha(r0.getPostOnViewCreatedAlpha());
            return;
        L15:
            if (r2.getVisibility() != 0) goto L17;
            r2.setVisibility(4);
            goto L17
        L19:
            if (getLifecycleImpact() != Operation.LifecycleImpact.REMOVING) goto L26;
            Fragment r6 = this.mFragmentStateManager.getFragment();
            View r3 = r6.requireView();
            if (FragmentManager.isLoggingEnabled(2) == false) goto L23;
            Log.v(FragmentManager.TAG, "Clearing focus " + r3.findFocus() + " on view " + r3 + " for Fragment " + r6);
        L23:
            r3.clearFocus();
            return;
        }
    }

    static class Operation {

        @NonNull
        private final List<Runnable> mCompletionListeners;

        @NonNull
        private State mFinalState;

        @NonNull
        private final Fragment mFragment;
        private boolean mIsCanceled;
        private boolean mIsComplete;

        @NonNull
        private LifecycleImpact mLifecycleImpact;

        @NonNull
        private final HashSet<CancellationSignal> mSpecialEffectsSignals;

        static final enum LifecycleImpact extends Enum<LifecycleImpact> {
            private static final /* synthetic */ LifecycleImpact[] $VALUES = null;
            public static final LifecycleImpact ADDING = null;
            public static final LifecycleImpact NONE = null;
            public static final LifecycleImpact REMOVING = null;

            static {
                LifecycleImpact r0 = new LifecycleImpact("NONE", 0);
                NONE = r0;
                LifecycleImpact r1 = new LifecycleImpact("ADDING", 1);
                ADDING = r1;
                LifecycleImpact r3 = new LifecycleImpact("REMOVING", 2);
                REMOVING = r3;
                $VALUES = new LifecycleImpact[]{r0, r1, r3};
            }

            private LifecycleImpact(String r1, int r2) {
                super(r1, r2);
            }

            public static LifecycleImpact valueOf(String r1) {
                return (LifecycleImpact) Enum.valueOf(LifecycleImpact.class, r1);
            }

            public static LifecycleImpact[] values() {
                return (LifecycleImpact[]) $VALUES.clone();
            }
        }

        static final enum State extends Enum<State> {
            private static final /* synthetic */ State[] $VALUES = null;
            public static final State GONE = null;
            public static final State INVISIBLE = null;
            public static final State REMOVED = null;
            public static final State VISIBLE = null;

            static {
                State r0 = new State("REMOVED", 0);
                REMOVED = r0;
                State r1 = new State("VISIBLE", 1);
                VISIBLE = r1;
                State r3 = new State("GONE", 2);
                GONE = r3;
                State r5 = new State("INVISIBLE", 3);
                INVISIBLE = r5;
                $VALUES = new State[]{r0, r1, r3, r5};
            }

            private State(String r1, int r2) {
                super(r1, r2);
            }

            @NonNull
            static State from(int r3) {
                if (r3 == 0) goto L14;
                if (r3 == 4) goto L12;
                if (r3 != 8) goto L10;
                return GONE;
            L10:
                throw new IllegalArgumentException("Unknown visibility " + r3);
            L12:
                return INVISIBLE;
            L14:
                return VISIBLE;
            }

            @NonNull
            static State from(@NonNull View r2) {
                if (r2.getAlpha() != 0.0f) goto L9;
                if (r2.getVisibility() != 0) goto L9;
                return INVISIBLE;
            L9:
                return from(r2.getVisibility());
            }

            public static State valueOf(String r1) {
                return (State) Enum.valueOf(State.class, r1);
            }

            public static State[] values() {
                return (State[]) $VALUES.clone();
            }

            void applyState(@NonNull View r5) {
                int r4 = AnonymousClass3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[ordinal()];
                if (r4 != 1) goto L5;
                ViewGroup r6 = (ViewGroup) r5.getParent();
                if (r6 != null) goto L27;
                return;
            L27:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L29;
                Log.v(FragmentManager.TAG, "SpecialEffectsController: Removing view " + r5 + " from container " + r6);
            L29:
                r6.removeView(r5);
                return;
            L5:
                if (r4 == 2) goto L20;
                if (r4 == 3) goto L16;
                if (r4 == 4) goto L12;
                return;
            L12:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L14;
                Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + r5 + " to INVISIBLE");
            L14:
                r5.setVisibility(4);
                return;
            L16:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L18;
                Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + r5 + " to GONE");
            L18:
                int r7 = 8;
            L23:
                r5.setVisibility(r7);
                return;
            L20:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L22;
                Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + r5 + " to VISIBLE");
            L22:
                r7 = 0;
                goto L23
            }
        }

        Operation(@NonNull State r2, @NonNull LifecycleImpact r3, @NonNull Fragment r4, @NonNull CancellationSignal r5) {
            this.mCompletionListeners = new ArrayList();
            this.mSpecialEffectsSignals = new HashSet();
            this.mIsCanceled = false;
            this.mIsComplete = false;
            this.mFinalState = r2;
            this.mLifecycleImpact = r3;
            this.mFragment = r4;
            r5.setOnCancelListener(new AnonymousClass1(this));
        }

        final void addCompletionListener(@NonNull Runnable r1) {
            this.mCompletionListeners.add(r1);
        }

        final void cancel() {
            if (isCanceled() == false) goto L5;
            return;
        L5:
            this.mIsCanceled = true;
            if (this.mSpecialEffectsSignals.isEmpty() == false) goto L8;
            complete();
            return;
        L8:
            Iterator r1 = new ArrayList(this.mSpecialEffectsSignals).iterator();
        L10:
            if (r1.hasNext() == false) goto L14;
            ((CancellationSignal) r1.next()).cancel();
            goto L10
        }

        @CallSuper
        public void complete() {
            if (this.mIsComplete == false) goto L6;
            return;
        L6:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
            Log.v(FragmentManager.TAG, "SpecialEffectsController: " + this + " has called complete.");
        L8:
            this.mIsComplete = true;
            Iterator<Runnable> r2 = this.mCompletionListeners.iterator();
        L10:
            if (r2.hasNext() == false) goto L12;
            r2.next().run();
            goto L10
        }

        public final void completeSpecialEffect(@NonNull CancellationSignal r2) {
            if (this.mSpecialEffectsSignals.remove(r2) == true) goto L5;
            return;
        L5:
            if (this.mSpecialEffectsSignals.isEmpty() == false) goto L9;
            complete();
            return;
        }

        @NonNull
        public State getFinalState() {
            return this.mFinalState;
        }

        @NonNull
        public final Fragment getFragment() {
            return this.mFragment;
        }

        @NonNull
        LifecycleImpact getLifecycleImpact() {
            return this.mLifecycleImpact;
        }

        final boolean isCanceled() {
            return this.mIsCanceled;
        }

        final boolean isComplete() {
            return this.mIsComplete;
        }

        public final void markStartedSpecialEffect(@NonNull CancellationSignal r1) {
            onStart();
            this.mSpecialEffectsSignals.add(r1);
        }

        final void mergeWith(@NonNull State r6, @NonNull LifecycleImpact r7) {
            int r8 = AnonymousClass3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[r7.ordinal()];
            if (r8 == 1) goto L21;
            if (r8 == 2) goto L16;
            if (r8 == 3) goto L10;
            return;
        L10:
            if (this.mFinalState != State.REMOVED) goto L12;
            return;
        L12:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L14;
            Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.mFragment + " mFinalState = " + this.mFinalState + " -> " + r6 + ". ");
        L14:
            this.mFinalState = r6;
            return;
        L16:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L18;
            Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.mFragment + " mFinalState = " + this.mFinalState + " -> REMOVED. mLifecycleImpact  = " + this.mLifecycleImpact + " to REMOVING.");
        L18:
            this.mFinalState = State.REMOVED;
            LifecycleImpact r9 = LifecycleImpact.REMOVING;
        L19:
            this.mLifecycleImpact = r9;
            return;
        L21:
            if (this.mFinalState == State.REMOVED) goto L23;
            return;
        L23:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L25;
            Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.mFragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.mLifecycleImpact + " to ADDING.");
        L25:
            this.mFinalState = State.VISIBLE;
            r9 = LifecycleImpact.ADDING;
            goto L19
        }

        void onStart() {
        }

        @NonNull
        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.mFinalState + "} {mLifecycleImpact = " + this.mLifecycleImpact + "} {mFragment = " + this.mFragment + "}";
        }
    }

    SpecialEffectsController(@NonNull ViewGroup r2) {
        this.mPendingOperations = new ArrayList();
        this.mRunningOperations = new ArrayList();
        this.mOperationDirectionIsPop = false;
        this.mIsContainerPostponed = false;
        this.mContainer = r2;
    }

    private void enqueue(@NonNull Operation.State r4, @NonNull Operation.LifecycleImpact r5, @NonNull FragmentStateManager r6) {
        ArrayList<Operation> r0 = this.mPendingOperations;
        monitor-enter(r0);
        CancellationSignal r1 = new CancellationSignal();     // Catch: Throwable -> L12
        Operation r2 = findPendingOperation(r6.getFragment());     // Catch: Throwable -> L12
        if (r2 == null) goto L9;
        r2.mergeWith(r4, r5);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        final FragmentStateManagerOperation r3 = new FragmentStateManagerOperation(r4, r5, r6, r1);     // Catch: Throwable -> L12
        this.mPendingOperations.add(r3);     // Catch: Throwable -> L12
        r3.addCompletionListener(new AnonymousClass1(this, r3));     // Catch: Throwable -> L12
        r3.addCompletionListener(new AnonymousClass2(this, r3));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Nullable
    private Operation findPendingOperation(@NonNull Fragment r3) {
        Iterator<Operation> r2 = this.mPendingOperations.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        Operation r0 = r2.next();
        if (r0.getFragment().equals(r3) == false) goto L4;
        if (r0.isCanceled() == true) goto L4;
        return r0;
    L10:
        return null;
    }

    @Nullable
    private Operation findRunningOperation(@NonNull Fragment r3) {
        Iterator<Operation> r2 = this.mRunningOperations.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        Operation r0 = r2.next();
        if (r0.getFragment().equals(r3) == false) goto L4;
        if (r0.isCanceled() == true) goto L4;
        return r0;
    L10:
        return null;
    }

    @NonNull
    static SpecialEffectsController getOrCreateController(@NonNull ViewGroup r0, @NonNull FragmentManager r1) {
        return getOrCreateController(r0, r1.getSpecialEffectsControllerFactory());
    }

    @NonNull
    static SpecialEffectsController getOrCreateController(@NonNull ViewGroup r3, @NonNull SpecialEffectsControllerFactory r4) {
        int r0 = R.id.special_effects_controller_view_tag;
        Object r1 = r3.getTag(r0);
        if ((r1 instanceof SpecialEffectsController) == true) goto L5;
        SpecialEffectsController r5 = r4.createController(r3);
        r3.setTag(r0, r5);
        return r5;
    L5:
        return (SpecialEffectsController) r1;
    }

    private void updateFinalState() {
        Iterator<Operation> r3 = this.mPendingOperations.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Operation r0 = r3.next();
        if (r0.getLifecycleImpact() != Operation.LifecycleImpact.ADDING) goto L4;
        r0.mergeWith(Operation.State.from(r0.getFragment().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
        goto L4
    }

    void enqueueAdd(@NonNull Operation.State r3, @NonNull FragmentStateManager r4) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing add operation for fragment " + r4.getFragment());
    L5:
        enqueue(r3, Operation.LifecycleImpact.ADDING, r4);
    }

    void enqueueHide(@NonNull FragmentStateManager r3) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing hide operation for fragment " + r3.getFragment());
    L5:
        enqueue(Operation.State.GONE, Operation.LifecycleImpact.NONE, r3);
    }

    void enqueueRemove(@NonNull FragmentStateManager r3) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing remove operation for fragment " + r3.getFragment());
    L5:
        enqueue(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, r3);
    }

    void enqueueShow(@NonNull FragmentStateManager r3) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing show operation for fragment " + r3.getFragment());
    L5:
        enqueue(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, r3);
    }

    abstract void executeOperations(@NonNull List<Operation> r1, boolean r2);

    void executePendingOperations() {
        if (this.mIsContainerPostponed == false) goto L6;
        return;
    L6:
        if (ViewCompat.isAttachedToWindow(this.mContainer) == true) goto L9;
        forceCompleteAllOperations();
        this.mOperationDirectionIsPop = false;
        return;
    L9:
        ArrayList<Operation> r0 = this.mPendingOperations;
        monitor-enter(r0);
    L34:
        th = move-exception;
        throw th;
    L12:
        if (this.mPendingOperations.isEmpty() == true) goto L32;
        ArrayList r2 = new ArrayList(this.mRunningOperations);     // Catch: Throwable -> L34
        this.mRunningOperations.clear();     // Catch: Throwable -> L34
        Iterator r3 = r2.iterator();     // Catch: Throwable -> L34
    L15:
        if (r3.hasNext() == false) goto L22;
        Operation r4 = (Operation) r3.next();     // Catch: Throwable -> L34
        if (FragmentManager.isLoggingEnabled(2) == false) goto L19;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Cancelling operation " + r4);     // Catch: Throwable -> L34
    L19:
        r4.cancel();     // Catch: Throwable -> L34
        if (r4.isComplete() == true) goto L15;
        this.mRunningOperations.add(r4);     // Catch: Throwable -> L34
        goto L15
    L22:
        updateFinalState();     // Catch: Throwable -> L34
        ArrayList r5 = new ArrayList(this.mPendingOperations);     // Catch: Throwable -> L34
        this.mPendingOperations.clear();     // Catch: Throwable -> L34
        this.mRunningOperations.addAll(r5);     // Catch: Throwable -> L34
        if (FragmentManager.isLoggingEnabled(2) == false) goto L25;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Executing pending operations");     // Catch: Throwable -> L34
    L25:
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L34
    L27:
        if (r6.hasNext() == false) goto L29;
        ((Operation) r6.next()).onStart();     // Catch: Throwable -> L34
        goto L27
    L29:
        executeOperations(r5, this.mOperationDirectionIsPop);     // Catch: Throwable -> L34
        this.mOperationDirectionIsPop = false;     // Catch: Throwable -> L34
        if (FragmentManager.isLoggingEnabled(2) == false) goto L32;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Finished executing pending operations");     // Catch: Throwable -> L34
    L32:
        monitor-exit(r0);     // Catch: Throwable -> L34
    }

    void forceCompleteAllOperations() {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Forcing all operations to complete");
    L5:
        boolean r1 = ViewCompat.isAttachedToWindow(this.mContainer);
        ArrayList<Operation> r2 = this.mPendingOperations;
        monitor-enter(r2);
        updateFinalState();     // Catch: Throwable -> L35
        Iterator<Operation> r3 = this.mPendingOperations.iterator();     // Catch: Throwable -> L35
    L9:
        if (r3.hasNext() == false) goto L11;
        r3.next().onStart();     // Catch: Throwable -> L35
        goto L9
    L11:
        Iterator r4 = new ArrayList(this.mRunningOperations).iterator();     // Catch: Throwable -> L35
    L13:
        if (r4.hasNext() == false) goto L22;
        Operation r5 = (Operation) r4.next();     // Catch: Throwable -> L35
        if (FragmentManager.isLoggingEnabled(2) == false) goto L21;
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L35
        r6.append("SpecialEffectsController: ");     // Catch: Throwable -> L35
        if (r1 == false) goto L19;
        String r7 = "";
    L20:
        r6.append(r7);     // Catch: Throwable -> L35
        r6.append("Cancelling running operation ");     // Catch: Throwable -> L35
        r6.append(r5);     // Catch: Throwable -> L35
        Log.v(FragmentManager.TAG, r6.toString());     // Catch: Throwable -> L35
        goto L21
    L19:
        r7 = "Container " + this.mContainer + " is not attached to window. ";     // Catch: Throwable -> L35
    L21:
        r5.cancel();     // Catch: Throwable -> L35
        goto L13
    L22:
        Iterator r8 = new ArrayList(this.mPendingOperations).iterator();     // Catch: Throwable -> L35
    L24:
        if (r8.hasNext() == false) goto L33;
        Operation r9 = (Operation) r8.next();     // Catch: Throwable -> L35
        if (FragmentManager.isLoggingEnabled(2) == false) goto L32;
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L35
        r10.append("SpecialEffectsController: ");     // Catch: Throwable -> L35
        if (r1 == false) goto L30;
        String r11 = "";
    L31:
        r10.append(r11);     // Catch: Throwable -> L35
        r10.append("Cancelling pending operation ");     // Catch: Throwable -> L35
        r10.append(r9);     // Catch: Throwable -> L35
        Log.v(FragmentManager.TAG, r10.toString());     // Catch: Throwable -> L35
        goto L32
    L30:
        r11 = "Container " + this.mContainer + " is not attached to window. ";     // Catch: Throwable -> L35
    L32:
        r9.cancel();     // Catch: Throwable -> L35
        goto L24
    L33:
        monitor-exit(r2);     // Catch: Throwable -> L35
        return;
    L35:
        th = move-exception;
        throw th;
    }

    void forcePostponedExecutePendingOperations() {
        if (this.mIsContainerPostponed == true) goto L5;
        return;
    L5:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L7;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Forcing postponed operations");
    L7:
        this.mIsContainerPostponed = false;
        executePendingOperations();
    }

    @Nullable
    Operation.LifecycleImpact getAwaitingCompletionLifecycleImpact(@NonNull FragmentStateManager r2) {
        Operation r0 = findPendingOperation(r2.getFragment());
        if (r0 == null) goto L5;
        Operation.LifecycleImpact r1 = r0.getLifecycleImpact();
    L6:
        Operation r3 = findRunningOperation(r2.getFragment());
        if (r3 == null) goto L13;
        if (r1 == null) goto L12;
        if (r1 != Operation.LifecycleImpact.NONE) goto L13;
    L12:
        return r3.getLifecycleImpact();
    L13:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @NonNull
    public ViewGroup getContainer() {
        return this.mContainer;
    }

    void markPostponedState() {
        ArrayList<Operation> r0 = this.mPendingOperations;
        monitor-enter(r0);
        updateFinalState();     // Catch: Throwable -> L13
        this.mIsContainerPostponed = false;     // Catch: Throwable -> L13
        int r1 = this.mPendingOperations.size() - 1;     // Catch: Throwable -> L13
    L5:
        if (r1 < 0) goto L11;
        Operation r2 = this.mPendingOperations.get(r1);     // Catch: Throwable -> L13
        Operation.State r3 = Operation.State.from(r2.getFragment().mView);     // Catch: Throwable -> L13
        Operation.State r4 = r2.getFinalState();     // Catch: Throwable -> L13
        Operation.State r5 = Operation.State.VISIBLE;     // Catch: Throwable -> L13
        if (r4 != r5) goto L10;
        if (r3 == r5) goto L10;
        this.mIsContainerPostponed = r2.getFragment().isPostponed();     // Catch: Throwable -> L13
    L10:
        r1 = r1 - 1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    void updateOperationDirection(boolean r1) {
        this.mOperationDirectionIsPop = r1;
    }
}
