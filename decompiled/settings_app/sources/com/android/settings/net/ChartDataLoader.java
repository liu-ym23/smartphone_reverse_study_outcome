package com.android.settings.net;

import android.content.Context;
import android.net.INetworkStatsSession;
import android.net.NetworkStatsHistory;
import android.net.NetworkTemplate;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.loader.content.AsyncTaskLoader;
import com.android.settings.DataUsageSummary;

/* JADX INFO: loaded from: classes2.dex */
public class ChartDataLoader extends AsyncTaskLoader<ChartData> {
    private static final String KEY_APP = "app";
    private static final String KEY_FIELDS = "fields";
    private static final String KEY_TEMPLATE = "template";
    private final Bundle mArgs;
    private final INetworkStatsSession mSession;

    @Override // androidx.loader.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ ChartData loadInBackground() {
        return loadInBackground();
    }

    public static Bundle buildArgs(NetworkTemplate r1, DataUsageSummary.AppItem r2) {
        return buildArgs(r1, r2, 10);
    }

    public static Bundle buildArgs(NetworkTemplate r2, DataUsageSummary.AppItem r3, int r4) {
        Bundle r0 = new Bundle();
        r0.putParcelable(KEY_TEMPLATE, r2);
        r0.putParcelable("app", r3);
        r0.putInt("fields", r4);
        return r0;
    }

    public ChartDataLoader(Context r1, INetworkStatsSession r2, Bundle r3) {
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
    public ChartData loadInBackground() {
        return loadInBackground((NetworkTemplate) this.mArgs.getParcelable(KEY_TEMPLATE), (DataUsageSummary.AppItem) this.mArgs.getParcelable("app"), this.mArgs.getInt("fields"));
    L5:
        e = move-exception;
        throw new RuntimeException("problem reading network stats", e);
    }

    private ChartData loadInBackground(NetworkTemplate r7, DataUsageSummary.AppItem r8, int r9) throws RemoteException {
        ChartData r0 = new ChartData();
        r0.network = this.mSession.getHistoryForNetwork(r7, r9);
        if (r8 == null) goto L10;
        int r10 = r8.uids.size();
        int r2 = 0;
    L5:
        if (r2 >= r10) goto L7;
        int r3 = r8.uids.keyAt(r2);
        r0.detailDefault = collectHistoryForUid(r7, r3, 0, r0.detailDefault);
        r0.detailForeground = collectHistoryForUid(r7, r3, 1, r0.detailForeground);
        r2 = r2 + 1;
        goto L5
    L7:
        if (r10 <= 0) goto L9;
        r0.detail = new NetworkStatsHistory(r0.detailForeground.getBucketDuration());
        r0.detail.recordEntireHistory(r0.detailDefault);
        r0.detail.recordEntireHistory(r0.detailForeground);
        goto L10
    L9:
        r0.detailDefault = new NetworkStatsHistory(3600000);
        r0.detailForeground = new NetworkStatsHistory(3600000);
        r0.detail = new NetworkStatsHistory(3600000);
    L10:
        return r0;
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

    private NetworkStatsHistory collectHistoryForUid(NetworkTemplate r7, int r8, int r9, NetworkStatsHistory r10) throws RemoteException {
        NetworkStatsHistory r6 = this.mSession.getHistoryForUid(r7, r8, r9, 0, 10);
        if (r10 == null) goto L6;
        r10.recordEntireHistory(r6);
        return r10;
    L6:
        return r6;
    }
}
