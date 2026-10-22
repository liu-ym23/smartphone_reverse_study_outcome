package l.b.g.b.a;

/* JADX INFO: loaded from: classes2.dex */
class m {
    static void a(byte[] r2, l.b.b.a r3) {
        r3.b(r2, 0, r2.length);
    }

    static void b(short r1, l.b.b.a r2) {
        r2.c((byte) (r1 >>> 8));
        r2.c((byte) r1);
    }

    static void c(int r1, l.b.b.a r2) {
        r2.c((byte) (r1 >>> 24));
        r2.c((byte) (r1 >>> 16));
        r2.c((byte) (r1 >>> 8));
        r2.c((byte) r1);
    }
}
