package com.qihoo360.mobilesafe.common.ui.badge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.drawable.CircleRectDrawable;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonBadgeView extends TextView {
    private static final float SHADOW_RADIUS = 3.5f;
    private int badgeColor;
    private int badgeTextColor;
    private float density;
    private int mPadding;
    private Paint mPaint;
    private int mShadowRadius;

    private class CircleDrawable extends Drawable {
        private final Paint mPaint;
        private int mRadius;
        final /* synthetic */ CommonBadgeView this$0;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        public Paint getPaint() {
            return this.mPaint;
        }

        public CircleDrawable(CommonBadgeView r1, int r2, int r3) {
            this.this$0 = r1;
            Paint r4 = new Paint();
            this.mPaint = r4;
            r4.setColor(r3);
            r4.setAntiAlias(true);
            this.mRadius = r2;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas r4) {
            r4.drawCircle(this.this$0.getWidth() / 2, this.this$0.getHeight() / 2, this.mRadius, this.mPaint);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int r1) {
            this.mPaint.setAlpha(r1);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter r1) {
            this.mPaint.setColorFilter(r1);
        }
    }

    public CommonBadgeView(Context r2) {
        this(r2, null);
    }

    public CommonBadgeView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public CommonBadgeView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.badgeColor = -1358546;
        this.badgeTextColor = -1;
        init(r1, r2);
    }

    private void init(Context r2, AttributeSet r3) {
        Paint r4 = new Paint();
        this.mPaint = r4;
        r4.setAntiAlias(true);
        setGravity(17);
        float r5 = getContext().getResources().getDisplayMetrics().density;
        this.density = r5;
        int r6 = (int) (r5 * SHADOW_RADIUS);
        this.mShadowRadius = r6;
        this.mPadding = r6 * 2;
        setTextSize(1, 11.0f);
        float r7 = getTextSize();
        int r0 = this.mPadding + ((int) (Math.abs(r7 - (r7 / 4.0f)) / 2.0f));
        int r8 = this.mPadding;
        setPadding(r0, r8, r0, r8);
        setTextColor(this.badgeTextColor);
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        resetBadgeDrawable(r1, r2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas r1) {
        super.onDraw(r1);
    }

    private void resetBadgeDrawable(int r5, int r6) {
        if (r5 <= 0) goto L15;
        if (r6 <= 0) goto L18;
        CharSequence r7 = getText();
        if (TextUtils.isEmpty(r7) == false) goto L8;
        r7 = "";
    L8:
        int r8 = CommonUtils.getWordCount(r7.toString());
        if (r8 <= 1) goto L11;
        float r9 = getTextSize();
        CircleRectDrawable r0 = new CircleRectDrawable((int) (Math.abs(r9 - (r9 / 4.0f)) / 2.0f), (int) (this.density * SHADOW_RADIUS));
        r0.getPaint().setStyle(Paint.Style.FILL);
        r0.getPaint().setTextAlign(Paint.Align.CENTER);
        r0.getPaint().setTextSize(CommonUtils.sp2px(getContext(), 9.0f));
        r0.getPaint().setFakeBoldText(true);
        r0.getPaint().setColor(this.badgeColor);
        setBackgroundDrawable(r0);
        return;
    L11:
        if (r8 != 1) goto L13;
        CircleDrawable r2 = new CircleDrawable(this, (CommonUtils.dip2px(getContext(), 13.0f) / 2) + CommonUtils.dip2px(getContext(), 2.0f), this.badgeColor);
        r2.getPaint().setTextSize(CommonUtils.sp2px(getContext(), 9.0f));
        r2.getPaint().setStyle(Paint.Style.FILL);
        r2.getPaint().setTextAlign(Paint.Align.CENTER);
        r2.getPaint().setFakeBoldText(true);
        setBackgroundDrawable(r2);
        return;
    L13:
        setPureCircle();
        return;
    L18:
        return;
    }

    public void setPureCircle() {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        r0.width = CommonUtils.dip2px(getContext(), 6.0f);
        r0.height = r0.width;
        setLayoutParams(r0);
        setBackgroundDrawable(new CircleDrawable(this, CommonUtils.dip2px(getContext(), 6.0f) / 2, this.badgeColor));
        setVisibility(0);
    }

    public void setBadgeContent(String r4) {
        String r1 = "";
        if (TextUtils.isEmpty(r4) == false) goto L6;
        r4 = "";
    L6:
        if (CommonUtils.getWordCount(r4) < 2) goto L13;
        if (CommonUtils.isInteger(r4) == true) goto L10;
    L19:
        r1 = r4;
    L20:
        setText(r1);
        return;
    L10:
        if (Integer.valueOf(r4).intValue() <= 99) goto L19;
        r1 = "99+";
        goto L20
    L13:
        if (CommonUtils.getWordCount(r4) < 1) goto L19;
        if (CommonUtils.isInteger(r4) == false) goto L19;
        if (Integer.valueOf(r4).intValue() != 0) goto L19;
        goto L19
    }

    public void setBadgeShown(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 0;
    L5:
        setVisibility(r2);
        return;
    L4:
        r2 = 8;
        goto L5
    }

    public void setBadgeColor(int r1) {
        this.badgeColor = r1;
    }

    public boolean isBadgeShown() {
        return isShown();
    }
}
