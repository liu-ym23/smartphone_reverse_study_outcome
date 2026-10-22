package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f3782a;

    static class a implements WeakHandler.IHandler {
        a() {
        }

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public void handleMsg(Message r1) {
        }
    }

    private static b a(Context r10) {
        HandlerThread r0 = new HandlerThread("wschannel");
        r0.start();
        com.bytedance.common.wschannel.server.a r6 = new com.bytedance.common.wschannel.server.a();
        m r1 = new m(r10, r6);
        l r8 = new l(r10, new WeakHandler(r0.getLooper(), new a()));
        b r9 = new b(r10, r0.getLooper(), new o(r10), r6, r1, r8);
        r1.o(r9);
        return r9;
    }

    public static b b(Context r2) {
        if (f3782a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3782a != null) goto L9;
        f3782a = a(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f3782a;
    }
}
