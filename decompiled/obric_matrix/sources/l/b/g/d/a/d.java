package l.b.g.d.a;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static int[] a(int[] r3) {
        int[] r0 = new int[r3.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return r0;
    }

    public static boolean b(int[] r6, int[] r7) {
        if (r6.length == r7.length) goto L5;
        return false;
    L5:
        int r0 = r6.length - 1;
        boolean r3 = true;
    L6:
        if (r0 < 0) goto L12;
        if (r6[r0] != r7[r0]) goto L10;
        boolean r4 = true;
    L11:
        r3 = r3 & r4;
        r0 = r0 - 1;
        goto L6
    L10:
        r4 = false;
        goto L11
    L12:
        return r3;
    }
}
