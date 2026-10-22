package com.loc;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p0 extends o5 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected Context f7589l;
    protected t5 m;
    protected byte[] n;

    public p0(Context r1, t5 r2) {
        if (r1 == null) goto L5;
        this.f7589l = r1.getApplicationContext();
    L5:
        this.m = r2;
        A();
    }

    private static byte[] J() {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        r2.write(u5.o("PANDORA$"));     // Catch: Throwable -> L9
        r2.write(new byte[]{1});     // Catch: Throwable -> L9
        r2.write(new byte[]{0});     // Catch: Throwable -> L9
        byte[] r3 = r2.toByteArray();     // Catch: Throwable -> L9
        r2.close();     // Catch: Throwable -> L6
    L8:
        return r3;
    L6:
        th = move-exception;
        s.e(th, "bre", "gbh");
    L9:
        th = move-exception;
        s.e(th, "bre", "gbh");     // Catch: Throwable -> L17
        r2.close();     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        s.e(th, "bre", "gbh");
        return null;
    L17:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L20
    L22:
        throw th;
    L20:
        th = move-exception;
        s.e(th, "bre", "gbh");
        goto L22
    }

    private byte[] K() {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        r2.write(new byte[]{3});     // Catch: Throwable -> L31
        if (R() == false) goto L12;
        Context r5 = this.f7589l;     // Catch: Throwable -> L31
        boolean r7 = T();     // Catch: Throwable -> L31
        t5 r8 = this.m;     // Catch: Throwable -> L31
        if (r8 != null) goto L8;
    L10:
        boolean r9 = false;
    L11:
        byte[] r6 = k5.f(r5, r7, r9);     // Catch: Throwable -> L31
        r2.write(N(r6));     // Catch: Throwable -> L31
        r2.write(r6);     // Catch: Throwable -> L31
    L13:
        byte[] r10 = u5.o(Q());     // Catch: Throwable -> L31
        if (r10 != null) goto L16;
    L18:
        r2.write(new byte[]{0, 0});     // Catch: Throwable -> L31
    L19:
        byte[] r11 = u5.o(S());     // Catch: Throwable -> L31
        if (r11 != null) goto L22;
    L24:
        r2.write(new byte[]{0, 0});     // Catch: Throwable -> L31
    L25:
        byte[] r12 = r2.toByteArray();     // Catch: Throwable -> L31
        r2.close();     // Catch: Throwable -> L28
    L30:
        return r12;
    L28:
        th = move-exception;
        s.e(th, "bre", "gred");
        goto L30
    L22:
        if (r11.length <= 0) goto L24;
        r2.write(N(r11));     // Catch: Throwable -> L31
        r2.write(r11);     // Catch: Throwable -> L31
        goto L25
    L16:
        if (r10.length <= 0) goto L18;
        r2.write(N(r10));     // Catch: Throwable -> L31
        r2.write(r10);     // Catch: Throwable -> L31
        goto L19
    L8:
        if ("navi".equals(r8.a()) == false) goto L10;
        r9 = true;
        goto L11
    L12:
        r2.write(new byte[]{0, 0});     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        s.e(th, "bre", "gpd");     // Catch: Throwable -> L39
        r2.close();     // Catch: Throwable -> L35
    L38:
        return new byte[]{0};
    L35:
        th = move-exception;
        s.e(th, "bre", "gred");
    L39:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L42
    L44:
        throw th;
    L42:
        th = move-exception;
        s.e(th, "bre", "gred");
        goto L44
    }

    private byte[] L() {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        byte[] r6 = O();     // Catch: Throwable -> L20
        if (r6 != null) goto L6;
    L14:
        r2.write(new byte[]{0});     // Catch: Throwable -> L20
        byte[] r7 = r2.toByteArray();     // Catch: Throwable -> L20
        r2.close();     // Catch: Throwable -> L17
    L19:
        return r7;
    L17:
        th = move-exception;
        s.e(th, "bre", "grrd");
        goto L19
    L6:
        if (r6.length == 0) goto L14;
        r2.write(new byte[]{1});     // Catch: Throwable -> L20
        r2.write(N(r6));     // Catch: Throwable -> L20
        r2.write(r6);     // Catch: Throwable -> L20
        byte[] r8 = r2.toByteArray();     // Catch: Throwable -> L20
        r2.close();     // Catch: Throwable -> L11
    L13:
        return r8;
    L11:
        th = move-exception;
        s.e(th, "bre", "grrd");
    L20:
        th = move-exception;
        s.e(th, "bre", "grrd");     // Catch: Throwable -> L28
        r2.close();     // Catch: Throwable -> L24
    L27:
        return new byte[]{0};
    L24:
        th = move-exception;
        s.e(th, "bre", "grrd");
    L28:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L31
    L33:
        throw th;
    L31:
        th = move-exception;
        s.e(th, "bre", "grrd");
        goto L33
    }

    private byte[] M() {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        byte[] r6 = P();     // Catch: Throwable -> L20
        if (r6 != null) goto L6;
    L14:
        r2.write(new byte[]{0});     // Catch: Throwable -> L20
        byte[] r7 = r2.toByteArray();     // Catch: Throwable -> L20
        r2.close();     // Catch: Throwable -> L17
    L19:
        return r7;
    L17:
        th = move-exception;
        s.e(th, "bre", "gred");
        goto L19
    L6:
        if (r6.length == 0) goto L14;
        r2.write(new byte[]{1});     // Catch: Throwable -> L20
        byte[] r8 = k5.g(r6);     // Catch: Throwable -> L20
        r2.write(N(r8));     // Catch: Throwable -> L20
        r2.write(r8);     // Catch: Throwable -> L20
        byte[] r9 = r2.toByteArray();     // Catch: Throwable -> L20
        r2.close();     // Catch: Throwable -> L11
    L13:
        return r9;
    L11:
        th = move-exception;
        s.e(th, "bre", "gred");
    L20:
        th = move-exception;
        s.e(th, "bre", "gred");     // Catch: Throwable -> L28
        r2.close();     // Catch: Throwable -> L24
    L27:
        return new byte[]{0};
    L24:
        th = move-exception;
        s.e(th, "bre", "gred");
    L28:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L31
    L33:
        throw th;
    L31:
        th = move-exception;
        s.e(th, "bre", "gred");
        goto L33
    }

    protected static byte[] N(byte[] r0) {
        return u5.n(r0.length);
    }

    public abstract byte[] O();

    public abstract byte[] P();

    protected String Q() {
        return "2.1";
    }

    public boolean R() {
        return true;
    }

    public String S() {
        return String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{this.m.f(), this.m.a()});
    }

    protected boolean T() {
        return false;
    }

    @Override // com.loc.t0
    public final byte[] q() {
        byte[] r2 = this.n;
        if (r2 == null) goto L5;
        return r2;
    L5:
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();
        r3.write(J());     // Catch: Throwable -> L12
        r3.write(K());     // Catch: Throwable -> L12
        r3.write(L());     // Catch: Throwable -> L12
        r3.write(M());     // Catch: Throwable -> L12
        byte[] r4 = r3.toByteArray();     // Catch: Throwable -> L12
        this.n = r4;     // Catch: Throwable -> L12
        r3.close();     // Catch: Throwable -> L9
    L11:
        return r4;
    L9:
        th = move-exception;
        s.e(th, "bre", "geb");
    L12:
        th = move-exception;
        s.e(th, "bre", "geb");     // Catch: Throwable -> L20
        r3.close();     // Catch: Throwable -> L16
        return null;
    L16:
        th = move-exception;
        s.e(th, "bre", "geb");
        return null;
    L20:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L23
    L25:
        throw th;
    L23:
        th = move-exception;
        s.e(th, "bre", "geb");
        goto L25
    }

    @Override // com.loc.t0
    public Map<String, String> r() {
        String r0 = i5.j(this.f7589l);
        String r1 = k5.a();
        String r4 = k5.c(this.f7589l, r1, "key=".concat(String.valueOf(r0)));
        HashMap r2 = new HashMap();
        r2.put("ts", r1);
        r2.put("key", r0);
        r2.put("scode", r4);
        return r2;
    }
}
