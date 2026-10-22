package com.obric.matrix.push.m.e;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.matrix.push.k;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/push/base/handler/RevokeMsgHandler;", "Lcom/obric/matrix/push/base/handler/PbMsgHandler;", "()V", LocationMonitorConst.TAG, "", "canHandle", "", NotificationCompat.CATEGORY_MESSAGE, "Lcom/obric/matrix/push/Packet;", "handle", "", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9675a;

    public f() {
        this.f9675a = "RevokeMsgHandler";
    }

    @Override // com.obric.matrix.push.m.e.c
    public boolean a(com.obric.matrix.push.e r1) {
        o.f(r1, NotificationCompat.CATEGORY_MESSAGE);
        if (r1.f9542k != com.obric.matrix.push.f.m) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.matrix.push.m.e.c
    public void b(com.obric.matrix.push.e r3) {
        o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.matrix.push.n.c.c.i(this.f9675a, "handle msg: " + r3);
        k r2 = r3.q;
        com.obric.matrix.push.m.i.d r4 = com.obric.matrix.push.m.b.f9633a.C();
        o.e(r2, "revokeMsg");
        r4.b(r2);
    }

    @Override // com.obric.matrix.push.m.e.a
    public void c(byte[] r1) {
        c.a.a(this, r1);
    }
}
