package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.Barrier;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.obric.oui.constraintlayout.core.widgets.Flow;
import com.obric.oui.constraintlayout.core.widgets.Guideline;
import com.obric.oui.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class Grouping {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_GROUPING = false;
    private static final boolean FORCE_USE = true;

    public Grouping() {
    }

    public static boolean validInGroup(ConstraintWidget.DimensionBehaviour r3, ConstraintWidget.DimensionBehaviour r4, ConstraintWidget.DimensionBehaviour r5, ConstraintWidget.DimensionBehaviour r6) {
        if (r5 != ConstraintWidget.DimensionBehaviour.FIXED) goto L5;
    L12:
        boolean r7 = true;
    L14:
        if (r6 != ConstraintWidget.DimensionBehaviour.FIXED) goto L16;
    L23:
        boolean r8 = true;
    L24:
        if (r7 == true) goto L28;
        if (r8 == true) goto L28;
        return false;
    L28:
        return true;
    L16:
        if (r6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L23;
        if (r6 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L20;
    L22:
        r8 = false;
        goto L24
    L20:
        if (r4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L22;
    L5:
        if (r5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L12;
        if (r5 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L9;
    L11:
        r7 = false;
        goto L14
    L9:
        if (r3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L11;
        goto L11
    }

    public static boolean simpleSolvingPass(ConstraintWidgetContainer r16, BasicMeasure.Measurer r17) {
        ArrayList<ConstraintWidget> r1 = r16.getChildren();
        int r2 = r1.size();
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L12;
        ConstraintWidget r5 = r1.get(r4);
        if (validInGroup(r16.getHorizontalDimensionBehaviour(), r16.getVerticalDimensionBehaviour(), r5.getHorizontalDimensionBehaviour(), r5.getVerticalDimensionBehaviour()) == false) goto L6;
        if ((r5 instanceof Flow) == true) goto L9;
        r4 = r4 + 1;
        goto L3
    L9:
        return false;
    L6:
        return false;
    L12:
        if (r16.mMetrics == null) goto L14;
        r16.mMetrics.grouping++;
    L14:
        int r6 = 0;
        ArrayList r7 = null;
        ArrayList r8 = null;
        ArrayList r9 = null;
        ArrayList r10 = null;
        ArrayList r11 = null;
        ArrayList r12 = null;
    L15:
        if (r6 >= r2) goto L76;
        ConstraintWidget r13 = r1.get(r6);
        if (validInGroup(r16.getHorizontalDimensionBehaviour(), r16.getVerticalDimensionBehaviour(), r13.getHorizontalDimensionBehaviour(), r13.getVerticalDimensionBehaviour()) == true) goto L20;
        ConstraintWidgetContainer.measure(r3, r13, r17, r16.mMeasure, BasicMeasure.Measure.SELF_DIMENSIONS);
    L20:
        boolean r14 = r13 instanceof Guideline;
        if (r14 == false) goto L33;
        Guideline r15 = (Guideline) r13;
        if (r15.getOrientation() != 0) goto L28;
        if (r9 != null) goto L26;
        r9 = new ArrayList();
    L26:
        r9.add(r15);
    L28:
        if (r15.getOrientation() != 1) goto L33;
        if (r7 != null) goto L31;
        r7 = new ArrayList();
    L31:
        r7.add(r15);
    L33:
        if ((r13 instanceof HelperWidget) == false) goto L54;
        if ((r13 instanceof Barrier) == false) goto L46;
        Barrier r18 = (Barrier) r13;
        if (r18.getOrientation() != 0) goto L42;
        if (r8 != null) goto L40;
        r8 = new ArrayList();
    L40:
        r8.add(r18);
    L42:
        if (r18.getOrientation() != 1) goto L54;
        if (r10 != null) goto L45;
        r10 = new ArrayList();
    L45:
        r10.add(r18);
        goto L54
    L46:
        HelperWidget r19 = (HelperWidget) r13;
        if (r8 != null) goto L49;
        r8 = new ArrayList();
    L49:
        r8.add(r19);
        if (r10 != null) goto L52;
        r10 = new ArrayList();
    L52:
        r10.add(r19);
    L54:
        if (r13.mLeft.mTarget != null) goto L64;
        if (r13.mRight.mTarget != null) goto L64;
        if (r14 == true) goto L64;
        if ((r13 instanceof Barrier) == true) goto L64;
        if (r11 != null) goto L62;
        r11 = new ArrayList();
    L62:
        r11.add(r13);
    L64:
        if (r13.mTop.mTarget != null) goto L75;
        if (r13.mBottom.mTarget != null) goto L75;
        if (r13.mBaseline.mTarget != null) goto L75;
        if (r14 == true) goto L75;
        if ((r13 instanceof Barrier) == true) goto L75;
        if (r12 != null) goto L74;
        r12 = new ArrayList();
    L74:
        r12.add(r13);
    L75:
        r6 = r6 + 1;
        r3 = 0;
        goto L15
    L76:
        ArrayList<WidgetGroup> r20 = new ArrayList();
        if (r7 == null) goto L82;
        Iterator r21 = r7.iterator();
    L80:
        if (r21.hasNext() == false) goto L82;
        findDependents((Guideline) r21.next(), 0, r20, null);
    L82:
        WidgetGroup r22 = null;
        int r110 = 0;
        if (r8 == null) goto L88;
        Iterator r23 = r8.iterator();
    L86:
        if (r23.hasNext() == false) goto L88;
        HelperWidget r24 = (HelperWidget) r23.next();
        WidgetGroup r25 = findDependents(r24, r110, r20, r22);
        r24.addDependents(r20, r110, r25);
        r25.cleanup(r20);
        r22 = null;
        r110 = 0;
    L88:
        ConstraintAnchor r26 = r16.getAnchor(ConstraintAnchor.Type.LEFT);
        if (r26.getDependents() == null) goto L94;
        Iterator<ConstraintAnchor> r27 = r26.getDependents().iterator();
    L92:
        if (r27.hasNext() == false) goto L94;
        findDependents(r27.next().mOwner, 0, r20, null);
    L94:
        ConstraintAnchor r28 = r16.getAnchor(ConstraintAnchor.Type.RIGHT);
        if (r28.getDependents() == null) goto L100;
        Iterator<ConstraintAnchor> r29 = r28.getDependents().iterator();
    L98:
        if (r29.hasNext() == false) goto L100;
        findDependents(r29.next().mOwner, 0, r20, null);
    L100:
        ConstraintAnchor r30 = r16.getAnchor(ConstraintAnchor.Type.CENTER);
        if (r30.getDependents() == null) goto L106;
        Iterator<ConstraintAnchor> r31 = r30.getDependents().iterator();
    L104:
        if (r31.hasNext() == false) goto L106;
        findDependents(r31.next().mOwner, 0, r20, null);
    L106:
        WidgetGroup r32 = null;
        if (r11 == null) goto L112;
        Iterator r33 = r11.iterator();
    L110:
        if (r33.hasNext() == false) goto L112;
        findDependents((ConstraintWidget) r33.next(), 0, r20, null);
    L112:
        if (r9 == null) goto L117;
        Iterator r34 = r9.iterator();
    L115:
        if (r34.hasNext() == false) goto L117;
        findDependents((Guideline) r34.next(), 1, r20, null);
    L117:
        int r35 = 1;
        if (r10 == null) goto L123;
        Iterator r36 = r10.iterator();
    L121:
        if (r36.hasNext() == false) goto L123;
        HelperWidget r37 = (HelperWidget) r36.next();
        WidgetGroup r38 = findDependents(r37, r35, r20, r32);
        r37.addDependents(r20, r35, r38);
        r38.cleanup(r20);
        r32 = null;
        r35 = 1;
    L123:
        ConstraintAnchor r39 = r16.getAnchor(ConstraintAnchor.Type.TOP);
        if (r39.getDependents() == null) goto L129;
        Iterator<ConstraintAnchor> r40 = r39.getDependents().iterator();
    L127:
        if (r40.hasNext() == false) goto L129;
        findDependents(r40.next().mOwner, 1, r20, null);
    L129:
        ConstraintAnchor r41 = r16.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (r41.getDependents() == null) goto L135;
        Iterator<ConstraintAnchor> r42 = r41.getDependents().iterator();
    L133:
        if (r42.hasNext() == false) goto L135;
        findDependents(r42.next().mOwner, 1, r20, null);
    L135:
        ConstraintAnchor r43 = r16.getAnchor(ConstraintAnchor.Type.BOTTOM);
        if (r43.getDependents() == null) goto L141;
        Iterator<ConstraintAnchor> r44 = r43.getDependents().iterator();
    L139:
        if (r44.hasNext() == false) goto L141;
        findDependents(r44.next().mOwner, 1, r20, null);
    L141:
        ConstraintAnchor r45 = r16.getAnchor(ConstraintAnchor.Type.CENTER);
        if (r45.getDependents() == null) goto L148;
        Iterator<ConstraintAnchor> r46 = r45.getDependents().iterator();
    L145:
        if (r46.hasNext() == false) goto L148;
        findDependents(r46.next().mOwner, 1, r20, null);
    L148:
        if (r12 == null) goto L153;
        Iterator r47 = r12.iterator();
    L151:
        if (r47.hasNext() == false) goto L153;
        findDependents((ConstraintWidget) r47.next(), 1, r20, null);
    L153:
        int r48 = 0;
    L154:
        if (r48 >= r2) goto L163;
        ConstraintWidget r49 = r1.get(r48);
        if (r49.oppositeDimensionsTied() == false) goto L161;
        WidgetGroup r50 = findGroup(r20, r49.horizontalGroup);
        WidgetGroup r51 = findGroup(r20, r49.verticalGroup);
        if (r50 == null) goto L161;
        if (r51 == null) goto L161;
        r50.moveTo(0, r51);
        r51.setOrientation(2);
        r20.remove(r50);
    L161:
        r48 = r48 + 1;
        goto L154
    L163:
        if (r20.size() > 1) goto L167;
        return false;
    L167:
        if (r16.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L179;
        Iterator<WidgetGroup> r52 = r20.iterator();
        WidgetGroup r53 = null;
        int r111 = 0;
    L170:
        if (r52.hasNext() == false) goto L177;
        WidgetGroup r54 = r52.next();
        if (r54.getOrientation() == 1) goto L170;
        r54.setAuthoritative(false);
        int r55 = r54.measureWrap(r16.getSystem(), 0);
        if (r55 <= r111) goto L170;
        r53 = r54;
        r111 = r55;
        goto L170
    L177:
        if (r53 == null) goto L179;
        r16.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r16.setWidth(r111);
        r53.setAuthoritative(true);
    L181:
        if (r16.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L194;
        Iterator<WidgetGroup> r56 = r20.iterator();
        WidgetGroup r57 = null;
        int r112 = 0;
    L184:
        if (r56.hasNext() == false) goto L191;
        WidgetGroup r58 = r56.next();
        if (r58.getOrientation() == 0) goto L184;
        r58.setAuthoritative(false);
        int r59 = r58.measureWrap(r16.getSystem(), 1);
        if (r59 <= r112) goto L184;
        r57 = r58;
        r112 = r59;
        goto L184
    L191:
        boolean r60 = false;
        boolean r61 = true;
        if (r57 == null) goto L195;
        r16.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r16.setHeight(r112);
        r57.setAuthoritative(true);
        WidgetGroup r62 = r57;
    L196:
        if (r53 != null) goto L201;
        if (r62 != null) goto L201;
        return r60;
    L201:
        return r61;
    L195:
        r62 = null;
        goto L196
    L194:
        r60 = false;
        r61 = true;
    L179:
        r53 = null;
        goto L181
    }

    private static WidgetGroup findGroup(ArrayList<WidgetGroup> r4, int r5) {
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        WidgetGroup r2 = r4.get(r1);
        if (r5 == r2.getId()) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    public static WidgetGroup findDependents(ConstraintWidget r6, int r7, ArrayList<WidgetGroup> r8, WidgetGroup r9) {
        if (r7 != 0) goto L4;
        int r0 = r6.horizontalGroup;
    L5:
        int r1 = 0;
        if (r0 == (-1)) goto L19;
        if (r9 != null) goto L9;
    L10:
        int r3 = 0;
    L12:
        if (r3 >= r8.size()) goto L21;
        WidgetGroup r4 = r8.get(r3);
        if (r4.getId() == r0) goto L15;
        r3 = r3 + 1;
        goto L12
    L15:
        if (r9 == null) goto L17;
        r9.moveTo(r7, r4);
        r8.remove(r9);
    L17:
        r9 = r4;
    L21:
        if (r9 != null) goto L37;
        if ((r6 instanceof HelperWidget) == false) goto L33;
        int r2 = ((HelperWidget) r6).findGroupInDependents(r7);
        if (r2 == (-1)) goto L33;
        int r5 = 0;
    L28:
        if (r5 >= r8.size()) goto L33;
        WidgetGroup r10 = r8.get(r5);
        if (r10.getId() == r2) goto L31;
        r5 = r5 + 1;
        goto L28
    L31:
        r9 = r10;
    L33:
        if (r9 != null) goto L35;
        r9 = new WidgetGroup(r7);
    L35:
        r8.add(r9);
    L37:
        if (r9.add(r6) == true) goto L39;
    L48:
        return r9;
    L39:
        if ((r6 instanceof Guideline) == false) goto L44;
        Guideline r11 = (Guideline) r6;
        ConstraintAnchor r12 = r11.getAnchor();
        if (r11.getOrientation() != 0) goto L43;
        r1 = 1;
    L43:
        r12.findDependents(r1, r8, r9);
    L44:
        if (r7 != 0) goto L46;
        r6.horizontalGroup = r9.getId();
        r6.mLeft.findDependents(r7, r8, r9);
        r6.mRight.findDependents(r7, r8, r9);
    L47:
        r6.mCenter.findDependents(r7, r8, r9);
        goto L48
    L46:
        r6.verticalGroup = r9.getId();
        r6.mTop.findDependents(r7, r8, r9);
        r6.mBaseline.findDependents(r7, r8, r9);
        r6.mBottom.findDependents(r7, r8, r9);
        goto L47
    L9:
        if (r0 != r9.getId()) goto L10;
    L19:
        if (r0 == (-1)) goto L21;
        return r9;
    L4:
        r0 = r6.verticalGroup;
        goto L5
    }
}
