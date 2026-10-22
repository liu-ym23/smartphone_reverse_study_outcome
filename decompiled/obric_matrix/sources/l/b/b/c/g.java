package l.b.b.c;

/* JADX INFO: loaded from: classes2.dex */
public class g extends c {
    public g() {
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
        r();
        return 48;
    }

    @Override // l.b.b.a
    public String e() {
        return "SHA-384";
    }

    @Override // l.b.b.a
    public int f() {
        return 48;
    }

    @Override // l.b.b.c.c
    public void r() {
        super.r();
        this.f21834e = -3766243637369397544L;
        this.f21835f = 7105036623409894663L;
        this.f21836g = -7973340178411365097L;
        this.f21837h = 1526699215303891257L;
        this.f21838i = 7436329637833083697L;
        this.f21839j = -8163818279084223215L;
        this.f21840k = -2662702644619276377L;
        this.f21841l = 5167115440072839076L;
    }
}
