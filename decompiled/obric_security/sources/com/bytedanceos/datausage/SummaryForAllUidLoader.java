package com.bytedanceos.datausage;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.net.INetworkStatsSession;
import android.net.NetworkStats;
import android.net.NetworkTemplate;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class SummaryForAllUidLoader extends AsyncTaskLoader<NetworkStats> {
    private static final String KEY_END = "end";
    private static final String KEY_START = "start";
    private static final String KEY_TEMPLATE = "template";
    private final Bundle mArgs;
    private final INetworkStatsSession mSession;

    @Override // android.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ NetworkStats loadInBackground() {
        return loadInBackground();
    }

    public static Bundle buildArgs(NetworkTemplate template, long start, long end) {
        Bundle r0 = new Bundle();
        r0.putParcelable(KEY_TEMPLATE, template);
        r0.putLong("start", start);
        r0.putLong("end", end);
        return r0;
    }

    public SummaryForAllUidLoader(Context context, INetworkStatsSession session, Bundle args) {
        super(context);
        this.mSession = session;
        this.mArgs = args;
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
        return this.mSession.getSummaryForAllUid(r2, r3, r5, false);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
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
