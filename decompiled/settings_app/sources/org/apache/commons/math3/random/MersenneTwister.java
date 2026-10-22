package org.apache.commons.math3.random;

import android.icu.lang.UCharacter;
import cz.msebera.android.httpclient.impl.client.cache.CacheValidityPolicy;
import java.io.Serializable;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class MersenneTwister extends BitsStreamGenerator implements Serializable {
    private static final int M = 397;
    private static final int[] MAG01 = null;
    private static final int N = 624;
    private static final long serialVersionUID = 8661194735290153518L;
    private int[] mt;
    private int mti;

    static {
        MAG01 = new int[]{0, -1727483681};
    }

    public MersenneTwister() {
        this.mt = new int[N];
        setSeed(System.currentTimeMillis() + ((long) System.identityHashCode(this)));
    }

    public MersenneTwister(int r2) {
        this.mt = new int[N];
        setSeed(r2);
    }

    public MersenneTwister(int[] r2) {
        this.mt = new int[N];
        setSeed(r2);
    }

    public MersenneTwister(long r2) {
        this.mt = new int[N];
        setSeed(r2);
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int r5) {
        long r0 = r5;
        this.mt[0] = (int) r0;
        int r6 = 1;
    L3:
        this.mti = r6;
        int r7 = this.mti;
        if (r7 >= N) goto L6;
        r0 = (((r0 ^ (r0 >> 30)) * 1812433253) + ((long) r7)) & 4294967295L;
        this.mt[r7] = (int) r0;
        r6 = r7 + 1;
        goto L3
    L6:
        clear();
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int[] r23) {
        if (r23 != null) goto L6;
        setSeed(System.currentTimeMillis() + ((long) System.identityHashCode(this)));
        return;
    L6:
        setSeed(19650218);
        int r2 = FastMath.max(N, r23.length);
        int r6 = 1;
        int r7 = 0;
    L8:
        if (r2 == 0) goto L24;
        int[] r12 = this.mt;
        int r13 = r12[r6];
        long r14 = ((long) r13) & 2147483647L;
        if (r13 >= 0) goto L12;
        long r20 = CacheValidityPolicy.MAX_AGE;
    L13:
        long r15 = r14 | r20;
        int r16 = r12[r6 - 1];
        long r3 = ((long) r16) & 2147483647L;
        if (r16 >= 0) goto L16;
        long r18 = CacheValidityPolicy.MAX_AGE;
    L17:
        long r4 = r3 | r18;
        r12[r6] = (int) ((((((r4 ^ (r4 >> 30)) * 1664525) ^ r15) + ((long) r23[r7])) + ((long) r7)) & 4294967295L);
        r6 = r6 + 1;
        r7 = r7 + 1;
        if (r6 < N) goto L21;
        r12[0] = r12[623(0x26f, float:8.73E-43)];
        r6 = 1;
    L21:
        if (r7 < r23.length) goto L23;
        r7 = 0;
    L23:
        r2 = r2 - 1;
        goto L8
    L16:
        r18 = 0;
        goto L17
    L12:
        r20 = 0;
        goto L13
    L24:
        int r1 = 623;
    L25:
        if (r1 == 0) goto L39;
        int[] r5 = this.mt;
        int r8 = r5[r6];
        long r17 = ((long) r8) & 2147483647L;
        if (r8 >= 0) goto L29;
        long r9 = CacheValidityPolicy.MAX_AGE;
    L30:
        long r10 = r9 | r17;
        int r11 = r5[r6 - 1];
        long r19 = ((long) r11) & 2147483647L;
        if (r11 >= 0) goto L33;
        long r110 = CacheValidityPolicy.MAX_AGE;
    L34:
        long r111 = r19 | r110;
        r5[r6] = (int) (((r10 ^ ((r111 ^ (r111 >> 30)) * 1566083941)) - ((long) r6)) & 4294967295L);
        r6 = r6 + 1;
        if (r6 < N) goto L38;
        r5[0] = r5[623(0x26f, float:8.73E-43)];
        r6 = 1;
    L38:
        r1 = r1 - 1;
        goto L25
    L33:
        r110 = 0;
        goto L34
    L29:
        r9 = 0;
        goto L30
    L39:
        this.mt[0] = Integer.MIN_VALUE;
        clear();
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(long r4) {
        setSeed(new int[]{(int) (r4 >>> 32), (int) (r4 & 4294967295L)});
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator
    protected int next(int r11) {
        if (this.mti < N) goto L12;
        int r0 = this.mt[0];
        int r2 = 0;
    L5:
        int r3 = UCharacter.UnicodeBlock.GEOMETRIC_SHAPES_EXTENDED_ID;
        if (r2 >= 227) goto L9;
        int[] r4 = this.mt;
        int r6 = r2 + 1;
        int r7 = r4[r6];
        int r1 = (r0 & Integer.MIN_VALUE) | (Integer.MAX_VALUE & r7);
        r4[r2] = MAG01[r1 & 1] ^ (r4[r2 + M] ^ (r1 >>> 1));
        r2 = r6;
        r0 = r7;
    L9:
        if (r3 >= 623) goto L11;
        int[] r5 = this.mt;
        int r8 = r3 + 1;
        int r9 = r5[r8];
        int r10 = (r0 & Integer.MIN_VALUE) | (r9 & Integer.MAX_VALUE);
        r5[r3] = MAG01[r10 & 1] ^ (r5[r3 - 227] ^ (r10 >>> 1));
        r3 = r8;
        r0 = r9;
        goto L9
    L11:
        int[] r12 = this.mt;
        int r13 = (r0 & Integer.MIN_VALUE) | (Integer.MAX_VALUE & r12[0]);
        r12[623(0x26f, float:8.73E-43)] = MAG01[r13 & 1] ^ (r12[396(0x18c, float:5.55E-43)] ^ (r13 >>> 1));
        this.mti = 0;
    L12:
        int[] r14 = this.mt;
        int r15 = this.mti;
        this.mti = r15 + 1;
        int r16 = r14[r15];
        int r17 = r16 ^ (r16 >>> 11);
        int r18 = r17 ^ ((r17 << 7) & (-1658038656));
        int r19 = r18 ^ ((r18 << 15) & (-272236544));
        return (r19 ^ (r19 >>> 18)) >>> (32 - r11);
    }
}
