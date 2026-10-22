package com.obric.matrix.location_api;

import com.obric.matrix.q.b.d;
import com.obric.matrix.u.b;
import com.obric.matrix.w.b0;

/* JADX INFO: loaded from: classes2.dex */
public class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f9219a;

    public a() {
    }

    public static d b() {
        if (f9219a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9219a != null) goto L9;
        f9219a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f9219a;
    }

    @Override // com.obric.matrix.q.b.d
    public f.a.a<b> a(int r1, b0 r2, com.obric.matrix.platform.e.b r3) {
        switch(r1) {
            case 102001: goto L13;
            case 102002: goto L11;
            case 102003: goto L9;
            case 102004: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return ((ILocationService) com.bytedance.news.common.service.manager.d.a(ILocationService.class)).getIntersectFences(r2);
    L9:
        return ((ILocationService) com.bytedance.news.common.service.manager.d.a(ILocationService.class)).decodeLocation(r2);
    L11:
        return ((ILocationService) com.bytedance.news.common.service.manager.d.a(ILocationService.class)).refreshLocation(r2);
    L13:
        return ((ILocationService) com.bytedance.news.common.service.manager.d.a(ILocationService.class)).getLocation(r2);
    }
}
