package tmsdkobf;

import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ui {

    public interface a {
        void a(boolean r1, int r2, int r3);
    }

    public static byte[] a(InputStream r5, int r6, int r7, a r8) {
        byte[] r0 = new byte[r7];
        int r3 = r7;
        int r2 = 0;
    L3:
        if (r2 >= r7) goto L12;
        if (r3 <= 0) goto L12;
        int r4 = r5.read(r0, r6, r3);
        if (r4 <= 0) goto L7;
        r2 = r2 + r4;
        r6 = r6 + r4;
        r3 = r3 - r4;
        if (r8 == null) goto L3;
        r8.a(false, r2, r7);
        goto L3
    L7:
        if (r8 == null) goto L12;
        r8.a(true, r2, r7);
    L12:
        if (r2 == r7) goto L15;
        return null;
    L15:
        return r0;
    }
}
