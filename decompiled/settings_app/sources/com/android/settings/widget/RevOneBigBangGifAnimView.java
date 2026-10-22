package com.android.settings.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.settings.R;
import com.android.settings.utils.NullSafe;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.oui.texteffects.preset.DimPointEffectTokens;

/* JADX INFO: loaded from: classes.dex */
public class RevOneBigBangGifAnimView extends RelativeLayout {
    private Animator mAnimator;
    private ImageView mIvCircleIcon;
    private ImageView mIvCircleText;
    private ImageView mIvMagnifier;
    private ImageView mIvMask;
    private ImageView mIvSmallWindow;

    static /* synthetic */ void access$000(RevOneBigBangGifAnimView r0) {
        r0.reset();
    }

    static /* synthetic */ void access$100(RevOneBigBangGifAnimView r0) {
        r0.run();
    }

    static /* synthetic */ ImageView access$200(RevOneBigBangGifAnimView r0) {
        return r0.mIvCircleIcon;
    }

    static /* synthetic */ ImageView access$300(RevOneBigBangGifAnimView r0) {
        return r0.mIvCircleText;
    }

    public RevOneBigBangGifAnimView(Context r2) {
        this(r2, null);
    }

    public RevOneBigBangGifAnimView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public RevOneBigBangGifAnimView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        inflate(r1, R.layout.revone_bigbang_gif_anim_layout, this);
        this.mIvMagnifier = (ImageView) NullSafe.nonNull(findViewById(R.id.iv_magnifier));
        this.mIvCircleIcon = (ImageView) NullSafe.nonNull(findViewById(R.id.iv_circle_icon));
        this.mIvMask = (ImageView) NullSafe.nonNull(findViewById(R.id.iv_mask));
        this.mIvCircleText = (ImageView) NullSafe.nonNull(findViewById(R.id.iv_circle_text));
        this.mIvSmallWindow = (ImageView) NullSafe.nonNull(findViewById(R.id.iv_small_window));
        reset();
    }

    public void startAnim() {
        if (isRunning() == true) goto L6;
        run();
        return;
    }

    public void stopAnim() {
        if (isRunning() == false) goto L6;
        this.mAnimator.removeAllListeners();
        this.mAnimator.cancel();
        this.mAnimator = null;
        return;
    }

    private void run() {
        if (this.mAnimator != null) goto L5;
        this.mAnimator = createAllAnimators();
    L5:
        this.mAnimator.start();
    }

    private boolean isRunning() {
        Animator r0 = this.mAnimator;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isRunning() == false) goto L7;
        return true;
    }

    private void reset() {
        this.mIvMagnifier.setAlpha(0.0f);
        this.mIvCircleIcon.setAlpha(0.0f);
        this.mIvMask.setAlpha(0.0f);
        this.mIvCircleText.setAlpha(0.0f);
        this.mIvSmallWindow.setAlpha(0.0f);
    }

    private Animator createAllAnimators() {
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{createMagnifierAnim(), createCircleIconAnim(), createMaskAnim(), createCircleTextAnim(), createSmallWindowAnim()});
        r0.addListener(new AnonymousClass1(this));
        return r0;
    }

    private Animator createMagnifierAnim() {
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{createAlphaAnim(this.mIvMagnifier, 0.0f, 1.0f, 250, 625), createAlphaAnim(this.mIvMagnifier, 1.0f, 0.0f, 125, 2125)});
        return r0;
    }

    private Animator createCircleIconAnim() {
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{createAlphaAnim(this.mIvCircleIcon, 0.5f, 1.0f, 250, DimPointEffectTokens.PendingCycleMs), createScaleAnim(this.mIvCircleIcon, 1.0f, 0.6f, 250, DimPointEffectTokens.PendingCycleMs), createAlphaAnim(this.mIvCircleIcon, 1.0f, 0.3f, 250, 1750), createScaleAnim(this.mIvCircleIcon, 0.6f, 1.2f, 250, 1750)});
        r0.addListener(new AnonymousClass2(this));
        return r0;
    }

    private Animator createMaskAnim() {
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{createAlphaAnim(this.mIvMask, 0.0f, 1.0f, 250, 2250), createAlphaAnim(this.mIvMask, 1.0f, 0.0f, 250, 3750)});
        return r0;
    }

    private Animator createCircleTextAnim() {
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{createAlphaAnim(this.mIvCircleText, 0.5f, 1.0f, 250, WsConstants.EXIT_DELAY_TIME), createScaleAnim(this.mIvCircleText, 1.0f, 0.6f, 250, WsConstants.EXIT_DELAY_TIME), createAlphaAnim(this.mIvCircleText, 1.0f, 0.3f, 250, 3250), createScaleAnim(this.mIvCircleText, 0.6f, 1.2f, 250, 3250)});
        r0.addListener(new AnonymousClass3(this));
        return r0;
    }

    private Animator createSmallWindowAnim() {
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{createAlphaAnim(this.mIvSmallWindow, 0.0f, 1.0f, 125, 3875), createAlphaAnim(this.mIvSmallWindow, 1.0f, 1.0f, 1000, 4000)});
        return r0;
    }

    private static Animator createAlphaAnim(View r6, float r7, float r8, long r9, long r11) {
        ObjectAnimator r10 = ofFloatObjectAnimator(r6, "alpha", r7, r8, r9);
        r10.setStartDelay(r11);
        return r10;
    }

    private static Animator createScaleAnim(View r10, float r11, float r12, long r13, long r15) {
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{ofFloatObjectAnimator(r10, "scaleX", r11, r12, r13), ofFloatObjectAnimator(r10, "scaleY", r11, r12, r13)});
        r0.setStartDelay(r15);
        return r0;
    }

    private static ObjectAnimator ofFloatObjectAnimator(View r2, String r3, float r4, float r5, long r6) {
        ObjectAnimator r7 = ObjectAnimator.ofFloat(r2, r3, new float[]{r4, r5});
        r7.setDuration(r6);
        return r7;
    }
}
