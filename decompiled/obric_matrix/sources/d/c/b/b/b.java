package d.c.b.b;

/* JADX INFO: loaded from: classes.dex */
public class b implements i {

    class a implements h {
        a(b r1) {
        }

        public int a(d.a r3, d.a r4) {
            long r2 = r3.b();
            long r0 = r4.b();
            if (r2 >= r0) goto L6;
            return -1;
        L6:
            if (r0 != r2) goto L8;
            return 0;
        L8:
            return 1;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(d.a r1, d.a r2) {
            return a(r1, r2);
        }
    }

    public b() {
    }

    @Override // d.c.b.b.i
    public h get() {
        return new a(this);
    }
}
