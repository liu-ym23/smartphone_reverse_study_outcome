package com.bytedance.apm.launch.evil;

import com.bytedance.apm.internal.FunctionSwitcher;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.monitor.collector.BinderMonitor;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LaunchBinderDetector {
    private static final String REPORT_TAG = "is_launch_binder";

    public LaunchBinderDetector() {
    }

    public static long fetchLaunchBinderData() {
        long r1 = 0;
        if (LaunchAnalysisContext.getInstance().getMonitorConfig().isDetectBinder() == true) goto L5;
    L15:
        return r1;
    L5:
        if (FunctionSwitcher.getSwitch(2) == false) goto L15;
        List<BinderMonitor.BinderInfo> r0 = PerfMonitorManager.getInstance().dumpBinderInfo();
        if (r0 != null) goto L9;
    L14:
        LaunchAnalysisContext.getInstance().logD("binder cost when launch: " + r1);
        goto L15
    L9:
        if (r0.isEmpty() == true) goto L14;
        Iterator<BinderMonitor.BinderInfo> r2 = r0.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        BinderMonitor.BinderInfo r3 = r2.next();
        long r4 = r3.getEnd() - r3.getBegin();
        r1 = r1 + r4;
        reportLongBinderData(r4, removeUselessStackTrace(r3.getElements()));
        goto L12
    }

    private static void reportLongBinderData(final long r2, final StackTraceElement[] r4) {
        AsyncEventManager.getInstance().post(new AnonymousClass1(r4, r2));
    }

    private static StackTraceElement[] removeUselessStackTrace(StackTraceElement[] r4) {
        if (r4 != null) goto L4;
        return r4;
    L4:
        if (r4.length == 0) goto L21;
        int r0 = 0;
        int r1 = 0;
    L8:
        if (r1 >= r4.length) goto L13;
        if ("saveBinderInfo".equals(r4[r1].getMethodName()) == true) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        r0 = r1;
    L13:
        int r2 = r0 + 1;
        if (r2 <= r4.length) goto L16;
        return r4;
    L16:
        return (StackTraceElement[]) Arrays.copyOfRange(r4, r2, r4.length);
    L21:
        return r4;
    }
}
