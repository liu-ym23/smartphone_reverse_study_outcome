package androidx.constraintlayout.core.widgets.analyzer;

import a.a;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import com.bytedance.librarian.LibrarianImpl;
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
        if (r1.hasNext() == false) goto L141;
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
        r2.mMatchConstraintDefaultHeight = 3;
        goto L41
    L29:
        if (r5 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L31;
    L32:
        r2.mMatchConstraintDefaultHeight = 3;
        goto L41
    L31:
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
        if (r12 == r15) goto L132;
        if (r12 == ConstraintWidget.DimensionBehaviour.FIXED) goto L132;
        if (r12 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L132;
    L72:
        if (r9 != r8) goto L93;
        ConstraintWidget.DimensionBehaviour r16 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r12 != r16) goto L76;
    L77:
        if (r11 == 3) goto L78;
        if (r11 != 1) goto L83;
        measure(r2, r16, 0, r12, 0);
        r2.horizontalRun.dimension.wrapValue = r2.getWidth();
        goto L4
    L83:
        if (r11 == 2) goto L84;
        ConstraintAnchor[] r18 = r2.mListAnchors;
        if (r18[0].mTarget == null) goto L92;
        if (r18[1].mTarget != null) goto L93;
    L92:
        measure(r2, r16, 0, r12, 0);
        r2.horizontalRun.dimension.resolve(r2.getWidth());
        r2.verticalRun.dimension.resolve(r2.getHeight());
        r2.measured = true;
        goto L4
    L84:
        ConstraintWidget.DimensionBehaviour r19 = r17.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r110 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r19 == r110) goto L87;
        if (r19 != r15) goto L93;
    L87:
        measure(r2, r110, (int) ((r2.mMatchConstraintPercentWidth * r17.getWidth()) + 0.5f), r12, r2.getHeight());
        r2.horizontalRun.dimension.resolve(r2.getWidth());
        r2.verticalRun.dimension.resolve(r2.getHeight());
        r2.measured = true;
        goto L4
    L78:
        if (r12 != r16) goto L80;
        measure(r2, r16, 0, r16, 0);
    L80:
        int r20 = r2.getHeight();
        int r21 = (int) ((r20 * r2.mDimensionRatio) + 0.5f);
        ConstraintWidget.DimensionBehaviour r22 = ConstraintWidget.DimensionBehaviour.FIXED;
        measure(r2, r22, r21, r22, r20);
        r2.horizontalRun.dimension.resolve(r2.getWidth());
        r2.verticalRun.dimension.resolve(r2.getHeight());
        r2.measured = true;
        goto L4
    L76:
        if (r12 == ConstraintWidget.DimensionBehaviour.FIXED) goto L77;
    L93:
        if (r12 != r8) goto L118;
        ConstraintWidget.DimensionBehaviour r111 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r9 != r111) goto L97;
    L98:
        if (r14 == 3) goto L99;
        if (r14 != 1) goto L108;
        measure(r2, r9, 0, r111, 0);
        r2.verticalRun.dimension.wrapValue = r2.getHeight();
        goto L4
    L108:
        if (r14 == 2) goto L109;
        ConstraintAnchor[] r23 = r2.mListAnchors;
        if (r23[2].mTarget == null) goto L117;
        if (r23[3].mTarget != null) goto L118;
    L117:
        measure(r2, r111, 0, r12, 0);
        r2.horizontalRun.dimension.resolve(r2.getWidth());
        r2.verticalRun.dimension.resolve(r2.getHeight());
        r2.measured = true;
        goto L4
    L109:
        ConstraintWidget.DimensionBehaviour r24 = r17.mListDimensionBehaviors[1];
        ConstraintWidget.DimensionBehaviour r25 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r24 == r25) goto L112;
        if (r24 != r15) goto L118;
    L112:
        measure(r2, r9, r2.getWidth(), r25, (int) ((r2.mMatchConstraintPercentHeight * r17.getHeight()) + 0.5f));
        r2.horizontalRun.dimension.resolve(r2.getWidth());
        r2.verticalRun.dimension.resolve(r2.getHeight());
        r2.measured = true;
        goto L4
    L99:
        if (r9 != r111) goto L101;
        measure(r2, r111, 0, r111, 0);
    L101:
        int r26 = r2.getWidth();
        float r3 = r2.mDimensionRatio;
        if (r2.getDimensionRatioSide() != (-1)) goto L104;
        r3 = 1.0f / r3;
    L104:
        ConstraintWidget.DimensionBehaviour r27 = ConstraintWidget.DimensionBehaviour.FIXED;
        measure(r2, r27, r26, r27, (int) ((r26 * r3) + 0.5f));
        r2.horizontalRun.dimension.resolve(r2.getWidth());
        r2.verticalRun.dimension.resolve(r2.getHeight());
        r2.measured = true;
        goto L4
    L97:
        if (r9 == ConstraintWidget.DimensionBehaviour.FIXED) goto L98;
    L118:
        if (r9 != r8) goto L4;
        if (r12 != r8) goto L4;
        if (r11 == 1) goto L131;
        if (r14 == 1) goto L131;
        if (r14 != 2) goto L4;
        if (r11 != 2) goto L4;
        ConstraintWidget.DimensionBehaviour[] r28 = r17.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r29 = r28[0];
        ConstraintWidget.DimensionBehaviour r30 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r29 != r30) goto L4;
        if (r28[1] != r30) goto L4;
        measure(r2, r30, (int) ((r2.mMatchConstraintPercentWidth * r17.getWidth()) + 0.5f), r30, (int) ((r2.mMatchConstraintPercentHeight * r17.getHeight()) + 0.5f));
        r2.horizontalRun.dimension.resolve(r2.getWidth());
        r2.verticalRun.dimension.resolve(r2.getHeight());
        r2.measured = true;
    L131:
        ConstraintWidget.DimensionBehaviour r31 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        measure(r2, r31, 0, r31, 0);
        r2.horizontalRun.dimension.wrapValue = r2.getWidth();
        r2.verticalRun.dimension.wrapValue = r2.getHeight();
    L132:
        int r32 = r2.getWidth();
        if (r9 != r15) goto L135;
        int r33 = (r17.getWidth() - r2.mLeft.mMargin) - r2.mRight.mMargin;
        ConstraintWidget.DimensionBehaviour r34 = ConstraintWidget.DimensionBehaviour.FIXED;
    L136:
        int r35 = r2.getHeight();
        if (r12 != r15) goto L139;
        int r36 = (r17.getHeight() - r2.mTop.mMargin) - r2.mBottom.mMargin;
        ConstraintWidget.DimensionBehaviour r37 = ConstraintWidget.DimensionBehaviour.FIXED;
    L140:
        measure(r2, r34, r33, r37, r36);
        r2.horizontalRun.dimension.resolve(r2.getWidth());
        r2.verticalRun.dimension.resolve(r2.getHeight());
        r2.measured = true;
        goto L4
    L139:
        r36 = r35;
        r37 = r12;
        goto L140
    L135:
        r33 = r32;
        r34 = r9;
        goto L136
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
    L141:
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
        String r3 = a.j(r1, "\n}\n");
        System.out.println("content:<<\n" + r3 + "\n>>");
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
        StringBuilder r1 = new StringBuilder("subgraph cluster_");
        r1.append(r6.widget.getDebugName());
        if (r0 != 0) goto L5;
        r1.append("_h");
    L6:
        r1.append(" {\n");
        Iterator<WidgetRun> r8 = r6.widgets.iterator();
        String r2 = "";
    L8:
        if (r8.hasNext() == false) goto L14;
        WidgetRun r3 = r8.next();
        r1.append(r3.widget.getDebugName());
        if (r0 != 0) goto L12;
        r1.append("_HORIZONTAL");
    L13:
        r1.append(";\n");
        r2 = generateDisplayGraph(r3, r2);
        goto L8
    L12:
        r1.append("_VERTICAL");
        goto L13
    L14:
        r1.append("}\n");
        return r7 + r2 + r1;
    L5:
        r1.append("_v");
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
        if ((r10 instanceof HorizontalWidgetRun) == true) goto L45;
        boolean r5 = r10 instanceof ChainRun;
        if (r5 == true) goto L19;
    L21:
        if (r4 == true) goto L25;
        if (r5 == false) goto L66;
        if (((ChainRun) r10).orientation == 1) goto L25;
    L66:
        if ((r10 instanceof ChainRun) == false) goto L70;
        return generateChainDisplayGraph((ChainRun) r10, r12);
    L70:
        return r2.toString();
    L25:
        ConstraintWidget.DimensionBehaviour r6 = r10.widget.getVerticalDimensionBehaviour();
        if (r6 == ConstraintWidget.DimensionBehaviour.FIXED) goto L36;
        if (r6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L36;
        if (r6 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L66;
        if (r10.widget.getDimensionRatio() <= 0.0f) goto L66;
        r2.append("\n");
        r2.append(r10.widget.getDebugName());
        r2.append("_VERTICAL -> ");
        r2.append(r10.widget.getDebugName());
        r2.append("_HORIZONTAL;\n");
    L36:
        if (r0.targets.isEmpty() == true) goto L41;
        if (r1.targets.isEmpty() == false) goto L41;
        r2.append("\n");
        r2.append(r1.name());
        r2.append(" -> ");
        r2.append(r0.name());
        r2.append("\n");
    L41:
        if (r0.targets.isEmpty() == false) goto L66;
        if (r1.targets.isEmpty() == true) goto L66;
        r2.append("\n");
        r2.append(r0.name());
        r2.append(" -> ");
        r2.append(r1.name());
        r2.append("\n");
        goto L66
    L19:
        if (((ChainRun) r10).orientation != 0) goto L21;
    L45:
        ConstraintWidget.DimensionBehaviour r7 = r10.widget.getHorizontalDimensionBehaviour();
        if (r7 == ConstraintWidget.DimensionBehaviour.FIXED) goto L56;
        if (r7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L56;
        if (r7 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L66;
        if (r10.widget.getDimensionRatio() <= 0.0f) goto L66;
        r2.append("\n");
        r2.append(r10.widget.getDebugName());
        r2.append("_HORIZONTAL -> ");
        r2.append(r10.widget.getDebugName());
        r2.append("_VERTICAL;\n");
    L56:
        if (r0.targets.isEmpty() == true) goto L61;
        if (r1.targets.isEmpty() == false) goto L61;
        r2.append("\n");
        r2.append(r1.name());
        r2.append(" -> ");
        r2.append(r0.name());
        r2.append("\n");
    L61:
        if (r0.targets.isEmpty() == false) goto L66;
        if (r1.targets.isEmpty() == true) goto L66;
        r2.append("\n");
        r2.append(r0.name());
        r2.append(" -> ");
        r2.append(r1.name());
        r2.append("\n");
        goto L66
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
        StringBuilder r1 = a.t("\n" + r5.name(), " -> ");
        r1.append(r0.name());
        String r2 = r1.toString();
        if (r5.margin > 0) goto L10;
        if (r6 == true) goto L10;
        if ((r5.run instanceof HelperReferences) == true) goto L10;
    L21:
        r4.append(r2 + "\n");
    L10:
        String r3 = a.j(r2, "[");
        if (r5.margin <= 0) goto L15;
        r3 = a.n(a.t(r3, "label=\""), "\"", r5.margin);
        if (r6 == false) goto L15;
        r3 = a.j(r3, ",");
    L15:
        if (r6 == false) goto L18;
        r3 = a.j(r3, " style=dashed ");
    L18:
        if ((r5.run instanceof HelperReferences) == false) goto L20;
        r3 = a.j(r3, " style=bold,color=gray ");
    L20:
        r2 = a.j(r3, "]");
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
        r1.append("_HORIZONTAL");
    L10:
        r1.append(" [shape=none, label=<<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">  <TR>");
        if (r8 == true) goto L16;
        r1.append("    <TD ");
        if (r9.start.resolved == false) goto L15;
        r1.append(" BGCOLOR=\"green\"");
    L15:
        r1.append(" PORT=\"LEFT\" BORDER=\"1\">L</TD>");
    L20:
        r1.append("    <TD BORDER=\"1\" ");
        boolean r6 = r9.dimension.resolved;
        if (r6 == true) goto L23;
    L25:
        if (r6 == false) goto L28;
        r1.append(" BGCOLOR=\"lightgray\" ");
    L31:
        if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L33;
        r1.append("style=\"dashed\"");
    L33:
        r1.append(">");
        r1.append(r0);
        if (r4 == null) goto L36;
        r1.append(" [");
        r1.append(r4.groupIndex + 1);
        r1.append(LibrarianImpl.Constants.SEPARATOR);
        r1.append(RunGroup.index);
        r1.append("]");
    L36:
        r1.append(" </TD>");
        if (r8 == true) goto L42;
        r1.append("    <TD ");
        if (r9.end.resolved == false) goto L41;
        r1.append(" BGCOLOR=\"green\"");
    L41:
        r1.append(" PORT=\"RIGHT\" BORDER=\"1\">R</TD>");
    L49:
        r1.append("  </TR></TABLE>>];\n");
        return r1.toString();
    L42:
        r1.append("    <TD ");
        if (((VerticalWidgetRun) r9).baseline.resolved == false) goto L45;
        r1.append(" BGCOLOR=\"green\"");
    L45:
        r1.append(" PORT=\"BASELINE\" BORDER=\"1\">b</TD>    <TD ");
        if (r9.end.resolved == false) goto L48;
        r1.append(" BGCOLOR=\"green\"");
    L48:
        r1.append(" PORT=\"BOTTOM\" BORDER=\"1\">B</TD>");
        goto L49
    L28:
        if (r9.widget.measured == false) goto L31;
        r1.append(" BGCOLOR=\"yellow\" ");
        goto L31
    L23:
        if (r9.widget.measured == true) goto L25;
        r1.append(" BGCOLOR=\"green\" ");
        goto L31
    L16:
        r1.append("    <TD ");
        if (r9.start.resolved == false) goto L19;
        r1.append(" BGCOLOR=\"green\"");
    L19:
        r1.append(" PORT=\"TOP\" BORDER=\"1\">T</TD>");
        goto L20
    L9:
        r1.append("_VERTICAL");
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
        boolean r1 = false;
        if (this.mNeedBuildGraph == false) goto L5;
    L6:
        Iterator<ConstraintWidget> r0 = this.container.mChildren.iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        ConstraintWidget r2 = r0.next();
        r2.ensureWidgetRuns();
        r2.measured = false;
        r2.horizontalRun.reset();
        r2.verticalRun.reset();
        goto L8
    L10:
        this.container.ensureWidgetRuns();
        ConstraintWidgetContainer r3 = this.container;
        r3.measured = false;
        r3.horizontalRun.reset();
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
        ConstraintWidgetContainer r11 = this.container;
        ConstraintWidget.DimensionBehaviour r9 = r11.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r12 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r9 != r12) goto L38;
    L41:
        int r13 = r11.getWidth() + r6;
        this.container.horizontalRun.end.resolve(r13);
        this.container.horizontalRun.dimension.resolve(r13 - r6);
        measureWidgets();
        ConstraintWidgetContainer r14 = this.container;
        ConstraintWidget.DimensionBehaviour r15 = r14.mListDimensionBehaviors[1];
        if (r15 != r12) goto L44;
    L45:
        int r16 = r14.getHeight() + r7;
        this.container.verticalRun.end.resolve(r16);
        this.container.verticalRun.dimension.resolve(r16 - r7);
    L46:
        measureWidgets();
        boolean r17 = true;
    L47:
        Iterator<WidgetRun> r18 = this.mRuns.iterator();
    L49:
        if (r18.hasNext() == false) goto L56;
        WidgetRun r19 = r18.next();
        if (r19.widget != this.container) goto L55;
        if (r19.resolved == false) goto L49;
    L55:
        r19.applyToWidget();
        goto L49
    L56:
        Iterator<WidgetRun> r20 = this.mRuns.iterator();
    L58:
        if (r20.hasNext() == false) goto L79;
        WidgetRun r21 = r20.next();
        if (r17 == true) goto L65;
        if (r21.widget == this.container) goto L58;
    L65:
        if (r21.start.resolved == false) goto L80;
        if (r21.end.resolved == true) goto L73;
        if ((r21 instanceof GuidelineReference) == false) goto L80;
    L73:
        if (r21.dimension.resolved == true) goto L58;
        if ((r21 instanceof ChainRun) == true) goto L58;
        if ((r21 instanceof GuidelineReference) == true) goto L58;
    L80:
        this.container.setHorizontalDimensionBehaviour(r4);
        this.container.setVerticalDimensionBehaviour(r5);
        return r1;
    L79:
        r1 = true;
        goto L80
    L44:
        if (r15 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L46;
    L38:
        if (r9 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L41;
        r17 = false;
    L20:
        if (r10 == false) goto L27;
        Iterator<WidgetRun> r22 = this.mRuns.iterator();
    L23:
        if (r22.hasNext() == false) goto L27;
        if (r22.next().supportsWrapComputation() == true) goto L23;
        r10 = false;
    L27:
        if (r10 == true) goto L29;
    L31:
        if (r10 == false) goto L35;
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
        ConstraintWidgetContainer r23 = this.container;
        r23.setWidth(computeWrap(r23, 0));
        ConstraintWidgetContainer r24 = this.container;
        r24.horizontalRun.dimension.resolve(r24.getWidth());
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
        boolean r1 = false;
        ConstraintWidget.DimensionBehaviour r0 = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r2 = this.container.getDimensionBehaviour(1);
        int r4 = this.container.getX();
        int r5 = this.container.getY();
        if (r10 == false) goto L24;
        ConstraintWidget.DimensionBehaviour r6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r0 == r6) goto L7;
        if (r2 != r6) goto L24;
    L7:
        Iterator<WidgetRun> r7 = this.mRuns.iterator();
    L9:
        if (r7.hasNext() == false) goto L15;
        WidgetRun r8 = r7.next();
        if (r8.orientation != r11) goto L9;
        if (r8.supportsWrapComputation() == true) goto L9;
        r10 = false;
    L15:
        if (r11 != 0) goto L20;
        if (r10 == false) goto L24;
        if (r0 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L24;
        this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r12 = this.container;
        r12.setWidth(computeWrap(r12, 0));
        ConstraintWidgetContainer r13 = this.container;
        r13.horizontalRun.dimension.resolve(r13.getWidth());
        goto L24
    L20:
        if (r10 == false) goto L24;
        if (r2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L24;
        this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r14 = this.container;
        r14.setHeight(computeWrap(r14, 1));
        ConstraintWidgetContainer r15 = this.container;
        r15.verticalRun.dimension.resolve(r15.getHeight());
    L24:
        if (r11 != 0) goto L31;
        ConstraintWidgetContainer r16 = this.container;
        ConstraintWidget.DimensionBehaviour r9 = r16.mListDimensionBehaviors[0];
        if (r9 != ConstraintWidget.DimensionBehaviour.FIXED) goto L28;
    L29:
        int r17 = r16.getWidth() + r4;
        this.container.horizontalRun.end.resolve(r17);
        this.container.horizontalRun.dimension.resolve(r17 - r4);
    L30:
        boolean r18 = true;
    L38:
        measureWidgets();
        Iterator<WidgetRun> r19 = this.mRuns.iterator();
    L40:
        if (r19.hasNext() == false) goto L50;
        WidgetRun r20 = r19.next();
        if (r20.orientation != r11) goto L40;
        if (r20.widget != this.container) goto L49;
        if (r20.resolved == false) goto L40;
    L49:
        r20.applyToWidget();
        goto L40
    L50:
        Iterator<WidgetRun> r21 = this.mRuns.iterator();
    L52:
        if (r21.hasNext() == false) goto L71;
        WidgetRun r22 = r21.next();
        if (r22.orientation != r11) goto L52;
        if (r18 == true) goto L61;
        if (r22.widget == this.container) goto L52;
    L61:
        if (r22.start.resolved == false) goto L72;
        if (r22.end.resolved == false) goto L72;
        if ((r22 instanceof ChainRun) == true) goto L52;
        if (r22.dimension.resolved == true) goto L52;
    L72:
        this.container.setHorizontalDimensionBehaviour(r0);
        this.container.setVerticalDimensionBehaviour(r2);
        return r1;
    L71:
        r1 = true;
        goto L72
    L28:
        if (r9 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L29;
    L36:
        r18 = false;
        goto L38
    L31:
        ConstraintWidgetContainer r110 = this.container;
        ConstraintWidget.DimensionBehaviour r23 = r110.mListDimensionBehaviors[1];
        if (r23 != ConstraintWidget.DimensionBehaviour.FIXED) goto L34;
    L37:
        int r111 = r110.getHeight() + r5;
        this.container.verticalRun.end.resolve(r111);
        this.container.verticalRun.dimension.resolve(r111 - r5);
        goto L30
    L34:
        if (r23 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L36;
        goto L36
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
        if (r0.hasNext() == false) goto L42;
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
        if (r11 == false) goto L25;
        if (r13 == false) goto L25;
        ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.FIXED;
        measure(r1, r14, r9.value, r14, r12.value);
        r1.measured = true;
    L38:
        if (r1.measured == false) goto L4;
        DimensionDependency r15 = r1.verticalRun.baselineDimension;
        if (r15 == null) goto L4;
        r15.resolve(r1.getBaselineDistance());
    L25:
        if (r11 == false) goto L31;
        if (r3 == false) goto L31;
        measure(r1, ConstraintWidget.DimensionBehaviour.FIXED, r9.value, r6, r12.value);
        if (r10 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L30;
        r1.verticalRun.dimension.wrapValue = r1.getHeight();
        goto L38
    L30:
        r1.verticalRun.dimension.resolve(r1.getHeight());
        r1.measured = true;
    L31:
        if (r13 == false) goto L38;
        if (r7 == false) goto L38;
        measure(r1, r6, r9.value, ConstraintWidget.DimensionBehaviour.FIXED, r12.value);
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L36;
        r1.horizontalRun.dimension.wrapValue = r1.getWidth();
        goto L38
    L36:
        r1.horizontalRun.dimension.resolve(r1.getWidth());
        r1.measured = true;
        goto L38
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

    public void buildGraph(ArrayList<WidgetRun> r6) {
        r6.clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        r6.add(this.mContainer.horizontalRun);
        r6.add(this.mContainer.verticalRun);
        Iterator<ConstraintWidget> r0 = this.mContainer.mChildren.iterator();
        HashSet r1 = null;
    L4:
        if (r0.hasNext() == false) goto L29;
        ConstraintWidget r2 = r0.next();
        if ((r2 instanceof Guideline) == true) goto L7;
        if (r2.isInHorizontalChain() == true) goto L11;
        r6.add(r2.horizontalRun);
    L18:
        if (r2.isInVerticalChain() == true) goto L20;
        r6.add(r2.verticalRun);
    L27:
        if ((r2 instanceof HelperWidget) == false) goto L4;
        r6.add(new HelperReferences(r2));
        goto L4
    L20:
        if (r2.verticalChainRun != null) goto L22;
        r2.verticalChainRun = new ChainRun(r2, 1);
    L22:
        if (r1 != null) goto L24;
        r1 = new HashSet();
    L24:
        r1.add(r2.verticalChainRun);
        goto L27
    L11:
        if (r2.horizontalChainRun != null) goto L13;
        r2.horizontalChainRun = new ChainRun(r2, 0);
    L13:
        if (r1 != null) goto L15;
        r1 = new HashSet();
    L15:
        r1.add(r2.horizontalChainRun);
        goto L18
    L7:
        r6.add(new GuidelineReference(r2));
        goto L4
    L29:
        if (r1 == null) goto L31;
        r6.addAll(r1);
    L31:
        Iterator<WidgetRun> r3 = r6.iterator();
    L33:
        if (r3.hasNext() == false) goto L35;
        r3.next().clear();
        goto L33
    L35:
        Iterator<WidgetRun> r7 = r6.iterator();
    L37:
        if (r7.hasNext() == false) goto L42;
        WidgetRun r4 = r7.next();
        if (r4.widget == this.mContainer) goto L37;
        r4.apply();
        goto L37
    }
}
