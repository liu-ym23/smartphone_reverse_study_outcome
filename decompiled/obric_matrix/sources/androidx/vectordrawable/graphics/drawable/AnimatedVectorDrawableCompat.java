package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
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
            Drawable r9 = r8.newDrawable(r6);
        L10:
            this.mVectorDrawable = (VectorDrawableCompat) r9;
            VectorDrawableCompat r10 = (VectorDrawableCompat) this.mVectorDrawable.mutate();
            this.mVectorDrawable = r10;
            r10.setCallback(r5);
            this.mVectorDrawable.setBounds(r4.mVectorDrawable.getBounds());
            this.mVectorDrawable.setAllowCaching(false);
            goto L11
        L9:
            r9 = r8.newDrawable();
        L11:
            ArrayList<Animator> r11 = r4.mAnimators;
            if (r11 == null) goto L20;
            int r12 = r11.size();
            this.mAnimators = new ArrayList(r12);
            this.mTargetNameMap = new ArrayMap(r12);
        L14:
            if (r0 >= r12) goto L16;
            Animator r13 = r4.mAnimators.get(r0);
            Animator r14 = r13.clone();
            String r15 = r4.mTargetNameMap.get(r13);
            r14.setTarget(this.mVectorDrawable.getTargetByName(r15));
            this.mAnimators.add(r14);
            this.mTargetNameMap.put(r14, r15);
            r0 = r0 + 1;
            goto L14
        L16:
            setupAnimatorSet();
            return;
        L20:
            return;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r1) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public void setupAnimatorSet() {
            if (this.mAnimatorSet != null) goto L5;
            this.mAnimatorSet = new AnimatorSet();
        L5:
            this.mAnimatorSet.playTogether(this.mAnimators);
        }
    }

    @RequiresApi(24)
    private static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {
        private final Drawable.ConstantState mDelegateState;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState r1) {
            this.mDelegateState = r1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat r0 = new AnimatedVectorDrawableCompat();
            Drawable r2 = this.mDelegateState.newDrawable();
            r0.mDelegateDrawable = r2;
            r2.setCallback(r0.mCallback);
            return r0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r2) {
            AnimatedVectorDrawableCompat r0 = new AnimatedVectorDrawableCompat();
            Drawable r1 = this.mDelegateState.newDrawable(r2);
            r0.mDelegateDrawable = r1;
            r1.setCallback(r0.mCallback);
            return r0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r2, Resources.Theme r3) {
            AnimatedVectorDrawableCompat r0 = new AnimatedVectorDrawableCompat();
            Drawable r1 = this.mDelegateState.newDrawable(r2, r3);
            r0.mDelegateDrawable = r1;
            r1.setCallback(r0.mCallback);
            return r0;
        }
    }

    AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    private AnimatedVectorDrawableCompat(@Nullable Context r2) {
        this(r2, null, null);
    }

    private AnimatedVectorDrawableCompat(@Nullable Context r3, @Nullable AnimatedVectorDrawableCompatState r4, @Nullable Resources r5) {
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

    public static void clearAnimationCallbacks(Drawable r2) {
        if ((r2 instanceof Animatable) == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L8;
        ((AnimatedVectorDrawable) r2).clearAnimationCallbacks();
        return;
    L8:
        ((AnimatedVectorDrawableCompat) r2).clearAnimationCallbacks();
    }

    @Nullable
    public static AnimatedVectorDrawableCompat create(@NonNull Context r6, @DrawableRes int r7) {
        if (Build.VERSION.SDK_INT < 24) goto L21;
        AnimatedVectorDrawableCompat r0 = new AnimatedVectorDrawableCompat(r6);
        Drawable r8 = ResourcesCompat.getDrawable(r6.getResources(), r7, r6.getTheme());
        r0.mDelegateDrawable = r8;
        r8.setCallback(r0.mCallback);
        r0.mCachedConstantStateDelegate = new AnimatedVectorDrawableDelegateState(r0.mDelegateDrawable.getConstantState());
        return r0;
    L21:
        XmlResourceParser r9 = r6.getResources().getXml(r7);     // Catch: Throwable -> L18
        AttributeSet r2 = Xml.asAttributeSet(r9);     // Catch: Throwable -> L18
    L8:
        int r3 = r9.next();     // Catch: Throwable -> L18
        if (r3 == 2) goto L13;
        if (r3 != 1) goto L8;
    L13:
        if (r3 != 2) goto L17;
        return createFromXmlInner(r6, r6.getResources(), r9, r2, r6.getTheme());
    L17:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L18
    L18:
        e = move-exception;
        Log.e(LOGTAG, "parser error", e);
        return null;
    }

    public static AnimatedVectorDrawableCompat createFromXmlInner(Context r1, Resources r2, XmlPullParser r3, AttributeSet r4, Resources.Theme r5) {
        AnimatedVectorDrawableCompat r0 = new AnimatedVectorDrawableCompat(r1);
        r0.inflate(r2, r3, r4, r5);
        return r0;
    }

    public static void registerAnimationCallback(Drawable r2, Animatable2Compat.AnimationCallback r3) {
        if (r2 == null) goto L13;
        if (r3 != null) goto L6;
        return;
    L6:
        if ((r2 instanceof Animatable) == true) goto L9;
        return;
    L9:
        if (Build.VERSION.SDK_INT < 24) goto L11;
        registerPlatformCallback((AnimatedVectorDrawable) r2, r3);
        return;
    L11:
        ((AnimatedVectorDrawableCompat) r2).registerAnimationCallback(r3);
        return;
    }

    @RequiresApi(23)
    private static void registerPlatformCallback(@NonNull AnimatedVectorDrawable r0, @NonNull Animatable2Compat.AnimationCallback r1) {
        r0.registerAnimationCallback(r1.getPlatformCallback());
    }

    private void removeAnimatorSetListener() {
        Animator.AnimatorListener r0 = this.mAnimatorListener;
        if (r0 == null) goto L6;
        this.mAnimatedVectorState.mAnimatorSet.removeListener(r0);
        this.mAnimatorListener = null;
        return;
    }

    private void setupAnimatorsForTarget(String r3, Animator r4) {
        r4.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(r3));
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        setupColorAnimator(r4);
    L5:
        AnimatedVectorDrawableCompatState r0 = this.mAnimatedVectorState;
        if (r0.mAnimators != null) goto L8;
        r0.mAnimators = new ArrayList();
        AnimatedVectorDrawableCompatState r1 = this.mAnimatedVectorState;
        r1.mTargetNameMap = new ArrayMap();
    L8:
        this.mAnimatedVectorState.mAnimators.add(r4);
        this.mAnimatedVectorState.mTargetNameMap.put(r4, r3);
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

    public static boolean unregisterAnimationCallback(Drawable r2, Animatable2Compat.AnimationCallback r3) {
        if (r2 == null) goto L15;
        if (r3 == null) goto L15;
        if ((r2 instanceof Animatable) == true) goto L10;
        return false;
    L10:
        if (Build.VERSION.SDK_INT < 24) goto L14;
        return unregisterPlatformCallback((AnimatedVectorDrawable) r2, r3);
    L14:
        return ((AnimatedVectorDrawableCompat) r2).unregisterAnimationCallback(r3);
    L15:
        return false;
    }

    @RequiresApi(23)
    private static boolean unregisterPlatformCallback(AnimatedVectorDrawable r0, Animatable2Compat.AnimationCallback r1) {
        return r0.unregisterAnimationCallback(r1.getPlatformCallback());
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme r1) {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L6;
        DrawableCompat.applyTheme(r0, r1);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 != null) goto L5;
        return false;
    L5:
        return DrawableCompat.canApplyTheme(r0);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L6;
        ((AnimatedVectorDrawable) r0).clearAnimationCallbacks();
        return;
    L6:
        removeAnimatorSetListener();
        ArrayList<Animatable2Compat.AnimationCallback> r1 = this.mAnimationCallbacks;
        if (r1 != null) goto L9;
        return;
    L9:
        r1.clear();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L6;
        r0.draw(r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.draw(r2);
        if (this.mAnimatedVectorState.mAnimatorSet.isStarted() == false) goto L10;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L7;
        return DrawableCompat.getAlpha(r0);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 != null) goto L5;
        int r1 = super.getChangingConfigurations();
        return this.mAnimatedVectorState.mChangingConfigurations | r1;
    L5:
        return r0.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L7;
        return DrawableCompat.getColorFilter(r0);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null) goto L5;
        return null;
    L5:
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        return null;
    L7:
        return new AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L7;
        return r0.getIntrinsicHeight();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L7;
        return r0.getIntrinsicWidth();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L7;
        return r0.getOpacity();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
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

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r2, XmlPullParser r3, AttributeSet r4) {
        inflate(r2, r3, r4, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r7, XmlPullParser r8, AttributeSet r9, Resources.Theme r10) {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L6;
        DrawableCompat.inflate(r0, r7, r8, r9, r10);
        return;
    L6:
        int r1 = r8.getEventType();
        int r2 = r8.getDepth() + 1;
    L7:
        if (r1 == 1) goto L33;
        if (r8.getDepth() >= r2) goto L13;
        if (r1 == 3) goto L33;
    L13:
        if (r1 != 2) goto L32;
        String r3 = r8.getName();
        if (ANIMATED_VECTOR.equals(r3) == false) goto L24;
        TypedArray r4 = TypedArrayUtils.obtainAttributes(r7, r10, r9, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE);
        int r5 = r4.getResourceId(0, 0);
        if (r5 == 0) goto L22;
        VectorDrawableCompat r6 = VectorDrawableCompat.create(r7, r5, r10);
        r6.setAllowCaching(false);
        r6.setCallback(this.mCallback);
        VectorDrawableCompat r11 = this.mAnimatedVectorState.mVectorDrawable;
        if (r11 == null) goto L21;
        r11.setCallback(null);
    L21:
        this.mAnimatedVectorState.mVectorDrawable = r6;
    L22:
        r4.recycle();
        goto L32
    L24:
        if ("target".equals(r3) == false) goto L32;
        r4 = r7.obtainAttributes(r9, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET);
        String r12 = r4.getString(0);
        int r13 = r4.getResourceId(1, 0);
        if (r13 == 0) goto L22;
        Context r14 = this.mContext;
        if (r14 == null) goto L30;
        setupAnimatorsForTarget(r12, AnimatorInflaterCompat.loadAnimator(r14, r13));
        goto L22
    L30:
        r4.recycle();
        throw new IllegalStateException("Context can't be null when inflating animators");
    L32:
        r1 = r8.next();
    L33:
        this.mAnimatedVectorState.setupAnimatorSet();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L7;
        return DrawableCompat.isAutoMirrored(r0);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L7;
        return ((AnimatedVectorDrawable) r0).isRunning();
    L7:
        return this.mAnimatedVectorState.mAnimatorSet.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L7;
        return r0.isStateful();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.isStateful();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L5;
        r0.mutate();
    L5:
        return this;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r2) {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L6;
        r0.setBounds(r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setBounds(r2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r2) {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L7;
        return r0.setLevel(r2);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.setLevel(r2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] r2) {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L7;
        return r0.setState(r2);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.setState(r2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r2) {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L6;
        registerPlatformCallback((AnimatedVectorDrawable) r0, r2);
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

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L6;
        r0.setAlpha(r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r2) {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L6;
        DrawableCompat.setAutoMirrored(r0, r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setAutoMirrored(r2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int r1) {
        super.setChangingConfigurations(r1);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int r1, PorterDuff.Mode r2) {
        super.setColorFilter(r1, r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L6;
        r0.setColorFilter(r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setColorFilter(r2);
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

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r2) {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L6;
        DrawableCompat.setTint(r0, r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTint(r2);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r2) {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L6;
        DrawableCompat.setTintList(r0, r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTintList(r2);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r2) {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L6;
        DrawableCompat.setTintMode(r0, r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTintMode(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r2, boolean r3) {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 != null) goto L5;
        this.mAnimatedVectorState.mVectorDrawable.setVisible(r2, r3);
        return super.setVisible(r2, r3);
    L5:
        return r0.setVisible(r2, r3);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L7;
        ((AnimatedVectorDrawable) r0).start();
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
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L6;
        ((AnimatedVectorDrawable) r0).stop();
        return;
    L6:
        this.mAnimatedVectorState.mAnimatorSet.end();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r2) {
        Drawable r0 = this.mDelegateDrawable;
        if (r0 == null) goto L5;
        unregisterPlatformCallback((AnimatedVectorDrawable) r0, r2);
    L5:
        ArrayList<Animatable2Compat.AnimationCallback> r1 = this.mAnimationCallbacks;
        if (r1 == null) goto L13;
        if (r2 == null) goto L15;
        boolean r3 = r1.remove(r2);
        if (this.mAnimationCallbacks.size() != 0) goto L12;
        removeAnimatorSetListener();
    L12:
        return r3;
    L15:
        return false;
    L13:
        return false;
    }
}
