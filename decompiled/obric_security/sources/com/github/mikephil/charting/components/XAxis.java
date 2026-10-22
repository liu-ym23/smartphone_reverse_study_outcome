package com.github.mikephil.charting.components;

import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class XAxis extends AxisBase {
    private boolean mAvoidFirstLastClipping;
    public int mLabelHeight;
    public int mLabelRotatedHeight;
    public int mLabelRotatedWidth;
    protected float mLabelRotationAngle;
    public int mLabelWidth;
    private XAxisPosition mPosition;

    public static final enum XAxisPosition extends Enum<XAxisPosition> {
        private static final /* synthetic */ XAxisPosition[] $VALUES = null;
        public static final XAxisPosition BOTH_SIDED = null;
        public static final XAxisPosition BOTTOM = null;
        public static final XAxisPosition BOTTOM_INSIDE = null;
        public static final XAxisPosition TOP = null;
        public static final XAxisPosition TOP_INSIDE = null;

        private XAxisPosition(String r1, int r2) {
            super(r1, r2);
        }

        public static XAxisPosition valueOf(String r1) {
            return (XAxisPosition) Enum.valueOf(XAxisPosition.class, r1);
        }

        public static XAxisPosition[] values() {
            return (XAxisPosition[]) $VALUES.clone();
        }

        static {
            XAxisPosition r0 = new XAxisPosition("TOP", 0);
            TOP = r0;
            XAxisPosition r1 = new XAxisPosition("BOTTOM", 1);
            BOTTOM = r1;
            XAxisPosition r3 = new XAxisPosition("BOTH_SIDED", 2);
            BOTH_SIDED = r3;
            XAxisPosition r5 = new XAxisPosition("TOP_INSIDE", 3);
            TOP_INSIDE = r5;
            XAxisPosition r7 = new XAxisPosition("BOTTOM_INSIDE", 4);
            BOTTOM_INSIDE = r7;
            $VALUES = new XAxisPosition[]{r0, r1, r3, r5, r7};
        }
    }

    public XAxis() {
        this.mLabelWidth = 1;
        this.mLabelHeight = 1;
        this.mLabelRotatedWidth = 1;
        this.mLabelRotatedHeight = 1;
        this.mLabelRotationAngle = 0.0f;
        this.mAvoidFirstLastClipping = false;
        this.mPosition = XAxisPosition.TOP;
        this.mYOffset = Utils.convertDpToPixel(4.0f);
    }

    public XAxisPosition getPosition() {
        return this.mPosition;
    }

    public void setPosition(XAxisPosition r1) {
        this.mPosition = r1;
    }

    public float getLabelRotationAngle() {
        return this.mLabelRotationAngle;
    }

    public void setLabelRotationAngle(float r1) {
        this.mLabelRotationAngle = r1;
    }

    public void setAvoidFirstLastClipping(boolean r1) {
        this.mAvoidFirstLastClipping = r1;
    }

    public boolean isAvoidFirstLastClippingEnabled() {
        return this.mAvoidFirstLastClipping;
    }
}
