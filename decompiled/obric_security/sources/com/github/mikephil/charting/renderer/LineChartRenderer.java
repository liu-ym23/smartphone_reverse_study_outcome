package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LineChartRenderer extends LineRadarRenderer {
    protected Path cubicFillPath;
    protected Path cubicPath;
    protected Canvas mBitmapCanvas;
    protected Bitmap.Config mBitmapConfig;
    protected LineDataProvider mChart;
    protected Paint mCirclePaintInner;
    private float[] mCirclesBuffer;
    protected WeakReference<Bitmap> mDrawBitmap;
    protected Path mGenerateFilledPathBuffer;
    private HashMap<IDataSet, DataSetImageCache> mImageCaches;
    private float[] mLineBuffer;

    /* JADX INFO: renamed from: com.github.mikephil.charting.renderer.LineChartRenderer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode = null;

        static {
            int[] r0 = new int[LineDataSet.Mode.values().length];
            $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode = r0;
            r0[LineDataSet.Mode.LINEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode[LineDataSet.Mode.STEPPED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode[LineDataSet.Mode.CUBIC_BEZIER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode[LineDataSet.Mode.HORIZONTAL_BEZIER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private class DataSetImageCache {
        private Bitmap[] circleBitmaps;
        private Path mCirclePathBuffer;
        final /* synthetic */ LineChartRenderer this$0;

        private DataSetImageCache(LineChartRenderer r1) {
            this.this$0 = r1;
            this.mCirclePathBuffer = new Path();
        }

        /* synthetic */ DataSetImageCache(LineChartRenderer r1, AnonymousClass1 r2) {
            this(r1);
        }

        protected boolean init(ILineDataSet r3) {
            int r4 = r3.getCircleColorCount();
            Bitmap[] r0 = this.circleBitmaps;
            if (r0 != null) goto L6;
            this.circleBitmaps = new Bitmap[r4];
            return true;
        L6:
            if (r0.length == r4) goto L8;
            this.circleBitmaps = new Bitmap[r4];
            return true;
        L8:
            return false;
        }

        protected void fill(ILineDataSet r10, boolean r11, boolean r12) {
            int r0 = r10.getCircleColorCount();
            float r1 = r10.getCircleRadius();
            float r2 = r10.getCircleHoleRadius();
            int r3 = 0;
        L3:
            if (r3 >= r0) goto L11;
            int r5 = (int) (((double) r1) * 2.1d);
            Bitmap r4 = Bitmap.createBitmap(r5, r5, Bitmap.Config.ARGB_4444);
            Canvas r6 = new Canvas(r4);
            this.circleBitmaps[r3] = r4;
            this.this$0.mRenderPaint.setColor(r10.getCircleColor(r3));
            if (r12 == false) goto L7;
            this.mCirclePathBuffer.reset();
            this.mCirclePathBuffer.addCircle(r1, r1, r1, Path.Direction.CW);
            this.mCirclePathBuffer.addCircle(r1, r1, r2, Path.Direction.CCW);
            r6.drawPath(this.mCirclePathBuffer, this.this$0.mRenderPaint);
        L10:
            r3 = r3 + 1;
            goto L3
        L7:
            r6.drawCircle(r1, r1, r1, this.this$0.mRenderPaint);
            if (r11 == false) goto L10;
            r6.drawCircle(r1, r1, r2, this.this$0.mCirclePaintInner);
            goto L10
        }

        protected Bitmap getBitmap(int r2) {
            Bitmap[] r1 = this.circleBitmaps;
            return r1[r2 % r1.length];
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public LineChartRenderer(LineDataProvider r1, ChartAnimator r2, ViewPortHandler r3) {
        super(r2, r3);
        this.mBitmapConfig = Bitmap.Config.ARGB_8888;
        this.cubicPath = new Path();
        this.cubicFillPath = new Path();
        this.mLineBuffer = new float[4];
        this.mGenerateFilledPathBuffer = new Path();
        this.mImageCaches = new HashMap();
        this.mCirclesBuffer = new float[2];
        this.mChart = r1;
        Paint r4 = new Paint(1);
        this.mCirclePaintInner = r4;
        r4.setStyle(Paint.Style.FILL);
        this.mCirclePaintInner.setColor(-1);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas r5) {
        int r0 = (int) this.mViewPortHandler.getChartWidth();
        int r1 = (int) this.mViewPortHandler.getChartHeight();
        WeakReference<Bitmap> r2 = this.mDrawBitmap;
        if (r2 != null) goto L5;
        Bitmap r3 = null;
    L6:
        if (r3 != null) goto L8;
    L11:
        if (r0 <= 0) goto L27;
        if (r1 <= 0) goto L28;
        r3 = Bitmap.createBitmap(r0, r1, this.mBitmapConfig);
        this.mDrawBitmap = new WeakReference(r3);
        this.mBitmapCanvas = new Canvas(r3);
    L14:
        r3.eraseColor(0);
        Iterator r4 = this.mChart.getLineData().getDataSets().iterator();
    L16:
        if (r4.hasNext() == false) goto L20;
        ILineDataSet r6 = (ILineDataSet) r4.next();
        if (r6.isVisible() == false) goto L16;
        drawDataSet(r5, r6);
        goto L16
    L20:
        r5.drawBitmap(r3, 0.0f, 0.0f, this.mRenderPaint);
        return;
    L28:
        return;
    L27:
        return;
    L8:
        if (r3.getWidth() != r0) goto L11;
        if (r3.getHeight() == r1) goto L14;
    L5:
        r3 = r2.get();
        goto L6
    }

    protected void drawDataSet(Canvas r3, ILineDataSet r4) {
        if (r4.getEntryCount() >= 1) goto L5;
        return;
    L5:
        this.mRenderPaint.setStrokeWidth(r4.getLineWidth());
        this.mRenderPaint.setPathEffect(r4.getDashPathEffect());
        int r0 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode[r4.getMode().ordinal()];
        if (r0 != 3) goto L8;
        drawCubicBezier(r4);
    L12:
        this.mRenderPaint.setPathEffect(null);
        return;
    L8:
        if (r0 == 4) goto L10;
        drawLinear(r3, r4);
        goto L12
    L10:
        drawHorizontalBezier(r4);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.github.mikephil.charting.data.Entry] */
    protected void drawHorizontalBezier(ILineDataSet r15) {
        float r0 = this.mAnimator.getPhaseY();
        Transformer r1 = this.mChart.getTransformer(r15.getAxisDependency());
        this.mXBounds.set(this.mChart, r15);
        this.cubicPath.reset();
        if (this.mXBounds.range < 1) goto L9;
        ?? r2 = r15.getEntryForIndex(this.mXBounds.min);
        this.cubicPath.moveTo(r2.getX(), r2.getY() * r0);
        int r4 = this.mXBounds.min + 1;
        ?? r3 = r2;
    L6:
        if (r4 > (this.mXBounds.range + this.mXBounds.min)) goto L9;
        ?? r5 = r15.getEntryForIndex(r4);
        float r10 = r3.getX() + ((r5.getX() - r3.getX()) / 2.0f);
        this.cubicPath.cubicTo(r10, r3.getY() * r0, r10, r5.getY() * r0, r5.getX(), r5.getY() * r0);
        r4 = r4 + 1;
        r3 = r5;
    L9:
        if (r15.isDrawFilledEnabled() == false) goto L11;
        this.cubicFillPath.reset();
        this.cubicFillPath.addPath(this.cubicPath);
        drawCubicFill(this.mBitmapCanvas, r15, this.cubicFillPath, r1, this.mXBounds);
    L11:
        this.mRenderPaint.setColor(r15.getColor());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        r1.pathValueToPixel(this.cubicPath);
        this.mBitmapCanvas.drawPath(this.cubicPath, this.mRenderPaint);
        this.mRenderPaint.setPathEffect(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v6, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r5v8 */
    protected void drawCubicBezier(ILineDataSet r23) {
        float r0 = this.mAnimator.getPhaseY();
        Transformer r8 = this.mChart.getTransformer(r23.getAxisDependency());
        this.mXBounds.set(this.mChart, r23);
        float r1 = r23.getCubicIntensity();
        this.cubicPath.reset();
        if (this.mXBounds.range < 1) goto L18;
        int r2 = this.mXBounds.min + 1;
        int r4 = this.mXBounds.min;
        int r5 = this.mXBounds.range;
        Object r6 = r23.getEntryForIndex(Math.max(r2 - 2, 0));
        ?? r3 = r23.getEntryForIndex(Math.max(r2 - 1, 0));
        if (r3 != 0) goto L7;
        return;
    L7:
        this.cubicPath.moveTo(r3.getX(), r3.getY() * r0);
        int r7 = -1;
        int r9 = this.mXBounds.min + 1;
        ?? r10 = r3;
        ?? r11 = r3;
        ?? r12 = r6;
    L8:
        ?? r13 = r11;
        if (r9 > (this.mXBounds.range + this.mXBounds.min)) goto L18;
        if (r7 == r9) goto L13;
        r13 = r23.getEntryForIndex(r9);
    L13:
        int r14 = r9 + 1;
        if (r14 >= r23.getEntryCount()) goto L16;
        r9 = r14;
    L16:
        ?? r15 = r23.getEntryForIndex(r9);
        this.cubicPath.cubicTo(r10.getX() + ((r13.getX() - r12.getX()) * r1), (r10.getY() + ((r13.getY() - r12.getY()) * r1)) * r0, r13.getX() - ((r15.getX() - r10.getX()) * r1), (r13.getY() - ((r15.getY() - r10.getY()) * r1)) * r0, r13.getX(), r13.getY() * r0);
        r12 = r10;
        r10 = r13;
        r11 = r15;
        int r21 = r9;
        r9 = r14;
        r7 = r21;
    L18:
        if (r23.isDrawFilledEnabled() == false) goto L20;
        this.cubicFillPath.reset();
        this.cubicFillPath.addPath(this.cubicPath);
        drawCubicFill(this.mBitmapCanvas, r23, this.cubicFillPath, r8, this.mXBounds);
    L20:
        this.mRenderPaint.setColor(r23.getColor());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        r8.pathValueToPixel(this.cubicPath);
        this.mBitmapCanvas.drawPath(this.cubicPath, this.mRenderPaint);
        this.mRenderPaint.setPathEffect(null);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.github.mikephil.charting.data.Entry] */
    protected void drawCubicFill(Canvas r4, ILineDataSet r5, Path r6, Transformer r7, BarLineScatterCandleBubbleRenderer.XBounds r8) {
        float r0 = r5.getFillFormatter().getFillLinePosition(r5, this.mChart);
        r6.lineTo(r5.getEntryForIndex(r8.min + r8.range).getX(), r0);
        r6.lineTo(r5.getEntryForIndex(r8.min).getX(), r0);
        r6.close();
        r7.pathValueToPixel(r6);
        Drawable r9 = r5.getFillDrawable();
        if (r9 == null) goto L5;
        drawFilledPath(r4, r6, r9);
        return;
    L5:
        drawFilledPath(r4, r6, r5.getFillColor(), r5.getFillAlpha());
    }

    /* JADX WARN: Type inference failed for: r12v12, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r13v5, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r8v23, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r8v5, types: [com.github.mikephil.charting.data.Entry] */
    protected void drawLinear(Canvas r18, ILineDataSet r19) {
        int r2 = r19.getEntryCount();
        if (r19.getMode() != LineDataSet.Mode.STEPPED) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L9;
        int r8 = 4;
    L10:
        Transformer r9 = this.mChart.getTransformer(r19.getAxisDependency());
        float r10 = this.mAnimator.getPhaseY();
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        if (r19.isDashedLineEnabled() == false) goto L13;
        Canvas r11 = this.mBitmapCanvas;
    L14:
        this.mXBounds.set(this.mChart, r19);
        if (r19.isDrawFilledEnabled() == false) goto L19;
        if (r2 <= 0) goto L19;
        drawLinearFill(r18, r19, r9, this.mXBounds);
    L19:
        if (r19.getColors().size() <= 1) goto L50;
        int r12 = r8 * 2;
        if (this.mLineBuffer.length > r12) goto L23;
        this.mLineBuffer = new float[r8 * 4];
    L23:
        int r4 = this.mXBounds.min;
    L25:
        if (r4 > (this.mXBounds.range + this.mXBounds.min)) goto L72;
        ?? r13 = r19.getEntryForIndex(r4);
        if (r13 == 0) goto L49;
        this.mLineBuffer[0] = r13.getX();
        this.mLineBuffer[1] = r13.getY() * r10;
        if (r4 >= this.mXBounds.max) goto L37;
        ?? r14 = r19.getEntryForIndex(r4 + 1);
        if (r14 == 0) goto L72;
        if (r3 == false) goto L36;
        this.mLineBuffer[2] = r14.getX();
        float[] r15 = this.mLineBuffer;
        float r16 = r15[1];
        r15[3] = r16;
        r15[4] = r15[2];
        r15[5] = r16;
        r15[6] = r14.getX();
        this.mLineBuffer[7] = r14.getY() * r10;
    L38:
        r9.pointValuesToPixel(this.mLineBuffer);
        if (this.mViewPortHandler.isInBoundsRight(this.mLineBuffer[0]) == false) goto L72;
        if (this.mViewPortHandler.isInBoundsLeft(this.mLineBuffer[2]) == false) goto L49;
        if (this.mViewPortHandler.isInBoundsTop(this.mLineBuffer[1]) == false) goto L46;
    L48:
        this.mRenderPaint.setColor(r19.getColor(r4));
        r11.drawLines(this.mLineBuffer, 0, r12, this.mRenderPaint);
        goto L49
    L46:
        if (this.mViewPortHandler.isInBoundsBottom(this.mLineBuffer[3]) == true) goto L48;
    L36:
        this.mLineBuffer[2] = r14.getX();
        this.mLineBuffer[3] = r14.getY() * r10;
        goto L38
    L37:
        float[] r17 = this.mLineBuffer;
        r17[2] = r17[0];
        r17[3] = r17[1];
    L49:
        r4 = r4 + 1;
    L72:
        this.mRenderPaint.setPathEffect(null);
        return;
    L50:
        int r5 = r2 * r8;
        if (this.mLineBuffer.length >= (Math.max(r5, r8) * 2)) goto L54;
        this.mLineBuffer = new float[Math.max(r5, r8) * 4];
    L54:
        if (r19.getEntryForIndex(this.mXBounds.min) == 0) goto L72;
        int r6 = this.mXBounds.min;
        int r7 = 0;
    L57:
        if (r6 > (this.mXBounds.range + this.mXBounds.min)) goto L70;
        if (r6 != 0) goto L60;
        int r110 = 0;
    L61:
        ?? r111 = r19.getEntryForIndex(r110);
        ?? r112 = r19.getEntryForIndex(r6);
        if (r111 == 0) goto L69;
        if (r112 == 0) goto L69;
        int r113 = r7 + 1;
        this.mLineBuffer[r7] = r111.getX();
        int r114 = r113 + 1;
        this.mLineBuffer[r113] = r111.getY() * r10;
        if (r3 == false) goto L68;
        int r115 = r114 + 1;
        this.mLineBuffer[r114] = r112.getX();
        int r116 = r115 + 1;
        this.mLineBuffer[r115] = r111.getY() * r10;
        int r117 = r116 + 1;
        this.mLineBuffer[r116] = r112.getX();
        r114 = r117 + 1;
        this.mLineBuffer[r117] = r111.getY() * r10;
    L68:
        int r118 = r114 + 1;
        this.mLineBuffer[r114] = r112.getX();
        this.mLineBuffer[r118] = r112.getY() * r10;
        r7 = r118 + 1;
    L69:
        r6 = r6 + 1;
        goto L57
    L60:
        r110 = r6 - 1;
        goto L61
    L70:
        if (r7 <= 0) goto L72;
        r9.pointValuesToPixel(this.mLineBuffer);
        int r20 = Math.max((this.mXBounds.range + 1) * r8, r8) * 2;
        this.mRenderPaint.setColor(r19.getColor());
        r11.drawLines(this.mLineBuffer, 0, r20, this.mRenderPaint);
        goto L72
    L13:
        r11 = r18;
        goto L14
    L9:
        r8 = 2;
        goto L10
    L5:
        r3 = false;
        goto L7
    }

    protected void drawLinearFill(Canvas r8, ILineDataSet r9, Transformer r10, BarLineScatterCandleBubbleRenderer.XBounds r11) {
        Path r0 = this.mGenerateFilledPathBuffer;
        int r1 = r11.min;
        int r2 = r11.range + r11.min;
        int r12 = 0;
    L3:
        int r3 = (r12 * 128) + r1;
        int r4 = r3 + 128;
        if (r4 <= r2) goto L6;
        r4 = r2;
    L6:
        if (r3 > r4) goto L11;
        generateFilledPath(r9, r3, r4, r0);
        r10.pathValueToPixel(r0);
        Drawable r5 = r9.getFillDrawable();
        if (r5 == null) goto L10;
        drawFilledPath(r8, r0, r5);
        goto L11
    L10:
        drawFilledPath(r8, r0, r9.getFillColor(), r9.getFillAlpha());
    L11:
        r12 = r12 + 1;
        if (r3 <= r4) goto L3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r3v4 */
    private void generateFilledPath(ILineDataSet r7, int r8, int r9, Path r10) {
        float r0 = r7.getFillFormatter().getFillLinePosition(r7, this.mChart);
        float r6 = this.mAnimator.getPhaseY();
        if (r7.getMode() != LineDataSet.Mode.STEPPED) goto L5;
        boolean r1 = true;
    L6:
        r10.reset();
        ?? r2 = r7.getEntryForIndex(r8);
        r10.moveTo(r2.getX(), r0);
        r10.lineTo(r2.getX(), r2.getY() * r6);
        int r11 = r8 + 1;
        ?? r3 = 0;
        ?? r4 = r2;
    L7:
        if (r11 > r9) goto L12;
        ?? r5 = r7.getEntryForIndex(r11);
        if (r1 == false) goto L11;
        r10.lineTo(r5.getX(), r4.getY() * r6);
    L11:
        r10.lineTo(r5.getX(), r5.getY() * r6);
        r11 = r11 + 1;
        r4 = r5;
        r3 = r5;
        goto L7
    L12:
        if (r3 == 0) goto L14;
        r10.lineTo(r3.getX(), r0);
    L14:
        r10.close();
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas r27) {
        if (isDrawingValuesAllowed(this.mChart) == false) goto L39;
        List<T> r7 = this.mChart.getLineData().getDataSets();
        int r9 = 0;
    L6:
        if (r9 >= r7.size()) goto L50;
        ILineDataSet r5 = (ILineDataSet) r7.get(r9);
        if (shouldDrawValues(r5) == false) goto L38;
        if (r5.getEntryCount() < 1) goto L38;
        applyValueTextStyle(r5);
        Transformer r10 = this.mChart.getTransformer(r5.getAxisDependency());
        int r0 = (int) (r5.getCircleRadius() * 1.75f);
        if (r5.isDrawCirclesEnabled() == true) goto L15;
        r0 = r0 / 2;
    L15:
        int r4 = r0;
        this.mXBounds.set(this.mChart, r5);
        float[] r11 = r10.generateTransformedValuesLine(r5, this.mAnimator.getPhaseX(), this.mAnimator.getPhaseY(), this.mXBounds.min, this.mXBounds.max);
        ValueFormatter r12 = r5.getValueFormatter();
        MPPointF r13 = MPPointF.getInstance(r5.getIconsOffset());
        r13.x = Utils.convertDpToPixel(r13.x);
        r13.y = Utils.convertDpToPixel(r13.y);
        int r14 = 0;
    L17:
        if (r14 >= r11.length) goto L37;
        float r15 = r11[r14];
        float r16 = r11[r14 + 1];
        if (this.mViewPortHandler.isInBoundsRight(r15) == false) goto L37;
        if (this.mViewPortHandler.isInBoundsLeft(r15) == true) goto L24;
    L35:
        r4 = r4;
        r5 = r5;
    L36:
        r14 = r14 + 2;
        r5 = r5;
        r4 = r4;
        goto L17
    L24:
        if (this.mViewPortHandler.isInBoundsY(r16) == false) goto L35;
        int r1 = r14 / 2;
        Entry r3 = r5.getEntryForIndex(this.mXBounds.min + r1);
        if (r5.isDrawValuesEnabled() == false) goto L31;
        drawValue(r27, r12.getPointLabel(r3), r15, r16 - r4, r5.getValueTextColor(r1));
    L31:
        if (r3.getIcon() == null) goto L36;
        if (r5.isDrawIconsEnabled() == false) goto L36;
        Drawable r21 = r3.getIcon();
        Utils.drawImage(r27, r21, (int) (r15 + r13.x), (int) (r16 + r13.y), r21.getIntrinsicWidth(), r21.getIntrinsicHeight());
    L37:
        MPPointF.recycleInstance(r13);
    L38:
        r9 = r9 + 1;
        goto L6
    L50:
        return;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas r2, String r3, float r4, float r5, int r6) {
        this.mValuePaint.setColor(r6);
        r2.drawText(r3, r4, r5, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas r1) {
        drawCircles(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v2, types: [com.github.mikephil.charting.data.Entry] */
    protected void drawCircles(Canvas r18) {
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        float r1 = this.mAnimator.getPhaseY();
        float[] r2 = this.mCirclesBuffer;
        char r3 = 0;
        float r4 = 0.0f;
        r2[0] = 0.0f;
        r2[1] = 0.0f;
        List<T> r5 = this.mChart.getLineData().getDataSets();
        int r6 = 0;
    L4:
        if (r6 >= r5.size()) goto L51;
        ILineDataSet r7 = (ILineDataSet) r5.get(r6);
        if (r7.isVisible() == false) goto L50;
        if (r7.isDrawCirclesEnabled() == false) goto L50;
        if (r7.getEntryCount() == 0) goto L50;
        this.mCirclePaintInner.setColor(r7.getCircleHoleColor());
        Transformer r8 = this.mChart.getTransformer(r7.getAxisDependency());
        this.mXBounds.set(this.mChart, r7);
        float r9 = r7.getCircleRadius();
        float r10 = r7.getCircleHoleRadius();
        if (r7.isDrawCircleHoleEnabled() == true) goto L15;
    L19:
        boolean r11 = r3;
    L20:
        if (r11 != 0) goto L22;
    L24:
        boolean r12 = r3;
    L25:
        AnonymousClass1 r13 = null;
        if (this.mImageCaches.containsKey(r7) == false) goto L28;
        DataSetImageCache r14 = this.mImageCaches.get(r7);
    L30:
        if (r14.init(r7) == false) goto L32;
        r14.fill(r7, r11, r12);
    L32:
        int r15 = this.mXBounds.range + this.mXBounds.min;
        int r16 = this.mXBounds.min;
    L33:
        if (r16 > r15) goto L50;
        ?? r17 = r7.getEntryForIndex(r16);
        if (r17 == 0) goto L50;
        this.mCirclesBuffer[r3] = r17.getX();
        this.mCirclesBuffer[1] = r17.getY() * r1;
        r8.pointValuesToPixel(this.mCirclesBuffer);
        if (this.mViewPortHandler.isInBoundsRight(this.mCirclesBuffer[r3]) == false) goto L50;
        if (this.mViewPortHandler.isInBoundsLeft(this.mCirclesBuffer[r3]) == false) goto L49;
        if (this.mViewPortHandler.isInBoundsY(this.mCirclesBuffer[1]) == false) goto L49;
        Bitmap r19 = r14.getBitmap(r16);
        if (r19 == null) goto L49;
        float[] r110 = this.mCirclesBuffer;
        r18.drawBitmap(r19, r110[r3] - r9, r110[1] - r9, null);
    L49:
        r16 = r16 + 1;
        r3 = 0;
        goto L33
    L28:
        DataSetImageCache r111 = new DataSetImageCache(this, r13);
        this.mImageCaches.put(r7, r111);
        r14 = r111;
        goto L30
    L22:
        if (r7.getCircleHoleColor() != 1122867) goto L24;
        r12 = 1;
        goto L25
    L15:
        if (r10 >= r9) goto L19;
        if (r10 <= r4) goto L19;
        r11 = 1;
    L50:
        r6 = r6 + 1;
        r3 = 0;
        r4 = 0.0f;
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.github.mikephil.charting.data.Entry] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas r10, Highlight[] r11) {
        LineData r0 = this.mChart.getLineData();
        int r1 = r11.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L14;
        Highlight r3 = r11[r2];
        ILineDataSet r4 = (ILineDataSet) r0.getDataSetByIndex(r3.getDataSetIndex());
        if (r4 == null) goto L13;
        if (r4.isHighlightEnabled() == false) goto L13;
        ?? r5 = r4.getEntryForXValue(r3.getX(), r3.getY());
        if (isInBoundsX(r5, r4) == false) goto L13;
        MPPointD r6 = this.mChart.getTransformer(r4.getAxisDependency()).getPixelForValues(r5.getX(), r5.getY() * this.mAnimator.getPhaseY());
        r3.setDraw((float) r6.x, (float) r6.y);
        drawHighlightLines(r10, (float) r6.x, (float) r6.y, r4);
    L13:
        r2 = r2 + 1;
        goto L3
    }

    public void setBitmapConfig(Bitmap.Config r1) {
        this.mBitmapConfig = r1;
        releaseBitmap();
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mBitmapConfig;
    }

    public void releaseBitmap() {
        Canvas r0 = this.mBitmapCanvas;
        if (r0 == null) goto L5;
        r0.setBitmap(null);
        this.mBitmapCanvas = null;
    L5:
        WeakReference<Bitmap> r1 = this.mDrawBitmap;
        if (r1 == null) goto L12;
        Bitmap r2 = r1.get();
        if (r2 == null) goto L10;
        r2.recycle();
    L10:
        this.mDrawBitmap.clear();
        this.mDrawBitmap = null;
        return;
    }
}
