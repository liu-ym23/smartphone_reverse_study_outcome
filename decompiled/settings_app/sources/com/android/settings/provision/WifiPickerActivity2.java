package com.android.settings.provision;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ServiceManager;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.animation.PathInterpolator;
import androidx.fragment.app.Fragment;
import com.android.internal.telephony.ITelephony;
import com.android.settings.MainSettings;
import com.android.settings.MultiSimAdapter;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.about.DeviceUtils;
import com.android.settings.provision.NextPageRouting.RoutingUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.ProvisionTeaEvent;
import com.android.settings.teaevent.TeaEventConst;
import com.android.settings.wifi.WifiSettings;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class WifiPickerActivity2 extends MainSettings {
    private static final String TAG = "WifiPickerActivity2";
    public boolean mBackPressed;
    private FrpUtils mFrpUtils;
    private boolean mIsActivated;

    public void com_android_settings_provision_WifiPickerActivity2__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_provision_WifiPickerActivity2__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.MainSettings, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_provision_WifiPickerActivity2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_provision_WifiPickerActivity2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_provision_WifiPickerActivity2_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_provision_WifiPickerActivity2_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_provision_WifiPickerActivity2_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public WifiPickerActivity2() {
        this.mIsActivated = false;
        this.mBackPressed = false;
    }

    @Override // com.android.settings.MainSettings, com.android.settings.base.BaseActivity
    public <T extends Fragment> T getBindFragment() {
        return new WifiSettings();
    }

    public void com_android_settings_provision_WifiPickerActivity2__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        if (WizardManagerHelper.isAnySetupWizard(getIntent()) == false) goto L6;
        getWindow().getDecorView().setBackgroundDrawable(new ColorDrawable(getColor(R.color.oui_basic_bg_base_1_light)));
    L6:
        if (isSetupWizardMode() == false) goto L10;
        Window r5 = getWindow();
        if (r5 == null) goto L11;
        r5.setNavigationBarColor(getColor(R.color.Transparent));
    L11:
        OLog.i(TAG, "onCreate DEVICE_PROVISIONING_MOBILE_DATA_ENABLED 1");
        Settings.Global.putInt(getContentResolver(), "device_provisioning_mobile_data", 1);
        this.mFrpUtils = new FrpUtils();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        OLog.e(TAG, "FrpUtils init failed", e);
        ToastUtils.show(this, R.string.init_security_frp_failed);
        return;
    L10:
        Utils.hideNavigationBar(this);
        goto L11
    }

    public boolean isSetupWizardMode() {
        return this.mSetupWizardMode;
    }

    public void gotoNextPage() {
        OLog.e(TAG, "gotoNextPage");
        if (this.mSetupWizardMode == false) goto L5;
        this.mIsActivated = true;
        RoutingUtils.nextToFace(this);
        return;
    L5:
        setResult(-1);
        finish();
    }

    public void setActivated() {
        OLog.e(TAG, "setActivated");
        this.mIsActivated = true;
    }

    public boolean isActivated() {
        return this.mIsActivated;
    }

    public void startActivate(boolean r6) {
        OLog.i(TAG, "startActivate isCell=" + r6);
        if (DeviceUtils.INSTANCE.isZ80U() == false) goto L7;
        OLog.i(TAG, "isZ80U, start CompletedActivity");
        Intent r7 = new Intent();
        r7.setClassName("com.android.provision", "com.android.provision.CompletedActivity");
        RoutingUtils.startActivityFade(this, r7, ProvisionConstants.REQ_ACTIVATE);
        return;
    L7:
        if (WizardManagerHelper.isAnySetupWizard(getIntent()) == false) goto L10;
        OLog.i(TAG, "nextStep isAnySetupWizard");
        Intent r0 = WizardManagerHelper.getNextIntent(getIntent(), -1);
        r0.putExtra("isCell", r6);
        r0.putExtra("isSeDevice", Utils.isSeDevice());
        RoutingUtils.startActivityDefault2(this, r0, ProvisionConstants.REQ_ACTIVATE);
        return;
    L10:
        Intent r1 = new Intent();
        r1.setClassName("com.android.provision", "com.android.provision.activate.ActivateActivity2");
        r1.putExtra("isCell", r6);
        r1.putExtra("isSeDevice", Utils.isSeDevice());
        ProvisionTeaEvent.overrideOutEnterPage("obric_os_active", TeaEventConst.PAGE_WIFI_CONNECTION, r1);
        RoutingUtils.startActivityFade(this, r1, ProvisionConstants.REQ_ACTIVATE);
    }

    public boolean checkFrpActivated() {
        OLog.i(TAG, "checkFrpActivated enter");
        boolean r2 = false;
        if (DeviceUtils.INSTANCE.isZ80U() == false) goto L6;
        OLog.i(TAG, "checkFrpActivated isZ80U");
        return false;
    L6:
        this.mFrpUtils.updateLastReadResult();
        boolean r0 = this.mFrpUtils.isFrpOn();
        if (Settings.Global.getInt(getContentResolver(), "provision_activate_success", 0) != 1) goto L9;
        boolean r3 = true;
    L10:
        OLog.i(TAG, "checkFrpActivated frpRes=" + r0 + " activated=" + r3);
        if (r0 == false) goto L14;
        if (r3 == true) goto L14;
        r2 = true;
    L14:
        if (r2 == false) goto L16;
        startFrpPage();
    L16:
        return r2;
    L9:
        r3 = false;
        goto L10
    }

    private void startFrpPage() {
        OLog.i(TAG, "startFrpPage");
        Intent r0 = new Intent();
        r0.setClassName("com.obric.cloudservice", "com.obric.cloudservice.phone_setup.PhoneFrpUnlockActivity");
        ProvisionTeaEvent.overrideOutEnterPage("obric_os_active", TeaEventConst.PAGE_WIFI_CONNECTION, r0);
        if (WizardManagerHelper.isAnySetupWizard(getIntent()) == false) goto L5;
        WizardManagerHelper.copyWizardManagerExtras(getIntent(), r0);
    L5:
        RoutingUtils.startActivityDefault2(this, r0, ProvisionConstants.REQ_FRP_ACTIVATE);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        if (Utils.isDeviceSetupComplete(this) == true) goto L6;
        OLog.w(TAG, "onWindowFocusChanged isDeviceSetupComplete false ");
        return;
    }

    public void com_android_settings_provision_WifiPickerActivity2__onResume$___twin___() {
        super.onResume();
        OLog.i(TAG, "onResume");
        if (isSetupWizardMode() == false) goto L6;
        ProvisionTeaEvent.enterPage(getIntent());
        uploadSimCardSlot();
    L6:
        if (WizardManagerHelper.isAnySetupWizard(getIntent()) == false) goto L9;
        OLog.i(TAG, "onResume isAnySetupWizard");
        return;
    L9:
        getWindow().getDecorView().setVisibility(0);
        View r0 = getWindow().getDecorView();
        int r3 = getResources().getDisplayMetrics().widthPixels;
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r0, "translationX", new float[]{r0.getTranslationX(), 0.0f});
        r1.setDuration(500);
        r1.setInterpolator(new PathInterpolator(0.18f, 0.85f, 0.4f, 1.0f));
        r1.start();
        OLog.i(TAG, "onResume: animator.start");
        r1.addListener(new AnonymousClass1(this));
    }

    public void com_android_settings_provision_WifiPickerActivity2__onPause$___twin___() {
        super.onPause();
        OLog.i(TAG, "onPause: " + getTaskId());
        if (isSetupWizardMode() == false) goto L6;
        ProvisionTeaEvent.leavePage(getIntent());
    L6:
        if (WizardManagerHelper.isAnySetupWizard(getIntent()) == false) goto L10;
        OLog.i(TAG, "onPause isAnySetupWizard");
        return;
    L10:
        if (this.mBackPressed == false) goto L13;
        OLog.i(TAG, "onPause: back pressed");
        return;
    L13:
        ObjectAnimator r0 = ObjectAnimator.ofFloat(getWindow().getDecorView(), "translationX", new float[]{0.0f, -getResources().getDisplayMetrics().widthPixels});
        r0.setDuration(500);
        r0.setInterpolator(new PathInterpolator(0.18f, 0.85f, 0.4f, 1.0f));
        r0.start();
        OLog.i(TAG, "onPause: animator.start");
        r0.addListener(new AnonymousClass2(this));
    }

    public void setBackPressed(boolean r1) {
        this.mBackPressed = r1;
    }

    @Override // com.android.settings.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        OLog.e(TAG, "onBackPressed");
        if (isSetupWizardMode() == false) goto L6;
        ProvisionTeaEvent.click(ProvisionTeaEvent.getPageName(getIntent()), TeaEventConst.CLICK_BACK);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    private void uploadSimCardSlot() {
        if (isSetupWizardMode() == true) goto L13;
        return;
    L13:
        ITelephony r2 = ITelephony.Stub.asInterface(ServiceManager.checkService(MultiSimAdapter.PHONE_KEY));     // Catch: Throwable -> L10
        ?? r0 = r2.getISmtEx().isSlotActive(0);     // Catch: Throwable -> L10
        int r1 = r0;
        if (r2.getISmtEx().isSlotActive(1) == false) goto L8;
        r1 = r0 + 1;     // Catch: Throwable -> L10
    L8:
        ProvisionTeaEvent.uploadSimCardSlot(TeaEventConst.PAGE_WIFI_CONNECTION, r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        OLog.e(TAG, "uploadSimCardSlot RemoteException", th);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_provision_WifiPickerActivity2_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(WifiPickerActivity2 r1) {
        r1.com_android_settings_provision_WifiPickerActivity2__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_provision_WifiPickerActivity2_com_obric_hook_lancet_BatchedActivityLancet_onResume(WifiPickerActivity2 r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_provision_WifiPickerActivity2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_provision_WifiPickerActivity2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(WifiPickerActivity2 r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_provision_WifiPickerActivity2__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        WifiPickerActivity2 r5 = r4;
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
    public static void com_android_settings_provision_WifiPickerActivity2_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(WifiPickerActivity2 r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_provision_WifiPickerActivity2__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_provision_WifiPickerActivity2_com_obric_hook_lancet_BatchedActivityLancet_onStop(WifiPickerActivity2 r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_provision_WifiPickerActivity2_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_provision_WifiPickerActivity2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(WifiPickerActivity2 r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_provision_WifiPickerActivity2__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_provision_WifiPickerActivity2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(WifiPickerActivity2 r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_provision_WifiPickerActivity2__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        WifiPickerActivity2 r5 = r3;
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
}
