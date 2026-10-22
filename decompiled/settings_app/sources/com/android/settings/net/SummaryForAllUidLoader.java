package com.android.settings.net;

import android.content.Context;
import android.net.INetworkStatsSession;
import android.net.NetworkStats;
import android.net.NetworkTemplate;
import android.os.Bundle;
import androidx.loader.content.AsyncTaskLoader;

/* JADX INFO: loaded from: classes2.dex */
public class SummaryForAllUidLoader extends AsyncTaskLoader<NetworkStats> {
    private static final String KEY_END = "end";
    private static final String KEY_START = "start";
    private static final String KEY_TEMPLATE = "template";
    private final Bundle mArgs;
    private final INetworkStatsSession mSession;

    @Override // androidx.loader.content.AsyncTaskLoader
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

    public SummaryForAllUidLoader(Context r1, INetworkStatsSession r2, Bundle r3) {
        super(r1);
        this.mSession = r2;
        this.mArgs = r3;
    }

    @Override // androidx.loader.content.Loader
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.loader.content.AsyncTaskLoader
    public NetworkStats loadInBackground() {
        NetworkTemplate r2 = this.mArgs.getParcelable(KEY_TEMPLATE);
        long r3 = this.mArgs.getLong("start");
        long r5 = this.mArgs.getLong("end");
        return this.mSession.getSummaryForAllUid(r2, r3, r5, false);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // androidx.loader.content.Loader
    protected void onStopLoading() {
        super.onStopLoading();
        cancelLoad();
    }

    @Override // androidx.loader.content.Loader
    protected void onReset() {
        super.onReset();
        cancelLoad();
    }
}
