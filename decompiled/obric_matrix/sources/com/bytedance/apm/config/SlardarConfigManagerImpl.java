package com.bytedance.apm.config;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.bytedance.services.slardar.config.IResponseConfigListener;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SlardarConfigManagerImpl implements IConfigManager {
    private g mSlardarConfigFetcher;

    public SlardarConfigManagerImpl() {
        this.mSlardarConfigFetcher = new g();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void fetchConfig() {
        this.mSlardarConfigFetcher.q();
    }

    @WorkerThread
    public void forceUpdateFromRemote(@Nullable com.bytedance.apm.core.d r1, @Nullable List<String> r2) {
        this.mSlardarConfigFetcher.h(r1, r2);
    }

    @Nullable
    public JSONObject getConfig() {
        return this.mSlardarConfigFetcher.i();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public int getConfigInt(String r1, int r2) {
        return this.mSlardarConfigFetcher.j(r1, r2);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    @Nullable
    public JSONObject getConfigJSON(String r1) {
        return this.mSlardarConfigFetcher.k(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getLogTypeSwitch(String r1) {
        return this.mSlardarConfigFetcher.l(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getMetricTypeSwitch(String r1) {
        return this.mSlardarConfigFetcher.m(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getServiceSwitch(String r1) {
        return this.mSlardarConfigFetcher.n(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getSwitch(String r1) {
        return this.mSlardarConfigFetcher.o(r1);
    }

    public void initParams(boolean r1, com.bytedance.apm.core.d r2, List<String> r3) {
        this.mSlardarConfigFetcher.r(r1, r2, r3);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean isConfigReady() {
        return this.mSlardarConfigFetcher.w();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public String queryConfig() {
        return this.mSlardarConfigFetcher.z();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerConfigListener(IConfigListener r1) {
        this.mSlardarConfigFetcher.e(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerResponseConfigListener(IResponseConfigListener r1) {
        d.b.b.a.c(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public JSONObject retrieveSettingsParams() {
        return this.mSlardarConfigFetcher.E();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterConfigListener(IConfigListener r1) {
        this.mSlardarConfigFetcher.D(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterResponseConfigListener(IResponseConfigListener r1) {
        d.b.b.a.d(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean updateWithSpecificAidResult(JSONObject r1) {
        return this.mSlardarConfigFetcher.J(r1);
    }
}
