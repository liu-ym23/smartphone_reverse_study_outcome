package com.bytedance.apm6.consumer.slardar;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfig;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService;
import com.bytedance.apm6.consumer.slardar.header.HeaderManager;
import com.bytedance.apm6.consumer.slardar.header.HeaderUtils;
import com.bytedance.apm6.consumer.slardar.persistent.PersistentBuffer;
import com.bytedance.apm6.consumer.slardar.send.LogReportController;
import com.bytedance.apm6.consumer.slardar.send.LogSender;
import com.bytedance.apm6.consumer.slardar.send.NetworkSender;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeController;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutManager;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.monitor.MonitorableHandler;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.NetUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.common.utility.NetworkUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SlardarHandler implements MonitorableHandler {
    private static volatile SlardarHandler sInstance;
    private volatile boolean inited;
    private SlardarHandlerConfig mSlardarHandlerConfig;
    private PersistentBuffer persistentBuffer;

    static {
        sInstance = new SlardarHandler();
    }

    private SlardarHandler() {
        this.inited = false;
    }

    private void addExtension(JSONObject r7, boolean r8) {
    L6:
        e = move-exception;
        Log.e(Constants.TAG, "addExtension", e);
        return;
    L4:
        if (TextUtils.isEmpty(ApmContext.getSessionId()) == true) goto L9;
        r7.put("session_id", ApmContext.getSessionId());     // Catch: Exception -> L6
    L9:
        if (r7.isNull("network_type") == false) goto L18;
        NetworkUtils.NetworkType r2 = NetworkUtils.getNetworkTypeFast(ApmBaseContext.getContext());     // Catch: Exception -> L6
        r7.put("network_type", r2.getValue());     // Catch: Exception -> L6
        if (r2.is2G() == false) goto L13;
    L14:
        int r0 = NetUtils.getMobileNetworkType(ApmBaseContext.getContext());     // Catch: Exception -> L6
        if (r0 == (-10000)) goto L18;
        r7.put("network_type_code", r0);     // Catch: Exception -> L6
        goto L18
    L13:
        if (r2.is3GOrHigher() == true) goto L14;
    L18:
        if (r7.isNull("timestamp") == false) goto L20;
    L21:
        r7.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L6
    L23:
        if (r7.isNull("sid") == false) goto L25;
        r7.put("sid", ApmContext.getStartId());     // Catch: Exception -> L6
    L25:
        r7.put("process_name", ApmContext.getCurrentProcessName());     // Catch: Exception -> L6
        if (r8 == false) goto L33;
        r7.put("seq_no", SeqNumGenerator.getInstance().next());     // Catch: Exception -> L6
        return;
    L33:
        return;
    L20:
        if (r7.optLong("timestamp") > 0) goto L23;
        goto L21
    }

    private synchronized void ensureInited() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.inited == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (ApmBaseContext.isDebugMode() == false) goto L13;
        Logger.d(Constants.TAG, "Initializing SlardarHandler...");     // Catch: Throwable -> L10
    L13:
        if (ApmAlogHelper.getInnerLogger() == null) goto L15;
        ApmAlogHelper.getInnerLogger().d(Constants.TAG, "ensureInited");     // Catch: Throwable -> L10
    L15:
        HeaderManager.getInstance().init();     // Catch: Throwable -> L10
        DowngradeController.getInstance().init(ApmBaseContext.getContext());     // Catch: Throwable -> L10
        SlardarHandlerConfigService r0 = (SlardarHandlerConfigService) ServiceManager.getService(SlardarHandlerConfigService.class);     // Catch: Throwable -> L10
        if (r0 == null) goto L18;
        setSlardarHandlerConfig(r0.getConfig());     // Catch: Throwable -> L10
    L18:
        this.persistentBuffer = new PersistentBuffer(HeaderUtils.getUniqueHeaderId(), DiskEnvironmentHelper.getPersistentFile(), DiskEnvironmentHelper.getFlushDirectory());     // Catch: Throwable -> L10
        LogReporter.getInstance().setPersistentBuffer(this.persistentBuffer);     // Catch: Throwable -> L10
        WeedOutManager.getInstance().addStrategy(LogReporter.getInstance());     // Catch: Throwable -> L10
        WeedOutManager.getInstance().addStrategy(LogSender.getInstance());     // Catch: Throwable -> L10
        WeedOutManager.getInstance().init();     // Catch: Throwable -> L10
        LogReporter.getInstance().init();     // Catch: Throwable -> L10
        LogSender.getInstance().init();     // Catch: Throwable -> L10
        this.inited = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public static SlardarHandler getInstance() {
        return sInstance;
    }

    @Override // com.bytedance.apm6.monitor.MonitorableHandler
    public void handle(Monitorable r5) {
        if (this.inited == true) goto L5;
        ensureInited();
    L5:
        JSONObject r0 = r5.toJsonObject();
        if (Constants.EXCEPTION_TYPE.contains(r5.getLogType()) == false) goto L8;
    L17:
        addExtension(r0, false);
    L19:
        if (ApmBaseContext.isDebugMode() == false) goto L21;
        DoctorDataUtil.onReceivedEvent(r5.getLogType(), r0, true);
    L21:
        this.persistentBuffer.push(r0);
        return;
    L8:
        if ("tracing".equals(r5.getLogType()) == true) goto L17;
        if (DowngradeController.getInstance().uploadEnabled(r0, ApmContext.getAid()) == false) goto L13;
        addExtension(r0, true);
        goto L19
    L13:
        if (ApmBaseContext.isDebugMode() == false) goto L23;
        Logger.d(Constants.TAG, "push failed: event(aid=" + ApmContext.getAid() + " is downgraded: " + r0.toString());
        return;
    }

    public void pause() {
        if (ApmBaseContext.isDebugMode() == false) goto L5;
        Logger.d(Constants.TAG, "pause");
    L5:
        LogReporter.getInstance().pause();
        LogSender.getInstance().pause();
    }

    public void resume() {
        if (ApmBaseContext.isDebugMode() == false) goto L5;
        Logger.d(Constants.TAG, "resume");
    L5:
        LogReporter.getInstance().resume();
        LogSender.getInstance().resume();
    }

    public synchronized void setSlardarHandlerConfig(SlardarHandlerConfig r6) {
        monitor-enter(this);
        this.mSlardarHandlerConfig = r6;     // Catch: Throwable -> L7
        if (r6 == null) goto L10;
        LogReportController.getInstance().updateConfig(r6);     // Catch: Throwable -> L7
        LogReporter.getInstance().setLoopInterval(r6.getReportInterval());     // Catch: Throwable -> L7
        LogReporter.getInstance().setOnceReportMaxSizeBytes(r6.getOnceReportMaxSizeBytes());     // Catch: Throwable -> L7
        WeedOutManager.getInstance().setWeedOutConfig(r6.getMaxSizeMB(), r6.getKeepDays(), r6.getMaxSizeMBToday());     // Catch: Throwable -> L7
        NetworkSender.setCompressType(r6.getCompressType());     // Catch: Throwable -> L7
    L10:
        if (ApmBaseContext.isDebugMode() == false) goto L12;
        Logger.d(Constants.TAG, "setSlardarHandlerConfig:" + r6);     // Catch: Throwable -> L7
    L12:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
