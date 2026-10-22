package com.obric.matrix.common_api;

import com.obric.matrix.q.b.d;
import com.obric.matrix.w.b0;

/* JADX INFO: loaded from: classes2.dex */
public class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f8950a;

    public b() {
    }

    public static d b() {
        if (f8950a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8950a != null) goto L9;
        f8950a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f8950a;
    }

    @Override // com.obric.matrix.q.b.d
    public f.a.a<com.obric.matrix.u.b> a(int r1, b0 r2, com.obric.matrix.platform.e.b r3) {
        switch(r1) {
            case 112001: goto L13;
            case 112002: goto L11;
            case 112003: goto L9;
            case 112004: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return ((ICommonNetworkApi) com.bytedance.news.common.service.manager.d.a(ICommonNetworkApi.class)).getTTNetParameters(r2);
    L9:
        return ((ICommonNetworkApi) com.bytedance.news.common.service.manager.d.a(ICommonNetworkApi.class)).processGenericNetworkRequest(r2);
    L11:
        return ((ICommonNetworkApi) com.bytedance.news.common.service.manager.d.a(ICommonNetworkApi.class)).sendApplogEventRequest(r2);
    L13:
        return ((ICommonNetworkApi) com.bytedance.news.common.service.manager.d.a(ICommonNetworkApi.class)).onePartyNetworkRequest(r2);
    }
}
