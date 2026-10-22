package l.b.a.u2.f;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import l.b.a.e;
import l.b.a.h1;
import l.b.a.o;
import l.b.a.t;
import l.b.a.z;
import l.b.h.g;
import l.b.h.h.f;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static void a(StringBuffer r4, l.b.a.u2.b r5, Hashtable r6) {
        if (r5.q() == false) goto L12;
        l.b.a.u2.a[] r7 = r5.p();
        boolean r1 = true;
        int r2 = 0;
    L6:
        if (r2 == r7.length) goto L19;
        if (r1 == false) goto L9;
        r1 = false;
    L10:
        b(r4, r7[r2], r6);
        r2 = r2 + 1;
        goto L6
    L9:
        r4.append('+');
        goto L10
    L19:
        return;
    L12:
        if (r5.n() == null) goto L18;
        b(r4, r5.n(), r6);
        return;
    }

    public static void b(StringBuffer r1, l.b.a.u2.a r2, Hashtable r3) {
        String r4 = (String) r3.get(r2.o());
        if (r4 != null) goto L6;
        r4 = r2.o().A();
    L6:
        r1.append(r4);
        r1.append('=');
        r1.append(q(r2.p()));
    }

    private static boolean c(l.b.a.u2.a r4, l.b.a.u2.a r5) {
        if (r4 != r5) goto L6;
        return true;
    L6:
        if (r4 == null) goto L16;
        if (r5 == null) goto L16;
        if (r4.o().r(r5.o()) == true) goto L13;
        return false;
    L13:
        if (d(r4.p()).equals(d(r5.p())) == true) goto L15;
        return false;
    L15:
        return true;
    L16:
        return false;
    }

    public static String d(e r0) {
        return e(q(r0));
    }

    public static String e(String r7) {
        int r1 = 0;
        if (r7.length() > 0) goto L5;
    L9:
        String r8 = g.f(r7);
        int r0 = r8.length();
        if (r0 >= 2) goto L12;
        return r8;
    L12:
        int r2 = r0 - 1;
    L14:
        if (r1 >= r2) goto L20;
        if (r8.charAt(r1) != '\\') goto L20;
        if (r8.charAt(r1 + 1) != ' ') goto L20;
        r1 = r1 + 2;
    L20:
        int r4 = r1 + 1;
        int r5 = r2;
    L21:
        if (r5 <= r4) goto L27;
        if (r8.charAt(r5 - 1) != '\\') goto L27;
        if (r8.charAt(r5) != ' ') goto L27;
        r5 = r5 - 2;
    L27:
        if (r1 > 0) goto L29;
        if (r5 < r2) goto L29;
    L31:
        return l(r8);
    L29:
        r8 = r8.substring(r1, r5 + 1);
        goto L31
    L5:
        if (r7.charAt(0) != '#') goto L9;
        e r3 = h(r7);
        if ((r3 instanceof z) == false) goto L9;
        r7 = ((z) r3).c();
        goto L9
    }

    private static int f(char r2) {
        if ('0' > r2) goto L9;
        if (r2 > '9') goto L9;
        return r2 - '0';
    L9:
        if ('a' <= r2) goto L11;
    L15:
        int r3 = r2 - 'A';
    L14:
        return r3 + 10;
    L11:
        if (r2 > 'f') goto L15;
        r3 = r2 - 'a';
        goto L14
    }

    public static o g(String r3, Hashtable r4) {
        if (g.j(r3).startsWith("OID.") == false) goto L7;
        return new o(r3.substring(4));
    L7:
        if (r3.charAt(0) >= '0') goto L9;
    L12:
        o r5 = (o) r4.get(g.f(r3));
        if (r5 == null) goto L16;
        return r5;
    L16:
        throw new IllegalArgumentException("Unknown object id - " + r3 + " - passed to distinguished name");
    L9:
        if (r3.charAt(0) > '9') goto L12;
        return new o(r3);
    }

    private static t h(String r3) {
        return t.s(f.a(r3, 1, r3.length() - 1));
    L4:
        e = move-exception;
        throw new IllegalStateException("unknown encoding in name: " + e);
    }

    private static boolean i(char r1) {
        if ('0' > r1) goto L7;
        if (r1 > '9') goto L7;
    L14:
        return true;
    L7:
        if ('a' > r1) goto L11;
        if (r1 <= 'f') goto L14;
    L11:
        if ('A' <= r1) goto L13;
    L15:
        return false;
    L13:
        if (r1 > 'F') goto L15;
        goto L14
    }

    public static boolean j(l.b.a.u2.b r4, l.b.a.u2.b r5) {
        if (r4.size() == r5.size()) goto L5;
        return false;
    L5:
        l.b.a.u2.a[] r6 = r4.p();
        l.b.a.u2.a[] r7 = r5.p();
        if (r6.length == r7.length) goto L8;
        return false;
    L8:
        int r0 = 0;
    L10:
        if (r0 == r6.length) goto L15;
        if (c(r6[r0], r7[r0]) == false) goto L13;
        r0 = r0 + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }

    public static l.b.a.u2.b[] k(String r9, l.b.a.u2.e r10) {
        d r0 = new d(r9);
        l.b.a.u2.d r11 = new l.b.a.u2.d(r10);
    L4:
        if (r0.a() == false) goto L29;
        String r1 = r0.b();
        if (r1.indexOf(43) > 0) goto L7;
        d r2 = new d(r1, '=');
        String r3 = r2.b();
        if (r2.a() == false) goto L27;
        String r4 = r2.b();
        r11.d(r10.c(r3.trim()), o(r4));
        goto L4
    L27:
        throw new IllegalArgumentException("badly formatted directory string");
    L7:
        d r5 = new d(r1, '+');
        d r6 = new d(r5.b(), '=');
        String r7 = r6.b();
        if (r6.a() == false) goto L22;
        String r8 = r6.b();
        o r12 = r10.c(r7.trim());
        if (r5.a() == true) goto L11;
        r11.d(r12, o(r8));
        goto L4
    L11:
        Vector r13 = new Vector();
        Vector r14 = new Vector();
    L12:
        r13.addElement(r12);
        r14.addElement(o(r8));
        if (r5.a() == false) goto L19;
        d r15 = new d(r5.b(), '=');
        String r16 = r15.b();
        if (r15.a() == false) goto L18;
        r8 = r15.b();
        r12 = r10.c(r16.trim());
        goto L12
    L18:
        throw new IllegalArgumentException("badly formatted directory string");
    L19:
        r11.a(m(r13), n(r14));
        goto L4
    L22:
        throw new IllegalArgumentException("badly formatted directory string");
    L29:
        return r11.f().n();
    }

    public static String l(String r5) {
        if (r5.indexOf("  ") >= 0) goto L5;
        return r5;
    L5:
        StringBuffer r0 = new StringBuffer();
        char r1 = r5.charAt(0);
        r0.append(r1);
        int r2 = 1;
    L7:
        if (r2 >= r5.length()) goto L14;
        char r3 = r5.charAt(r2);
        if (r1 != ' ') goto L11;
        if (r3 != ' ') goto L11;
    L12:
        r2 = r2 + 1;
    L11:
        r0.append(r3);
        r1 = r3;
        goto L12
    L14:
        return r0.toString();
    }

    private static o[] m(Vector r4) {
        int r0 = r4.size();
        o[] r1 = new o[r0];
        int r2 = 0;
    L3:
        if (r2 == r0) goto L5;
        r1[r2] = (o) r4.elementAt(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    private static String[] n(Vector r4) {
        int r0 = r4.size();
        String[] r1 = new String[r0];
        int r2 = 0;
    L3:
        if (r2 == r0) goto L5;
        r1[r2] = (String) r4.elementAt(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    private static String o(String r13) {
        if (r13.length() == 0) goto L51;
        if (r13.indexOf(92) < 0) goto L7;
    L9:
        char[] r1 = r13.toCharArray();
        StringBuffer r3 = new StringBuffer(r13.length());
        if (r1[0] == '\\') goto L12;
    L14:
        int r4 = 0;
    L15:
        boolean r6 = false;
        int r7 = 0;
        boolean r8 = false;
        boolean r9 = false;
        char r10 = 0;
    L17:
        if (r4 == r1.length) goto L42;
        char r11 = r1[r4];
        if (r11 == ' ') goto L21;
        r9 = true;
    L21:
        if (r11 != '\"') goto L25;
        if (r6 == true) goto L39;
        r8 = !r8;
    L24:
        r6 = false;
    L40:
        r4 = r4 + 1;
    L39:
        r3.append(r11);
        goto L24
    L25:
        if (r11 != '\\') goto L29;
        if (r6 == true) goto L29;
        if (r8 == true) goto L29;
        r7 = r3.length();
        r6 = true;
    L29:
        if (r11 != ' ') goto L33;
        if (r6 == true) goto L33;
        if (r9 == false) goto L40;
    L33:
        if (r6 == false) goto L39;
        if (i(r11) == false) goto L39;
        if (r10 == 0) goto L38;
        r3.append((char) ((f(r10) * 16) + f(r11)));
        r6 = false;
        r10 = 0;
        goto L40
    L38:
        r10 = r11;
        goto L40
    L42:
        if (r3.length() <= 0) goto L49;
    L44:
        if (r3.charAt(r3.length() - 1) != ' ') goto L49;
        if (r7 == (r3.length() - 1)) goto L49;
        r3.setLength(r3.length() - 1);
    L49:
        return r3.toString();
    L12:
        if (r1[1] != '#') goto L14;
        r4 = 2;
        r3.append("\\#");
        goto L15
    L7:
        if (r13.indexOf(34) >= 0) goto L9;
    L51:
        return r13.trim();
    }

    public static e p(String r5, int r6) {
        int r0 = (r5.length() - r6) / 2;
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L3:
        if (r2 == r0) goto L6;
        int r3 = (r2 * 2) + r6;
        char r4 = r5.charAt(r3);
        char r7 = r5.charAt(r3 + 1);
        int r8 = f(r4) << 4;
        r1[r2] = (byte) (f(r7) | r8);
        r2 = r2 + 1;
        goto L3
    L6:
        return t.s(r1);
    }

    public static String q(e r8) {
        StringBuffer r0 = new StringBuffer();
        int r4 = 0;
        if ((r8 instanceof z) == true) goto L5;
    L49:
        r0.append('#');     // Catch: IOException -> L47
        r0.append(f.d(r8.b().m("DER")));     // Catch: IOException -> L47
    L13:
        int r9 = r0.length();
        int r6 = 2;
        if (r0.length() >= 2) goto L16;
    L20:
        r6 = 0;
    L22:
        if (r6 == r9) goto L34;
        char r2 = r0.charAt(r6);
        if (r2 == '\"') goto L32;
        if (r2 == '\\') goto L32;
        if (r2 == '+') goto L32;
        if (r2 == ',') goto L32;
        switch(r2) {
            case 59: goto L32;
            case 60: goto L32;
            case 61: goto L32;
            case 62: goto L32;
            default: goto L31;
        };
    L31:
        r6 = r6 + 1;
    L32:
        r0.insert(r6, "\\");
        r6 = r6 + 2;
        r9 = r9 + 1;
        goto L22
    L34:
        if (r0.length() > 0) goto L36;
    L40:
        int r10 = r0.length() - 1;
    L41:
        if (r10 < 0) goto L46;
        if (r0.charAt(r10) != ' ') goto L46;
        r0.insert(r10, '\\');
        r10 = r10 - 1;
    L46:
        return r0.toString();
    L36:
        if (r0.length() <= r4) goto L40;
        if (r0.charAt(r4) != ' ') goto L40;
        r0.insert(r4, "\\");
        r4 = r4 + 2;
        goto L36
    L16:
        if (r0.charAt(0) != '\\') goto L20;
        if (r0.charAt(1) != '#') goto L20;
    L48:
        throw new IllegalArgumentException("Other value has no encoded form");
    L5:
        if ((r8 instanceof h1) == true) goto L49;
        String r11 = ((z) r8).c();
        if (r11.length() > 0) goto L9;
    L11:
        r0.append(r11);
        goto L13
    L9:
        if (r11.charAt(0) != '#') goto L11;
        r0.append('\\');
        goto L11
    }
}
