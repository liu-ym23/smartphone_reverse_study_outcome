package com.android.settingslib.qrcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.GlobalProxyLancet;
import com.android.settingslib.R;

/* JADX INFO: loaded from: classes.dex */
public class QrDecorateView extends View {
    private static final float CORNER_LINE_LENGTH = 264.0f;
    private static final float CORNER_RADIUS = 16.0f;
    private static final float CORNER_STROKE_WIDTH = 4.0f;
    private static final String TAG = "QrDecorateView";
    private final int mBackgroundColor;
    private final Paint mBackgroundPaint;
    private final int mCornerColor;
    private boolean mFocused;
    private final int mFocusedCornerColor;
    private RectF mInnerFrame;
    private final float mInnerRadius;
    private Bitmap mMaskBitmap;
    private Canvas mMaskCanvas;
    private RectF mOuterFrame;
    private final float mRadius;
    private final Paint mStrokePaint;
    private final Paint mTransparentPaint;

    public QrDecorateView(Context r2) {
        this(r2, null);
    }

    public QrDecorateView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public QrDecorateView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public QrDecorateView(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.mFocused = false;
        this.mRadius = TypedValue.applyDimension(1, 16.0f, getResources().getDisplayMetrics());
        this.mInnerRadius = TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics());
        this.mCornerColor = r1.getResources().getColor(R.color.qr_corner_line_color);
        this.mFocusedCornerColor = r1.getResources().getColor(R.color.qr_focused_corner_line_color);
        int r5 = r1.getResources().getColor(R.color.qr_background_color);
        this.mBackgroundColor = r5;
        Paint r6 = new Paint();
        this.mStrokePaint = r6;
        r6.setAntiAlias(true);
        Paint r7 = new Paint();
        this.mTransparentPaint = r7;
        r7.setAntiAlias(true);
        r7.setColor(getResources().getColor(android.R.color.transparent));
        r7.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint r8 = new Paint();
        this.mBackgroundPaint = r8;
        r8.setColor(r5);
    }

    @Override // android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (getWidth() > 0) goto L5;
    L12:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "width and height must be > 0");
        return;
    L5:
        if (getHeight() <= 0) goto L12;
        if (this.mMaskBitmap != null) goto L10;
        this.mMaskBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.mMaskCanvas = new Canvas(this.mMaskBitmap);
    L10:
        calculateFramePos();
    }

    @Override // android.view.View
    protected void onDraw(Canvas r5) {
        if (this.mMaskCanvas != null) goto L5;
    L11:
        super.onDraw(r5);
        return;
    L5:
        if (this.mMaskBitmap == null) goto L11;
        Paint r0 = this.mStrokePaint;
        if (this.mFocused == false) goto L9;
        int r1 = this.mFocusedCornerColor;
    L10:
        r0.setColor(r1);
        this.mMaskCanvas.drawColor(this.mBackgroundColor);
        Canvas r2 = this.mMaskCanvas;
        RectF r3 = this.mOuterFrame;
        float r4 = this.mRadius;
        r2.drawRoundRect(r3, r4, r4, this.mStrokePaint);
        Canvas r6 = this.mMaskCanvas;
        RectF r7 = this.mInnerFrame;
        float r8 = this.mInnerRadius;
        r6.drawRoundRect(r7, r8, r8, this.mTransparentPaint);
        r5.drawBitmap(this.mMaskBitmap, 0.0f, 0.0f, this.mBackgroundPaint);
        goto L11
    L9:
        r1 = this.mCornerColor;
        goto L10
    }

    private void calculateFramePos() {
        int r0 = getWidth() / 2;
        int r1 = getHeight() / 2;
        float r2 = TypedValue.applyDimension(1, CORNER_LINE_LENGTH, getResources().getDisplayMetrics()) / 2.0f;
        float r3 = TypedValue.applyDimension(1, CORNER_STROKE_WIDTH, getResources().getDisplayMetrics());
        float r4 = r0;
        float r5 = r1;
        this.mOuterFrame = new RectF(r4 - r2, r5 - r2, r4 + r2, r5 + r2);
        this.mInnerFrame = new RectF(this.mOuterFrame.left + r3, this.mOuterFrame.top + r3, this.mOuterFrame.right - r3, this.mOuterFrame.bottom - r3);
    }

    public void setFocused(boolean r1) {
        this.mFocused = r1;
        invalidate();
    }
}
