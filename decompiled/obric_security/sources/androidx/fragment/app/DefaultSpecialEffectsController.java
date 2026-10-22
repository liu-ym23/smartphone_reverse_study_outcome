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
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        AnimationInfo(SpecialEffectsController.Operation r1, CancellationSignal r2, boolean r3) {
            super(r1, r2);
            this.mLoadedAnim = false;
            this.mIsPop = r3;
        }

        FragmentAnim.AnimationOrAnimator getAnimation(Context r5) {
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
        private final SpecialEffectsController.Operation mOperation;
        private final CancellationSignal mSignal;

        SpecialEffectsInfo(SpecialEffectsController.Operation r1, CancellationSignal r2) {
            this.mOperation = r1;
            this.mSignal = r2;
        }

        SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        CancellationSignal getSignal() {
            return this.mSignal;
        }

        boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State r0 = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State r2 = this.mOperation.getFinalState();
            if (r0 != r2) goto L5;
        L10:
            return true;
        L5:
            if (r0 != SpecialEffectsController.Operation.State.VISIBLE) goto L7;
        L9:
            return false;
        L7:
            if (r2 == SpecialEffectsController.Operation.State.VISIBLE) goto L9;
            goto L9
        }

        void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }
    }

    private static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;
        private final Object mSharedElementTransition;
        private final Object mTransition;

        TransitionInfo(SpecialEffectsController.Operation r2, CancellationSignal r3, boolean r4, boolean r5) {
            super(r2, r3);
            if (r2.getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L12;
            if (r4 == false) goto L6;
            Object r6 = r2.getFragment().getReenterTransition();
        L7:
            this.mTransition = r6;
            if (r4 == false) goto L10;
            boolean r7 = r2.getFragment().getAllowReturnTransitionOverlap();
        L11:
            this.mOverlapAllowed = r7;
        L16:
            if (r5 == false) goto L20;
            if (r4 == false) goto L19;
            this.mSharedElementTransition = r2.getFragment().getSharedElementReturnTransition();
            return;
        L19:
            this.mSharedElementTransition = r2.getFragment().getSharedElementEnterTransition();
            return;
        L20:
            this.mSharedElementTransition = null;
            return;
        L10:
            r7 = r2.getFragment().getAllowEnterTransitionOverlap();
            goto L11
        L6:
            r6 = r2.getFragment().getEnterTransition();
            goto L7
        L12:
            if (r4 == false) goto L14;
            Object r8 = r2.getFragment().getReturnTransition();
        L15:
            this.mTransition = r8;
            this.mOverlapAllowed = true;
            goto L16
        L14:
            r8 = r2.getFragment().getExitTransition();
            goto L15
        }

        Object getTransition() {
            return this.mTransition;
        }

        boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        public boolean hasSharedElementTransition() {
            if (this.mSharedElementTransition == null) goto L5;
            return true;
        L5:
            return false;
        }

        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

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

        private FragmentTransitionImpl getHandlingImpl(Object r4) {
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

    DefaultSpecialEffectsController(ViewGroup r1) {
        super(r1);
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    void executeOperations(List<SpecialEffectsController.Operation> r11, boolean r12) {
        Iterator<SpecialEffectsController.Operation> r0 = r11.iterator();
        SpecialEffectsController.Operation r6 = null;
        SpecialEffectsController.Operation r7 = null;
    L4:
        if (r0.hasNext() == false) goto L21;
        SpecialEffectsController.Operation r1 = r0.next();
        SpecialEffectsController.Operation.State r2 = SpecialEffectsController.Operation.State.from(r1.getFragment().mView);
        int r3 = AnonymousClass10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[r1.getFinalState().ordinal()];
        if (r3 == 1) goto L18;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L18;
        if (r3 != 4) goto L4;
        if (r2 == SpecialEffectsController.Operation.State.VISIBLE) goto L4;
        r7 = r1;
    L18:
        if (r2 != SpecialEffectsController.Operation.State.VISIBLE) goto L4;
        if (r6 != null) goto L4;
        r6 = r1;
        goto L4
    L21:
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        final ArrayList r8 = new ArrayList(r11);
        Iterator<SpecialEffectsController.Operation> r13 = r11.iterator();
    L23:
        if (r13.hasNext() == false) goto L31;
        final SpecialEffectsController.Operation r9 = r13.next();
        CancellationSignal r10 = new CancellationSignal();
        r9.markStartedSpecialEffect(r10);
        r4.add(new AnimationInfo(r9, r10, r12));
        CancellationSignal r14 = new CancellationSignal();
        r9.markStartedSpecialEffect(r14);
        boolean r15 = false;
        if (r12 == false) goto L28;
        if (r9 != r6) goto L30;
    L29:
        r15 = true;
    L30:
        r5.add(new TransitionInfo(r9, r14, r12, r15));
        r9.addCompletionListener(new AnonymousClass1(this, r8, r9));
        goto L23
    L28:
        if (r9 != r7) goto L30;
    L31:
        Map<SpecialEffectsController.Operation, Boolean> r16 = startTransitions(r5, r8, r12, r6, r7);
        startAnimations(r4, r8, r16.containsValue(true), r16);
        Iterator<SpecialEffectsController.Operation> r17 = r8.iterator();
    L33:
        if (r17.hasNext() == false) goto L35;
        applyContainerChanges(r17.next());
        goto L33
    L35:
        r8.clear();
    }

    private void startAnimations(List<AnimationInfo> r19, List<SpecialEffectsController.Operation> r20, boolean r21, Map<SpecialEffectsController.Operation, Boolean> r22) {
        final ViewGroup r8 = getContainer();
        Context r9 = r8.getContext();
        ArrayList r10 = new ArrayList();
        Iterator<AnimationInfo> r11 = r19.iterator();
        boolean r0 = false;
    L4:
        if (r11.hasNext() == false) goto L29;
        final AnimationInfo r13 = r11.next();
        if (r13.isVisibilityUnchanged() == true) goto L7;
        FragmentAnim.AnimationOrAnimator r1 = r13.getAnimation(r9);
        if (r1 == null) goto L11;
        final Animator r14 = r1.animator;
        if (r14 == null) goto L14;
        final SpecialEffectsController.Operation r5 = r13.getOperation();
        Fragment r2 = r5.getFragment();
        if (Boolean.TRUE.equals(r22.get(r5)) == true) goto L18;
        if (r5.getFinalState() != SpecialEffectsController.Operation.State.GONE) goto L24;
        final boolean r4 = true;
    L26:
        if (r4 == false) goto L28;
        r20.remove(r5);
    L28:
        final View r3 = r2.mView;
        r8.startViewTransition(r3);
        r14.addListener(new AnonymousClass2(this, r8, r3, r4, r5, r13));
        r14.setTarget(r3);
        r14.start();
        r13.getSignal().setOnCancelListener(new AnonymousClass3(this, r14));
        r0 = true;
        goto L4
    L24:
        r4 = false;
        goto L26
    L18:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L20;
        Log.v("FragmentManager", "Ignoring Animator set on " + r2 + " as this Fragment was involved in a Transition.");
    L20:
        r13.completeSpecialEffect();
        goto L4
    L14:
        r10.add(r13);
        goto L4
    L11:
        r13.completeSpecialEffect();
        goto L4
    L7:
        r13.completeSpecialEffect();
        goto L4
    L29:
        Iterator r6 = r10.iterator();
    L31:
        if (r6.hasNext() == false) goto L48;
        final AnimationInfo r7 = (AnimationInfo) r6.next();
        SpecialEffectsController.Operation r12 = r7.getOperation();
        Fragment r15 = r12.getFragment();
        if (r21 == true) goto L35;
        if (r0 == true) goto L40;
        final View r16 = r15.mView;
        Animation r17 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(r7.getAnimation(r9))).animation);
        if (r12.getFinalState() == SpecialEffectsController.Operation.State.REMOVED) goto L46;
        r16.startAnimation(r17);
        r7.completeSpecialEffect();
    L47:
        r7.getSignal().setOnCancelListener(new AnonymousClass5(this, r16, r8, r7));
        goto L31
    L46:
        r8.startViewTransition(r16);
        FragmentAnim.EndViewTransitionAnimation r18 = new FragmentAnim.EndViewTransitionAnimation(r17, r8, r16);
        r18.setAnimationListener(new AnonymousClass4(this, r8, r16, r7));
        r16.startAnimation(r18);
        goto L47
    L40:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L42;
        Log.v("FragmentManager", "Ignoring Animation set on " + r15 + " as Animations cannot run alongside Animators.");
    L42:
        r7.completeSpecialEffect();
        goto L31
    L35:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L37;
        Log.v("FragmentManager", "Ignoring Animation set on " + r15 + " as Animations cannot run alongside Transitions.");
    L37:
        r7.completeSpecialEffect();
        goto L31
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r30v0, types: [androidx.fragment.app.DefaultSpecialEffectsController] */
    /* JADX WARN: Type inference failed for: r30v1 */
    /* JADX WARN: Type inference failed for: r30v3 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [androidx.fragment.app.DefaultSpecialEffectsController] */
    /* JADX WARN: Type inference failed for: r6v19 */
    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(List<TransitionInfo> r32, List<SpecialEffectsController.Operation> r33, final boolean r34, final SpecialEffectsController.Operation r35, final SpecialEffectsController.Operation r36) {
        ?? r6 = this;
        SpecialEffectsController.Operation r8 = r35;
        SpecialEffectsController.Operation r9 = r36;
        HashMap r10 = new HashMap();
        Iterator<TransitionInfo> r0 = r32.iterator();
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
        int r14 = 0;
        if (r15 != null) goto L23;
        Iterator<TransitionInfo> r3 = r32.iterator();
    L20:
        if (r3.hasNext() == false) goto L22;
        TransitionInfo r4 = r3.next();
        r10.put(r4.getOperation(), false);
        r4.completeSpecialEffect();
        goto L20
    L22:
        return r10;
    L23:
        View r13 = new View(getContainer().getContext());
        final Rect r12 = new Rect();
        ArrayList<View> r5 = new ArrayList();
        ArrayList<View> r7 = new ArrayList();
        ArrayMap r11 = new ArrayMap();
        Iterator<TransitionInfo> r20 = r32.iterator();
        boolean r21 = false;
        Object r16 = null;
        View r17 = null;
        ArrayMap r18 = r11;
    L25:
        if (r20.hasNext() == false) goto L89;
        TransitionInfo r19 = r20.next();
        if (r19.hasSharedElementTransition() == false) goto L87;
        if (r8 == null) goto L87;
        if (r9 == null) goto L87;
        Object r22 = r15.wrapTransitionInSet(r15.cloneTransition(r19.getSharedElementTransition()));
        ArrayList<String> r23 = r36.getFragment().getSharedElementSourceNames();
        ArrayList<String> r110 = r35.getFragment().getSharedElementSourceNames();
        ArrayList<String> r111 = r35.getFragment().getSharedElementTargetNames();
        View r112 = r17;
        int r24 = 0;
    L32:
        if (r24 >= r111.size()) goto L37;
        int r25 = r23.indexOf(r111.get(r24));
        ArrayList<String> r113 = r111;
        if (r25 == (-1)) goto L36;
        r23.set(r25, r110.get(r24));
    L36:
        r24 = r24 + 1;
        r111 = r113;
        goto L32
    L37:
        ArrayList<String> r114 = r36.getFragment().getSharedElementTargetNames();
        if (r34 != 0) goto L40;
        SharedElementCallback r26 = r35.getFragment().getExitTransitionCallback();
        SharedElementCallback r27 = r36.getFragment().getEnterTransitionCallback();
    L41:
        int r115 = r23.size();
        int r28 = 0;
    L42:
        if (r28 >= r115) goto L44;
        r18.put(r23.get(r28), r114.get(r28));
        r28 = r28 + 1;
        r115 = r115;
        goto L42
    L44:
        ArrayMap r29 = new ArrayMap();
        r6.findNamedViews(r29, r35.getFragment().mView);
        r29.retainAll(r23);
        if (r26 == null) goto L56;
        r26.onMapSharedElements(r23, r29);
        int r30 = r23.size() - 1;
    L47:
        if (r30 < 0) goto L55;
        String r31 = r23.get(r30);
        View r116 = (View) r29.get(r31);
        if (r116 != null) goto L51;
        r18.remove(r31);
        ArrayList<String> r117 = r23;
    L54:
        r30 = r30 - 1;
        r23 = r117;
        goto L47
    L51:
        r117 = r23;
        if (r31.equals(ViewCompat.getTransitionName(r116)) == true) goto L54;
        r18.put(ViewCompat.getTransitionName(r116), (String) r18.remove(r31));
        goto L54
    L55:
        ArrayList<String> r118 = r23;
    L57:
        final ArrayMap r37 = new ArrayMap();
        r6.findNamedViews(r37, r36.getFragment().mView);
        r37.retainAll(r114);
        r37.retainAll(r18.values());
        if (r27 == null) goto L72;
        r27.onMapSharedElements(r114, r37);
        int r38 = r114.size() - 1;
    L60:
        if (r38 < 0) goto L73;
        String r39 = r114.get(r38);
        View r40 = (View) r37.get(r39);
        if (r40 != null) goto L67;
        String r41 = FragmentTransition.findKeyForValue(r18, r39);
        if (r41 == null) goto L71;
        r18.remove(r41);
    L71:
        r38 = r38 - 1;
        goto L60
    L67:
        if (r39.equals(ViewCompat.getTransitionName(r40)) == true) goto L71;
        String r42 = FragmentTransition.findKeyForValue(r18, r39);
        if (r42 == null) goto L71;
        r18.put(r42, ViewCompat.getTransitionName(r40));
    L73:
        r6.retainMatchingViews(r29, r18.keySet());
        r6.retainMatchingViews(r37, r18.values());
        if (r18.isEmpty() == false) goto L76;
        r5.clear();
        r7.clear();
        ArrayList<View> r43 = r7;
        View r44 = r13;
        r17 = r112;
        r16 = null;
        int r45 = 0;
        SpecialEffectsController.Operation r46 = r36;
        HashMap r119 = r10;
        SpecialEffectsController.Operation r120 = r35;
        ?? r310 = r6;
        ArrayList<View> r47 = r5;
        ?? r48 = r310;
    L88:
        r14 = r45;
        r12 = r12;
        r13 = r44;
        r7 = r43;
        r8 = r120;
        r10 = r119;
        r9 = r46;
        r15 = r15;
        r18 = r18;
        ArrayList<View> r311 = r47;
        r6 = r48;
        r5 = r311;
        goto L25
    L76:
        FragmentTransition.callSharedElementStartEnd(r36.getFragment(), r35.getFragment(), r34, r29, true);
        HashMap r210 = r10;
        View r121 = r13;
        ArrayList<View> r122 = r7;
        r47 = r5;
        OneShotPreDrawListener.add(getContainer(), new AnonymousClass6(this, r36, r35, r34, r37));
        r47.addAll(r29.values());
        if (r118.isEmpty() == true) goto L79;
        r45 = 0;
        View r49 = (View) r29.get(r118.get(0));
        r15.setEpicenter(r22, r49);
        r17 = r49;
    L80:
        r122.addAll(r37.values());
        if (r114.isEmpty() == true) goto L85;
        final View r50 = (View) r37.get(r114.get(r45));
        if (r50 == null) goto L85;
        final DefaultSpecialEffectsController r51 = this;
        OneShotPreDrawListener.add(getContainer(), new AnonymousClass7(r51, r15, r50, r12));
        r21 = true;
        r48 = r51;
    L86:
        r15.setSharedElementTargets(r22, r121, r47);
        r44 = r121;
        r43 = r122;
        r15.scheduleRemoveTargets(r22, null, null, null, null, r22, r43);
        r120 = r35;
        r119 = r210;
        r119.put(r120, true);
        r46 = r36;
        r119.put(r46, true);
        r16 = r22;
    L85:
        r48 = this;
        goto L86
    L79:
        r45 = 0;
        r17 = r112;
        goto L80
    L72:
        FragmentTransition.retainValues(r18, r37);
        goto L73
    L56:
        r118 = r23;
        r18.retainAll(r29.keySet());
        goto L57
    L40:
        r26 = r35.getFragment().getEnterTransitionCallback();
        r27 = r36.getFragment().getExitTransitionCallback();
    L87:
        r46 = r9;
        r45 = r14;
        r43 = r7;
        r119 = r10;
        r120 = r8;
        r44 = r13;
        ?? r312 = r6;
        r47 = r5;
        r48 = r312;
        r17 = r17;
        goto L88
    L89:
        View r211 = r17;
        ArrayMap r212 = r18;
        SpecialEffectsController.Operation r52 = r9;
        ?? r53 = r14;
        FragmentTransitionImpl r123 = r15;
        ArrayList<View> r54 = r7;
        HashMap r124 = r10;
        Rect r55 = r12;
        SpecialEffectsController.Operation r125 = r8;
        View r56 = r13;
        final ?? r313 = r6;
        ArrayList<View> r57 = r5;
        ArrayList r58 = new ArrayList();
        Iterator<TransitionInfo> r59 = r32.iterator();
        Object r126 = null;
        Object r127 = null;
    L91:
        if (r59.hasNext() == false) goto L130;
        TransitionInfo r213 = r59.next();
        if (r213.isVisibilityUnchanged() == false) goto L96;
        r124.put(r213.getOperation(), Boolean.valueOf(r53));
        r213.completeSpecialEffect();
    L95:
        r59 = r59;
        r53 = r53;
        goto L91
    L96:
        Object r60 = r123.cloneTransition(r213.getTransition());
        SpecialEffectsController.Operation r128 = r213.getOperation();
        if (r16 == null) goto L101;
        if (r128 == r125) goto L100;
        if (r128 != r52) goto L101;
    L100:
        boolean r129 = true;
    L102:
        if (r60 != null) goto L106;
        if (r129 == true) goto L105;
        r124.put(r128, Boolean.valueOf(r53));
        r213.completeSpecialEffect();
    L105:
        ArrayList<View> r214 = r57;
        View r215 = r56;
        ArrayList<View> r216 = r54;
        Object r61 = r126;
        Object r62 = r127;
        HashMap r63 = r124;
        View r64 = r211;
    L129:
        r211 = r64;
        r127 = r62;
        r126 = r61;
        r124 = r63;
        r56 = r215;
        r57 = r214;
        r54 = r216;
        r53 = 0;
        goto L95
    L106:
        final ArrayList<View> r65 = new ArrayList();
        Object r130 = r126;
        r313.captureTransitioningViews(r65, r128.getFragment().mView);
        if (r129 == false) goto L112;
        if (r128 != r125) goto L110;
        r65.removeAll(r57);
        goto L112
    L110:
        r65.removeAll(r54);
    L112:
        if (r65.isEmpty() == false) goto L114;
        r123.addTarget(r60, r56);
        r214 = r57;
        r215 = r56;
        r216 = r54;
        SpecialEffectsController.Operation r131 = r128;
        r62 = r127;
        r63 = r124;
        Object r66 = r130;
    L119:
        if (r131.getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L124;
        r58.addAll(r65);
        if (r21 == false) goto L123;
        r123.setEpicenter(r60, r55);
    L123:
        r64 = r211;
    L125:
        r63.put(r131, true);
        if (r213.isOverlapAllowed() == false) goto L128;
        r62 = r123.mergeTransitionsTogether(r62, r60, null);
        r61 = r66;
        goto L129
    L128:
        r61 = r123.mergeTransitionsTogether(r66, r60, null);
        goto L129
    L124:
        r64 = r211;
        r123.setEpicenter(r60, r64);
        goto L125
    L114:
        r123.addTargets(r60, r65);
        r215 = r56;
        r66 = r130;
        r214 = r57;
        r62 = r127;
        r216 = r54;
        r63 = r124;
        r123.scheduleRemoveTargets(r60, r60, r65, null, null, null, null);
        if (r128.getFinalState() != SpecialEffectsController.Operation.State.GONE) goto L117;
        r131 = r128;
        r33.remove(r131);
        ArrayList<View> r132 = new ArrayList(r65);
        r132.remove(r131.getFragment().mView);
        r123.scheduleHideFragmentView(r60, r131.getFragment().mView, r132);
        OneShotPreDrawListener.add(getContainer(), new AnonymousClass8(r313, r65));
        goto L119
    L117:
        r131 = r128;
    L101:
        r129 = r53 == true ? 1 : 0;
        goto L102
    L130:
        ArrayList<View> r217 = r57;
        ArrayList<View> r218 = r54;
        HashMap r67 = r124;
        Object r68 = r123.mergeTransitionsInSequence(r127, r126, r16);
        Iterator<TransitionInfo> r69 = r32.iterator();
    L132:
        if (r69.hasNext() == false) goto L152;
        final TransitionInfo r70 = r69.next();
        if (r70.isVisibilityUnchanged() == true) goto L132;
        Object r71 = r70.getTransition();
        SpecialEffectsController.Operation r72 = r70.getOperation();
        if (r16 == null) goto L141;
        if (r72 == r125) goto L140;
        if (r72 != r52) goto L141;
    L140:
        boolean r133 = true;
    L142:
        if (r71 != null) goto L145;
        if (r133 == false) goto L132;
    L145:
        if (ViewCompat.isLaidOut(getContainer()) == false) goto L147;
        r123.setListenerForTransitionEnd(r70.getOperation().getFragment(), r68, r70.getSignal(), new AnonymousClass9(r313, r70));
        goto L132
    L147:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L149;
        Log.v("FragmentManager", "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + r72);
    L149:
        r70.completeSpecialEffect();
    L141:
        r133 = false;
        goto L142
    L152:
        if (ViewCompat.isLaidOut(getContainer()) == true) goto L154;
        return r67;
    L154:
        FragmentTransition.setViewVisibility(r58, 4);
        ArrayList<String> r73 = r123.prepareSetNameOverridesReordered(r218);
        r123.beginDelayedTransition(getContainer(), r68);
        r123.setNameOverridesReordered(getContainer(), r217, r218, r73, r212);
        FragmentTransition.setViewVisibility(r58, 0);
        r123.swapSharedElementTargets(r16, r217, r218);
        return r67;
    }

    void retainMatchingViews(ArrayMap<String, View> r1, Collection<String> r2) {
        Iterator<Map.Entry<String, View>> r0 = r1.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r2.contains(ViewCompat.getTransitionName(r0.next().getValue())) == true) goto L4;
        r0.remove();
        goto L4
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

    void findNamedViews(Map<String, View> r5, View r6) {
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

    void applyContainerChanges(SpecialEffectsController.Operation r1) {
        View r0 = r1.getFragment().mView;
        r1.getFinalState().applyState(r0);
    }
}
