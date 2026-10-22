package com.github.mikephil.charting.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.util.Log;
import com.github.mikephil.charting.formatter.DefaultFillFormatter;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LineDataSet extends LineRadarDataSet<Entry> implements ILineDataSet {
    private List<Integer> mCircleColors;
    private int mCircleHoleColor;
    private float mCircleHoleRadius;
    private float mCircleRadius;
    private float mCubicIntensity;
    private DashPathEffect mDashPathEffect;
    private boolean mDrawCircleHole;
    private boolean mDrawCircles;
    private IFillFormatter mFillFormatter;
    private Mode mMode;

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode CUBIC_BEZIER = null;
        public static final Mode HORIZONTAL_BEZIER = null;
        public static final Mode LINEAR = null;
        public static final Mode STEPPED = null;

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        public static Mode valueOf(String r1) {
            return (Mode) Enum.valueOf(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        static {
            Mode r0 = new Mode("LINEAR", 0);
            LINEAR = r0;
            Mode r1 = new Mode("STEPPED", 1);
            STEPPED = r1;
            Mode r3 = new Mode("CUBIC_BEZIER", 2);
            CUBIC_BEZIER = r3;
            Mode r5 = new Mode("HORIZONTAL_BEZIER", 3);
            HORIZONTAL_BEZIER = r5;
            $VALUES = new Mode[]{r0, r1, r3, r5};
        }
    }

    public LineDataSet(List<Entry> r2, String r3) {
        super(r2, r3);
        this.mMode = Mode.LINEAR;
        this.mCircleColors = null;
        this.mCircleHoleColor = -1;
        this.mCircleRadius = 8.0f;
        this.mCircleHoleRadius = 4.0f;
        this.mCubicIntensity = 0.2f;
        this.mDashPathEffect = null;
        this.mFillFormatter = new DefaultFillFormatter();
        this.mDrawCircles = true;
        this.mDrawCircleHole = true;
        if (this.mCircleColors != null) goto L5;
        this.mCircleColors = new ArrayList();
    L5:
        this.mCircleColors.clear();
        this.mCircleColors.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<Entry> copy() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= this.mValues.size()) goto L6;
        r0.add(((Entry) this.mValues.get(r1)).copy());
        r1 = r1 + 1;
        goto L4
    L6:
        LineDataSet r2 = new LineDataSet(r0, getLabel());
        copy(r2);
        return r2;
    }

    protected void copy(LineDataSet r2) {
        super.copy(r2);
        r2.mCircleColors = this.mCircleColors;
        r2.mCircleHoleColor = this.mCircleHoleColor;
        r2.mCircleHoleRadius = this.mCircleHoleRadius;
        r2.mCircleRadius = this.mCircleRadius;
        r2.mCubicIntensity = this.mCubicIntensity;
        r2.mDashPathEffect = this.mDashPathEffect;
        r2.mDrawCircleHole = this.mDrawCircleHole;
        r2.mDrawCircles = this.mDrawCircleHole;
        r2.mFillFormatter = this.mFillFormatter;
        r2.mMode = this.mMode;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public Mode getMode() {
        return this.mMode;
    }

    public void setMode(Mode r1) {
        this.mMode = r1;
    }

    public void setCubicIntensity(float r3) {
        if (r3 <= 1.0f) goto L6;
        r3 = 1.0f;
    L6:
        if (r3 >= 0.05f) goto L8;
        r3 = 0.05f;
    L8:
        this.mCubicIntensity = r3;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public float getCubicIntensity() {
        return this.mCubicIntensity;
    }

    public void setCircleRadius(float r2) {
        if (r2 < 1.0f) goto L5;
        this.mCircleRadius = Utils.convertDpToPixel(r2);
        return;
    L5:
        Log.e("LineDataSet", "Circle radius cannot be < 1");
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public float getCircleRadius() {
        return this.mCircleRadius;
    }

    public void setCircleHoleRadius(float r2) {
        if (r2 < 0.5f) goto L5;
        this.mCircleHoleRadius = Utils.convertDpToPixel(r2);
        return;
    L5:
        Log.e("LineDataSet", "Circle radius cannot be < 0.5");
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public float getCircleHoleRadius() {
        return this.mCircleHoleRadius;
    }

    @Deprecated
    public void setCircleSize(float r1) {
        setCircleRadius(r1);
    }

    @Deprecated
    public float getCircleSize() {
        return getCircleRadius();
    }

    public void enableDashedLine(float r4, float r5, float r6) {
        this.mDashPathEffect = new DashPathEffect(new float[]{r4, r5}, r6);
    }

    public void disableDashedLine() {
        this.mDashPathEffect = null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public boolean isDashedLineEnabled() {
        if (this.mDashPathEffect != null) goto L5;
        return false;
    L5:
        return true;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public DashPathEffect getDashPathEffect() {
        return this.mDashPathEffect;
    }

    public void setDrawCircles(boolean r1) {
        this.mDrawCircles = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public boolean isDrawCirclesEnabled() {
        return this.mDrawCircles;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    @Deprecated
    public boolean isDrawCubicEnabled() {
        if (this.mMode != Mode.CUBIC_BEZIER) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    @Deprecated
    public boolean isDrawSteppedEnabled() {
        if (this.mMode != Mode.STEPPED) goto L5;
        return true;
    L5:
        return false;
    }

    public List<Integer> getCircleColors() {
        return this.mCircleColors;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public int getCircleColor(int r1) {
        return this.mCircleColors.get(r1).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public int getCircleColorCount() {
        return this.mCircleColors.size();
    }

    public void setCircleColors(List<Integer> r1) {
        this.mCircleColors = r1;
    }

    public void setCircleColors(int... r1) {
        this.mCircleColors = ColorTemplate.createColors(r1);
    }

    public void setCircleColors(int[] r6, Context r7) {
        List<Integer> r0 = this.mCircleColors;
        if (r0 != null) goto L5;
        r0 = new ArrayList();
    L5:
        r0.clear();
        int r1 = r6.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        int r3 = r6[r2];
        r0.add(Integer.valueOf(r7.getResources().getColor(r3)));
        r2 = r2 + 1;
        goto L6
    L8:
        this.mCircleColors = r0;
    }

    public void setCircleColor(int r1) {
        resetCircleColors();
        this.mCircleColors.add(Integer.valueOf(r1));
    }

    public void resetCircleColors() {
        if (this.mCircleColors != null) goto L5;
        this.mCircleColors = new ArrayList();
    L5:
        this.mCircleColors.clear();
    }

    public void setCircleHoleColor(int r1) {
        this.mCircleHoleColor = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public int getCircleHoleColor() {
        return this.mCircleHoleColor;
    }

    public void setDrawCircleHole(boolean r1) {
        this.mDrawCircleHole = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public boolean isDrawCircleHoleEnabled() {
        return this.mDrawCircleHole;
    }

    public void setFillFormatter(IFillFormatter r1) {
        if (r1 != null) goto L4;
        this.mFillFormatter = new DefaultFillFormatter();
        return;
    L4:
        this.mFillFormatter = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public IFillFormatter getFillFormatter() {
        return this.mFillFormatter;
    }
}
