package com.android.setupwizardlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.android.setupwizardlib.R;

/* JADX INFO: loaded from: classes.dex */
public class StatusBarBackgroundLayout extends FrameLayout {
    private Object lastInsets;
    private Drawable statusBarBackground;

    public StatusBarBackgroundLayout(Context r3) {
        super(r3);
        init(r3, null, 0);
    }

    public StatusBarBackgroundLayout(Context r2, AttributeSet r3) {
        super(r2, r3);
        init(r2, r3, 0);
    }

    public StatusBarBackgroundLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r1, r2, r3);
    }

    private void init(Context r3, AttributeSet r4, int r5) {
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.SuwStatusBarBackgroundLayout, r5, 0);
        setStatusBarBackground(r6.getDrawable(R.styleable.SuwStatusBarBackgroundLayout_suwStatusBarBackground));
        r6.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.lastInsets != null) goto L6;
        requestApplyInsets();
        return;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r5) {
        super.onDraw(r5);
        Object r0 = this.lastInsets;
        if (r0 == null) goto L8;
        int r1 = ((WindowInsets) r0).getSystemWindowInsetTop();
        if (r1 <= 0) goto L9;
        this.statusBarBackground.setBounds(0, 0, getWidth(), r1);
        this.statusBarBackground.draw(r5);
        return;
    L9:
        return;
    }

    public void setStatusBarBackground(Drawable r4) {
        this.statusBarBackground = r4;
        boolean r0 = true;
        if (r4 != null) goto L5;
        boolean r2 = true;
    L6:
        setWillNotDraw(r2);
        if (r4 != null) goto L10;
        r0 = false;
    L10:
        setFitsSystemWindows(r0);
        invalidate();
        return;
    L5:
        r2 = false;
        goto L6
    }

    public Drawable getStatusBarBackground() {
        return this.statusBarBackground;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets r1) {
        this.lastInsets = r1;
        return super.onApplyWindowInsets(r1);
    }
}
