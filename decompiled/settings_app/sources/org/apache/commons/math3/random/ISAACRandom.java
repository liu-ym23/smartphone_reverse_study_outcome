package org.apache.commons.math3.random;

import java.io.Serializable;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class ISAACRandom extends BitsStreamGenerator implements Serializable {
    private static final int GLD_RATIO = -1640531527;
    private static final int H_SIZE = 128;
    private static final int MASK = 1020;
    private static final int SIZE = 256;
    private static final int SIZE_L = 8;
    private static final long serialVersionUID = 7288197941165002400L;
    private final int[] arr;
    private int count;
    private int isaacA;
    private int isaacB;
    private int isaacC;
    private int isaacI;
    private int isaacJ;
    private int isaacX;
    private final int[] mem;
    private final int[] rsl;

    public ISAACRandom() {
        this.rsl = new int[256];
        this.mem = new int[256];
        this.arr = new int[8];
        setSeed(System.currentTimeMillis() + ((long) System.identityHashCode(this)));
    }

    public ISAACRandom(long r3) {
        this.rsl = new int[256];
        this.mem = new int[256];
        this.arr = new int[8];
        setSeed(r3);
    }

    public ISAACRandom(int[] r3) {
        this.rsl = new int[256];
        this.mem = new int[256];
        this.arr = new int[8];
        setSeed(r3);
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int r3) {
        setSeed(new int[]{r3});
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(long r4) {
        setSeed(new int[]{(int) (r4 >>> 32), (int) (r4 & 4294967295L)});
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int[] r8) {
        if (r8 != null) goto L5;
        setSeed(System.currentTimeMillis() + ((long) System.identityHashCode(this)));
        return;
    L5:
        int r0 = r8.length;
        int[] r1 = this.rsl;
        int r2 = r1.length;
        System.arraycopy(r8, 0, r1, 0, FastMath.min(r0, r2));
        if (r0 >= r2) goto L10;
        int r9 = r0;
    L8:
        if (r9 >= r2) goto L10;
        int[] r3 = this.rsl;
        long r4 = r3[r9 - r0];
        r3[r9] = (int) ((((r4 ^ (r4 >> 30)) * 1812433253) + ((long) r9)) & 4294967295L);
        r9 = r9 + 1;
    L10:
        initState();
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator
    protected int next(int r4) {
        if (this.count >= 0) goto L5;
        isaac();
        this.count = 255;
    L5:
        int[] r0 = this.rsl;
        int r1 = this.count;
        this.count = r1 - 1;
        return r0[r1] >>> (32 - r4);
    }

    private void isaac() {
        this.isaacI = 0;
        this.isaacJ = 128;
        int r2 = this.isaacB;
        int r3 = this.isaacC + 1;
        this.isaacC = r3;
        this.isaacB = r2 + r3;
    L4:
        if (this.isaacI >= 128) goto L6;
        isaac2();
        goto L4
    L6:
        this.isaacJ = 0;
    L8:
        if (this.isaacJ >= 128) goto L10;
        isaac2();
        goto L8
    }

    private void isaac2() {
        int[] r0 = this.mem;
        this.isaacX = r0[this.isaacI];
        int r1 = this.isaacA;
        int r2 = r1 ^ (r1 << 13);
        int r3 = this.isaacJ;
        this.isaacJ = r3 + 1;
        this.isaacA = r2 + r0[r3];
        isaac3();
        int[] r4 = this.mem;
        this.isaacX = r4[this.isaacI];
        int r5 = this.isaacA;
        int r6 = r5 ^ (r5 >>> 6);
        int r7 = this.isaacJ;
        this.isaacJ = r7 + 1;
        this.isaacA = r6 + r4[r7];
        isaac3();
        int[] r8 = this.mem;
        this.isaacX = r8[this.isaacI];
        int r9 = this.isaacA;
        int r10 = r9 ^ (r9 << 2);
        int r11 = this.isaacJ;
        this.isaacJ = r11 + 1;
        this.isaacA = r10 + r8[r11];
        isaac3();
        int[] r12 = this.mem;
        this.isaacX = r12[this.isaacI];
        int r13 = this.isaacA;
        int r14 = r13 ^ (r13 >>> 16);
        int r15 = this.isaacJ;
        this.isaacJ = r15 + 1;
        this.isaacA = r14 + r12[r15];
        isaac3();
    }

    private void isaac3() {
        int[] r0 = this.mem;
        int r1 = this.isaacI;
        int r2 = this.isaacX;
        int r3 = (r0[(r2 & 1020) >> 2] + this.isaacA) + this.isaacB;
        r0[r1] = r3;
        int r4 = r0[((r3 >> 8) & 1020) >> 2] + r2;
        this.isaacB = r4;
        int[] r5 = this.rsl;
        this.isaacI = r1 + 1;
        r5[r1] = r4;
    }

    private void initState() {
        this.isaacA = 0;
        this.isaacB = 0;
        this.isaacC = 0;
        int r1 = 0;
    L3:
        int[] r2 = this.arr;
        if (r1 >= r2.length) goto L6;
        r2[r1] = GLD_RATIO;
        r1 = r1 + 1;
        goto L3
    L6:
        int r3 = 0;
    L8:
        if (r3 >= 4) goto L10;
        shuffle();
        r3 = r3 + 1;
        goto L8
    L10:
        int r4 = 0;
    L12:
        if (r4 >= 256) goto L14;
        int[] r5 = this.arr;
        int r10 = r5[0];
        int[] r11 = this.rsl;
        r5[0] = r10 + r11[r4];
        r5[1] = r5[1] + r11[r4 + 1];
        r5[2] = r5[2] + r11[r4 + 2];
        r5[3] = r5[3] + r11[r4 + 3];
        r5[4] = r5[4] + r11[r4 + 4];
        r5[5] = r5[5] + r11[r4 + 5];
        r5[6] = r5[6] + r11[r4 + 6];
        r5[7] = r5[7] + r11[r4 + 7];
        shuffle();
        setState(r4);
        r4 = r4 + 8;
        goto L12
    L14:
        int r6 = 0;
    L15:
        if (r6 >= 256) goto L17;
        int[] r12 = this.arr;
        int r13 = r12[0];
        int[] r14 = this.mem;
        r12[0] = r13 + r14[r6];
        r12[1] = r12[1] + r14[r6 + 1];
        r12[2] = r12[2] + r14[r6 + 2];
        r12[3] = r12[3] + r14[r6 + 3];
        r12[4] = r12[4] + r14[r6 + 4];
        r12[5] = r12[5] + r14[r6 + 5];
        r12[6] = r12[6] + r14[r6 + 6];
        r12[7] = r12[7] + r14[r6 + 7];
        shuffle();
        setState(r6);
        r6 = r6 + 8;
        goto L15
    L17:
        isaac();
        this.count = 255;
        clear();
    }

    private void shuffle() {
        int[] r13 = this.arr;
        int r1 = r13[0];
        int r3 = r13[1];
        int r2 = r1 ^ (r3 << 11);
        r13[0] = r2;
        int r5 = r13[3] + r2;
        r13[3] = r5;
        int r7 = r13[2];
        int r4 = r3 + r7;
        r13[1] = r4;
        int r6 = r4 ^ (r7 >>> 2);
        r13[1] = r6;
        int r9 = r13[4] + r6;
        r13[4] = r9;
        int r8 = r7 + r5;
        r13[2] = r8;
        int r10 = r8 ^ (r5 << 8);
        r13[2] = r10;
        int r11 = r13[5] + r10;
        r13[5] = r11;
        int r12 = r5 + r9;
        r13[3] = r12;
        int r14 = r12 ^ (r9 >>> 16);
        r13[3] = r14;
        int r15 = r13[6] + r14;
        r13[6] = r15;
        int r16 = r9 + r11;
        r13[4] = r16;
        int r17 = (r11 << 10) ^ r16;
        r13[4] = r17;
        int r18 = r13[7] + r17;
        r13[7] = r18;
        int r19 = r11 + r15;
        r13[5] = r19;
        int r20 = (r15 >>> 4) ^ r19;
        r13[5] = r20;
        int r21 = r2 + r20;
        r13[0] = r21;
        int r110 = r15 + r18;
        r13[6] = r110;
        int r22 = (r18 << 8) ^ r110;
        r13[6] = r22;
        int r23 = r6 + r22;
        r13[1] = r23;
        int r24 = r18 + r21;
        r13[7] = r24;
        int r25 = (r21 >>> 9) ^ r24;
        r13[7] = r25;
        r13[2] = r10 + r25;
        r13[0] = r21 + r23;
    }

    private void setState(int r4) {
        int[] r0 = this.mem;
        int[] r3 = this.arr;
        r0[r4] = r3[0];
        r0[r4 + 1] = r3[1];
        r0[r4 + 2] = r3[2];
        r0[r4 + 3] = r3[3];
        r0[r4 + 4] = r3[4];
        r0[r4 + 5] = r3[5];
        r0[r4 + 6] = r3[6];
        r0[r4 + 7] = r3[7];
    }
}
