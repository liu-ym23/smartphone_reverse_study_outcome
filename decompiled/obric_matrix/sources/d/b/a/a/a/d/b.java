package d.b.a.a.a.d;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static String a(byte[] r8) {
        if (r8 != null) goto L11;
        return null;
    L11:
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L10
        int r2 = r8.length;     // Catch: Throwable -> L10
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L8;
        r1.append(String.format("%02x", new Object[]{Byte.valueOf(r8[r4])}));     // Catch: Throwable -> L10
        r4 = r4 + 1;     // Catch: Throwable -> L10
        goto L6
    L8:
        return r1.toString();
    L10:
        return null;
    }

    public static String b(String r2, String r3) {
        byte[] r4 = r2.getBytes();
    L8:
        return null;
    L4:
        if (d.b.a.a.a.e.a.c(r3) == false) goto L6;
        r3 = "SHA-256";
    L6:
        MessageDigest r5 = MessageDigest.getInstance(r3);     // Catch: Throwable -> L8
        r5.update(r4);     // Catch: Throwable -> L8
        return a(r5.digest());
    }
}
