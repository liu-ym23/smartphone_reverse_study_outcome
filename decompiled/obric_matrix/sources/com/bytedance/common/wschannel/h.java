package com.bytedance.common.wschannel;

import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.message.PushThreadHandlerManager;

/* JADX INFO: loaded from: classes.dex */
public class h implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile h f3527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static WeakHandler f3528g;

    private h() {
        if (f3528g != null) goto L10;
        f3528g = PushThreadHandlerManager.inst().getHandler();     // Catch: Throwable -> L6
        return;
    L6:
        HandlerThread r0 = new HandlerThread("WsHT");
        r0.start();
        f3528g = new WeakHandler(r0.getLooper(), this);
        return;
    }

    public static h b() {
        if (f3527f != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3527f != null) goto L9;
        f3527f = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f3527f;
    }

    public WeakHandler a() {
        return f3528g;
    }

    public void c(Runnable r3) {
        d(r3, 0);
    }

    public void d(Runnable r3, long r4) {
        if (r4 > 0) goto L5;
        f3528g.post(r3);
        return;
    L5:
        f3528g.postDelayed(r3, r4);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }
}
