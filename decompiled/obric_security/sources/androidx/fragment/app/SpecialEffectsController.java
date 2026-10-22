package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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
        private final FragmentStateManager mFragmentStateManager;

        FragmentStateManagerOperation(Operation.State r2, Operation.LifecycleImpact r3, FragmentStateManager r4, CancellationSignal r5) {
            super(r2, r3, r4.getFragment(), r5);
            this.mFragmentStateManager = r4;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        void onStart() {
            if (getLifecycleImpact() != Operation.LifecycleImpact.ADDING) goto L19;
            Fragment r0 = this.mFragmentStateManager.getFragment();
            View r1 = r0.mView.findFocus();
            if (r1 == null) goto L9;
            r0.setFocusedView(r1);
            if (FragmentManager.isLoggingEnabled(2) == false) goto L9;
            Log.v("FragmentManager", "requestFocus: Saved focused view " + r1 + " for Fragment " + r0);
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
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void complete() {
            super.complete();
            this.mFragmentStateManager.moveToExpectedState();
        }
    }

    static class Operation {
        private final List<Runnable> mCompletionListeners;
        private State mFinalState;
        private final Fragment mFragment;
        private boolean mIsCanceled;
        private boolean mIsComplete;
        private LifecycleImpact mLifecycleImpact;
        private final HashSet<CancellationSignal> mSpecialEffectsSignals;

        static final enum LifecycleImpact extends Enum<LifecycleImpact> {
            private static final /* synthetic */ LifecycleImpact[] $VALUES = null;
            public static final LifecycleImpact ADDING = null;
            public static final LifecycleImpact NONE = null;
            public static final LifecycleImpact REMOVING = null;

            private LifecycleImpact(String r1, int r2) {
                super(r1, r2);
            }

            public static LifecycleImpact valueOf(String r1) {
                return (LifecycleImpact) Enum.valueOf(LifecycleImpact.class, r1);
            }

            public static LifecycleImpact[] values() {
                return (LifecycleImpact[]) $VALUES.clone();
            }

            static {
                LifecycleImpact r0 = new LifecycleImpact("NONE", 0);
                NONE = r0;
                LifecycleImpact r1 = new LifecycleImpact("ADDING", 1);
                ADDING = r1;
                LifecycleImpact r3 = new LifecycleImpact("REMOVING", 2);
                REMOVING = r3;
                $VALUES = new LifecycleImpact[]{r0, r1, r3};
            }
        }

        static final enum State extends Enum<State> {
            private static final /* synthetic */ State[] $VALUES = null;
            public static final State GONE = null;
            public static final State INVISIBLE = null;
            public static final State REMOVED = null;
            public static final State VISIBLE = null;

            private State(String r1, int r2) {
                super(r1, r2);
            }

            public static State valueOf(String r1) {
                return (State) Enum.valueOf(State.class, r1);
            }

            public static State[] values() {
                return (State[]) $VALUES.clone();
            }

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

            static State from(View r2) {
                if (r2.getAlpha() != 0.0f) goto L9;
                if (r2.getVisibility() != 0) goto L9;
                return INVISIBLE;
            L9:
                return from(r2.getVisibility());
            }

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

            void applyState(View r5) {
                int r4 = AnonymousClass3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[ordinal()];
                if (r4 != 1) goto L5;
                ViewGroup r6 = (ViewGroup) r5.getParent();
                if (r6 != null) goto L26;
                return;
            L26:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L28;
                Log.v("FragmentManager", "SpecialEffectsController: Removing view " + r5 + " from container " + r6);
            L28:
                r6.removeView(r5);
                return;
            L5:
                if (r4 == 2) goto L20;
                if (r4 == 3) goto L16;
                if (r4 == 4) goto L12;
                return;
            L12:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L14;
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + r5 + " to INVISIBLE");
            L14:
                r5.setVisibility(4);
                return;
            L16:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L18;
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + r5 + " to GONE");
            L18:
                r5.setVisibility(8);
                return;
            L20:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L22;
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + r5 + " to VISIBLE");
            L22:
                r5.setVisibility(0);
            }
        }

        void onStart() {
        }

        Operation(State r2, LifecycleImpact r3, Fragment r4, CancellationSignal r5) {
            this.mCompletionListeners = new ArrayList();
            this.mSpecialEffectsSignals = new HashSet();
            this.mIsCanceled = false;
            this.mIsComplete = false;
            this.mFinalState = r2;
            this.mLifecycleImpact = r3;
            this.mFragment = r4;
            r5.setOnCancelListener(new AnonymousClass1(this));
        }

        public State getFinalState() {
            return this.mFinalState;
        }

        LifecycleImpact getLifecycleImpact() {
            return this.mLifecycleImpact;
        }

        public final Fragment getFragment() {
            return this.mFragment;
        }

        final boolean isCanceled() {
            return this.mIsCanceled;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.mFinalState + "} {mLifecycleImpact = " + this.mLifecycleImpact + "} {mFragment = " + this.mFragment + "}";
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

        final void mergeWith(State r6, LifecycleImpact r7) {
            int r8 = AnonymousClass3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[r7.ordinal()];
            if (r8 == 1) goto L20;
            if (r8 == 2) goto L16;
            if (r8 == 3) goto L10;
            return;
        L10:
            if (this.mFinalState != State.REMOVED) goto L12;
            return;
        L12:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L14;
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.mFragment + " mFinalState = " + this.mFinalState + " -> " + r6 + ". ");
        L14:
            this.mFinalState = r6;
            return;
        L16:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L18;
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.mFragment + " mFinalState = " + this.mFinalState + " -> REMOVED. mLifecycleImpact  = " + this.mLifecycleImpact + " to REMOVING.");
        L18:
            this.mFinalState = State.REMOVED;
            this.mLifecycleImpact = LifecycleImpact.REMOVING;
            return;
        L20:
            if (this.mFinalState == State.REMOVED) goto L22;
            return;
        L22:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L24;
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.mFragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.mLifecycleImpact + " to ADDING.");
        L24:
            this.mFinalState = State.VISIBLE;
            this.mLifecycleImpact = LifecycleImpact.ADDING;
        }

        final void addCompletionListener(Runnable r1) {
            this.mCompletionListeners.add(r1);
        }

        public final void markStartedSpecialEffect(CancellationSignal r1) {
            onStart();
            this.mSpecialEffectsSignals.add(r1);
        }

        public final void completeSpecialEffect(CancellationSignal r2) {
            if (this.mSpecialEffectsSignals.remove(r2) == true) goto L5;
            return;
        L5:
            if (this.mSpecialEffectsSignals.isEmpty() == false) goto L9;
            complete();
            return;
        }

        final boolean isComplete() {
            return this.mIsComplete;
        }

        public void complete() {
            if (this.mIsComplete == false) goto L6;
            return;
        L6:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
            Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
        L8:
            this.mIsComplete = true;
            Iterator<Runnable> r2 = this.mCompletionListeners.iterator();
        L10:
            if (r2.hasNext() == false) goto L12;
            r2.next().run();
            goto L10
        }
    }

    abstract void executeOperations(List<Operation> r1, boolean r2);

    static SpecialEffectsController getOrCreateController(ViewGroup r0, FragmentManager r1) {
        return getOrCreateController(r0, r1.getSpecialEffectsControllerFactory());
    }

    static SpecialEffectsController getOrCreateController(ViewGroup r2, SpecialEffectsControllerFactory r3) {
        Object r0 = r2.getTag(R.id.special_effects_controller_view_tag);
        if ((r0 instanceof SpecialEffectsController) == true) goto L5;
        SpecialEffectsController r4 = r3.createController(r2);
        r2.setTag(R.id.special_effects_controller_view_tag, r4);
        return r4;
    L5:
        return (SpecialEffectsController) r0;
    }

    SpecialEffectsController(ViewGroup r2) {
        this.mPendingOperations = new ArrayList();
        this.mRunningOperations = new ArrayList();
        this.mOperationDirectionIsPop = false;
        this.mIsContainerPostponed = false;
        this.mContainer = r2;
    }

    public ViewGroup getContainer() {
        return this.mContainer;
    }

    Operation.LifecycleImpact getAwaitingCompletionLifecycleImpact(FragmentStateManager r2) {
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

    private Operation findPendingOperation(Fragment r3) {
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

    private Operation findRunningOperation(Fragment r3) {
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

    void enqueueAdd(Operation.State r3, FragmentStateManager r4) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + r4.getFragment());
    L5:
        enqueue(r3, Operation.LifecycleImpact.ADDING, r4);
    }

    void enqueueShow(FragmentStateManager r3) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + r3.getFragment());
    L5:
        enqueue(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, r3);
    }

    void enqueueHide(FragmentStateManager r3) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + r3.getFragment());
    L5:
        enqueue(Operation.State.GONE, Operation.LifecycleImpact.NONE, r3);
    }

    void enqueueRemove(FragmentStateManager r3) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + r3.getFragment());
    L5:
        enqueue(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, r3);
    }

    private void enqueue(Operation.State r4, Operation.LifecycleImpact r5, FragmentStateManager r6) {
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

    void updateOperationDirection(boolean r1) {
        this.mOperationDirectionIsPop = r1;
    }

    void markPostponedState() {
        ArrayList<Operation> r0 = this.mPendingOperations;
        monitor-enter(r0);
        updateFinalState();     // Catch: Throwable -> L14
        this.mIsContainerPostponed = false;     // Catch: Throwable -> L14
        int r1 = this.mPendingOperations.size() - 1;     // Catch: Throwable -> L14
    L5:
        if (r1 < 0) goto L12;
        Operation r2 = this.mPendingOperations.get(r1);     // Catch: Throwable -> L14
        Operation.State r3 = Operation.State.from(r2.getFragment().mView);     // Catch: Throwable -> L14
        if (r2.getFinalState() != Operation.State.VISIBLE) goto L11;
        if (r3 == Operation.State.VISIBLE) goto L11;
        this.mIsContainerPostponed = r2.getFragment().isPostponed();     // Catch: Throwable -> L14
    L11:
        r1 = r1 - 1;     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    void forcePostponedExecutePendingOperations() {
        if (this.mIsContainerPostponed == false) goto L6;
        this.mIsContainerPostponed = false;
        executePendingOperations();
        return;
    }

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
    L29:
        th = move-exception;
        throw th;
    L12:
        if (this.mPendingOperations.isEmpty() == true) goto L27;
        ArrayList r2 = new ArrayList(this.mRunningOperations);     // Catch: Throwable -> L29
        this.mRunningOperations.clear();     // Catch: Throwable -> L29
        Iterator r3 = r2.iterator();     // Catch: Throwable -> L29
    L15:
        if (r3.hasNext() == false) goto L22;
        Operation r4 = (Operation) r3.next();     // Catch: Throwable -> L29
        if (FragmentManager.isLoggingEnabled(2) == false) goto L19;
        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + r4);     // Catch: Throwable -> L29
    L19:
        r4.cancel();     // Catch: Throwable -> L29
        if (r4.isComplete() == true) goto L15;
        this.mRunningOperations.add(r4);     // Catch: Throwable -> L29
        goto L15
    L22:
        updateFinalState();     // Catch: Throwable -> L29
        ArrayList r5 = new ArrayList(this.mPendingOperations);     // Catch: Throwable -> L29
        this.mPendingOperations.clear();     // Catch: Throwable -> L29
        this.mRunningOperations.addAll(r5);     // Catch: Throwable -> L29
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L29
    L24:
        if (r6.hasNext() == false) goto L26;
        ((Operation) r6.next()).onStart();     // Catch: Throwable -> L29
        goto L24
    L26:
        executeOperations(r5, this.mOperationDirectionIsPop);     // Catch: Throwable -> L29
        this.mOperationDirectionIsPop = false;     // Catch: Throwable -> L29
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L29
    }

    void forceCompleteAllOperations() {
        boolean r0 = ViewCompat.isAttachedToWindow(this.mContainer);
        ArrayList<Operation> r1 = this.mPendingOperations;
        monitor-enter(r1);
        updateFinalState();     // Catch: Throwable -> L32
        Iterator<Operation> r2 = this.mPendingOperations.iterator();     // Catch: Throwable -> L32
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().onStart();     // Catch: Throwable -> L32
        goto L6
    L8:
        Iterator r3 = new ArrayList(this.mRunningOperations).iterator();     // Catch: Throwable -> L32
    L10:
        if (r3.hasNext() == false) goto L19;
        Operation r4 = (Operation) r3.next();     // Catch: Throwable -> L32
        if (FragmentManager.isLoggingEnabled(2) == false) goto L18;
        StringBuilder r5 = new StringBuilder().append("SpecialEffectsController: ");     // Catch: Throwable -> L32
        if (r0 == false) goto L16;
        String r6 = "";
    L17:
        Log.v("FragmentManager", r5.append(r6).append("Cancelling running operation ").append(r4).toString());     // Catch: Throwable -> L32
        goto L18
    L16:
        r6 = "Container " + this.mContainer + " is not attached to window. ";     // Catch: Throwable -> L32
    L18:
        r4.cancel();     // Catch: Throwable -> L32
        goto L10
    L19:
        Iterator r7 = new ArrayList(this.mPendingOperations).iterator();     // Catch: Throwable -> L32
    L21:
        if (r7.hasNext() == false) goto L30;
        Operation r8 = (Operation) r7.next();     // Catch: Throwable -> L32
        if (FragmentManager.isLoggingEnabled(2) == false) goto L29;
        StringBuilder r9 = new StringBuilder().append("SpecialEffectsController: ");     // Catch: Throwable -> L32
        if (r0 == false) goto L27;
        String r10 = "";
    L28:
        Log.v("FragmentManager", r9.append(r10).append("Cancelling pending operation ").append(r8).toString());     // Catch: Throwable -> L32
        goto L29
    L27:
        r10 = "Container " + this.mContainer + " is not attached to window. ";     // Catch: Throwable -> L32
    L29:
        r8.cancel();     // Catch: Throwable -> L32
        goto L21
    L30:
        monitor-exit(r1);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
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
}
