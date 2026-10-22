package com.obric.matrix.server;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/server/ServerCallback;", "Lcom/obric/matrix/platform/server/IServerCallback$Stub;", "()V", "dispatchResponse", "", "cmd", "", "bytes", "", "onResult", "Companion", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class r extends com.obric.matrix.platform.e.b.a {
    static {
    }

    public r() {
    }

    @Override // com.obric.matrix.platform.e.b
    public void A(int r3, byte[] r4) {
        com.obric.matrix.server.t.b.b.a("ServerCallback", "onResult(cmd: " + r3 + ", bytes: " + r4 + ").");
        k(r3, r4);
    }

    public final void k(int r1, byte[] r2) {
        ServerBrokerJni.onNotification(r1, r2);
    }
}
