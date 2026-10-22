package com.ss.android.i;

import android.text.TextUtils;
import com.ss.android.ug.bus.UgCallbackCenter;

/* JADX INFO: loaded from: classes2.dex */
public class b implements com.ss.android.ug.bus.c.a, d.b.s.a.q.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile b f11871h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f11873g;

    static {
    }

    private b() {
        this.f11872f = false;
        this.f11873g = "";
        com.bytedance.sdk.account.impl.g.d(j.k().e()).b(this);
        String r0 = b();
        this.f11873g = r0;
        this.f11872f = !TextUtils.isEmpty(r0);
    }

    public static b M() {
        if (f11871h != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11871h != null) goto L9;
        f11871h = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f11871h;
    }

    @Override // d.b.s.a.q.c
    public void F(d.b.s.a.q.b r2) {
        int r3 = r2.f14879a;
        if (r3 != 1) goto L5;
    L11:
        p0();
        return;
    L5:
        if (r3 == 2) goto L11;
        if (this.f11872f == true) goto L10;
        o0(b());
        return;
    L10:
        q0(b());
    }

    @Override // com.ss.android.ug.bus.c.a
    public String b() {
        return com.bytedance.sdk.account.impl.g.d(j.k().e()).k();
    }

    public void o0(String r2) {
        if (this.f11872f == false) goto L5;
        return;
    L5:
        UgCallbackCenter.b(new com.ss.android.ug.bus.c.b.a(r2));
        this.f11873g = r2;
        this.f11872f = true;
    }

    public void p0() {
        this.f11872f = false;
        this.f11873g = "";
        UgCallbackCenter.b(new com.ss.android.ug.bus.c.b.b());
    }

    public void q0(String r2) {
        if (this.f11873g.equals(r2) == false) goto L5;
        return;
    L5:
        this.f11873g = r2;
        UgCallbackCenter.b(new com.ss.android.ug.bus.c.b.c(r2));
    }
}
