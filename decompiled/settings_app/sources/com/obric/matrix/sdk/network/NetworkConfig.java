package com.obric.matrix.sdk.network;

import com.android.settings.search.IndexDatabaseHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0001\u0015B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/obric/matrix/sdk/network/NetworkConfig;", "", "appName", "", "appId", "", "did", "versionCode", "versionName", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getAppId", "()I", "getAppName", "()Ljava/lang/String;", "channel", "getChannel", "getDid", "setDid", "(Ljava/lang/String;)V", "getVersionCode", "getVersionName", "Builder", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkConfig {
    private final int appId;
    private final String appName;
    private final String channel;
    private String did;
    private final int versionCode;
    private final String versionName;

    /* JADX INFO: compiled from: NetworkConfig.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/sdk/network/NetworkConfig$Builder;", "", "()V", "appId", "", "appName", "", "did", "versionCode", "versionName", IndexDatabaseHelper.MetaColumns.BUILD, "Lcom/obric/matrix/sdk/network/NetworkConfig;", "setAppId", "setAppName", "setDid", "setVersionCode", "setVersionName", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private int appId;
        private String appName;
        private String did;
        private int versionCode;
        private String versionName;

        public Builder() {
            this.appName = "";
            this.did = "";
            this.versionName = "";
        }

        public final Builder setAppName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "appName");
            this.appName = r2;
            return this;
        }

        public final Builder setAppId(int r1) {
            this.appId = r1;
            return this;
        }

        public final Builder setDid(String r2) {
            Intrinsics.checkNotNullParameter(r2, "did");
            this.did = r2;
            return this;
        }

        public final Builder setVersionCode(int r1) {
            this.versionCode = r1;
            return this;
        }

        public final Builder setVersionName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "versionName");
            this.versionName = r2;
            return this;
        }

        public final NetworkConfig build() {
            return new NetworkConfig(this.appName, this.appId, this.did, this.versionCode, this.versionName, null);
        }
    }

    public /* synthetic */ NetworkConfig(String r1, int r2, String r3, int r4, String r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    private NetworkConfig(String r1, int r2, String r3, int r4, String r5) {
        this.appName = r1;
        this.appId = r2;
        this.did = r3;
        this.versionCode = r4;
        this.versionName = r5;
        this.channel = ProductUtils.Companion.getProductType();
    }

    public final String getAppName() {
        return this.appName;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final String getDid() {
        return this.did;
    }

    public final void setDid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.did = r2;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final String getChannel() {
        return this.channel;
    }
}
