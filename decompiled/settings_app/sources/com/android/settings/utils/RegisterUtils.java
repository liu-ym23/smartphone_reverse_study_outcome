package com.android.settings.utils;

import android.app.Activity;
import android.content.BroadcastReceiver;
import com.android.settingslib.SliceBroadcastRelay;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RegisterUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0007J$\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0007¨\u0006\u000f"}, d2 = {"Lcom/android/settings/utils/RegisterUtils;", "", "()V", "registerSafely", "", "tag", "", "onBlock", "Lkotlin/Function0;", "unRegisterBroadcastReceiverSafely", "activity", "Landroid/app/Activity;", SliceBroadcastRelay.EXTRA_RECEIVER, "Landroid/content/BroadcastReceiver;", "unRegisterSafely", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RegisterUtils {
    public static final RegisterUtils INSTANCE = null;

    static {
        INSTANCE = new RegisterUtils();
    }

    private RegisterUtils() {
    }

    @JvmStatic
    public static final void registerSafely(String r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "onBlock");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r3.invoke();     // Catch: Throwable -> L5
        Object r4 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.m1511exceptionOrNullimpl(r4);
        if (r5 == null) goto L13;
        OLog.e(r2, "registerSafely, register failed, error_msg: " + r5);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @JvmStatic
    public static final void unRegisterSafely(String r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "onBlock");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r3.invoke();     // Catch: Throwable -> L5
        Object r4 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.m1511exceptionOrNullimpl(r4);
        if (r5 == null) goto L13;
        OLog.e(r2, "unRegisterSafely, unregister failed, error_msg: " + r5);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @JvmStatic
    public static final void unRegisterBroadcastReceiverSafely(String r1, Activity r2, BroadcastReceiver r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        if (r2 == null) goto L16;
        if (r3 == null) goto L18;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        r2.unregisterReceiver(r3);     // Catch: Throwable -> L8
        Object r4 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r5 = Result.m1511exceptionOrNullimpl(r4);
        if (r5 == null) goto L17;
        OLog.e(r1, "unRegisterBroadcastReceiverSafely failed, error_msg: " + r5);
        return;
    L17:
        return;
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L10
    L18:
        return;
    }
}
