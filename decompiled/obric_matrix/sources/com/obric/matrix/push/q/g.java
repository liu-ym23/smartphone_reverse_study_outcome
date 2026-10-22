package com.obric.matrix.push.q;

import android.app.Application;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.mpaas.app.AppInfo;
import com.obric.matrix.ws_api.IWs;
import d.b.u.m;
import d.b.u.t;
import d.b.u.w.i;
import d.b.u.w.k;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.f0;
import kotlin.i0.m0;
import kotlin.n0.c.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0005\u001a\u00020\u000628\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\bJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/push/sync/SyncManager;", "", "()V", "TAG", "", "init", "", "listener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "bizId", "", "data", "start", "did", "installId", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f9786a = null;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements l<WsChannelMsg, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f9787f = null;

        static {
            f9787f = new a();
        }

        a() {
            super(1);
        }

        public final void a(WsChannelMsg r1) {
            if (r1 == null) goto L5;
            t.e(r1);
            return;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(WsChannelMsg r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/obric/matrix/push/sync/SyncManager$init$configuration$1", "Lcom/bytedance/sync/interfaze/IWsService;", "isConnect", "", "registerOnWsStatusChangedListener", "", "listener", "Lcom/bytedance/sync/interfaze/IWsStatusChangedListener;", "send", NotificationCompat.CATEGORY_MESSAGE, "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements k {

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/push/sync/SyncManager$init$configuration$1$registerOnWsStatusChangedListener$1", "Lcom/obric/matrix/ws_api/IWsStatusChangeListener;", "onWsStatusChanged", "", "connectEvent", "Lcom/bytedance/common/wschannel/event/ConnectEvent;", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a implements com.obric.matrix.ws_api.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d.b.u.w.l f9788a;

            a(d.b.u.w.l r1) {
                this.f9788a = r1;
            }

            @Override // com.obric.matrix.ws_api.b
            public void a(com.bytedance.common.wschannel.r.b r2) {
                o.f(r2, "connectEvent");
                d.b.u.w.l r1 = this.f9788a;
                if (r1 == null) goto L6;
                r1.F(r2);
                return;
            }
        }

        /* JADX INFO: renamed from: com.obric.matrix.push.q.g$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "isSuccess", "", "<anonymous parameter 1>", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class C0279b extends q implements p<Boolean, WsChannelMsg, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0279b f9789f = null;

            static {
                f9789f = new C0279b();
            }

            C0279b() {
                super(2);
            }

            public final void a(boolean r1, WsChannelMsg r2) {
                o.f(r2, "<anonymous parameter 1>");
                com.obric.matrix.push.n.c.c.b("SyncManager", "IWsService, send <<< " + r1);
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ f0 invoke(Boolean r1, WsChannelMsg r2) {
                a(r1.booleanValue(), r2);
                return f0.f18324a;
            }
        }

        b() {
        }

        @Override // d.b.u.w.k
        public boolean j() {
            boolean r2 = ((IWs) com.bytedance.news.common.service.manager.d.a(IWs.class)).isConnected();
            com.obric.matrix.r.c.c.b("SyncManager", "IWsService, isConnected = " + r2);
            return r2;
        }

        @Override // d.b.u.w.k
        public void k(d.b.u.w.l r2) {
            ((IWs) com.bytedance.news.common.service.manager.d.a(IWs.class)).registerWsStatusChangeListener(new a(r2));
        }

        @Override // d.b.u.w.k
        public void l(WsChannelMsg r2) {
            com.obric.matrix.push.n.c.c.b("SyncManager", "IWsService, send >>> " + r2);
            ((IWs) com.bytedance.news.common.service.manager.d.a(IWs.class)).sendWsMessage(r2, C0279b.f9789f);
        }
    }

    static {
        f9786a = new g();
    }

    private g() {
    }

    private static final Map b() {
        return m0.l(new u[]{a0.a("device_platform", "android")});
    }

    private static final void c(p r2, i.a r3) {
        o.f(r2, "$listener");
        r2.invoke(Long.valueOf(e.f9784a.d()), r3.f15120a);
    }

    private static final void d(p r2, i.a r3) {
        o.f(r2, "$listener");
        r2.invoke(Long.valueOf(e.f9784a.f()), r3.f15120a);
    }

    private static final void e(p r2, i.a r3) {
        o.f(r2, "$listener");
        r2.invoke(Long.valueOf(e.f9784a.c()), r3.f15120a);
    }

    public static /* synthetic */ Map f() {
        return b();
    }

    public static /* synthetic */ void g(p r0, i.a r1) {
        c(r0, r1);
    }

    public static /* synthetic */ void h(p r0, i.a r1) {
        d(r0, r1);
    }

    public static /* synthetic */ void i(p r0, i.a r1) {
        e(r0, r1);
    }

    public final void a(final p<? super Long, ? super byte[], f0> r9) {
        o.f(r9, "listener");
        String r8 = AppInfo.getInstatnce().getAid();
        e r0 = e.f9784a;
        int r1 = r0.a();
        int r2 = r0.e();
        String r3 = r0.b();
        d.b.u.e.b r4 = new d.b.u.e.b(r8, r1, r2);
        r4.n(r3);
        r4.o(new f("SyncManager"));
        r4.p(new b());
        r4.m(com.obric.matrix.push.q.a.f9780f);
        d.b.u.e r5 = r4.l();
        com.obric.matrix.r.c.c.b("SyncManager", "init, aid: " + r8 + ", channelId: " + r1 + ", upStreamServiceId: " + r2 + ", host: " + r3);
        Application r10 = com.bytedance.mpaas.app.a.b();
        o.e(r10, "getInstance()");
        t.d(com.obric.matrix.r.b.g(r10), r5);
        m.a r11 = new m.a(r0.d());
        r11.e(new com.obric.matrix.push.q.b(r9));
        m r12 = r11.f();
        m.a r6 = new m.a(r0.f());
        r6.e(new c(r9));
        m r7 = r6.f();
        m.a r13 = new m.a(r0.c());
        r13.e(new d(r9));
        m r14 = r13.f();
        t.f(r12);
        t.f(r7);
        t.f(r14);
        ((IWs) com.bytedance.news.common.service.manager.d.a(IWs.class)).registerWsMsgReceivedListener(a.f9787f);
        com.bytedance.common.utility.g.j(com.obric.matrix.push.base.network.f.f9511b);
    }

    public final void j(String r1, String r2) {
        t.h(r1, r2);
    }
}
