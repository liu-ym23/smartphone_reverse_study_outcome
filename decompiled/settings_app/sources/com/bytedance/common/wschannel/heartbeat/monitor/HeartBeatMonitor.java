package com.bytedance.common.wschannel.heartbeat.monitor;

/* JADX INFO: loaded from: classes3.dex */
public class HeartBeatMonitor implements IHeartBeatMonitor {
    private IHeartBeatMonitor heartBeatMonitor;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.heartbeat.monitor.HeartBeatMonitor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class SingletonHolder {
        private static final HeartBeatMonitor instance = null;

        private SingletonHolder() {
        }

        static /* synthetic */ HeartBeatMonitor access$100() {
            return instance;
        }

        static {
            instance = new HeartBeatMonitor(null);
        }
    }

    /* synthetic */ HeartBeatMonitor(AnonymousClass1 r1) {
        this();
    }

    private HeartBeatMonitor() {
    }

    public static HeartBeatMonitor getInstance() {
        return SingletonHolder.access$100();
    }

    public void setHeartBeatMonitor(IHeartBeatMonitor r1) {
        this.heartBeatMonitor = r1;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.monitor.IHeartBeatMonitor
    public void onPingSuccess() {
        IHeartBeatMonitor r0 = this.heartBeatMonitor;
        if (r0 == null) goto L6;
        r0.onPingSuccess();
        return;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.monitor.IHeartBeatMonitor
    public void onPingTimeout() {
        IHeartBeatMonitor r0 = this.heartBeatMonitor;
        if (r0 == null) goto L6;
        r0.onPingTimeout();
        return;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.monitor.IHeartBeatMonitor
    public void onPingFail(Throwable r1) {
        IHeartBeatMonitor r0 = this.heartBeatMonitor;
        if (r0 == null) goto L6;
        r0.onPingFail(r1);
        return;
    }
}
