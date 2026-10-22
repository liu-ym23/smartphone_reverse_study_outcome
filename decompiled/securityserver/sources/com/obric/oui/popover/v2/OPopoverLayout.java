package com.obric.oui.popover.v2;

import a.a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.annotation.Px;
import com.obric.oui.utils.log.L;
import d.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OPopoverLayout extends LinearLayout {
    public static final int m = 0;
    public float b;
    public float c;
    public float e;
    public Bitmap f;
    public int i;
    public int j;
    public int k;
    public Paint l;

    @Metadata
    public static final class Companion {
    }

    static {
        float r0 = 0;
        m = a.d("Resources.getSystem()", 1, r0);
        Resources r4 = Resources.getSystem();
        Intrinsics.e(r4, "Resources.getSystem()");
        TypedValue.applyDimension(1, 28, r4.getDisplayMetrics());
        Resources r3 = Resources.getSystem();
        Intrinsics.e(r3, "Resources.getSystem()");
        TypedValue.applyDimension(1, r0, r3.getDisplayMetrics());
        b.b("Resources.getSystem()", 1, 36);
    }

    public final int getArrowHeight() {
        return m;
    }

    public final float getCornerRadius() {
        return this.b;
    }

    public final int getMBgColor() {
        return this.i;
    }

    public final float getMHeight() {
        return this.e;
    }

    public final float getMWidth() {
        return this.c;
    }

    public final int getPadding() {
        return m / 2;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.f(r4, "canvas");
        if (this.f != null) goto L5;
        Context r5 = getContext();
        Intrinsics.e(r5, "context");
        Resources r6 = r5.getResources();
        Intrinsics.e(r6, "context.resources");
        this.f = Bitmap.createBitmap(r6.getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r3 = this.f;
        Intrinsics.c(r3);
        new Canvas(r3);
    L5:
        Intrinsics.m("mFillPaint");
        throw null;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r8, int r9) {
        super.onMeasure(r8, r9);
        int r0 = View.MeasureSpec.getMode(r8);
        int r10 = View.MeasureSpec.getSize(r8);
        int r1 = View.MeasureSpec.getMode(r9);
        int r11 = View.MeasureSpec.getSize(r9);
        PopupWindow r4 = new PopupWindow(getChildAt(0), -2, -2, true);
        r4.getContentView().measure(0, 0);
        View r2 = r4.getContentView();
        Intrinsics.e(r2, "pop.contentView");
        int r3 = r2.getMeasuredWidth();
        int r5 = m;
        int r6 = (r5 * 2) + r3;
        View r7 = r4.getContentView();
        Intrinsics.e(r7, "pop.contentView");
        int r12 = (r5 * 2) + r7.getMeasuredHeight();
        if (r0 != Integer.MIN_VALUE) goto L6;
        if (r1 != Integer.MIN_VALUE) goto L6;
        setMeasuredDimension(r6, r12);
    L11:
        this.c = getMeasuredWidth();
        this.e = getMeasuredHeight();
        return;
    L6:
        if (r0 != Integer.MIN_VALUE) goto L8;
        setMeasuredDimension(r6, r11);
        goto L11
    L8:
        if (r1 != Integer.MIN_VALUE) goto L10;
        setMeasuredDimension(r10, r12);
        goto L11
    L10:
        setMeasuredDimension(r10, r11);
        goto L11
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r6, int r7, int r8) {
        super.onSizeChanged(r5, r6, r7, r8);
        if (r5 <= 0) goto L17;
        if (r6 <= 0) goto L18;
        Bitmap r0 = this.f;
        if (r0 != null) goto L8;
        return;
    L8:
        if (getMeasuredWidth() != 0) goto L10;
        return;
    L10:
        if (getMeasuredHeight() != 0) goto L12;
        return;
    L12:
        if (r0.getHeight() == getMeasuredHeight()) goto L14;
    L15:
        Context r1 = getContext();
        Intrinsics.e(r1, "context");
        Resources r2 = r1.getResources();
        Intrinsics.e(r2, "context.resources");
        Bitmap r3 = Bitmap.createBitmap(r2.getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(r3);
        this.f = r3;
        StringBuilder r4 = a.r("onSizeChanged, init new bg, w: ", r5, ", h: ", r6, ", oldw: ");
        r4.append(r7);
        r4.append(", oldh: ");
        r4.append(r8);
        L.g("OPopoverLayout", r4.toString());
        return;
    L14:
        if (r0.getWidth() != getMeasuredWidth()) goto L15;
        return;
    L18:
        return;
    }

    public final void setBorderColor(int r1) {
        this.k = r1;
    }

    public final void setBorderWidth(int r3) {
        if (r3 > 0) goto L4;
        return;
    L4:
        this.j = r3;
        if (this.l != null) goto L7;
        this.l = new Paint();
    L7:
        Paint r4 = this.l;
        if (r4 == null) goto L10;
        r4.setStyle(Paint.Style.STROKE);
    L10:
        Paint r5 = this.l;
        if (r5 == null) goto L13;
        r5.setStrokeWidth(this.j);
    L13:
        Paint r6 = this.l;
        if (r6 == null) goto L16;
        r6.setStrokeCap(Paint.Cap.BUTT);
    L16:
        Paint r7 = this.l;
        if (r7 == null) goto L19;
        r7.setStrokeJoin(Paint.Join.MITER);
    L19:
        Paint r8 = this.l;
        if (r8 == null) goto L22;
        r8.setAntiAlias(true);
    L22:
        Paint r9 = this.l;
        if (r9 == null) goto L25;
        r9.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    L25:
        Paint r10 = this.l;
        if (r10 == null) goto L28;
        r10.setColor(this.k);
    L28:
        Intrinsics.m("mFillPaint");
        throw null;
    }

    public final void setCornerRadius(@Px float r1) {
        this.b = r1;
    }

    public final void setMBgColor(int r1) {
        this.i = r1;
    }

    public final void setMHeight(float r1) {
        this.e = r1;
    }

    public final void setMWidth(float r1) {
        this.c = r1;
    }

    public final void setTransparentBg(boolean r1) {
        if (r1 == false) goto L5;
        this.i = 0;
        return;
    }
}
