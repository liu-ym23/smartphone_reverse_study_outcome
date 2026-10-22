package com.qihoo360.mobilesafe.common.ui.loading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonHorizonLoading extends View {
    private boolean mLoading;

    private class LoadingBarDrawable extends Drawable {
        int _3dp;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f17a;
        LinearGradient gradient;
        private int i;
        protected RectF mInRectF;
        protected Paint mPaint;
        private Matrix matrix;
        float[] radii;
        final /* synthetic */ CommonHorizonLoading this$0;
        private int width;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int r1) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter r1) {
        }

        public LoadingBarDrawable(CommonHorizonLoading r6) {
            this.this$0 = r6;
            this.matrix = new Matrix();
            int r7 = CommonUtils.dip2px(r6.getContext(), 3.0f);
            this._3dp = r7;
            this.radii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r7, r7, r7, r7};
            Paint r8 = new Paint(1);
            this.mPaint = r8;
            r8.setStyle(Paint.Style.FILL_AND_STROKE);
            this.mInRectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect r11) {
            super.onBoundsChange(r11);
            this.width = r11.width();
            LinearGradient r9 = new LinearGradient(0.0f, 0.0f, this.width, 0.0f, new int[]{this.this$0.getContext().getResources().getColor(R.color.inner_common_bg_color_5), this.this$0.getContext().getResources().getColor(R.color.inner_common_bg_color_1), this.this$0.getContext().getResources().getColor(R.color.inner_common_bg_color_5)}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.REPEAT);
            this.gradient = r9;
            this.mPaint.setShader(r9);
            RectF r0 = this.mInRectF;
            r0.top = 0.0f;
            r0.left = 0.0f;
            this.mInRectF.right = r11.width();
            this.mInRectF.bottom = r11.height();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas r5) {
            if (CommonHorizonLoading.access$000(this.this$0) == true) goto L6;
            return;
        L6:
            if (this.i < 100) goto L8;
            this.i = 0;
        L8:
            this.f17a = this.i / 100.0f;
            this.matrix.reset();
            this.matrix.postTranslate(this.f17a * this.width, 0.0f);
            LinearGradient r0 = this.gradient;
            if (r0 == null) goto L11;
            r0.setLocalMatrix(this.matrix);
        L11:
            RectF r1 = this.mInRectF;
            int r2 = this._3dp;
            r5.drawRoundRect(r1, r2, r2, this.mPaint);
            this.i++;
            invalidateSelf();
        }
    }

    static /* synthetic */ boolean access$000(CommonHorizonLoading r0) {
        return r0.mLoading;
    }

    public CommonHorizonLoading(Context r1) {
        super(r1);
    }

    public CommonHorizonLoading(Context r3, AttributeSet r4) {
        super(r3, r4);
        ClipDrawable r5 = new ClipDrawable(new LoadingBarDrawable(this), 80, 2);
        r5.setLevel(5000);
        setBackgroundDrawable(r5);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        clearAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        this.mLoading = r1;
        if (r1 == false) goto L6;
        invalidate();
        return;
    }
}
