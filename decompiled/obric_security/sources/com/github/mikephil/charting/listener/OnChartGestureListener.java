package com.github.mikephil.charting.listener;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public interface OnChartGestureListener {
    void onChartDoubleTapped(MotionEvent r1);

    void onChartFling(MotionEvent r1, MotionEvent r2, float r3, float r4);

    void onChartGestureEnd(MotionEvent r1, ChartTouchListener.ChartGesture r2);

    void onChartGestureStart(MotionEvent r1, ChartTouchListener.ChartGesture r2);

    void onChartLongPressed(MotionEvent r1);

    void onChartScale(MotionEvent r1, float r2, float r3);

    void onChartSingleTapped(MotionEvent r1);

    void onChartTranslate(MotionEvent r1, float r2, float r3);
}
