package com.android.settingslib.net;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.net.NetworkTemplate;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SummaryForAllUidLoader extends AsyncTaskLoader<NetworkStats> {
    private static final String KEY_END = "end";
    private static final String KEY_START = "start";
    private static final String KEY_TEMPLATE = "template";
    private final Bundle mArgs;
    private final NetworkStatsManager mNetworkStatsManager;

    @Override // android.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ NetworkStats loadInBackground() {
        return loadInBackground();
    }

    public static Bundle buildArgs(NetworkTemplate r2, long r3, long r5) {
        Bundle r0 = new Bundle();
        r0.putParcelable(KEY_TEMPLATE, r2);
        r0.putLong("start", r3);
        r0.putLong("end", r5);
        return r0;
    }

    public SummaryForAllUidLoader(Context r2, Bundle r3) {
        super(r2);
        this.mNetworkStatsManager = (NetworkStatsManager) r2.getSystemService(NetworkStatsManager.class);
        this.mArgs = r3;
    }

    @Override // android.content.Loader
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.content.AsyncTaskLoader
    public NetworkStats loadInBackground() {
        NetworkTemplate r2 = this.mArgs.getParcelable(KEY_TEMPLATE);
        long r3 = this.mArgs.getLong("start");
        long r5 = this.mArgs.getLong("end");
        return this.mNetworkStatsManager.querySummary(r2, r3, r5);
    }

    @Override // android.content.Loader
    protected void onStopLoading() {
        super.onStopLoading();
        cancelLoad();
    }

    @Override // android.content.Loader
    protected void onReset() {
        super.onReset();
        cancelLoad();
    }
}
