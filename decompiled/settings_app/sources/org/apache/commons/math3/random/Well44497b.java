package org.apache.commons.math3.random;

/* JADX INFO: loaded from: classes6.dex */
public class Well44497b extends AbstractWell {
    private static final int K = 44497;
    private static final int M1 = 23;
    private static final int M2 = 481;
    private static final int M3 = 229;
    private static final long serialVersionUID = 4032007538246675492L;

    public Well44497b() {
        super(K, 23, M2, 229);
    }

    public Well44497b(int r7) {
        super(K, 23, M2, 229, r7);
    }

    public Well44497b(int[] r7) {
        super(K, 23, M2, 229, r7);
    }

    public Well44497b(long r8) {
        super(K, 23, M2, 229, r8);
    }

    @Override // org.apache.commons.math3.random.AbstractWell, org.apache.commons.math3.random.BitsStreamGenerator
    protected int next(int r9) {
        int r0 = this.iRm1[this.index];
        int r1 = this.iRm2[this.index];
        int r2 = this.v[this.index];
        int r3 = this.v[this.i1[this.index]];
        int r4 = this.v[this.i2[this.index]];
        int r5 = this.v[this.i3[this.index]];
        int r6 = (this.v[r0] & (-32768)) ^ (this.v[r1] & 32767);
        int r7 = (r2 ^ (r2 << 24)) ^ (r3 ^ (r3 >>> 30));
        int r8 = ((r4 << 10) ^ r4) ^ (r5 << 26);
        int r10 = r7 ^ r8;
        int r11 = ((r8 << 9) ^ (r8 >>> 23)) & (-67108865);
        if ((r8 & 131072) == 0) goto L5;
        r11 = r11 ^ (-1221985044);
    L5:
        int r12 = (((r7 ^ (r7 >>> 20)) ^ r6) ^ r11) ^ r10;
        this.v[this.index] = r10;
        this.v[r0] = r12;
        int[] r13 = this.v;
        r13[r1] = r13[r1] & (-32768);
        this.index = r0;
        int r14 = ((r12 << 7) & (-1814227968)) ^ r12;
        return (r14 ^ ((r14 << 15) & (-99516416))) >>> (32 - r9);
    }
}
