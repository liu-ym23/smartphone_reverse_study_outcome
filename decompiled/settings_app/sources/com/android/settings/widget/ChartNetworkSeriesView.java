package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.net.NetworkStatsHistory;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.android.internal.util.Preconditions;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class ChartNetworkSeriesView extends View {
    private static final boolean ESTIMATE_ENABLED = false;
    private static final boolean LOGD = false;
    private static final String TAG = "ChartNetworkSeriesView";
    private long mEnd;
    private long mEndTime;
    private boolean mEstimateVisible;
    private ChartAxis mHoriz;
    private long mMax;
    private long mMaxEstimate;
    private Paint mPaintEstimate;
    private Paint mPaintFill;
    private Paint mPaintFillSecondary;
    private Paint mPaintStroke;
    private Path mPathEstimate;
    private Path mPathFill;
    private Path mPathStroke;
    private boolean mPathValid;
    private long mPrimaryLeft;
    private long mPrimaryRight;
    private int mSafeRegion;
    private boolean mSecondary;
    private long mStart;
    private NetworkStatsHistory mStats;
    private ChartAxis mVert;

    public ChartNetworkSeriesView(Context r3) {
        this(r3, null, 0);
    }

    public ChartNetworkSeriesView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ChartNetworkSeriesView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.mEndTime = Long.MIN_VALUE;
        this.mPathValid = false;
        this.mEstimateVisible = false;
        this.mSecondary = false;
        TypedArray r7 = r4.obtainStyledAttributes(r5, R.styleable.ChartNetworkSeriesView, r6, 0);
        int r8 = r7.getColor(3, SupportMenu.CATEGORY_MASK);
        int r1 = r7.getColor(0, SupportMenu.CATEGORY_MASK);
        int r9 = r7.getColor(1, SupportMenu.CATEGORY_MASK);
        int r2 = r7.getDimensionPixelSize(2, 0);
        setChartColor(r8, r1, r9);
        setSafeRegion(r2);
        setWillNotDraw(false);
        r7.recycle();
        this.mPathStroke = new Path();
        this.mPathFill = new Path();
        this.mPathEstimate = new Path();
    }

    void init(ChartAxis r2, ChartAxis r3) {
        this.mHoriz = (ChartAxis) Preconditions.checkNotNull(r2, "missing horiz");
        this.mVert = (ChartAxis) Preconditions.checkNotNull(r3, "missing vert");
    }

    public void setChartColor(int r4, int r5, int r6) {
        Paint r0 = new Paint();
        this.mPaintStroke = r0;
        r0.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0f);
        this.mPaintStroke.setColor(r4);
        this.mPaintStroke.setStyle(Paint.Style.STROKE);
        this.mPaintStroke.setAntiAlias(true);
        Paint r7 = new Paint();
        this.mPaintFill = r7;
        r7.setColor(r5);
        this.mPaintFill.setStyle(Paint.Style.FILL);
        this.mPaintFill.setAntiAlias(true);
        Paint r8 = new Paint();
        this.mPaintFillSecondary = r8;
        r8.setColor(r6);
        this.mPaintFillSecondary.setStyle(Paint.Style.FILL);
        this.mPaintFillSecondary.setAntiAlias(true);
        Paint r9 = new Paint();
        this.mPaintEstimate = r9;
        r9.setStrokeWidth(3.0f);
        this.mPaintEstimate.setColor(r6);
        this.mPaintEstimate.setStyle(Paint.Style.STROKE);
        this.mPaintEstimate.setAntiAlias(true);
        this.mPaintEstimate.setPathEffect(new DashPathEffect(new float[]{10.0f, 10.0f}, 1.0f));
    }

    public void setSafeRegion(int r1) {
        this.mSafeRegion = r1;
    }

    public void bindNetworkStats(NetworkStatsHistory r1) {
        this.mStats = r1;
        invalidatePath();
        invalidate();
    }

    public void setBounds(long r1, long r3) {
        this.mStart = r1;
        this.mEnd = r3;
    }

    public void setSecondary(boolean r1) {
        this.mSecondary = r1;
    }

    public void setPrimaryRange(long r1, long r3) {
        this.mPrimaryLeft = r1;
        this.mPrimaryRight = r3;
        invalidate();
    }

    public void invalidatePath() {
        this.mPathValid = false;
        this.mMax = 0;
        invalidate();
    }

    private void generatePath() {
        long r1 = 0;
        this.mMax = 0;
        this.mPathStroke.reset();
        this.mPathFill.reset();
        this.mPathEstimate.reset();
        this.mPathValid = true;
        NetworkStatsHistory r3 = this.mStats;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.size() < 2) goto L26;
        getWidth();
        float r4 = getHeight();
        long r6 = this.mHoriz.convertToValue(0.0f);
        this.mPathStroke.moveTo(0.0f, r4);
        this.mPathFill.moveTo(0.0f, r4);
        int r5 = this.mStats.getIndexBefore(this.mStart);
        int r8 = this.mStats.getIndexAfter(this.mEnd);
        NetworkStatsHistory.Entry r9 = null;
        float r10 = r4;
        float r11 = 0.0f;
    L8:
        if (r5 > r8) goto L17;
        r9 = this.mStats.getValues(r5, r9);
        long r12 = r9.bucketStart;
        long r14 = r9.bucketDuration + r12;
        float r7 = this.mHoriz.convertToPoint(r12);
        int r17 = r8;
        float r13 = this.mHoriz.convertToPoint(r14);
        if (r13 < 0.0f) goto L16;
        r1 = r1 + (r9.rxBytes + r9.txBytes);
        float r15 = this.mVert.convertToPoint(r1);
        if (r6 == r12) goto L15;
        this.mPathStroke.lineTo(r7, r10);
        this.mPathFill.lineTo(r7, r10);
    L15:
        this.mPathStroke.lineTo(r13, r15);
        this.mPathFill.lineTo(r13, r15);
        r10 = r15;
        r11 = r13;
        r6 = r14;
    L16:
        r5 = r5 + 1;
        r8 = r17;
        r4 = r4;
        goto L8
    L17:
        float r20 = r4;
        long r16 = this.mEndTime;
        if (r6 >= r16) goto L20;
        r11 = this.mHoriz.convertToPoint(r16);
        this.mPathStroke.lineTo(r11, r10);
        this.mPathFill.lineTo(r11, r10);
    L20:
        this.mPathFill.lineTo(r11, r20);
        this.mPathFill.lineTo(0.0f, r20);
        this.mMax = r1;
        invalidate();
        return;
    }

    public void setEndTime(long r1) {
        this.mEndTime = r1;
    }

    public void setEstimateVisible(boolean r1) {
        this.mEstimateVisible = false;
        invalidate();
    }

    public long getMaxEstimate() {
        return this.mMaxEstimate;
    }

    public long getMaxVisible() {
        if (this.mEstimateVisible == false) goto L5;
        long r0 = this.mMaxEstimate;
    L7:
        if (r0 > 0) goto L12;
        NetworkStatsHistory r3 = this.mStats;
        if (r3 == null) goto L13;
        NetworkStatsHistory.Entry r9 = r3.getValues(this.mStart, this.mEnd, null);
        return r9.rxBytes + r9.txBytes;
    L13:
        return r0;
    L12:
        return r0;
    L5:
        r0 = this.mMax;
        goto L7
    }

    @Override // android.view.View
    protected void onDraw(Canvas r11) {
        if (this.mPathValid == true) goto L5;
        generatePath();
    L5:
        float r0 = this.mHoriz.convertToPoint(this.mPrimaryLeft);
        float r1 = this.mHoriz.convertToPoint(this.mPrimaryRight);
        if (this.mEstimateVisible == false) goto L8;
        int r2 = r11.save();
        r11.clipRect(0, 0, getWidth(), getHeight());
        r11.drawPath(this.mPathEstimate, this.mPaintEstimate);
        r11.restoreToCount(r2);
    L8:
        int r3 = r11.save();
        r11.clipRect(0.0f, 0.0f, r0, getHeight());
        r11.drawPath(this.mPathFill, this.mPaintFillSecondary);
        r11.restoreToCount(r3);
        if (this.mSecondary == false) goto L11;
        Paint r4 = this.mPaintFillSecondary;
    L12:
        int r5 = r11.save();
        r11.clipRect(this.mSafeRegion, 0, getWidth(), getHeight() - this.mSafeRegion);
        r11.drawPath(this.mPathFill, r4);
        r11.restoreToCount(r5);
        int r6 = r11.save();
        r11.clipRect(r0, 0.0f, r1, getHeight());
        r11.drawPath(this.mPathFill, this.mPaintFill);
        r11.drawPath(this.mPathStroke, this.mPaintStroke);
        r11.restoreToCount(r6);
        return;
    L11:
        r4 = this.mPaintFill;
        goto L12
    }
}
