package com.bytedanceos.rotateview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.RotateDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.keva.KevaImpl;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class RotateFanView extends FrameLayout implements ValueAnimator.AnimatorUpdateListener, ColorAnimateHelper.ColorUpdateListener {
    private static final int DEFAULT_WAIT_SPEED = 50;
    private RotateDrawable mFanBladeDrawable;
    private ImageView mFanBladeView;
    private int mLastLevel;
    private int mLevelSpeed;
    private ObjectAnimator mRotateAnimator;
    private ValueAnimator mWaitingAnimator;

    @Override // com.bytedanceos.rotateview.ColorAnimateHelper.ColorUpdateListener
    public void onColorUpdateEnd() {
    }

    public RotateFanView(Context context) {
        this(context, null);
    }

    public RotateFanView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RotateFanView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public RotateFanView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        ImageView r2 = (ImageView) LayoutInflater.from(context).inflate(R.layout.rotate_layout, this, true).findViewById(R.id.fanblade);
        this.mFanBladeView = r2;
        RotateDrawable r3 = (RotateDrawable) r2.getDrawable();
        this.mFanBladeDrawable = r3;
        ObjectAnimator r4 = ObjectAnimator.ofInt(r3, "level", new int[]{0});
        this.mRotateAnimator = r4;
        r4.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mRotateAnimator.addUpdateListener(this);
        ValueAnimator r5 = ValueAnimator.ofInt(new int[]{0});
        this.mWaitingAnimator = r5;
        r5.setInterpolator(new LinearInterpolator());
        this.mWaitingAnimator.setRepeatCount(-1);
        this.mWaitingAnimator.setRepeatMode(1);
        this.mWaitingAnimator.addUpdateListener(this);
    }

    public void setRotateAnimatorDuration(long duration, long delay) {
        this.mRotateAnimator.setStartDelay(delay);
        this.mRotateAnimator.setDuration(duration);
    }

    public void setRotateAnimatorDuration(long duration) {
        this.mRotateAnimator.setDuration(duration);
    }

    public void startRotateAnimator(boolean clockwise) {
        if (clockwise == false) goto L5;
        this.mRotateAnimator.setIntValues(new int[]{0, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD});
    L6:
        this.mRotateAnimator.start();
        return;
    L5:
        this.mRotateAnimator.setIntValues(new int[]{KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, 0});
        goto L6
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        if (animation != this.mRotateAnimator) goto L9;
        if (animation.getAnimatedValue("level") != null) goto L7;
        return;
    L7:
        int r3 = ((Integer) animation.getAnimatedValue("level")).intValue();
        this.mLevelSpeed = r3 - this.mLastLevel;
        this.mLastLevel = r3;
        return;
    L9:
        if (animation != this.mWaitingAnimator) goto L17;
        RotateDrawable r4 = this.mFanBladeDrawable;
        int r0 = r4.getLevel();
        if (this.mLevelSpeed <= 0) goto L13;
        int r2 = 1;
    L14:
        r4.setLevel((r0 + (r2 * 50)) % 10001);
        return;
    L13:
        r2 = -1;
        goto L14
    }

    @Override // com.bytedanceos.rotateview.ColorAnimateHelper.ColorUpdateListener
    public void onColorUpdate(int color) {
        this.mFanBladeDrawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    public void onPause() {
        this.mRotateAnimator.pause();
        this.mWaitingAnimator.start();
    }

    public void onResume() {
        this.mWaitingAnimator.cancel();
        this.mFanBladeDrawable.setLevel(this.mLastLevel);
        this.mRotateAnimator.resume();
    }

    public void destory() {
        this.mWaitingAnimator.cancel();
        this.mRotateAnimator.cancel();
        this.mFanBladeDrawable.setLevel(0);
    }
}
