package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
class InsideFinder<S extends Space> {
    private boolean minusFound;
    private boolean plusFound;
    private final Region<S> region;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.partitioning.InsideFinder$1, reason: invalid class name */
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

    InsideFinder(Region<S> r1) {
        this.region = r1;
        this.plusFound = false;
        this.minusFound = false;
    }

    public void recurseSides(BSPTree<S> r5, SubHyperplane<S> r6) {
        if (r5.getCut() == null) goto L5;
        SubHyperplane.SplitSubHyperplane<S> r0 = r6.split(r5.getCut().getHyperplane());
        int r2 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[r0.getSide().ordinal()];
        if (r2 == 1) goto L55;
        if (r2 == 2) goto L42;
        if (r2 != 3) goto L15;
        recurseSides(r5.getPlus(), r0.getPlus());
        if (this.plusFound == true) goto L39;
    L40:
        recurseSides(r5.getMinus(), r0.getMinus());
        return;
    L39:
        if (this.minusFound == false) goto L40;
        return;
    L15:
        if (r5.getCut().getHyperplane().sameOrientationAs(r6.getHyperplane()) == false) goto L27;
        if (r5.getPlus().getCut() == null) goto L19;
    L20:
        this.plusFound = true;
    L22:
        if (r5.getMinus().getCut() == null) goto L24;
    L25:
        this.minusFound = true;
        return;
    L24:
        if (((Boolean) r5.getMinus().getAttribute()).booleanValue() == true) goto L25;
        return;
    L19:
        if (((Boolean) r5.getPlus().getAttribute()).booleanValue() == false) goto L22;
    L27:
        if (r5.getPlus().getCut() == null) goto L29;
    L30:
        this.minusFound = true;
    L32:
        if (r5.getMinus().getCut() == null) goto L34;
    L35:
        this.plusFound = true;
        return;
    L34:
        if (((Boolean) r5.getMinus().getAttribute()).booleanValue() == true) goto L35;
        return;
    L29:
        if (((Boolean) r5.getPlus().getAttribute()).booleanValue() == false) goto L32;
    L42:
        if (r5.getCut().split(r6.getHyperplane()).getSide() != Side.PLUS) goto L47;
        if (this.region.isEmpty(r5.getPlus()) == true) goto L50;
        this.plusFound = true;
    L50:
        if (this.plusFound == true) goto L52;
    L53:
        recurseSides(r5.getMinus(), r6);
        return;
    L52:
        if (this.minusFound == false) goto L53;
        return;
    L47:
        if (this.region.isEmpty(r5.getPlus()) == true) goto L50;
        this.minusFound = true;
        goto L50
    L55:
        if (r5.getCut().split(r6.getHyperplane()).getSide() != Side.PLUS) goto L60;
        if (this.region.isEmpty(r5.getMinus()) == true) goto L63;
        this.plusFound = true;
    L63:
        if (this.plusFound == true) goto L65;
    L66:
        recurseSides(r5.getPlus(), r6);
        return;
    L65:
        if (this.minusFound == false) goto L66;
        return;
    L60:
        if (this.region.isEmpty(r5.getMinus()) == true) goto L63;
        this.minusFound = true;
        goto L63
    L5:
        if (((Boolean) r5.getAttribute()).booleanValue() == false) goto L68;
        this.plusFound = true;
        this.minusFound = true;
        return;
    }

    public boolean plusFound() {
        return this.plusFound;
    }

    public boolean minusFound() {
        return this.minusFound;
    }
}
