package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.bytedance.librarian.LibrarianImpl;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LineRadarRenderer extends LineScatterCandleRadarRenderer {
    public LineRadarRenderer(ChartAnimator r1, ViewPortHandler r2) {
        super(r1, r2);
    }

    protected void drawFilledPath(Canvas r4, Path r5, Drawable r6) {
        if (clipPathSupported() == false) goto L7;
        int r0 = r4.save();
        r4.clipPath(r5);
        r6.setBounds((int) this.mViewPortHandler.contentLeft(), (int) this.mViewPortHandler.contentTop(), (int) this.mViewPortHandler.contentRight(), (int) this.mViewPortHandler.contentBottom());
        r6.draw(r4);
        r4.restoreToCount(r0);
        return;
    L7:
        throw new RuntimeException("Fill-drawables not (yet) supported below API level 18, this code was run on API level " + Utils.getSDKInt() + LibrarianImpl.Constants.DOT);
    }

    protected void drawFilledPath(Canvas r4, Path r5, int r6, int r7) {
        int r8 = r6 & 16777215;
        int r9 = r8 | (r7 << 24);
        if (clipPathSupported() == false) goto L5;
        int r3 = r4.save();
        r4.clipPath(r5);
        r4.drawColor(r9);
        r4.restoreToCount(r3);
        return;
    L5:
        Paint.Style r10 = this.mRenderPaint.getStyle();
        int r0 = this.mRenderPaint.getColor();
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        this.mRenderPaint.setColor(r9);
        r4.drawPath(r5, this.mRenderPaint);
        this.mRenderPaint.setColor(r0);
        this.mRenderPaint.setStyle(r10);
    }

    private boolean clipPathSupported() {
        if (Utils.getSDKInt() < 18) goto L5;
        return true;
    L5:
        return false;
    }
}
