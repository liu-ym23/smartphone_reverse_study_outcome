package org.apache.commons.math3.linear;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class SingularValueDecomposition {
    private static final double EPS = 2.220446049250313E-16d;
    private static final double TINY = 1.6033346880071782E-291d;
    private RealMatrix cachedS;
    private final RealMatrix cachedU;
    private RealMatrix cachedUt;
    private final RealMatrix cachedV;
    private RealMatrix cachedVt;
    private final int m;
    private final int n;
    private final double[] singularValues;
    private final double tol;
    private final boolean transposed;

    private static class Solver implements DecompositionSolver {
        private boolean nonSingular;
        private final RealMatrix pseudoInverse;

        /* synthetic */ Solver(double[] r1, RealMatrix r2, RealMatrix r3, boolean r4, double r5, AnonymousClass1 r7) {
            this(r1, r2, r3, r4, r5);
        }

        private Solver(double[] r9, RealMatrix r10, RealMatrix r11, boolean r12, double r13) {
            double[][] r14 = r10.getData();
            int r1 = 0;
        L4:
            if (r1 >= r9.length) goto L14;
            double r2 = r9[r1];
            if (r2 <= r13) goto L8;
            double r4 = 1.0d / r2;
        L9:
            double[] r3 = r14[r1];
            int r5 = 0;
        L11:
            if (r5 >= r3.length) goto L13;
            r3[r5] = r3[r5] * r4;
            r5 = r5 + 1;
            goto L11
        L13:
            r1 = r1 + 1;
            goto L4
        L8:
            r4 = 0.0d;
            goto L9
        L14:
            this.pseudoInverse = r11.multiply(new Array2DRowRealMatrix(r14, false));
            this.nonSingular = r12;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealVector solve(RealVector r1) {
            return this.pseudoInverse.operate(r1);
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix r1) {
            return this.pseudoInverse.multiply(r1);
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public boolean isNonSingular() {
            return this.nonSingular;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix getInverse() {
            return this.pseudoInverse;
        }
    }

    static /* synthetic */ double[] access$000(SingularValueDecomposition r0) {
        return r0.singularValues;
    }

    public SingularValueDecomposition(RealMatrix r35) {
        if (r35.getRowDimension() >= r35.getColumnDimension()) goto L5;
        this.transposed = true;
        double[][] r1 = r35.transpose().getData();
        this.m = r35.getColumnDimension();
        this.n = r35.getRowDimension();
    L6:
        int r2 = this.n;
        this.singularValues = new double[r2];
        double[][] r3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.m, r2});
        int r5 = this.n;
        double[][] r6 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r5, r5});
        int r7 = this.n;
        double[] r8 = new double[r7];
        int r9 = this.m;
        double[] r10 = new double[r9];
        int r11 = FastMath.min(r9 - 1, r7);
        int r12 = FastMath.max(0, this.n - 2);
        int r13 = 0;
    L7:
        double r15 = 0.0d;
        if (r13 >= FastMath.max(r11, r12)) goto L92;
        if (r13 >= r11) goto L25;
        this.singularValues[r13] = 0.0d;
        int r14 = r13;
    L12:
        if (r14 >= this.m) goto L14;
        double[] r4 = this.singularValues;
        r4[r13] = FastMath.hypot(r4[r13], r1[r14][r13]);
        r14 = r14 + 1;
        r6 = r6;
        r11 = r11;
        goto L12
    L14:
        double[][] r36 = r6;
        int r20 = r11;
        double[] r16 = this.singularValues;
        double r17 = r16[r13];
        if (r17 != 0.0d) goto L17;
    L24:
        double[] r18 = this.singularValues;
        r18[r13] = -r18[r13];
    L26:
        int r19 = r13 + 1;
        int r21 = r19;
    L28:
        if (r21 >= this.n) goto L42;
        int r22 = r20;
        if (r13 >= r22) goto L41;
        if (this.singularValues[r13] == 0.0d) goto L41;
        int r23 = r13;
        double r110 = 0.0d;
    L35:
        if (r23 >= this.m) goto L37;
        double[] r24 = r1[r23];
        r110 = r110 + (r24[r13] * r24[r21]);
        r23 = r23 + 1;
        goto L35
    L37:
        double r25 = (-r110) / r1[r13][r13];
        int r111 = r13;
    L39:
        if (r111 >= this.m) goto L41;
        double[] r112 = r1[r111];
        r112[r21] = r112[r21] + (r112[r13] * r25);
        r111 = r111 + 1;
    L41:
        r8[r21] = r1[r13][r21];
        r21 = r21 + 1;
        r20 = r22;
        goto L28
    L42:
        int r26 = r20;
        if (r13 >= r26) goto L48;
        int r27 = r13;
    L46:
        if (r27 >= this.m) goto L48;
        r3[r27][r13] = r1[r27][r13];
        r27 = r27 + 1;
    L48:
        if (r13 >= r12) goto L91;
        r8[r13] = 0.0d;
        int r28 = r19;
    L51:
        if (r28 >= this.n) goto L53;
        r8[r13] = FastMath.hypot(r8[r13], r8[r28]);
        r28 = r28 + 1;
        goto L51
    L53:
        double r29 = r8[r13];
        if (r29 != 0.0d) goto L56;
    L63:
        double r30 = -r8[r13];
        r8[r13] = r30;
        if (r19 < this.m) goto L66;
    L87:
        int r31 = r19;
    L89:
        if (r31 >= this.n) goto L91;
        r36[r31][r13] = r8[r31];
        r31 = r31 + 1;
        goto L89
    L66:
        if (r30 == 0.0d) goto L87;
        int r32 = r19;
    L69:
        if (r32 >= this.m) goto L71;
        r10[r32] = 0.0d;
        r32 = r32 + 1;
        goto L69
    L71:
        int r33 = r19;
    L73:
        if (r33 >= this.n) goto L79;
        int r34 = r19;
    L76:
        if (r34 >= this.m) goto L78;
        r10[r34] = r10[r34] + (r8[r33] * r1[r34][r33]);
        r34 = r34 + 1;
        goto L76
    L78:
        r33 = r33 + 1;
        goto L73
    L79:
        int r37 = r19;
    L81:
        if (r37 >= this.n) goto L87;
        double r38 = (-r8[r37]) / r8[r19];
        int r113 = r19;
    L84:
        if (r113 >= this.m) goto L86;
        double[] r114 = r1[r113];
        r114[r37] = r114[r37] + (r10[r113] * r38);
        r113 = r113 + 1;
        goto L84
    L86:
        r37 = r37 + 1;
        goto L81
    L56:
        if (r8[r19] >= 0.0d) goto L58;
        r8[r13] = -r29;
    L58:
        int r39 = r19;
    L60:
        if (r39 >= this.n) goto L62;
        r8[r39] = r8[r39] / r8[r13];
        r39 = r39 + 1;
        goto L60
    L62:
        r8[r19] = r8[r19] + 1.0d;
    L91:
        r13 = r19;
        r11 = r26;
        r6 = r36;
        goto L7
    L17:
        if (r1[r13][r13] >= 0.0d) goto L19;
        r16[r13] = -r17;
    L19:
        int r40 = r13;
    L21:
        if (r40 >= this.m) goto L23;
        double[] r41 = r1[r40];
        r41[r13] = r41[r13] / this.singularValues[r13];
        r40 = r40 + 1;
        goto L21
    L23:
        double[] r42 = r1[r13];
        r42[r13] = r42[r13] + 1.0d;
        goto L24
    L25:
        r36 = r6;
        r20 = r11;
        goto L26
    L92:
        double[][] r310 = r6;
        int r43 = r11;
        int r44 = this.n;
        if (r43 >= r44) goto L96;
        this.singularValues[r43] = r1[r43][r43];
    L96:
        if (this.m >= r44) goto L99;
        this.singularValues[r44 - 1] = 0.0d;
    L99:
        if ((r12 + 1) >= r44) goto L101;
        r8[r12] = r1[r12][r44 - 1];
    L101:
        int r45 = r44 - 1;
        r8[r45] = 0.0d;
        int r46 = r43;
    L103:
        if (r46 >= this.n) goto L109;
        int r47 = 0;
    L106:
        if (r47 >= this.m) goto L108;
        r3[r47][r46] = 0.0d;
        r47 = r47 + 1;
        goto L106
    L108:
        r3[r46][r46] = 1.0d;
        r46 = r46 + 1;
        goto L103
    L109:
        int r48 = r43 - 1;
    L110:
        if (r48 < 0) goto L139;
        if (this.singularValues[r48] == 0.0d) goto L133;
        int r49 = r48 + 1;
    L115:
        if (r49 >= this.n) goto L125;
        int r50 = r48;
        double r115 = 0.0d;
    L118:
        if (r50 >= this.m) goto L120;
        double[] r51 = r3[r50];
        r115 = r115 + (r51[r48] * r51[r49]);
        r50 = r50 + 1;
        goto L118
    L120:
        double r52 = (-r115) / r3[r48][r48];
        int r116 = r48;
    L122:
        if (r116 >= this.m) goto L124;
        double[] r117 = r3[r116];
        r117[r49] = r117[r49] + (r117[r48] * r52);
        r116 = r116 + 1;
        goto L122
    L124:
        r49 = r49 + 1;
        goto L115
    L125:
        int r53 = r48;
    L127:
        if (r53 >= this.m) goto L129;
        double[] r54 = r3[r53];
        r54[r48] = -r54[r48];
        r53 = r53 + 1;
        goto L127
    L129:
        double[] r55 = r3[r48];
        r55[r48] = r55[r48] + 1.0d;
        int r56 = 0;
    L131:
        if (r56 >= (r48 - 1)) goto L138;
        r3[r56][r48] = 0.0d;
        r56 = r56 + 1;
    L138:
        r48 = r48 - 1;
        goto L110
    L133:
        int r57 = 0;
    L135:
        if (r57 >= this.m) goto L137;
        r3[r57][r48] = 0.0d;
        r57 = r57 + 1;
        goto L135
    L137:
        r3[r48][r48] = 1.0d;
        goto L138
    L139:
        int r58 = this.n - 1;
    L140:
        if (r58 < 0) goto L162;
        if (r58 < r12) goto L143;
    L156:
        int r59 = 0;
    L158:
        if (r59 >= this.n) goto L160;
        r310[r59][r58] = 0.0d;
        r59 = r59 + 1;
        goto L158
    L160:
        r310[r58][r58] = 1.0d;
        r58 = r58 - 1;
        goto L140
    L143:
        if (r8[r58] == 0.0d) goto L156;
        int r60 = r58 + 1;
        int r61 = r60;
    L146:
        if (r61 >= this.n) goto L156;
        int r62 = r60;
        double r118 = 0.0d;
    L149:
        if (r62 >= this.n) goto L151;
        double[] r119 = r310[r62];
        r118 = r118 + (r119[r58] * r119[r61]);
        r62 = r62 + 1;
        goto L149
    L151:
        double r120 = (-r118) / r310[r60][r58];
        int r63 = r60;
    L153:
        if (r63 >= this.n) goto L155;
        double[] r121 = r310[r63];
        r121[r61] = r121[r61] + (r121[r58] * r120);
        r63 = r63 + 1;
        goto L153
    L155:
        r61 = r61 + 1;
    L162:
        if (r44 <= 0) goto L272;
        int r64 = r44 - 2;
        int r65 = r64;
    L165:
        if (r65 < 0) goto L171;
        if (FastMath.abs(r8[r65]) <= (((FastMath.abs(this.singularValues[r65]) + FastMath.abs(this.singularValues[r65 + 1])) * EPS) + TINY)) goto L168;
        r65 = r65 - 1;
        goto L165
    L168:
        r8[r65] = r15;
    L171:
        if (r65 != r64) goto L174;
        char r66 = 4;
    L194:
        int r67 = r65 + 1;
        if (r66 != 1) goto L197;
        int r210 = r45;
        double[][] r211 = r3;
        int r68 = r44;
        double r69 = r8[r64];
        r8[r64] = 0.0d;
    L261:
        if (r64 < r67) goto L270;
        double r122 = FastMath.hypot(this.singularValues[r64], r69);
        double[] r70 = this.singularValues;
        double r123 = r70[r64] / r122;
        double r71 = r69 / r122;
        r70[r64] = r122;
        if (r64 == r67) goto L265;
        int r72 = r64 - 1;
        double r124 = r8[r72];
        r69 = (-r71) * r124;
        r8[r72] = r124 * r123;
    L265:
        int r73 = 0;
    L267:
        if (r73 >= this.n) goto L269;
        double[] r125 = r310[r73];
        double r126 = r125[r64];
        int r127 = r68 - 1;
        double r212 = r125[r127];
        r125[r127] = ((-r71) * r126) + (r212 * r123);
        r125[r64] = (r123 * r126) + (r71 * r212);
        r73 = r73 + 1;
        r69 = r69;
        goto L267
    L269:
        r64 = r64 - 1;
    L270:
        r44 = r68;
    L271:
        r3 = r211;
        r45 = r210;
        r15 = 0.0d;
        goto L162
    L197:
        if (r66 == 2) goto L253;
        if (r66 == 3) goto L226;
        double[] r74 = this.singularValues;
        double r75 = r74[r67];
        if (r75 > r15) goto L208;
        if (r75 >= r15) goto L204;
        double r76 = -r75;
    L205:
        r74[r67] = r76;
        int r77 = 0;
    L206:
        if (r77 > r45) goto L208;
        double[] r78 = r310[r77];
        r78[r67] = -r78[r67];
        r77 = r77 + 1;
        goto L206
    L204:
        r76 = r15;
    L208:
        if (r67 >= r45) goto L225;
        double[] r79 = this.singularValues;
        double r80 = r79[r67];
        int r128 = r67 + 1;
        double r129 = r79[r128];
        if (r80 >= r129) goto L225;
        r79[r67] = r129;
        r79[r128] = r80;
        if (r67 >= (this.n - 1)) goto L219;
        int r81 = 0;
    L216:
        if (r81 >= this.n) goto L219;
        double[] r82 = r310[r81];
        double r130 = r82[r128];
        r82[r128] = r82[r67];
        r82[r67] = r130;
        r81 = r81 + 1;
    L219:
        if (r67 >= (this.m - 1)) goto L224;
        int r83 = 0;
    L222:
        if (r83 >= this.m) goto L224;
        double[] r84 = r3[r83];
        double r131 = r84[r128];
        r84[r128] = r84[r67];
        r84[r67] = r131;
        r83 = r83 + 1;
    L224:
        r67 = r128;
    L225:
        r44 = r44 - 1;
        r210 = r45;
        r211 = r3;
        goto L271
    L226:
        int r85 = r44 - 1;
        double r132 = FastMath.max(FastMath.max(FastMath.max(FastMath.max(FastMath.abs(this.singularValues[r85]), FastMath.abs(this.singularValues[r64])), FastMath.abs(r8[r64])), FastMath.abs(this.singularValues[r67])), FastMath.abs(r8[r67]));
        double[] r86 = this.singularValues;
        double r133 = r86[r85] / r132;
        double r134 = r86[r64] / r132;
        double r213 = r8[r64] / r132;
        double r214 = r86[r67] / r132;
        double r215 = r8[r67] / r132;
        double r135 = (((r134 + r133) * (r134 - r133)) + (r213 * r213)) / 2.0d;
        double r216 = r213 * r133;
        double r217 = r216 * r216;
        if (r135 == r15) goto L229;
    L232:
        double r87 = FastMath.sqrt((r135 * r135) + r217);
        if (r135 >= r15) goto L235;
        r87 = -r87;
    L235:
        double r218 = r217 / (r135 + r87);
    L236:
        double r88 = ((r214 + r133) * (r214 - r133)) + r218;
        int r136 = r67;
        double r137 = r214 * r215;
    L237:
        if (r136 >= r85) goto L252;
        double r138 = FastMath.hypot(r88, r137);
        double r89 = r88 / r138;
        double r139 = r137 / r138;
        if (r136 == r67) goto L241;
        r8[r136 - 1] = r138;
    L241:
        double[] r140 = this.singularValues;
        double r141 = r140[r136];
        double r219 = r8[r136];
        int r142 = r44;
        double r143 = (r89 * r141) + (r139 * r219);
        r8[r136] = (r219 * r89) - (r141 * r139);
        int r144 = r136 + 1;
        double r145 = r140[r144];
        int r220 = r85;
        int r221 = r64;
        double r90 = r139 * r145;
        r140[r144] = r145 * r89;
        int r146 = 0;
    L243:
        if (r146 >= this.n) goto L245;
        double[] r91 = r310[r146];
        double r222 = r91[r136];
        double r223 = r91[r144];
        r91[r144] = ((-r139) * r222) + (r223 * r89);
        r91[r136] = (r89 * r222) + (r139 * r223);
        r146 = r146 + 1;
        r3 = r3;
        r45 = r45;
        goto L243
    L245:
        int r224 = r45;
        double[][] r225 = r3;
        double r92 = FastMath.hypot(r143, r90);
        double r147 = r143 / r92;
        double r93 = r90 / r92;
        double[] r94 = this.singularValues;
        r94[r136] = r92;
        double r95 = r8[r136];
        double r226 = r94[r144];
        double r96 = (r147 * r95) + (r93 * r226);
        double r97 = -r93;
        r94[r144] = (r95 * r97) + (r226 * r147);
        double r98 = r8[r144];
        double r99 = r93 * r98;
        r8[r144] = r98 * r147;
        if (r136 >= (this.m - 1)) goto L251;
        int r100 = 0;
    L249:
        if (r100 >= this.m) goto L251;
        double[] r148 = r225[r100];
        double r227 = r148[r136];
        double r311 = r148[r144];
        r148[r144] = (r227 * r97) + (r311 * r147);
        r148[r136] = (r147 * r227) + (r93 * r311);
        r100 = r100 + 1;
    L251:
        r137 = r99;
        r44 = r142;
        r136 = r144;
        r3 = r225;
        r64 = r221;
        r85 = r220;
        r45 = r224;
        r88 = r96;
        goto L237
    L252:
        r210 = r45;
        r211 = r3;
        r8[r64] = r88;
        r68 = r44;
        goto L270
    L229:
        if (r217 != r15) goto L232;
        r218 = r15;
        goto L236
    L253:
        r210 = r45;
        r211 = r3;
        int r149 = r44;
        int r101 = r67 - 1;
        double r102 = r8[r101];
        r8[r101] = 0.0d;
        r68 = r149;
    L254:
        if (r67 >= r68) goto L270;
        double r103 = FastMath.hypot(this.singularValues[r67], r102);
        double[] r104 = this.singularValues;
        double r150 = r104[r67] / r103;
        double r105 = r102 / r103;
        r104[r67] = r103;
        double r106 = -r105;
        double r151 = r8[r67];
        double r152 = r106 * r151;
        r8[r67] = r151 * r150;
        int r107 = 0;
    L257:
        if (r107 >= this.m) goto L259;
        double[] r153 = r211[r107];
        double r154 = r153[r67];
        double r228 = r153[r101];
        r153[r101] = (r154 * r106) + (r228 * r150);
        r153[r67] = (r150 * r154) + (r105 * r228);
        r107 = r107 + 1;
        goto L257
    L259:
        r67 = r67 + 1;
        r102 = r152;
        goto L254
    L174:
        int r155 = r44 - 1;
        int r156 = r155;
    L175:
        if (r156 < r65) goto L189;
        if (r156 == r65) goto L189;
        if (r156 == r44) goto L180;
        double r229 = FastMath.abs(r8[r156]);
    L182:
        if (r156 == (r65 + 1)) goto L184;
        double r230 = FastMath.abs(r8[r156 - 1]);
    L186:
        if (FastMath.abs(this.singularValues[r156]) <= (((r229 + r230) * EPS) + TINY)) goto L187;
        r156 = r156 - 1;
        goto L175
    L187:
        this.singularValues[r156] = r15;
        goto L189
    L184:
        r230 = r15;
        goto L186
    L180:
        r229 = r15;
    L189:
        if (r156 != r65) goto L191;
        r66 = 3;
        goto L194
    L191:
        if (r156 != r155) goto L193;
        r66 = 1;
        goto L194
    L193:
        r65 = r156;
        r66 = 2;
        goto L194
    L272:
        double[][] r231 = r3;
        this.tol = FastMath.max((((double) this.m) * this.singularValues[0]) * EPS, FastMath.sqrt(Precision.SAFE_MIN));
        if (this.transposed == true) goto L275;
        this.cachedU = MatrixUtils.createRealMatrix(r231);
        this.cachedV = MatrixUtils.createRealMatrix(r310);
        return;
    L275:
        this.cachedU = MatrixUtils.createRealMatrix(r310);
        this.cachedV = MatrixUtils.createRealMatrix(r231);
        return;
    L5:
        this.transposed = false;
        r1 = r35.getData();
        this.m = r35.getRowDimension();
        this.n = r35.getColumnDimension();
        goto L6
    }

    public RealMatrix getU() {
        return this.cachedU;
    }

    public RealMatrix getUT() {
        if (this.cachedUt != null) goto L6;
        this.cachedUt = getU().transpose();
    L6:
        return this.cachedUt;
    }

    public RealMatrix getS() {
        if (this.cachedS != null) goto L6;
        this.cachedS = MatrixUtils.createRealDiagonalMatrix(this.singularValues);
    L6:
        return this.cachedS;
    }

    public double[] getSingularValues() {
        return (double[]) this.singularValues.clone();
    }

    public RealMatrix getV() {
        return this.cachedV;
    }

    public RealMatrix getVT() {
        if (this.cachedVt != null) goto L6;
        this.cachedVt = getV().transpose();
    L6:
        return this.cachedVt;
    }

    public RealMatrix getCovariance(double r11) {
        int r0 = this.singularValues.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (this.singularValues[r2] < r11) goto L8;
        r2 = r2 + 1;
    L8:
        if (r2 == 0) goto L12;
        final double[][] r12 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r2, r0});
        getVT().walkInOptimizedOrder(new AnonymousClass1(this, r12), 0, r2 - 1, 0, r0 - 1);
        RealMatrix r10 = new Array2DRowRealMatrix(r12, false);
        return r10.transpose().multiply(r10);
    L12:
        throw new NumberIsTooLargeException(LocalizedFormats.TOO_LARGE_CUTOFF_SINGULAR_VALUE, Double.valueOf(r11), Double.valueOf(this.singularValues[0]), true);
    }

    public double getNorm() {
        return this.singularValues[0];
    }

    public double getConditionNumber() {
        double[] r0 = this.singularValues;
        return r0[0] / r0[this.n - 1];
    }

    public double getInverseConditionNumber() {
        double[] r0 = this.singularValues;
        return r0[this.n - 1] / r0[0];
    }

    public int getRank() {
        int r0 = 0;
        int r1 = 0;
    L3:
        double[] r2 = this.singularValues;
        if (r0 >= r2.length) goto L9;
        if (r2[r0] <= this.tol) goto L8;
        r1 = r1 + 1;
    L8:
        r0 = r0 + 1;
        goto L3
    L9:
        return r1;
    }

    public DecompositionSolver getSolver() {
        double[] r1 = this.singularValues;
        RealMatrix r2 = getUT();
        RealMatrix r3 = getV();
        if (getRank() != this.m) goto L5;
        boolean r0 = true;
    L7:
        return new Solver(r1, r2, r3, r0, this.tol, null);
    L5:
        r0 = false;
        goto L7
    }
}
