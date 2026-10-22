package d.c.i.e;

/* JADX INFO: loaded from: classes2.dex */
public class k implements d.c.c.d.l<r> {
    public k() {
    }

    private int b() {
        int r4 = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (r4 >= 16777216) goto L7;
        return 1048576;
    L7:
        if (r4 >= 33554432) goto L10;
        return 2097152;
    L10:
        return 4194304;
    }

    public r a() {
        int r3 = b();
        return new r(r3, Integer.MAX_VALUE, r3, Integer.MAX_VALUE, r3 / 8);
    }

    @Override // d.c.c.d.l
    public /* bridge */ /* synthetic */ r get() {
        return a();
    }
}
