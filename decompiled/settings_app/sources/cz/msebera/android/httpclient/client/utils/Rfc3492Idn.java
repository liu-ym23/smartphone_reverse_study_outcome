package cz.msebera.android.httpclient.client.utils;

import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class Rfc3492Idn implements Idn {
    private static final String ACE_PREFIX = "xn--";
    private static final int base = 36;
    private static final int damp = 700;
    private static final char delimiter = '-';
    private static final int initial_bias = 72;
    private static final int initial_n = 128;
    private static final int skew = 38;
    private static final int tmax = 26;
    private static final int tmin = 1;

    public Rfc3492Idn() {
    }

    private int adapt(int r1, int r2, boolean r3) {
        if (r3 == false) goto L4;
        int r4 = r1 / 700;
    L5:
        int r5 = r4 + (r4 / r2);
        int r0 = 0;
    L7:
        if (r5 <= 455) goto L10;
        r5 = r5 / 35;
        r0 = r0 + 36;
        goto L7
    L10:
        return r0 + ((r5 * 36) / (r5 + 38));
    L4:
        r4 = r1 / 2;
        goto L5
    }

    private int digit(char r3) {
        if (r3 < 'A') goto L9;
        if (r3 > 'Z') goto L9;
        return r3 - 'A';
    L9:
        if (r3 < 'a') goto L15;
        if (r3 > 'z') goto L15;
        return r3 - 'a';
    L15:
        if (r3 < '0') goto L21;
        if (r3 > '9') goto L21;
        return (r3 - '0') + 26;
    L21:
        throw new IllegalArgumentException("illegal digit: " + r3);
    }

    @Override // cz.msebera.android.httpclient.client.utils.Idn
    public String toUnicode(String r4) {
        StringBuilder r0 = new StringBuilder(r4.length());
        StringTokenizer r1 = new StringTokenizer(r4, ".");
    L4:
        if (r1.hasMoreTokens() == false) goto L13;
        String r5 = r1.nextToken();
        if (r0.length() <= 0) goto L9;
        r0.append('.');
    L9:
        if (r5.startsWith(ACE_PREFIX) == false) goto L11;
        r5 = decode(r5.substring(4));
    L11:
        r0.append(r5);
        goto L4
    L13:
        return r0.toString();
    }

    protected String decode(String r12) {
        StringBuilder r0 = new StringBuilder(r12.length());
        int r1 = r12.lastIndexOf(45);
        int r4 = 128;
        int r6 = 72;
        if (r1 == (-1)) goto L5;
        r0.append(r12.subSequence(0, r1));
        r12 = r12.substring(r1 + 1);
    L5:
        int r2 = 0;
    L7:
        if (r12.isEmpty() == true) goto L27;
        int r3 = 36;
        int r7 = r2;
        int r8 = 1;
    L10:
        if (r12.isEmpty() == true) goto L20;
        char r9 = r12.charAt(0);
        r12 = r12.substring(1);
        int r10 = digit(r9);
        r7 = r7 + (r10 * r8);
        if (r3 > (r6 + 1)) goto L16;
        int r11 = 1;
    L19:
        if (r10 < r11) goto L20;
        r8 = r8 * (36 - r11);
        r3 = r3 + 36;
        goto L10
    L16:
        if (r3 < (r6 + 26)) goto L18;
        r11 = 26;
        goto L19
    L18:
        r11 = r3 - r6;
    L20:
        int r5 = r7 - r2;
        int r13 = r0.length() + 1;
        if (r2 != 0) goto L23;
        boolean r14 = true;
    L24:
        r6 = adapt(r5, r13, r14);
        r4 = r4 + (r7 / (r0.length() + 1));
        int r15 = r7 % (r0.length() + 1);
        r0.insert(r15, (char) r4);
        r2 = r15 + 1;
        goto L7
    L23:
        r14 = false;
        goto L24
    L27:
        return r0.toString();
    }
}
