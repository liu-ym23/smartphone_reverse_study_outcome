package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes.dex */
public class MainChannelManager {
    private static volatile ChannelManager sInstance;

    private MainChannelManager() {
    }

    private static ChannelManager createChannelManager(Context r10) {
        HandlerThread r0 = new HandlerThread("wschannel");
        r0.start();
        ChannelKeeper r6 = new ChannelKeeper();
        MainMsgHandler r1 = new MainMsgHandler(r10, r6);
        IEnableObserver r8 = new AnonymousClass1();
        ChannelManager r9 = new ChannelManager(r10, r0.getLooper(), new AnonymousClass2(), r6, r1, r8);
        r1.setChannelManager(r9);
        return r9;
    }

    public static ChannelManager inst(Context r2) {
        if (sInstance != null) goto L16;
        monitor-enter(ChannelManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = createChannelManager(r2);     // Catch: Throwable -> L9
    L11:
        monitor-exit(ChannelManager.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }
}
