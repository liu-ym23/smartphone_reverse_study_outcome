package com.bytedance.services.slardar.config;

import androidx.annotation.Nullable;
import com.bytedance.news.common.service.manager.IService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IConfigManager extends IService {
    void fetchConfig();

    int getConfigInt(String r1, int r2);

    @Nullable
    JSONObject getConfigJSON(String r1);

    boolean getLogTypeSwitch(String r1);

    boolean getMetricTypeSwitch(String r1);

    boolean getServiceSwitch(String r1);

    boolean getSwitch(String r1);

    boolean isConfigReady();

    String queryConfig();

    void registerConfigListener(IConfigListener r1);

    void registerResponseConfigListener(IResponseConfigListener r1);

    JSONObject retrieveSettingsParams();

    void unregisterConfigListener(IConfigListener r1);

    void unregisterResponseConfigListener(IResponseConfigListener r1);

    boolean updateWithSpecificAidResult(JSONObject r1);
}
