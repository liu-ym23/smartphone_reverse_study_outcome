package com.obric.oui.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.obric.security.R;

/* JADX INFO: loaded from: classes3.dex */
public class PieProgressFullView extends View {
    private final float cornerRadius;
    private final float tickHeight;
    private float tickHeightScale;
    private Paint tickPaint;
    private RectF tickRectF;
    private final float tickWidth;

    public float getTickHeightScale() {
        return this.tickHeightScale;
    }

    public void setTickHeightScale(float tickHeightScale) {
        this.tickHeightScale = tickHeightScale;
        invalidate();
    }

    public PieProgressFullView(Context context) {
        super(context);
        this.tickWidth = getResources().getDimension(R.dimen.dimen_2_4);
        this.tickHeight = getResources().getDimension(R.dimen.dimen_14);
        this.tickHeightScale = 1.0f;
        this.cornerRadius = getResources().getDimension(R.dimen.dimen_2);
        this.tickRectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        init();
    }

    public PieProgressFullView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.tickWidth = getResources().getDimension(R.dimen.dimen_2_4);
        this.tickHeight = getResources().getDimension(R.dimen.dimen_14);
        this.tickHeightScale = 1.0f;
        this.cornerRadius = getResources().getDimension(R.dimen.dimen_2);
        this.tickRectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        init();
    }

    public PieProgressFullView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.tickWidth = getResources().getDimension(R.dimen.dimen_2_4);
        this.tickHeight = getResources().getDimension(R.dimen.dimen_14);
        this.tickHeightScale = 1.0f;
        this.cornerRadius = getResources().getDimension(R.dimen.dimen_2);
        this.tickRectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        init();
    }

    private void init() {
        Paint r0 = new Paint();
        this.tickPaint = r0;
        r0.setColor(Color.parseColor("#4D2BD900"));
        this.tickPaint.setStyle(Paint.Style.FILL);
        this.tickPaint.setAntiAlias(true);
    }

    private RectF updateRectF(float centerX, float centerY) {
        RectF r4 = this.tickRectF;
        r4.left = centerX - (this.tickWidth / 2.0f);
        RectF r3 = this.tickRectF;
        r3.top = this.tickHeight * (1.0f - this.tickHeightScale);
        RectF r5 = this.tickRectF;
        r5.right = r5.left + this.tickWidth;
        RectF r6 = this.tickRectF;
        r6.bottom = r6.top + (this.tickHeight * this.tickHeightScale);
        return this.tickRectF;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float r0 = getWidth() / 2.0f;
        float r2 = getHeight() / 2.0f;
        float r1 = 360.0f / 164;
        RectF r4 = updateRectF(r0, r2);
        canvas.save();
        int r5 = 0;
    L3:
        if (r5 >= 164) goto L5;
        canvas.rotate(r1, r0, r2);
        float r6 = this.cornerRadius;
        canvas.drawRoundRect(r4, r6, r6, this.tickPaint);
        r5 = r5 + 1;
        goto L3
    L5:
        canvas.restore();
    }
}
