package org.apache.commons.math3.random;

/* JADX INFO: loaded from: classes6.dex */
public class Well512a extends AbstractWell {
    private static final int K = 512;
    private static final int M1 = 13;
    private static final int M2 = 9;
    private static final int M3 = 5;
    private static final long serialVersionUID = -6104179812103820574L;

    public Well512a() {
        super(512, 13, 9, 5);
    }

    public Well512a(int r7) {
        super(512, 13, 9, 5, r7);
    }

    public Well512a(int[] r7) {
        super(512, 13, 9, 5, r7);
    }

    public Well512a(long r8) {
        super(512, 13, 9, 5, r8);
    }

    @Override // org.apache.commons.math3.random.AbstractWell, org.apache.commons.math3.random.BitsStreamGenerator
    protected int next(int r7) {
        int r0 = this.iRm1[this.index];
        int r1 = this.v[this.index];
        int r2 = this.v[this.i1[this.index]];
        int r3 = this.v[this.i2[this.index]];
        int r4 = this.v[r0];
        int r5 = (r1 ^ (r1 << 16)) ^ (r2 ^ (r2 << 15));
        int r6 = (r3 >>> 11) ^ r3;
        int r8 = r5 ^ r6;
        int r9 = r4 ^ (r4 << 2);
        int r10 = (((r5 ^ (r5 << 18)) ^ r9) ^ (r6 << 28)) ^ (((r8 << 5) & (-633066204)) ^ r8);
        this.v[this.index] = r8;
        this.v[r0] = r10;
        this.index = r0;
        return r10 >>> (32 - r7);
    }
}
