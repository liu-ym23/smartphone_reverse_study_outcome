package com.obric.oui.animation.engine;

/* JADX INFO: loaded from: classes2.dex */
public final class SpringForce implements Force {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f170a;
    public double b;
    public boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f171d;
    public double e;
    public double f;
    public double g;
    public double h;
    public double i;
    public final DynamicAnimation.MassState j;

    public SpringForce() {
        this.f170a = Math.sqrt(1500.0d);
        this.b = 0.5d;
        this.c = false;
        this.i = Double.MAX_VALUE;
        this.j = new DynamicAnimation.MassState();
    }

    public final DynamicAnimation.MassState a(long r17, double r19, double r21) {
        if (this.c == false) goto L6;
    L16:
        double r4 = r17 / 1000.0d;
        double r6 = r19 - this.i;
        double r8 = this.b;
        if (r8 <= 1.0d) goto L20;
        double r1 = this.g;
        double r12 = this.f;
        double r9 = r6 - (((r1 * r6) - r21) / (r1 - r12));
        double r7 = ((r6 * r1) - r21) / (r1 - r12);
        double r13 = (Math.pow(2.718281828459045d, this.f * r4) * r7) + (Math.pow(2.718281828459045d, r1 * r4) * r9);
        double r2 = this.g;
        double r3 = Math.pow(2.718281828459045d, r2 * r4) * (r9 * r2);
        double r10 = this.f;
        double r5 = (Math.pow(2.718281828459045d, r10 * r4) * (r7 * r10)) + r3;
    L23:
        float r11 = (float) (r13 + this.i);
        DynamicAnimation.MassState r0 = this.j;
        r0.f169a = r11;
        r0.b = (float) r5;
        return r0;
    L20:
        if (r8 != 1.0d) goto L22;
        double r14 = this.f170a;
        double r15 = (r14 * r6) + r21;
        double r16 = (r15 * r4) + r6;
        double r18 = Math.pow(2.718281828459045d, (-r14) * r4) * r16;
        double r20 = Math.pow(2.718281828459045d, (-this.f170a) * r4) * r16;
        double r110 = this.f170a;
        r5 = (Math.pow(2.718281828459045d, (-r110) * r4) * r15) + (r20 * (-r110));
        r13 = r18;
        goto L23
    L22:
        double r22 = 1.0d / this.h;
        double r111 = this.f170a;
        double r112 = (((r8 * r111) * r6) + r21) * r22;
        double r113 = ((Math.sin(this.h * r4) * r112) + (Math.cos(this.h * r4) * r6)) * Math.pow(2.718281828459045d, ((-r8) * r111) * r4);
        double r23 = this.f170a;
        double r114 = this.b;
        double r24 = ((-r23) * r113) * r114;
        double r25 = Math.pow(2.718281828459045d, ((-r114) * r23) * r4);
        double r115 = this.h;
        double r26 = Math.sin(r115 * r4) * ((-r115) * r6);
        double r116 = this.h;
        r5 = (((Math.cos(r116 * r4) * (r112 * r116)) + r26) * r25) + r24;
        r13 = r113;
        goto L23
    L6:
        if (this.i == Double.MAX_VALUE) goto L26;
        double r27 = this.b;
        if (r27 <= 1.0d) goto L11;
        double r28 = this.f170a;
        this.f = (Math.sqrt((r27 * r27) - 1.0d) * r28) + ((-r27) * r28);
        double r29 = this.b;
        double r30 = this.f170a;
        this.g = ((-r29) * r30) - (Math.sqrt((r29 * r29) - 1.0d) * r30);
    L15:
        this.c = true;
        goto L16
    L11:
        if (r27 < 0.0d) goto L15;
        if (r27 >= 1.0d) goto L15;
        this.h = Math.sqrt(1.0d - (r27 * r27)) * this.f170a;
        goto L15
    L26:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }
}
