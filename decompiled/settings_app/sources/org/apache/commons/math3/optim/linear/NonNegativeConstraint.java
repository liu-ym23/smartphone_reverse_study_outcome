package org.apache.commons.math3.optim.linear;

import org.apache.commons.math3.optim.OptimizationData;

/* JADX INFO: loaded from: classes6.dex */
public class NonNegativeConstraint implements OptimizationData {
    private final boolean isRestricted;

    public NonNegativeConstraint(boolean r1) {
        this.isRestricted = r1;
    }

    public boolean isRestrictedToNonNegative() {
        return this.isRestricted;
    }
}
