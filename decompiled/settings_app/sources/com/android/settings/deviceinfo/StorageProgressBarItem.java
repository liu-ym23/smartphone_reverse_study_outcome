package com.android.settings.deviceinfo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class StorageProgressBarItem extends View {
    private static final String TAG = "StorageProgressBarItem";
    private long ANIM_DURATION_PER_PIXEL;
    private ValueAnimator mTranslationAnim;
    private int rateWidth;

    public StorageProgressBarItem(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.ANIM_DURATION_PER_PIXEL = 1;
    }

    public StorageProgressBarItem(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.ANIM_DURATION_PER_PIXEL = 1;
    }

    public StorageProgressBarItem(Context r3) {
        super(r3);
        this.ANIM_DURATION_PER_PIXEL = 1;
    }

    public void setRateWidth(int r1) {
        this.rateWidth = r1;
        playAnim();
    }

    public void setRateBackgroundId(int r1) {
        setBackgroundResource(r1);
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
