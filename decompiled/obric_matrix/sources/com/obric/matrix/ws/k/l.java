package com.obric.matrix.ws.k;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.i0.r;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fJ\u0010\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/ws/internal/WsSettings;", "", "()V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getAppKey", "", "getChannelId", "", "getProductId", "getReconnectCount", "getUrls", "", "update", "", "force", "", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f10685a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f10686b;

    static {
        f10685a = new l();
        f10686b = new AtomicBoolean(false);
    }

    private l() {
    }

    public static /* synthetic */ void g(l r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.f(r1);
    }

    public final String a() {
        return com.obric.matrix.ws.j.f10634a.a();
    }

    public final int b() {
        return 1;
    }

    public final int c() {
        return 1077;
    }

    public final int d() {
        if (e().size() <= 1) goto L5;
        return 0;
    L5:
        return 2;
    }

    public final List<String> e() {
        return r.d(com.obric.matrix.ws.j.f10634a.b());
    }

    public final void f(boolean r2) {
        if (r2 == true) goto L5;
        f10686b.compareAndSet(false, true);
        return;
    }
}
