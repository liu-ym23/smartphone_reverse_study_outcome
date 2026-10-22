package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public final class m0 extends i3 implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f344a;
    public String b;
    public int c;
    public int d;
    public String e;
    public long f;

    public m0() {
        this.f344a = 0;
        this.b = "";
        this.c = 0;
        this.d = 0;
        this.e = "";
        this.f = 0;
    }

    @Override // tmsdkobf.i3
    public void a(i2 r3) {
        r3.a(this.f344a, 0);
        r3.a(this.b, 1);
        int r0 = this.c;
        if (r0 == 0) goto L5;
        r3.a(r0, 3);
    L5:
        int r2 = this.d;
        if (r2 == 0) goto L9;
        r3.a(r2, 4);
        return;
    }

    @Override // tmsdkobf.i3
    public void a(y1 r5) {
        this.f344a = r5.a(this.f344a, 0, true);
        this.b = r5.b(1, true);
        this.c = r5.a(this.c, 3, false);
        this.d = r5.a(this.d, 4, false);
        this.e = r5.b(5, false);
        this.f = r5.a(this.f, 6, false);
    }
}
