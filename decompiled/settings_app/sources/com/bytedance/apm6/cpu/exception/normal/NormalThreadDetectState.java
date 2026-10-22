package com.bytedance.apm6.cpu.exception.normal;

import android.os.Looper;
import android.os.Process;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.BaseCpuExceptionState;
import com.bytedance.apm6.cpu.exception.CpuExceptionJudgeHelper;
import com.bytedance.apm6.cpu.exception.CpuExceptionManager;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.CpuLoadCollector;
import com.bytedance.apm6.cpu.exception.StateType;
import com.bytedance.apm6.cpu.exception.ThreadCpuExceptionUtils;
import com.bytedance.apm6.cpu.exception.ThreadExceptionItem;
import com.bytedance.apm6.cpu.service.CurrentCpuDataHolder;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.service.perf.ICpuDataService;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
class NormalThreadDetectState extends BaseCpuExceptionState {
    private static final long DETECT_INTERVAL = 1000;
    private static final int LIMIT_STACK_DEPTH = 40;
    private static final int MAX_JUDGE_TIME = 30000;
    private CpuExceptionConfig config;
    private AsyncTask detectTask;
    private boolean isBackground;
    private List<Double> loadList;
    private long startTime;
    private List<ThreadExceptionItem> threadExceptionCacheList;
    private List<ThreadExceptionItem> threadExceptionReportList;

    static /* synthetic */ void access$000(NormalThreadDetectState r0) {
        r0.judge();
    }

    public NormalThreadDetectState(CpuExceptionStateMachine r7) {
        super(r7);
        this.startTime = 0;
        this.loadList = new CopyOnWriteArrayList();
        this.threadExceptionReportList = new CopyOnWriteArrayList();
        this.threadExceptionCacheList = new CopyOnWriteArrayList();
        final long r2 = 0;
        final long r4 = 1000;
        this.detectTask = new AnonymousClass1(this, r2, r4);
    }

    private void judge() {
        if (CpuExceptionJudgeHelper.isNeedSkipJudge() == false) goto L6;
        reset();
        this.machine.onProcessDetect();
        return;
    L6:
        boolean r0 = judgeProcessLoad();
        if ((System.currentTimeMillis() - this.startTime) < getMaxJudgeInterval()) goto L10;
        reactOnFinish();
        return;
    L10:
        if (r0 == true) goto L13;
        cpuExceptionLog("not over process threshold");
        this.threadExceptionCacheList.clear();
        return;
    L13:
        collectThreadException();
    }

    private long getMaxJudgeInterval() {
        CpuExceptionConfig r4 = this.config;
        if (r4 != null) goto L7;
        return 30000;
    L7:
        return ((long) r4.getThreadDetectInterval()) * 1000;
    }

