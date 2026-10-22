package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class o4 extends p0 {
    Map<String, String> o;
    private String p;
    String q;
    String r;
    byte[] s;
    byte[] t;
    boolean u;
    String v;
    Map<String, String> w;
    boolean x;

    public o4(Context r1, t5 r2) {
        super(r1, r2);
        this.o = null;
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = null;
        this.t = null;
        this.u = false;
        this.v = null;
        this.w = null;
        this.x = false;
    }

    @Override // com.loc.p0
    public final byte[] O() {
        return this.s;
    }

    @Override // com.loc.p0
    public final byte[] P() {
        return this.t;
    }

    @Override // com.loc.p0
    public final boolean R() {
        return this.u;
    }

    @Override // com.loc.p0
    public final String S() {
        return this.v;
    }

    @Override // com.loc.p0
    protected final boolean T() {
        return this.x;
    }

    public final void U(Map<String, String> r1) {
        this.w = r1;
    }

    public final void V(String r1) {
        this.v = r1;
    }

    public final void W(Map<String, String> r1) {
        this.o = r1;
    }

    public final void X(boolean r1) {
        this.u = r1;
    }

    public final void Y(byte[] r3) {
        ByteArrayOutputStream r0 = null;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L14
        if (r3 != null) goto L31;
    L6:
        this.t = r1.toByteArray();     // Catch: Throwable -> L12
        r1.close();     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L12:
        th = th;
        r0 = r1;
    L33:
        th.printStackTrace();     // Catch: Throwable -> L22
        if (r0 == null) goto L41;
        r0.close();     // Catch: IOException -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L41:
        return;
    L22:
        th = move-exception;
        if (r0 != null) goto L29;
    L28:
        throw th;
    L29:
        r0.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L31:
        r1.write(p0.N(r3));     // Catch: Throwable -> L12
        r1.write(r3);     // Catch: Throwable -> L12
    L14:
        th = th;
        goto L33
    }

    public final void Z(String r1) {
        this.q = r1;
    }

    public final void a0(boolean r1) {
        this.x = r1;
    }

    @Override // com.loc.t0
    public final Map<String, String> b() {
        return this.o;
    }

    public final void b0(byte[] r1) {
        this.s = r1;
    }

    public final void c0(String r1) {
        this.r = r1;
    }

    public final void d0(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.p = r2;
        return;
    L6:
        this.p = "";
    }

    @Override // com.loc.t0
    public final String j() {
        return this.q;
    }

    @Override // com.loc.o5, com.loc.t0
    public final String m() {
        return this.r;
    }

    @Override // com.loc.t0
    public final String p() {
        return "loc";
    }

    @Override // com.loc.p0, com.loc.t0
    public final Map<String, String> r() {
        return this.w;
    }

    @Override // com.loc.t0
    public final String s() {
        return this.p;
    }
}
