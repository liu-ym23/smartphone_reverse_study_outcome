package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {
    private boolean drawBottomInsetForeground;
    private boolean drawTopInsetForeground;
    Drawable insetForeground;
    Rect insets;
    private Rect tempRect;

    protected void onInsetsChanged(WindowInsetsCompat r1) {
    }

    public ScrimInsetsFrameLayout(Context r2) {
        this(r2, null);
    }

    public ScrimInsetsFrameLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ScrimInsetsFrameLayout(Context r8, AttributeSet r9, int r10) {
        super(r8, r9, r10);
        this.tempRect = new Rect();
        this.drawTopInsetForeground = true;
        this.drawBottomInsetForeground = true;
        TypedArray r11 = ThemeEnforcement.obtainStyledAttributes(r8, r9, R.styleable.ScrimInsetsFrameLayout, r10, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.insetForeground = r11.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        r11.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
    }

    public void setScrimInsetForeground(Drawable r1) {
        this.insetForeground = r1;
    }

    public void setDrawTopInsetForeground(boolean r1) {
        this.drawTopInsetForeground = r1;
    }

    public void setDrawBottomInsetForeground(boolean r1) {
        this.drawBottomInsetForeground = r1;
    }

    @Override // android.view.View
    public void draw(Canvas r9) {
        super.draw(r9);
        int r0 = getWidth();
        int r1 = getHeight();
        if (this.insets != null) goto L5;
        return;
    L5:
        if (this.insetForeground == null) goto L15;
        int r2 = r9.save();
        r9.translate(getScrollX(), getScrollY());
        if (this.drawTopInsetForeground == false) goto L10;
        this.tempRect.set(0, 0, r0, this.insets.top);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r9);
    L10:
        if (this.drawBottomInsetForeground == false) goto L12;
        this.tempRect.set(0, r1 - this.insets.bottom, r0, r1);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r9);
    L12:
        this.tempRect.set(0, this.insets.top, this.insets.left, r1 - this.insets.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r9);
        this.tempRect.set(r0 - this.insets.right, this.insets.top, r0, r1 - this.insets.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r9);
        r9.restoreToCount(r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable r0 = this.insetForeground;
        if (r0 == null) goto L6;
        r0.setCallback(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable r1 = this.insetForeground;
        if (r1 == null) goto L6;
        r1.setCallback(null);
        return;
    }
}
