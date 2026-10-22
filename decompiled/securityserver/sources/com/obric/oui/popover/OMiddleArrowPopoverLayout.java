package com.obric.oui.popover;

import a.a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Px;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OMiddleArrowPopoverLayout extends LinearLayout {
    public static final int r = 0;
    public static final float s = 0.0f;
    public static final int t = 0;
    public static final int u = 0;
    public float b;
    public float c;
    public float e;
    public int f;
    public Bitmap i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public Paint q;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class ShadowConfig {
        public final boolean equals(Object r1) {
            if (this != r1) goto L4;
            return true;
        L4:
            if ((r1 instanceof ShadowConfig) == false) goto L12;
            ((ShadowConfig) r1).getClass();
            if (Float.compare(0.0f, 0.0f) == 0) goto L8;
            return false;
        L8:
            if (Float.compare(0.0f, 0.0f) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(0.0f, 0.0f) == 0) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r2 = a.b(0.0f, a.b(0.0f, Float.hashCode(0.0f) * 31, 31), 31);
            return Integer.hashCode(0) + r2;
        }

        public final String toString() {
            return "ShadowConfig(radius=0.0, dx=0.0, dy=0.0, color=0)";
        }
    }

    static {
        r = a.d("Resources.getSystem()", 1, 9);
        Resources r3 = Resources.getSystem();
        Intrinsics.e(r3, "Resources.getSystem()");
        s = TypedValue.applyDimension(1, 18, r3.getDisplayMetrics());
        float r0 = 42;
        int r4 = a.d("Resources.getSystem()", 1, r0);
        t = r4;
        int r1 = a.d("Resources.getSystem()", 1, r0);
        u = r1;
        Integer.min(r1, r4);
    }

    public final int getArrowHeight() {
        return r;
    }

    public final float getBubbleOffset() {
        float r1 = s;
        float r2 = Math.max(0.0f, r1);
        int r3 = this.f;
        int r4 = r;
        if (r3 == 0) goto L15;
        if (r3 == 1) goto L18;
        if (r3 == 2) goto L17;
        if (r3 == 3) goto L16;
        return 0.0f;
    L16:
        return Math.min(r2, (this.c - r4) - r1);
    L17:
        return Math.min(r2, (this.e - r4) - r1);
    L18:
        return Math.min(r2, (this.e - r4) - r1);
    L15:
        return Math.min(r2, (this.c - r4) - r1);
    }

    @NotNull
    public final Path getFullPath() {
        Intrinsics.m("mPath");
        throw null;
    }

    public final int getMAdjustHeight() {
        return this.n;
    }

    public final int getMBgColor() {
        return this.j;
    }

    public final float getMHeight() {
        return this.e;
    }

    public final boolean getMNeedArrow() {
        return this.l;
    }

    public final boolean getMNeedShadow() {
        return this.k;
    }

    public final float getMPadding() {
        return this.b;
    }

    public final float getMWidth() {
        return this.c;
    }

    public final int getPadding() {
        return r / 2;
    }

    @NotNull
    public final ShadowConfig getShadowConfig() {
        return null;
    }

    public final boolean getUseDefaultView() {
        return this.m;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.f(r4, "canvas");
        if (this.i != null) goto L5;
        Context r5 = getContext();
        Intrinsics.e(r5, "context");
        Resources r6 = r5.getResources();
        Intrinsics.e(r6, "context.resources");
        this.i = Bitmap.createBitmap(r6.getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r3 = this.i;
        Intrinsics.c(r3);
        new Canvas(r3);
    L5:
        Intrinsics.m("mFillPaint");
        throw null;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r11, int r12) {
        super.onMeasure(r11, r12);
        if ((getChildAt(0) instanceof TextView) == false) goto L9;
        View r1 = getChildAt(0);
        if (r1 == null) goto L8;
        TextView r2 = (TextView) r1;
    L10:
        int r3 = View.MeasureSpec.getMode(r11);
        int r13 = View.MeasureSpec.getSize(r11);
        int r4 = View.MeasureSpec.getMode(r12);
        int r14 = View.MeasureSpec.getSize(r12);
        if (r2 == null) goto L17;
        float r8 = 276;
        if (((int) r2.getPaint().measureText(r2.getText().toString())) <= a.d("Resources.getSystem()", 1, r8)) goto L15;
        int r7 = a.d("Resources.getSystem()", 1, r8);
    L16:
        int r5 = r2.getPaddingRight() + (r2.getPaddingLeft() + r7);
    L18:
        boolean r9 = this.m;
        int r10 = r;
        if (r9 == false) goto L24;
        int r0 = t;
        if (r5 <= r0) goto L23;
        float r6 = this.b;
        Resources r15 = Resources.getSystem();
        Intrinsics.e(r15, "Resources.getSystem()");
        r0 = (MathKt.a(TypedValue.applyDimension(1, r6, r15.getDisplayMetrics())) * 2) + r5;
    L23:
        int r16 = (r10 * 2) + r0;
        int r17 = this.o;
        int r18 = (r17 * 2) + r16;
        int r19 = r17 * 2;
        int r20 = r19 + ((r10 * 2) + u);
    L26:
        if (r3 != Integer.MIN_VALUE) goto L30;
        if (r4 != Integer.MIN_VALUE) goto L30;
        setMeasuredDimension(r18, r20);
    L34:
        this.c = getMeasuredWidth();
        this.e = getMeasuredHeight();
        Intrinsics.m("mBubbleArrowPath");
        throw null;
    L30:
        if (r3 == Integer.MIN_VALUE) goto L33;
        if (r4 != Integer.MIN_VALUE) goto L34;
        setMeasuredDimension(r13, r20);
        goto L34
    L33:
        setMeasuredDimension(r18, r14);
        goto L34
    L24:
        PopupWindow r21 = new PopupWindow(getChildAt(0), -2, -2, true);
        r21.getContentView().measure(0, 0);
        View r22 = r21.getContentView();
        Intrinsics.e(r22, "pop.contentView");
        int r23 = r22.getMeasuredWidth() + (r10 * 2);
        View r24 = r21.getContentView();
        Intrinsics.e(r24, "pop.contentView");
        int r25 = r24.getMeasuredHeight() + (r10 * 2);
        r18 = r23;
        r20 = r25;
        goto L26
    L15:
        r7 = (int) r2.getPaint().measureText(r2.getText().toString());
        goto L16
    L17:
        r5 = getMeasuredWidth();
        goto L18
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L9:
        r2 = null;
        goto L10
    }

    public final void setBorderColor(int r1) {
        this.p = r1;
    }

    public final void setBorderWidth(int r3) {
        if (r3 > 0) goto L4;
        return;
    L4:
        this.o = r3;
        if (this.q != null) goto L7;
        this.q = new Paint();
    L7:
        Paint r4 = this.q;
        if (r4 == null) goto L10;
        r4.setStyle(Paint.Style.STROKE);
    L10:
        Paint r5 = this.q;
        if (r5 == null) goto L13;
        r5.setStrokeWidth(this.o);
    L13:
        Paint r6 = this.q;
        if (r6 == null) goto L16;
        r6.setStrokeCap(Paint.Cap.BUTT);
    L16:
        Paint r7 = this.q;
        if (r7 == null) goto L19;
        r7.setStrokeJoin(Paint.Join.MITER);
    L19:
        Paint r8 = this.q;
        if (r8 == null) goto L22;
        r8.setAntiAlias(true);
    L22:
        Paint r9 = this.q;
        if (r9 == null) goto L25;
        r9.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    L25:
        Paint r10 = this.q;
        if (r10 == null) goto L28;
        r10.setColor(this.p);
    L28:
        Intrinsics.m("mFillPaint");
        throw null;
    }

    public final void setBubbleOrientation(int r1) {
        this.f = r1;
    }

    public final void setCornerRadius(@Px float r1) {
    }

    public final void setMAdjustHeight(int r1) {
        this.n = r1;
    }

    public final void setMBgColor(int r1) {
        this.j = r1;
    }

    public final void setMHeight(float r1) {
        this.e = r1;
    }

    public final void setMNeedArrow(boolean r1) {
        this.l = r1;
    }

    public final void setMNeedShadow(boolean r1) {
        this.k = r1;
    }

    public final void setMPadding(float r1) {
        this.b = r1;
    }

    public final void setMWidth(float r1) {
        this.c = r1;
    }

    public final void setTransparentBg(boolean r3) {
        if (r3 == false) goto L5;
        this.j = 0;
        setLayerType(1, null);
        return;
    L5:
        setLayerType(1, null);
    }

    public final void setUseDefaultView(boolean r1) {
        this.m = r1;
    }
}
