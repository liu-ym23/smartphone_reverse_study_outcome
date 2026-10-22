package com.android.settings.widget;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface ChartAxis {
    long buildLabel(Resources r1, SpannableStringBuilder r2, long r3);

    float convertToPoint(long r1);

    long convertToValue(float r1);

    float[] getTickPoints();

    boolean setBounds(long r1, long r3);

    boolean setSize(float r1);

    int shouldAdjustAxis(long r1);
}
