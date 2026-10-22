package com.obric.matrix.platform.sdk.ones.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixSettingsConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u0012B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/settings/MatrixSettingsConfig;", "", "pkgName", "", "versionCode", "", "versionName", "isBoe", "", "receiverName", "(Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;)V", "()Z", "getPkgName", "()Ljava/lang/String;", "getReceiverName", "getVersionCode", "()I", "getVersionName", "Builder", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixSettingsConfig {
    private final boolean isBoe;
    private final String pkgName;
    private final String receiverName;
    private final int versionCode;
    private final String versionName;

    /* JADX INFO: compiled from: MatrixSettingsConfig.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/settings/MatrixSettingsConfig$Builder;", "", "()V", "isBoe", "", "pkgName", "", "receiverName", "versionCode", "", "versionName", "build", "Lcom/obric/matrix/platform/sdk/ones/settings/MatrixSettingsConfig;", "setIsBoe", "setPackageName", "setReceiverName", "setVersionCode", "setVersionName", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private boolean isBoe;
        private String pkgName;
        private String receiverName;
        private int versionCode;
        private String versionName;

        public Builder() {
            this.pkgName = "";
            this.versionName = "";
            this.receiverName = "";
        }

        public final Builder setPackageName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "pkgName");
            this.pkgName = r2;
            return this;
        }

        public final Builder setReceiverName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "receiverName");
            this.receiverName = r2;
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

        public final Builder setIsBoe(boolean r1) {
            this.isBoe = r1;
            return this;
        }

        public final MatrixSettingsConfig build() {
            return new MatrixSettingsConfig(this.pkgName, this.versionCode, this.versionName, this.isBoe, this.receiverName, null);
        }
    }

    public /* synthetic */ MatrixSettingsConfig(String r1, int r2, String r3, boolean r4, String r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    private MatrixSettingsConfig(String r1, int r2, String r3, boolean r4, String r5) {
        this.pkgName = r1;
        this.versionCode = r2;
        this.versionName = r3;
        this.isBoe = r4;
        this.receiverName = r5;
    }

    /* synthetic */ MatrixSettingsConfig(String r7, int r8, String r9, boolean r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = false;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    public final String getPkgName() {
        return this.pkgName;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final boolean isBoe() {
        return this.isBoe;
    }

    public final String getReceiverName() {
        return this.receiverName;
    }
}
