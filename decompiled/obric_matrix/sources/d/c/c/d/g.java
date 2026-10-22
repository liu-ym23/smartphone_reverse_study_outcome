package d.c.c.d;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static int a(int... r3) {
        int r2 = 1;
        if (r3.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        i.b(r0);
        int r1 = r3[0];
    L8:
        if (r2 >= r3.length) goto L13;
        if (r3[r2] <= r1) goto L12;
        r1 = r3[r2];
    L12:
        r2 = r2 + 1;
        goto L8
    L13:
        return r1;
    L5:
        r0 = false;
        goto L6
    }
}
