package com.github.mikephil.charting.data;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.ChevronDownShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.ChevronUpShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.CircleShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.CrossShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.SquareShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.TriangleShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.XShapeRenderer;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ScatterDataSet extends LineScatterCandleRadarDataSet<Entry> implements IScatterDataSet {
    private int mScatterShapeHoleColor;
    private float mScatterShapeHoleRadius;
    protected IShapeRenderer mShapeRenderer;
    private float mShapeSize;

    /* JADX INFO: renamed from: com.github.mikephil.charting.data.ScatterDataSet$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape = null;

        static {
            int[] r0 = new int[ScatterChart.ScatterShape.values().length];
            $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape = r0;
            r0[ScatterChart.ScatterShape.SQUARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.CIRCLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.TRIANGLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.CROSS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.X.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.CHEVRON_UP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.CHEVRON_DOWN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public ScatterDataSet(List<Entry> r1, String r2) {
        super(r1, r2);
        this.mShapeSize = 15.0f;
        this.mShapeRenderer = new SquareShapeRenderer();
        this.mScatterShapeHoleRadius = 0.0f;
        this.mScatterShapeHoleColor = ColorTemplate.COLOR_NONE;
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
        ScatterDataSet r2 = new ScatterDataSet(r0, getLabel());
        copy(r2);
        return r2;
    }

    protected void copy(ScatterDataSet r2) {
        super.copy(r2);
        r2.mShapeSize = this.mShapeSize;
        r2.mShapeRenderer = this.mShapeRenderer;
        r2.mScatterShapeHoleRadius = this.mScatterShapeHoleRadius;
        r2.mScatterShapeHoleColor = this.mScatterShapeHoleColor;
    }

    public void setScatterShapeSize(float r1) {
        this.mShapeSize = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public float getScatterShapeSize() {
        return this.mShapeSize;
    }

    public void setScatterShape(ScatterChart.ScatterShape r1) {
        this.mShapeRenderer = getRendererForShape(r1);
    }

    public void setShapeRenderer(IShapeRenderer r1) {
        this.mShapeRenderer = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public IShapeRenderer getShapeRenderer() {
        return this.mShapeRenderer;
    }

    public void setScatterShapeHoleRadius(float r1) {
        this.mScatterShapeHoleRadius = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public float getScatterShapeHoleRadius() {
        return this.mScatterShapeHoleRadius;
    }

    public void setScatterShapeHoleColor(int r1) {
        this.mScatterShapeHoleColor = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public int getScatterShapeHoleColor() {
        return this.mScatterShapeHoleColor;
    }

    public static IShapeRenderer getRendererForShape(ScatterChart.ScatterShape r1) {
        switch(AnonymousClass1.$SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[r1.ordinal()]) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return new ChevronDownShapeRenderer();
    L9:
        return new ChevronUpShapeRenderer();
    L11:
        return new XShapeRenderer();
    L13:
        return new CrossShapeRenderer();
    L15:
        return new TriangleShapeRenderer();
    L17:
        return new CircleShapeRenderer();
    L19:
        return new SquareShapeRenderer();
    }
}
