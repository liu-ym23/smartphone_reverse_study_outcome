package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.apache.commons.math3.linear.ConjugateGradient;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedStateListDrawableCompat extends StateListDrawableCompat implements TintAwareDrawable {
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
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AnimatableTransition extends Transition {
        private final Animatable mA;

        AnimatableTransition(Animatable r2) {
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

    static class AnimatedStateListState extends StateListDrawableCompat.StateListState {
        private static final long REVERSED_BIT = 4294967296L;
        private static final long REVERSIBLE_FLAG_BIT = 8589934592L;
        SparseArrayCompat<Integer> mStateIds;
        LongSparseArray<Long> mTransitions;

        private static long generateTransitionKey(int r2, int r3) {
            long r0 = ((long) r2) << 32;
            return ((long) r3) | r0;
        }

        AnimatedStateListState(AnimatedStateListState r1, AnimatedStateListDrawableCompat r2, Resources r3) {
            super(r1, r2, r3);
            if (r1 == null) goto L5;
            this.mTransitions = r1.mTransitions;
            this.mStateIds = r1.mStateIds;
            return;
        L5:
            this.mTransitions = new LongSparseArray();
            this.mStateIds = new SparseArrayCompat();
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        void mutate() {
            this.mTransitions = this.mTransitions.clone();
            this.mStateIds = this.mStateIds.clone();
        }

        int addTransition(int r10, int r11, Drawable r12, boolean r13) {
            int r14 = super.addChild(r12);
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

        int addStateSet(int[] r1, Drawable r2, int r3) {
            int r4 = super.addStateSet(r1, r2);
            this.mStateIds.put(r4, Integer.valueOf(r3));
            return r4;
        }

        int indexOfKeyframe(int[] r1) {
            int r2 = super.indexOfStateSet(r1);
            if (r2 < 0) goto L6;
            return r2;
        L6:
            return super.indexOfStateSet(StateSet.WILD_CARD);
        }

        int getKeyframeIdAt(int r2) {
            if (r2 >= 0) goto L6;
            return 0;
        L6:
            return this.mStateIds.get(r2, 0).intValue();
        }

        int indexOfTransition(int r3, int r4) {
            long r5 = generateTransitionKey(r3, r4);
            return (int) this.mTransitions.get(r5, -1L).longValue();
        }

        boolean isTransitionReversed(int r3, int r4) {
            long r5 = generateTransitionKey(r3, r4);
            if ((this.mTransitions.get(r5, -1L).longValue() & REVERSED_BIT) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean transitionHasReversibleFlag(int r3, int r4) {
            long r5 = generateTransitionKey(r3, r4);
            if ((this.mTransitions.get(r5, -1L).longValue() & REVERSIBLE_FLAG_BIT) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r2) {
            return new AnimatedStateListDrawableCompat(this, r2);
        }
    }

    private static class AnimatedVectorDrawableTransition extends Transition {
        private final AnimatedVectorDrawableCompat mAvd;

        AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat r2) {
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

    private static class AnimationDrawableTransition extends Transition {
        private final ObjectAnimator mAnim;
        private final boolean mHasReversibleFlag;

        AnimationDrawableTransition(AnimationDrawable r6, boolean r7, boolean r8) {
            super(null);
            int r0 = r6.getNumberOfFrames();
            if (r7 == false) goto L5;
            int r2 = r0 - 1;
        L7:
            if (r7 == false) goto L9;
            int r1 = 0;
        L10:
            FrameInterpolator r4 = new FrameInterpolator(r6, r7);
            ObjectAnimator r9 = ObjectAnimator.ofInt(r6, "currentIndex", new int[]{r2, r1});
            Compatibility.Api18Impl.setAutoCancel(r9, true);
            r9.setDuration(r4.getTotalDuration());
            r9.setInterpolator(r4);
            this.mHasReversibleFlag = r8;
            this.mAnim = r9;
            return;
        L9:
            r1 = r0 - 1;
            goto L10
        L5:
            r2 = 0;
            goto L7
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public boolean canReverse() {
            return this.mHasReversibleFlag;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            this.mAnim.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void reverse() {
            this.mAnim.reverse();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            this.mAnim.cancel();
        }
    }

    private static class FrameInterpolator implements TimeInterpolator {
        private int[] mFrameTimes;
        private int mFrames;
        private int mTotalDuration;

        FrameInterpolator(AnimationDrawable r1, boolean r2) {
            updateFrames(r1, r2);
        }

        int updateFrames(AnimationDrawable r6, boolean r7) {
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

        int getTotalDuration() {
            return this.mTotalDuration;
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
    }

    private static abstract class Transition {
        public boolean canReverse() {
            return false;
        }

        public void reverse() {
        }

        public abstract void start();

        public abstract void stop();

        private Transition() {
        }

        /* synthetic */ Transition(AnonymousClass1 r1) {
            this();
        }
    }

    static {
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* bridge */ /* synthetic */ DrawableContainerCompat.DrawableContainerState cloneConstantState() {
        return cloneConstantState();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* bridge */ /* synthetic */ StateListDrawableCompat.StateListState cloneConstantState() {
        return cloneConstantState();
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    AnimatedStateListDrawableCompat(AnimatedStateListState r2, Resources r3) {
        super(null);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        setConstantState(new AnimatedStateListState(r2, this, r3));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static AnimatedStateListDrawableCompat create(Context r6, int r7, Resources.Theme r8) {
        Resources r1 = r6.getResources();     // Catch: IOException -> L14 XmlPullParserException -> L16
        XmlResourceParser r9 = r1.getXml(r7);     // Catch: IOException -> L14 XmlPullParserException -> L16
        AttributeSet r2 = Xml.asAttributeSet(r9);     // Catch: IOException -> L14 XmlPullParserException -> L16
    L4:
        int r3 = r9.next();     // Catch: IOException -> L14 XmlPullParserException -> L16
        if (r3 == 2) goto L9;
        if (r3 != 1) goto L4;
    L9:
        if (r3 != 2) goto L13;
        return createFromXmlInner(r6, r1, r9, r2, r8);
    L13:
        throw new XmlPullParserException("No start tag found");     // Catch: IOException -> L14 XmlPullParserException -> L16
    L14:
        e = move-exception;
        Log.e(LOGTAG, "parser error", e);
        return null;
    L16:
        e = move-exception;
        Log.e(LOGTAG, "parser error", e);
        return null;
    }

    public static AnimatedStateListDrawableCompat createFromXmlInner(Context r8, Resources r9, XmlPullParser r10, AttributeSet r11, Resources.Theme r12) throws IOException, XmlPullParserException {
        String r0 = r10.getName();
        if (r0.equals("animated-selector") == false) goto L7;
        AnimatedStateListDrawableCompat r1 = new AnimatedStateListDrawableCompat();
        r1.inflate(r8, r9, r10, r11, r12);
        return r1;
    L7:
        throw new XmlPullParserException(r10.getPositionDescription() + ": invalid animated-selector tag " + r0);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat
    public void inflate(Context r4, Resources r5, XmlPullParser r6, AttributeSet r7, Resources.Theme r8) throws XmlPullParserException, IOException {
        TypedArray r0 = TypedArrayUtils.obtainAttributes(r5, r8, r7, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(r0.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        updateStateFromTypedArray(r0);
        updateDensity(r5);
        r0.recycle();
        inflateChildElements(r4, r5, r6, r7, r8);
        init();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
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

    public void addState(int[] r2, Drawable r3, int r4) {
        ObjectsCompat.requireNonNull(r3);
        this.mState.addStateSet(r2, r3, r4);
        onStateChange(getState());
    }

    public <T extends Drawable & Animatable> void addTransition(int r1, int r2, T r3, boolean r4) {
        ObjectsCompat.requireNonNull(r3);
        this.mState.addTransition(r1, r2, r3, r4);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
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

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] r3) {
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
        r0.mChangingConfigurations |= Compatibility.Api21Impl.getChangingConfigurations(r4);
        r0.setVariablePadding(r4.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, r0.mVariablePadding));
        r0.setConstantSize(r4.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, r0.mConstantSize));
        r0.setEnterFadeDuration(r4.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, r0.mEnterFadeDuration));
        r0.setExitFadeDuration(r4.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, r0.mExitFadeDuration));
        setDither(r4.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, r0.mDither));
    }

    private void init() {
        onStateChange(getState());
    }

    private void inflateChildElements(Context r6, Resources r7, XmlPullParser r8, AttributeSet r9, Resources.Theme r10) throws XmlPullParserException, IOException {
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

    private int parseTransition(Context r8, Resources r9, XmlPullParser r10, AttributeSet r11, Resources.Theme r12) throws XmlPullParserException, IOException {
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
        r5 = Compatibility.Api21Impl.createFromXmlInner(r9, r10, r11, r12);
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

    private int parseItem(Context r5, Resources r6, XmlPullParser r7, AttributeSet r8, Resources.Theme r9) throws XmlPullParserException, IOException {
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
        if (r7.getName().equals(ConjugateGradient.VECTOR) == false) goto L16;
        r10 = VectorDrawableCompat.createFromXmlInner(r6, r7, r8, r9);
        goto L19
    L16:
        r10 = Compatibility.Api21Impl.createFromXmlInner(r6, r7, r8, r9);
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

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
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

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    AnimatedStateListState cloneConstantState() {
        return new AnimatedStateListState(this.mState, this, null);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    void setConstantState(DrawableContainerCompat.DrawableContainerState r2) {
        super.setConstantState(r2);
        if ((r2 instanceof AnimatedStateListState) == false) goto L6;
        this.mState = (AnimatedStateListState) r2;
        return;
    }
}
