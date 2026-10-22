package com.obric.oui.indicator;

import android.graphics.Canvas;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class IndicatorGroupLayout extends LinearLayout {
    public boolean b;
    public int c;
    public int e;

    public final int getBgColor() {
        return this.e;
    }

    public final int getCornerRadius() {
        return this.c;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r2) {
        Intrinsics.f(r2, "canvas");
        if (this.b == true) goto L6;
        super.onDraw(r2);
        return;
    L6:
        getWidth();
        getHeight();
        throw null;
    }

    public final void setBgColor(int r2) {
        if (this.e == r2) goto L6;
        this.e = r2;
    L6:
        throw null;
    }

    public final void setCornerRadius(int r1) {
        this.c = r1;
    }

    public final void setDrawBackground(boolean r1) {
        this.b = r1;
        invalidate();
    }
}
