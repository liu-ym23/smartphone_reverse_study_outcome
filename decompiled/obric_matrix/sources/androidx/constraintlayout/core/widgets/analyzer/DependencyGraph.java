package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class DependencyGraph {
    private static final boolean USE_GROUPS = true;
    private ConstraintWidgetContainer container;
    private ConstraintWidgetContainer mContainer;
    ArrayList<RunGroup> mGroups;
    private BasicMeasure.Measure mMeasure;
    private BasicMeasure.Measurer mMeasurer;
    private boolean mNeedBuildGraph;
    private boolean mNeedRedoMeasures;
    private ArrayList<WidgetRun> mRuns;
    private ArrayList<RunGroup> runGroups;

    public DependencyGraph(ConstraintWidgetContainer r2) {
        this.mNeedBuildGraph = true;
        this.mNeedRedoMeasures = true;
        this.mRuns = new ArrayList();
        this.runGroups = new ArrayList();
        this.mMeasurer = null;
        this.mMeasure = new BasicMeasure.Measure();
        this.mGroups = new ArrayList();
        this.container = r2;
        this.mContainer = r2;
    }

    private void applyGroup(DependencyNode r9, int r10, int r11, DependencyNode r12, ArrayList<RunGroup> r13, RunGroup r14) {
        WidgetRun r15 = r9.run;
        if (r15.runGroup != null) goto L54;
        ConstraintWidgetContainer r0 = this.container;
        if (r15 != r0.horizontalRun) goto L7;
        return;
    L7:
        if (r15 == r0.verticalRun) goto L80;
        if (r14 != null) goto L11;
        r14 = new RunGroup(r15, r11);
        r13.add(r14);
    L11:
        r15.runGroup = r14;
        r14.add(r15);
        Iterator<Dependency> r16 = r15.start.dependencies.iterator();
    L13:
        if (r16.hasNext() == false) goto L17;
        Dependency r1 = r16.next();
        if ((r1 instanceof DependencyNode) == false) goto L13;
        applyGroup((DependencyNode) r1, r10, 0, r12, r13, r14);
        goto L13
    L17:
        Iterator<Dependency> r17 = r15.end.dependencies.iterator();
    L19:
        if (r17.hasNext() == false) goto L24;
        Dependency r2 = r17.next();
        if ((r2 instanceof DependencyNode) == false) goto L19;
        applyGroup((DependencyNode) r2, r10, 1, r12, r13, r14);
        goto L19
    L24:
        if (r10 == 1) goto L26;
    L33:
        Iterator<DependencyNode> r7 = r15.start.targets.iterator();
    L35:
        if (r7.hasNext() == false) goto L40;
        DependencyNode r3 = r7.next();
        if (r3 != r12) goto L39;
        r14.dual = true;
    L39:
        applyGroup(r3, r10, 0, r12, r13, r14);
        goto L35
    L40:
        Iterator<DependencyNode> r8 = r15.end.targets.iterator();
    L42:
        if (r8.hasNext() == false) goto L47;
        DependencyNode r4 = r8.next();
        if (r4 != r12) goto L46;
        r14.dual = true;
    L46:
        applyGroup(r4, r10, 1, r12, r13, r14);
        goto L42
    L47:
        if (r10 == 1) goto L49;
        return;
    L49:
        if ((r15 instanceof VerticalWidgetRun) == false) goto L79;
        Iterator<DependencyNode> r18 = ((VerticalWidgetRun) r15).baseline.targets.iterator();
    L52:
        if (r18.hasNext() == false) goto L81;
        applyGroup(r18.next(), r10, 2, r12, r13, r14);
        goto L52
    L81:
        return;
    L79:
        return;
    L26:
        if ((r15 instanceof VerticalWidgetRun) == false) goto L33;
        Iterator<Dependency> r19 = ((VerticalWidgetRun) r15).baseline.dependencies.iterator();
    L29:
        if (r19.hasNext() == false) goto L33;
        Dependency r5 = r19.next();
        if ((r5 instanceof DependencyNode) == false) goto L29;
        applyGroup((DependencyNode) r5, r10, 2, r12, r13, r14);
        goto L29
    L80:
        return;
    }

    private boolean basicMeasureWidgets(ConstraintWidgetContainer r17) {
        Iterator<ConstraintWidget> r1 = r17.mChildren.iterator();
    L4:
        if (r1.hasNext() == false) goto L149;
        ConstraintWidget r2 = r1.next();
        ConstraintWidget.DimensionBehaviour[] r4 = r2.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r5 = r4[0];
        ConstraintWidget.DimensionBehaviour r6 = r4[1];
        if (r2.getVisibility() == 8) goto L7;
        if (r2.mMatchConstraintPercentWidth >= 1.0f) goto L14;
        if (r5 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
        r2.mMatchConstraintDefaultWidth = 2;
    L14:
        if (r2.mMatchConstraintPercentHeight >= 1.0f) goto L19;
        if (r6 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
        r2.mMatchConstraintDefaultHeight = 2;
    L19:
        if (r2.getDimensionRatio() <= 0.0f) goto L41;
        ConstraintWidget.DimensionBehaviour r7 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r5 == r7) goto L23;
    L27:
        if (r6 == r7) goto L29;
    L33:
        if (r5 != r7) goto L41;
        if (r6 != r7) goto L41;
        if (r2.mMatchConstraintDefaultWidth != 0) goto L39;
        r2.mMatchConstraintDefaultWidth = 3;
    L39:
        if (r2.mMatchConstraintDefaultHeight != 0) goto L41;
    L32:
        r2.mMatchConstraintDefaultHeight = 3;
        goto L41
    L29:
        if (r5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L32;
        if (r5 != ConstraintWidget.DimensionBehaviour.FIXED) goto L33;
    L23:
        if (r6 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L25;
    L26:
        r2.mMatchConstraintDefaultWidth = 3;
        goto L41
    L25:
        if (r6 != ConstraintWidget.DimensionBehaviour.FIXED) goto L27;
    L41:
        ConstraintWidget.DimensionBehaviour r8 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r5 == r8) goto L44;
    L50:
        ConstraintWidget.DimensionBehaviour r9 = r5;
        if (r6 == r8) goto L53;
    L59:
        ConstraintWidget.DimensionBehaviour r12 = r6;
        HorizontalWidgetRun r10 = r2.horizontalRun;
        r10.dimensionBehavior = r9;
        int r11 = r2.mMatchConstraintDefaultWidth;
        r10.matchConstraintsType = r11;
        VerticalWidgetRun r13 = r2.verticalRun;
        r13.dimensionBehavior = r12;
        int r14 = r2.mMatchConstraintDefaultHeight;
        r13.matchConstraintsType = r14;
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r9 != r15) goto L62;
    L65:
        if (r12 == r15) goto L139;
        if (r12 == ConstraintWidget.DimensionBehaviour.FIXED) goto L139;
        if (r12 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L139;
    L72:
        if (r9 != r8) goto L98;
        ConstraintWidget.DimensionBehaviour r16 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r12 != r16) goto L76;
    L77:
        if (r11 == 3) goto L78;
        if (r11 == 1) goto L84;
        if (r11 != 2) goto L92;
        ConstraintWidget.DimensionBehaviour[] r18 = r17.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r19 = r18[0];
        ConstraintWidget.DimensionBehaviour r20 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r19 == r20) goto L91;
        if (r18[0] != r15) goto L98;
    L91:
        int r3 = (int) ((r2.mMatchConstraintPercentWidth * r17.getWidth()) + 0.5f);
        int r21 = r2.getHeight();
        ConstraintWidget.DimensionBehaviour r22 = r20;
        int r23 = r3;
    L97:
        ConstraintWidget.DimensionBehaviour r24 = r12;
    L148:
        this.measure(r2, r22, r23, r24, r21);
        r2.horizontalRun.dimension.resolve(r2.getWidth());
        r2.verticalRun.dimension.resolve(r2.getHeight());
        goto L7
    L92:
        ConstraintAnchor[] r25 = r2.mListAnchors;
        if (r25[0].mTarget == null) goto L96;
        if (r25[1].mTarget != null) goto L98;
    L96:
        r23 = 0;
        r21 = 0;
        r22 = r16;
        goto L97
    L84:
        measure(r2, r16, 0, r12, 0);
        DimensionDependency r26 = r2.horizontalRun.dimension;
        int r27 = r2.getWidth();
    L85:
        r26.wrapValue = r27;
        goto L4
    L78:
        if (r12 != r16) goto L80;
        measure(r2, r16, 0, r16, 0);
    L80:
        r21 = r2.getHeight();
        r23 = (int) ((r21 * r2.mDimensionRatio) + 0.5f);
    L81:
        r24 = ConstraintWidget.DimensionBehaviour.FIXED;
    L82:
        DependencyGraph this = this;
        r2 = r2;
        r22 = r24;
        goto L148
    L76:
        if (r12 == ConstraintWidget.DimensionBehaviour.FIXED) goto L77;
    L98:
        if (r12 != r8) goto L125;
        ConstraintWidget.DimensionBehaviour r110 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r9 != r110) goto L102;
    L103:
        if (r14 == 3) goto L104;
        if (r14 == 1) goto L111;
        if (r14 != 2) goto L120;
        ConstraintWidget.DimensionBehaviour[] r28 = r17.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r29 = r28[1];
        ConstraintWidget.DimensionBehaviour r111 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r29 == r111) goto L119;
        if (r28[1] != r15) goto L125;
    L119:
        float r30 = r2.mMatchConstraintPercentHeight;
        r23 = r2.getWidth();
        this = this;
        r2 = r2;
        r22 = r9;
        r24 = r111;
        r21 = (int) ((r30 * r17.getHeight()) + 0.5f);
        goto L148
    L120:
        ConstraintAnchor[] r31 = r2.mListAnchors;
        if (r31[2].mTarget == null) goto L124;
        if (r31[3].mTarget != null) goto L125;
    L124:
        r23 = 0;
        r21 = 0;
        r22 = r110;
        goto L97
    L111:
        measure(r2, r9, 0, r110, 0);
    L112:
        r26 = r2.verticalRun.dimension;
        r27 = r2.getHeight();
        goto L85
    L104:
        if (r9 != r110) goto L106;
        measure(r2, r110, 0, r110, 0);
    L106:
        r23 = r2.getWidth();
        float r32 = r2.mDimensionRatio;
        if (r2.getDimensionRatioSide() != (-1)) goto L109;
        r32 = 1.0f / r32;
    L109:
        r21 = (int) ((r23 * r32) + 0.5f);
        goto L81
    L102:
        if (r9 == ConstraintWidget.DimensionBehaviour.FIXED) goto L103;
    L125:
        if (r9 != r8) goto L4;
        if (r12 != r8) goto L4;
        if (r11 == 1) goto L138;
        if (r14 == 1) goto L138;
        if (r14 != 2) goto L4;
        if (r11 != 2) goto L4;
        ConstraintWidget.DimensionBehaviour[] r33 = r17.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r34 = r33[0];
        r24 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r34 != r24) goto L4;
        if (r33[1] != r24) goto L4;
        float r35 = r2.mMatchConstraintPercentWidth;
        float r36 = r2.mMatchConstraintPercentHeight;
        r23 = (int) ((r35 * r17.getWidth()) + 0.5f);
        r21 = (int) ((r36 * r17.getHeight()) + 0.5f);
    L138:
        ConstraintWidget.DimensionBehaviour r37 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        measure(r2, r37, 0, r37, 0);
        r2.horizontalRun.dimension.wrapValue = r2.getWidth();
    L139:
        int r38 = r2.getWidth();
        if (r9 != r15) goto L142;
        r23 = (r17.getWidth() - r2.mLeft.mMargin) - r2.mRight.mMargin;
        r22 = ConstraintWidget.DimensionBehaviour.FIXED;
    L143:
        int r39 = r2.getHeight();
        if (r12 != r15) goto L146;
        r21 = (r17.getHeight() - r2.mTop.mMargin) - r2.mBottom.mMargin;
        r24 = ConstraintWidget.DimensionBehaviour.FIXED;
    L147:
        this = this;
        r2 = r2;
        goto L148
    L146:
        r21 = r39;
        r24 = r12;
        goto L147
    L142:
        r23 = r38;
        r22 = r9;
        goto L143
    L62:
        if (r9 == ConstraintWidget.DimensionBehaviour.FIXED) goto L65;
        if (r9 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L72;
    L53:
        if (r2.mMatchConstraintDefaultHeight != 1) goto L59;
        if (r2.mTop.mTarget != null) goto L57;
    L58:
        r6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        goto L59
    L57:
        if (r2.mBottom.mTarget != null) goto L59;
    L44:
        if (r2.mMatchConstraintDefaultWidth != 1) goto L50;
        if (r2.mLeft.mTarget != null) goto L48;
    L49:
        r5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        goto L50
    L48:
        if (r2.mRight.mTarget != null) goto L50;
    L7:
        r2.measured = true;
        goto L4
    L149:
        return false;
    }

    private int computeWrap(ConstraintWidgetContainer r7, int r8) {
        int r0 = this.mGroups.size();
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r1 = Math.max(r1, this.mGroups.get(r3).computeWrapSize(r7, r8));
        r3 = r3 + 1;
        goto L3
    L6:
        return (int) r1;
    }

    private void displayGraph() {
        Iterator<WidgetRun> r0 = this.mRuns.iterator();
        String r1 = "digraph {\n";
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = generateDisplayGraph(r0.next(), r1);
        goto L4
    L6:
        PrintStream r2 = System.out;
        r2.println("content:<<\n" + (r1 + "\n}\n") + "\n>>");
    }

    private void findGroup(WidgetRun r11, int r12, ArrayList<RunGroup> r13) {
        Iterator<Dependency> r0 = r11.start.dependencies.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Dependency r1 = r0.next();
        if ((r1 instanceof DependencyNode) == true) goto L7;
        if ((r1 instanceof WidgetRun) == false) goto L4;
        applyGroup(((WidgetRun) r1).start, r12, 0, r11.end, r13, null);
        goto L4
    L7:
        applyGroup((DependencyNode) r1, r12, 0, r11.end, r13, null);
        goto L4
    L11:
        Iterator<Dependency> r2 = r11.end.dependencies.iterator();
    L13:
        if (r2.hasNext() == false) goto L21;
        Dependency r3 = r2.next();
        if ((r3 instanceof DependencyNode) == true) goto L16;
        if ((r3 instanceof WidgetRun) == false) goto L13;
        applyGroup(((WidgetRun) r3).end, r12, 1, r11.start, r13, null);
        goto L13
    L16:
        applyGroup((DependencyNode) r3, r12, 1, r11.start, r13, null);
        goto L13
    L21:
        if (r12 != 1) goto L28;
        Iterator<Dependency> r14 = ((VerticalWidgetRun) r11).baseline.dependencies.iterator();
    L24:
        if (r14.hasNext() == false) goto L50;
        Dependency r4 = r14.next();
        if ((r4 instanceof DependencyNode) == false) goto L24;
        applyGroup((DependencyNode) r4, r12, 2, null, r13, null);
        goto L24
    L50:
        return;
    }

    private String generateChainDisplayGraph(ChainRun r6, String r7) {
        int r0 = r6.orientation;
        StringBuilder r1 = new StringBuilder("subgraph ");
        r1.append("cluster_");
        r1.append(r6.widget.getDebugName());
        if (r0 != 0) goto L5;
        String r2 = "_h";
    L6:
        r1.append(r2);
        r1.append(" {\n");
        Iterator<WidgetRun> r8 = r6.widgets.iterator();
        String r3 = "";
    L8:
        if (r8.hasNext() == false) goto L14;
        WidgetRun r4 = r8.next();
        r1.append(r4.widget.getDebugName());
        if (r0 != 0) goto L12;
        String r5 = "_HORIZONTAL";
    L13:
        r1.append(r5);
        r1.append(";\n");
        r3 = generateDisplayGraph(r4, r3);
        goto L8
    L12:
        r5 = "_VERTICAL";
        goto L13
    L14:
        r1.append("}\n");
        return r7 + r3 + r1;
    L5:
        r2 = "_v";
        goto L6
    }

    private String generateDisplayGraph(WidgetRun r10, String r11) {
        DependencyNode r0 = r10.start;
        DependencyNode r1 = r10.end;
        StringBuilder r2 = new StringBuilder(r11);
        if ((r10 instanceof HelperReferences) == false) goto L5;
    L11:
        r2.append(nodeDefinition(r10));
        boolean r3 = isCenteredConnection(r0, r1);
        String r12 = generateDisplayNode(r1, r3, generateDisplayNode(r0, r3, r11));
        boolean r4 = r10 instanceof VerticalWidgetRun;
        if (r4 == false) goto L15;
        r12 = generateDisplayNode(((VerticalWidgetRun) r10).baseline, r3, r12);
    L15:
        if ((r10 instanceof HorizontalWidgetRun) == true) goto L47;
        boolean r5 = r10 instanceof ChainRun;
        if (r5 == true) goto L19;
    L21:
        if (r4 == true) goto L25;
        if (r5 == false) goto L68;
        if (((ChainRun) r10).orientation == 1) goto L25;
    L68:
        if ((r10 instanceof ChainRun) == false) goto L72;
        return generateChainDisplayGraph((ChainRun) r10, r12);
    L72:
        return r2.toString();
    L25:
        ConstraintWidget.DimensionBehaviour r6 = r10.widget.getVerticalDimensionBehaviour();
        if (r6 == ConstraintWidget.DimensionBehaviour.FIXED) goto L37;
        if (r6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L37;
        if (r6 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L68;
        if (r10.widget.getDimensionRatio() <= 0.0f) goto L68;
        r2.append("\n");
        r2.append(r10.widget.getDebugName());
        r2.append("_VERTICAL -> ");
        r2.append(r10.widget.getDebugName());
        String r7 = "_HORIZONTAL;\n";
    L35:
        r2.append(r7);
    L37:
        if (r0.targets.isEmpty() == true) goto L43;
        if (r1.targets.isEmpty() == false) goto L43;
    L40:
        r2.append("\n");
        r2.append(r1.name());
        r2.append(" -> ");
        String r8 = r0.name();
    L41:
        r2.append(r8);
        r2.append("\n");
    L43:
        if (r0.targets.isEmpty() == false) goto L68;
        if (r1.targets.isEmpty() == true) goto L68;
    L46:
        r2.append("\n");
        r2.append(r0.name());
        r2.append(" -> ");
        r8 = r1.name();
        goto L41
    L19:
        if (((ChainRun) r10).orientation != 0) goto L21;
    L47:
        ConstraintWidget.DimensionBehaviour r9 = r10.widget.getHorizontalDimensionBehaviour();
        if (r9 == ConstraintWidget.DimensionBehaviour.FIXED) goto L58;
        if (r9 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L58;
        if (r9 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L68;
        if (r10.widget.getDimensionRatio() <= 0.0f) goto L68;
        r2.append("\n");
        r2.append(r10.widget.getDebugName());
        r2.append("_HORIZONTAL -> ");
        r2.append(r10.widget.getDebugName());
        r7 = "_VERTICAL;\n";
    L58:
        if (r0.targets.isEmpty() == true) goto L63;
        if (r1.targets.isEmpty() == true) goto L40;
    L63:
        if (r0.targets.isEmpty() == false) goto L68;
        if (r1.targets.isEmpty() == true) goto L68;
    L5:
        if (r0.dependencies.isEmpty() == false) goto L11;
        if ((r1.dependencies.isEmpty() & r0.targets.isEmpty()) == false) goto L11;
        if (r1.targets.isEmpty() == false) goto L11;
        return r11;
    }

    private String generateDisplayNode(DependencyNode r5, boolean r6, String r7) {
        StringBuilder r4 = new StringBuilder(r7);
        Iterator<DependencyNode> r8 = r5.targets.iterator();
    L4:
        if (r8.hasNext() == false) goto L23;
        DependencyNode r0 = r8.next();
        String r1 = ("\n" + r5.name()) + " -> " + r0.name();
        if (r5.margin > 0) goto L10;
        if (r6 == true) goto L10;
        if ((r5.run instanceof HelperReferences) == true) goto L10;
    L21:
        r4.append(r1 + "\n");
    L10:
        String r2 = r1 + "[";
        if (r5.margin <= 0) goto L15;
        r2 = r2 + "label=\"" + r5.margin + "\"";
        if (r6 == false) goto L15;
        r2 = r2 + ",";
    L15:
        if (r6 == false) goto L18;
        r2 = r2 + " style=dashed ";
    L18:
        if ((r5.run instanceof HelperReferences) == false) goto L20;
        r2 = r2 + " style=bold,color=gray ";
    L20:
        r1 = r2 + "]";
        goto L21
    L23:
        return r4.toString();
    }

    private boolean isCenteredConnection(DependencyNode r4, DependencyNode r5) {
        Iterator<DependencyNode> r3 = r4.targets.iterator();
        int r1 = 0;
    L4:
        if (r3.hasNext() == false) goto L8;
        if (r3.next() == r5) goto L4;
        r1 = r1 + 1;
        goto L4
    L8:
        Iterator<DependencyNode> r6 = r5.targets.iterator();
        int r7 = 0;
    L10:
        if (r6.hasNext() == false) goto L14;
        if (r6.next() == r4) goto L10;
        r7 = r7 + 1;
        goto L10
    L14:
        if (r1 <= 0) goto L28;
        if (r7 <= 0) goto L29;
        return true;
    L29:
        return false;
    L28:
        return false;
    }

    private void measure(ConstraintWidget r2, ConstraintWidget.DimensionBehaviour r3, int r4, ConstraintWidget.DimensionBehaviour r5, int r6) {
        BasicMeasure.Measure r0 = this.mMeasure;
        r0.horizontalBehavior = r3;
        r0.verticalBehavior = r5;
        r0.horizontalDimension = r4;
        r0.verticalDimension = r6;
        this.mMeasurer.measure(r2, r0);
        r2.setWidth(this.mMeasure.measuredWidth);
        r2.setHeight(this.mMeasure.measuredHeight);
        r2.setHasBaseline(this.mMeasure.measuredHasBaseline);
        r2.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    private String nodeDefinition(WidgetRun r9) {
        boolean r8 = r9 instanceof VerticalWidgetRun;
        String r0 = r9.widget.getDebugName();
        StringBuilder r1 = new StringBuilder(r0);
        ConstraintWidget r2 = r9.widget;
        if (r8 == true) goto L5;
        ConstraintWidget.DimensionBehaviour r3 = r2.getHorizontalDimensionBehaviour();
    L6:
        RunGroup r4 = r9.runGroup;
        if (r8 == true) goto L9;
        String r5 = "_HORIZONTAL";
    L10:
        r1.append(r5);
        r1.append(" [shape=none, label=<");
        r1.append("<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">");
        r1.append("  <TR>");
        r1.append("    <TD ");
        boolean r6 = r9.start.resolved;
        if (r8 == true) goto L15;
        if (r6 == false) goto L14;
        r1.append(" BGCOLOR=\"green\"");
    L14:
        String r7 = " PORT=\"LEFT\" BORDER=\"1\">L</TD>";
    L18:
        r1.append(r7);
        r1.append("    <TD BORDER=\"1\" ");
        boolean r10 = r9.dimension.resolved;
        if (r10 == true) goto L21;
    L23:
        if (r10 == false) goto L27;
        String r11 = " BGCOLOR=\"lightgray\" ";
    L25:
        r1.append(r11);
    L30:
        if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        r1.append("style=\"dashed\"");
    L32:
        r1.append(">");
        r1.append(r0);
        if (r4 == null) goto L35;
        r1.append(" [");
        r1.append(r4.groupIndex + 1);
        r1.append("/");
        r1.append(RunGroup.index);
        r1.append("]");
    L35:
        r1.append(" </TD>");
        r1.append("    <TD ");
        if (r8 == true) goto L43;
        if (r9.end.resolved == false) goto L40;
        r1.append(" BGCOLOR=\"green\"");
    L40:
        String r12 = " PORT=\"RIGHT\" BORDER=\"1\">R</TD>";
    L41:
        r1.append(r12);
        r1.append("  </TR></TABLE>");
        r1.append(">];\n");
        return r1.toString();
    L43:
        if (((VerticalWidgetRun) r9).baseline.resolved == false) goto L45;
        r1.append(" BGCOLOR=\"green\"");
    L45:
        r1.append(" PORT=\"BASELINE\" BORDER=\"1\">b</TD>");
        r1.append("    <TD ");
        if (r9.end.resolved == false) goto L48;
        r1.append(" BGCOLOR=\"green\"");
    L48:
        r12 = " PORT=\"BOTTOM\" BORDER=\"1\">B</TD>";
        goto L41
    L27:
        if (r9.widget.measured == false) goto L30;
        r11 = " BGCOLOR=\"yellow\" ";
        goto L25
    L21:
        if (r9.widget.measured == true) goto L23;
        r11 = " BGCOLOR=\"green\" ";
        goto L25
    L15:
        if (r6 == false) goto L17;
        r1.append(" BGCOLOR=\"green\"");
    L17:
        r7 = " PORT=\"TOP\" BORDER=\"1\">T</TD>";
        goto L18
    L9:
        r5 = "_VERTICAL";
        goto L10
    L5:
        r3 = r2.getVerticalDimensionBehaviour();
        goto L6
    }

    public void buildGraph() {
        buildGraph(this.mRuns);
        this.mGroups.clear();
        RunGroup.index = 0;
        findGroup(this.container.horizontalRun, 0, this.mGroups);
        findGroup(this.container.verticalRun, 1, this.mGroups);
        this.mNeedBuildGraph = false;
    }

    public void buildGraph(ArrayList<WidgetRun> r6) {
        r6.clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        r6.add(this.mContainer.horizontalRun);
        r6.add(this.mContainer.verticalRun);
        Iterator<ConstraintWidget> r0 = this.mContainer.mChildren.iterator();
        HashSet r1 = null;
    L4:
        if (r0.hasNext() == false) goto L30;
        ConstraintWidget r2 = r0.next();
        if ((r2 instanceof Guideline) == true) goto L7;
        if (r2.isInHorizontalChain() == true) goto L12;
        r6.add(r2.horizontalRun);
    L19:
        if (r2.isInVerticalChain() == true) goto L21;
        r6.add(r2.verticalRun);
    L28:
        if ((r2 instanceof HelperWidget) == false) goto L4;
        WidgetRun r3 = new HelperReferences(r2);
    L8:
        r6.add(r3);
        goto L4
    L21:
        if (r2.verticalChainRun != null) goto L23;
        r2.verticalChainRun = new ChainRun(r2, 1);
    L23:
        if (r1 != null) goto L25;
        r1 = new HashSet();
    L25:
        r1.add(r2.verticalChainRun);
        goto L28
    L12:
        if (r2.horizontalChainRun != null) goto L14;
        r2.horizontalChainRun = new ChainRun(r2, 0);
    L14:
        if (r1 != null) goto L16;
        r1 = new HashSet();
    L16:
        r1.add(r2.horizontalChainRun);
        goto L19
    L7:
        r3 = new GuidelineReference(r2);
        goto L8
    L30:
        if (r1 == null) goto L32;
        r6.addAll(r1);
    L32:
        Iterator<WidgetRun> r4 = r6.iterator();
    L34:
        if (r4.hasNext() == false) goto L36;
        r4.next().clear();
        goto L34
    L36:
        Iterator<WidgetRun> r7 = r6.iterator();
    L38:
        if (r7.hasNext() == false) goto L43;
        WidgetRun r5 = r7.next();
        if (r5.widget == this.mContainer) goto L38;
        r5.apply();
        goto L38
    }

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour r7, ConstraintWidget.DimensionBehaviour r8) {
        if (this.mNeedBuildGraph == false) goto L22;
        buildGraph();
        Iterator<ConstraintWidget> r0 = this.container.mChildren.iterator();
        boolean r2 = false;
    L6:
        if (r0.hasNext() == false) goto L10;
        ConstraintWidget r3 = r0.next();
        boolean[] r5 = r3.isTerminalWidget;
        r5[0] = true;
        r5[1] = true;
        if ((r3 instanceof Barrier) == false) goto L6;
        r2 = true;
        goto L6
    L10:
        if (r2 == true) goto L31;
        Iterator<RunGroup> r6 = this.mGroups.iterator();
    L13:
        if (r6.hasNext() == false) goto L32;
        RunGroup r1 = r6.next();
        ConstraintWidget.DimensionBehaviour r4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r7 != r4) goto L17;
        boolean r9 = true;
    L18:
        if (r8 != r4) goto L20;
        boolean r10 = true;
    L21:
        r1.defineTerminalWidgets(r9, r10);
        goto L13
    L20:
        r10 = false;
        goto L21
    L17:
        r9 = false;
        goto L18
    L32:
        return;
    L31:
        return;
    }

    public boolean directMeasure(boolean r10) {
        boolean r0 = true;
        boolean r11 = r10 & true;
        if (this.mNeedBuildGraph == false) goto L5;
    L6:
        Iterator<ConstraintWidget> r1 = this.container.mChildren.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ConstraintWidget r3 = r1.next();
        r3.ensureWidgetRuns();
        r3.measured = false;
        r3.horizontalRun.reset();
        r3.verticalRun.reset();
        goto L8
    L10:
        this.container.ensureWidgetRuns();
        ConstraintWidgetContainer r2 = this.container;
        r2.measured = false;
        r2.horizontalRun.reset();
        this.container.verticalRun.reset();
        this.mNeedRedoMeasures = false;
    L12:
        if (basicMeasureWidgets(this.mContainer) == false) goto L14;
        return false;
    L14:
        this.container.setX(0);
        this.container.setY(0);
        ConstraintWidget.DimensionBehaviour r4 = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r5 = this.container.getDimensionBehaviour(1);
        if (this.mNeedBuildGraph == false) goto L17;
        buildGraph();
    L17:
        int r6 = this.container.getX();
        int r7 = this.container.getY();
        this.container.horizontalRun.start.resolve(r6);
        this.container.verticalRun.start.resolve(r7);
        measureWidgets();
        ConstraintWidget.DimensionBehaviour r8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 == r8) goto L20;
        if (r5 == r8) goto L20;
    L35:
        ConstraintWidgetContainer r12 = this.container;
        ConstraintWidget.DimensionBehaviour[] r9 = r12.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r13 = r9[0];
        ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r13 != r14) goto L38;
    L41:
        int r15 = r12.getWidth() + r6;
        this.container.horizontalRun.end.resolve(r15);
        this.container.horizontalRun.dimension.resolve(r15 - r6);
        measureWidgets();
        ConstraintWidgetContainer r16 = this.container;
        ConstraintWidget.DimensionBehaviour[] r17 = r16.mListDimensionBehaviors;
        if (r17[1] != r14) goto L44;
    L45:
        int r18 = r16.getHeight() + r7;
        this.container.verticalRun.end.resolve(r18);
        this.container.verticalRun.dimension.resolve(r18 - r7);
    L46:
        measureWidgets();
        boolean r19 = true;
    L47:
        Iterator<WidgetRun> r20 = this.mRuns.iterator();
    L49:
        if (r20.hasNext() == false) goto L56;
        WidgetRun r21 = r20.next();
        if (r21.widget != this.container) goto L55;
        if (r21.resolved == false) goto L49;
    L55:
        r21.applyToWidget();
        goto L49
    L56:
        Iterator<WidgetRun> r22 = this.mRuns.iterator();
    L58:
        if (r22.hasNext() == false) goto L79;
        WidgetRun r23 = r22.next();
        if (r19 == true) goto L65;
        if (r23.widget == this.container) goto L58;
    L65:
        if (r23.start.resolved == false) goto L66;
        if (r23.end.resolved == true) goto L73;
        if ((r23 instanceof GuidelineReference) == false) goto L66;
    L73:
        if (r23.dimension.resolved == true) goto L58;
        if ((r23 instanceof ChainRun) == true) goto L58;
        if ((r23 instanceof GuidelineReference) == true) goto L58;
    L66:
        r0 = false;
    L79:
        this.container.setHorizontalDimensionBehaviour(r4);
        this.container.setVerticalDimensionBehaviour(r5);
        return r0;
    L44:
        if (r17[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L46;
    L38:
        if (r9[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L41;
        r19 = false;
    L20:
        if (r11 == false) goto L27;
        Iterator<WidgetRun> r24 = this.mRuns.iterator();
    L23:
        if (r24.hasNext() == false) goto L27;
        if (r24.next().supportsWrapComputation() == true) goto L23;
        r11 = false;
    L27:
        if (r11 == true) goto L29;
    L31:
        if (r11 == false) goto L35;
        if (r5 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L35;
        this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r110 = this.container;
        r110.setHeight(computeWrap(r110, 1));
        ConstraintWidgetContainer r111 = this.container;
        r111.verticalRun.dimension.resolve(r111.getHeight());
        goto L35
    L29:
        if (r4 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L31;
        this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r25 = this.container;
        r25.setWidth(computeWrap(r25, 0));
        ConstraintWidgetContainer r26 = this.container;
        r26.horizontalRun.dimension.resolve(r26.getWidth());
        goto L31
    L5:
        if (this.mNeedRedoMeasures == false) goto L12;
        goto L6
    }

    public boolean directMeasureSetup(boolean r5) {
        if (this.mNeedBuildGraph == false) goto L10;
        Iterator<ConstraintWidget> r6 = this.container.mChildren.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        ConstraintWidget r1 = r6.next();
        r1.ensureWidgetRuns();
        r1.measured = false;
        HorizontalWidgetRun r2 = r1.horizontalRun;
        r2.dimension.resolved = false;
        r2.resolved = false;
        r2.reset();
        VerticalWidgetRun r3 = r1.verticalRun;
        r3.dimension.resolved = false;
        r3.resolved = false;
        r3.reset();
        goto L6
    L8:
        this.container.ensureWidgetRuns();
        ConstraintWidgetContainer r7 = this.container;
        r7.measured = false;
        HorizontalWidgetRun r8 = r7.horizontalRun;
        r8.dimension.resolved = false;
        r8.resolved = false;
        r8.reset();
        VerticalWidgetRun r9 = this.container.verticalRun;
        r9.dimension.resolved = false;
        r9.resolved = false;
        r9.reset();
        buildGraph();
    L10:
        if (basicMeasureWidgets(this.mContainer) == false) goto L12;
        return false;
    L12:
        this.container.setX(0);
        this.container.setY(0);
        this.container.horizontalRun.start.resolve(0);
        this.container.verticalRun.start.resolve(0);
        return true;
    }

    public boolean directMeasureWithOrientation(boolean r10, int r11) {
        boolean r0 = true;
        boolean r12 = r10 & true;
        ConstraintWidget.DimensionBehaviour r1 = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r3 = this.container.getDimensionBehaviour(1);
        int r4 = this.container.getX();
        int r5 = this.container.getY();
        if (r12 == false) goto L25;
        ConstraintWidget.DimensionBehaviour r6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r1 == r6) goto L7;
        if (r3 != r6) goto L25;
    L7:
        Iterator<WidgetRun> r7 = this.mRuns.iterator();
    L9:
        if (r7.hasNext() == false) goto L15;
        WidgetRun r8 = r7.next();
        if (r8.orientation != r11) goto L9;
        if (r8.supportsWrapComputation() == true) goto L9;
        r12 = false;
    L15:
        if (r11 != 0) goto L20;
        if (r12 == false) goto L25;
        if (r1 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L25;
        this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r13 = this.container;
        r13.setWidth(computeWrap(r13, 0));
        ConstraintWidgetContainer r14 = this.container;
        DimensionDependency r9 = r14.horizontalRun.dimension;
        int r15 = r14.getWidth();
    L24:
        r9.resolve(r15);
        goto L25
    L20:
        if (r12 == false) goto L25;
        if (r3 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L25;
        this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r16 = this.container;
        r16.setHeight(computeWrap(r16, 1));
        ConstraintWidgetContainer r17 = this.container;
        r9 = r17.verticalRun.dimension;
        r15 = r17.getHeight();
    L25:
        ConstraintWidgetContainer r18 = this.container;
        if (r11 != 0) goto L32;
        ConstraintWidget.DimensionBehaviour[] r19 = r18.mListDimensionBehaviors;
        if (r19[0] != ConstraintWidget.DimensionBehaviour.FIXED) goto L30;
    L31:
        int r110 = r18.getWidth() + r4;
        this.container.horizontalRun.end.resolve(r110);
        this.container.horizontalRun.dimension.resolve(r110 - r4);
    L39:
        boolean r111 = true;
    L40:
        measureWidgets();
        Iterator<WidgetRun> r20 = this.mRuns.iterator();
    L42:
        if (r20.hasNext() == false) goto L52;
        WidgetRun r21 = r20.next();
        if (r21.orientation != r11) goto L42;
        if (r21.widget != this.container) goto L51;
        if (r21.resolved == false) goto L42;
    L51:
        r21.applyToWidget();
        goto L42
    L52:
        Iterator<WidgetRun> r22 = this.mRuns.iterator();
    L54:
        if (r22.hasNext() == false) goto L73;
        WidgetRun r23 = r22.next();
        if (r23.orientation != r11) goto L54;
        if (r111 == true) goto L63;
        if (r23.widget == this.container) goto L54;
    L63:
        if (r23.start.resolved == false) goto L64;
        if (r23.end.resolved == false) goto L64;
        if ((r23 instanceof ChainRun) == true) goto L54;
        if (r23.dimension.resolved == true) goto L54;
    L64:
        r0 = false;
    L73:
        this.container.setHorizontalDimensionBehaviour(r1);
        this.container.setVerticalDimensionBehaviour(r3);
        return r0;
    L30:
        if (r19[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L31;
    L37:
        r111 = false;
        goto L40
    L32:
        ConstraintWidget.DimensionBehaviour[] r24 = r18.mListDimensionBehaviors;
        if (r24[1] != ConstraintWidget.DimensionBehaviour.FIXED) goto L35;
    L38:
        int r112 = r18.getHeight() + r5;
        this.container.verticalRun.end.resolve(r112);
        this.container.verticalRun.dimension.resolve(r112 - r5);
        goto L39
    L35:
        if (r24[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L37;
        goto L37
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = true;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = true;
    }

    public void measureWidgets() {
        Iterator<ConstraintWidget> r0 = this.container.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L45;
        ConstraintWidget r1 = r0.next();
        if (r1.measured == true) goto L4;
        ConstraintWidget.DimensionBehaviour[] r2 = r1.mListDimensionBehaviors;
        boolean r3 = false;
        ConstraintWidget.DimensionBehaviour r8 = r2[0];
        ConstraintWidget.DimensionBehaviour r10 = r2[1];
        int r4 = r1.mMatchConstraintDefaultWidth;
        int r5 = r1.mMatchConstraintDefaultHeight;
        ConstraintWidget.DimensionBehaviour r6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r8 != r6) goto L11;
    L15:
        boolean r7 = true;
    L16:
        if (r10 != r6) goto L18;
    L20:
        r3 = true;
    L21:
        DimensionDependency r9 = r1.horizontalRun.dimension;
        boolean r11 = r9.resolved;
        DimensionDependency r12 = r1.verticalRun.dimension;
        boolean r13 = r12.resolved;
        if (r11 == false) goto L26;
        if (r13 == false) goto L26;
        ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.FIXED;
        measure(r1, r14, r9.value, r14, r12.value);
    L25:
        r1.measured = true;
    L41:
        if (r1.measured == false) goto L4;
        DimensionDependency r15 = r1.verticalRun.baselineDimension;
        if (r15 == null) goto L4;
        r15.resolve(r1.getBaselineDistance());
    L26:
        if (r11 == false) goto L34;
        if (r3 == false) goto L34;
        measure(r1, ConstraintWidget.DimensionBehaviour.FIXED, r9.value, r6, r12.value);
        if (r10 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        DimensionDependency r16 = r1.verticalRun.dimension;
        int r17 = r1.getHeight();
    L31:
        r16.wrapValue = r17;
        goto L41
    L32:
        DimensionDependency r18 = r1.verticalRun.dimension;
        int r19 = r1.getHeight();
    L33:
        r18.resolve(r19);
    L34:
        if (r13 == false) goto L41;
        if (r7 == false) goto L41;
        measure(r1, r6, r9.value, ConstraintWidget.DimensionBehaviour.FIXED, r12.value);
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L39;
        r16 = r1.horizontalRun.dimension;
        r17 = r1.getWidth();
        goto L31
    L39:
        r18 = r1.horizontalRun.dimension;
        r19 = r1.getWidth();
        goto L33
    L18:
        if (r10 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L21;
        if (r5 != 1) goto L21;
    L11:
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
        if (r4 == 1) goto L15;
    L14:
        r7 = false;
        goto L16
    }

    public void setMeasurer(BasicMeasure.Measurer r1) {
        this.mMeasurer = r1;
    }
}
