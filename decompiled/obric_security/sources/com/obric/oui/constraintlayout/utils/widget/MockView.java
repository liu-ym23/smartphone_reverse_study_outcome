package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes3.dex */
public class MockView extends View {
    private int mDiagonalsColor;
    private boolean mDrawDiagonals;
    private boolean mDrawLabel;
    private int mMargin;
    private Paint mPaintDiagonals;
    private Paint mPaintText;
    private Paint mPaintTextBackground;
    protected String mText;
    private int mTextBackgroundColor;
    private Rect mTextBounds;
    private int mTextColor;

    public MockView(Context r4) {
        super(r4);
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(255, 0, 0, 0);
        this.mTextColor = Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(r4, null);
    }

    public MockView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(255, 0, 0, 0);
        this.mTextColor = Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(r3, r4);
    }

    public MockView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(255, 0, 0, 0);
        this.mTextColor = Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(r2, r3);
    }

    private void init(Context r5, AttributeSet r6) {
        if (r6 == null) goto L26;
        TypedArray r7 = r5.obtainStyledAttributes(r6, R.styleable.MockView);
        int r0 = r7.getIndexCount();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L24;
        int r2 = r7.getIndex(r1);
        if (r2 != R.styleable.MockView_mock_label) goto L9;
        this.mText = r7.getString(r2);
    L23:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r2 != R.styleable.MockView_mock_showDiagonals) goto L12;
        this.mDrawDiagonals = r7.getBoolean(r2, this.mDrawDiagonals);
        goto L23
    L12:
        if (r2 != R.styleable.MockView_mock_diagonalsColor) goto L15;
        this.mDiagonalsColor = r7.getColor(r2, this.mDiagonalsColor);
        goto L23
    L15:
        if (r2 != R.styleable.MockView_mock_labelBackgroundColor) goto L18;
        this.mTextBackgroundColor = r7.getColor(r2, this.mTextBackgroundColor);
        goto L23
    L18:
        if (r2 != R.styleable.MockView_mock_labelColor) goto L21;
        this.mTextColor = r7.getColor(r2, this.mTextColor);
        goto L23
    L21:
        if (r2 != R.styleable.MockView_mock_showLabel) goto L23;
        this.mDrawLabel = r7.getBoolean(r2, this.mDrawLabel);
        goto L23
    L24:
        r7.recycle();
    L26:
        if (this.mText == null) goto L31;
    L28:
        this.mPaintDiagonals.setColor(this.mDiagonalsColor);
        this.mPaintDiagonals.setAntiAlias(true);
        this.mPaintText.setColor(this.mTextColor);
        this.mPaintText.setAntiAlias(true);
        this.mPaintTextBackground.setColor(this.mTextBackgroundColor);
        this.mMargin = Math.round(this.mMargin * (getResources().getDisplayMetrics().xdpi / 160.0f));
        return;
    L31:
        this.mText = r5.getResources().getResourceEntryName(getId());     // Catch: Exception -> L30
        goto L28
    }

    @Override // android.view.View
    public void onDraw(Canvas r14) {
        super.onDraw(r14);
        int r0 = getWidth();
        int r1 = getHeight();
        if (this.mDrawDiagonals == false) goto L5;
        r0 = r0 - 1;
        r1 = r1 - 1;
        float r11 = r0;
        float r12 = r1;
        r14.drawLine(0.0f, 0.0f, r11, r12, this.mPaintDiagonals);
        r14.drawLine(0.0f, r12, r11, 0.0f, this.mPaintDiagonals);
        r14.drawLine(0.0f, 0.0f, r11, 0.0f, this.mPaintDiagonals);
        r14.drawLine(r11, 0.0f, r11, r12, this.mPaintDiagonals);
        r14.drawLine(r11, r12, 0.0f, r12, this.mPaintDiagonals);
        r14.drawLine(0.0f, r12, 0.0f, 0.0f, this.mPaintDiagonals);
    L5:
        String r2 = this.mText;
        if (r2 != null) goto L8;
        return;
    L8:
        if (this.mDrawLabel == false) goto L12;
        this.mPaintText.getTextBounds(r2, 0, r2.length(), this.mTextBounds);
        float r3 = (r0 - this.mTextBounds.width()) / 2.0f;
        float r4 = ((r1 - this.mTextBounds.height()) / 2.0f) + this.mTextBounds.height();
        this.mTextBounds.offset((int) r3, (int) r4);
        Rect r5 = this.mTextBounds;
        r5.set(r5.left - this.mMargin, this.mTextBounds.top - this.mMargin, this.mTextBounds.right + this.mMargin, this.mTextBounds.bottom + this.mMargin);
        r14.drawRect(this.mTextBounds, this.mPaintTextBackground);
        r14.drawText(this.mText, r3, r4, this.mPaintText);
        return;
    }
}
