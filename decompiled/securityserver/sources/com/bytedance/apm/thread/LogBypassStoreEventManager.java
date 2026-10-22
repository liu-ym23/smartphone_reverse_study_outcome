package com.bytedance.apm.thread;

import com.bytedance.apm.ApmContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class LogBypassStoreEventManager {
    private volatile ExecutorService mExecutors;

    public static class Holder {
        static final LogBypassStoreEventManager sINSTANCE = null;

        static {
            sINSTANCE = new LogBypassStoreEventManager(null);
        }

        private Holder() {
        }
    }

    public /* synthetic */ LogBypassStoreEventManager(AnonymousClass1 r1) {
        this();
    }

    public static LogBypassStoreEventManager getInstance() {
        if (ApmContext.isInternalTest() == true) goto L5;
        return null;
    L5:
        return Holder.sINSTANCE;
    }

    public void post(Runnable r1) {
        this.mExecutors.submit(r1);
    }

    private LogBypassStoreEventManager() {
        this.mExecutors = Executors.newFixedThreadPool(1, new AnonymousClass1(this));
    }
}
