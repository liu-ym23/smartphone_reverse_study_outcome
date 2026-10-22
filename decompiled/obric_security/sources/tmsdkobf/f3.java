package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public final class f3 extends i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f195a;
    public float b;
    public float c;
    public float d;
    public float e;

    public f3() {
        this.f195a = 0;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
    }

    @Override // tmsdkobf.i3
    public void a(i2 r4) {
        r4.a(this.f195a, 0);
        r4.a(this.b, 1);
        r4.a(this.c, 2);
        float r0 = this.d;
        if (r0 == 0.0f) goto L5;
        r4.a(r0, 3);
    L5:
        float r3 = this.e;
        if (r3 == 0.0f) goto L9;
        r4.a(r3, 4);
        return;
    }

    @Override // tmsdkobf.i3
    public void a(y1 r5) {
        this.f195a = r5.a(this.f195a, 0, true);
        this.b = r5.a(this.b, 1, true);
        this.c = r5.a(this.c, 2, true);
        this.d = r5.a(this.d, 3, false);
        this.e = r5.a(this.e, 4, false);
    }
}
