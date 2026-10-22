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
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Px;
import com.obric.oui.utils.log.L;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OPopoverLayout extends LinearLayout {
    public static final int A = 0;
    public static final int w = 0;
    public static final float x = 0.0f;
    public static final int y = 0;
    public static final int z = 0;
    public String b;
    public float c;
    public float e;
    public RectF f;
    public Paint i;
    public float j;
    public float k;
    public int l;
    public Bitmap m;
    public Canvas n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public int t;
    public int u;
    public Paint v;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class ShadowConfig {
        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof ShadowConfig) == false) goto L12;
            ShadowConfig r3 = (ShadowConfig) r2;
            r3.getClass();
            if (Float.compare(0.0f, 0.0f) != 0) goto L16;
            r3.getClass();
            if (Float.compare(0.0f, 0.0f) != 0) goto L17;
            r3.getClass();
            if (Float.compare(0.0f, 0.0f) != 0) goto L18;
            r3.getClass();
            return true;
        L18:
            return false;
        L17:
            return false;
        L16:
            return false;
        L12:
            return false;
        }

        public final int hashCode() {
            int r2 = a.b(0.0f, a.b(0.0f, Float.hashCode(0.0f) * 31, 31), 31);
            return Integer.hashCode(0) + r2;
        }

        public final String toString() {
            StringBuilder r2 = new StringBuilder("ShadowConfig(radius=");
            r2.append(0.0f);
            r2.append(", dx=");
            r2.append(0.0f);
            r2.append(", dy=");
            r2.append(0.0f);
            r2.append(", color=");
            return a.n(r2, ")", 0);
        }
    }

    static {
        w = a.d("Resources.getSystem()", 1, 7);
        Resources r3 = Resources.getSystem();
        Intrinsics.e(r3, "Resources.getSystem()");
        TypedValue.applyDimension(1, 28, r3.getDisplayMetrics());
        Resources r4 = Resources.getSystem();
        Intrinsics.e(r4, "Resources.getSystem()");
        TypedValue.applyDimension(1, 99, r4.getDisplayMetrics());
        Resources r5 = Resources.getSystem();
        Intrinsics.e(r5, "Resources.getSystem()");
        TypedValue.applyDimension(1, 12, r5.getDisplayMetrics());
        Resources r6 = Resources.getSystem();
        Intrinsics.e(r6, "Resources.getSystem()");
        x = TypedValue.applyDimension(1, 18, r6.getDisplayMetrics());
        y = a.d("Resources.getSystem()", 1, 40);
        z = a.d("Resources.getSystem()", 1, 36);
        A = a.d("Resources.getSystem()", 1, 20);
    }

    public static int a(TextView r4) {
        String r0 = r4.getText().toString();
        TextPaint r5 = r4.getPaint();
        if (r5 == null) goto L16;
        int r2 = 0;
        if (StringsKt.m("\n", false, r0) == false) goto L7;
        Iterator r1 = StringsKt.D(r0, new String[]{"\n"}).iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        int r3 = (int) r5.measureText((String) r1.next());
        if (r3 <= r2) goto L10;
        r2 = r3;
        goto L10
    L14:
        return r2;
    L7:
        return (int) r5.measureText(r0);
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.text.TextPaint");
    }

    public final int getArrowHeight() {
        return w;
    }

    public final float getBubbleOffset() {
        float r1 = x;
        float r0 = Math.max(0.0f, r1);
        int r2 = this.l;
        int r3 = w;
        if (r2 == 0) goto L15;
        if (r2 == 1) goto L19;
        if (r2 == 2) goto L18;
        if (r2 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r0, (this.j - r3) - r1);
    L18:
        return Math.min(r0, (this.k - r3) - r1);
    L19:
        return Math.min(r0, (this.k - r3) - r1);
    L15:
        return Math.min(r0, (this.j - r3) - r1);
    }

    public final float getCornerRadius() {
        return this.c;
    }

    @NotNull
    public final Path getFullPath() {
        Intrinsics.m("mPath");
        throw null;
    }

    public final int getMAdjustHeight() {
        return this.s;
    }

    public final int getMBgColor() {
        return this.o;
    }

    public final float getMHeight() {
        return this.k;
    }

    public final boolean getMNeedArrow() {
        return this.q;
    }

    public final boolean getMNeedShadow() {
        return this.p;
    }

    public final float getMPadding() {
        return this.e;
    }

    @NotNull
    public final String getMSubTitle() {
        return this.b;
    }

    public final float getMWidth() {
        return this.j;
    }

    public final int getPadding() {
        return w / 2;
    }

    @NotNull
    public final ShadowConfig getShadowConfig() {
        return null;
    }

    public final boolean getUseDefaultView() {
        return this.r;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.f(r4, "canvas");
        if (this.m != null) goto L5;
        Context r5 = getContext();
        Intrinsics.e(r5, "context");
        Resources r6 = r5.getResources();
        Intrinsics.e(r6, "context.resources");
        this.m = Bitmap.createBitmap(r6.getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r0 = this.m;
        Intrinsics.c(r0);
        this.n = new Canvas(r0);
    L5:
        Intrinsics.m("mFillPaint");
        throw null;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r0 = 0;
        if ((getChildAt(0) instanceof TextView) == false) goto L9;
        View r1 = getChildAt(0);
        if (r1 == null) goto L8;
        TextView r2 = (TextView) r1;
    L10:
        int r3 = View.MeasureSpec.getMode(r10);
        int r12 = View.MeasureSpec.getSize(r10);
        int r4 = View.MeasureSpec.getMode(r11);
        int r13 = View.MeasureSpec.getSize(r11);
        if (r2 == null) goto L17;
        float r7 = 276;
        if (a(r2) <= a.d("Resources.getSystem()", 1, r7)) goto L15;
        int r6 = a.d("Resources.getSystem()", 1, r7);
    L16:
        int r5 = r2.getPaddingRight() + (r2.getPaddingLeft() + r6);
    L18:
        boolean r8 = this.r;
        int r9 = w;
        if (r8 == false) goto L28;
        int r14 = y;
        if (r5 <= r14) goto L23;
        float r15 = this.e;
        Resources r16 = Resources.getSystem();
        Intrinsics.e(r16, "Resources.getSystem()");
        r14 = (MathKt.a(TypedValue.applyDimension(1, r15, r16.getDisplayMetrics())) * 2) + r5;
    L23:
        int r17 = r9 * 2;
        int r18 = this.t * 2;
        int r19 = (r14 + r17) + r18;
        int r20 = (r17 + z) + r18;
        if (Intrinsics.a(this.b, "") == true) goto L27;
        r0 = A;
    L27:
        int r21 = r20 + r0;
    L30:
        if (r3 != Integer.MIN_VALUE) goto L33;
        if (r4 != Integer.MIN_VALUE) goto L33;
        setMeasuredDimension(r19, r21);
    L38:
        this.j = getMeasuredWidth();
        this.k = getMeasuredHeight();
        return;
    L33:
        if (r3 != Integer.MIN_VALUE) goto L35;
        setMeasuredDimension(r19, r13);
        goto L38
    L35:
        if (r4 != Integer.MIN_VALUE) goto L37;
        setMeasuredDimension(r12, r21);
        goto L38
    L37:
        setMeasuredDimension(r12, r13);
        goto L38
    L28:
        PopupWindow r22 = new PopupWindow(getChildAt(0), -2, -2, true);
        r22.getContentView().measure(0, 0);
        View r23 = r22.getContentView();
        Intrinsics.e(r23, "pop.contentView");
        int r24 = r9 * 2;
        r19 = r24 + r23.getMeasuredWidth();
        View r25 = r22.getContentView();
        Intrinsics.e(r25, "pop.contentView");
        r21 = r24 + r25.getMeasuredHeight();
        goto L30
    L15:
        r6 = a(r2);
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

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r6, int r7, int r8) {
        super.onSizeChanged(r5, r6, r7, r8);
        if (r5 <= 0) goto L17;
        if (r6 <= 0) goto L18;
        Bitmap r0 = this.m;
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
        this.n = new Canvas(r3);
        this.m = r3;
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
        this.u = r1;
    }

    public final void setBorderWidth(int r3) {
        if (r3 > 0) goto L4;
        return;
    L4:
        this.t = r3;
        if (this.v != null) goto L7;
        this.v = new Paint();
    L7:
        Paint r4 = this.v;
        if (r4 == null) goto L10;
        r4.setStyle(Paint.Style.STROKE);
    L10:
        Paint r5 = this.v;
        if (r5 == null) goto L13;
        r5.setStrokeWidth(this.t);
    L13:
        Paint r6 = this.v;
        if (r6 == null) goto L16;
        r6.setStrokeCap(Paint.Cap.BUTT);
    L16:
        Paint r7 = this.v;
        if (r7 == null) goto L19;
        r7.setStrokeJoin(Paint.Join.MITER);
    L19:
        Paint r8 = this.v;
        if (r8 == null) goto L22;
        r8.setAntiAlias(true);
    L22:
        Paint r9 = this.v;
        if (r9 == null) goto L25;
        r9.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    L25:
        Paint r10 = this.v;
        if (r10 == null) goto L28;
        r10.setColor(this.u);
    L28:
        Intrinsics.m("mFillPaint");
        throw null;
    }

    public final void setBubbleOrientation(int r1) {
        this.l = r1;
    }

    public final void setCornerRadius(@Px float r1) {
        this.c = r1;
    }

    public final void setMAdjustHeight(int r1) {
        this.s = r1;
    }

    public final void setMBgColor(int r1) {
        this.o = r1;
    }

    public final void setMHeight(float r1) {
        this.k = r1;
    }

    public final void setMNeedArrow(boolean r1) {
        this.q = r1;
    }

    public final void setMNeedShadow(boolean r1) {
        this.p = r1;
    }

    public final void setMPadding(float r1) {
        this.e = r1;
    }

    public final void setMSubTitle(@NotNull String r2) {
        Intrinsics.f(r2, "<set-?>");
        this.b = r2;
    }

    public final void setMWidth(float r1) {
        this.j = r1;
    }

    public final void setSubText(@NotNull String r2) {
        Intrinsics.f(r2, "str");
        this.b = r2;
    }

    public final void setTransparentBg(boolean r1) {
        if (r1 == false) goto L5;
        this.o = 0;
        return;
    }

    public final void setUseDefaultView(boolean r1) {
        this.r = r1;
    }
}
