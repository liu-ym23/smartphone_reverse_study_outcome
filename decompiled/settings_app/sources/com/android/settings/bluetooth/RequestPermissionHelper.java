package com.android.settings.bluetooth;

import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import com.android.settings.R;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: RequestPermissionHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ>\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¨\u0006\u0010"}, d2 = {"Lcom/android/settings/bluetooth/RequestPermissionHelper;", "", "()V", "requestDisable", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "context", "Landroid/content/Context;", "appLabel", "", "onAllow", "Lkotlin/Function0;", "", "onDeny", "requestEnable", "timeout", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RequestPermissionHelper {
    public static final RequestPermissionHelper INSTANCE = null;

    /* JADX INFO: renamed from: $r8$lambda$6ySaFGC4ZwEy7WzJ1t-bb3T_-m8, reason: not valid java name */
    public static /* synthetic */ void m374$r8$lambda$6ySaFGC4ZwEy7WzJ1tbb3T_m8(Ref.ObjectRef r0, Function0 r1, DialogInterface r2, int r3) {
        requestEnable$lambda$1(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$7KcVG9wo5C8kMTfYDOJg-wVQCHM, reason: not valid java name */
    public static /* synthetic */ void m375$r8$lambda$7KcVG9wo5C8kMTfYDOJgwVQCHM(Ref.ObjectRef r0, OAlertDialog r1, Context r2, Function0 r3, DialogInterface r4) {
        requestDisable$lambda$6(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$CNZgBxwBab9ucKWMWT3hOBCOfz0(Ref.ObjectRef r0, Function0 r1, DialogInterface r2, int r3) {
        requestDisable$lambda$5(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$OsTKydQUmlopWCKizm_ZwQGM6FY(Context r0, Function0 r1, Function0 r2, DialogInterface r3, int r4) {
        requestEnable$lambda$0(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$P80WyID0MAWq-tIrOLLIv3D7wjA, reason: not valid java name */
    public static /* synthetic */ void m376$r8$lambda$P80WyID0MAWqtIrOLLIv3D7wjA(Ref.ObjectRef r0, DialogInterface r1) {
        requestEnable$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Sl-V4kj7db7zEFDjQth_YPCEfTg, reason: not valid java name */
    public static /* synthetic */ void m377$r8$lambda$SlV4kj7db7zEFDjQth_YPCEfTg(Ref.ObjectRef r0, DialogInterface r1) {
        requestDisable$lambda$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ZTnfu1J4SuIMm4ESgYDPI4MyaIg(Function0 r0, DialogInterface r1, int r2) {
        requestDisable$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$wn8XFlbdIEInH7OYPQXGLuIy3vw(Ref.ObjectRef r0, OAlertDialog r1, Context r2, Function0 r3, DialogInterface r4) {
        requestEnable$lambda$2(r0, r1, r2, r3, r4);
    }

    static {
        INSTANCE = new RequestPermissionHelper();
    }

    private RequestPermissionHelper() {
    }

    public final OAlertDialog requestEnable(final Context r21, CharSequence r22, int r23, final Function0<Unit> r24, final Function0<Unit> r25) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r24, "onAllow");
        Intrinsics.checkNotNullParameter(r25, "onDeny");
        if (r21.getResources().getBoolean(R.bool.auto_confirm_bluetooth_activation_dialog) == false) goto L6;
        r24.invoke();
        return null;
    L6:
        final Ref.ObjectRef r3 = new Ref.ObjectRef();
        final OAlertDialog r1 = OAlertDialogBuilder.negativeButton$default(OAlertDialogBuilder.positiveButton$default(OAlertDialogBuilder.horizontalButton$default(new OAlertDialogBuilder(r21).autoDismiss(false), false, 1, null).title(RequestPermissionHelperKt.access$getEnableMessage(r21, r23, r22), true), R.string.allow, new RequestPermissionHelper$$ExternalSyntheticLambda4(r21, r25, r24), null, 4, null), R.string.prohibit, new RequestPermissionHelper$$ExternalSyntheticLambda5(r3, r25), null, 4, null).build();
        r1.setOnShowListener(new RequestPermissionHelper$$ExternalSyntheticLambda6(r3, r1, r21, r25));
        r1.setOnDismissListener(new RequestPermissionHelper$$ExternalSyntheticLambda7(r3));
        return r1;
    }

    private static final void requestEnable$lambda$0(Context r0, Function0 r1, Function0 r2, DialogInterface r3, int r4) {
        Intrinsics.checkNotNullParameter(r0, "$context");
        Intrinsics.checkNotNullParameter(r1, "$onDeny");
        Intrinsics.checkNotNullParameter(r2, "$onAllow");
        if (RequestPermissionHelperKt.access$isDisallowBluetooth(r0) == false) goto L5;
        r1.invoke();
        return;
    L5:
        r2.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void requestEnable$lambda$1(Ref.ObjectRef r0, Function0 r1, DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r0, "$countDownTimer");
        Intrinsics.checkNotNullParameter(r1, "$onDeny");
        CountDownTimer r4 = (CountDownTimer) r0.element;
        if (r4 == null) goto L5;
        r4.cancel();
    L5:
        r1.invoke();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, android.os.CountDownTimer] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.android.settings.bluetooth.RequestPermissionHelper$requestEnable$1$1] */
    private static final void requestEnable$lambda$2(Ref.ObjectRef r0, final OAlertDialog r1, final Context r2, final Function0 r3, DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r0, "$countDownTimer");
        Intrinsics.checkNotNullParameter(r1, "$dialog");
        Intrinsics.checkNotNullParameter(r2, "$context");
        Intrinsics.checkNotNullParameter(r3, "$onDeny");
        r0.element = new RequestPermissionHelper$requestEnable$1$1(r1, r2, r3).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void requestEnable$lambda$3(Ref.ObjectRef r0, DialogInterface r1) {
        Intrinsics.checkNotNullParameter(r0, "$countDownTimer");
        CountDownTimer r2 = (CountDownTimer) r0.element;
        if (r2 == null) goto L6;
        r2.cancel();
        return;
    }

    public final OAlertDialog requestDisable(final Context r21, CharSequence r22, final Function0<Unit> r23, final Function0<Unit> r24) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r23, "onAllow");
        Intrinsics.checkNotNullParameter(r24, "onDeny");
        if (r21.getResources().getBoolean(R.bool.auto_confirm_bluetooth_activation_dialog) == false) goto L6;
        r23.invoke();
        return null;
    L6:
        final Ref.ObjectRef r3 = new Ref.ObjectRef();
        final OAlertDialog r1 = OAlertDialogBuilder.negativeButton$default(OAlertDialogBuilder.positiveButton$default(OAlertDialogBuilder.horizontalButton$default(new OAlertDialogBuilder(r21).autoDismiss(false), false, 1, null).title(RequestPermissionHelperKt.access$getDisableMessage(r21, r22), true), R.string.allow, new RequestPermissionHelper$$ExternalSyntheticLambda0(r23), null, 4, null), R.string.prohibit, new RequestPermissionHelper$$ExternalSyntheticLambda1(r3, r24), null, 4, null).build();
        r1.setOnShowListener(new RequestPermissionHelper$$ExternalSyntheticLambda2(r3, r1, r21, r24));
        r1.setOnDismissListener(new RequestPermissionHelper$$ExternalSyntheticLambda3(r3));
        return r1;
    }

    private static final void requestDisable$lambda$4(Function0 r0, DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter(r0, "$onAllow");
        r0.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void requestDisable$lambda$5(Ref.ObjectRef r0, Function0 r1, DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r0, "$countDownTimer");
        Intrinsics.checkNotNullParameter(r1, "$onDeny");
        CountDownTimer r4 = (CountDownTimer) r0.element;
        if (r4 == null) goto L5;
        r4.cancel();
    L5:
        r1.invoke();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, android.os.CountDownTimer] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.android.settings.bluetooth.RequestPermissionHelper$requestDisable$1$1] */
    private static final void requestDisable$lambda$6(Ref.ObjectRef r0, final OAlertDialog r1, final Context r2, final Function0 r3, DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r0, "$countDownTimer");
        Intrinsics.checkNotNullParameter(r1, "$dialog");
        Intrinsics.checkNotNullParameter(r2, "$context");
        Intrinsics.checkNotNullParameter(r3, "$onDeny");
        r0.element = new RequestPermissionHelper$requestDisable$1$1(r1, r2, r3).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void requestDisable$lambda$7(Ref.ObjectRef r0, DialogInterface r1) {
        Intrinsics.checkNotNullParameter(r0, "$countDownTimer");
        CountDownTimer r2 = (CountDownTimer) r0.element;
        if (r2 == null) goto L6;
        r2.cancel();
        return;
    }
}
