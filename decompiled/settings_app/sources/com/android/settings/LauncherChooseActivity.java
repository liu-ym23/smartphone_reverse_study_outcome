package com.android.settings;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import bytedanceos.api.SettingsSmt;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SelectOptionsView;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class LauncherChooseActivity extends BaseActivity implements View.OnClickListener, SelectOptionsView.OptionsSelectedCallback {
    private static final String BYTEDANCE_LAUNCHER_PKG_NAME = "com.bytedanceos.launcher";
    private final String TAG;
    private int mCurrentLauncherIndex;
    IntentFilter mHomeFilter;
    Intent mIntentHome;
    private boolean mIsFromSetupWizard;
    private boolean mIsUserClickCancel;
    private List<Integer> mLauncherModeValues;
    private ArrayList<Integer> mLauncherPreviewRes;
    private int mNewLauncherMode;
    private int mNewMultiBlockMode;
    private Button mNextStepButton;
    private int mOldLauncherMode;
    private ImageView mPhoneFrameImage;
    PackageManager mPm;
    private ImageView mPreviewImage;
    private int[] mPreviewResource;
    private SelectOptionsView mSelectOptionsView;

    public void com_android_settings_LauncherChooseActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_LauncherChooseActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_LauncherChooseActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_LauncherChooseActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public LauncherChooseActivity() {
        this.TAG = "LauncherChooseActivity";
        this.mLauncherModeValues = new ArrayList();
        this.mLauncherPreviewRes = new ArrayList();
    }

    static /* synthetic */ boolean access$002(LauncherChooseActivity r0, boolean r1) {
        r0.mIsUserClickCancel = r1;
        return r1;
    }

    static /* synthetic */ int access$100(LauncherChooseActivity r0) {
        return r0.mNewLauncherMode;
    }

    static /* synthetic */ void access$200(LauncherChooseActivity r0) {
        r0.toNextStep();
    }

    public void com_android_settings_LauncherChooseActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.launcher_choose_settings_layout);
        IntentFilter r6 = new IntentFilter("android.intent.action.MAIN");
        this.mHomeFilter = r6;
        r6.addCategory("android.intent.category.HOME");
        this.mHomeFilter.addCategory("android.intent.category.DEFAULT");
        Intent r7 = new Intent("android.intent.action.MAIN");
        this.mIntentHome = r7;
        r7.addCategory("android.intent.category.HOME");
        this.mIntentHome.addCategory("android.intent.category.DEFAULT");
        int r8 = Utils.getCurrentLauncherMode(this.mContext);
        this.mOldLauncherMode = r8;
        this.mNewLauncherMode = r8;
        this.mNewMultiBlockMode = Utils.getCurrentLauncherMultiBlockMode(this.mContext);
        this.mPm = getPackageManager();
        boolean r9 = !Utils.isDeviceSetupComplete(this);
        this.mIsFromSetupWizard = r9;
        if (r9 == false) goto L5;
        registerWizardFinishReceiver();
    L5:
        this.mPreviewImage = (ImageView) findViewById(R.id.preview_image);
        ImageView r10 = (ImageView) findViewById(R.id.phone_frame);
        this.mPhoneFrameImage = r10;
        if (SettingsFeature.isSupportNewPhoneFrame() == false) goto L8;
        int r0 = Utils.getNewPhoneFrameResId();
    L9:
        r10.setImageResource(r0);
        Button r11 = (Button) findViewById(R.id.next_step_btn);
        this.mNextStepButton = r11;
        if (this.mIsFromSetupWizard == false) goto L12;
        r11.setText(R.string.button_next_step);
    L13:
        this.mNextStepButton.setOnClickListener(this);
        this.mSelectOptionsView = (SelectOptionsView) findViewById(R.id.select_options_view);
        this.mLauncherModeValues.clear();
        this.mLauncherPreviewRes.clear();
        ArrayList<Drawable> r12 = new ArrayList();
        ArrayList<String> r1 = new ArrayList();
        "gintama".equals(Utils.getDeviceColor());
        if (SettingsFeature.isLauncher12GridsSupport() == false) goto L16;
        this.mLauncherModeValues.add(12);
        r1.add(getString(R.string.mode_bytedance_launcher_12_grids));
    L18:
        if (SettingsFeature.LAUNCHER_4X5_SUPPORTED == false) goto L20;
        r1.add(getString(R.string.mode_bytedance_launcher_20_grids));
        this.mLauncherModeValues.add(20);
    L21:
        this.mSelectOptionsView.initView(r12, r1, R.dimen.launcher_preview_item_horizontal_margin, R.dimen.selection_option_margin_bottom);
        int r13 = this.mLauncherModeValues.indexOf(Integer.valueOf(this.mOldLauncherMode));
        this.mCurrentLauncherIndex = r13;
        if (r13 != (-1)) goto L37;
        this.mCurrentLauncherIndex = this.mLauncherModeValues.size() - 1;
    L37:
        this.mPreviewImage.setImageResource(this.mLauncherPreviewRes.get(this.mCurrentLauncherIndex).intValue());     // Catch: IndexOutOfBoundsException -> L26
    L29:
        if (this.mIsFromSetupWizard == true) goto L31;
        this.mSelectOptionsView.setOriginIndex(this.mCurrentLauncherIndex);
    L31:
        this.mSelectOptionsView.setSelectedIndex(this.mCurrentLauncherIndex);
        this.mSelectOptionsView.setCallback(this);
        if (this.mIsFromSetupWizard == false) goto L34;
        return;
    L34:
        if (this.mBackView == null) goto L40;
        this.mBackView.setOnClickListener(new AnonymousClass1(this));
        return;
    L40:
        return;
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L20:
        r1.add(getString(R.string.mode_bytedance_launcher_16_grids));
        this.mLauncherModeValues.add(16);
        goto L21
    L16:
        this.mLauncherModeValues.add(9);
        r1.add(getString(R.string.mode_bytedance_launcher_9_grids));
        goto L18
    L12:
        r11.setText(R.string.lockpattern_confirm_button_text);
        goto L13
    L8:
        r0 = Utils.getPhoneFrameResId();
        goto L9
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.android.settings.LauncherChooseActivity$2] */
    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 == this.mNextStepButton) goto L5;
        return;
    L5:
        if (this.mIsFromSetupWizard == false) goto L9;
        setDefaultLauncherMode();
        setupDefaultMultiBlockMode();
        new AnonymousClass2(this).execute(new Void[0]);
        return;
    }

    public static void notifyLauncherModeChanged(Context r3, int r4) {
        Bundle r0 = new Bundle();     // Catch: Exception -> L4
        r0.putInt("bytedance_launcher_user_select", r4);     // Catch: Exception -> L4
        Uri r5 = Uri.parse("content://com.bytedanceos.launcher.exportprovider");     // Catch: Exception -> L4
        r3.getContentResolver().call(r5, "", null, r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private String getMessage(int r2, int r3) {
        if (r2 != 9) goto L9;
        if (r3 != SettingsSmt.get_LAUNCHER_MODE_VALUE_LAUNCHER_MODE_GRIDS_16()) goto L9;
        return getString(R.string.dlg_switch_launcher_msg_9_grids);
    L9:
        return getString(R.string.dlg_switch_launcher_msg);
    }

    private void setLauncherGridsCount(int r3, int r4) {
        android.provider.Settings.Global.putInt(getContentResolver(), "launcher_grids_x", r3);
        android.provider.Settings.Global.putInt(getContentResolver(), "launcher_grids_y", r4);
    }

    public void setupDefaultMultiBlockMode() {
        android.provider.Settings.Global.putInt(getContentResolver(), "multi_block_mode", this.mNewMultiBlockMode);
    }

    public void setDefaultLauncherMode() {
        android.provider.Settings.Global.putInt(getContentResolver(), "launcher_mode", this.mNewLauncherMode);
        int r0 = this.mNewLauncherMode;
        if (r0 != 9) goto L5;
        setLauncherGridsCount(3, 3);
        return;
    L5:
        if (r0 != 12) goto L7;
        setLauncherGridsCount(3, 4);
        return;
    L7:
        if (r0 != 16) goto L9;
        setLauncherGridsCount(4, 4);
        return;
    L9:
        if (r0 != 20) goto L19;
        setLauncherGridsCount(4, 5);
        return;
    }

    private void toNextStep() {
        Utils.startActivity(this, new Intent(this, GridThemeChooseActivity.class));
    }

    @Override // com.android.settings.widget.SelectOptionsView.OptionsSelectedCallback
    public void onSelectIndex(int r3) {
        this.mCurrentLauncherIndex = r3;
        int r0 = this.mLauncherModeValues.get(r3).intValue();
        if (r0 != 9) goto L5;
        this.mNewLauncherMode = 9;
        this.mNewMultiBlockMode = 36;
    L15:
        this.mPreviewImage.setImageResource(this.mLauncherPreviewRes.get(r3).intValue());
        return;
    L5:
        if (r0 != 12) goto L7;
        this.mNewLauncherMode = 12;
        this.mNewMultiBlockMode = 48;
        goto L15
    L7:
        if (r0 != 16) goto L9;
        this.mNewLauncherMode = 16;
        this.mNewMultiBlockMode = 64;
        goto L15
    L9:
        if (r0 != 20) goto L15;
        this.mNewLauncherMode = 20;
        this.mNewMultiBlockMode = 80;
        goto L15
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_LauncherChooseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(LauncherChooseActivity r1) {
        com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_PrivacyHook_onCreate(LauncherChooseActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LauncherChooseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_LauncherChooseActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(LauncherChooseActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(LauncherChooseActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        LauncherChooseActivity r5 = r4;
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
    public static void com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(LauncherChooseActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_LauncherChooseActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(LauncherChooseActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_LauncherChooseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_PrivacyHook_onResume(LauncherChooseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LauncherChooseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_LauncherChooseActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(LauncherChooseActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_PrivacyHook_onPause(LauncherChooseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LauncherChooseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_LauncherChooseActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(LauncherChooseActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        LauncherChooseActivity r5 = r3;
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
    public static void com_android_settings_LauncherChooseActivity_com_obric_hook_lancet_PrivacyHook_onStop(LauncherChooseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LauncherChooseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_LauncherChooseActivity__onStop$___twin___();
    }
}
