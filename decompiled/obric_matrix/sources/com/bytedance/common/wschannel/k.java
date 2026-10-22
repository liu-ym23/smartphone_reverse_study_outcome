package com.bytedance.common.wschannel;

import android.content.Context;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f3536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.common.wschannel.app.d f3537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.common.wschannel.app.c f3538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.common.wschannel.app.e f3539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.common.wschannel.client.k f3540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f3541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SsWsApp f3542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.bytedance.common.wschannel.r.c f3543h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AtomicBoolean f3544i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ConcurrentHashMap<Integer, Boolean> f3545j;

    k(Context r3, com.bytedance.common.wschannel.client.k r4, a r5, com.bytedance.common.wschannel.app.d r6, com.bytedance.common.wschannel.app.e r7, com.bytedance.common.wschannel.app.c r8) {
        this.f3544i = new AtomicBoolean(false);
        this.f3545j = new ConcurrentHashMap();
        this.f3541f = r3;
        this.f3540e = r4;
        this.f3536a = r5;
        this.f3537b = r6;
        this.f3539d = r7;
        this.f3538c = r8;
        this.f3542g = n.e(r5);
    }

    void a(WsChannelMsg r8) {
        if (this.f3537b == null) goto L9;
        if (r8.x() == true) goto L9;
        this.f3537b.c(r8);
        return;
    L9:
        if (this.f3538c != null) goto L11;
        return;
    L11:
        if (r8.x() == false) goto L15;
        com.bytedance.common.wschannel.r.d r0 = new com.bytedance.common.wschannel.r.d(r8.w(), r8.c(), r8.s(), r8.f(), r8.e());
        r0.a(r8.v());
        this.f3538c.a(r0);
        return;
    }

    void b(com.bytedance.common.wschannel.r.b r2, JSONObject r3) {
        com.bytedance.common.wschannel.app.d r0 = this.f3537b;
        if (r0 == null) goto L6;
        r0.b(r2, r3);
    L6:
        if (r2.f3660b == com.bytedance.common.wschannel.r.c.f3666j) goto L8;
        return;
    L8:
        if (this.f3544i.get() == false) goto L12;
        n.l(c());
        return;
    }

    @Override // com.bytedance.common.wschannel.j
    public int c() {
        return this.f3536a.f3337a;
    }

    @Override // com.bytedance.common.wschannel.j
    public void d(WsChannelMsg r3, g r4) {
        if (r3.c() != this.f3536a.f3337a) goto L12;
        if (this.f3544i.get() == false) goto L9;
        if (r4 == null) goto L13;
        r4.a(r3, false);
        return;
    L13:
        return;
    L9:
        this.f3540e.f(this.f3541f, new MainProcessMsg(r3, r4));
        return;
    L12:
        throw new IllegalArgumentException("channelId isn't the same");
    }

    @Override // com.bytedance.common.wschannel.j
    public void e(a r3) {
        if (r3 == null) goto L11;
        if (r3.f3337a != this.f3536a.f3337a) goto L11;
        if (this.f3544i.get() == false) goto L8;
        return;
    L8:
        this.f3536a = r3;
        SsWsApp r4 = n.e(r3);
        this.f3542g = r4;
        this.f3540e.g(this.f3541f, r4);
        return;
    L11:
        throw new IllegalArgumentException("channelId isn't the same");
    }

    @Override // com.bytedance.common.wschannel.j
    public void f() {
        this.f3540e.b(this.f3541f, this.f3536a.f3337a);
        this.f3544i.set(true);
    }

    void g(ServiceConnectEvent r1) {
        com.bytedance.common.wschannel.app.e r0 = this.f3539d;
        if (r0 == null) goto L6;
        r0.b(r1);
        return;
    }

    void h() {
        this.f3540e.a(this.f3541f, this.f3542g);
    }

    void i(WsChannelMsg r1, boolean r2) {
        if ((r1 instanceof MainProcessMsg) == false) goto L8;
        MainProcessMsg r3 = (MainProcessMsg) r1;
        WsChannelMsg r0 = r3.T();
        g r4 = r3.S();
        if (r4 == null) goto L9;
        r4.a(r0, r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.common.wschannel.j
    public boolean isConnected() {
        if (this.f3543h != com.bytedance.common.wschannel.r.c.f3667k) goto L5;
        return true;
    L5:
        return false;
    }

    void j(ServiceConnectEvent r2) {
        this.f3545j.put(Integer.valueOf(r2.b()), Boolean.valueOf(r2.d()));
    }

    void k(com.bytedance.common.wschannel.r.c r1, boolean r2) {
        this.f3543h = r1;
    }
}
