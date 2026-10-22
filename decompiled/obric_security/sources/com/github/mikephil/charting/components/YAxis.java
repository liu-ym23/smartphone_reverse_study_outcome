package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class YAxis extends AxisBase {
    private AxisDependency mAxisDependency;
    private boolean mDrawBottomYLabelEntry;
    private boolean mDrawTopYLabelEntry;
    protected boolean mDrawZeroLine;
    protected boolean mInverted;
    protected float mMaxWidth;
    protected float mMinWidth;
    private YAxisLabelPosition mPosition;
    protected float mSpacePercentBottom;
    protected float mSpacePercentTop;
    private boolean mUseAutoScaleRestrictionMax;
    private boolean mUseAutoScaleRestrictionMin;
    protected int mZeroLineColor;
    protected float mZeroLineWidth;

    public static final enum AxisDependency extends Enum<AxisDependency> {
        private static final /* synthetic */ AxisDependency[] $VALUES = null;
        public static final AxisDependency LEFT = null;
        public static final AxisDependency RIGHT = null;

        private AxisDependency(String r1, int r2) {
            super(r1, r2);
        }

        public static AxisDependency valueOf(String r1) {
            return (AxisDependency) Enum.valueOf(AxisDependency.class, r1);
        }

        public static AxisDependency[] values() {
            return (AxisDependency[]) $VALUES.clone();
        }

        static {
            AxisDependency r0 = new AxisDependency("LEFT", 0);
            LEFT = r0;
            AxisDependency r1 = new AxisDependency("RIGHT", 1);
            RIGHT = r1;
            $VALUES = new AxisDependency[]{r0, r1};
        }
    }

    public static final enum YAxisLabelPosition extends Enum<YAxisLabelPosition> {
        private static final /* synthetic */ YAxisLabelPosition[] $VALUES = null;
        public static final YAxisLabelPosition INSIDE_CHART = null;
        public static final YAxisLabelPosition OUTSIDE_CHART = null;

        private YAxisLabelPosition(String r1, int r2) {
            super(r1, r2);
        }

        public static YAxisLabelPosition valueOf(String r1) {
            return (YAxisLabelPosition) Enum.valueOf(YAxisLabelPosition.class, r1);
        }

        public static YAxisLabelPosition[] values() {
            return (YAxisLabelPosition[]) $VALUES.clone();
        }

        static {
            YAxisLabelPosition r0 = new YAxisLabelPosition("OUTSIDE_CHART", 0);
            OUTSIDE_CHART = r0;
            YAxisLabelPosition r1 = new YAxisLabelPosition("INSIDE_CHART", 1);
            INSIDE_CHART = r1;
            $VALUES = new YAxisLabelPosition[]{r0, r1};
        }
    }

    public YAxis() {
        this.mDrawBottomYLabelEntry = true;
        this.mDrawTopYLabelEntry = true;
        this.mInverted = false;
        this.mDrawZeroLine = false;
        this.mUseAutoScaleRestrictionMin = false;
        this.mUseAutoScaleRestrictionMax = false;
        this.mZeroLineColor = -7829368;
        this.mZeroLineWidth = 1.0f;
        this.mSpacePercentTop = 10.0f;
        this.mSpacePercentBottom = 10.0f;
        this.mPosition = YAxisLabelPosition.OUTSIDE_CHART;
        this.mMinWidth = 0.0f;
        this.mMaxWidth = Float.POSITIVE_INFINITY;
        this.mAxisDependency = AxisDependency.LEFT;
        this.mYOffset = 0.0f;
    }

    public YAxis(AxisDependency r3) {
        this.mDrawBottomYLabelEntry = true;
        this.mDrawTopYLabelEntry = true;
        this.mInverted = false;
        this.mDrawZeroLine = false;
        this.mUseAutoScaleRestrictionMin = false;
        this.mUseAutoScaleRestrictionMax = false;
        this.mZeroLineColor = -7829368;
        this.mZeroLineWidth = 1.0f;
        this.mSpacePercentTop = 10.0f;
        this.mSpacePercentBottom = 10.0f;
        this.mPosition = YAxisLabelPosition.OUTSIDE_CHART;
        this.mMinWidth = 0.0f;
        this.mMaxWidth = Float.POSITIVE_INFINITY;
        this.mAxisDependency = r3;
        this.mYOffset = 0.0f;
    }

    public AxisDependency getAxisDependency() {
        return this.mAxisDependency;
    }

    public float getMinWidth() {
        return this.mMinWidth;
    }

    public void setMinWidth(float r1) {
        this.mMinWidth = r1;
    }

    public float getMaxWidth() {
        return this.mMaxWidth;
    }

    public void setMaxWidth(float r1) {
        this.mMaxWidth = r1;
    }

    public YAxisLabelPosition getLabelPosition() {
        return this.mPosition;
    }

    public void setPosition(YAxisLabelPosition r1) {
        this.mPosition = r1;
    }

    public boolean isDrawTopYLabelEntryEnabled() {
        return this.mDrawTopYLabelEntry;
    }

    public boolean isDrawBottomYLabelEntryEnabled() {
        return this.mDrawBottomYLabelEntry;
    }

    public void setDrawTopYLabelEntry(boolean r1) {
        this.mDrawTopYLabelEntry = r1;
    }

    public void setInverted(boolean r1) {
        this.mInverted = r1;
    }

    public boolean isInverted() {
        return this.mInverted;
    }

    @Deprecated
    public void setStartAtZero(boolean r1) {
        if (r1 == false) goto L4;
        setAxisMinimum(0.0f);
        return;
    L4:
        resetAxisMinimum();
    }

    public void setSpaceTop(float r1) {
        this.mSpacePercentTop = r1;
    }

    public float getSpaceTop() {
        return this.mSpacePercentTop;
    }

    public void setSpaceBottom(float r1) {
        this.mSpacePercentBottom = r1;
    }

    public float getSpaceBottom() {
        return this.mSpacePercentBottom;
    }

    public boolean isDrawZeroLineEnabled() {
        return this.mDrawZeroLine;
    }

    public void setDrawZeroLine(boolean r1) {
        this.mDrawZeroLine = r1;
    }

    public int getZeroLineColor() {
        return this.mZeroLineColor;
    }

    public void setZeroLineColor(int r1) {
        this.mZeroLineColor = r1;
    }

    public float getZeroLineWidth() {
        return this.mZeroLineWidth;
    }

    public void setZeroLineWidth(float r1) {
        this.mZeroLineWidth = Utils.convertDpToPixel(r1);
    }

    public float getRequiredWidthSpace(Paint r6) {
        r6.setTextSize(this.mTextSize);
        float r7 = Utils.calcTextWidth(r6, getLongestLabel()) + (getXOffset() * 2.0f);
        float r0 = getMinWidth();
        float r5 = getMaxWidth();
        if (r0 <= 0.0f) goto L6;
        r0 = Utils.convertDpToPixel(r0);
    L6:
        if (r5 <= 0.0f) goto L11;
        if (r5 == Float.POSITIVE_INFINITY) goto L11;
        r5 = Utils.convertDpToPixel(r5);
    L11:
        if (r5 > 0.0d) goto L15;
        r5 = r7;
    L15:
        return Math.max(r0, Math.min(r7, r5));
    }

    public float getRequiredHeightSpace(Paint r2) {
        r2.setTextSize(this.mTextSize);
        return Utils.calcTextHeight(r2, getLongestLabel()) + (getYOffset() * 2.0f);
    }

    public boolean needsOffset() {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        if (isDrawLabelsEnabled() == true) goto L7;
        return false;
    L7:
        if (getLabelPosition() != YAxisLabelPosition.OUTSIDE_CHART) goto L13;
        return true;
    L13:
        return false;
    }

    @Deprecated
    public boolean isUseAutoScaleMinRestriction() {
        return this.mUseAutoScaleRestrictionMin;
    }

    @Deprecated
    public void setUseAutoScaleMinRestriction(boolean r1) {
        this.mUseAutoScaleRestrictionMin = r1;
    }

    @Deprecated
    public boolean isUseAutoScaleMaxRestriction() {
        return this.mUseAutoScaleRestrictionMax;
    }

    @Deprecated
    public void setUseAutoScaleMaxRestriction(boolean r1) {
        this.mUseAutoScaleRestrictionMax = r1;
    }

    @Override // com.github.mikephil.charting.components.AxisBase
    public void calculate(float r5, float r6) {
        if (Math.abs(r6 - r5) != 0.0f) goto L5;
        r6 = r6 + 1.0f;
        r5 = r5 - 1.0f;
    L5:
        float r0 = Math.abs(r6 - r5);
        if (this.mCustomAxisMin == false) goto L8;
        float r7 = this.mAxisMinimum;
    L9:
        this.mAxisMinimum = r7;
        if (this.mCustomAxisMax == false) goto L12;
        float r8 = this.mAxisMaximum;
    L13:
        this.mAxisMaximum = r8;
        this.mAxisRange = Math.abs(this.mAxisMinimum - this.mAxisMaximum);
        return;
    L12:
        r8 = r6 + ((r0 / 100.0f) * getSpaceTop());
        goto L13
    L8:
        r7 = r5 - ((r0 / 100.0f) * getSpaceBottom());
        goto L9
    }
}
