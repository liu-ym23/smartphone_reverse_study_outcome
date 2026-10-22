package com.bytedanceos.datausage;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.net.INetworkStatsSession;
import android.net.NetworkStatsHistory;
import android.net.NetworkTemplate;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.SparseBooleanArray;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class ChartDataLoader extends AsyncTaskLoader<ChartData> {
    private static final String KEY_APP = "app";
    private static final String KEY_FIELDS = "fields";
    private static final String KEY_TEMPLATE = "template";
    private static String TAG = "dataUsage";
    private final Bundle mArgs;
    private final INetworkStatsSession mSession;

    public static class AppItem implements Comparable<AppItem>, Parcelable {
        public static final int CATEGORY_APP = 2;
        public static final int CATEGORY_APP_TITLE = 1;
        public static final int CATEGORY_USER = 0;
        public static final Parcelable.Creator<AppItem> CREATOR = null;
        public int category;
        public final int key;
        public boolean restricted;
        public long total;
        public SparseBooleanArray uids;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(AppItem another) {
            return compareTo2(another);
        }

        public AppItem() {
            this.uids = new SparseBooleanArray();
            this.key = 0;
        }

        public AppItem(int key) {
            this.uids = new SparseBooleanArray();
            this.key = key;
        }

        public AppItem(Parcel parcel) {
            this.uids = new SparseBooleanArray();
            this.key = parcel.readInt();
            this.uids = parcel.readSparseBooleanArray();
            this.total = parcel.readLong();
        }

        public void addUid(int uid) {
            this.uids.put(uid, true);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.key);
            dest.writeSparseBooleanArray(this.uids);
            dest.writeLong(this.total);
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(AppItem another) {
            int r0 = Integer.compare(this.category, another.category);
            if (r0 == 0) goto L5;
            return r0;
        L5:
            return Long.compare(another.total, this.total);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static {
    }

    @Override // android.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ ChartData loadInBackground() {
        return loadInBackground();
    }

    public static Bundle buildArgs(NetworkTemplate template, AppItem app) {
        return buildArgs(template, app, 10);
    }

    public static Bundle buildArgs(NetworkTemplate template, AppItem app, int fields) {
        Bundle r0 = new Bundle();
        r0.putParcelable(KEY_TEMPLATE, template);
        r0.putParcelable(KEY_APP, app);
        r0.putInt("fields", fields);
        return r0;
    }

    public ChartDataLoader(Context context, INetworkStatsSession session, Bundle args) {
        super(context);
        this.mSession = session;
        this.mArgs = args;
    }

    @Override // android.content.Loader
    protected void onStartLoading() {
        super.onStartLoading();
        OLog.d(TAG, "ChartDataLoader onStartLoading data ");
        forceLoad();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.content.AsyncTaskLoader
    public ChartData loadInBackground() {
        return loadInBackground((NetworkTemplate) this.mArgs.getParcelable(KEY_TEMPLATE), (AppItem) this.mArgs.getParcelable(KEY_APP), this.mArgs.getInt("fields"));
    L5:
        e = move-exception;
        throw new RuntimeException("problem reading network stats", e);
    }

    private ChartData loadInBackground(NetworkTemplate template, AppItem app, int fields) throws RemoteException {
        ChartData r0 = new ChartData();
        r0.network = this.mSession.getHistoryForNetwork(template, fields);
        OLog.d(TAG, "ChartDataLoader loadInBackground data true");
        if (app == null) goto L10;
        int r9 = app.uids.size();
        int r3 = 0;
    L5:
        if (r3 >= r9) goto L7;
        int r4 = app.uids.keyAt(r3);
        r0.detailDefault = collectHistoryForUid(template, r4, 0, r0.detailDefault);
        r0.detailForeground = collectHistoryForUid(template, r4, 1, r0.detailForeground);
        r3 = r3 + 1;
        goto L5
    L7:
        if (r9 <= 0) goto L9;
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

    private NetworkStatsHistory collectHistoryForUid(NetworkTemplate template, int uid, int set, NetworkStatsHistory existing) throws RemoteException {
        NetworkStatsHistory r6 = this.mSession.getHistoryForUid(template, uid, set, 0, 10);
        if (existing == null) goto L6;
        existing.recordEntireHistory(r6);
        return existing;
    L6:
        return r6;
    }
}
