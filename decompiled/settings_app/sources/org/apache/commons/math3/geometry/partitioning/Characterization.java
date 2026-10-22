package org.apache.commons.math3.geometry.partitioning;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
class Characterization<S extends Space> {
    private final NodesSet<S> insideSplitters;
    private SubHyperplane<S> insideTouching;
    private final NodesSet<S> outsideSplitters;
    private SubHyperplane<S> outsideTouching;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.partitioning.Characterization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = null;

        static {
            int[] r0 = new int[Side.values().length];
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = r0;
            r0[Side.PLUS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.MINUS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.BOTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    Characterization(BSPTree<S> r2, SubHyperplane<S> r3) {
        this.outsideTouching = null;
        this.insideTouching = null;
        this.outsideSplitters = new NodesSet();
        this.insideSplitters = new NodesSet();
        characterize(r2, r3, new ArrayList());
    }

    private void characterize(BSPTree<S> r5, SubHyperplane<S> r6, List<BSPTree<S>> r7) {
        if (r5.getCut() == null) goto L5;
        SubHyperplane.SplitSubHyperplane<S> r0 = r6.split(r5.getCut().getHyperplane());
        int r1 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[r0.getSide().ordinal()];
        if (r1 != 1) goto L11;
        characterize(r5.getPlus(), r6, r7);
        return;
    L11:
        if (r1 != 2) goto L13;
        characterize(r5.getMinus(), r6, r7);
        return;
    L13:
        if (r1 != 3) goto L16;
        r7.add(r5);
        characterize(r5.getPlus(), r0.getPlus(), r7);
        characterize(r5.getMinus(), r0.getMinus(), r7);
        r7.remove(r7.size() - 1);
        return;
    L16:
        throw new MathInternalError();
    L5:
        if (((Boolean) r5.getAttribute()).booleanValue() == false) goto L7;
        addInsideTouching(r6, r7);
        return;
    L7:
        addOutsideTouching(r6, r7);
    }

    private void addOutsideTouching(SubHyperplane<S> r2, List<BSPTree<S>> r3) {
        SubHyperplane<S> r0 = this.outsideTouching;
        if (r0 != null) goto L5;
        this.outsideTouching = r2;
    L6:
        this.outsideSplitters.addAll(r3);
        return;
    L5:
        this.outsideTouching = r0.reunite(r2);
        goto L6
    }

    private void addInsideTouching(SubHyperplane<S> r2, List<BSPTree<S>> r3) {
        SubHyperplane<S> r0 = this.insideTouching;
        if (r0 != null) goto L5;
        this.insideTouching = r2;
    L6:
        this.insideSplitters.addAll(r3);
        return;
    L5:
        this.insideTouching = r0.reunite(r2);
        goto L6
    }

    public boolean touchOutside() {
        SubHyperplane<S> r0 = this.outsideTouching;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L7;
        return true;
    }

    public SubHyperplane<S> outsideTouching() {
        return this.outsideTouching;
    }

    public NodesSet<S> getOutsideSplitters() {
        return this.outsideSplitters;
    }

    public boolean touchInside() {
        SubHyperplane<S> r0 = this.insideTouching;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L7;
        return true;
    }

    public SubHyperplane<S> insideTouching() {
        return this.insideTouching;
    }

    public NodesSet<S> getInsideSplitters() {
        return this.insideSplitters;
    }
}
