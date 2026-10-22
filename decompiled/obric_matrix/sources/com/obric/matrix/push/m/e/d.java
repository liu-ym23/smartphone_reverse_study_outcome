package com.obric.matrix.push.m.e;

import androidx.core.app.NotificationCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/push/base/handler/PbMsgHandlers;", "Lcom/obric/matrix/push/base/handler/IMsgHandler;", "()V", "handlers", "", "Lcom/obric/matrix/push/base/handler/PbMsgHandler;", "decode", "Lcom/obric/matrix/push/Packet;", "data", "", "dispatchHandle", "", NotificationCompat.CATEGORY_MESSAGE, "handle", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f9672a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<c> f9673b = null;

    static {
        f9672a = new d();
        f9673b = r.j(new c[]{new e(), new f()});
    }

    private d() {
    }

    private final com.obric.matrix.push.e d(byte[] r1) {
        com.obric.matrix.push.e r0 = com.obric.matrix.push.e.r.decode(r1);
        o.e(r0, "packet");
        return r0;
    }

    private final void e(com.obric.matrix.push.e r3) {
        Iterator<T> r2 = f9673b.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        c r0 = (c) r2.next();
        if (r0.a(r3) == false) goto L4;
        r0.b(r3);
        goto L4
    }

    @Override // com.obric.matrix.push.m.e.a
    public void c(byte[] r2) {
        o.f(r2, "data");
        e(d(r2));
    }
}
