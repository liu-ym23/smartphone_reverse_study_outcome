package com.android.settings.bluetooth;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.android.settings.R;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import com.obric.oui.dialog.v2.alert.style.OViewStyleController;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothPbapClientActivity extends BaseActivity {
    private final String TAG;
    private BluetoothPbapClientFragment mBluetoothPbapClientFragment;

    public void com_android_settings_bluetooth_BluetoothPbapClientActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_bluetooth_BluetoothPbapClientActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_bluetooth_BluetoothPbapClientActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_bluetooth_BluetoothPbapClientActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public BluetoothPbapClientActivity() {
        this.TAG = "BluetoothPbapClientIntroduction";
    }

    static /* synthetic */ BluetoothPbapClientFragment access$000(BluetoothPbapClientActivity r0) {
        return r0.mBluetoothPbapClientFragment;
    }

    public void com_android_settings_bluetooth_BluetoothPbapClientActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.bluetooth_pbapclient_intro);
        this.mBluetoothPbapClientFragment = (BluetoothPbapClientFragment) getSupportFragmentManager().findFragmentById(R.id.BluetoothPbapClientFragment);
        this.mBackView = ((OFloatingTitleBar) findViewById(R.id.view_title)).addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
        this.mBackView.setOnClickListener(new AnonymousClass1(this));
        showDisconnectDialog();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        OLog.d("BluetoothPbapClientIntroduction", "onConfigurationChanged");
    }

    @Override // com.android.settings.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.mBluetoothPbapClientFragment.onBackPressed();
        super.onBackPressed();
    }

    private void showDisconnectDialog() {
        final View r0 = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.bluetooth_pbapclient_tips, null);
        StringBuilder r1 = new StringBuilder();
        r1.append(getResources().getString(R.string.step_1)).append("\n");
        r1.append(getResources().getString(R.string.step_2)).append("\n");
        r1.append(getResources().getString(R.string.step_3));
        new OViewStyleController(new BluetoothPbapClientActivity$$ExternalSyntheticLambda0(r0));
        new OAlertDialogBuilder(this).autoDismiss(false).horizontalButton().title(R.string.op_remote).message(r1.toString()).negativeButton(R.string.pbap_know, new AnonymousClass2(this)).show();
    }

    static /* synthetic */ Unit lambda$showDisconnectDialog$0(View r0, DialogContainer r1) {
        r1.getBodySlot().addView(r0);
        return null;
    }

    public void com_android_settings_bluetooth_BluetoothPbapClientActivity__finish$___twin___() {
        super.finish();
        if (getIntent() == null) goto L9;
        int[] r0 = getIntent().getIntArrayExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID");
        if (r0 == null) goto L7;
        overridePendingTransition(r0[0], r0[1]);
        return;
    L7:
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Standard);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_bluetooth_BluetoothPbapClientActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(BluetoothPbapClientActivity r1) {
        com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_PrivacyHook_onCreate(BluetoothPbapClientActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BluetoothPbapClientActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_bluetooth_BluetoothPbapClientActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(BluetoothPbapClientActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(BluetoothPbapClientActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        BluetoothPbapClientActivity r5 = r4;
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
    public static void com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(BluetoothPbapClientActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_bluetooth_BluetoothPbapClientActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(BluetoothPbapClientActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_bluetooth_BluetoothPbapClientActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_PrivacyHook_onResume(BluetoothPbapClientActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BluetoothPbapClientActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_bluetooth_BluetoothPbapClientActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(BluetoothPbapClientActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_PrivacyHook_onPause(BluetoothPbapClientActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BluetoothPbapClientActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_bluetooth_BluetoothPbapClientActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(BluetoothPbapClientActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        BluetoothPbapClientActivity r5 = r3;
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
    public static void com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_PrivacyHook_onStop(BluetoothPbapClientActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BluetoothPbapClientActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_bluetooth_BluetoothPbapClientActivity__onStop$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_bluetooth_BluetoothPbapClientActivity_com_obric_hook_lancet_PrivacyHook_finish(BluetoothPbapClientActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BluetoothPbapClientActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_bluetooth_BluetoothPbapClientActivity__finish$___twin___();
    }
}
