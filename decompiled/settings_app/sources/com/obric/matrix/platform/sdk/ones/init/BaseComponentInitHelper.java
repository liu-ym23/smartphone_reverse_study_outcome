package com.obric.matrix.platform.sdk.ones.init;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.obric.matrix.platform.sdk.ones.account.log.OLog;
import com.obric.matrix.platform.sdk.ones.dataanalysis.DeviceInfoListener;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaConfig;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.matrix.sdk.network.NetworkConfig;
import com.obric.matrix.sdk.network.NetworkSDKInit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseComponentInitHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\"\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0003J\"\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0003J\u000e\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentInitHelper;", "", "()V", "TAG", "", "isInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "packageInfo", "Landroid/content/pm/PackageInfo;", "init", "", "context", "Landroid/content/Context;", "baseComponentConfig", "Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentConfig;", "initInterval", "deviceId", "initNetwork", "isValidDeviceIdOrInstallId", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BaseComponentInitHelper {
    public static final BaseComponentInitHelper INSTANCE = null;
    private static final String TAG = "BaseComponentInitHelper";
    private static final AtomicBoolean isInited = null;
    private static PackageInfo packageInfo;

    private BaseComponentInitHelper() {
    }

    public static final /* synthetic */ void access$initInterval(Context r0, String r1, BaseComponentConfig r2) {
        initInterval(r0, r1, r2);
    }

    public static final /* synthetic */ boolean access$isValidDeviceIdOrInstallId(BaseComponentInitHelper r0, String r1) {
        return r0.isValidDeviceIdOrInstallId(r1);
    }

    static {
        INSTANCE = new BaseComponentInitHelper();
        isInited = new AtomicBoolean(false);
    }

    @JvmStatic
    public static final void init(final Context r5, final BaseComponentConfig r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "baseComponentConfig");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.m1508constructorimpl(r5.getPackageManager().getPackageInfo(r5.getPackageName(), 128));     // Catch: Throwable -> L5
    L8:
        if (Result.m1511exceptionOrNullimpl(r1) == null) goto L11;
        r1 = new PackageInfo();
    L11:
        packageInfo = (PackageInfo) r1;
        DeviceInfoListener r2 = new BaseComponentInitHelper$init$deviceInfoListener$1(r5, r6);
        if (MatrixTeaManager.Companion.isInited() == true) goto L24;
        MatrixTeaManager.Companion r3 = MatrixTeaManager.Companion;
        MatrixTeaConfig.Builder r7 = new MatrixTeaConfig.Builder().setIsBoe(r6.isBoe());
        PackageInfo r4 = packageInfo;
        PackageInfo r8 = null;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("packageInfo");
        r4 = null;
    L16:
        MatrixTeaConfig.Builder r9 = r7.setVersionCode(r4.versionCode);
        PackageInfo r10 = packageInfo;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("packageInfo");
    L20:
        String r11 = r8.versionName;
        if (r11 != null) goto L23;
        r11 = "";
    L23:
        MatrixTeaConfig.Builder r12 = r9.setVersionName(r11);
        String r13 = r5.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r13, "context.packageName");
        r3.init(r5, r12.setPackageName(r13).build());
        goto L24
    L19:
        r8 = r10;
    L24:
        MatrixTeaManager.Companion.getInstance().addDeviceInfoListener(r2);
        return;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r1 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final boolean isValidDeviceIdOrInstallId(String r3) {
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
        if (r2.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    @JvmStatic
    private static final void initInterval(Context r3, String r4, BaseComponentConfig r5) {
        if (isInited.compareAndSet(false, true) == true) goto L6;
        OLog.i(TAG, "is inited");
        return;
    L6:
        INSTANCE.initNetwork(r3, r4, r5);
        InitHelper r6 = InitHelper.INSTANCE;
        Context r7 = r3.getApplicationContext();
        if (r7 == null) goto L11;
        r6.initSettingsAndCrashProtect((Application) r7, r5.isBoe());
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }

    private final void initNetwork(Context r8, String r9, BaseComponentConfig r10) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        BaseComponentInitHelper r7 = this;     // Catch: Throwable -> L4
        ApplicationInfo r11 = r8.getPackageManager().getApplicationInfo(r8.getPackageName(), PackageManager.ApplicationInfoFlags.of(128));     // Catch: Throwable -> L4
        Intrinsics.checkNotNullExpressionValue(r11, "context.packageManager.g….GET_META_DATA.toLong()))");     // Catch: Throwable -> L4
        Object r12 = Result.m1508constructorimpl(r8.getString(r11.labelRes));     // Catch: Throwable -> L4
    L7:
        if (Result.m1511exceptionOrNullimpl(r12) == null) goto L10;
        r12 = r10.getAppName();     // Catch: PackageManager.NameNotFoundException -> L30
    L10:
        Intrinsics.checkNotNullExpressionValue(r12, "runCatching {\n          …ComponentConfig.appName }");     // Catch: PackageManager.NameNotFoundException -> L30
        String r13 = (String) r12;     // Catch: PackageManager.NameNotFoundException -> L30
        NetworkConfig.Builder r1 = new NetworkConfig.Builder().setAppId(r10.getAppId());     // Catch: PackageManager.NameNotFoundException -> L30
        PackageInfo r2 = packageInfo;     // Catch: PackageManager.NameNotFoundException -> L30
        PackageInfo r3 = null;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("packageInfo");     // Catch: PackageManager.NameNotFoundException -> L30
        r2 = null;
    L14:
        NetworkConfig.Builder r4 = r1.setVersionCode(r2.versionCode);     // Catch: PackageManager.NameNotFoundException -> L30
        PackageInfo r5 = packageInfo;     // Catch: PackageManager.NameNotFoundException -> L30
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("packageInfo");     // Catch: PackageManager.NameNotFoundException -> L30
    L18:
        String r6 = r3.versionName;     // Catch: PackageManager.NameNotFoundException -> L30
        if (r6 != null) goto L22;
        r6 = "";
    L22:
        NetworkConfig.Builder r14 = r4.setVersionName(r6).setAppName(r13);     // Catch: PackageManager.NameNotFoundException -> L30
        if (r9 != null) goto L25;
        r9 = "";
    L25:
        NetworkConfig r15 = r14.setDid(r9).build();     // Catch: PackageManager.NameNotFoundException -> L30
        NetworkSDKInit r16 = NetworkSDKInit.INSTANCE;     // Catch: PackageManager.NameNotFoundException -> L30
        Context r17 = r8.getApplicationContext();     // Catch: PackageManager.NameNotFoundException -> L30
        if (r17 == null) goto L29;
        r16.init(r8, (Application) r17, r10.getBaseUrl(), r15, null, new AnonymousClass1());     // Catch: PackageManager.NameNotFoundException -> L30
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");     // Catch: PackageManager.NameNotFoundException -> L30
    L17:
        r3 = r5;
    L30:
        e = move-exception;
        Log.e(TAG, "initNetwork error " + e.getMessage());
        return;
    L4:
        th = move-exception;
        Result.Companion r18 = Result.Companion;     // Catch: PackageManager.NameNotFoundException -> L30
        r12 = Result.m1508constructorimpl(ResultKt.createFailure(th));     // Catch: PackageManager.NameNotFoundException -> L30
        goto L7
    }
}
