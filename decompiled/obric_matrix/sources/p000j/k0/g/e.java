package p000j.k0.g;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import k.h;
import p000j.f0;
import p000j.m;
import p000j.o;
import p000j.v;
import p000j.w;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h f17877a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f17878b = null;

    static {
        f17877a = h.k("\"\\");
        f17878b = h.k("\t ,=");
    }

    public static long a(v r2) {
        return o(r2.d("Content-Length"));
    }

    public static long b(f0 r2) {
        return a(r2.F());
    }

    public static boolean c(f0 r8) {
        if (r8.Y().f().equals("HEAD") == false) goto L5;
        return false;
    L5:
        int r0 = r8.s();
        if (r0 < 100) goto L10;
        if (r0 >= 200) goto L10;
    L15:
        if (b(r8) == (-1)) goto L17;
    L20:
        return true;
    L17:
        if ("chunked".equalsIgnoreCase(r8.A("Transfer-Encoding")) == true) goto L20;
        return false;
    L10:
        if (r0 == 204) goto L15;
        if (r0 == 304) goto L15;
        return true;
    }

    private static void d(List<p000j.h> r8, k.e r9) {
    L3:
        String r1 = null;
    L4:
        if (r1 != null) goto L8;
        n(r9);
        r1 = h(r9);
        if (r1 != null) goto L8;
        return;
    L8:
        boolean r2 = n(r9);
        String r3 = h(r9);
        if (r3 == null) goto L11;
        int r5 = k(r9, (byte) 61);
        boolean r6 = n(r9);
        if (r2 == true) goto L21;
        if (r6 == true) goto L20;
        if (r9.v() == false) goto L21;
    L20:
        r8.add(new p000j.h(r1, Collections.singletonMap(null, r3 + j('=', r5))));
    L21:
        LinkedHashMap r4 = new LinkedHashMap();
        int r7 = r5 + k(r9, (byte) 61);
    L22:
        if (r3 != null) goto L27;
        r3 = h(r9);
        if (n(r9) == true) goto L28;
        r7 = k(r9, (byte) 61);
    L28:
        r8.add(new p000j.h(r1, r4));
        r1 = r3;
    L27:
        if (r7 == 0) goto L28;
        if (r7 > 1) goto L31;
        if (n(r9) == true) goto L34;
        if (r9.v() == false) goto L38;
    L40:
        String r10 = h(r9);
    L41:
        if (r10 == null) goto L42;
        if (((String) r4.put(r3, r10)) != null) goto L45;
        if (n(r9) == true) goto L51;
        if (r9.v() == true) goto L51;
        return;
    L51:
        r3 = null;
        goto L22
    L45:
        return;
    L42:
        return;
    L38:
        if (r9.O(0) != 34) goto L40;
        r10 = g(r9);
        goto L41
    L34:
        return;
    L31:
        return;
    L11:
        if (r9.v() == true) goto L13;
        return;
    L13:
        r8.add(new p000j.h(r1, Collections.emptyMap()));
    }

    public static List<p000j.h> e(v r4, String r5) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r4.k()) goto L9;
        if (r5.equalsIgnoreCase(r4.f(r1)) == false) goto L8;
        k.e r2 = new k.e();
        r2.B0(r4.m(r1));
        d(r0, r2);
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    public static int f(String r2, int r3) {
        long r4 = Long.parseLong(r2);     // Catch: NumberFormatException -> L13
        if (r4 <= 2147483647L) goto L8;
        return Integer.MAX_VALUE;
    L8:
        if (r4 >= 0) goto L12;
        return 0;
    L12:
        return (int) r4;
    L13:
        return r3;
    }

    private static String g(k.e r12) {
        if (r12.readByte() != 34) goto L17;
        k.e r0 = new k.e();
    L5:
        long r2 = r12.S(f17877a);
        if (r2 == (-1)) goto L7;
        if (r12.O(r2) == 34) goto L10;
        if (r12.k0() == (r2 + 1)) goto L14;
        r0.J(r12, r2);
        r12.readByte();
        r0.J(r12, 1);
        goto L5
    L14:
        return null;
    L10:
        r0.J(r12, r2);
        r12.readByte();
        return r0.i0();
    L7:
        return null;
    L17:
        throw new IllegalArgumentException();
    }

    private static String h(k.e r4) {
        long r0 = r4.S(f17878b);     // Catch: EOFException -> L11
        if (r0 != (-1)) goto L6;
        r0 = r4.k0();     // Catch: EOFException -> L11
    L6:
        if (r0 == 0) goto L9;
        return r4.m(r0);
    L9:
        return null;
    L12:
        throw new AssertionError();
    }

    public static void i(o r1, w r2, v r3) {
        if (r1 != o.f18176a) goto L5;
        return;
    L5:
        List<m> r4 = m.f(r2, r3);
        if (r4.isEmpty() == false) goto L8;
        return;
    L8:
        r1.a(r2, r4);
    }

    private static String j(char r0, int r1) {
        char[] r2 = new char[r1];
        Arrays.fill(r2, r0);
        return new String(r2);
    }

    private static int k(k.e r3, byte r4) {
        int r0 = 0;
    L4:
        if (r3.v() == true) goto L8;
        if (r3.O(0) != r4) goto L8;
        r0 = r0 + 1;
        r3.readByte();
    L8:
        return r0;
    }

    public static int l(String r2, int r3, String r4) {
    L3:
        if (r3 >= r2.length()) goto L8;
        if (r4.indexOf(r2.charAt(r3)) != (-1)) goto L8;
        r3 = r3 + 1;
    L8:
        return r3;
    }

    public static int m(String r2, int r3) {
    L3:
        if (r3 >= r2.length()) goto L10;
        char r0 = r2.charAt(r3);
        if (r0 == ' ') goto L9;
        if (r0 != '\t') goto L10;
    L9:
        r3 = r3 + 1;
    L10:
        return r3;
    }

    private static boolean n(k.e r3) {
        boolean r0 = false;
    L4:
        if (r3.v() == true) goto L13;
        byte r1 = r3.O(0);
        if (r1 == 44) goto L7;
        if (r1 != 32) goto L11;
    L12:
        r3.readByte();
        goto L4
    L11:
        if (r1 != 9) goto L13;
    L7:
        r3.readByte();
        r0 = true;
    L13:
        return r0;
    }

    private static long o(String r2) {
        if (r2 != null) goto L8;
        return -1;
    L8:
        return Long.parseLong(r2);
    L10:
        return -1;
    }
}
