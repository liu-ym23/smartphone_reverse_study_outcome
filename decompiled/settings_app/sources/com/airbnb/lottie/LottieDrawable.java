package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private static final String TAG = "LottieDrawable";
    private int alpha;
    private final LottieValueAnimator animator;
    private final Set<ColorFilterData> colorFilterData;
    private LottieComposition composition;
    private CompositionLayer compositionLayer;
    private boolean enableMergePaths;
    FontAssetDelegate fontAssetDelegate;
    private FontAssetManager fontAssetManager;
    private ImageAssetDelegate imageAssetDelegate;
    private ImageAssetManager imageAssetManager;
    private String imageAssetsFolder;
    private boolean isApplyingOpacityToLayersEnabled;
    private boolean isDirty;
    private boolean isExtraScaleEnabled;
    private final ArrayList<LazyCompositionTask> lazyCompositionTasks;
    private final Matrix matrix;
    private boolean performanceTrackingEnabled;
    private final ValueAnimator.AnimatorUpdateListener progressUpdateListener;
    private boolean safeMode;
    private float scale;
    private ImageView.ScaleType scaleType;
    private boolean systemAnimationsEnabled;
    TextDelegate textDelegate;

    private static class ColorFilterData {
        final ColorFilter colorFilter;
        final String contentName;
        final String layerName;

        ColorFilterData(String r1, String r2, ColorFilter r3) {
            this.layerName = r1;
            this.contentName = r2;
            this.colorFilter = r3;
        }

        public int hashCode() {
            String r0 = this.layerName;
            if (r0 == null) goto L5;
            int r1 = 527 * r0.hashCode();
        L6:
            String r2 = this.contentName;
            if (r2 != null) goto L9;
            return r1;
        L9:
            return (r1 * 31) * r2.hashCode();
        L5:
            r1 = 17;
            goto L6
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ColorFilterData) == true) goto L8;
            return false;
        L8:
            ColorFilterData r6 = (ColorFilterData) r5;
            if (hashCode() != r6.hashCode()) goto L14;
            if (this.colorFilter != r6.colorFilter) goto L14;
            return true;
        L14:
            return false;
        }
    }

    private interface LazyCompositionTask {
        void run(LottieComposition r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    static /* synthetic */ CompositionLayer access$000(LottieDrawable r0) {
        return r0.compositionLayer;
    }

    static /* synthetic */ LottieValueAnimator access$100(LottieDrawable r0) {
        return r0.animator;
    }

    public LottieDrawable() {
        this.matrix = new Matrix();
        LottieValueAnimator r0 = new LottieValueAnimator();
        this.animator = r0;
        this.scale = 1.0f;
        this.systemAnimationsEnabled = true;
        this.safeMode = false;
        this.colorFilterData = new HashSet();
        this.lazyCompositionTasks = new ArrayList();
        ValueAnimator.AnimatorUpdateListener r3 = new AnonymousClass1(this);
        this.progressUpdateListener = r3;
        this.alpha = 255;
        this.isExtraScaleEnabled = true;
        this.isDirty = false;
        r0.addUpdateListener(r3);
    }

    public boolean hasMasks() {
        CompositionLayer r0 = this.compositionLayer;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hasMasks() == false) goto L7;
        return true;
    }

    public boolean hasMatte() {
        CompositionLayer r0 = this.compositionLayer;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hasMatte() == false) goto L7;
        return true;
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public void enableMergePathsForKitKatAndAbove(boolean r2) {
        if (this.enableMergePaths != r2) goto L5;
        return;
    L5:
        this.enableMergePaths = r2;
        if (this.composition == null) goto L9;
        buildCompositionLayer();
        return;
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public void setImagesAssetsFolder(String r1) {
        this.imageAssetsFolder = r1;
    }

    public String getImageAssetsFolder() {
        return this.imageAssetsFolder;
    }

    public boolean setComposition(LottieComposition r3) {
        if (this.composition != r3) goto L5;
        return false;
    L5:
        this.isDirty = false;
        clearComposition();
        this.composition = r3;
        buildCompositionLayer();
        this.animator.setComposition(r3);
        setProgress(this.animator.getAnimatedFraction());
        setScale(this.scale);
        updateBounds();
        Iterator r0 = new ArrayList(this.lazyCompositionTasks).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((LazyCompositionTask) r0.next()).run(r3);
        r0.remove();
        goto L7
    L9:
        this.lazyCompositionTasks.clear();
        r3.setPerformanceTrackingEnabled(this.performanceTrackingEnabled);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean r1) {
        this.performanceTrackingEnabled = r1;
        LottieComposition r0 = this.composition;
        if (r0 == null) goto L6;
        r0.setPerformanceTrackingEnabled(r1);
        return;
    }

    public PerformanceTracker getPerformanceTracker() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getPerformanceTracker();
    }

    public void setApplyingOpacityToLayersEnabled(boolean r1) {
        this.isApplyingOpacityToLayersEnabled = r1;
    }

    public void disableExtraScaleModeInFitXY() {
        this.isExtraScaleEnabled = false;
    }

    public boolean isApplyingOpacityToLayersEnabled() {
        return this.isApplyingOpacityToLayersEnabled;
    }

    private void buildCompositionLayer() {
        this.compositionLayer = new CompositionLayer(this, LayerParser.parse(this.composition), this.composition.getLayers(), this.composition);
    }

    public void clearComposition() {
        if (this.animator.isRunning() == false) goto L5;
        this.animator.cancel();
    L5:
        this.composition = null;
        this.compositionLayer = null;
        this.imageAssetManager = null;
        this.animator.clearComposition();
        invalidateSelf();
    }

    public void setSafeMode(boolean r1) {
        this.safeMode = r1;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.isDirty == false) goto L5;
        return;
    L5:
        this.isDirty = true;
        Drawable.Callback r0 = getCallback();
        if (r0 == null) goto L9;
        r0.invalidateDrawable(this);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
        this.alpha = r1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        Logger.warning("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r3) {
        this.isDirty = false;
        L.beginSection("Drawable#draw");
        if (this.safeMode == true) goto L11;
        drawInternal(r3);
    L9:
        L.endSection("Drawable#draw");
        return;
    L11:
        drawInternal(r3);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Logger.error("Lottie crashed in draw!", th);
        goto L9
    }

    private void drawInternal(Canvas r3) {
        if (ImageView.ScaleType.FIT_XY != this.scaleType) goto L5;
        drawWithNewAspectRatio(r3);
        return;
    L5:
        drawWithOriginalAspectRatio(r3);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        playAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        endAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return isAnimating();
    }

    public void playAnimation() {
        if (this.compositionLayer != null) goto L7;
        this.lazyCompositionTasks.add(new AnonymousClass2(this));
        return;
    L7:
        if (this.systemAnimationsEnabled == false) goto L9;
    L10:
        this.animator.playAnimation();
    L12:
        if (this.systemAnimationsEnabled == false) goto L14;
        return;
    L14:
        if (getSpeed() >= 0.0f) goto L16;
        float r0 = getMinFrame();
    L17:
        setFrame((int) r0);
        this.animator.endAnimation();
        return;
    L16:
        r0 = getMaxFrame();
        goto L17
    L9:
        if (getRepeatCount() != 0) goto L12;
        goto L10
    }

    public void endAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.endAnimation();
    }

    public void resumeAnimation() {
        if (this.compositionLayer != null) goto L7;
        this.lazyCompositionTasks.add(new AnonymousClass3(this));
        return;
    L7:
        if (this.systemAnimationsEnabled == false) goto L9;
    L10:
        this.animator.resumeAnimation();
    L12:
        if (this.systemAnimationsEnabled == false) goto L14;
        return;
    L14:
        if (getSpeed() >= 0.0f) goto L16;
        float r0 = getMinFrame();
    L17:
        setFrame((int) r0);
        this.animator.endAnimation();
        return;
    L16:
        r0 = getMaxFrame();
        goto L17
    L9:
        if (getRepeatCount() != 0) goto L12;
        goto L10
    }

    public void setMinFrame(final int r3) {
        if (this.composition != null) goto L6;
        this.lazyCompositionTasks.add(new AnonymousClass4(this, r3));
        return;
    L6:
        this.animator.setMinFrame(r3);
    }

    public float getMinFrame() {
        return this.animator.getMinFrame();
    }

    public void setMinProgress(final float r3) {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        this.lazyCompositionTasks.add(new AnonymousClass5(this, r3));
        return;
    L6:
        setMinFrame((int) MiscUtils.lerp(r0.getStartFrame(), this.composition.getEndFrame(), r3));
    }

    public void setMaxFrame(final int r3) {
        if (this.composition != null) goto L6;
        this.lazyCompositionTasks.add(new AnonymousClass6(this, r3));
        return;
    L6:
        this.animator.setMaxFrame(r3 + 0.99f);
    }

    public float getMaxFrame() {
        return this.animator.getMaxFrame();
    }

    public void setMaxProgress(final float r3) {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        this.lazyCompositionTasks.add(new AnonymousClass7(this, r3));
        return;
    L6:
        setMaxFrame((int) MiscUtils.lerp(r0.getStartFrame(), this.composition.getEndFrame(), r3));
    }

    public void setMinFrame(final String r3) {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        this.lazyCompositionTasks.add(new AnonymousClass8(this, r3));
        return;
    L6:
        Marker r1 = r0.getMarker(r3);
        if (r1 == null) goto L11;
        setMinFrame((int) r1.startFrame);
        return;
    L11:
        throw new IllegalArgumentException("Cannot find marker with name " + r3 + ".");
    }

    public void setMaxFrame(final String r3) {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        this.lazyCompositionTasks.add(new AnonymousClass9(this, r3));
        return;
    L6:
        Marker r1 = r0.getMarker(r3);
        if (r1 == null) goto L11;
        setMaxFrame((int) (r1.startFrame + r1.durationFrames));
        return;
    L11:
        throw new IllegalArgumentException("Cannot find marker with name " + r3 + ".");
    }

    public void setMinAndMaxFrame(final String r3) {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        this.lazyCompositionTasks.add(new AnonymousClass10(this, r3));
        return;
    L6:
        Marker r1 = r0.getMarker(r3);
        if (r1 == null) goto L11;
        int r4 = (int) r1.startFrame;
        setMinAndMaxFrame(r4, ((int) r1.durationFrames) + r4);
        return;
    L11:
        throw new IllegalArgumentException("Cannot find marker with name " + r3 + ".");
    }

    public void setMinAndMaxFrame(final String r4, final String r5, final boolean r6) {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        this.lazyCompositionTasks.add(new AnonymousClass11(this, r4, r5, r6));
        return;
    L6:
        Marker r1 = r0.getMarker(r4);
        if (r1 == null) goto L19;
        int r7 = (int) r1.startFrame;
        Marker r2 = this.composition.getMarker(r5);
        if (r5 == null) goto L17;
        float r8 = r2.startFrame;
        if (r6 == false) goto L13;
        float r9 = 1.0f;
    L14:
        setMinAndMaxFrame(r7, (int) (r8 + r9));
        return;
    L13:
        r9 = 0.0f;
        goto L14
    L17:
        throw new IllegalArgumentException("Cannot find marker with name " + r5 + ".");
    L19:
        throw new IllegalArgumentException("Cannot find marker with name " + r4 + ".");
    }

    public void setMinAndMaxFrame(final int r3, final int r4) {
        if (this.composition != null) goto L6;
        this.lazyCompositionTasks.add(new AnonymousClass12(this, r3, r4));
        return;
    L6:
        this.animator.setMinAndMaxFrames(r3, r4 + 0.99f);
    }

    public void setMinAndMaxProgress(final float r3, final float r4) {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        this.lazyCompositionTasks.add(new AnonymousClass13(this, r3, r4));
        return;
    L6:
        setMinAndMaxFrame((int) MiscUtils.lerp(r0.getStartFrame(), this.composition.getEndFrame(), r3), (int) MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), r4));
    }

    public void reverseAnimationSpeed() {
        this.animator.reverseAnimationSpeed();
    }

    public void setSpeed(float r1) {
        this.animator.setSpeed(r1);
    }

    public float getSpeed() {
        return this.animator.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener r1) {
        this.animator.addUpdateListener(r1);
    }

    public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener r1) {
        this.animator.removeUpdateListener(r1);
    }

    public void removeAllUpdateListeners() {
        this.animator.removeAllUpdateListeners();
        this.animator.addUpdateListener(this.progressUpdateListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener r1) {
        this.animator.addListener(r1);
    }

    public void removeAnimatorListener(Animator.AnimatorListener r1) {
        this.animator.removeListener(r1);
    }

    public void removeAllAnimatorListeners() {
        this.animator.removeAllListeners();
    }

    public void setFrame(final int r3) {
        if (this.composition != null) goto L6;
        this.lazyCompositionTasks.add(new AnonymousClass14(this, r3));
        return;
    L6:
        this.animator.setFrame(r3);
    }

    public int getFrame() {
        return (int) this.animator.getFrame();
    }

    public void setProgress(final float r4) {
        if (this.composition != null) goto L6;
        this.lazyCompositionTasks.add(new AnonymousClass15(this, r4));
        return;
    L6:
        L.beginSection("Drawable#setProgress");
        this.animator.setFrame(MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), r4));
        L.endSection("Drawable#setProgress");
    }

    @Deprecated
    public void loop(boolean r1) {
        LottieValueAnimator r0 = this.animator;
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
        this.animator.setRepeatMode(r1);
    }

    public int getRepeatMode() {
        return this.animator.getRepeatMode();
    }

    public void setRepeatCount(int r1) {
        this.animator.setRepeatCount(r1);
    }

    public int getRepeatCount() {
        return this.animator.getRepeatCount();
    }

    public boolean isLooping() {
        if (this.animator.getRepeatCount() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isAnimating() {
        LottieValueAnimator r0 = this.animator;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isRunning();
    }

    void setSystemAnimationsAreEnabled(Boolean r1) {
        this.systemAnimationsEnabled = r1.booleanValue();
    }

    public void setScale(float r1) {
        this.scale = r1;
        updateBounds();
    }

    public void setImageAssetDelegate(ImageAssetDelegate r1) {
        this.imageAssetDelegate = r1;
        ImageAssetManager r0 = this.imageAssetManager;
        if (r0 == null) goto L6;
        r0.setDelegate(r1);
        return;
    }

    public void setFontAssetDelegate(FontAssetDelegate r1) {
        this.fontAssetDelegate = r1;
        FontAssetManager r0 = this.fontAssetManager;
        if (r0 == null) goto L6;
        r0.setDelegate(r1);
        return;
    }

    public void setTextDelegate(TextDelegate r1) {
        this.textDelegate = r1;
    }

    public TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public boolean useTextGlyphs() {
        if (this.textDelegate == null) goto L5;
    L7:
        return false;
    L5:
        if (this.composition.getCharacters().size() <= 0) goto L7;
        return true;
    }

    public float getScale() {
        return this.scale;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    private void updateBounds() {
        if (this.composition != null) goto L5;
        return;
    L5:
        float r0 = getScale();
        setBounds(0, 0, (int) (this.composition.getBounds().width() * r0), (int) (this.composition.getBounds().height() * r0));
    }

    public void cancelAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.cancel();
    }

    public void pauseAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.pauseAnimation();
    }

    public float getProgress() {
        return this.animator.getAnimatedValueAbsolute();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return (int) (r0.getBounds().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return (int) (r0.getBounds().height() * getScale());
    }

    public List<KeyPath> resolveKeyPath(KeyPath r5) {
        if (this.compositionLayer != null) goto L6;
        Logger.warning("Cannot resolve KeyPath. Composition is not set yet.");
        return Collections.emptyList();
    L6:
        ArrayList r0 = new ArrayList();
        this.compositionLayer.resolveKeyPath(r5, 0, r0, new KeyPath(new String[0]));
        return r0;
    }

    public <T> void addValueCallback(final KeyPath r4, final T r5, final LottieValueCallback<T> r6) {
        if (this.compositionLayer != null) goto L6;
        this.lazyCompositionTasks.add(new AnonymousClass16(this, r4, r5, r6));
        return;
    L6:
        boolean r1 = true;
        if (r4.getResolvedElement() == null) goto L9;
        r4.getResolvedElement().addValueCallback(r5, r6);
    L14:
        if (r1 == false) goto L20;
        invalidateSelf();
        if (r5 != LottieProperty.TIME_REMAP) goto L21;
        setProgress(getProgress());
        return;
    L21:
        return;
    L20:
        return;
    L9:
        List<KeyPath> r7 = resolveKeyPath(r4);
        int r0 = 0;
    L11:
        if (r0 >= r7.size()) goto L13;
        r7.get(r0).getResolvedElement().addValueCallback(r5, r6);
        r0 = r0 + 1;
        goto L11
    L13:
        r1 = true ^ r7.isEmpty();
        goto L14
    }

    public <T> void addValueCallback(KeyPath r2, T r3, final SimpleLottieValueCallback<T> r4) {
        addValueCallback(r2, r3, new AnonymousClass17(this, r4));
    }

    public Bitmap updateBitmap(String r2, Bitmap r3) {
        ImageAssetManager r0 = getImageAssetManager();
        if (r0 != null) goto L6;
        Logger.warning("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
        return null;
    L6:
        Bitmap r4 = r0.updateBitmap(r2, r3);
        invalidateSelf();
        return r4;
    }

    public Bitmap getImageAsset(String r1) {
        ImageAssetManager r0 = getImageAssetManager();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.bitmapForId(r1);
    }

    private ImageAssetManager getImageAssetManager() {
        if (getCallback() != null) goto L5;
        return null;
    L5:
        ImageAssetManager r0 = this.imageAssetManager;
        if (r0 == null) goto L11;
        if (r0.hasSameContext(getContext()) == true) goto L11;
        this.imageAssetManager = null;
    L11:
        if (this.imageAssetManager != null) goto L14;
        this.imageAssetManager = new ImageAssetManager(getCallback(), this.imageAssetsFolder, this.imageAssetDelegate, this.composition.getImages());
    L14:
        return this.imageAssetManager;
    }

    public Typeface getTypeface(String r1, String r2) {
        FontAssetManager r0 = getFontAssetManager();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getTypeface(r1, r2);
    }

    private FontAssetManager getFontAssetManager() {
        if (getCallback() != null) goto L7;
        return null;
    L7:
        if (this.fontAssetManager != null) goto L10;
        this.fontAssetManager = new FontAssetManager(getCallback(), this.fontAssetDelegate);
    L10:
        return this.fontAssetManager;
    }

    private Context getContext() {
        Drawable.Callback r2 = getCallback();
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof View) == true) goto L8;
        return null;
    L8:
        return ((View) r2).getContext();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r1) {
        Drawable.Callback r2 = getCallback();
        if (r2 != null) goto L5;
        return;
    L5:
        r2.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
        Drawable.Callback r4 = getCallback();
        if (r4 != null) goto L5;
        return;
    L5:
        r4.scheduleDrawable(this, r2, r3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r1, Runnable r2) {
        Drawable.Callback r3 = getCallback();
        if (r3 != null) goto L5;
        return;
    L5:
        r3.unscheduleDrawable(this, r2);
    }

    void setScaleType(ImageView.ScaleType r1) {
        this.scaleType = r1;
    }

    private float getMaxScale(Canvas r3) {
        return Math.min(r3.getWidth() / this.composition.getBounds().width(), r3.getHeight() / this.composition.getBounds().height());
    }

    private void drawWithNewAspectRatio(Canvas r9) {
        if (this.compositionLayer != null) goto L5;
        return;
    L5:
        Rect r0 = getBounds();
        float r1 = r0.width() / this.composition.getBounds().width();
        float r2 = r0.height() / this.composition.getBounds().height();
        int r4 = -1;
        if (this.isExtraScaleEnabled == false) goto L14;
        float r3 = Math.min(r1, r2);
        if (r3 >= 1.0f) goto L10;
        float r6 = 1.0f / r3;
        r1 = r1 / r6;
        r2 = r2 / r6;
    L12:
        if (r6 <= 1.0f) goto L14;
        r4 = r9.save();
        float r5 = r0.width() / 2.0f;
        float r7 = r0.height() / 2.0f;
        float r8 = r5 * r3;
        float r10 = r3 * r7;
        r9.translate(r5 - r8, r7 - r10);
        r9.scale(r6, r6, r8, r10);
        goto L14
    L10:
        r6 = 1.0f;
    L14:
        this.matrix.reset();
        this.matrix.preScale(r1, r2);
        this.compositionLayer.draw(r9, this.matrix, this.alpha);
        if (r4 <= 0) goto L18;
        r9.restoreToCount(r4);
        return;
    }

    private void drawWithOriginalAspectRatio(Canvas r9) {
        if (this.compositionLayer != null) goto L5;
        return;
    L5:
        float r0 = this.scale;
        float r1 = getMaxScale(r9);
        if (r0 <= r1) goto L8;
        float r2 = this.scale / r1;
    L10:
        if (r2 <= 1.0f) goto L12;
        int r3 = r9.save();
        float r4 = this.composition.getBounds().width() / 2.0f;
        float r5 = this.composition.getBounds().height() / 2.0f;
        float r6 = r4 * r1;
        float r7 = r5 * r1;
        r9.translate((getScale() * r4) - r6, (getScale() * r5) - r7);
        r9.scale(r2, r2, r6, r7);
    L13:
        this.matrix.reset();
        this.matrix.preScale(r1, r1);
        this.compositionLayer.draw(r9, this.matrix, this.alpha);
        if (r3 <= 0) goto L17;
        r9.restoreToCount(r3);
        return;
    L17:
        return;
    L12:
        r3 = -1;
        goto L13
    L8:
        r1 = r0;
        r2 = 1.0f;
        goto L10
    }
}
