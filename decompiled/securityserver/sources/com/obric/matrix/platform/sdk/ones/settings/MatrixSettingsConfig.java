package com.obric.matrix.platform.sdk.ones.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MatrixSettingsConfig {
    private final boolean isBoe;

    @NotNull
    private final String pkgName;

    @NotNull
    private final String receiverName;
    private final int versionCode;

    @NotNull
    private final String versionName;

    @Metadata
    public static final class Builder {
        private boolean isBoe;

        @NotNull
        private String pkgName;

        @NotNull
        private String receiverName;
        private int versionCode;

        @NotNull
        private String versionName;

        public Builder() {
            this.pkgName = "";
            this.versionName = "";
            this.receiverName = "";
        }

        @NotNull
        public final MatrixSettingsConfig build() {
            return new MatrixSettingsConfig(this.pkgName, this.versionCode, this.versionName, this.isBoe, this.receiverName, null);
        }

        @NotNull
        public final Builder setIsBoe(boolean r1) {
            this.isBoe = r1;
            return this;
        }

        @NotNull
        public final Builder setPackageName(@NotNull String r2) {
            Intrinsics.f(r2, "pkgName");
            this.pkgName = r2;
            return this;
        }

        @NotNull
        public final Builder setReceiverName(@NotNull String r2) {
            Intrinsics.f(r2, "receiverName");
            this.receiverName = r2;
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

    public /* synthetic */ MatrixSettingsConfig(String r1, int r2, String r3, boolean r4, String r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    @NotNull
    public final String getPkgName() {
        return this.pkgName;
    }

    @NotNull
    public final String getReceiverName() {
        return this.receiverName;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    @NotNull
    public final String getVersionName() {
        return this.versionName;
    }

    public final boolean isBoe() {
        return this.isBoe;
    }

    private MatrixSettingsConfig(String r1, int r2, String r3, boolean r4, String r5) {
        this.pkgName = r1;
        this.versionCode = r2;
        this.versionName = r3;
        this.isBoe = r4;
        this.receiverName = r5;
    }

    public /* synthetic */ MatrixSettingsConfig(String r7, int r8, String r9, boolean r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = false;
    L5:
        this(r7, r8, r9, r10, r11);
    }
}
