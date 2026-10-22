package com.google.common.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public class BigDecimalMath {

    private static class BigDecimalToDoubleRounder extends ToDoubleRounder<BigDecimal> {
        static final BigDecimalToDoubleRounder INSTANCE = null;

        @Override // com.google.common.math.ToDoubleRounder
        /* bridge */ /* synthetic */ Number minus(Number r1, Number r2) {
            return minus((BigDecimal) r1, (BigDecimal) r2);
        }

        @Override // com.google.common.math.ToDoubleRounder
        /* bridge */ /* synthetic */ double roundToDoubleArbitrarily(Number r1) {
            return roundToDoubleArbitrarily((BigDecimal) r1);
        }

        @Override // com.google.common.math.ToDoubleRounder
        /* bridge */ /* synthetic */ int sign(Number r1) {
            return sign((BigDecimal) r1);
        }

        @Override // com.google.common.math.ToDoubleRounder
        /* bridge */ /* synthetic */ Number toX(double r1, RoundingMode r3) {
            return toX(r1, r3);
        }

        static {
            INSTANCE = new BigDecimalToDoubleRounder();
        }

        private BigDecimalToDoubleRounder() {
        }

        double roundToDoubleArbitrarily(BigDecimal r1) {
            return r1.doubleValue();
        }

        int sign(BigDecimal r1) {
            return r1.signum();
        }

        @Override // com.google.common.math.ToDoubleRounder
        BigDecimal toX(double r1, RoundingMode r3) {
            return new BigDecimal(r1);
        }

        BigDecimal minus(BigDecimal r1, BigDecimal r2) {
            return r1.subtract(r2);
        }
    }

    private BigDecimalMath() {
    }

    public static double roundToDouble(BigDecimal r1, RoundingMode r2) {
        return BigDecimalToDoubleRounder.INSTANCE.roundToDouble(r1, r2);
    }
}
