package com.obric.matrix.server;

import com.obric.matrix.w.b0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/server/HandlerCenter;", "", "()V", "TAG", "", "handlerRequest", "Lio/reactivex/Maybe;", "Lcom/obric/matrix/model/BaseResponseBody;", "cmd", "", "request", "Lcom/obric/matrix/proto/Request;", "callback", "Lcom/obric/matrix/platform/server/IServerCallback;", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f9991a = null;

    static {
        f9991a = new n();
    }

    private n() {
    }

    public final f.a.a<com.obric.matrix.u.b> a(int r1, b0 r2, com.obric.matrix.platform.e.b r3) {
        kotlin.n0.d.o.f(r2, "request");
        f.a.a<com.obric.matrix.u.b> r0 = com.obric.matrix.q.b.c.f9840a.b(r1, r2, r3);     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        return r0;
    L6:
        f.a.a<com.obric.matrix.u.b> r4 = f.a.a.c(new com.obric.matrix.s.c(r2));     // Catch: Throwable -> L8
        kotlin.n0.d.o.e(r4, "error(CmdNotSupportException(request))");     // Catch: Throwable -> L8
        return r4;
    L8:
        th = move-exception;
        f.a.a<com.obric.matrix.u.b> r5 = f.a.a.c(th);
        kotlin.n0.d.o.e(r5, "error(e)");
        return r5;
    }
}
