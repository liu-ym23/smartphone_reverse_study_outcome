package com.bytedance.feedbackerlib.matisse.internal.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes.dex */
public class RoundedRectangleImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f4445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Path f4446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private RectF f4447h;

    public RoundedRectangleImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
        f(r1);
    }

    private void f(Context r2) {
        this.f4445f = r2.getResources().getDisplayMetrics().density * 5.0f;
        this.f4446g = new Path();
        this.f4447h = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas r2) {
        r2.clipPath(this.f4446g);
        super.onDraw(r2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        this.f4447h.set(1.0f, 1.0f, getMeasuredWidth(), getMeasuredHeight());
        Path r5 = this.f4446g;
        RectF r6 = this.f4447h;
        float r2 = this.f4445f;
        r5.addRoundRect(r6, r2, r2, Path.Direction.CW);
    }
}
