package com.obric.matrix.sdk.network;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.ttnet.http.HttpRequestInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class NetworkConfig {

    @Nullable
    private final NetworkParams.ApiProcessHook<HttpRequestInfo> apiProcessHook;
    private final int appId;

    @NotNull
    private final String appName;

    @NotNull
    private final String channel;

    @NotNull
    private String did;
    private final boolean needSetCookieHandler;
    private final int versionCode;

    @NotNull
    private final String versionName;

    @Metadata
    public static final class Builder {

        @Nullable
        private NetworkParams.ApiProcessHook<HttpRequestInfo> apiProcessHook;
        private int appId;

        @NotNull
        private String appName;

        @NotNull
        private String did;
        private boolean needSetCookieHandler;
        private int versionCode;

        @NotNull
        private String versionName;

        public Builder() {
            this.appName = "";
            this.did = "";
            this.versionName = "";
            this.needSetCookieHandler = true;
        }

        @NotNull
        public final NetworkConfig build() {
            return new NetworkConfig(this.appName, this.appId, this.did, this.versionCode, this.versionName, this.needSetCookieHandler, this.apiProcessHook, null);
        }

        @NotNull
        public final Builder setApiProcessHook(@Nullable NetworkParams.ApiProcessHook<HttpRequestInfo> r1) {
            this.apiProcessHook = r1;
            return this;
        }

        @NotNull
        public final Builder setAppId(int r1) {
            this.appId = r1;
            return this;
        }

        @NotNull
        public final Builder setAppName(@NotNull String r2) {
            Intrinsics.f(r2, "appName");
            this.appName = r2;
            return this;
        }

        @NotNull
        public final Builder setDid(@NotNull String r2) {
            Intrinsics.f(r2, "did");
            this.did = r2;
            return this;
        }

        @NotNull
        public final Builder setNeedSetCookieHandler(boolean r1) {
            this.needSetCookieHandler = r1;
            return this;
        }

        @NotNull
        public final Builder setVersionCode(int r1) {
            this.versionCode = r1;
            return this;
        }

        @NotNull
        public final Builder setVersionName(@NotNull String r2) {
            Intrinsics.f(r2, "versionName");
            this.versionName = r2;
            return this;
        }
    }

    public /* synthetic */ NetworkConfig(String r1, int r2, String r3, int r4, String r5, boolean r6, NetworkParams.ApiProcessHook r7, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    @Nullable
    public final NetworkParams.ApiProcessHook<HttpRequestInfo> getApiProcessHook() {
        return this.apiProcessHook;
    }

    public final int getAppId() {
        return this.appId;
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
    }

    @NotNull
    public final String getChannel() {
        return this.channel;
    }

    @NotNull
    public final String getDid() {
        return this.did;
    }

    public final boolean getNeedSetCookieHandler() {
        return this.needSetCookieHandler;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    @NotNull
    public final String getVersionName() {
        return this.versionName;
    }

    public final void setDid(@NotNull String r2) {
        Intrinsics.f(r2, "<set-?>");
        this.did = r2;
    }

    private NetworkConfig(String r1, int r2, String r3, int r4, String r5, boolean r6, NetworkParams.ApiProcessHook<HttpRequestInfo> r7) {
        this.appName = r1;
        this.appId = r2;
        this.did = r3;
        this.versionCode = r4;
        this.versionName = r5;
        this.needSetCookieHandler = r6;
        this.apiProcessHook = r7;
        this.channel = ProductUtils.Companion.getProductType();
    }

    public /* synthetic */ NetworkConfig(String r10, int r11, String r12, int r13, String r14, boolean r15, NetworkParams.ApiProcessHook r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 64) == 0) goto L5;
        NetworkParams.ApiProcessHook r8 = null;
    L6:
        this(r10, r11, r12, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }
}
