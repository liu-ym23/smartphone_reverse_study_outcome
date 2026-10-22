package com.loc;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public final class z3 extends x3<b4> {
    public z3(Context r1, String r2, Handler r3) {
        super(r1, r2, r3);
    }

    private static String w(b4 r0) {
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.b();
    }

    private static void x(b4 r0, long r1) {
        if (r0 == null) goto L5;
        r0.t = r1;
        return;
    }

    private static int y(b4 r0) {
        if (r0 != null) goto L6;
        return 99;
    L6:
        return r0.s;
    }

    private static long z(b4 r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.t;
    }

    @Override // com.loc.x3
    final /* bridge */ /* synthetic */ void e(b4 r1, long r2) {
        x(r1, r2);
    }

    @Override // com.loc.x3
    final long h() {
        return v3.f7904c;
    }

    @Override // com.loc.x3
    public final /* synthetic */ String i(b4 r1) {
        return w(r1);
    }

    @Override // com.loc.x3
    final /* synthetic */ int l(b4 r1) {
        return y(r1);
    }

    @Override // com.loc.x3
    final long m() {
        return v3.f7905d;
    }

    @Override // com.loc.x3
    final /* synthetic */ long o(b4 r1) {
        return z(r1);
    }
}
