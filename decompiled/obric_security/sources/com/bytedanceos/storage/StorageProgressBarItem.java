package com.bytedanceos.storage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class StorageProgressBarItem extends View {
    private static final String TAG = "Security_StorageProgressBarItem";
    private long ANIM_DURATION_PER_PIXEL;
    private ValueAnimator mTranslationAnim;
    private int rateWidth;

    public StorageProgressBarItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ANIM_DURATION_PER_PIXEL = 1;
    }

    public StorageProgressBarItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.ANIM_DURATION_PER_PIXEL = 1;
    }

    public StorageProgressBarItem(Context context) {
        super(context);
        this.ANIM_DURATION_PER_PIXEL = 1;
    }

    public void setRateWidth(int w) {
        this.rateWidth = w;
        playAnim();
    }

    public void setRateBackgroundId(int rateBackground) {
        setBackgroundResource(rateBackground);
    }

    private void playAnim() {
        ValueAnimator r0 = this.mTranslationAnim;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        this.mTranslationAnim.cancel();
    L10:
        int r2 = getMeasuredWidth();
        int r3 = this.rateWidth;
        long r4 = ((long) Math.abs(r2 - r3)) * this.ANIM_DURATION_PER_PIXEL;
        OLog.d(TAG, "anim width from " + r2 + " to " + r3 + " anim duration " + r4);
        ValueAnimator r5 = ValueAnimator.ofInt(new int[]{r2, r3});
        this.mTranslationAnim = r5;
        r5.addUpdateListener(new AnonymousClass1(this));
        this.mTranslationAnim.setDuration(r4);
        this.mTranslationAnim.start();
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        r1 = true;
        goto L8
    }
}
