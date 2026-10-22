package com.bytedance.ttnet;

import android.content.Context;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface ITTNetDepend {
    @Deprecated
    int checkHttpRequestException(Throwable r1, String[] r2);

    @Deprecated
    String executeGet(int r1, String r2) throws Exception;

    @Deprecated
    String getApiIHostPrefix();

    int getAppId();

    @Deprecated
    String getCdnHostSuffix();

    String[] getConfigServers();

    Context getContext();

    ArrayList<String> getCookieFlushPathList();

    @Deprecated
    Map<String, String> getHostReverseMap();

    String getHostSuffix();

    int getProviderInt(Context r1, String r2, int r3);

    String getProviderString(Context r1, String r2, String r3);

    String getShareCookieMainDomain();

    Map<String, String> getTTNetServiceDomainMap();

    boolean isCronetPluginInstalled();

    @Deprecated
    boolean isPrivateApiAccessEnabled();

    void mobOnEvent(Context r1, String r2, String r3, JSONObject r4);

    void monitorLogSend(String r1, JSONObject r2);

    @Deprecated
    void onAppConfigUpdated(Context r1, JSONObject r2);

    void onColdStartFinish();

    @Deprecated
    void onNetConfigUpdate(JSONObject r1, boolean r2);

    void onShareCookieConfigUpdated(String r1);

    void saveMapToProvider(Context r1, Map<String, ?> r2);
}
