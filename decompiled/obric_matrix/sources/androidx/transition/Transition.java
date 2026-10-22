package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public abstract class Transition implements Cloneable {
    static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER = null;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final PathMotion STRAIGHT_PATH_MOTION = null;
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators;
    private ArrayList<Animator> mAnimators;
    boolean mCanRemoveViews;
    ArrayList<Animator> mCurrentAnimators;
    long mDuration;
    private TransitionValuesMaps mEndValues;
    private ArrayList<TransitionValues> mEndValuesList;
    private boolean mEnded;
    private EpicenterCallback mEpicenterCallback;
    private TimeInterpolator mInterpolator;
    private ArrayList<TransitionListener> mListeners;
    private int[] mMatchOrder;
    private String mName;
    private ArrayMap<String, String> mNameOverrides;
    private int mNumInstances;
    TransitionSet mParent;
    private PathMotion mPathMotion;
    private boolean mPaused;
    TransitionPropagation mPropagation;
    private long mStartDelay;
    private TransitionValuesMaps mStartValues;
    private ArrayList<TransitionValues> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes;
    private ArrayList<View> mTargetExcludes;
    private ArrayList<Integer> mTargetIdChildExcludes;
    private ArrayList<Integer> mTargetIdExcludes;
    ArrayList<Integer> mTargetIds;
    private ArrayList<String> mTargetNameExcludes;
    private ArrayList<String> mTargetNames;
    private ArrayList<Class<?>> mTargetTypeChildExcludes;
    private ArrayList<Class<?>> mTargetTypeExcludes;
    private ArrayList<Class<?>> mTargetTypes;
    ArrayList<View> mTargets;

    private static class AnimationInfo {
        String mName;
        Transition mTransition;
        TransitionValues mValues;
        View mView;
        WindowIdImpl mWindowId;

        AnimationInfo(View r1, String r2, Transition r3, WindowIdImpl r4, TransitionValues r5) {
            this.mView = r1;
            this.mName = r2;
            this.mValues = r5;
            this.mWindowId = r4;
            this.mTransition = r3;
        }
    }

    private static class ArrayListManager {
        private ArrayListManager() {
        }

        static <T> ArrayList<T> add(ArrayList<T> r1, T r2) {
            if (r1 != null) goto L5;
            r1 = new ArrayList();
        L5:
            if (r1.contains(r2) == true) goto L7;
            r1.add(r2);
        L7:
            return r1;
        }

        static <T> ArrayList<T> remove(ArrayList<T> r0, T r1) {
            if (r0 == null) goto L7;
            r0.remove(r1);
            if (r0.isEmpty() == false) goto L8;
            return null;
        L8:
            return r0;
        L7:
            return r0;
        }
    }

    public static abstract class EpicenterCallback {
        public EpicenterCallback() {
        }

        public abstract Rect onGetEpicenter(@NonNull Transition r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface MatchOrder {
    }

    public interface TransitionListener {
        void onTransitionCancel(@NonNull Transition r1);

        void onTransitionEnd(@NonNull Transition r1);

        void onTransitionPause(@NonNull Transition r1);

        void onTransitionResume(@NonNull Transition r1);

        void onTransitionStart(@NonNull Transition r1);
    }

    static {
        DEFAULT_MATCH_ORDER = new int[]{2, 1, 3, 4};
        STRAIGHT_PATH_MOTION = new AnonymousClass1();
        sRunningAnimators = new ThreadLocal();
    }

    public Transition() {
        this.mName = getClass().getName();
        this.mStartDelay = -1;
        this.mDuration = -1;
        this.mInterpolator = null;
        this.mTargetIds = new ArrayList();
        this.mTargets = new ArrayList();
        this.mTargetNames = null;
        this.mTargetTypes = null;
        this.mTargetIdExcludes = null;
        this.mTargetExcludes = null;
        this.mTargetTypeExcludes = null;
        this.mTargetNameExcludes = null;
        this.mTargetIdChildExcludes = null;
        this.mTargetChildExcludes = null;
        this.mTargetTypeChildExcludes = null;
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mParent = null;
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = new ArrayList();
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mListeners = null;
        this.mAnimators = new ArrayList();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(@NonNull Context r9, @NonNull AttributeSet r10) {
        this.mName = getClass().getName();
        this.mStartDelay = -1;
        this.mDuration = -1;
        this.mInterpolator = null;
        this.mTargetIds = new ArrayList();
        this.mTargets = new ArrayList();
        this.mTargetNames = null;
        this.mTargetTypes = null;
        this.mTargetIdExcludes = null;
        this.mTargetExcludes = null;
        this.mTargetTypeExcludes = null;
        this.mTargetNameExcludes = null;
        this.mTargetIdChildExcludes = null;
        this.mTargetChildExcludes = null;
        this.mTargetTypeChildExcludes = null;
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mParent = null;
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = new ArrayList();
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mListeners = null;
        this.mAnimators = new ArrayList();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
        TypedArray r0 = r9.obtainStyledAttributes(r10, Styleable.TRANSITION);
        XmlResourceParser r11 = (XmlResourceParser) r10;
        long r2 = TypedArrayUtils.getNamedInt(r0, r11, TypedValues.TransitionType.S_DURATION, 1, -1);
        if (r2 < 0) goto L5;
        setDuration(r2);
    L5:
        long r3 = TypedArrayUtils.getNamedInt(r0, r11, "startDelay", 2, -1);
        if (r3 <= 0) goto L8;
        setStartDelay(r3);
    L8:
        int r1 = TypedArrayUtils.getNamedResourceId(r0, r11, "interpolator", 0, 0);
        if (r1 <= 0) goto L11;
        setInterpolator(AnimationUtils.loadInterpolator(r9, r1));
    L11:
        String r12 = TypedArrayUtils.getNamedString(r0, r11, "matchOrder", 3);
        if (r12 == null) goto L14;
        setMatchOrder(parseMatchOrder(r12));
    L14:
        r0.recycle();
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> r6, ArrayMap<View, TransitionValues> r7) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= r6.size()) goto L10;
        TransitionValues r2 = r6.valueAt(r1);
        if (isValidTarget(r2.view) == false) goto L8;
        this.mStartValuesList.add(r2);
        this.mEndValuesList.add(null);
    L8:
        r1 = r1 + 1;
    L10:
        if (r0 >= r7.size()) goto L15;
        TransitionValues r8 = r7.valueAt(r0);
        if (isValidTarget(r8.view) == false) goto L14;
        this.mEndValuesList.add(r8);
        this.mStartValuesList.add(null);
    L14:
        r0 = r0 + 1;
        goto L10
    }

    private static void addViewValues(TransitionValuesMaps r3, View r4, TransitionValues r5) {
        r3.mViewValues.put(r4, r5);
        int r6 = r4.getId();
        if (r6 >= 0) goto L5;
    L8:
        String r7 = ViewCompat.getTransitionName(r4);
        if (r7 == null) goto L15;
        if (r3.mNameValues.containsKey(r7) == false) goto L13;
        r3.mNameValues.put(r7, null);
        goto L15
    L13:
        r3.mNameValues.put(r7, r4);
    L15:
        if ((r4.getParent() instanceof ListView) == false) goto L25;
        ListView r8 = (ListView) r4.getParent();
        if (r8.getAdapter().hasStableIds() == false) goto L26;
        long r1 = r8.getItemIdAtPosition(r8.getPositionForView(r4));
        if (r3.mItemIdValues.indexOfKey(r1) < 0) goto L23;
        View r9 = r3.mItemIdValues.get(r1);
        if (r9 == null) goto L27;
        ViewCompat.setHasTransientState(r9, false);
        r3.mItemIdValues.put(r1, null);
        return;
    L27:
        return;
    L23:
        ViewCompat.setHasTransientState(r4, true);
        r3.mItemIdValues.put(r1, r4);
        return;
    L26:
        return;
    L25:
        return;
    L5:
        if (r3.mIdValues.indexOfKey(r6) < 0) goto L7;
        r3.mIdValues.put(r6, null);
        goto L8
    L7:
        r3.mIdValues.put(r6, r4);
        goto L8
    }

    private static boolean alreadyContains(int[] r4, int r5) {
        int r0 = r4[r5];
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L9;
        if (r4[r2] == r0) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void captureHierarchy(View r6, boolean r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        int r0 = r6.getId();
        ArrayList<Integer> r1 = this.mTargetIdExcludes;
        if (r1 != null) goto L7;
    L9:
        ArrayList<View> r2 = this.mTargetExcludes;
        if (r2 != null) goto L12;
    L14:
        ArrayList<Class<?>> r3 = this.mTargetTypeExcludes;
        int r4 = 0;
        if (r3 == null) goto L23;
        int r5 = r3.size();
        int r8 = 0;
    L17:
        if (r8 >= r5) goto L23;
        if (this.mTargetTypeExcludes.get(r8).isInstance(r6) == true) goto L20;
        r8 = r8 + 1;
        goto L17
    L20:
        return;
    L23:
        if ((r6.getParent() instanceof ViewGroup) == false) goto L34;
        TransitionValues r9 = new TransitionValues(r6);
        if (r7 == false) goto L27;
        captureStartValues(r9);
    L28:
        r9.mTargetedTransitions.add(this);
        capturePropagationValues(r9);
        if (r7 == false) goto L31;
        TransitionValuesMaps r10 = this.mStartValues;
    L32:
        addViewValues(r10, r6, r9);
        goto L34
    L31:
        r10 = this.mEndValues;
        goto L32
    L27:
        captureEndValues(r9);
    L34:
        if ((r6 instanceof ViewGroup) == false) goto L57;
        ArrayList<Integer> r11 = this.mTargetIdChildExcludes;
        if (r11 != null) goto L38;
    L40:
        ArrayList<View> r12 = this.mTargetChildExcludes;
        if (r12 != null) goto L43;
    L45:
        ArrayList<Class<?>> r13 = this.mTargetTypeChildExcludes;
        if (r13 == null) goto L53;
        int r14 = r13.size();
        int r15 = 0;
    L48:
        if (r15 >= r14) goto L53;
        if (this.mTargetTypeChildExcludes.get(r15).isInstance(r6) == true) goto L51;
        r15 = r15 + 1;
        goto L48
    L51:
        return;
    L53:
        ViewGroup r16 = (ViewGroup) r6;
    L55:
        if (r4 >= r16.getChildCount()) goto L63;
        captureHierarchy(r16.getChildAt(r4), r7);
        r4 = r4 + 1;
        goto L55
    L63:
        return;
    L43:
        if (r12.contains(r6) == false) goto L45;
        return;
    L38:
        if (r11.contains(Integer.valueOf(r0)) == false) goto L40;
        return;
    L57:
        return;
    L12:
        if (r2.contains(r6) == false) goto L14;
        return;
    L7:
        if (r1.contains(Integer.valueOf(r0)) == false) goto L9;
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> r1, int r2, boolean r3) {
        if (r2 <= 0) goto L8;
        Integer r0 = Integer.valueOf(r2);
        if (r3 == false) goto L7;
        return ArrayListManager.add(r1, r0);
    L7:
        return ArrayListManager.remove(r1, r0);
    L8:
        return r1;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> r0, T r1, boolean r2) {
        if (r1 == null) goto L7;
        if (r2 == false) goto L6;
        return ArrayListManager.add(r0, r1);
    L6:
        return ArrayListManager.remove(r0, r1);
    L7:
        return r0;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> r1, Class<?> r2, boolean r3) {
        if (r2 == null) goto L7;
        if (r3 == false) goto L6;
        return ArrayListManager.add(r1, r2);
    L6:
        return ArrayListManager.remove(r1, r2);
    L7:
        return r1;
    }

    private ArrayList<View> excludeView(ArrayList<View> r1, View r2, boolean r3) {
        if (r2 == null) goto L7;
        if (r3 == false) goto L6;
        return ArrayListManager.add(r1, r2);
    L6:
        return ArrayListManager.remove(r1, r2);
    L7:
        return r1;
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> r0 = sRunningAnimators.get();
        if (r0 != null) goto L6;
        ArrayMap<Animator, AnimationInfo> r1 = new ArrayMap();
        sRunningAnimators.set(r1);
        return r1;
    L6:
        return r0;
    }

    private static boolean isValidMatch(int r2) {
        if (r2 >= 1) goto L5;
    L7:
        return false;
    L5:
        if (r2 > 4) goto L7;
        return true;
    }

    private static boolean isValueChanged(TransitionValues r0, TransitionValues r1, String r2) {
        Object r3 = r0.values.get(r2);
        Object r4 = r1.values.get(r2);
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r3 == null) goto L12;
        if (r4 != null) goto L10;
        return true;
    L10:
        return true ^ r3.equals(r4);
    L12:
        return true;
    }

    private void matchIds(ArrayMap<View, TransitionValues> r8, ArrayMap<View, TransitionValues> r9, SparseArray<View> r10, SparseArray<View> r11) {
        int r0 = r10.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L17;
        View r2 = r10.valueAt(r1);
        if (r2 == null) goto L16;
        if (isValidTarget(r2) == false) goto L16;
        View r3 = r11.get(r10.keyAt(r1));
        if (r3 == null) goto L16;
        if (isValidTarget(r3) == false) goto L16;
        TransitionValues r4 = r8.get(r2);
        TransitionValues r5 = r9.get(r3);
        if (r4 == null) goto L16;
        if (r5 == null) goto L16;
        this.mStartValuesList.add(r4);
        this.mEndValuesList.add(r5);
        r8.remove(r2);
        r9.remove(r3);
    L16:
        r1 = r1 + 1;
        goto L3
    }

    private void matchInstances(ArrayMap<View, TransitionValues> r5, ArrayMap<View, TransitionValues> r6) {
        int r0 = r5.size() - 1;
    L3:
        if (r0 < 0) goto L14;
        View r1 = r5.keyAt(r0);
        if (r1 == null) goto L13;
        if (isValidTarget(r1) == false) goto L13;
        TransitionValues r2 = r6.remove(r1);
        if (r2 == null) goto L13;
        if (isValidTarget(r2.view) == false) goto L13;
        this.mStartValuesList.add(r5.removeAt(r0));
        this.mEndValuesList.add(r2);
    L13:
        r0 = r0 - 1;
        goto L3
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> r8, ArrayMap<View, TransitionValues> r9, LongSparseArray<View> r10, LongSparseArray<View> r11) {
        int r0 = r10.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L17;
        View r2 = r10.valueAt(r1);
        if (r2 == null) goto L16;
        if (isValidTarget(r2) == false) goto L16;
        View r3 = r11.get(r10.keyAt(r1));
        if (r3 == null) goto L16;
        if (isValidTarget(r3) == false) goto L16;
        TransitionValues r4 = r8.get(r2);
        TransitionValues r5 = r9.get(r3);
        if (r4 == null) goto L16;
        if (r5 == null) goto L16;
        this.mStartValuesList.add(r4);
        this.mEndValuesList.add(r5);
        r8.remove(r2);
        r9.remove(r3);
    L16:
        r1 = r1 + 1;
        goto L3
    }

    private void matchNames(ArrayMap<View, TransitionValues> r8, ArrayMap<View, TransitionValues> r9, ArrayMap<String, View> r10, ArrayMap<String, View> r11) {
        int r0 = r10.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L17;
        View r2 = r10.valueAt(r1);
        if (r2 == null) goto L16;
        if (isValidTarget(r2) == false) goto L16;
        View r3 = r11.get(r10.keyAt(r1));
        if (r3 == null) goto L16;
        if (isValidTarget(r3) == false) goto L16;
        TransitionValues r4 = r8.get(r2);
        TransitionValues r5 = r9.get(r3);
        if (r4 == null) goto L16;
        if (r5 == null) goto L16;
        this.mStartValuesList.add(r4);
        this.mEndValuesList.add(r5);
        r8.remove(r2);
        r9.remove(r3);
    L16:
        r1 = r1 + 1;
        goto L3
    }

    private void matchStartAndEnd(TransitionValuesMaps r6, TransitionValuesMaps r7) {
        ArrayMap<View, TransitionValues> r0 = new ArrayMap(r6.mViewValues);
        ArrayMap<View, TransitionValues> r1 = new ArrayMap(r7.mViewValues);
        int r2 = 0;
    L3:
        int[] r3 = this.mMatchOrder;
        if (r2 >= r3.length) goto L19;
        int r4 = r3[r2];
        if (r4 != 1) goto L8;
        matchInstances(r0, r1);
    L18:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r4 != 2) goto L10;
        matchNames(r0, r1, r6.mNameValues, r7.mNameValues);
        goto L18
    L10:
        if (r4 != 3) goto L12;
        matchIds(r0, r1, r6.mIdValues, r7.mIdValues);
        goto L18
    L12:
        if (r4 != 4) goto L18;
        matchItemIds(r0, r1, r6.mItemIdValues, r7.mItemIdValues);
        goto L18
    L19:
        addUnmatched(r0, r1);
    }

    private static int[] parseMatchOrder(String r6) {
        StringTokenizer r0 = new StringTokenizer(r6, ",");
        int[] r7 = new int[r0.countTokens()];
        int r2 = 0;
    L4:
        if (r0.hasMoreTokens() == false) goto L23;
        String r3 = r0.nextToken().trim();
        if (MATCH_ID_STR.equalsIgnoreCase(r3) == false) goto L9;
        r7[r2] = 3;
    L20:
        r2 = r2 + 1;
        goto L4
    L9:
        if (MATCH_INSTANCE_STR.equalsIgnoreCase(r3) == false) goto L12;
        r7[r2] = 1;
        goto L20
    L12:
        if (MATCH_NAME_STR.equalsIgnoreCase(r3) == false) goto L15;
        r7[r2] = 2;
        goto L20
    L15:
        if (MATCH_ITEM_ID_STR.equalsIgnoreCase(r3) == false) goto L18;
        r7[r2] = 4;
        goto L20
    L18:
        if (r3.isEmpty() == false) goto L22;
        int[] r4 = new int[r7.length - 1];
        System.arraycopy(r7, 0, r4, 0, r2);
        r2 = r2 - 1;
        r7 = r4;
        goto L20
    L22:
        throw new InflateException("Unknown match type in matchOrder: '" + r3 + "'");
    L23:
        return r7;
    }

    private void runAnimator(Animator r2, final ArrayMap<Animator, AnimationInfo> r3) {
        if (r2 == null) goto L5;
        r2.addListener(new AnonymousClass2(this, r3));
        animate(r2);
        return;
    }

    @NonNull
    public Transition addListener(@NonNull TransitionListener r2) {
        if (this.mListeners != null) goto L5;
        this.mListeners = new ArrayList();
    L5:
        this.mListeners.add(r2);
        return this;
    }

    @NonNull
    public Transition addTarget(@IdRes int r2) {
        if (r2 == 0) goto L4;
        this.mTargetIds.add(Integer.valueOf(r2));
    L4:
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull View r2) {
        this.mTargets.add(r2);
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull Class<?> r2) {
        if (this.mTargetTypes != null) goto L5;
        this.mTargetTypes = new ArrayList();
    L5:
        this.mTargetTypes.add(r2);
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull String r2) {
        if (this.mTargetNames != null) goto L5;
        this.mTargetNames = new ArrayList();
    L5:
        this.mTargetNames.add(r2);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void animate(Animator r5) {
        if (r5 != null) goto L5;
        end();
        return;
    L5:
        if (getDuration() < 0) goto L8;
        r5.setDuration(getDuration());
    L8:
        if (getStartDelay() < 0) goto L11;
        r5.setStartDelay(getStartDelay() + r5.getStartDelay());
    L11:
        if (getInterpolator() == null) goto L13;
        r5.setInterpolator(getInterpolator());
    L13:
        r5.addListener(new AnonymousClass3(this));
        r5.start();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void cancel() {
        int r0 = this.mCurrentAnimators.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.mCurrentAnimators.get(r0).cancel();
        r0 = r0 - 1;
        goto L3
    L5:
        ArrayList<TransitionListener> r1 = this.mListeners;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.size() <= 0) goto L15;
        ArrayList r2 = (ArrayList) this.mListeners.clone();
        int r3 = r2.size();
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L16;
        ((TransitionListener) r2.get(r4)).onTransitionCancel(this);
        r4 = r4 + 1;
        goto L10
    L16:
        return;
    }

    public abstract void captureEndValues(@NonNull TransitionValues r1);

    void capturePropagationValues(TransitionValues r6) {
        if (this.mPropagation != null) goto L5;
        return;
    L5:
        if (r6.values.isEmpty() == true) goto L23;
        String[] r0 = this.mPropagation.getPropagationProperties();
        if (r0 != null) goto L9;
        return;
    L9:
        boolean r1 = false;
        int r2 = 0;
    L11:
        if (r2 >= r0.length) goto L16;
        if (r6.values.containsKey(r0[r2]) == false) goto L17;
        r2 = r2 + 1;
    L17:
        if (r1 == true) goto L24;
        this.mPropagation.captureValues(r6);
        return;
    L24:
        return;
    L16:
        r1 = true;
        goto L17
    }

    public abstract void captureStartValues(@NonNull TransitionValues r1);

    void captureValues(ViewGroup r6, boolean r7) {
        clearValues(r7);
        int r1 = 0;
        if (this.mTargetIds.size() <= 0) goto L5;
    L6:
        ArrayList<String> r0 = this.mTargetNames;
        if (r0 != null) goto L9;
    L10:
        ArrayList<Class<?>> r2 = this.mTargetTypes;
        if (r2 != null) goto L13;
    L16:
        int r3 = 0;
    L18:
        if (r3 >= this.mTargetIds.size()) goto L31;
        View r4 = r6.findViewById(this.mTargetIds.get(r3).intValue());
        if (r4 == null) goto L30;
        TransitionValues r5 = new TransitionValues(r4);
        if (r7 == false) goto L24;
        captureStartValues(r5);
    L25:
        r5.mTargetedTransitions.add(this);
        capturePropagationValues(r5);
        if (r7 == false) goto L28;
        TransitionValuesMaps r8 = this.mStartValues;
    L29:
        addViewValues(r8, r4, r5);
        goto L30
    L28:
        r8 = this.mEndValues;
        goto L29
    L24:
        captureEndValues(r5);
    L30:
        r3 = r3 + 1;
        goto L18
    L31:
        int r9 = 0;
    L33:
        if (r9 >= this.mTargets.size()) goto L43;
        View r10 = this.mTargets.get(r9);
        TransitionValues r11 = new TransitionValues(r10);
        if (r7 == false) goto L37;
        captureStartValues(r11);
    L38:
        r11.mTargetedTransitions.add(this);
        capturePropagationValues(r11);
        if (r7 == false) goto L41;
        TransitionValuesMaps r12 = this.mStartValues;
    L42:
        addViewValues(r12, r10, r11);
        r9 = r9 + 1;
        goto L33
    L41:
        r12 = this.mEndValues;
        goto L42
    L37:
        captureEndValues(r11);
    L43:
        if (r7 == true) goto L54;
        ArrayMap<String, String> r13 = this.mNameOverrides;
        if (r13 == null) goto L65;
        int r14 = r13.size();
        ArrayList r15 = new ArrayList(r14);
        int r16 = 0;
    L47:
        if (r16 >= r14) goto L49;
        r15.add(this.mStartValues.mNameValues.remove(this.mNameOverrides.keyAt(r16)));
        r16 = r16 + 1;
    L49:
        if (r1 >= r14) goto L66;
        View r17 = (View) r15.get(r1);
        if (r17 == null) goto L53;
        this.mStartValues.mNameValues.put(this.mNameOverrides.valueAt(r1), r17);
    L53:
        r1 = r1 + 1;
        goto L49
    L66:
        return;
    L65:
        return;
    L54:
        return;
    L13:
        if (r2.isEmpty() == true) goto L16;
    L15:
        captureHierarchy(r6, r7);
        goto L43
    L9:
        if (r0.isEmpty() == false) goto L15;
    L5:
        if (this.mTargets.size() <= 0) goto L15;
        goto L6
    }

    void clearValues(boolean r1) {
        if (r1 == false) goto L4;
        this.mStartValues.mViewValues.clear();
        this.mStartValues.mIdValues.clear();
        TransitionValuesMaps r0 = this.mStartValues;
    L5:
        r0.mItemIdValues.clear();
        return;
    L4:
        this.mEndValues.mViewValues.clear();
        this.mEndValues.mIdValues.clear();
        r0 = this.mEndValues;
        goto L5
    }

    public Transition clone() {
        Transition r2 = (Transition) super.clone();     // Catch: CloneNotSupportedException -> L5
        r2.mAnimators = new ArrayList();     // Catch: CloneNotSupportedException -> L5
        r2.mStartValues = new TransitionValuesMaps();     // Catch: CloneNotSupportedException -> L5
        r2.mEndValues = new TransitionValuesMaps();     // Catch: CloneNotSupportedException -> L5
        r2.mStartValuesList = null;     // Catch: CloneNotSupportedException -> L5
        r2.mEndValuesList = null;     // Catch: CloneNotSupportedException -> L5
        return r2;
    L5:
        return null;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo43clone() {
        return clone();
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r1, @Nullable TransitionValues r2, @Nullable TransitionValues r3) {
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void createAnimators(ViewGroup r21, TransitionValuesMaps r22, TransitionValuesMaps r23, ArrayList<TransitionValues> r24, ArrayList<TransitionValues> r25) {
        ArrayMap<Animator, AnimationInfo> r8 = getRunningAnimators();
        SparseIntArray r9 = new SparseIntArray();
        int r10 = r24.size();
        long r0 = LocationRequestCompat.PASSIVE_INTERVAL;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L60;
        TransitionValues r2 = r24.get(r12);
        TransitionValues r3 = r25.get(r12);
        if (r2 != null) goto L7;
    L9:
        if (r3 != null) goto L11;
    L13:
        if (r2 != null) goto L16;
        if (r3 != null) goto L16;
    L15:
        int r16 = r10;
        int r18 = r12;
    L58:
        r12 = r18 + 1;
        r10 = r16;
    L16:
        if (r2 == null) goto L22;
        if (r3 == null) goto L22;
        if (isTransitionRequired(r2, r3) == true) goto L22;
        boolean r5 = false;
    L23:
        if (r5 == false) goto L15;
        Animator r6 = createAnimator(r21, r2, r3);
        if (r6 == null) goto L15;
        if (r3 == null) goto L52;
        View r15 = r3.view;
        String[] r4 = getTransitionProperties();
        if (r4 != null) goto L30;
    L50:
        r16 = r10;
        r18 = r12;
        Animator r7 = r6;
        TransitionValues r11 = null;
    L51:
        Animator r13 = r7;
        TransitionValues r14 = r11;
    L53:
        if (r13 == null) goto L58;
        TransitionPropagation r17 = this.mPropagation;
        if (r17 == null) goto L57;
        long r19 = r17.getStartDelay(r21, this, r2, r3);
        r9.put(this.mAnimators.size(), (int) r19);
        r0 = Math.min(r19, r0);
    L57:
        long r110 = r0;
        View r1 = r15;
        r8.put(r13, new AnimationInfo(r1, getName(), this, ViewUtils.getWindowId(r21), r14));
        this.mAnimators.add(r13);
        r0 = r110;
        goto L58
    L30:
        if (r4.length <= 0) goto L50;
        r11 = new TransitionValues(r15);
        r16 = r10;
        TransitionValues r20 = r23.mViewValues.get(r15);
        if (r20 == null) goto L37;
        int r111 = 0;
    L35:
        if (r111 >= r4.length) goto L37;
        int r112 = r12;
        TransitionValues r113 = r20;
        r11.values.put(r4[r111], r20.values.get(r4[r111]));
        r111 = r111 + 1;
        r12 = r112;
        r20 = r113;
    L37:
        r18 = r12;
        int r26 = r8.size();
        int r27 = 0;
    L38:
        if (r27 >= r26) goto L49;
        AnimationInfo r114 = r8.get(r8.keyAt(r27));
        if (r114.mValues == null) goto L48;
        if (r114.mView != r15) goto L48;
        if (r114.mName.equals(getName()) == false) goto L48;
        if (r114.mValues.equals(r11) == false) goto L48;
        r7 = null;
    L48:
        r27 = r27 + 1;
        goto L38
    L49:
        r7 = r6;
        goto L51
    L52:
        r16 = r10;
        r18 = r12;
        r15 = r2.view;
        r13 = r6;
        r14 = null;
    L22:
        r5 = true;
        goto L23
    L11:
        if (r3.mTargetedTransitions.contains(this) == true) goto L13;
        r3 = null;
        goto L13
    L7:
        if (r2.mTargetedTransitions.contains(this) == true) goto L9;
        r2 = null;
        goto L9
    L60:
        if (r9.size() == 0) goto L65;
        int r115 = 0;
    L63:
        if (r115 >= r9.size()) goto L78;
        int r28 = r9.keyAt(r115);
        Animator r29 = this.mAnimators.get(r28);
        r29.setStartDelay((((long) r9.valueAt(r115)) - r0) + r29.getStartDelay());
        r115 = r115 + 1;
        goto L63
    L78:
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void end() {
        int r0 = this.mNumInstances - 1;
        this.mNumInstances = r0;
        if (r0 != 0) goto L34;
        ArrayList<TransitionListener> r1 = this.mListeners;
        if (r1 != null) goto L7;
    L11:
        int r2 = 0;
    L13:
        if (r2 >= this.mStartValues.mItemIdValues.size()) goto L18;
        View r3 = this.mStartValues.mItemIdValues.valueAt(r2);
        if (r3 == null) goto L17;
        ViewCompat.setHasTransientState(r3, false);
    L17:
        r2 = r2 + 1;
        goto L13
    L18:
        int r4 = 0;
    L20:
        if (r4 >= this.mEndValues.mItemIdValues.size()) goto L25;
        View r5 = this.mEndValues.mItemIdValues.valueAt(r4);
        if (r5 == null) goto L24;
        ViewCompat.setHasTransientState(r5, false);
    L24:
        r4 = r4 + 1;
        goto L20
    L25:
        this.mEnded = true;
        return;
    L7:
        if (r1.size() <= 0) goto L11;
        ArrayList r6 = (ArrayList) this.mListeners.clone();
        int r7 = r6.size();
        int r8 = 0;
    L9:
        if (r8 >= r7) goto L11;
        ((TransitionListener) r6.get(r8)).onTransitionEnd(this);
        r8 = r8 + 1;
        goto L9
    }

    @NonNull
    public Transition excludeChildren(@IdRes int r2, boolean r3) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, r2, r3);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@NonNull View r2, boolean r3) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, r2, r3);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@NonNull Class<?> r2, boolean r3) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, r2, r3);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@IdRes int r2, boolean r3) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, r2, r3);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull View r2, boolean r3) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, r2, r3);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull Class<?> r2, boolean r3) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, r2, r3);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull String r2, boolean r3) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, r2, r3);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void forceToEnd(ViewGroup r4) {
        ArrayMap<Animator, AnimationInfo> r3 = getRunningAnimators();
        int r0 = r3.size();
        if (r4 == null) goto L15;
        if (r0 == 0) goto L21;
        WindowIdImpl r5 = ViewUtils.getWindowId(r4);
        ArrayMap r1 = new ArrayMap(r3);
        r3.clear();
        int r2 = r0 - 1;
    L7:
        if (r2 < 0) goto L22;
        AnimationInfo r6 = (AnimationInfo) r1.valueAt(r2);
        if (r6.mView == null) goto L14;
        if (r5 == null) goto L14;
        if (r5.equals(r6.mWindowId) == false) goto L14;
        ((Animator) r1.keyAt(r2)).end();
    L14:
        r2 = r2 - 1;
        goto L7
    L22:
        return;
    L21:
        return;
    }

    public long getDuration() {
        return this.mDuration;
    }

    @Nullable
    public Rect getEpicenter() {
        EpicenterCallback r0 = this.mEpicenterCallback;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.onGetEpicenter(this);
    }

    @Nullable
    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    TransitionValues getMatchedTransitionValues(View r7, boolean r8) {
        TransitionSet r0 = this.mParent;
        if (r0 != null) goto L5;
        if (r8 == false) goto L8;
        ArrayList<TransitionValues> r1 = this.mStartValuesList;
    L10:
        if (r1 != null) goto L12;
        return null;
    L12:
        int r2 = r1.size();
        int r3 = -1;
        int r4 = 0;
    L13:
        if (r4 >= r2) goto L21;
        TransitionValues r5 = r1.get(r4);
        if (r5 == null) goto L16;
        if (r5.view == r7) goto L19;
        r4 = r4 + 1;
        goto L13
    L19:
        r3 = r4;
        goto L21
    L16:
        return null;
    L21:
        if (r3 < 0) goto L30;
        if (r8 == false) goto L24;
        ArrayList<TransitionValues> r6 = this.mEndValuesList;
    L26:
        return r6.get(r3);
    L24:
        r6 = this.mStartValuesList;
        goto L26
    L30:
        return null;
    L8:
        r1 = this.mEndValuesList;
        goto L10
    L5:
        return r0.getMatchedTransitionValues(r7, r8);
    }

    @NonNull
    public String getName() {
        return this.mName;
    }

    @NonNull
    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    @Nullable
    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    @NonNull
    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    @Nullable
    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    @Nullable
    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    @NonNull
    public List<View> getTargets() {
        return this.mTargets;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return null;
    }

    @Nullable
    public TransitionValues getTransitionValues(@NonNull View r2, boolean r3) {
        TransitionSet r0 = this.mParent;
        if (r0 != null) goto L5;
        if (r3 == false) goto L8;
        TransitionValuesMaps r1 = this.mStartValues;
    L10:
        return r1.mViewValues.get(r2);
    L8:
        r1 = this.mEndValues;
        goto L10
    L5:
        return r0.getTransitionValues(r2, r3);
    }

    public boolean isTransitionRequired(@Nullable TransitionValues r6, @Nullable TransitionValues r7) {
        if (r6 == null) goto L25;
        if (r7 == null) goto L26;
        String[] r5 = getTransitionProperties();
        if (r5 == null) goto L13;
        int r2 = r5.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L27;
        if (isValueChanged(r6, r7, r5[r3]) == true) goto L19;
        r3 = r3 + 1;
    L19:
        return true;
    L27:
        return false;
    L13:
        Iterator<String> r8 = r6.values.keySet().iterator();
    L15:
        if (r8.hasNext() == false) goto L28;
        if (isValueChanged(r6, r7, r8.next()) == false) goto L15;
    L28:
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    boolean isValidTarget(View r6) {
        int r0 = r6.getId();
        ArrayList<Integer> r1 = this.mTargetIdExcludes;
        if (r1 != null) goto L5;
    L7:
        ArrayList<View> r2 = this.mTargetExcludes;
        if (r2 != null) goto L10;
    L12:
        ArrayList<Class<?>> r3 = this.mTargetTypeExcludes;
        if (r3 == null) goto L21;
        int r4 = r3.size();
        int r5 = 0;
    L15:
        if (r5 >= r4) goto L21;
        if (this.mTargetTypeExcludes.get(r5).isInstance(r6) == true) goto L18;
        r5 = r5 + 1;
        goto L15
    L18:
        return false;
    L21:
        if (this.mTargetNameExcludes == null) goto L28;
        if (ViewCompat.getTransitionName(r6) == null) goto L28;
        if (this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(r6)) == false) goto L28;
        return false;
    L28:
        if (this.mTargetIds.size() != 0) goto L41;
        if (this.mTargets.size() != 0) goto L41;
        ArrayList<Class<?>> r7 = this.mTargetTypes;
        if (r7 != null) goto L34;
    L35:
        ArrayList<String> r8 = this.mTargetNames;
        if (r8 != null) goto L38;
    L39:
        return true;
    L38:
        if (r8.isEmpty() == false) goto L41;
    L34:
        if (r7.isEmpty() == true) goto L35;
    L41:
        if (this.mTargetIds.contains(Integer.valueOf(r0)) == false) goto L43;
    L60:
        return true;
    L43:
        if (this.mTargets.contains(r6) == true) goto L60;
        ArrayList<String> r9 = this.mTargetNames;
        if (r9 == null) goto L51;
        if (r9.contains(ViewCompat.getTransitionName(r6)) == false) goto L51;
        return true;
    L51:
        if (this.mTargetTypes == null) goto L59;
        int r10 = 0;
    L54:
        if (r10 >= this.mTargetTypes.size()) goto L59;
        if (this.mTargetTypes.get(r10).isInstance(r6) == true) goto L57;
        r10 = r10 + 1;
        goto L54
    L57:
        return true;
    L59:
        return false;
    L10:
        if (r2.contains(r6) == false) goto L12;
        return false;
    L5:
        if (r1.contains(Integer.valueOf(r0)) == false) goto L7;
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View r5) {
        if (this.mEnded == true) goto L18;
        int r6 = this.mCurrentAnimators.size() - 1;
    L5:
        if (r6 < 0) goto L7;
        AnimatorUtils.pause(this.mCurrentAnimators.get(r6));
        r6 = r6 - 1;
        goto L5
    L7:
        ArrayList<TransitionListener> r7 = this.mListeners;
        if (r7 != null) goto L10;
    L14:
        this.mPaused = true;
        return;
    L10:
        if (r7.size() <= 0) goto L14;
        ArrayList r8 = (ArrayList) this.mListeners.clone();
        int r1 = r8.size();
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L14;
        ((TransitionListener) r8.get(r2)).onTransitionPause(this);
        r2 = r2 + 1;
        goto L12
    }

    void playTransition(ViewGroup r11) {
        this.mStartValuesList = new ArrayList();
        this.mEndValuesList = new ArrayList();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, AnimationInfo> r0 = getRunningAnimators();
        int r1 = r0.size();
        WindowIdImpl r2 = ViewUtils.getWindowId(r11);
        int r3 = r1 - 1;
    L3:
        if (r3 < 0) goto L31;
        Animator r4 = r0.keyAt(r3);
        if (r4 == null) goto L30;
        AnimationInfo r5 = r0.get(r4);
        if (r5 == null) goto L30;
        if (r5.mView == null) goto L30;
        if (r2.equals(r5.mWindowId) == false) goto L30;
        TransitionValues r6 = r5.mValues;
        View r7 = r5.mView;
        TransitionValues r8 = getTransitionValues(r7, true);
        TransitionValues r9 = getMatchedTransitionValues(r7, true);
        if (r8 != null) goto L16;
        if (r9 != null) goto L16;
        r9 = this.mEndValues.mViewValues.get(r7);
    L16:
        if (r8 != null) goto L19;
        if (r9 != null) goto L19;
    L21:
        boolean r10 = false;
    L22:
        if (r10 == false) goto L30;
        if (r4.isRunning() == false) goto L26;
    L29:
        r4.cancel();
        goto L30
    L26:
        if (r4.isStarted() == true) goto L29;
        r0.remove(r4);
    L19:
        if (r5.mTransition.isTransitionRequired(r6, r9) == false) goto L21;
        r10 = true;
    L30:
        r3 = r3 - 1;
        goto L3
    L31:
        createAnimators(r11, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    @NonNull
    public Transition removeListener(@NonNull TransitionListener r2) {
        ArrayList<TransitionListener> r0 = this.mListeners;
        if (r0 != null) goto L5;
        return this;
    L5:
        r0.remove(r2);
        if (this.mListeners.size() != 0) goto L8;
        this.mListeners = null;
    L8:
        return this;
    }

    @NonNull
    public Transition removeTarget(@IdRes int r2) {
        if (r2 == 0) goto L4;
        this.mTargetIds.remove(Integer.valueOf(r2));
    L4:
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull View r2) {
        this.mTargets.remove(r2);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull Class<?> r2) {
        ArrayList<Class<?>> r0 = this.mTargetTypes;
        if (r0 == null) goto L5;
        r0.remove(r2);
    L5:
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull String r2) {
        ArrayList<String> r0 = this.mTargetNames;
        if (r0 == null) goto L5;
        r0.remove(r2);
    L5:
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View r5) {
        if (this.mPaused == true) goto L5;
        return;
    L5:
        if (this.mEnded == true) goto L16;
        int r6 = this.mCurrentAnimators.size() - 1;
    L7:
        if (r6 < 0) goto L9;
        AnimatorUtils.resume(this.mCurrentAnimators.get(r6));
        r6 = r6 - 1;
        goto L7
    L9:
        ArrayList<TransitionListener> r7 = this.mListeners;
        if (r7 == null) goto L16;
        if (r7.size() <= 0) goto L16;
        ArrayList r8 = (ArrayList) this.mListeners.clone();
        int r1 = r8.size();
        int r2 = 0;
    L14:
        if (r2 >= r1) goto L16;
        ((TransitionListener) r8.get(r2)).onTransitionResume(this);
        r2 = r2 + 1;
    L16:
        this.mPaused = false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void runAnimators() {
        start();
        ArrayMap<Animator, AnimationInfo> r0 = getRunningAnimators();
        Iterator<Animator> r1 = this.mAnimators.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Animator r2 = r1.next();
        if (r0.containsKey(r2) == false) goto L4;
        start();
        runAnimator(r2, r0);
        goto L4
    L8:
        this.mAnimators.clear();
        end();
    }

    void setCanRemoveViews(boolean r1) {
        this.mCanRemoveViews = r1;
    }

    @NonNull
    public Transition setDuration(long r1) {
        this.mDuration = r1;
        return this;
    }

    public void setEpicenterCallback(@Nullable EpicenterCallback r1) {
        this.mEpicenterCallback = r1;
    }

    @NonNull
    public Transition setInterpolator(@Nullable TimeInterpolator r1) {
        this.mInterpolator = r1;
        return this;
    }

    public void setMatchOrder(int... r3) {
        if (r3 != null) goto L4;
    L19:
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        return;
    L4:
        if (r3.length == 0) goto L19;
        int r0 = 0;
    L8:
        if (r0 >= r3.length) goto L18;
        if (isValidMatch(r3[r0]) == false) goto L17;
        if (alreadyContains(r3, r0) == true) goto L15;
        r0 = r0 + 1;
        goto L8
    L15:
        throw new IllegalArgumentException("matches contains a duplicate value");
    L17:
        throw new IllegalArgumentException("matches contains invalid value");
    L18:
        this.mMatchOrder = (int[]) r3.clone();
    }

    public void setPathMotion(@Nullable PathMotion r1) {
        if (r1 != null) goto L4;
        r1 = STRAIGHT_PATH_MOTION;
    L4:
        this.mPathMotion = r1;
    }

    public void setPropagation(@Nullable TransitionPropagation r1) {
        this.mPropagation = r1;
    }

    @NonNull
    public Transition setStartDelay(long r1) {
        this.mStartDelay = r1;
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void start() {
        if (this.mNumInstances != 0) goto L12;
        ArrayList<TransitionListener> r0 = this.mListeners;
        if (r0 != null) goto L7;
    L11:
        this.mEnded = false;
        goto L12
    L7:
        if (r0.size() <= 0) goto L11;
        ArrayList r1 = (ArrayList) this.mListeners.clone();
        int r2 = r1.size();
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L11;
        ((TransitionListener) r1.get(r3)).onTransitionStart(this);
        r3 = r3 + 1;
    L12:
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    String toString(String r7) {
        String r8 = r7 + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration == (-1)) goto L6;
        r8 = r8 + "dur(" + this.mDuration + ") ";
    L6:
        if (this.mStartDelay == (-1)) goto L9;
        r8 = r8 + "dly(" + this.mStartDelay + ") ";
    L9:
        if (this.mInterpolator == null) goto L12;
        r8 = r8 + "interp(" + this.mInterpolator + ") ";
    L12:
        if (this.mTargetIds.size() <= 0) goto L14;
    L15:
        String r9 = r8 + "tgts(";
        int r2 = 0;
        if (this.mTargetIds.size() <= 0) goto L24;
        int r0 = 0;
    L19:
        if (r0 >= this.mTargetIds.size()) goto L24;
        if (r0 <= 0) goto L22;
        r9 = r9 + ", ";
    L22:
        r9 = r9 + this.mTargetIds.get(r0);
        r0 = r0 + 1;
    L24:
        if (this.mTargets.size() <= 0) goto L31;
    L26:
        if (r2 >= this.mTargets.size()) goto L31;
        if (r2 <= 0) goto L29;
        r9 = r9 + ", ";
    L29:
        r9 = r9 + this.mTargets.get(r2);
        r2 = r2 + 1;
    L31:
        return r9 + ")";
    L14:
        if (this.mTargets.size() > 0) goto L15;
        return r8;
    }
}
