package kotlin.s0.w.d.l0.o.u;

import java.util.Iterator;
import java.util.Locale;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final String a(String r4) {
        o.f(r4, "<this>");
        boolean r2 = false;
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r4;
    L8:
        char r1 = r4.charAt(0);
        if ('a' <= r1) goto L11;
    L13:
        if (r2 == false) goto L16;
        char r3 = Character.toUpperCase(r1);
        String r5 = r4.substring(1);
        o.e(r5, "this as java.lang.String).substring(startIndex)");
        return r3 + r5;
    L16:
        return r4;
    L11:
        if (r1 >= '{') goto L13;
        r2 = true;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public static final String b(String r4) {
        o.f(r4, "<this>");
        boolean r2 = false;
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r4;
    L8:
        char r1 = r4.charAt(0);
        if ('A' <= r1) goto L11;
    L13:
        if (r2 == false) goto L16;
        char r3 = Character.toLowerCase(r1);
        String r5 = r4.substring(1);
        o.e(r5, "this as java.lang.String).substring(startIndex)");
        return r3 + r5;
    L16:
        return r4;
    L11:
        if (r1 >= '[') goto L13;
        r2 = true;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public static final String c(String r6, boolean r7) {
        o.f(r6, "<this>");
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r6;
    L8:
        if (d(r6, 0, r7) == true) goto L11;
        return r6;
    L11:
        if (r6.length() != 1) goto L13;
    L28:
        if (r7 == false) goto L31;
        return b(r6);
    L31:
        if (r6.length() <= 0) goto L33;
        boolean r8 = true;
    L34:
        if (r8 == false) goto L42;
        char r9 = Character.toLowerCase(r6.charAt(0));
        String r10 = r6.substring(1);
        o.e(r10, "this as java.lang.String).substring(startIndex)");
        return r9 + r10;
    L42:
        return r6;
    L33:
        r8 = false;
        goto L34
    L13:
        if (d(r6, 1, r7) == false) goto L28;
        Iterator<Integer> r1 = k.J(r6).iterator();
    L17:
        if (r1.hasNext() == false) goto L21;
        Integer r4 = r1.next();
        if ((!d(r6, r4.intValue(), r7)) == false) goto L17;
    L22:
        Integer r5 = r4;
        if (r5 == null) goto L27;
        int r2 = r5.intValue() - 1;
        StringBuilder r3 = new StringBuilder();
        String r11 = r6.substring(0, r2);
        o.e(r11, "this as java.lang.String…ing(startIndex, endIndex)");
        r3.append(e(r11, r7));
        String r12 = r6.substring(r2);
        o.e(r12, "this as java.lang.String).substring(startIndex)");
        r3.append(r12);
        return r3.toString();
    L27:
        return e(r6, r7);
    L21:
        r4 = null;
        goto L22
    L5:
        r0 = false;
        goto L6
    }

    private static final boolean d(String r0, int r1, boolean r2) {
        char r3 = r0.charAt(r1);
        if (r2 == false) goto L10;
        if ('A' <= r3) goto L7;
        return false;
    L7:
        if (r3 >= '[') goto L12;
        return true;
    L12:
        return false;
    L10:
        return Character.isUpperCase(r3);
    }

    private static final String e(String r0, boolean r1) {
        if (r1 == true) goto L6;
        String r2 = r0.toLowerCase(Locale.ROOT);
        o.e(r2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return r2;
    L6:
        return f(r0);
    }

    public static final String f(String r6) {
        o.f(r6, "<this>");
        StringBuilder r0 = new StringBuilder(r6.length());
        int r1 = r6.length();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L13;
        char r4 = r6.charAt(r3);
        if ('A' <= r4) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L12;
        r4 = Character.toLowerCase(r4);
    L12:
        r0.append(r4);
        r3 = r3 + 1;
        goto L3
    L7:
        if (r4 >= '[') goto L9;
        r5 = true;
        goto L10
    L13:
        String r7 = r0.toString();
        o.e(r7, "builder.toString()");
        return r7;
    }
}
