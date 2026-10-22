package com.qihoo360.mobilesafe.ui.common.other;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.qihoo360.mobilesafe.common.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public class CommonLoadingIcon extends ImageView {
    private Drawable mCompleteDrawable;
    private int mHeight;
    private Drawable mLoadingDrawable;
    private int mWidth;

    public CommonLoadingIcon(Context r3) {
        AttributeSet r1 = (AttributeSet) null;
        this(r3, null);
    }

    public CommonLoadingIcon(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mLoadingDrawable = getResources().getDrawable(R.drawable.common_v5_loading_icon);
        this.mCompleteDrawable = getResources().getDrawable(R.drawable.common_icon_list_ok);
        Drawable r3 = getResources().getDrawable(R.drawable.checkbox_active);
        this.mHeight = r3.getIntrinsicHeight();
        this.mWidth = r3.getIntrinsicWidth();
    }

    public CommonLoadingIcon(Context r3, Drawable r4) {
        AttributeSet r1 = (AttributeSet) null;
        this(r3, null);
        this.mCompleteDrawable = r4;
    }

    public void setLoading(boolean r2) {
        if (r2 == false) goto L4;
        setImageDrawable(this.mLoadingDrawable);
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.common_loading_rotate));
        return;
    L4:
        clearAnimation();
        setImageDrawable(this.mCompleteDrawable);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int r5, int r6) {
        int r0 = View.MeasureSpec.getMode(r5);
        int r1 = View.MeasureSpec.getMode(r6);
        int r2 = this.mWidth;
        if (r2 > 0) goto L5;
    L7:
        super.onMeasure(r5, r6);
        return;
    L5:
        if (this.mHeight <= 0) goto L7;
        r5 = View.MeasureSpec.makeMeasureSpec(r2, r0);
        r6 = View.MeasureSpec.makeMeasureSpec(this.mHeight, r1);
        goto L7
    }

    public Drawable getLoadingDrawable() {
        return this.mLoadingDrawable;
    }
}
