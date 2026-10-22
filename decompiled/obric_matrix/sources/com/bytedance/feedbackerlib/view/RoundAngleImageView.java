package com.bytedance.feedbackerlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.feedbackerlib.i;

/* JADX INFO: loaded from: classes.dex */
public class RoundAngleImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f4671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Paint f4672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4674i;

    public RoundAngleImageView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.f4673h = 20;
        this.f4674i = 20;
        init(r2, r3);
    }

    private void f(Canvas r7) {
        Path r0 = new Path();
        r0.moveTo(0.0f, getHeight() - this.f4674i);
        r0.lineTo(0.0f, getHeight());
        r0.lineTo(this.f4673h, getHeight());
        r0.arcTo(new RectF(0.0f, getHeight() - (this.f4674i * 2), this.f4673h * 2, getHeight()), 90.0f, 90.0f);
        r0.close();
        r7.drawPath(r0, this.f4671f);
    }

    private void g(Canvas r6) {
        Path r0 = new Path();
        r0.moveTo(0.0f, this.f4674i);
        r0.lineTo(0.0f, 0.0f);
        r0.lineTo(this.f4673h, 0.0f);
        r0.arcTo(new RectF(0.0f, 0.0f, this.f4673h * 2, this.f4674i * 2), -90.0f, -90.0f);
        r0.close();
        r6.drawPath(r0, this.f4671f);
    }

    private void h(Canvas r7) {
        Path r0 = new Path();
        r0.moveTo(getWidth() - this.f4673h, getHeight());
        r0.lineTo(getWidth(), getHeight());
        r0.lineTo(getWidth(), getHeight() - this.f4674i);
        r0.arcTo(new RectF(getWidth() - (this.f4673h * 2), getHeight() - (this.f4674i * 2), getWidth(), getHeight()), 0.0f, 90.0f);
        r0.close();
        r7.drawPath(r0, this.f4671f);
    }

    private void i(Canvas r7) {
        Path r0 = new Path();
        r0.moveTo(getWidth(), this.f4674i);
        r0.lineTo(getWidth(), 0.0f);
        r0.lineTo(getWidth() - this.f4673h, 0.0f);
        r0.arcTo(new RectF(getWidth() - (this.f4673h * 2), 0.0f, getWidth(), this.f4674i * 2), -90.0f, 90.0f);
        r0.close();
        r7.drawPath(r0, this.f4671f);
    }

    private void init(Context r2, AttributeSet r3) {
        if (r3 == null) goto L4;
        TypedArray r4 = r2.obtainStyledAttributes(r3, i.f4049a);
        this.f4673h = r4.getDimensionPixelSize(i.f4051c, this.f4673h);
        this.f4674i = r4.getDimensionPixelSize(i.f4050b, this.f4674i);
        r4.recycle();
    L5:
        Paint r5 = new Paint();
        this.f4671f = r5;
        r5.setColor(-1);
        this.f4671f.setAntiAlias(true);
        this.f4671f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint r6 = new Paint();
        this.f4672g = r6;
        r6.setXfermode(null);
        return;
    L4:
        float r7 = r2.getResources().getDisplayMetrics().density;
        this.f4673h = (int) (this.f4673h * r7);
        this.f4674i = (int) (this.f4674i * r7);
        goto L5
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
        r4.drawBitmap(r0, 0.0f, 0.0f, this.f4672g);
        r0.recycle();
    }
}
