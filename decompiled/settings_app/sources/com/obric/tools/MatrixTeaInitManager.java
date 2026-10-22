package com.obric.tools;

import android.content.Context;
import com.bytedance.os.oms.deviceinfo.DeviceInfoManager;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaConfig;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.matrix.platform.sdk.ones.init.BaseComponentConfig;
import com.obric.matrix.platform.sdk.ones.init.BaseComponentInitHelper;
import com.obric.olog.OLog;
import com.obric.oui.common.util.ToolsExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MatrixTeaInitManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/tools/MatrixTeaInitManager;", "", "()V", "CONFIG_USE_OMS_DEVICE_ID", "", "PACKAGE_NAME", "TAG", "USE_OMS_DEVICE_INFO", "", "deviceId", "deviceInfoListener", "Lcom/bytedance/os/oms/deviceinfo/DeviceInfoManager$DeviceInfoListener;", "deviceInfoManager", "Lcom/bytedance/os/oms/deviceinfo/DeviceInfoManager;", "getDeviceId", "init", "", "context", "Landroid/content/Context;", "initMatrixTeaDeviceInfo", "initOmsDeviceInfo", "isValidDeviceId", "value", "tryUpdateDeviceId", "newDid", "useOmsDeviceInfo", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MatrixTeaInitManager {
    private static final String CONFIG_USE_OMS_DEVICE_ID = "use_oms_device_id";
    public static final MatrixTeaInitManager INSTANCE = null;
    private static final String PACKAGE_NAME = "com.android.settings";
    private static final String TAG = "MatrixTeaInitManager";
    private static final boolean USE_OMS_DEVICE_INFO = true;
    private static String deviceId;
    private static DeviceInfoManager.DeviceInfoListener deviceInfoListener;
    private static DeviceInfoManager deviceInfoManager;

    static {
        INSTANCE = new MatrixTeaInitManager();
    }

    private MatrixTeaInitManager() {
    }

    public static final /* synthetic */ String access$getDeviceId$p() {
        return deviceId;
    }

    public static final /* synthetic */ boolean access$isValidDeviceId(MatrixTeaInitManager r0, String r1) {
        return r0.isValidDeviceId(r1);
    }

    public static final /* synthetic */ void access$setDeviceId$p(String r0) {
        deviceId = r0;
    }

    public static final /* synthetic */ void access$tryUpdateDeviceId(MatrixTeaInitManager r0, String r1) {
        r0.tryUpdateDeviceId(r1);
    }

    private final boolean useOmsDeviceInfo() {
        boolean r2 = MatrixSettingsInitManager.INSTANCE.getBooleanConfig(CONFIG_USE_OMS_DEVICE_ID, true);
        OLog.i(TAG, "useOmsDeviceInfo: " + r2);
        return r2;
    }

    public final String getDeviceId() {
    L17:
        e = move-exception;
        OLog.e(TAG, "getDeviceId from OMS error", e);
    L20:
        return deviceId;
    L4:
        if (isValidDeviceId(deviceId) == true) goto L20;
        if (useOmsDeviceInfo() == true) goto L9;
        deviceId = MatrixTeaManager.Companion.getInstance().getDeviceId();     // Catch: Exception -> L17
        OLog.i(TAG, "getDeviceId from MatrixTea: " + deviceId);     // Catch: Exception -> L17
        return deviceId;
    L9:
        DeviceInfoManager r1 = deviceInfoManager;     // Catch: Exception -> L17
        if (r1 != null) goto L13;
        OLog.w(TAG, "getDeviceId skipped, DeviceInfoManager unavailable");     // Catch: Exception -> L17
        return deviceId;
    L13:
        String r2 = r1.getDeviceId();     // Catch: Exception -> L17
        OLog.i(TAG, "getDeviceId from OMS: " + r2);     // Catch: Exception -> L17
        if (isValidDeviceId(r2) == false) goto L20;
        deviceId = r2;     // Catch: Exception -> L17
        goto L20
    }

    private final void tryUpdateDeviceId(final String r1) {
        ToolsExtKt.runInUIThread(new C03241(r1));
    }

    public final void init(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        OLog.i(TAG, "OLog init");
        OLog.i(TAG, "init");
        MatrixTeaConfig r0 = new MatrixTeaConfig.Builder().setPackageName("com.android.settings").setVersionCode(10000).setIsBoe(true).setVersionName("1.0.0").build();
        MatrixTeaManager.Companion.init(r4, r0);
        if (useOmsDeviceInfo() == false) goto L5;
        initOmsDeviceInfo(r4);
    L6:
        BaseComponentInitHelper.init(r4, new BaseComponentConfig.Builder().setIsBoe(false).setAppId(3740).build());
        OLog.i(TAG, "init2");
        OLog.i(TAG, "OLog init2");
        return;
    L5:
        initMatrixTeaDeviceInfo();
        goto L6
    }

    private final void initOmsDeviceInfo(Context r5) {
        DeviceInfoManager r6 = DeviceInfoManager.get(r5);
        if (r6 != null) goto L6;
        OLog.w(TAG, "initDeviceInfo skipped, DeviceInfoManager unavailable");
        return;
    L6:
        deviceInfoManager = r6;
        String r1 = r6.getDeviceId();
        OLog.i(TAG, "initDeviceInfo getDeviceId from OMS: " + r1);
        if (isValidDeviceId(r1) == false) goto L10;
        tryUpdateDeviceId(r1);
        return;
    L10:
        DeviceInfoManager.DeviceInfoListener r4 = new MatrixTeaInitManager$initOmsDeviceInfo$listener$1();
        deviceInfoListener = r4;
        r6.registerDeviceInfoListener(r4);
    }

    private final void initMatrixTeaDeviceInfo() {
        MatrixTeaManager.Companion.getInstance().addDeviceInfoListener(new AnonymousClass1());
    }

    private final boolean isValidDeviceId(String r3) {
        String r2 = r3;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r3, "0") == false) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r3, "-1") == false) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r4 = false;
        goto L9
    }
}
