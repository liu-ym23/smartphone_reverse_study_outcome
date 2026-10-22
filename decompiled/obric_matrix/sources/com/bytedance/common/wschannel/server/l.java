package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes.dex */
class l implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f3783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f3784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f.a f3785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ContentObserver f3787e;

    class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f3788a;

        a(l r1, Handler r2) {
            this.f3788a = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r2) {
            if (Logger.debug() == false) goto L5;
            Logger.d("WsChannelService", "KEY_FRONTIER_ENABLED");
        L5:
            l.d(this.f3788a);
        }
    }

    l(Context r1, Handler r2) {
        this.f3783a = r2;
        this.f3784b = r1;
    }

    static /* synthetic */ void d(l r0) {
        r0.e();
    }

    private void e() {
        boolean r0 = this.f3786d;     // Catch: Exception -> L8
        f();     // Catch: Exception -> L8
        boolean r1 = this.f3786d;     // Catch: Exception -> L8
        if (r0 == r1) goto L11;
        f.a r2 = this.f3785c;     // Catch: Exception -> L8
        if (r2 == null) goto L12;
        r2.a(r1);     // Catch: Exception -> L8
        return;
    L12:
        return;
    L11:
        return;
    }

    private void f() {
        boolean r0 = com.bytedance.common.wschannel.o.f(this.f3784b).g();     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L6;
        Logger.d("WsChannelService", "pushSdkEnabled = " + r0);     // Catch: Throwable -> L9
    L6:
        if (r0 == this.f3786d) goto L12;
        this.f3786d = r0;     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    private void g() {
        this.f3784b.getContentResolver().registerContentObserver(WsChannelMultiProcessSharedProvider.k(this.f3784b, WsConstants.KEY_FRONTIER_ENABLED, TypedValues.Custom.S_BOOLEAN), true, this.f3787e);     // Catch: Throwable -> L4
        return;
    }

    @Override // com.bytedance.common.wschannel.server.f
    public boolean a() {
        return this.f3786d;
    }

    @Override // com.bytedance.common.wschannel.server.f
    public void b() {
        f();
        this.f3787e = new a(this, this.f3783a);
        g();
    }

    @Override // com.bytedance.common.wschannel.server.f
    public void c(f.a r1) {
        this.f3785c = r1;
    }
}
