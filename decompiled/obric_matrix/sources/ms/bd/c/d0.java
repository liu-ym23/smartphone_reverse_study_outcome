package ms.bd.c;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f22329a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f22330b = null;

    static {
        f22329a = (String) m.a(16777217, 0, 0, "e6772e", new byte[]{85, 22, 103, 103, 40, 84, 65, 63, 79, 77, 95, 24, 105, 109, 34, 66, 87, 37, 85, 83, 65, 2, 115, 123, 52, 72, 103, 21, 101, 99, 113, 50, 67, 75, 4, 120, 109, 27, 107, 105, 123, 36, 85, 81, 30, 102, 115, 1, 113, 127, 109, 46, 20, 18, 95, 33, 50, 66, 48, 48, 44, 109, 15, 12});
        f22330b = (String) m.a(16777217, 0, 0, "24e6e8", new byte[]{126});
    }

    public static String a(String r9) {
        if (r9 != null) goto L4;
        return r9;
    L4:
        if (r9.length() > 0) goto L7;
        return r9;
    L7:
        return r9.replaceAll((String) m.a(16777217, 0, 0, "60f7f0", new byte[]{27, 121}), (String) m.a(16777217, 0, 0, "a289ef", new byte[]{61})).replaceAll((String) m.a(16777217, 0, 0, "f76351", new byte[]{56}), (String) m.a(16777217, 0, 0, "59dd6d", new byte[]{27})).replaceAll(f22330b, "");
    }

    public static String b(byte[] r10) {
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L15
        int r2 = r10.length % 3;     // Catch: Throwable -> L15
        if (r2 <= 0) goto L8;
        r10 = Arrays.copyOf(r10, (r10.length + 3) - r2);     // Catch: Throwable -> L15
        String r4 = "";
    L6:
        if (r2 >= 3) goto L9;
        r4 = r4 + f22330b;     // Catch: Throwable -> L15
        r2 = r2 + 1;     // Catch: Throwable -> L15
    L9:
        int r3 = 0;
    L11:
        if (r3 >= r10.length) goto L13;
        byte r5 = r10[r3];     // Catch: Throwable -> L15
        byte r6 = r10[r3 + 1];     // Catch: Throwable -> L15
        byte r7 = r10[r3 + 2];     // Catch: Throwable -> L15
        int r8 = (r5 >> 2) & 63;     // Catch: Throwable -> L15
        int r9 = ((r5 << 4) | (r6 >> 4)) & 63;     // Catch: Throwable -> L15
        String r11 = f22329a;     // Catch: Throwable -> L15
        r1.append(r11.charAt(r8));     // Catch: Throwable -> L15
        r1.append(r11.charAt(r9));     // Catch: Throwable -> L15
        r1.append(r11.charAt(((r6 << 2) | (r7 >> 6)) & 63));     // Catch: Throwable -> L15
        r1.append(r11.charAt(r7 & 63));     // Catch: Throwable -> L15
        r3 = r3 + 3;     // Catch: Throwable -> L15
        goto L11
    L13:
        String r12 = r1.toString();     // Catch: Throwable -> L15
        return r12.substring(0, r12.length() - r4.length()) + r4;
    L8:
        r4 = "";
    L15:
        return "";
    }

    public static String c(String r17) {
        if (r17 != null) goto L5;
        return r17;
    L5:
        if (r17.length() <= 0) goto L17;
        int r1 = 4 - (r17.length() % 4);
        if (r1 != 1) goto L10;
        String r2 = f22330b;
    L15:
        return r17.replaceAll((String) m.a(16777217, 0, 0, "1592bb", new byte[]{109}), (String) m.a(16777217, 0, 0, "c1e13e", new byte[]{57})).replaceAll((String) m.a(16777217, 0, 0, "ed563a", new byte[]{75}), (String) m.a(16777217, 0, 0, "ff3893", new byte[]{56})) + r2;
    L10:
        if (r1 == 2) goto L12;
        r2 = "";
        goto L15
    L12:
        r2 = (String) m.a(16777217, 0, 0, "73dfa7", new byte[]{123, 108});
        goto L15
    L17:
        return r17;
    }

    public static byte[] d(String r12) {
        int r1 = (r12.length() * 3) / 4;     // Catch: Throwable -> L18
        byte[] r2 = new byte[r1];     // Catch: Throwable -> L18
        int r3 = r12.length();     // Catch: Throwable -> L18
        String r4 = "";
        int r5 = 0;
    L6:
        if (r5 >= 2) goto L12;
        if (r12.charAt((r3 - 1) - r5) != f22330b.charAt(0)) goto L11;
        r4 = r4 + f22329a.charAt(0);     // Catch: Throwable -> L18
    L11:
        r5 = r5 + 1;     // Catch: Throwable -> L18
        goto L6
    L12:
        String r13 = r12.substring(0, r3 - r4.length()) + r4;     // Catch: Throwable -> L18
        int r6 = 0;
        int r7 = 0;
    L14:
        if (r6 >= r13.length()) goto L16;
        String r8 = f22329a;     // Catch: Throwable -> L18
        int r9 = r8.indexOf(r13.charAt(r6));     // Catch: Throwable -> L18
        int r10 = r8.indexOf(r13.charAt(r6 + 1));     // Catch: Throwable -> L18
        int r11 = r8.indexOf(r13.charAt(r6 + 2));     // Catch: Throwable -> L18
        int r14 = r8.indexOf(r13.charAt(r6 + 3));     // Catch: Throwable -> L18
        int r15 = ((r9 << 2) | (r10 >> 4)) & 255;     // Catch: Throwable -> L18
        r2[r7] = (byte) r15;     // Catch: Throwable -> L18
        r2[r7 + 1] = (byte) (((r10 << 4) | (r11 >> 2)) & 255);     // Catch: Throwable -> L18
        r2[r7 + 2] = (byte) ((r14 | (r11 << 6)) & 255);     // Catch: Throwable -> L18
        r6 = r6 + 4;     // Catch: Throwable -> L18
        r7 = r7 + 3;     // Catch: Throwable -> L18
        goto L14
    L16:
        return Arrays.copyOfRange(r2, 0, r1 - r4.length());
    L19:
        return new byte[0];
    }
}
