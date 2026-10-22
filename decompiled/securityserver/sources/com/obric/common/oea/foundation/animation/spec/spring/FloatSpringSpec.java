package com.obric.common.oea.foundation.animation.spec.spring;

import com.obric.common.oea.foundation.animation.calculator.SpringSimulation;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FloatSpringSpec implements AnimationSpec<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpringSimulation f125a;
    public float b;
    public final float c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f126d;
    public final int e;
    public final float f;

    public FloatSpringSpec(float r7, float r8, int r9) {
        this.c = r7;
        this.f126d = r8;
        this.e = r9;
        this.f = 0.01f;
        SpringSimulation r10 = new SpringSimulation();
        r10.g = 1.0f;
        double r1 = Math.sqrt(50.0f);
        r10.f109a = r1;
        r10.f = 1.0f;
        float r4 = 0;
        if (r7 < r4) goto L11;
        r10.f = r7;
        r10.b = false;
        if (((float) (r1 * r1)) <= r4) goto L9;
        r10.f109a = Math.sqrt(r8);
        r10.b = false;
        this.f125a = r10;
        this.b = 1.0f;
        return;
    L9:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    L11:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public final float a(long r41, Number r43, Number r44, float r45) {
        float r2 = r43.floatValue();
        float r3 = r44.floatValue();
        SpringSimulation r4 = this.f125a;
        double r5 = r4.f109a;
        float r6 = (float) (r5 * r5);
        float r7 = r4.f;
        float r8 = this.f;
        float r9 = (r2 - r3) / r8;
        float r10 = r45 / r8;
        float r11 = this.b;
        if (r7 != 0.0f) goto L5;
        long r12 = 9223372036854L;
        float r21 = r2;
        r3 = r3;
        r4 = r4;
    L123:
        long r13 = r12 * 1000000;
        long r14 = r41 - (((long) this.e) * 1000000);
        if (r13 < 0) goto L126;
        long r15 = r13;
    L127:
        long r16 = RangesKt.c(r14, r15) / 1000000;
        SpringSimulation r1 = r4;
        r1.g = r3;
        return Float.intBitsToFloat((int) (r1.a(r21, r45, r16).f108a & 4294967295L));
    L126:
        r15 = 0;
        goto L127
    L5:
        double r17 = r6;
        double r18 = r7;
        double r19 = r10;
        double r20 = r9;
        double r22 = r11;
        r21 = r2;
        double r23 = Math.sqrt(r17) * (r18 * 2.0d);
        double r110 = (r23 * r23) - (r17 * 4.0d);
        double r24 = -r23;
        if (r110 >= 0.0d) goto L8;
        ComplexDouble r111 = new ComplexDouble(0.0d, Math.sqrt(Math.abs(r110)));
    L9:
        r111.f124a = (r111.f124a + r24) * 0.5d;
        r111.b *= 0.5d;
        if (r110 >= 0.0d) goto L12;
        ComplexDouble r25 = new ComplexDouble(0.0d, Math.sqrt(Math.abs(r110)));
    L13:
        double r112 = -1;
        double r26 = r25.f124a * r112;
        double r27 = r25.b * r112;
        r25.f124a = (r26 + r24) * 0.5d;
        r25.b = r27 * 0.5d;
        if (r20 == 0.0d) goto L16;
    L18:
        double r28 = 0;
        if (r20 >= r28) goto L21;
        r19 = -r19;
    L21:
        double r29 = Math.abs(r20);
        double r30 = Double.MAX_VALUE;
        if (r18 <= 1.0d) goto L71;
        double r31 = r111.f124a;
        double r32 = r25.f124a;
        double r33 = (r31 * r29) - r19;
        double r113 = r31 - r32;
        double r34 = r33 / r113;
        double r35 = r29 - r34;
        double r114 = Math.log(Math.abs(r22 / r35)) / r31;
        double r115 = Math.log(Math.abs(r22 / r34)) / r32;
        if (Double.isInfinite(r114) == false) goto L26;
    L29:
        boolean r116 = false;
    L31:
        if ((!r116) == false) goto L34;
        r114 = r115;
    L43:
        double r117 = r35 * r31;
        double r210 = r114;
        double r118 = Math.log(r117 / ((-r34) * r32)) / (r32 - r31);
        if (Double.isNaN(r118) == false) goto L46;
    L47:
        r32 = r32;
        double r36 = -r22;
        double r119 = r210;
    L61:
        double r120 = r34 * r32;
        if (Math.abs((Math.exp(r32 * r119) * r120) + (Math.exp(r31 * r119) * r117)) < 1.0E-4d) goto L122;
        int r37 = 0;
    L66:
        if (r30 <= 0.001d) goto L122;
        if (r37 >= 100) goto L122;
        r37 = r37 + 1;
        double r121 = r31 * r119;
        double r211 = r32 * r119;
        double r122 = r119 - ((((Math.exp(r211) * r34) + (Math.exp(r121) * r35)) + r36) / ((Math.exp(r211) * r120) + (Math.exp(r121) * r117)));
        r30 = Math.abs(r119 - r122);
        r119 = r122;
    L122:
        r12 = (long) (r119 * 1000.0d);
        goto L123
    L46:
        if (r118 <= 0.0d) goto L47;
        if (r118 > 0.0d) goto L51;
    L59:
        r32 = r32;
        r36 = r22;
        r119 = Math.log((-((r34 * r32) * r32)) / (r117 * r31)) / r113;
        goto L61
    L51:
        if ((-((Math.exp(r118 * r32) * r34) + (Math.exp(r31 * r118) * r35))) >= r22) goto L59;
        if (r34 > 0.0d) goto L55;
    L57:
        double r123 = r210;
    L58:
        r36 = -r22;
        r119 = r123;
        goto L61
    L55:
        if (r35 >= 0.0d) goto L57;
        r123 = 0.0d;
        goto L58
    L34:
        if (Double.isInfinite(r115) == false) goto L36;
    L38:
        boolean r124 = false;
    L40:
        if ((!r124) == true) goto L43;
        r114 = Math.max(r114, r115);
        goto L43
    L36:
        if (Double.isNaN(r115) == true) goto L38;
        r124 = true;
        goto L40
    L26:
        if (Double.isNaN(r114) == true) goto L29;
        r116 = true;
        goto L31
    L71:
        if (r18 >= 1.0d) goto L73;
        double r38 = r111.f124a;
        double r125 = (r19 - (r38 * r29)) / r111.b;
        r119 = Math.log(r22 / Math.sqrt((r125 * r125) + (r29 * r29))) / r38;
        goto L122
    L73:
        double r39 = r111.f124a;
        double r126 = r39 * r29;
        double r127 = r19 - r126;
        double r40 = Math.log(Math.abs(r22 / r29)) / r39;
        double r212 = Math.log(Math.abs(r22 / r127));
        double r310 = r212;
        int r42 = 0;
    L75:
        if (r42 > 5) goto L77;
        r310 = r212 - Math.log(Math.abs(r310 / r39));
        r42 = r42 + 1;
        goto L75
    L77:
        double r0 = r310 / r39;
        if (Double.isInfinite(r40) == false) goto L80;
    L83:
        boolean r46 = false;
    L85:
        if ((!r46) == false) goto L88;
        r40 = r0;
    L97:
        double r47 = (-(r126 + r127)) / (r39 * r127);
        double r213 = r39 * r47;
        double r311 = Math.exp(r213) * r29;
        double r312 = r40;
        double r48 = (Math.exp(r213) * (r127 * r47)) + r311;
        if (Double.isNaN(r47) == true) goto L114;
        double r49 = 0.0d;
        if (r47 <= 0.0d) goto L114;
        if (r47 > 0.0d) goto L105;
    L113:
        double r50 = r22;
        double r51 = (-(2.0d / r39)) - (r29 / r127);
    L115:
        int r52 = 0;
    L117:
        if (r30 <= 0.001d) goto L121;
        if (r52 >= 100) goto L121;
        r52 = r52 + 1;
        double r214 = r39 * r51;
        double r53 = r51 - (((Math.exp(r214) * ((r127 * r51) + r29)) + r50) / (Math.exp(r214) * (((r214 + ((double) 1)) * r127) + r126)));
        r30 = Math.abs(r51 - r53);
        r51 = r53;
        r29 = r29;
    L121:
        r119 = r51;
        goto L122
    L105:
        if ((-r48) >= r22) goto L113;
        if (r127 < r28) goto L109;
    L111:
        r49 = r312;
    L112:
        r50 = -r22;
        r51 = r49;
        goto L115
    L109:
        if (r29 <= r28) goto L111;
    L114:
        r50 = -r22;
        r51 = r312;
        goto L115
    L88:
        if (Double.isInfinite(r0) == false) goto L90;
    L92:
        boolean r54 = false;
    L94:
        if ((!r54) == true) goto L97;
        r40 = Math.max(r40, r0);
        goto L97
    L90:
        if (Double.isNaN(r0) == true) goto L92;
        r54 = true;
        goto L94
    L80:
        if (Double.isNaN(r40) == true) goto L83;
        r46 = true;
        goto L85
    L16:
        if (r19 != 0.0d) goto L18;
        r12 = 0;
        goto L123
    L12:
        r25 = new ComplexDouble(Math.sqrt(r110), 0.0d);
        goto L13
    L8:
        r111 = new ComplexDouble(Math.sqrt(r110), 0.0d);
        goto L9
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public final long b(float r30, Object r31, Object r32) {
        float r1 = ((Number) r31).floatValue();
        float r2 = ((Number) r32).floatValue();
        SpringSimulation r3 = this.f125a;
        double r4 = r3.f109a;
        float r5 = (float) (r4 * r4);
        float r6 = r3.f;
        float r7 = r1 - r2;
        float r8 = this.f;
        float r9 = r7 / r8;
        float r10 = r30 / r8;
        float r0 = this.b;
        if (r6 != 0.0f) goto L5;
        long r11 = 9223372036854L;
    L123:
        return r11 * 1000000;
    L5:
        double r12 = r5;
        double r13 = r6;
        double r14 = r10;
        double r15 = r9;
        double r16 = r0;
        double r17 = Math.sqrt(r12) * (r13 * 2.0d);
        double r18 = (r17 * r17) - (r12 * 4.0d);
        double r19 = -r17;
        if (r18 >= 0.0d) goto L8;
        ComplexDouble r110 = new ComplexDouble(0.0d, Math.sqrt(Math.abs(r18)));
    L9:
        r110.f124a = (r110.f124a + r19) * 0.5d;
        r110.b *= 0.5d;
        if (r18 >= 0.0d) goto L12;
        ComplexDouble r20 = new ComplexDouble(0.0d, Math.sqrt(Math.abs(r18)));
    L13:
        double r111 = -1;
        double r112 = r20.f124a * r111;
        double r21 = r20.b * r111;
        r20.f124a = (r112 + r19) * 0.5d;
        r20.b = r21 * 0.5d;
        if (r15 == 0.0d) goto L16;
    L18:
        double r22 = 0;
        if (r15 >= r22) goto L21;
        r14 = -r14;
    L21:
        double r23 = Math.abs(r15);
        double r113 = Double.MAX_VALUE;
        if (r13 <= 1.0d) goto L71;
        double r24 = r110.f124a;
        double r25 = r20.f124a;
        double r114 = (r24 * r23) - r14;
        double r26 = r24 - r25;
        double r115 = r114 / r26;
        double r27 = r23 - r115;
        double r28 = Math.log(Math.abs(r16 / r27)) / r24;
        double r116 = Math.log(Math.abs(r16 / r115)) / r25;
        if (Double.isInfinite(r28) == false) goto L26;
    L28:
        boolean r117 = true;
        boolean r118 = false;
    L30:
        if ((r118 ^ r117) == false) goto L33;
        r28 = r116;
    L42:
        double r119 = r27 * r24;
        double r120 = Math.log(r119 / ((-r115) * r25)) / (r25 - r24);
        if (Double.isNaN(r120) == true) goto L59;
        if (r120 <= 0.0d) goto L59;
        if (r120 > 0.0d) goto L50;
    L58:
        r28 = Math.log((-((r115 * r25) * r25)) / (r119 * r24)) / r26;
        double r29 = r16;
    L60:
        double r121 = r115 * r25;
        if (Math.abs((Math.exp(r25 * r28) * r121) + (Math.exp(r24 * r28) * r119)) < 1.0E-4d) goto L121;
        double r122 = r28;
        int r33 = 0;
        double r210 = 0.001d;
    L65:
        if (r113 <= r210) goto L69;
        if (r33 >= 100) goto L69;
        r33 = r33 + 1;
        double r123 = r24 * r122;
        double r211 = r25 * r122;
        double r124 = r122 - ((((Math.exp(r211) * r115) + (Math.exp(r123) * r27)) + r29) / ((Math.exp(r211) * r121) + (Math.exp(r123) * r119)));
        double r125 = Math.abs(r122 - r124);
        r210 = 0.001d;
        r122 = r124;
        r113 = r125;
    L69:
        r28 = r122;
    L121:
        r11 = (long) (r28 * 1000.0d);
        goto L123
    L50:
        if ((-((Math.exp(r120 * r25) * r115) + (Math.exp(r24 * r120) * r27))) >= r16) goto L58;
        if (r115 > 0.0d) goto L54;
    L56:
        double r126 = r28;
    L57:
        r29 = -r16;
        r28 = r126;
        goto L60
    L54:
        if (r27 >= 0.0d) goto L56;
        r126 = 0.0d;
    L59:
        r29 = -r16;
        goto L60
    L33:
        if (Double.isInfinite(r116) == false) goto L35;
    L37:
        boolean r127 = false;
    L39:
        if ((r117 ^ r127) == true) goto L42;
        r28 = Math.max(r28, r116);
        goto L42
    L35:
        if (Double.isNaN(r116) == true) goto L37;
        r127 = r117;
        goto L39
    L26:
        if (Double.isNaN(r28) == true) goto L28;
        r117 = true;
        r118 = true;
        goto L30
    L71:
        if (r13 >= 1.0d) goto L73;
        double r34 = r110.f124a;
        double r35 = (r14 - (r34 * r23)) / r110.b;
        r28 = Math.log(r16 / Math.sqrt((r35 * r35) + (r23 * r23))) / r34;
        goto L121
    L73:
        double r36 = r110.f124a;
        double r128 = r36 * r23;
        double r37 = r14 - r128;
        double r129 = Math.log(Math.abs(r16 / r23)) / r36;
        double r212 = Math.log(Math.abs(r16 / r37));
        double r213 = r212;
        int r38 = 0;
    L75:
        if (r38 > 5) goto L77;
        r213 = r212 - Math.log(Math.abs(r213 / r36));
        r38 = r38 + 1;
        goto L75
    L77:
        double r39 = r213 / r36;
        if (Double.isInfinite(r129) == false) goto L80;
    L82:
        boolean r214 = true;
        boolean r215 = false;
    L84:
        if ((!r215) == false) goto L87;
        r129 = r39;
    L96:
        double r40 = (-(r128 + r37)) / (r36 * r37);
        double r216 = r36 * r40;
        double r217 = Math.exp(r216) * r23;
        double r218 = r129;
        double r130 = (Math.exp(r216) * (r37 * r40)) + r217;
        if (Double.isNaN(r40) == true) goto L113;
        double r131 = 0.0d;
        if (r40 <= 0.0d) goto L113;
        if (r40 > 0.0d) goto L104;
    L112:
        double r132 = (-(2.0d / r36)) - (r23 / r37);
        double r41 = r16;
    L114:
        int r42 = 0;
    L116:
        if (r113 <= 0.001d) goto L120;
        if (r42 >= 100) goto L120;
        r42 = r42 + 1;
        double r133 = r36 * r132;
        double r134 = r132 - (((Math.exp(r133) * ((r37 * r132) + r23)) + r41) / (Math.exp(r133) * (((r133 + ((double) 1)) * r37) + r128)));
        r113 = Math.abs(r132 - r134);
        r132 = r134;
    L120:
        r28 = r132;
        goto L121
    L104:
        if ((-r130) >= r16) goto L112;
        if (r37 < r22) goto L108;
    L110:
        r131 = r218;
    L111:
        r41 = -r16;
        r132 = r131;
        goto L114
    L108:
        if (r23 <= r22) goto L110;
    L113:
        r41 = -r16;
        r132 = r218;
        goto L114
    L87:
        if (Double.isInfinite(r39) == false) goto L89;
    L91:
        boolean r219 = false;
    L93:
        if ((!r219) == true) goto L96;
        r129 = Math.max(r129, r39);
        goto L96
    L89:
        if (Double.isNaN(r39) == true) goto L91;
        r219 = r214;
        goto L93
    L80:
        if (Double.isNaN(r129) == true) goto L82;
        r214 = true;
        r215 = true;
        goto L84
    L16:
        if (r14 != 0.0d) goto L18;
        r11 = 0;
        goto L123
    L12:
        r20 = new ComplexDouble(Math.sqrt(r18), 0.0d);
        goto L13
    L8:
        r110 = new ComplexDouble(Math.sqrt(r18), 0.0d);
        goto L9
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public final String c() {
        return "FloatSpringSpec(dampingRatio: " + this.c + ", stiffness: " + this.f126d + ", delay: " + this.e + ", visibilityThreshold: " + this.f + ", delta: " + this.b + ')';
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public final Object d(long r41, Number r43, Number r44, float r45) {
        float r2 = r43.floatValue();
        float r3 = r44.floatValue();
        SpringSimulation r4 = this.f125a;
        double r5 = r4.f109a;
        float r6 = (float) (r5 * r5);
        float r7 = r4.f;
        float r8 = this.f;
        float r9 = (r2 - r3) / r8;
        float r10 = r45 / r8;
        float r11 = this.b;
        if (r7 != 0.0f) goto L5;
        long r12 = 9223372036854L;
        float r21 = r2;
        r3 = r3;
        r4 = r4;
    L123:
        long r13 = r12 * 1000000;
        long r14 = r41 - (((long) this.e) * 1000000);
        if (r13 < 0) goto L126;
        long r15 = r13;
    L127:
        long r16 = RangesKt.c(r14, r15) / 1000000;
        SpringSimulation r1 = r4;
        r1.g = r3;
        return Float.valueOf(Float.intBitsToFloat((int) (r1.a(r21, r45, r16).f108a >> 32)));
    L126:
        r15 = 0;
        goto L127
    L5:
        double r17 = r6;
        double r18 = r7;
        double r19 = r10;
        double r20 = r9;
        double r22 = r11;
        r21 = r2;
        double r23 = Math.sqrt(r17) * (r18 * 2.0d);
        double r110 = (r23 * r23) - (r17 * 4.0d);
        double r24 = -r23;
        if (r110 >= 0.0d) goto L8;
        ComplexDouble r111 = new ComplexDouble(0.0d, Math.sqrt(Math.abs(r110)));
    L9:
        r111.f124a = (r111.f124a + r24) * 0.5d;
        r111.b *= 0.5d;
        if (r110 >= 0.0d) goto L12;
        ComplexDouble r25 = new ComplexDouble(0.0d, Math.sqrt(Math.abs(r110)));
    L13:
        double r112 = -1;
        double r26 = r25.f124a * r112;
        double r27 = r25.b * r112;
        r25.f124a = (r26 + r24) * 0.5d;
        r25.b = r27 * 0.5d;
        if (r20 == 0.0d) goto L16;
    L18:
        double r28 = 0;
        if (r20 >= r28) goto L21;
        r19 = -r19;
    L21:
        double r29 = Math.abs(r20);
        double r30 = Double.MAX_VALUE;
        if (r18 <= 1.0d) goto L71;
        double r31 = r111.f124a;
        double r32 = r25.f124a;
        double r33 = (r31 * r29) - r19;
        double r113 = r31 - r32;
        double r34 = r33 / r113;
        double r35 = r29 - r34;
        double r114 = Math.log(Math.abs(r22 / r35)) / r31;
        double r115 = Math.log(Math.abs(r22 / r34)) / r32;
        if (Double.isInfinite(r114) == false) goto L26;
    L29:
        boolean r116 = false;
    L31:
        if ((!r116) == false) goto L34;
        r114 = r115;
    L43:
        double r117 = r35 * r31;
        double r210 = r114;
        double r118 = Math.log(r117 / ((-r34) * r32)) / (r32 - r31);
        if (Double.isNaN(r118) == false) goto L46;
    L47:
        r32 = r32;
        double r36 = -r22;
        double r119 = r210;
    L61:
        double r120 = r34 * r32;
        if (Math.abs((Math.exp(r32 * r119) * r120) + (Math.exp(r31 * r119) * r117)) < 1.0E-4d) goto L122;
        int r37 = 0;
    L66:
        if (r30 <= 0.001d) goto L122;
        if (r37 >= 100) goto L122;
        r37 = r37 + 1;
        double r121 = r31 * r119;
        double r211 = r32 * r119;
        double r122 = r119 - ((((Math.exp(r211) * r34) + (Math.exp(r121) * r35)) + r36) / ((Math.exp(r211) * r120) + (Math.exp(r121) * r117)));
        r30 = Math.abs(r119 - r122);
        r119 = r122;
    L122:
        r12 = (long) (r119 * 1000.0d);
        goto L123
    L46:
        if (r118 <= 0.0d) goto L47;
        if (r118 > 0.0d) goto L51;
    L59:
        r32 = r32;
        r36 = r22;
        r119 = Math.log((-((r34 * r32) * r32)) / (r117 * r31)) / r113;
        goto L61
    L51:
        if ((-((Math.exp(r118 * r32) * r34) + (Math.exp(r31 * r118) * r35))) >= r22) goto L59;
        if (r34 > 0.0d) goto L55;
    L57:
        double r123 = r210;
    L58:
        r36 = -r22;
        r119 = r123;
        goto L61
    L55:
        if (r35 >= 0.0d) goto L57;
        r123 = 0.0d;
        goto L58
    L34:
        if (Double.isInfinite(r115) == false) goto L36;
    L38:
        boolean r124 = false;
    L40:
        if ((!r124) == true) goto L43;
        r114 = Math.max(r114, r115);
        goto L43
    L36:
        if (Double.isNaN(r115) == true) goto L38;
        r124 = true;
        goto L40
    L26:
        if (Double.isNaN(r114) == true) goto L29;
        r116 = true;
        goto L31
    L71:
        if (r18 >= 1.0d) goto L73;
        double r38 = r111.f124a;
        double r125 = (r19 - (r38 * r29)) / r111.b;
        r119 = Math.log(r22 / Math.sqrt((r125 * r125) + (r29 * r29))) / r38;
        goto L122
    L73:
        double r39 = r111.f124a;
        double r126 = r39 * r29;
        double r127 = r19 - r126;
        double r40 = Math.log(Math.abs(r22 / r29)) / r39;
        double r212 = Math.log(Math.abs(r22 / r127));
        double r310 = r212;
        int r42 = 0;
    L75:
        if (r42 > 5) goto L77;
        r310 = r212 - Math.log(Math.abs(r310 / r39));
        r42 = r42 + 1;
        goto L75
    L77:
        double r0 = r310 / r39;
        if (Double.isInfinite(r40) == false) goto L80;
    L83:
        boolean r46 = false;
    L85:
        if ((!r46) == false) goto L88;
        r40 = r0;
    L97:
        double r47 = (-(r126 + r127)) / (r39 * r127);
        double r213 = r39 * r47;
        double r311 = Math.exp(r213) * r29;
        double r312 = r40;
        double r48 = (Math.exp(r213) * (r127 * r47)) + r311;
        if (Double.isNaN(r47) == true) goto L114;
        double r49 = 0.0d;
        if (r47 <= 0.0d) goto L114;
        if (r47 > 0.0d) goto L105;
    L113:
        double r50 = r22;
        double r51 = (-(2.0d / r39)) - (r29 / r127);
    L115:
        int r52 = 0;
    L117:
        if (r30 <= 0.001d) goto L121;
        if (r52 >= 100) goto L121;
        r52 = r52 + 1;
        double r214 = r39 * r51;
        double r53 = r51 - (((Math.exp(r214) * ((r127 * r51) + r29)) + r50) / (Math.exp(r214) * (((r214 + ((double) 1)) * r127) + r126)));
        r30 = Math.abs(r51 - r53);
        r51 = r53;
        r29 = r29;
    L121:
        r119 = r51;
        goto L122
    L105:
        if ((-r48) >= r22) goto L113;
        if (r127 < r28) goto L109;
    L111:
        r49 = r312;
    L112:
        r50 = -r22;
        r51 = r49;
        goto L115
    L109:
        if (r29 <= r28) goto L111;
    L114:
        r50 = -r22;
        r51 = r312;
        goto L115
    L88:
        if (Double.isInfinite(r0) == false) goto L90;
    L92:
        boolean r54 = false;
    L94:
        if ((!r54) == true) goto L97;
        r40 = Math.max(r40, r0);
        goto L97
    L90:
        if (Double.isNaN(r0) == true) goto L92;
        r54 = true;
        goto L94
    L80:
        if (Double.isNaN(r40) == true) goto L83;
        r46 = true;
        goto L85
    L16:
        if (r19 != 0.0d) goto L18;
        r12 = 0;
        goto L123
    L12:
        r25 = new ComplexDouble(Math.sqrt(r110), 0.0d);
        goto L13
    L8:
        r111 = new ComplexDouble(Math.sqrt(r110), 0.0d);
        goto L9
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public final boolean e(long r5, long r7) {
        if (r5 < ((((long) this.e) * 1000000) + r7)) goto L5;
        return true;
    L5:
        return false;
    }
}
