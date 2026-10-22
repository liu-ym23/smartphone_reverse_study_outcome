package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets;

    public ChainRun(ConstraintWidget r1, int r2) {
        super(r1);
        this.widgets = new ArrayList();
        this.orientation = r2;
        build();
    }

    private void build() {
        ConstraintWidget r0 = this.widget;
    L3:
        ConstraintWidget r1 = r0;
        r0 = r0.getPreviousChainMember(this.orientation);
        if (r0 != null) goto L3;
        this.widget = r1;
        this.widgets.add(r1.getRun(this.orientation));
        ConstraintWidget r2 = r1.getNextChainMember(this.orientation);
    L7:
        if (r2 == null) goto L9;
        this.widgets.add(r2.getRun(this.orientation));
        r2 = r2.getNextChainMember(this.orientation);
        goto L7
    L9:
        Iterator<WidgetRun> r3 = this.widgets.iterator();
    L11:
        if (r3.hasNext() == false) goto L18;
        WidgetRun r4 = r3.next();
        int r5 = this.orientation;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L11;
        r4.widget.verticalChainRun = this;
        goto L11
    L14:
        r4.widget.horizontalChainRun = this;
        goto L11
    L18:
        if (this.orientation == 0) goto L20;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == false) goto L28;
        if (this.widgets.size() <= 1) goto L28;
        ArrayList<WidgetRun> r7 = this.widgets;
        this.widget = r7.get(r7.size() - 1).widget;
    L28:
        if (this.orientation != 0) goto L30;
        int r8 = this.widget.getHorizontalChainStyle();
    L31:
        this.chainStyle = r8;
        return;
    L30:
        r8 = this.widget.getVerticalChainStyle();
        goto L31
    L20:
        if (((ConstraintWidgetContainer) this.widget.getParent()).isRtl() == false) goto L22;
        r6 = true;
        goto L23
    }

    private ConstraintWidget getFirstVisibleWidget() {
        int r0 = 0;
    L4:
        if (r0 >= this.widgets.size()) goto L10;
        WidgetRun r1 = this.widgets.get(r0);
        if (r1.widget.getVisibility() != 8) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return r1.widget;
    L10:
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        int r0 = this.widgets.size() - 1;
    L3:
        if (r0 < 0) goto L9;
        WidgetRun r1 = this.widgets.get(r0);
        if (r1.widget.getVisibility() != 8) goto L7;
        r0 = r0 - 1;
        goto L3
    L7:
        return r1.widget;
    L9:
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        Iterator<WidgetRun> r0 = this.widgets.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().apply();
        goto L4
    L6:
        int r1 = this.widgets.size();
        if (r1 >= 1) goto L9;
        return;
    L9:
        ConstraintWidget r2 = this.widgets.get(0).widget;
        ConstraintWidget r3 = this.widgets.get(r1 - 1).widget;
        if (this.orientation != 0) goto L21;
        ConstraintAnchor r4 = r2.mLeft;
        ConstraintAnchor r5 = r3.mRight;
        DependencyNode r6 = getTarget(r4, 0);
        int r7 = r4.getMargin();
        ConstraintWidget r8 = getFirstVisibleWidget();
        if (r8 == null) goto L14;
        r7 = r8.mLeft.getMargin();
    L14:
        if (r6 == null) goto L16;
        addTarget(this.start, r6, r7);
    L16:
        DependencyNode r9 = getTarget(r5, 0);
        int r10 = r5.getMargin();
        ConstraintWidget r11 = getLastVisibleWidget();
        if (r11 == null) goto L19;
        r10 = r11.mRight.getMargin();
    L19:
        if (r9 != null) goto L30;
    L31:
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
        return;
    L30:
        addTarget(this.end, r9, -r10);
        goto L31
    L21:
        ConstraintAnchor r12 = r2.mTop;
        ConstraintAnchor r13 = r3.mBottom;
        DependencyNode r14 = getTarget(r12, 1);
        int r15 = r12.getMargin();
        ConstraintWidget r16 = getFirstVisibleWidget();
        if (r16 == null) goto L24;
        r15 = r16.mTop.getMargin();
    L24:
        if (r14 == null) goto L26;
        addTarget(this.start, r14, r15);
    L26:
        r9 = getTarget(r13, 1);
        r10 = r13.getMargin();
        ConstraintWidget r17 = getLastVisibleWidget();
        if (r17 == null) goto L29;
        r10 = r17.mBottom.getMargin();
    L29:
        if (r9 == null) goto L31;
        goto L30
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        int r0 = 0;
    L4:
        if (r0 >= this.widgets.size()) goto L6;
        this.widgets.get(r0).applyToWidget();
        r0 = r0 + 1;
        goto L4
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> r1 = this.widgets.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().clear();
        goto L4
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int r0 = this.widgets.size();
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        WidgetRun r4 = this.widgets.get(r3);
        r1 = ((r1 + ((long) r4.start.margin)) + r4.getWrapDimension()) + ((long) r4.end.margin);
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        int r0 = this.widgets.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (this.widgets.get(r2).supportsWrapComputation() == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ChainRun ");
        if (this.orientation != 0) goto L5;
        String r1 = "horizontal : ";
    L6:
        r0.append(r1);
        Iterator<WidgetRun> r3 = this.widgets.iterator();
    L8:
        if (r3.hasNext() == false) goto L11;
        WidgetRun r2 = r3.next();
        r0.append("<");
        r0.append(r2);
        r0.append("> ");
        goto L8
    L11:
        return r0.toString();
    L5:
        r1 = "vertical : ";
        goto L6
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r27) {
        if (this.start.resolved == true) goto L5;
        return;
    L5:
        if (this.end.resolved == false) goto L330;
        ConstraintWidget r1 = this.widget.getParent();
        if ((r1 instanceof ConstraintWidgetContainer) == false) goto L10;
        boolean r2 = ((ConstraintWidgetContainer) r1).isRtl();
    L11:
        int r3 = this.end.value - this.start.value;
        int r4 = this.widgets.size();
        int r5 = 0;
    L12:
        int r6 = -1;
        int r7 = 8;
        if (r5 >= r4) goto L17;
        if (this.widgets.get(r5).widget.getVisibility() != 8) goto L18;
        r5 = r5 + 1;
    L18:
        int r8 = r4 - 1;
        int r9 = r8;
    L19:
        if (r9 < 0) goto L24;
        if (this.widgets.get(r9).widget.getVisibility() != 8) goto L23;
        r9 = r9 - 1;
        goto L19
    L23:
        r6 = r9;
    L24:
        int r10 = 0;
    L26:
        if (r10 >= 2) goto L75;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        float r17 = 0.0f;
    L28:
        if (r13 >= r4) goto L70;
        WidgetRun r11 = this.widgets.get(r13);
        if (r11.widget.getVisibility() == r7) goto L69;
        r16 = r16 + 1;
        if (r13 <= 0) goto L36;
        if (r13 < r5) goto L36;
        r14 = r14 + r11.start.margin;
    L36:
        DimensionDependency r12 = r11.dimension;
        int r18 = r12.value;
        if (r11.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L39;
        boolean r19 = true;
    L40:
        if (r19 == false) goto L52;
        int r110 = this.orientation;
        if (r110 != 0) goto L47;
        if (r11.widget.horizontalRun.dimension.resolved == true) goto L47;
        return;
    L47:
        if (r110 == 1) goto L49;
    L51:
        int r111 = r18;
    L60:
        int r20 = r111;
    L61:
        if (r19 == true) goto L65;
        r15 = r15 + 1;
        float r21 = r11.widget.mWeight[this.orientation];
        if (r21 < 0.0f) goto L66;
        r17 = r17 + r21;
    L66:
        if (r13 >= r8) goto L69;
        if (r13 >= r6) goto L69;
        r14 = r14 + (-r11.end.margin);
        goto L69
    L65:
        r14 = r14 + r20;
        goto L66
    L49:
        if (r11.widget.verticalRun.dimension.resolved == true) goto L51;
        return;
    L52:
        r111 = r18;
        if (r11.matchConstraintsType != 1) goto L57;
        if (r10 != 0) goto L57;
        r20 = r12.wrapValue;
        r15 = r15 + 1;
    L59:
        r19 = true;
    L57:
        if (r12.resolved == false) goto L60;
        r20 = r111;
        goto L59
    L39:
        r19 = false;
    L69:
        r13 = r13 + 1;
        r7 = 8;
        goto L28
    L70:
        if (r14 < r3) goto L74;
        if (r15 == 0) goto L74;
        r10 = r10 + 1;
        r7 = 8;
    L74:
        int r22 = r16;
    L76:
        int r23 = this.start.value;
        if (r2 == false) goto L80;
        r23 = this.end.value;
    L80:
        if (r14 <= r3) goto L85;
        int r112 = (int) (((r14 - r3) / 2.0f) + 0.5f);
        if (r2 == false) goto L84;
        r23 = r23 + r112;
        goto L85
    L84:
        r23 = r23 - r112;
    L85:
        if (r15 <= 0) goto L137;
        float r113 = r3 - r14;
        int r114 = (int) ((r113 / r15) + 0.5f);
        int r115 = 0;
        int r116 = 0;
    L87:
        if (r115 >= r4) goto L115;
        WidgetRun r24 = this.widgets.get(r115);
        int r117 = r114;
        int r25 = r14;
        if (r24.widget.getVisibility() != 8) goto L92;
    L113:
        r2 = r2;
        r23 = r23;
        r113 = r113;
    L114:
        r115 = r115 + 1;
        r114 = r117;
        r14 = r25;
        r23 = r23;
        r113 = r113;
        r2 = r2;
        r22 = r22;
        goto L87
    L92:
        if (r24.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L113;
        DimensionDependency r118 = r24.dimension;
        if (r118.resolved == true) goto L113;
        if (r17 <= 0.0f) goto L98;
        int r26 = (int) (((r24.widget.mWeight[this.orientation] * r113) / r17) + 0.5f);
    L100:
        if (this.orientation != 0) goto L102;
        ConstraintWidget r119 = r24.widget;
        int r120 = r119.mMatchConstraintMaxWidth;
        int r121 = r119.mMatchConstraintMinWidth;
    L104:
        if (r24.matchConstraintsType != 1) goto L106;
        int r28 = Math.min(r26, r118.wrapValue);
    L107:
        int r29 = Math.max(r121, r28);
        if (r120 <= 0) goto L110;
        r29 = Math.min(r120, r29);
    L110:
        if (r29 == r26) goto L112;
        r116 = r116 + 1;
        r26 = r29;
    L112:
        r24.dimension.resolve(r26);
        goto L114
    L106:
        r28 = r26;
        goto L107
    L102:
        ConstraintWidget r122 = r24.widget;
        int r123 = r122.mMatchConstraintMaxHeight;
        r121 = r122.mMatchConstraintMinHeight;
        r120 = r123;
        goto L104
    L98:
        r26 = r117;
        goto L100
    L115:
        boolean r210 = r2;
        int r211 = r22;
        int r212 = r23;
        int r213 = r14;
        if (r116 <= 0) goto L131;
        r15 = r15 - r116;
        int r30 = 0;
        int r31 = 0;
    L118:
        if (r30 >= r4) goto L130;
        WidgetRun r32 = this.widgets.get(r30);
        if (r32.widget.getVisibility() == 8) goto L129;
        if (r30 <= 0) goto L125;
        if (r30 < r5) goto L125;
        r31 = r31 + r32.start.margin;
    L125:
        r31 = r31 + r32.dimension.value;
        if (r30 >= r8) goto L129;
        if (r30 >= r6) goto L129;
        r31 = r31 + (-r32.end.margin);
    L129:
        r30 = r30 + 1;
        goto L118
    L130:
        r14 = r31;
    L132:
        int r33 = 2;
        if (this.chainStyle != 2) goto L136;
        if (r116 != 0) goto L136;
        int r34 = 0;
        this.chainStyle = 0;
    L138:
        if (r14 <= r3) goto L140;
        this.chainStyle = r33;
    L140:
        if (r211 <= 0) goto L144;
        if (r15 != 0) goto L144;
        if (r5 != r6) goto L144;
        this.chainStyle = r33;
    L144:
        int r35 = this.chainStyle;
        int r36 = r211;
        if (r35 != 1) goto L193;
        if (r36 <= 1) goto L148;
        int r37 = (r3 - r14) / (r36 - 1);
    L151:
        if (r15 <= 0) goto L153;
        r37 = r34;
    L153:
        int r38 = r34;
        int r39 = r212;
    L154:
        if (r38 >= r4) goto L331;
        if (r210 == false) goto L157;
        int r40 = r4 - (r38 + 1);
    L158:
        WidgetRun r41 = this.widgets.get(r40);
        if (r41.widget.getVisibility() != 8) goto L161;
        r41.start.resolve(r39);
        r41.end.resolve(r39);
    L192:
        r38 = r38 + 1;
        goto L154
    L161:
        if (r38 <= 0) goto L165;
        if (r210 == false) goto L164;
        r39 = r39 - r37;
        goto L165
    L164:
        r39 = r39 + r37;
    L165:
        if (r38 <= 0) goto L171;
        if (r38 < r5) goto L171;
        int r42 = r41.start.margin;
        if (r210 == false) goto L170;
        r39 = r39 - r42;
        goto L171
    L170:
        r39 = r39 + r42;
    L171:
        if (r210 == false) goto L173;
        DependencyNode r43 = r41.end;
    L174:
        r43.resolve(r39);
        DimensionDependency r44 = r41.dimension;
        int r124 = r44.value;
        if (r41.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L177;
    L179:
        if (r210 == false) goto L181;
        r39 = r39 - r124;
    L182:
        if (r210 == false) goto L184;
        DependencyNode r45 = r41.start;
    L185:
        r45.resolve(r39);
        r41.resolved = true;
        if (r38 >= r8) goto L192;
        if (r38 >= r6) goto L192;
        int r46 = -r41.end.margin;
        if (r210 == false) goto L191;
        r39 = r39 - r46;
        goto L192
    L191:
        r39 = r39 + r46;
        goto L192
    L184:
        r45 = r41.end;
        goto L185
    L181:
        r39 = r39 + r124;
        goto L182
    L177:
        if (r41.matchConstraintsType != 1) goto L179;
        r124 = r44.wrapValue;
        goto L179
    L173:
        r43 = r41.start;
        goto L174
    L157:
        r40 = r38;
        goto L158
    L331:
        return;
    L148:
        if (r36 != 1) goto L150;
        r37 = (r3 - r14) / 2;
        goto L151
    L150:
        r37 = r34;
        goto L151
    L193:
        if (r35 != 0) goto L237;
        int r47 = (r3 - r14) / (r36 + 1);
        if (r15 <= 0) goto L197;
        r47 = r34;
    L197:
        int r48 = r34;
        int r49 = r212;
    L198:
        if (r48 >= r4) goto L332;
        if (r210 == false) goto L201;
        int r50 = r4 - (r48 + 1);
    L202:
        WidgetRun r51 = this.widgets.get(r50);
        if (r51.widget.getVisibility() != 8) goto L205;
        r51.start.resolve(r49);
        r51.end.resolve(r49);
    L235:
        r48 = r48 + 1;
        goto L198
    L205:
        if (r210 == false) goto L207;
        int r52 = r49 - r47;
    L208:
        if (r48 <= 0) goto L214;
        if (r48 < r5) goto L214;
        int r53 = r51.start.margin;
        if (r210 == false) goto L213;
        r52 = r52 - r53;
        goto L214
    L213:
        r52 = r52 + r53;
    L214:
        if (r210 == false) goto L216;
        DependencyNode r54 = r51.end;
    L217:
        r54.resolve(r52);
        DimensionDependency r55 = r51.dimension;
        int r125 = r55.value;
        if (r51.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L220;
    L222:
        if (r210 == false) goto L224;
        r49 = r52 - r125;
    L225:
        if (r210 == false) goto L227;
        DependencyNode r56 = r51.start;
    L228:
        r56.resolve(r49);
        if (r48 >= r8) goto L235;
        if (r48 >= r6) goto L235;
        int r57 = -r51.end.margin;
        if (r210 == false) goto L234;
        r49 = r49 - r57;
        goto L235
    L234:
        r49 = r49 + r57;
        goto L235
    L227:
        r56 = r51.end;
        goto L228
    L224:
        r49 = r52 + r125;
        goto L225
    L220:
        if (r51.matchConstraintsType != 1) goto L222;
        r125 = Math.min(r125, r55.wrapValue);
        goto L222
    L216:
        r54 = r51.start;
        goto L217
    L207:
        r52 = r49 + r47;
        goto L208
    L201:
        r50 = r48;
        goto L202
    L332:
        return;
    L237:
        if (r35 == 2) goto L239;
        return;
    L239:
        if (this.orientation != 0) goto L241;
        float r58 = this.widget.getHorizontalBiasPercent();
    L242:
        if (r210 == false) goto L244;
        r58 = 1.0f - r58;
    L244:
        int r59 = (int) (((r3 - r14) * r58) + 0.5f);
        if (r59 < 0) goto L247;
        if (r15 > 0) goto L247;
    L248:
        if (r210 == false) goto L250;
        int r60 = r212 - r59;
    L251:
        int r61 = r34;
    L252:
        if (r61 >= r4) goto L333;
        if (r210 == false) goto L255;
        int r62 = r4 - (r61 + 1);
    L256:
        WidgetRun r63 = this.widgets.get(r62);
        if (r63.widget.getVisibility() != 8) goto L259;
        r63.start.resolve(r60);
        r63.end.resolve(r60);
    L287:
        r61 = r61 + 1;
        goto L252
    L259:
        if (r61 <= 0) goto L265;
        if (r61 < r5) goto L265;
        int r64 = r63.start.margin;
        if (r210 == false) goto L264;
        r60 = r60 - r64;
        goto L265
    L264:
        r60 = r60 + r64;
    L265:
        if (r210 == false) goto L267;
        DependencyNode r65 = r63.end;
    L268:
        r65.resolve(r60);
        DimensionDependency r66 = r63.dimension;
        int r126 = r66.value;
        if (r63.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L274;
        if (r63.matchConstraintsType != 1) goto L274;
        r126 = r66.wrapValue;
    L274:
        if (r210 == false) goto L276;
        r60 = r60 - r126;
    L277:
        if (r210 == false) goto L279;
        DependencyNode r67 = r63.start;
    L280:
        r67.resolve(r60);
        if (r61 >= r8) goto L287;
        if (r61 >= r6) goto L287;
        int r68 = -r63.end.margin;
        if (r210 == false) goto L286;
        r60 = r60 - r68;
        goto L287
    L286:
        r60 = r60 + r68;
        goto L287
    L279:
        r67 = r63.end;
        goto L280
    L276:
        r60 = r60 + r126;
        goto L277
    L267:
        r65 = r63.start;
        goto L268
    L255:
        r62 = r61;
        goto L256
    L333:
        return;
    L250:
        r60 = r212 + r59;
    L247:
        r59 = r34;
        goto L248
    L241:
        r58 = this.widget.getVerticalBiasPercent();
    L136:
        r34 = 0;
        goto L138
    L131:
        r14 = r213;
        goto L132
    L137:
        r210 = r2;
        r211 = r22;
        r212 = r23;
        r34 = 0;
        r33 = 2;
        goto L138
    L75:
        r22 = 0;
        r14 = 0;
        r15 = 0;
        r17 = 0.0f;
        goto L76
    L17:
        r5 = -1;
        goto L18
    L10:
        r2 = false;
        goto L11
    }
}
