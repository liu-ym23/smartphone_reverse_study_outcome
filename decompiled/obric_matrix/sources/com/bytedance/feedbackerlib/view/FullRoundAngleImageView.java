package com.bytedance.feedbackerlib.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes.dex */
public class FullRoundAngleImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f4667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Paint f4668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4670i;

    private void f(Canvas r7) {
        Path r0 = new Path();
        r0.moveTo(0.0f, getHeight() - this.f4670i);
        r0.lineTo(0.0f, getHeight());
        r0.lineTo(this.f4669h, getHeight());
        r0.arcTo(new RectF(0.0f, getHeight() - (this.f4670i * 2), this.f4669h * 2, getHeight()), 90.0f, 90.0f);
        r0.close();
        r7.drawPath(r0, this.f4667f);
    }

    private void g(Canvas r6) {
        Path r0 = new Path();
        r0.moveTo(0.0f, this.f4670i);
        r0.lineTo(0.0f, 0.0f);
        r0.lineTo(this.f4669h, 0.0f);
        r0.arcTo(new RectF(0.0f, 0.0f, this.f4669h * 2, this.f4670i * 2), -90.0f, -90.0f);
        r0.close();
        r6.drawPath(r0, this.f4667f);
    }

    private void h(Canvas r7) {
        Path r0 = new Path();
        r0.moveTo(getWidth() - this.f4669h, getHeight());
        r0.lineTo(getWidth(), getHeight());
        r0.lineTo(getWidth(), getHeight() - this.f4670i);
        r0.arcTo(new RectF(getWidth() - (this.f4669h * 2), getHeight() - (this.f4670i * 2), getWidth(), getHeight()), 0.0f, 90.0f);
        r0.close();
        r7.drawPath(r0, this.f4667f);
    }

    private void i(Canvas r7) {
        Path r0 = new Path();
        r0.moveTo(getWidth(), this.f4670i);
        r0.lineTo(getWidth(), 0.0f);
        r0.lineTo(getWidth() - this.f4669h, 0.0f);
        r0.arcTo(new RectF(getWidth() - (this.f4669h * 2), 0.0f, getWidth(), this.f4670i * 2), -90.0f, 90.0f);
        r0.close();
        r7.drawPath(r0, this.f4667f);
    }

    @Override // android.view.View
    public void draw(Canvas r4) {
        Bitmap r0 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r0);
        super.draw(r1);
        g(r1);
        f(r1);
        i(r1);
        h(r1);
        r4.drawBitmap(r0, 0.0f, 0.0f, this.f4668g);
        r0.recycle();
    }
}
