package com.obric.matrix.platform.sdk.ones.dataanalysis;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MatrixTeaConfig {
    private final boolean isBoe;

    @NotNull
    private final String pkgName;
    private final int versionCode;

    @NotNull
    private final String versionName;

    @Metadata
    public static final class Builder {
        private boolean isBoe;

        @NotNull
        private String pkgName;
        private int versionCode;

        @NotNull
        private String versionName;

        public Builder() {
            this.pkgName = "";
            this.versionName = "";
        }

        @NotNull
        public final MatrixTeaConfig build() {
            return new MatrixTeaConfig(this.pkgName, this.versionCode, this.versionName, this.isBoe, null);
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

    public /* synthetic */ MatrixTeaConfig(String r1, int r2, String r3, boolean r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    @NotNull
    public final String getPkgName() {
        return this.pkgName;
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

    private MatrixTeaConfig(String r1, int r2, String r3, boolean r4) {
        this.pkgName = r1;
        this.versionCode = r2;
        this.versionName = r3;
        this.isBoe = r4;
    }

    public /* synthetic */ MatrixTeaConfig(String r1, int r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        this(r1, r2, r3, r4);
    }
}
