package com.github.mikephil.charting.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.highlight.Highlight;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ChartTouchListener<T extends Chart<?>> extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
    protected static final int DRAG = 1;
    protected static final int NONE = 0;
    protected static final int PINCH_ZOOM = 4;
    protected static final int POST_ZOOM = 5;
    protected static final int ROTATE = 6;
    protected static final int X_ZOOM = 2;
    protected static final int Y_ZOOM = 3;
    protected T mChart;
    protected GestureDetector mGestureDetector;
    protected ChartGesture mLastGesture;
    protected Highlight mLastHighlighted;
    protected int mTouchMode;

    public static final enum ChartGesture extends Enum<ChartGesture> {
        private static final /* synthetic */ ChartGesture[] $VALUES = null;
        public static final ChartGesture DOUBLE_TAP = null;
        public static final ChartGesture DRAG = null;
        public static final ChartGesture FLING = null;
        public static final ChartGesture LONG_PRESS = null;
        public static final ChartGesture NONE = null;
        public static final ChartGesture PINCH_ZOOM = null;
        public static final ChartGesture ROTATE = null;
        public static final ChartGesture SINGLE_TAP = null;
        public static final ChartGesture X_ZOOM = null;
        public static final ChartGesture Y_ZOOM = null;

        private ChartGesture(String r1, int r2) {
            super(r1, r2);
        }

        public static ChartGesture valueOf(String r1) {
            return (ChartGesture) Enum.valueOf(ChartGesture.class, r1);
        }

        public static ChartGesture[] values() {
            return (ChartGesture[]) $VALUES.clone();
        }

        static {
            ChartGesture r0 = new ChartGesture("NONE", 0);
            NONE = r0;
            ChartGesture r1 = new ChartGesture("DRAG", 1);
            DRAG = r1;
            ChartGesture r3 = new ChartGesture("X_ZOOM", 2);
            X_ZOOM = r3;
            ChartGesture r5 = new ChartGesture("Y_ZOOM", 3);
            Y_ZOOM = r5;
            ChartGesture r7 = new ChartGesture("PINCH_ZOOM", 4);
            PINCH_ZOOM = r7;
            ChartGesture r9 = new ChartGesture("ROTATE", 5);
            ROTATE = r9;
            ChartGesture r11 = new ChartGesture("SINGLE_TAP", 6);
            SINGLE_TAP = r11;
            ChartGesture r13 = new ChartGesture("DOUBLE_TAP", 7);
            DOUBLE_TAP = r13;
            ChartGesture r15 = new ChartGesture("LONG_PRESS", 8);
            LONG_PRESS = r15;
            ChartGesture r14 = new ChartGesture("FLING", 9);
            FLING = r14;
            $VALUES = new ChartGesture[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        }
    }

    public ChartTouchListener(T r2) {
        this.mLastGesture = ChartGesture.NONE;
        this.mTouchMode = 0;
        this.mChart = r2;
        this.mGestureDetector = new GestureDetector(r2.getContext(), this);
    }

    public void startAction(MotionEvent r2) {
        OnChartGestureListener r0 = this.mChart.getOnChartGestureListener();
        if (r0 == null) goto L6;
        r0.onChartGestureStart(r2, this.mLastGesture);
        return;
    }

    public void endAction(MotionEvent r2) {
        OnChartGestureListener r0 = this.mChart.getOnChartGestureListener();
        if (r0 == null) goto L6;
        r0.onChartGestureEnd(r2, this.mLastGesture);
        return;
    }

    public void setLastHighlighted(Highlight r1) {
        this.mLastHighlighted = r1;
    }

    public int getTouchMode() {
        return this.mTouchMode;
    }

    public ChartGesture getLastGesture() {
        return this.mLastGesture;
    }

    protected void performHighlight(Highlight r2, MotionEvent r3) {
        if (r2 != null) goto L5;
    L8:
        this.mChart.highlightValue(null, true);
        this.mLastHighlighted = null;
        return;
    L5:
        if (r2.equalTo(this.mLastHighlighted) == true) goto L8;
        this.mChart.highlightValue(r2, true);
        this.mLastHighlighted = r2;
    }

    protected static float distance(float r0, float r1, float r2, float r3) {
        float r4 = r0 - r1;
        float r5 = r2 - r3;
        return (float) Math.sqrt((r4 * r4) + (r5 * r5));
    }
}
