package com.obric.matrix.sdk.network;

import android.content.Context;
import com.bytedance.ttnet.ITTNetDepend;
import com.bytedance.ttnet.TTNetInit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TTNetDepend implements ITTNetDepend {

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    private static final String TAG = "TTNetDepend";

    @NotNull
    private final Context context;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TTNetDepend(@NotNull Context r2) {
        Intrinsics.f(r2, "context");
        this.context = r2;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int checkHttpRequestException(@NotNull Throwable r1, @NotNull String[] r2) {
        Intrinsics.f(r1, "tr");
        Intrinsics.f(r2, "remoteIp");
        return 0;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    @Nullable
    public String executeGet(int r1, @NotNull String r2) {
        Intrinsics.f(r2, "url");
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    @Nullable
    public String getApiIHostPrefix() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int getAppId() {
        return NetworkSDKInit.INSTANCE.getConfig().getAppId();
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    @NotNull
    public String getCdnHostSuffix() {
        return "byteimg.com";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    @NotNull
    public String[] getConfigServers() {
        return new String[]{"tnc0-aliec2.zijieapi.com", "tnc0-alisc1.zijieapi.com"};
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    @NotNull
    public Context getContext() {
        return this.context;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    @Nullable
    public ArrayList<String> getCookieFlushPathList() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    @Nullable
    public Map<String, String> getHostReverseMap() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    @NotNull
    public String getHostSuffix() {
        return "snssdk.com";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int getProviderInt(@NotNull Context r1, @NotNull String r2, int r3) {
        Intrinsics.f(r1, "context");
        Intrinsics.f(r2, "key");
        return 0;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    @NotNull
    public String getProviderString(@NotNull Context r1, @NotNull String r2, @NotNull String r3) {
        Intrinsics.f(r1, "context");
        Intrinsics.f(r2, "key");
        Intrinsics.f(r3, "defaultValue");
        return "";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    @Nullable
    public String getShareCookieMainDomain() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    @NotNull
    public Map<String, String> getTTNetServiceDomainMap() {
        HashMap r2 = new HashMap();
        r2.put("httpdns", "dig.bdurl.net");
        r2.put(TTNetInit.DOMAIN_NETLOG_KEY, "crash.snssdk.com");
        r2.put(TTNetInit.DOMAIN_BOE_KEY, ".boe-gateway.byted.org");
        return r2;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public boolean isCronetPluginInstalled() {
        return true;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public boolean isPrivateApiAccessEnabled() {
        return true;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void mobOnEvent(@NotNull Context r1, @NotNull String r2, @NotNull String r3, @NotNull JSONObject r4) {
        Intrinsics.f(r1, "context");
        Intrinsics.f(r2, "eventName");
        Intrinsics.f(r3, "labelName");
        Intrinsics.f(r4, "extraJson");
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void monitorLogSend(@NotNull String r1, @NotNull JSONObject r2) {
        Intrinsics.f(r1, "logType");
        Intrinsics.f(r2, "json");
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onAppConfigUpdated(@NotNull Context r1, @NotNull JSONObject r2) {
        Intrinsics.f(r1, "context");
        Intrinsics.f(r2, "ext_json");
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onColdStartFinish() {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onNetConfigUpdate(@NotNull JSONObject r1, boolean r2) {
        Intrinsics.f(r1, "config");
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onShareCookieConfigUpdated(@NotNull String r1) {
        Intrinsics.f(r1, "shareCookieHosts");
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void saveMapToProvider(@NotNull Context r1, @Nullable Map<String, ?> r2) {
        Intrinsics.f(r1, "context");
    }
}
