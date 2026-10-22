package com.bytedance.sync.v2;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sync.v2.f.k;
import com.bytedance.sync.v2.f.l;
import com.bytedance.sync.v2.f.m;
import com.bytedance.sync.v2.h.i;
import com.ss.android.ug.bus.UgCallbackCenter;
import d.b.u.w.e;

/* JADX INFO: loaded from: classes.dex */
public class d implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f5938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Handler f5939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private UgCallbackCenter.d<Void> f5940h;

    class a implements UgCallbackCenter.d<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f5941a;

        a(d r1) {
            this.f5941a = r1;
        }

        @Override // com.ss.android.ug.bus.UgCallbackCenter.d
        public /* bridge */ /* synthetic */ void a(Void r1) {
            b(r1);
        }

        public void b(Void r5) {
            long r0 = d.b.u.b0.b.g(d.a(this.f5941a)).f().g() * 1000;
            Message r6 = d.b(this.f5941a).obtainMessage(102);
            d.b(this.f5941a).sendMessageDelayed(r6, r0);
        }
    }

    class b implements i.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f5942f;

        b(d r1) {
            this.f5942f = r1;
        }

        @Override // com.bytedance.sync.v2.h.i.a
        public void M(boolean r3) {
            if (r3 == true) goto L4;
        L6:
            this.f5942f.h(r3);
            return;
        L4:
            if (d.b(this.f5942f).hasMessages(101) == false) goto L6;
            d.b(this.f5942f).removeMessages(101);
            Message r0 = d.b(this.f5942f).obtainMessage(101);
            d.b(this.f5942f).sendMessage(r0);
            goto L6
        }
    }

    public d(Context r2) {
        this.f5938f = r2;
        this.f5939g = new Handler(((e) com.ss.android.ug.bus.b.a(e.class)).get(), this);
    }

    static /* synthetic */ Context a(d r0) {
        return r0.f5938f;
    }

    static /* synthetic */ Handler b(d r0) {
        return r0.f5939g;
    }

    private void e() {
        ((k) com.ss.android.ug.bus.b.a(k.class)).P();
        ((com.bytedance.sync.v2.f.a) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.a.class)).reset();
        ((com.bytedance.sync.v2.f.a) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.a.class)).m0();
    }

    private void g() {
    L11:
        th = move-exception;
        d.b.u.x.b.b(Log.getStackTraceString(th));
        return;
    L4:
        if (((l) com.ss.android.ug.bus.b.a(l.class)).p() == 1) goto L7;
        e();     // Catch: Throwable -> L11
    L9:
        ((l) com.ss.android.ug.bus.b.a(l.class)).q(true);     // Catch: Throwable -> L11
        return;
    L7:
        if (((l) com.ss.android.ug.bus.b.a(l.class)).c0() == true) goto L9;
        d.b.u.x.b.c("long link is online, in order for the server to sense that the long link is online, poll package needs to be sent ");     // Catch: Throwable -> L11
        d(false);     // Catch: Throwable -> L11
        goto L9
    }

    private void i() {
        ((l) com.ss.android.ug.bus.b.a(l.class)).q(false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        d.b.u.x.b.b(Log.getStackTraceString(th));
    }

    public void c() {
        if (this.f5940h == null) goto L5;
        ((d.b.u.w.b) com.ss.android.ug.bus.b.a(d.b.u.w.b.class)).L(this.f5940h);
    L5:
        this.f5939g.removeCallbacksAndMessages(null);
    }

    public void d(boolean r1) {
        ((k) com.ss.android.ug.bus.b.a(k.class)).G(r1);
    }

    public void f() {
        this.f5940h = new a(this);
        ((d.b.u.w.b) com.ss.android.ug.bus.b.a(d.b.u.w.b.class)).f0(this.f5940h);
        m r0 = (m) com.ss.android.ug.bus.b.a(m.class);
        if (d.b.u.b0.b.g(this.f5938f).f().o() == true) goto L5;
    L8:
        long r1 = 0;
    L9:
        Message r2 = this.f5939g.obtainMessage(101);
        this.f5939g.sendMessageDelayed(r2, r1);
        return;
    L5:
        if (r0.j() == true) goto L8;
        r1 = d.b.u.b0.b.g(this.f5938f).f().g() * 1000;
        r0.E(new b(this));
        goto L9
    }

    public void h(boolean r3) {
        if (r3 == false) goto L7;
        this.f5939g.removeMessages(104);     // Catch: Throwable -> L11
        if (this.f5939g.hasMessages(103) == true) goto L14;
        Handler r2 = this.f5939g;     // Catch: Throwable -> L11
        r2.sendMessageDelayed(r2.obtainMessage(103), 1000);     // Catch: Throwable -> L11
    L14:
        return;
    L7:
        this.f5939g.removeMessages(103);     // Catch: Throwable -> L11
        if (this.f5939g.hasMessages(104) == true) goto L14;
        Handler r4 = this.f5939g;     // Catch: Throwable -> L11
        r4.sendMessage(r4.obtainMessage(104));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        d.b.u.x.b.b(Log.getStackTraceString(th));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message r3) {
        if (r3.what != 102) goto L6;
        e();
    L6:
        if (r3.what != 101) goto L9;
        e();
    L9:
        if (r3.what != 103) goto L12;
        g();
    L12:
        if (r3.what != 104) goto L16;
        i();
        return false;
    L16:
        return false;
    }
}
