package com.android.settings.fuelgauge;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.BatteryStats;
import android.text.TextPaint;
import android.text.format.DateFormat;
import android.text.format.Formatter;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.android.internal.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryHistoryChart extends View {
    static final int CHART_DATA_BIN_MASK = -65536;
    static final int CHART_DATA_BIN_SHIFT = 16;
    static final int CHART_DATA_X_MASK = 65535;
    static final boolean DEBUG = false;
    static final int MONOSPACE = 3;
    static final int NUM_PHONE_SIGNALS = 7;
    static final int SANS = 1;
    static final int SERIF = 2;
    static final String TAG = "BatteryHistoryChart";
    final Path mBatCriticalPath;
    final Path mBatGoodPath;
    int mBatHigh;
    final Path mBatLevelPath;
    int mBatLow;
    final Path mBatWarnPath;
    final Paint mBatteryBackgroundPaint;
    Intent mBatteryBroadcast;
    int mBatteryCriticalLevel;
    final Paint mBatteryCriticalPaint;
    final Paint mBatteryGoodPaint;
    int mBatteryWarnLevel;
    final Paint mBatteryWarnPaint;
    Bitmap mBitmap;
    String mCameraOnLabel;
    int mCameraOnOffset;
    final Paint mCameraOnPaint;
    final Path mCameraOnPath;
    Canvas mCanvas;
    String mChargeDurationString;
    int mChargeDurationStringWidth;
    int mChargeLabelStringWidth;
    String mChargingLabel;
    int mChargingOffset;
    final Paint mChargingPaint;
    final Path mChargingPath;
    int mChartMinHeight;
    String mCpuRunningLabel;
    int mCpuRunningOffset;
    final Paint mCpuRunningPaint;
    final Path mCpuRunningPath;
    final ArrayList<DateLabel> mDateLabels;
    final Paint mDateLinePaint;
    final Path mDateLinePath;
    final Paint mDebugRectPaint;
    String mDrainString;
    int mDrainStringWidth;
    String mDurationString;
    int mDurationStringWidth;
    long mEndDataWallTime;
    long mEndWallTime;
    String mFlashlightOnLabel;
    int mFlashlightOnOffset;
    final Paint mFlashlightOnPaint;
    final Path mFlashlightOnPath;
    String mGpsOnLabel;
    int mGpsOnOffset;
    final Paint mGpsOnPaint;
    final Path mGpsOnPath;
    boolean mHaveCamera;
    boolean mHaveFlashlight;
    boolean mHaveGps;
    boolean mHavePhoneSignal;
    boolean mHaveWifi;
    int mHeaderHeight;
    int mHeaderTextAscent;
    int mHeaderTextDescent;
    final TextPaint mHeaderTextPaint;
    long mHistDataEnd;
    long mHistEnd;
    long mHistStart;
    BatteryInfo mInfo;
    boolean mLargeMode;
    int mLastHeight;
    int mLastWidth;
    int mLevelBottom;
    int mLevelLeft;
    int mLevelOffset;
    int mLevelRight;
    int mLevelTop;
    int mLineWidth;
    String mMaxPercentLabelString;
    int mMaxPercentLabelStringWidth;
    String mMinPercentLabelString;
    int mMinPercentLabelStringWidth;
    int mNumHist;
    final ChartData mPhoneSignalChart;
    String mPhoneSignalLabel;
    int mPhoneSignalOffset;
    String mScreenOnLabel;
    int mScreenOnOffset;
    final Paint mScreenOnPaint;
    final Path mScreenOnPath;
    long mStartWallTime;
    BatteryStats mStats;
    long mStatsPeriod;
    int mTextAscent;
    int mTextDescent;
    final TextPaint mTextPaint;
    int mThinLineWidth;
    final ArrayList<TimeLabel> mTimeLabels;
    final Paint mTimeRemainPaint;
    final Path mTimeRemainPath;
    String mWifiRunningLabel;
    int mWifiRunningOffset;
    final Paint mWifiRunningPaint;
    final Path mWifiRunningPath;

    static class ChartData {
        int[] mColors;
        int mLastBin;
        int mNumTicks;
        Paint[] mPaints;
        int[] mTicks;

        ChartData() {
        }

        void setColors(int[] r4) {
            this.mColors = r4;
            this.mPaints = new Paint[r4.length];
            int r0 = 0;
        L4:
            if (r0 >= r4.length) goto L6;
            this.mPaints[r0] = new Paint();
            this.mPaints[r0].setColor(r4[r0]);
            this.mPaints[r0].setStyle(Paint.Style.FILL);
            r0 = r0 + 1;
            goto L4
        }

        void init(int r1) {
            if (r1 <= 0) goto L4;
            this.mTicks = new int[r1 * 2];
        L5:
            this.mNumTicks = 0;
            this.mLastBin = 0;
            return;
        L4:
            this.mTicks = null;
            goto L5
        }

        void addTick(int r4, int r5) {
            if (r5 == this.mLastBin) goto L8;
            int r0 = this.mNumTicks;
            int[] r1 = this.mTicks;
            if (r0 >= r1.length) goto L9;
            r1[r0] = (r4 & 65535) | (r5 << 16);
            this.mNumTicks = r0 + 1;
            this.mLastBin = r5;
            return;
        L9:
            return;
        }

        void finish(int r2) {
            if (this.mLastBin == 0) goto L6;
            addTick(r2, 0);
            return;
        }

        void draw(Canvas r12, int r13, int r14) {
            int r15 = r14 + r13;
            int r0 = 0;
            int r1 = 0;
            int r2 = 0;
        L4:
            if (r0 >= this.mNumTicks) goto L9;
            int r3 = this.mTicks[r0];
            int r4 = 65535 & r3;
            int r5 = (r3 & (-65536)) >> 16;
            if (r1 == 0) goto L8;
            r12.drawRect(r2, r13, r4, r15, this.mPaints[r1]);
        L8:
            r0 = r0 + 1;
            r1 = r5;
            r2 = r4;
            goto L4
        }
    }

    static class DateLabel {
        final String label;
        final int width;
        final int x;

        DateLabel(TextPaint r1, int r2, Calendar r3, boolean r4) {
            this.x = r2;
            Locale r5 = Locale.getDefault();
            if (r4 == false) goto L5;
            String r6 = "dM";
        L6:
            String r7 = DateFormat.format(DateFormat.getBestDateTimePattern(r5, r6), r3).toString();
            this.label = r7;
            this.width = (int) r1.measureText(r7);
            return;
        L5:
            r6 = android.icu.text.DateFormat.NUM_MONTH_DAY;
            goto L6
        }
    }

    static class TextAttrs {
        int styleIndex;
        ColorStateList textColor;
        int textSize;
        int typefaceIndex;

        TextAttrs() {
            this.textColor = null;
            this.textSize = 15;
            this.typefaceIndex = -1;
            this.styleIndex = -1;
        }

        void retrieve(Context r4, TypedArray r5, int r6) {
            int r7 = r5.getResourceId(r6, -1);
            if (r7 == (-1)) goto L5;
            TypedArray r8 = r4.obtainStyledAttributes(r7, R.styleable.TextAppearance);
        L6:
            if (r8 == null) goto L31;
            int r9 = r8.getIndexCount();
            int r10 = 0;
        L8:
            if (r10 >= r9) goto L23;
            int r1 = r8.getIndex(r10);
            if (r1 != 0) goto L12;
            this.textSize = r8.getDimensionPixelSize(r1, this.textSize);
        L22:
            r10 = r10 + 1;
            goto L8
        L12:
            if (r1 != 1) goto L14;
            this.typefaceIndex = r8.getInt(r1, -1);
            goto L22
        L14:
            if (r1 != 2) goto L16;
            this.styleIndex = r8.getInt(r1, -1);
            goto L22
        L16:
            if (r1 != 3) goto L22;
            this.textColor = r8.getColorStateList(r1);
            goto L22
        L23:
            r8.recycle();
            return;
        L31:
            return;
        L5:
            r8 = null;
            goto L6
        }

        void apply(Context r2, TextPaint r3) {
            r3.density = r2.getResources().getDisplayMetrics().density;
            r3.setCompatibilityScaling(r2.getResources().getCompatibilityInfo().applicationScale);
            r3.setColor(this.textColor.getDefaultColor());
            r3.setTextSize(this.textSize);
            int r4 = this.typefaceIndex;
            if (r4 != 1) goto L5;
            Typeface r5 = Typeface.SANS_SERIF;
        L12:
            setTypeface(r3, r5, this.styleIndex);
            return;
        L5:
            if (r4 != 2) goto L7;
            r5 = Typeface.SERIF;
            goto L12
        L7:
            if (r4 == 3) goto L9;
            r5 = null;
            goto L12
        L9:
            r5 = Typeface.MONOSPACE;
            goto L12
        }

        public void setTypeface(TextPaint r2, Typeface r3, int r4) {
            float r1 = 0.0f;
            boolean r0 = false;
            if (r4 <= 0) goto L18;
            if (r3 != null) goto L6;
            Typeface r5 = Typeface.defaultFromStyle(r4);
        L7:
            r2.setTypeface(r5);
            if (r5 == null) goto L10;
            int r6 = r5.getStyle();
        L11:
            int r7 = (~r6) & r4;
            if ((r7 & 1) == 0) goto L14;
            r0 = true;
        L14:
            r2.setFakeBoldText(r0);
            if ((r7 & 2) == 0) goto L17;
            r1 = -0.25f;
        L17:
            r2.setTextSkewX(r1);
            return;
        L10:
            r6 = 0;
            goto L11
        L6:
            r5 = Typeface.create(r3, r4);
            goto L7
        L18:
            r2.setFakeBoldText(false);
            r2.setTextSkewX(0.0f);
            r2.setTypeface(r3);
        }
    }

    static class TimeLabel {
        final String label;
        final int width;
        final int x;

        TimeLabel(TextPaint r1, int r2, Calendar r3, boolean r4) {
            this.x = r2;
            Locale r5 = Locale.getDefault();
            if (r4 == false) goto L5;
            String r6 = "km";
        L6:
            String r7 = DateFormat.format(DateFormat.getBestDateTimePattern(r5, r6), r3).toString();
            this.label = r7;
            this.width = (int) r1.measureText(r7);
            return;
        L5:
            r6 = "ha";
            goto L6
        }
    }

    private boolean isDayFirst() {
        return false;
    }

    void setStats(BatteryStats r1, Intent r2) {
    }

    public BatteryHistoryChart(Context r19, AttributeSet r20) {
        super(r19, r20);
        Paint r2 = new Paint(1);
        this.mBatteryBackgroundPaint = r2;
        Paint r4 = new Paint(1);
        this.mBatteryGoodPaint = r4;
        Paint r5 = new Paint(1);
        this.mBatteryWarnPaint = r5;
        Paint r6 = new Paint(1);
        this.mBatteryCriticalPaint = r6;
        Paint r7 = new Paint(1);
        this.mTimeRemainPaint = r7;
        Paint r8 = new Paint();
        this.mChargingPaint = r8;
        Paint r9 = new Paint();
        this.mScreenOnPaint = r9;
        Paint r10 = new Paint();
        this.mGpsOnPaint = r10;
        Paint r11 = new Paint();
        this.mFlashlightOnPaint = r11;
        Paint r12 = new Paint();
        this.mCameraOnPaint = r12;
        Paint r13 = new Paint();
        this.mWifiRunningPaint = r13;
        Paint r14 = new Paint();
        this.mCpuRunningPaint = r14;
        this.mDateLinePaint = new Paint();
        ChartData r15 = new ChartData();
        this.mPhoneSignalChart = r15;
        this.mTextPaint = new TextPaint(1);
        this.mHeaderTextPaint = new TextPaint(1);
        Paint r1 = new Paint();
        this.mDebugRectPaint = r1;
        this.mBatLevelPath = new Path();
        this.mBatGoodPath = new Path();
        this.mBatWarnPath = new Path();
        this.mBatCriticalPath = new Path();
        this.mTimeRemainPath = new Path();
        this.mChargingPath = new Path();
        this.mScreenOnPath = new Path();
        this.mGpsOnPath = new Path();
        this.mFlashlightOnPath = new Path();
        this.mCameraOnPath = new Path();
        this.mWifiRunningPath = new Path();
        this.mCpuRunningPath = new Path();
        this.mDateLinePath = new Path();
        this.mLastWidth = -1;
        this.mLastHeight = -1;
        this.mTimeLabels = new ArrayList();
        this.mDateLabels = new ArrayList();
        this.mBatteryWarnLevel = this.mContext.getResources().getInteger(android.R.integer.config_maximumScreenDimDuration);
        this.mBatteryCriticalLevel = this.mContext.getResources().getInteger(android.R.integer.config_defaultAlarmVibrationIntensity);
        this.mThinLineWidth = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        r2.setColor(-16738680);
        r2.setStyle(Paint.Style.FILL);
        r4.setARGB(128, 0, 128, 0);
        r4.setStyle(Paint.Style.STROKE);
        r5.setARGB(128, 128, 128, 0);
        r5.setStyle(Paint.Style.STROKE);
        r6.setARGB(192, 128, 0, 0);
        r6.setStyle(Paint.Style.STROKE);
        r7.setColor(-3221573);
        r7.setStyle(Paint.Style.FILL);
        r8.setStyle(Paint.Style.STROKE);
        r9.setStyle(Paint.Style.STROKE);
        r10.setStyle(Paint.Style.STROKE);
        r12.setStyle(Paint.Style.STROKE);
        r11.setStyle(Paint.Style.STROKE);
        r13.setStyle(Paint.Style.STROKE);
        r14.setStyle(Paint.Style.STROKE);
        r15.setColors(com.android.settings.Utils.BADNESS_COLORS);
        r1.setARGB(255, 255, 0, 0);
        r1.setStyle(Paint.Style.STROKE);
        r9.setColor(-16738680);
        r10.setColor(-16738680);
        r12.setColor(-16738680);
        r11.setColor(-16738680);
        r13.setColor(-16738680);
        r14.setColor(-16738680);
        r8.setColor(-16738680);
        TypedArray r3 = r19.obtainStyledAttributes(r20, com.android.settings.R.styleable.BatteryHistoryChart, 0, 0);
        TextAttrs r16 = new TextAttrs();
        TextAttrs r17 = new TextAttrs();
        r16.retrieve(r19, r3, 0);
        r17.retrieve(r19, r3, 12);
        int r18 = r3.getIndexCount();
        int r21 = 0;
        int r22 = 0;
        float r110 = 0.0f;
        float r111 = 0.0f;
        float r112 = 0.0f;
    L3:
        if (r21 >= r18) goto L19;
        int r113 = r3.getIndex(r21);
        switch(r113) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L18;
        };
    L7:
        this.mChartMinHeight = r3.getDimensionPixelSize(r113, 0);
        goto L18
    L8:
        this.mBatteryBackgroundPaint.setColor(r3.getInt(r113, 0));
        this.mScreenOnPaint.setColor(r3.getInt(r113, 0));
        this.mGpsOnPaint.setColor(r3.getInt(r113, 0));
        this.mCameraOnPaint.setColor(r3.getInt(r113, 0));
        this.mFlashlightOnPaint.setColor(r3.getInt(r113, 0));
        this.mWifiRunningPaint.setColor(r3.getInt(r113, 0));
        this.mCpuRunningPaint.setColor(r3.getInt(r113, 0));
        this.mChargingPaint.setColor(r3.getInt(r113, 0));
        goto L18
    L9:
        this.mTimeRemainPaint.setColor(r3.getInt(r113, 0));
        goto L18
    L10:
        r110 = r3.getFloat(r113, 0.0f);
        goto L18
    L11:
        r112 = r3.getFloat(r113, 0.0f);
        goto L18
    L12:
        r111 = r3.getFloat(r113, 0.0f);
        goto L18
    L13:
        r22 = r3.getInt(r113, 0);
        goto L18
    L14:
        r16.textColor = r3.getColorStateList(r113);
        r17.textColor = r3.getColorStateList(r113);
        goto L18
    L15:
        r16.styleIndex = r3.getInt(r113, r16.styleIndex);
        r17.styleIndex = r3.getInt(r113, r17.styleIndex);
        goto L18
    L16:
        r16.typefaceIndex = r3.getInt(r113, r16.typefaceIndex);
        r17.typefaceIndex = r3.getInt(r113, r17.typefaceIndex);
        goto L18
    L17:
        r16.textSize = r3.getDimensionPixelSize(r113, r16.textSize);
        r17.textSize = r3.getDimensionPixelSize(r113, r17.textSize);
    L18:
        r21 = r21 + 1;
        goto L3
    L19:
        r3.recycle();
        r16.apply(r19, this.mTextPaint);
        r17.apply(r19, this.mHeaderTextPaint);
        this.mDateLinePaint.set(this.mTextPaint);
        this.mDateLinePaint.setStyle(Paint.Style.STROKE);
        int r114 = this.mThinLineWidth / 2;
        if (r114 >= 1) goto L22;
        r114 = 1;
    L22:
        this.mDateLinePaint.setStrokeWidth(r114);
        Paint r23 = this.mDateLinePaint;
        int r24 = this.mThinLineWidth;
        r23.setPathEffect(new DashPathEffect(new float[]{r24 * 2, r24 * 2}, 0.0f));
        if (r22 == 0) goto L39;
        this.mTextPaint.setShadowLayer(r110, r111, r112, r22);
        this.mHeaderTextPaint.setShadowLayer(r110, r111, r112, r22);
        return;
    }

    @Override // android.view.View
    protected void onMeasure(int r3, int r4) {
        this.mMaxPercentLabelStringWidth = (int) this.mTextPaint.measureText(this.mMaxPercentLabelString);
        this.mMinPercentLabelStringWidth = (int) this.mTextPaint.measureText(this.mMinPercentLabelString);
        this.mDrainStringWidth = (int) this.mHeaderTextPaint.measureText(this.mDrainString);
        this.mChargeLabelStringWidth = (int) this.mHeaderTextPaint.measureText(this.mInfo.chargeLabelString);
        this.mChargeDurationStringWidth = (int) this.mHeaderTextPaint.measureText(this.mChargeDurationString);
        this.mTextAscent = (int) this.mTextPaint.ascent();
        this.mTextDescent = (int) this.mTextPaint.descent();
        this.mHeaderTextAscent = (int) this.mHeaderTextPaint.ascent();
        int r0 = (int) this.mHeaderTextPaint.descent();
        this.mHeaderTextDescent = r0;
        this.mHeaderHeight = ((r0 - this.mHeaderTextAscent) * 2) - this.mTextAscent;
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), r3), getDefaultSize(this.mChartMinHeight + this.mHeaderHeight, r4));
    }

    void finishPaths(int r8, int r9, int r10, int r11, int r12, Path r13, int r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, boolean r21, Path r22) {
        if (r13 == null) goto L10;
        if (r14 < 0) goto L9;
        if (r14 >= r8) goto L9;
        if (r22 == null) goto L8;
        r22.lineTo(r8, r12);
    L8:
        r13.lineTo(r8, r12);
    L9:
        r13.lineTo(r8, this.mLevelTop + r10);
        r13.lineTo(r11, this.mLevelTop + r10);
        r13.close();
    L10:
        if (r15 == false) goto L12;
        this.mChargingPath.lineTo(r8, r9 - this.mChargingOffset);
    L12:
        if (r16 == false) goto L14;
        this.mScreenOnPath.lineTo(r8, r9 - this.mScreenOnOffset);
    L14:
        if (r17 == false) goto L16;
        this.mGpsOnPath.lineTo(r8, r9 - this.mGpsOnOffset);
    L16:
        if (r18 == false) goto L18;
        this.mFlashlightOnPath.lineTo(r8, r9 - this.mFlashlightOnOffset);
    L18:
        if (r19 == false) goto L20;
        this.mCameraOnPath.lineTo(r8, r9 - this.mCameraOnOffset);
    L20:
        if (r20 == false) goto L22;
        this.mWifiRunningPath.lineTo(r8, r9 - this.mWifiRunningOffset);
    L22:
        if (r21 == false) goto L25;
        this.mCpuRunningPath.lineTo(r8, r9 - this.mCpuRunningOffset);
    L25:
        if (this.mHavePhoneSignal == false) goto L28;
        this.mPhoneSignalChart.finish(r8);
        return;
    }

    private boolean is24Hour() {
        return DateFormat.is24HourFormat(getContext());
    }

    @Override // android.view.View
    protected void onSizeChanged(int r22, int r23, int r24, int r25) {
        super.onSizeChanged(r22, r23, r24, r25);
        int r0 = this.mLastWidth;
        if (r0 == r22) goto L5;
    L7:
        if (r0 != 0) goto L9;
        return;
    L9:
        if (this.mLastHeight == 0) goto L97;
        this.mLastWidth = r22;
        this.mLastHeight = r23;
        this.mBitmap = null;
        this.mCanvas = null;
        int r1 = this.mTextDescent - this.mTextAscent;
        if (r23 <= ((r1 * 10) + this.mChartMinHeight)) goto L17;
        this.mLargeMode = true;
        if (r23 <= (r1 * 15)) goto L16;
        this.mLineWidth = r1 / 2;
    L19:
        if (this.mLineWidth > 0) goto L21;
        this.mLineWidth = 1;
    L21:
        this.mLevelTop = this.mHeaderHeight;
        int r3 = this.mMaxPercentLabelStringWidth;
        int r4 = this.mThinLineWidth;
        this.mLevelLeft = r3 + (r4 * 3);
        this.mLevelRight = r22;
        this.mTextPaint.setStrokeWidth(r4);
        this.mBatteryGoodPaint.setStrokeWidth(this.mThinLineWidth);
        this.mBatteryWarnPaint.setStrokeWidth(this.mThinLineWidth);
        this.mBatteryCriticalPaint.setStrokeWidth(this.mThinLineWidth);
        this.mChargingPaint.setStrokeWidth(this.mLineWidth);
        this.mScreenOnPaint.setStrokeWidth(this.mLineWidth);
        this.mGpsOnPaint.setStrokeWidth(this.mLineWidth);
        this.mCameraOnPaint.setStrokeWidth(this.mLineWidth);
        this.mFlashlightOnPaint.setStrokeWidth(this.mLineWidth);
        this.mWifiRunningPaint.setStrokeWidth(this.mLineWidth);
        this.mCpuRunningPaint.setStrokeWidth(this.mLineWidth);
        this.mDebugRectPaint.setStrokeWidth(1.0f);
        int r5 = this.mLineWidth;
        int r2 = r1 + r5;
        if (this.mLargeMode == false) goto L46;
        this.mChargingOffset = r5;
        int r6 = r5 + r2;
        this.mScreenOnOffset = r6;
        int r7 = r6 + r2;
        this.mCpuRunningOffset = r7;
        int r8 = r7 + r2;
        this.mWifiRunningOffset = r8;
        if (this.mHaveWifi == false) goto L26;
        int r9 = r2;
    L27:
        int r10 = r8 + r9;
        this.mGpsOnOffset = r10;
        if (this.mHaveGps == false) goto L30;
        int r11 = r2;
    L31:
        int r12 = r10 + r11;
        this.mFlashlightOnOffset = r12;
        if (this.mHaveFlashlight == false) goto L34;
        int r13 = r2;
    L35:
        int r14 = r12 + r13;
        this.mCameraOnOffset = r14;
        if (this.mHaveCamera == false) goto L38;
        int r15 = r2;
    L39:
        int r16 = r14 + r15;
        this.mPhoneSignalOffset = r16;
        boolean r17 = this.mHavePhoneSignal;
        if (r17 == true) goto L43;
        r2 = 0;
    L43:
        this.mLevelOffset = ((r16 + r2) + (r5 * 2)) + (r5 / 2);
        if (r17 == false) goto L49;
        this.mPhoneSignalChart.init(r22);
    L49:
        this.mBatLevelPath.reset();
        this.mBatGoodPath.reset();
        this.mBatWarnPath.reset();
        this.mTimeRemainPath.reset();
        this.mBatCriticalPath.reset();
        this.mScreenOnPath.reset();
        this.mGpsOnPath.reset();
        this.mFlashlightOnPath.reset();
        this.mCameraOnPath.reset();
        this.mWifiRunningPath.reset();
        this.mCpuRunningPath.reset();
        this.mChargingPath.reset();
        this.mTimeLabels.clear();
        this.mDateLabels.clear();
        int r18 = this.mBatLow;
        int r19 = this.mBatHigh - r18;
        int r20 = r23 - this.mLevelOffset;
        int r21 = this.mLevelTop;
        int r26 = r20 - r21;
        this.mLevelBottom = r21 + r26;
        int r27 = this.mLevelLeft;
        int r28 = (r21 + r26) - (((this.mInfo.batteryLevel - r18) * (r26 - 1)) / r19);
        byte r29 = (byte) this.mInfo.batteryLevel;
        if (r29 > this.mBatteryCriticalLevel) goto L53;
        Path r30 = this.mBatCriticalPath;
    L56:
        if (r30 == null) goto L58;
        r30.moveTo(r27, r28);
        Path r210 = r30;
    L59:
        this.mBatLevelPath.moveTo(r27, r28);
        finishPaths(r22, r23, r26, r27, r28, this.mBatLevelPath, r27, false, false, false, false, false, false, false, r210);
        long r31 = this.mStartWallTime;
        if (r31 <= 0) goto L91;
        if (this.mEndWallTime <= r31) goto L91;
        boolean r32 = is24Hour();
        Calendar r33 = Calendar.getInstance();
        r33.setTimeInMillis(this.mStartWallTime);
        r33.set(14, 0);
        r33.set(13, 0);
        r33.set(12, 0);
        long r34 = r33.getTimeInMillis();
        if (r34 >= this.mStartWallTime) goto L66;
        int r35 = 1;
        r33.set(11, r33.get(11) + 1);
        r34 = r33.getTimeInMillis();
    L67:
        Calendar r110 = Calendar.getInstance();
        r110.setTimeInMillis(this.mEndWallTime);
        r110.set(14, 0);
        r110.set(13, 0);
        r110.set(12, 0);
        long r111 = r110.getTimeInMillis();
        if (r34 >= r111) goto L76;
        addTimeLabel(r33, this.mLevelLeft, this.mLevelRight, r32);
        Calendar r112 = Calendar.getInstance();
        long r211 = r34;
        long r36 = this.mStartWallTime;
        r112.setTimeInMillis(r36 + ((this.mEndWallTime - r36) / 2));
        r112.set(14, 0);
        r112.set(13, 0);
        r112.set(12, 0);
        long r37 = r112.getTimeInMillis();
        if (r37 > r211) goto L72;
    L74:
        addTimeLabel(r110, this.mLevelLeft, this.mLevelRight, r32);
        goto L76
    L72:
        if (r37 >= r111) goto L74;
        addTimeLabel(r112, this.mLevelLeft, this.mLevelRight, r32);
    L76:
        if (r33.get(6) == r110.get(6)) goto L78;
    L79:
        boolean r38 = isDayFirst();
        r33.set(11, 0);
        long r39 = r33.getTimeInMillis();
        if (r39 >= this.mStartWallTime) goto L82;
        r33.set(6, r33.get(6) + r35);
        r39 = r33.getTimeInMillis();
    L82:
        r110.set(11, 0);
        long r40 = r110.getTimeInMillis();
        if (r39 >= r40) goto L89;
        addDateLabel(r33, this.mLevelLeft, this.mLevelRight, r38);
        Calendar r41 = Calendar.getInstance();
        r41.setTimeInMillis((((r40 - r39) / 2) + r39) + 7200000);
        r41.set(11, 0);
        r41.set(12, 0);
        long r42 = r41.getTimeInMillis();
        if (r42 <= r39) goto L89;
        if (r42 >= r40) goto L89;
        addDateLabel(r41, this.mLevelLeft, this.mLevelRight, r38);
    L89:
        addDateLabel(r110, this.mLevelLeft, this.mLevelRight, r38);
        goto L91
    L78:
        if (r33.get(r35) == r110.get(r35)) goto L91;
    L66:
        r35 = 1;
    L91:
        if (this.mTimeLabels.size() >= 2) goto L93;
        String r43 = Formatter.formatShortElapsedTime(getContext(), this.mEndWallTime - this.mStartWallTime);
        this.mDurationString = r43;
        this.mDurationStringWidth = (int) this.mTextPaint.measureText(r43);
        return;
    L93:
        this.mDurationString = null;
        this.mDurationStringWidth = 0;
        return;
    L58:
        r210 = null;
        goto L59
    L53:
        if (r29 > this.mBatteryWarnLevel) goto L55;
        r30 = this.mBatWarnPath;
        goto L56
    L55:
        r30 = null;
        goto L56
    L38:
        r15 = 0;
        goto L39
    L34:
        r13 = 0;
        goto L35
    L30:
        r11 = 0;
        goto L31
    L26:
        r9 = 0;
        goto L27
    L46:
        this.mPhoneSignalOffset = 0;
        this.mChargingOffset = 0;
        this.mCpuRunningOffset = 0;
        this.mWifiRunningOffset = 0;
        this.mFlashlightOnOffset = 0;
        this.mCameraOnOffset = 0;
        this.mGpsOnOffset = 0;
        this.mScreenOnOffset = 0;
        this.mLevelOffset = r2 + (this.mThinLineWidth * 4);
        if (this.mHavePhoneSignal == false) goto L49;
        this.mPhoneSignalChart.init(0);
        goto L49
    L16:
        this.mLineWidth = r1 / 3;
        goto L19
    L17:
        this.mLargeMode = false;
        this.mLineWidth = this.mThinLineWidth;
        goto L19
    L97:
        return;
    L5:
        if (this.mLastHeight != r23) goto L7;
    }

    void addTimeLabel(Calendar r9, int r10, int r11, boolean r12) {
        long r0 = this.mStartWallTime;
        long r2 = this.mEndWallTime - r0;
        this.mTimeLabels.add(new TimeLabel(this.mTextPaint, r10 + ((int) (((r9.getTimeInMillis() - r0) * ((long) (r11 - r10))) / r2)), r9, r12));
    }

    void addDateLabel(Calendar r9, int r10, int r11, boolean r12) {
        long r0 = this.mStartWallTime;
        long r2 = this.mEndWallTime - r0;
        this.mDateLabels.add(new DateLabel(this.mTextPaint, r10 + ((int) (((r9.getTimeInMillis() - r0) * ((long) (r11 - r10))) / r2)), r9, r12));
    }

    @Override // android.view.View
    protected void onDraw(Canvas r3) {
        super.onDraw(r3);
        drawChart(r3, getWidth(), getHeight());
    }

    void buildBitmap(int r3, int r4) {
        Bitmap r0 = this.mBitmap;
        if (r0 != null) goto L5;
    L9:
        this.mBitmap = Bitmap.createBitmap(getResources().getDisplayMetrics(), r3, r4, Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(this.mBitmap);
        this.mCanvas = r1;
        drawChart(r1, r3, r4);
        return;
    L5:
        if (r3 != r0.getWidth()) goto L9;
        if (r4 != this.mBitmap.getHeight()) goto L9;
    }

    void drawChart(Canvas r21, int r22, int r23) {
        boolean r9 = isLayoutRtl();
        if (r9 == false) goto L5;
        int r11 = r22;
    L6:
        if (r9 == false) goto L8;
        int r12 = 0;
    L9:
        if (r9 == false) goto L11;
        Paint.Align r1 = Paint.Align.RIGHT;
    L12:
        Paint.Align r13 = r1;
        if (r9 == false) goto L15;
        Paint.Align r2 = Paint.Align.LEFT;
    L16:
        Paint.Align r14 = r2;
        r21.drawPath(this.mBatLevelPath, this.mBatteryBackgroundPaint);
        if (this.mTimeRemainPath.isEmpty() == true) goto L20;
        r21.drawPath(this.mTimeRemainPath, this.mTimeRemainPaint);
    L20:
        if (this.mTimeLabels.size() <= 1) goto L46;
        int r3 = this.mLevelBottom;
        int r4 = r3 - this.mTextAscent;
        int r5 = this.mThinLineWidth;
        int r6 = r4 + (r5 * 4);
        int r7 = (r3 + r5) + (r5 / 2);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        int r8 = 0;
        int r16 = 0;
    L23:
        if (r8 >= this.mTimeLabels.size()) goto L45;
        TimeLabel r10 = this.mTimeLabels.get(r8);
        if (r8 != 0) goto L31;
        int r15 = r10.x - (r10.width / 2);
        if (r15 >= 0) goto L29;
        int r17 = 0;
    L30:
        r21.drawText(r10.label, r17, r6, this.mTextPaint);
        int r19 = r12;
        int r18 = r8;
        int r110 = r7;
        Paint.Align r111 = r14;
        int r112 = r6;
        r21.drawLine(r10.x, r7, r10.x, this.mThinLineWidth + r7, this.mTextPaint);
        r16 = r17 + r10.width;
    L44:
        r8 = r18 + 1;
        r6 = r112;
        r7 = r110;
        r14 = r111;
        r12 = r19;
        goto L23
    L29:
        r17 = r15;
        goto L30
    L31:
        r18 = r8;
        r110 = r7;
        r19 = r12;
        r111 = r14;
        r112 = r6;
        if (r18 >= (this.mTimeLabels.size() - 1)) goto L40;
        int r20 = r10.x - (r10.width / 2);
        if (r20 < (r16 + this.mTextAscent)) goto L44;
        if (r20 > ((r22 - this.mTimeLabels.get(r18 + 1).width) - this.mTextAscent)) goto L44;
        r21.drawText(r10.label, r20, r112, this.mTextPaint);
        r21.drawLine(r10.x, r110, r10.x, r110 + this.mThinLineWidth, this.mTextPaint);
        r16 = r20 + r10.width;
        goto L44
    L40:
        int r24 = r10.x - (r10.width / 2);
        if ((r10.width + r24) < r22) goto L43;
        r24 = (r22 - 1) - r10.width;
    L43:
        r21.drawText(r10.label, r24, r112, this.mTextPaint);
        r21.drawLine(r10.x, r110, r10.x, r110 + this.mThinLineWidth, this.mTextPaint);
        goto L44
    L45:
        int r113 = r12;
        Paint.Align r114 = r14;
    L49:
        int r25 = this.mHeaderTextAscent;
        int r26 = (-r25) + ((this.mHeaderTextDescent - r25) / 3);
        this.mHeaderTextPaint.setTextAlign(r13);
        float r27 = r11;
        float r28 = r26;
        r21.drawText(this.mInfo.chargeLabelString, r27, r28, this.mHeaderTextPaint);
        int r29 = this.mChargeDurationStringWidth;
        int r30 = r29 / 2;
        if (r9 == false) goto L52;
        r30 = -r30;
    L52:
        int r31 = this.mDrainStringWidth;
        int r32 = ((r22 - r29) - r31) / 2;
        if (r9 == true) goto L56;
        r31 = this.mChargeLabelStringWidth;
    L56:
        r21.drawText(this.mChargeDurationString, (r32 + r31) - r30, r28, this.mHeaderTextPaint);
        this.mHeaderTextPaint.setTextAlign(r114);
        r21.drawText(this.mDrainString, r113, r28, this.mHeaderTextPaint);
        if (this.mBatGoodPath.isEmpty() == true) goto L60;
        r21.drawPath(this.mBatGoodPath, this.mBatteryGoodPaint);
    L60:
        if (this.mBatWarnPath.isEmpty() == true) goto L63;
        r21.drawPath(this.mBatWarnPath, this.mBatteryWarnPaint);
    L63:
        if (this.mBatCriticalPath.isEmpty() == true) goto L66;
        r21.drawPath(this.mBatCriticalPath, this.mBatteryCriticalPaint);
    L66:
        if (this.mHavePhoneSignal == false) goto L69;
        int r33 = r23 - this.mPhoneSignalOffset;
        int r34 = this.mLineWidth;
        this.mPhoneSignalChart.draw(r21, r33 - (r34 / 2), r34);
    L69:
        if (this.mScreenOnPath.isEmpty() == true) goto L72;
        r21.drawPath(this.mScreenOnPath, this.mScreenOnPaint);
    L72:
        if (this.mChargingPath.isEmpty() == true) goto L75;
        r21.drawPath(this.mChargingPath, this.mChargingPaint);
    L75:
        if (this.mHaveGps == false) goto L80;
        if (this.mGpsOnPath.isEmpty() == true) goto L80;
        r21.drawPath(this.mGpsOnPath, this.mGpsOnPaint);
    L80:
        if (this.mHaveFlashlight == false) goto L85;
        if (this.mFlashlightOnPath.isEmpty() == true) goto L85;
        r21.drawPath(this.mFlashlightOnPath, this.mFlashlightOnPaint);
    L85:
        if (this.mHaveCamera == false) goto L90;
        if (this.mCameraOnPath.isEmpty() == true) goto L90;
        r21.drawPath(this.mCameraOnPath, this.mCameraOnPaint);
    L90:
        if (this.mHaveWifi == false) goto L95;
        if (this.mWifiRunningPath.isEmpty() == true) goto L95;
        r21.drawPath(this.mWifiRunningPath, this.mWifiRunningPaint);
    L95:
        if (this.mCpuRunningPath.isEmpty() == true) goto L98;
        r21.drawPath(this.mCpuRunningPath, this.mCpuRunningPaint);
    L98:
        if (this.mLargeMode == false) goto L115;
        Paint.Align r35 = this.mTextPaint.getTextAlign();
        this.mTextPaint.setTextAlign(r13);
        if (this.mHavePhoneSignal == false) goto L103;
        r21.drawText(this.mPhoneSignalLabel, r27, (r23 - this.mPhoneSignalOffset) - this.mTextDescent, this.mTextPaint);
    L103:
        if (this.mHaveGps == false) goto L106;
        r21.drawText(this.mGpsOnLabel, r27, (r23 - this.mGpsOnOffset) - this.mTextDescent, this.mTextPaint);
    L106:
        if (this.mHaveFlashlight == false) goto L109;
        r21.drawText(this.mFlashlightOnLabel, r27, (r23 - this.mFlashlightOnOffset) - this.mTextDescent, this.mTextPaint);
    L109:
        if (this.mHaveCamera == false) goto L112;
        r21.drawText(this.mCameraOnLabel, r27, (r23 - this.mCameraOnOffset) - this.mTextDescent, this.mTextPaint);
    L112:
        if (this.mHaveWifi == false) goto L114;
        r21.drawText(this.mWifiRunningLabel, r27, (r23 - this.mWifiRunningOffset) - this.mTextDescent, this.mTextPaint);
    L114:
        r21.drawText(this.mCpuRunningLabel, r27, (r23 - this.mCpuRunningOffset) - this.mTextDescent, this.mTextPaint);
        r21.drawText(this.mChargingLabel, r27, (r23 - this.mChargingOffset) - this.mTextDescent, this.mTextPaint);
        r21.drawText(this.mScreenOnLabel, r27, (r23 - this.mScreenOnOffset) - this.mTextDescent, this.mTextPaint);
        this.mTextPaint.setTextAlign(r35);
    L115:
        int r36 = this.mLevelLeft;
        int r37 = this.mThinLineWidth;
        r21.drawLine(r36 - r37, this.mLevelTop, r36 - r37, this.mLevelBottom + (r37 / 2), this.mTextPaint);
        if (this.mLargeMode == false) goto L121;
        int r115 = 0;
    L119:
        if (r115 >= 10) goto L121;
        int r38 = this.mLevelTop;
        int r39 = this.mThinLineWidth;
        int r40 = ((r39 / 2) + r38) + (((this.mLevelBottom - r38) * r115) / 10);
        int r41 = this.mLevelLeft;
        float r42 = r40;
        r21.drawLine((r41 - (r39 * 2)) - (r39 / 2), r42, (r41 - r39) - (r39 / 2), r42, this.mTextPaint);
        r115 = r115 + 1;
    L121:
        r21.drawText(this.mMaxPercentLabelString, 0.0f, this.mLevelTop, this.mTextPaint);
        r21.drawText(this.mMinPercentLabelString, this.mMaxPercentLabelStringWidth - this.mMinPercentLabelStringWidth, this.mLevelBottom - this.mThinLineWidth, this.mTextPaint);
        float r43 = this.mLevelLeft / 2;
        int r44 = this.mLevelBottom;
        int r45 = this.mThinLineWidth;
        r21.drawLine(r43, r44 + r45, r22, r44 + r45, this.mTextPaint);
        if (this.mDateLabels.size() <= 0) goto L135;
        int r46 = this.mLevelTop + this.mTextAscent;
        int r47 = this.mLevelBottom;
        int r48 = this.mLevelRight;
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        int r49 = this.mDateLabels.size() - 1;
    L124:
        if (r49 < 0) goto L147;
        DateLabel r50 = this.mDateLabels.get(r49);
        int r51 = r50.x - this.mThinLineWidth;
        int r52 = r50.x + (this.mThinLineWidth * 2);
        if ((r50.width + r52) < r48) goto L131;
        r52 = (r50.x - (this.mThinLineWidth * 2)) - r50.width;
        r51 = r52 - this.mThinLineWidth;
        if (r51 < r48) goto L131;
    L134:
        r49 = r49 - 1;
    L131:
        if (r51 < this.mLevelLeft) goto L134;
        this.mDateLinePath.reset();
        this.mDateLinePath.moveTo(r50.x, r46);
        this.mDateLinePath.lineTo(r50.x, r47);
        r21.drawPath(this.mDateLinePath, this.mDateLinePaint);
        r21.drawText(r50.label, r52, r46 - this.mTextAscent, this.mTextPaint);
        goto L134
    L147:
        return;
    L135:
        return;
    L46:
        r113 = r12;
        r114 = r14;
        if (this.mDurationString == null) goto L49;
        int r53 = (this.mLevelBottom - this.mTextAscent) + (this.mThinLineWidth * 4);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        String r54 = this.mDurationString;
        int r55 = this.mLevelLeft;
        r21.drawText(r54, (r55 + ((this.mLevelRight - r55) / 2)) - (this.mDurationStringWidth / 2), r53, this.mTextPaint);
        goto L49
    L15:
        r2 = Paint.Align.RIGHT;
        goto L16
    L11:
        r1 = Paint.Align.LEFT;
        goto L12
    L8:
        r12 = r22;
        goto L9
    L5:
        r11 = 0;
        goto L6
    }
}
