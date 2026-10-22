package uq;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f22445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f22446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f22447c;
    public double d;
    public double e;
    public double f;
    public double g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f22448h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f22449i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ym.b f22450j;

    public e() {
        this.f22445a = Math.sqrt(1500.0d);
        this.f22446b = 0.5d;
        this.f22447c = false;
        this.f22449i = Double.MAX_VALUE;
        this.f22450j = new ym.b();
    }

    public final ym.b a(double r17, double r19, long r21) {
        if (this.f22447c == false) goto L6;
    L16:
        double r5 = r21 / 1000.0d;
        double r10 = r17 - this.f22449i;
        double r11 = this.f22446b;
        if (r11 <= 1.0d) goto L19;
        double r12 = this.g;
        double r13 = ((r12 * r10) - r19) / (r12 - this.f);
        double r14 = r10 - r13;
        double r15 = (Math.pow(2.718281828459045d, this.f * r5) * r13) + (Math.pow(2.718281828459045d, r12 * r5) * r14);
        double r16 = this.g;
        double r18 = Math.pow(2.718281828459045d, r16 * r5) * (r14 * r16);
        double r20 = this.f;
        double r22 = (Math.pow(2.718281828459045d, r20 * r5) * (r13 * r20)) + r18;
    L22:
        float r23 = (float) (r15 + this.f22449i);
        ym.b r24 = this.f22450j;
        r24.f23293a = r23;
        r24.f23294b = (float) r22;
        return r24;
    L19:
        if (r11 != 1.0d) goto L21;
        double r25 = this.f22445a;
        double r26 = (r25 * r10) + r19;
        double r110 = (r26 * r5) + r10;
        double r27 = Math.pow(2.718281828459045d, (-r25) * r5) * r110;
        double r28 = Math.pow(2.718281828459045d, (-this.f22445a) * r5) * r110;
        double r111 = -this.f22445a;
        r22 = (Math.pow(2.718281828459045d, r111 * r5) * r26) + (r28 * r111);
        r15 = r27;
        goto L22
    L21:
        double r29 = 1.0d / this.f22448h;
        double r112 = this.f22445a;
        double r113 = (((r11 * r112) * r10) + r19) * r29;
        double r114 = ((Math.sin(this.f22448h * r5) * r113) + (Math.cos(this.f22448h * r5) * r10)) * Math.pow(2.718281828459045d, ((-r11) * r112) * r5);
        double r30 = this.f22445a;
        double r115 = this.f22446b;
        double r31 = ((-r30) * r114) * r115;
        double r32 = Math.pow(2.718281828459045d, ((-r115) * r30) * r5);
        double r116 = this.f22448h;
        double r33 = Math.sin(r116 * r5) * ((-r116) * r10);
        double r117 = this.f22448h;
        r22 = (((Math.cos(r117 * r5) * (r113 * r117)) + r33) * r32) + r31;
        r15 = r114;
        goto L22
    L6:
        if (this.f22449i == Double.MAX_VALUE) goto L25;
        double r34 = this.f22446b;
        if (r34 <= 1.0d) goto L11;
        double r35 = this.f22445a;
        this.f = (Math.sqrt((r34 * r34) - 1.0d) * r35) + ((-r34) * r35);
        double r36 = this.f22446b;
        double r37 = this.f22445a;
        this.g = ((-r36) * r37) - (Math.sqrt((r36 * r36) - 1.0d) * r37);
    L15:
        this.f22447c = true;
        goto L16
    L11:
        if (r34 < 0.0d) goto L15;
        if (r34 >= 1.0d) goto L15;
        this.f22448h = Math.sqrt(1.0d - (r34 * r34)) * this.f22445a;
        goto L15
    L25:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }
}
