package com.bytedance.sync.v2.h;

import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.lego.init.IdleTaskConfig;
import com.bytedance.sync.v2.f.j;
import com.bytedance.sync.v2.f.l;
import com.bytedance.sync.v2.f.m;
import d.b.u.w.k;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class h implements com.bytedance.sync.v2.f.g, i.a, j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f5969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f5970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final k f5971h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Context f5972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LinkedBlockingQueue<WsChannelMsg> f5973j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.bytedance.sync.v2.f.g f5974k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Handler f5975l;
    private Runnable m;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f5976f;

        a(h r1) {
            this.f5976f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.u.x.b.c("wait 15000 don't receive msg ,so try send msg again");     // Catch: Throwable -> L4
            WsChannelMsg r0 = (WsChannelMsg) h.o0(this.f5976f).poll();     // Catch: Throwable -> L4
            h.p0(this.f5976f).l(r0);     // Catch: Throwable -> L4
            return;
        }
    }

    public h(Context r2, d.b.u.e r3, com.bytedance.sync.v2.f.g r4) {
        this.f5969f = new Object();
        this.f5973j = new LinkedBlockingQueue();
        this.m = new a(this);
        this.f5972i = r2;
        this.f5971h = r3.f15025c;
        this.f5974k = r4;
        this.f5975l = new Handler(((d.b.u.w.e) com.ss.android.ug.bus.b.a(d.b.u.w.e.class)).get());
        ((m) com.ss.android.ug.bus.b.a(m.class)).E(this);
        ((com.bytedance.sync.v2.f.f) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.f.class)).h0(this);
    }

    static /* synthetic */ LinkedBlockingQueue o0(h r0) {
        return r0.f5973j;
    }

    static /* synthetic */ k p0(h r0) {
        return r0.f5971h;
    }

    private void q0(com.bytedance.sync.v2.g.a r8) {
        d.b.u.x.b.a("[SendMsg] ws not connect, fallback to http...");
        if (((d.b.u.i) com.ss.android.ug.bus.b.a(d.b.u.i.class)).r(this.f5972i) == false) goto L5;
        com.bytedance.sync.v2.g.a r0 = new com.bytedance.sync.v2.g.a();
        r0.f5945a = r8.f5945a;
        r0.f5946b = false;
        r0.f5948d = r8.f5948d;
        this.f5974k.W(r0);
        return;
    L5:
        d.b.u.x.b.b("[SendMsg] net not available,throw msg " + d.r0(r8.f5945a));
        s0(r8.f5948d, 1, 3, com.bytedance.sync.v2.l.a.f6160a.c(r8.f5945a).intValue(), false);
    }

    private void r0(int r3, WsChannelMsg r4) {
        if (d.b.u.b0.b.g(this.f5972i).f().l() > 0) goto L5;
    L8:
        this.f5973j.clear();     // Catch: Throwable -> L10
    L11:
        return;
    L5:
        if (r3 != com.bytedance.sync.v2.j.j.f6111k.getValue()) goto L8;
        this.f5973j.offer(r4);     // Catch: Throwable -> L10
        this.f5975l.postDelayed(this.m, IdleTaskConfig.IDLE_START_TIME_OUT);     // Catch: Throwable -> L10
        d.b.u.x.b.c("send poll pkg retry task ");     // Catch: Throwable -> L10
    }

    private void s0(f r1, int r2, int r3, int r4, boolean r5) {
        if (r1 == null) goto L5;
        r1.f5965a = r2;
        r1.f5966b = r3;
        r1.f5967c = r4;
        r1.f5968d = r5 ? 1 : 0;
        r1.a();
    L5:
        if (com.bytedance.sync.v2.l.a.f6160a.b(r4) == false) goto L8;
        ((l) com.ss.android.ug.bus.b.a(l.class)).k0(r2, r3, System.currentTimeMillis());
        return;
    }

    @Override // com.bytedance.sync.v2.f.j
    public void F(WsChannelMsg r1) {
        this.f5973j.clear();     // Catch: Throwable -> L4
        return;
    }

    @Override // com.bytedance.sync.v2.h.i.a
    public void M(boolean r2) {
        if (r2 == false) goto L11;
        Object r3 = this.f5969f;
        monitor-enter(r3);
        d.b.u.x.b.a("[SendMsg] notify ws connected");     // Catch: Throwable -> L8
        this.f5969f.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r3);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.sync.v2.f.g
    public void W(com.bytedance.sync.v2.g.a r13) {
        if (r13.f5947c == false) goto L6;
        this.f5974k.W(r13);
        return;
    L6:
        com.bytedance.sync.v2.j.e r0 = r13.f5945a;
        if (r0 != null) goto L10;
        d.b.u.x.b.b("[SendMsg] msg is null ,not send");
        return;
    L10:
        int r5 = com.bytedance.sync.v2.l.a.f6160a.c(r0).intValue();
        WsChannelMsg r1 = ((com.bytedance.sync.v2.f.e) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.e.class)).t(this.f5972i, r13.f5945a);
        if (r1 != null) goto L14;
        d.b.u.x.b.b("[SendMsg] convert msg error, not send");
        return;
    L14:
        boolean r2 = false;
        if (this.f5971h.j() == false) goto L49;
        this.f5970g = false;
        this.f5971h.l(r1);
        s0(r13.f5948d, 1, 1, r5, true);
        StringBuilder r12 = new StringBuilder();
        String r3 = "[SendMsg] send msg to ws ";
    L17:
        r12.append(r3);
        r12.append(d.r0(r13.f5945a));
        d.b.u.x.b.a(r12.toString());
        return;
    L49:
        Object r4 = this.f5969f;     // Catch: InterruptedException -> L39
        monitor-enter(r4);     // Catch: InterruptedException -> L39
    L36:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L39
    L21:
        if (this.f5970g == true) goto L23;
    L26:
        boolean r6 = true;
    L27:
        if (r6 == false) goto L33;
        d.b.u.x.b.a("[SendMsg] ws not connect, sleep...");     // Catch: Throwable -> L36
        long r7 = System.currentTimeMillis();     // Catch: Throwable -> L36
        this.f5969f.wait(CoroutineLiveDataKt.DEFAULT_TIMEOUT);     // Catch: Throwable -> L36
        if ((System.currentTimeMillis() - r7) >= CoroutineLiveDataKt.DEFAULT_TIMEOUT) goto L31;
        r2 = true;
    L31:
        if (r2 == true) goto L34;
        this.f5970g = true;     // Catch: Throwable -> L36
    L34:
        monitor-exit(r4);     // Catch: Throwable -> L36
    L42:
        if (this.f5971h.j() == false) goto L45;
        this.f5971h.l(r1);
        r0(r5, r1);
        s0(r13.f5948d, 1, 1, r5, true);
        r12 = new StringBuilder();
        r3 = "[SendMsg] send msg to ws again ";
        goto L17
    L45:
        if (r13.f5946b == false) goto L47;
        q0(r13);
        return;
    L47:
        d.b.u.x.b.b("[SendMsg] send payload failed with ws " + d.r0(r13.f5945a) + ", throw it");
        s0(r13.f5948d, 1, 2, r5, false);
        return;
    L33:
        d.b.u.x.b.a("[SendMsg] ws not connect, but waiting timeout, so not sleep");     // Catch: Throwable -> L36
        goto L34
    L23:
        if (r13.f5946b == false) goto L26;
        r6 = false;
    L39:
        e = move-exception;
        e.printStackTrace();
        goto L42
    }

    @Override // com.bytedance.sync.v2.f.g
    public boolean c() {
        return false;
    }
}
