package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;

/* JADX INFO: loaded from: classes4.dex */
public final class ErrorCorrection {
    private final ModulusGF field;

    public ErrorCorrection() {
        this.field = ModulusGF.PDF417_GF;
    }

    public int decode(int[] r11, int r12, int[] r13) throws ChecksumException {
        ModulusPoly r0 = new ModulusPoly(this.field, r11);
        int[] r1 = new int[r12];
        int r2 = 0;
        int r3 = r12;
        boolean r4 = false;
    L4:
        if (r3 <= 0) goto L9;
        int r6 = r0.evaluateAt(this.field.exp(r3));
        r1[r12 - r3] = r6;
        if (r6 == 0) goto L8;
        r4 = true;
    L8:
        r3 = r3 - 1;
        goto L4
    L9:
        if (r4 == true) goto L11;
        return 0;
    L11:
        ModulusPoly r5 = this.field.getOne();
        if (r13 == null) goto L16;
        int r7 = r13.length;
        int r8 = 0;
    L14:
        if (r8 >= r7) goto L16;
        int r9 = this.field.exp((r11.length - 1) - r13[r8]);
        ModulusGF r10 = this.field;
        r5 = r5.multiply(new ModulusPoly(r10, new int[]{r10.subtract(0, r9), 1}));
        r8 = r8 + 1;
    L16:
        ModulusPoly[] r14 = runEuclideanAlgorithm(this.field.buildMonomial(r12, 1), new ModulusPoly(this.field, r1), r12);
        ModulusPoly r15 = r14[0];
        ModulusPoly r16 = r14[1];
        int[] r17 = findErrorLocations(r15);
        int[] r18 = findErrorMagnitudes(r16, r15, r17);
    L18:
        if (r2 >= r17.length) goto L25;
        int r19 = (r11.length - 1) - this.field.log(r17[r2]);
        if (r19 < 0) goto L23;
        r11[r19] = this.field.subtract(r11[r19], r18[r2]);
        r2 = r2 + 1;
        goto L18
    L23:
        throw ChecksumException.getChecksumInstance();
    L25:
        return r17.length;
    }

    private ModulusPoly[] runEuclideanAlgorithm(ModulusPoly r10, ModulusPoly r11, int r12) throws ChecksumException {
        if (r10.getDegree() >= r11.getDegree()) goto L5;
        r11 = r10;
        r10 = r11;
    L5:
        ModulusPoly r0 = this.field.getZero();
        ModulusPoly r1 = this.field.getOne();
    L6:
        ModulusPoly r7 = r11;
        r11 = r10;
        r10 = r7;
        ModulusPoly r8 = r1;
        ModulusPoly r2 = r0;
        r0 = r8;
        if (r10.getDegree() < (r12 / 2)) goto L19;
        if (r10.isZero() == true) goto L18;
        ModulusPoly r3 = this.field.getZero();
        int r4 = this.field.inverse(r10.getCoefficient(r10.getDegree()));
    L12:
        if (r11.getDegree() < r10.getDegree()) goto L16;
        if (r11.isZero() == true) goto L16;
        int r5 = r11.getDegree() - r10.getDegree();
        int r6 = this.field.multiply(r11.getCoefficient(r11.getDegree()), r4);
        r3 = r3.add(this.field.buildMonomial(r5, r6));
        r11 = r11.subtract(r10.multiplyByMonomial(r5, r6));
    L16:
        r1 = r3.multiply(r0).subtract(r2).negative();
        goto L6
    L18:
        throw ChecksumException.getChecksumInstance();
    L19:
        int r13 = r0.getCoefficient(0);
        if (r13 == 0) goto L24;
        int r9 = this.field.inverse(r13);
        return new ModulusPoly[]{r0.multiply(r9), r10.multiply(r9)};
    L24:
        throw ChecksumException.getChecksumInstance();
    }

    private int[] findErrorLocations(ModulusPoly r6) throws ChecksumException {
        int r0 = r6.getDegree();
        int[] r1 = new int[r0];
        int r2 = 0;
        int r3 = 1;
    L4:
        if (r3 >= this.field.getSize()) goto L10;
        if (r2 >= r0) goto L10;
        if (r6.evaluateAt(r3) != 0) goto L9;
        r1[r2] = this.field.inverse(r3);
        r2 = r2 + 1;
    L9:
        r3 = r3 + 1;
    L10:
        if (r2 != r0) goto L13;
        return r1;
    L13:
        throw ChecksumException.getChecksumInstance();
    }

    private int[] findErrorMagnitudes(ModulusPoly r8, ModulusPoly r9, int[] r10) {
        int r0 = r9.getDegree();
        int[] r1 = new int[r0];
        int r2 = 1;
    L3:
        if (r2 > r0) goto L5;
        r1[r0 - r2] = this.field.multiply(r2, r9.getCoefficient(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        ModulusPoly r11 = new ModulusPoly(this.field, r1);
        int r3 = r10.length;
        int[] r4 = new int[r3];
        int r5 = 0;
    L6:
        if (r5 >= r3) goto L8;
        int r6 = this.field.inverse(r10[r5]);
        r4[r5] = this.field.multiply(this.field.subtract(0, r8.evaluateAt(r6)), this.field.inverse(r11.evaluateAt(r6)));
        r5 = r5 + 1;
        goto L6
    L8:
        return r4;
    }
}
