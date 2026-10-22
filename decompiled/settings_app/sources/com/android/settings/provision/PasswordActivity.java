package com.android.settings.provision;

import android.animation.ObjectAnimator;
import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.ChooseLockGeneric;
import com.android.settings.ChooseLockPassword;
import com.android.settings.ChooseLockPattern;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.EncryptionInterstitial;
import com.android.settings.LockPasswordQualityHelper;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PasswordActivity extends ProvisionPureBaseActivity {
    private static final int MIN_PASSWORD_LENGTH = 4;
    private static final String TAG = "PasswordActivity";
    private PasswordAdapter mAdapter;
    private boolean mBackPressed;
    private ChooseLockSettingsHelper mChooseLockSettingsHelper;
    private DevicePolicyManager mDPM;
    private PasswordAdapter.PasswordItem[] mData;
    private LockPatternUtils mLockPatternUtils;
    private LockPasswordQualityHelper mLockQualityHelper;

    public void com_android_settings_provision_PasswordActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_provision_PasswordActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.provision.ProvisionPureBaseActivity
    protected int getBottomStringId(int r1) {
        return R.string.provision_face_go_enroll;
    }

    @Override // com.android.settings.provision.ProvisionPureBaseActivity
    protected int getContentLayoutId() {
        return R.layout.activity_base_password;
    }

    @Override // com.android.settings.provision.ProvisionPureBaseActivity
    protected int getTitleId() {
        return R.string.security_unlock_method;
    }

    @Override // com.android.settings.provision.ProvisionPureBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_provision_PasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_provision_PasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_provision_PasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_provision_PasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_provision_PasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public PasswordActivity() {
        this.mBackPressed = false;
    }

    @Override // com.android.settings.provision.ProvisionPureBaseActivity
    protected void nextStep(int r3) {
        PasswordAdapter.PasswordItem r4 = this.mData[this.mAdapter.getCurrentIndex()];
        updateUnlockMethodAndFinish(r4.quality, r4.pinLength, false);
    }

    public void com_android_settings_provision_PasswordActivity__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        UIUtils.setUpFakeStatusBarOnApplyWindowInsets(findViewById(R.id.fake_status_bar));
        this.mLockQualityHelper = new LockPasswordQualityHelper(this);
        this.mDPM = (DevicePolicyManager) getSystemService("device_policy");
        ChooseLockSettingsHelper r3 = new ChooseLockSettingsHelper(this);
        this.mChooseLockSettingsHelper = r3;
        this.mLockPatternUtils = r3.utils();
        RecyclerView r4 = (RecyclerView) findViewById(R.id.list_view);
        r4.setLayoutManager(new LinearLayoutManager(this));
        PasswordAdapter r0 = new PasswordAdapter(this);
        this.mAdapter = r0;
        r4.setAdapter(r0);
        PasswordAdapter.PasswordItem[] r5 = getPasswordData();
        this.mData = r5;
        this.mAdapter.setData(r5);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r1 == 300) goto L5;
    L7:
        setResult(0);
        return;
    L5:
        if (r2 != (-1)) goto L7;
        OLog.d(TAG, "SET_LOCK_PASSWORD_REQUEST");
        finish();
    }

    private PasswordAdapter.PasswordItem[] getPasswordData() {
        return new PasswordAdapter.PasswordItem[]{new AnonymousClass1(this), new AnonymousClass2(this), new AnonymousClass3(this), new AnonymousClass4(this)};
    }

    void updateUnlockMethodAndFinish(int r11, int r12, boolean r13) {
        int r14 = this.mLockQualityHelper.upgradeQuality(r11);
        if (r14 < 131072) goto L9;
        int r15 = this.mDPM.getPasswordMinimumLength(null);
        if (r15 >= 4) goto L7;
        r15 = 4;
    L7:
        int r6 = this.mDPM.getPasswordMaximumLength(r14);
        Intent r7 = new Intent().setClass(this, ChooseLockPassword.class);
        OLog.d(TAG, "updateUnlockMethodAndFinish  quality:" + r14);
        r7.putExtra("lockscreen.password_type", r14);
        r7.putExtra(ChooseLockPassword.PASSWORD_MIN_KEY, r15);
        r7.putExtra(ChooseLockPassword.PASSWORD_MAX_KEY, r6);
        r7.putExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, r12);
        r7.putExtra(EncryptionInterstitial.EXTRA_REQUIRE_PASSWORD, false);
        r7.putExtra(ProvisionConstants.EXTRA_SETUPWIZARD, true);
        Utils.startActivity(this, r7, 2, 300);
        return;
    L9:
        if (r14 != 65536) goto L13;
        Intent r16 = new Intent();
        r16.setClass(this, ChooseLockPattern.class);
        r16.putExtra("pattern_size", 3);
        r16.putExtra("key_lock_method", "pattern");
        r16.putExtra(ChooseLockGeneric.CONFIRM_CREDENTIALS, false);
        r16.putExtra(ProvisionConstants.EXTRA_SETUPWIZARD, true);
        r16.putExtra(EncryptionInterstitial.EXTRA_REQUIRE_PASSWORD, false);
        Utils.startActivity(this, r16, 2, 300);
        return;
    }

    @Override // com.android.settings.provision.ProvisionPureBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.mBackPressed = true;
        super.onBackPressed();
    }

    public void com_android_settings_provision_PasswordActivity__onPause$___twin___() {
        super.onPause();
        OLog.i(TAG, "onPause: " + getTaskId());
        if (this.mBackPressed == false) goto L5;
        return;
    L5:
        ObjectAnimator r0 = ObjectAnimator.ofFloat(getWindow().getDecorView(), "translationX", new float[]{0.0f, -getResources().getDisplayMetrics().widthPixels});
        r0.setDuration(500);
        r0.setInterpolator(new PathInterpolator(0.18f, 0.85f, 0.4f, 1.0f));
        r0.start();
        r0.addListener(new AnonymousClass5(this));
    }

    public void com_android_settings_provision_PasswordActivity__onResume$___twin___() {
        super.onResume();
        OLog.e(TAG, "onResume");
        getWindow().getDecorView().setBackgroundColor(0);
        getWindow().getDecorView().setVisibility(0);
        View r0 = getWindow().getDecorView();
        int r2 = getResources().getDisplayMetrics().widthPixels;
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r0, "translationX", new float[]{r0.getTranslationX(), 0.0f});
        r1.setDuration(500);
        r1.setInterpolator(new PathInterpolator(0.18f, 0.85f, 0.4f, 1.0f));
        r1.start();
        r1.addListener(new AnonymousClass6(this));
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_provision_PasswordActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(PasswordActivity r1) {
        r1.com_android_settings_provision_PasswordActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_provision_PasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(PasswordActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_provision_PasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_provision_PasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(PasswordActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_provision_PasswordActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        PasswordActivity r5 = r4;
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
    public static void com_android_settings_provision_PasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(PasswordActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_provision_PasswordActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_provision_PasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(PasswordActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_provision_PasswordActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_provision_PasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(PasswordActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_provision_PasswordActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_provision_PasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(PasswordActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_provision_PasswordActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        PasswordActivity r5 = r3;
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
