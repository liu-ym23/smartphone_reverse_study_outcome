package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ScrimInsetsFrameLayout extends FrameLayout {
    private boolean drawBottomInsetForeground;
    private boolean drawTopInsetForeground;

    @Nullable
    Drawable insetForeground;
    Rect insets;
    private Rect tempRect;

    public ScrimInsetsFrameLayout(@NonNull Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r9) {
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
        Rect r3 = this.tempRect;
        Rect r5 = this.insets;
        r3.set(0, r5.top, r5.left, r1 - r5.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r9);
        Rect r4 = this.tempRect;
        Rect r6 = this.insets;
        r4.set(r0 - r6.right, r6.top, r0, r1 - r6.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r9);
        r9.restoreToCount(r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable r0 = this.insetForeground;
        if (r0 == null) goto L6;
        r0.setCallback(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable r1 = this.insetForeground;
        if (r1 == null) goto L6;
        r1.setCallback(null);
        return;
    }

    public void onInsetsChanged(WindowInsetsCompat r1) {
    }

    public void setDrawBottomInsetForeground(boolean r1) {
        this.drawBottomInsetForeground = r1;
    }

    public void setDrawTopInsetForeground(boolean r1) {
        this.drawTopInsetForeground = r1;
    }

    public void setScrimInsetForeground(@Nullable Drawable r1) {
        this.insetForeground = r1;
    }

    public ScrimInsetsFrameLayout(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ScrimInsetsFrameLayout(@NonNull Context r8, @Nullable AttributeSet r9, int r10) {
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
}
