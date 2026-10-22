package com.bytedance.feedbackerlib.matisse.internal.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.feedbackerlib.d;

/* JADX INFO: loaded from: classes.dex */
public class CheckView extends View {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f4423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f4425i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Paint f4426j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextPaint f4427k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Paint f4428l;
    private Drawable m;
    private float n;
    private Rect o;
    private boolean p;

    public CheckView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.p = true;
        a(r1);
    }

    private void a(Context r6) {
        this.n = r6.getResources().getDisplayMetrics().density;
        Paint r0 = new Paint();
        this.f4425i = r0;
        r0.setAntiAlias(true);
        this.f4425i.setStyle(Paint.Style.STROKE);
        this.f4425i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        this.f4425i.setStrokeWidth(this.n * 1.0f);
        TypedArray r1 = getContext().getTheme().obtainStyledAttributes(new int[]{com.bytedance.feedbackerlib.a.f3835d});
        int r2 = r1.getColor(0, ResourcesCompat.getColor(getResources(), com.bytedance.feedbackerlib.b.f3986c, getContext().getTheme()));
        r1.recycle();
        this.f4425i.setColor(r2);
        this.m = ResourcesCompat.getDrawable(r6.getResources(), d.o, r6.getTheme());
    }

    private void b() {
        if (this.f4426j != null) goto L6;
        Paint r0 = new Paint();
        this.f4426j = r0;
        r0.setAntiAlias(true);
        this.f4426j.setStyle(Paint.Style.FILL);
        TypedArray r1 = getContext().getTheme().obtainStyledAttributes(new int[]{com.bytedance.feedbackerlib.a.f3834c});
        int r2 = ResourcesCompat.getColor(getResources(), com.bytedance.feedbackerlib.b.f3985b, getContext().getTheme());
        r1.getColor(0, r2);
        r1.recycle();
        this.f4426j.setColor(r2);
        return;
    }

    private void c() {
        if (this.f4428l != null) goto L6;
        Paint r0 = new Paint();
        this.f4428l = r0;
        r0.setAntiAlias(true);
        float r2 = (float) (((double) 12.5f) - 1.5d);
        Paint r4 = this.f4428l;
        float r13 = this.n;
        r4.setShader(new RadialGradient((r13 * 30.0f) / 2.0f, (30.0f * r13) / 2.0f, 12.5f * r13, new int[]{Color.parseColor("#00000000"), Color.parseColor("#1F000000"), Color.parseColor("#1F000000"), Color.parseColor("#00000000")}, new float[]{(r2 - 0.0f) / 12.5f, r2 / 12.5f, 1.0f, 1.0f}, Shader.TileMode.CLAMP));
        return;
    }

    private void d() {
        if (this.f4427k != null) goto L6;
        TextPaint r0 = new TextPaint();
        this.f4427k = r0;
        r0.setAntiAlias(true);
        this.f4427k.setColor(-1);
        this.f4427k.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        this.f4427k.setTextSize(this.n * 12.0f);
        return;
    }

    private Rect getCheckRect() {
        if (this.o != null) goto L6;
        float r0 = this.n;
        int r1 = (int) (((r0 * 30.0f) / 2.0f) - ((r0 * 16.0f) / 2.0f));
        float r3 = this.n;
        float r5 = r1;
        this.o = new Rect(r1, r1, (int) ((r3 * 30.0f) - r5), (int) ((r3 * 30.0f) - r5));
    L6:
        return this.o;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r7) {
        super.onDraw(r7);
        c();
        float r0 = this.n;
        r7.drawCircle((r0 * 30.0f) / 2.0f, (r0 * 30.0f) / 2.0f, r0 * 12.5f, this.f4428l);
        if (this.f4422f == false) goto L8;
        if (this.f4424h == Integer.MIN_VALUE) goto L10;
        b();
        float r1 = this.n;
        r7.drawCircle((r1 * 30.0f) / 2.0f, (30.0f * r1) / 2.0f, r1 * 12.0f, this.f4426j);
        d();
        String r2 = String.valueOf(this.f4424h);
        r7.drawText(r2, ((int) (r7.getWidth() - this.f4427k.measureText(r2))) / 2, ((int) ((r7.getHeight() - this.f4427k.descent()) - this.f4427k.ascent())) / 2, this.f4427k);
    L12:
        if (this.p == false) goto L14;
        float r8 = 1.0f;
    L15:
        setAlpha(r8);
        return;
    L14:
        r8 = 0.5f;
    L10:
        float r3 = this.n;
        r7.drawCircle((r3 * 30.0f) / 2.0f, (30.0f * r3) / 2.0f, r3 * 12.0f, this.f4425i);
        goto L12
    L8:
        if (this.f4423g == false) goto L10;
        b();
        float r4 = this.n;
        r7.drawCircle((r4 * 30.0f) / 2.0f, (30.0f * r4) / 2.0f, r4 * 12.0f, this.f4426j);
        this.m.setBounds(getCheckRect());
        this.m.draw(r7);
        goto L12
    }

    @Override // android.view.View
    protected void onMeasure(int r1, int r2) {
        int r3 = View.MeasureSpec.makeMeasureSpec((int) (this.n * 30.0f), BasicMeasure.EXACTLY);
        super.onMeasure(r3, r3);
    }

    public void setChecked(boolean r2) {
        if (this.f4422f == true) goto L7;
        this.f4423g = r2;
        invalidate();
        return;
    L7:
        throw new IllegalStateException("CheckView is countable, call setCheckedNum() instead.");
    }

    public void setCheckedNum(int r2) {
        if (this.f4422f == false) goto L13;
        if (r2 == Integer.MIN_VALUE) goto L10;
        if (r2 > 0) goto L10;
        throw new IllegalArgumentException("checked num can't be negative.");
    L10:
        this.f4424h = r2;
        invalidate();
        return;
    L13:
        throw new IllegalStateException("CheckView is not countable, call setChecked() instead.");
    }

    public void setCountable(boolean r1) {
        this.f4422f = r1;
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        if (this.p == r2) goto L6;
        this.p = r2;
        invalidate();
        return;
    }
}
