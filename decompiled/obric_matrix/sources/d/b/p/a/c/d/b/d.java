package d.b.p.a.c.d.b;

import android.os.MessageQueue;

/* JADX INFO: loaded from: classes.dex */
public class d implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MessageQueue.IdleHandler f14220a;

    public d(MessageQueue.IdleHandler r1) {
        this.f14220a = r1;
    }

    public MessageQueue.IdleHandler a() {
        return this.f14220a;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        String r0 = this.f14220a.getClass().getName();
        b.b(">>>>> Dispatching to IdleTask " + r0);
        long r1 = System.currentTimeMillis();
        boolean r6 = this.f14220a.queueIdle();
        b.b("<<<<< Finished to IdleTask " + r0);
        c.b().a().a(r0, System.currentTimeMillis() - r1);
        return r6;
    }
}
