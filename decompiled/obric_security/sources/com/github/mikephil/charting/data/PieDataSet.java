package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PieDataSet extends DataSet<PieEntry> implements IPieDataSet {
    private boolean mAutomaticallyDisableSliceSpacing;
    private float mShift;
    private float mSliceSpace;
    private boolean mUsingSliceColorAsValueLineColor;
    private int mValueLineColor;
    private float mValueLinePart1Length;
    private float mValueLinePart1OffsetPercentage;
    private float mValueLinePart2Length;
    private boolean mValueLineVariableLength;
    private float mValueLineWidth;
    private ValuePosition mXValuePosition;
    private ValuePosition mYValuePosition;

    public static final enum ValuePosition extends Enum<ValuePosition> {
        private static final /* synthetic */ ValuePosition[] $VALUES = null;
        public static final ValuePosition INSIDE_SLICE = null;
        public static final ValuePosition OUTSIDE_SLICE = null;

        private ValuePosition(String r1, int r2) {
            super(r1, r2);
        }

        public static ValuePosition valueOf(String r1) {
            return (ValuePosition) Enum.valueOf(ValuePosition.class, r1);
        }

        public static ValuePosition[] values() {
            return (ValuePosition[]) $VALUES.clone();
        }

        static {
            ValuePosition r0 = new ValuePosition("INSIDE_SLICE", 0);
            INSIDE_SLICE = r0;
            ValuePosition r1 = new ValuePosition("OUTSIDE_SLICE", 1);
            OUTSIDE_SLICE = r1;
            $VALUES = new ValuePosition[]{r0, r1};
        }
    }

    @Override // com.github.mikephil.charting.data.DataSet
    protected /* bridge */ /* synthetic */ void calcMinMax(Entry r1) {
        calcMinMax((PieEntry) r1);
    }

    public PieDataSet(List<PieEntry> r1, String r2) {
        super(r1, r2);
        this.mSliceSpace = 0.0f;
        this.mShift = 18.0f;
        this.mXValuePosition = ValuePosition.INSIDE_SLICE;
        this.mYValuePosition = ValuePosition.INSIDE_SLICE;
        this.mUsingSliceColorAsValueLineColor = false;
        this.mValueLineColor = -16777216;
        this.mValueLineWidth = 1.0f;
        this.mValueLinePart1OffsetPercentage = 75.0f;
        this.mValueLinePart1Length = 0.3f;
        this.mValueLinePart2Length = 0.4f;
        this.mValueLineVariableLength = true;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<PieEntry> copy() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= this.mValues.size()) goto L6;
        r0.add(((PieEntry) this.mValues.get(r1)).copy());
        r1 = r1 + 1;
        goto L4
    L6:
        PieDataSet r2 = new PieDataSet(r0, getLabel());
        copy(r2);
        return r2;
    }

    protected void copy(PieDataSet r1) {
        super.copy(r1);
    }

    protected void calcMinMax(PieEntry r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        calcMinMaxY(r1);
    }

    public void setSliceSpace(float r3) {
        if (r3 <= 20.0f) goto L6;
        r3 = 20.0f;
    L6:
        if (r3 >= 0.0f) goto L8;
        r3 = 0.0f;
    L8:
        this.mSliceSpace = Utils.convertDpToPixel(r3);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getSliceSpace() {
        return this.mSliceSpace;
    }

    public void setAutomaticallyDisableSliceSpacing(boolean r1) {
        this.mAutomaticallyDisableSliceSpacing = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public boolean isAutomaticallyDisableSliceSpacingEnabled() {
        return this.mAutomaticallyDisableSliceSpacing;
    }

    public void setSelectionShift(float r1) {
        this.mShift = Utils.convertDpToPixel(r1);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getSelectionShift() {
        return this.mShift;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public ValuePosition getXValuePosition() {
        return this.mXValuePosition;
    }

    public void setXValuePosition(ValuePosition r1) {
        this.mXValuePosition = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public ValuePosition getYValuePosition() {
        return this.mYValuePosition;
    }

    public void setYValuePosition(ValuePosition r1) {
        this.mYValuePosition = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public boolean isUsingSliceColorAsValueLineColor() {
        return this.mUsingSliceColorAsValueLineColor;
    }

    public void setUsingSliceColorAsValueLineColor(boolean r1) {
        this.mUsingSliceColorAsValueLineColor = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public int getValueLineColor() {
        return this.mValueLineColor;
    }

    public void setValueLineColor(int r1) {
        this.mValueLineColor = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getValueLineWidth() {
        return this.mValueLineWidth;
    }

    public void setValueLineWidth(float r1) {
        this.mValueLineWidth = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getValueLinePart1OffsetPercentage() {
        return this.mValueLinePart1OffsetPercentage;
    }

    public void setValueLinePart1OffsetPercentage(float r1) {
        this.mValueLinePart1OffsetPercentage = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getValueLinePart1Length() {
        return this.mValueLinePart1Length;
    }

    public void setValueLinePart1Length(float r1) {
        this.mValueLinePart1Length = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getValueLinePart2Length() {
        return this.mValueLinePart2Length;
    }

    public void setValueLinePart2Length(float r1) {
        this.mValueLinePart2Length = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public boolean isValueLineVariableLength() {
        return this.mValueLineVariableLength;
    }

    public void setValueLineVariableLength(boolean r1) {
        this.mValueLineVariableLength = r1;
    }
}
