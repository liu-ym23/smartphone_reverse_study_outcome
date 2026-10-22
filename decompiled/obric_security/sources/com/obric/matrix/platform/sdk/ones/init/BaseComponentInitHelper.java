package com.obric.matrix.platform.sdk.ones.init;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.UserManager;
import android.util.Log;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.matrix.platform.sdk.ones.account.log.OLog;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaConfig;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.sdk.network.NetworkConfig;
import com.obric.matrix.sdk.network.NetworkSDKInit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import obric.util.Utils;

/* JADX INFO: compiled from: BaseComponentInitHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001%B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J \u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0003J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\"\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0003J*\u0010 \u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0004H\u0003J(\u0010\"\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0004H\u0003J\b\u0010#\u001a\u00020\u001eH\u0007J\u000e\u0010$\u001a\u00020\u0016*\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentInitHelper;", "", "()V", "TAG", "", "initExecutor", "Ljava/util/concurrent/ExecutorService;", "getInitExecutor", "()Ljava/util/concurrent/ExecutorService;", "initExecutor$delegate", "Lkotlin/Lazy;", "isInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "packageInfo", "Landroid/content/pm/PackageInfo;", "pendingNetworkInit", "Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentInitHelper$PendingNetworkInit;", "pendingNetworkLock", "privacyAgreed", "privacyAgreementNotified", "unlockReceiverRegistered", "deferNetworkUntilPrivacyAgreed", "", "context", "Landroid/content/Context;", "deviceId", "baseComponentConfig", "Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentConfig;", "deferNetworkUntilUserUnlocked", "init", "", "initInterval", "initNetwork", DBHelper.BATTERY_COL_SOURCE, "initNetworkIfAllowed", "notifyPrivacyAgreed", "isValidDeviceIdOrInstallId", "PendingNetworkInit", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BaseComponentInitHelper {
    public static final BaseComponentInitHelper INSTANCE = null;
    private static final String TAG = "BaseComponentInitHelper";
    private static final Lazy initExecutor$delegate = null;
    private static final AtomicBoolean isInited = null;
    private static PackageInfo packageInfo;
    private static PendingNetworkInit pendingNetworkInit;
    private static final Object pendingNetworkLock = null;
    private static final AtomicBoolean privacyAgreed = null;
    private static final AtomicBoolean privacyAgreementNotified = null;
    private static final AtomicBoolean unlockReceiverRegistered = null;

    /* JADX INFO: compiled from: BaseComponentInitHelper.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentInitHelper$PendingNetworkInit;", "", "context", "Landroid/content/Context;", "deviceId", "", "baseComponentConfig", "Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentConfig;", "(Landroid/content/Context;Ljava/lang/String;Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentConfig;)V", "getBaseComponentConfig", "()Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentConfig;", "getContext", "()Landroid/content/Context;", Utils.METHOD_GET_DEVICE_ID, "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class PendingNetworkInit {
        private final BaseComponentConfig baseComponentConfig;
        private final Context context;
        private final String deviceId;

        public static /* synthetic */ PendingNetworkInit copy$default(PendingNetworkInit r0, Context r1, String r2, BaseComponentConfig r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.context;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.deviceId;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.baseComponentConfig;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final Context component1() {
            return this.context;
        }

        public final String component2() {
            return this.deviceId;
        }

        public final BaseComponentConfig component3() {
            return this.baseComponentConfig;
        }

        public final PendingNetworkInit copy(Context r1, String r2, BaseComponentConfig r3) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "deviceId");
            Intrinsics.checkNotNullParameter(r3, "baseComponentConfig");
            return new PendingNetworkInit(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PendingNetworkInit) == true) goto L8;
            return false;
        L8:
            PendingNetworkInit r6 = (PendingNetworkInit) r5;
            if (Intrinsics.areEqual(this.context, r6.context) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.deviceId, r6.deviceId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.baseComponentConfig, r6.baseComponentConfig) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.context.hashCode() * 31) + this.deviceId.hashCode()) * 31) + this.baseComponentConfig.hashCode();
        }

        public String toString() {
            return "PendingNetworkInit(context=" + this.context + ", deviceId=" + this.deviceId + ", baseComponentConfig=" + this.baseComponentConfig + ')';
        }

        public PendingNetworkInit(Context r2, String r3, BaseComponentConfig r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "deviceId");
            Intrinsics.checkNotNullParameter(r4, "baseComponentConfig");
            this.context = r2;
            this.deviceId = r3;
            this.baseComponentConfig = r4;
        }

        public final Context getContext() {
            return this.context;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final BaseComponentConfig getBaseComponentConfig() {
            return this.baseComponentConfig;
        }
    }

    public static /* synthetic */ void $r8$lambda$f92I6qRgRkl7tLUAVEUv0svOve0(PendingNetworkInit r0) {
        m162notifyPrivacyAgreed$lambda6(r0);
    }

    private BaseComponentInitHelper() {
    }

    public static final /* synthetic */ ExecutorService access$getInitExecutor(BaseComponentInitHelper r0) {
        return r0.getInitExecutor();
    }

    public static final /* synthetic */ AtomicBoolean access$getUnlockReceiverRegistered$p() {
        return unlockReceiverRegistered;
    }

    public static final /* synthetic */ void access$initInterval(Context r0, String r1, BaseComponentConfig r2) {
        initInterval(r0, r1, r2);
    }

    public static final /* synthetic */ void access$initNetwork(BaseComponentInitHelper r0, Context r1, String r2, BaseComponentConfig r3, String r4) {
        r0.initNetwork(r1, r2, r3, r4);
    }

    public static final /* synthetic */ boolean access$isValidDeviceIdOrInstallId(BaseComponentInitHelper r0, String r1) {
        return r0.isValidDeviceIdOrInstallId(r1);
    }

    static {
        INSTANCE = new BaseComponentInitHelper();
        isInited = new AtomicBoolean(false);
        unlockReceiverRegistered = new AtomicBoolean(false);
        privacyAgreed = new AtomicBoolean(true);
        privacyAgreementNotified = new AtomicBoolean(false);
        pendingNetworkLock = new Object();
        initExecutor$delegate = LazyKt.lazy(BaseComponentInitHelper$initExecutor$2.INSTANCE);
    }

    private final ExecutorService getInitExecutor() {
        Object r1 = initExecutor$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-initExecutor>(...)");
        return (ExecutorService) r1;
    }

    @JvmStatic
    public static final void init(Context r4, BaseComponentConfig r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "baseComponentConfig");
        Object r0 = pendingNetworkLock;
        monitor-enter(r0);
    L34:
        th = move-exception;
        throw th;
    L5:
        if (r5.getPrivacyAgreed() == false) goto L7;
    L9:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(r0);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        Object r3 = Result.m774constructorimpl(r4.getPackageManager().getPackageInfo(r4.getPackageName(), 128));     // Catch: Throwable -> L13
    L16:
        if (Result.m777exceptionOrNullimpl(r3) == null) goto L19;
        r3 = new PackageInfo();
    L19:
        packageInfo = (PackageInfo) r3;
        InitHelper.INSTANCE.prepareSettings(r4, r5.isBoe());
        BaseComponentInitHelper$init$deviceInfoListener$1 r6 = new BaseComponentInitHelper$init$deviceInfoListener$1(r4, r5);
        if (MatrixTeaManager.Companion.isInited() == true) goto L32;
        MatrixTeaManager.Companion r7 = MatrixTeaManager.Companion;
        MatrixTeaConfig.Builder r8 = new MatrixTeaConfig.Builder().setIsBoe(r5.isBoe());
        PackageInfo r9 = packageInfo;
        PackageInfo r10 = null;
        if (r9 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("packageInfo");
        r9 = null;
    L24:
        MatrixTeaConfig.Builder r11 = r8.setVersionCode(r9.versionCode);
        PackageInfo r12 = packageInfo;
        if (r12 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("packageInfo");
    L28:
        String r13 = r10.versionName;
        if (r13 != null) goto L31;
        r13 = "";
    L31:
        MatrixTeaConfig.Builder r14 = r11.setVersionName(r13);
        String r15 = r4.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r15, "context.packageName");
        r7.init(r4, r14.setPackageName(r15).build());
        goto L32
    L27:
        r10 = r12;
    L32:
        MatrixTeaManager.Companion.getInstance().addDeviceInfoListener(r6);
        return;
    L13:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r3 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L16
    L7:
        if (privacyAgreementNotified.get() == true) goto L9;
        privacyAgreed.set(false);     // Catch: Throwable -> L34
        goto L9
    }

    @JvmStatic
    public static final void notifyPrivacyAgreed() {
        Object r0 = pendingNetworkLock;
        monitor-enter(r0);
        privacyAgreementNotified.set(true);     // Catch: Throwable -> L11
        privacyAgreed.set(true);     // Catch: Throwable -> L11
        final PendingNetworkInit r1 = pendingNetworkInit;     // Catch: Throwable -> L11
        BaseComponentInitHelper r2 = INSTANCE;     // Catch: Throwable -> L11
        pendingNetworkInit = null;     // Catch: Throwable -> L11
        monitor-exit(r0);
        if (r1 != null) goto L9;
        OLog.i(TAG, "notifyPrivacyAgreed no pending network init");
        return;
    L9:
        OLog.i(TAG, "notifyPrivacyAgreed start pending network init");
        r2.getInitExecutor().execute(new BaseComponentInitHelper$$ExternalSyntheticLambda0(r1));
        return;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: notifyPrivacyAgreed$lambda-6, reason: not valid java name */
    private static final void m162notifyPrivacyAgreed$lambda6(PendingNetworkInit r5) {
        Intrinsics.checkNotNullParameter(r5, "$pending");
        if (Build.VERSION.SDK_INT >= 33) goto L6;
        return;
    L6:
        if (isInited.get() == true) goto L14;
        OLog.i(TAG, "pending network init skipped, base component not inited");
        return;
    L14:
        INSTANCE.initNetworkIfAllowed(r5.getContext(), r5.getDeviceId(), r5.getBaseComponentConfig(), "privacy_agreed");     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        MLog.e(TAG, "initNetwork after privacy agreed error", th);
    }

    private final boolean deferNetworkUntilUserUnlocked(Context r7, String r8, BaseComponentConfig r9) {
        UserManager r0 = (UserManager) r7.getSystemService(UserManager.class);
        if (r0 != null) goto L5;
    L38:
        StringBuilder r6 = new StringBuilder("network init not deferred, userUnlocked=");
        if (r0 == null) goto L41;
        Boolean r10 = Boolean.valueOf(r0.isUserUnlocked());
    L42:
        OLog.i(TAG, r6.append(r10).toString());
        return false;
    L41:
        r10 = null;
        goto L42
    L5:
        if (r0.isUserUnlocked() == true) goto L38;
        if (unlockReceiverRegistered.compareAndSet(false, true) == true) goto L11;
        OLog.i(TAG, "network init deferred, waiting for user unlock");
        return true;
    L11:
        Context r11 = r7.getApplicationContext();
        BaseComponentInitHelper$deferNetworkUntilUserUnlocked$receiver$1 r3 = new BaseComponentInitHelper$deferNetworkUntilUserUnlocked$receiver$1(r11, r8, r9);
        IntentFilter r12 = new IntentFilter("android.intent.action.USER_UNLOCKED");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L18
        BaseComponentInitHelper r14 = this;     // Catch: Throwable -> L18
        if (Build.VERSION.SDK_INT < 33) goto L15;
        Intent r15 = r11.registerReceiver(r3, r12, 4);     // Catch: Throwable -> L18
    L16:
        Object r16 = Result.m774constructorimpl(r15);     // Catch: Throwable -> L18
    L20:
        Throwable r17 = Result.m777exceptionOrNullimpl(r16);
        if (r17 == null) goto L28;
        unlockReceiverRegistered.set(false);
        MLog.e(TAG, "register user unlock receiver error", r17);
        if (r0.isUserUnlocked() == false) goto L26;
        OLog.i(TAG, "user unlocked after receiver registration failed, continue direct network init");
        return false;
    L26:
        isInited.set(false);
        return true;
    L28:
        OLog.i(TAG, "registered USER_UNLOCKED receiver for deferred network init");
        if (r0.isUserUnlocked() == true) goto L46;
        OLog.i(TAG, "network init deferred until user unlocked");
        return true;
    L46:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L32
        BaseComponentInitHelper r19 = this;     // Catch: Throwable -> L32
        r11.unregisterReceiver(r3);     // Catch: Throwable -> L32
        Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        unlockReceiverRegistered.set(false);
        OLog.i(TAG, "user unlocked after receiver registration, continue direct network init");
        return false;
    L32:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L34
    L15:
        r15 = r11.registerReceiver(r3, r12);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r16 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L20
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

    private final boolean deferNetworkUntilPrivacyAgreed(Context r3, String r4, BaseComponentConfig r5) {
        Object r2 = pendingNetworkLock;
        monitor-enter(r2);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (privacyAgreed.get() == false) goto L9;
        monitor-exit(r2);
        return false;
    L9:
        Context r6 = r3.getApplicationContext();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r6, "context.applicationContext");     // Catch: Throwable -> L13
        pendingNetworkInit = new PendingNetworkInit(r6, r4, r5);     // Catch: Throwable -> L13
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r2);
        OLog.i(TAG, "network init deferred until privacy agreed");
        return true;
    }

    private final void initNetworkIfAllowed(Context r2, String r3, BaseComponentConfig r4, String r5) {
        if (deferNetworkUntilPrivacyAgreed(r2, r3, r4) == false) goto L6;
        return;
    L6:
        if (deferNetworkUntilUserUnlocked(r2, r3, r4) == true) goto L9;
        initNetwork(r2, r3, r4, r5);
        return;
    }

    @JvmStatic
    private static final void initInterval(Context r3, String r4, BaseComponentConfig r5) {
        if (isInited.compareAndSet(false, true) == true) goto L7;
        OLog.i(TAG, "is inited");
        return;
    L7:
        if (r5.getUseTTNet() == false) goto L12;
        BaseComponentInitHelper r0 = INSTANCE;
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r0.initNetworkIfAllowed(r3, r4, r5, "direct");
    L12:
        InitHelper r6 = InitHelper.INSTANCE;
        Context r7 = r3.getApplicationContext();
        if (r7 == null) goto L17;
        r6.initSettingsAndCrashProtect((Application) r7, r5.isBoe(), r5.getCrashProtectConfig());
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }

    private final void initNetwork(Context r10, String r11, BaseComponentConfig r12, String r13) {
        UserManager r3 = (UserManager) r10.getSystemService(UserManager.class);     // Catch: PackageManager.NameNotFoundException -> L36
        PackageInfo r4 = null;
        if (r3 == null) goto L6;
        Boolean r5 = Boolean.valueOf(r3.isUserUnlocked());     // Catch: PackageManager.NameNotFoundException -> L36
    L7:
        OLog.i(TAG, "initNetwork start, source=" + r13 + ", userUnlocked=" + r5 + ", needSetCookieHandler=" + r12.getNeedSetCookieHandler() + ", useTTNet=" + r12.getUseTTNet());     // Catch: PackageManager.NameNotFoundException -> L36
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L10
        BaseComponentInitHelper r9 = this;     // Catch: Throwable -> L10
        ApplicationInfo r14 = r10.getPackageManager().getApplicationInfo(r10.getPackageName(), PackageManager.ApplicationInfoFlags.of(128));     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r14, "context.packageManager.g….GET_META_DATA.toLong()))");     // Catch: Throwable -> L10
        Object r15 = Result.m774constructorimpl(r10.getString(r14.labelRes));     // Catch: Throwable -> L10
    L13:
        if (Result.m777exceptionOrNullimpl(r15) == null) goto L16;
        r15 = r12.getAppName();     // Catch: PackageManager.NameNotFoundException -> L36
    L16:
        Intrinsics.checkNotNullExpressionValue(r15, "runCatching {\n          …ComponentConfig.appName }");     // Catch: PackageManager.NameNotFoundException -> L36
        String r16 = (String) r15;     // Catch: PackageManager.NameNotFoundException -> L36
        NetworkConfig.Builder r6 = new NetworkConfig.Builder().setAppId(r12.getAppId());     // Catch: PackageManager.NameNotFoundException -> L36
        PackageInfo r7 = packageInfo;     // Catch: PackageManager.NameNotFoundException -> L36
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("packageInfo");     // Catch: PackageManager.NameNotFoundException -> L36
        r7 = null;
    L20:
        NetworkConfig.Builder r8 = r6.setVersionCode(r7.versionCode);     // Catch: PackageManager.NameNotFoundException -> L36
        PackageInfo r17 = packageInfo;     // Catch: PackageManager.NameNotFoundException -> L36
        if (r17 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("packageInfo");     // Catch: PackageManager.NameNotFoundException -> L36
    L24:
        String r18 = r4.versionName;     // Catch: PackageManager.NameNotFoundException -> L36
        if (r18 != null) goto L28;
        r18 = "";
    L28:
        NetworkConfig.Builder r19 = r8.setVersionName(r18).setAppName(r16);     // Catch: PackageManager.NameNotFoundException -> L36
        if (r11 != null) goto L31;
        r11 = "";
    L31:
        NetworkConfig r20 = r19.setDid(r11).setNeedSetCookieHandler(r12.getNeedSetCookieHandler()).setApiProcessHook(r12.getApiProcessHook()).build();     // Catch: PackageManager.NameNotFoundException -> L36
        NetworkSDKInit r21 = NetworkSDKInit.INSTANCE;     // Catch: PackageManager.NameNotFoundException -> L36
        Context r22 = r10.getApplicationContext();     // Catch: PackageManager.NameNotFoundException -> L36
        if (r22 == null) goto L35;
        r21.init(r10, (Application) r22, r12.getBaseUrl(), r20, null, new AnonymousClass1());     // Catch: PackageManager.NameNotFoundException -> L36
        OLog.i(TAG, "initNetwork end, source=" + r13);     // Catch: PackageManager.NameNotFoundException -> L36
        return;
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");     // Catch: PackageManager.NameNotFoundException -> L36
    L23:
        r4 = r17;
    L10:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: PackageManager.NameNotFoundException -> L36
        r15 = Result.m774constructorimpl(ResultKt.createFailure(th));     // Catch: PackageManager.NameNotFoundException -> L36
        goto L13
    L6:
        r5 = null;
    L36:
        e = move-exception;
        Log.e(TAG, "initNetwork error source=" + r13 + ' ' + e.getMessage());
    }
}
