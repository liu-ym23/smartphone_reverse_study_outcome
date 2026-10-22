package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public class x2 implements v2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f610a;

    public x2(long r1) {
        this.f610a = r1;
    }

    @Override // tmsdkobf.v2
    public void a(int r4, v2.b r5) {
        w2.b().a(this.f610a, r4, r5);
    }

    @Override // tmsdkobf.v2
    public void a(v2.a r12, int r13, int r14) {
        w2 r0 = w2.b();
        long r1 = this.f610a;
        long r3 = r12.f564a;
        long r5 = r12.b;
        r2 r11 = r12.c;
        r0.a(r1, r3, r5, r11.f465a, r11.c, r13, r14);
    }
}
