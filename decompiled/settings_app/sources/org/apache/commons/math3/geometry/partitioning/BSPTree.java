package org.apache.commons.math3.geometry.partitioning;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class BSPTree<S extends Space> {
    private Object attribute;
    private SubHyperplane<S> cut;
    private BSPTree<S> minus;
    private BSPTree<S> parent;
    private BSPTree<S> plus;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.partitioning.BSPTree$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = null;

        static {
            int[] r0 = new int[Side.values().length];
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = r0;
            r0[Side.PLUS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L27:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.MINUS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L33:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.BOTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L8:
            int[] r3 = new int[BSPTreeVisitor.Order.values().length];
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order = r3;
            r3[BSPTreeVisitor.Order.PLUS_MINUS_SUB.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L41:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[BSPTreeVisitor.Order.PLUS_SUB_MINUS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L25:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[BSPTreeVisitor.Order.MINUS_PLUS_SUB.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L31:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[BSPTreeVisitor.Order.MINUS_SUB_PLUS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L39:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[BSPTreeVisitor.Order.SUB_PLUS_MINUS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L29:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[BSPTreeVisitor.Order.SUB_MINUS_PLUS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
            return;
        }
    }

    public interface LeafMerger<S extends Space> {
        BSPTree<S> merge(BSPTree<S> r1, BSPTree<S> r2, BSPTree<S> r3, boolean r4, boolean r5);
    }

    public interface VanishingCutHandler<S extends Space> {
        BSPTree<S> fixNode(BSPTree<S> r1);
    }

    public BSPTree() {
        this.cut = null;
        this.plus = null;
        this.minus = null;
        this.parent = null;
        this.attribute = null;
    }

    public BSPTree(Object r2) {
        this.cut = null;
        this.plus = null;
        this.minus = null;
        this.parent = null;
        this.attribute = r2;
    }

    public BSPTree(SubHyperplane<S> r1, BSPTree<S> r2, BSPTree<S> r3, Object r4) {
        this.cut = r1;
        this.plus = r2;
        this.minus = r3;
        this.parent = null;
        this.attribute = r4;
        r2.parent = this;
        r3.parent = this;
    }

    public boolean insertCut(Hyperplane<S> r3) {
        if (this.cut == null) goto L5;
        this.plus.parent = null;
        this.minus.parent = null;
    L5:
        SubHyperplane<S> r4 = fitToCell(r3.wholeHyperplane());
        if (r4 != null) goto L8;
    L12:
        this.cut = null;
        this.plus = null;
        this.minus = null;
        return false;
    L8:
        if (r4.isEmpty() == true) goto L12;
        this.cut = r4;
        BSPTree<S> r5 = new BSPTree();
        this.plus = r5;
        r5.parent = this;
        BSPTree<S> r6 = new BSPTree();
        this.minus = r6;
        r6.parent = this;
        return true;
    }

    public BSPTree<S> copySelf() {
        SubHyperplane<S> r0 = this.cut;
        if (r0 != null) goto L7;
        return new BSPTree(this.attribute);
    L7:
        return new BSPTree(r0.copySelf(), this.plus.copySelf(), this.minus.copySelf(), this.attribute);
    }

    public SubHyperplane<S> getCut() {
        return this.cut;
    }

    public BSPTree<S> getPlus() {
        return this.plus;
    }

    public BSPTree<S> getMinus() {
        return this.minus;
    }

    public BSPTree<S> getParent() {
        return this.parent;
    }

    public void setAttribute(Object r1) {
        this.attribute = r1;
    }

    public Object getAttribute() {
        return this.attribute;
    }

    public void visit(BSPTreeVisitor<S> r3) {
        if (this.cut != null) goto L6;
        r3.visitLeafNode(this);
        return;
    L6:
        switch(AnonymousClass2.$SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[r3.visitOrder(this).ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        r3.visitInternalNode(this);
        this.minus.visit(r3);
        this.plus.visit(r3);
        return;
    L10:
        r3.visitInternalNode(this);
        this.plus.visit(r3);
        this.minus.visit(r3);
        return;
    L11:
        this.minus.visit(r3);
        r3.visitInternalNode(this);
        this.plus.visit(r3);
        return;
    L12:
        this.minus.visit(r3);
        this.plus.visit(r3);
        r3.visitInternalNode(this);
        return;
    L13:
        this.plus.visit(r3);
        r3.visitInternalNode(this);
        this.minus.visit(r3);
        return;
    L14:
        this.plus.visit(r3);
        this.minus.visit(r3);
        r3.visitInternalNode(this);
        return;
    L8:
        throw new MathInternalError();
    }

    private SubHyperplane<S> fitToCell(SubHyperplane<S> r3) {
    L2:
        BSPTree<S> r0 = this.parent;
        if (r0 == null) goto L10;
        if (r3 == null) goto L10;
        if (this != r0.plus) goto L8;
        r3 = r3.split(r0.cut.getHyperplane()).getPlus();
    L9:
        BSPTree<S> this = this.parent;
        goto L2
    L8:
        r3 = r3.split(r0.cut.getHyperplane()).getMinus();
    L10:
        return r3;
    }

    @Deprecated
    public BSPTree<S> getCell(Vector<S> r3) {
        return getCell(r3, 1.0E-10d);
    }

    public BSPTree<S> getCell(Point<S> r5, double r6) {
        SubHyperplane<S> r0 = this.cut;
        if (r0 != null) goto L5;
        return this;
    L5:
        double r1 = r0.getHyperplane().getOffset(r5);
        if (FastMath.abs(r1) >= r6) goto L9;
        return this;
    L9:
        if (r1 > 0.0d) goto L13;
        return this.minus.getCell(r5, r6);
    L13:
        return this.plus.getCell(r5, r6);
    }

    public List<BSPTree<S>> getCloseCuts(Point<S> r2, double r3) {
        ArrayList r0 = new ArrayList();
        recurseCloseCuts(r2, r3, r0);
        return r0;
    }

    private void recurseCloseCuts(Point<S> r5, double r6, List<BSPTree<S>> r8) {
        SubHyperplane<S> r0 = this.cut;
        if (r0 == null) goto L12;
        double r1 = r0.getHyperplane().getOffset(r5);
        if (r1 >= (-r6)) goto L8;
        this.minus.recurseCloseCuts(r5, r6, r8);
        return;
    L8:
        if (r1 <= r6) goto L10;
        this.plus.recurseCloseCuts(r5, r6, r8);
        return;
    L10:
        r8.add(this);
        this.minus.recurseCloseCuts(r5, r6, r8);
        this.plus.recurseCloseCuts(r5, r6, r8);
        return;
    }

    private void condense() {
        if (this.cut == null) goto L20;
        BSPTree<S> r0 = this.plus;
        if (r0.cut != null) goto L21;
        BSPTree<S> r1 = this.minus;
        if (r1.cut != null) goto L22;
        Object r2 = r0.attribute;
        if (r2 == null) goto L11;
    L12:
        if (r2 != null) goto L14;
        return;
    L14:
        if (r2.equals(r1.attribute) == false) goto L24;
    L15:
        Object r3 = this.plus.attribute;
        if (r3 != null) goto L18;
        r3 = this.minus.attribute;
    L18:
        this.attribute = r3;
        this.cut = null;
        this.plus = null;
        this.minus = null;
        return;
    L24:
        return;
    L11:
        if (r1.attribute == null) goto L15;
    L22:
        return;
    L21:
        return;
    }

    public BSPTree<S> merge(BSPTree<S> r3, LeafMerger<S> r4) {
        return merge(r3, r4, null, false);
    }

    private BSPTree<S> merge(BSPTree<S> r9, LeafMerger<S> r10, BSPTree<S> r11, boolean r12) {
        SubHyperplane<S> r0 = this.cut;
        if (r0 != null) goto L7;
        return r10.merge(this, r9, r11, r12, true);
    L7:
        if (r9.cut == null) goto L9;
        BSPTree<S> r13 = r9.split(r0);
        if (r11 == null) goto L16;
        r13.parent = r11;
        if (r12 == false) goto L15;
        r11.plus = r13;
        goto L16
    L15:
        r11.minus = r13;
    L16:
        this.plus.merge(r13.plus, r10, r13, true);
        this.minus.merge(r13.minus, r10, r13, false);
        r13.condense();
        SubHyperplane<S> r8 = r13.cut;
        if (r8 == null) goto L19;
        r13.cut = r13.fitToCell(r8.getHyperplane().wholeHyperplane());
    L19:
        return r13;
    L9:
        return r10.merge(r9, this, r11, r12, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public BSPTree<S> split(SubHyperplane<S> r7) {
        SubHyperplane<S> r0 = this.cut;
        if (r0 == null) goto L5;
        Hyperplane<S> r1 = r0.getHyperplane();
        Hyperplane<S> r2 = r7.getHyperplane();
        SubHyperplane.SplitSubHyperplane<S> r3 = r7.split(r1);
        int r4 = AnonymousClass2.$SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[r3.getSide().ordinal()];
        if (r4 != 1) goto L9;
        BSPTree<S> r8 = this.plus.split(r7);
        if (this.cut.split(r2).getSide() != Side.PLUS) goto L27;
        BSPTree<S> r5 = new BSPTree(this.cut.copySelf(), r8.plus, this.minus.copySelf(), this.attribute);
        r8.plus = r5;
        r5.condense();
        r8.plus.parent = r8;
    L28:
        return r8;
    L27:
        BSPTree<S> r6 = new BSPTree(this.cut.copySelf(), r8.minus, this.minus.copySelf(), this.attribute);
        r8.minus = r6;
        r6.condense();
        r8.minus.parent = r8;
        goto L28
    L9:
        if (r4 != 2) goto L11;
        BSPTree<S> r9 = this.minus.split(r7);
        if (this.cut.split(r2).getSide() != Side.PLUS) goto L22;
        BSPTree<S> r10 = new BSPTree(this.cut.copySelf(), this.plus.copySelf(), r9.plus, this.attribute);
        r9.plus = r10;
        r10.condense();
        r9.plus.parent = r9;
    L23:
        return r9;
    L22:
        BSPTree<S> r11 = new BSPTree(this.cut.copySelf(), this.plus.copySelf(), r9.minus, this.attribute);
        r9.minus = r11;
        r11.condense();
        r9.minus.parent = r9;
        goto L23
    L11:
        if (r4 != 3) goto L13;
        SubHyperplane.SplitSubHyperplane<S> r12 = this.cut.split(r2);
        BSPTree<S> r13 = new BSPTree(r7, this.plus.split(r3.getPlus()), this.minus.split(r3.getMinus()), null);
        BSPTree<S> r14 = r13.plus;
        r14.cut = (SubHyperplane<S>) r12.getPlus();
        BSPTree<S> r15 = r13.minus;
        r15.cut = (SubHyperplane<S>) r12.getMinus();
        BSPTree<S> r16 = r13.plus;
        BSPTree<S> r17 = r16.minus;
        BSPTree<S> r18 = r13.minus.plus;
        r16.minus = r18;
        r18.parent = r16;
        BSPTree<S> r19 = r13.minus;
        r19.plus = r17;
        r17.parent = r19;
        r13.plus.condense();
        r13.minus.condense();
        return r13;
    L13:
        if (r1.sameOrientationAs(r2) == false) goto L16;
        return new BSPTree(r7, this.plus.copySelf(), this.minus.copySelf(), this.attribute);
    L16:
        return new BSPTree(r7, this.minus.copySelf(), this.plus.copySelf(), this.attribute);
    L5:
        return new BSPTree(r7, copySelf(), new BSPTree(this.attribute), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void insertInTree(BSPTree<S> r2, boolean r3) {
        insertInTree(r2, r3, new AnonymousClass1(this));
    }

    public void insertInTree(BSPTree<S> r3, boolean r4, VanishingCutHandler<S> r5) {
        this.parent = r3;
        if (r3 == null) goto L8;
        if (r4 == false) goto L6;
        r3.plus = this;
        goto L8
    L6:
        r3.minus = this;
    L8:
        if (this.cut == null) goto L28;
        BSPTree<S> r6 = this;
    L10:
        BSPTree<S> r7 = r6.parent;
        if (r7 == null) goto L22;
        Hyperplane<S> r8 = r7.cut.getHyperplane();
        if (r6 != r6.parent.plus) goto L15;
        this.cut = (SubHyperplane<S>) this.cut.split(r8).getPlus();
        this.plus.chopOffMinus(r8, r5);
        this.minus.chopOffMinus(r8, r5);
    L17:
        if (this.cut != null) goto L21;
        BSPTree<S> r9 = r5.fixNode(this);
        SubHyperplane<S> r0 = r9.cut;
        this.cut = r0;
        this.plus = r9.plus;
        this.minus = r9.minus;
        this.attribute = r9.attribute;
        if (r0 == null) goto L22;
    L21:
        r6 = r6.parent;
        goto L10
    L15:
        this.cut = (SubHyperplane<S>) this.cut.split(r8).getMinus();
        this.plus.chopOffPlus(r8, r5);
        this.minus.chopOffPlus(r8, r5);
    L22:
        condense();
        return;
    }

    public BSPTree<S> pruneAroundConvexCell(Object r4, Object r5, Object r6) {
        BSPTree<S> r0 = new BSPTree(r4);
    L3:
        BSPTree<S> r7 = this.parent;
        if (r7 == null) goto L10;
        SubHyperplane<S> r8 = r7.cut.copySelf();
        BSPTree r1 = new BSPTree(r5);
        if (this != this.parent.plus) goto L8;
        BSPTree<S> r2 = new BSPTree(r8, r0, r1, r6);
    L9:
        r0 = r2;
        BSPTree<S> this = this.parent;
        goto L3
    L8:
        r2 = new BSPTree(r8, r1, r0, r6);
        goto L9
    L10:
        return r0;
    }

    private void chopOffMinus(Hyperplane<S> r2, VanishingCutHandler<S> r3) {
        SubHyperplane<S> r0 = this.cut;
        if (r0 == null) goto L8;
        this.cut = (SubHyperplane<S>) r0.split(r2).getPlus();
        this.plus.chopOffMinus(r2, r3);
        this.minus.chopOffMinus(r2, r3);
        if (this.cut != null) goto L9;
        BSPTree<S> r4 = r3.fixNode(this);
        this.cut = r4.cut;
        this.plus = r4.plus;
        this.minus = r4.minus;
        this.attribute = r4.attribute;
        return;
    L9:
        return;
    }

    private void chopOffPlus(Hyperplane<S> r2, VanishingCutHandler<S> r3) {
        SubHyperplane<S> r0 = this.cut;
        if (r0 == null) goto L8;
        this.cut = (SubHyperplane<S>) r0.split(r2).getMinus();
        this.plus.chopOffPlus(r2, r3);
        this.minus.chopOffPlus(r2, r3);
        if (this.cut != null) goto L9;
        BSPTree<S> r4 = r3.fixNode(this);
        this.cut = r4.cut;
        this.plus = r4.plus;
        this.minus = r4.minus;
        this.attribute = r4.attribute;
        return;
    L9:
        return;
    }
}
