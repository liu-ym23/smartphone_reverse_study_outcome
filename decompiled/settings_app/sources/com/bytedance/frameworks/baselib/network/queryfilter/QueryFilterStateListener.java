package com.bytedance.frameworks.baselib.network.queryfilter;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.LifeCycleMonitor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.math3.optimization.direct.CMAESOptimizer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class QueryFilterStateListener extends LifeCycleMonitor.NetworkAppStateListener {
    private static volatile QueryFilterStateListener sInstance;
    public AtomicBoolean mIsBackgroundState;

    public static QueryFilterStateListener getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(QueryFilterStateListener.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new QueryFilterStateListener(CMAESOptimizer.DEFAULT_MAXITERATIONS);     // Catch: Throwable -> L11
    L9:
        monitor-exit(QueryFilterStateListener.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public QueryFilterStateListener(int r2) {
        super(r2);
        this.mIsBackgroundState = new AtomicBoolean(false);
    }

    public void onServerConfigChanged(JSONObject r3) {
        setEnterBackgroundDelayMills(r3.optInt("qf_enter_background_time", CMAESOptimizer.DEFAULT_MAXITERATIONS));
    }

    @Override // com.bytedance.frameworks.baselib.network.LifeCycleMonitor.NetworkAppStateListener
    public void onEnterToForeground() {
        this.mIsBackgroundState.set(false);
        if (Logger.debug() == false) goto L6;
        Logger.d("QueryFilterStateListener", "onEnterToForeground");
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.LifeCycleMonitor.NetworkAppStateListener
    public void onEnterToBackground() {
        this.mIsBackgroundState.set(true);
        if (Logger.debug() == false) goto L6;
        Logger.d("QueryFilterStateListener", "onEnterToBackground");
        return;
    }
}
