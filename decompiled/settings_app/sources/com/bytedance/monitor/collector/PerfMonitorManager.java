package com.bytedance.monitor.collector;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.thread.ThreadWithHandler;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import com.bytedance.monitor.util.jni.SafelyLibraryLoader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PerfMonitorManager {
    private static volatile PerfMonitorManager sPerfMonitorManager = null;
    private static ISoLoader sSoLoader = null;
    static volatile boolean soLoaded = false;
    private volatile boolean isConfigReady;
    private boolean isEnableCpuOpt;
    private volatile boolean isEnableStackSampling;
    private volatile boolean isEvilMethodEnable;
    private volatile boolean isHyperMode;
    private volatile boolean isInited;
    private boolean isLockStackFetchOpen;
    private volatile boolean isNeedInitAlog;
    private volatile boolean isStarted;
    private AtraceMonitor mAtraceMonitor;
    private BinderMonitor mBinderMonitor;
    private IHyperMonitor mHyperMonitor;
    private MonitorConfig mInitMonitorConfig;
    private LooperDispatchMonitor mLooperDispatchMonitor;
    private final List<AbsMonitor> mMonitorList;
    private ProcMonitor mProcMonitor;
    private IProfilerMonitor mProfilerMonitor;
    protected ThreadWithHandler mThreadWithHandler;

    public interface ISoLoader {
        void loadLibrary(String r1);
    }

    static {
    }

    public void setEnableCpuOpt(boolean r1) {
        this.isEnableCpuOpt = r1;
    }

    public static PerfMonitorManager getInstance() {
        if (sPerfMonitorManager != null) goto L15;
        monitor-enter(PerfMonitorManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sPerfMonitorManager != null) goto L9;
        sPerfMonitorManager = new PerfMonitorManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PerfMonitorManager.class);     // Catch: Throwable -> L11
    L15:
        return sPerfMonitorManager;
    }

    public static boolean isSoLoaded() {
        return soLoaded;
    }

    public static synchronized boolean loadLibrary(Context r2) {
        monitor-enter(PerfMonitorManager.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (soLoaded == true) goto L11;
        ISoLoader r1 = sSoLoader;     // Catch: Throwable -> L14
        if (r1 == null) goto L9;
        r1.loadLibrary("monitorcollector-lib");     // Catch: Throwable -> L14
        soLoaded = true;     // Catch: Throwable -> L14
    L10:
        ByteHook.init();     // Catch: Throwable -> L14
        goto L11
    L9:
        soLoaded = SafelyLibraryLoader.loadLibrary(r2, "monitorcollector-lib");     // Catch: Throwable -> L14
    L11:
        boolean r3 = soLoaded;     // Catch: Throwable -> L14
        monitor-exit(PerfMonitorManager.class);
        return r3;
    }

    public boolean hasInited() {
        return this.isInited;
    }

    public synchronized void init(Context r3, MonitorConfig r4) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.isInited == false) goto L13;
        if (ApmContext.isDebugMode() == false) goto L9;
        Log.w("PerfMonitorManager", "PerfMonitorManager init twice? " + r4, new Throwable());     // Catch: Throwable -> L17
    L9:
        updateConfig(r4);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L13:
        if (loadLibrary(r3) == false) goto L15;
        ProcMonitor.init();     // Catch: Throwable -> L17
        updateConfig(r4);     // Catch: Throwable -> L17
        this.isInited = true;     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
    }

    public synchronized boolean updateConfig(MonitorConfig r6) {
        monitor-enter(this);
        this.mInitMonitorConfig = r6;     // Catch: Throwable -> L43
        if (ApmContext.isDebugMode() == false) goto L9;
        Log.i("PerfMonitorManager", "PerfMonitorManager update config:\n " + r6);     // Catch: Throwable -> L43
        doSetDebugMode(true);     // Catch: Throwable -> L43
    L9:
        if (isSoLoaded() == true) goto L12;
        monitor-exit(this);
        return false;
    L12:
        this.isEnableStackSampling = r6.isEnableStackSampling();     // Catch: Throwable -> L43
        IProfilerMonitor r0 = this.mProfilerMonitor;     // Catch: Throwable -> L43
        if (r0 == null) goto L22;
        if (this.isEvilMethodEnable == false) goto L17;
    L19:
        boolean r3 = false;
    L20:
        r0.enableEvilMethodCollect(r3);     // Catch: Throwable -> L43
        goto L22
    L17:
        if (this.isEnableStackSampling == false) goto L19;
        r3 = true;
    L22:
        if (this.mProcMonitor != null) goto L25;
        this.mProcMonitor = new ProcMonitor(r6.getRunMode());     // Catch: Throwable -> L43
    L25:
        if (r6.isEnableBinder() == false) goto L31;
        if (this.mBinderMonitor != null) goto L29;
        this.mBinderMonitor = new BinderMonitor(r6.getRunMode());     // Catch: Throwable -> L43
    L29:
        this.mBinderMonitor.enable();     // Catch: Throwable -> L43
    L31:
        if (r6.isEnableAtrace() == false) goto L37;
        if (this.mAtraceMonitor != null) goto L35;
        this.mAtraceMonitor = new AtraceMonitor(r6.getRunMode());     // Catch: Throwable -> L43
    L35:
        this.mAtraceMonitor.enableAtrace(r6.getAtraceTag());     // Catch: Throwable -> L43
    L37:
        if (r6.isEnableLooperMonitor() == true) goto L39;
    L41:
        monitor-exit(this);
        return true;
    L39:
        if (this.mLooperDispatchMonitor != null) goto L41;
        this.mLooperDispatchMonitor = new LooperDispatchMonitor(r6.getRunMode(), false);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    }

    public MonitorConfig getMonitorConfig() {
        return this.mInitMonitorConfig;
    }

    public void enableAtrace() {
        if (this.isInited == true) goto L5;
        return;
    L5:
        enableAtrace(this.mInitMonitorConfig.getAtraceTag());
    }

    public void enableAtrace(long r3) {
        if (this.isInited == true) goto L6;
        return;
    L6:
        if (this.mAtraceMonitor != null) goto L8;
        this.mAtraceMonitor = new AtraceMonitor(this.mInitMonitorConfig.getRunMode());
    L8:
        this.mAtraceMonitor.enableAtrace(r3);
    }

    public void disableAtrace() {
        if (this.isInited == true) goto L5;
        return;
    L5:
        AtraceMonitor r1 = this.mAtraceMonitor;
        if (r1 == null) goto L9;
        r1.disableAtrace();
        return;
    }

    public void refreshMonitorConfig(int r2) {
        if (this.isConfigReady == false) goto L10;
        Iterator<AbsMonitor> r1 = this.mMonitorList.iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        AbsMonitor r0 = r1.next();
        if (r0 == null) goto L6;
        r0.refreshConfig(r2);
        goto L6
    L16:
        return;
    }

    public static void setSoLoader(ISoLoader r0) {
        sSoLoader = r0;
    }

    public void onReady() {
        this.isConfigReady = true;
    }

    private PerfMonitorManager() {
        this.isInited = false;
        this.isStarted = false;
        this.isHyperMode = false;
        this.isConfigReady = false;
        this.isEvilMethodEnable = false;
        this.isEnableStackSampling = false;
        this.isNeedInitAlog = false;
        this.isLockStackFetchOpen = false;
        this.mMonitorList = new CopyOnWriteArrayList();
        ActivityLifeObserver.getInstance().register(new AnonymousClass1(this));
    }

    public void addCollector(AbsMonitor r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.mMonitorList.contains(r2) == true) goto L10;
        this.mMonitorList.add(r2);
        if (this.isStarted == false) goto L11;
        r2.start();
        return;
    L11:
        return;
    }

    public IHyperMonitor.ILogInstance getLogInstance() {
        IHyperMonitor r0 = this.mHyperMonitor;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLogInstance();
    }

    public void setHyperMonitor(IHyperMonitor r1) {
        this.mHyperMonitor = r1;
    }

    void setProfilerMonitor(IProfilerMonitor r2) {
        this.mProfilerMonitor = r2;
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.isEvilMethodEnable == false) goto L7;
    L9:
        boolean r1 = false;
    L10:
        r2.enableEvilMethodCollect(r1);
        return;
    L7:
        if (this.isEnableStackSampling == false) goto L9;
        r1 = true;
        goto L10
    }

    public void startStackSampling() {
        if (this.mProfilerMonitor != null) goto L5;
        return;
    L5:
        if (this.isEnableStackSampling == false) goto L9;
        this.mProfilerMonitor.start();
        return;
    }

    public void stopStackSampling() {
        if (this.mProfilerMonitor != null) goto L5;
        return;
    L5:
        if (this.isEnableStackSampling == false) goto L9;
        this.mProfilerMonitor.stop();
        return;
    }

    public void setEvilMethodEnable(boolean r1) {
        this.isEvilMethodEnable = r1;
    }

    public void removeCollector(AbsMonitor r1) {
        if (r1 == null) goto L5;
        this.mMonitorList.remove(r1);
        r1.destroy();
        return;
    }

    public void start() {
        int r0 = 0;
    L4:
        if (r0 >= this.mMonitorList.size()) goto L6;
        this.mMonitorList.get(r0).start();
        r0 = r0 + 1;
        goto L4
    L6:
        this.isStarted = true;
    }

    public void stop() {
        int r1 = 0;
    L4:
        if (r1 >= this.mMonitorList.size()) goto L6;
        this.mMonitorList.get(r1).stop();
        r1 = r1 + 1;
        goto L4
    L6:
        this.isStarted = false;
    }

    void doSetDebugMode(boolean r1) {
        if (soLoaded == true) goto L5;
        return;
    L5:
        MonitorJni.doSetDebugMode(r1);     // Catch: Throwable -> L7
        return;
    }

    public synchronized void initALogInstance() {
        monitor-enter(this);
        this.isNeedInitAlog = true;     // Catch: Throwable -> L11
        IHyperMonitor r0 = this.mHyperMonitor;     // Catch: Throwable -> L11
        if (r0 != null) goto L7;
    L9:
        monitor-exit(this);
        return;
    L7:
        if (r0.getLogInstance() == null) goto L9;
        MonitorJni.setAlogInstance(this.mHyperMonitor.getLogInstance().getNativeReference());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    void initProfiler() {
        if (this.mHyperMonitor != null) goto L5;
        return;
    L5:
        if (this.mProfilerMonitor != null) goto L8;
        return;
    L8:
        if (this.isEvilMethodEnable == false) goto L11;
        return;
    L11:
        if (this.mHyperMonitor.getLogInstance() == null) goto L13;
        this.mProfilerMonitor.init(ApmContext.getContext(), this.mHyperMonitor.getLogInstance().getNativeReference());
    L13:
        startStackSampling();
        if (this.isNeedInitAlog == true) goto L16;
        return;
    L16:
        if (this.mHyperMonitor.getLogInstance() == null) goto L21;
        MonitorJni.setAlogInstance(this.mHyperMonitor.getLogInstance().getNativeReference());
        return;
    }

    public ThreadWithHandler getThreadWithHandler() {
        return this.mThreadWithHandler;
    }

    synchronized void startHyperMode() {
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L4:
        if (this.mHyperMonitor != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.isHyperMode == false) goto L12;
        monitor-exit(this);
        return;
    L12:
        if (this.mHyperMonitor.getLogInstance() == null) goto L15;
        MonitorJni.setAlogInstance(this.mHyperMonitor.getLogInstance().getNativeReference());     // Catch: Throwable -> L29
    L15:
        if (this.mThreadWithHandler != null) goto L18;
        ThreadWithHandler r0 = new ThreadWithHandler("hyper_mode");     // Catch: Throwable -> L29
        this.mThreadWithHandler = r0;     // Catch: Throwable -> L29
        r0.start();     // Catch: Throwable -> L29
    L18:
        if (this.mProfilerMonitor != null) goto L20;
    L22:
        MonitorJni.startHyperMonitor();     // Catch: Throwable -> L29
        int r1 = 0;
    L24:
        if (r1 >= this.mMonitorList.size()) goto L26;
        this.mMonitorList.get(r1).startHyperMode();     // Catch: Throwable -> L29
        r1 = r1 + 1;     // Catch: Throwable -> L29
        goto L24
    L26:
        this.isHyperMode = true;     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L20:
        if (this.isEvilMethodEnable == true) goto L22;
        this.mProfilerMonitor.start();     // Catch: Throwable -> L29
        goto L22
    }

    synchronized void stopHyperMode() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.isHyperMode == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        MonitorJni.stopHyperMonitor();     // Catch: Throwable -> L17
        IProfilerMonitor r0 = this.mProfilerMonitor;     // Catch: Throwable -> L17
        if (r0 == null) goto L10;
        r0.stop();     // Catch: Throwable -> L17
    L10:
        int r1 = 0;
    L12:
        if (r1 >= this.mMonitorList.size()) goto L14;
        this.mMonitorList.get(r1).stopHyperMode();     // Catch: Throwable -> L17
        r1 = r1 + 1;     // Catch: Throwable -> L17
        goto L12
    L14:
        this.isHyperMode = false;     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    public void destory() {
        int r0 = 0;
    L4:
        if (r0 >= this.mMonitorList.size()) goto L6;
        this.mMonitorList.get(r0).destroy();
        r0 = r0 + 1;
        goto L4
    L6:
        this.mMonitorList.clear();
    }

    public synchronized void startLockDetect(long r2) {
        monitor-enter(this);
        LockMonitorManager.setOpenFetchStack(true);     // Catch: Throwable -> L9
        if (soLoaded == true) goto L13;
    L7:
        monitor-exit(this);
        return;
    L13:
        MonitorJni.enableLock(r2);     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void startLockDetect(long r2, boolean r4) {
        monitor-enter(this);
        LockMonitorManager.setOpenFetchStack(true);     // Catch: Throwable -> L9
        if (soLoaded == true) goto L13;
    L7:
        monitor-exit(this);
        return;
    L13:
        MonitorJni.enableLockAll(r2, r4);     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void endLockDetect() {
        monitor-enter(this);
        LockMonitorManager.setOpenFetchStack(false);     // Catch: Throwable -> L9
        if (soLoaded == true) goto L13;
    L7:
        monitor-exit(this);
        return;
    L13:
        MonitorJni.disableLock();     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;
    }

    public List<BinderMonitor.BinderInfo> dumpBinderInfo() {
        BinderMonitor r0 = this.mBinderMonitor;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getBinderInfoListCopy();
    }

    public JSONObject dumpInfos() {
        JSONObject r0 = new JSONObject();
        int r1 = 0;
    L10:
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        return r0;
    L4:
        if (r1 >= this.mMonitorList.size()) goto L9;
        Pair<String, ?> r2 = this.mMonitorList.get(r1).dumpInfo();     // Catch: Exception -> L7
        r0.put((String) r2.first, r2.second);     // Catch: Exception -> L7
        r1 = r1 + 1;
        goto L10
    }

    public JSONObject dumpInfos(long r5, long r7, boolean r9) {
        JSONObject r0 = new JSONObject();
        int r1 = 0;
    L4:
        if (r1 >= this.mMonitorList.size()) goto L12;
        AbsMonitor r2 = this.mMonitorList.get(r1);     // Catch: Exception -> L13
        if (r9 == true) goto L8;
    L10:
        Pair<String, ?> r3 = r2.dumpInfosRange(r5, r7);     // Catch: Exception -> L13
        r0.put((String) r3.first, r3.second);     // Catch: Exception -> L13
        goto L11
    L8:
        if ((r2 instanceof LooperDispatchMonitor) == false) goto L10;
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        return r0;
    }

    public JSONObject dumpInfos(long r7, long r9) {
        return dumpInfos(r7, r9, false);
    }

    public long dumpTotalCPUTimeByTimeInStat(int r3) {
        if (this.isEnableCpuOpt == true) goto L7;
        return CommonMonitorUtil.getTotalCPUTimeByTimeInStat();
    L7:
        if (isSoLoaded() == true) goto L12;
        return 0;
    L12:
        return MonitorJni.getTotalCPUTimeByTimeInStat(r3);
    L11:
        return 0;
    }

    public long dumpAppCPUTime() {
        if (this.isEnableCpuOpt == true) goto L7;
        return CommonMonitorUtil.getAppCPUTime();
    L7:
        if (isSoLoaded() == true) goto L12;
        return 0;
    L12:
        return MonitorJni.doGetAppCpuTime();
    L14:
        return 0;
    }

    public ThreadStatInfo dumpThreadStatInfo(int r1, int r2) {
        return MonitorJni.getThreadStatInfo(r1, r2);
    }

    public int getProcCGroup(int r1) {
        return MonitorJni.getProcCGroup(r1);
    }

    public boolean readProcFile(String r1, int[] r2, Object[] r3, long[] r4, float[] r5) {
        return MonitorJni.readProcFile(r1, r2, r3, r4, r5);
    }

    public String dumpStackTrace(long r2, long r4) {
        if (this.mProfilerMonitor != null) goto L5;
        return null;
    L5:
        if (this.isEvilMethodEnable == false) goto L8;
        return null;
    L8:
        return this.mProfilerMonitor.dumpStack(r2, r4);
    }

    public String dumpNativeStackTrace(int r1) {
        return MonitorJni.doDumpNativeStack(r1);
    }

    public String dumpSortedStackTrace(long r2, long r4) {
        if (this.mProfilerMonitor != null) goto L5;
        return null;
    L5:
        if (this.isEvilMethodEnable == false) goto L8;
        return null;
    L8:
        return SamplingStackUtil.getStackString(this.mProfilerMonitor.dumpStack(r2, r4));
    }

    public void dumpInfoToALog(long r10, long r12, long r14) {
        if (this.isHyperMode == false) goto L5;
        return;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mMonitorList.size()) goto L13;
        AbsMonitor r2 = this.mMonitorList.get(r0);     // Catch: Exception -> L14
        if ((r2 instanceof LooperDispatchMonitor) == true) goto L12;
        r2.dumpInfosToALog(r10, r12, r14);     // Catch: Exception -> L14
    L12:
        r0 = r0 + 1;
        goto L7
    }

    public Map<String, String> dumpInfosAsMap() {
        HashMap r0 = new HashMap();
        int r1 = 0;
    L10:
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        return r0;
    L4:
        if (r1 >= this.mMonitorList.size()) goto L9;
        Pair<String, ?> r2 = this.mMonitorList.get(r1).dumpInfo();     // Catch: Exception -> L7
        r0.put(r2.first, String.valueOf(r2.second));     // Catch: Exception -> L7
        r1 = r1 + 1;
        goto L10
    }

    public void setProcALogMode(boolean r1) {
        ProcMonitor r0 = this.mProcMonitor;
        if (r0 == null) goto L6;
        r0.setALogCollectMode(r1);
        return;
    }

    public LooperDispatchMonitor.FrameCallback getFrameCallback() {
        LooperDispatchMonitor r0 = this.mLooperDispatchMonitor;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.mFrameCallback;
    }

    public LooperDispatchMonitor.ScheduleItem getLastMessageItem() {
        LooperDispatchMonitor r0 = this.mLooperDispatchMonitor;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getLastItem();
    }

    public LooperDispatchMonitor getLooperDispatchMonitor() {
        return this.mLooperDispatchMonitor;
    }
}
