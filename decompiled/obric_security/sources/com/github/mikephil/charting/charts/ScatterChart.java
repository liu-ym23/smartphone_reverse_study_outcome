package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.renderer.ScatterChartRenderer;

/* JADX INFO: loaded from: classes2.dex */
public class ScatterChart extends BarLineChartBase<ScatterData> implements ScatterDataProvider {

    public static final enum ScatterShape extends Enum<ScatterShape> {
        private static final /* synthetic */ ScatterShape[] $VALUES = null;
        public static final ScatterShape CHEVRON_DOWN = null;
        public static final ScatterShape CHEVRON_UP = null;
        public static final ScatterShape CIRCLE = null;
        public static final ScatterShape CROSS = null;
        public static final ScatterShape SQUARE = null;
        public static final ScatterShape TRIANGLE = null;
        public static final ScatterShape X = null;
        private final String shapeIdentifier;

        public static ScatterShape valueOf(String r1) {
            return (ScatterShape) Enum.valueOf(ScatterShape.class, r1);
        }

        public static ScatterShape[] values() {
            return (ScatterShape[]) $VALUES.clone();
        }

        static {
            ScatterShape r0 = new ScatterShape("SQUARE", 0, "SQUARE");
            SQUARE = r0;
            ScatterShape r1 = new ScatterShape("CIRCLE", 1, "CIRCLE");
            CIRCLE = r1;
            ScatterShape r3 = new ScatterShape("TRIANGLE", 2, "TRIANGLE");
            TRIANGLE = r3;
            ScatterShape r5 = new ScatterShape("CROSS", 3, "CROSS");
            CROSS = r5;
            ScatterShape r7 = new ScatterShape("X", 4, "X");
            X = r7;
            ScatterShape r9 = new ScatterShape("CHEVRON_UP", 5, "CHEVRON_UP");
            CHEVRON_UP = r9;
            ScatterShape r11 = new ScatterShape("CHEVRON_DOWN", 6, "CHEVRON_DOWN");
            CHEVRON_DOWN = r11;
            $VALUES = new ScatterShape[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private ScatterShape(String r1, int r2, String r3) {
            super(r1, r2);
            this.shapeIdentifier = r3;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.shapeIdentifier;
        }

        public static ScatterShape[] getAllDefaultShapes() {
            return new ScatterShape[]{SQUARE, CIRCLE, TRIANGLE, CROSS, X, CHEVRON_UP, CHEVRON_DOWN};
        }
    }

    public ScatterChart(Context r1) {
        super(r1);
    }

    public ScatterChart(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public ScatterChart(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mRenderer = new ScatterChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        getXAxis().setSpaceMin(0.5f);
        getXAxis().setSpaceMax(0.5f);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider
    public ScatterData getScatterData() {
        return (ScatterData) this.mData;
    }
}
