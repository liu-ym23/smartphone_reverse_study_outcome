package com.bytedance.apm;

import android.util.Log;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MonitorCoreExceptionManager {
    private static final String TAG = "apm_";
    private ExceptionCallBack mExceptionCallBack;
    private HashSet<String> mOnceMessages;

    public interface ExceptionCallBack {
        void directReportError(StackTraceElement r1, String r2, String r3);

        void directReportError(Throwable r1, String r2);

        void ensureNotReachHere(String r1);

        void ensureNotReachHere(Throwable r1, String r2);

        void ensureNotReachHere(Throwable r1, String r2, Map<String, String> r3);
    }

    private static class Holder {
        private static final MonitorCoreExceptionManager INSTANCE = null;

        private Holder() {
        }

        static /* synthetic */ MonitorCoreExceptionManager access$100() {
            return INSTANCE;
        }

        static {
            INSTANCE = new MonitorCoreExceptionManager(null);
        }
    }

    /* synthetic */ MonitorCoreExceptionManager(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ ExceptionCallBack access$200(MonitorCoreExceptionManager r0) {
        return r0.mExceptionCallBack;
    }

    private MonitorCoreExceptionManager() {
        this.mOnceMessages = new HashSet();
    }

    public static MonitorCoreExceptionManager getInstance() {
        return Holder.access$100();
    }

    public void setExceptionCallback(ExceptionCallBack r1) {
        this.mExceptionCallBack = r1;
        setExceptionCallbackForAsyncTask();
    }

    private void setExceptionCallbackForAsyncTask() {
        AsyncTaskUtil.getAsyncTaskManagerInstance().setExceptionListener(new AnonymousClass1(this));
    }

    public void ensureNotReachHere(Throwable r3, String r4) {
        if (this.mExceptionCallBack == null) goto L8;
        if (this.mOnceMessages.contains(r4) == true) goto L8;
        this.mOnceMessages.add(r4);
        this.mExceptionCallBack.ensureNotReachHere(r3, TAG + r4);
    L8:
        if (ApmContext.isDebugMode() == false) goto L11;
        r3.printStackTrace();
        return;
    }

    public void directReportError(Throwable r1, String r2) {
        ExceptionCallBack r0 = this.mExceptionCallBack;     // Catch: Throwable -> L12
        if (r0 == null) goto L6;
        r0.directReportError(r1, r2);     // Catch: Throwable -> L12
    L6:
        if (ApmContext.isDebugMode() == true) goto L11;
        if (ApmContext.isLocalChannel() == true) goto L11;
        return;
    L11:
        throw new RuntimeException(r1);
    }

    public void ensureNotReachHere(String r3) {
        if (this.mExceptionCallBack == null) goto L8;
        if (this.mOnceMessages.contains(r3) == true) goto L8;
        this.mOnceMessages.add(r3);
        this.mExceptionCallBack.ensureNotReachHere(TAG + r3);
    L8:
        if (ApmContext.isDebugMode() == false) goto L11;
        Log.e(TAG, "ensureNotReachHere", new RuntimeException(r3));
        System.exit(1);
        return;
    }

    public void ensureNotReachHere(Throwable r3, String r4, Map<String, String> r5) {
        if (this.mExceptionCallBack != null) goto L5;
        return;
    L5:
        if (this.mOnceMessages.contains(r4) == true) goto L9;
        this.mOnceMessages.add(r4);
        this.mExceptionCallBack.ensureNotReachHere(r3, TAG + r4, r5);
        return;
    }
}
