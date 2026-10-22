package com.bytedance.common.wschannel.client;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends Service implements WeakHandler.IHandler, c.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f3491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c f3492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Messenger f3493h;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.client.a$a, reason: collision with other inner class name */
    class RunnableC0099a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Intent f3494f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f3495g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f3496h;

        RunnableC0099a(a r1, Intent r2, long r3) {
            this.f3496h = r1;
            this.f3494f = r2;
            this.f3495g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.g(this.f3496h, this.f3494f, this.f3495g);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Intent f3497f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f3498g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f3499h;

        b(a r1, Intent r2, long r3) {
            this.f3499h = r1;
            this.f3497f = r2;
            this.f3498g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.g(this.f3499h, this.f3497f, this.f3498g);
        }
    }

    public a() {
        this.f3491f = new WeakHandler(this);
        this.f3492g = new c(this);
    }

    static /* synthetic */ void g(a r0, Intent r1, long r2) {
        r0.h(r1, r2);
    }

    @WorkerThread
    private void h(Intent r2, long r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        com.bytedance.common.wschannel.model.a r0 = new com.bytedance.common.wschannel.model.a(r3);
        this.f3492g.a(r2, r0);
    }

    public void f(String r1, boolean r2) {
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r6) {
        long r0 = com.bytedance.common.wschannel.u.b.a();     // Catch: Exception -> L14
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.what != 10123) goto L19;
        Intent r7 = (Intent) r6.getData().getParcelable(WsConstants.DATA_INTENT);     // Catch: Exception -> L14
        if (Logger.debug() == false) goto L10;
        Logger.d("AbsWsClientService", "handleMsg = " + r7);     // Catch: Exception -> L14
    L10:
        if (r7 == null) goto L12;
        com.bytedance.common.wschannel.h.b().c(new b(this, r7, r0));     // Catch: Exception -> L14
        return;
    L12:
        Logger.e("AbsWsClientService", "handleMsg but intent isnull");     // Catch: Exception -> L14
        return;
    L19:
        return;
    L14:
        e = move-exception;
        Logger.e(e.toString());
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent r1) {
        return this.f3493h.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f3493h = new Messenger(this.f3491f);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (Logger.debug() == false) goto L6;
        Logger.d("AbsWsClientService", "onDestroy");
        return;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r3, int r4, int r5) {
        if (Logger.debug() == false) goto L9;
        StringBuilder r6 = new StringBuilder();
        r6.append("onStartCommand intent = ");
        if (r3 == null) goto L7;
        String r7 = r3.toString();
    L8:
        r6.append(r7);
        Logger.d("AbsWsClientService", r6.toString());
        goto L9
    L7:
        r7 = "null";
    L9:
        long r8 = com.bytedance.common.wschannel.u.b.a();
        com.bytedance.common.wschannel.h.b().c(new RunnableC0099a(this, r3, r8));
        return 2;
    }
}
