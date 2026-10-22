package com.obric.matrix.push.m.e;

import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/matrix/push/base/handler/JsonMsgHandler;", "Lcom/obric/matrix/push/base/handler/IMsgHandler;", "()V", "handle", "", "data", "", "Companion", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b implements a {
    static {
    }

    public b() {
    }

    @Override // com.obric.matrix.push.m.e.a
    public void c(byte[] r2) {
        o.f(r2, "data");
        com.obric.matrix.r.c.c.b("JsonMsgHandler", "handle msg: " + new String(r2, kotlin.u0.d.f21429a));
    }
}
