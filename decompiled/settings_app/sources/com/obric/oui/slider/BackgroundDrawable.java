package com.obric.oui.slider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackgroundDrawable.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0014J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/slider/BackgroundDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "backgroundPaint", "Landroid/graphics/Paint;", "defaultHeight", "", "margin", "radius", "tickMarkCount", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "getOpacity", "onLevelChange", "", "level", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setTickMarkCount", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BackgroundDrawable extends Drawable {
    private final Paint backgroundPaint;
    private int defaultHeight;
    private int margin;
    private int radius;
    private int tickMarkCount;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }

    public BackgroundDrawable(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.tickMarkCount = 3;
        this.defaultHeight = OUnitExtensionKt.cdp(r3, 8);
        this.margin = OUnitExtensionKt.cdp(r3, 14);
        this.radius = OUnitExtensionKt.cdp(r3, 16);
        this.tickMarkCount = 3;
        Paint r0 = new Paint();
        r0.setColor(ContextCompat.getColor(r3, R.color.oui_fill_sunken_variable));
        r0.setStyle(Paint.Style.FILL);
        this.backgroundPaint = r0;
    }

    public final void setTickMarkCount(int r1) {
        this.tickMarkCount = r1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r18) {
        Intrinsics.checkNotNullParameter(r18, "canvas");
        Rect r2 = getBounds();
        Intrinsics.checkNotNullExpressionValue(r2, "bounds");
        float r3 = r2.left;
        float r4 = r2.top;
        int r5 = r2.right;
        float r6 = r2.bottom;
        int r7 = r2.width();
        r2.height();
        int r8 = this.margin;
        int r9 = this.tickMarkCount;
        int r10 = (r7 - (r9 * r8)) / (r9 + 1);
        if (r9 < 0) goto L9;
        char r11 = 0;
        int r12 = 0;
    L5:
        int r13 = r12 + 1;
        float r14 = ((r10 + r8) * r12) + r3;
        RectF r15 = new RectF(r14, r4, r10 + r14, r6);
        Path r16 = new Path();
        float[] r17 = new float[8];
        int r19 = this.radius;
        r17[r11] = r19;
        r17[1] = r19;
        r17[2] = r19;
        r17[3] = r19;
        r17[4] = r19;
        r17[5] = r19;
        r17[6] = r19;
        r17[7] = r19;
        r16.addRoundRect(r15, r17, Path.Direction.CW);
        r18.drawPath(r16, this.backgroundPaint);
        if (r12 == r9) goto L11;
        r12 = r13;
        r11 = 0;
        goto L5
    L11:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r1) {
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.defaultHeight;
    }
}
