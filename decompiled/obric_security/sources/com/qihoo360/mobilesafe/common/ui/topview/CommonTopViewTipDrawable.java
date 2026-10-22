package com.qihoo360.mobilesafe.common.ui.topview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonTopViewTipDrawable extends Drawable {
    private static final int ANIM_DURATION = 2000;
    private static final int ANIM_WIDTH = 180;
    private boolean isLoading;
    private GradientDrawable mAnimDrawable;
    private ValueAnimator mAnimator;
    private int mBgColor;
    private Context mContext;
    private int mFromColor;
    private int mScreenWidth;
    private int mToColor;
    private int offset;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }

    static /* synthetic */ int access$002(CommonTopViewTipDrawable r0, int r1) {
        r0.offset = r1;
        return r1;
    }

    public CommonTopViewTipDrawable(Context r2) {
        this.mContext = r2;
        this.mBgColor = r2.getResources().getColor(R.color.inner_common_bg_color_2_a19);
        this.mFromColor = this.mContext.getResources().getColor(R.color.inner_common_top_view_loading_from_color);
        this.mToColor = this.mContext.getResources().getColor(R.color.inner_common_top_view_loading_to_color);
        WindowManager r3 = (WindowManager) this.mContext.getSystemService("window");
        DisplayMetrics r0 = new DisplayMetrics();
        r3.getDefaultDisplay().getMetrics(r0);
        this.mScreenWidth = r0.widthPixels;
        this.isLoading = false;
    }

    public void startLoading() {
        this.isLoading = true;
        GradientDrawable.Orientation r2 = GradientDrawable.Orientation.LEFT_RIGHT;
        int r4 = this.mFromColor;
        this.mAnimDrawable = new GradientDrawable(r2, new int[]{r4, this.mToColor, r4});
        if (this.mAnimator != null) goto L5;
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{-CommonUtils.dip2px(this.mContext, 180.0f), this.mScreenWidth + CommonUtils.dip2px(this.mContext, 180.0f)});
        this.mAnimator = r1;
        r1.setDuration(2000);
        this.mAnimator.setInterpolator(new LinearInterpolator());
        this.mAnimator.setRepeatCount(-1);
        this.mAnimator.setRepeatMode(1);
        this.mAnimator.addUpdateListener(new AnonymousClass1(this));
    L5:
        this.mAnimator.start();
    }

    public void stopLoading() {
        if (this.isLoading == true) goto L5;
        return;
    L5:
        ValueAnimator r0 = this.mAnimator;
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        this.mAnimDrawable = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r7) {
        int r0 = r7.save();
        r7.drawColor(this.mBgColor);
        GradientDrawable r1 = this.mAnimDrawable;
        if (r1 == null) goto L5;
        int r2 = this.offset;
        r1.setBounds(r2, 0, CommonUtils.dip2px(this.mContext, 180.0f) + r2, getBounds().height());
        this.mAnimDrawable.draw(r7);
    L5:
        r7.restoreToCount(r0);
    }
}
