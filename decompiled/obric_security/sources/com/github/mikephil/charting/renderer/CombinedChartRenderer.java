package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CombinedChartRenderer extends DataRenderer {
    protected WeakReference<Chart> mChart;
    protected List<Highlight> mHighlightBuffer;
    protected List<DataRenderer> mRenderers;

    /* JADX INFO: renamed from: com.github.mikephil.charting.renderer.CombinedChartRenderer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder = null;

        static {
            int[] r0 = new int[CombinedChart.DrawOrder.values().length];
            $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder = r0;
            r0[CombinedChart.DrawOrder.BAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder[CombinedChart.DrawOrder.BUBBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder[CombinedChart.DrawOrder.LINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder[CombinedChart.DrawOrder.CANDLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder[CombinedChart.DrawOrder.SCATTER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public CombinedChartRenderer(CombinedChart r1, ChartAnimator r2, ViewPortHandler r3) {
        super(r2, r3);
        this.mRenderers = new ArrayList(5);
        this.mHighlightBuffer = new ArrayList();
        this.mChart = new WeakReference(r1);
        createRenderers();
    }

    public void createRenderers() {
        this.mRenderers.clear();
        CombinedChart r0 = (CombinedChart) this.mChart.get();
        if (r0 != null) goto L5;
        return;
    L5:
        CombinedChart.DrawOrder[] r1 = r0.getDrawOrder();
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L34;
        CombinedChart.DrawOrder r4 = r1[r3];
        int r5 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder[r4.ordinal()];
        if (r5 == 1) goto L31;
        if (r5 == 2) goto L28;
        if (r5 == 3) goto L25;
        if (r5 == 4) goto L22;
        if (r5 != 5) goto L33;
        if (r0.getScatterData() == null) goto L33;
        this.mRenderers.add(new ScatterChartRenderer(r0, this.mAnimator, this.mViewPortHandler));
    L33:
        r3 = r3 + 1;
        goto L6
    L22:
        if (r0.getCandleData() == null) goto L33;
        this.mRenderers.add(new CandleStickChartRenderer(r0, this.mAnimator, this.mViewPortHandler));
        goto L33
    L25:
        if (r0.getLineData() == null) goto L33;
        this.mRenderers.add(new LineChartRenderer(r0, this.mAnimator, this.mViewPortHandler));
        goto L33
    L28:
        if (r0.getBubbleData() == null) goto L33;
        this.mRenderers.add(new BubbleChartRenderer(r0, this.mAnimator, this.mViewPortHandler));
        goto L33
    L31:
        if (r0.getBarData() == null) goto L33;
        this.mRenderers.add(new BarChartRenderer(r0, this.mAnimator, this.mViewPortHandler));
        goto L33
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        Iterator<DataRenderer> r1 = this.mRenderers.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().initBuffers();
        goto L4
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas r2) {
        Iterator<DataRenderer> r1 = this.mRenderers.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().drawData(r2);
        goto L4
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas r1, String r2, float r3, float r4, int r5) {
        Log.e(Chart.LOG_TAG, "Erroneous call to drawValue() in CombinedChartRenderer!");
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas r2) {
        Iterator<DataRenderer> r1 = this.mRenderers.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().drawValues(r2);
        goto L4
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas r2) {
        Iterator<DataRenderer> r1 = this.mRenderers.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().drawExtras(r2);
        goto L4
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas r10, Highlight[] r11) {
        Chart r0 = this.mChart.get();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<DataRenderer> r1 = this.mRenderers.iterator();
    L7:
        if (r1.hasNext() == false) goto L37;
        DataRenderer r2 = r1.next();
        if ((r2 instanceof BarChartRenderer) == false) goto L12;
        Object r3 = ((BarChartRenderer) r2).mChart.getBarData();
    L25:
        if (r3 != null) goto L27;
        int r4 = -1;
    L28:
        this.mHighlightBuffer.clear();
        int r5 = r11.length;
        int r6 = 0;
    L29:
        if (r6 >= r5) goto L36;
        Highlight r7 = r11[r6];
        if (r7.getDataIndex() != r4) goto L33;
    L34:
        this.mHighlightBuffer.add(r7);
    L35:
        r6 = r6 + 1;
        goto L29
    L33:
        if (r7.getDataIndex() != (-1)) goto L35;
    L36:
        List<Highlight> r8 = this.mHighlightBuffer;
        r2.drawHighlighted(r10, (Highlight[]) r8.toArray(new Highlight[r8.size()]));
        goto L7
    L27:
        r4 = ((CombinedData) r0.getData()).getAllData().indexOf(r3);
        goto L28
    L12:
        if ((r2 instanceof LineChartRenderer) == false) goto L15;
        r3 = ((LineChartRenderer) r2).mChart.getLineData();
        goto L25
    L15:
        if ((r2 instanceof CandleStickChartRenderer) == false) goto L18;
        r3 = ((CandleStickChartRenderer) r2).mChart.getCandleData();
        goto L25
    L18:
        if ((r2 instanceof ScatterChartRenderer) == false) goto L21;
        r3 = ((ScatterChartRenderer) r2).mChart.getScatterData();
        goto L25
    L21:
        if ((r2 instanceof BubbleChartRenderer) == false) goto L23;
        r3 = ((BubbleChartRenderer) r2).mChart.getBubbleData();
        goto L25
    L23:
        r3 = null;
        goto L25
    }

    public DataRenderer getSubRenderer(int r2) {
        if (r2 >= this.mRenderers.size()) goto L8;
        if (r2 >= 0) goto L7;
        return null;
    L7:
        return this.mRenderers.get(r2);
    L8:
        return null;
    }

    public List<DataRenderer> getSubRenderers() {
        return this.mRenderers;
    }

    public void setSubRenderers(List<DataRenderer> r1) {
        this.mRenderers = r1;
    }
}