    private void collectThreadException() {
        if (this.threadExceptionCacheList.isEmpty() == false) goto L6;
        ThreadCpuExceptionUtils.getThreadInfo(Process.myPid(), this.threadExceptionCacheList);
        cpuExceptionLog("over process threshold, first collect thread info, list size: " + this.threadExceptionCacheList.size());
        return;
    L6:
        ThreadCpuExceptionUtils.filterThreads(Process.myPid(), this.threadExceptionCacheList, this.config.getMaxThreadCpuRate(), this.config.getMaxThreadCpuRateMap());
        cpuExceptionLog("over process threshold, second collect thread info, list size after filter is: " + this.threadExceptionCacheList.size());
        if (this.threadExceptionCacheList.isEmpty() == false) goto L10;
        return;
    L10:
        if (this.threadExceptionCacheList.size() <= 10) goto L14;
        this.threadExceptionCacheList.clear();
        return;
    L14:
        if (CpuExceptionManager.getInstance().needFetchStack() == false) goto L50;
        ThreadGroup r0 = Looper.getMainLooper().getThread().getThreadGroup();
        int r4 = r0.activeCount();
        int r5 = r4 + (r4 / 2);
        Thread[] r6 = new Thread[r5];
        r0.enumerate(r6);
        StringBuilder r1 = new StringBuilder();
        ListIterator<ThreadExceptionItem> r7 = this.threadExceptionCacheList.listIterator();
    L17:
        if (r7.hasNext() == false) goto L61;
        ThreadExceptionItem r8 = r7.next();
        if (r8 == null) goto L17;
        if (r8.getThreadId() == Process.myPid()) goto L24;
        int r9 = 0;
    L27:
        if (r9 >= r5) goto L43;
        Thread r10 = r6[r9];
        if (r10 == null) goto L43;
        if (r8.getThreadName().equals(r10.getName()) == true) goto L40;
        if (r10.getName().length() <= 15) goto L38;
        if (r8.getThreadName().equals(r10.getName().substring(0, 15)) == true) goto L40;
    L38:
        r9 = r9 + 1;
    L40:
        if (r10 == Thread.currentThread()) goto L42;
        assembleStackAndAddToReport(r8, r10, r1);
    L42:
        boolean r11 = true;
    L44:
        if (r11 == true) goto L17;
        if (this.config.isCollectNativeThread() == false) goto L17;
        String r12 = PerfMonitorManager.getInstance().dumpNativeStackTrace(r8.getThreadId());
        if (r12 == null) goto L17;
        r8.setStack(r12);
        r8.setWeight(String.format("%.2f", new Object[]{Double.valueOf(r8.getCpuUsage() / this.config.getMaxThreadCpuRate())}));
        this.threadExceptionReportList.add(r8);
    L43:
        r11 = false;
        goto L44
    L24:
        if (this.config.isCollectMainThread() == false) goto L17;
        assembleStackAndAddToReport(r8, Looper.getMainLooper().getThread(), r1);
    L61:
        Collections.sort(this.threadExceptionCacheList, new AnonymousClass2(this));
        LinkedList<ICpuDataService.ThreadCpuItem> r2 = new LinkedList();
        Iterator<ThreadExceptionItem> r3 = this.threadExceptionCacheList.iterator();
    L63:
        if (r3.hasNext() == false) goto L65;
        ThreadExceptionItem r13 = r3.next();
        r2.add(new ICpuDataService.ThreadCpuItem(r13.getThreadName(), r13.getCpuUsage(), r13.getThreadId()));
        goto L63
    L65:
        CurrentCpuDataHolder.getInstance().refreshExceptionTopThreadData(r2);
        this.threadExceptionCacheList.clear();
        return;
    L50:
        ListIterator<ThreadExceptionItem> r14 = this.threadExceptionCacheList.listIterator();
    L52:
        if (r14.hasNext() == false) goto L61;
        ThreadExceptionItem r15 = r14.next();
        if (r15 == null) goto L52;
        if (r15.getThreadId() != Process.myPid()) goto L60;
        if (this.config.isCollectMainThread() == false) goto L52;
    L60:
        r15.setWeight(String.format("%.2f", new Object[]{Double.valueOf(r15.getCpuUsage() / this.config.getMaxThreadCpuRate())}));
        this.threadExceptionReportList.add(r15);
        goto L52
    }

