package com.bytedance.apm6.cpu;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.perf.entity.CpuInfo;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm6.cpu.collect.CpuCollectManager;
import com.bytedance.apm6.cpu.collect.InitiativeCpuCollectManager;
import com.bytedance.apm6.cpu.exception.CpuExceptionManager;
import com.bytedance.apm6.cpu.service.CurrentCpuDataHolder;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.service.perf.ICpuDataService;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.watson.assist.api.IAssistStat;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class ApmCpuManager {
    private static volatile ApmCpuManager singleton;
    private CopyOnWriteArraySet<String> mSceneSet;

    public interface ICpuDataListener {
        void onCpuData(double r1, double r3, String r5, @Nullable IAssistStat.CpuFactorTag r6, NetworkUtils.NetworkType r7);
    }

    public interface ICpuExceptionFilter {
        boolean needFilter();
    }

    public interface ICpuExceptionListener {
        void onException(double r1);
    }

    private ApmCpuManager() {
        this.mSceneSet = new CopyOnWriteArraySet();
    }

    public static ApmCpuManager getInstance() {
        if (singleton != null) goto L16;
        monitor-enter(ApmCpuManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L11;
        singleton = new ApmCpuManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(ApmCpuManager.class);     // Catch: Throwable -> L9
    L16:
        return singleton;
    }

    public double getCpuRate() {
        return CurrentCpuDataHolder.getInstance().getCpuRate();
    }

    public CopyOnWriteArraySet<String> getCpuSceneSet() {
        return this.mSceneSet;
    }

    public String getCpuSceneString() {
        String r1 = ListUtils.arrayToString(this.mSceneSet.toArray(), "#");
        if (TextUtils.isEmpty(r1) == true) goto L5;
        return r1;
    L5:
        return "";
    }

    public double getCpuSpeed() {
        return CurrentCpuDataHolder.getInstance().getCpuSpeed();
    }

    public CpuInfo getCurrentCpuRate() {
        return getCurrentCpuRateNew();
    }

    public CpuInfo getCurrentCpuRateNew() {
        CpuInfo r11 = new CpuInfo();
        int r0 = CommonMonitorUtil.getCpuCoreNum();     // Catch: Exception -> L16
        if (r0 > 0) goto L6;
        return r11;
    L6:
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L16
        long r3 = PerfMonitorManager.getInstance().dumpAppCPUTime();     // Catch: Exception -> L16
        long r5 = PerfMonitorManager.getInstance().dumpTotalCPUTimeByTimeInStat(r0);     // Catch: Exception -> L16
        Thread.sleep(360);     // Catch: InterruptedException -> L15 Exception -> L16
    L9:
        long r7 = PerfMonitorManager.getInstance().dumpAppCPUTime();     // Catch: Exception -> L16
        long r9 = PerfMonitorManager.getInstance().dumpTotalCPUTimeByTimeInStat(r0) - r5;     // Catch: Exception -> L16
        if (r9 <= 0) goto L12;
        double r6 = (r7 - r3) / r9;     // Catch: Exception -> L16
    L13:
        double r8 = (((r7 - r3) * 1000.0d) / (System.currentTimeMillis() - r1)) / CommonMonitorUtil.getScClkTck(100);     // Catch: Exception -> L16
        r11.cpuAppRate = r6;     // Catch: Exception -> L16
        r11.cpuAppSpeed = r8;     // Catch: Exception -> L16
        goto L14
    L12:
        r6 = -1.0d;
    L14:
        return r11;
    }

    public Pair<Long, LinkedList<ICpuDataService.ThreadCpuItem>> getExceptionThreadList() {
        return CurrentCpuDataHolder.getInstance().getExceptionThreadList();
    }

    public long getLastCpuExceptionTimestamp() {
        return CpuExceptionManager.getInstance().getLastExceptionTimestamp();
    }

    public Pair<Long, LinkedList<ICpuDataService.ThreadCpuItem>> getThreadList() {
        return CurrentCpuDataHolder.getInstance().getThreadList();
    }

    public void setCpuDataListener(ICpuDataListener r1) {
        CpuCollectManager.getInstance().setDataListener(r1);
    }

    public void setCpuExceptionFilter(ICpuExceptionFilter r1) {
        CpuExceptionManager.getInstance().setCpuFilterListener(r1);
    }

    public void setExceptionListener(ICpuExceptionListener r1) {
        CpuExceptionManager.getInstance().setExceptionListener(r1);
    }

    public void startExceptionDetectNoStack() {
        if (ApmContext.isInitFinish() == false) goto L6;
        CpuExceptionManager.getInstance().forceOpenNoStack();
        return;
    }

    public void startScene(String r1) {
        this.mSceneSet.add(r1);
        PerfFilterManager.getInstance().startScene(r1);
    }

    public void startUsageDetect(String r1) {
        InitiativeCpuCollectManager.startCollect(r1);
    }

    public void stopExceptionDetectNoStack() {
        if (ApmContext.isInitFinish() == false) goto L6;
        CpuExceptionManager.getInstance().stopForceOpenNoStack();
        return;
    }

    public void stopScene(String r1) {
        this.mSceneSet.remove(r1);
        PerfFilterManager.getInstance().stopScene(r1);
    }

    public void stopUsageDetect(String r1, boolean r2) {
        InitiativeCpuCollectManager.stopCollect(r1, r2);
    }

    @Deprecated
    public void tmpStartExceptionDetect() {
        CpuExceptionManager.getInstance().forceOpen();
    }
}
