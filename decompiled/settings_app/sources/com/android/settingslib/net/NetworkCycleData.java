package com.android.settingslib.net;

/* JADX INFO: loaded from: classes.dex */
public class NetworkCycleData {
    private long mEndTime;
    private long mStartTime;
    private long mTotalUsage;

    public static class Builder {
        private NetworkCycleData mObject;

        public Builder() {
            this.mObject = new NetworkCycleData();
        }

        public Builder setStartTime(long r2) {
            NetworkCycleData.access$002(getObject(), r2);
            return this;
        }

        public Builder setEndTime(long r2) {
            NetworkCycleData.access$102(getObject(), r2);
            return this;
        }

        public Builder setTotalUsage(long r2) {
            NetworkCycleData.access$202(getObject(), r2);
            return this;
        }

        protected NetworkCycleData getObject() {
            return this.mObject;
        }

        public NetworkCycleData build() {
            return getObject();
        }
    }

    static /* synthetic */ long access$002(NetworkCycleData r0, long r1) {
        r0.mStartTime = r1;
        return r1;
    }

    static /* synthetic */ long access$102(NetworkCycleData r0, long r1) {
        r0.mEndTime = r1;
        return r1;
    }

    static /* synthetic */ long access$202(NetworkCycleData r0, long r1) {
        r0.mTotalUsage = r1;
        return r1;
    }

    protected NetworkCycleData() {
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public long getTotalUsage() {
        return this.mTotalUsage;
    }
}