    private void assembleStackAndAddToReport(ThreadExceptionItem r9, Thread r10, StringBuilder r11) {
        StackTraceElement[] r12 = r10.getStackTrace();
        int r0 = r12.length;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r0) goto L9;
        StackTraceElement r5 = r12[r2];
        r3 = r3 + 1;
        r11.append("\tat ").append(r5.getClassName()).append(".").append(r5.getMethodName()).append("(").append(r5.getFileName()).append(":").append(r5.getLineNumber()).append(")\n");
        if (r3 > 40) goto L9;
        r2 = r2 + 1;
    L9:
        r9.setStack(r11.toString());
        r9.setWeight(String.format("%.2f", new Object[]{Double.valueOf(r9.getCpuUsage() / this.config.getMaxThreadCpuRate())}));
        this.threadExceptionReportList.add(r9);
        r11.setLength(0);
    }

    private void reactOnFinish() {
        if (this.loadList.isEmpty() == false) goto L5;
    L97:
        cpuExceptionLog("finish collect, but no exception thread is found");
        reset();
        this.machine.onProcessDetect();
        return;
    L5:
        if (this.threadExceptionReportList.isEmpty() == true) goto L97;
        Iterator<Double> r1 = this.loadList.iterator();
        double r4 = 0.0d;
        double r9 = 0.0d;
    L9:
        if (r1.hasNext() == false) goto L14;
        double r6 = r1.next().doubleValue();
        if (r9 >= r6) goto L13;
        r9 = r6;
    L13:
        r4 = r4 + r6;
        goto L9
    L14:
        cpuExceptionLog("report exception data, exception thread size is: " + this.threadExceptionReportList.size());
        double r7 = r4 / ((double) this.loadList.size());
        LinkedList r2 = new LinkedList();
        String[] r5 = CpuExceptionJudgeHelper.getCacheScene().split("#");
        String r11 = null;
        if (this.isBackground == false) goto L38;
        if (this.config.getBackSceneMaxSpeedMap().isEmpty() == true) goto L59;
        int r8 = r5.length;
        int r13 = 0;
        double r14 = 0.0d;
    L19:
        if (r13 >= r8) goto L33;
        String r12 = r5[r13];
        if (this.config.getBackSceneMaxSpeedMap().containsKey(r12) == false) goto L32;
        double r3 = this.config.getBackSceneMaxSpeedMap().get(r12).doubleValue();
        if (r3 < 0.0d) goto L32;
        if (r14 >= r3) goto L30;
        r14 = r3;
        r11 = r12;
    L30:
        if (r7 <= r3) goto L32;
        r2.add(r12);
    L32:
        r13 = r13 + 1;
        goto L19
    L33:
        if (r11 == null) goto L59;
        if (r2.contains(r11) == false) goto L59;
        r2.remove(r11);
        r2.add(0, r11);
    L59:
        if (r2.isEmpty() == true) goto L61;
    L68:
        CpuExceptionManager.getInstance().setLastExceptionTimestamp(System.currentTimeMillis());
        ApmCpuManager.ICpuExceptionListener r10 = CpuExceptionManager.getInstance().getExceptionListener();
        if (r10 == null) goto L72;
        r10.onException(r7);
    L72:
        if (r2.isEmpty() == true) goto L74;
        String r15 = ListUtils.arrayToString(r2.toArray(), "#");
        if (this.isBackground == false) goto L90;
        if (r7 <= this.config.getMaxProcessBackCpuSpeed()) goto L90;
        r15 = r15 + "#apm_max_background";
    L94:
        Monitor.record(new CpuNormalExceptionEvent(r7, r9, this.threadExceptionReportList, r15, this.isBackground));
    L95:
        reset();
        this.machine.onCoolDown();
        return;
    L90:
        if (this.isBackground == true) goto L94;
        if (r7 <= this.config.getMaxProcessForeCpuSpeed()) goto L94;
        r15 = r15 + "#apm_max_foreground";
        goto L94
    L74:
        if (this.isBackground == false) goto L79;
        if (r7 <= this.config.getMaxProcessBackCpuSpeed()) goto L79;
        r15 = CpuNormalExceptionEvent.KEY_MAX_BACKGROUND;
    L79:
        if (this.isBackground == false) goto L81;
    L83:
        r15 = "";
        goto L94
    L81:
        if (r7 <= this.config.getMaxProcessForeCpuSpeed()) goto L83;
        r15 = CpuNormalExceptionEvent.KEY_MAX_FOREGROUND;
        goto L94
    L61:
        if (this.isBackground == false) goto L65;
        if (r7 > this.config.getMaxProcessBackCpuSpeed()) goto L68;
    L65:
        if (this.isBackground == true) goto L95;
        if (r7 <= this.config.getMaxProcessForeCpuSpeed()) goto L95;
    L38:
        if (this.config.getForeSceneMaxSpeedMap().isEmpty() == true) goto L59;
        int r16 = r5.length;
        int r17 = 0;
        double r18 = 0.0d;
    L40:
        if (r17 >= r16) goto L54;
        String r19 = r5[r17];
        if (this.config.getForeSceneMaxSpeedMap().containsKey(r19) == false) goto L53;
        double r110 = this.config.getForeSceneMaxSpeedMap().get(r19).doubleValue();
        if (r110 < 0.0d) goto L53;
        if (r18 >= r110) goto L51;
        r11 = r19;
        r18 = r110;
    L51:
        if (r7 <= r110) goto L53;
        r2.add(r19);
    L53:
        r17 = r17 + 1;
        goto L40
    L54:
        if (r11 == null) goto L59;
        if (r2.contains(r11) == false) goto L59;
        r2.remove(r11);
        r2.add(0, r11);
        goto L59
    }

    private boolean judgeProcessLoad() {
        double r0 = CpuLoadCollector.collectSpeed();
        this.loadList.add(Double.valueOf(r0));
        return CpuExceptionJudgeHelper.judge(this.config, r0, this.isBackground);
    }

    private void reset() {
        this.loadList.clear();
        this.threadExceptionReportList.clear();
        this.threadExceptionCacheList.clear();
        this.startTime = 0;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.detectTask);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(CpuExceptionConfig r3, boolean r4) {
        super.onEnterThisState(r3, r4);
        this.config = r3;
        this.startTime = System.currentTimeMillis();
        this.isBackground = r4;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(this.detectTask);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        super.onStopDetect();
        reset();
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r1) {
        super.onLifeCycleChange(r1);
        reset();
        this.machine.onIdle();
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.THREAD_DETECT;
    }
}
