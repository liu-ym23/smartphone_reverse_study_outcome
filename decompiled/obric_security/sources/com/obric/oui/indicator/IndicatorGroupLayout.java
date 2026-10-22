package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.obric.oui.common.style.SmoothCornerH;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IndicatorGroupLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0014J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0014J\u000e\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0015R$\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/oui/indicator/IndicatorGroupLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "bgColor", "getBgColor", "()I", "setBgColor", "(I)V", "bgPaint", "Landroid/graphics/Paint;", "cornerRadius", "getCornerRadius", "setCornerRadius", "drawSelf", "", "fixedContentWidthPx", "getFixedContentWidthPx", "()Ljava/lang/Integer;", "setFixedContentWidthPx", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "rectF", "Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setDrawBackground", "draw", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IndicatorGroupLayout extends LinearLayout {
    private int bgColor;
    private final Paint bgPaint;
    private int cornerRadius;
    private boolean drawSelf;
    private Integer fixedContentWidthPx;
    private final RectF rectF;

    public IndicatorGroupLayout(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public IndicatorGroupLayout(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ IndicatorGroupLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public IndicatorGroupLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.rectF = new RectF();
        Paint r5 = new Paint(1);
        r5.setStyle(Paint.Style.FILL);
        this.bgPaint = r5;
        setBackgroundColor(0);
    }

    public final int getCornerRadius() {
        return this.cornerRadius;
    }

    public final void setCornerRadius(int r1) {
        this.cornerRadius = r1;
    }

    public final Integer getFixedContentWidthPx() {
        return this.fixedContentWidthPx;
    }

    public final void setFixedContentWidthPx(Integer r2) {
        if (Intrinsics.areEqual(this.fixedContentWidthPx, r2) == true) goto L6;
        this.fixedContentWidthPx = r2;
        requestLayout();
        invalidate();
        return;
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final void setBgColor(int r2) {
        if (this.bgColor == r2) goto L5;
        this.bgColor = r2;
    L5:
        this.bgPaint.setColor(r2);
    }

    public final void setDrawBackground(boolean r1) {
        this.drawSelf = r1;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        Integer r4 = this.fixedContentWidthPx;
        if (r4 != null) goto L5;
        return;
    L5:
        int r5 = r4.intValue();
        int r6 = LinearLayout.resolveSize((getPaddingLeft() + r5) + getPaddingRight(), r2);
        if (getMeasuredWidth() == r6) goto L9;
        setMeasuredDimension(r6, getMeasuredHeight());
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        if (this.drawSelf == false) goto L5;
        this.rectF.set(0.0f, 0.0f, getWidth(), getHeight());
        SmoothCornerH.drawRoundRect(r5, this.rectF, this.cornerRadius * 1.0f, this.bgPaint);
    L5:
        super.onDraw(r5);
    }
}
