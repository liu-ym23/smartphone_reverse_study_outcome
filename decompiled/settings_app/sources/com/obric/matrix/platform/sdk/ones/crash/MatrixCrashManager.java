package com.obric.matrix.platform.sdk.ones.crash;

import android.app.Application;
import com.bytedance.platform.godzilla.Godzilla;
import com.bytedance.platform.godzilla.anr.CookieManagerPlugin;
import com.bytedance.platform.godzilla.anr.SpBlockPlugin;
import com.bytedance.platform.godzilla.crash.ProviderInstalledFailedPlugin;
import com.bytedance.platform.godzilla.crash.SpFetcherDeadObjectPlugin;
import com.bytedance.platform.godzilla.crash.uncaughtexecption.FinalizeTimeoutPlugin;
import com.bytedance.platform.godzilla.crash.uncaughtexecption.JsDialogBadTokenPlugin;
import com.bytedance.platform.godzilla.crash.uncaughtexecption.SuperUncaughtExceptionPlugin;
import com.bytedance.platform.godzilla.crash.uncaughtexecption.ToastBadTokenPlugin;
import com.bytedance.platform.godzilla.plugin.StartType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixCrashManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/crash/MatrixCrashManager;", "", "()V", "isInitialized", "", "init", "", "configBuilder", "Lcom/obric/matrix/platform/sdk/ones/crash/MatrixCrashConfigBuilder;", "init$sdk_platform_ones_release", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixCrashManager {
    public static final MatrixCrashManager INSTANCE = null;
    private static volatile boolean isInitialized;

    static {
        INSTANCE = new MatrixCrashManager();
    }

    private MatrixCrashManager() {
    }

    public final void init$sdk_platform_ones_release(final MatrixCrashConfigBuilder r4) {
        Intrinsics.checkNotNullParameter(r4, "configBuilder");
        if (isInitialized == false) goto L6;
        return;
    L6:
        if (isInitialized == false) goto L8;
        return;
    L8:
        Application r3 = r4.getApplication$sdk_platform_ones_release();
        Godzilla.Builder r0 = new Godzilla.Builder(r3);
        if (r4.getEnableSpBlockPlugin$sdk_platform_ones_release() == false) goto L12;
        r0.plugin(new SpBlockPlugin());
    L12:
        if (r4.getEnableSpFetcherDeadObjectPlugin$sdk_platform_ones_release() == false) goto L15;
        r0.plugin(new SpFetcherDeadObjectPlugin());
    L15:
        if (r4.getEnableProviderInstalledFailedPlugin$sdk_platform_ones_release() == false) goto L18;
        r0.plugin(new ProviderInstalledFailedPlugin());
    L18:
        if (r4.getEnableCookieManagerPlugin$sdk_platform_ones_release() == false) goto L21;
        r0.plugin(new CookieManagerPlugin());
    L21:
        if (r4.getEnableFinalizeTimeoutPlugin$sdk_platform_ones_release() == false) goto L24;
        r0.plugin(new FinalizeTimeoutPlugin());
    L24:
        if (r4.getEnableJsDialogBadTokenPlugin$sdk_platform_ones_release() == false) goto L27;
        r0.plugin(new JsDialogBadTokenPlugin());
    L27:
        if (r4.getEnableToastBadTokenPlugin$sdk_platform_ones_release() == false) goto L30;
        r0.plugin(new ToastBadTokenPlugin());
    L30:
        if (r4.getEnableSuperUncaughtExceptionPlugin$sdk_platform_ones_release() == false) goto L32;
        r0.plugin(new SuperUncaughtExceptionPlugin(new MatrixCrashManager$init$1(r4), r3));
    L32:
        Godzilla.init(r0.build()).start();
        Godzilla.with().start(StartType.REGISTER_EXCEPTION);
        isInitialized = true;
    }
}
