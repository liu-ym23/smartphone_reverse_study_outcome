package org.apache.commons.math3.optim.linear;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.math3.optim.OptimizationData;

/* JADX INFO: loaded from: classes6.dex */
public class LinearConstraintSet implements OptimizationData {
    private final Set<LinearConstraint> linearConstraints;

    public LinearConstraintSet(LinearConstraint... r5) {
        this.linearConstraints = new LinkedHashSet();
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        LinearConstraint r2 = r5[r1];
        this.linearConstraints.add(r2);
        r1 = r1 + 1;
        goto L3
    }

    public LinearConstraintSet(Collection<LinearConstraint> r2) {
        LinkedHashSet r0 = new LinkedHashSet();
        this.linearConstraints = r0;
        r0.addAll(r2);
    }

    public Collection<LinearConstraint> getConstraints() {
        return Collections.unmodifiableSet(this.linearConstraints);
    }
}
