package com.obric.matrix.platform.sdk.ones.init;

import com.android.settings.search.IndexDatabaseHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseComponentConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0014B5\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentConfig;", "", "appId", "", "isBoe", "", "loopInternal", "", "baseUrl", "", "appName", "(IZJLjava/lang/String;Ljava/lang/String;)V", "getAppId", "()I", "getAppName", "()Ljava/lang/String;", "getBaseUrl", "()Z", "getLoopInternal", "()J", "Builder", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BaseComponentConfig {
    private final int appId;
    private final String appName;
    private final String baseUrl;
    private final boolean isBoe;
    private final long loopInternal;

    /* JADX INFO: compiled from: BaseComponentConfig.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentConfig$Builder;", "", "()V", "appId", "", "appName", "", "baseUrl", "isBoe", "", "loopInternal", "", IndexDatabaseHelper.MetaColumns.BUILD, "Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentConfig;", "setAppId", "setAppName", "setBaseUrl", "setIsBoe", "setLoopInternal", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private int appId;
        private String appName;
        private String baseUrl;
        private boolean isBoe;
        private long loopInternal;

        public Builder() {
            this.baseUrl = "";
            this.appName = "";
        }

        public final Builder setAppName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "appName");
            this.appName = r2;
            return this;
        }

        public final Builder setBaseUrl(String r2) {
            Intrinsics.checkNotNullParameter(r2, "baseUrl");
            this.baseUrl = r2;
            return this;
        }

        public final Builder setAppId(int r1) {
            this.appId = r1;
            return this;
        }

        public final Builder setIsBoe(boolean r1) {
            this.isBoe = r1;
            return this;
        }

        public final Builder setLoopInternal(long r1) {
            this.loopInternal = r1;
            return this;
        }

        public final BaseComponentConfig build() {
            return new BaseComponentConfig(this.appId, this.isBoe, this.loopInternal, this.baseUrl, null, 16, null);
        }
    }

    private BaseComponentConfig(int r1, boolean r2, long r3, String r5, String r6) {
        this.appId = r1;
        this.isBoe = r2;
        this.loopInternal = r3;
        this.baseUrl = r5;
        this.appName = r6;
    }

    /* synthetic */ BaseComponentConfig(int r8, boolean r9, long r10, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 4) == 0) goto L5;
        r10 = 0;
    L5:
        long r3 = r10;
        if ((r14 & 8) == 0) goto L8;
        String r5 = "";
    L10:
        if ((r14 & 16) == 0) goto L12;
        String r6 = "";
    L13:
        this(r8, r9, r3, r5, r6);
        return;
    L12:
        r6 = r13;
        goto L13
    L8:
        r5 = r12;
        goto L10
    }

    public final int getAppId() {
        return this.appId;
    }

    public final boolean isBoe() {
        return this.isBoe;
    }

    public final long getLoopInternal() {
        return this.loopInternal;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getAppName() {
        return this.appName;
    }
}
