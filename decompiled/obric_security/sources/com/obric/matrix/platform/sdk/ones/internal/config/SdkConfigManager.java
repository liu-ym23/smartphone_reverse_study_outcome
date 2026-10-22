package com.obric.matrix.platform.sdk.ones.internal.config;

import android.app.KeyguardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.room.util.CursorUtil;
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

/* JADX INFO: compiled from: SdkConfigManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/config/SdkConfigManager;", "", "()V", "ALL_CONFIG_STR", "", "AUTHORITY", "DEFAULT_POLLING_INTERVAL", "", "GET_SETTINGS_CONFIG", "GET_SETTINGS_CONFIG_URI", "SDK_ALL_CONFIG", "TAG", "isStartPolling", "", "keyguardManager", "Landroid/app/KeyguardManager;", "getKeyguardManager", "()Landroid/app/KeyguardManager;", "keyguardManager$delegate", "Lkotlin/Lazy;", "pollingConfigDisposable", "Lio/reactivex/disposables/Disposable;", "sdkAllConfig", "Lcom/obric/matrix/proto/SdkAllConfig;", "getSdkAllConfig", "startPolling", "", "updateConfigByProvider", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SdkConfigManager {
    private static final String ALL_CONFIG_STR = "all_config_str";
    private static final String AUTHORITY = "com.obric.matrix.sdk.settings.provider";
    private static final int DEFAULT_POLLING_INTERVAL = 30;
    private static final String GET_SETTINGS_CONFIG = "get_settings_config";
    private static final String GET_SETTINGS_CONFIG_URI = "content://com.obric.matrix.sdk.settings.provider/get_settings_config";
    public static final SdkConfigManager INSTANCE = null;
    private static final String SDK_ALL_CONFIG = "sdk_all_config";
    private static final String TAG = "SdkConfigManager";
    private static boolean isStartPolling;
    private static final Lazy keyguardManager$delegate = null;
    private static Disposable pollingConfigDisposable;
    private static SdkAllConfig sdkAllConfig;

    public static /* synthetic */ void $r8$lambda$5SfjlSeocKhpvhXqvxqgWaiUlOk(Long r0) {
        m167startPolling$lambda1(r0);
    }

    private SdkConfigManager() {
    }

    static {
        INSTANCE = new SdkConfigManager();
        keyguardManager$delegate = LazyKt.lazy(SdkConfigManager$keyguardManager$2.INSTANCE);
    }

    private final KeyguardManager getKeyguardManager() {
        return (KeyguardManager) keyguardManager$delegate.getValue();
    }

    public final SdkAllConfig getSdkAllConfig() {
        SdkAllConfig r0 = sdkAllConfig;
        if (r0 == null) goto L5;
        return r0;
    L5:
        updateConfigByProvider();
        return sdkAllConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateConfigByProvider() {
        CursorUtil.AnonymousClass2 r2 = 0;
        MLog.d$default(TAG, "updateConfigByProvider", null, 4, null);
        Context r1 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();     // Catch: Throwable -> L22 Exception -> L24
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L22 Exception -> L24
        ContentResolver r3 = r1.getContentResolver();     // Catch: Throwable -> L22 Exception -> L24
        MLog.d$default(TAG, "Uri content://com.obric.matrix.sdk.settings.provider/get_settings_config", null, 4, null);     // Catch: Throwable -> L22 Exception -> L24
        Cursor r4 = r3.query(Uri.parse(GET_SETTINGS_CONFIG_URI), null, null, null);     // Catch: Throwable -> L22 Exception -> L24
        if (r4 != null) goto L8;
        MLog.d$default(TAG, "get sdk config items is null", null, 4, null);     // Catch: Exception -> L20 Throwable -> L33
        return;
    L8:
        if (r4.moveToNext() == false) goto L19;
        int r5 = r4.getColumnIndex(ALL_CONFIG_STR);     // Catch: Exception -> L20 Throwable -> L33
        if (r5 < 0) goto L12;
        MLog.d$default(TAG, "get all config str = " + r4.getString(r5), null, 4, null);     // Catch: Exception -> L20 Throwable -> L33
    L12:
        int r6 = r4.getColumnIndex(SDK_ALL_CONFIG);     // Catch: Exception -> L20 Throwable -> L33
        if (r6 < 0) goto L8;
        byte[] r7 = r4.getBlob(r6);     // Catch: Exception -> L20 Throwable -> L33
        if (r7 != null) goto L16;
        MLog.d$default(TAG, "SdkAllConfigBytes == null ", null, 4, null);     // Catch: Exception -> L20 Throwable -> L33
        goto L8
    L16:
        MLog.d$default(TAG, "SdkAllConfigBytes != null ", null, 4, null);     // Catch: Exception -> L20 Throwable -> L33
        sdkAllConfig = SdkAllConfig.ADAPTER.decode(r7);     // Catch: Exception -> L20 Throwable -> L33
        MLog.d$default(TAG, "sdk all config: " + sdkAllConfig, null, 4, null);     // Catch: Exception -> L20 Throwable -> L33
    L19:
        r4.close();
    L30:
        if (isStartPolling == true) goto L49;
        isStartPolling = true;
        startPolling();
        return;
    L49:
        return;
    L20:
        Exception e = e;
    L26:
        MLog.e(TAG, "get settings config error ", e);     // Catch: Throwable -> L33
        if (r4 == null) goto L30;
    L33:
        th = th;
        r2 = "updateConfigByProvider";
    L35:
        if (r2 == 0) goto L37;
        r2.close();
    L37:
        throw th;
    L24:
        e = move-exception;
        e = e;
        r4 = null;
    L22:
        th = th;
        goto L35
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
        long r0 = r1;
        pollingConfigDisposable = Observable.interval(r0, r0, TimeUnit.MINUTES).subscribeOn(Schedulers.io()).subscribe(new SdkConfigManager$$ExternalSyntheticLambda0());
        return;
    L13:
        if (r7.intValue() <= 0) goto L15;
        r1 = r7.intValue();
    L10:
        r7 = null;
        goto L11
    }

    /* JADX INFO: renamed from: startPolling$lambda-1, reason: not valid java name */
    private static final void m167startPolling$lambda1(Long r4) {
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
        r6 = Unit.INSTANCE;
        goto L10
    L7:
        MLog.d$default(TAG, "设备处于锁屏状态，跳过本次配置更新", null, 4, null);
        goto L8
    }
}
