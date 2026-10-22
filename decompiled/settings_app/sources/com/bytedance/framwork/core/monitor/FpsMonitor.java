package com.bytedance.framwork.core.monitor;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class FpsMonitor {

    public interface IFPSCallBack {
        void fpsCallBack(String r1, double r2);
    }

    public interface IFrameCallBack {
        void onFrame(String r1, long r2);
    }

    public static void start(String r0) {
    }

    public static void stop() {
    }

    public boolean getMonitorFPSStatus(String r1) {
        return false;
    }

    public void setIFPSCallBack(IFPSCallBack r1) {
    }

    public void setIFrameCallBack(IFrameCallBack r1) {
    }

    public FpsMonitor() {
    }
}
