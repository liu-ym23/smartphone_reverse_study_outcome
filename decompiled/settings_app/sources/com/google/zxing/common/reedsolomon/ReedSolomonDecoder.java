package com.google.zxing.common.reedsolomon;

/* JADX INFO: loaded from: classes4.dex */
public final class ReedSolomonDecoder {
    private final GenericGF field;

    public ReedSolomonDecoder(GenericGF r1) {
        this.field = r1;
    }

    public void decode(int[] r9, int r10) throws ReedSolomonException {
        GenericGFPoly r0 = new GenericGFPoly(this.field, r9);
        int[] r1 = new int[r10];
        int r3 = 0;
        boolean r5 = true;
        int r4 = 0;
    L3:
        if (r4 >= r10) goto L8;
        GenericGF r6 = this.field;
        int r7 = r0.evaluateAt(r6.exp(r6.getGeneratorBase() + r4));
        r1[(r10 - 1) - r4] = r7;
        if (r7 == 0) goto L7;
        r5 = false;
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        if (r5 == false) goto L10;
        return;
    L10:
        GenericGFPoly[] r11 = runEuclideanAlgorithm(this.field.buildMonomial(r10, 1), new GenericGFPoly(this.field, r1), r10);
        GenericGFPoly r2 = r11[0];
        GenericGFPoly r12 = r11[1];
        int[] r8 = findErrorLocations(r2);
        int[] r13 = findErrorMagnitudes(r12, r8);
    L12:
        if (r3 >= r8.length) goto L18;
        int r14 = (r9.length - 1) - this.field.log(r8[r3]);
        if (r14 < 0) goto L17;
        r9[r14] = GenericGF.addOrSubtract(r9[r14], r13[r3]);
        r3 = r3 + 1;
        goto L12
    L17:
        throw new ReedSolomonException("Bad error location");
    }

    private GenericGFPoly[] runEuclideanAlgorithm(GenericGFPoly r10, GenericGFPoly r11, int r12) throws ReedSolomonException {
        if (r10.getDegree() >= r11.getDegree()) goto L5;
        r11 = r10;
        r10 = r11;
    L5:
        GenericGFPoly r0 = this.field.getZero();
        GenericGFPoly r1 = this.field.getOne();
    L6:
        GenericGFPoly r7 = r11;
        r11 = r10;
        r10 = r7;
        GenericGFPoly r8 = r1;
        GenericGFPoly r2 = r0;
        r0 = r8;
        if (r10.getDegree() < (r12 / 2)) goto L23;
        if (r10.isZero() == true) goto L22;
        GenericGFPoly r3 = this.field.getZero();
        int r4 = this.field.inverse(r10.getCoefficient(r10.getDegree()));
    L12:
        if (r11.getDegree() < r10.getDegree()) goto L16;
        if (r11.isZero() == true) goto L16;
        int r5 = r11.getDegree() - r10.getDegree();
        int r6 = this.field.multiply(r11.getCoefficient(r11.getDegree()), r4);
        r3 = r3.addOrSubtract(this.field.buildMonomial(r5, r6));
        r11 = r11.addOrSubtract(r10.multiplyByMonomial(r5, r6));
    L16:
        r1 = r3.multiply(r0).addOrSubtract(r2);
        if (r11.getDegree() < r10.getDegree()) goto L6;
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    L22:
        throw new ReedSolomonException("r_{i-1} was zero");
    L23:
        int r13 = r0.getCoefficient(0);
        if (r13 == 0) goto L28;
        int r9 = this.field.inverse(r13);
        return new GenericGFPoly[]{r0.multiply(r9), r10.multiply(r9)};
    L28:
        throw new ReedSolomonException("sigmaTilde(0) was zero");
    }

    private int[] findErrorLocations(GenericGFPoly r6) throws ReedSolomonException {
        int r0 = r6.getDegree();
        int r1 = 0;
        int r2 = 1;
        if (r0 == 1) goto L5;
        int[] r3 = new int[r0];
    L8:
        if (r2 >= this.field.getSize()) goto L14;
        if (r1 >= r0) goto L14;
        if (r6.evaluateAt(r2) != 0) goto L13;
        r3[r1] = this.field.inverse(r2);
        r1 = r1 + 1;
    L13:
        r2 = r2 + 1;
    L14:
        if (r1 != r0) goto L17;
        return r3;
    L17:
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    L5:
        return new int[]{r6.getCoefficient(1)};
    }

    private int[] findErrorMagnitudes(GenericGFPoly r10, int[] r11) {
        int r0 = r11.length;
        int[] r1 = new int[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L17;
        int r4 = this.field.inverse(r11[r3]);
        int r5 = 1;
        int r6 = 0;
    L5:
        if (r6 >= r0) goto L13;
        if (r3 == r6) goto L12;
        int r7 = this.field.multiply(r11[r6], r4);
        if ((r7 & 1) != 0) goto L10;
        int r8 = r7 | 1;
    L11:
        r5 = this.field.multiply(r5, r8);
        goto L12
    L10:
        r8 = r7 & (-2);
    L12:
        r6 = r6 + 1;
        goto L5
    L13:
        r1[r3] = this.field.multiply(r10.evaluateAt(r4), this.field.inverse(r5));
        if (this.field.getGeneratorBase() == 0) goto L16;
        r1[r3] = this.field.multiply(r1[r3], r4);
    L16:
        r3 = r3 + 1;
        goto L3
    L17:
        return r1;
    }
}
