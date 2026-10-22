package d.b.r;

/* JADX INFO: loaded from: classes.dex */
public class l extends RuntimeException {
    public l(d0<?> r2) {
        super(a(r2));
        r2.b();
        r2.f();
    }

    private static String a(d0<?> r2) {
        f0.a(r2, "response == null");
        return "HTTP " + r2.b() + " " + r2.f();
    }
}
