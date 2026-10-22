package com.obric.matrix.platform.sdk.ones.init;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.obric.matrix.platform.sdk.ones.account.log.OLog;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseComponentInitHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/platform/sdk/ones/init/BaseComponentInitHelper$deferNetworkUntilUserUnlocked$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BaseComponentInitHelper$deferNetworkUntilUserUnlocked$receiver$1 extends BroadcastReceiver {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ BaseComponentConfig $baseComponentConfig;
    final /* synthetic */ String $deviceId;

    public static /* synthetic */ void $r8$lambda$pNaVbkdB9zmdhAxsv6byfV3olXw(Context r0, String r1, BaseComponentConfig r2) {
        m163onReceive$lambda1(r0, r1, r2);
    }

    BaseComponentInitHelper$deferNetworkUntilUserUnlocked$receiver$1(Context r1, String r2, BaseComponentConfig r3) {
        this.$appContext = r1;
        this.$deviceId = r2;
        this.$baseComponentConfig = r3;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r3, Intent r4) {
        if (r4 == null) goto L4;
        String r5 = r4.getAction();
    L6:
        if (Intrinsics.areEqual(r5, "android.intent.action.USER_UNLOCKED") == true) goto L8;
        return;
    L8:
        OLog.i("BaseComponentInitHelper", "received USER_UNLOCKED, start deferred network init");
        Context r6 = this.$appContext;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L11
        BaseComponentInitHelper$deferNetworkUntilUserUnlocked$receiver$1 r8 = this;     // Catch: Throwable -> L11
        r6.unregisterReceiver(this);     // Catch: Throwable -> L11
        Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        BaseComponentInitHelper.access$getUnlockReceiverRegistered$p().set(false);
        ExecutorService r9 = BaseComponentInitHelper.access$getInitExecutor(BaseComponentInitHelper.INSTANCE);
        final Context r10 = this.$appContext;
        final String r0 = this.$deviceId;
        final BaseComponentConfig r2 = this.$baseComponentConfig;
        r9.execute(new BaseComponentInitHelper$deferNetworkUntilUserUnlocked$receiver$1$$ExternalSyntheticLambda0(r10, r0, r2));
        return;
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L13
    L4:
        r5 = null;
        goto L6
    }

    /* JADX INFO: renamed from: onReceive$lambda-1, reason: not valid java name */
    private static final void m163onReceive$lambda1(Context r2, String r3, BaseComponentConfig r4) {
        Intrinsics.checkNotNullParameter(r3, "$deviceId");
        Intrinsics.checkNotNullParameter(r4, "$baseComponentConfig");
        if (Build.VERSION.SDK_INT >= 33) goto L10;
        return;
    L10:
        BaseComponentInitHelper r0 = BaseComponentInitHelper.INSTANCE;     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r2, "appContext");     // Catch: Throwable -> L7
        BaseComponentInitHelper.access$initNetwork(r0, r2, r3, r4, "user_unlocked");     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        MLog.e("BaseComponentInitHelper", "initNetwork after unlock error", th);
    }
}
