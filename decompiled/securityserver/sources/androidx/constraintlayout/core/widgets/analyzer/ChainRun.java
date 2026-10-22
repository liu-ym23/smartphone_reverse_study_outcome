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
        ConstraintWidget r1 = r0.getPreviousChainMember(this.orientation);
    L3:
        ConstraintWidget r4 = r1;
        ConstraintWidget r2 = r0;
        r0 = r4;
        if (r0 == null) goto L6;
        r1 = r0.getPreviousChainMember(this.orientation);
        goto L3
    L6:
        this.widget = r2;
        this.widgets.add(r2.getRun(this.orientation));
        ConstraintWidget r3 = r2.getNextChainMember(this.orientation);
    L7:
        if (r3 == null) goto L9;
        this.widgets.add(r3.getRun(this.orientation));
        r3 = r3.getNextChainMember(this.orientation);
        goto L7
    L9:
        Iterator<WidgetRun> r5 = this.widgets.iterator();
    L11:
        if (r5.hasNext() == false) goto L18;
        WidgetRun r6 = r5.next();
        int r7 = this.orientation;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L11;
        r6.widget.verticalChainRun = this;
        goto L11
    L14:
        r6.widget.horizontalChainRun = this;
        goto L11
    L18:
        if (this.orientation != 0) goto L25;
        if (((ConstraintWidgetContainer) this.widget.getParent()).isRtl() == false) goto L25;
        if (this.widgets.size() <= 1) goto L25;
        ArrayList<WidgetRun> r8 = this.widgets;
        this.widget = r8.get(r8.size() - 1).widget;
    L25:
        if (this.orientation != 0) goto L27;
        int r9 = this.widget.getHorizontalChainStyle();
    L28:
        this.chainStyle = r9;
        return;
    L27:
        r9 = this.widget.getVerticalChainStyle();
        goto L28
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
    public void apply() {
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
        if (r9 == null) goto L31;
        addTarget(this.end, r9, -r10);
    L31:
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
        return;
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
        DependencyNode r17 = getTarget(r13, 1);
        int r18 = r13.getMargin();
        ConstraintWidget r19 = getLastVisibleWidget();
        if (r19 == null) goto L29;
        r18 = r19.mBottom.getMargin();
    L29:
        if (r17 == null) goto L31;
        addTarget(this.end, r17, -r18);
        goto L31
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
    public void clear() {
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
        long r2 = r1 + ((long) r4.start.margin);
        long r5 = r4.getWrapDimension() + r2;
        r1 = ((long) r4.end.margin) + r5;
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
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
        if (this.end.resolved == false) goto L323;
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
        if (r11.matchConstraintsType != 1) goto L58;
        if (r10 != 0) goto L58;
        r20 = r12.wrapValue;
        r15 = r15 + 1;
    L56:
        r19 = true;
    L58:
        if (r12.resolved == false) goto L60;
        r20 = r111;
        goto L56
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
        if (r14 > r3) goto L82;
    L85:
        if (r15 <= 0) goto L135;
        float r112 = r3 - r14;
        int r113 = (int) ((r112 / r15) + 0.5f);
        int r114 = 0;
        int r115 = 0;
    L87:
        if (r114 >= r4) goto L114;
        WidgetRun r24 = this.widgets.get(r114);
        int r116 = r113;
        int r25 = r14;
        if (r24.widget.getVisibility() != 8) goto L92;
    L90:
        r2 = r2;
        r23 = r23;
        r112 = r112;
    L113:
        r114 = r114 + 1;
        r113 = r116;
        r14 = r25;
        r23 = r23;
        r112 = r112;
        r2 = r2;
        r22 = r22;
        goto L87
    L92:
        if (r24.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L90;
        DimensionDependency r117 = r24.dimension;
        if (r117.resolved == true) goto L90;
        if (r17 <= 0.0f) goto L98;
        int r26 = (int) (((r24.widget.mWeight[this.orientation] * r112) / r17) + 0.5f);
    L100:
        if (this.orientation != 0) goto L102;
        ConstraintWidget r118 = r24.widget;
        int r119 = r118.mMatchConstraintMaxWidth;
        int r120 = r118.mMatchConstraintMinWidth;
    L104:
        if (r24.matchConstraintsType != 1) goto L106;
        int r28 = Math.min(r26, r117.wrapValue);
    L107:
        int r29 = Math.max(r120, r28);
        if (r119 <= 0) goto L110;
        r29 = Math.min(r119, r29);
    L110:
        if (r29 == r26) goto L112;
        r115 = r115 + 1;
        r26 = r29;
    L112:
        r24.dimension.resolve(r26);
        goto L113
    L106:
        r28 = r26;
        goto L107
    L102:
        ConstraintWidget r121 = r24.widget;
        int r122 = r121.mMatchConstraintMaxHeight;
        r120 = r121.mMatchConstraintMinHeight;
        r119 = r122;
        goto L104
    L98:
        r26 = r116;
        goto L100
    L114:
        boolean r210 = r2;
        int r211 = r22;
        int r212 = r23;
        int r213 = r14;
        if (r115 <= 0) goto L129;
        r15 = r15 - r115;
        int r30 = 0;
        r14 = 0;
    L117:
        if (r30 >= r4) goto L130;
        WidgetRun r31 = this.widgets.get(r30);
        if (r31.widget.getVisibility() == 8) goto L128;
        if (r30 <= 0) goto L124;
        if (r30 < r5) goto L124;
        r14 = r14 + r31.start.margin;
    L124:
        r14 = r14 + r31.dimension.value;
        if (r30 >= r8) goto L128;
        if (r30 >= r6) goto L128;
        r14 = r14 + (-r31.end.margin);
    L128:
        r30 = r30 + 1;
    L130:
        int r32 = 2;
        if (this.chainStyle != 2) goto L134;
        if (r115 != 0) goto L134;
        int r33 = 0;
        this.chainStyle = 0;
    L136:
        if (r14 <= r3) goto L138;
        this.chainStyle = r32;
    L138:
        if (r211 <= 0) goto L142;
        if (r15 != 0) goto L142;
        if (r5 != r6) goto L142;
        this.chainStyle = r32;
    L142:
        int r34 = this.chainStyle;
        if (r34 != 1) goto L191;
        int r35 = r211;
        if (r35 <= 1) goto L147;
        int r36 = (r3 - r14) / (r35 - 1);
    L150:
        if (r15 <= 0) goto L152;
        r36 = r33;
    L152:
        int r37 = r33;
        int r38 = r212;
    L153:
        if (r37 >= r4) goto L324;
        if (r210 == false) goto L156;
        int r39 = r4 - (r37 + 1);
    L157:
        WidgetRun r40 = this.widgets.get(r39);
        if (r40.widget.getVisibility() != 8) goto L160;
        r40.start.resolve(r38);
        r40.end.resolve(r38);
    L190:
        r37 = r37 + 1;
        goto L153
    L160:
        if (r37 <= 0) goto L164;
        if (r210 == false) goto L163;
        r38 = r38 - r36;
        goto L164
    L163:
        r38 = r38 + r36;
    L164:
        if (r37 <= 0) goto L169;
        if (r37 < r5) goto L169;
        if (r210 == false) goto L168;
        r38 = r38 - r40.start.margin;
        goto L169
    L168:
        r38 = r38 + r40.start.margin;
    L169:
        if (r210 == false) goto L171;
        r40.end.resolve(r38);
    L172:
        DimensionDependency r41 = r40.dimension;
        int r123 = r41.value;
        if (r40.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L175;
    L177:
        if (r210 == false) goto L179;
        r38 = r38 - r123;
    L180:
        if (r210 == false) goto L183;
        r40.start.resolve(r38);
    L184:
        r40.resolved = true;
        if (r37 >= r8) goto L190;
        if (r37 >= r6) goto L190;
        if (r210 == false) goto L189;
        r38 = r38 - (-r40.end.margin);
        goto L190
    L189:
        r38 = r38 + (-r40.end.margin);
        goto L190
    L183:
        r40.end.resolve(r38);
        goto L184
    L179:
        r38 = r38 + r123;
        goto L180
    L175:
        if (r40.matchConstraintsType != 1) goto L177;
        r123 = r41.wrapValue;
        goto L177
    L171:
        r40.start.resolve(r38);
        goto L172
    L156:
        r39 = r37;
        goto L157
    L324:
        return;
    L147:
        if (r35 != 1) goto L149;
        r36 = (r3 - r14) / 2;
        goto L150
    L149:
        r36 = r33;
        goto L150
    L191:
        int r42 = r211;
        if (r34 != 0) goto L233;
        int r43 = (r3 - r14) / (r42 + 1);
        if (r15 <= 0) goto L196;
        r43 = r33;
    L196:
        int r44 = r33;
        int r45 = r212;
    L197:
        if (r44 >= r4) goto L325;
        if (r210 == false) goto L200;
        int r46 = r4 - (r44 + 1);
    L201:
        WidgetRun r47 = this.widgets.get(r46);
        if (r47.widget.getVisibility() != 8) goto L204;
        r47.start.resolve(r45);
        r47.end.resolve(r45);
    L231:
        r44 = r44 + 1;
        goto L197
    L204:
        if (r210 == false) goto L206;
        int r48 = r45 - r43;
    L207:
        if (r44 <= 0) goto L212;
        if (r44 < r5) goto L212;
        if (r210 == false) goto L211;
        r48 = r48 - r47.start.margin;
        goto L212
    L211:
        r48 = r48 + r47.start.margin;
    L212:
        if (r210 == false) goto L214;
        r47.end.resolve(r48);
    L215:
        DimensionDependency r49 = r47.dimension;
        int r124 = r49.value;
        if (r47.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L218;
    L220:
        if (r210 == false) goto L222;
        r45 = r48 - r124;
    L223:
        if (r210 == false) goto L225;
        r47.start.resolve(r45);
    L226:
        if (r44 >= r8) goto L231;
        if (r44 >= r6) goto L231;
        if (r210 == false) goto L230;
        r45 = r45 - (-r47.end.margin);
        goto L231
    L230:
        r45 = r45 + (-r47.end.margin);
        goto L231
    L225:
        r47.end.resolve(r45);
        goto L226
    L222:
        r45 = r48 + r124;
        goto L223
    L218:
        if (r47.matchConstraintsType != 1) goto L220;
        r124 = Math.min(r124, r49.wrapValue);
        goto L220
    L214:
        r47.start.resolve(r48);
        goto L215
    L206:
        r48 = r45 + r43;
        goto L207
    L200:
        r46 = r44;
        goto L201
    L325:
        return;
    L233:
        if (r34 == 2) goto L235;
        return;
    L235:
        if (this.orientation != 0) goto L237;
        float r50 = this.widget.getHorizontalBiasPercent();
    L238:
        if (r210 == false) goto L240;
        r50 = 1.0f - r50;
    L240:
        int r51 = (int) (((r3 - r14) * r50) + 0.5f);
        if (r51 < 0) goto L243;
        if (r15 > 0) goto L243;
    L244:
        if (r210 == false) goto L246;
        int r52 = r212 - r51;
    L247:
        int r53 = r33;
    L248:
        if (r53 >= r4) goto L326;
        if (r210 == false) goto L251;
        int r54 = r4 - (r53 + 1);
    L252:
        WidgetRun r55 = this.widgets.get(r54);
        if (r55.widget.getVisibility() != 8) goto L255;
        r55.start.resolve(r52);
        r55.end.resolve(r52);
    L280:
        r53 = r53 + 1;
        goto L248
    L255:
        if (r53 <= 0) goto L260;
        if (r53 < r5) goto L260;
        if (r210 == false) goto L259;
        r52 = r52 - r55.start.margin;
        goto L260
    L259:
        r52 = r52 + r55.start.margin;
    L260:
        if (r210 == false) goto L262;
        r55.end.resolve(r52);
    L263:
        DimensionDependency r56 = r55.dimension;
        int r125 = r56.value;
        if (r55.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L269;
        if (r55.matchConstraintsType != 1) goto L269;
        r125 = r56.wrapValue;
    L269:
        if (r210 == false) goto L271;
        r52 = r52 - r125;
    L272:
        if (r210 == false) goto L274;
        r55.start.resolve(r52);
    L275:
        if (r53 >= r8) goto L280;
        if (r53 >= r6) goto L280;
        if (r210 == false) goto L279;
        r52 = r52 - (-r55.end.margin);
        goto L280
    L279:
        r52 = r52 + (-r55.end.margin);
        goto L280
    L274:
        r55.end.resolve(r52);
        goto L275
    L271:
        r52 = r52 + r125;
        goto L272
    L262:
        r55.start.resolve(r52);
        goto L263
    L251:
        r54 = r53;
        goto L252
    L326:
        return;
    L246:
        r52 = r212 + r51;
    L243:
        r51 = r33;
        goto L244
    L237:
        r50 = this.widget.getVerticalBiasPercent();
    L134:
        r33 = 0;
        goto L136
    L129:
        r14 = r213;
        goto L130
    L135:
        r210 = r2;
        r211 = r22;
        r212 = r23;
        r33 = 0;
        r32 = 2;
        goto L136
    L82:
        if (r2 == false) goto L84;
        r23 = r23 + ((int) (((r14 - r3) / 2.0f) + 0.5f));
        goto L85
    L84:
        r23 = r23 - ((int) (((r14 - r3) / 2.0f) + 0.5f));
        goto L85
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
