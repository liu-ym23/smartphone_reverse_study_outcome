package com.obric.matrix.sdk.network;

import com.bytedance.ttnet.cronet.AbsCronetDependAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.chromium.CronetAppProviderManager;
import org.chromium.CronetDependManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TTNetCronetDependAdapter extends AbsCronetDependAdapter {

    @NotNull
    public static final TTNetCronetDependAdapter INSTANCE = null;

    static {
        INSTANCE = new TTNetCronetDependAdapter();
    }

    private TTNetCronetDependAdapter() {
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    @NotNull
    public String getAppId() {
        return String.valueOf(NetworkSDKInit.INSTANCE.getConfig().getAppId());
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    @NotNull
    public String getAppName() {
        return NetworkSDKInit.INSTANCE.getConfig().getAppName();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    @Nullable
    public String getCarrierRegion() {
        return null;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    @NotNull
    public String getChannel() {
        return NetworkSDKInit.INSTANCE.getConfig().getChannel();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    @NotNull
    public String getDeviceId() {
        return NetworkSDKInit.INSTANCE.getConfig().getDid();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    @NotNull
    public String getManifestVersionCode() {
        return String.valueOf(NetworkSDKInit.INSTANCE.getConfig().getVersionCode());
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    @Nullable
    public ArrayList<byte[]> getOpaqueData() {
        return null;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    @Nullable
    public String getRegion() {
        return null;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    @Nullable
    public String getStoreIdc() {
        return null;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    @Nullable
    public String getSysRegion() {
        return null;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    @NotNull
    public String getUpdateVersionCode() {
        return String.valueOf(NetworkSDKInit.INSTANCE.getConfig().getVersionCode());
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    @NotNull
    public String getUserId() {
        return "null";
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    @NotNull
    public String getVersionCode() {
        return String.valueOf(NetworkSDKInit.INSTANCE.getConfig().getVersionCode());
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    @NotNull
    public String getVersionName() {
        return NetworkSDKInit.INSTANCE.getConfig().getVersionName();
    }

    public final void inJect() {
        CronetDependManager.inst().setAdapter(this);     // Catch: Throwable -> L4
        CronetAppProviderManager.inst().setAdapter(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
        throw th;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public boolean loggerDebug() {
        return false;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void sendAppMonitorEvent(@NotNull String r1, @NotNull String r2) {
        Intrinsics.f(r1, "logContent");
        Intrinsics.f(r2, "logType");
    }
}
