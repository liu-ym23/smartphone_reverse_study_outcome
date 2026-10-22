package com.android.settingslib.animation;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.RenderNodeAnimator;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.android.settingslib.R;

/* JADX INFO: loaded from: classes.dex */
public class AppearAnimationUtils implements AppearAnimationCreator<View> {
    public static final long DEFAULT_APPEAR_DURATION = 220;
    protected boolean mAppearing;
    protected final float mDelayScale;
    private final long mDuration;
    private final Interpolator mInterpolator;
    private final AppearAnimationProperties mProperties;
    protected RowTranslationScaler mRowTranslationScaler;
    private final float mStartTranslation;

    public class AppearAnimationProperties {
        public long[][] delays;
        public int maxDelayColIndex;
        public int maxDelayRowIndex;
        final /* synthetic */ AppearAnimationUtils this$0;

        public AppearAnimationProperties(AppearAnimationUtils r1) {
            this.this$0 = r1;
        }
    }

    public interface RowTranslationScaler {
        float getRowTranslationScale(int r1, int r2);
    }

    @Override // com.android.settingslib.animation.AppearAnimationCreator
    public /* bridge */ /* synthetic */ void createAnimation(View r1, long r2, long r4, float r6, boolean r7, Interpolator r8, Runnable r9) {
        createAnimation2(r1, r2, r4, r6, r7, r8, r9);
    }

    @Override // com.android.settingslib.animation.AppearAnimationCreator
    public /* bridge */ /* synthetic */ void createAnimation(View r1, long r2, long r4, float r6, boolean r7, Interpolator r8, Runnable r9, AnimatorListenerAdapter r10) {
        createAnimation2(r1, r2, r4, r6, r7, r8, r9, r10);
    }

    public AppearAnimationUtils(Context r8) {
        this(r8, 220, 1.0f, 1.0f, AnimationUtils.loadInterpolator(r8, 17563662));
    }

    public AppearAnimationUtils(Context r2, long r3, float r5, float r6, Interpolator r7) {
        this.mProperties = new AppearAnimationProperties(this);
        this.mInterpolator = r7;
        this.mStartTranslation = r2.getResources().getDimensionPixelOffset(R.dimen.appear_y_translation_start) * r5;
        this.mDelayScale = r6;
        this.mDuration = r3;
        this.mAppearing = true;
    }

    public void startAnimation2d(View[][] r1, Runnable r2) {
        startAnimation2d(r1, r2, this);
    }

    public void startAnimation(View[] r1, Runnable r2) {
        startAnimation(r1, r2, this);
    }

    public <T> void startAnimation2d(T[][] r2, Runnable r3, AppearAnimationCreator<T> r4) {
        startAnimations(getDelays(r2), r2, r3, r4);
    }

    public <T> void startAnimation(T[] r2, Runnable r3, AppearAnimationCreator<T> r4) {
        startAnimations(getDelays(r2), r2, r3, r4);
    }

    private <T> void startAnimations(AppearAnimationProperties r16, T[] r17, Runnable r18, AppearAnimationCreator<T> r19) {
        if (r16.maxDelayRowIndex != (-1)) goto L5;
    L26:
        r18.run();
        return;
    L5:
        if (r16.maxDelayColIndex == (-1)) goto L26;
        int r3 = 0;
    L9:
        if (r3 >= r16.delays.length) goto L25;
        long r7 = r16.delays[r3][0];
        if (r16.maxDelayRowIndex == r3) goto L13;
    L15:
        Runnable r14 = null;
    L16:
        RowTranslationScaler r4 = this.mRowTranslationScaler;
        if (r4 == null) goto L19;
        float r5 = r4.getRowTranslationScale(r3, r16.delays.length);
    L20:
        float r6 = r5 * this.mStartTranslation;
        T r8 = r17[r3];
        long r9 = this.mDuration;
        boolean r12 = this.mAppearing;
        if (r12 == true) goto L24;
        r6 = -r6;
    L24:
        r19.createAnimation(r8, r7, r9, r6, r12, this.mInterpolator, r14);
        r3 = r3 + 1;
        goto L9
    L19:
        r5 = 1.0f;
        goto L20
    L13:
        if (r16.maxDelayColIndex != 0) goto L15;
        r14 = r18;
        goto L16
    }

    private <T> void startAnimations(AppearAnimationProperties r19, T[][] r20, Runnable r21, AppearAnimationCreator<T> r22) {
        if (r19.maxDelayRowIndex != (-1)) goto L5;
    L30:
        r21.run();
        return;
    L5:
        if (r19.maxDelayColIndex == (-1)) goto L30;
        int r3 = 0;
    L9:
        if (r3 >= r19.delays.length) goto L29;
        long[] r4 = r19.delays[r3];
        RowTranslationScaler r5 = this.mRowTranslationScaler;
        if (r5 == null) goto L13;
        float r6 = r5.getRowTranslationScale(r3, r19.delays.length);
    L14:
        float r7 = r6 * this.mStartTranslation;
        int r8 = 0;
    L16:
        if (r8 >= r4.length) goto L28;
        long r10 = r4[r8];
        if (r19.maxDelayRowIndex == r3) goto L20;
    L22:
        Runnable r17 = null;
    L23:
        T r9 = r20[r3][r8];
        long r12 = this.mDuration;
        boolean r15 = this.mAppearing;
        if (r15 == false) goto L26;
        float r14 = r7;
    L27:
        r22.createAnimation(r9, r10, r12, r14, r15, this.mInterpolator, r17);
        r8 = r8 + 1;
        goto L16
    L26:
        r14 = -r7;
        goto L27
    L20:
        if (r19.maxDelayColIndex != r8) goto L22;
        r17 = r21;
        goto L23
    L28:
        r3 = r3 + 1;
        goto L9
    L13:
        r6 = 1.0f;
        goto L14
    }

