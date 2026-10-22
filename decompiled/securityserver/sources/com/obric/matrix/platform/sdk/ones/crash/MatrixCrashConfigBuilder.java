package com.obric.matrix.platform.sdk.ones.crash;

import android.app.Application;
import com.bytedance.platform.godzilla.common.CrashPortrait;
import com.bytedance.securityserver.robotspolicy.RobotsPolicyContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MatrixCrashConfigBuilder {

    @NotNull
    private String appVersion;

    @NotNull
    private final Application application;

    @Nullable
    private Object chanelFetcher;

    @NotNull
    private Function0<? extends List<? extends CrashPortrait>> crashPortraitProvider;
    private boolean enableCookieManagerPlugin;
    private boolean enableFinalizeTimeoutPlugin;
    private boolean enableJsDialogBadTokenPlugin;
    private boolean enableProviderInstalledFailedPlugin;
    private boolean enableSpBlockPlugin;
    private boolean enableSpFetcherDeadObjectPlugin;
    private boolean enableStopActivityNPEPlugin;
    private boolean enableSuperUncaughtExceptionPlugin;
    private boolean enableToastBadTokenPlugin;

    @NotNull
    private Function1<? super CrashPortrait, Unit> onCrashCatchSucceed;

    @NotNull
    private String packageName;
    private int updateVersion;

    public MatrixCrashConfigBuilder(@NotNull Application r2) {
        Intrinsics.f(r2, "application");
        this.application = r2;
        this.enableSpBlockPlugin = true;
        this.enableSpFetcherDeadObjectPlugin = true;
        this.enableProviderInstalledFailedPlugin = true;
        this.enableCookieManagerPlugin = true;
        this.enableFinalizeTimeoutPlugin = true;
        this.enableJsDialogBadTokenPlugin = true;
        this.enableStopActivityNPEPlugin = true;
        this.enableToastBadTokenPlugin = true;
        this.enableSuperUncaughtExceptionPlugin = true;
        this.packageName = "";
        this.appVersion = "1.0.0";
        this.crashPortraitProvider = AnonymousClass1.INSTANCE;
        this.onCrashCatchSucceed = C00331.INSTANCE;
    }

    @NotNull
    public final MatrixCrashConfigBuilder appVersion(@NotNull String r2) {
        Intrinsics.f(r2, RobotsPolicyContract.COL_VERSION);
        this.appVersion = r2;
        return this;
    }

    public final void buildAndInit() {
        MatrixCrashManager.INSTANCE.init$sdk_platform_ones_release(this);
    }

    @NotNull
    public final MatrixCrashConfigBuilder chanelFetcher(@NotNull Object r2) {
        Intrinsics.f(r2, "fetcher");
        this.chanelFetcher = r2;
        return this;
    }

    @NotNull
    public final MatrixCrashConfigBuilder crashPortraitProvider(@NotNull Function0<? extends List<? extends CrashPortrait>> r2) {
        Intrinsics.f(r2, "provider");
        this.crashPortraitProvider = r2;
        return this;
    }

    @NotNull
    public final MatrixCrashConfigBuilder enableCookieManagerPlugin(boolean r1) {
        this.enableCookieManagerPlugin = r1;
        return this;
    }

    @NotNull
    public final MatrixCrashConfigBuilder enableFinalizeTimeoutPlugin(boolean r1) {
        this.enableFinalizeTimeoutPlugin = r1;
        return this;
    }

    @NotNull
    public final MatrixCrashConfigBuilder enableJsDialogBadTokenPlugin(boolean r1) {
        this.enableJsDialogBadTokenPlugin = r1;
        return this;
    }

    @NotNull
    public final MatrixCrashConfigBuilder enableProviderInstalledFailedPlugin(boolean r1) {
        this.enableProviderInstalledFailedPlugin = r1;
        return this;
    }

    @NotNull
    public final MatrixCrashConfigBuilder enableSpBlockPlugin(boolean r1) {
        this.enableSpBlockPlugin = r1;
        return this;
    }

    @NotNull
    public final MatrixCrashConfigBuilder enableSpFetcherDeadObjectPlugin(boolean r1) {
        this.enableSpFetcherDeadObjectPlugin = r1;
        return this;
    }

    @NotNull
    public final MatrixCrashConfigBuilder enableStopActivityNPEPlugin(boolean r1) {
        this.enableStopActivityNPEPlugin = r1;
        return this;
    }

    @NotNull
    public final MatrixCrashConfigBuilder enableSuperUncaughtExceptionPlugin(boolean r1) {
        this.enableSuperUncaughtExceptionPlugin = r1;
        return this;
    }

    @NotNull
    public final MatrixCrashConfigBuilder enableToastBadTokenPlugin(boolean r1) {
        this.enableToastBadTokenPlugin = r1;
        return this;
    }

    @NotNull
    public final String getAppVersion$sdk_platform_ones_release() {
        return this.appVersion;
    }

    @NotNull
    public final Application getApplication$sdk_platform_ones_release() {
        return this.application;
    }

    @Nullable
    public final Object getChanelFetcher$sdk_platform_ones_release() {
        return this.chanelFetcher;
    }

    @NotNull
    public final Function0<List<CrashPortrait>> getCrashPortraitProvider$sdk_platform_ones_release() {
        return this.crashPortraitProvider;
    }

    public final boolean getEnableCookieManagerPlugin$sdk_platform_ones_release() {
        return this.enableCookieManagerPlugin;
    }

    public final boolean getEnableFinalizeTimeoutPlugin$sdk_platform_ones_release() {
        return this.enableFinalizeTimeoutPlugin;
    }

    public final boolean getEnableJsDialogBadTokenPlugin$sdk_platform_ones_release() {
        return this.enableJsDialogBadTokenPlugin;
    }

    public final boolean getEnableProviderInstalledFailedPlugin$sdk_platform_ones_release() {
        return this.enableProviderInstalledFailedPlugin;
    }

    public final boolean getEnableSpBlockPlugin$sdk_platform_ones_release() {
        return this.enableSpBlockPlugin;
    }

    public final boolean getEnableSpFetcherDeadObjectPlugin$sdk_platform_ones_release() {
        return this.enableSpFetcherDeadObjectPlugin;
    }

    public final boolean getEnableStopActivityNPEPlugin$sdk_platform_ones_release() {
        return this.enableStopActivityNPEPlugin;
    }

    public final boolean getEnableSuperUncaughtExceptionPlugin$sdk_platform_ones_release() {
        return this.enableSuperUncaughtExceptionPlugin;
    }

    public final boolean getEnableToastBadTokenPlugin$sdk_platform_ones_release() {
        return this.enableToastBadTokenPlugin;
    }

    @NotNull
    public final Function1<CrashPortrait, Unit> getOnCrashCatchSucceed$sdk_platform_ones_release() {
        return this.onCrashCatchSucceed;
    }

    @NotNull
    public final String getPackageName$sdk_platform_ones_release() {
        return this.packageName;
    }

    public final int getUpdateVersion$sdk_platform_ones_release() {
        return this.updateVersion;
    }

    @NotNull
    public final MatrixCrashConfigBuilder onCrashCatchSucceed(@NotNull Function1<? super CrashPortrait, Unit> r2) {
        Intrinsics.f(r2, "callback");
        this.onCrashCatchSucceed = r2;
        return this;
    }

    @NotNull
    public final MatrixCrashConfigBuilder packageName(@NotNull String r2) {
        Intrinsics.f(r2, "packageName");
        this.packageName = r2;
        return this;
    }

    public final void setAppVersion$sdk_platform_ones_release(@NotNull String r2) {
        Intrinsics.f(r2, "<set-?>");
        this.appVersion = r2;
    }

    public final void setChanelFetcher$sdk_platform_ones_release(@Nullable Object r1) {
        this.chanelFetcher = r1;
    }

    public final void setCrashPortraitProvider$sdk_platform_ones_release(@NotNull Function0<? extends List<? extends CrashPortrait>> r2) {
        Intrinsics.f(r2, "<set-?>");
        this.crashPortraitProvider = r2;
    }

    public final void setEnableCookieManagerPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableCookieManagerPlugin = r1;
    }

    public final void setEnableFinalizeTimeoutPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableFinalizeTimeoutPlugin = r1;
    }

    public final void setEnableJsDialogBadTokenPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableJsDialogBadTokenPlugin = r1;
    }

    public final void setEnableProviderInstalledFailedPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableProviderInstalledFailedPlugin = r1;
    }

    public final void setEnableSpBlockPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableSpBlockPlugin = r1;
    }

    public final void setEnableSpFetcherDeadObjectPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableSpFetcherDeadObjectPlugin = r1;
    }

    public final void setEnableStopActivityNPEPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableStopActivityNPEPlugin = r1;
    }

    public final void setEnableSuperUncaughtExceptionPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableSuperUncaughtExceptionPlugin = r1;
    }

    public final void setEnableToastBadTokenPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableToastBadTokenPlugin = r1;
    }

    public final void setOnCrashCatchSucceed$sdk_platform_ones_release(@NotNull Function1<? super CrashPortrait, Unit> r2) {
        Intrinsics.f(r2, "<set-?>");
        this.onCrashCatchSucceed = r2;
    }

    public final void setPackageName$sdk_platform_ones_release(@NotNull String r2) {
        Intrinsics.f(r2, "<set-?>");
        this.packageName = r2;
    }

    public final void setUpdateVersion$sdk_platform_ones_release(int r1) {
        this.updateVersion = r1;
    }

    @NotNull
    public final MatrixCrashConfigBuilder updateVersion(int r1) {
        this.updateVersion = r1;
        return this;
    }
}
