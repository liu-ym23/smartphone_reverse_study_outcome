package com.bytedance.sync.v2.compensate;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.bytedance.sync.v2.f.k;
import com.bytedance.sync.v2.f.m;
import d.b.u.l;

/* JADX INFO: loaded from: classes.dex */
final class j implements d, Handler.Callback, com.bytedance.sync.v2.h.i.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final l<Handler> f5930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d.b.u.e f5931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c f5932h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final k f5933i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private d.b.u.b0.a f5934j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f5935k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private d f5936l;
    private boolean m;

    class a extends l<Handler> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f5937b;

        a(j r1) {
            this.f5937b = r1;
        }

        @Override // d.b.u.l
        protected /* bridge */ /* synthetic */ Handler a(Object[] r1) {
            return c(r1);
        }

        protected Handler c(Object... r2) {
            return new Handler(((d.b.u.w.e) com.ss.android.ug.bus.b.a(d.b.u.w.e.class)).get(), this.f5937b);
        }
    }

    public j(c r1, k r2, d.b.u.e r3) {
        this.f5932h = r1;
        this.f5933i = r2;
        this.f5930f = new a(this);
        this.f5931g = r3;
    }

    private d f(boolean r10, boolean r11) {
        if (r10 == false) goto L4;
        d r12 = new i(this.f5932h, this.f5930f, this.f5933i, true);
    L5:
        this.f5936l = r12;
        return this.f5936l;
    L4:
        r12 = new b(this.f5932h, this.f5930f, this.f5933i, r11, false);
        goto L5
    }

    @Override // com.bytedance.sync.v2.h.i.a
    public void M(boolean r6) {
        d.b.u.x.b.a("Compensator: WsFirstCompensator onWsStatusChanged cur=" + r6 + ", before=" + this.f5935k);
        if (r6 != this.f5935k) goto L6;
        this.f5930f.b(new Object[0]).removeMessages(3);
        return;
    L6:
        if (this.f5930f.b(new Object[0]).hasMessages(3) == true) goto L10;
        this.f5930f.b(new Object[0]).sendMessageDelayed(this.f5930f.b(new Object[0]).obtainMessage(3, Boolean.valueOf(r6)), this.f5934j.g() * 1000);
        return;
    }

    @Override // com.bytedance.sync.v2.compensate.d
    public void a(com.bytedance.sync.v2.j.e r1) {
        d r0 = this.f5936l;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // com.bytedance.sync.v2.compensate.d
    public void b() {
        d r0 = this.f5936l;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.m = true;
    }

    @Override // com.bytedance.sync.v2.compensate.d
    public void c(d.b.u.b0.a r3, boolean r4) {
        d.b.u.x.b.a("[Compensator] WsFirst start readyToPoll = " + r4);
        this.f5934j = r3;
        this.m = r4;
        this.f5935k = this.f5931g.f15025c.j();
        ((m) com.ss.android.ug.bus.b.a(m.class)).E(this);
        d r0 = f(this.f5935k, true);
        this.f5936l = r0;
        r0.c(r3, r4);
    }

    @Override // com.bytedance.sync.v2.compensate.d
    public void d(d.b.u.b0.a r1) {
        this.f5934j = r1;
        d r0 = this.f5936l;
        if (r0 == null) goto L6;
        r0.d(r1);
        return;
    }

    @Override // com.bytedance.sync.v2.compensate.d
    public void destroy() {
        d.b.u.x.b.a("Compensator: WsFirstCompensator destroy");
        ((m) com.ss.android.ug.bus.b.a(m.class)).X(this);
        this.f5930f.b(new Object[0]).removeCallbacksAndMessages(null);
        d r2 = this.f5936l;
        if (r2 == null) goto L6;
        r2.destroy();
        return;
    }

    @Override // com.bytedance.sync.v2.h.f.a
    public int e() {
        d r0 = this.f5936l;
        if (r0 != null) goto L7;
        return 0;
    L7:
        if ((r0 instanceof i) == false) goto L9;
        return 1;
    L9:
        return 2;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message r5) {
        if (r5.what != 3) goto L11;
        boolean r6 = ((Boolean) r5.obj).booleanValue();
        if (r6 == this.f5935k) goto L10;
        d r0 = this.f5936l;
        if (r0 == null) goto L9;
        r0.destroy();
    L9:
        d r1 = f(r6, false);
        this.f5936l = r1;
        r1.c(this.f5934j, this.m);
    L10:
        this.f5935k = r6;
    L11:
        return false;
    }
}