    private <T> AppearAnimationProperties getDelays(T[] r8) {
        this.mProperties.maxDelayColIndex = -1;
        this.mProperties.maxDelayRowIndex = -1;
        this.mProperties.delays = new long[r8.length][];
        long r0 = -1;
        int r3 = 0;
    L4:
        if (r3 >= r8.length) goto L12;
        this.mProperties.delays[r3] = new long[1];
        long r4 = calculateDelay(r3, 0);
        this.mProperties.delays[r3][0] = r4;
        if (r8[r3] == null) goto L10;
        if (r4 <= r0) goto L10;
        this.mProperties.maxDelayColIndex = 0;
        this.mProperties.maxDelayRowIndex = r3;
        r0 = r4;
    L10:
        r3 = r3 + 1;
        goto L4
    L12:
        return this.mProperties;
    }

    private <T> AppearAnimationProperties getDelays(T[][] r10) {
        this.mProperties.maxDelayColIndex = -1;
        this.mProperties.maxDelayRowIndex = -1;
        this.mProperties.delays = new long[r10.length][];
        long r0 = -1;
        int r3 = 0;
    L4:
        if (r3 >= r10.length) goto L16;
        T[] r4 = r10[r3];
        this.mProperties.delays[r3] = new long[r4.length];
        int r5 = 0;
    L7:
        if (r5 >= r4.length) goto L14;
        long r6 = calculateDelay(r3, r5);
        this.mProperties.delays[r3][r5] = r6;
        if (r10[r3][r5] == null) goto L13;
        if (r6 <= r0) goto L13;
        this.mProperties.maxDelayColIndex = r5;
        this.mProperties.maxDelayRowIndex = r3;
        r0 = r6;
    L13:
        r5 = r5 + 1;
        goto L7
    L14:
        r3 = r3 + 1;
        goto L4
    L16:
        return this.mProperties;
    }

    protected long calculateDelay(int r7, int r8) {
        return (long) ((((double) (r7 * 40)) + ((((double) r8) * (Math.pow(r7, 0.4d) + 0.4d)) * 20.0d)) * ((double) this.mDelayScale));
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public float getStartTranslation() {
        return this.mStartTranslation;
    }

    /* JADX INFO: renamed from: createAnimation, reason: avoid collision after fix types in other method */
    public void createAnimation2(View r12, long r13, long r15, float r17, boolean r18, Interpolator r19, Runnable r20) {
        createAnimation2(r12, r13, r15, r17, r18, r19, r20, null);
    }

    /* JADX INFO: renamed from: createAnimation, reason: avoid collision after fix types in other method */
    public void createAnimation2(final View r13, long r14, long r16, float r18, boolean r19, Interpolator r20, final Runnable r21, AnimatorListenerAdapter r22) {
        if (r13 != null) goto L5;
        return;
    L5:
        if (r19 == false) goto L7;
        final float r4 = 1.0f;
    L8:
        if (r19 == false) goto L10;
        float r5 = 0.0f;
    L11:
        r13.setAlpha(1.0f - r4);
        r13.setTranslationY(r18 - r5);
        if (r13.isHardwareAccelerated() == false) goto L14;
        RenderNodeAnimator r2 = new RenderNodeAnimator(11, r4);
        r2.setTarget(r13);
    L15:
        r2.setInterpolator(r20);
        r2.setDuration(r16);
        r2.setStartDelay(r14);
        if (r13.hasOverlappingRendering() == false) goto L18;
        r13.setLayerType(2, null);
        r2.addListener(new AnonymousClass1(this, r13));
    L18:
        r2.addListener(new AnonymousClass2(this, r13, r4, r21));
        r2.start();
        startTranslationYAnimation(r13, r14, r16, r5, r20, r22);
        return;
    L14:
        r2 = ObjectAnimator.ofFloat(r13, View.ALPHA, new float[]{r13.getAlpha(), r4});
        goto L15
    L10:
        r5 = r18;
        goto L11
    L7:
        r4 = 0.0f;
        goto L8
    }

    public static void startTranslationYAnimation(View r8, long r9, long r11, float r13, Interpolator r14) {
        startTranslationYAnimation(r8, r9, r11, r13, r14, null);
    }

    public static void startTranslationYAnimation(final View r5, long r6, long r8, final float r10, Interpolator r11, AnimatorListenerAdapter r12) {
        if (r5.isHardwareAccelerated() == false) goto L5;
        RenderNodeAnimator r0 = new RenderNodeAnimator(1, r10);
        r0.setTarget(r5);
    L6:
        r0.setInterpolator(r11);
        r0.setDuration(r8);
        r0.setStartDelay(r6);
        if (r12 == null) goto L9;
        r0.addListener(r12);
    L9:
        r0.addListener(new AnonymousClass3(r5, r10));
        r0.start();
        return;
    L5:
        r0 = ObjectAnimator.ofFloat(r5, View.TRANSLATION_Y, new float[]{r5.getTranslationY(), r10});
        goto L6
    }
}
