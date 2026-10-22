package com.obric.matrix.platform.sdk.ones.init;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.RequiresApi;
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
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class BaseComponentInitHelper {

    @NotNull
    public static final BaseComponentInitHelper INSTANCE = null;

    @NotNull
    private static final String TAG = "BaseComponentInitHelper";

    @NotNull
    private static final AtomicBoolean isInited = null;
    private static PackageInfo packageInfo;

    static {
        INSTANCE = new BaseComponentInitHelper();
        isInited = new AtomicBoolean(false);
    }

    private BaseComponentInitHelper() {
    }

    public static final /* synthetic */ void access$initInterval(Context r0, String r1, BaseComponentConfig r2) {
        initInterval(r0, r1, r2);
    }

    public static final /* synthetic */ boolean access$isValidDeviceIdOrInstallId(BaseComponentInitHelper r0, String r1) {
        return r0.isValidDeviceIdOrInstallId(r1);
    }

    @JvmStatic
    public static final void init(@NotNull final Context r5, @NotNull final BaseComponentConfig r6) {
        Intrinsics.f(r5, "context");
        Intrinsics.f(r6, "baseComponentConfig");
        Object r0 = r5.getPackageManager().getPackageInfo(r5.getPackageName(), 128);     // Catch: Throwable -> L5
    L8:
        if (Result.a(r0) == null) goto L11;
        r0 = new PackageInfo();
    L11:
        packageInfo = (PackageInfo) r0;
        DeviceInfoListener r1 = new BaseComponentInitHelper$init$deviceInfoListener$1(r5, r6);
        MatrixTeaManager.Companion r2 = MatrixTeaManager.Companion;
        if (r2.isInited() == true) goto L25;
        MatrixTeaConfig.Builder r7 = new MatrixTeaConfig.Builder().setIsBoe(r6.isBoe());
        PackageInfo r3 = packageInfo;
        if (r3 == null) goto L23;
        MatrixTeaConfig.Builder r8 = r7.setVersionCode(r3.versionCode);
        PackageInfo r4 = packageInfo;
        if (r4 == null) goto L21;
        String r9 = r4.versionName;
        if (r9 != null) goto L20;
        r9 = "";
    L20:
        MatrixTeaConfig.Builder r10 = r8.setVersionName(r9);
        String r11 = r5.getPackageName();
        Intrinsics.e(r11, "context.packageName");
        r2.init(r5, r10.setPackageName(r11).build());
        goto L25
    L21:
        Intrinsics.m("packageInfo");
        throw null;
    L23:
        Intrinsics.m("packageInfo");
        throw null;
    L25:
        r2.getInstance().addDeviceInfoListener(r1);
        return;
    L5:
        th = move-exception;
        r0 = ResultKt.a(th);
        goto L8
    }

    @JvmStatic
    @RequiresApi(33)
    private static final void initInterval(Context r3, String r4, BaseComponentConfig r5) {
        if (isInited.compareAndSet(false, true) == true) goto L7;
        OLog.i(TAG, "is inited");
        return;
    L7:
        if (r5.getUseTTNet() == false) goto L9;
        INSTANCE.initNetwork(r3, r4, r5);
    L9:
        InitHelper r6 = InitHelper.INSTANCE;
        Context r7 = r3.getApplicationContext();
        if (r7 == null) goto L14;
        r6.initSettingsAndCrashProtect((Application) r7, r5.isBoe());
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }

    @RequiresApi(33)
    private final void initNetwork(Context r8, String r9, BaseComponentConfig r10) {
        ApplicationInfo r7 = r8.getPackageManager().getApplicationInfo(r8.getPackageName(), PackageManager.ApplicationInfoFlags.of(128));     // Catch: Throwable -> L4
        Intrinsics.e(r7, "context.packageManager.g….GET_META_DATA.toLong()))");     // Catch: Throwable -> L4
        Object r11 = r8.getString(r7.labelRes);     // Catch: Throwable -> L4
    L7:
        if (Result.a(r11) == null) goto L10;
        r11 = r10.getAppName();     // Catch: PackageManager.NameNotFoundException -> L25
    L10:
        Intrinsics.e(r11, "runCatching {\n          …ComponentConfig.appName }");     // Catch: PackageManager.NameNotFoundException -> L25
        String r12 = (String) r11;     // Catch: PackageManager.NameNotFoundException -> L25
        NetworkConfig.Builder r0 = new NetworkConfig.Builder().setAppId(r10.getAppId());     // Catch: PackageManager.NameNotFoundException -> L25
        PackageInfo r1 = packageInfo;     // Catch: PackageManager.NameNotFoundException -> L25
        if (r1 == null) goto L31;
        NetworkConfig.Builder r2 = r0.setVersionCode(r1.versionCode);     // Catch: PackageManager.NameNotFoundException -> L25
        PackageInfo r3 = packageInfo;     // Catch: PackageManager.NameNotFoundException -> L25
        if (r3 == null) goto L29;
        String r4 = r3.versionName;     // Catch: PackageManager.NameNotFoundException -> L25
        if (r4 != null) goto L19;
        r4 = "";
    L19:
        NetworkConfig.Builder r13 = r2.setVersionName(r4).setAppName(r12);     // Catch: PackageManager.NameNotFoundException -> L25
        if (r9 != null) goto L22;
        r9 = "";
    L22:
        NetworkConfig r5 = r13.setDid(r9).setNeedSetCookieHandler(r10.getNeedSetCookieHandler()).setApiProcessHook(r10.getApiProcessHook()).build();     // Catch: PackageManager.NameNotFoundException -> L25
        NetworkSDKInit r6 = NetworkSDKInit.INSTANCE;     // Catch: PackageManager.NameNotFoundException -> L25
        Context r14 = r8.getApplicationContext();     // Catch: PackageManager.NameNotFoundException -> L25
        if (r14 == null) goto L28;
        r6.init(r8, (Application) r14, r10.getBaseUrl(), r5, null, new AnonymousClass1());     // Catch: PackageManager.NameNotFoundException -> L25
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");     // Catch: PackageManager.NameNotFoundException -> L25
    L29:
        Intrinsics.m("packageInfo");     // Catch: PackageManager.NameNotFoundException -> L25
        throw null;     // Catch: PackageManager.NameNotFoundException -> L25
    L31:
        Intrinsics.m("packageInfo");     // Catch: PackageManager.NameNotFoundException -> L25
        throw null;     // Catch: PackageManager.NameNotFoundException -> L25
    L25:
        e = move-exception;
        Log.e(TAG, "initNetwork error " + e.getMessage());
        return;
    L4:
        th = move-exception;
        r11 = ResultKt.a(th);     // Catch: PackageManager.NameNotFoundException -> L25
        goto L7
    }

    private final boolean isValidDeviceIdOrInstallId(String r1) {
        if (r1 != null) goto L4;
    L11:
        return false;
    L4:
        if (r1.length() == 0) goto L11;
        if (Intrinsics.a(r1, "0") == true) goto L11;
        if (Intrinsics.a(r1, "-1") == true) goto L11;
        return true;
    }
}
