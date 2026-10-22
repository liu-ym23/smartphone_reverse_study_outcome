package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Grouping {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_GROUPING = false;

    public Grouping() {
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
        if (r0 != r9.id) goto L10;
    L19:
        if (r0 == (-1)) goto L21;
        return r9;
    L4:
        r0 = r6.verticalGroup;
        goto L5
    }

    private static WidgetGroup findGroup(ArrayList<WidgetGroup> r4, int r5) {
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        WidgetGroup r2 = r4.get(r1);
        if (r5 == r2.id) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    public static boolean simpleSolvingPass(ConstraintWidgetContainer r16, BasicMeasure.Measurer r17) {
        ArrayList<ConstraintWidget> r1 = r16.getChildren();
        int r2 = r1.size();
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L11;
        ConstraintWidget r5 = r1.get(r4);
        if (validInGroup(r16.getHorizontalDimensionBehaviour(), r16.getVerticalDimensionBehaviour(), r5.getHorizontalDimensionBehaviour(), r5.getVerticalDimensionBehaviour()) == false) goto L6;
        if ((r5 instanceof Flow) == true) goto L9;
        r4 = r4 + 1;
        goto L3
    L9:
        return false;
    L6:
        return false;
    L11:
        Metrics r6 = r16.mMetrics;
        if (r6 == null) goto L14;
        r6.grouping++;
    L14:
        int r7 = 0;
        ArrayList r8 = null;
        ArrayList r9 = null;
        ArrayList r10 = null;
        ArrayList r11 = null;
        ArrayList r12 = null;
        ArrayList r13 = null;
    L15:
        if (r7 >= r2) goto L76;
        ConstraintWidget r14 = r1.get(r7);
        if (validInGroup(r16.getHorizontalDimensionBehaviour(), r16.getVerticalDimensionBehaviour(), r14.getHorizontalDimensionBehaviour(), r14.getVerticalDimensionBehaviour()) == true) goto L20;
        ConstraintWidgetContainer.measure(r3, r14, r17, r16.mMeasure, BasicMeasure.Measure.SELF_DIMENSIONS);
    L20:
        boolean r15 = r14 instanceof Guideline;
        if (r15 == false) goto L33;
        Guideline r18 = (Guideline) r14;
        if (r18.getOrientation() != 0) goto L28;
        if (r10 != null) goto L26;
        r10 = new ArrayList();
    L26:
        r10.add(r18);
    L28:
        if (r18.getOrientation() != 1) goto L33;
        if (r8 != null) goto L31;
        r8 = new ArrayList();
    L31:
        r8.add(r18);
    L33:
        if ((r14 instanceof HelperWidget) == false) goto L54;
        if ((r14 instanceof Barrier) == false) goto L46;
        Barrier r19 = (Barrier) r14;
        if (r19.getOrientation() != 0) goto L42;
        if (r9 != null) goto L40;
        r9 = new ArrayList();
    L40:
        r9.add(r19);
    L42:
        if (r19.getOrientation() != 1) goto L54;
        if (r11 != null) goto L45;
        r11 = new ArrayList();
    L45:
        r11.add(r19);
        goto L54
    L46:
        HelperWidget r20 = (HelperWidget) r14;
        if (r9 != null) goto L49;
        r9 = new ArrayList();
    L49:
        r9.add(r20);
        if (r11 != null) goto L52;
        r11 = new ArrayList();
    L52:
        r11.add(r20);
    L54:
        if (r14.mLeft.mTarget != null) goto L64;
        if (r14.mRight.mTarget != null) goto L64;
        if (r15 == true) goto L64;
        if ((r14 instanceof Barrier) == true) goto L64;
        if (r12 != null) goto L62;
        r12 = new ArrayList();
    L62:
        r12.add(r14);
    L64:
        if (r14.mTop.mTarget != null) goto L75;
        if (r14.mBottom.mTarget != null) goto L75;
        if (r14.mBaseline.mTarget != null) goto L75;
        if (r15 == true) goto L75;
        if ((r14 instanceof Barrier) == true) goto L75;
        if (r13 != null) goto L74;
        r13 = new ArrayList();
    L74:
        r13.add(r14);
    L75:
        r7 = r7 + 1;
        r3 = 0;
        goto L15
    L76:
        ArrayList<WidgetGroup> r21 = new ArrayList();
        if (r8 == null) goto L82;
        Iterator r22 = r8.iterator();
    L80:
        if (r22.hasNext() == false) goto L82;
        findDependents((Guideline) r22.next(), 0, r21, null);
    L82:
        int r23 = 0;
        WidgetGroup r110 = null;
        if (r9 == null) goto L88;
        Iterator r24 = r9.iterator();
    L86:
        if (r24.hasNext() == false) goto L88;
        HelperWidget r25 = (HelperWidget) r24.next();
        WidgetGroup r26 = findDependents(r25, r23, r21, r110);
        r25.addDependents(r21, r23, r26);
        r26.cleanup(r21);
        r23 = 0;
        r110 = null;
    L88:
        ConstraintAnchor r27 = r16.getAnchor(ConstraintAnchor.Type.LEFT);
        if (r27.getDependents() == null) goto L94;
        Iterator<ConstraintAnchor> r28 = r27.getDependents().iterator();
    L92:
        if (r28.hasNext() == false) goto L94;
        findDependents(r28.next().mOwner, 0, r21, null);
    L94:
        ConstraintAnchor r29 = r16.getAnchor(ConstraintAnchor.Type.RIGHT);
        if (r29.getDependents() == null) goto L100;
        Iterator<ConstraintAnchor> r30 = r29.getDependents().iterator();
    L98:
        if (r30.hasNext() == false) goto L100;
        findDependents(r30.next().mOwner, 0, r21, null);
    L100:
        ConstraintAnchor r31 = r16.getAnchor(ConstraintAnchor.Type.CENTER);
        if (r31.getDependents() == null) goto L106;
        Iterator<ConstraintAnchor> r32 = r31.getDependents().iterator();
    L104:
        if (r32.hasNext() == false) goto L106;
        findDependents(r32.next().mOwner, 0, r21, null);
    L106:
        WidgetGroup r33 = null;
        if (r12 == null) goto L112;
        Iterator r34 = r12.iterator();
    L110:
        if (r34.hasNext() == false) goto L112;
        findDependents((ConstraintWidget) r34.next(), 0, r21, null);
    L112:
        if (r10 == null) goto L117;
        Iterator r35 = r10.iterator();
    L115:
        if (r35.hasNext() == false) goto L117;
        findDependents((Guideline) r35.next(), 1, r21, null);
    L117:
        int r36 = 1;
        if (r11 == null) goto L123;
        Iterator r37 = r11.iterator();
    L121:
        if (r37.hasNext() == false) goto L123;
        HelperWidget r38 = (HelperWidget) r37.next();
        WidgetGroup r39 = findDependents(r38, r36, r21, r33);
        r38.addDependents(r21, r36, r39);
        r39.cleanup(r21);
        r36 = 1;
        r33 = null;
    L123:
        ConstraintAnchor r40 = r16.getAnchor(ConstraintAnchor.Type.TOP);
        if (r40.getDependents() == null) goto L129;
        Iterator<ConstraintAnchor> r41 = r40.getDependents().iterator();
    L127:
        if (r41.hasNext() == false) goto L129;
        findDependents(r41.next().mOwner, 1, r21, null);
    L129:
        ConstraintAnchor r42 = r16.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (r42.getDependents() == null) goto L135;
        Iterator<ConstraintAnchor> r43 = r42.getDependents().iterator();
    L133:
        if (r43.hasNext() == false) goto L135;
        findDependents(r43.next().mOwner, 1, r21, null);
    L135:
        ConstraintAnchor r44 = r16.getAnchor(ConstraintAnchor.Type.BOTTOM);
        if (r44.getDependents() == null) goto L141;
        Iterator<ConstraintAnchor> r45 = r44.getDependents().iterator();
    L139:
        if (r45.hasNext() == false) goto L141;
        findDependents(r45.next().mOwner, 1, r21, null);
    L141:
        ConstraintAnchor r46 = r16.getAnchor(ConstraintAnchor.Type.CENTER);
        if (r46.getDependents() == null) goto L148;
        Iterator<ConstraintAnchor> r47 = r46.getDependents().iterator();
    L145:
        if (r47.hasNext() == false) goto L148;
        findDependents(r47.next().mOwner, 1, r21, null);
    L148:
        if (r13 == null) goto L153;
        Iterator r48 = r13.iterator();
    L151:
        if (r48.hasNext() == false) goto L153;
        findDependents((ConstraintWidget) r48.next(), 1, r21, null);
    L153:
        int r49 = 0;
    L154:
        if (r49 >= r2) goto L163;
        ConstraintWidget r50 = r1.get(r49);
        if (r50.oppositeDimensionsTied() == false) goto L161;
        WidgetGroup r51 = findGroup(r21, r50.horizontalGroup);
        WidgetGroup r52 = findGroup(r21, r50.verticalGroup);
        if (r51 == null) goto L161;
        if (r52 == null) goto L161;
        r51.moveTo(0, r52);
        r52.setOrientation(2);
        r21.remove(r51);
    L161:
        r49 = r49 + 1;
        goto L154
    L163:
        if (r21.size() > 1) goto L167;
        return false;
    L167:
        if (r16.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L179;
        Iterator<WidgetGroup> r53 = r21.iterator();
        WidgetGroup r54 = null;
        int r55 = 0;
    L170:
        if (r53.hasNext() == false) goto L177;
        WidgetGroup r56 = r53.next();
        if (r56.getOrientation() == 1) goto L170;
        r56.setAuthoritative(false);
        int r57 = r56.measureWrap(r16.getSystem(), 0);
        if (r57 <= r55) goto L170;
        r54 = r56;
        r55 = r57;
        goto L170
    L177:
        if (r54 == null) goto L179;
        r16.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r16.setWidth(r55);
        r54.setAuthoritative(true);
    L181:
        if (r16.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L194;
        Iterator<WidgetGroup> r58 = r21.iterator();
        WidgetGroup r59 = null;
        int r60 = 0;
    L184:
        if (r58.hasNext() == false) goto L191;
        WidgetGroup r61 = r58.next();
        if (r61.getOrientation() == 0) goto L184;
        r61.setAuthoritative(false);
        int r62 = r61.measureWrap(r16.getSystem(), 1);
        if (r62 <= r60) goto L184;
        r59 = r61;
        r60 = r62;
        goto L184
    L191:
        boolean r63 = false;
        boolean r64 = true;
        if (r59 == null) goto L195;
        r16.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r16.setHeight(r60);
        r59.setAuthoritative(true);
        WidgetGroup r65 = r59;
    L196:
        if (r54 != null) goto L201;
        if (r65 != null) goto L201;
        return r63;
    L201:
        return r64;
    L195:
        r65 = null;
        goto L196
    L194:
        r63 = false;
        r64 = true;
    L179:
        r54 = null;
        goto L181
    }

    public static boolean validInGroup(ConstraintWidget.DimensionBehaviour r5, ConstraintWidget.DimensionBehaviour r6, ConstraintWidget.DimensionBehaviour r7, ConstraintWidget.DimensionBehaviour r8) {
        ConstraintWidget.DimensionBehaviour r0 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r7 == r0) goto L11;
        ConstraintWidget.DimensionBehaviour r3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r7 == r3) goto L11;
        if (r7 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L10;
        if (r5 != r3) goto L11;
    L10:
        boolean r9 = false;
    L12:
        if (r8 == r0) goto L20;
        ConstraintWidget.DimensionBehaviour r10 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r8 == r10) goto L20;
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L19;
        if (r6 != r10) goto L20;
    L19:
        boolean r11 = false;
    L21:
        if (r9 == true) goto L25;
        if (r11 == true) goto L25;
        return false;
    L25:
        return true;
    L20:
        r11 = true;
    L11:
        r9 = true;
        goto L12
    }
}
