package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LegendRenderer extends Renderer {
    protected List<LegendEntry> computedEntries;
    protected Paint.FontMetrics legendFontMetrics;
    protected Legend mLegend;
    protected Paint mLegendFormPaint;
    protected Paint mLegendLabelPaint;
    private Path mLineFormPath;

    /* JADX INFO: renamed from: com.github.mikephil.charting.renderer.LegendRenderer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm = null;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment = null;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = null;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment = null;

        static {
            int[] r0 = new int[Legend.LegendForm.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm = r0;
            r0[Legend.LegendForm.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L51:
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.EMPTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L39:
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.DEFAULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L49:
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.CIRCLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L53:
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.SQUARE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L43:
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.LINE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L11:
            int[] r3 = new int[Legend.LegendOrientation.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = r3;
            r3[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L63:
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[Legend.LegendOrientation.VERTICAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L14:
            int[] r4 = new int[Legend.LegendVerticalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment = r4;
            r4[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L55:
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L41:
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[Legend.LegendVerticalAlignment.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
        L18:
            int[] r5 = new int[Legend.LegendHorizontalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment = r5;
            r5[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L61:
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L37:
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
            return;
        }
    }

    public LegendRenderer(ViewPortHandler r2, Legend r3) {
        super(r2);
        this.computedEntries = new ArrayList(16);
        this.legendFontMetrics = new Paint.FontMetrics();
        this.mLineFormPath = new Path();
        this.mLegend = r3;
        Paint r4 = new Paint(1);
        this.mLegendLabelPaint = r4;
        r4.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mLegendLabelPaint.setTextAlign(Paint.Align.LEFT);
        Paint r5 = new Paint(1);
        this.mLegendFormPaint = r5;
        r5.setStyle(Paint.Style.FILL);
    }

    public Paint getLabelPaint() {
        return this.mLegendLabelPaint;
    }

    public Paint getFormPaint() {
        return this.mLegendFormPaint;
    }

    public void computeLegend(ChartData<?> r19) {
        ChartData<?> r1 = r19;
        if (this.mLegend.isLegendCustom() == true) goto L53;
        this.computedEntries.clear();
        int r3 = 0;
    L6:
        if (r3 >= r19.getDataSetCount()) goto L50;
        IDataSet r4 = r1.getDataSetByIndex(r3);
        List<Integer> r5 = r4.getColors();
        int r6 = r4.getEntryCount();
        if ((r4 instanceof IBarDataSet) == false) goto L22;
        IBarDataSet r7 = (IBarDataSet) r4;
        if (r7.isStacked() == false) goto L22;
        String[] r8 = r7.getStackLabels();
        int r9 = 0;
    L13:
        if (r9 >= r5.size()) goto L18;
        if (r9 >= r7.getStackSize()) goto L18;
        this.computedEntries.add(new LegendEntry(r8[r9 % r8.length], r4.getForm(), r4.getFormSize(), r4.getFormLineWidth(), r4.getFormLineDashEffect(), r5.get(r9).intValue()));
        r9 = r9 + 1;
    L18:
        if (r7.getLabel() == null) goto L20;
        this.computedEntries.add(new LegendEntry(r4.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, ColorTemplate.COLOR_NONE));
    L20:
        ChartData<?> r2 = r1;
    L48:
        r3 = r3 + 1;
        r1 = r2;
    L22:
        if ((r4 instanceof IPieDataSet) == false) goto L32;
        IPieDataSet r10 = (IPieDataSet) r4;
        int r11 = 0;
    L25:
        if (r11 >= r5.size()) goto L29;
        if (r11 >= r6) goto L29;
        this.computedEntries.add(new LegendEntry(r10.getEntryForIndex(r11).getLabel(), r4.getForm(), r4.getFormSize(), r4.getFormLineWidth(), r4.getFormLineDashEffect(), r5.get(r11).intValue()));
        r11 = r11 + 1;
    L29:
        if (r10.getLabel() == null) goto L47;
        this.computedEntries.add(new LegendEntry(r4.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, ColorTemplate.COLOR_NONE));
    L47:
        r2 = r19;
        goto L48
    L32:
        if ((r4 instanceof ICandleDataSet) == false) goto L36;
        ICandleDataSet r12 = (ICandleDataSet) r4;
        if (r12.getDecreasingColor() == 1122867) goto L36;
        int r14 = r12.getDecreasingColor();
        int r13 = r12.getIncreasingColor();
        this.computedEntries.add(new LegendEntry(null, r4.getForm(), r4.getFormSize(), r4.getFormLineWidth(), r4.getFormLineDashEffect(), r14));
        this.computedEntries.add(new LegendEntry(r4.getLabel(), r4.getForm(), r4.getFormSize(), r4.getFormLineWidth(), r4.getFormLineDashEffect(), r13));
    L36:
        int r15 = 0;
    L38:
        if (r15 >= r5.size()) goto L47;
        if (r15 >= r6) goto L47;
        if (r15 < (r5.size() - 1)) goto L43;
    L45:
        String r16 = r19.getDataSetByIndex(r3).getLabel();
    L46:
        this.computedEntries.add(new LegendEntry(r16, r4.getForm(), r4.getFormSize(), r4.getFormLineWidth(), r4.getFormLineDashEffect(), r5.get(r15).intValue()));
        r15 = r15 + 1;
        goto L38
    L43:
        if (r15 >= (r6 - 1)) goto L45;
        r16 = null;
        goto L46
    L50:
        if (this.mLegend.getExtraEntries() == null) goto L52;
        Collections.addAll(this.computedEntries, this.mLegend.getExtraEntries());
    L52:
        this.mLegend.setEntries(this.computedEntries);
    L53:
        Typeface r17 = this.mLegend.getTypeface();
        if (r17 == null) goto L56;
        this.mLegendLabelPaint.setTypeface(r17);
    L56:
        this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
        this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
        this.mLegend.calculateDimensions(this.mLegendLabelPaint, this.mViewPortHandler);
    }

    public void renderLegend(Canvas r35) {
        if (this.mLegend.isEnabled() == true) goto L5;
        return;
    L5:
        Typeface r0 = this.mLegend.getTypeface();
        if (r0 == null) goto L8;
        this.mLegendLabelPaint.setTypeface(r0);
    L8:
        this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
        this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
        float r8 = Utils.getLineHeight(this.mLegendLabelPaint, this.legendFontMetrics);
        float r9 = Utils.getLineSpacing(this.mLegendLabelPaint, this.legendFontMetrics) + Utils.convertDpToPixel(this.mLegend.getYEntrySpace());
        float r11 = r8 - (Utils.calcTextHeight(this.mLegendLabelPaint, "ABC") / 2.0f);
        LegendEntry[] r12 = this.mLegend.getEntries();
        float r13 = Utils.convertDpToPixel(this.mLegend.getFormToTextSpace());
        float r14 = Utils.convertDpToPixel(this.mLegend.getXEntrySpace());
        Legend.LegendOrientation r1 = this.mLegend.getOrientation();
        Legend.LegendHorizontalAlignment r15 = this.mLegend.getHorizontalAlignment();
        Legend.LegendVerticalAlignment r2 = this.mLegend.getVerticalAlignment();
        Legend.LegendDirection r5 = this.mLegend.getDirection();
        float r16 = Utils.convertDpToPixel(this.mLegend.getFormSize());
        float r4 = Utils.convertDpToPixel(this.mLegend.getStackSpace());
        float r3 = this.mLegend.getYOffset();
        float r6 = this.mLegend.getXOffset();
        int r10 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[r15.ordinal()];
        float r17 = r4;
        float r21 = r14;
        if (r10 == 1) goto L38;
        if (r10 != 2) goto L12;
        r8 = r8;
        float r18 = r9;
        if (r1 != Legend.LegendOrientation.VERTICAL) goto L33;
        float r7 = this.mViewPortHandler.getChartWidth();
    L34:
        float r19 = r7 - r6;
        if (r5 != Legend.LegendDirection.LEFT_TO_RIGHT) goto L37;
        r19 = r19 - this.mLegend.mNeededWidth;
    L37:
        float r20 = r19;
    L46:
        int r22 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[r1.ordinal()];
        if (r22 != 1) goto L49;
        float r23 = r17;
        List<FSize> r24 = this.mLegend.getCalculatedLineSizes();
        List<FSize> r110 = this.mLegend.getCalculatedLabelSizes();
        List<Boolean> r25 = this.mLegend.getCalculatedLabelBreakPoints();
        int r26 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[r2.ordinal()];
        if (r26 != 1) goto L113;
    L119:
        int r27 = r12.length;
        float r111 = r20;
        int r28 = 0;
        int r29 = 0;
    L120:
        if (r28 >= r27) goto L192;
        float r112 = r23;
        LegendEntry r30 = r12[r28];
        int r210 = r27;
        if (r30.form == Legend.LegendForm.NONE) goto L124;
        boolean r211 = true;
    L126:
        if (Float.isNaN(r30.formSize) == false) goto L128;
        float r212 = r16;
    L130:
        if (r28 < r25.size()) goto L132;
    L134:
        float r31 = r111;
        float r113 = r3;
    L136:
        if (r31 != r20) goto L147;
        if (r15 != Legend.LegendHorizontalAlignment.CENTER) goto L147;
        if (r29 >= r24.size()) goto L147;
        if (r5 != Legend.LegendDirection.RIGHT_TO_LEFT) goto L144;
        float r32 = r24.get(r29).width;
    L145:
        r31 = r31 + (r32 / 2.0f);
        r29 = r29 + 1;
        goto L147
    L144:
        r32 = -r24.get(r29).width;
    L147:
        int r213 = r29;
        if (r30.label != null) goto L150;
        boolean r214 = true;
    L151:
        if (r211 == true) goto L153;
        List<Boolean> r33 = r25;
        float r34 = r20;
        List<FSize> r36 = r24;
        Canvas r37 = r35;
        int r38 = r28;
    L160:
        if (r214 == true) goto L178;
        if (r211 == false) goto L168;
        if (r5 != Legend.LegendDirection.RIGHT_TO_LEFT) goto L165;
        float r39 = -r13;
    L166:
        r31 = r31 + r39;
        goto L168
    L165:
        r39 = r13;
    L168:
        if (r5 != Legend.LegendDirection.RIGHT_TO_LEFT) goto L170;
        r31 = r31 - r110.get(r38).width;
    L170:
        drawLabel(r37, r31, r113 + r8, r30.label);
        if (r5 != Legend.LegendDirection.LEFT_TO_RIGHT) goto L174;
        r31 = r31 + r110.get(r38).width;
    L174:
        if (r5 != Legend.LegendDirection.RIGHT_TO_LEFT) goto L176;
        float r40 = r21;
        float r41 = -r40;
    L177:
        float r42 = r31 + r41;
        float r43 = r112;
    L183:
        r21 = r40;
        r23 = r43;
        r28 = r38 + 1;
        r3 = r113;
        r29 = r213;
        r20 = r34;
        r25 = r33;
        r24 = r36;
        r111 = r42;
        r27 = r210;
        goto L120
    L176:
        r40 = r21;
        r41 = r40;
        goto L177
    L178:
        r40 = r21;
        if (r5 != Legend.LegendDirection.RIGHT_TO_LEFT) goto L181;
        r43 = r112;
        float r44 = -r43;
    L182:
        r42 = r31 + r44;
        goto L183
    L181:
        r43 = r112;
        r44 = r43;
        goto L182
    L153:
        if (r5 != Legend.LegendDirection.RIGHT_TO_LEFT) goto L155;
        r31 = r31 - r212;
    L155:
        float r310 = r31;
        r34 = r20;
        r38 = r28;
        r33 = r25;
        r36 = r24;
        r37 = r35;
        drawForm(r35, r310, r113 + r11, r30, this.mLegend);
        if (r5 != Legend.LegendDirection.LEFT_TO_RIGHT) goto L158;
        r31 = r310 + r212;
        goto L160
    L158:
        r31 = r310;
        goto L160
    L150:
        r214 = false;
        goto L151
    L132:
        if (r25.get(r28).booleanValue() == false) goto L134;
        r113 = r3 + (r8 + r18);
        r31 = r20;
        goto L136
    L128:
        r212 = Utils.convertDpToPixel(r30.formSize);
        goto L130
    L124:
        r211 = false;
        goto L126
    L192:
        return;
    L113:
        if (r26 != 2) goto L115;
        r3 = (this.mViewPortHandler.getChartHeight() - r3) - this.mLegend.mNeededHeight;
        goto L119
    L115:
        if (r26 == 3) goto L117;
        r3 = 0.0f;
        goto L119
    L117:
        r3 = r3 + ((this.mViewPortHandler.getChartHeight() - this.mLegend.mNeededHeight) / 2.0f);
        goto L119
    L49:
        if (r22 != 2) goto L184;
        int r45 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[r2.ordinal()];
        if (r45 == 1) goto L64;
        if (r45 == 2) goto L59;
        if (r45 == 3) goto L57;
        float r46 = 0.0f;
    L68:
        float r47 = r46;
        float r114 = 0.0f;
        boolean r115 = false;
        int r116 = 0;
    L70:
        if (r116 >= r12.length) goto L191;
        LegendEntry r48 = r12[r116];
        if (r48.form == Legend.LegendForm.NONE) goto L74;
        boolean r117 = true;
    L76:
        if (Float.isNaN(r48.formSize) == false) goto L78;
        float r215 = r16;
    L79:
        if (r117 == true) goto L81;
        Legend.LegendDirection r118 = r5;
        LegendEntry r49 = r48;
        float r216 = r20;
    L90:
        if (r49.label == null) goto L108;
        if (r117 == false) goto L98;
        if (r115 == true) goto L98;
        if (r118 != Legend.LegendDirection.LEFT_TO_RIGHT) goto L96;
        float r50 = r13;
    L97:
        r216 = r216 + r50;
    L101:
        if (r118 != Legend.LegendDirection.RIGHT_TO_LEFT) goto L103;
        r216 = r216 - Utils.calcTextWidth(this.mLegendLabelPaint, r49.label);
    L103:
        float r51 = r216;
        if (r115 == true) goto L106;
        drawLabel(r35, r51, r47 + r8, r49.label);
    L107:
        r47 = r47 + (r8 + r18);
        r114 = 0.0f;
    L109:
        r116 = r116 + 1;
        r17 = r17;
        r5 = r118;
        r11 = r11;
        goto L70
    L106:
        r47 = r47 + (r8 + r18);
        drawLabel(r35, r51, r47 + r8, r49.label);
        goto L107
    L96:
        r50 = -r13;
    L98:
        if (r115 == false) goto L101;
        r216 = r20;
        goto L101
    L108:
        r114 = r114 + (r215 + r17);
        r115 = true;
        goto L109
    L81:
        if (r5 != Legend.LegendDirection.LEFT_TO_RIGHT) goto L83;
        float r52 = r20 + r114;
    L84:
        r216 = r52;
        r118 = r5;
        drawForm(r35, r216, r47 + r11, r48, this.mLegend);
        if (r118 != Legend.LegendDirection.LEFT_TO_RIGHT) goto L87;
        r216 = r216 + r215;
    L87:
        r49 = r48;
        goto L90
    L83:
        r52 = r20 - (r215 - r114);
        goto L84
    L78:
        r215 = Utils.convertDpToPixel(r48.formSize);
        goto L79
    L74:
        r117 = false;
        goto L76
    L191:
        return;
    L57:
        r46 = ((this.mViewPortHandler.getChartHeight() / 2.0f) - (this.mLegend.mNeededHeight / 2.0f)) + this.mLegend.getYOffset();
        goto L68
    L59:
        if (r15 != Legend.LegendHorizontalAlignment.CENTER) goto L61;
        float r53 = this.mViewPortHandler.getChartHeight();
    L62:
        r46 = r53 - (this.mLegend.mNeededHeight + r3);
        goto L68
    L61:
        r53 = this.mViewPortHandler.contentBottom();
        goto L62
    L64:
        if (r15 != Legend.LegendHorizontalAlignment.CENTER) goto L66;
        float r54 = 0.0f;
    L67:
        r46 = r54 + r3;
        goto L68
    L66:
        r54 = this.mViewPortHandler.contentTop();
        goto L67
    L184:
        return;
    L33:
        r7 = this.mViewPortHandler.contentRight();
        goto L34
    L12:
        if (r10 == 3) goto L15;
        r8 = r8;
        r18 = r9;
        r20 = 0.0f;
        goto L46
    L15:
        if (r1 != Legend.LegendOrientation.VERTICAL) goto L17;
        float r55 = this.mViewPortHandler.getChartWidth() / 2.0f;
    L19:
        if (r5 != Legend.LegendDirection.LEFT_TO_RIGHT) goto L21;
        float r119 = r6;
    L22:
        r19 = r55 + r119;
        if (r1 != Legend.LegendOrientation.VERTICAL) goto L29;
        r18 = r9;
        double r56 = r19;
        if (r5 != Legend.LegendDirection.LEFT_TO_RIGHT) goto L27;
        double r57 = (((double) (-this.mLegend.mNeededWidth)) / 2.0d) + ((double) r6);
    L28:
        r19 = (float) (r56 + r57);
        goto L37
    L27:
        r57 = (((double) this.mLegend.mNeededWidth) / 2.0d) - ((double) r6);
        goto L28
    L29:
        r8 = r8;
        r18 = r9;
        goto L37
    L21:
        r119 = -r6;
        goto L22
    L17:
        r55 = this.mViewPortHandler.contentLeft() + (this.mViewPortHandler.contentWidth() / 2.0f);
        goto L19
    L38:
        r8 = r8;
        r18 = r9;
        if (r1 == Legend.LegendOrientation.VERTICAL) goto L43;
        r6 = r6 + this.mViewPortHandler.contentLeft();
    L43:
        if (r5 != Legend.LegendDirection.RIGHT_TO_LEFT) goto L45;
        r19 = this.mLegend.mNeededWidth + r6;
        goto L37
    L45:
        r20 = r6;
        goto L46
    }

    protected void drawForm(Canvas r11, float r12, float r13, LegendEntry r14, Legend r15) {
        if (r14.formColor != 1122868) goto L5;
        return;
    L5:
        if (r14.formColor != 1122867) goto L7;
        return;
    L7:
        if (r14.formColor == 0) goto L40;
        int r0 = r11.save();
        Legend.LegendForm r1 = r14.form;
        if (r1 != Legend.LegendForm.DEFAULT) goto L12;
        r1 = r15.getForm();
    L12:
        this.mLegendFormPaint.setColor(r14.formColor);
        if (Float.isNaN(r14.formSize) == false) goto L15;
        float r2 = r15.getFormSize();
    L16:
        float r3 = Utils.convertDpToPixel(r2);
        float r4 = r3 / 2.0f;
        int r5 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[r1.ordinal()];
        if (r5 != 3) goto L19;
    L35:
        this.mLegendFormPaint.setStyle(Paint.Style.FILL);
        r11.drawCircle(r12 + r4, r13, r4, this.mLegendFormPaint);
    L36:
        r11.restoreToCount(r0);
        return;
    L19:
        if (r5 == 4) goto L35;
        if (r5 != 5) goto L23;
        this.mLegendFormPaint.setStyle(Paint.Style.FILL);
        r11.drawRect(r12, r13 - r4, r12 + r3, r13 + r4, this.mLegendFormPaint);
        goto L36
    L23:
        if (r5 != 6) goto L36;
        if (Float.isNaN(r14.formLineWidth) == false) goto L28;
        float r6 = r15.getFormLineWidth();
    L29:
        float r7 = Utils.convertDpToPixel(r6);
        if (r14.formLineDashEffect != null) goto L32;
        DashPathEffect r16 = r15.getFormLineDashEffect();
    L33:
        this.mLegendFormPaint.setStyle(Paint.Style.STROKE);
        this.mLegendFormPaint.setStrokeWidth(r7);
        this.mLegendFormPaint.setPathEffect(r16);
        this.mLineFormPath.reset();
        this.mLineFormPath.moveTo(r12, r13);
        this.mLineFormPath.lineTo(r12 + r3, r13);
        r11.drawPath(this.mLineFormPath, this.mLegendFormPaint);
        goto L36
    L32:
        r16 = r14.formLineDashEffect;
        goto L33
    L28:
        r6 = r14.formLineWidth;
        goto L29
    L15:
        r2 = r14.formSize;
        goto L16
    }

    protected void drawLabel(Canvas r1, float r2, float r3, String r4) {
        r1.drawText(r4, r2, r3, this.mLegendLabelPaint);
    }
}
