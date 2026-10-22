package com.bytedance.mpaas.applog;

import androidx.annotation.NonNull;
import com.bytedance.news.common.service.manager.IService;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IBdtrackerService extends IService {
    String addCommonParams(String r1, boolean r2);

    String getClientUdid();

    String getDeviceId();

    String getInstallId();

    String getSessionId();

    @Deprecated
    String getSessionKey();

    String getUserId();

    void onActivityPaused();

    void onActivityResume(String r1, int r2);

    void onEvent(@NonNull String r1, @NonNull String r2, String r3, long r4, long r6, JSONObject r8);

    void onEventV3(String r1, JSONObject r2);

    void putCommonParams(Map<String, String> r1, boolean r2);

    void putCommonParamsWithLevel(Map<String, String> r1, boolean r2, int r3);

    void registerDataListener(a r1);

    @Deprecated
    void setSessionKey(String r1);

    void setUserId(long r1);

    void unregisterDataListener(a r1);
}
