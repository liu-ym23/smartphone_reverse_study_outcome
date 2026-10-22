package com.android.setupwizardlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.android.setupwizardlib.R;

/* JADX INFO: loaded from: classes.dex */
public class Illustration extends FrameLayout {
    private float aspectRatio;
    private Drawable background;
    private float baselineGridSize;
    private Drawable illustration;
    private final Rect illustrationBounds;
    private float scale;
    private final Rect viewBounds;

    public Illustration(Context r2) {
        super(r2);
        this.viewBounds = new Rect();
        this.illustrationBounds = new Rect();
        this.scale = 1.0f;
        this.aspectRatio = 0.0f;
        init(null, 0);
    }

    public Illustration(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.viewBounds = new Rect();
        this.illustrationBounds = new Rect();
        this.scale = 1.0f;
        this.aspectRatio = 0.0f;
        init(r2, 0);
    }

    public Illustration(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.viewBounds = new Rect();
        this.illustrationBounds = new Rect();
        this.scale = 1.0f;
        this.aspectRatio = 0.0f;
        init(r2, r3);
    }

    private void init(AttributeSet r4, int r5) {
        if (r4 == null) goto L5;
        TypedArray r6 = getContext().obtainStyledAttributes(r4, R.styleable.SuwIllustration, r5, 0);
        this.aspectRatio = r6.getFloat(R.styleable.SuwIllustration_suwAspectRatio, 0.0f);
        r6.recycle();
    L5:
        this.baselineGridSize = getResources().getDisplayMetrics().density * 8.0f;
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r2) {
        if (r2 != this.background) goto L5;
        return;
    L5:
        this.background = r2;
        invalidate();
        requestLayout();
    }

    public void setIllustration(Drawable r2) {
        if (r2 != this.illustration) goto L5;
        return;
    L5:
        this.illustration = r2;
        invalidate();
        requestLayout();
    }

    public void setAspectRatio(float r1) {
        this.aspectRatio = r1;
        invalidate();
        requestLayout();
    }

    @Override // android.view.View
    @Deprecated
    public void setForeground(Drawable r1) {
        setIllustration(r1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r3, int r4) {
        if (this.aspectRatio == 0.0f) goto L5;
        float r0 = (int) (View.MeasureSpec.getSize(r3) / this.aspectRatio);
        setPadding(0, (int) (r0 - (r0 % this.baselineGridSize)), 0, 0);
    L5:
        setOutlineProvider(ViewOutlineProvider.BOUNDS);
        super.onMeasure(r3, r4);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        int r0 = r12 - r10;
        int r1 = r13 - r11;
        Drawable r2 = this.illustration;
        if (r2 == null) goto L8;
        int r3 = r2.getIntrinsicWidth();
        int r4 = this.illustration.getIntrinsicHeight();
        this.viewBounds.set(0, 0, r0, r1);
        if (this.aspectRatio == 0.0f) goto L7;
        float r5 = r0 / r3;
        this.scale = r5;
        r4 = (int) (r4 * r5);
        r3 = r0;
    L7:
        Gravity.apply(55, r3, r4, this.viewBounds, this.illustrationBounds);
        this.illustration.setBounds(this.illustrationBounds);
    L8:
        Drawable r6 = this.background;
        if (r6 == null) goto L11;
        r6.setBounds(0, 0, (int) Math.ceil(r0 / this.scale), (int) Math.ceil((r1 - this.illustrationBounds.height()) / this.scale));
    L11:
        super.onLayout(r9, r10, r11, r12, r13);
    }

    @Override // android.view.View
    public void onDraw(Canvas r6) {
        if (this.background == null) goto L9;
        r6.save();
        r6.translate(0.0f, this.illustrationBounds.height());
        float r0 = this.scale;
        r6.scale(r0, r0, 0.0f, 0.0f);
        if (shouldMirrorDrawable(this.background, getLayoutDirection()) == false) goto L7;
        r6.scale(-1.0f, 1.0f);
        r6.translate(-this.background.getBounds().width(), 0.0f);
    L7:
        this.background.draw(r6);
        r6.restore();
    L9:
        if (this.illustration == null) goto L14;
        r6.save();
        if (shouldMirrorDrawable(this.illustration, getLayoutDirection()) == false) goto L13;
        r6.scale(-1.0f, 1.0f);
        r6.translate(-this.illustrationBounds.width(), 0.0f);
    L13:
        this.illustration.draw(r6);
        r6.restore();
    L14:
        super.onDraw(r6);
    }

    private boolean shouldMirrorDrawable(Drawable r1, int r2) {
        if (r2 == 1) goto L5;
        return false;
    L5:
        return r1.isAutoMirrored();
    }
}
