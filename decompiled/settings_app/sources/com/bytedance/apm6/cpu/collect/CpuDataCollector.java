package com.bytedance.apm6.cpu.collect;

import android.os.Process;
import com.android.settings.utils.HanziToPinyin;
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

/* JADX INFO: loaded from: classes3.dex */
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

    static /* synthetic */ long access$000(CpuDataCollector r2) {
        return r2.mCollectInterval;
    }

    static /* synthetic */ void access$100(CpuDataCollector r0, boolean r1) {
        r0.refreshConfig(r1);
    }

    static /* synthetic */ boolean access$200(CpuDataCollector r0) {
        return r0.isFirstCollect;
    }

    static /* synthetic */ boolean access$202(CpuDataCollector r0, boolean r1) {
        r0.isFirstCollect = r1;
        return r1;
    }

    static /* synthetic */ void access$300(CpuDataCollector r0) {
        r0.doCollectProcess();
    }

    static /* synthetic */ void access$400(CpuDataCollector r0) {
        r0.doCollectThread();
    }

    CpuDataCollector(CpuDataAssembler r3, IAssistStat r4) {
        this.isFirstCollect = true;
        this.mIsStart = new AtomicBoolean(false);
        this.mAssembler = r3;
        this.assistStat = r4;
    }

    void start(CpuConfig r4) {
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

    void stop() {
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

    void resume() {
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

    private void initAsyncTask() {
        if (this.mCollectAsyncTask != null) goto L6;
        final long r3 = 30000;
        final long r5 = 30000;
        this.mCollectAsyncTask = new AnonymousClass1(this, r3, r5);
        return;
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
        Thread.sleep(100);     // Catch: InterruptedException -> L8
        boolean r1 = false;
    L10:
        if (r1 == false) goto L12;
        return;
    L12:
        ThreadCpuExceptionUtils.getThreadInfo(Process.myPid(), r7);
        IAssistStat.CpuFactorTag r2 = this.assistStat.getCpuFactorTag();     // Catch: Exception -> L15
    L16:
        doCollectThreadAndReport(0, r6, r7, r2);
        return;
    L15:
        r2 = null;
    L8:
        e = move-exception;
        Logger.e(Constants.TAG, "InterruptedException", e);
        r1 = true;
        goto L10
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
        Thread.sleep(360);     // Catch: InterruptedException -> L11
        boolean r8 = false;
    L12:
        if (r8 == false) goto L14;
        return;
    L14:
        long r9 = PerfMonitorManager.getInstance().dumpAppCPUTime();
        long r10 = PerfMonitorManager.getInstance().dumpTotalCPUTimeByTimeInStat(r3) - r6;
        if (r10 <= 0) goto L17;
        double r11 = (r9 - r4) / r10;
        ApmAlogHelper.feedbackI(TAG, "appCpuRate -> " + r11);
    L18:
        double r7 = (r9 - r4) * 1000.0d;
        double r5 = (r7 / (System.currentTimeMillis() - r1)) / CommonMonitorUtil.getScClkTck(100);
        if (ApmContext.isDebugMode() == false) goto L22;
        Logger.d(Constants.TAG, String.valueOf(r7) + HanziToPinyin.Token.SEPARATOR + (System.currentTimeMillis() - r1) + HanziToPinyin.Token.SEPARATOR + CommonMonitorUtil.getScClkTck(100));
    L22:
        if (ApmContext.isDebugMode() == false) goto L36;
        ApmAlogHelper.feedbackI(TAG, "appCpuSpeed -> " + r5);
        Logger.d(Constants.TAG, "collect cpu data, rate: " + r11 + " speed: " + r5);
    L36:
        this.assistStat.refreshCpuStat();     // Catch: Throwable -> L26
        IAssistStat.CpuFactorTag r2 = this.assistStat.getCpuFactorTag();     // Catch: Throwable -> L26
    L28:
        if (this.mAssembler.isStart() == false) goto L30;
        this.mAssembler.addCacheData(r11, r5);
        this.mAssembler.triggerAssemble(r2);
    L30:
        CurrentCpuDataHolder.getInstance().refreshData(r11, r5);
        ApmCpuManager.ICpuDataListener r12 = CpuCollectManager.getInstance().getDataListener();
        if (r12 == null) goto L38;
        r12.onCpuData(r5, r11, PerfFilterManager.getInstance().getSceneString(), r2, NetworkUtils.getNetworkTypeFast(ApmContext.getContext()));
        return;
    L38:
        return;
    L26:
        r2 = null;
        goto L28
    L17:
        r11 = -1.0d;
    L11:
        r8 = true;
        goto L12
    }

    private void doCollectThreadAndReport(long r17, Map<Integer, ThreadExceptionItem> r19, Map<Integer, ThreadExceptionItem> r20, IAssistStat.CpuFactorTag r21) {
        if (r19.isEmpty() == false) goto L5;
        return;
    L5:
        if (r20.isEmpty() == true) goto L62;
        LinkedList r3 = new LinkedList();
        LinkedList<ICpuDataService.ThreadCpuItem> r4 = new LinkedList();
        Iterator<Map.Entry<Integer, ThreadExceptionItem>> r5 = r19.entrySet().iterator();
    L9:
        if (r5.hasNext() == false) goto L29;
        Map.Entry<Integer, ThreadExceptionItem> r6 = r5.next();
        ThreadExceptionItem r7 = r6.getValue();
        if (r7 == null) goto L9;
        ThreadExceptionItem r8 = r20.get(r6.getKey());
        if (r8 == null) goto L9;
        if (r8.getThreadName().equals(r7.getThreadName()) == false) goto L9;
        long r9 = r8.getThreadCpuTime() - r7.getThreadCpuTime();
        if (r9 == 0) goto L9;
        Logger.d(Constants.TAG, "cpu_thread=" + r8.getThreadName() + " thread_time=" + r9 + " app_time=" + r17);
        if (r17 == 0) goto L24;
        double r10 = r9 / r17;
        if (r10 <= 9.0E-4d) goto L9;
        r3.add(new Pair(r8.getThreadName(), Double.valueOf(String.format("%.3f", new Object[]{Double.valueOf(r10)}))));
        r4.add(new ICpuDataService.ThreadCpuItem(r8.getThreadName(), Double.valueOf(String.format("%.3f", new Object[]{Double.valueOf(r10)})).doubleValue(), r8.getThreadId()));
        goto L9
    L24:
        double r11 = r9;
        r3.add(new Pair(r8.getThreadName(), Double.valueOf(r11)));
        r4.add(new ICpuDataService.ThreadCpuItem(r8.getThreadName(), r11, r8.getThreadId()));
        goto L9
    L29:
        if (r3.isEmpty() == false) goto L31;
        return;
    L31:
        Collections.sort(r4, new AnonymousClass2(this));
        CurrentCpuDataHolder.getInstance().refreshTopThreadData(r4);
        if (this.cpuConfig.isEnableUpload() == true) goto L34;
        return;
    L34:
        if (CpuCollectManager.getInstance().isFront() == false) goto L36;
        CpuCacheItem.CpuDataType r1 = CpuCacheItem.CpuDataType.FRONT;
    L37:
        CpuReportEvent r2 = new CpuReportEvent(r1, PerfFilterManager.getInstance().getSceneString(), r3, r21);
        r2.setBatteryCurrent(ThorUtils.getGalvanicNow(ApmContext.getContext()));
        r2.setNormalSampleState(this.assistStat.isCpuSampleEnvironment());     // Catch: Throwable -> L41
    L39:
        Monitor.record(r2);
        return;
    L36:
        r1 = CpuCacheItem.CpuDataType.BACK;
        goto L37
    }
}
