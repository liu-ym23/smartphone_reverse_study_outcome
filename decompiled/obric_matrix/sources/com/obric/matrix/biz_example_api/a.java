package com.obric.matrix.biz_example_api;

import com.obric.matrix.q.b.d;
import com.obric.matrix.u.b;
import com.obric.matrix.w.b0;

/* JADX INFO: loaded from: classes2.dex */
public class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f8902a;

    public a() {
    }

    public static d b() {
        if (f8902a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8902a != null) goto L9;
        f8902a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f8902a;
    }

    @Override // com.obric.matrix.q.b.d
    public f.a.a<b> a(int r1, b0 r2, com.obric.matrix.platform.e.b r3) {
        if (r1 == 100000) goto L7;
        return null;
    L7:
        return ((IBizExample) com.bytedance.news.common.service.manager.d.a(IBizExample.class)).testFun(r2);
    }
}
