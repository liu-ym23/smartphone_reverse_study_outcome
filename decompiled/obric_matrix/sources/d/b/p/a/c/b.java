package d.b.p.a.c;

import android.os.Looper;
import android.os.MessageQueue;
import d.b.p.a.d.d;
import d.b.p.a.d.h;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b extends d.b.p.a.g.a {
    public b(d.b.p.a.c.d.a r1) {
        if (r1 == null) goto L7;
        d.b.p.a.c.d.b.c.b().c(r1);
        return;
    L7:
        throw new IllegalArgumentException("Argument idleHandlerCostTimeCallback can not be null ");
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "IdleHandlerMonitorPlugin";
    }

    @Override // d.b.p.a.g.a
    public void d() {
        super.d();
        if (Looper.myLooper() != Looper.getMainLooper()) goto L19;
        MessageQueue r4 = Looper.myQueue();     // Catch: Throwable -> L20
        monitor-enter(r4);     // Catch: Throwable -> L20
        Field r0 = d.a(MessageQueue.class, "mIdleHandlers");     // Catch: Throwable -> L14
        ArrayList r1 = (ArrayList) r0.get(r4);     // Catch: Throwable -> L14
        if (d.b.p.a.c.d.b.a.class.getName().equals(r1.getClass().getName()) == false) goto L11;
        h.c("IdleHandlerMonitorPlugin", "Already replaced,return.");     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L14
        return;
    L11:
        r0.set(r4, new d.b.p.a.c.d.b.a(r1));     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L23:
        return;
    L19:
        throw new RuntimeException("Must start in UI thread!");
    }
}
