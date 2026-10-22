package com.bytedance.common.wschannel.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes.dex */
public class n extends BroadcastReceiver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f3799d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f3800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private j.a f3802c;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f3803f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f3804g;

        a(n r1, Context r2) {
            this.f3804g = r1;
            this.f3803f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.a(this.f3804g, this.f3803f);
            if (n.b() == true) goto L11;
            return;
        L11:
            if (Logger.debug() == false) goto L8;
            Logger.d("WsChannelReceiver", "ConnectivityReceiver");     // Catch: Exception -> L10
        L8:
            int r0 = j.a(this.f3803f);     // Catch: Exception -> L10
            Message r1 = Message.obtain();     // Catch: Exception -> L10
            r1.what = 3;     // Catch: Exception -> L10
            r1.arg1 = r0;     // Catch: Exception -> L10
            n.c(this.f3804g).handleMsg(r1);     // Catch: Exception -> L10
            return;
        }
    }

    static {
    }

    public n(Context r2, b r3) {
        this.f3801b = true;
        this.f3802c = j.b(r2);
        this.f3800a = r3;
    }

    static /* synthetic */ void a(n r0, Context r1) {
        r0.d(r1);
    }

    static /* synthetic */ boolean b() {
        return f3799d;
    }

    static /* synthetic */ b c(n r0) {
        return r0.f3800a;
    }

    private void d(Context r1) {
        boolean r0 = com.bytedance.common.wschannel.o.f(r1).g();     // Catch: Throwable -> L6
        if (r0 == f3799d) goto L9;
        f3799d = r0;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r2, Intent r3) {
        if (r2 == null) goto L20;
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.f3800a != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r3.getAction()) == false) goto L11;
        return;
    L11:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r3.getAction()) == true) goto L14;
        return;
    L14:
        if (this.f3801b == false) goto L18;
        this.f3801b = false;
        if (j.b(r2) != this.f3802c) goto L18;
        return;
    L18:
        com.bytedance.common.utility.m.c.c(new a(this, r2));
        return;
    }
}
