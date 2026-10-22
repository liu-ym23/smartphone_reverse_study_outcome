package d.b.r.k0;

/* JADX INFO: loaded from: classes.dex */
public class k extends g {
    public k(String r3) {
        super("text/plain; charset=UTF-8", l(r3), new String[0]);
    }

    private static byte[] l(String r1) {
        return r1.getBytes("UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // d.b.r.k0.g
    public String toString() {
        return "TypedString[" + new String(k(), "UTF-8") + "]";
    L5:
        throw new AssertionError("Must be able to decode UTF-8");
    }
}
