package com.bytedance.apm.data;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.MonitorCoreExceptionManager;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.data.ui.ActionRecord;
import com.bytedance.apm.doctor.DoctorConstants;
import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.observer.LogObserver;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.commonevent.model.GeneralLegacyEvent;
import com.bytedance.frameworks.baselib.log.SlardarLogConstants;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.bytedance.tracing.internal.BatchTracingLogWrapUtils;
import com.bytedance.tracing.internal.TracingData;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseDataPipeline<T extends ITypeData> implements IConfigListener {
    private static final String TAG = "BaseDataPipeline";
    private static boolean isEnable = false;
    private static int sCacheBufferMaxSize = 1000;
    public boolean fastMode;
    private volatile boolean mConfigReady;
    private volatile boolean mHasReported;
    private final LinkedList<T> mLogBuffer;

    public BaseDataPipeline() {
        this.mHasReported = false;
        this.fastMode = false;
        this.mLogBuffer = new LinkedList();
    }

    public static /* synthetic */ void access$000(BaseDataPipeline r0, ITypeData r1) {
        r0.handleInner(r1);
    }

    public static /* synthetic */ LinkedList access$100(BaseDataPipeline r0) {
        return r0.mLogBuffer;
    }

    private void cache(T r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        LinkedList<T> r1 = this.mLogBuffer;
        monitor-enter(r1);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (this.mLogBuffer.size() <= sCacheBufferMaxSize) goto L18;
        T r2 = this.mLogBuffer.poll();     // Catch: Throwable -> L15
        if (isEnable == true) goto L12;
    L24:
        ApmAlogHelper.i(SlardarLogConstants.TAG_ALOG, "apm_cache_buffer_full:" + r2.packLog().toString());     // Catch: Throwable -> L15 Exception -> L23
        goto L18
    L12:
        if (this.mHasReported == true) goto L24;
        MonitorCoreExceptionManager.getInstance().ensureNotReachHere("apm_cache_buffer_full");     // Catch: Throwable -> L15
        this.mHasReported = true;     // Catch: Throwable -> L15
    L18:
        this.mLogBuffer.add(r6);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
    }

    private void handleCache() {
        AsyncEventManager.getInstance().post(new AnonymousClass2(this));
    }

    private void handleInner(T r2) {
        if (checkValid(r2) == true) goto L5;
        return;
    L5:
        hookBeforeRealHandle(r2);
        if (this.mConfigReady == false) goto L8;
        handleAfterReady(r2);
        return;
    L8:
        cache(r2);
    }

    public static boolean isBackground() {
        if (ActivityLifeObserver.getInstance() != null) goto L6;
        return true;
    L6:
        return !ActivityLifeObserver.getInstance().isForeground();
    }

    private void monitorTrace(TracingData r2) {
        if ("batch_tracing".equals(r2.getSubTypeLabel()) == false) goto L5;
        CommonEventDeliverer.monitorTrace(new com.bytedance.apm6.commonevent.model.TracingData(BatchTracingLogWrapUtils.stripData(r2.packLog())));
        return;
    L5:
        CommonEventDeliverer.monitorTrace(new com.bytedance.apm6.commonevent.model.TracingData(r2.packLog()));
    }

    public static void setCacheBufferMaxSize(int r0) {
        sCacheBufferMaxSize = r0;
    }

    public static void setReportFullException(boolean r0) {
        isEnable = r0;
    }

    public boolean checkValid(T r1) {
        return true;
    }

    public final void handle(final T r3) {
        if (AsyncEventManager.getInstance().inWorkThread() == true) goto L5;
        AsyncEventManager.getInstance().post(new AnonymousClass1(this, r3));
        return;
    L5:
        handleInner(r3);
    }

    public abstract void handleAfterReady(T r1);

    public void hookBeforeRealHandle(T r1) {
    }

    public void init() {
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerConfigListener(this);
    }

    public boolean isConfigReady() {
        return this.mConfigReady;
    }

    public void logSend(String r3, String r4, JSONObject r5, boolean r6, boolean r7) {
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.d(TAG, new String[]{"type:" + r3 + " isSaveUnSampleLog:" + r7 + "isSampled:" + r6 + " log:" + r5});
    L6:
        if (r6 == false) goto L19;
        if (this.fastMode == false) goto L10;
        JSONObject r8 = JsonUtils.safeJsonObject(r5);
    L12:
        if (TextUtils.equals(r3, "tracing") == false) goto L15;
        monitorTrace(new TracingData(r8, null, false, r4));
    L28:
        LogObserver.getInstance().notifyObservers(r3, r4, r5);
        if (TextUtils.equals(r3, "ui_action") == false) goto L34;
        ActionRecord.getInstance().addRecord(r5);
        return;
    L34:
        return;
    L15:
        if (TextUtils.equals(r3, "common_log") == false) goto L17;
        CommonEventDeliverer.monitorLegacyEvent(new GeneralLegacyEvent(r4, r8));
        goto L28
    L17:
        CommonEventDeliverer.monitorLegacyEvent(new GeneralLegacyEvent(r3, r8));
        goto L28
    L10:
        r8 = JsonUtils.deepCopy(r5);
        goto L12
    L19:
        if (ApmContext.isDebugMode() == false) goto L21;
        DoctorDataUtil.onReceivedEvent(r3, r5, false);
    L21:
        if (r7 == false) goto L28;
        if (ApmAlogHelper.isUnSampleEnable() == false) goto L28;
        ApmAlogHelper.onUnSampleLog(r3, r5.toString());     // Catch: Exception -> L26
    L26:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "apm_unsampled_log_error");
        goto L28
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        this.mConfigReady = true;
        handleCache();
        if (ApmContext.isDebugMode() == false) goto L6;
        DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_READY, null);
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r1, boolean r2) {
    }
}
