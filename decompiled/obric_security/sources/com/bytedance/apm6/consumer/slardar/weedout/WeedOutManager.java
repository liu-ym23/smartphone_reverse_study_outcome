package com.bytedance.apm6.consumer.slardar.weedout;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class WeedOutManager {
    private static final int MINIMUM_OF_MB_TODAY = 80;
    private static final long WEED_OUT_INTERVAL = 14400000;
    private static volatile WeedOutManager instance;
    private int keepDays;
    private WeedOutListener listener;
    private int maxSizeMB;
    private int maxSizeMBToday;
    private Set<WeedOutStrategy> strategies;

    public WeedOutManager() {
        this.strategies = new HashSet();
        this.maxSizeMB = 80;
        this.keepDays = 5;
        this.maxSizeMBToday = -1;
    }

    static /* synthetic */ int access$000(WeedOutManager r0) {
        return r0.keepDays;
    }

    static /* synthetic */ int access$100(WeedOutManager r0) {
        return r0.maxSizeMB;
    }

    static /* synthetic */ Set access$200(WeedOutManager r0) {
        return r0.strategies;
    }

    static /* synthetic */ int access$300(WeedOutManager r0) {
        return r0.maxSizeMBToday;
    }

    static /* synthetic */ WeedOutListener access$400(WeedOutManager r0) {
        return r0.listener;
    }

    static {
        instance = new WeedOutManager();
    }

    public static WeedOutManager getInstance() {
        return instance;
    }

    public void setWeedOutConfig(int r2, int r3, int r4) {
        if (r2 <= 0) goto L12;
        if (r3 <= 0) goto L14;
        this.maxSizeMB = r2;
        this.keepDays = r3;
        int r0 = -1;
        if (r4 == (-1)) goto L8;
        r0 = Math.max(r4, 80);
    L8:
        this.maxSizeMBToday = r0;
        if (ApmContext.isDebugMode() == false) goto L13;
        Logger.d(Constants.TAG, "weed out config:maxSizeMB:" + r2 + " keepDays:" + r3);
        return;
    L13:
        return;
    L14:
        return;
    }

    public synchronized void addStrategy(WeedOutStrategy r2) {
        monitor-enter(this);
        if (r2 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.strategies.add(r2);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void register(WeedOutListener r1) {
        monitor-enter(this);
        this.listener = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void init() {
        if (ApmContext.isMainProcess() == true) goto L5;
        return;
    L5:
        AsyncTaskManager r0 = AsyncTaskManager.getInstance(AsyncTaskManagerType.IO);
        final long r3 = 0;
        final long r5 = WEED_OUT_INTERVAL;
        r0.sendTask(new AnonymousClass1(this, r3, r5));
    }
}
