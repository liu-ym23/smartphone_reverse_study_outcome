package androidx.fragment.app;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.transition.FragmentTransitionSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class FragmentTransition {
    private static final int[] INVERSE_OPS = null;
    private static final FragmentTransitionImpl PLATFORM_IMPL = null;
    private static final FragmentTransitionImpl SUPPORT_IMPL = null;

    public static class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;

        public FragmentContainerTransition() {
        }
    }

    static {
        INVERSE_OPS = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
        PLATFORM_IMPL = new FragmentTransitionCompat21();
        SUPPORT_IMPL = resolveSupportImpl();
    }

    private FragmentTransition() {
    }

    private static void addSharedElementsWithMatchingNames(ArrayList<View> r3, ArrayMap<String, View> r4, Collection<String> r5) {
        int r0 = r4.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        View r1 = r4.valueAt(r0);
        if (r5.contains(ViewCompat.getTransitionName(r1)) == false) goto L7;
        r3.add(r1);
    L7:
        r0 = r0 - 1;
        goto L3
    }

    private static void addToFirstInLastOut(BackStackRecord r16, FragmentTransaction.Op r17, SparseArray<FragmentContainerTransition> r18, boolean r19, boolean r20) {
        Fragment r10 = r17.mFragment;
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = r10.mContainerId;
        if (r11 != 0) goto L8;
        return;
    L8:
        if (r19 == false) goto L10;
        int r1 = INVERSE_OPS[r17.mCmd];
    L11:
        boolean r4 = false;
        if (r1 != 1) goto L14;
    L65:
        if (r20 == false) goto L68;
        boolean r2 = r10.mIsNewlyAdded;
    L34:
        boolean r12 = false;
        boolean r13 = false;
        r4 = r2;
        boolean r3 = true;
    L72:
        FragmentContainerTransition r6 = r18.get(r11);
        if (r4 == false) goto L75;
        r6 = ensureContainer(r6, r18, r11);
        r6.lastIn = r10;
        r6.lastInIsPop = r19;
        r6.lastInTransaction = r16;
    L75:
        FragmentContainerTransition r14 = r6;
        if (r20 == true) goto L89;
        if (r3 == false) goto L89;
        if (r14 != null) goto L80;
    L82:
        FragmentManagerImpl r5 = r16.mManager;
        if (r10.mState >= 1) goto L89;
        if (r5.mCurState < 1) goto L89;
        if (r16.mReorderingAllowed == true) goto L89;
        r5.makeActive(r10);
        r5.moveToState(r10, 1, 0, 0, false);
        goto L89
    L80:
        if (r14.firstOut != r10) goto L82;
        r14.firstOut = null;
    L89:
        if (r13 == false) goto L94;
        if (r14 != null) goto L92;
    L93:
        r14 = ensureContainer(r14, r18, r11);
        r14.firstOut = r10;
        r14.firstOutIsPop = r19;
        r14.firstOutTransaction = r16;
        goto L94
    L92:
        if (r14.firstOut == null) goto L93;
    L94:
        if (r20 == true) goto L101;
        if (r12 == false) goto L102;
        if (r14 != null) goto L98;
        return;
    L98:
        if (r14.lastIn != r10) goto L104;
        r14.lastIn = null;
        return;
    L104:
        return;
    L102:
        return;
    L101:
        return;
    L68:
        if (r10.mAdded == false) goto L70;
    L32:
        r2 = false;
        goto L34
    L70:
        if (r10.mHidden == true) goto L32;
    L31:
        r2 = true;
        goto L34
    L14:
        if (r1 != 3) goto L16;
    L50:
        if (r20 == false) goto L61;
        if (r10.mAdded == false) goto L53;
    L43:
        boolean r7 = false;
    L49:
        r13 = r7;
        r3 = false;
        r12 = true;
        goto L72
    L53:
        View r8 = r10.mView;
        if (r8 == null) goto L43;
        if (r8.getVisibility() != 0) goto L43;
        if (r10.mPostponedAlpha < 0.0f) goto L43;
    L42:
        r7 = true;
        goto L49
    L61:
        if (r10.mAdded == false) goto L43;
        if (r10.mHidden == true) goto L43;
    L16:
        if (r1 != 4) goto L18;
        if (r20 == false) goto L45;
        if (r10.mHiddenChanged == false) goto L43;
        if (r10.mAdded == false) goto L43;
        if (r10.mHidden == false) goto L43;
    L45:
        if (r10.mAdded == false) goto L43;
        if (r10.mHidden == true) goto L43;
    L18:
        if (r1 != 5) goto L20;
        if (r20 == true) goto L26;
        r2 = r10.mHidden;
        goto L34
    L26:
        if (r10.mHiddenChanged == false) goto L32;
        if (r10.mHidden == true) goto L32;
        if (r10.mAdded == false) goto L32;
    L20:
        if (r1 == 6) goto L50;
        if (r1 == 7) goto L65;
        r3 = false;
        r12 = false;
        r13 = false;
        goto L72
    L10:
        r1 = r17.mCmd;
        goto L11
    }

    public static void calculateFragments(BackStackRecord r4, SparseArray<FragmentContainerTransition> r5, boolean r6) {
        int r0 = r4.mOps.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        addToFirstInLastOut(r4, r4.mOps.get(r2), r5, false, r6);
        r2 = r2 + 1;
        goto L3
    }

    private static ArrayMap<String, String> calculateNameOverrides(int r9, ArrayList<BackStackRecord> r10, ArrayList<Boolean> r11, int r12, int r13) {
        ArrayMap<String, String> r0 = new ArrayMap();
        int r14 = r13 - 1;
    L3:
        if (r14 < r12) goto L21;
        BackStackRecord r1 = r10.get(r14);
        if (r1.interactsWith(r9) == false) goto L20;
        boolean r2 = r11.get(r14).booleanValue();
        ArrayList<String> r3 = r1.mSharedElementSourceNames;
        if (r3 == null) goto L20;
        int r4 = r3.size();
        if (r2 == false) goto L12;
        ArrayList<String> r5 = r1.mSharedElementSourceNames;
        ArrayList<String> r6 = r1.mSharedElementTargetNames;
    L13:
        int r7 = 0;
    L14:
        if (r7 >= r4) goto L20;
        String r8 = r6.get(r7);
        String r15 = r5.get(r7);
        String r16 = r0.remove(r15);
        if (r16 == null) goto L18;
        r0.put(r8, r16);
    L19:
        r7 = r7 + 1;
        goto L14
    L18:
        r0.put(r8, r15);
        goto L19
    L12:
        ArrayList<String> r17 = r1.mSharedElementSourceNames;
        r5 = r1.mSharedElementTargetNames;
        r6 = r17;
    L20:
        r14 = r14 - 1;
        goto L3
    L21:
        return r0;
    }

    public static void calculatePopFragments(BackStackRecord r3, SparseArray<FragmentContainerTransition> r4, boolean r5) {
        if (r3.mManager.mContainer.onHasView() == true) goto L5;
        return;
    L5:
        int r0 = r3.mOps.size() - 1;
    L6:
        if (r0 < 0) goto L8;
        addToFirstInLastOut(r3, r3.mOps.get(r0), r4, true, r5);
        r0 = r0 - 1;
        goto L6
    }

    public static void callSharedElementStartEnd(Fragment r3, Fragment r4, boolean r5, ArrayMap<String, View> r6, boolean r7) {
        if (r5 == false) goto L4;
        SharedElementCallback r8 = r4.getEnterTransitionCallback();
    L5:
        if (r8 == null) goto L19;
        ArrayList r9 = new ArrayList();
        ArrayList r10 = new ArrayList();
        int r0 = 0;
        if (r6 != null) goto L9;
        int r1 = 0;
    L10:
        if (r0 >= r1) goto L13;
        r10.add(r6.keyAt(r0));
        r9.add(r6.valueAt(r0));
        r0 = r0 + 1;
        goto L10
    L13:
        if (r7 == false) goto L15;
        r8.onSharedElementStart(r10, r9, null);
        return;
    L15:
        r8.onSharedElementEnd(r10, r9, null);
        return;
    L9:
        r1 = r6.size();
        goto L10
    L19:
        return;
    L4:
        r8 = r3.getEnterTransitionCallback();
        goto L5
    }

    private static boolean canHandleAll(FragmentTransitionImpl r4, List<Object> r5) {
        int r0 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (r4.canHandle(r5.get(r2)) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static ArrayMap<String, View> captureInSharedElements(FragmentTransitionImpl r3, ArrayMap<String, String> r4, Object r5, FragmentContainerTransition r6) {
        Fragment r0 = r6.lastIn;
        View r1 = r0.getView();
        if (r4.isEmpty() == true) goto L29;
        if (r5 == null) goto L29;
        if (r1 == null) goto L29;
        ArrayMap<String, View> r7 = new ArrayMap();
        r3.findNamedViews(r7, r1);
        BackStackRecord r8 = r6.lastInTransaction;
        if (r6.lastInIsPop == false) goto L10;
        SharedElementCallback r9 = r0.getExitTransitionCallback();
        ArrayList<String> r10 = r8.mSharedElementSourceNames;
    L11:
        if (r10 == null) goto L13;
        r7.retainAll(r10);
        r7.retainAll(r4.values());
    L13:
        if (r9 == null) goto L27;
        r9.onMapSharedElements(r10, r7);
        int r11 = r10.size() - 1;
    L15:
        if (r11 < 0) goto L28;
        String r2 = r10.get(r11);
        View r12 = r7.get(r2);
        if (r12 != null) goto L22;
        String r13 = findKeyForValue(r4, r2);
        if (r13 == null) goto L26;
        r4.remove(r13);
    L26:
        r11 = r11 - 1;
        goto L15
    L22:
        if (r2.equals(ViewCompat.getTransitionName(r12)) == true) goto L26;
        String r14 = findKeyForValue(r4, r2);
        if (r14 == null) goto L26;
        r4.put(r14, ViewCompat.getTransitionName(r12));
    L28:
        return r7;
    L27:
        retainValues(r4, r7);
        goto L28
    L10:
        r9 = r0.getEnterTransitionCallback();
        r10 = r8.mSharedElementTargetNames;
    L29:
        r4.clear();
        return null;
    }

    private static ArrayMap<String, View> captureOutSharedElements(FragmentTransitionImpl r3, ArrayMap<String, String> r4, Object r5, FragmentContainerTransition r6) {
        if (r4.isEmpty() == true) goto L23;
        if (r5 == null) goto L23;
        Fragment r7 = r6.firstOut;
        ArrayMap<String, View> r0 = new ArrayMap();
        r3.findNamedViews(r0, r7.requireView());
        BackStackRecord r8 = r6.firstOutTransaction;
        if (r6.firstOutIsPop == false) goto L9;
        SharedElementCallback r9 = r7.getEnterTransitionCallback();
        ArrayList<String> r10 = r8.mSharedElementTargetNames;
    L10:
        r0.retainAll(r10);
        if (r9 == null) goto L21;
        r9.onMapSharedElements(r10, r0);
        int r11 = r10.size() - 1;
    L13:
        if (r11 < 0) goto L22;
        String r12 = r10.get(r11);
        View r1 = r0.get(r12);
        if (r1 != null) goto L18;
        r4.remove(r12);
    L20:
        r11 = r11 - 1;
        goto L13
    L18:
        if (r12.equals(ViewCompat.getTransitionName(r1)) == true) goto L20;
        r4.put(ViewCompat.getTransitionName(r1), r4.remove(r12));
    L22:
        return r0;
    L21:
        r4.retainAll(r0.keySet());
        goto L22
    L9:
        r9 = r7.getExitTransitionCallback();
        r10 = r8.mSharedElementSourceNames;
    L23:
        r4.clear();
        return null;
    }

    private static FragmentTransitionImpl chooseImpl(Fragment r2, Fragment r3) {
        ArrayList r0 = new ArrayList();
        if (r2 == null) goto L13;
        Object r1 = r2.getExitTransition();
        if (r1 == null) goto L7;
        r0.add(r1);
    L7:
        Object r4 = r2.getReturnTransition();
        if (r4 == null) goto L10;
        r0.add(r4);
    L10:
        Object r5 = r2.getSharedElementReturnTransition();
        if (r5 == null) goto L13;
        r0.add(r5);
    L13:
        if (r3 == null) goto L24;
        Object r6 = r3.getEnterTransition();
        if (r6 == null) goto L17;
        r0.add(r6);
    L17:
        Object r7 = r3.getReenterTransition();
        if (r7 == null) goto L20;
        r0.add(r7);
    L20:
        Object r8 = r3.getSharedElementEnterTransition();
        if (r8 == null) goto L24;
        r0.add(r8);
    L24:
        if (r0.isEmpty() == false) goto L26;
        return null;
    L26:
        FragmentTransitionImpl r9 = PLATFORM_IMPL;
        if (r9 != null) goto L29;
    L31:
        FragmentTransitionImpl r10 = SUPPORT_IMPL;
        if (r10 != null) goto L34;
    L36:
        if (r9 != null) goto L40;
        if (r10 != null) goto L40;
        return null;
    L40:
        throw new IllegalArgumentException("Invalid Transition types");
    L34:
        if (canHandleAll(r10, r0) == false) goto L36;
        return r10;
    L29:
        if (canHandleAll(r9, r0) == false) goto L31;
        return r9;
    }

    public static ArrayList<View> configureEnteringExitingViews(FragmentTransitionImpl r1, Object r2, Fragment r3, ArrayList<View> r4, View r5) {
        if (r2 == null) goto L11;
        ArrayList<View> r0 = new ArrayList();
        View r6 = r3.getView();
        if (r6 == null) goto L6;
        r1.captureTransitioningViews(r0, r6);
    L6:
        if (r4 == null) goto L9;
        r0.removeAll(r4);
    L9:
        if (r0.isEmpty() == true) goto L13;
        r0.add(r5);
        r1.addTargets(r2, r0);
        return r0;
    L13:
        return r0;
    L11:
        return null;
    }

    private static Object configureSharedElementsOrdered(final FragmentTransitionImpl r17, ViewGroup r18, final View r19, final ArrayMap<String, String> r20, final FragmentContainerTransition r21, final ArrayList<View> r22, final ArrayList<View> r23, final Object r24, Object r25) {
        final Fragment r8 = r21.lastIn;
        final Fragment r9 = r21.firstOut;
        if (r8 == null) goto L26;
        if (r9 == null) goto L26;
        final boolean r12 = r21.lastInIsPop;
        if (r20.isEmpty() == false) goto L9;
        Object r1 = null;
    L10:
        ArrayMap<String, View> r3 = captureOutSharedElements(r17, r20, r1, r21);
        if (r20.isEmpty() == false) goto L13;
        Object r14 = null;
    L14:
        if (r24 != null) goto L18;
        if (r25 != null) goto L18;
        if (r14 != null) goto L18;
        return null;
    L18:
        callSharedElementStartEnd(r8, r9, r12, r3, true);
        if (r14 == null) goto L23;
        Rect r15 = new Rect();
        r17.setSharedElementTargets(r14, r19, r22);
        setOutEpicenter(r17, r14, r25, r3, r21.firstOutIsPop, r21.firstOutTransaction);
        if (r24 == null) goto L24;
        r17.setEpicenter(r24, r15);
    L24:
        final Object r4 = r14;
        final Rect r13 = r15;
        OneShotPreDrawListener.add(r18, new AnonymousClass4(r17, r20, r4, r21, r23, r19, r8, r9, r12, r22, r24, r13));
        return r14;
    L23:
        r15 = null;
        goto L24
    L13:
        r22.addAll(r3.values());
        r14 = r1;
        goto L14
    L9:
        r1 = getSharedElementTransition(r17, r8, r9, r12);
    L26:
        return null;
    }

    private static Object configureSharedElementsReordered(final FragmentTransitionImpl r15, ViewGroup r16, View r17, ArrayMap<String, String> r18, FragmentContainerTransition r19, ArrayList<View> r20, ArrayList<View> r21, Object r22, Object r23) {
        final Fragment r9 = r19.lastIn;
        final Fragment r10 = r19.firstOut;
        if (r9 == null) goto L6;
        r9.requireView().setVisibility(0);
    L6:
        if (r9 == null) goto L34;
        if (r10 == null) goto L34;
        final boolean r11 = r19.lastInIsPop;
        if (r18.isEmpty() == false) goto L12;
        Object r5 = null;
    L13:
        ArrayMap<String, View> r12 = captureOutSharedElements(r15, r18, r5, r19);
        final ArrayMap<String, View> r13 = captureInSharedElements(r15, r18, r5, r19);
        if (r18.isEmpty() == false) goto L20;
        if (r12 == null) goto L17;
        r12.clear();
    L17:
        if (r13 == null) goto L19;
        r13.clear();
    L19:
        Object r14 = null;
    L21:
        if (r22 != null) goto L25;
        if (r23 != null) goto L25;
        if (r14 != null) goto L25;
        return null;
    L25:
        callSharedElementStartEnd(r9, r10, r11, r12, true);
        if (r14 == null) goto L31;
        r21.add(r17);
        r15.setSharedElementTargets(r14, r17, r20);
        setOutEpicenter(r15, r14, r23, r12, r19.firstOutIsPop, r19.firstOutTransaction);
        Rect r0 = new Rect();
        View r1 = getInEpicenterView(r13, r19, r22, r11);
        if (r1 == null) goto L30;
        r15.setEpicenter(r22, r0);
    L30:
        final Rect r7 = r0;
        final View r6 = r1;
    L32:
        OneShotPreDrawListener.add(r16, new AnonymousClass3(r9, r10, r11, r13, r6, r15, r7));
        return r14;
    L31:
        r6 = null;
        r7 = null;
        goto L32
    L20:
        addSharedElementsWithMatchingNames(r20, r12, r18.keySet());
        addSharedElementsWithMatchingNames(r21, r13, r18.values());
        r14 = r5;
        goto L21
    L12:
        r5 = getSharedElementTransition(r15, r9, r10, r11);
    L34:
        return null;
    }

    private static void configureTransitionsOrdered(FragmentManagerImpl r19, int r20, FragmentContainerTransition r21, View r22, ArrayMap<String, String> r23) {
        if (r19.mContainer.onHasView() == false) goto L5;
        ViewGroup r13 = (ViewGroup) r19.mContainer.onFindViewById(r20);
    L6:
        if (r13 != null) goto L8;
        return;
    L8:
        Fragment r14 = r21.lastIn;
        Fragment r15 = r21.firstOut;
        FragmentTransitionImpl r8 = chooseImpl(r15, r14);
        if (r8 != null) goto L11;
        return;
    L11:
        boolean r0 = r21.lastInIsPop;
        boolean r1 = r21.firstOutIsPop;
        Object r7 = getEnterTransition(r8, r14, r0);
        Object r6 = getExitTransition(r8, r15, r1);
        ArrayList r5 = new ArrayList();
        ArrayList<View> r4 = new ArrayList();
        Object r9 = configureSharedElementsOrdered(r8, r13, r22, r23, r21, r5, r4, r7, r6);
        if (r7 != null) goto L18;
        if (r9 != null) goto L18;
        Object r2 = r6;
        if (r2 != null) goto L19;
        return;
    L19:
        ArrayList<View> r16 = configureEnteringExitingViews(r8, r2, r15, r5, r22);
        if (r16 != null) goto L22;
    L25:
        Object r18 = null;
    L26:
        r8.addTarget(r7, r22);
        Object r3 = r18;
        Object r10 = mergeTransitions(r8, r7, r3, r9, r14, r21.lastInIsPop);
        if (r10 == null) goto L30;
        ArrayList<View> r17 = new ArrayList();
        r8.scheduleRemoveTargets(r10, r7, r17, r18, r16, r9, r4);
        scheduleTargetChange(r8, r13, r14, r22, r4, r7, r17, r18, r16);
        r8.setNameOverridesOrdered(r13, r4, r23);
        r8.beginDelayedTransition(r13, r10);
        r8.scheduleNameReset(r13, r4, r23);
        return;
    L30:
        return;
    L22:
        if (r16.isEmpty() == true) goto L25;
        r18 = r2;
    L18:
        r2 = r6;
        goto L19
    L5:
        r13 = null;
        goto L6
    }

    private static void configureTransitionsReordered(FragmentManagerImpl r17, int r18, FragmentContainerTransition r19, View r20, ArrayMap<String, String> r21) {
        if (r17.mContainer.onHasView() == false) goto L6;
        ViewGroup r0 = (ViewGroup) r17.mContainer.onFindViewById(r18);
    L5:
        ViewGroup r10 = r0;
        if (r10 != null) goto L9;
        return;
    L9:
        Fragment r11 = r19.lastIn;
        Fragment r12 = r19.firstOut;
        FragmentTransitionImpl r13 = chooseImpl(r12, r11);
        if (r13 != null) goto L12;
        return;
    L12:
        boolean r14 = r19.lastInIsPop;
        boolean r1 = r19.firstOutIsPop;
        ArrayList<View> r15 = new ArrayList();
        ArrayList<View> r8 = new ArrayList();
        Object r7 = getEnterTransition(r13, r11, r14);
        Object r6 = getExitTransition(r13, r12, r1);
        Object r9 = configureSharedElementsReordered(r13, r10, r20, r21, r19, r8, r15, r7, r6);
        if (r7 != null) goto L18;
        if (r9 != null) goto L18;
        Object r16 = r6;
        if (r16 != null) goto L19;
        return;
    L19:
        ArrayList<View> r5 = configureEnteringExitingViews(r13, r16, r12, r8, r20);
        ArrayList<View> r22 = configureEnteringExitingViews(r13, r7, r11, r15, r20);
        setViewVisibility(r22, 4);
        Object r110 = mergeTransitions(r13, r7, r16, r9, r11, r14);
        if (r110 == null) goto L23;
        replaceHide(r13, r16, r12, r5);
        ArrayList<String> r111 = r13.prepareSetNameOverridesReordered(r15);
        r13.scheduleRemoveTargets(r110, r7, r22, r16, r5, r9, r15);
        r13.beginDelayedTransition(r10, r110);
        r13.setNameOverridesReordered(r10, r8, r15, r111, r21);
        setViewVisibility(r22, 0);
        r13.swapSharedElementTargets(r9, r8, r15);
        return;
    L23:
        return;
    L18:
        r16 = r6;
        goto L19
    L6:
        r0 = null;
        goto L5
    }

    private static FragmentContainerTransition ensureContainer(FragmentContainerTransition r0, SparseArray<FragmentContainerTransition> r1, int r2) {
        if (r0 != null) goto L5;
        FragmentContainerTransition r3 = new FragmentContainerTransition();
        r1.put(r2, r3);
        return r3;
    L5:
        return r0;
    }

    private static String findKeyForValue(ArrayMap<String, String> r3, String r4) {
        int r0 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (r4.equals(r3.valueAt(r1)) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return r3.keyAt(r1);
    L9:
        return null;
    }

    private static Object getEnterTransition(FragmentTransitionImpl r0, Fragment r1, boolean r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r2 == false) goto L7;
        Object r3 = r1.getReenterTransition();
    L9:
        return r0.cloneTransition(r3);
    L7:
        r3 = r1.getEnterTransition();
        goto L9
    }

    private static Object getExitTransition(FragmentTransitionImpl r0, Fragment r1, boolean r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r2 == false) goto L7;
        Object r3 = r1.getReturnTransition();
    L9:
        return r0.cloneTransition(r3);
    L7:
        r3 = r1.getExitTransition();
        goto L9
    }

    public static View getInEpicenterView(ArrayMap<String, View> r0, FragmentContainerTransition r1, Object r2, boolean r3) {
        BackStackRecord r4 = r1.lastInTransaction;
        if (r2 == null) goto L15;
        if (r0 == null) goto L17;
        ArrayList<String> r5 = r4.mSharedElementSourceNames;
        if (r5 != null) goto L8;
        return null;
    L8:
        if (r5.isEmpty() == false) goto L10;
        return null;
    L10:
        if (r3 == false) goto L12;
        String r6 = r4.mSharedElementSourceNames.get(0);
    L14:
        return r0.get(r6);
    L12:
        r6 = r4.mSharedElementTargetNames.get(0);
        goto L14
    L17:
        return null;
    L15:
        return null;
    }

    private static Object getSharedElementTransition(FragmentTransitionImpl r0, Fragment r1, Fragment r2, boolean r3) {
        if (r1 == null) goto L10;
        if (r2 == null) goto L12;
        if (r3 == false) goto L7;
        Object r4 = r2.getSharedElementReturnTransition();
    L9:
        return r0.wrapTransitionInSet(r0.cloneTransition(r4));
    L7:
        r4 = r1.getSharedElementEnterTransition();
        goto L9
    L12:
        return null;
    L10:
        return null;
    }

    private static Object mergeTransitions(FragmentTransitionImpl r0, Object r1, Object r2, Object r3, Fragment r4, boolean r5) {
        if (r1 == null) goto L8;
        if (r2 == null) goto L8;
        if (r4 == null) goto L8;
        if (r5 == false) goto L7;
        boolean r6 = r4.getAllowReturnTransitionOverlap();
    L9:
        if (r6 == false) goto L12;
        return r0.mergeTransitionsTogether(r2, r1, r3);
    L12:
        return r0.mergeTransitionsInSequence(r2, r1, r3);
    L7:
        r6 = r4.getAllowEnterTransitionOverlap();
    L8:
        r6 = true;
        goto L9
    }

    private static void replaceHide(FragmentTransitionImpl r1, Object r2, Fragment r3, final ArrayList<View> r4) {
        if (r3 == null) goto L12;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r3.mAdded == true) goto L7;
        return;
    L7:
        if (r3.mHidden == true) goto L9;
        return;
    L9:
        if (r3.mHiddenChanged == false) goto L16;
        r3.setHideReplaced(true);
        r1.scheduleHideFragmentView(r2, r3.getView(), r4);
        OneShotPreDrawListener.add(r3.mContainer, new AnonymousClass1(r4));
        return;
    L16:
        return;
    }

    private static FragmentTransitionImpl resolveSupportImpl() {
        return (FragmentTransitionImpl) FragmentTransitionSupport.class.getDeclaredConstructor(null).newInstance(null);
    L5:
        return null;
    }

    private static void retainValues(ArrayMap<String, String> r2, ArrayMap<String, View> r3) {
        int r0 = r2.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (r3.containsKey(r2.valueAt(r0)) == true) goto L7;
        r2.removeAt(r0);
    L7:
        r0 = r0 - 1;
        goto L3
    }

    private static void scheduleTargetChange(final FragmentTransitionImpl r10, ViewGroup r11, final Fragment r12, final View r13, final ArrayList<View> r14, final Object r15, final ArrayList<View> r16, final Object r17, final ArrayList<View> r18) {
        OneShotPreDrawListener.add(r11, new AnonymousClass2(r15, r10, r13, r12, r14, r16, r18, r17));
    }

    private static void setOutEpicenter(FragmentTransitionImpl r1, Object r2, Object r3, ArrayMap<String, View> r4, boolean r5, BackStackRecord r6) {
        ArrayList<String> r0 = r6.mSharedElementSourceNames;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return;
    L7:
        if (r5 == false) goto L9;
        String r7 = r6.mSharedElementTargetNames.get(0);
    L10:
        View r8 = r4.get(r7);
        r1.setEpicenter(r2, r8);
        if (r3 == null) goto L16;
        r1.setEpicenter(r3, r8);
        return;
    L16:
        return;
    L9:
        r7 = r6.mSharedElementSourceNames.get(0);
        goto L10
    }

    public static void setViewVisibility(ArrayList<View> r2, int r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        int r0 = r2.size() - 1;
    L5:
        if (r0 < 0) goto L7;
        r2.get(r0).setVisibility(r3);
        r0 = r0 - 1;
        goto L5
    }

    public static void startTransitions(FragmentManagerImpl r7, ArrayList<BackStackRecord> r8, ArrayList<Boolean> r9, int r10, int r11, boolean r12) {
        if (r7.mCurState >= 1) goto L5;
        return;
    L5:
        SparseArray r0 = new SparseArray();
        int r1 = r10;
    L6:
        if (r1 >= r11) goto L13;
        BackStackRecord r2 = r8.get(r1);
        if (r9.get(r1).booleanValue() == false) goto L10;
        calculatePopFragments(r2, r0, r12);
    L11:
        r1 = r1 + 1;
        goto L6
    L10:
        calculateFragments(r2, r0, r12);
        goto L11
    L13:
        if (r0.size() == 0) goto L21;
        View r3 = new View(r7.mHost.getContext());
        int r4 = r0.size();
        int r5 = 0;
    L15:
        if (r5 >= r4) goto L28;
        int r6 = r0.keyAt(r5);
        ArrayMap<String, String> r13 = calculateNameOverrides(r6, r8, r9, r10, r11);
        FragmentContainerTransition r14 = (FragmentContainerTransition) r0.valueAt(r5);
        if (r12 == false) goto L19;
        configureTransitionsReordered(r7, r6, r14, r3, r13);
    L20:
        r5 = r5 + 1;
        goto L15
    L19:
        configureTransitionsOrdered(r7, r6, r14, r3, r13);
        goto L20
    L28:
        return;
    }

    public static boolean supportsTransition() {
        if (PLATFORM_IMPL == null) goto L5;
    L8:
        return true;
    L5:
        if (SUPPORT_IMPL != null) goto L8;
        return false;
    }
}
