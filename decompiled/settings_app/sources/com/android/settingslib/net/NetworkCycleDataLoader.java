package com.android.settingslib.net;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.net.NetworkPolicy;
import android.net.NetworkPolicyManager;
import android.net.NetworkTemplate;
import android.util.Pair;
import android.util.Range;
import androidx.loader.content.AsyncTaskLoader;
import com.android.settingslib.NetworkPolicyEditor;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class NetworkCycleDataLoader<D> extends AsyncTaskLoader<D> {
    private static final String TAG = "NetworkCycleDataLoader";
    private final ArrayList<Long> mCycles;
    protected final NetworkStatsManager mNetworkStatsManager;
    protected final NetworkTemplate mNetworkTemplate;
    private final NetworkPolicy mPolicy;

    public static abstract class Builder<T extends NetworkCycleDataLoader> {
        private final Context mContext;
        private ArrayList<Long> mCycles;
        private NetworkTemplate mNetworkTemplate;

        public abstract T build();

        static /* synthetic */ Context access$000(Builder r0) {
            return r0.mContext;
        }

        static /* synthetic */ NetworkTemplate access$100(Builder r0) {
            return r0.mNetworkTemplate;
        }

        static /* synthetic */ ArrayList access$200(Builder r0) {
            return r0.mCycles;
        }

        public Builder(Context r1) {
            this.mContext = r1;
        }

        public Builder<T> setNetworkTemplate(NetworkTemplate r1) {
            this.mNetworkTemplate = r1;
            return this;
        }

        public Builder<T> setCycles(ArrayList<Long> r1) {
            this.mCycles = r1;
            return this;
        }
    }

    abstract D getCycleUsage();

    abstract void recordUsage(long r1, long r3);

    protected NetworkCycleDataLoader(Builder<?> r4) {
        super(Builder.access$000(r4));
        NetworkTemplate r0 = Builder.access$100(r4);
        this.mNetworkTemplate = r0;
        this.mCycles = Builder.access$200(r4);
        this.mNetworkStatsManager = (NetworkStatsManager) Builder.access$000(r4).getSystemService("netstats");
        NetworkPolicyEditor r1 = new NetworkPolicyEditor(NetworkPolicyManager.from(Builder.access$000(r4)));
        r1.read();
        this.mPolicy = r1.getPolicy(r0);
    }

    @Override // androidx.loader.content.Loader
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public D loadInBackground() {
        ArrayList<Long> r0 = this.mCycles;
        if (r0 == null) goto L8;
        if (r0.size() <= 1) goto L8;
        loadDataForSpecificCycles();
    L12:
        return getCycleUsage();
    L8:
        if (this.mPolicy != null) goto L10;
        loadFourWeeksData();
        goto L12
    L10:
        loadPolicyData();
        goto L12
    }

    void loadPolicyData() {
        Iterator r0 = NetworkPolicyManager.cycleIterator(this.mPolicy);
    L4:
        if (r0.hasNext() == false) goto L6;
        Pair r1 = (Pair) r0.next();
        recordUsage(((ZonedDateTime) r1.first).toInstant().toEpochMilli(), ((ZonedDateTime) r1.second).toInstant().toEpochMilli());
        goto L4
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

    void loadFourWeeksData() {
        NetworkTemplate r1 = this.mNetworkTemplate;
        if (r1 != null) goto L13;
        return;
    L13:
        Range r0 = getTimeRangeOf(this.mNetworkStatsManager.queryDetailsForDevice(r1, Long.MIN_VALUE, Long.MAX_VALUE));     // Catch: IllegalArgumentException -> L12
        long r2 = ((Long) r0.getUpper()).longValue();     // Catch: IllegalArgumentException -> L12
    L8:
        if (r2 <= ((Long) r0.getLower()).longValue()) goto L16;
        long r3 = r2 - 2419200000L;     // Catch: IllegalArgumentException -> L12
        recordUsage(r3, r2);     // Catch: IllegalArgumentException -> L12
        r2 = r3;
        goto L8
    L16:
        return;
    }

    void loadDataForSpecificCycles() {
        long r0 = this.mCycles.get(0).longValue();
        int r3 = 1;
        int r2 = this.mCycles.size() - 1;
    L3:
        if (r3 > r2) goto L5;
        long r4 = this.mCycles.get(r3).longValue();
        recordUsage(r4, r0);
        r3 = r3 + 1;
        r0 = r4;
        goto L3
    }

    public static Builder<?> builder(final Context r1) {
        return new AnonymousClass1(r1);
    }

    protected long getTotalUsage(NetworkStats r7) {
        long r0 = 0;
        if (r7 == null) goto L11;
        NetworkStats.Bucket r6 = new NetworkStats.Bucket();
    L6:
        if (r7.hasNextBucket() == false) goto L10;
        if (r7.getNextBucket(r6) == false) goto L10;
        r0 = r0 + (r6.getRxBytes() + r6.getTxBytes());
    L10:
        r7.close();
    L11:
        return r0;
    }

    Range getTimeRangeOf(NetworkStats r8) {
        long r0 = Long.MAX_VALUE;
        long r2 = Long.MIN_VALUE;
    L4:
        if (hasNextBucket(r8) == false) goto L7;
        NetworkStats.Bucket r4 = getNextBucket(r8);
        r0 = Math.min(r0, r4.getStartTimeStamp());
        r2 = Math.max(r2, r4.getEndTimeStamp());
        goto L4
    L7:
        return new Range(Long.valueOf(r0), Long.valueOf(r2));
    }

    boolean hasNextBucket(NetworkStats r1) {
        return r1.hasNextBucket();
    }

    NetworkStats.Bucket getNextBucket(NetworkStats r1) {
        NetworkStats.Bucket r0 = new NetworkStats.Bucket();
        r1.getNextBucket(r0);
        return r0;
    }

    public ArrayList<Long> getCycles() {
        return this.mCycles;
    }
}
