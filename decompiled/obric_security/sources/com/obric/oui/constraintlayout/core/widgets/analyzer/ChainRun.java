package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class ChainRun extends WidgetRun {
    private int mChainStyle;
    ArrayList<WidgetRun> mWidgets;

    public ChainRun(ConstraintWidget r1, int r2) {
        super(r1);
        this.mWidgets = new ArrayList();
        this.orientation = r2;
        build();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ChainRun ");
        if (this.orientation != 0) goto L5;
        String r1 = "horizontal : ";
    L6:
        r0.append(r1);
        Iterator<WidgetRun> r3 = this.mWidgets.iterator();
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

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        int r0 = this.mWidgets.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (this.mWidgets.get(r2).supportsWrapComputation() == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int r0 = this.mWidgets.size();
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        WidgetRun r4 = this.mWidgets.get(r3);
        r1 = ((r1 + ((long) r4.start.mMargin)) + r4.getWrapDimension()) + ((long) r4.end.mMargin);
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    private void build() {
        ConstraintWidget r0 = this.mWidget;
        ConstraintWidget r1 = r0.getPreviousChainMember(this.orientation);
    L3:
        ConstraintWidget r4 = r1;
        ConstraintWidget r2 = r0;
        r0 = r4;
        if (r0 == null) goto L6;
        r1 = r0.getPreviousChainMember(this.orientation);
        goto L3
    L6:
        this.mWidget = r2;
        this.mWidgets.add(r2.getRun(this.orientation));
        ConstraintWidget r3 = r2.getNextChainMember(this.orientation);
    L7:
        if (r3 == null) goto L9;
        this.mWidgets.add(r3.getRun(this.orientation));
        r3 = r3.getNextChainMember(this.orientation);
        goto L7
    L9:
        Iterator<WidgetRun> r5 = this.mWidgets.iterator();
    L11:
        if (r5.hasNext() == false) goto L19;
        WidgetRun r6 = r5.next();
        if (this.orientation == 0) goto L14;
        if (this.orientation != 1) goto L11;
        r6.mWidget.verticalChainRun = this;
        goto L11
    L14:
        r6.mWidget.horizontalChainRun = this;
        goto L11
    L19:
        if (this.orientation == 0) goto L21;
    L23:
        boolean r7 = false;
    L24:
        if (r7 == false) goto L29;
        if (this.mWidgets.size() <= 1) goto L29;
        ArrayList<WidgetRun> r8 = this.mWidgets;
        this.mWidget = r8.get(r8.size() - 1).mWidget;
    L29:
        if (this.orientation != 0) goto L31;
        int r9 = this.mWidget.getHorizontalChainStyle();
    L32:
        this.mChainStyle = r9;
        return;
    L31:
        r9 = this.mWidget.getVerticalChainStyle();
        goto L32
    L21:
        if (((ConstraintWidgetContainer) this.mWidget.getParent()).isRtl() == false) goto L23;
        r7 = true;
        goto L24
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.mRunGroup = null;
        Iterator<WidgetRun> r1 = this.mWidgets.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().clear();
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r23) {
        if (this.start.resolved == true) goto L5;
        return;
    L5:
        if (this.end.resolved == false) goto L319;
        ConstraintWidget r1 = this.mWidget.getParent();
        if ((r1 instanceof ConstraintWidgetContainer) == false) goto L10;
        boolean r2 = ((ConstraintWidgetContainer) r1).isRtl();
    L11:
        int r3 = this.end.value - this.start.value;
        int r4 = this.mWidgets.size();
        int r5 = 0;
    L12:
        int r6 = -1;
        int r7 = 8;
        if (r5 >= r4) goto L17;
        if (this.mWidgets.get(r5).mWidget.getVisibility() != 8) goto L18;
        r5 = r5 + 1;
    L18:
        int r8 = r4 - 1;
        int r9 = r8;
    L19:
        if (r9 < 0) goto L24;
        if (this.mWidgets.get(r9).mWidget.getVisibility() != 8) goto L23;
        r9 = r9 - 1;
        goto L19
    L23:
        r6 = r9;
    L24:
        int r10 = 0;
    L26:
        if (r10 >= 2) goto L72;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        float r17 = 0.0f;
    L28:
        if (r13 >= r4) goto L67;
        WidgetRun r11 = this.mWidgets.get(r13);
        if (r11.mWidget.getVisibility() == r7) goto L66;
        r16 = r16 + 1;
        if (r13 <= 0) goto L36;
        if (r13 < r5) goto L36;
        r14 = r14 + r11.start.mMargin;
    L36:
        int r12 = r11.mDimension.value;
        if (r11.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L39;
        boolean r18 = true;
    L40:
        if (r18 == false) goto L52;
        if (this.orientation != 0) goto L47;
        if (r11.mWidget.mHorizontalRun.mDimension.resolved == true) goto L47;
        return;
    L47:
        if (this.orientation == 1) goto L49;
    L58:
        if (r18 == true) goto L62;
        r15 = r15 + 1;
        float r19 = r11.mWidget.mWeight[this.orientation];
        if (r19 < 0.0f) goto L63;
        r17 = r17 + r19;
    L63:
        if (r13 >= r8) goto L66;
        if (r13 >= r6) goto L66;
        r14 = r14 + (-r11.end.mMargin);
        goto L66
    L62:
        r14 = r14 + r12;
        goto L63
    L49:
        if (r11.mWidget.mVerticalRun.mDimension.resolved == true) goto L58;
        return;
    L52:
        if (r11.matchConstraintsType != 1) goto L56;
        if (r10 != 0) goto L56;
        r12 = r11.mDimension.wrapValue;
        r15 = r15 + 1;
    L57:
        r18 = true;
    L56:
        if (r11.mDimension.resolved == false) goto L58;
    L39:
        r18 = false;
    L66:
        r13 = r13 + 1;
        r7 = 8;
        goto L28
    L67:
        if (r14 < r3) goto L71;
        if (r15 == 0) goto L71;
        r10 = r10 + 1;
        r7 = 8;
    L71:
        int r20 = r16;
    L73:
        int r21 = this.start.value;
        if (r2 == false) goto L77;
        r21 = this.end.value;
    L77:
        if (r14 > r3) goto L79;
    L82:
        if (r15 <= 0) goto L134;
        float r110 = r3 - r14;
        int r111 = (int) ((r110 / r15) + 0.5f);
        int r112 = 0;
        int r113 = 0;
    L84:
        if (r112 >= r4) goto L112;
        WidgetRun r114 = this.mWidgets.get(r112);
        int r115 = r111;
        if (r114.mWidget.getVisibility() != 8) goto L89;
    L110:
        r110 = r110;
    L111:
        r112 = r112 + 1;
        r111 = r115;
        r110 = r110;
        r14 = r14;
        r21 = r21;
        goto L84
    L89:
        if (r114.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L110;
        if (r114.mDimension.resolved == true) goto L110;
        if (r17 <= 0.0f) goto L95;
        int r22 = (int) (((r114.mWidget.mWeight[this.orientation] * r110) / r17) + 0.5f);
    L97:
        if (this.orientation != 0) goto L99;
        int r116 = r114.mWidget.mMatchConstraintMaxWidth;
        int r117 = r114.mWidget.mMatchConstraintMinWidth;
    L101:
        if (r114.matchConstraintsType != 1) goto L103;
        int r24 = Math.min(r22, r114.mDimension.wrapValue);
    L104:
        int r25 = Math.max(r117, r24);
        if (r116 <= 0) goto L107;
        r25 = Math.min(r116, r25);
    L107:
        if (r25 == r22) goto L109;
        r113 = r113 + 1;
        r22 = r25;
    L109:
        r114.mDimension.resolve(r22);
        goto L111
    L103:
        r24 = r22;
        goto L104
    L99:
        r116 = r114.mWidget.mMatchConstraintMaxHeight;
        r117 = r114.mWidget.mMatchConstraintMinHeight;
        goto L101
    L95:
        r22 = r115;
        goto L97
    L112:
        int r26 = r21;
        int r27 = r14;
        if (r113 <= 0) goto L128;
        r15 = r15 - r113;
        int r28 = 0;
        int r29 = 0;
    L115:
        if (r28 >= r4) goto L127;
        WidgetRun r118 = this.mWidgets.get(r28);
        if (r118.mWidget.getVisibility() == 8) goto L126;
        if (r28 <= 0) goto L122;
        if (r28 < r5) goto L122;
        r29 = r29 + r118.start.mMargin;
    L122:
        r29 = r29 + r118.mDimension.value;
        if (r28 >= r8) goto L126;
        if (r28 >= r6) goto L126;
        r29 = r29 + (-r118.end.mMargin);
    L126:
        r28 = r28 + 1;
        goto L115
    L127:
        r14 = r29;
    L129:
        int r30 = 2;
        if (this.mChainStyle != 2) goto L133;
        if (r113 != 0) goto L133;
        int r31 = 0;
        this.mChainStyle = 0;
    L135:
        if (r14 <= r3) goto L137;
        this.mChainStyle = r30;
    L137:
        if (r20 <= 0) goto L141;
        if (r15 != 0) goto L141;
        if (r5 != r6) goto L141;
        this.mChainStyle = r30;
    L141:
        int r32 = this.mChainStyle;
        if (r32 != 1) goto L188;
        if (r20 <= 1) goto L145;
        int r33 = (r3 - r14) / (r20 - 1);
    L148:
        if (r15 <= 0) goto L150;
        r33 = r31;
    L150:
        int r34 = r31;
        int r35 = r26;
    L151:
        if (r34 >= r4) goto L320;
        if (r2 == false) goto L154;
        int r36 = r4 - (r34 + 1);
    L155:
        WidgetRun r37 = this.mWidgets.get(r36);
        if (r37.mWidget.getVisibility() != 8) goto L158;
        r37.start.resolve(r35);
        r37.end.resolve(r35);
    L187:
        r34 = r34 + 1;
        goto L151
    L158:
        if (r34 <= 0) goto L162;
        if (r2 == false) goto L161;
        r35 = r35 - r33;
        goto L162
    L161:
        r35 = r35 + r33;
    L162:
        if (r34 <= 0) goto L167;
        if (r34 < r5) goto L167;
        if (r2 == false) goto L166;
        r35 = r35 - r37.start.mMargin;
        goto L167
    L166:
        r35 = r35 + r37.start.mMargin;
    L167:
        if (r2 == false) goto L169;
        r37.end.resolve(r35);
    L170:
        int r119 = r37.mDimension.value;
        if (r37.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L173;
    L175:
        if (r2 == false) goto L177;
        r35 = r35 - r119;
    L178:
        if (r2 == false) goto L180;
        r37.start.resolve(r35);
    L181:
        r37.mResolved = true;
        if (r34 >= r8) goto L187;
        if (r34 >= r6) goto L187;
        if (r2 == false) goto L186;
        r35 = r35 - (-r37.end.mMargin);
        goto L187
    L186:
        r35 = r35 + (-r37.end.mMargin);
        goto L187
    L180:
        r37.end.resolve(r35);
        goto L181
    L177:
        r35 = r35 + r119;
        goto L178
    L173:
        if (r37.matchConstraintsType != 1) goto L175;
        r119 = r37.mDimension.wrapValue;
        goto L175
    L169:
        r37.start.resolve(r35);
        goto L170
    L154:
        r36 = r34;
        goto L155
    L320:
        return;
    L145:
        if (r20 != 1) goto L147;
        r33 = (r3 - r14) / 2;
        goto L148
    L147:
        r33 = r31;
        goto L148
    L188:
        if (r32 != 0) goto L229;
        int r38 = (r3 - r14) / (r20 + 1);
        if (r15 <= 0) goto L192;
        r38 = r31;
    L192:
        int r39 = r31;
        int r40 = r26;
    L193:
        if (r39 >= r4) goto L321;
        if (r2 == false) goto L196;
        int r41 = r4 - (r39 + 1);
    L197:
        WidgetRun r42 = this.mWidgets.get(r41);
        if (r42.mWidget.getVisibility() != 8) goto L200;
        r42.start.resolve(r40);
        r42.end.resolve(r40);
    L227:
        r39 = r39 + 1;
        goto L193
    L200:
        if (r2 == false) goto L202;
        int r43 = r40 - r38;
    L203:
        if (r39 <= 0) goto L208;
        if (r39 < r5) goto L208;
        if (r2 == false) goto L207;
        r43 = r43 - r42.start.mMargin;
        goto L208
    L207:
        r43 = r43 + r42.start.mMargin;
    L208:
        if (r2 == false) goto L210;
        r42.end.resolve(r43);
    L211:
        int r120 = r42.mDimension.value;
        if (r42.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L214;
    L216:
        if (r2 == false) goto L218;
        r40 = r43 - r120;
    L219:
        if (r2 == false) goto L221;
        r42.start.resolve(r40);
    L222:
        if (r39 >= r8) goto L227;
        if (r39 >= r6) goto L227;
        if (r2 == false) goto L226;
        r40 = r40 - (-r42.end.mMargin);
        goto L227
    L226:
        r40 = r40 + (-r42.end.mMargin);
        goto L227
    L221:
        r42.end.resolve(r40);
        goto L222
    L218:
        r40 = r43 + r120;
        goto L219
    L214:
        if (r42.matchConstraintsType != 1) goto L216;
        r120 = Math.min(r120, r42.mDimension.wrapValue);
        goto L216
    L210:
        r42.start.resolve(r43);
        goto L211
    L202:
        r43 = r40 + r38;
        goto L203
    L196:
        r41 = r39;
        goto L197
    L321:
        return;
    L229:
        if (r32 == 2) goto L231;
        return;
    L231:
        if (this.orientation != 0) goto L233;
        float r44 = this.mWidget.getHorizontalBiasPercent();
    L234:
        if (r2 == false) goto L236;
        r44 = 1.0f - r44;
    L236:
        int r45 = (int) (((r3 - r14) * r44) + 0.5f);
        if (r45 < 0) goto L239;
        if (r15 > 0) goto L239;
    L240:
        if (r2 == false) goto L242;
        int r46 = r26 - r45;
    L243:
        int r47 = r31;
    L244:
        if (r47 >= r4) goto L322;
        if (r2 == false) goto L247;
        int r48 = r4 - (r47 + 1);
    L248:
        WidgetRun r49 = this.mWidgets.get(r48);
        if (r49.mWidget.getVisibility() != 8) goto L251;
        r49.start.resolve(r46);
        r49.end.resolve(r46);
    L276:
        r47 = r47 + 1;
        goto L244
    L251:
        if (r47 <= 0) goto L256;
        if (r47 < r5) goto L256;
        if (r2 == false) goto L255;
        r46 = r46 - r49.start.mMargin;
        goto L256
    L255:
        r46 = r46 + r49.start.mMargin;
    L256:
        if (r2 == false) goto L258;
        r49.end.resolve(r46);
    L259:
        int r50 = r49.mDimension.value;
        if (r49.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L265;
        if (r49.matchConstraintsType != 1) goto L265;
        r50 = r49.mDimension.wrapValue;
    L265:
        if (r2 == false) goto L267;
        r46 = r46 - r50;
    L268:
        if (r2 == false) goto L270;
        r49.start.resolve(r46);
    L271:
        if (r47 >= r8) goto L276;
        if (r47 >= r6) goto L276;
        if (r2 == false) goto L275;
        r46 = r46 - (-r49.end.mMargin);
        goto L276
    L275:
        r46 = r46 + (-r49.end.mMargin);
        goto L276
    L270:
        r49.end.resolve(r46);
        goto L271
    L267:
        r46 = r46 + r50;
        goto L268
    L258:
        r49.start.resolve(r46);
        goto L259
    L247:
        r48 = r47;
        goto L248
    L322:
        return;
    L242:
        r46 = r26 + r45;
    L239:
        r45 = r31;
        goto L240
    L233:
        r44 = this.mWidget.getVerticalBiasPercent();
    L133:
        r31 = 0;
        goto L135
    L128:
        r14 = r27;
        goto L129
    L134:
        r26 = r21;
        r31 = 0;
        r30 = 2;
        goto L135
    L79:
        if (r2 == false) goto L81;
        r21 = r21 + ((int) (((r14 - r3) / 2.0f) + 0.5f));
        goto L82
    L81:
        r21 = r21 - ((int) (((r14 - r3) / 2.0f) + 0.5f));
        goto L82
    L72:
        r20 = 0;
        r14 = 0;
        r15 = 0;
        r17 = 0.0f;
        goto L73
    L17:
        r5 = -1;
        goto L18
    L10:
        r2 = false;
        goto L11
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        int r0 = 0;
    L4:
        if (r0 >= this.mWidgets.size()) goto L6;
        this.mWidgets.get(r0).applyToWidget();
        r0 = r0 + 1;
        goto L4
    }

    private ConstraintWidget getFirstVisibleWidget() {
        int r0 = 0;
    L4:
        if (r0 >= this.mWidgets.size()) goto L10;
        WidgetRun r1 = this.mWidgets.get(r0);
        if (r1.mWidget.getVisibility() != 8) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return r1.mWidget;
    L10:
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        int r0 = this.mWidgets.size() - 1;
    L3:
        if (r0 < 0) goto L9;
        WidgetRun r1 = this.mWidgets.get(r0);
        if (r1.mWidget.getVisibility() != 8) goto L7;
        r0 = r0 - 1;
        goto L3
    L7:
        return r1.mWidget;
    L9:
        return null;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        Iterator<WidgetRun> r0 = this.mWidgets.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().apply();
        goto L4
    L6:
        int r1 = this.mWidgets.size();
        if (r1 >= 1) goto L9;
        return;
    L9:
        ConstraintWidget r2 = this.mWidgets.get(0).mWidget;
        ConstraintWidget r3 = this.mWidgets.get(r1 - 1).mWidget;
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
}
