package com.android.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.android.settings.base.BaseActivity;
import com.android.settings.provision.ProvisionConstants;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SelectOptionsView;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class GridThemeChooseActivity extends BaseActivity implements View.OnClickListener, SelectOptionsView.OptionsSelectedCallback {
    private final String TAG;
    private final int THEME_CLASSIC;
    private final int THEME_TRANSPARENT;
    private int mCurThemeIndex;
    private int mCurrentThemeValue;
    private boolean mIsFromSetupWizard;
    private boolean mIsUserClickCancel;
    private int[] mLauncherPreviewRes;
    private Button mNextStepButton;
    private ImageView mPhoneFrameImage;
    private ImageView mPreviewImage;
    private SelectOptionsView mSelectOptionsView;
    private List<Integer> mThemeSettings;

    public void com_android_settings_GridThemeChooseActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_GridThemeChooseActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_GridThemeChooseActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_GridThemeChooseActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public GridThemeChooseActivity() {
        this.TAG = "GridThemeChooseActivity";
        this.THEME_CLASSIC = 0;
        this.THEME_TRANSPARENT = 1;
        this.mThemeSettings = Arrays.asList(new Integer[]{0, 1});
    }

    static /* synthetic */ boolean access$002(GridThemeChooseActivity r0, boolean r1) {
        r0.mIsUserClickCancel = r1;
        return r1;
    }

    public void com_android_settings_GridThemeChooseActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        setContentView(R.layout.grid_theme_choose_settings_layout);
        int r7 = Utils.getCurrentLauncherMode(this.mContext);
        boolean r0 = !Utils.isDeviceSetupComplete(this);
        this.mIsFromSetupWizard = r0;
        if (r0 == false) goto L5;
        registerWizardFinishReceiver();
    L5:
        this.mPreviewImage = (ImageView) findViewById(R.id.preview_image);
        ImageView r1 = (ImageView) findViewById(R.id.phone_frame);
        this.mPhoneFrameImage = r1;
        if (SettingsFeature.isSupportNewPhoneFrame() == false) goto L8;
        int r2 = Utils.getNewPhoneFrameResId();
    L9:
        r1.setImageResource(r2);
        Button r3 = (Button) findViewById(R.id.next_step_btn);
        this.mNextStepButton = r3;
        if (this.mIsFromSetupWizard == false) goto L12;
        r3.setText(R.string.button_next_step);
    L13:
        this.mNextStepButton.setOnClickListener(this);
        this.mSelectOptionsView = (SelectOptionsView) findViewById(R.id.select_options_view);
        boolean r4 = "gintama".equals(Utils.getDeviceColor());
        if (r7 != 9) goto L16;
        if (r4 == false) goto L37;
        this.mLauncherPreviewRes = new int[0];
        int r8 = R.array.gintama_launcher_9_grid_theme_icons;
    L38:
        SelectOptionsView r5 = this.mSelectOptionsView;
        if (r5 == null) goto L41;
        r5.initView(r8, R.array.launcher_grid_theme_titles, R.dimen.launcher_preview_item_horizontal_margin, R.dimen.selection_option_margin_bottom);
    L41:
        int r9 = android.provider.Settings.Global.getInt(getContentResolver(), "launcher_grid_theme", 0);
        this.mCurrentThemeValue = r9;
        int r10 = this.mThemeSettings.indexOf(Integer.valueOf(r9));
        this.mCurThemeIndex = r10;
        this.mPreviewImage.setImageResource(this.mLauncherPreviewRes[r10]);
        if (this.mIsFromSetupWizard == true) goto L44;
        this.mSelectOptionsView.setOriginIndex(this.mCurThemeIndex);
    L44:
        this.mSelectOptionsView.setSelectedIndex(this.mCurThemeIndex);
        this.mSelectOptionsView.setCallback(this);
        setupBackBtnOnTitle();
        if (this.mIsFromSetupWizard == true) goto L48;
        this.mBackView.setOnClickListener(new AnonymousClass1(this));
        return;
    L48:
        return;
    L37:
        this.mLauncherPreviewRes = new int[0];
        r8 = R.array.launcher_9_grid_theme_icons;
        goto L38
    L16:
        if (r7 == 12) goto L31;
        if (r7 != 16) goto L20;
        if (r4 == false) goto L29;
        this.mLauncherPreviewRes = new int[0];
        r8 = R.array.gintama_launcher_16_grid_theme_icons;
        goto L38
    L29:
        this.mLauncherPreviewRes = new int[0];
        r8 = R.array.launcher_16_grid_theme_icons;
        goto L38
    L20:
        if (r7 == 20) goto L23;
        r8 = 0;
        goto L38
    L23:
        if (SettingsFeature.isSupportNewPhoneFrame() == false) goto L25;
        this.mLauncherPreviewRes = new int[0];
    L26:
        r8 = R.array.launcher_20_grid_theme_icons;
        goto L38
    L25:
        this.mLauncherPreviewRes = new int[0];
        goto L26
    L31:
        if (SettingsFeature.isSupportNewPhoneFrame() == false) goto L33;
        this.mLauncherPreviewRes = new int[0];
    L34:
        r8 = R.array.launcher_12_grid_theme_icons;
        goto L38
    L33:
        this.mLauncherPreviewRes = new int[0];
        goto L34
    L12:
        r3.setText(R.string.lockpattern_confirm_button_text);
        goto L13
    L8:
        r2 = Utils.getPhoneFrameResId();
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        int r0 = this.mThemeSettings.get(this.mCurThemeIndex).intValue();
        if (r3 == this.mNextStepButton) goto L5;
        return;
    L5:
        if (this.mIsFromSetupWizard == false) goto L7;
        android.provider.Settings.Global.putInt(getContentResolver(), "launcher_grid_theme", r0);
        toNextStep();
        return;
    L7:
        finish();
    }

    private void toNextStep() {
        Intent r0 = new Intent();
        if (Utils.isNetworkAvailable(this) == true) goto L5;
    L7:
        r0.setClassName("com.android.settings", "com.android.settings.DateTimeSettingsActivity");
        r0.putExtra(ProvisionConstants.EXTRA_SETUPWIZARD, true);
        r0.putExtra("back_text", getString(R.string.wifi_setup_back));
    L8:
        Utils.startActivity(this, r0);
        return;
    L5:
        if (SettingsFeature.isSmilingCloudAvailable(this) == false) goto L7;
        r0.setClassName("com.bytedanceos.cloudsync", "com.bytedanceos.accounts.AccountsActivity");
        r0.putExtra("bytedance_origin_app_tag", "first_step");
        goto L8
    }

    @Override // com.android.settings.widget.SelectOptionsView.OptionsSelectedCallback
    public void onSelectIndex(int r2) {
        this.mCurThemeIndex = r2;
        this.mPreviewImage.setImageResource(this.mLauncherPreviewRes[r2]);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_GridThemeChooseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(GridThemeChooseActivity r1) {
        com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_PrivacyHook_onCreate(GridThemeChooseActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        GridThemeChooseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_GridThemeChooseActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(GridThemeChooseActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(GridThemeChooseActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        GridThemeChooseActivity r5 = r4;
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
    public static void com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(GridThemeChooseActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_GridThemeChooseActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(GridThemeChooseActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_GridThemeChooseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_PrivacyHook_onResume(GridThemeChooseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        GridThemeChooseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_GridThemeChooseActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(GridThemeChooseActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_PrivacyHook_onPause(GridThemeChooseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        GridThemeChooseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_GridThemeChooseActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(GridThemeChooseActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        GridThemeChooseActivity r5 = r3;
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
    public static void com_android_settings_GridThemeChooseActivity_com_obric_hook_lancet_PrivacyHook_onStop(GridThemeChooseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        GridThemeChooseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_GridThemeChooseActivity__onStop$___twin___();
    }
}
