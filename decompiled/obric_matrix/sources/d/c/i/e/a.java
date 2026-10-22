package d.c.i.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: d.c.i.e.a$a, reason: collision with other inner class name */
    static class C0428a implements x<d.c.i.l.c> {
        C0428a() {
        }

        @Override // d.c.i.e.x
        public /* bridge */ /* synthetic */ int a(d.c.i.l.c r1) {
            return b(r1);
        }

        public int b(d.c.i.l.c r1) {
            if (r1 != null) goto L5;
            return 0;
        L5:
            return r1.x();
        }
    }

    public static h<d.c.b.a.d, d.c.i.l.c> a(d.c.c.d.l<r> r2, d.c.c.g.d r3, h.c r4) {
        h<d.c.b.a.d, d.c.i.l.c> r1 = new h(new C0428a(), r4, r2);
        r3.a(r1);
        return r1;
    }
}
