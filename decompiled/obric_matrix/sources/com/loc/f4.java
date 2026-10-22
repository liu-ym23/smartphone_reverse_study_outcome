package com.loc;

import android.content.Context;
import android.os.Handler;
import com.ttnet.org.chromium.net.NetError;

/* JADX INFO: loaded from: classes2.dex */
public final class f4 extends x3<i3> {
    public f4(Context r1, String r2, Handler r3) {
        super(r1, r2, r3);
    }

    private static String w(i3 r0) {
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.b();
    }

    private static void x(i3 r0, long r1) {
        if (r0 == null) goto L5;
        r0.f7378f = r1;
        return;
    }

    private static int y(i3 r0) {
        if (r0 != null) goto L6;
        return NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH;
    L6:
        return r0.f7375c;
    }

    private static long z(i3 r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.f7378f;
    }

    @Override // com.loc.x3
    final /* bridge */ /* synthetic */ void e(i3 r1, long r2) {
        x(r1, r2);
    }

    @Override // com.loc.x3
    final long h() {
        return v3.f7902a;
    }

    @Override // com.loc.x3
    public final /* synthetic */ String i(i3 r1) {
        return w(r1);
    }

    @Override // com.loc.x3
    final /* synthetic */ int l(i3 r1) {
        return y(r1);
    }

    @Override // com.loc.x3
    final long m() {
        return v3.f7903b;
    }

    @Override // com.loc.x3
    final /* synthetic */ long o(i3 r1) {
        return z(r1);
    }
}
