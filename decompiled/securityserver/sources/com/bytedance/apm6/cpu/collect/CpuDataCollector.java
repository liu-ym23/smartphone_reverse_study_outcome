package com.bytedance.apm6.cpu.collect;

import android.os.Process;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm.util.Pair;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.config.CpuConfig;
import com.bytedance.apm6.cpu.exception.ThreadCpuExceptionUtils;
import com.bytedance.apm6.cpu.exception.ThreadExceptionItem;
import com.bytedance.apm6.cpu.service.CurrentCpuDataHolder;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.service.lifecycle.DummyLifecycleListener;
import com.bytedance.apm6.service.perf.ICpuDataService;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.watson.assist.api.IAssistStat;
import com.ss.thor.ThorUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class CpuDataCollector extends DummyLifecycleListener {
    private static final long POLL_INTERVAL = 30000;
    private static final String TAG = "MonitorCpu";
    private IAssistStat assistStat;
    private CpuConfig cpuConfig;
    private boolean isFirstCollect;
    private CpuDataAssembler mAssembler;
    private AsyncTask mCollectAsyncTask;
    private long mCollectInterval;
    private long mCollectThreadInterval;
    private AtomicBoolean mIsStart;
    private long mLastThreadWorkTimestamp;
    private long mLastWorkTimestamp;

    public CpuDataCollector(CpuDataAssembler r3, IAssistStat r4) {
        this.isFirstCollect = true;
        this.mIsStart = new AtomicBoolean(false);
        this.mAssembler = r3;
        this.assistStat = r4;
    }

    public static /* synthetic */ long access$000(CpuDataCollector r2) {
        return r2.mCollectInterval;
    }

    public static /* synthetic */ void access$100(CpuDataCollector r0, boolean r1) {
        r0.refreshConfig(r1);
    }

    public static /* synthetic */ boolean access$200(CpuDataCollector r0) {
        return r0.isFirstCollect;
    }

    public static /* synthetic */ boolean access$202(CpuDataCollector r0, boolean r1) {
        r0.isFirstCollect = r1;
        return r1;
    }

    public static /* synthetic */ void access$300(CpuDataCollector r0) {
        r0.doCollectProcess();
    }

    public static /* synthetic */ void access$400(CpuDataCollector r0) {
        r0.doCollectThread();
    }

    private void doCollectProcess() {
        long r1 = System.currentTimeMillis();
        if ((r1 - this.mLastWorkTimestamp) >= this.mCollectInterval) goto L5;
        return;
    L5:
        this.mLastWorkTimestamp = r1;
        int r3 = CommonMonitorUtil.getCpuCoreNum();
        if (r3 > 0) goto L8;
        return;
    L8:
        long r4 = PerfMonitorManager.getInstance().dumpAppCPUTime();
        long r6 = PerfMonitorManager.getInstance().dumpTotalCPUTimeByTimeInStat(r3);
        Thread.sleep(360);     // Catch: InterruptedException -> L30
        long r8 = PerfMonitorManager.getInstance().dumpAppCPUTime();
        long r10 = PerfMonitorManager.getInstance().dumpTotalCPUTimeByTimeInStat(r3) - r6;
        if (r10 <= 0) goto L13;
        double r11 = (r8 - r4) / r10;
        ApmAlogHelper.feedbackI(TAG, "appCpuRate -> " + r11);
    L14:
        double r7 = (r8 - r4) * 1000.0d;
        double r5 = (r7 / (System.currentTimeMillis() - r1)) / CommonMonitorUtil.getScClkTck(100);
        if (ApmContext.isDebugMode() == false) goto L18;
        Logger.d(Constants.TAG, String.valueOf(r7) + " " + (System.currentTimeMillis() - r1) + " " + CommonMonitorUtil.getScClkTck(100));
    L18:
        if (ApmContext.isDebugMode() == false) goto L33;
        ApmAlogHelper.feedbackI(TAG, "appCpuSpeed -> " + r5);
        Logger.d(Constants.TAG, "collect cpu data, rate: " + r11 + " speed: " + r5);
    L33:
        this.assistStat.refreshCpuStat();     // Catch: Throwable -> L22
        IAssistStat.CpuFactorTag r2 = this.assistStat.getCpuFactorTag();     // Catch: Throwable -> L22
    L24:
        if (this.mAssembler.isStart() == false) goto L26;
        this.mAssembler.addCacheData(r11, r5);
        this.mAssembler.triggerAssemble(r2);
    L26:
        CurrentCpuDataHolder.getInstance().refreshData(r11, r5);
        ApmCpuManager.ICpuDataListener r12 = CpuCollectManager.getInstance().getDataListener();
        if (r12 == null) goto L35;
        r12.onCpuData(r5, r11, PerfFilterManager.getInstance().getSceneString(), r2, NetworkUtils.getNetworkTypeFast(ApmContext.getContext()));
        return;
    L35:
        return;
    L22:
        r2 = null;
        goto L24
    L13:
        r11 = -1.0d;
    }

    private void doCollectThread() {
        long r0 = System.currentTimeMillis();
        if ((r0 - this.mLastThreadWorkTimestamp) >= this.mCollectThreadInterval) goto L5;
        return;
    L5:
        this.mLastThreadWorkTimestamp = r0;
        HashMap r6 = new HashMap();
        HashMap r7 = new HashMap();
        ThreadCpuExceptionUtils.getThreadInfo(Process.myPid(), r6);
        Thread.sleep(100);     // Catch: InterruptedException -> L13
        ThreadCpuExceptionUtils.getThreadInfo(Process.myPid(), r7);
        IAssistStat.CpuFactorTag r1 = this.assistStat.getCpuFactorTag();     // Catch: Exception -> L10
    L11:
        doCollectThreadAndReport(0, r6, r7, r1);
        return;
    L10:
        r1 = null;
    L13:
        e = move-exception;
        Logger.e(Constants.TAG, "InterruptedException", e);
    }

    private void doCollectThreadAndReport(long r10, Map<Integer, ThreadExceptionItem> r12, Map<Integer, ThreadExceptionItem> r13, IAssistStat.CpuFactorTag r14) {
        if (r12.isEmpty() == false) goto L5;
        return;
    L5:
        if (r13.isEmpty() == true) goto L62;
        LinkedList r0 = new LinkedList();
        LinkedList<ICpuDataService.ThreadCpuItem> r1 = new LinkedList();
        Iterator<Map.Entry<Integer, ThreadExceptionItem>> r15 = r12.entrySet().iterator();
    L9:
        if (r15.hasNext() == false) goto L29;
        Map.Entry<Integer, ThreadExceptionItem> r2 = r15.next();
        ThreadExceptionItem r3 = r2.getValue();
        if (r3 == null) goto L9;
        ThreadExceptionItem r4 = r13.get(r2.getKey());
        if (r4 == null) goto L9;
        if (r4.getThreadName().equals(r3.getThreadName()) == false) goto L9;
        long r5 = r4.getThreadCpuTime() - r3.getThreadCpuTime();
        if (r5 == 0) goto L9;
        Logger.d(Constants.TAG, "cpu_thread=" + r4.getThreadName() + " thread_time=" + r5 + " app_time=" + r10);
        if (r10 == 0) goto L24;
        double r6 = r5 / r10;
        if (r6 <= 9.0E-4d) goto L9;
        r0.add(new Pair(r4.getThreadName(), Double.valueOf(String.format("%.3f", new Object[]{Double.valueOf(r6)}))));
        r1.add(new ICpuDataService.ThreadCpuItem(r4.getThreadName(), Double.valueOf(String.format("%.3f", new Object[]{Double.valueOf(r6)})).doubleValue(), r4.getThreadId()));
        goto L9
    L24:
        double r7 = r5;
        r0.add(new Pair(r4.getThreadName(), Double.valueOf(r7)));
        r1.add(new ICpuDataService.ThreadCpuItem(r4.getThreadName(), r7, r4.getThreadId()));
        goto L9
    L29:
        if (r0.isEmpty() == false) goto L31;
        return;
    L31:
        Collections.sort(r1, new AnonymousClass2(this));
        CurrentCpuDataHolder.getInstance().refreshTopThreadData(r1);
        if (this.cpuConfig.isEnableUpload() == true) goto L34;
        return;
    L34:
        if (CpuCollectManager.getInstance().isFront() == false) goto L36;
        CpuCacheItem.CpuDataType r11 = CpuCacheItem.CpuDataType.FRONT;
    L37:
        CpuReportEvent r16 = new CpuReportEvent(r11, PerfFilterManager.getInstance().getSceneString(), r0, r14);
        r16.setBatteryCurrent(ThorUtils.getGalvanicNow(ApmContext.getContext()));
        r16.setNormalSampleState(this.assistStat.isCpuSampleEnvironment());     // Catch: Throwable -> L41
    L39:
        Monitor.record(r16);
        return;
    L36:
        r11 = CpuCacheItem.CpuDataType.BACK;
        goto L37
    }

    private void initAsyncTask() {
        if (this.mCollectAsyncTask != null) goto L6;
        final long r3 = 30000;
        final long r5 = 30000;
        this.mCollectAsyncTask = new AnonymousClass1(this, r3, r5);
        return;
    }

    private void refreshConfig(boolean r3) {
        CpuConfig r0 = this.cpuConfig;
        if (r3 == false) goto L5;
        long r1 = r0.getFrontCollectInterval();
    L6:
        this.mCollectInterval = r1;
        if (r3 == false) goto L9;
        long r2 = this.cpuConfig.getFrontThreadCollectInterval();
    L10:
        this.mCollectThreadInterval = r2;
        return;
    L9:
        r2 = this.cpuConfig.getBackThreadCollectInterval();
        goto L10
    L5:
        r1 = r0.getBackCollectInterval();
        goto L6
    }

    public void resume() {
        if (this.mIsStart.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        initAsyncTask();
        if (this.mCollectAsyncTask == null) goto L11;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(this.mCollectAsyncTask);
    L11:
        this.assistStat.start();     // Catch: Throwable -> L10
        return;
    }

    public void start(CpuConfig r4) {
        if (this.mIsStart.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.cpuConfig = r4;
        initAsyncTask();
        if (this.mCollectAsyncTask == null) goto L11;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(this.mCollectAsyncTask);
    L11:
        this.assistStat.start();     // Catch: Throwable -> L10
        return;
    }

    public void stop() {
        if (this.mIsStart.compareAndSet(true, false) == true) goto L5;
        return;
    L5:
        if (this.mCollectAsyncTask == null) goto L14;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.mCollectAsyncTask);
        this.assistStat.end();     // Catch: Throwable -> L10
        return;
    L15:
        return;
    }
}
