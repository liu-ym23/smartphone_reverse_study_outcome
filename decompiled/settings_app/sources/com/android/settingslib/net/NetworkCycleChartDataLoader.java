package com.android.settingslib.net;

import android.app.usage.NetworkStats;
import android.content.Context;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NetworkCycleChartDataLoader extends NetworkCycleDataLoader<List<NetworkCycleChartData>> {
    private static final String TAG = "NetworkCycleChartLoader";
    private final List<NetworkCycleChartData> mData;

    public static abstract class Builder<T extends NetworkCycleChartDataLoader> extends NetworkCycleDataLoader.Builder<T> {
        public Builder(Context r1) {
            super(r1);
        }
    }

    /* synthetic */ NetworkCycleChartDataLoader(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    @Override // com.android.settingslib.net.NetworkCycleDataLoader
    /* bridge */ /* synthetic */ List<NetworkCycleChartData> getCycleUsage() {
        return getCycleUsage2();
    }

    private NetworkCycleChartDataLoader(Builder r1) {
        super(r1);
        this.mData = new ArrayList();
    }

    @Override // com.android.settingslib.net.NetworkCycleDataLoader
    void recordUsage(long r8, long r10) {
        NetworkStats.Bucket r0 = this.mNetworkStatsManager.querySummaryForDevice(this.mNetworkTemplate, r8, r10);     // Catch: RuntimeException -> L10
        if (r0 != null) goto L5;
        long r3 = 0;
    L7:
        if (r3 <= 0) goto L15;
        NetworkCycleChartData.Builder r1 = new NetworkCycleChartData.Builder();     // Catch: RuntimeException -> L10
        r1.setUsageBuckets(getUsageBuckets(r8, r10)).setStartTime(r8).setEndTime(r10).setTotalUsage(r3);     // Catch: RuntimeException -> L10
        this.mData.add(r1.build());     // Catch: RuntimeException -> L10
        return;
    L15:
        return;
    L5:
        r3 = r0.getRxBytes() + r0.getTxBytes();     // Catch: RuntimeException -> L10
    L10:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Exception querying network detail.", e);
    }

    @Override // com.android.settingslib.net.NetworkCycleDataLoader
    /* JADX INFO: renamed from: getCycleUsage, reason: avoid collision after fix types in other method */
    List<NetworkCycleChartData> getCycleUsage2() {
        return this.mData;
    }

    public static Builder<?> builder(final Context r1) {
        return new AnonymousClass1(r1);
    }

    private List<NetworkCycleData> getUsageBuckets(long r16, long r18) {
        ArrayList r2 = new ArrayList();
        long r3 = r16 + NetworkCycleChartData.BUCKET_DURATION_MS;
        long r11 = r16;
    L4:
        if (r3 > r18) goto L13;
        long r13 = 0;
        NetworkStats.Bucket r0 = this.mNetworkStatsManager.querySummaryForDevice(this.mNetworkTemplate, r11, r3);     // Catch: RuntimeException -> L10
        if (r0 == null) goto L12;
        r13 = r0.getRxBytes() + r0.getTxBytes();
    L12:
        r2.add(new NetworkCycleData.Builder().setStartTime(r11).setEndTime(r3).setTotalUsage(r13).build());
        r11 = r3;
        r3 = NetworkCycleChartData.BUCKET_DURATION_MS + r3;
    L10:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Exception querying network detail.", e);
        goto L12
    L13:
        return r2;
    }
}
