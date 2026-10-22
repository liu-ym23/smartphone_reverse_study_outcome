package com.obric.matrix.platform.sdk.ones.internal.config;

import android.app.KeyguardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.net.Uri;
import com.obric.matrix.platform.sdk.ones.MatrixOnesSdk;
import com.obric.matrix.platform.sdk.ones.internal.tunnel.CmdManager;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.proto.SdkAllConfig;
import com.obric.matrix.proto.SdkSendCmdConfig;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SdkConfigManager {

    @NotNull
    private static final String ALL_CONFIG_STR = "all_config_str";

    @NotNull
    private static final String AUTHORITY = "com.obric.matrix.sdk.settings.provider";
    private static final int DEFAULT_POLLING_INTERVAL = 30;

    @NotNull
    private static final String GET_SETTINGS_CONFIG = "get_settings_config";

    @NotNull
    private static final String GET_SETTINGS_CONFIG_URI = "content://com.obric.matrix.sdk.settings.provider/get_settings_config";

    @NotNull
    public static final SdkConfigManager INSTANCE = null;

    @NotNull
    private static final String SDK_ALL_CONFIG = "sdk_all_config";

    @NotNull
    private static final String TAG = "SdkConfigManager";
    private static boolean isStartPolling;

    @NotNull
    private static final Lazy keyguardManager$delegate = null;

    @Nullable
    private static Disposable pollingConfigDisposable;

    @Nullable
    private static SdkAllConfig sdkAllConfig;

    static {
        INSTANCE = new SdkConfigManager();
        keyguardManager$delegate = LazyKt.b(SdkConfigManager$keyguardManager$2.INSTANCE);
    }

    private SdkConfigManager() {
    }

    public static /* synthetic */ void a(Long r0) {
        m24startPolling$lambda1(r0);
    }

    private final KeyguardManager getKeyguardManager() {
        return (KeyguardManager) keyguardManager$delegate.getValue();
    }

    private final void startPolling() {
        Disposable r4 = pollingConfigDisposable;
        if (r4 == null) goto L5;
        r4.dispose();
    L5:
        SdkAllConfig r5 = sdkAllConfig;
        if (r5 == null) goto L10;
        SdkSendCmdConfig r6 = r5.sdkSendCmdConfig;
        if (r6 == null) goto L10;
        Integer r7 = r6.pollingInterval;
    L11:
        if (r7 != null) goto L13;
    L15:
        int r1 = 30;
    L16:
        MLog.d$default(TAG, "startPolling, realInterval: " + r1 + ", interval: " + r7, null, 4, null);
        long r0 = (long) r1;
        pollingConfigDisposable = Observable.interval(r0, r0, TimeUnit.MINUTES).subscribeOn(Schedulers.io()).subscribe(new a(0));
        return;
    L13:
        if (r7.intValue() <= 0) goto L15;
        r1 = r7.intValue();
    L10:
        r7 = null;
        goto L11
    }

    /* JADX INFO: renamed from: startPolling$lambda-1, reason: not valid java name */
    private static final void m24startPolling$lambda1(Long r4) {
        SdkConfigManager r5 = INSTANCE;
        KeyguardManager r0 = r5.getKeyguardManager();
        if (r0 != null) goto L5;
        Unit r6 = null;
    L10:
        if (r6 != null) goto L13;
        MLog.w$default(TAG, "keyguardManager 为空，无法判断锁屏状态，跳过本次更新", null, 4, null);
        return;
    L13:
        return;
    L5:
        if (r0.isKeyguardLocked() == true) goto L7;
        r5.updateConfigByProvider();
        CmdManager.INSTANCE.updateConfig$sdk_platform_ones_release();
    L8:
        r6 = Unit.f330a;
        goto L10
    L7:
        MLog.d$default(TAG, "设备处于锁屏状态，跳过本次配置更新", null, 4, null);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateConfigByProvider() {
        SQLiteCursor r2 = 0;
        MLog.d$default(TAG, "updateConfigByProvider", null, 4, null);
        Context r1 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();     // Catch: Throwable -> L24 Exception -> L26
        Intrinsics.c(r1);     // Catch: Throwable -> L24 Exception -> L26
        ContentResolver r3 = r1.getContentResolver();     // Catch: Throwable -> L24 Exception -> L26
        MLog.d$default(TAG, "Uri content://com.obric.matrix.sdk.settings.provider/get_settings_config", null, 4, null);     // Catch: Throwable -> L24 Exception -> L26
        Cursor r4 = r3.query(Uri.parse(GET_SETTINGS_CONFIG_URI), null, null, null);     // Catch: Throwable -> L24 Exception -> L26
        if (r4 != null) goto L12;
        MLog.d$default(TAG, "get sdk config items is null", null, 4, null);     // Catch: Throwable -> L7 Exception -> L9
        return;
    L12:
        if (r4.moveToNext() == false) goto L23;
        int r5 = r4.getColumnIndex(ALL_CONFIG_STR);     // Catch: Throwable -> L7 Exception -> L9
        if (r5 < 0) goto L16;
        MLog.d$default(TAG, "get all config str = " + r4.getString(r5), null, 4, null);     // Catch: Throwable -> L7 Exception -> L9
    L16:
        int r6 = r4.getColumnIndex(SDK_ALL_CONFIG);     // Catch: Throwable -> L7 Exception -> L9
        if (r6 < 0) goto L12;
        byte[] r7 = r4.getBlob(r6);     // Catch: Throwable -> L7 Exception -> L9
        if (r7 != null) goto L20;
        MLog.d$default(TAG, "SdkAllConfigBytes == null ", null, 4, null);     // Catch: Throwable -> L7 Exception -> L9
        goto L12
    L20:
        MLog.d$default(TAG, "SdkAllConfigBytes != null ", null, 4, null);     // Catch: Throwable -> L7 Exception -> L9
        sdkAllConfig = SdkAllConfig.ADAPTER.decode(r7);     // Catch: Throwable -> L7 Exception -> L9
        MLog.d$default(TAG, "sdk all config: " + sdkAllConfig, null, 4, null);     // Catch: Throwable -> L7 Exception -> L9
    L23:
        r4.close();
    L32:
        if (isStartPolling == true) goto L49;
        isStartPolling = true;
        startPolling();
        return;
    L49:
        return;
    L9:
        Exception e = e;
    L28:
        MLog.e(TAG, "get settings config error ", e);     // Catch: Throwable -> L7
        if (r4 == null) goto L32;
    L7:
        th = th;
        r2 = "updateConfigByProvider";
    L35:
        if (r2 == 0) goto L37;
        r2.close();
    L37:
        throw th;
    L26:
        e = move-exception;
        e = e;
        r4 = null;
    L24:
        th = th;
        goto L35
    }

    @Nullable
    public final SdkAllConfig getSdkAllConfig() {
        SdkAllConfig r0 = sdkAllConfig;
        if (r0 == null) goto L5;
        return r0;
    L5:
        updateConfigByProvider();
        return sdkAllConfig;
    }
}
