package com.android.settingslib.net;

import android.content.Context;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NetworkCycleDataForUidLoader extends NetworkCycleDataLoader<List<NetworkCycleDataForUid>> {
    private static final String TAG = "NetworkDataForUidLoader";
    private final List<NetworkCycleDataForUid> mData;
    private final boolean mRetrieveDetail;
    private final List<Integer> mUids;

    public static abstract class Builder<T extends NetworkCycleDataForUidLoader> extends NetworkCycleDataLoader.Builder<T> {
        private boolean mRetrieveDetail;
        private final List<Integer> mUids;

        static /* synthetic */ List access$000(Builder r0) {
            return r0.mUids;
        }

        static /* synthetic */ boolean access$100(Builder r0) {
            return r0.mRetrieveDetail;
        }

        public Builder(Context r1) {
            super(r1);
            this.mUids = new ArrayList();
            this.mRetrieveDetail = true;
        }

        public Builder<T> addUid(int r2) {
            this.mUids.add(Integer.valueOf(r2));
            return this;
        }

        public Builder<T> setRetrieveDetail(boolean r1) {
            this.mRetrieveDetail = r1;
            return this;
        }
    }

    /* synthetic */ NetworkCycleDataForUidLoader(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    @Override // com.android.settingslib.net.NetworkCycleDataLoader
    /* bridge */ /* synthetic */ List<NetworkCycleDataForUid> getCycleUsage() {
        return getCycleUsage2();
    }

    private NetworkCycleDataForUidLoader(Builder r2) {
        super(r2);
        this.mUids = Builder.access$000(r2);
        this.mRetrieveDetail = Builder.access$100(r2);
        this.mData = new ArrayList();
    }

    @Override // com.android.settingslib.net.NetworkCycleDataLoader
    void recordUsage(long r22, long r24) {
        Iterator<Integer> r7 = this.mUids.iterator();     // Catch: Exception -> L21
        long r1 = 0;
        long r10 = 0;
    L5:
        if (r7.hasNext() == false) goto L13;
        int r6 = r7.next().intValue();     // Catch: Exception -> L21
        long r3 = getTotalUsage(this.mNetworkStatsManager.queryDetailsForUidTagState(this.mNetworkTemplate, r22, r24, r6, 0, -1));     // Catch: Exception -> L21
        if (r3 <= 0) goto L5;
        long r12 = r1 + r3;     // Catch: Exception -> L21
        if (this.mRetrieveDetail == false) goto L11;
        r10 = r10 + getForegroundUsage(r22, r24, r6);     // Catch: Exception -> L21
    L11:
        r1 = r12;
        goto L5
    L13:
        if (r1 <= 0) goto L31;
        NetworkCycleDataForUid.Builder r4 = new NetworkCycleDataForUid.Builder();     // Catch: Exception -> L21
        r4.setStartTime(r22).setEndTime(r24).setTotalUsage(r1);     // Catch: Exception -> L21
        if (this.mRetrieveDetail == false) goto L17;
        r4.setBackgroundUsage(r1 - r10).setForegroundUsage(r10);     // Catch: Exception -> L21
    L17:
        NetworkCycleDataForUid r2 = r4.build();     // Catch: Exception -> L21
        if (r2.getBackgroudUsage() < 0) goto L32;
        this.mData.add(r2);     // Catch: Exception -> L21
        return;
    L32:
        return;
    L31:
        return;
    L21:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Exception querying network detail.", e);
    }

    @Override // com.android.settingslib.net.NetworkCycleDataLoader
    /* JADX INFO: renamed from: getCycleUsage, reason: avoid collision after fix types in other method */
    List<NetworkCycleDataForUid> getCycleUsage2() {
        return this.mData;
    }

    public static Builder<?> builder(final Context r1) {
        return new AnonymousClass1(r1);
    }

    public List<Integer> getUids() {
        return this.mUids;
    }

    private long getForegroundUsage(long r10, long r12, int r14) {
        return getTotalUsage(this.mNetworkStatsManager.queryDetailsForUidTagState(this.mNetworkTemplate, r10, r12, r14, 0, 2));
    }
}
