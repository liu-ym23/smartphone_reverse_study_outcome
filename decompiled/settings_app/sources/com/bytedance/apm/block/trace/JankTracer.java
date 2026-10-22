package com.bytedance.apm.block.trace;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class JankTracer {
    private static final int DEFAULT_END_TAG = 0;
    private static volatile JankTracer sInstance = null;
    private static volatile boolean sNeePostEnd = false;
    private volatile IJankCalculator mJankCalculator;

    static class DefaultJankCalculator implements IJankCalculator {
        @Override // com.bytedance.apm.block.trace.JankTracer.IJankCalculator
        public void collectEnd() {
        }

        @Override // com.bytedance.apm.block.trace.JankTracer.IJankCalculator
        public void doFrame(long r1, long[] r3) {
        }

        @Override // com.bytedance.apm.block.trace.JankTracer.IJankCalculator
        public boolean needFilter() {
            return false;
        }

        DefaultJankCalculator() {
        }
    }

    public interface IJankCalculator {
        void collectEnd();

        void doFrame(long r1, long[] r3);

        boolean needFilter();
    }

    static {
    }

    public void reportJank(JSONObject r1) {
    }

    static /* synthetic */ IJankCalculator access$000(JankTracer r0) {
        return r0.mJankCalculator;
    }

    private JankTracer() {
    }

    public static JankTracer getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(JankTracer.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new JankTracer();     // Catch: Throwable -> L11
    L9:
        monitor-exit(JankTracer.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void setJankCalculator(IJankCalculator r1) {
        if (r1 == null) goto L5;
        this.mJankCalculator = r1;
        return;
    }

    public void doFrame(final long[] r3, final long r4) {
        if (this.mJankCalculator != null) goto L6;
        return;
    L6:
        if (this.mJankCalculator.needFilter() == true) goto L9;
        MainThreadMonitor.getMonitor().mThreadWithBlockingQueue.post(new AnonymousClass1(this, r4, r3));
        sNeePostEnd = true;
        return;
    L9:
        if (sNeePostEnd == false) goto L13;
        MainThreadMonitor.getMonitor().mThreadWithBlockingQueue.post(new AnonymousClass2(this));
        sNeePostEnd = false;
        return;
    }
}
