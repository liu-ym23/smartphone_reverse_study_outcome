package com.android.settings.scheduledpower;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.scheduledpower.utils.ScheduledPowerUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.view.WindowManagerHelper;

/* JADX INFO: compiled from: ShutdownConfirmActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/settings/scheduledpower/ShutdownConfirmActivity;", "Lcom/obric/privacy/LifeHookActivity2;", "()V", "mAlertDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showShutdownDialog", "context", "Landroid/content/Context;", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ShutdownConfirmActivity extends LifeHookActivity2 {
    public static final Companion Companion = null;
    private static final long ONE_MINUTE = 60000;
    private static final long ONE_SECOND = 1000;
    private OAlertDialog mAlertDialog;

    /* JADX INFO: compiled from: ShutdownConfirmActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/settings/scheduledpower/ShutdownConfirmActivity$Companion;", "", "()V", "ONE_MINUTE", "", "ONE_SECOND", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$0PHj4P1TtNSo6MMhhNn-cHZNsAc, reason: not valid java name */
    public static /* synthetic */ void m582$r8$lambda$0PHj4P1TtNSo6MMhhNncHZNsAc(Ref.ObjectRef r0, Context r1, Function0 r2, DialogInterface r3, int r4) {
        showShutdownDialog$lambda$0(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$eqHoDIsFvXOYXdxqXIA5D1nnQiE(Ref.ObjectRef r0, Function0 r1, DialogInterface r2, int r3) {
        showShutdownDialog$lambda$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$tPNSpOxz30yT7jtDK2EF7ID6J2k(Ref.ObjectRef r0, OAlertDialog r1, Context r2, Function0 r3, DialogInterface r4) {
        showShutdownDialog$lambda$2(r0, r1, r2, r3, r4);
    }

    static {
        Companion = new Companion(null);
    }

    public void com_android_settings_scheduledpower_ShutdownConfirmActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_scheduledpower_ShutdownConfirmActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_scheduledpower_ShutdownConfirmActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_scheduledpower_ShutdownConfirmActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ShutdownConfirmActivity() {
    }

    /* JADX INFO: renamed from: access$finish$s-108024988, reason: not valid java name */
    public static final /* synthetic */ void m583access$finish$s108024988(ShutdownConfirmActivity r0) {
        super.finish();
    }

    public static final /* synthetic */ OAlertDialog access$getMAlertDialog$p(ShutdownConfirmActivity r0) {
        return r0.mAlertDialog;
    }

    public static final /* synthetic */ void access$setMAlertDialog$p(ShutdownConfirmActivity r0, OAlertDialog r1) {
        r0.mAlertDialog = r1;
    }

    public void com_android_settings_scheduledpower_ShutdownConfirmActivity__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        OLog.i(getTAG(), "onCreate");
        Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        showShutdownDialog(this);
    }

    private final void showShutdownDialog(final Context r20) {
        OAlertDialog r2 = this.mAlertDialog;
        if (r2 == null) goto L13;
        if (r2 != null) goto L6;
    L8:
        boolean r3 = false;
    L9:
        if (r3 == false) goto L13;
        OAlertDialog r4 = this.mAlertDialog;
        if (r4 == null) goto L13;
        r4.dismiss();
        goto L13
    L6:
        if (r2.isShowing() != true) goto L8;
        r3 = true;
    L13:
        final Function0<Unit> r5 = new ShutdownConfirmActivity$showShutdownDialog$dialogDismiss$1(this);
        final Ref.ObjectRef r6 = new Ref.ObjectRef();
        OAlertDialogBuilder r7 = OAlertDialogBuilder.horizontalButton$default(new OAlertDialogBuilder(r20).autoDismiss(false), false, 1, null).title(R.string.shutdown_dialog_title).message(r20.getString(R.string.shutdown_dialog_message, new Object[]{60000L}));
        String r8 = r20.getString(R.string.shutdown_dialog_positive_button);
        Intrinsics.checkNotNullExpressionValue(r8, "getString(...)");
        OAlertDialogBuilder r13 = OAlertDialogBuilder.positiveButton$default(r7, r8, new ShutdownConfirmActivity$$ExternalSyntheticLambda0(r6, r20, r5), null, 4, null);
        String r9 = r20.getString(R.string.shutdown_dialog_negative_button);
        Intrinsics.checkNotNullExpressionValue(r9, "getString(...)");
        final OAlertDialog r10 = OAlertDialogBuilder.negativeButton$default(r13, r9, new ShutdownConfirmActivity$$ExternalSyntheticLambda1(r6, r5), null, 4, null).build();
        r10.setOnShowListener(new ShutdownConfirmActivity$$ExternalSyntheticLambda2(r6, r10, r20, r5));
        this.mAlertDialog = r10;
        if (r10.getWindow() == null) goto L18;
        Window r0 = r10.getWindow();
        if (r0 == null) goto L18;
        r0.setType(WindowManagerHelper.LayoutParamsSmt.TYPE_APPLICATION_OVERLAY);
    L18:
        r10.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void showShutdownDialog$lambda$0(Ref.ObjectRef r0, Context r1, Function0 r2, DialogInterface r3, int r4) {
        Intrinsics.checkNotNullParameter(r0, "$countDownTimer");
        Intrinsics.checkNotNullParameter(r1, "$context");
        Intrinsics.checkNotNullParameter(r2, "$dialogDismiss");
        CountDownTimer r5 = (CountDownTimer) r0.element;
        if (r5 == null) goto L5;
        r5.cancel();
    L5:
        ScheduledPowerUtils.shutdown(r1);
        r2.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void showShutdownDialog$lambda$1(Ref.ObjectRef r0, Function0 r1, DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r0, "$countDownTimer");
        Intrinsics.checkNotNullParameter(r1, "$dialogDismiss");
        CountDownTimer r4 = (CountDownTimer) r0.element;
        if (r4 == null) goto L5;
        r4.cancel();
    L5:
        r1.invoke();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, android.os.CountDownTimer] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.android.settings.scheduledpower.ShutdownConfirmActivity$showShutdownDialog$1$1] */
    private static final void showShutdownDialog$lambda$2(Ref.ObjectRef r0, final OAlertDialog r1, final Context r2, final Function0 r3, DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r0, "$countDownTimer");
        Intrinsics.checkNotNullParameter(r1, "$dialog");
        Intrinsics.checkNotNullParameter(r2, "$context");
        Intrinsics.checkNotNullParameter(r3, "$dialogDismiss");
        r0.element = new ShutdownConfirmActivity$showShutdownDialog$1$1(r1, r2, r3).start();
    }

    public void com_android_settings_scheduledpower_ShutdownConfirmActivity__onDestroy$___twin___() {
        OAlertDialog r0 = this.mAlertDialog;
        if (r0 == null) goto L13;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L13;
        OAlertDialog r2 = this.mAlertDialog;
        if (r2 == null) goto L13;
        r2.dismiss();
        goto L13
    L7:
        if (r0.isShowing() != true) goto L9;
        r1 = true;
    L13:
        super.onDestroy();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_scheduledpower_ShutdownConfirmActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ShutdownConfirmActivity r1) {
        com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(ShutdownConfirmActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ShutdownConfirmActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_scheduledpower_ShutdownConfirmActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(ShutdownConfirmActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ShutdownConfirmActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ShutdownConfirmActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ShutdownConfirmActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_scheduledpower_ShutdownConfirmActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(ShutdownConfirmActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_scheduledpower_ShutdownConfirmActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(ShutdownConfirmActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ShutdownConfirmActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_scheduledpower_ShutdownConfirmActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ShutdownConfirmActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(ShutdownConfirmActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ShutdownConfirmActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_scheduledpower_ShutdownConfirmActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ShutdownConfirmActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ShutdownConfirmActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(ShutdownConfirmActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ShutdownConfirmActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_scheduledpower_ShutdownConfirmActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_scheduledpower_ShutdownConfirmActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(ShutdownConfirmActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ShutdownConfirmActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_scheduledpower_ShutdownConfirmActivity__onDestroy$___twin___();
    }
}
