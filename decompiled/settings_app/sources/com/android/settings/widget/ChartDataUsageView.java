package com.android.settings.widget;

import android.content.Context;
import android.content.res.Resources;
import android.net.NetworkPolicy;
import android.net.NetworkStatsHistory;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.android.settings.R;
import com.obric.olog.OLog;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ChartDataUsageView extends ChartView {
    private static final long DELAY_MILLIS = 250;
    private static final int MSG_UPDATE_AXIS = 100;
    private static final String TAG = "DataUsage";
    private ChartNetworkSeriesView mDetailSeries;
    private ChartGridView mGrid;
    private Handler mHandler;
    private NetworkStatsHistory mHistory;
    private ChartSweepView.OnSweepListener mHorizListener;
    private long mInspectEnd;
    private long mInspectStart;
    private DataUsageChartListener mListener;
    private ChartNetworkSeriesView mSeries;
    private ChartSweepView mSweepLeft;
    private ChartSweepView mSweepLimit;
    private ChartSweepView mSweepRight;
    private ChartSweepView mSweepWarning;
    private ChartSweepView.OnSweepListener mVertListener;
    private long mVertMax;

    public static class DataAxis implements ChartAxis {
        private static final boolean LOG_SCALE = false;
        private static final Object sSpanSize = null;
        private static final Object sSpanUnit = null;
        private long mMax;
        private long mMin;
        private float mSize;

        public DataAxis() {
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Long.valueOf(this.mMin), Long.valueOf(this.mMax), Float.valueOf(this.mSize)});
        }

        @Override // com.android.settings.widget.ChartAxis
        public boolean setBounds(long r3, long r5) {
            if (this.mMin == r3) goto L5;
        L9:
            this.mMin = r3;
            this.mMax = r5;
            return true;
        L5:
            if (this.mMax != r5) goto L9;
            return false;
        }

        @Override // com.android.settings.widget.ChartAxis
        public boolean setSize(float r2) {
            if (this.mSize == r2) goto L6;
            this.mSize = r2;
            return true;
        L6:
            return false;
        }

        @Override // com.android.settings.widget.ChartAxis
        public float convertToPoint(long r4) {
            float r0 = this.mSize;
            long r1 = this.mMin;
            return (r0 * (r4 - r1)) / (this.mMax - r1);
        }

        @Override // com.android.settings.widget.ChartAxis
        public long convertToValue(float r6) {
            long r0 = this.mMin;
            return (long) (r0 + ((r6 * (this.mMax - r0)) / this.mSize));
        }

        static {
            sSpanSize = new Object();
            sSpanUnit = new Object();
        }

        @Override // com.android.settings.widget.ChartAxis
        public long buildLabel(Resources r1, SpannableStringBuilder r2, long r3) {
            Formatter.BytesResult r0 = Formatter.formatBytes(r1, r3, 3);
            ChartDataUsageView.access$800(r2, sSpanSize, r0.value, "^1");
            ChartDataUsageView.access$800(r2, sSpanUnit, r0.units, "^2");
            return r0.roundedBytes;
        }

        @Override // com.android.settings.widget.ChartAxis
        public float[] getTickPoints() {
            long r0 = this.mMax - this.mMin;
            long r2 = ChartDataUsageView.access$900(r0 / 16);
            int r1 = (int) (r0 / r2);
            float[] r3 = new float[r1];
            long r4 = this.mMin;
            int r6 = 0;
        L3:
            if (r6 >= r1) goto L5;
            r3[r6] = convertToPoint(r4);
            r4 = r4 + r2;
            r6 = r6 + 1;
            goto L3
        L5:
            return r3;
        }

        @Override // com.android.settings.widget.ChartAxis
        public int shouldAdjustAxis(long r5) {
            double r6 = convertToPoint(r5);
            float r4 = this.mSize;
            if (r6 >= (((double) r4) * 0.1d)) goto L7;
            return -1;
        L7:
            if (r6 <= (((double) r4) * 0.85d)) goto L10;
            return 1;
        L10:
            return 0;
        }
    }

    public interface DataUsageChartListener {
        void onInspectRangeChanged();

        void onLimitChanged();

        void onWarningChanged();

        void requestLimitEdit();

        void requestWarningEdit();
    }

    public static class TimeAxis implements ChartAxis {
        private static final int FIRST_DAY_OF_WEEK = 0;
        private long mMax;
        private long mMin;
        private float mSize;

        @Override // com.android.settings.widget.ChartAxis
        public int shouldAdjustAxis(long r1) {
            return 0;
        }

        static {
            FIRST_DAY_OF_WEEK = Calendar.getInstance().getFirstDayOfWeek() - 1;
        }

        public TimeAxis() {
            long r0 = System.currentTimeMillis();
            setBounds(r0 - 2592000000L, r0);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Long.valueOf(this.mMin), Long.valueOf(this.mMax), Float.valueOf(this.mSize)});
        }

        @Override // com.android.settings.widget.ChartAxis
        public boolean setBounds(long r3, long r5) {
            if (this.mMin == r3) goto L5;
        L9:
            this.mMin = r3;
            this.mMax = r5;
            return true;
        L5:
            if (this.mMax != r5) goto L9;
            return false;
        }

        @Override // com.android.settings.widget.ChartAxis
        public boolean setSize(float r2) {
            if (this.mSize == r2) goto L6;
            this.mSize = r2;
            return true;
        L6:
            return false;
        }

        @Override // com.android.settings.widget.ChartAxis
        public float convertToPoint(long r4) {
            float r0 = this.mSize;
            long r1 = this.mMin;
            return (r0 * (r4 - r1)) / (this.mMax - r1);
        }

        @Override // com.android.settings.widget.ChartAxis
        public long convertToValue(float r6) {
            long r0 = this.mMin;
            return (long) (r0 + ((r6 * (this.mMax - r0)) / this.mSize));
        }

        @Override // com.android.settings.widget.ChartAxis
        public long buildLabel(Resources r2, SpannableStringBuilder r3, long r4) {
            r3.replace(0, r3.length(), Long.toString(r4));
            return r4;
        }

        @Override // com.android.settings.widget.ChartAxis
        public float[] getTickPoints() {
            float[] r0 = new float[32];
            Time r1 = new Time();
            r1.set(this.mMax);
            r1.monthDay -= r1.weekDay - FIRST_DAY_OF_WEEK;
            int r2 = 0;
            r1.second = 0;
            r1.minute = 0;
            r1.hour = 0;
            r1.normalize(true);
            long r4 = r1.toMillis(true);
        L4:
            if (r4 <= this.mMin) goto L10;
            if (r4 > this.mMax) goto L8;
            r0[r2] = convertToPoint(r4);
            r2 = r2 + 1;
        L8:
            r1.monthDay -= 7;
            r1.normalize(true);
            r4 = r1.toMillis(true);
            goto L4
        L10:
            return Arrays.copyOf(r0, r2);
        }
    }

    private static long roundUpToPowerOfTwo(long r4) {
        long r5 = r4 - 1;
        long r6 = r5 | (r5 >>> 1);
        long r7 = r6 | (r6 >>> 2);
        long r8 = r7 | (r7 >>> 4);
        long r9 = r8 | (r8 >>> 8);
        long r10 = r9 | (r9 >>> 16);
        long r11 = (r10 | (r10 >>> 32)) + 1;
        if (r11 > 0) goto L7;
        return Long.MAX_VALUE;
    L7:
        return r11;
    }

    static /* synthetic */ void access$000(ChartDataUsageView r0, ChartSweepView r1) {
        r0.updateVertAxisBounds(r1);
    }

    static /* synthetic */ void access$100(ChartDataUsageView r0) {
        r0.updateEstimateVisible();
    }

    static /* synthetic */ void access$200(ChartDataUsageView r0, ChartSweepView r1, boolean r2) {
        r0.sendUpdateAxisDelayed(r1, r2);
    }

    static /* synthetic */ void access$300(ChartDataUsageView r0) {
        r0.updatePrimaryRange();
    }

    static /* synthetic */ DataUsageChartListener access$400(ChartDataUsageView r0) {
        return r0.mListener;
    }

    static /* synthetic */ void access$500(ChartDataUsageView r0, ChartSweepView r1) {
        r0.clearUpdateAxisDelayed(r1);
    }

    static /* synthetic */ ChartSweepView access$600(ChartDataUsageView r0) {
        return r0.mSweepWarning;
    }

    static /* synthetic */ ChartSweepView access$700(ChartDataUsageView r0) {
        return r0.mSweepLimit;
    }

    static /* synthetic */ void access$800(SpannableStringBuilder r0, Object r1, CharSequence r2, String r3) {
        setText(r0, r1, r2, r3);
    }

    static /* synthetic */ long access$900(long r0) {
        return roundUpToPowerOfTwo(r0);
    }

    public ChartDataUsageView(Context r3) {
        this(r3, null, 0);
    }

    public ChartDataUsageView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ChartDataUsageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mHorizListener = new AnonymousClass2(this);
        this.mVertListener = new AnonymousClass3(this);
        init(new TimeAxis(), new InvertedChartAxis(new DataAxis()));
        this.mHandler = new AnonymousClass1(this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mGrid = (ChartGridView) findViewById(R.id.grid);
        this.mSeries = (ChartNetworkSeriesView) findViewById(R.id.series);
        ChartNetworkSeriesView r0 = (ChartNetworkSeriesView) findViewById(R.id.detail_series);
        this.mDetailSeries = r0;
        r0.setVisibility(8);
        ChartSweepView r1 = (ChartSweepView) findViewById(R.id.sweep_left);
        this.mSweepLeft = r1;
        r1.setVisibility(8);
        ChartSweepView r2 = (ChartSweepView) findViewById(R.id.sweep_right);
        this.mSweepRight = r2;
        r2.setVisibility(8);
        this.mSweepLimit = (ChartSweepView) findViewById(R.id.sweep_limit);
        this.mSweepWarning = (ChartSweepView) findViewById(R.id.sweep_warning);
        this.mSweepLeft.setValidRangeDynamic(null, this.mSweepRight);
        this.mSweepRight.setValidRangeDynamic(this.mSweepLeft, null);
        this.mSweepWarning.setValidRangeDynamic(null, this.mSweepLimit);
        this.mSweepLimit.setValidRangeDynamic(this.mSweepWarning, null);
        this.mSweepLeft.setNeighbors(new ChartSweepView[]{this.mSweepRight});
        this.mSweepRight.setNeighbors(new ChartSweepView[]{this.mSweepLeft});
        this.mSweepLimit.setNeighbors(new ChartSweepView[]{this.mSweepWarning, this.mSweepLeft, this.mSweepRight});
        this.mSweepWarning.setNeighbors(new ChartSweepView[]{this.mSweepLimit, this.mSweepLeft, this.mSweepRight});
        this.mSweepLeft.addOnSweepListener(this.mHorizListener);
        this.mSweepRight.addOnSweepListener(this.mHorizListener);
        this.mSweepWarning.addOnSweepListener(this.mVertListener);
        this.mSweepLimit.addOnSweepListener(this.mVertListener);
        this.mSweepLeft.setClickable(false);
        this.mSweepLeft.setFocusable(false);
        this.mSweepRight.setClickable(false);
        this.mSweepRight.setFocusable(false);
        this.mSweepWarning.setDragInterval(5242880);
        this.mSweepLimit.setDragInterval(5242880);
        this.mGrid.init(this.mHoriz, this.mVert);
        this.mSeries.init(this.mHoriz, this.mVert);
        this.mDetailSeries.init(this.mHoriz, this.mVert);
        this.mSweepLeft.init(this.mHoriz);
        this.mSweepRight.init(this.mHoriz);
        this.mSweepWarning.init(this.mVert);
        this.mSweepLimit.init(this.mVert);
        setActivated(false);
    }

    public void setListener(DataUsageChartListener r1) {
        this.mListener = r1;
    }

    public void bindNetworkStats(NetworkStatsHistory r2) {
        this.mSeries.bindNetworkStats(r2);
        this.mHistory = r2;
        updateVertAxisBounds(null);
        updateEstimateVisible();
        updatePrimaryRange();
        requestLayout();
    }

    public void bindDetailNetworkStats(NetworkStatsHistory r4) {
        this.mDetailSeries.bindNetworkStats(r4);
        ChartNetworkSeriesView r0 = this.mDetailSeries;
        if (r4 == null) goto L5;
        int r5 = 0;
    L6:
        r0.setVisibility(r5);
        NetworkStatsHistory r6 = this.mHistory;
        if (r6 == null) goto L9;
        this.mDetailSeries.setEndTime(r6.getEnd());
    L9:
        updateVertAxisBounds(null);
        updateEstimateVisible();
        updatePrimaryRange();
        requestLayout();
        return;
    L5:
        r5 = 8;
        goto L6
    }

    public void bindNetworkPolicy(NetworkPolicy r8) {
        if (r8 != null) goto L7;
        this.mSweepLimit.setVisibility(4);
        this.mSweepLimit.setValue(-1);
        this.mSweepWarning.setVisibility(4);
        this.mSweepWarning.setValue(-1);
        return;
    L7:
        if (r8.limitBytes == (-1)) goto L9;
        this.mSweepLimit.setVisibility(0);
        this.mSweepLimit.setEnabled(true);
        this.mSweepLimit.setValue(r8.limitBytes);
    L11:
        if (r8.warningBytes == (-1)) goto L13;
        this.mSweepWarning.setVisibility(0);
        this.mSweepWarning.setValue(r8.warningBytes);
    L14:
        updateVertAxisBounds(null);
        requestLayout();
        invalidate();
        return;
    L13:
        this.mSweepWarning.setVisibility(4);
        this.mSweepWarning.setValue(-1);
        goto L14
    L9:
        this.mSweepLimit.setVisibility(4);
        this.mSweepLimit.setEnabled(false);
        this.mSweepLimit.setValue(-1);
        goto L11
    }

    private void updateVertAxisBounds(ChartSweepView r13) {
        long r0 = this.mVertMax;
        if (r13 == null) goto L9;
        int r6 = r13.shouldAdjustAxis();
        if (r6 <= 0) goto L7;
        r0 = (r0 * 11) / 10;
    L10:
        long r1 = Math.max(Math.max((Math.max(Math.max(this.mSeries.getMaxVisible(), this.mDetailSeries.getMaxVisible()), Math.max(this.mSweepWarning.getValue(), this.mSweepLimit.getValue())) * 12) / 10, 52428800), r0);
        if (r1 == this.mVertMax) goto L25;
        this.mVertMax = r1;
        boolean r2 = this.mVert.setBounds(0, r1);
        this.mSweepWarning.setValidRange(0, r1);
        this.mSweepLimit.setValidRange(0, r1);
        if (r2 == false) goto L15;
        this.mSeries.invalidatePath();
        this.mDetailSeries.invalidatePath();
    L15:
        this.mGrid.invalidate();
        if (r13 == null) goto L18;
        r13.updateValueFromPosition();
    L18:
        ChartSweepView r3 = this.mSweepLimit;
        if (r3 == r13) goto L21;
        layoutSweep(r3);
    L21:
        ChartSweepView r4 = this.mSweepWarning;
        if (r4 == r13) goto L26;
        layoutSweep(r4);
        return;
    L26:
        return;
    L25:
        return;
    L7:
        if (r6 >= 0) goto L10;
        r0 = (r0 * 9) / 10;
        goto L10
    L9:
        r0 = 0;
        goto L10
    }

    private void updateEstimateVisible() {
        long r0 = this.mSeries.getMaxEstimate();
        long r3 = Long.MAX_VALUE;
        if (this.mSweepWarning.isEnabled() == false) goto L6;
        long r5 = this.mSweepWarning.getValue();
    L10:
        if (r5 < 0) goto L14;
        r3 = r5;
    L14:
        if (r0 < ((r3 * 7) / 10)) goto L16;
        boolean r1 = true;
    L17:
        this.mSeries.setEstimateVisible(r1);
        return;
    L16:
        r1 = false;
        goto L17
    L6:
        if (this.mSweepLimit.isEnabled() == false) goto L8;
        r5 = this.mSweepLimit.getValue();
        goto L10
    L8:
        r5 = Long.MAX_VALUE;
        goto L10
    }

    private void sendUpdateAxisDelayed(ChartSweepView r3, boolean r4) {
        if (r4 == false) goto L5;
    L6:
        Handler r2 = this.mHandler;
        r2.sendMessageDelayed(r2.obtainMessage(100, r3), DELAY_MILLIS);
        return;
    L5:
        if (this.mHandler.hasMessages(100, r3) == false) goto L6;
    }

    private void clearUpdateAxisDelayed(ChartSweepView r2) {
        this.mHandler.removeMessages(100, r2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        if (isActivated() == false) goto L5;
        return false;
    L5:
        int r4 = r3.getAction();
        if (r4 == 0) goto L10;
        if (r4 == 1) goto L9;
        return false;
    L9:
        setActivated(true);
    L10:
        return true;
    }

    public long getInspectStart() {
        return this.mInspectStart;
    }

    public long getInspectEnd() {
        return this.mInspectEnd;
    }

    public long getInspectLeft() {
        return this.mSweepLeft.getValue();
    }

    public long getInspectRight() {
        return this.mSweepRight.getValue();
    }

    public long getWarningBytes() {
        return this.mSweepWarning.getLabelValue();
    }

    public long getLimitBytes() {
        return this.mSweepLimit.getLabelValue();
    }

    private long getHistoryStart() {
        NetworkStatsHistory r2 = this.mHistory;
        if (r2 != null) goto L7;
        return Long.MAX_VALUE;
    L7:
        return r2.getStart();
    }

    private long getHistoryEnd() {
        NetworkStatsHistory r2 = this.mHistory;
        if (r2 != null) goto L7;
        return Long.MIN_VALUE;
    L7:
        return r2.getEnd();
    }

    public void setVisibleRange(long r8, long r10, long r12, long r14) {
        boolean r0 = this.mHoriz.setBounds(r8, r10);
        this.mGrid.setBounds(r8, r10);
        this.mSeries.setBounds(r8, r10);
        this.mDetailSeries.setBounds(r8, r10);
        this.mInspectStart = r8;
        this.mInspectEnd = r10;
        long r1 = getHistoryStart();
        long r3 = getHistoryEnd();
        if (r1 == Long.MAX_VALUE) goto L7;
        Math.max(r8, r1);
    L7:
        if (r3 != Long.MIN_VALUE) goto L9;
        long r2 = r10;
    L10:
        this.mSweepLeft.setValidRange(r8, r10);
        this.mSweepRight.setValidRange(r8, r10);
        long r4 = (r10 + r8) / 2;
        long r5 = Math.max(r8, r2 - 604800000);
        ChartSweepView r6 = this.mSweepLeft;
        if (r12 >= r8) goto L13;
    L15:
        r12 = r5;
    L16:
        r6.setValue(r12);
        ChartSweepView r13 = this.mSweepRight;
        if (r14 >= r8) goto L19;
    L21:
        r14 = r2;
    L22:
        r13.setValue(r14);
        OLog.d(TAG, "sweepMax" + new Date(r2).toString() + "sweepMin" + new Date(r5).toString());
        requestLayout();
        if (r0 == false) goto L25;
        this.mSeries.invalidatePath();
        this.mDetailSeries.invalidatePath();
    L25:
        updateVertAxisBounds(null);
        updateEstimateVisible();
        updatePrimaryRange();
        return;
    L19:
        if (r14 > r10) goto L21;
    L13:
        if (r12 > r10) goto L15;
    L9:
        r2 = Math.min(r10, r3);
        goto L10
    }

    private void updatePrimaryRange() {
        long r0 = this.mSweepLeft.getValue();
        long r2 = this.mSweepRight.getValue();
        if (this.mDetailSeries.getVisibility() != 0) goto L5;
        this.mDetailSeries.setPrimaryRange(r0, r2);
        this.mSeries.setPrimaryRange(0, 0);
        this.mSeries.setSecondary(true);
        return;
    L5:
        this.mSeries.setPrimaryRange(r0, r2);
        this.mSeries.setSecondary(false);
    }

    private static void setText(SpannableStringBuilder r3, Object r4, CharSequence r5, String r6) {
        int r0 = r3.getSpanStart(r4);
        int r1 = r3.getSpanEnd(r4);
        if (r0 != (-1)) goto L5;
        r0 = TextUtils.indexOf(r3, r6);
        r1 = r0 + r6.length();
        r3.setSpan(r4, r0, r1, 18);
    L5:
        r3.replace(r0, r1, r5);
    }

    public void setDateSelectionSweepVisible(int r2) {
        this.mSweepLeft.setVisibility(r2);
        this.mSweepRight.setVisibility(r2);
    }
}
