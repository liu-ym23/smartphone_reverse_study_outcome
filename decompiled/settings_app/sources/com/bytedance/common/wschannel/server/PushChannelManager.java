package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.HandlerThread;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes3.dex */
public class PushChannelManager {
    private static volatile ChannelManager sInstance;

    private PushChannelManager() {
    }

    public static ChannelManager inst(Context r2) {
        if (sInstance != null) goto L15;
        monitor-enter(ChannelManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = createChannelManager(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ChannelManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private static ChannelManager createChannelManager(Context r10) {
        HandlerThread r0 = new HandlerThread("wschannel");
        r0.start();
        ChannelKeeper r6 = new ChannelKeeper();
        WsChannelMsgHandler r1 = new WsChannelMsgHandler(r10, r6);
        WsChannelEnableObserver r8 = new WsChannelEnableObserver(r10, new WeakHandler(r0.getLooper(), new AnonymousClass1()));
        ChannelManager r9 = new ChannelManager(r10, r0.getLooper(), new WsChannelSaver(r10), r6, r1, r8);
        r1.setChannelManager(r9);
        return r9;
    }
}
