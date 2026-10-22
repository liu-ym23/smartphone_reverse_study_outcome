package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    private static final LottieListener<Throwable> DEFAULT_FAILURE_LISTENER = null;
    private static final String TAG = "LottieAnimationView";
    private String animationName;
    private int animationResId;
    private boolean autoPlay;
    private int buildDrawingCacheDepth;
    private boolean cacheComposition;
    private LottieComposition composition;
    private LottieTask<LottieComposition> compositionTask;
    private LottieListener<Throwable> failureListener;
    private int fallbackResource;
    private boolean isInitialized;
    private final LottieListener<LottieComposition> loadedListener;
    private final LottieDrawable lottieDrawable;
    private Set<LottieOnCompositionLoadedListener> lottieOnCompositionLoadedListeners;
    private RenderMode renderMode;
    private boolean wasAnimatingWhenDetached;
    private boolean wasAnimatingWhenNotShown;
    private final LottieListener<Throwable> wrappedFailureListener;

    /* JADX INFO: renamed from: com.airbnb.lottie.LottieAnimationView$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$RenderMode = null;

        static {
            int[] r0 = new int[RenderMode.values().length];
            $SwitchMap$com$airbnb$lottie$RenderMode = r0;
            r0[RenderMode.HARDWARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$airbnb$lottie$RenderMode[RenderMode.SOFTWARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$airbnb$lottie$RenderMode[RenderMode.AUTOMATIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        String animationName;
        int animationResId;
        String imageAssetsFolder;
        boolean isAnimating;
        float progress;
        int repeatCount;
        int repeatMode;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        SavedState(Parcelable r1) {
            super(r1);
        }

        private SavedState(Parcel r3) {
            super(r3);
            this.animationName = r3.readString();
            this.progress = r3.readFloat();
            boolean r1 = true;
            if (r3.readInt() == 1) goto L6;
            r1 = false;
        L6:
            this.isAnimating = r1;
            this.imageAssetsFolder = r3.readString();
            this.repeatMode = r3.readInt();
            this.repeatCount = r3.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeString(this.animationName);
            r1.writeFloat(this.progress);
            r1.writeInt(this.isAnimating ? 1 : 0);
            r1.writeString(this.imageAssetsFolder);
            r1.writeInt(this.repeatMode);
            r1.writeInt(this.repeatCount);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static /* synthetic */ int access$000(LottieAnimationView r0) {
        return r0.fallbackResource;
    }

    static /* synthetic */ LottieListener access$100(LottieAnimationView r0) {
        return r0.failureListener;
    }

    static /* synthetic */ LottieListener access$200() {
        return DEFAULT_FAILURE_LISTENER;
    }

    static {
        DEFAULT_FAILURE_LISTENER = new AnonymousClass1();
    }

    public LottieAnimationView(Context r2) {
        super(r2);
        this.loadedListener = new AnonymousClass2(this);
        this.wrappedFailureListener = new AnonymousClass3(this);
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.renderMode = RenderMode.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.buildDrawingCacheDepth = 0;
        init(null);
    }

    public LottieAnimationView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.loadedListener = new AnonymousClass2(this);
        this.wrappedFailureListener = new AnonymousClass3(this);
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.renderMode = RenderMode.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.buildDrawingCacheDepth = 0;
        init(r3);
    }

    public LottieAnimationView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.loadedListener = new AnonymousClass2(this);
        this.wrappedFailureListener = new AnonymousClass3(this);
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.renderMode = RenderMode.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.buildDrawingCacheDepth = 0;
        init(r2);
    }

    private void init(AttributeSet r8) {
        TypedArray r9 = getContext().obtainStyledAttributes(r8, R.styleable.LottieAnimationView);
        boolean r2 = false;
        if (isInEditMode() == true) goto L24;
        this.cacheComposition = r9.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
        boolean r0 = r9.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
        boolean r3 = r9.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
        boolean r4 = r9.hasValue(R.styleable.LottieAnimationView_lottie_url);
        if (r0 == false) goto L10;
        if (r3 == false) goto L10;
        throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
    L10:
        if (r0 == false) goto L14;
        int r1 = r9.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
        if (r1 == 0) goto L22;
        setAnimation(r1);
    L22:
        setFallbackResource(r9.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        goto L24
    L14:
        if (r3 == false) goto L18;
        String r5 = r9.getString(R.styleable.LottieAnimationView_lottie_fileName);
        if (r5 == null) goto L22;
        setAnimation(r5);
        goto L22
    L18:
        if (r4 == false) goto L22;
        String r6 = r9.getString(R.styleable.LottieAnimationView_lottie_url);
        if (r6 == null) goto L22;
        setAnimationFromUrl(r6);
    L24:
        if (r9.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false) == false) goto L27;
        this.wasAnimatingWhenDetached = true;
        this.autoPlay = true;
    L27:
        if (r9.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false) == false) goto L30;
        this.lottieDrawable.setRepeatCount(-1);
    L30:
        if (r9.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode) == false) goto L33;
        setRepeatMode(r9.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
    L33:
        if (r9.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount) == false) goto L36;
        setRepeatCount(r9.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
    L36:
        if (r9.hasValue(R.styleable.LottieAnimationView_lottie_speed) == false) goto L38;
        setSpeed(r9.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0f));
    L38:
        setImageAssetsFolder(r9.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(r9.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        enableMergePathsForKitKatAndAbove(r9.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (r9.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter) == false) goto L42;
        SimpleColorFilter r7 = new SimpleColorFilter(r9.getColor(R.styleable.LottieAnimationView_lottie_colorFilter, 0));
        addValueCallback(new KeyPath(new String[]{"**"}), LottieProperty.COLOR_FILTER, new LottieValueCallback(r7));
    L42:
        if (r9.hasValue(R.styleable.LottieAnimationView_lottie_scale) == false) goto L45;
        this.lottieDrawable.setScale(r9.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0f));
    L45:
        if (r9.hasValue(R.styleable.LottieAnimationView_lottie_renderMode) == false) goto L51;
        int r10 = r9.getInt(R.styleable.LottieAnimationView_lottie_renderMode, RenderMode.AUTOMATIC.ordinal());
        if (r10 < RenderMode.values().length) goto L49;
        r10 = RenderMode.AUTOMATIC.ordinal();
    L49:
        setRenderMode(RenderMode.values()[r10]);
    L51:
        if (getScaleType() == null) goto L53;
        this.lottieDrawable.setScaleType(getScaleType());
    L53:
        r9.recycle();
        LottieDrawable r11 = this.lottieDrawable;
        if (Utils.getAnimationScale(getContext()) == 0.0f) goto L56;
        r2 = true;
    L56:
        r11.setSystemAnimationsAreEnabled(Boolean.valueOf(r2));
        enableOrDisableHardwareLayer();
        this.isInitialized = true;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r1) {
        cancelLoaderTask();
        super.setImageResource(r1);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r1) {
        cancelLoaderTask();
        super.setImageDrawable(r1);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r1) {
        cancelLoaderTask();
        super.setImageBitmap(r1);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r3) {
        Drawable r0 = getDrawable();
        LottieDrawable r1 = this.lottieDrawable;
        if (r0 != r1) goto L5;
        super.invalidateDrawable(r1);
        return;
    L5:
        super.invalidateDrawable(r3);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.animationName = this.animationName;
        r1.animationResId = this.animationResId;
        r1.progress = this.lottieDrawable.getProgress();
        if (this.lottieDrawable.isAnimating() == false) goto L5;
    L10:
        boolean r0 = true;
    L11:
        r1.isAnimating = r0;
        r1.imageAssetsFolder = this.lottieDrawable.getImageAssetsFolder();
        r1.repeatMode = this.lottieDrawable.getRepeatMode();
        r1.repeatCount = this.lottieDrawable.getRepeatCount();
        return r1;
    L5:
        if (ViewCompat.isAttachedToWindow(this) == false) goto L7;
    L9:
        r0 = false;
        goto L11
    L7:
        if (this.wasAnimatingWhenDetached == false) goto L9;
        goto L9
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r3) {
        if ((r3 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r3);
        return;
    L6:
        SavedState r4 = (SavedState) r3;
        super.onRestoreInstanceState(r4.getSuperState());
        String r0 = r4.animationName;
        this.animationName = r0;
        if (TextUtils.isEmpty(r0) == true) goto L9;
        setAnimation(this.animationName);
    L9:
        int r1 = r4.animationResId;
        this.animationResId = r1;
        if (r1 == 0) goto L12;
        setAnimation(r1);
    L12:
        setProgress(r4.progress);
        if (r4.isAnimating == false) goto L15;
        playAnimation();
    L15:
        this.lottieDrawable.setImagesAssetsFolder(r4.imageAssetsFolder);
        setRepeatMode(r4.repeatMode);
        setRepeatCount(r4.repeatCount);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View r1, int r2) {
        if (this.isInitialized == true) goto L6;
        return;
    L6:
        if (isShown() == false) goto L11;
        if (this.wasAnimatingWhenNotShown == false) goto L14;
        resumeAnimation();
        this.wasAnimatingWhenNotShown = false;
        return;
    L14:
        return;
    L11:
        if (isAnimating() == false) goto L16;
        pauseAnimation();
        this.wasAnimatingWhenNotShown = true;
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay == false) goto L5;
    L6:
        playAnimation();
        this.autoPlay = false;
        this.wasAnimatingWhenDetached = false;
        return;
    L5:
        if (this.wasAnimatingWhenDetached == true) goto L6;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (isAnimating() == false) goto L5;
        cancelAnimation();
        this.wasAnimatingWhenDetached = true;
    L5:
        super.onDetachedFromWindow();
    }

    public void enableMergePathsForKitKatAndAbove(boolean r1) {
        this.lottieDrawable.enableMergePathsForKitKatAndAbove(r1);
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.isMergePathsEnabledForKitKatAndAbove();
    }

    public void setCacheComposition(boolean r1) {
        this.cacheComposition = r1;
    }

    public void setAnimation(int r3) {
        this.animationResId = r3;
        this.animationName = null;
        if (this.cacheComposition == false) goto L5;
        LottieTask<LottieComposition> r4 = LottieCompositionFactory.fromRawRes(getContext(), r3);
    L6:
        setCompositionTask(r4);
        return;
    L5:
        r4 = LottieCompositionFactory.fromRawRes(getContext(), r3, null);
        goto L6
    }

    public void setAnimation(String r3) {
        this.animationName = r3;
        this.animationResId = 0;
        if (this.cacheComposition == false) goto L5;
        LottieTask<LottieComposition> r4 = LottieCompositionFactory.fromAsset(getContext(), r3);
    L6:
        setCompositionTask(r4);
        return;
    L5:
        r4 = LottieCompositionFactory.fromAsset(getContext(), r3, null);
        goto L6
    }

    @Deprecated
    public void setAnimationFromJson(String r2) {
        setAnimationFromJson(r2, null);
    }

    public void setAnimationFromJson(String r2, String r3) {
        setAnimation(new ByteArrayInputStream(r2.getBytes()), r3);
    }

    public void setAnimation(InputStream r1, String r2) {
        setCompositionTask(LottieCompositionFactory.fromJsonInputStream(r1, r2));
    }

    public void setAnimationFromUrl(String r3) {
        if (this.cacheComposition == false) goto L5;
        LottieTask<LottieComposition> r4 = LottieCompositionFactory.fromUrl(getContext(), r3);
    L6:
        setCompositionTask(r4);
        return;
    L5:
        r4 = LottieCompositionFactory.fromUrl(getContext(), r3, null);
        goto L6
    }

    public void setFailureListener(LottieListener<Throwable> r1) {
        this.failureListener = r1;
    }

    public void setFallbackResource(int r1) {
        this.fallbackResource = r1;
    }

    private void setCompositionTask(LottieTask<LottieComposition> r2) {
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = r2.addListener(this.loadedListener).addFailureListener(this.wrappedFailureListener);
    }

    private void cancelLoaderTask() {
        LottieTask<LottieComposition> r0 = this.compositionTask;
        if (r0 == null) goto L6;
        r0.removeListener(this.loadedListener);
        this.compositionTask.removeFailureListener(this.wrappedFailureListener);
        return;
    }

    public void setComposition(LottieComposition r4) {
        if (L.DBG == false) goto L5;
        Log.v(TAG, "Set Composition \n" + r4);
    L5:
        this.lottieDrawable.setCallback(this);
        this.composition = r4;
        boolean r0 = this.lottieDrawable.setComposition(r4);
        enableOrDisableHardwareLayer();
        if (getDrawable() != this.lottieDrawable) goto L9;
        if (r0 == true) goto L9;
        return;
    L9:
        setImageDrawable(null);
        setImageDrawable(this.lottieDrawable);
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        Iterator<LottieOnCompositionLoadedListener> r3 = this.lottieOnCompositionLoadedListeners.iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        r3.next().onCompositionLoaded(r4);
        goto L11
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public boolean hasMasks() {
        return this.lottieDrawable.hasMasks();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.hasMatte();
    }

    public void playAnimation() {
        if (isShown() == false) goto L5;
        this.lottieDrawable.playAnimation();
        enableOrDisableHardwareLayer();
        return;
    L5:
        this.wasAnimatingWhenNotShown = true;
    }

    public void resumeAnimation() {
        if (isShown() == false) goto L5;
        this.lottieDrawable.resumeAnimation();
        enableOrDisableHardwareLayer();
        return;
    L5:
        this.wasAnimatingWhenNotShown = true;
    }

    public void setMinFrame(int r1) {
        this.lottieDrawable.setMinFrame(r1);
    }

    public float getMinFrame() {
        return this.lottieDrawable.getMinFrame();
    }

    public void setMinProgress(float r1) {
        this.lottieDrawable.setMinProgress(r1);
    }

    public void setMaxFrame(int r1) {
        this.lottieDrawable.setMaxFrame(r1);
    }

    public float getMaxFrame() {
        return this.lottieDrawable.getMaxFrame();
    }

    public void setMaxProgress(float r1) {
        this.lottieDrawable.setMaxProgress(r1);
    }

    public void setMinFrame(String r1) {
        this.lottieDrawable.setMinFrame(r1);
    }

    public void setMaxFrame(String r1) {
        this.lottieDrawable.setMaxFrame(r1);
    }

    public void setMinAndMaxFrame(String r1) {
        this.lottieDrawable.setMinAndMaxFrame(r1);
    }

    public void setMinAndMaxFrame(String r1, String r2, boolean r3) {
        this.lottieDrawable.setMinAndMaxFrame(r1, r2, r3);
    }

    public void setMinAndMaxFrame(int r1, int r2) {
        this.lottieDrawable.setMinAndMaxFrame(r1, r2);
    }

    public void setMinAndMaxProgress(float r1, float r2) {
        this.lottieDrawable.setMinAndMaxProgress(r1, r2);
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.reverseAnimationSpeed();
    }

    public void setSpeed(float r1) {
        this.lottieDrawable.setSpeed(r1);
    }

    public float getSpeed() {
        return this.lottieDrawable.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener r1) {
        this.lottieDrawable.addAnimatorUpdateListener(r1);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener r1) {
        this.lottieDrawable.removeAnimatorUpdateListener(r1);
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener r1) {
        this.lottieDrawable.addAnimatorListener(r1);
    }

    public void removeAnimatorListener(Animator.AnimatorListener r1) {
        this.lottieDrawable.removeAnimatorListener(r1);
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.removeAllAnimatorListeners();
    }

    @Deprecated
    public void loop(boolean r1) {
        LottieDrawable r0 = this.lottieDrawable;
        if (r1 == false) goto L5;
        int r2 = -1;
    L6:
        r0.setRepeatCount(r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public void setRepeatMode(int r1) {
        this.lottieDrawable.setRepeatMode(r1);
    }

    public int getRepeatMode() {
        return this.lottieDrawable.getRepeatMode();
    }

    public void setRepeatCount(int r1) {
        this.lottieDrawable.setRepeatCount(r1);
    }

    public int getRepeatCount() {
        return this.lottieDrawable.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.lottieDrawable.isAnimating();
    }

    public void setImageAssetsFolder(String r1) {
        this.lottieDrawable.setImagesAssetsFolder(r1);
    }

    public String getImageAssetsFolder() {
        return this.lottieDrawable.getImageAssetsFolder();
    }

    public Bitmap updateBitmap(String r1, Bitmap r2) {
        return this.lottieDrawable.updateBitmap(r1, r2);
    }

    public void setImageAssetDelegate(ImageAssetDelegate r1) {
        this.lottieDrawable.setImageAssetDelegate(r1);
    }

    public void setFontAssetDelegate(FontAssetDelegate r1) {
        this.lottieDrawable.setFontAssetDelegate(r1);
    }

    public void setTextDelegate(TextDelegate r1) {
        this.lottieDrawable.setTextDelegate(r1);
    }

    public List<KeyPath> resolveKeyPath(KeyPath r1) {
        return this.lottieDrawable.resolveKeyPath(r1);
    }

    public <T> void addValueCallback(KeyPath r1, T r2, LottieValueCallback<T> r3) {
        this.lottieDrawable.addValueCallback(r1, r2, r3);
    }

    public <T> void addValueCallback(KeyPath r3, T r4, final SimpleLottieValueCallback<T> r5) {
        this.lottieDrawable.addValueCallback(r3, r4, new AnonymousClass4(this, r5));
    }

    public void setScale(float r2) {
        this.lottieDrawable.setScale(r2);
        if (getDrawable() != this.lottieDrawable) goto L6;
        setImageDrawable(null);
        setImageDrawable(this.lottieDrawable);
        return;
    }

    public float getScale() {
        return this.lottieDrawable.getScale();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r1) {
        super.setScaleType(r1);
        LottieDrawable r0 = this.lottieDrawable;
        if (r0 == null) goto L6;
        r0.setScaleType(r1);
        return;
    }

    public void cancelAnimation() {
        this.wasAnimatingWhenNotShown = false;
        this.lottieDrawable.cancelAnimation();
        enableOrDisableHardwareLayer();
    }

    public void pauseAnimation() {
        this.autoPlay = false;
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.lottieDrawable.pauseAnimation();
        enableOrDisableHardwareLayer();
    }

    public void setFrame(int r1) {
        this.lottieDrawable.setFrame(r1);
    }

    public int getFrame() {
        return this.lottieDrawable.getFrame();
    }

    public void setProgress(float r1) {
        this.lottieDrawable.setProgress(r1);
    }

    public float getProgress() {
        return this.lottieDrawable.getProgress();
    }

    public long getDuration() {
        LottieComposition r2 = this.composition;
        if (r2 != null) goto L7;
        return 0;
    L7:
        return (long) r2.getDuration();
    }

    public void setPerformanceTrackingEnabled(boolean r1) {
        this.lottieDrawable.setPerformanceTrackingEnabled(r1);
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.lottieDrawable.getPerformanceTracker();
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.clearComposition();
    }

    public void setSafeMode(boolean r1) {
        this.lottieDrawable.setSafeMode(r1);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean r4) {
        L.beginSection("buildDrawingCache");
        this.buildDrawingCacheDepth++;
        super.buildDrawingCache(r4);
        if (this.buildDrawingCacheDepth == 1) goto L5;
    L13:
        this.buildDrawingCacheDepth--;
        L.endSection("buildDrawingCache");
        return;
    L5:
        if (getWidth() <= 0) goto L13;
        if (getHeight() <= 0) goto L13;
        if (getLayerType() != 1) goto L13;
        if (getDrawingCache(r4) != null) goto L13;
        setRenderMode(RenderMode.HARDWARE);
        goto L13
    }

    public void setRenderMode(RenderMode r1) {
        this.renderMode = r1;
        enableOrDisableHardwareLayer();
    }

    public void setApplyingOpacityToLayersEnabled(boolean r1) {
        this.lottieDrawable.setApplyingOpacityToLayersEnabled(r1);
    }

    public void disableExtraScaleModeInFitXY() {
        this.lottieDrawable.disableExtraScaleModeInFitXY();
    }

    private void enableOrDisableHardwareLayer() {
        int r0 = AnonymousClass5.$SwitchMap$com$airbnb$lottie$RenderMode[this.renderMode.ordinal()];
        int r1 = 2;
        if (r0 == 1) goto L19;
        if (r0 != 2) goto L6;
    L7:
        r1 = 1;
        goto L19
    L6:
        if (r0 != 3) goto L7;
        LottieComposition r2 = this.composition;
        if (r2 == null) goto L11;
        r2.hasDashPattern();
    L11:
        LottieComposition r3 = this.composition;
        if (r3 != null) goto L14;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L7;
    L14:
        if (r3.getMaskAndMatteCount() <= 4) goto L16;
        r4 = false;
    L19:
        if (r1 == getLayerType()) goto L22;
        setLayerType(r1, null);
        return;
    }

    public boolean addLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener r2) {
        LottieComposition r0 = this.composition;
        if (r0 == null) goto L6;
        r2.onCompositionLoaded(r0);
    L6:
        return this.lottieOnCompositionLoadedListeners.add(r2);
    }

    public boolean removeLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener r1) {
        return this.lottieOnCompositionLoadedListeners.remove(r1);
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }
}
