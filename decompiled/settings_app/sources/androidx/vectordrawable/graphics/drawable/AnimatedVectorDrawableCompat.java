package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat {
    private static final String ANIMATED_VECTOR = "animated-vector";
    private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
    private static final String LOGTAG = "AnimatedVDCompat";
    private static final String TARGET = "target";
    private AnimatedVectorDrawableCompatState mAnimatedVectorState;
    ArrayList<Animatable2Compat.AnimationCallback> mAnimationCallbacks;
    private Animator.AnimatorListener mAnimatorListener;
    private android.animation.ArgbEvaluator mArgbEvaluator;
    AnimatedVectorDrawableDelegateState mCachedConstantStateDelegate;
    final Drawable.Callback mCallback;
    private Context mContext;

    private static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {
        AnimatorSet mAnimatorSet;
        ArrayList<Animator> mAnimators;
        int mChangingConfigurations;
        ArrayMap<Animator, String> mTargetNameMap;
        VectorDrawableCompat mVectorDrawable;

        public AnimatedVectorDrawableCompatState(Context r3, AnimatedVectorDrawableCompatState r4, Drawable.Callback r5, Resources r6) {
            if (r4 == null) goto L19;
            this.mChangingConfigurations = r4.mChangingConfigurations;
            VectorDrawableCompat r7 = r4.mVectorDrawable;
            int r0 = 0;
            if (r7 == null) goto L11;
            Drawable.ConstantState r8 = r7.getConstantState();
            if (r6 == null) goto L9;
            this.mVectorDrawable = (VectorDrawableCompat) r8.newDrawable(r6);
        L10:
            VectorDrawableCompat r9 = (VectorDrawableCompat) this.mVectorDrawable.mutate();
            this.mVectorDrawable = r9;
            r9.setCallback(r5);
            this.mVectorDrawable.setBounds(r4.mVectorDrawable.getBounds());
            this.mVectorDrawable.setAllowCaching(false);
            goto L11
        L9:
            this.mVectorDrawable = (VectorDrawableCompat) r8.newDrawable();
        L11:
            ArrayList<Animator> r10 = r4.mAnimators;
            if (r10 == null) goto L20;
            int r11 = r10.size();
            this.mAnimators = new ArrayList(r11);
            this.mTargetNameMap = new ArrayMap(r11);
        L14:
            if (r0 >= r11) goto L16;
            Animator r12 = r4.mAnimators.get(r0);
            Animator r13 = r12.clone();
            String r14 = r4.mTargetNameMap.get(r12);
            r13.setTarget(this.mVectorDrawable.getTargetByName(r14));
            this.mAnimators.add(r13);
            this.mTargetNameMap.put(r13, r14);
            r0 = r0 + 1;
            goto L14
        L16:
            setupAnimatorSet();
            return;
        L20:
            return;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r1) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public void setupAnimatorSet() {
            if (this.mAnimatorSet != null) goto L5;
            this.mAnimatorSet = new AnimatorSet();
        L5:
            this.mAnimatorSet.playTogether(this.mAnimators);
        }
    }

    private static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {
        private final Drawable.ConstantState mDelegateState;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState r1) {
            this.mDelegateState = r1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat r0 = new AnimatedVectorDrawableCompat();
            r0.mDelegateDrawable = this.mDelegateState.newDrawable();
            r0.mDelegateDrawable.setCallback(r0.mCallback);
            return r0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r2) {
            AnimatedVectorDrawableCompat r0 = new AnimatedVectorDrawableCompat();
            r0.mDelegateDrawable = this.mDelegateState.newDrawable(r2);
            r0.mDelegateDrawable.setCallback(r0.mCallback);
            return r0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r2, Resources.Theme r3) {
            AnimatedVectorDrawableCompat r0 = new AnimatedVectorDrawableCompat();
            r0.mDelegateDrawable = this.mDelegateState.newDrawable(r2, r3);
            r0.mDelegateDrawable.setCallback(r0.mCallback);
            return r0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect r1) {
        return super.getPadding(r1);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int r1) {
        super.setChangingConfigurations(r1);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int r1, PorterDuff.Mode r2) {
        super.setColorFilter(r1, r2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean r1) {
        super.setFilterBitmap(r1);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float r1, float r2) {
        super.setHotspot(r1, r2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int r1, int r2, int r3, int r4) {
        super.setHotspotBounds(r1, r2, r3, r4);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] r1) {
        return super.setState(r1);
    }

    AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    private AnimatedVectorDrawableCompat(Context r2) {
        this(r2, null, null);
    }

    private AnimatedVectorDrawableCompat(Context r3, AnimatedVectorDrawableCompatState r4, Resources r5) {
        this.mArgbEvaluator = null;
        this.mAnimatorListener = null;
        this.mAnimationCallbacks = null;
        Drawable.Callback r0 = new AnonymousClass1(this);
        this.mCallback = r0;
        this.mContext = r3;
        if (r4 == null) goto L5;
        this.mAnimatedVectorState = r4;
        return;
    L5:
        this.mAnimatedVectorState = new AnimatedVectorDrawableCompatState(r3, r4, r0, r5);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.mDelegateDrawable == null) goto L5;
        this.mDelegateDrawable.mutate();
    L5:
        return this;
    }

    public static AnimatedVectorDrawableCompat create(Context r2, int r3) {
        AnimatedVectorDrawableCompat r0 = new AnimatedVectorDrawableCompat(r2);
        r0.mDelegateDrawable = ResourcesCompat.getDrawable(r2.getResources(), r3, r2.getTheme());
        r0.mDelegateDrawable.setCallback(r0.mCallback);
        r0.mCachedConstantStateDelegate = new AnimatedVectorDrawableDelegateState(r0.mDelegateDrawable.getConstantState());
        return r0;
    }

    public static AnimatedVectorDrawableCompat createFromXmlInner(Context r1, Resources r2, XmlPullParser r3, AttributeSet r4, Resources.Theme r5) throws XmlPullParserException, IOException {
        AnimatedVectorDrawableCompat r0 = new AnimatedVectorDrawableCompat(r1);
        r0.inflate(r2, r3, r4, r5);
        return r0;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null) goto L5;
        return null;
    L5:
        return new AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        if (this.mDelegateDrawable != null) goto L5;
        int r0 = super.getChangingConfigurations();
        return this.mAnimatedVectorState.mChangingConfigurations | r0;
    L5:
        return this.mDelegateDrawable.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        if (this.mDelegateDrawable == null) goto L6;
        this.mDelegateDrawable.draw(r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.draw(r2);
        if (this.mAnimatedVectorState.mAnimatorSet.isStarted() == false) goto L10;
        invalidateSelf();
        return;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r2) {
        if (this.mDelegateDrawable == null) goto L6;
        this.mDelegateDrawable.setBounds(r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setBounds(r2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] r2) {
        if (this.mDelegateDrawable == null) goto L7;
        return this.mDelegateDrawable.setState(r2);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.setState(r2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r2) {
        if (this.mDelegateDrawable == null) goto L7;
        return this.mDelegateDrawable.setLevel(r2);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.setLevel(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        if (this.mDelegateDrawable == null) goto L7;
        return DrawableCompat.getAlpha(this.mDelegateDrawable);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (this.mDelegateDrawable == null) goto L6;
        this.mDelegateDrawable.setAlpha(r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        if (this.mDelegateDrawable == null) goto L6;
        this.mDelegateDrawable.setColorFilter(r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setColorFilter(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        if (this.mDelegateDrawable == null) goto L7;
        return DrawableCompat.getColorFilter(this.mDelegateDrawable);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r2) {
        if (this.mDelegateDrawable == null) goto L6;
        DrawableCompat.setTint(this.mDelegateDrawable, r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTint(r2);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r2) {
        if (this.mDelegateDrawable == null) goto L6;
        DrawableCompat.setTintList(this.mDelegateDrawable, r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTintList(r2);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r2) {
        if (this.mDelegateDrawable == null) goto L6;
        DrawableCompat.setTintMode(this.mDelegateDrawable, r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTintMode(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r2, boolean r3) {
        if (this.mDelegateDrawable != null) goto L5;
        this.mAnimatedVectorState.mVectorDrawable.setVisible(r2, r3);
        return super.setVisible(r2, r3);
    L5:
        return this.mDelegateDrawable.setVisible(r2, r3);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.mDelegateDrawable == null) goto L7;
        return this.mDelegateDrawable.isStateful();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.mDelegateDrawable == null) goto L7;
        return this.mDelegateDrawable.getOpacity();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.mDelegateDrawable == null) goto L7;
        return this.mDelegateDrawable.getIntrinsicWidth();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.mDelegateDrawable == null) goto L7;
        return this.mDelegateDrawable.getIntrinsicHeight();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        if (this.mDelegateDrawable == null) goto L7;
        return DrawableCompat.isAutoMirrored(this.mDelegateDrawable);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r2) {
        if (this.mDelegateDrawable == null) goto L6;
        DrawableCompat.setAutoMirrored(this.mDelegateDrawable, r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setAutoMirrored(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r7, XmlPullParser r8, AttributeSet r9, Resources.Theme r10) throws XmlPullParserException, IOException {
        if (this.mDelegateDrawable == null) goto L6;
        DrawableCompat.inflate(this.mDelegateDrawable, r7, r8, r9, r10);
        return;
    L6:
        int r0 = r8.getEventType();
        int r1 = r8.getDepth() + 1;
    L7:
        if (r0 == 1) goto L34;
        if (r8.getDepth() >= r1) goto L13;
        if (r0 == 3) goto L34;
    L13:
        if (r0 != 2) goto L33;
        String r2 = r8.getName();
        if (ANIMATED_VECTOR.equals(r2) == false) goto L24;
        TypedArray r3 = TypedArrayUtils.obtainAttributes(r7, r10, r9, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE);
        int r4 = r3.getResourceId(0, 0);
        if (r4 == 0) goto L22;
        VectorDrawableCompat r5 = VectorDrawableCompat.create(r7, r4, r10);
        r5.setAllowCaching(false);
        r5.setCallback(this.mCallback);
        if (this.mAnimatedVectorState.mVectorDrawable == null) goto L21;
        this.mAnimatedVectorState.mVectorDrawable.setCallback(null);
    L21:
        this.mAnimatedVectorState.mVectorDrawable = r5;
    L22:
        r3.recycle();
        goto L33
    L24:
        if ("target".equals(r2) == false) goto L33;
        TypedArray r6 = r7.obtainAttributes(r9, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET);
        String r11 = r6.getString(0);
        int r12 = r6.getResourceId(1, 0);
        if (r12 == 0) goto L32;
        Context r13 = this.mContext;
        if (r13 == null) goto L30;
        setupAnimatorsForTarget(r11, AnimatorInflaterCompat.loadAnimator(r13, r12));
        goto L32
    L30:
        r6.recycle();
        throw new IllegalStateException("Context can't be null when inflating animators");
    L32:
        r6.recycle();
    L33:
        r0 = r8.next();
    L34:
        this.mAnimatedVectorState.setupAnimatorSet();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r2, XmlPullParser r3, AttributeSet r4) throws XmlPullParserException, IOException {
        inflate(r2, r3, r4, null);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme r2) {
        if (this.mDelegateDrawable == null) goto L6;
        DrawableCompat.applyTheme(this.mDelegateDrawable, r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.mDelegateDrawable != null) goto L5;
        return false;
    L5:
        return DrawableCompat.canApplyTheme(this.mDelegateDrawable);
    }

    private void setupColorAnimator(Animator r4) {
        if ((r4 instanceof AnimatorSet) == false) goto L11;
        ArrayList<Animator> r0 = ((AnimatorSet) r4).getChildAnimations();
        if (r0 == null) goto L11;
        int r1 = 0;
    L8:
        if (r1 >= r0.size()) goto L11;
        setupColorAnimator(r0.get(r1));
        r1 = r1 + 1;
    L11:
        if ((r4 instanceof ObjectAnimator) == false) goto L22;
        ObjectAnimator r5 = (ObjectAnimator) r4;
        String r2 = r5.getPropertyName();
        if ("fillColor".equals(r2) == true) goto L17;
        if ("strokeColor".equals(r2) == true) goto L17;
        return;
    L17:
        if (this.mArgbEvaluator != null) goto L19;
        this.mArgbEvaluator = new android.animation.ArgbEvaluator();
    L19:
        r5.setEvaluator(this.mArgbEvaluator);
        return;
    }

    private void setupAnimatorsForTarget(String r3, Animator r4) {
        r4.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(r3));
        if (this.mAnimatedVectorState.mAnimators != null) goto L5;
        AnimatedVectorDrawableCompatState r0 = this.mAnimatedVectorState;
        r0.mAnimators = new ArrayList();
        AnimatedVectorDrawableCompatState r1 = this.mAnimatedVectorState;
        r1.mTargetNameMap = new ArrayMap();
    L5:
        this.mAnimatedVectorState.mAnimators.add(r4);
        this.mAnimatedVectorState.mTargetNameMap.put(r4, r3);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        if (this.mDelegateDrawable == null) goto L7;
        return ((AnimatedVectorDrawable) this.mDelegateDrawable).isRunning();
    L7:
        return this.mAnimatedVectorState.mAnimatorSet.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.mDelegateDrawable == null) goto L7;
        ((AnimatedVectorDrawable) this.mDelegateDrawable).start();
        return;
    L7:
        if (this.mAnimatedVectorState.mAnimatorSet.isStarted() == false) goto L9;
        return;
    L9:
        this.mAnimatedVectorState.mAnimatorSet.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mDelegateDrawable == null) goto L6;
        ((AnimatedVectorDrawable) this.mDelegateDrawable).stop();
        return;
    L6:
        this.mAnimatedVectorState.mAnimatorSet.end();
    }

    private static boolean unregisterPlatformCallback(AnimatedVectorDrawable r0, Animatable2Compat.AnimationCallback r1) {
        return r0.unregisterAnimationCallback(r1.getPlatformCallback());
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback r2) {
        if (this.mDelegateDrawable == null) goto L6;
        registerPlatformCallback((AnimatedVectorDrawable) this.mDelegateDrawable, r2);
        return;
    L6:
        if (r2 != null) goto L9;
        return;
    L9:
        if (this.mAnimationCallbacks != null) goto L12;
        this.mAnimationCallbacks = new ArrayList();
    L12:
        if (this.mAnimationCallbacks.contains(r2) == false) goto L14;
        return;
    L14:
        this.mAnimationCallbacks.add(r2);
        if (this.mAnimatorListener != null) goto L17;
        this.mAnimatorListener = new AnonymousClass2(this);
    L17:
        this.mAnimatedVectorState.mAnimatorSet.addListener(this.mAnimatorListener);
    }

    private static void registerPlatformCallback(AnimatedVectorDrawable r0, Animatable2Compat.AnimationCallback r1) {
        r0.registerAnimationCallback(r1.getPlatformCallback());
    }

    private void removeAnimatorSetListener() {
        if (this.mAnimatorListener == null) goto L6;
        this.mAnimatedVectorState.mAnimatorSet.removeListener(this.mAnimatorListener);
        this.mAnimatorListener = null;
        return;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback r2) {
        if (this.mDelegateDrawable == null) goto L5;
        unregisterPlatformCallback((AnimatedVectorDrawable) this.mDelegateDrawable, r2);
    L5:
        ArrayList<Animatable2Compat.AnimationCallback> r0 = this.mAnimationCallbacks;
        if (r0 == null) goto L13;
        if (r2 == null) goto L15;
        boolean r3 = r0.remove(r2);
        if (this.mAnimationCallbacks.size() != 0) goto L12;
        removeAnimatorSetListener();
    L12:
        return r3;
    L15:
        return false;
    L13:
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        if (this.mDelegateDrawable == null) goto L6;
        ((AnimatedVectorDrawable) this.mDelegateDrawable).clearAnimationCallbacks();
        return;
    L6:
        removeAnimatorSetListener();
        ArrayList<Animatable2Compat.AnimationCallback> r1 = this.mAnimationCallbacks;
        if (r1 != null) goto L9;
        return;
    L9:
        r1.clear();
    }

    public static void registerAnimationCallback(Drawable r1, Animatable2Compat.AnimationCallback r2) {
        if (r1 == null) goto L10;
        if (r2 != null) goto L6;
        return;
    L6:
        if ((r1 instanceof Animatable) == true) goto L8;
        return;
    L8:
        registerPlatformCallback((AnimatedVectorDrawable) r1, r2);
        return;
    }

    public static boolean unregisterAnimationCallback(Drawable r2, Animatable2Compat.AnimationCallback r3) {
        if (r2 == null) goto L11;
        if (r3 == null) goto L11;
        if ((r2 instanceof Animatable) == true) goto L10;
        return false;
    L10:
        return unregisterPlatformCallback((AnimatedVectorDrawable) r2, r3);
    L11:
        return false;
    }

    public static void clearAnimationCallbacks(Drawable r1) {
        if ((r1 instanceof Animatable) == true) goto L5;
        return;
    L5:
        ((AnimatedVectorDrawable) r1).clearAnimationCallbacks();
    }
}
