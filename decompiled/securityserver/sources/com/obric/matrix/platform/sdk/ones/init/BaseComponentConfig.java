package com.obric.matrix.platform.sdk.ones.init;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.ttnet.http.HttpRequestInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class BaseComponentConfig {

    @Nullable
    private final NetworkParams.ApiProcessHook<HttpRequestInfo> apiProcessHook;
    private final int appId;

    @NotNull
    private final String appName;

    @NotNull
    private final String baseUrl;
    private final boolean isBoe;
    private final long loopInternal;
    private final boolean needSetCookieHandler;
    private final boolean useTTNet;

    @Metadata
    public static final class Builder {

        @Nullable
        private NetworkParams.ApiProcessHook<HttpRequestInfo> apiProcessHook;
        private int appId;

        @NotNull
        private String appName;

        @NotNull
        private String baseUrl;
        private boolean isBoe;
        private long loopInternal;
        private boolean needSetCookieHandler;
        private boolean useTTNet;

        public Builder() {
            this.useTTNet = true;
            this.baseUrl = "";
            this.appName = "";
            this.needSetCookieHandler = true;
        }

        @NotNull
        public final BaseComponentConfig build() {
            return new BaseComponentConfig(this.appId, this.isBoe, this.loopInternal, this.useTTNet, this.baseUrl, this.appName, this.needSetCookieHandler, this.apiProcessHook, null);
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
        public final Builder setBaseUrl(@NotNull String r2) {
            Intrinsics.f(r2, "baseUrl");
            this.baseUrl = r2;
            return this;
        }

        @NotNull
        public final Builder setIsBoe(boolean r1) {
            this.isBoe = r1;
            return this;
        }

        @NotNull
        public final Builder setLoopInternal(long r1) {
            this.loopInternal = r1;
            return this;
        }

        @NotNull
        public final Builder setNeedSetCookieHandler(boolean r1) {
            this.needSetCookieHandler = r1;
            return this;
        }

        @NotNull
        public final Builder setUseTTNet(boolean r1) {
            this.useTTNet = r1;
            return this;
        }
    }

    public /* synthetic */ BaseComponentConfig(int r1, boolean r2, long r3, boolean r5, String r6, String r7, boolean r8, NetworkParams.ApiProcessHook r9, DefaultConstructorMarker r10) {
        this(r1, r2, r3, r5, r6, r7, r8, r9);
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
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final long getLoopInternal() {
        return this.loopInternal;
    }

    public final boolean getNeedSetCookieHandler() {
        return this.needSetCookieHandler;
    }

    public final boolean getUseTTNet() {
        return this.useTTNet;
    }

    public final boolean isBoe() {
        return this.isBoe;
    }

    private BaseComponentConfig(int r1, boolean r2, long r3, boolean r5, String r6, String r7, boolean r8, NetworkParams.ApiProcessHook<HttpRequestInfo> r9) {
        this.appId = r1;
        this.isBoe = r2;
        this.loopInternal = r3;
        this.useTTNet = r5;
        this.baseUrl = r6;
        this.appName = r7;
        this.needSetCookieHandler = r8;
        this.apiProcessHook = r9;
    }

    public /* synthetic */ BaseComponentConfig(int r14, boolean r15, long r16, boolean r18, String r19, String r20, boolean r21, NetworkParams.ApiProcessHook r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 4) == 0) goto L5;
        long r6 = 0;
    L7:
        if ((r23 & 8) == 0) goto L9;
        boolean r8 = true;
    L11:
        if ((r23 & 16) == 0) goto L13;
        String r9 = "";
    L15:
        if ((r23 & 32) == 0) goto L17;
        String r10 = "";
    L19:
        if ((r23 & 64) == 0) goto L21;
        boolean r11 = true;
    L23:
        if ((r23 & 128) == 0) goto L25;
        NetworkParams.ApiProcessHook r12 = null;
    L26:
        this(r14, r15, r6, r8, r9, r10, r11, r12);
        return;
    L25:
        r12 = r22;
        goto L26
    L21:
        r11 = r21;
        goto L23
    L17:
        r10 = r20;
        goto L19
    L13:
        r9 = r19;
        goto L15
    L9:
        r8 = r18;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }
}
