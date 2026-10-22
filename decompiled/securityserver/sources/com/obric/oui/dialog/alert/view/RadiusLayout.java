package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper;
import com.obric.common.oui.R;
import com.obric.oui.common.style.SmoothCornerH;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class RadiusLayout extends FrameLayout {
    public final boolean b;
    public final Paint c;
    public final boolean e;
    public float[] f;
    public final RectF i;
    public final Path j;
    public int k;
    public boolean l;

    @JvmOverloads
    public RadiusLayout(@NotNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r6) {
        Intrinsics.f(r6, "canvas");
        super.dispatchDraw(r6);
        if (this.e == true) goto L5;
        return;
    L5:
        if (this.b == false) goto L14;
        Paint r0 = this.c;
        if (r0 == null) goto L15;
        RectF r1 = this.i;
        r1.set(0.0f, 0.0f, getWidth(), getHeight());
        Path r2 = this.j;
        r2.reset();
        SmoothCornerHelper r3 = SmoothCornerH.f206a;
        float[] r5 = this.f;
        if (r5 == null) goto L11;
        SmoothCornerH.b(r2, r1, r5, Path.Direction.CW);
        r6.drawPath(r2, r0);
        return;
    L11:
        Intrinsics.m("radiusArray");
        throw null;
    L15:
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r5) {
        Intrinsics.f(r5, "canvas");
        RectF r0 = this.i;
        r0.set(0.0f, 0.0f, getWidth(), getHeight());
        Path r1 = this.j;
        r1.reset();
        SmoothCornerHelper r2 = SmoothCornerH.f206a;
        float[] r3 = this.f;
        if (r3 == null) goto L6;
        SmoothCornerH.b(r1, r0, r3, Path.Direction.CW);
        r5.clipPath(r1);
        super.draw(r5);
        return;
    L6:
        Intrinsics.m("radiusArray");
        throw null;
    }

    public final int getMaxHeight() {
        return this.k;
    }

    public final boolean getMeasureHeightUnspecified() {
        return this.l;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r2, int r3) {
        if (this.l == false) goto L9;
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r4 = getMeasuredHeight();
        int r5 = this.k;
        if (1 > r5) goto L13;
        if (r4 <= r5) goto L11;
        setMeasuredDimension(getMeasuredWidth(), this.k);
        return;
    L11:
        return;
    L13:
        return;
    L9:
        super.onMeasure(r2, r3);
    }

    public final void setMaxHeight(int r1) {
        this.k = r1;
    }

    public final void setMeasureHeightUnspecified(boolean r1) {
        this.l = r1;
    }

    public final void setRadius(float r3) {
        this.f = new float[]{r3, r3, r3, r3, r3, r3, r3, r3};
        invalidate();
    }

    public RadiusLayout(Context r17, AttributeSet r18, int r19) {
        Intrinsics.f(r17, "context");
        super(r17, r18, r19);
        boolean r2 = true;
        this.b = true;
        this.i = new RectF();
        this.j = new Path();
        TypedArray r1 = r17.obtainStyledAttributes(r18, R.styleable.p, r19, 0);
        Intrinsics.e(r1, "context.obtainStyledAttr…sLayout, defStyleAttr, 0)");
        float r5 = r1.getDimension(0, 0.0f);
        float r7 = r1.getDimension(2, r5);
        float r9 = r1.getDimension(4, r5);
        float r10 = r1.getDimension(1, r5);
        float r6 = r1.getDimension(3, r5);
        int r14 = r1.getColor(5, ViewCompat.MEASURED_STATE_MASK);
        int r13 = r1.getDimensionPixelOffset(8, 0);
        int r12 = r1.getDimensionPixelOffset(7, 0);
        int r8 = r1.getDimensionPixelOffset(6, 0);
        this.f = new float[]{r7, r7, r9, r9, r6, r6, r10, r10};
        invalidate();
        Paint r3 = new Paint();
        r3.setAntiAlias(true);
        r3.setColor(r14);
        r3.setStyle(Paint.Style.STROKE);
        if (r12 == 0) goto L6;
        if (r8 == 0) goto L6;
        r3.setPathEffect(new DashPathEffect(new float[]{r12, r8}, 0.0f));
    L6:
        r3.setStrokeWidth(r13);
        this.c = r3;
        if (((-16777216) & r14) == 0) goto L10;
        if (r13 == 0) goto L10;
    L11:
        this.e = r2;
        invalidate();
        r1.recycle();
        return;
    L10:
        r2 = false;
        goto L11
    }
}
