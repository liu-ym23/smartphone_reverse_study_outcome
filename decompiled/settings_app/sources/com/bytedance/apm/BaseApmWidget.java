package com.bytedance.apm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import com.bytedance.services.apm.api.IWidget;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseApmWidget implements IWidget, IConfigListener, IActivityLifeObserver, AsyncEventManager.IMonitorTimeTask {
    private volatile JSONObject mAllowLogType;
    private volatile JSONObject mAllowService;
    private JSONObject mConfigData;
    private boolean mConfigReady;
    private boolean mIsFront;
    private volatile JSONObject mMetricType;

    @Override // com.bytedance.services.apm.api.IWidget
    public String getTag() {
        return TraceStatsConsts.STATS_BASE_MODULE;
    }

    @Override // com.bytedance.services.apm.api.IWidget
    public void init(Context r1) {
    }

    @Override // com.bytedance.services.apm.api.IWidget
    public abstract boolean isOnlyMainProcess();

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityPause(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityResume(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityStarted(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onChange(Activity r1, Fragment r2) {
    }

    @Override // com.bytedance.apm.thread.AsyncEventManager.IMonitorTimeTask
    public void onTimeEvent(long r1) {
    }

    @Override // com.bytedance.services.apm.api.IWidget
    public void start() {
    }

    @Override // com.bytedance.services.apm.api.IWidget
    public void stop() {
    }

    public BaseApmWidget() {
    }

    @Override // com.bytedance.services.apm.api.IWidget
    public void destroy() {
        ensureUnregisterForSafety();
    }

    private void ensureUnregisterForSafety() {
        unregisterAppLifeCycle();
        unregisterConfigService();
        unregisterTimerTask();
    }

    protected final boolean registerConfigService() {
        IConfigManager r0 = (IConfigManager) ServiceManager.getService(IConfigManager.class);
        if (r0 == null) goto L6;
        r0.registerConfigListener(this);
        return true;
    L6:
        return false;
    }

    protected final boolean registerAppLifeCycle() {
        IActivityLifeManager r0 = (IActivityLifeManager) ServiceManager.getService(IActivityLifeManager.class);
        if (r0 == null) goto L6;
        r0.register(this);
        return true;
    L6:
        return false;
    }

    protected final void registerTimerTask() {
        AsyncEventManager.getInstance().addTimeTask(this);
    }

    protected final boolean unregisterConfigService() {
        IConfigManager r0 = (IConfigManager) ServiceManager.getService(IConfigManager.class);
        if (r0 == null) goto L6;
        r0.unregisterConfigListener(this);
        return true;
    L6:
        return false;
    }

    protected final boolean unregisterAppLifeCycle() {
        IActivityLifeManager r0 = (IActivityLifeManager) ServiceManager.getService(IActivityLifeManager.class);
        if (r0 == null) goto L6;
        r0.unregister(this);
        return true;
    L6:
        return false;
    }

    protected final void unregisterTimerTask() {
        AsyncEventManager.getInstance().removeTimeTask(this);
    }

    protected boolean isFront() {
        return this.mIsFront;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        this.mIsFront = true;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        this.mIsFront = false;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r1, boolean r2) {
        this.mConfigData = r1;
        JSONObject r3 = r1.optJSONObject("custom_event_settings");
        if (r3 == null) goto L6;
        this.mAllowLogType = r3.optJSONObject("allow_log_type");
        this.mMetricType = r3.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_METRIC_TYPE);
        this.mAllowService = r3.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_SERVICE_NAME);
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        this.mConfigReady = true;
    }

    public boolean isConfigReady() {
        return this.mConfigReady;
    }

    public boolean getLogTypeSwitch(String r3) {
        if (this.mAllowLogType != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.mAllowLogType.optInt(r3) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean getMetricTypeSwitch(String r3) {
        if (this.mMetricType != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.mMetricType.optInt(r3) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean getServiceSwitch(String r3) {
        if (this.mAllowService != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.mAllowService.optInt(r3) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean getConfigBool(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        JSONObject r1 = this.mConfigData;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.optBoolean(r2);
    L9:
        return false;
    }

    public JSONObject getConfigJSON(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        JSONObject r1 = this.mConfigData;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.optJSONObject(r2);
    L9:
        return null;
    }

    public int getConfigInt(String r2, int r3) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        JSONObject r1 = this.mConfigData;
        if (r1 == null) goto L9;
        return r1.optInt(r2, r3);
    L9:
        return r3;
    }
}
