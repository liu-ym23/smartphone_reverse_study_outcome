package com.airbnb.lottie.utils;

import android.view.Choreographer;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;

/* JADX INFO: loaded from: classes.dex */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
    private LottieComposition composition;
    private float frame;
    private long lastFrameTimeNs;
    private float maxFrame;
    private float minFrame;
    private int repeatCount;
    protected boolean running;
    private float speed;
    private boolean speedReversedForRepeatMode;

    public LottieValueAnimator() {
        this.speed = 1.0f;
        this.speedReversedForRepeatMode = false;
        this.lastFrameTimeNs = 0;
        this.frame = 0.0f;
        this.repeatCount = 0;
        this.minFrame = -2.1474836E9f;
        this.maxFrame = 2.1474836E9f;
        this.running = false;
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }

    public float getAnimatedValueAbsolute() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return (this.frame - r0.getStartFrame()) / (this.composition.getEndFrame() - this.composition.getStartFrame());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        if (this.composition != null) goto L7;
        return 0.0f;
    L7:
        if (isReversed() == false) goto L11;
        float r0 = getMaxFrame() - this.frame;
        float r1 = getMaxFrame();
        float r2 = getMinFrame();
    L10:
        return r0 / (r1 - r2);
    L11:
        r0 = this.frame - getMinFrame();
        r1 = getMaxFrame();
        r2 = getMinFrame();
        goto L10
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        LottieComposition r2 = this.composition;
        if (r2 != null) goto L6;
        return 0;
    L6:
        return (long) r2.getDuration();
    }

    public float getFrame() {
        return this.frame;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.running;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long r7) {
        postFrameCallback();
        if (this.composition != null) goto L5;
        return;
    L5:
        if (isRunning() == false) goto L37;
        L.beginSection("LottieValueAnimator#doFrame");
        long r1 = this.lastFrameTimeNs;
        long r3 = 0;
        if (r1 == 0) goto L11;
        r3 = r7 - r1;
    L11:
        float r2 = r3 / getFrameDurationNs();
        float r4 = this.frame;
        if (isReversed() == false) goto L14;
        r2 = -r2;
    L14:
        float r5 = r4 + r2;
        this.frame = r5;
        boolean r6 = !MiscUtils.contains(r5, getMinFrame(), getMaxFrame());
        this.frame = MiscUtils.clamp(this.frame, getMinFrame(), getMaxFrame());
        this.lastFrameTimeNs = r7;
        notifyUpdate();
        if (r6 == true) goto L17;
    L34:
        verifyFrame();
        L.endSection("LottieValueAnimator#doFrame");
        return;
    L17:
        if (getRepeatCount() != (-1)) goto L19;
    L25:
        notifyRepeat();
        this.repeatCount++;
        if (getRepeatMode() != 2) goto L29;
        this.speedReversedForRepeatMode = !this.speedReversedForRepeatMode;
        reverseAnimationSpeed();
    L33:
        this.lastFrameTimeNs = r7;
        goto L34
    L29:
        if (isReversed() == false) goto L31;
        float r8 = getMaxFrame();
    L32:
        this.frame = r8;
        goto L33
    L31:
        r8 = getMinFrame();
        goto L32
    L19:
        if (this.repeatCount < getRepeatCount()) goto L25;
        if (this.speed >= 0.0f) goto L23;
        float r9 = getMinFrame();
    L24:
        this.frame = r9;
        removeFrameCallback();
        notifyEnd(isReversed());
        goto L34
    L23:
        r9 = getMaxFrame();
        goto L24
    }

    private float getFrameDurationNs() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L7;
        return Float.MAX_VALUE;
    L7:
        return (1.0E9f / r0.getFrameRate()) / Math.abs(this.speed);
    }

    public void clearComposition() {
        this.composition = null;
        this.minFrame = -2.1474836E9f;
        this.maxFrame = 2.1474836E9f;
    }

    public void setComposition(LottieComposition r3) {
        if (this.composition != null) goto L5;
        boolean r0 = true;
    L6:
        this.composition = r3;
        if (r0 == false) goto L9;
        setMinAndMaxFrames((int) Math.max(this.minFrame, r3.getStartFrame()), (int) Math.min(this.maxFrame, r3.getEndFrame()));
    L10:
        float r4 = this.frame;
        this.frame = 0.0f;
        setFrame((int) r4);
        return;
    L9:
        setMinAndMaxFrames((int) r3.getStartFrame(), (int) r3.getEndFrame());
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public void setFrame(float r3) {
        if (this.frame != r3) goto L5;
        return;
    L5:
        this.frame = MiscUtils.clamp(r3, getMinFrame(), getMaxFrame());
        this.lastFrameTimeNs = 0;
        notifyUpdate();
    }

    public void setMinFrame(int r2) {
        setMinAndMaxFrames(r2, (int) this.maxFrame);
    }

    public void setMaxFrame(float r2) {
        setMinAndMaxFrames(this.minFrame, r2);
    }

    public void setMinAndMaxFrames(float r4, float r5) {
        if (r4 > r5) goto L15;
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L7;
        float r1 = -3.4028235E38f;
    L8:
        LottieComposition r2 = this.composition;
        if (r2 != null) goto L11;
        float r3 = Float.MAX_VALUE;
    L12:
        this.minFrame = MiscUtils.clamp(r4, r1, r3);
        this.maxFrame = MiscUtils.clamp(r5, r1, r3);
        setFrame((int) MiscUtils.clamp(this.frame, r4, r5));
        return;
    L11:
        r3 = r2.getEndFrame();
        goto L12
    L7:
        r1 = r0.getStartFrame();
        goto L8
    L15:
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[]{Float.valueOf(r4), Float.valueOf(r5)}));
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setSpeed(float r1) {
        this.speed = r1;
    }

    public float getSpeed() {
        return this.speed;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int r2) {
        super.setRepeatMode(r2);
        if (r2 != 2) goto L5;
        return;
    L5:
        if (this.speedReversedForRepeatMode == false) goto L9;
        this.speedReversedForRepeatMode = false;
        reverseAnimationSpeed();
        return;
    }

    public void playAnimation() {
        this.running = true;
        notifyStart(isReversed());
        if (isReversed() == false) goto L5;
        float r0 = getMaxFrame();
    L6:
        setFrame((int) r0);
        this.lastFrameTimeNs = 0;
        this.repeatCount = 0;
        postFrameCallback();
        return;
    L5:
        r0 = getMinFrame();
        goto L6
    }

    public void endAnimation() {
        removeFrameCallback();
        notifyEnd(isReversed());
    }

    public void pauseAnimation() {
        removeFrameCallback();
    }

    public void resumeAnimation() {
        this.running = true;
        postFrameCallback();
        this.lastFrameTimeNs = 0;
        if (isReversed() == false) goto L8;
        if (getFrame() != getMinFrame()) goto L8;
        this.frame = getMaxFrame();
        return;
    L8:
        if (isReversed() == false) goto L10;
        return;
    L10:
        if (getFrame() != getMaxFrame()) goto L15;
        this.frame = getMinFrame();
        return;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        notifyCancel();
        removeFrameCallback();
    }

    private boolean isReversed() {
        if (getSpeed() >= 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public float getMinFrame() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        float r2 = this.minFrame;
        if (r2 == (-2.1474836E9f)) goto L9;
        return r2;
    L9:
        return r0.getStartFrame();
    }

    public float getMaxFrame() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        float r2 = this.maxFrame;
        if (r2 == 2.1474836E9f) goto L9;
        return r2;
    L9:
        return r0.getEndFrame();
    }

    protected void postFrameCallback() {
        if (isRunning() == false) goto L6;
        removeFrameCallback(false);
        Choreographer.getInstance().postFrameCallback(this);
        return;
    }

    protected void removeFrameCallback() {
        removeFrameCallback(true);
    }

    protected void removeFrameCallback(boolean r2) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (r2 == false) goto L6;
        this.running = false;
        return;
    }

    private void verifyFrame() {
        if (this.composition != null) goto L5;
        return;
    L5:
        float r0 = this.frame;
        if (r0 < this.minFrame) goto L11;
        if (r0 > this.maxFrame) goto L11;
        return;
    L11:
        throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.minFrame), Float.valueOf(this.maxFrame), Float.valueOf(this.frame)}));
    }
}
