package d.c.i.c.d;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public a() {
    }

    public void a(int[] r3) {
        int r2 = 0;
    L4:
        if (r2 >= r3.length) goto L9;
        if (r3[r2] >= 11) goto L8;
        r3[r2] = 100;
    L8:
        r2 = r2 + 1;
        goto L4
    }

    public int[] b(int[] r4) {
        int[] r3 = new int[r4.length];
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r3[r0] = r1;
        r1 = r1 + r4[r0];
        r0 = r0 + 1;
        goto L4
    L6:
        return r3;
    }

    public int c(int[] r3) {
        int r2 = 0;
        int r0 = 0;
    L4:
        if (r2 >= r3.length) goto L6;
        r0 = r0 + r3[r2];
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }
}
