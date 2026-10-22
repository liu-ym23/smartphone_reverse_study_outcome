package l.b.b.c;

/* JADX INFO: loaded from: classes2.dex */
public class h extends c {
    public h() {
    }

    @Override // l.b.b.a
    public int a(byte[] r4, int r5) {
        n();
        l.b.h.e.h(this.f21834e, r4, r5);
        l.b.h.e.h(this.f21835f, r4, r5 + 8);
        l.b.h.e.h(this.f21836g, r4, r5 + 16);
        l.b.h.e.h(this.f21837h, r4, r5 + 24);
        l.b.h.e.h(this.f21838i, r4, r5 + 32);
        l.b.h.e.h(this.f21839j, r4, r5 + 40);
        l.b.h.e.h(this.f21840k, r4, r5 + 48);
        l.b.h.e.h(this.f21841l, r4, r5 + 56);
        r();
        return 64;
    }

    @Override // l.b.b.a
    public String e() {
        return "SHA-512";
    }

    @Override // l.b.b.a
    public int f() {
        return 64;
    }

    @Override // l.b.b.c.c
    public void r() {
        super.r();
        this.f21834e = 7640891576956012808L;
        this.f21835f = -4942790177534073029L;
        this.f21836g = 4354685564936845355L;
        this.f21837h = -6534734903238641935L;
        this.f21838i = 5840696475078001361L;
        this.f21839j = -7276294671716946913L;
        this.f21840k = 2270897969802886507L;
        this.f21841l = 6620516959819538809L;
    }
}
