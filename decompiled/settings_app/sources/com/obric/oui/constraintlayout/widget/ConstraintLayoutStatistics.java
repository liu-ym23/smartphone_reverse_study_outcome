package com.obric.oui.constraintlayout.widget;

import android.icu.text.DateFormat;
import android.util.Log;
import com.obric.oui.constraintlayout.core.Metrics;
import cz.msebera.android.httpclient.message.TokenParser;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes4.dex */
public class ConstraintLayoutStatistics {
    public static final int DURATION_OF_CHILD_MEASURES = 5;
    public static final int DURATION_OF_LAYOUT = 7;
    public static final int DURATION_OF_MEASURES = 6;
    private static int MAX_WORD = 25;
    public static final int NUMBER_OF_CHILD_MEASURES = 4;
    public static final int NUMBER_OF_CHILD_VIEWS = 3;
    public static final int NUMBER_OF_EQUATIONS = 9;
    public static final int NUMBER_OF_LAYOUTS = 1;
    public static final int NUMBER_OF_ON_MEASURES = 2;
    public static final int NUMBER_OF_SIMPLE_EQUATIONS = 10;
    public static final int NUMBER_OF_VARIABLES = 8;
    private static final String WORD_PAD = null;
    ConstraintLayout mConstraintLayout;
    private final Metrics mMetrics;

    String geName(int r1) {
        switch(r1) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L7;
            case 10: goto L5;
            default: goto L3;
        };
    L3:
        return "";
    L5:
        return "SimpleEquations";
    L7:
        return "SolverEquations";
    L9:
        return "SolverVariables";
    L11:
        return "MeasuresLayoutDuration";
    L13:
        return "MeasureDuration";
    L15:
        return "MeasuresWidgetsDuration ";
    L17:
        return "ChildrenMeasures";
    L19:
        return "ChildCount";
    L21:
        return "MeasureCalls";
    L23:
        return "NumberOfLayouts";
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1104clone() throws CloneNotSupportedException {
        return clone();
    }

    static {
        WORD_PAD = new String(new char[MAX_WORD]).replace(0, TokenParser.SP);
    }

    public ConstraintLayoutStatistics(ConstraintLayout r2) {
        this.mMetrics = new Metrics();
        attach(r2);
    }

    public ConstraintLayoutStatistics(ConstraintLayoutStatistics r2) {
        Metrics r0 = new Metrics();
        this.mMetrics = r0;
        r0.copy(r2.mMetrics);
    }

    public void attach(ConstraintLayout r2) {
        r2.fillMetrics(this.mMetrics);
        this.mConstraintLayout = r2;
    }

    public void detach() {
        ConstraintLayout r1 = this.mConstraintLayout;
        if (r1 == null) goto L6;
        r1.fillMetrics(null);
        return;
    }

    public void reset() {
        this.mMetrics.reset();
    }

    public ConstraintLayoutStatistics clone() {
        return new ConstraintLayoutStatistics(this);
    }

    private String fmt(DecimalFormat r3, float r4, int r5) {
        String r2 = new String(new char[r5]).replace(0, TokenParser.SP) + r3.format(r4);
        return r2.substring(r2.length() - r5);
    }

    public void logSummary(String r1) {
        log(r1);
    }

    private void log(String r5) {
        StackTraceElement r0 = new Throwable().getStackTrace()[2];
        Log.v(r5, "CL Perf: --------  Performance .(" + r0.getFileName() + ":" + r0.getLineNumber() + ")  ------ ");
        DecimalFormat r1 = new DecimalFormat("###.000");
        Log.v(r5, log(r1, 5));
        Log.v(r5, log(r1, 7));
        Log.v(r5, log(r1, 6));
        Log.v(r5, log(1));
        Log.v(r5, log(2));
        Log.v(r5, log(3));
        Log.v(r5, log(4));
        Log.v(r5, log(8));
        Log.v(r5, log(9));
        Log.v(r5, log(10));
    }

    private String log(DecimalFormat r3, int r4) {
        String r5 = fmt(r3, getValue(r4) * 1.0E-6f, 7);
        String r2 = WORD_PAD + geName(r4);
        return "CL Perf: " + (r2.substring(r2.length() - MAX_WORD) + " = ") + r5;
    }

    private String log(int r3) {
        String r0 = Long.toString(getValue(r3));
        String r2 = WORD_PAD + geName(r3);
        return "CL Perf: " + (r2.substring(r2.length() - MAX_WORD) + " = ") + r0;
    }

    private String compare(DecimalFormat r6, ConstraintLayoutStatistics r7, int r8) {
        String r9 = fmt(r6, getValue(r8) * 1.0E-6f, 7) + " -> " + fmt(r6, r7.getValue(r8) * 1.0E-6f, 7) + DateFormat.MINUTE_SECOND;
        String r5 = WORD_PAD + geName(r8);
        return "CL Perf: " + (r5.substring(r5.length() - MAX_WORD) + " = ") + r9;
    }

    private String compare(ConstraintLayoutStatistics r4, int r5) {
        String r6 = getValue(r5) + " -> " + r4.getValue(r5);
        String r3 = WORD_PAD + geName(r5);
        return "CL Perf: " + (r3.substring(r3.length() - MAX_WORD) + " = ") + r6;
    }

    public void logSummary(String r6, ConstraintLayoutStatistics r7) {
        if (r7 != null) goto L5;
        log(r6);
        return;
    L5:
        DecimalFormat r0 = new DecimalFormat("###.000");
        StackTraceElement r1 = new Throwable().getStackTrace()[1];
        Log.v(r6, "CL Perf: -=  Performance .(" + r1.getFileName() + ":" + r1.getLineNumber() + ")  =- ");
        Log.v(r6, compare(r0, r7, 5));
        Log.v(r6, compare(r0, r7, 7));
        Log.v(r6, compare(r0, r7, 6));
        Log.v(r6, compare(r7, 1));
        Log.v(r6, compare(r7, 2));
        Log.v(r6, compare(r7, 3));
        Log.v(r6, compare(r7, 4));
        Log.v(r6, compare(r7, 8));
        Log.v(r6, compare(r7, 9));
        Log.v(r6, compare(r7, 10));
    }

    public long getValue(int r1) {
        switch(r1) {
            case 1: goto L24;
            case 2: goto L22;
            case 3: goto L20;
            case 4: goto L18;
            case 5: goto L16;
            case 6: goto L14;
            case 7: goto L12;
            case 8: goto L10;
            case 9: goto L8;
            case 10: goto L6;
            default: goto L3;
        };
    L3:
        return 0;
    L6:
        return this.mMetrics.mSimpleEquations;
    L8:
        return this.mMetrics.mEquations;
    L10:
        return this.mMetrics.mVariables;
    L12:
        return this.mMetrics.measuresLayoutDuration;
    L14:
        return this.mMetrics.mMeasureDuration;
    L16:
        return this.mMetrics.measuresWidgetsDuration;
    L18:
        return this.mMetrics.mNumberOfMeasures;
    L20:
        return this.mMetrics.mChildCount;
    L22:
        return this.mMetrics.mMeasureCalls;
    L24:
        return this.mMetrics.mNumberOfLayouts;
    }
}
