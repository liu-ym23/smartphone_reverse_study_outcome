package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public interface SubHyperplane<S extends Space> {

    public static class SplitSubHyperplane<U extends Space> {
        private final SubHyperplane<U> minus;
        private final SubHyperplane<U> plus;

        public SplitSubHyperplane(SubHyperplane<U> r1, SubHyperplane<U> r2) {
            this.plus = r1;
            this.minus = r2;
        }

        public SubHyperplane<U> getPlus() {
            return this.plus;
        }

        public SubHyperplane<U> getMinus() {
            return this.minus;
        }

        public Side getSide() {
            SubHyperplane<U> r0 = this.plus;
            if (r0 != null) goto L5;
        L14:
            SubHyperplane<U> r1 = this.minus;
            if (r1 == null) goto L21;
            if (r1.isEmpty() == true) goto L21;
            return Side.MINUS;
        L21:
            return Side.HYPER;
        L5:
            if (r0.isEmpty() == true) goto L14;
            SubHyperplane<U> r2 = this.minus;
            if (r2 == null) goto L13;
            if (r2.isEmpty() == true) goto L13;
            return Side.BOTH;
        L13:
            return Side.PLUS;
        }
    }

    SubHyperplane<S> copySelf();

    Hyperplane<S> getHyperplane();

    double getSize();

    boolean isEmpty();

    SubHyperplane<S> reunite(SubHyperplane<S> r1);

    @Deprecated
    Side side(Hyperplane<S> r1);

    SplitSubHyperplane<S> split(Hyperplane<S> r1);
}
