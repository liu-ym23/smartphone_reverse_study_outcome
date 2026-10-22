package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public final class nk extends i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f376a;
    public String b;

    public nk() {
        this.f376a = "";
        this.b = "";
    }

    @Override // tmsdkobf.i3
    public void a(i2 r3) {
        r3.a(this.f376a, 0);
        r3.a(this.b, 1);
    }

    @Override // tmsdkobf.i3
    public void a(y1 r3) {
        this.f376a = r3.b(0, true);
        this.b = r3.b(1, true);
    }
}
