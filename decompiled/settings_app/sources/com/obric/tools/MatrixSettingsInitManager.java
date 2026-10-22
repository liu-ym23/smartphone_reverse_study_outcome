package com.obric.tools;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.PowerManager;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.android.settings.utils.ThreadUtils;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsConfig;
import com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsManager;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: MatrixSettingsInitManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\fJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\n\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/tools/MatrixSettingsInitManager;", "", "()V", "PACKAGE_NAME", "", "TAG", "cachedSettingsJson", "cachedSettingsObject", "Lorg/json/JSONObject;", "configLock", "deviceId", "getBooleanConfig", "", "configName", "defaultValue", "getDeviceId", "getSettingsObject", "handlePushPermissionConfig", "", "context", "Landroid/content/Context;", "init", "parseSettingsJson", "settingsJson", "readAllSettings", "releaseQuietly", DeviceInfoProvider.CLIENT, "Landroid/content/ContentProviderClient;", "updateSettingsCache", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MatrixSettingsInitManager {
    public static final MatrixSettingsInitManager INSTANCE = null;
    private static final String PACKAGE_NAME = "com.android.settings";
    private static final String TAG = "MatrixTeaInitManager";
    private static String cachedSettingsJson;
    private static JSONObject cachedSettingsObject;
    private static final Object configLock = null;
    private static String deviceId;

    public static /* synthetic */ void $r8$lambda$rKuGHSO2LGeuHvZ5d_XMtewF2P8(Context r0, Uri r1) {
        handlePushPermissionConfig$lambda$8(r0, r1);
    }

    private MatrixSettingsInitManager() {
    }

    public static final /* synthetic */ void access$handlePushPermissionConfig(MatrixSettingsInitManager r0, Context r1) {
        r0.handlePushPermissionConfig(r1);
    }

    public static final /* synthetic */ String access$readAllSettings(MatrixSettingsInitManager r0) {
        return r0.readAllSettings();
    }

    public static final /* synthetic */ JSONObject access$updateSettingsCache(MatrixSettingsInitManager r0, String r1) {
        return r0.updateSettingsCache(r1);
    }

    static {
        INSTANCE = new MatrixSettingsInitManager();
        configLock = new Object();
    }

    public final String getDeviceId() {
        return deviceId;
    }

    public final boolean getBooleanConfig(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "configName");
        if (StringsKt.isBlank(r2) == false) goto L5;
        return r3;
    L5:
        JSONObject r1 = getSettingsObject();
        if (r1 != null) goto L8;
        return r3;
    L8:
        return r1.optBoolean(r2, r3);
    }

    public final void init(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        OLog.i(TAG, "init");
        MatrixSettingsConfig r2 = new MatrixSettingsConfig.Builder().setPackageName("com.android.settings").setVersionCode(10000).setIsBoe(true).setReceiverName("com.obric.tools.SettingsUpdateReceiver").setVersionName("1.0.0").build();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        MatrixSettingsManager.Companion.init(r3, r2);     // Catch: Throwable -> L5
        Object r4 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.m1511exceptionOrNullimpl(r4);
        if (r5 == null) goto L10;
        OLog.e(TAG, "MatrixSettingsManager init fail", r5);
    L10:
        MatrixSettingsInitManager$init$settingsUpdateListener$1 r6 = new MatrixSettingsInitManager$init$settingsUpdateListener$1(r3);
        MatrixSettingsManager.Companion.getInstance().addSettingsUpdateListener(r6);
        OLog.i(TAG, "init2");
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final JSONObject getSettingsObject() {
        String r0 = readAllSettings();
        Object r1 = configLock;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(r0, cachedSettingsJson) == false) goto L9;
        JSONObject r3 = cachedSettingsObject;     // Catch: Throwable -> L13
        monitor-exit(r1);
        return r3;
    L9:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r1);
        return updateSettingsCache(r0);
    }

    private final JSONObject updateSettingsCache(String r2) {
        Object r1 = configLock;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(r2, cachedSettingsJson) == false) goto L9;
        JSONObject r3 = cachedSettingsObject;     // Catch: Throwable -> L12
        monitor-exit(r1);
        return r3;
    L9:
        MatrixSettingsInitManager r0 = INSTANCE;     // Catch: Throwable -> L12
        cachedSettingsJson = r2;     // Catch: Throwable -> L12
        JSONObject r4 = r0.parseSettingsJson(r2);     // Catch: Throwable -> L12
        cachedSettingsObject = r4;     // Catch: Throwable -> L12
        monitor-exit(r1);
        return r4;
    }

    private final String readAllSettings() {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L4
        Object r4 = Result.m1508constructorimpl(MatrixSettingsManager.Companion.getInstance().getAllSettings());     // Catch: Throwable -> L4
    L6:
        Throwable r0 = Result.m1511exceptionOrNullimpl(r4);
        if (r0 == null) goto L10;
        OLog.e(TAG, "readAllSettings failed", r0);
    L10:
        if (Result.m1514isFailureimpl(r4) == false) goto L13;
        r4 = null;
    L13:
        return (String) r4;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final JSONObject parseSettingsJson(String r4) {
        String r3 = r4;
        if (r3 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        Object r0 = null;
        if (r5 == false) goto L25;
        return null;
    L25:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L14
        Object r7 = Result.m1508constructorimpl(new JSONObject(r4));     // Catch: Throwable -> L14
    L16:
        Throwable r8 = Result.m1511exceptionOrNullimpl(r7);
        if (r8 == null) goto L20;
        OLog.e(TAG, "parse settings json failed", r8);
    L20:
        if (Result.m1514isFailureimpl(r7) == true) goto L24;
        r0 = r7;
    L24:
        return (JSONObject) r0;
    L14:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L16
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r5 = false;
        goto L9
    }

    private final void handlePushPermissionConfig(final Context r2) {
        Object r1 = r2.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.os.PowerManager");
        if (((PowerManager) r1).isInteractive() == true) goto L5;
        return;
    L5:
        OLog.i(TAG, "aiLab call check_permission");
        final Uri r3 = Uri.parse("content://com.obric.memorydata.memory.ailabprovider");
        ThreadUtils.postOnBackgroundThread(new MatrixSettingsInitManager$$ExternalSyntheticLambda0(r2, r3));
    }

    private static final void handlePushPermissionConfig$lambda$8(Context r3, Uri r4) {
        Intrinsics.checkNotNullParameter(r3, "$context");
        ContentProviderClient r2 = null;
        ContentProviderClient r5 = r3.getContentResolver().acquireUnstableContentProviderClient(r4);     // Catch: Throwable -> L14 Exception -> L16
        if (r5 != null) goto L8;
        OLog.i(TAG, "aiLab provider client null");     // Catch: Throwable -> L10 Exception -> L12
        INSTANCE.releaseQuietly(r5);
        return;
    L8:
        r5.call("check_permission", null, null);     // Catch: Throwable -> L10 Exception -> L12
        INSTANCE.releaseQuietly(r5);
    L22:
        return;
    L12:
        e = e;
        r2 = r5;
    L17:
        OLog.e(TAG, "解析推送权限配置失败: " + e.getMessage());     // Catch: Throwable -> L14
        INSTANCE.releaseQuietly(r2);
    L10:
        th = th;
        r2 = r5;
    L20:
        INSTANCE.releaseQuietly(r2);
        throw th;
    L14:
        th = th;
    L16:
        e = e;
        goto L17
    }

    private final void releaseQuietly(ContentProviderClient r1) {
        if (r1 != null) goto L7;
        return;
    L7:
        r1.close();     // Catch: Throwable -> L6
        return;
    }
}
