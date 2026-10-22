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

    static {
    }

    protected boolean checkValid(T r1) {
        return true;
    }

    protected abstract void handleAfterReady(T r1);

    protected void hookBeforeRealHandle(T r1) {
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r1, boolean r2) {
    }

    static /* synthetic */ void access$000(BaseDataPipeline r0, ITypeData r1) {
        r0.handleInner(r1);
    }

    static /* synthetic */ LinkedList access$100(BaseDataPipeline r0) {
        return r0.mLogBuffer;
    }

    protected BaseDataPipeline() {
        this.mHasReported = false;
        this.fastMode = false;
        this.mLogBuffer = new LinkedList();
    }

    public void init() {
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerConfigListener(this);
    }

    public final void handle(final T r3) {
        if (AsyncEventManager.getInstance().inWorkThread() == true) goto L5;
        AsyncEventManager.getInstance().post(new AnonymousClass1(this, r3));
        return;
    L5:
        handleInner(r3);
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

    private void cache(T r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        LinkedList<T> r1 = this.mLogBuffer;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (this.mLogBuffer.size() <= sCacheBufferMaxSize) goto L15;
        T r2 = this.mLogBuffer.poll();     // Catch: Throwable -> L18
        if (isEnable == true) goto L12;
    L22:
        ApmAlogHelper.i(SlardarLogConstants.TAG_ALOG, "apm_cache_buffer_full:" + r2.packLog().toString());     // Catch: Exception -> L21 Throwable -> L18
        goto L15
    L12:
        if (this.mHasReported == true) goto L22;
        MonitorCoreExceptionManager.getInstance().ensureNotReachHere("apm_cache_buffer_full");     // Catch: Throwable -> L18
        this.mHasReported = true;     // Catch: Throwable -> L18
    L15:
        this.mLogBuffer.add(r6);     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
    }

    private void handleCache() {
        AsyncEventManager.getInstance().post(new AnonymousClass2(this));
    }

    protected void logSend(String r5, String r6, JSONObject r7, boolean r8, boolean r9) {
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d(TAG, new String[]{"type:" + r5 + " isSaveUnSampleLog:" + r9 + "isSampled:" + r8 + " log:" + r7});
    L5:
        if (r8 == false) goto L18;
        if (this.fastMode == false) goto L9;
        JSONObject r10 = JsonUtils.safeJsonObject(r7);
    L11:
        if (TextUtils.equals(r5, "tracing") == false) goto L14;
        monitorTrace(new TracingData(r10, null, false, r6));
    L27:
        LogObserver.getInstance().notifyObservers(r5, r6, r7);
        if (TextUtils.equals(r5, "ui_action") == false) goto L33;
        ActionRecord.getInstance().addRecord(r7);
        return;
    L33:
        return;
    L14:
        if (TextUtils.equals(r5, "common_log") == false) goto L16;
        CommonEventDeliverer.monitorLegacyEvent(new GeneralLegacyEvent(r6, r10));
        goto L27
    L16:
        CommonEventDeliverer.monitorLegacyEvent(new GeneralLegacyEvent(r5, r10));
        goto L27
    L9:
        r10 = JsonUtils.deepCopy(r7);
        goto L11
    L18:
        if (ApmContext.isDebugMode() == false) goto L20;
        DoctorDataUtil.onReceivedEvent(r5, r7, false);
    L20:
        if (r9 == false) goto L27;
        if (ApmAlogHelper.isUnSampleEnable() == false) goto L27;
        ApmAlogHelper.onUnSampleLog(r5, r7.toString());     // Catch: Exception -> L25
    L25:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "apm_unsampled_log_error");
        goto L27
    }

    private void monitorTrace(TracingData r2) {
        if ("batch_tracing".equals(r2.getSubTypeLabel()) == false) goto L5;
        CommonEventDeliverer.monitorTrace(new com.bytedance.apm6.commonevent.model.TracingData(BatchTracingLogWrapUtils.stripData(r2.packLog())));
        return;
    L5:
        CommonEventDeliverer.monitorTrace(new com.bytedance.apm6.commonevent.model.TracingData(r2.packLog()));
    }

    protected boolean isConfigReady() {
        return this.mConfigReady;
    }

    protected static boolean isBackground() {
        if (ActivityLifeObserver.getInstance() != null) goto L6;
        return true;
    L6:
        return !ActivityLifeObserver.getInstance().isForeground();
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        this.mConfigReady = true;
        handleCache();
        if (ApmContext.isDebugMode() == false) goto L6;
        DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_READY, null);
        return;
    }

    public static void setCacheBufferMaxSize(int r0) {
        sCacheBufferMaxSize = r0;
    }

    public static void setReportFullException(boolean r0) {
        isEnable = r0;
    }
}
