package com.bytedance.article.common.monitor;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.apm.thread.AsyncEventManager;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class MonitorFPS {
    private static final long FAKE_FRAME_TIME = 10;
    private static int INTEVERAL;
    private static final Long MAX_INTERVAL = null;
    private static final Long MONITOR_INTERVAL = null;
    private static final Long MONITOR_INTERVAL_NANOS = null;
    private static AsyncEventManager.IMonitorTimeTask fpsTimerTask;
    private static HashMap<String, AggregateFpsTimer> mTimerInfo;
    private FPSRecordView mFPSFpsRecordView;
    private volatile boolean mFPSState;
    private Choreographer.FrameCallback mFrameCallback;
    private IFPSCallBack mIFPSCallBack;
    private IFrameCallBack mIFrameCallBack;
    private String mType;
    private WindowManager mWindowManager;

    private static class AggregateFpsTimer {
        public long firstTime;
        public int times;
        public float value;

        public AggregateFpsTimer(int r1, float r2, long r3) {
            this.times = r1;
            this.value = r2;
            this.firstTime = r3;
        }
    }

    private class FPSRecordView extends View {
        private int mCounter;
        private long mStartTime;
        final /* synthetic */ MonitorFPS this$0;

        static /* synthetic */ long access$002(FPSRecordView r0, long r1) {
            r0.mStartTime = r1;
            return r1;
        }

        static /* synthetic */ int access$102(FPSRecordView r0, int r1) {
            r0.mCounter = r1;
            return r1;
        }

        public FPSRecordView(MonitorFPS r1, Context r2) {
            this.this$0 = r1;
            super(r2);
            this.mStartTime = -1;
            this.mCounter = 0;
        }

        @Override // android.view.View
        protected void onDraw(Canvas r5) {
            if (this.mStartTime != (-1)) goto L6;
            this.mStartTime = SystemClock.elapsedRealtime();
            this.mCounter = 0;
        L6:
            if (MonitorFPS.access$400(this.this$0) == null) goto L8;
            MonitorFPS.access$400(this.this$0).onFrame(SystemClock.elapsedRealtime());
        L8:
            long r0 = SystemClock.elapsedRealtime() - this.mStartTime;
            if (r0 <= MonitorFPS.access$1000().longValue()) goto L14;
            double r2 = (((double) this.mCounter) / r0) * MonitorFPS.access$600().longValue();
            if (MonitorFPS.access$700(this.this$0) == null) goto L13;
            MonitorFPS.access$700(this.this$0).fpsCallBack(r2);
        L13:
            MonitorFPS.access$900(MonitorFPS.access$800(this.this$0), (float) r2);
            this.this$0.stop();
        L14:
            this.mCounter++;
        }
    }

    public interface IFPSCallBack {
        void fpsCallBack(double r1);
    }

    public interface IFrameCallBack {
        void onFrame(long r1);
    }

    static /* synthetic */ Long access$1000() {
        return MONITOR_INTERVAL;
    }

    static /* synthetic */ HashMap access$1100() {
        return mTimerInfo;
    }

    static /* synthetic */ int access$1200() {
        return INTEVERAL;
    }

    static /* synthetic */ boolean access$200(MonitorFPS r0) {
        return r0.mFPSState;
    }

    static /* synthetic */ boolean access$202(MonitorFPS r0, boolean r1) {
        r0.mFPSState = r1;
        return r1;
    }

    static /* synthetic */ FPSRecordView access$300(MonitorFPS r0) {
        return r0.mFPSFpsRecordView;
    }

    static /* synthetic */ IFrameCallBack access$400(MonitorFPS r0) {
        return r0.mIFrameCallBack;
    }

    static /* synthetic */ Long access$500() {
        return MONITOR_INTERVAL_NANOS;
    }

    static /* synthetic */ Long access$600() {
        return MAX_INTERVAL;
    }

    static /* synthetic */ IFPSCallBack access$700(MonitorFPS r0) {
        return r0.mIFPSCallBack;
    }

    static /* synthetic */ String access$800(MonitorFPS r0) {
        return r0.mType;
    }

    static /* synthetic */ void access$900(String r0, float r1) {
        monitorFPSOnTimer(r0, r1);
    }

    static {
        Long r0 = 200L;
        MONITOR_INTERVAL = r0;
        MONITOR_INTERVAL_NANOS = Long.valueOf((r0.longValue() * 1000) * 1000);
        MAX_INTERVAL = 1000L;
        INTEVERAL = 120;
        fpsTimerTask = new AnonymousClass3();
        AsyncEventManager.getInstance().addTimeTask(fpsTimerTask);
        mTimerInfo = new HashMap();
    }

    public MonitorFPS(Context r2, String r3) {
        this.mFPSFpsRecordView = null;
        this.mWindowManager = null;
        this.mFPSState = false;
        this.mIFrameCallBack = null;
        this.mType = r3;
    }

    public void setIFrameCallBack(IFrameCallBack r1) {
        this.mIFrameCallBack = r1;
    }

    public boolean getMonitorFPSStatus() {
        return this.mFPSState;
    }

    public void setIFPSCallBack(IFPSCallBack r1) {
        this.mIFPSCallBack = r1;
    }

    public synchronized void stop() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mFPSState == false) goto L8;
        this.mFPSState = false;     // Catch: Throwable -> L10
        if (this.mFrameCallback == null) goto L8;
        Choreographer.getInstance().removeFrameCallback(this.mFrameCallback);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    }

    public void start() {
        if (this.mFPSState == true) goto L6;
        this.mFPSState = true;
        startJellyBean();
        return;
    }

    private void startBase() {
        FPSRecordView.access$002(this.mFPSFpsRecordView, -1);
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams(-2, -2, 2005, 0, -3);
        r0.gravity = 51;
        r0.flags = 24;
        r0.height = 1;
        r0.width = 1;
        this.mWindowManager.removeView(this.mFPSFpsRecordView);     // Catch: Exception -> L6
    L4:
        this.mWindowManager.addView(this.mFPSFpsRecordView, r0);
        this.mFPSFpsRecordView.postDelayed(new AnonymousClass1(this), 10);
    }

    private void startJellyBean() {
        this.mFrameCallback = new AnonymousClass2(this);
        Choreographer.getInstance().postFrameCallback(this.mFrameCallback);
    }

    private static void monitorFPSOnTimer(final String r2, final float r3) {
        AsyncEventManager.getInstance().post(new AnonymousClass4(r2, r3));
    }
}
