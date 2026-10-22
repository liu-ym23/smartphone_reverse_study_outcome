package org.apache.commons.math3.analysis.integration.gauss;

import java.math.BigDecimal;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class GaussIntegratorFactory {
    private final BaseRuleFactory<Double> hermite;
    private final BaseRuleFactory<Double> legendre;
    private final BaseRuleFactory<BigDecimal> legendreHighPrecision;

    public GaussIntegratorFactory() {
        this.legendre = new LegendreRuleFactory();
        this.legendreHighPrecision = new LegendreHighPrecisionRuleFactory();
        this.hermite = new HermiteRuleFactory();
    }

    public GaussIntegrator legendre(int r2) {
        return new GaussIntegrator(getRule(this.legendre, r2));
    }

    public GaussIntegrator legendre(int r2, double r3, double r5) throws NotStrictlyPositiveException {
        return new GaussIntegrator(transform(getRule(this.legendre, r2), r3, r5));
    }

    public GaussIntegrator legendreHighPrecision(int r2) throws NotStrictlyPositiveException {
        return new GaussIntegrator(getRule(this.legendreHighPrecision, r2));
    }

    public GaussIntegrator legendreHighPrecision(int r2, double r3, double r5) throws NotStrictlyPositiveException {
        return new GaussIntegrator(transform(getRule(this.legendreHighPrecision, r2), r3, r5));
    }

    public SymmetricGaussIntegrator hermite(int r2) {
        return new SymmetricGaussIntegrator(getRule(this.hermite, r2));
    }

    private static Pair<double[], double[]> getRule(BaseRuleFactory<? extends Number> r0, int r1) throws NotStrictlyPositiveException, DimensionMismatchException {
        return r0.getRule(r1);
    }

    private static Pair<double[], double[]> transform(Pair<double[], double[]> r4, double r5, double r7) {
        double[] r0 = r4.getFirst();
        double[] r6 = r4.getSecond();
        double r8 = (r7 - r5) / 2.0d;
        double r9 = r5 + r8;
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L7;
        r0[r1] = (r0[r1] * r8) + r9;
        r6[r1] = r6[r1] * r8;
        r1 = r1 + 1;
        goto L4
    L7:
        return new Pair(r0, r6);
    }
}
