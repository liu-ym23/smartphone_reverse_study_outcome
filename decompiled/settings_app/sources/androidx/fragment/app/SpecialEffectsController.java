package androidx.fragment.app;

import android.security.bytedance.guard.BDSecurityGuardStub;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpecialEffectsController.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000 *2\u00020\u0001:\u0003*+,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J#\u0010\u001a\u001a\u00020\u000f2\u0011\u0010\u001b\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\bH&J\u0006\u0010\u001f\u001a\u00020\u000fJ\u0012\u0010 \u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0006\u0010$\u001a\u00020\u000fJ\u0006\u0010%\u001a\u00020\u000fJ\u0010\u0010&\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010'\u001a\u00020\u000fJ\b\u0010(\u001a\u00020\u000fH\u0002J\u000e\u0010)\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController;", "", "container", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "getContainer", "()Landroid/view/ViewGroup;", "isContainerPostponed", "", "operationDirectionIsPop", "pendingOperations", "", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "runningOperations", "enqueue", "", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "lifecycleImpact", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "fragmentStateManager", "Landroidx/fragment/app/FragmentStateManager;", "enqueueAdd", "enqueueHide", "enqueueRemove", "enqueueShow", "executeOperations", "operations", "", "Lkotlin/jvm/JvmSuppressWildcards;", "isPop", "executePendingOperations", "findPendingOperation", "fragment", "Landroidx/fragment/app/Fragment;", "findRunningOperation", "forceCompleteAllOperations", "forcePostponedExecutePendingOperations", "getAwaitingCompletionLifecycleImpact", "markPostponedState", "updateFinalState", "updateOperationDirection", "Companion", "FragmentStateManagerOperation", "Operation", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class SpecialEffectsController {
    public static final Companion Companion = null;
    private final ViewGroup container;
    private boolean isContainerPostponed;
    private boolean operationDirectionIsPop;
    private final List<Operation> pendingOperations;
    private final List<Operation> runningOperations;

    /* JADX INFO: compiled from: SpecialEffectsController.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Companion;", "", "()V", "getOrCreateController", "Landroidx/fragment/app/SpecialEffectsController;", "container", "Landroid/view/ViewGroup;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "factory", "Landroidx/fragment/app/SpecialEffectsControllerFactory;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SpecialEffectsController getOrCreateController(ViewGroup r2, FragmentManager r3) {
            Intrinsics.checkNotNullParameter(r2, "container");
            Intrinsics.checkNotNullParameter(r3, "fragmentManager");
            SpecialEffectsControllerFactory r4 = r3.getSpecialEffectsControllerFactory();
            Intrinsics.checkNotNullExpressionValue(r4, "fragmentManager.specialEffectsControllerFactory");
            return getOrCreateController(r2, r4);
        }

        @JvmStatic
        public final SpecialEffectsController getOrCreateController(ViewGroup r2, SpecialEffectsControllerFactory r3) {
            Intrinsics.checkNotNullParameter(r2, "container");
            Intrinsics.checkNotNullParameter(r3, "factory");
            Object r1 = r2.getTag(R.id.special_effects_controller_view_tag);
            if ((r1 instanceof SpecialEffectsController) == true) goto L5;
            SpecialEffectsController r4 = r3.createController(r2);
            Intrinsics.checkNotNullExpressionValue(r4, "factory.createController(container)");
            r2.setTag(R.id.special_effects_controller_view_tag, r4);
            return r4;
        L5:
            return (SpecialEffectsController) r1;
        }
    }

    /* JADX INFO: compiled from: SpecialEffectsController.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$FragmentStateManagerOperation;", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "lifecycleImpact", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "fragmentStateManager", "Landroidx/fragment/app/FragmentStateManager;", "cancellationSignal", "Landroidx/core/os/CancellationSignal;", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;Landroidx/fragment/app/FragmentStateManager;Landroidx/core/os/CancellationSignal;)V", "complete", "", "onStart", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class FragmentStateManagerOperation extends Operation {
        private final FragmentStateManager fragmentStateManager;

        public FragmentStateManagerOperation(Operation.State r3, Operation.LifecycleImpact r4, FragmentStateManager r5, CancellationSignal r6) {
            Intrinsics.checkNotNullParameter(r3, "finalState");
            Intrinsics.checkNotNullParameter(r4, "lifecycleImpact");
            Intrinsics.checkNotNullParameter(r5, "fragmentStateManager");
            Intrinsics.checkNotNullParameter(r6, "cancellationSignal");
            Fragment r0 = r5.getFragment();
            Intrinsics.checkNotNullExpressionValue(r0, "fragmentStateManager.fragment");
            super(r3, r4, r0, r6);
            this.fragmentStateManager = r5;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void onStart() {
            if (getLifecycleImpact() != Operation.LifecycleImpact.ADDING) goto L22;
            Fragment r0 = this.fragmentStateManager.getFragment();
            Intrinsics.checkNotNullExpressionValue(r0, "fragmentStateManager.fragment");
            View r1 = r0.mView.findFocus();
            if (r1 == null) goto L9;
            r0.setFocusedView(r1);
            if (FragmentManager.isLoggingEnabled(2) == false) goto L9;
            Log.v(FragmentManager.TAG, "requestFocus: Saved focused view " + r1 + " for Fragment " + r0);
        L9:
            View r2 = getFragment().requireView();
            Intrinsics.checkNotNullExpressionValue(r2, "this.fragment.requireView()");
            if (r2.getParent() != null) goto L13;
            this.fragmentStateManager.addViewToContainer();
            r2.setAlpha(0.0f);
        L13:
            if (r2.getAlpha() != 0.0f) goto L15;
            boolean r6 = true;
        L16:
            if (r6 == true) goto L18;
        L20:
            r2.setAlpha(r0.getPostOnViewCreatedAlpha());
            return;
        L18:
            if (r2.getVisibility() != 0) goto L20;
            r2.setVisibility(4);
            goto L20
        L15:
            r6 = false;
            goto L16
        L22:
            if (getLifecycleImpact() != Operation.LifecycleImpact.REMOVING) goto L29;
            Fragment r7 = this.fragmentStateManager.getFragment();
            Intrinsics.checkNotNullExpressionValue(r7, "fragmentStateManager.fragment");
            View r3 = r7.requireView();
            Intrinsics.checkNotNullExpressionValue(r3, "fragment.requireView()");
            if (FragmentManager.isLoggingEnabled(2) == false) goto L26;
            Log.v(FragmentManager.TAG, "Clearing focus " + r3.findFocus() + " on view " + r3 + " for Fragment " + r7);
        L26:
            r3.clearFocus();
            return;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void complete() {
            super.complete();
            this.fragmentStateManager.moveToExpectedState();
        }
    }

    /* JADX INFO: compiled from: SpecialEffectsController.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001:\u0002+,B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\rJ\u0006\u0010\"\u001a\u00020 J\b\u0010#\u001a\u00020 H\u0017J\u000e\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\tJ\u000e\u0010&\u001a\u00020 2\u0006\u0010%\u001a\u00020\tJ\u0016\u0010'\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010(\u001a\u00020 H\u0016J\b\u0010)\u001a\u00020*H\u0016R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation;", "", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "lifecycleImpact", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "fragment", "Landroidx/fragment/app/Fragment;", "cancellationSignal", "Landroidx/core/os/CancellationSignal;", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;Landroidx/fragment/app/Fragment;Landroidx/core/os/CancellationSignal;)V", "completionListeners", "", "Ljava/lang/Runnable;", "getFinalState", "()Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "setFinalState", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "<set-?>", "", "isCanceled", "()Z", "isComplete", "getLifecycleImpact", "()Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "setLifecycleImpact", "(Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;)V", "specialEffectsSignals", "", "addCompletionListener", "", "listener", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "complete", "completeSpecialEffect", "signal", "markStartedSpecialEffect", "mergeWith", "onStart", "toString", "", "LifecycleImpact", "State", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class Operation {
        private final List<Runnable> completionListeners;
        private State finalState;
        private final Fragment fragment;
        private boolean isCanceled;
        private boolean isComplete;
        private LifecycleImpact lifecycleImpact;
        private final Set<CancellationSignal> specialEffectsSignals;

        /* JADX INFO: compiled from: SpecialEffectsController.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "", "(Ljava/lang/String;I)V", "NONE", "ADDING", "REMOVING", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final enum LifecycleImpact extends Enum<LifecycleImpact> {
            private static final /* synthetic */ LifecycleImpact[] $VALUES = null;
            public static final LifecycleImpact ADDING = null;
            public static final LifecycleImpact NONE = null;
            public static final LifecycleImpact REMOVING = null;

            private static final /* synthetic */ LifecycleImpact[] $values() {
                return new LifecycleImpact[]{NONE, ADDING, REMOVING};
            }

            public static LifecycleImpact valueOf(String r1) {
                return (LifecycleImpact) Enum.valueOf(LifecycleImpact.class, r1);
            }

            public static LifecycleImpact[] values() {
                return (LifecycleImpact[]) $VALUES.clone();
            }

            private LifecycleImpact(String r1, int r2) {
                super(r1, r2);
            }

            static {
                NONE = new LifecycleImpact("NONE", 0);
                ADDING = new LifecycleImpact("ADDING", 1);
                REMOVING = new LifecycleImpact("REMOVING", 2);
                $VALUES = $values();
            }
        }

        /* JADX INFO: compiled from: SpecialEffectsController.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "", "(Ljava/lang/String;I)V", "applyState", "", "view", "Landroid/view/View;", "REMOVED", "VISIBLE", "GONE", "INVISIBLE", "Companion", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final enum State extends Enum<State> {
            private static final /* synthetic */ State[] $VALUES = null;
            public static final Companion Companion = null;
            public static final State GONE = null;
            public static final State INVISIBLE = null;
            public static final State REMOVED = null;
            public static final State VISIBLE = null;

            /* JADX INFO: compiled from: SpecialEffectsController.kt */
            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\n\u0010\u0007\u001a\u00020\u0004*\u00020\b¨\u0006\t"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$State$Companion;", "", "()V", "from", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "visibility", "", "asOperationState", "Landroid/view/View;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                    this();
                }

                private Companion() {
                }

                public final State asOperationState(View r3) {
                    Intrinsics.checkNotNullParameter(r3, "<this>");
                    if (r3.getAlpha() != 0.0f) goto L5;
                    boolean r0 = true;
                L6:
                    if (r0 == false) goto L11;
                    if (r3.getVisibility() != 0) goto L11;
                    return State.INVISIBLE;
                L11:
                    return from(r3.getVisibility());
                L5:
                    r0 = false;
                    goto L6
                }

                @JvmStatic
                public final State from(int r3) {
                    if (r3 == 0) goto L12;
                    if (r3 == 4) goto L14;
                    if (r3 != 8) goto L9;
                    return State.GONE;
                L9:
                    throw new IllegalArgumentException("Unknown visibility " + r3);
                L14:
                    return State.INVISIBLE;
                L12:
                    return State.VISIBLE;
                }
            }

            /* JADX INFO: compiled from: SpecialEffectsController.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

                static {
                    int[] r0 = new int[State.values().length];
                    r0[State.REMOVED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
                L13:
                    r0[State.VISIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
                L19:
                    r0[State.GONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
                L15:
                    r0[State.INVISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
                L7:
                    $EnumSwitchMapping$0 = r0;
                }
            }

            private static final /* synthetic */ State[] $values() {
                return new State[]{REMOVED, VISIBLE, GONE, INVISIBLE};
            }

            @JvmStatic
            public static final State from(int r1) {
                return Companion.from(r1);
            }

            public static State valueOf(String r1) {
                return (State) Enum.valueOf(State.class, r1);
            }

            public static State[] values() {
                return (State[]) $VALUES.clone();
            }

            private State(String r1, int r2) {
                super(r1, r2);
            }

            static {
                REMOVED = new State("REMOVED", 0);
                VISIBLE = new State("VISIBLE", 1);
                GONE = new State("GONE", 2);
                INVISIBLE = new State("INVISIBLE", 3);
                $VALUES = $values();
                Companion = new Companion(null);
            }

            public final void applyState(View r5) {
                Intrinsics.checkNotNullParameter(r5, "view");
                int r4 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
                if (r4 != 1) goto L5;
                ViewParent r6 = r5.getParent();
                if ((r6 instanceof ViewGroup) == false) goto L26;
                ViewGroup r7 = (ViewGroup) r6;
            L27:
                if (r7 != null) goto L29;
                return;
            L29:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L31;
                Log.v(FragmentManager.TAG, "SpecialEffectsController: Removing view " + r5 + " from container " + r7);
            L31:
                r7.removeView(r5);
                return;
            L26:
                r7 = null;
                goto L27
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
                r5.setVisibility(8);
                return;
            L20:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L22;
                Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + r5 + " to VISIBLE");
            L22:
                r5.setVisibility(0);
            }
        }

        /* JADX INFO: compiled from: SpecialEffectsController.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[LifecycleImpact.values().length];
                r0[LifecycleImpact.ADDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[LifecycleImpact.REMOVING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[LifecycleImpact.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                $EnumSwitchMapping$0 = r0;
            }
        }

        public static /* synthetic */ void $r8$lambda$saLOZO_K6f8lTZt_eEfS1pkxLyc(Operation r0) {
            _init_$lambda$0(r0);
        }

        public void onStart() {
        }

        public Operation(State r2, LifecycleImpact r3, Fragment r4, CancellationSignal r5) {
            Intrinsics.checkNotNullParameter(r2, "finalState");
            Intrinsics.checkNotNullParameter(r3, "lifecycleImpact");
            Intrinsics.checkNotNullParameter(r4, "fragment");
            Intrinsics.checkNotNullParameter(r5, "cancellationSignal");
            this.finalState = r2;
            this.lifecycleImpact = r3;
            this.fragment = r4;
            this.completionListeners = new ArrayList();
            this.specialEffectsSignals = new LinkedHashSet();
            r5.setOnCancelListener(new SpecialEffectsController$Operation$$ExternalSyntheticLambda0(this));
        }

        public final State getFinalState() {
            return this.finalState;
        }

        public final void setFinalState(State r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.finalState = r2;
        }

        public final LifecycleImpact getLifecycleImpact() {
            return this.lifecycleImpact;
        }

        public final void setLifecycleImpact(LifecycleImpact r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.lifecycleImpact = r2;
        }

        public final Fragment getFragment() {
            return this.fragment;
        }

        public final boolean isCanceled() {
            return this.isCanceled;
        }

        public final boolean isComplete() {
            return this.isComplete;
        }

        private static final void _init_$lambda$0(Operation r1) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            r1.cancel();
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + this.finalState + " lifecycleImpact = " + this.lifecycleImpact + " fragment = " + this.fragment + '}';
        }

        public final void cancel() {
            if (this.isCanceled == false) goto L5;
            return;
        L5:
            this.isCanceled = true;
            if (this.specialEffectsSignals.isEmpty() == false) goto L8;
            complete();
            return;
        L8:
            Iterator r1 = CollectionsKt.toMutableSet(this.specialEffectsSignals).iterator();
        L10:
            if (r1.hasNext() == false) goto L14;
            ((CancellationSignal) r1.next()).cancel();
            goto L10
        }

        public final void mergeWith(State r6, LifecycleImpact r7) {
            Intrinsics.checkNotNullParameter(r6, "finalState");
            Intrinsics.checkNotNullParameter(r7, "lifecycleImpact");
            int r8 = WhenMappings.$EnumSwitchMapping$0[r7.ordinal()];
            if (r8 == 1) goto L20;
            if (r8 == 2) goto L16;
            if (r8 == 3) goto L10;
            return;
        L10:
            if (this.finalState != State.REMOVED) goto L12;
            return;
        L12:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L14;
            Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.fragment + " mFinalState = " + this.finalState + " -> " + r6 + '.');
        L14:
            this.finalState = r6;
            return;
        L16:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L18;
            Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.fragment + " mFinalState = " + this.finalState + " -> REMOVED. mLifecycleImpact  = " + this.lifecycleImpact + " to REMOVING.");
        L18:
            this.finalState = State.REMOVED;
            this.lifecycleImpact = LifecycleImpact.REMOVING;
            return;
        L20:
            if (this.finalState == State.REMOVED) goto L22;
            return;
        L22:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L24;
            Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.fragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.lifecycleImpact + " to ADDING.");
        L24:
            this.finalState = State.VISIBLE;
            this.lifecycleImpact = LifecycleImpact.ADDING;
        }

        public final void addCompletionListener(Runnable r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.completionListeners.add(r2);
        }

        public final void markStartedSpecialEffect(CancellationSignal r2) {
            Intrinsics.checkNotNullParameter(r2, "signal");
            onStart();
            this.specialEffectsSignals.add(r2);
        }

        public final void completeSpecialEffect(CancellationSignal r2) {
            Intrinsics.checkNotNullParameter(r2, "signal");
            if (this.specialEffectsSignals.remove(r2) == true) goto L5;
            return;
        L5:
            if (this.specialEffectsSignals.isEmpty() == false) goto L9;
            complete();
            return;
        }

        public void complete() {
            if (this.isComplete == false) goto L6;
            return;
        L6:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
            Log.v(FragmentManager.TAG, "SpecialEffectsController: " + this + " has called complete.");
        L8:
            this.isComplete = true;
            Iterator<T> r2 = this.completionListeners.iterator();
        L10:
            if (r2.hasNext() == false) goto L12;
            ((Runnable) r2.next()).run();
            goto L10
        }
    }

    /* JADX INFO: compiled from: SpecialEffectsController.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Operation.LifecycleImpact.values().length];
            r0[Operation.LifecycleImpact.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$HzA9s4aFoOsiJ_WkKfUvVoTfNJY(SpecialEffectsController r0, FragmentStateManagerOperation r1) {
        enqueue$lambda$4$lambda$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$PcxTk79tvtTaJMirbpJm6o9rlVo(SpecialEffectsController r0, FragmentStateManagerOperation r1) {
        enqueue$lambda$4$lambda$2(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final SpecialEffectsController getOrCreateController(ViewGroup r1, FragmentManager r2) {
        return Companion.getOrCreateController(r1, r2);
    }

    @JvmStatic
    public static final SpecialEffectsController getOrCreateController(ViewGroup r1, SpecialEffectsControllerFactory r2) {
        return Companion.getOrCreateController(r1, r2);
    }

    public abstract void executeOperations(List<Operation> r1, boolean r2);

    public SpecialEffectsController(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.container = r2;
        this.pendingOperations = new ArrayList();
        this.runningOperations = new ArrayList();
    }

    public final ViewGroup getContainer() {
        return this.container;
    }

    public final Operation.LifecycleImpact getAwaitingCompletionLifecycleImpact(FragmentStateManager r4) {
        Intrinsics.checkNotNullParameter(r4, "fragmentStateManager");
        Fragment r5 = r4.getFragment();
        Intrinsics.checkNotNullExpressionValue(r5, "fragmentStateManager.fragment");
        Operation r0 = findPendingOperation(r5);
        Operation.LifecycleImpact r1 = null;
        if (r0 == null) goto L5;
        Operation.LifecycleImpact r2 = r0.getLifecycleImpact();
    L6:
        Operation r3 = findRunningOperation(r5);
        if (r3 == null) goto L10;
        r1 = r3.getLifecycleImpact();
    L10:
        if (r2 != null) goto L12;
        int r6 = -1;
    L13:
        if (r6 == (-1)) goto L18;
        if (r6 == 1) goto L18;
        return r2;
    L18:
        return r1;
    L12:
        r6 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    private final Operation findPendingOperation(Fragment r4) {
        Iterator<T> r3 = this.pendingOperations.iterator();
    L4:
        if (r3.hasNext() == false) goto L13;
        Object r0 = r3.next();
        Operation r1 = (Operation) r0;
        if (Intrinsics.areEqual(r1.getFragment(), r4) == true) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L4;
    L15:
        return (Operation) r0;
    L8:
        if (r1.isCanceled() == true) goto L10;
        r2 = true;
        goto L11
    L13:
        r0 = null;
        goto L15
    }

    private final Operation findRunningOperation(Fragment r4) {
        Iterator<T> r3 = this.runningOperations.iterator();
    L4:
        if (r3.hasNext() == false) goto L13;
        Object r0 = r3.next();
        Operation r1 = (Operation) r0;
        if (Intrinsics.areEqual(r1.getFragment(), r4) == true) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L4;
    L15:
        return (Operation) r0;
    L8:
        if (r1.isCanceled() == true) goto L10;
        r2 = true;
        goto L11
    L13:
        r0 = null;
        goto L15
    }

    public final void enqueueAdd(Operation.State r3, FragmentStateManager r4) {
        Intrinsics.checkNotNullParameter(r3, "finalState");
        Intrinsics.checkNotNullParameter(r4, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing add operation for fragment " + r4.getFragment());
    L5:
        enqueue(r3, Operation.LifecycleImpact.ADDING, r4);
    }

    public final void enqueueShow(FragmentStateManager r3) {
        Intrinsics.checkNotNullParameter(r3, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing show operation for fragment " + r3.getFragment());
    L5:
        enqueue(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, r3);
    }

    public final void enqueueHide(FragmentStateManager r3) {
        Intrinsics.checkNotNullParameter(r3, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing hide operation for fragment " + r3.getFragment());
    L5:
        enqueue(Operation.State.GONE, Operation.LifecycleImpact.NONE, r3);
    }

    public final void enqueueRemove(FragmentStateManager r3) {
        Intrinsics.checkNotNullParameter(r3, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing remove operation for fragment " + r3.getFragment());
    L5:
        enqueue(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, r3);
    }

    private final void enqueue(Operation.State r5, Operation.LifecycleImpact r6, FragmentStateManager r7) {
        List<Operation> r0 = this.pendingOperations;
        monitor-enter(r0);
        CancellationSignal r1 = new CancellationSignal();     // Catch: Throwable -> L12
        Fragment r2 = r7.getFragment();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullExpressionValue(r2, "fragmentStateManager.fragment");     // Catch: Throwable -> L12
        Operation r3 = findPendingOperation(r2);     // Catch: Throwable -> L12
        if (r3 == null) goto L9;
        r3.mergeWith(r5, r6);     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L9:
        final FragmentStateManagerOperation r4 = new FragmentStateManagerOperation(r5, r6, r7, r1);     // Catch: Throwable -> L12
        this.pendingOperations.add(r4);     // Catch: Throwable -> L12
        r4.addCompletionListener(new SpecialEffectsController$$ExternalSyntheticLambda0(this, r4));     // Catch: Throwable -> L12
        r4.addCompletionListener(new SpecialEffectsController$$ExternalSyntheticLambda1(this, r4));     // Catch: Throwable -> L12
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private static final void enqueue$lambda$4$lambda$2(SpecialEffectsController r1, FragmentStateManagerOperation r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$operation");
        if (r1.pendingOperations.contains(r2) == false) goto L6;
        Operation.State r3 = r2.getFinalState();
        View r4 = r2.getFragment().mView;
        Intrinsics.checkNotNullExpressionValue(r4, "operation.fragment.mView");
        r3.applyState(r4);
        return;
    }

    private static final void enqueue$lambda$4$lambda$3(SpecialEffectsController r1, FragmentStateManagerOperation r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$operation");
        r1.pendingOperations.remove(r2);
        r1.runningOperations.remove(r2);
    }

    public final void updateOperationDirection(boolean r1) {
        this.operationDirectionIsPop = r1;
    }

    public final void markPostponedState() {
        List<Operation> r0 = this.pendingOperations;
        monitor-enter(r0);
        updateFinalState();     // Catch: Throwable -> L24
        List<Operation> r1 = this.pendingOperations;     // Catch: Throwable -> L24
        ListIterator<Operation> r2 = r1.listIterator(r1.size());     // Catch: Throwable -> L24
    L5:
        boolean r3 = false;
        Fragment r4 = null;
        if (r2.hasPrevious() == false) goto L15;
        Operation r5 = r2.previous();     // Catch: Throwable -> L24
        Operation r6 = r5;     // Catch: Throwable -> L24
        Operation.State.Companion r7 = Operation.State.Companion;     // Catch: Throwable -> L24
        View r8 = r6.getFragment().mView;     // Catch: Throwable -> L24
        Intrinsics.checkNotNullExpressionValue(r8, "operation.fragment.mView");     // Catch: Throwable -> L24
        Operation.State r9 = r7.asOperationState(r8);     // Catch: Throwable -> L24
        if (r6.getFinalState() == Operation.State.VISIBLE) goto L10;
    L12:
        boolean r10 = false;
    L13:
        if (r10 == false) goto L5;
    L16:
        Operation r11 = r5;     // Catch: Throwable -> L24
        if (r11 == null) goto L19;
        r4 = r11.getFragment();     // Catch: Throwable -> L24
    L19:
        if (r4 == null) goto L21;
        r3 = r4.isPostponed();     // Catch: Throwable -> L24
    L21:
        this.isContainerPostponed = r3;     // Catch: Throwable -> L24
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r0);
        return;
    L10:
        if (r9 == Operation.State.VISIBLE) goto L12;
        r10 = true;
        goto L13
    L15:
        r5 = null;
    L24:
        th = move-exception;
        throw th;
    }

    public final void forcePostponedExecutePendingOperations() {
        if (this.isContainerPostponed == true) goto L5;
        return;
    L5:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L7;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Forcing postponed operations");
    L7:
        this.isContainerPostponed = false;
        executePendingOperations();
    }

    public final void executePendingOperations() {
        if (this.isContainerPostponed == false) goto L6;
        return;
    L6:
        if (ViewCompat.isAttachedToWindow(this.container) == true) goto L9;
        forceCompleteAllOperations();
        this.operationDirectionIsPop = false;
        return;
    L9:
        List<Operation> r0 = this.pendingOperations;
        monitor-enter(r0);
    L35:
        th = move-exception;
        throw th;
    L12:
        if ((!this.pendingOperations.isEmpty()) == false) goto L32;
        List r2 = CollectionsKt.toMutableList(this.runningOperations);     // Catch: Throwable -> L35
        this.runningOperations.clear();     // Catch: Throwable -> L35
        Iterator r3 = r2.iterator();     // Catch: Throwable -> L35
    L15:
        if (r3.hasNext() == false) goto L22;
        Operation r4 = (Operation) r3.next();     // Catch: Throwable -> L35
        if (FragmentManager.isLoggingEnabled(2) == false) goto L19;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Cancelling operation " + r4);     // Catch: Throwable -> L35
    L19:
        r4.cancel();     // Catch: Throwable -> L35
        if (r4.isComplete() == true) goto L15;
        this.runningOperations.add(r4);     // Catch: Throwable -> L35
        goto L15
    L22:
        updateFinalState();     // Catch: Throwable -> L35
        List<Operation> r5 = CollectionsKt.toMutableList(this.pendingOperations);     // Catch: Throwable -> L35
        this.pendingOperations.clear();     // Catch: Throwable -> L35
        this.runningOperations.addAll(r5);     // Catch: Throwable -> L35
        if (FragmentManager.isLoggingEnabled(2) == false) goto L25;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Executing pending operations");     // Catch: Throwable -> L35
    L25:
        Iterator<Operation> r6 = r5.iterator();     // Catch: Throwable -> L35
    L27:
        if (r6.hasNext() == false) goto L29;
        r6.next().onStart();     // Catch: Throwable -> L35
        goto L27
    L29:
        executeOperations(r5, this.operationDirectionIsPop);     // Catch: Throwable -> L35
        this.operationDirectionIsPop = false;     // Catch: Throwable -> L35
        if (FragmentManager.isLoggingEnabled(2) == false) goto L32;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Finished executing pending operations");     // Catch: Throwable -> L35
    L32:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r0);
    }

    public final void forceCompleteAllOperations() {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Forcing all operations to complete");
    L5:
        boolean r1 = ViewCompat.isAttachedToWindow(this.container);
        List<Operation> r2 = this.pendingOperations;
        monitor-enter(r2);
        updateFinalState();     // Catch: Throwable -> L34
        Iterator<Operation> r3 = this.pendingOperations.iterator();     // Catch: Throwable -> L34
    L9:
        if (r3.hasNext() == false) goto L11;
        r3.next().onStart();     // Catch: Throwable -> L34
        goto L9
    L11:
        Iterator r4 = CollectionsKt.toMutableList(this.runningOperations).iterator();     // Catch: Throwable -> L34
    L13:
        if (r4.hasNext() == false) goto L21;
        Operation r5 = (Operation) r4.next();     // Catch: Throwable -> L34
        if (FragmentManager.isLoggingEnabled(2) == false) goto L20;
        if (r1 == false) goto L18;
        String r6 = "";
    L19:
        Log.v(FragmentManager.TAG, "SpecialEffectsController: " + r6 + "Cancelling running operation " + r5);     // Catch: Throwable -> L34
        goto L20
    L18:
        r6 = "Container " + this.container + " is not attached to window. ";     // Catch: Throwable -> L34
    L20:
        r5.cancel();     // Catch: Throwable -> L34
        goto L13
    L21:
        Iterator r7 = CollectionsKt.toMutableList(this.pendingOperations).iterator();     // Catch: Throwable -> L34
    L23:
        if (r7.hasNext() == false) goto L31;
        Operation r8 = (Operation) r7.next();     // Catch: Throwable -> L34
        if (FragmentManager.isLoggingEnabled(2) == false) goto L30;
        if (r1 == false) goto L28;
        String r9 = "";
    L29:
        Log.v(FragmentManager.TAG, "SpecialEffectsController: " + r9 + "Cancelling pending operation " + r8);     // Catch: Throwable -> L34
        goto L30
    L28:
        r9 = "Container " + this.container + " is not attached to window. ";     // Catch: Throwable -> L34
    L30:
        r8.cancel();     // Catch: Throwable -> L34
        goto L23
    L31:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(r2);
        return;
    L34:
        th = move-exception;
        throw th;
    }

    private final void updateFinalState() {
        Iterator<Operation> r3 = this.pendingOperations.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Operation r0 = r3.next();
        if (r0.getLifecycleImpact() != Operation.LifecycleImpact.ADDING) goto L4;
        View r1 = r0.getFragment().requireView();
        Intrinsics.checkNotNullExpressionValue(r1, "fragment.requireView()");
        r0.mergeWith(Operation.State.Companion.from(r1.getVisibility()), Operation.LifecycleImpact.NONE);
        goto L4
    }
}
