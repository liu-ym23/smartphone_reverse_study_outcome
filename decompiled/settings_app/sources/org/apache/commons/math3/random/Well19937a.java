package org.apache.commons.math3.random;

/* JADX INFO: loaded from: classes6.dex */
public class Well19937a extends AbstractWell {
    private static final int K = 19937;
    private static final int M1 = 70;
    private static final int M2 = 179;
    private static final int M3 = 449;
    private static final long serialVersionUID = -7462102162223815419L;

    public Well19937a() {
        super(K, 70, 179, M3);
    }

    public Well19937a(int r7) {
        super(K, 70, 179, M3, r7);
    }

    public Well19937a(int[] r7) {
        super(K, 70, 179, M3, r7);
    }

    public Well19937a(long r8) {
        super(K, 70, 179, M3, r8);
    }

    @Override // org.apache.commons.math3.random.AbstractWell, org.apache.commons.math3.random.BitsStreamGenerator
    protected int next(int r11) {
        int r0 = this.iRm1[this.index];
        int r1 = this.iRm2[this.index];
        int r2 = this.v[this.index];
        int r3 = this.v[this.i1[this.index]];
        int r4 = this.v[this.i2[this.index]];
        int r5 = this.v[this.i3[this.index]];
        int r6 = (this.v[r0] & Integer.MIN_VALUE) ^ (this.v[r1] & Integer.MAX_VALUE);
        int r7 = (r2 ^ (r2 << 25)) ^ (r3 ^ (r3 >>> 27));
        int r8 = (r4 >>> 9) ^ ((r5 >>> 1) ^ r5);
        int r9 = r7 ^ r8;
        int r10 = (((r7 ^ (r7 << 9)) ^ r6) ^ (r8 ^ (r8 << 21))) ^ ((r9 >>> 21) ^ r9);
        this.v[this.index] = r9;
        this.v[r0] = r10;
        int[] r12 = this.v;
        r12[r1] = r12[r1] & Integer.MIN_VALUE;
        this.index = r0;
        return r10 >>> (32 - r11);
    }
}
