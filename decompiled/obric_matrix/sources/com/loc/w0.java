package com.loc;

import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 {
    public static int a(v0 r10) {
        l0 r2 = null;
    L42:
        th = th;
    L58:
        v.m(th, "leg", "uts");     // Catch: Throwable -> L47
        if (r2 == null) goto L46;
        r2.close();     // Catch: Throwable -> L40
    L65:
    L46:
        return -1;
    L47:
        th = move-exception;
        if (r2 != null) goto L63;
    L53:
        throw th;
    L63:
        r2.close();     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        th.printStackTrace();
        goto L53
    L4:
        if (r10.f7885f.e() == false) goto L37;
        r10.f7885f.b(true);     // Catch: Throwable -> L42
        l0 r3 = l0.b(new File(r10.f7880a), r10.f7881b);     // Catch: Throwable -> L42
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L35
        byte[] r6 = e(r3, r10, r5);     // Catch: Throwable -> L35
        if (r6 != null) goto L9;
    L54:
        r3.close();     // Catch: Throwable -> L32
    L34:
        return -1;
    L32:
        th = move-exception;
        th.printStackTrace();
        goto L34
    L9:
        if (r6.length == 0) goto L54;
        u r7 = new u(r6, r10.f7882c);     // Catch: Throwable -> L35
        o0.b();     // Catch: Throwable -> L35
        JSONObject r8 = new JSONObject(new String(o0.c(r7).f7856a));     // Catch: Throwable -> L35
        if (r8.has("code") == true) goto L14;
    L29:
        r2 = r3;
        goto L37
    L14:
        if (r8.getInt("code") != 1) goto L29;
        o1 r0 = r10.f7885f;     // Catch: Throwable -> L35
        if (r0 == null) goto L20;
        if (r6 == null) goto L20;
        r0.a(r6.length);     // Catch: Throwable -> L35
    L20:
        if (r10.f7885f.d() >= Integer.MAX_VALUE) goto L56;
        b(r3, r5);     // Catch: Throwable -> L35
    L27:
        return r6.length;
    L56:
        r3.Y();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        v.m(th, "ofm", "dlo");     // Catch: Throwable -> L35
    L35:
        th = th;
        r2 = r3;
    L37:
        if (r2 == null) goto L46;
        r2.close();     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        th.printStackTrace();
        goto L46
    }

    private static void b(l0 r1, List<String> r2) {
        if (r1 == null) goto L15;
        Iterator<String> r3 = r2.iterator();     // Catch: Throwable -> L9
    L5:
        if (r3.hasNext() == false) goto L7;
        r1.V(r3.next());     // Catch: Throwable -> L9
        goto L5
    L7:
        r1.close();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        v.m(th, "ofm", "dlo");
        return;
    }

    public static void c(String r4, byte[] r5, v0 r6) {
        OutputStream r0 = null;
    L23:
        th = th;
        l0 r1 = null;
    L25:
        if (r0 != null) goto L42;
    L30:
        if (r1 == null) goto L48;
        r1.close();     // Catch: Throwable -> L33
        throw th;
    L33:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L48:
        throw th;
    L42:
        r0.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.printStackTrace();
        goto L30
    L4:
        if (d(r6.f7880a, r4) == false) goto L6;
        return;
    L6:
        File r2 = new File(r6.f7880a);     // Catch: Throwable -> L23
        if (r2.exists() == true) goto L9;
        r2.mkdirs();     // Catch: Throwable -> L23
    L9:
        r1 = l0.b(r2, r6.f7881b);     // Catch: Throwable -> L23
        r1.s(r6.f7883d);     // Catch: Throwable -> L21
        byte[] r7 = r6.f7884e.b(r5);     // Catch: Throwable -> L21
        l0.d r8 = r1.L(r4);     // Catch: Throwable -> L21
        r0 = r8.b();     // Catch: Throwable -> L21
        r0.write(r7);     // Catch: Throwable -> L21
        r8.c();     // Catch: Throwable -> L21
        r1.Q();     // Catch: Throwable -> L21
        if (r0 == null) goto L44;
        r0.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.printStackTrace();
    L44:
        r1.close();     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L21:
        th = th;
        goto L25
    }

    private static boolean d(String r2, String r3) {
        return new File(r2, r3 + ".0").exists();
    L4:
        th = move-exception;
        v.m(th, "leg", "fet");
        return false;
    }

    private static byte[] e(l0 r8, v0 r9, List<String> r10) {
        File r1 = r8.M();     // Catch: Throwable -> L20
        if (r1 == null) goto L23;
        if (r1.exists() == false) goto L23;
        String[] r2 = r1.list();     // Catch: Throwable -> L20
        int r3 = r2.length;     // Catch: Throwable -> L20
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r4 >= r3) goto L15;
        String r6 = r2[r4];     // Catch: Throwable -> L20
        if (r6.contains(".0") == false) goto L14;
        String r7 = r6.split("\\.")[0];     // Catch: Throwable -> L20
        byte[] r11 = b1.f(r8, r7);     // Catch: Throwable -> L20
        r5 = r5 + r11.length;     // Catch: Throwable -> L20
        r10.add(r7);     // Catch: Throwable -> L20
        if (r5 > r9.f7885f.d()) goto L15;
        r9.f7886g.c(r11);     // Catch: Throwable -> L20
    L14:
        r4 = r4 + 1;     // Catch: Throwable -> L20
    L15:
        if (r5 > 0) goto L18;
        return null;
    L18:
        return r9.f7886g.a();
    L23:
        return new byte[0];
    L20:
        th = move-exception;
        v.m(th, "leg", "gCo");
        goto L23
    }
}
