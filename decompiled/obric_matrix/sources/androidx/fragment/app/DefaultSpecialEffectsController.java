package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10, reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = null;

        static {
            int[] r0 = new int[SpecialEffectsController.Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = r0;
            r0[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private static class AnimationInfo extends SpecialEffectsInfo {

        @Nullable
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        AnimationInfo(@NonNull SpecialEffectsController.Operation r1, @NonNull CancellationSignal r2, boolean r3) {
            super(r1, r2);
            this.mLoadedAnim = false;
            this.mIsPop = r3;
        }

        @Nullable
        FragmentAnim.AnimationOrAnimator getAnimation(@NonNull Context r5) {
            if (this.mLoadedAnim == true) goto L5;
            Fragment r0 = getOperation().getFragment();
            if (getOperation().getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L9;
            boolean r1 = true;
        L10:
            FragmentAnim.AnimationOrAnimator r6 = FragmentAnim.loadAnimation(r5, r0, r1, this.mIsPop);
            this.mAnimation = r6;
            this.mLoadedAnim = true;
            return r6;
        L9:
            r1 = false;
            goto L10
        L5:
            return this.mAnimation;
        }
    }

    private static class SpecialEffectsInfo {

        @NonNull
        private final SpecialEffectsController.Operation mOperation;

        @NonNull
        private final CancellationSignal mSignal;

        SpecialEffectsInfo(@NonNull SpecialEffectsController.Operation r1, @NonNull CancellationSignal r2) {
            this.mOperation = r1;
            this.mSignal = r2;
        }

        void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        @NonNull
        SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        @NonNull
        CancellationSignal getSignal() {
            return this.mSignal;
        }

        boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State r0 = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State r2 = this.mOperation.getFinalState();
            if (r0 == r2) goto L9;
            SpecialEffectsController.Operation.State r1 = SpecialEffectsController.Operation.State.VISIBLE;
            if (r0 == r1) goto L8;
            if (r2 != r1) goto L9;
        L8:
            return false;
        L9:
            return true;
        }
    }

    private static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;

        @Nullable
        private final Object mSharedElementTransition;

        @Nullable
        private final Object mTransition;

        TransitionInfo(@NonNull SpecialEffectsController.Operation r2, @NonNull CancellationSignal r3, boolean r4, boolean r5) {
            super(r2, r3);
            if (r2.getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L12;
            Fragment r6 = r2.getFragment();
            if (r4 == false) goto L7;
            Object r7 = r6.getReenterTransition();
        L8:
            this.mTransition = r7;
            Fragment r8 = r2.getFragment();
            if (r4 == false) goto L11;
            boolean r9 = r8.getAllowReturnTransitionOverlap();
        L17:
            this.mOverlapAllowed = r9;
            if (r5 == false) goto L23;
            Fragment r10 = r2.getFragment();
            if (r4 == false) goto L22;
            Object r11 = r10.getSharedElementReturnTransition();
        L24:
            this.mSharedElementTransition = r11;
            return;
        L22:
            r11 = r10.getSharedElementEnterTransition();
            goto L24
        L23:
            r11 = null;
            goto L24
        L11:
            r9 = r8.getAllowEnterTransitionOverlap();
            goto L17
        L7:
            r7 = r6.getEnterTransition();
            goto L8
        L12:
            Fragment r12 = r2.getFragment();
            if (r4 == false) goto L15;
            Object r13 = r12.getReturnTransition();
        L16:
            this.mTransition = r13;
            r9 = true;
            goto L17
        L15:
            r13 = r12.getExitTransition();
            goto L16
        }

        @Nullable
        private FragmentTransitionImpl getHandlingImpl(Object r4) {
            if (r4 != null) goto L5;
            return null;
        L5:
            FragmentTransitionImpl r0 = FragmentTransition.PLATFORM_IMPL;
            if (r0 != null) goto L8;
        L10:
            FragmentTransitionImpl r1 = FragmentTransition.SUPPORT_IMPL;
            if (r1 == null) goto L16;
            if (r1.canHandle(r4) == false) goto L16;
            return r1;
        L16:
            throw new IllegalArgumentException("Transition " + r4 + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        L8:
            if (r0.canHandle(r4) == false) goto L10;
            return r0;
        }

        @Nullable
        FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl r0 = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl r1 = getHandlingImpl(this.mSharedElementTransition);
            if (r0 == null) goto L9;
            if (r1 == null) goto L9;
            if (r0 == r1) goto L9;
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        L9:
            if (r0 == null) goto L12;
            return r0;
        L12:
            return r1;
        }

        @Nullable
        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        @Nullable
        Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            if (this.mSharedElementTransition == null) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }
    }

    DefaultSpecialEffectsController(@NonNull ViewGroup r1) {
        super(r1);
    }

    private void startAnimations(@NonNull List<AnimationInfo> r21, @NonNull List<SpecialEffectsController.Operation> r22, boolean r23, @NonNull Map<SpecialEffectsController.Operation, Boolean> r24) {
        final ViewGroup r7 = getContainer();
        Context r8 = r7.getContext();
        ArrayList r9 = new ArrayList();
        Iterator<AnimationInfo> r10 = r21.iterator();
        boolean r6 = false;
    L3:
        int r15 = 2;
        if (r10.hasNext() == false) goto L33;
        final AnimationInfo r5 = r10.next();
        if (r5.isVisibilityUnchanged() == true) goto L7;
        FragmentAnim.AnimationOrAnimator r0 = r5.getAnimation(r8);
        if (r0 == null) goto L7;
        final Animator r4 = r0.animator;
        if (r4 == null) goto L14;
        final SpecialEffectsController.Operation r3 = r5.getOperation();
        Fragment r1 = r3.getFragment();
        if (Boolean.TRUE.equals(r24.get(r3)) == true) goto L18;
        if (r3.getFinalState() != SpecialEffectsController.Operation.State.GONE) goto L24;
        boolean r11 = true;
    L26:
        if (r11 == false) goto L28;
        r22.remove(r3);
    L28:
        final View r2 = r1.mView;
        r7.startViewTransition(r2);
        final boolean r12 = r11;
        r4.addListener(new AnonymousClass2(this, r7, r2, r12, r3, r5));
        r4.setTarget(r2);
        r4.start();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L31;
        StringBuilder r13 = new StringBuilder();
        r13.append("Animator from operation ");
        final SpecialEffectsController.Operation r14 = r3;
        r13.append(r14);
        r13.append(" has started.");
        Log.v(FragmentManager.TAG, r13.toString());
    L32:
        r5.getSignal().setOnCancelListener(new AnonymousClass3(this, r4, r14));
        r6 = true;
        goto L3
    L31:
        r14 = r3;
        goto L32
    L24:
        r11 = false;
        goto L26
    L18:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L20;
        Log.v(FragmentManager.TAG, "Ignoring Animator set on " + r1 + " as this Fragment was involved in a Transition.");
    L20:
        r5.completeSpecialEffect();
        goto L3
    L14:
        r9.add(r5);
    L7:
        r5.completeSpecialEffect();
        goto L3
    L33:
        Iterator r16 = r9.iterator();
    L35:
        if (r16.hasNext() == false) goto L54;
        final AnimationInfo r17 = (AnimationInfo) r16.next();
        final SpecialEffectsController.Operation r18 = r17.getOperation();
        Fragment r19 = r18.getFragment();
        if (r23 == true) goto L39;
        if (r6 == true) goto L45;
        final View r110 = r19.mView;
        Animation r20 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(r17.getAnimation(r8))).animation);
        if (r18.getFinalState() == SpecialEffectsController.Operation.State.REMOVED) goto L50;
        r110.startAnimation(r20);
        r17.completeSpecialEffect();
        boolean r111 = r6;
        int r25 = r15;
    L53:
        r17.getSignal().setOnCancelListener(new AnonymousClass5(this, r110, r7, r17, r18));
        r15 = r25;
        r6 = r111;
        goto L35
    L50:
        r7.startViewTransition(r110);
        FragmentAnim.EndViewTransitionAnimation r26 = new FragmentAnim.EndViewTransitionAnimation(r20, r7, r110);
        r111 = r6;
        r26.setAnimationListener(new AnonymousClass4(this, r18, r7, r110, r17));
        r110.startAnimation(r26);
        r25 = 2;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L53;
        Log.v(FragmentManager.TAG, "Animation from operation " + r18 + " has started.");
        goto L53
    L45:
        if (FragmentManager.isLoggingEnabled(r15) == true) goto L46;
    L42:
        r17.completeSpecialEffect();
        goto L35
    L46:
        StringBuilder r27 = new StringBuilder();
        r27.append("Ignoring Animation set on ");
        r27.append(r19);
        String r28 = " as Animations cannot run alongside Animators.";
    L41:
        r27.append(r28);
        Log.v(FragmentManager.TAG, r27.toString());
        goto L42
    L39:
        if (FragmentManager.isLoggingEnabled(r15) == false) goto L42;
        r27 = new StringBuilder();
        r27.append("Ignoring Animation set on ");
        r27.append(r19);
        r28 = " as Animations cannot run alongside Transitions.";
        goto L41
    }

    @NonNull
    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(@NonNull List<TransitionInfo> r33, @NonNull List<SpecialEffectsController.Operation> r34, final boolean r35, @Nullable final SpecialEffectsController.Operation r36, @Nullable final SpecialEffectsController.Operation r37) {
        SpecialEffectsController.Operation r8 = r36;
        SpecialEffectsController.Operation r9 = r37;
        Boolean r10 = Boolean.TRUE;
        Boolean r11 = Boolean.FALSE;
        HashMap r12 = new HashMap();
        Iterator<TransitionInfo> r0 = r33.iterator();
        final FragmentTransitionImpl r15 = null;
    L4:
        if (r0.hasNext() == false) goto L16;
        TransitionInfo r1 = r0.next();
        if (r1.isVisibilityUnchanged() == true) goto L4;
        FragmentTransitionImpl r2 = r1.getHandlingImpl();
        if (r15 == null) goto L10;
        if (r2 == null) goto L4;
        if (r15 == r2) goto L4;
        throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + r1.getOperation().getFragment() + " returned Transition " + r1.getTransition() + " which uses a different Transition  type than other Fragments.");
    L10:
        r15 = r2;
        goto L4
    L16:
        if (r15 != null) goto L22;
        Iterator<TransitionInfo> r3 = r33.iterator();
    L19:
        if (r3.hasNext() == false) goto L21;
        TransitionInfo r4 = r3.next();
        r12.put(r4.getOperation(), r11);
        r4.completeSpecialEffect();
        goto L19
    L21:
        return r12;
    L22:
        View r14 = new View(getContainer().getContext());
        Rect r5 = new Rect();
        ArrayList<View> r6 = new ArrayList();
        ArrayList<View> r7 = new ArrayList();
        ArrayMap r13 = new ArrayMap();
        Iterator<TransitionInfo> r22 = r33.iterator();
        Object r16 = null;
        View r17 = null;
        boolean r23 = false;
    L23:
        boolean r18 = r22.hasNext();
        View r25 = r17;
        String r19 = FragmentManager.TAG;
        if (r18 == false) goto L103;
        TransitionInfo r110 = r22.next();
        if (r110.hasSharedElementTransition() == false) goto L101;
        if (r8 == null) goto L101;
        if (r9 == null) goto L101;
        Object r20 = r15.wrapTransitionInSet(r15.cloneTransition(r110.getSharedElementTransition()));
        ArrayList<String> r111 = r37.getFragment().getSharedElementSourceNames();
        ArrayList<String> r21 = r36.getFragment().getSharedElementSourceNames();
        Rect r112 = r5;
        ArrayList<String> r24 = r36.getFragment().getSharedElementTargetNames();
        Boolean r27 = r10;
        Boolean r26 = r11;
        int r113 = 0;
    L31:
        if (r113 >= r24.size()) goto L36;
        int r114 = r111.indexOf(r24.get(r113));
        ArrayList<String> r115 = r24;
        if (r114 == (-1)) goto L35;
        r111.set(r114, r21.get(r113));
    L35:
        r113 = r113 + 1;
        r24 = r115;
        goto L31
    L36:
        ArrayList<String> r116 = r37.getFragment().getSharedElementTargetNames();
        Fragment r28 = r36.getFragment();
        if (r35 != 0) goto L39;
        SharedElementCallback r29 = r28.getExitTransitionCallback();
        SharedElementCallback r30 = r37.getFragment().getEnterTransitionCallback();
    L40:
        int r117 = r111.size();
        HashMap r210 = r12;
        int r118 = 0;
    L41:
        if (r118 >= r117) goto L43;
        r13.put(r111.get(r118), r116.get(r118));
        r118 = r118 + 1;
        r117 = r117;
        r14 = r14;
        goto L41
    L43:
        View r211 = r14;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L53;
        Log.v(FragmentManager.TAG, ">>> entering view names <<<");
        Iterator<String> r119 = r116.iterator();
    L47:
        if (r119.hasNext() == false) goto L49;
        Log.v(FragmentManager.TAG, "Name: " + r119.next());
        r119 = r119;
        goto L47
    L49:
        Log.v(FragmentManager.TAG, ">>> exiting view names <<<");
        Iterator<String> r120 = r111.iterator();
    L51:
        if (r120.hasNext() == false) goto L53;
        Log.v(FragmentManager.TAG, "Name: " + r120.next());
        r120 = r120;
    L53:
        ArrayMap<String, View> r121 = new ArrayMap();
        findNamedViews(r121, r36.getFragment().mView);
        r121.retainAll(r111);
        if (r29 != null) goto L56;
        r13.retainAll(r121.keySet());
    L68:
        final ArrayMap<String, View> r31 = new ArrayMap();
        findNamedViews(r31, r37.getFragment().mView);
        r31.retainAll(r116);
        r31.retainAll(r13.values());
        if (r30 != null) goto L71;
        FragmentTransition.retainValues(r13, r31);
    L87:
        retainMatchingViews(r121, r13.keySet());
        retainMatchingViews(r31, r13.values());
        if (r13.isEmpty() == false) goto L90;
        r6.clear();
        r7.clear();
        r8 = r36;
        ArrayList<View> r122 = r6;
        SpecialEffectsController.Operation r123 = r9;
        final Rect r32 = r112;
        View r38 = r211;
        r17 = r25;
        r10 = r27;
        HashMap r39 = r210;
        r16 = null;
    L102:
        r14 = r38;
        r15 = r15;
        r5 = r32;
        r6 = r122;
        r13 = r13;
        r12 = r39;
        r9 = r123;
        r11 = r26;
        goto L23
    L90:
        FragmentTransition.callSharedElementStartEnd(r37.getFragment(), r36.getFragment(), r35, r121, true);
        ArrayList<View> r310 = r7;
        r122 = r6;
        r32 = r112;
        OneShotPreDrawListener.add(getContainer(), new AnonymousClass6(this, r37, r36, r35, r31));
        r122.addAll(r121.values());
        if (r111.isEmpty() == true) goto L93;
        int r40 = 0;
        View r41 = r121.get(r111.get(0));
        Object r42 = r20;
        r15.setEpicenter(r42, r41);
        r17 = r41;
    L94:
        r7 = r310;
        r7.addAll(r31.values());
        if (r116.isEmpty() == true) goto L100;
        final View r43 = r31.get(r116.get(r40));
        if (r43 == null) goto L100;
        OneShotPreDrawListener.add(getContainer(), new AnonymousClass7(this, r15, r43, r32));
        r23 = true;
    L100:
        r15.setSharedElementTargets(r42, r211, r122);
        r38 = r211;
        r15.scheduleRemoveTargets(r42, null, null, null, null, r42, r7);
        r8 = r36;
        r10 = r27;
        r39 = r210;
        r39.put(r8, r10);
        r123 = r37;
        r39.put(r123, r10);
        r16 = r42;
        goto L102
    L93:
        r42 = r20;
        r40 = 0;
        r17 = r25;
        goto L94
    L71:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L73;
        Log.v(FragmentManager.TAG, "Executing enter callback for operation " + r9);
    L73:
        r30.onMapSharedElements(r116, r31);
        int r44 = r116.size() - 1;
    L74:
        if (r44 < 0) goto L87;
        String r45 = r116.get(r44);
        View r46 = r31.get(r45);
        if (r46 != null) goto L81;
        String r47 = FragmentTransition.findKeyForValue(r13, r45);
        if (r47 == null) goto L85;
        r13.remove(r47);
    L85:
        r44 = r44 - 1;
        goto L74
    L81:
        if (r45.equals(ViewCompat.getTransitionName(r46)) == true) goto L85;
        String r48 = FragmentTransition.findKeyForValue(r13, r45);
        if (r48 == null) goto L85;
        r13.put(r48, ViewCompat.getTransitionName(r46));
        goto L85
    L56:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L58;
        Log.v(FragmentManager.TAG, "Executing exit callback for operation " + r8);
    L58:
        r29.onMapSharedElements(r111, r121);
        int r49 = r111.size() - 1;
    L59:
        if (r49 < 0) goto L68;
        String r124 = r111.get(r49);
        View r125 = r121.get(r124);
        if (r125 != null) goto L64;
        r13.remove(r124);
    L66:
        r49 = r49 - 1;
        goto L59
    L64:
        if (r124.equals(ViewCompat.getTransitionName(r125)) == true) goto L66;
        r13.put(ViewCompat.getTransitionName(r125), (String) r13.remove(r124));
        goto L66
    L39:
        r29 = r28.getEnterTransitionCallback();
        r30 = r37.getFragment().getExitTransitionCallback();
    L101:
        r32 = r5;
        r26 = r11;
        r123 = r9;
        r39 = r12;
        r122 = r6;
        r38 = r14;
        r17 = r25;
        goto L102
    L103:
        ArrayMap r311 = r13;
        Rect r50 = r5;
        Boolean r212 = r11;
        FragmentTransitionImpl r51 = r15;
        SpecialEffectsController.Operation r126 = r9;
        HashMap r52 = r12;
        ArrayList<View> r127 = r6;
        View r53 = r14;
        ArrayList r54 = new ArrayList();
        Iterator<TransitionInfo> r128 = r33.iterator();
        Object r129 = null;
        Object r130 = null;
    L105:
        if (r128.hasNext() == false) goto L143;
        TransitionInfo r213 = r128.next();
        if (r213.isVisibilityUnchanged() == true) goto L108;
        String r214 = r19;
        Iterator<TransitionInfo> r312 = r128;
        Boolean r55 = r212;
        Object r131 = r51.cloneTransition(r213.getTransition());
        Boolean r215 = r10;
        SpecialEffectsController.Operation r132 = r213.getOperation();
        if (r16 == null) goto L114;
        if (r132 == r8) goto L113;
        if (r132 != r126) goto L114;
    L113:
        boolean r133 = true;
    L115:
        if (r131 != null) goto L119;
        if (r133 == true) goto L118;
        r52.put(r132, r55);
        r213.completeSpecialEffect();
    L118:
        View r216 = r53;
        ArrayList<View> r313 = r127;
        Object r56 = r129;
        View r57 = r25;
        Boolean r134 = r215;
    L142:
        r128 = r312;
        r25 = r57;
        r10 = r134;
        r19 = r214;
        r212 = r55;
        r127 = r313;
        r129 = r56;
        r53 = r216;
        goto L105
    L119:
        final ArrayList<View> r58 = new ArrayList();
        Object r135 = r129;
        captureTransitioningViews(r58, r132.getFragment().mView);
        if (r133 == false) goto L125;
        if (r132 != r8) goto L123;
        r58.removeAll(r127);
        goto L125
    L123:
        r58.removeAll(r7);
    L125:
        if (r58.isEmpty() == false) goto L127;
        r51.addTarget(r131, r53);
        r216 = r53;
        r313 = r127;
        Object r136 = r130;
        r56 = r135;
    L131:
        if (r132.getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L136;
        r54.addAll(r58);
        if (r23 == false) goto L135;
        r51.setEpicenter(r131, r50);
    L135:
        r57 = r25;
    L137:
        r134 = r215;
        r52.put(r132, r134);
        if (r213.isOverlapAllowed() == false) goto L140;
        r136 = r51.mergeTransitionsTogether(r136, r131, null);
    L141:
        r130 = r136;
        goto L142
    L140:
        r56 = r51.mergeTransitionsTogether(r56, r131, null);
        goto L141
    L136:
        r57 = r25;
        r51.setEpicenter(r131, r57);
        goto L137
    L127:
        r51.addTargets(r131, r58);
        r216 = r53;
        r56 = r135;
        r313 = r127;
        r136 = r130;
        r51.scheduleRemoveTargets(r131, r131, r58, null, null, null, null);
        if (r132.getFinalState() != SpecialEffectsController.Operation.State.GONE) goto L131;
        r34.remove(r132);
        ArrayList<View> r137 = new ArrayList(r58);
        r137.remove(r132.getFragment().mView);
        r51.scheduleHideFragmentView(r131, r132.getFragment().mView, r137);
        OneShotPreDrawListener.add(getContainer(), new AnonymousClass8(this, r58));
    L114:
        r133 = false;
        goto L115
    L108:
        r52.put(r213.getOperation(), r212);
        r213.completeSpecialEffect();
        r128 = r128;
        r19 = r19;
        goto L105
    L143:
        String r217 = r19;
        ArrayList<View> r314 = r127;
        Object r59 = r51.mergeTransitionsInSequence(r130, r129, r16);
        if (r59 != null) goto L146;
        return r52;
    L146:
        Iterator<TransitionInfo> r60 = r33.iterator();
    L148:
        if (r60.hasNext() == false) goto L171;
        final TransitionInfo r61 = r60.next();
        if (r61.isVisibilityUnchanged() == true) goto L148;
        Object r138 = r61.getTransition();
        final SpecialEffectsController.Operation r139 = r61.getOperation();
        if (r16 == null) goto L157;
        if (r139 == r8) goto L156;
        if (r139 != r126) goto L157;
    L156:
        boolean r140 = true;
    L158:
        if (r138 != null) goto L163;
        if (r140 == true) goto L163;
        String r141 = r217;
    L170:
        r217 = r141;
    L163:
        if (ViewCompat.isLaidOut(getContainer()) == false) goto L165;
        r141 = r217;
        r51.setListenerForTransitionEnd(r61.getOperation().getFragment(), r59, r61.getSignal(), new AnonymousClass9(this, r61, r139));
        goto L170
    L165:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L167;
        r141 = r217;
        Log.v(r141, "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + r139);
    L168:
        r61.completeSpecialEffect();
        goto L170
    L167:
        r141 = r217;
    L157:
        r140 = false;
        goto L158
    L171:
        String r142 = r217;
        if (ViewCompat.isLaidOut(getContainer()) == true) goto L174;
        return r52;
    L174:
        FragmentTransition.setViewVisibility(r54, 4);
        ArrayList<String> r62 = r51.prepareSetNameOverridesReordered(r7);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L184;
        Log.v(r142, ">>>>> Beginning transition <<<<<");
        Log.v(r142, ">>>>> SharedElementFirstOutViews <<<<<");
        Iterator<View> r63 = r314.iterator();
    L178:
        if (r63.hasNext() == false) goto L180;
        View r64 = r63.next();
        Log.v(r142, "View: " + r64 + " Name: " + ViewCompat.getTransitionName(r64));
        goto L178
    L180:
        Log.v(r142, ">>>>> SharedElementLastInViews <<<<<");
        Iterator<View> r65 = r7.iterator();
    L182:
        if (r65.hasNext() == false) goto L184;
        View r66 = r65.next();
        Log.v(r142, "View: " + r66 + " Name: " + ViewCompat.getTransitionName(r66));
    L184:
        r51.beginDelayedTransition(getContainer(), r59);
        r51.setNameOverridesReordered(getContainer(), r314, r7, r62, r311);
        FragmentTransition.setViewVisibility(r54, 0);
        r51.swapSharedElementTargets(r16, r314, r7);
        return r52;
    }

    private void syncAnimations(@NonNull List<SpecialEffectsController.Operation> r4) {
        Fragment r3 = r4.get(r4.size() - 1).getFragment();
        Iterator<SpecialEffectsController.Operation> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        SpecialEffectsController.Operation r0 = r5.next();
        r0.getFragment().mAnimationInfo.mEnterAnim = r3.mAnimationInfo.mEnterAnim;
        r0.getFragment().mAnimationInfo.mExitAnim = r3.mAnimationInfo.mExitAnim;
        r0.getFragment().mAnimationInfo.mPopEnterAnim = r3.mAnimationInfo.mPopEnterAnim;
        r0.getFragment().mAnimationInfo.mPopExitAnim = r3.mAnimationInfo.mPopExitAnim;
        goto L4
    }

    void applyContainerChanges(@NonNull SpecialEffectsController.Operation r1) {
        View r0 = r1.getFragment().mView;
        r1.getFinalState().applyState(r0);
    }

    void captureTransitioningViews(ArrayList<View> r5, View r6) {
        if ((r6 instanceof ViewGroup) == false) goto L16;
        ViewGroup r0 = (ViewGroup) r6;
        if (ViewGroupCompat.isTransitionGroup(r0) == true) goto L7;
        int r7 = r0.getChildCount();
        int r1 = 0;
    L10:
        if (r1 >= r7) goto L25;
        View r2 = r0.getChildAt(r1);
        if (r2.getVisibility() != 0) goto L14;
        captureTransitioningViews(r5, r2);
    L14:
        r1 = r1 + 1;
        goto L10
    L25:
        return;
    L7:
        if (r5.contains(r6) == true) goto L22;
        r5.add(r0);
        return;
    L22:
        return;
    L16:
        if (r5.contains(r6) == true) goto L24;
        r5.add(r6);
        return;
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    void executeOperations(@NonNull List<SpecialEffectsController.Operation> r14, boolean r15) {
        Iterator<SpecialEffectsController.Operation> r0 = r14.iterator();
        SpecialEffectsController.Operation r1 = null;
        SpecialEffectsController.Operation r8 = null;
    L4:
        if (r0.hasNext() == false) goto L21;
        SpecialEffectsController.Operation r2 = r0.next();
        SpecialEffectsController.Operation.State r4 = SpecialEffectsController.Operation.State.from(r2.getFragment().mView);
        int r5 = AnonymousClass10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[r2.getFinalState().ordinal()];
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L17;
        if (r5 == 3) goto L17;
        if (r5 != 4) goto L4;
        if (r4 == SpecialEffectsController.Operation.State.VISIBLE) goto L4;
        r8 = r2;
    L17:
        if (r4 != SpecialEffectsController.Operation.State.VISIBLE) goto L4;
        if (r1 != null) goto L4;
        r1 = r2;
        goto L4
    L21:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L23;
        Log.v(FragmentManager.TAG, "Executing operations from " + r1 + " to " + r8);
    L23:
        ArrayList r3 = new ArrayList();
        ArrayList r6 = new ArrayList();
        final ArrayList r12 = new ArrayList(r14);
        syncAnimations(r14);
        Iterator<SpecialEffectsController.Operation> r16 = r14.iterator();
    L25:
        if (r16.hasNext() == false) goto L33;
        final SpecialEffectsController.Operation r7 = r16.next();
        CancellationSignal r9 = new CancellationSignal();
        r7.markStartedSpecialEffect(r9);
        r3.add(new AnimationInfo(r7, r9, r15));
        CancellationSignal r10 = new CancellationSignal();
        r7.markStartedSpecialEffect(r10);
        boolean r11 = false;
        if (r15 == false) goto L30;
        if (r7 != r1) goto L32;
    L31:
        r11 = true;
    L32:
        r6.add(new TransitionInfo(r7, r10, r15, r11));
        r7.addCompletionListener(new AnonymousClass1(this, r12, r7));
        goto L25
    L30:
        if (r7 != r8) goto L32;
    L33:
        Map<SpecialEffectsController.Operation, Boolean> r17 = startTransitions(r6, r12, r15, r1, r8);
        startAnimations(r3, r12, r17.containsValue(Boolean.TRUE), r17);
        Iterator<SpecialEffectsController.Operation> r18 = r12.iterator();
    L35:
        if (r18.hasNext() == false) goto L37;
        applyContainerChanges(r18.next());
        goto L35
    L37:
        r12.clear();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L62;
        Log.v(FragmentManager.TAG, "Completed executing operations from " + r1 + " to " + r8);
        return;
    }

    void findNamedViews(Map<String, View> r5, @NonNull View r6) {
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
        findNamedViews(r5, r3);
    L12:
        r2 = r2 + 1;
        goto L8
    L17:
        return;
    }

    void retainMatchingViews(@NonNull ArrayMap<String, View> r1, @NonNull Collection<String> r2) {
        Iterator<Map.Entry<String, View>> r0 = r1.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r2.contains(ViewCompat.getTransitionName(r0.next().getValue())) == true) goto L4;
        r0.remove();
        goto L4
    }
}
