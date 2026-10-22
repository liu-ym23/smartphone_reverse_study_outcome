package tmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class jk {
    public static byte[] a(byte[] r4, vi r5) {
        if (r4 != null) goto L16;
    L11:
        r5.c |= 1;     // Catch: Exception -> L13
    L15:
        return r4;
    L13:
        return null;
    L16:
        if (r4.length <= 50) goto L11;
        byte[] r0 = oi.a(r4);     // Catch: Exception -> L13
        int r1 = r5.c;     // Catch: Exception -> L13
        if (r0 != null) goto L8;
    L10:
        r5.c = r1 | 1;     // Catch: Exception -> L13
        goto L15
    L8:
        if (r0.length >= r4.length) goto L10;
        r5.c = r1 & (-2);     // Catch: Exception -> L13
        r4 = r0;
        goto L15
    }

    public static byte[] b(byte[] r1, byte[] r2, y6 r3) {
        if (r1 != null) goto L4;
        return r1;
    L4:
        if (r1.length == 0) goto L13;
        return r3.b(r1, r2);
    L8:
        return null;
    L13:
        return r1;
    }

    public static boolean c(ij r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.c == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean b(ij r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (c(r5) == false) goto L8;
        return false;
    L8:
        fk r6 = r5.g;
        if (r6 != null) goto L11;
    L14:
        return false;
    L11:
        if (r6.f206a == 0) goto L14;
        return true;
    }

    public static String b(String r5) {
        if (r5 == null) goto L23;
        if (r5.length() == 0) goto L23;
        if (r5.startsWith("-----BEGIN PUBLIC KEY-----") == true) goto L8;
        return r5;
    L8:
        StringBuilder r0 = new StringBuilder();
        int r2 = 1;
        if (r5.endsWith(IOUtils.LINE_SEPARATOR_UNIX) == false) goto L11;
        r5 = r5.substring(0, r5.length() - 1);
    L11:
        String[] r1 = r5.split("\\n");
        if (r1 == null) goto L21;
        if (r1.length != 6) goto L21;
    L16:
        if (r2 > 4) goto L19;
        r0.append(r1[r2]);
        r2 = r2 + 1;
        goto L16
    L19:
        return r0.toString();
    L21:
        throw new IllegalArgumentException("bad format public key: " + r5);
    L23:
        throw new IllegalArgumentException("public key must not be empty: " + r5);
    }

    public static byte[] a(byte[] r1, byte[] r2, y6 r3) {
        if (r1 != null) goto L4;
        return r1;
    L4:
        if (r1.length == 0) goto L13;
        return r3.a(r1, r2);
    L8:
        return null;
    L13:
        return r1;
    }

    public static byte[] a(Context r1, y6 r2, byte[] r3, byte[] r4, int r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.length != 0) goto L8;
        return null;
    L8:
        if ((r5 & 2) != 0) goto L10;
        r4 = r2.c(r4, r3);
    L10:
        if (r4 != null) goto L12;
        return null;
    L12:
        if (r4.length != 0) goto L15;
        return null;
    L15:
        if ((r5 & 1) != 0) goto L23;
        byte[] r6 = oi.b(r4);
        if (r6 != null) goto L19;
        return null;
    L19:
        if (r6.length != 0) goto L27;
        return null;
    L27:
        return r6;
    L23:
        return r4;
    }

    public static boolean a(byte[] r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.length != 1) goto L6;
        return true;
    }

    public static boolean a(ij r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (c(r2) == false) goto L8;
        return false;
    L8:
        if (b(r2) == true) goto L12;
        return true;
    L12:
        return false;
    }

    public static String a(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L7;
        return r3.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s", "");
    L7:
        throw new IllegalArgumentException("public key must not be empty: " + r3);
    }
}
