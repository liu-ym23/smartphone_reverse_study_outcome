package com.bytedanceos.security.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class CircleProgressBar extends View {
    private static final int ANIM_TIME = 1500;
    private int bgRectoffset;
    private String centerText;
    Paint.FontMetrics fontMetrics;
    private Paint fontPaint;
    private int height;
    Bitmap mBitmap;
    private int mFinishSoftProgress;
    private int mHardProgress;
    private int mHardProgressColor;
    private boolean mIsAnim;
    private Paint mPaint;
    private int mSoftProgress;
    private int mSoftProgressColor;
    private int mUnitLeftMargin;
    private int mUnitTopMargin;
    private int normalColor;
    private Paint.Style progress_style;
    private RectF rectF;
    private int strokeWidth;
    private int textColor;
    private float textSize;
    private Paint unitPaint;
    private float unitSize;
    private String unitText;
    private int width;

    static /* synthetic */ int access$000(CircleProgressBar r0) {
        return r0.mSoftProgress;
    }

    static /* synthetic */ int access$002(CircleProgressBar r0, int r1) {
        r0.mSoftProgress = r1;
        return r1;
    }

    static /* synthetic */ int access$100(CircleProgressBar r0) {
        return r0.mHardProgress;
    }

    static /* synthetic */ int access$102(CircleProgressBar r0, int r1) {
        r0.mHardProgress = r1;
        return r1;
    }

    static /* synthetic */ boolean access$202(CircleProgressBar r0, boolean r1) {
        r0.mIsAnim = r1;
        return r1;
    }

    public CircleProgressBar(Context context) {
        this(context, null);
    }

    public CircleProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.strokeWidth = 5;
        this.normalColor = Color.parseColor("#E6E6E6");
        this.mHardProgressColor = Color.parseColor("#b6d92b");
        this.mSoftProgressColor = Color.parseColor("#ed4e42");
        this.textColor = this.normalColor;
        this.textSize = 20.0f;
        this.unitSize = 20.0f;
        this.mHardProgress = 0;
        this.mSoftProgress = 0;
        this.centerText = "0";
        this.unitText = "%";
        this.fontPaint = null;
        this.unitPaint = null;
        this.progress_style = Paint.Style.STROKE;
        this.mFinishSoftProgress = -1;
        this.mIsAnim = false;
        this.fontMetrics = null;
        TypedArray r4 = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressBar);
        this.textSize = r4.getDimension(7, this.textSize);
        this.textColor = r4.getColor(6, this.textColor);
        if (r4.getString(5) != null) goto L5;
        String r5 = this.centerText;
    L6:
        this.centerText = r5;
        this.strokeWidth = r4.getDimensionPixelOffset(4, this.strokeWidth);
        this.normalColor = r4.getColor(0, this.normalColor);
        if (r4.getInt(3, 0) != 0) goto L9;
        Paint.Style r6 = Paint.Style.STROKE;
    L10:
        this.progress_style = r6;
        r4.recycle();
        this.bgRectoffset = getResources().getDimensionPixelOffset(R.dimen.circle_process_bar_bg_offset);
        this.mUnitLeftMargin = getResources().getDimensionPixelOffset(R.dimen.circle_process_bar_unit_left_margin);
        this.unitSize = getResources().getDimensionPixelOffset(R.dimen.circle_process_bar_unit_text_size);
        this.mUnitTopMargin = getResources().getDimensionPixelOffset(R.dimen.circle_process_bar_unit_top_margin);
        initPaint();
        return;
    L9:
        r6 = Paint.Style.FILL;
        goto L10
    L5:
        r5 = r4.getString(5);
        goto L6
    }

    private void initPaint() {
        Paint r0 = new Paint();
        this.mPaint = r0;
        r0.setColor(this.normalColor);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(this.progress_style);
        this.mPaint.setStrokeWidth(this.strokeWidth);
        Paint r1 = new Paint();
        this.fontPaint = r1;
        r1.setTextSize(this.textSize);
        this.fontPaint.setAntiAlias(true);
        this.fontPaint.setFakeBoldText(true);
        this.fontPaint.setColor(this.textColor);
        Paint r2 = new Paint();
        this.unitPaint = r2;
        r2.setTextSize(this.unitSize);
        this.unitPaint.setAntiAlias(true);
        this.unitPaint.setColor(this.textColor);
        this.mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.chart_pie_bg);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.height = View.MeasureSpec.getSize(heightMeasureSpec);
        this.width = View.MeasureSpec.getSize(widthMeasureSpec);
        int r1 = this.strokeWidth;
        int r3 = this.bgRectoffset;
        this.rectF = new RectF((r1 / 2) + r3, (r1 / 2) + r3, (this.width - (r1 / 2)) - r3, (this.height - (r1 / 2)) - r3);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(this.normalColor);
        RectF r3 = this.rectF;
        if (this.progress_style != Paint.Style.FILL) goto L5;
        boolean r6 = true;
    L6:
        canvas.drawArc(r3, 0.0f, 360.0f, r6, this.mPaint);
        this.mPaint.setColor(this.mHardProgressColor);
        int r0 = this.mHardProgress;
        if (r0 <= 0) goto L13;
        RectF r2 = this.rectF;
        float r4 = this.mSoftProgress + 269;
        float r5 = r0 + 2;
        if (this.progress_style != Paint.Style.FILL) goto L11;
        boolean r7 = true;
    L12:
        canvas.drawArc(r2, r4, r5, r7, this.mPaint);
        goto L13
    L11:
        r7 = false;
    L13:
        this.mPaint.setColor(this.mSoftProgressColor);
        int r1 = this.mSoftProgress;
        if (r1 <= 0) goto L21;
        RectF r8 = this.rectF;
        float r9 = r1;
        if (this.progress_style != Paint.Style.FILL) goto L18;
        boolean r10 = true;
    L19:
        canvas.drawArc(r8, 270.0f, r9, r10, this.mPaint);
        return;
    L18:
        r10 = false;
        goto L19
    L21:
        return;
    L5:
        r6 = false;
        goto L6
    }

    public void update(final int softProgress, String text) {
        if (softProgress <= 360) goto L5;
        return;
    L5:
        if (this.mFinishSoftProgress != softProgress) goto L7;
        return;
    L7:
        if (this.mIsAnim == true) goto L17;
        this.mFinishSoftProgress = softProgress;
        this.mHardProgress = 0;
        this.mSoftProgress = 0;
        this.mIsAnim = true;
        int r2 = (int) ((((double) softProgress) / 360.0d) * 1500.0d);
        ValueAnimator r5 = ValueAnimator.ofInt(new int[]{0, softProgress});
        final ValueAnimator r0 = ValueAnimator.ofInt(new int[]{1, 360 - softProgress});
        r5.addUpdateListener(new AnonymousClass1(this, softProgress, r0));
        r0.addUpdateListener(new AnonymousClass2(this, softProgress));
        r0.setDuration(1500 - r2);
        if (softProgress <= 0) goto L12;
        r5.setDuration(r2).start();
    L13:
        this.centerText = text;
        return;
    L12:
        r0.start();
        goto L13
    }

    public boolean isAnim() {
        return this.mIsAnim;
    }
}
