package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultSpecialEffectsController.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0003*+,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J(\u0010\t\u001a\u00020\u00062\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u001e\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\f0\u00162\u0006\u0010\u000e\u001a\u00020\fH\u0002J@\u0010\u0018\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\u0006\u0010\u001d\u001a\u00020\u00132\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u001fH\u0002JL\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010$\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010%\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0002J&\u0010&\u001a\u00020\u0006*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\f0'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170)H\u0002¨\u0006-"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController;", "Landroidx/fragment/app/SpecialEffectsController;", "container", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "applyContainerChanges", "", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "captureTransitioningViews", "transitioningViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "view", "executeOperations", "operations", "", "isPop", "", "findNamedViews", "namedViews", "", "", "startAnimations", "animationInfos", "Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "awaitingContainerChanges", "", "startedAnyTransition", "startedTransitions", "", "startTransitions", "transitionInfos", "Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "firstOut", "lastIn", "syncAnimations", "retainMatchingViews", "Landroidx/collection/ArrayMap;", "names", "", "AnimationInfo", "SpecialEffectsInfo", "TransitionInfo", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "signal", "Landroidx/core/os/CancellationSignal;", "isPop", "", "(Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/core/os/CancellationSignal;Z)V", "animation", "Landroidx/fragment/app/FragmentAnim$AnimationOrAnimator;", "isAnimLoaded", "getAnimation", "context", "Landroid/content/Context;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class AnimationInfo extends SpecialEffectsInfo {
        private FragmentAnim.AnimationOrAnimator animation;
        private boolean isAnimLoaded;
        private final boolean isPop;

        public AnimationInfo(SpecialEffectsController.Operation r2, CancellationSignal r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "operation");
            Intrinsics.checkNotNullParameter(r3, "signal");
            super(r2, r3);
            this.isPop = r4;
        }

        public final FragmentAnim.AnimationOrAnimator getAnimation(Context r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            if (this.isAnimLoaded == true) goto L11;
            Fragment r0 = getOperation().getFragment();
            if (getOperation().getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L8;
            boolean r1 = true;
        L9:
            FragmentAnim.AnimationOrAnimator r6 = FragmentAnim.loadAnimation(r5, r0, r1, this.isPop);
            this.animation = r6;
            this.isAnimLoaded = true;
            return r6;
        L8:
            r1 = false;
            goto L9
        L11:
            return this.animation;
        }
    }

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "signal", "Landroidx/core/os/CancellationSignal;", "(Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/core/os/CancellationSignal;)V", "isVisibilityUnchanged", "", "()Z", "getOperation", "()Landroidx/fragment/app/SpecialEffectsController$Operation;", "getSignal", "()Landroidx/core/os/CancellationSignal;", "completeSpecialEffect", "", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static class SpecialEffectsInfo {
        private final SpecialEffectsController.Operation operation;
        private final CancellationSignal signal;

        public SpecialEffectsInfo(SpecialEffectsController.Operation r2, CancellationSignal r3) {
            Intrinsics.checkNotNullParameter(r2, "operation");
            Intrinsics.checkNotNullParameter(r3, "signal");
            this.operation = r2;
            this.signal = r3;
        }

        public final SpecialEffectsController.Operation getOperation() {
            return this.operation;
        }

        public final CancellationSignal getSignal() {
            return this.signal;
        }

        public final boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State.Companion r0 = SpecialEffectsController.Operation.State.Companion;
            View r1 = this.operation.getFragment().mView;
            Intrinsics.checkNotNullExpressionValue(r1, "operation.fragment.mView");
            SpecialEffectsController.Operation.State r2 = r0.asOperationState(r1);
            SpecialEffectsController.Operation.State r3 = this.operation.getFinalState();
            if (r2 != r3) goto L5;
        L10:
            return true;
        L5:
            if (r2 != SpecialEffectsController.Operation.State.VISIBLE) goto L7;
        L9:
            return false;
        L7:
            if (r3 == SpecialEffectsController.Operation.State.VISIBLE) goto L9;
            goto L9
        }

        public final void completeSpecialEffect() {
            this.operation.completeSpecialEffect(this.signal);
        }
    }

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0002J\u0006\u0010\u0016\u001a\u00020\u0007R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0017"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "signal", "Landroidx/core/os/CancellationSignal;", "isPop", "", "providesSharedElementTransition", "(Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/core/os/CancellationSignal;ZZ)V", "handlingImpl", "Landroidx/fragment/app/FragmentTransitionImpl;", "getHandlingImpl", "()Landroidx/fragment/app/FragmentTransitionImpl;", "isOverlapAllowed", "()Z", "sharedElementTransition", "", "getSharedElementTransition", "()Ljava/lang/Object;", "transition", "getTransition", "hasSharedElementTransition", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class TransitionInfo extends SpecialEffectsInfo {
        private final boolean isOverlapAllowed;
        private final Object sharedElementTransition;
        private final Object transition;

        public TransitionInfo(SpecialEffectsController.Operation r2, CancellationSignal r3, boolean r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "operation");
            Intrinsics.checkNotNullParameter(r3, "signal");
            super(r2, r3);
            if (r2.getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L8;
            Fragment r6 = r2.getFragment();
            if (r4 == false) goto L7;
            Object r7 = r6.getReenterTransition();
        L12:
            this.transition = r7;
            if (r2.getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L17;
            if (r4 == false) goto L16;
            boolean r8 = r2.getFragment().getAllowReturnTransitionOverlap();
        L18:
            this.isOverlapAllowed = r8;
            if (r5 == false) goto L23;
            if (r4 == false) goto L22;
            Object r9 = r2.getFragment().getSharedElementReturnTransition();
        L24:
            this.sharedElementTransition = r9;
            return;
        L22:
            r9 = r2.getFragment().getSharedElementEnterTransition();
            goto L24
        L23:
            r9 = null;
            goto L24
        L16:
            r8 = r2.getFragment().getAllowEnterTransitionOverlap();
            goto L18
        L17:
            r8 = true;
            goto L18
        L7:
            r7 = r6.getEnterTransition();
            goto L12
        L8:
            Fragment r10 = r2.getFragment();
            if (r4 == false) goto L11;
            r7 = r10.getReturnTransition();
            goto L12
        L11:
            r7 = r10.getExitTransition();
            goto L12
        }

        public final Object getTransition() {
            return this.transition;
        }

        public final boolean isOverlapAllowed() {
            return this.isOverlapAllowed;
        }

        public final Object getSharedElementTransition() {
            return this.sharedElementTransition;
        }

        public final boolean hasSharedElementTransition() {
            if (this.sharedElementTransition == null) goto L5;
            return true;
        L5:
            return false;
        }

        public final FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl r0 = getHandlingImpl(this.transition);
            FragmentTransitionImpl r1 = getHandlingImpl(this.sharedElementTransition);
            if (r0 == null) goto L8;
            if (r1 == null) goto L8;
            if (r0 == r1) goto L8;
            boolean r2 = false;
        L9:
            if (r2 == false) goto L14;
            if (r0 == null) goto L12;
            return r0;
        L12:
            return r1;
        L14:
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.transition + " which uses a different Transition  type than its shared element transition " + this.sharedElementTransition).toString());
        L8:
            r2 = true;
            goto L9
        }

        private final FragmentTransitionImpl getHandlingImpl(Object r4) {
            if (r4 != null) goto L6;
            return null;
        L6:
            if (FragmentTransition.PLATFORM_IMPL == null) goto L12;
            if (FragmentTransition.PLATFORM_IMPL.canHandle(r4) == false) goto L12;
            return FragmentTransition.PLATFORM_IMPL;
        L12:
            if (FragmentTransition.SUPPORT_IMPL == null) goto L18;
            if (FragmentTransition.SUPPORT_IMPL.canHandle(r4) == false) goto L18;
            return FragmentTransition.SUPPORT_IMPL;
        L18:
            throw new IllegalArgumentException("Transition " + r4 + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$startAnimations$3, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultSpecialEffectsController.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"androidx/fragment/app/DefaultSpecialEffectsController$startAnimations$3", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass3 implements Animation.AnimationListener {
        final /* synthetic */ AnimationInfo $animationInfo;
        final /* synthetic */ SpecialEffectsController.Operation $operation;
        final /* synthetic */ View $viewToAnimate;
        final /* synthetic */ DefaultSpecialEffectsController this$0;

        public static /* synthetic */ void $r8$lambda$e4JYQPCwrudQZpKmEdhGp1_4AOE(DefaultSpecialEffectsController r0, View r1, AnimationInfo r2) {
            onAnimationEnd$lambda$0(r0, r1, r2);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r1) {
            Intrinsics.checkNotNullParameter(r1, "animation");
        }

        AnonymousClass3(SpecialEffectsController.Operation r1, DefaultSpecialEffectsController r2, View r3, AnimationInfo r4) {
            this.$operation = r1;
            this.this$0 = r2;
            this.$viewToAnimate = r3;
            this.$animationInfo = r4;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
            Log.v(FragmentManager.TAG, "Animation from operation " + this.$operation + " has reached onAnimationStart.");
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            ViewGroup r6 = this.this$0.getContainer();
            final DefaultSpecialEffectsController r0 = this.this$0;
            final View r1 = this.$viewToAnimate;
            final AnimationInfo r2 = this.$animationInfo;
            r6.post(new DefaultSpecialEffectsController$startAnimations$3$$ExternalSyntheticLambda0(r0, r1, r2));
            if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
            Log.v(FragmentManager.TAG, "Animation from operation " + this.$operation + " has ended.");
            return;
        }

        private static final void onAnimationEnd$lambda$0(DefaultSpecialEffectsController r1, View r2, AnimationInfo r3) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r3, "$animationInfo");
            r1.getContainer().endViewTransition(r2);
            r3.completeSpecialEffect();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-BPUgvtrXJop0NyBRYNNBI4cvGs, reason: not valid java name */
    public static /* synthetic */ void m43$r8$lambda$BPUgvtrXJop0NyBRYNNBI4cvGs(TransitionInfo r0, SpecialEffectsController.Operation r1) {
        startTransitions$lambda$14$lambda$13(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$80uanJcSks_q3pUzXhnQHPkjlsU(SpecialEffectsController.Operation r0, SpecialEffectsController.Operation r1, boolean r2, ArrayMap r3) {
        startTransitions$lambda$9(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$JqYMpb1_b3WxHwoSgflIvImy3IM(FragmentTransitionImpl r0, View r1, Rect r2) {
        startTransitions$lambda$10(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Q6FgD4jZH_jdeVxJxVn553yFXpk(List r0, SpecialEffectsController.Operation r1, DefaultSpecialEffectsController r2) {
        executeOperations$lambda$2(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$fUBM---k61isyKaNmMT0N0w8V00, reason: not valid java name */
    public static /* synthetic */ void m44$r8$lambda$fUBMk61isyKaNmMT0N0w8V00(ArrayList r0) {
        startTransitions$lambda$11(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$nBPnIVzE-IIkFDPl66EJ4I_Fbz0, reason: not valid java name */
    public static /* synthetic */ void m45$r8$lambda$nBPnIVzEIIkFDPl66EJ4I_Fbz0(Animator r0, SpecialEffectsController.Operation r1) {
        startAnimations$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$noXJE-4-p2U-P6k2CjIqAF2MXUI, reason: not valid java name */
    public static /* synthetic */ void m46$r8$lambda$noXJE4p2UP6k2CjIqAF2MXUI(View r0, DefaultSpecialEffectsController r1, AnimationInfo r2, SpecialEffectsController.Operation r3) {
        startAnimations$lambda$4(r0, r1, r2, r3);
    }

    public DefaultSpecialEffectsController(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        super(r2);
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    public void executeOperations(List<? extends SpecialEffectsController.Operation> r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r17, "operations");
        Iterator<T> r1 = r17.iterator();
    L3:
        SpecialEffectsController.Operation r5 = null;
        if (r1.hasNext() == false) goto L13;
        Object r2 = r1.next();
        SpecialEffectsController.Operation r9 = (SpecialEffectsController.Operation) r2;
        SpecialEffectsController.Operation.State.Companion r10 = SpecialEffectsController.Operation.State.Companion;
        View r11 = r9.getFragment().mView;
        Intrinsics.checkNotNullExpressionValue(r11, "operation.fragment.mView");
        if (r10.asOperationState(r11) == SpecialEffectsController.Operation.State.VISIBLE) goto L8;
    L10:
        boolean r12 = false;
    L11:
        if (r12 == false) goto L3;
    L14:
        SpecialEffectsController.Operation r13 = (SpecialEffectsController.Operation) r2;
        ListIterator<? extends SpecialEffectsController.Operation> r3 = r17.listIterator(r17.size());
    L16:
        if (r3.hasPrevious() == false) goto L25;
        SpecialEffectsController.Operation r4 = r3.previous();
        SpecialEffectsController.Operation r14 = r4;
        SpecialEffectsController.Operation.State.Companion r15 = SpecialEffectsController.Operation.State.Companion;
        View r16 = r14.getFragment().mView;
        Intrinsics.checkNotNullExpressionValue(r16, "operation.fragment.mView");
        if (r15.asOperationState(r16) != SpecialEffectsController.Operation.State.VISIBLE) goto L20;
    L22:
        boolean r19 = false;
    L23:
        if (r19 == false) goto L16;
        r5 = r4;
        goto L25
    L20:
        if (r14.getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L22;
        r19 = true;
    L25:
        SpecialEffectsController.Operation r110 = r5;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L28;
        Log.v(FragmentManager.TAG, "Executing operations from " + r13 + " to " + r110);
    L28:
        ArrayList r111 = new ArrayList();
        ArrayList r6 = new ArrayList();
        final List<SpecialEffectsController.Operation> r112 = CollectionsKt.toMutableList(r17);
        syncAnimations(r17);
        Iterator<? extends SpecialEffectsController.Operation> r0 = r17.iterator();
    L30:
        if (r0.hasNext() == false) goto L39;
        final SpecialEffectsController.Operation r7 = r0.next();
        CancellationSignal r8 = new CancellationSignal();
        r7.markStartedSpecialEffect(r8);
        r111.add(new AnimationInfo(r7, r8, r18));
        CancellationSignal r20 = new CancellationSignal();
        r7.markStartedSpecialEffect(r20);
        if (r18 == false) goto L35;
        if (r7 == r13) goto L36;
    L37:
        boolean r21 = false;
    L38:
        r6.add(new TransitionInfo(r7, r20, r18, r21));
        r7.addCompletionListener(new DefaultSpecialEffectsController$$ExternalSyntheticLambda0(r112, r7, this));
    L36:
        r21 = true;
        goto L38
    L35:
        if (r7 != r110) goto L37;
    L39:
        Map<SpecialEffectsController.Operation, Boolean> r22 = startTransitions(r6, r112, r18, r13, r110);
        startAnimations(r111, r112, r22.containsValue(true), r22);
        Iterator<SpecialEffectsController.Operation> r23 = r112.iterator();
    L41:
        if (r23.hasNext() == false) goto L43;
        applyContainerChanges(r23.next());
        goto L41
    L43:
        r112.clear();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L61;
        Log.v(FragmentManager.TAG, "Completed executing operations from " + r13 + " to " + r110);
        return;
    L61:
        return;
    L8:
        if (r9.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) goto L10;
        r12 = true;
        goto L11
    L13:
        r2 = null;
        goto L14
    }

    private static final void executeOperations$lambda$2(List r1, SpecialEffectsController.Operation r2, DefaultSpecialEffectsController r3) {
        Intrinsics.checkNotNullParameter(r1, "$awaitingContainerChanges");
        Intrinsics.checkNotNullParameter(r2, "$operation");
        Intrinsics.checkNotNullParameter(r3, "this$0");
        if (r1.contains(r2) == false) goto L6;
        r1.remove(r2);
        r3.applyContainerChanges(r2);
        return;
    }

    private final void syncAnimations(List<? extends SpecialEffectsController.Operation> r4) {
        Fragment r3 = ((SpecialEffectsController.Operation) CollectionsKt.last(r4)).getFragment();
        Iterator<? extends SpecialEffectsController.Operation> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        SpecialEffectsController.Operation r0 = r5.next();
        Fragment.AnimationInfo r1 = r0.getFragment().mAnimationInfo;
        r1.mEnterAnim = r3.mAnimationInfo.mEnterAnim;
        Fragment.AnimationInfo r2 = r0.getFragment().mAnimationInfo;
        r2.mExitAnim = r3.mAnimationInfo.mExitAnim;
        Fragment.AnimationInfo r6 = r0.getFragment().mAnimationInfo;
        r6.mPopEnterAnim = r3.mAnimationInfo.mPopEnterAnim;
        Fragment.AnimationInfo r7 = r0.getFragment().mAnimationInfo;
        r7.mPopExitAnim = r3.mAnimationInfo.mPopExitAnim;
        goto L4
    }

    private final void startAnimations(List<AnimationInfo> r19, List<SpecialEffectsController.Operation> r20, boolean r21, Map<SpecialEffectsController.Operation, Boolean> r22) {
        Context r7 = getContainer().getContext();
        ArrayList r8 = new ArrayList();
        Iterator<AnimationInfo> r9 = r19.iterator();
        boolean r0 = false;
    L4:
        if (r9.hasNext() == false) goto L32;
        final AnimationInfo r14 = r9.next();
        if (r14.isVisibilityUnchanged() == true) goto L7;
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        FragmentAnim.AnimationOrAnimator r1 = r14.getAnimation(r7);
        if (r1 == null) goto L11;
        final Animator r15 = r1.animator;
        if (r15 == null) goto L14;
        final SpecialEffectsController.Operation r5 = r14.getOperation();
        Fragment r2 = r5.getFragment();
        if (Intrinsics.areEqual(r22.get(r5), true) == true) goto L18;
        if (r5.getFinalState() != SpecialEffectsController.Operation.State.GONE) goto L24;
        final boolean r3 = true;
    L26:
        if (r3 == false) goto L28;
        r20.remove(r5);
    L28:
        final View r4 = r2.mView;
        getContainer().startViewTransition(r4);
        r15.addListener(new C01191(this, r4, r3, r5, r14));
        r15.setTarget(r4);
        r15.start();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L31;
        Log.v(FragmentManager.TAG, "Animator from operation " + r5 + " has started.");
    L31:
        r14.getSignal().setOnCancelListener(new DefaultSpecialEffectsController$$ExternalSyntheticLambda5(r15, r5));
        r0 = true;
        goto L4
    L24:
        r3 = false;
        goto L26
    L18:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L20;
        Log.v(FragmentManager.TAG, "Ignoring Animator set on " + r2 + " as this Fragment was involved in a Transition.");
    L20:
        r14.completeSpecialEffect();
        goto L4
    L14:
        r8.add(r14);
        goto L4
    L11:
        r14.completeSpecialEffect();
        goto L4
    L7:
        r14.completeSpecialEffect();
        goto L4
    L32:
        Iterator r6 = r8.iterator();
    L34:
        if (r6.hasNext() == false) goto L61;
        final AnimationInfo r10 = (AnimationInfo) r6.next();
        final SpecialEffectsController.Operation r11 = r10.getOperation();
        Fragment r12 = r11.getFragment();
        if (r21 == true) goto L38;
        if (r0 == true) goto L43;
        final View r13 = r12.mView;
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        FragmentAnim.AnimationOrAnimator r16 = r10.getAnimation(r7);
        if (r16 == null) goto L60;
        Animation r17 = r16.animation;
        if (r17 == null) goto L58;
        if (r11.getFinalState() == SpecialEffectsController.Operation.State.REMOVED) goto L53;
        r13.startAnimation(r17);
        r10.completeSpecialEffect();
    L56:
        r10.getSignal().setOnCancelListener(new DefaultSpecialEffectsController$$ExternalSyntheticLambda6(r13, this, r10, r11));
        goto L34
    L53:
        getContainer().startViewTransition(r13);
        FragmentAnim.EndViewTransitionAnimation r18 = new FragmentAnim.EndViewTransitionAnimation(r17, getContainer(), r13);
        r18.setAnimationListener(new AnonymousClass3(r11, this, r13, r10));
        r13.startAnimation(r18);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L56;
        Log.v(FragmentManager.TAG, "Animation from operation " + r11 + " has started.");
        goto L56
    L58:
        throw new IllegalStateException("Required value was null.".toString());
    L60:
        throw new IllegalStateException("Required value was null.".toString());
    L43:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L45;
        Log.v(FragmentManager.TAG, "Ignoring Animation set on " + r12 + " as Animations cannot run alongside Animators.");
    L45:
        r10.completeSpecialEffect();
        goto L34
    L38:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L40;
        Log.v(FragmentManager.TAG, "Ignoring Animation set on " + r12 + " as Animations cannot run alongside Transitions.");
    L40:
        r10.completeSpecialEffect();
        goto L34
    }

    private static final void startAnimations$lambda$3(Animator r1, SpecialEffectsController.Operation r2) {
        Intrinsics.checkNotNullParameter(r2, "$operation");
        r1.end();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
        Log.v(FragmentManager.TAG, "Animator from operation " + r2 + " has been canceled.");
        return;
    }

    private static final void startAnimations$lambda$4(View r1, DefaultSpecialEffectsController r2, AnimationInfo r3, SpecialEffectsController.Operation r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$animationInfo");
        Intrinsics.checkNotNullParameter(r4, "$operation");
        r1.clearAnimation();
        r2.getContainer().endViewTransition(r1);
        r3.completeSpecialEffect();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
        Log.v(FragmentManager.TAG, "Animation from operation " + r4 + " has been cancelled.");
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<SpecialEffectsController.Operation, Boolean> startTransitions(List<TransitionInfo> r34, List<SpecialEffectsController.Operation> r35, final boolean r36, final SpecialEffectsController.Operation r37, final SpecialEffectsController.Operation r38) {
        DefaultSpecialEffectsController r0 = this;
        LinkedHashMap r4 = new LinkedHashMap();
        List<TransitionInfo> r5 = r34;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Object r8 = r7.next();
        if (((TransitionInfo) r8).isVisibilityUnchanged() == true) goto L4;
        r6.add(r8);
        goto L4
    L8:
        ArrayList r9 = new ArrayList();
        Iterator r10 = r6.iterator();
    L10:
        if (r10.hasNext() == false) goto L17;
        Object r11 = r10.next();
        if (((TransitionInfo) r11).getHandlingImpl() == null) goto L14;
        boolean r12 = true;
    L15:
        if (r12 == false) goto L10;
        r9.add(r11);
        goto L10
    L14:
        r12 = false;
        goto L15
    L17:
        Iterator r13 = r9.iterator();
        FragmentTransitionImpl r14 = null;
    L19:
        if (r13.hasNext() == false) goto L30;
        TransitionInfo r15 = (TransitionInfo) r13.next();
        FragmentTransitionImpl r16 = r15.getHandlingImpl();
        if (r14 == null) goto L25;
        if (r16 == r14) goto L25;
        boolean r17 = false;
    L26:
        if (r17 == false) goto L29;
        r14 = r16;
        goto L19
    L29:
        throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + r15.getOperation().getFragment() + " returned Transition " + r15.getTransition() + " which uses a different Transition type than other Fragments.").toString());
    L25:
        r17 = true;
        goto L26
    L30:
        if (r14 != null) goto L36;
        Iterator<TransitionInfo> r1 = r34.iterator();
    L33:
        if (r1.hasNext() == false) goto L35;
        TransitionInfo r2 = r1.next();
        r4.put(r2.getOperation(), false);
        r2.completeSpecialEffect();
        goto L33
    L35:
        return r4;
    L36:
        View r18 = new View(getContainer().getContext());
        Rect r19 = new Rect();
        ArrayList<View> r110 = new ArrayList();
        ArrayList<View> r111 = new ArrayList();
        ArrayMap r112 = new ArrayMap();
        Iterator<TransitionInfo> r113 = r34.iterator();
        boolean r20 = false;
        View r21 = null;
    L37:
        Object r114 = null;
    L39:
        if (r113.hasNext() == false) goto L124;
        TransitionInfo r115 = r113.next();
        if (r115.hasSharedElementTransition() == false) goto L122;
        if (r37 == null) goto L122;
        if (r38 == null) goto L122;
        Object r116 = r14.wrapTransitionInSet(r14.cloneTransition(r115.getSharedElementTransition()));
        ArrayList<String> r22 = r38.getFragment().getSharedElementSourceNames();
        List<TransitionInfo> r23 = r5;
        Intrinsics.checkNotNullExpressionValue(r22, "lastIn.fragment.sharedElementSourceNames");
        ArrayList<String> r24 = r37.getFragment().getSharedElementSourceNames();
        View r25 = r21;
        Intrinsics.checkNotNullExpressionValue(r24, "firstOut.fragment.sharedElementSourceNames");
        ArrayList<String> r26 = r37.getFragment().getSharedElementTargetNames();
        LinkedHashMap r27 = r4;
        Intrinsics.checkNotNullExpressionValue(r26, "firstOut.fragment.sharedElementTargetNames");
        int r28 = r26.size();
        View r29 = r18;
        Rect r117 = r19;
        int r30 = 0;
    L46:
        if (r30 >= r28) goto L51;
        int r118 = r28;
        int r31 = r22.indexOf(r26.get(r30));
        if (r31 == (-1)) goto L50;
        r22.set(r31, r24.get(r30));
    L50:
        r30 = r30 + 1;
        r28 = r118;
        goto L46
    L51:
        ArrayList<String> r32 = r38.getFragment().getSharedElementTargetNames();
        Intrinsics.checkNotNullExpressionValue(r32, "lastIn.fragment.sharedElementTargetNames");
        if (r36 == true) goto L54;
        Pair r33 = TuplesKt.to(r37.getFragment().getExitTransitionCallback(), r38.getFragment().getEnterTransitionCallback());
    L55:
        SharedElementCallback r39 = (SharedElementCallback) r33.component1();
        SharedElementCallback r40 = (SharedElementCallback) r33.component2();
        int r41 = r22.size();
        int r119 = 0;
    L56:
        if (r119 >= r41) goto L58;
        int r210 = r41;
        FragmentTransitionImpl r211 = r14;
        r112.put(r22.get(r119), r32.get(r119));
        r119 = r119 + 1;
        r116 = r116;
        r41 = r210;
        r14 = r211;
        goto L56
    L58:
        FragmentTransitionImpl r212 = r14;
        Object r120 = r116;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L68;
        Log.v(FragmentManager.TAG, ">>> entering view names <<<");
        Iterator<String> r42 = r32.iterator();
    L62:
        if (r42.hasNext() == false) goto L64;
        Log.v(FragmentManager.TAG, "Name: " + r42.next());
        goto L62
    L64:
        Log.v(FragmentManager.TAG, ">>> exiting view names <<<");
        Iterator<String> r43 = r22.iterator();
    L66:
        if (r43.hasNext() == false) goto L68;
        Log.v(FragmentManager.TAG, "Name: " + r43.next());
    L68:
        ArrayMap<String, View> r44 = new ArrayMap();
        ArrayMap<String, View> r45 = r44;
        View r121 = r37.getFragment().mView;
        Intrinsics.checkNotNullExpressionValue(r121, "firstOut.fragment.mView");
        r0.findNamedViews(r45, r121);
        ArrayList<String> r122 = r22;
        r44.retainAll(r122);
        if (r39 != null) goto L71;
        r122 = r122;
        r112.retainAll(r44.keySet());
    L86:
        final ArrayMap<String, View> r46 = new ArrayMap();
        ArrayMap<String, View> r47 = r46;
        View r123 = r38.getFragment().mView;
        Intrinsics.checkNotNullExpressionValue(r123, "lastIn.fragment.mView");
        r0.findNamedViews(r47, r123);
        ArrayList<String> r124 = r32;
        r46.retainAll(r124);
        r46.retainAll(r112.values());
        if (r40 != null) goto L89;
        r124 = r124;
        FragmentTransition.retainValues(r112, r46);
    L108:
        Set r48 = r112.keySet();
        Intrinsics.checkNotNullExpressionValue(r48, "sharedElementNameMapping.keys");
        r0.retainMatchingViews(r44, r48);
        Collection<String> r49 = r112.values();
        Intrinsics.checkNotNullExpressionValue(r49, "sharedElementNameMapping.values");
        r0.retainMatchingViews(r46, r49);
        if (r112.isEmpty() == true) goto L110;
        FragmentTransition.callSharedElementStartEnd(r38.getFragment(), r37.getFragment(), r36, r44, true);
        OneShotPreDrawListener.add(getContainer(), new DefaultSpecialEffectsController$$ExternalSyntheticLambda1(r38, r37, r36, r46));
        r110.addAll(r44.values());
        if ((!r122.isEmpty()) == false) goto L114;
        View r50 = r44.get(r22.get(0));
        Object r51 = r120;
        final FragmentTransitionImpl r52 = r212;
        r52.setEpicenter(r51, r50);
        r25 = r50;
    L115:
        r111.addAll(r46.values());
        if ((!r124.isEmpty()) == false) goto L120;
        final View r53 = r46.get(r32.get(0));
        if (r53 == null) goto L120;
        final Rect r54 = r117;
        OneShotPreDrawListener.add(getContainer(), new DefaultSpecialEffectsController$$ExternalSyntheticLambda2(r52, r53, r54));
        r20 = true;
    L121:
        r52.setSharedElementTargets(r51, r29, r110);
        ArrayList<View> r125 = r111;
        Rect r55 = r54;
        r52.scheduleRemoveTargets(r51, null, null, null, null, r51, r125);
        LinkedHashMap r126 = r27;
        r126.put(r37, true);
        r126.put(r38, true);
        r110 = r110;
        r114 = r51;
        r111 = r125;
        r5 = r23;
        r112 = r112;
        r14 = r52;
        r21 = r25;
    L123:
        Rect r310 = r55;
        r18 = r29;
        r4 = r126;
        r19 = r310;
    L120:
        r54 = r117;
        goto L121
    L114:
        r51 = r120;
        r52 = r212;
        goto L115
    L110:
        r110.clear();
        r111.clear();
        r19 = r117;
        r5 = r23;
        r21 = r25;
        r4 = r27;
        r18 = r29;
        r14 = r212;
        goto L37
    L89:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L92;
        Log.v(FragmentManager.TAG, "Executing enter callback for operation " + r38);
    L92:
        r40.onMapSharedElements(r32, r47);
        int r56 = r32.size() - 1;
        if (r56 < 0) goto L108;
    L94:
        int r57 = r56 - 1;
        String r58 = r32.get(r56);
        View r127 = r46.get(r58);
        if (r127 != null) goto L100;
        Intrinsics.checkNotNullExpressionValue(r58, "name");
        String r59 = FragmentTransition.findKeyForValue(r112, r58);
        if (r59 == null) goto L104;
        r112.remove(r59);
    L104:
        if (r57 < 0) goto L108;
        r56 = r57;
        goto L94
    L100:
        if (Intrinsics.areEqual(r58, ViewCompat.getTransitionName(r127)) == true) goto L104;
        Intrinsics.checkNotNullExpressionValue(r58, "name");
        String r60 = FragmentTransition.findKeyForValue(r112, r58);
        if (r60 == null) goto L104;
        r112.put(r60, ViewCompat.getTransitionName(r127));
        goto L104
    L71:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L74;
        Log.v(FragmentManager.TAG, "Executing exit callback for operation " + r37);
    L74:
        r39.onMapSharedElements(r22, r45);
        int r61 = r22.size() - 1;
        if (r61 < 0) goto L86;
    L76:
        int r62 = r61 - 1;
        String r63 = r22.get(r61);
        View r128 = r44.get(r63);
        if (r128 != null) goto L80;
        r112.remove(r63);
    L82:
        if (r62 < 0) goto L86;
        r61 = r62;
        goto L76
    L80:
        if (Intrinsics.areEqual(r63, ViewCompat.getTransitionName(r128)) == true) goto L82;
        r112.put(ViewCompat.getTransitionName(r128), (String) r112.remove(r63));
        goto L82
    L54:
        r33 = TuplesKt.to(r37.getFragment().getEnterTransitionCallback(), r38.getFragment().getExitTransitionCallback());
    L122:
        Rect r311 = r19;
        r126 = r4;
        r29 = r18;
        r55 = r311;
        r110 = r110;
        r14 = r14;
        r111 = r111;
        r5 = r5;
        r21 = r21;
        r112 = r112;
        goto L123
    L124:
        List<TransitionInfo> r213 = r5;
        View r214 = r21;
        FragmentTransitionImpl r64 = r14;
        ArrayMap r215 = r112;
        ArrayList<View> r65 = r111;
        ArrayList<View> r66 = r110;
        Rect r312 = r19;
        LinkedHashMap r129 = r4;
        View r67 = r18;
        ArrayList r3 = new ArrayList();
        Iterator<TransitionInfo> r68 = r34.iterator();
        Object r130 = null;
        Object r131 = null;
    L126:
        if (r68.hasNext() == false) goto L164;
        TransitionInfo r132 = r68.next();
        if (r132.isVisibilityUnchanged() == true) goto L129;
        Iterator<TransitionInfo> r313 = r68;
        Object r69 = r64.cloneTransition(r132.getTransition());
        SpecialEffectsController.Operation r133 = r132.getOperation();
        if (r114 == null) goto L135;
        if (r133 == r37) goto L134;
        if (r133 != r38) goto L135;
    L134:
        boolean r134 = true;
    L136:
        if (r69 == null) goto L137;
        Object r135 = r114;
        ArrayList<View> r136 = new ArrayList();
        Object r314 = r130;
        View r137 = r133.getFragment().mView;
        Object r138 = r131;
        Intrinsics.checkNotNullExpressionValue(r137, "operation.fragment.mView");
        r0.captureTransitioningViews(r136, r137);
        if (r134 == false) goto L147;
        if (r133 != r37) goto L145;
        r136.removeAll(CollectionsKt.toSet(r66));
        goto L147
    L145:
        r136.removeAll(CollectionsKt.toSet(r65));
    L147:
        if (r136.isEmpty() == false) goto L149;
        r64.addTarget(r69, r67);
        Object r216 = r314;
        View r315 = r67;
        ArrayList<View> r316 = r66;
        final ArrayList<View> r139 = r136;
        LinkedHashMap r70 = r129;
        Object r71 = r135;
        Object r72 = r138;
    L154:
        if (r133.getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L159;
        r3.addAll(r139);
        if (r20 == false) goto L158;
        r64.setEpicenter(r69, r312);
    L158:
        View r140 = r214;
    L160:
        r70.put(r133, true);
        if (r132.isOverlapAllowed() == true) goto L162;
        r131 = r72;
        r114 = r71;
        r129 = r70;
        r214 = r140;
        r67 = r315;
        r66 = r316;
        r0 = this;
        r130 = r64.mergeTransitionsTogether(r216, r69, null);
        r68 = r313;
        goto L126
    L162:
        Object r73 = r64.mergeTransitionsTogether(r72, r69, null);
        r68 = r313;
        r131 = r73;
        r114 = r71;
        r129 = r70;
        r214 = r140;
        r130 = r216;
        r67 = r315;
        r66 = r316;
        r0 = this;
        goto L126
    L159:
        r140 = r214;
        r64.setEpicenter(r69, r140);
        goto L160
    L149:
        r64.addTargets(r69, r136);
        r216 = r314;
        r315 = r67;
        r71 = r135;
        r72 = r138;
        r316 = r66;
        r70 = r129;
        r64.scheduleRemoveTargets(r69, r69, r136, null, null, null, null);
        if (r133.getFinalState() != SpecialEffectsController.Operation.State.GONE) goto L152;
        r133 = r133;
        r35.remove(r133);
        r139 = r136;
        ArrayList<View> r141 = new ArrayList(r139);
        r141.remove(r133.getFragment().mView);
        r64.scheduleHideFragmentView(r69, r133.getFragment().mView, r141);
        OneShotPreDrawListener.add(getContainer(), new DefaultSpecialEffectsController$$ExternalSyntheticLambda3(r139));
        goto L154
    L152:
        r139 = r136;
        r133 = r133;
        goto L154
    L137:
        Object r142 = r114;
        if (r134 == true) goto L140;
        r129.put(r133, false);
        r132.completeSpecialEffect();
    L140:
        r68 = r313;
        r114 = r142;
    L135:
        r134 = false;
        goto L136
    L129:
        r313 = r68;
        r129.put(r132.getOperation(), false);
        r132.completeSpecialEffect();
        r142 = r114;
        goto L140
    L164:
        ArrayList<View> r317 = r66;
        Object r74 = r114;
        LinkedHashMap r75 = r129;
        Object r76 = r64.mergeTransitionsInSequence(r131, r130, r74);
        if (r76 != null) goto L167;
        return r75;
    L167:
        ArrayList r77 = new ArrayList();
        Iterator<T> r78 = r213.iterator();
    L169:
        if (r78.hasNext() == false) goto L173;
        Object r143 = r78.next();
        if (((TransitionInfo) r143).isVisibilityUnchanged() == true) goto L169;
        r77.add(r143);
        goto L169
    L173:
        Iterator r79 = r77.iterator();
    L175:
        if (r79.hasNext() == false) goto L192;
        final TransitionInfo r80 = (TransitionInfo) r79.next();
        Object r144 = r80.getTransition();
        final SpecialEffectsController.Operation r145 = r80.getOperation();
        if (r74 == null) goto L181;
        if (r145 == r37) goto L180;
        if (r145 != r38) goto L181;
    L180:
        boolean r146 = true;
    L182:
        if (r144 != null) goto L185;
        if (r146 == false) goto L175;
    L185:
        if (ViewCompat.isLaidOut(getContainer()) == false) goto L187;
        r64.setListenerForTransitionEnd(r80.getOperation().getFragment(), r76, r80.getSignal(), new DefaultSpecialEffectsController$$ExternalSyntheticLambda4(r80, r145));
        goto L175
    L187:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L189;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + r145);
    L189:
        r80.completeSpecialEffect();
    L181:
        r146 = false;
        goto L182
    L192:
        if (ViewCompat.isLaidOut(getContainer()) == true) goto L194;
        return r75;
    L194:
        ArrayList r81 = r3;
        FragmentTransition.setViewVisibility(r81, 4);
        ArrayList<String> r82 = r64.prepareSetNameOverridesReordered(r65);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L204;
        Log.v(FragmentManager.TAG, ">>>>> Beginning transition <<<<<");
        Log.v(FragmentManager.TAG, ">>>>> SharedElementFirstOutViews <<<<<");
        Iterator<View> r83 = r317.iterator();
    L198:
        if (r83.hasNext() == false) goto L200;
        View r84 = r83.next();
        Intrinsics.checkNotNullExpressionValue(r84, "sharedElementFirstOutViews");
        View r85 = r84;
        Log.v(FragmentManager.TAG, "View: " + r85 + " Name: " + ViewCompat.getTransitionName(r85));
        goto L198
    L200:
        Log.v(FragmentManager.TAG, ">>>>> SharedElementLastInViews <<<<<");
        Iterator<View> r86 = r65.iterator();
    L202:
        if (r86.hasNext() == false) goto L204;
        View r87 = r86.next();
        Intrinsics.checkNotNullExpressionValue(r87, "sharedElementLastInViews");
        View r88 = r87;
        Log.v(FragmentManager.TAG, "View: " + r88 + " Name: " + ViewCompat.getTransitionName(r88));
    L204:
        r64.beginDelayedTransition(getContainer(), r76);
        r64.setNameOverridesReordered(getContainer(), r317, r65, r82, r215);
        FragmentTransition.setViewVisibility(r81, 0);
        r64.swapSharedElementTargets(r74, r317, r65);
        return r75;
    }

    private static final void startTransitions$lambda$9(SpecialEffectsController.Operation r1, SpecialEffectsController.Operation r2, boolean r3, ArrayMap r4) {
        Intrinsics.checkNotNullParameter(r4, "$lastInViews");
        FragmentTransition.callSharedElementStartEnd(r1.getFragment(), r2.getFragment(), r3, r4, false);
    }

    private static final void startTransitions$lambda$10(FragmentTransitionImpl r1, View r2, Rect r3) {
        Intrinsics.checkNotNullParameter(r1, "$impl");
        Intrinsics.checkNotNullParameter(r3, "$lastInEpicenterRect");
        r1.getBoundsOnScreen(r2, r3);
    }

    private static final void startTransitions$lambda$11(ArrayList r1) {
        Intrinsics.checkNotNullParameter(r1, "$transitioningViews");
        FragmentTransition.setViewVisibility(r1, 4);
    }

    private static final void startTransitions$lambda$14$lambda$13(TransitionInfo r1, SpecialEffectsController.Operation r2) {
        Intrinsics.checkNotNullParameter(r1, "$transitionInfo");
        Intrinsics.checkNotNullParameter(r2, "$operation");
        r1.completeSpecialEffect();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
        Log.v(FragmentManager.TAG, "Transition for operation " + r2 + " has completed");
        return;
    }

    private final void retainMatchingViews(ArrayMap<String, View> r1, final Collection<String> r2) {
        Set<Map.Entry<String, View>> r0 = r1.entrySet();
        Intrinsics.checkNotNullExpressionValue(r0, "entries");
        CollectionsKt.retainAll(r0, new AnonymousClass1(r2));
    }

    private final void captureTransitioningViews(ArrayList<View> r5, View r6) {
        if ((r6 instanceof ViewGroup) == false) goto L16;
        ViewGroup r0 = (ViewGroup) r6;
        if (ViewGroupCompat.isTransitionGroup(r0) == true) goto L7;
        int r7 = r0.getChildCount();
        int r1 = 0;
    L10:
        if (r1 >= r7) goto L25;
        View r2 = r0.getChildAt(r1);
        if (r2.getVisibility() != 0) goto L14;
        Intrinsics.checkNotNullExpressionValue(r2, "child");
        captureTransitioningViews(r5, r2);
    L14:
        r1 = r1 + 1;
        goto L10
    L25:
        return;
    L7:
        if (r5.contains(r6) == true) goto L22;
        r5.add(r6);
        return;
    L22:
        return;
    L16:
        if (r5.contains(r6) == true) goto L24;
        r5.add(r6);
        return;
    }

    private final void findNamedViews(Map<String, View> r5, View r6) {
        String r0 = ViewCompat.getTransitionName(r6);
        if (r0 == null) goto L6;
        r5.put(r0, r6);
    L6:
        if ((r6 instanceof ViewGroup) == false) goto L13;
        ViewGroup r7 = (ViewGroup) r6;
        int r1 = r7.getChildCount();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L17;
        View r3 = r7.getChildAt(r2);
        if (r3.getVisibility() != 0) goto L12;
        Intrinsics.checkNotNullExpressionValue(r3, "child");
        findNamedViews(r5, r3);
    L12:
        r2 = r2 + 1;
        goto L8
    L17:
        return;
    }

    private final void applyContainerChanges(SpecialEffectsController.Operation r2) {
        View r1 = r2.getFragment().mView;
        SpecialEffectsController.Operation.State r3 = r2.getFinalState();
        Intrinsics.checkNotNullExpressionValue(r1, "view");
        r3.applyState(r1);
    }
}
