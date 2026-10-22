package com.obric.oui.indicator;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class IndicatorDotView extends View implements IndicatorIcon {
    public int b;
    public int c;
    public float e;
    public float f;

    public float getCornerRadius() {
        return this.f;
    }

    public int getDotColor() {
        return this.b;
    }

    public int getStrokeColor() {
        return this.c;
    }

    public float getStrokeWidth() {
        return this.e;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r2) {
        Intrinsics.f(r2, "canvas");
        super.onDraw(r2);
        getWidth();
        getHeight();
        throw null;
    }

    public void setCornerRadius(float r1) {
        this.f = r1;
    }

    public void setDotColor(int r2) {
        if (this.b == r2) goto L6;
        this.b = r2;
    L6:
        throw null;
    }

    public void setHorizontalMargin(int r3) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        if (r1 == null) goto L9;
        r1.setMarginStart(r3);
        r1.setMarginEnd(r3);
        requestLayout();
        return;
    }

    public void setStrokeColor(int r2) {
        if (this.c == r2) goto L6;
        this.c = r2;
    L6:
        throw null;
    }

    public void setStrokeWidth(float r2) {
        if (this.e == r2) goto L6;
        this.e = r2;
    L6:
        throw null;
    }

    public void setWidth(int r1) {
        IndicatorExternalsKt.b(this, r1);
    }
}
