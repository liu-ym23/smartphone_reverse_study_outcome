package com.bytedance.sync.v2.k;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.bytedance.sync.v2.f.h;
import com.bytedance.sync.v2.presistence.d.f;
import d.b.u.e;
import d.b.u.k;
import java.util.List;
import kotlin.b0;
import kotlin.i;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;

/* JADX INFO: loaded from: classes.dex */
public final class b implements h, Handler.Callback {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final /* synthetic */ l[] f6152l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bytedance.sync.v2.k.a f6153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.h f6154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f6155h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final e f6156i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d.b.u.w.b f6157j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final d.b.u.b f6158k;

    static final class a extends q implements kotlin.n0.c.a<Handler> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f6159f;

        a(b r1) {
            this.f6159f = r1;
            super(0);
        }

        public final Handler a() {
            return new Handler(((d.b.u.w.e) com.ss.android.ug.bus.b.a(d.b.u.w.e.class)).get(), this.f6159f);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Handler invoke() {
            return a();
        }
    }

    static {
        f6152l = new l[]{e0.g(new y(e0.b(b.class), "mHandler", "getMHandler()Landroid/os/Handler;"))};
    }

    public b(Context r2, e r3, d.b.u.w.b r4, d.b.u.b r5) {
        o.g(r2, "context");
        o.g(r3, "configuration");
        o.g(r4, "mAccountEventSynchronizer");
        o.g(r5, "mBusinessMgr");
        this.f6155h = r2;
        this.f6156i = r3;
        this.f6157j = r4;
        this.f6158k = r5;
        this.f6153f = new com.bytedance.sync.v2.k.a(r2, r3, r5);
        this.f6154g = i.b(new a(this));
    }

    private final Handler F() {
        kotlin.h r2 = this.f6154g;
        l r0 = f6152l[0];
        return (Handler) r2.getValue();
    }

    private final void M(f r2) {
        d.b.u.x.b.e("do insert upstream msg -> " + r2);
        ((com.bytedance.sync.v2.f.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class)).n0(r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        k.c().ensureNotReachHere(e, "execute sql failed when insertUploadPayload");
        e.printStackTrace();
    }

    private final void o0(List<? extends f> r2) {
        d.b.u.x.b.e("do insert upstream msg -> " + r2);
        ((com.bytedance.sync.v2.f.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class)).Z(r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        k.c().ensureNotReachHere(e, "execute sql failed when insertUploadPayload");
        e.printStackTrace();
    }

    @Override // com.bytedance.sync.v2.f.h
    public void d0() {
        if (F().hasMessages(102) == true) goto L6;
        F().obtainMessage(102).sendToTarget();
        return;
    }

    @Override // com.bytedance.sync.v2.f.h
    public void g0() {
        this.f6153f.j();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r4) {
        o.g(r4, NotificationCompat.CATEGORY_MESSAGE);
        if (r4.what != 101) goto L12;
        Object r0 = r4.obj;
        if (r0 == null) goto L10;
        M((f) r0);
        if (F().hasMessages(102) == true) goto L12;
        F().obtainMessage(102).sendToTarget();
        goto L12
    L10:
        throw new b0("null cannot be cast to non-null type com.bytedance.sync.v2.presistence.table.UploadItem");
    L12:
        if (r4.what != 103) goto L21;
        Object r1 = r4.obj;
        if (r1 == null) goto L19;
        o0((List) r1);
        if (F().hasMessages(102) == true) goto L21;
        F().obtainMessage(102).sendToTarget();
        goto L21
    L19:
        throw new b0("null cannot be cast to non-null type kotlin.collections.List<com.bytedance.sync.v2.presistence.table.UploadItem>");
    L21:
        if (r4.what != 102) goto L25;
        this.f6153f.l();
        return false;
    L25:
        return false;
    }
}
