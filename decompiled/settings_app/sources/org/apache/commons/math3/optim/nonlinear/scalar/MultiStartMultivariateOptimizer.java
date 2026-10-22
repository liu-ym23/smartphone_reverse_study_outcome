package org.apache.commons.math3.optim.nonlinear.scalar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.optim.BaseMultiStartMultivariateOptimizer;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.random.RandomVectorGenerator;

/* JADX INFO: loaded from: classes6.dex */
public class MultiStartMultivariateOptimizer extends BaseMultiStartMultivariateOptimizer<PointValuePair> {
    private final List<PointValuePair> optima;
    private final MultivariateOptimizer optimizer;

    static /* synthetic */ MultivariateOptimizer access$000(MultiStartMultivariateOptimizer r0) {
        return r0.optimizer;
    }

    @Override // org.apache.commons.math3.optim.BaseMultiStartMultivariateOptimizer
    public /* bridge */ /* synthetic */ PointValuePair[] getOptima() {
        return getOptima2();
    }

    @Override // org.apache.commons.math3.optim.BaseMultiStartMultivariateOptimizer
    protected /* bridge */ /* synthetic */ void store(PointValuePair r1) {
        store2(r1);
    }

    public MultiStartMultivariateOptimizer(MultivariateOptimizer r1, int r2, RandomVectorGenerator r3) throws NullArgumentException, NotStrictlyPositiveException {
        super(r1, r2, r3);
        this.optima = new ArrayList();
        this.optimizer = r1;
    }

    @Override // org.apache.commons.math3.optim.BaseMultiStartMultivariateOptimizer
    /* JADX INFO: renamed from: getOptima, reason: avoid collision after fix types in other method */
    public PointValuePair[] getOptima2() {
        Collections.sort(this.optima, getPairComparator());
        return (PointValuePair[]) this.optima.toArray(new PointValuePair[0]);
    }

    /* JADX INFO: renamed from: store, reason: avoid collision after fix types in other method */
    protected void store2(PointValuePair r1) {
        this.optima.add(r1);
    }

    @Override // org.apache.commons.math3.optim.BaseMultiStartMultivariateOptimizer
    protected void clear() {
        this.optima.clear();
    }

    private Comparator<PointValuePair> getPairComparator() {
        return new AnonymousClass1(this);
    }
}
