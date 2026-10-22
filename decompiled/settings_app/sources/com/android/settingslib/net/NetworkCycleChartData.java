package com.android.settingslib.net;

import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class NetworkCycleChartData extends NetworkCycleData {
    public static final long BUCKET_DURATION_MS = 0;
    private List<NetworkCycleData> mUsageBuckets;

    /* JADX INFO: renamed from: com.android.settingslib.net.NetworkCycleChartData$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder extends NetworkCycleData.Builder {
        private NetworkCycleChartData mObject;

        public Builder() {
            this.mObject = new NetworkCycleChartData(null);
        }

        @Override // com.android.settingslib.net.NetworkCycleData.Builder
        public /* bridge */ /* synthetic */ NetworkCycleData build() {
            return build();
        }

        @Override // com.android.settingslib.net.NetworkCycleData.Builder
        protected /* bridge */ /* synthetic */ NetworkCycleData getObject() {
            return getObject();
        }

        public Builder setUsageBuckets(List<NetworkCycleData> r2) {
            NetworkCycleChartData.access$102(getObject(), r2);
            return this;
        }

        @Override // com.android.settingslib.net.NetworkCycleData.Builder
        protected NetworkCycleChartData getObject() {
            return this.mObject;
        }

        @Override // com.android.settingslib.net.NetworkCycleData.Builder
        public NetworkCycleChartData build() {
            return getObject();
        }
    }

    /* synthetic */ NetworkCycleChartData(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ List access$102(NetworkCycleChartData r0, List r1) {
        r0.mUsageBuckets = r1;
        return r1;
    }

    static {
        BUCKET_DURATION_MS = TimeUnit.DAYS.toMillis(1);
    }

    private NetworkCycleChartData() {
    }

    public List<NetworkCycleData> getUsageBuckets() {
        return this.mUsageBuckets;
    }
}
