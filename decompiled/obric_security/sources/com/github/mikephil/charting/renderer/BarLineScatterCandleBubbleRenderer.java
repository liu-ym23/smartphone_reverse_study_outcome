package com.github.mikephil.charting.renderer;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BarLineScatterCandleBubbleRenderer extends DataRenderer {
    protected XBounds mXBounds;

    protected class XBounds {
        public int max;
        public int min;
        public int range;
        final /* synthetic */ BarLineScatterCandleBubbleRenderer this$0;

        protected XBounds(BarLineScatterCandleBubbleRenderer r1) {
            this.this$0 = r1;
        }

        public void set(BarLineScatterCandleBubbleDataProvider r5, IBarLineScatterCandleBubbleDataSet r6) {
            float r0 = Math.max(0.0f, Math.min(1.0f, this.this$0.mAnimator.getPhaseX()));
            float r1 = r5.getLowestVisibleX();
            float r7 = r5.getHighestVisibleX();
            T r2 = r6.getEntryForXValue(r1, Float.NaN, DataSet.Rounding.DOWN);
            T r8 = r6.getEntryForXValue(r7, Float.NaN, DataSet.Rounding.UP);
            int r3 = 0;
            if (r2 != 0) goto L5;
            int r4 = 0;
        L6:
            this.min = r4;
            if (r8 == 0) goto L10;
            r3 = r6.getEntryIndex(r8);
        L10:
            this.max = r3;
            this.range = (int) ((r3 - this.min) * r0);
            return;
        L5:
            r4 = r6.getEntryIndex(r2);
            goto L6
        }
    }

    public BarLineScatterCandleBubbleRenderer(ChartAnimator r1, ViewPortHandler r2) {
        super(r1, r2);
        this.mXBounds = new XBounds(this);
    }

    protected boolean shouldDrawValues(IDataSet r1) {
        if (r1.isVisible() == true) goto L5;
    L9:
        return false;
    L5:
        if (r1.isDrawValuesEnabled() == false) goto L7;
    L8:
        return true;
    L7:
        if (r1.isDrawIconsEnabled() == false) goto L9;
        goto L8
    }

    protected boolean isInBoundsX(Entry r3, IBarLineScatterCandleBubbleDataSet r4) {
        if (r3 != null) goto L5;
        return false;
    L5:
        float r1 = r4.getEntryIndex(r3);
        if (r3 != null) goto L8;
    L12:
        return false;
    L8:
        if (r1 >= (r4.getEntryCount() * this.mAnimator.getPhaseX())) goto L12;
        return true;
    }
}
