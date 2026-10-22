package com.bytedance.apm.perf.traffic;

/* JADX INFO: loaded from: classes.dex */
public class TrafficStatisticWrapper {
    private ITrafficStatistics mTrafficStatistics;

    /* JADX INFO: renamed from: com.bytedance.apm.perf.traffic.TrafficStatisticWrapper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Holder {
        private static TrafficStatisticWrapper sInstance;

        static {
            sInstance = new TrafficStatisticWrapper(null);
        }

        private Holder() {
        }

        public static /* synthetic */ TrafficStatisticWrapper access$000() {
            return sInstance;
        }
    }

    public /* synthetic */ TrafficStatisticWrapper(AnonymousClass1 r1) {
        this();
    }

    public static TrafficStatisticWrapper getInstance() {
        return Holder.access$000();
    }

    public long getBackBytes() {
        return this.mTrafficStatistics.getBackBytes();
    }

    public long getBackPackets() {
        return this.mTrafficStatistics.getBackPackets();
    }

    public long getFrontBytes() {
        return this.mTrafficStatistics.getFrontBytes();
    }

    public long getFrontPackets() {
        return this.mTrafficStatistics.getFrontPackets();
    }

    public long getMobileBackBytes() {
        return this.mTrafficStatistics.getMobileBackBytes();
    }

    public long getMobileBytes() {
        return this.mTrafficStatistics.getMobileBytes();
    }

    public long getMobileFrontBytes() {
        return this.mTrafficStatistics.getMobileFrontBytes();
    }

    public long getTotalBytes() {
        return this.mTrafficStatistics.getTotalBytes();
    }

    public long getWifiBackBytes() {
        return this.mTrafficStatistics.getWifiBackBytes();
    }

    public long getWifiBytes() {
        return this.mTrafficStatistics.getWifiBytes();
    }

    public long getWifiFrontBytes() {
        return this.mTrafficStatistics.getWifiFrontBytes();
    }

    public void onStatusChange(boolean r1) {
        this.mTrafficStatistics.onStatusChange(r1);
    }

    private TrafficStatisticWrapper() {
        NewTrafficStatisticsImpl r0 = new NewTrafficStatisticsImpl();
        this.mTrafficStatistics = r0;
        r0.init();
    }
}
