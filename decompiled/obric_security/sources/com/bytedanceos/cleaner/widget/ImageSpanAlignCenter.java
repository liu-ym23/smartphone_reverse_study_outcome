package com.bytedanceos.cleaner.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import bytedanceos.util.LogTag;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class ImageSpanAlignCenter extends ImageSpan {
    private static final char[] ELLIPSIS_NORMAL = null;
    private static final char[] ELLIPSIS_TWO_DOTS = null;
    private WeakReference<Drawable> mDrawableRef;
    private int mTopMargin;

    static {
        ELLIPSIS_NORMAL = new char[]{8230};
        ELLIPSIS_TWO_DOTS = new char[]{8229};
    }

    public ImageSpanAlignCenter(Context context, int resourceId) {
        super(context, resourceId);
    }

    public ImageSpanAlignCenter(Context context, int resourceId, int topMargin) {
        super(context, resourceId);
        this.mTopMargin = topMargin;
    }

    public ImageSpanAlignCenter(Drawable d) {
        super(d);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Drawable r0 = getCachedDrawable(paint);
        if (r0 != null) goto L6;
        return 0;
    L6:
        Rect r1 = r0.getBounds();
        if (fm == null) goto L10;
        Paint.FontMetricsInt r2 = new Paint.FontMetricsInt();
        paint.getFontMetricsInt(r2);
        fm.ascent = r2.ascent;
        fm.descent = r2.descent;
        fm.top = r2.top;
        fm.bottom = r2.bottom;
    L10:
        return r1.right;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        String r3 = text.toString().substring(start, end);
        if (ELLIPSIS_NORMAL[0] != r3.charAt(0)) goto L5;
    L11:
        canvas.save();
        canvas.drawText(r3, x, y, paint);
        canvas.restore();
        return;
    L5:
        if (ELLIPSIS_TWO_DOTS[0] == r3.charAt(0)) goto L11;
        Drawable r1 = getCachedDrawable(paint);
        if (r1 != null) goto L10;
        return;
    L10:
        canvas.save();
        Paint.FontMetricsInt r4 = new Paint.FontMetricsInt();
        paint.getFontMetricsInt(r4);
        Rect r5 = r1.getBounds();
        int r6 = r4.ascent + y;
        LogTag.v("ImageSpanAlignCenter", "transY=" + r6 + " y=" + y + "  top=" + top + " bottom=" + bottom + " rect.bottom=" + r5.bottom + " rect.top=" + r5.top + " " + r4);
        canvas.translate(x, r6);
        r1.draw(canvas);
        canvas.restore();
    }

    private Drawable getCachedDrawable(Paint paint) {
        WeakReference<Drawable> r0 = this.mDrawableRef;
        if (r0 == null) goto L5;
        Drawable r1 = r0.get();
    L6:
        if (r1 != null) goto L15;
        r1 = getDrawable();
        if (r1 != null) goto L10;
        return null;
    L10:
        int r12 = paint.getFontMetricsInt(null);
        int r2 = r1.getIntrinsicWidth();
        int r3 = r1.getIntrinsicHeight();
        if (r12 <= r3) goto L13;
        int r4 = (r12 - r3) / 2;
    L14:
        int r13 = Math.min(r12, r3);
        int r5 = this.mTopMargin;
        r1.setBounds(new Rect(0, r4 + r5, (int) (((double) r2) * ((((double) r13) * 1.0d) / ((double) r3))), (r5 + r4) + r13));
        this.mDrawableRef = new WeakReference(r1);
        goto L15
    L13:
        r4 = 0;
    L15:
        return r1;
    L5:
        r1 = null;
        goto L6
    }
}
