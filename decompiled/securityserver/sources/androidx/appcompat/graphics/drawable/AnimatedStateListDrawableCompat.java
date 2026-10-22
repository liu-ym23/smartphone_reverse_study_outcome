package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public class AnimatedStateListDrawableCompat extends StateListDrawable implements TintAwareDrawable {
    private static final String ELEMENT_ITEM = "item";
    private static final String ELEMENT_TRANSITION = "transition";
    private static final String ITEM_MISSING_DRAWABLE_ERROR = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String LOGTAG = "AnimatedStateListDrawableCompat";
    private static final String TRANSITION_MISSING_DRAWABLE_ERROR = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String TRANSITION_MISSING_FROM_TO_ID = ": <transition> tag requires 'fromId' & 'toId' attributes";
    private boolean mMutated;
    private AnimatedStateListState mState;
    private Transition mTransition;
    private int mTransitionFromIndex;
    private int mTransitionToIndex;

    /* JADX INFO: renamed from: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class AnimatableTransition extends Transition {
        private final Animatable mA;

        public AnimatableTransition(Animatable r2) {
            super(null);
            this.mA = r2;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            this.mA.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            this.mA.stop();
        }
    }

    public static class AnimatedStateListState extends StateListDrawable.StateListState {
        private static final long REVERSED_BIT = 4294967296L;
        private static final long REVERSIBLE_FLAG_BIT = 8589934592L;
        SparseArrayCompat<Integer> mStateIds;
        LongSparseArray<Long> mTransitions;

        public AnimatedStateListState(@Nullable AnimatedStateListState r1, @NonNull AnimatedStateListDrawableCompat r2, @Nullable Resources r3) {
            super(r1, r2, r3);
            if (r1 == null) goto L5;
            this.mTransitions = r1.mTransitions;
            this.mStateIds = r1.mStateIds;
            return;
        L5:
            this.mTransitions = new LongSparseArray();
            this.mStateIds = new SparseArrayCompat();
        }

        private static long generateTransitionKey(int r2, int r3) {
            long r0 = ((long) r2) << 32;
            return ((long) r3) | r0;
        }

        public int addStateSet(@NonNull int[] r1, @NonNull Drawable r2, int r3) {
            int r4 = super.addStateSet(r1, r2);
            this.mStateIds.put(r4, Integer.valueOf(r3));
            return r4;
        }

        public int addTransition(int r10, int r11, @NonNull Drawable r12, boolean r13) {
            int r14 = addChild(r12);
            long r0 = generateTransitionKey(r10, r11);
            if (r13 == false) goto L5;
            long r2 = REVERSIBLE_FLAG_BIT;
        L6:
            long r5 = r14;
            this.mTransitions.append(r0, Long.valueOf(r5 | r2));
            if (r13 == false) goto L9;
            this.mTransitions.append(generateTransitionKey(r11, r10), Long.valueOf((REVERSED_BIT | r5) | r2));
        L9:
            return r14;
        L5:
            r2 = 0;
            goto L6
        }

        public int getKeyframeIdAt(int r2) {
            if (r2 >= 0) goto L6;
            return 0;
        L6:
            return this.mStateIds.get(r2, 0).intValue();
        }

        public int indexOfKeyframe(@NonNull int[] r1) {
            int r2 = super.indexOfStateSet(r1);
            if (r2 < 0) goto L6;
            return r2;
        L6:
            return super.indexOfStateSet(StateSet.WILD_CARD);
        }

        public int indexOfTransition(int r3, int r4) {
            long r5 = generateTransitionKey(r3, r4);
            return (int) this.mTransitions.get(r5, -1L).longValue();
        }

        public boolean isTransitionReversed(int r3, int r4) {
            long r5 = generateTransitionKey(r3, r4);
            if ((this.mTransitions.get(r5, -1L).longValue() & REVERSED_BIT) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState, androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        public void mutate() {
            this.mTransitions = this.mTransitions.clone();
            this.mStateIds = this.mStateIds.clone();
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        public boolean transitionHasReversibleFlag(int r3, int r4) {
            long r5 = generateTransitionKey(r3, r4);
            if ((this.mTransitions.get(r5, -1L).longValue() & REVERSIBLE_FLAG_BIT) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources r2) {
            return new AnimatedStateListDrawableCompat(this, r2);
        }
    }

    public static class AnimatedVectorDrawableTransition extends Transition {
        private final AnimatedVectorDrawableCompat mAvd;

        public AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat r2) {
            super(null);
            this.mAvd = r2;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            this.mAvd.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            this.mAvd.stop();
        }
    }

    public static class AnimationDrawableTransition extends Transition {
        private final ObjectAnimator mAnim;
        private final boolean mHasReversibleFlag;

        public AnimationDrawableTransition(AnimationDrawable r5, boolean r6, boolean r7) {
            super(null);
            int r0 = r5.getNumberOfFrames();
            int r1 = 0;
            if (r6 == false) goto L5;
            int r2 = r0 - 1;
        L7:
            if (r6 == true) goto L10;
            r1 = r0 - 1;
        L10:
            FrameInterpolator r3 = new FrameInterpolator(r5, r6);
            ObjectAnimator r8 = ObjectAnimator.ofInt(r5, "currentIndex", new int[]{r2, r1});
            r8.setAutoCancel(true);
            r8.setDuration(r3.getTotalDuration());
            r8.setInterpolator(r3);
            this.mHasReversibleFlag = r7;
            this.mAnim = r8;
            return;
        L5:
            r2 = 0;
            goto L7
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public boolean canReverse() {
            return this.mHasReversibleFlag;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void reverse() {
            this.mAnim.reverse();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            this.mAnim.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            this.mAnim.cancel();
        }
    }

    public static class FrameInterpolator implements TimeInterpolator {
        private int[] mFrameTimes;
        private int mFrames;
        private int mTotalDuration;

        public FrameInterpolator(AnimationDrawable r1, boolean r2) {
            updateFrames(r1, r2);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r5) {
            int r6 = (int) ((r5 * this.mTotalDuration) + 0.5f);
            int r0 = this.mFrames;
            int[] r1 = this.mFrameTimes;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L7;
            int r3 = r1[r2];
            if (r6 < r3) goto L7;
            r6 = r6 - r3;
            r2 = r2 + 1;
        L7:
            if (r2 >= r0) goto L9;
            float r7 = r6 / this.mTotalDuration;
        L11:
            return (r2 / r0) + r7;
        L9:
            r7 = 0.0f;
            goto L11
        }

        public int getTotalDuration() {
            return this.mTotalDuration;
        }

        public int updateFrames(AnimationDrawable r6, boolean r7) {
            int r0 = r6.getNumberOfFrames();
            this.mFrames = r0;
            int[] r1 = this.mFrameTimes;
            if (r1 != null) goto L5;
        L6:
            this.mFrameTimes = new int[r0];
        L7:
            int[] r2 = this.mFrameTimes;
            int r3 = 0;
            int r4 = 0;
        L8:
            if (r3 >= r0) goto L13;
            if (r7 == false) goto L11;
            int r5 = (r0 - r3) - 1;
        L12:
            int r8 = r6.getDuration(r5);
            r2[r3] = r8;
            r4 = r4 + r8;
            r3 = r3 + 1;
            goto L8
        L11:
            r5 = r3;
            goto L12
        L13:
            this.mTotalDuration = r4;
            return r4;
        L5:
            if (r1.length >= r0) goto L7;
            goto L6
        }
    }

    public static abstract class Transition {
        private Transition() {
        }

        public boolean canReverse() {
            return false;
        }

        public void reverse() {
        }

        public abstract void start();

        public abstract void stop();

        public /* synthetic */ Transition(AnonymousClass1 r1) {
            this();
        }
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    @Nullable
    public static AnimatedStateListDrawableCompat create(@NonNull Context r6, @DrawableRes int r7, @Nullable Resources.Theme r8) {
        Resources r1 = r6.getResources();     // Catch: IOException -> L12 XmlPullParserException -> L14
        XmlResourceParser r9 = r1.getXml(r7);     // Catch: IOException -> L12 XmlPullParserException -> L14
        AttributeSet r2 = Xml.asAttributeSet(r9);     // Catch: IOException -> L12 XmlPullParserException -> L14
    L4:
        int r3 = r9.next();     // Catch: IOException -> L12 XmlPullParserException -> L14
        if (r3 == 2) goto L9;
        if (r3 != 1) goto L4;
    L9:
        if (r3 != 2) goto L17;
        return createFromXmlInner(r6, r1, r9, r2, r8);
    L17:
        throw new XmlPullParserException("No start tag found");     // Catch: IOException -> L12 XmlPullParserException -> L14
    L12:
        e = move-exception;
        Log.e(LOGTAG, "parser error", e);
        return null;
    L14:
        e = move-exception;
        Log.e(LOGTAG, "parser error", e);
        return null;
    }

    public static AnimatedStateListDrawableCompat createFromXmlInner(@NonNull Context r8, @NonNull Resources r9, @NonNull XmlPullParser r10, @NonNull AttributeSet r11, @Nullable Resources.Theme r12) {
        String r0 = r10.getName();
        if (r0.equals("animated-selector") == false) goto L7;
        AnimatedStateListDrawableCompat r1 = new AnimatedStateListDrawableCompat();
        r1.inflate(r8, r9, r10, r11, r12);
        return r1;
    L7:
        throw new XmlPullParserException(r10.getPositionDescription() + ": invalid animated-selector tag " + r0);
    }

    private void inflateChildElements(@NonNull Context r6, @NonNull Resources r7, @NonNull XmlPullParser r8, @NonNull AttributeSet r9, @Nullable Resources.Theme r10) {
        int r0 = r8.getDepth() + 1;
    L3:
        int r2 = r8.next();
        if (r2 == 1) goto L20;
        int r3 = r8.getDepth();
        if (r3 >= r0) goto L10;
        if (r2 != 3) goto L10;
        return;
    L10:
        if (r2 != 2) goto L3;
        if (r3 > r0) goto L3;
        if (r8.getName().equals(ELEMENT_ITEM) == true) goto L16;
        if (r8.getName().equals(ELEMENT_TRANSITION) == false) goto L3;
        parseTransition(r6, r7, r8, r9, r10);
        goto L3
    L16:
        parseItem(r6, r7, r8, r9, r10);
        goto L3
    }

    private void init() {
        onStateChange(getState());
    }

    private int parseItem(@NonNull Context r5, @NonNull Resources r6, @NonNull XmlPullParser r7, @NonNull AttributeSet r8, @Nullable Resources.Theme r9) {
        TypedArray r0 = TypedArrayUtils.obtainAttributes(r6, r9, r8, R.styleable.AnimatedStateListDrawableItem);
        int r1 = r0.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int r2 = r0.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        if (r2 <= 0) goto L5;
        Drawable r10 = ResourceManagerInternal.get().getDrawable(r5, r2);
    L6:
        r0.recycle();
        int[] r3 = extractStateSet(r8);
        if (r10 != null) goto L19;
    L8:
        int r11 = r7.next();
        if (r11 == 4) goto L8;
        if (r11 != 2) goto L18;
        if (r7.getName().equals("vector") == false) goto L16;
        r10 = VectorDrawableCompat.createFromXmlInner(r6, r7, r8, r9);
        goto L19
    L16:
        r10 = Drawable.createFromXmlInner(r6, r7, r8, r9);
        goto L19
    L18:
        throw new XmlPullParserException(r7.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
    L19:
        if (r10 == null) goto L23;
        return this.mState.addStateSet(r3, r10, r1);
    L23:
        throw new XmlPullParserException(r7.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
    L5:
        r10 = null;
        goto L6
    }

    private int parseTransition(@NonNull Context r8, @NonNull Resources r9, @NonNull XmlPullParser r10, @NonNull AttributeSet r11, @Nullable Resources.Theme r12) {
        TypedArray r0 = TypedArrayUtils.obtainAttributes(r9, r12, r11, R.styleable.AnimatedStateListDrawableTransition);
        int r1 = r0.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int r3 = r0.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int r4 = r0.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        if (r4 <= 0) goto L5;
        Drawable r5 = ResourceManagerInternal.get().getDrawable(r8, r4);
    L6:
        boolean r6 = r0.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        r0.recycle();
        if (r5 != null) goto L19;
    L8:
        int r7 = r10.next();
        if (r7 == 4) goto L8;
        if (r7 != 2) goto L18;
        if (r10.getName().equals("animated-vector") == false) goto L16;
        r5 = AnimatedVectorDrawableCompat.createFromXmlInner(r8, r9, r10, r11, r12);
        goto L19
    L16:
        r5 = Drawable.createFromXmlInner(r9, r10, r11, r12);
        goto L19
    L18:
        throw new XmlPullParserException(r10.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
    L19:
        if (r5 == null) goto L27;
        if (r1 == (-1)) goto L25;
        if (r3 == (-1)) goto L25;
        return this.mState.addTransition(r1, r3, r5, r6);
    L25:
        throw new XmlPullParserException(r10.getPositionDescription() + TRANSITION_MISSING_FROM_TO_ID);
    L27:
        throw new XmlPullParserException(r10.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
    L5:
        r5 = null;
        goto L6
    }

    private boolean selectTransition(int r10) {
        Transition r0 = this.mTransition;
        if (r0 != null) goto L5;
        int r2 = getCurrentIndex();
    L15:
        this.mTransition = null;
        this.mTransitionFromIndex = -1;
        this.mTransitionToIndex = -1;
        AnimatedStateListState r1 = this.mState;
        int r3 = r1.getKeyframeIdAt(r2);
        int r4 = r1.getKeyframeIdAt(r10);
        if (r4 == 0) goto L33;
        if (r3 == 0) goto L33;
        int r6 = r1.indexOfTransition(r3, r4);
        if (r6 >= 0) goto L22;
        return false;
    L22:
        boolean r7 = r1.transitionHasReversibleFlag(r3, r4);
        selectDrawable(r6);
        Object r8 = getCurrent();
        if ((r8 instanceof AnimationDrawable) == false) goto L26;
        AnimationDrawable r9 = (AnimationDrawable) r8;
        Transition r5 = new AnimationDrawableTransition(r9, r1.isTransitionReversed(r3, r4), r7);
    L31:
        r5.start();
        this.mTransition = r5;
        this.mTransitionFromIndex = r2;
        this.mTransitionToIndex = r10;
        return true;
    L26:
        if ((r8 instanceof AnimatedVectorDrawableCompat) == false) goto L29;
        r5 = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat) r8);
        goto L31
    L29:
        if ((r8 instanceof Animatable) == false) goto L33;
        r5 = new AnimatableTransition((Animatable) r8);
    L33:
        return false;
    L5:
        if (r10 != this.mTransitionToIndex) goto L8;
        return true;
    L8:
        if (r10 == this.mTransitionFromIndex) goto L10;
    L13:
        r2 = this.mTransitionToIndex;
        r0.stop();
        goto L15
    L10:
        if (r0.canReverse() == false) goto L13;
        r0.reverse();
        this.mTransitionToIndex = this.mTransitionFromIndex;
        this.mTransitionFromIndex = r10;
        return true;
    }

    private void updateStateFromTypedArray(TypedArray r4) {
        AnimatedStateListState r0 = this.mState;
        r0.mChangingConfigurations |= r4.getChangingConfigurations();
        r0.setVariablePadding(r4.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, r0.mVariablePadding));
        r0.setConstantSize(r4.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, r0.mConstantSize));
        r0.setEnterFadeDuration(r4.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, r0.mEnterFadeDuration));
        r0.setExitFadeDuration(r4.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, r0.mExitFadeDuration));
        setDither(r4.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, r0.mDither));
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable
    public /* bridge */ /* synthetic */ void addState(int[] r1, Drawable r2) {
        super.addState(r1, r2);
    }

    public <T extends Drawable & Animatable> void addTransition(int r1, int r2, @NonNull T r3, boolean r4) {
        if (r3 == null) goto L6;
        this.mState.addTransition(r1, r2, r3, r4);
        return;
    L6:
        throw new IllegalArgumentException("Transition drawable must not be null");
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public /* bridge */ /* synthetic */ void applyTheme(@NonNull Resources.Theme r1) {
        super.applyTheme(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public /* bridge */ /* synthetic */ DrawableContainer.DrawableContainerState cloneConstantState() {
        return cloneConstantState();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(@NonNull Canvas r1) {
        super.draw(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    @NonNull
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(@NonNull Rect r1) {
        super.getHotspotBounds(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public /* bridge */ /* synthetic */ void getOutline(@NonNull Outline r1) {
        super.getOutline(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(@NonNull Rect r1) {
        return super.getPadding(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable
    public void inflate(@NonNull Context r4, @NonNull Resources r5, @NonNull XmlPullParser r6, @NonNull AttributeSet r7, @Nullable Resources.Theme r8) {
        TypedArray r0 = TypedArrayUtils.obtainAttributes(r5, r8, r7, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(r0.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        updateStateFromTypedArray(r0);
        updateDensity(r5);
        r0.recycle();
        inflateChildElements(r4, r5, r6, r7, r8);
        init();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(@NonNull Drawable r1) {
        super.invalidateDrawable(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition r0 = this.mTransition;
        if (r0 == null) goto L6;
        r0.stop();
        this.mTransition = null;
        selectDrawable(this.mTransitionToIndex);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        return;
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.mMutated == false) goto L5;
    L7:
        return this;
    L5:
        if (super.mutate() != this) goto L7;
        this.mState.mutate();
        this.mMutated = true;
        goto L7
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int r1) {
        return super.onLayoutDirectionChanged(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r3) {
        int r0 = this.mState.indexOfKeyframe(r3);
        if (r0 != getCurrentIndex()) goto L5;
    L9:
        boolean r1 = false;
    L10:
        Drawable r2 = getCurrent();
        if (r2 != null) goto L13;
        return r1;
    L13:
        return r1 | r2.setState(r3);
    L5:
        if (selectTransition(r0) == false) goto L7;
    L8:
        r1 = true;
        goto L10
    L7:
        if (selectDrawable(r0) == false) goto L9;
        goto L8
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(@NonNull Drawable r1, @NonNull Runnable r2, long r3) {
        super.scheduleDrawable(r1, r2, r3);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int r1) {
        super.setAlpha(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean r1) {
        super.setAutoMirrored(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter r1) {
        super.setColorFilter(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public void setConstantState(@NonNull DrawableContainer.DrawableContainerState r2) {
        super.setConstantState(r2);
        if ((r2 instanceof AnimatedStateListState) == false) goto L6;
        this.mState = (AnimatedStateListState) r2;
        return;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean r1) {
        super.setDither(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public /* bridge */ /* synthetic */ void setEnterFadeDuration(int r1) {
        super.setEnterFadeDuration(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public /* bridge */ /* synthetic */ void setExitFadeDuration(int r1) {
        super.setExitFadeDuration(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float r1, float r2) {
        super.setHotspot(r1, r2);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int r1, int r2, int r3, int r4) {
        super.setHotspotBounds(r1, r2, r3, r4);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList r1) {
        super.setTintList(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public /* bridge */ /* synthetic */ void setTintMode(@NonNull PorterDuff.Mode r1) {
        super.setTintMode(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean setVisible(boolean r3, boolean r4) {
        boolean r0 = super.setVisible(r3, r4);
        Transition r1 = this.mTransition;
        if (r1 == null) goto L9;
        if (r0 == true) goto L6;
        if (r4 == false) goto L9;
    L6:
        if (r3 == false) goto L8;
        r1.start();
        goto L9
    L8:
        jumpToCurrentState();
    L9:
        return r0;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(@NonNull Drawable r1, @NonNull Runnable r2) {
        super.unscheduleDrawable(r1, r2);
    }

    public AnimatedStateListDrawableCompat(@Nullable AnimatedStateListState r2, @Nullable Resources r3) {
        super(null);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        setConstantState(new AnimatedStateListState(r2, this, r3));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public void addState(@NonNull int[] r2, @NonNull Drawable r3, int r4) {
        if (r3 == null) goto L6;
        this.mState.addStateSet(r2, r3, r4);
        onStateChange(getState());
        return;
    L6:
        throw new IllegalArgumentException("Drawable must not be null");
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public /* bridge */ /* synthetic */ StateListDrawable.StateListState cloneConstantState() {
        return cloneConstantState();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public AnimatedStateListState cloneConstantState() {
        return new AnimatedStateListState(this.mState, this, null);
    }
}
