package com.android.server;

import android.content.Context;
import com.android.server.utils.TimingsTraceAndSlog;
import com.obric.server.memorydata.MemoryManagerService;

/* JADX INFO: loaded from: classes.dex */
public class ObricSystemServerImpl implements IObricSystemServer {
    private static final String TAG = "ObricSystemServerImpl";

    public ObricSystemServerImpl() {
    }

    public void startMemoryManagerService(Context context, TimingsTraceAndSlog t) {
        MemoryManagerService.start(context, t);
    }
}
