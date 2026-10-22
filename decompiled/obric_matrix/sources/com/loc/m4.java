package com.loc;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class m4 extends o5 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Map<String, String> f7557l;
    Map<String, String> m;
    String n;
    byte[] o;
    private String p;

    public m4() {
        this.f7557l = null;
        this.m = null;
        this.n = "";
        this.o = null;
        this.p = null;
    }

    public final void J(Map<String, String> r1) {
        this.f7557l = r1;
    }

    public final void K(byte[] r1) {
        this.o = r1;
    }

    public final void L(String r1) {
        this.n = r1;
    }

    public final void M(String r1) {
        this.p = r1;
    }

    @Override // com.loc.t0
    public final Map<String, String> b() {
        return this.f7557l;
    }

    @Override // com.loc.t0
    public final String j() {
        return this.n;
    }

    @Override // com.loc.o5, com.loc.t0
    public final String m() {
        if (TextUtils.isEmpty(this.p) == true) goto L7;
        return this.p;
    L7:
        return super.m();
    }

    @Override // com.loc.t0
    public final byte[] q() {
        return this.o;
    }

    @Override // com.loc.t0
    public final Map<String, String> r() {
        return this.m;
    }
}
