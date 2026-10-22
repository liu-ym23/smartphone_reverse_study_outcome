package com.obric.matrix.platform.sdk.ones.init;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CrashProtectConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0001\u0017BO\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/init/CrashProtectConfig;", "", "enableSpBlockPlugin", "", "enableSpFetcherDeadObjectPlugin", "enableProviderInstalledFailedPlugin", "enableCookieManagerPlugin", "enableFinalizeTimeoutPlugin", "enableJsDialogBadTokenPlugin", "enableStopActivityNPEPlugin", "enableToastBadTokenPlugin", "enableSuperUncaughtExceptionPlugin", "(ZZZZZZZZZ)V", "getEnableCookieManagerPlugin", "()Z", "getEnableFinalizeTimeoutPlugin", "getEnableJsDialogBadTokenPlugin", "getEnableProviderInstalledFailedPlugin", "getEnableSpBlockPlugin", "getEnableSpFetcherDeadObjectPlugin", "getEnableStopActivityNPEPlugin", "getEnableSuperUncaughtExceptionPlugin", "getEnableToastBadTokenPlugin", "Builder", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CrashProtectConfig {
    private final boolean enableCookieManagerPlugin;
    private final boolean enableFinalizeTimeoutPlugin;
    private final boolean enableJsDialogBadTokenPlugin;
    private final boolean enableProviderInstalledFailedPlugin;
    private final boolean enableSpBlockPlugin;
    private final boolean enableSpFetcherDeadObjectPlugin;
    private final boolean enableStopActivityNPEPlugin;
    private final boolean enableSuperUncaughtExceptionPlugin;
    private final boolean enableToastBadTokenPlugin;

    /* JADX INFO: compiled from: CrashProtectConfig.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/init/CrashProtectConfig$Builder;", "", "()V", "enableCookieManagerPlugin", "", "enableFinalizeTimeoutPlugin", "enableJsDialogBadTokenPlugin", "enableProviderInstalledFailedPlugin", "enableSpBlockPlugin", "enableSpFetcherDeadObjectPlugin", "enableStopActivityNPEPlugin", "enableSuperUncaughtExceptionPlugin", "enableToastBadTokenPlugin", "build", "Lcom/obric/matrix/platform/sdk/ones/init/CrashProtectConfig;", "setEnableCookieManagerPlugin", "setEnableFinalizeTimeoutPlugin", "setEnableJsDialogBadTokenPlugin", "setEnableProviderInstalledFailedPlugin", "setEnableSpBlockPlugin", "setEnableSpFetcherDeadObjectPlugin", "setEnableStopActivityNPEPlugin", "setEnableSuperUncaughtExceptionPlugin", "setEnableToastBadTokenPlugin", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private boolean enableCookieManagerPlugin;
        private boolean enableFinalizeTimeoutPlugin;
        private boolean enableJsDialogBadTokenPlugin;
        private boolean enableProviderInstalledFailedPlugin;
        private boolean enableSpBlockPlugin;
        private boolean enableSpFetcherDeadObjectPlugin;
        private boolean enableStopActivityNPEPlugin;
        private boolean enableSuperUncaughtExceptionPlugin;
        private boolean enableToastBadTokenPlugin;

        public Builder() {
            this.enableSpBlockPlugin = true;
            this.enableSpFetcherDeadObjectPlugin = true;
            this.enableProviderInstalledFailedPlugin = true;
            this.enableCookieManagerPlugin = true;
            this.enableFinalizeTimeoutPlugin = true;
            this.enableJsDialogBadTokenPlugin = true;
            this.enableStopActivityNPEPlugin = true;
            this.enableToastBadTokenPlugin = true;
            this.enableSuperUncaughtExceptionPlugin = true;
        }

        public final Builder setEnableSpBlockPlugin(boolean r1) {
            this.enableSpBlockPlugin = r1;
            return this;
        }

        public final Builder setEnableSpFetcherDeadObjectPlugin(boolean r1) {
            this.enableSpFetcherDeadObjectPlugin = r1;
            return this;
        }

        public final Builder setEnableProviderInstalledFailedPlugin(boolean r1) {
            this.enableProviderInstalledFailedPlugin = r1;
            return this;
        }

        public final Builder setEnableCookieManagerPlugin(boolean r1) {
            this.enableCookieManagerPlugin = r1;
            return this;
        }

        public final Builder setEnableFinalizeTimeoutPlugin(boolean r1) {
            this.enableFinalizeTimeoutPlugin = r1;
            return this;
        }

        public final Builder setEnableJsDialogBadTokenPlugin(boolean r1) {
            this.enableJsDialogBadTokenPlugin = r1;
            return this;
        }

        public final Builder setEnableStopActivityNPEPlugin(boolean r1) {
            this.enableStopActivityNPEPlugin = r1;
            return this;
        }

        public final Builder setEnableToastBadTokenPlugin(boolean r1) {
            this.enableToastBadTokenPlugin = r1;
            return this;
        }

        public final Builder setEnableSuperUncaughtExceptionPlugin(boolean r1) {
            this.enableSuperUncaughtExceptionPlugin = r1;
            return this;
        }

        public final CrashProtectConfig build() {
            return new CrashProtectConfig(this.enableSpBlockPlugin, this.enableSpFetcherDeadObjectPlugin, this.enableProviderInstalledFailedPlugin, this.enableCookieManagerPlugin, this.enableFinalizeTimeoutPlugin, this.enableJsDialogBadTokenPlugin, this.enableStopActivityNPEPlugin, this.enableToastBadTokenPlugin, this.enableSuperUncaughtExceptionPlugin, null);
        }
    }

    public /* synthetic */ CrashProtectConfig(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, DefaultConstructorMarker r10) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    private CrashProtectConfig(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9) {
        this.enableSpBlockPlugin = r1;
        this.enableSpFetcherDeadObjectPlugin = r2;
        this.enableProviderInstalledFailedPlugin = r3;
        this.enableCookieManagerPlugin = r4;
        this.enableFinalizeTimeoutPlugin = r5;
        this.enableJsDialogBadTokenPlugin = r6;
        this.enableStopActivityNPEPlugin = r7;
        this.enableToastBadTokenPlugin = r8;
        this.enableSuperUncaughtExceptionPlugin = r9;
    }

    public final boolean getEnableSpBlockPlugin() {
        return this.enableSpBlockPlugin;
    }

    public final boolean getEnableSpFetcherDeadObjectPlugin() {
        return this.enableSpFetcherDeadObjectPlugin;
    }

    public final boolean getEnableProviderInstalledFailedPlugin() {
        return this.enableProviderInstalledFailedPlugin;
    }

    public final boolean getEnableCookieManagerPlugin() {
        return this.enableCookieManagerPlugin;
    }

    public final boolean getEnableFinalizeTimeoutPlugin() {
        return this.enableFinalizeTimeoutPlugin;
    }

    public final boolean getEnableJsDialogBadTokenPlugin() {
        return this.enableJsDialogBadTokenPlugin;
    }

    public final boolean getEnableStopActivityNPEPlugin() {
        return this.enableStopActivityNPEPlugin;
    }

    public final boolean getEnableToastBadTokenPlugin() {
        return this.enableToastBadTokenPlugin;
    }

    public final boolean getEnableSuperUncaughtExceptionPlugin() {
        return this.enableSuperUncaughtExceptionPlugin;
    }
}
