package com.bytedance.mobsec.metasec.ml;

import android.text.TextUtils;
import ms.bd.c.o;
import ms.bd.c.p2;

/* JADX INFO: loaded from: classes.dex */
public final class c implements p2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p2.a f5081a;

    c(p2.a r1) {
        this.f5081a = r1;
    }

    @Override // ms.bd.c.p2.a
    public void a(String r1) {
        this.f5081a.a(r1);
    }

    @Override // ms.bd.c.p2.a
    public void b(String r1) {
        this.f5081a.b(r1);
    }

    @Override // ms.bd.c.p2.a
    public void c(String r3) {
        String r0 = o.a().b();
        if (TextUtils.isEmpty(r0) == true) goto L5;
        this.f5081a.a(r0);
    L5:
        this.f5081a.c(r3);
    }

    @Override // ms.bd.c.p2.a
    public void d(String r1) {
        this.f5081a.d(r1);
    }

    @Override // ms.bd.c.p2.a
    public void e(String r1) {
        this.f5081a.e(r1);
    }
}
