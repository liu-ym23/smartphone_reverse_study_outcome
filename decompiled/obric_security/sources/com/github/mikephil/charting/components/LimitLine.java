package com.github.mikephil.charting.components;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class LimitLine extends ComponentBase {
    private DashPathEffect mDashPathEffect;
    private String mLabel;
    private LimitLabelPosition mLabelPosition;
    private float mLimit;
    private int mLineColor;
    private float mLineWidth;
    private Paint.Style mTextStyle;

    public static final enum LimitLabelPosition extends Enum<LimitLabelPosition> {
        private static final /* synthetic */ LimitLabelPosition[] $VALUES = null;
        public static final LimitLabelPosition LEFT_BOTTOM = null;
        public static final LimitLabelPosition LEFT_TOP = null;
        public static final LimitLabelPosition RIGHT_BOTTOM = null;
        public static final LimitLabelPosition RIGHT_TOP = null;

        private LimitLabelPosition(String r1, int r2) {
            super(r1, r2);
        }

        public static LimitLabelPosition valueOf(String r1) {
            return (LimitLabelPosition) Enum.valueOf(LimitLabelPosition.class, r1);
        }

        public static LimitLabelPosition[] values() {
            return (LimitLabelPosition[]) $VALUES.clone();
        }

        static {
            LimitLabelPosition r0 = new LimitLabelPosition("LEFT_TOP", 0);
            LEFT_TOP = r0;
            LimitLabelPosition r1 = new LimitLabelPosition("LEFT_BOTTOM", 1);
            LEFT_BOTTOM = r1;
            LimitLabelPosition r3 = new LimitLabelPosition("RIGHT_TOP", 2);
            RIGHT_TOP = r3;
            LimitLabelPosition r5 = new LimitLabelPosition("RIGHT_BOTTOM", 3);
            RIGHT_BOTTOM = r5;
            $VALUES = new LimitLabelPosition[]{r0, r1, r3, r5};
        }
    }

    public LimitLine(float r3) {
        this.mLimit = 0.0f;
        this.mLineWidth = 2.0f;
        this.mLineColor = Color.rgb(237, 91, 91);
        this.mTextStyle = Paint.Style.FILL_AND_STROKE;
        this.mLabel = "";
        this.mDashPathEffect = null;
        this.mLabelPosition = LimitLabelPosition.RIGHT_TOP;
        this.mLimit = r3;
    }

    public LimitLine(float r3, String r4) {
        this.mLimit = 0.0f;
        this.mLineWidth = 2.0f;
        this.mLineColor = Color.rgb(237, 91, 91);
        this.mTextStyle = Paint.Style.FILL_AND_STROKE;
        this.mLabel = "";
        this.mDashPathEffect = null;
        this.mLabelPosition = LimitLabelPosition.RIGHT_TOP;
        this.mLimit = r3;
        this.mLabel = r4;
    }

    public float getLimit() {
        return this.mLimit;
    }

    public void setLineWidth(float r3) {
        if (r3 >= 0.2f) goto L6;
        r3 = 0.2f;
    L6:
        if (r3 <= 12.0f) goto L8;
        r3 = 12.0f;
    L8:
        this.mLineWidth = Utils.convertDpToPixel(r3);
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public void setLineColor(int r1) {
        this.mLineColor = r1;
    }

    public int getLineColor() {
        return this.mLineColor;
    }

    public void enableDashedLine(float r4, float r5, float r6) {
        this.mDashPathEffect = new DashPathEffect(new float[]{r4, r5}, r6);
    }

    public void disableDashedLine() {
        this.mDashPathEffect = null;
    }

    public boolean isDashedLineEnabled() {
        if (this.mDashPathEffect != null) goto L5;
        return false;
    L5:
        return true;
    }

    public DashPathEffect getDashPathEffect() {
        return this.mDashPathEffect;
    }

    public void setTextStyle(Paint.Style r1) {
        this.mTextStyle = r1;
    }

    public Paint.Style getTextStyle() {
        return this.mTextStyle;
    }

    public void setLabelPosition(LimitLabelPosition r1) {
        this.mLabelPosition = r1;
    }

    public LimitLabelPosition getLabelPosition() {
        return this.mLabelPosition;
    }

    public void setLabel(String r1) {
        this.mLabel = r1;
    }

    public String getLabel() {
        return this.mLabel;
    }
}
