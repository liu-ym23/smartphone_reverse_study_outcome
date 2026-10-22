package com.qihoo360.mobilesafe.common.ui.other;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.ripple.CommonRippleButton;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonProgressBar extends CommonRippleButton {
    private ProgressBarDrawable clipDrawable;
    private int mProgress;

    private class ProgressBarDrawable extends ClipDrawable {
        private RectF bg;
        private Paint bgPaint;
        private RectF bgStroke;
        private Paint bgStrokePaint;
        private int mBgColor;
        private int mCorner;
        private int mHeight;
        private int mInset;
        private int mStrokeColor;
        private int mStrokeWidth;
        private int mWidth;
        final /* synthetic */ CommonProgressBar this$0;

        static /* synthetic */ void access$000(ProgressBarDrawable r0, int r1, int r2, int r3) {
            r0.setBackground(r1, r2, r3);
        }

        public ProgressBarDrawable(CommonProgressBar r1, Drawable r2, int r3, int r4) {
            this.this$0 = r1;
            super(r2, r3, r4);
            this.bg = new RectF();
            this.bgStroke = new RectF();
            Paint r5 = new Paint(1);
            this.bgPaint = r5;
            r5.setStyle(Paint.Style.FILL_AND_STROKE);
            Paint r6 = new Paint(1);
            this.bgStrokePaint = r6;
            r6.setStyle(Paint.Style.STROKE);
            int r7 = CommonUtils.dip2px(r1.getContext(), 1.0f);
            this.mStrokeWidth = r7;
            this.mInset = r7 / 4;
            this.bgStrokePaint.setStrokeWidth(r7);
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect r2) {
            super.onBoundsChange(r2);
            this.mWidth = r2.width();
            this.mHeight = r2.height();
            RectF r3 = this.bg;
            r3.top = 0.0f;
            r3.left = 0.0f;
            this.bg.right = this.mWidth;
            this.bg.bottom = this.mHeight;
            RectF r4 = this.bg;
            this.bgStroke = r4;
            int r1 = this.mInset;
            r4.inset(r1, r1);
        }

        private void setBackground(int r3, int r4, int r5) {
            this.mCorner = (int) (r4 / 1.5f);
            this.mBgColor = r3;
            this.mStrokeColor = r5;
            Paint r6 = this.bgPaint;
            int r1 = 0;
            if (drawBg() == false) goto L5;
            int r7 = this.this$0.getResources().getColor(r3);
        L6:
            r6.setColor(r7);
            Paint r8 = this.bgStrokePaint;
            if (drawEdge() == false) goto L9;
            r1 = this.this$0.getResources().getColor(r5);
        L9:
            r8.setColor(r1);
            return;
        L5:
            r7 = 0;
            goto L6
        }

        @Override // android.graphics.drawable.ClipDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas r5) {
            if (drawBg() == false) goto L5;
            RectF r0 = this.bg;
            int r1 = this.mCorner;
            r5.drawRoundRect(r0, r1, r1, this.bgPaint);
        L5:
            super.draw(r5);
            if (drawEdge() == false) goto L9;
            RectF r2 = this.bgStroke;
            int r3 = this.mCorner;
            r5.drawRoundRect(r2, r3, r3, this.bgStrokePaint);
            return;
        }

        @Override // android.graphics.drawable.ClipDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        protected boolean onLevelChange(int r1) {
            invalidateSelf();
            return super.onLevelChange(r1);
        }

        private boolean drawEdge() {
            if (this.mStrokeColor == 0) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean drawBg() {
            if (this.mBgColor == 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public CommonProgressBar(Context r1) {
        super(r1);
    }

    public CommonProgressBar(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public void setUIColorAndCorner(int r6, int r7, int r8, int r9) {
        float r1 = r8;
        ShapeDrawable r0 = new ShapeDrawable(new RoundRectShape(new float[]{r1, r1, r1, r1, r1, r1, r1, r1}, null, null));
        r0.getPaint().setColor(getResources().getColor(r7));     // Catch: Exception -> L5
    L6:
        ProgressBarDrawable r10 = new ProgressBarDrawable(this, r0, 3, 1);
        this.clipDrawable = r10;
        ProgressBarDrawable.access$000(r10, r6, r8, r9);
        setBackgroundDrawable(this.clipDrawable);
        return;
    L5:
        r0.getPaint().setColor(getResources().getColor(R.color.common_transparent));
        goto L6
    }

    public void setUIProgress(int r3) {
        if (r3 > 100) goto L7;
        if (r3 < 0) goto L8;
        int r4 = r3 * 100;
        this.clipDrawable.setLevel(r4);
        this.mProgress = r4;
        return;
    L8:
        return;
    }

    public int getUIProgress() {
        return this.mProgress;
    }
}
