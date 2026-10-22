package com.bytedance.frameworks.baselib.network.queryfilter;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.LifeCycleMonitor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class QueryFilterStateListener extends LifeCycleMonitor.NetworkAppStateListener {
    private static volatile QueryFilterStateListener sInstance;
    public AtomicBoolean mIsBackgroundState;

    public QueryFilterStateListener(int r2) {
        super(r2);
        this.mIsBackgroundState = new AtomicBoolean(false);
    }

    public static QueryFilterStateListener getInstance() {
        if (sInstance != null) goto L16;
        monitor-enter(QueryFilterStateListener.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new QueryFilterStateListener(30000);     // Catch: Throwable -> L9
    L11:
        monitor-exit(QueryFilterStateListener.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    @Override // com.bytedance.frameworks.baselib.network.LifeCycleMonitor.NetworkAppStateListener
    public void onEnterToBackground() {
        this.mIsBackgroundState.set(true);
        if (Logger.debug() == false) goto L6;
        Logger.d("QueryFilterStateListener", "onEnterToBackground");
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.LifeCycleMonitor.NetworkAppStateListener
    public void onEnterToForeground() {
        this.mIsBackgroundState.set(false);
        if (Logger.debug() == false) goto L6;
        Logger.d("QueryFilterStateListener", "onEnterToForeground");
        return;
    }

    public void onServerConfigChanged(JSONObject r3) {
        setEnterBackgroundDelayMills(r3.optInt("qf_enter_background_time", 30000));
    }
}
