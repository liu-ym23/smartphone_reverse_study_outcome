package com.android.settingslib.widget;

import android.content.Context;
import android.graphics.drawable.AnimatedRotateDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedImageView extends ImageView {
    private boolean mAnimating;
    private AnimatedRotateDrawable mDrawable;

    public AnimatedImageView(Context r1) {
        super(r1);
    }

    public AnimatedImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    private void updateDrawable() {
        if (isShown() == false) goto L7;
        AnimatedRotateDrawable r0 = this.mDrawable;
        if (r0 == null) goto L7;
        r0.stop();
    L7:
        AnimatedRotateDrawable r1 = getDrawable();
        if ((r1 instanceof AnimatedRotateDrawable) == false) goto L14;
        AnimatedRotateDrawable r2 = r1;
        this.mDrawable = r2;
        r2.setFramesCount(56);
        this.mDrawable.setFramesDuration(32);
        if (isShown() == true) goto L12;
        return;
    L12:
        if (this.mAnimating == false) goto L17;
        this.mDrawable.start();
        return;
    L17:
        return;
    L14:
        this.mDrawable = null;
    }

    private void updateAnimating() {
        if (this.mDrawable != null) goto L5;
        return;
    L5:
        if (getVisibility() == 0) goto L7;
    L9:
        this.mDrawable.stop();
        return;
    L7:
        if (this.mAnimating == false) goto L9;
        this.mDrawable.start();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r1) {
        super.setImageDrawable(r1);
        updateDrawable();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r1) {
        super.setImageResource(r1);
        updateDrawable();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateAnimating();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        updateAnimating();
    }

    public void setAnimating(boolean r1) {
        this.mAnimating = r1;
        updateAnimating();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
        updateAnimating();
    }
}
