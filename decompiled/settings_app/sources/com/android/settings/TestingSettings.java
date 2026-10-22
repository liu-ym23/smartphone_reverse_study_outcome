package com.android.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.android.settings.applications.ManageApplicationsFragment;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.wifi.WifiInfo;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.OMenuDialog;
import obric.app.OMenuDialogListAdapter;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public class TestingSettings extends BaseActivity implements View.OnClickListener {
    public static final String INTENT_SLOT_EXTRA_NAME = "slotID";
    private ListContentItemText mAppManagerItem;
    private ListContentItemText mBatteryInfo;
    private OMenuDialog mDialog;
    private ListContentItemText mRadioInfo;
    private ListContentItemText mUsageStats;
    private ListContentItemText mWifiInfo;

    public void com_android_settings_TestingSettings__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_TestingSettings__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_TestingSettings__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_TestingSettings__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_TestingSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_TestingSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_TestingSettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_TestingSettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_TestingSettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public TestingSettings() {
    }

    public void com_android_settings_TestingSettings__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.testing_settings_activity);
        ((OFloatingTitleBar) findViewById(R.id.view_title)).addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null).setOnClickListener(new AnonymousClass1(this));
        ListContentItemText r5 = (ListContentItemText) findViewById(R.id.item_radio_info);
        this.mRadioInfo = r5;
        r5.setOnClickListener(this);
        ListContentItemText r6 = (ListContentItemText) findViewById(R.id.item_battery_info);
        this.mBatteryInfo = r6;
        r6.setOnClickListener(this);
        ListContentItemText r7 = (ListContentItemText) findViewById(R.id.item_usage_stats);
        this.mUsageStats = r7;
        r7.setOnClickListener(this);
        ListContentItemText r8 = (ListContentItemText) findViewById(R.id.item_wifi_info);
        this.mWifiInfo = r8;
        r8.setOnClickListener(this);
        ListContentItemText r9 = (ListContentItemText) findViewById(R.id.item_app_manager);
        this.mAppManagerItem = r9;
        r9.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        Intent r0 = new Intent("android.intent.action.MAIN");
        switch(r3.getId()) {
            case 2131429278: goto L13;
            case 2131429287: goto L12;
            case 2131429494: goto L8;
            case 2131429555: goto L6;
            case 2131429568: goto L5;
            default: goto L14;
        };
    L5:
        r0.setClass(this, WifiInfo.class);
        goto L14
    L6:
        r0.setClass(this, UsageStatsActivity.class);
        goto L14
    L12:
        r0 = new Intent(this, Settings.PowerUsageSummaryActivity2.class);
        goto L14
    L13:
        r0.setClass(this, Settings.ManageApplicationsActivity.class);
        r0.putExtra(ManageApplicationsFragment.EXTRA_SYSTEM_APP_MANAGER, true);
        r0.putExtra("title_id", R.string.system_app_manager_title);
    L14:
        Utils.startActivity(this, r0, 0);
        return;
    L8:
        if (MultiSimAdapter.isMultiSimEnabled() == false) goto L11;
        showCardChooseMenuDialog();
        return;
    L11:
        r0.setClass(this, RadioInfo.class);
        goto L14
    }

    private void showCardChooseMenuDialog() {
        OMenuDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
    L7:
        this.mDialog = new OMenuDialog(this.mActivity);
        ArrayList r1 = new ArrayList();
        r1.add(getString(R.string.card_1));
        r1.add(getString(R.string.card_2));
        ArrayList r2 = new ArrayList();
        r2.add(new AnonymousClass2(this));
        r2.add(new AnonymousClass3(this));
        OMenuDialogListAdapter r3 = new OMenuDialogListAdapter(this.mActivity, r1, r2);
        this.mDialog.setAdapter(r3);
        this.mDialog.setTitle(R.string.select_card);
        this.mDialog.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mDialog.dismiss();
        goto L7
    }

    protected void chooseCard(int r3) {
        Intent r0 = new Intent("android.intent.action.MAIN");
        r0.setClass(this, RadioInfo.class);
        r0.putExtra(INTENT_SLOT_EXTRA_NAME, r3);
        Utils.startActivity(this, r0, 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_TestingSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(TestingSettings r1) {
        com_android_settings_TestingSettings_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_TestingSettings_com_obric_hook_lancet_PrivacyHook_onCreate(TestingSettings r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        TestingSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_TestingSettings__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_TestingSettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(TestingSettings r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_TestingSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_TestingSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(TestingSettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_TestingSettings_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        TestingSettings r5 = r4;
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
    public static void com_android_settings_TestingSettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(TestingSettings r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_TestingSettings__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_TestingSettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(TestingSettings r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_TestingSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_TestingSettings_com_obric_hook_lancet_PrivacyHook_onResume(TestingSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        TestingSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_TestingSettings__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_TestingSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(TestingSettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_TestingSettings_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_TestingSettings_com_obric_hook_lancet_PrivacyHook_onPause(TestingSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        TestingSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_TestingSettings__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_TestingSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(TestingSettings r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_TestingSettings_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        TestingSettings r5 = r3;
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
    public static void com_android_settings_TestingSettings_com_obric_hook_lancet_PrivacyHook_onStop(TestingSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        TestingSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_TestingSettings__onStop$___twin___();
    }
}
