package d.g.d.b.b;

/* JADX INFO: loaded from: classes2.dex */
public final class q {
    public static final /* synthetic */ boolean a(float[] r0) {
        return b(r0);
    }

    private static final boolean b(float[] r6) {
        if (r6.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        float r1 = r6[0];
        int r3 = r6.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L22;
        float r5 = r6[r4];
        r4 = r4 + 1;
        if (r5 == r1) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L9;
        return false;
    L13:
        r7 = false;
        goto L14
    L22:
        return true;
    L5:
        r0 = false;
        goto L6
    }
}
