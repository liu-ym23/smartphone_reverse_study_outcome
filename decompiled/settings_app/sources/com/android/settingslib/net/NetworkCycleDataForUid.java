package com.android.settingslib.net;

/* JADX INFO: loaded from: classes.dex */
public class NetworkCycleDataForUid extends NetworkCycleData {
    private long mBackgroudUsage;
    private long mForegroudUsage;

    /* JADX INFO: renamed from: com.android.settingslib.net.NetworkCycleDataForUid$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder extends NetworkCycleData.Builder {
        private NetworkCycleDataForUid mObject;

        public Builder() {
            this.mObject = new NetworkCycleDataForUid(null);
        }

        @Override // com.android.settingslib.net.NetworkCycleData.Builder
        public /* bridge */ /* synthetic */ NetworkCycleData build() {
            return build();
        }

        @Override // com.android.settingslib.net.NetworkCycleData.Builder
        public /* bridge */ /* synthetic */ NetworkCycleData getObject() {
            return getObject();
        }

        public Builder setBackgroundUsage(long r2) {
            NetworkCycleDataForUid.access$102(getObject(), r2);
            return this;
        }

        public Builder setForegroundUsage(long r2) {
            NetworkCycleDataForUid.access$202(getObject(), r2);
            return this;
        }

        @Override // com.android.settingslib.net.NetworkCycleData.Builder
        public NetworkCycleDataForUid getObject() {
            return this.mObject;
        }

        @Override // com.android.settingslib.net.NetworkCycleData.Builder
        public NetworkCycleDataForUid build() {
            return getObject();
        }
    }

    /* synthetic */ NetworkCycleDataForUid(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ long access$102(NetworkCycleDataForUid r0, long r1) {
        r0.mBackgroudUsage = r1;
        return r1;
    }

    static /* synthetic */ long access$202(NetworkCycleDataForUid r0, long r1) {
        r0.mForegroudUsage = r1;
        return r1;
    }

    private NetworkCycleDataForUid() {
    }

    public long getBackgroudUsage() {
        return this.mBackgroudUsage;
    }

    public long getForegroudUsage() {
        return this.mForegroudUsage;
    }
}
