package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
abstract class c {
    c() {
    }

    abstract void a(int r1, String r2, String r3);

    public void a(String r2, String r3) {
        a(3, r2, r3);
    }

    public void b(String r2, String r3) {
        a(6, r2, r3);
    }

    public void c(String r2, String r3) {
        a(4, r2, r3);
    }

    public void d(String r2, String r3) {
        a(2, r2, r3);
    }

    public void e(String r2, String r3) {
        a(5, r2, r3);
    }

    public void a(String r2, String r3, Throwable r4) {
        a(6, r2, r3 + '\n' + q8.a(r4));
    }

    public void b(String r2, String r3, Throwable r4) {
        a(4, r2, r3 + '\n' + q8.a(r4));
    }

    public void c(String r2, String r3, Throwable r4) {
        a(5, r2, r3 + '\n' + q8.a(r4));
    }
}
