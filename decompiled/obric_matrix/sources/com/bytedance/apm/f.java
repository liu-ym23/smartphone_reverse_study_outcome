package com.bytedance.apm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.Fragment;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import com.bytedance.services.apm.api.IWidget;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class f implements IWidget, IConfigListener, IActivityLifeObserver, com.bytedance.apm.f0.b.e {
    private volatile JSONObject mAllowLogType;
    private volatile JSONObject mAllowService;
    private JSONObject mConfigData;
    private boolean mConfigReady;
    private boolean mIsFront;
    private volatile JSONObject mMetricType;

    public f() {
    }

    private void ensureUnregisterForSafety() {
        unregisterAppLifeCycle();
        unregisterConfigService();
        unregisterTimerTask();
    }

    @Override // com.bytedance.services.apm.api.IWidget
    @WorkerThread
    public void destroy() {
        ensureUnregisterForSafety();
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

    public int getConfigInt(String r2, int r3) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        JSONObject r1 = this.mConfigData;
        if (r1 == null) goto L9;
        return r1.optInt(r2, r3);
    L9:
        return r3;
    }

    @Nullable
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

    @Override // com.bytedance.services.apm.api.IWidget
    public String getTag() {
        return "base";
    }

    @Override // com.bytedance.services.apm.api.IWidget
    @WorkerThread
    public void init(Context r1) {
    }

    public boolean isConfigReady() {
        return this.mConfigReady;
    }

    protected boolean isFront() {
        return this.mIsFront;
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
    public void onBackground(Activity r1) {
        this.mIsFront = false;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onChange(Activity r1, Fragment r2) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        this.mIsFront = true;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        this.mConfigReady = true;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r1, boolean r2) {
        this.mConfigData = r1;
        JSONObject r3 = r1.optJSONObject("custom_event_settings");
        if (r3 == null) goto L6;
        this.mAllowLogType = r3.optJSONObject("allow_log_type");
        this.mMetricType = r3.optJSONObject("allow_metric_type");
        this.mAllowService = r3.optJSONObject("allow_service_name");
        return;
    }

    @Override // com.bytedance.apm.f0.b.e
    public void onTimeEvent(long r1) {
    }

    protected final boolean registerAppLifeCycle() {
        IActivityLifeManager r0 = (IActivityLifeManager) com.bytedance.news.common.service.manager.d.a(IActivityLifeManager.class);
        if (r0 == null) goto L6;
        r0.register(this);
        return true;
    L6:
        return false;
    }

    protected final boolean registerConfigService() {
        IConfigManager r0 = (IConfigManager) com.bytedance.news.common.service.manager.d.a(IConfigManager.class);
        if (r0 == null) goto L6;
        r0.registerConfigListener(this);
        return true;
    L6:
        return false;
    }

    protected final void registerTimerTask() {
        com.bytedance.apm.f0.b.f().c(this);
    }

    @Override // com.bytedance.services.apm.api.IWidget
    @WorkerThread
    public void start() {
    }

    @Override // com.bytedance.services.apm.api.IWidget
    @WorkerThread
    public void stop() {
    }

    protected final boolean unregisterAppLifeCycle() {
        IActivityLifeManager r0 = (IActivityLifeManager) com.bytedance.news.common.service.manager.d.a(IActivityLifeManager.class);
        if (r0 == null) goto L6;
        r0.unregister(this);
        return true;
    L6:
        return false;
    }

    protected final boolean unregisterConfigService() {
        IConfigManager r0 = (IConfigManager) com.bytedance.news.common.service.manager.d.a(IConfigManager.class);
        if (r0 == null) goto L6;
        r0.unregisterConfigListener(this);
        return true;
    L6:
        return false;
    }

    protected final void unregisterTimerTask() {
        com.bytedance.apm.f0.b.f().m(this);
    }
}
