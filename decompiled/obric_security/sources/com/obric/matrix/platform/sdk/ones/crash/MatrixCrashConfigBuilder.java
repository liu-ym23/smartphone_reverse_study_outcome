package com.obric.matrix.platform.sdk.ones.crash;

import android.app.Application;
import com.bytedance.platform.godzilla.common.CrashPortrait;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixCrashConfigBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\u0006J\u0006\u0010I\u001a\u00020:J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0001J\u001c\u0010\u0012\u001a\u00020\u00002\u0014\u0010K\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u0013J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u001bJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u001bJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u001bJ\u000e\u0010&\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u001bJ\u000e\u0010)\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u001bJ\u000e\u0010,\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u001bJ\u000e\u0010/\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u001bJ\u000e\u00102\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u001bJ\u000e\u00105\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u001bJ\u001a\u00108\u001a\u00020\u00002\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020:09J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u0006J\u000e\u0010B\u001a\u00020\u00002\u0006\u0010H\u001a\u00020CR\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001a\u0010&\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\u001a\u0010)\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u001a\u0010,\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\u001a\u0010/\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001fR\u001a\u00102\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u0010\u001fR\u001a\u00105\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u0010\u001fR&\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020:09X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\b\"\u0004\bA\u0010\nR\u001a\u0010B\u001a\u00020CX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006N"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/crash/MatrixCrashConfigBuilder;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "appVersion", "", "getAppVersion$sdk_platform_ones_release", "()Ljava/lang/String;", "setAppVersion$sdk_platform_ones_release", "(Ljava/lang/String;)V", "getApplication$sdk_platform_ones_release", "()Landroid/app/Application;", "chanelFetcher", "getChanelFetcher$sdk_platform_ones_release", "()Ljava/lang/Object;", "setChanelFetcher$sdk_platform_ones_release", "(Ljava/lang/Object;)V", "crashPortraitProvider", "Lkotlin/Function0;", "", "Lcom/bytedance/platform/godzilla/common/CrashPortrait;", "getCrashPortraitProvider$sdk_platform_ones_release", "()Lkotlin/jvm/functions/Function0;", "setCrashPortraitProvider$sdk_platform_ones_release", "(Lkotlin/jvm/functions/Function0;)V", "enableCookieManagerPlugin", "", "getEnableCookieManagerPlugin$sdk_platform_ones_release", "()Z", "setEnableCookieManagerPlugin$sdk_platform_ones_release", "(Z)V", "enableFinalizeTimeoutPlugin", "getEnableFinalizeTimeoutPlugin$sdk_platform_ones_release", "setEnableFinalizeTimeoutPlugin$sdk_platform_ones_release", "enableJsDialogBadTokenPlugin", "getEnableJsDialogBadTokenPlugin$sdk_platform_ones_release", "setEnableJsDialogBadTokenPlugin$sdk_platform_ones_release", "enableProviderInstalledFailedPlugin", "getEnableProviderInstalledFailedPlugin$sdk_platform_ones_release", "setEnableProviderInstalledFailedPlugin$sdk_platform_ones_release", "enableSpBlockPlugin", "getEnableSpBlockPlugin$sdk_platform_ones_release", "setEnableSpBlockPlugin$sdk_platform_ones_release", "enableSpFetcherDeadObjectPlugin", "getEnableSpFetcherDeadObjectPlugin$sdk_platform_ones_release", "setEnableSpFetcherDeadObjectPlugin$sdk_platform_ones_release", "enableStopActivityNPEPlugin", "getEnableStopActivityNPEPlugin$sdk_platform_ones_release", "setEnableStopActivityNPEPlugin$sdk_platform_ones_release", "enableSuperUncaughtExceptionPlugin", "getEnableSuperUncaughtExceptionPlugin$sdk_platform_ones_release", "setEnableSuperUncaughtExceptionPlugin$sdk_platform_ones_release", "enableToastBadTokenPlugin", "getEnableToastBadTokenPlugin$sdk_platform_ones_release", "setEnableToastBadTokenPlugin$sdk_platform_ones_release", "onCrashCatchSucceed", "Lkotlin/Function1;", "", "getOnCrashCatchSucceed$sdk_platform_ones_release", "()Lkotlin/jvm/functions/Function1;", "setOnCrashCatchSucceed$sdk_platform_ones_release", "(Lkotlin/jvm/functions/Function1;)V", "packageName", "getPackageName$sdk_platform_ones_release", "setPackageName$sdk_platform_ones_release", "updateVersion", "", "getUpdateVersion$sdk_platform_ones_release", "()I", "setUpdateVersion$sdk_platform_ones_release", "(I)V", "version", "buildAndInit", "fetcher", "provider", "enable", "callback", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixCrashConfigBuilder {
    private String appVersion;
    private final Application application;
    private Object chanelFetcher;
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
    private Function1<? super CrashPortrait, Unit> onCrashCatchSucceed;
    private String packageName;
    private int updateVersion;

    public MatrixCrashConfigBuilder(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
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
        this.onCrashCatchSucceed = C02301.INSTANCE;
    }

    public final Application getApplication$sdk_platform_ones_release() {
        return this.application;
    }

    public final boolean getEnableSpBlockPlugin$sdk_platform_ones_release() {
        return this.enableSpBlockPlugin;
    }

    public final void setEnableSpBlockPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableSpBlockPlugin = r1;
    }

    public final boolean getEnableSpFetcherDeadObjectPlugin$sdk_platform_ones_release() {
        return this.enableSpFetcherDeadObjectPlugin;
    }

    public final void setEnableSpFetcherDeadObjectPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableSpFetcherDeadObjectPlugin = r1;
    }

    public final boolean getEnableProviderInstalledFailedPlugin$sdk_platform_ones_release() {
        return this.enableProviderInstalledFailedPlugin;
    }

    public final void setEnableProviderInstalledFailedPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableProviderInstalledFailedPlugin = r1;
    }

    public final boolean getEnableCookieManagerPlugin$sdk_platform_ones_release() {
        return this.enableCookieManagerPlugin;
    }

    public final void setEnableCookieManagerPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableCookieManagerPlugin = r1;
    }

    public final boolean getEnableFinalizeTimeoutPlugin$sdk_platform_ones_release() {
        return this.enableFinalizeTimeoutPlugin;
    }

    public final void setEnableFinalizeTimeoutPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableFinalizeTimeoutPlugin = r1;
    }

    public final boolean getEnableJsDialogBadTokenPlugin$sdk_platform_ones_release() {
        return this.enableJsDialogBadTokenPlugin;
    }

    public final void setEnableJsDialogBadTokenPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableJsDialogBadTokenPlugin = r1;
    }

    public final boolean getEnableStopActivityNPEPlugin$sdk_platform_ones_release() {
        return this.enableStopActivityNPEPlugin;
    }

    public final void setEnableStopActivityNPEPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableStopActivityNPEPlugin = r1;
    }

    public final boolean getEnableToastBadTokenPlugin$sdk_platform_ones_release() {
        return this.enableToastBadTokenPlugin;
    }

    public final void setEnableToastBadTokenPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableToastBadTokenPlugin = r1;
    }

    public final boolean getEnableSuperUncaughtExceptionPlugin$sdk_platform_ones_release() {
        return this.enableSuperUncaughtExceptionPlugin;
    }

    public final void setEnableSuperUncaughtExceptionPlugin$sdk_platform_ones_release(boolean r1) {
        this.enableSuperUncaughtExceptionPlugin = r1;
    }

    public final Object getChanelFetcher$sdk_platform_ones_release() {
        return this.chanelFetcher;
    }

    public final void setChanelFetcher$sdk_platform_ones_release(Object r1) {
        this.chanelFetcher = r1;
    }

    public final String getPackageName$sdk_platform_ones_release() {
        return this.packageName;
    }

    public final void setPackageName$sdk_platform_ones_release(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.packageName = r2;
    }

    public final String getAppVersion$sdk_platform_ones_release() {
        return this.appVersion;
    }

    public final void setAppVersion$sdk_platform_ones_release(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.appVersion = r2;
    }

    public final int getUpdateVersion$sdk_platform_ones_release() {
        return this.updateVersion;
    }

    public final void setUpdateVersion$sdk_platform_ones_release(int r1) {
        this.updateVersion = r1;
    }

    public final Function0<List<CrashPortrait>> getCrashPortraitProvider$sdk_platform_ones_release() {
        return this.crashPortraitProvider;
    }

    public final void setCrashPortraitProvider$sdk_platform_ones_release(Function0<? extends List<? extends CrashPortrait>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.crashPortraitProvider = r2;
    }

    public final Function1<CrashPortrait, Unit> getOnCrashCatchSucceed$sdk_platform_ones_release() {
        return this.onCrashCatchSucceed;
    }

    public final void setOnCrashCatchSucceed$sdk_platform_ones_release(Function1<? super CrashPortrait, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.onCrashCatchSucceed = r2;
    }

    public final MatrixCrashConfigBuilder enableSpBlockPlugin(boolean r1) {
        this.enableSpBlockPlugin = r1;
        return this;
    }

    public final MatrixCrashConfigBuilder enableSpFetcherDeadObjectPlugin(boolean r1) {
        this.enableSpFetcherDeadObjectPlugin = r1;
        return this;
    }

    public final MatrixCrashConfigBuilder enableProviderInstalledFailedPlugin(boolean r1) {
        this.enableProviderInstalledFailedPlugin = r1;
        return this;
    }

    public final MatrixCrashConfigBuilder enableCookieManagerPlugin(boolean r1) {
        this.enableCookieManagerPlugin = r1;
        return this;
    }

    public final MatrixCrashConfigBuilder enableFinalizeTimeoutPlugin(boolean r1) {
        this.enableFinalizeTimeoutPlugin = r1;
        return this;
    }

    public final MatrixCrashConfigBuilder enableJsDialogBadTokenPlugin(boolean r1) {
        this.enableJsDialogBadTokenPlugin = r1;
        return this;
    }

    public final MatrixCrashConfigBuilder enableStopActivityNPEPlugin(boolean r1) {
        this.enableStopActivityNPEPlugin = r1;
        return this;
    }

    public final MatrixCrashConfigBuilder enableToastBadTokenPlugin(boolean r1) {
        this.enableToastBadTokenPlugin = r1;
        return this;
    }

    public final MatrixCrashConfigBuilder enableSuperUncaughtExceptionPlugin(boolean r1) {
        this.enableSuperUncaughtExceptionPlugin = r1;
        return this;
    }

    public final MatrixCrashConfigBuilder chanelFetcher(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "fetcher");
        this.chanelFetcher = r2;
        return this;
    }

    public final MatrixCrashConfigBuilder appVersion(String r2) {
        Intrinsics.checkNotNullParameter(r2, "version");
        this.appVersion = r2;
        return this;
    }

    public final MatrixCrashConfigBuilder packageName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "packageName");
        this.packageName = r2;
        return this;
    }

    public final MatrixCrashConfigBuilder updateVersion(int r1) {
        this.updateVersion = r1;
        return this;
    }

    public final MatrixCrashConfigBuilder crashPortraitProvider(Function0<? extends List<? extends CrashPortrait>> r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.crashPortraitProvider = r2;
        return this;
    }

    public final MatrixCrashConfigBuilder onCrashCatchSucceed(Function1<? super CrashPortrait, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.onCrashCatchSucceed = r2;
        return this;
    }

    public final void buildAndInit() {
        MatrixCrashManager.INSTANCE.init$sdk_platform_ones_release(this);
    }
}
