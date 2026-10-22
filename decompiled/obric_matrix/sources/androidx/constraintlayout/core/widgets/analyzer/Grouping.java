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
    L49:
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
        int r13 = r9.getId();
        if (r7 != 0) goto L47;
        r6.horizontalGroup = r13;
        r6.mLeft.findDependents(r7, r8, r9);
        ConstraintAnchor r14 = r6.mRight;
    L48:
        r14.findDependents(r7, r8, r9);
        r6.mCenter.findDependents(r7, r8, r9);
        goto L49
    L47:
        r6.verticalGroup = r13;
        r6.mTop.findDependents(r7, r8, r9);
        r6.mBaseline.findDependents(r7, r8, r9);
        r14 = r6.mBottom;
        goto L48
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
        if (r7 >= r2) goto L75;
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
        if ((r14 instanceof HelperWidget) == false) goto L53;
        if ((r14 instanceof Barrier) == false) goto L45;
        Barrier r19 = (Barrier) r14;
        if (r19.getOrientation() != 0) goto L41;
        if (r9 != null) goto L40;
        r9 = new ArrayList();
    L40:
        r9.add(r19);
    L41:
        int r110 = r19.getOrientation();
        Object r20 = r19;
        if (r110 != 1) goto L53;
        if (r11 != null) goto L51;
        r11 = new ArrayList();
        r20 = r19;
    L51:
        r11.add(r20);
        goto L53
    L45:
        HelperWidget r21 = (HelperWidget) r14;
        if (r9 != null) goto L48;
        r9 = new ArrayList();
    L48:
        r9.add(r21);
        r20 = r21;
        if (r11 != null) goto L51;
        r11 = new ArrayList();
        r20 = r21;
    L53:
        if (r14.mLeft.mTarget != null) goto L63;
        if (r14.mRight.mTarget != null) goto L63;
        if (r15 == true) goto L63;
        if ((r14 instanceof Barrier) == true) goto L63;
        if (r12 != null) goto L61;
        r12 = new ArrayList();
    L61:
        r12.add(r14);
    L63:
        if (r14.mTop.mTarget != null) goto L74;
        if (r14.mBottom.mTarget != null) goto L74;
        if (r14.mBaseline.mTarget != null) goto L74;
        if (r15 == true) goto L74;
        if ((r14 instanceof Barrier) == true) goto L74;
        if (r13 != null) goto L73;
        r13 = new ArrayList();
    L73:
        r13.add(r14);
    L74:
        r7 = r7 + 1;
        r3 = 0;
        goto L15
    L75:
        ArrayList<WidgetGroup> r22 = new ArrayList();
        if (r8 == null) goto L81;
        Iterator r23 = r8.iterator();
    L79:
        if (r23.hasNext() == false) goto L81;
        findDependents((Guideline) r23.next(), 0, r22, null);
    L81:
        int r24 = 0;
        WidgetGroup r111 = null;
        if (r9 == null) goto L87;
        Iterator r25 = r9.iterator();
    L85:
        if (r25.hasNext() == false) goto L87;
        HelperWidget r26 = (HelperWidget) r25.next();
        WidgetGroup r27 = findDependents(r26, r24, r22, r111);
        r26.addDependents(r22, r24, r27);
        r27.cleanup(r22);
        r24 = 0;
        r111 = null;
    L87:
        ConstraintAnchor r28 = r16.getAnchor(ConstraintAnchor.Type.LEFT);
        if (r28.getDependents() == null) goto L93;
        Iterator<ConstraintAnchor> r29 = r28.getDependents().iterator();
    L91:
        if (r29.hasNext() == false) goto L93;
        findDependents(r29.next().mOwner, 0, r22, null);
    L93:
        ConstraintAnchor r30 = r16.getAnchor(ConstraintAnchor.Type.RIGHT);
        if (r30.getDependents() == null) goto L99;
        Iterator<ConstraintAnchor> r31 = r30.getDependents().iterator();
    L97:
        if (r31.hasNext() == false) goto L99;
        findDependents(r31.next().mOwner, 0, r22, null);
    L99:
        ConstraintAnchor r32 = r16.getAnchor(ConstraintAnchor.Type.CENTER);
        if (r32.getDependents() == null) goto L105;
        Iterator<ConstraintAnchor> r33 = r32.getDependents().iterator();
    L103:
        if (r33.hasNext() == false) goto L105;
        findDependents(r33.next().mOwner, 0, r22, null);
    L105:
        WidgetGroup r34 = null;
        if (r12 == null) goto L111;
        Iterator r35 = r12.iterator();
    L109:
        if (r35.hasNext() == false) goto L111;
        findDependents((ConstraintWidget) r35.next(), 0, r22, null);
    L111:
        if (r10 == null) goto L116;
        Iterator r36 = r10.iterator();
    L114:
        if (r36.hasNext() == false) goto L116;
        findDependents((Guideline) r36.next(), 1, r22, null);
    L116:
        int r37 = 1;
        if (r11 == null) goto L122;
        Iterator r38 = r11.iterator();
    L120:
        if (r38.hasNext() == false) goto L122;
        HelperWidget r39 = (HelperWidget) r38.next();
        WidgetGroup r40 = findDependents(r39, r37, r22, r34);
        r39.addDependents(r22, r37, r40);
        r40.cleanup(r22);
        r37 = 1;
        r34 = null;
    L122:
        ConstraintAnchor r41 = r16.getAnchor(ConstraintAnchor.Type.TOP);
        if (r41.getDependents() == null) goto L128;
        Iterator<ConstraintAnchor> r42 = r41.getDependents().iterator();
    L126:
        if (r42.hasNext() == false) goto L128;
        findDependents(r42.next().mOwner, 1, r22, null);
    L128:
        ConstraintAnchor r43 = r16.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (r43.getDependents() == null) goto L134;
        Iterator<ConstraintAnchor> r44 = r43.getDependents().iterator();
    L132:
        if (r44.hasNext() == false) goto L134;
        findDependents(r44.next().mOwner, 1, r22, null);
    L134:
        ConstraintAnchor r45 = r16.getAnchor(ConstraintAnchor.Type.BOTTOM);
        if (r45.getDependents() == null) goto L140;
        Iterator<ConstraintAnchor> r46 = r45.getDependents().iterator();
    L138:
        if (r46.hasNext() == false) goto L140;
        findDependents(r46.next().mOwner, 1, r22, null);
    L140:
        ConstraintAnchor r47 = r16.getAnchor(ConstraintAnchor.Type.CENTER);
        if (r47.getDependents() == null) goto L147;
        Iterator<ConstraintAnchor> r48 = r47.getDependents().iterator();
    L144:
        if (r48.hasNext() == false) goto L147;
        findDependents(r48.next().mOwner, 1, r22, null);
    L147:
        if (r13 == null) goto L152;
        Iterator r49 = r13.iterator();
    L150:
        if (r49.hasNext() == false) goto L152;
        findDependents((ConstraintWidget) r49.next(), 1, r22, null);
    L152:
        int r50 = 0;
    L153:
        if (r50 >= r2) goto L162;
        ConstraintWidget r51 = r1.get(r50);
        if (r51.oppositeDimensionsTied() == false) goto L160;
        WidgetGroup r52 = findGroup(r22, r51.horizontalGroup);
        WidgetGroup r53 = findGroup(r22, r51.verticalGroup);
        if (r52 == null) goto L160;
        if (r53 == null) goto L160;
        r52.moveTo(0, r53);
        r53.setOrientation(2);
        r22.remove(r52);
    L160:
        r50 = r50 + 1;
        goto L153
    L162:
        if (r22.size() > 1) goto L166;
        return false;
    L166:
        if (r16.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L178;
        Iterator<WidgetGroup> r54 = r22.iterator();
        WidgetGroup r55 = null;
        int r56 = 0;
    L169:
        if (r54.hasNext() == false) goto L176;
        WidgetGroup r57 = r54.next();
        if (r57.getOrientation() == 1) goto L169;
        r57.setAuthoritative(false);
        int r58 = r57.measureWrap(r16.getSystem(), 0);
        if (r58 <= r56) goto L169;
        r55 = r57;
        r56 = r58;
        goto L169
    L176:
        if (r55 == null) goto L178;
        r16.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r16.setWidth(r56);
        r55.setAuthoritative(true);
    L180:
        if (r16.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L193;
        Iterator<WidgetGroup> r59 = r22.iterator();
        WidgetGroup r60 = null;
        int r61 = 0;
    L183:
        if (r59.hasNext() == false) goto L190;
        WidgetGroup r62 = r59.next();
        if (r62.getOrientation() == 0) goto L183;
        r62.setAuthoritative(false);
        int r63 = r62.measureWrap(r16.getSystem(), 1);
        if (r63 <= r61) goto L183;
        r60 = r62;
        r61 = r63;
        goto L183
    L190:
        boolean r64 = false;
        boolean r65 = true;
        if (r60 == null) goto L194;
        r16.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r16.setHeight(r61);
        r60.setAuthoritative(true);
        WidgetGroup r66 = r60;
    L195:
        if (r55 != null) goto L200;
        if (r66 != null) goto L200;
        return r64;
    L200:
        return r65;
    L194:
        r66 = null;
        goto L195
    L193:
        r64 = false;
        r65 = true;
    L178:
        r55 = null;
        goto L180
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
