package com.android.settings.deviceinfo;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.Utils;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class StoragePathDetailActivity extends BaseActivity implements View.OnClickListener {
    private static final String EXTRA_FROM_BACKUP = "from_backup";
    private int mCurrentPosition;
    private SettingItemCheck mPopupExternalStorage;
    private SettingItemCheck mPopupInternalStorage;
    private String[] mPreferredCategoryTitle;
    private String[] mPreferredStoragePathTip;
    private TextView mPreferredStoragePathTipView;
    private TextView mSdPreferredStoragePathTipView;
    private OFloatingTitleBar mTitle;
    private SharedPreferences preferences;

    public void com_android_settings_deviceinfo_StoragePathDetailActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_deviceinfo_StoragePathDetailActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_deviceinfo_StoragePathDetailActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_deviceinfo_StoragePathDetailActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public StoragePathDetailActivity() {
    }

    public void com_android_settings_deviceinfo_StoragePathDetailActivity__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        if (SettingsFeature.isSdMounted() == true) goto L5;
        finish();
    L5:
        setContentView(R.layout.storage_path_detail);
        this.mTitle = setupBackBtnOnTitle(false);
        this.mPreferredCategoryTitle = getResources().getStringArray(R.array.preferred_storage_path);
        this.mPreferredStoragePathTip = getResources().getStringArray(R.array.preferred_storage_path_tip);
        initViews();
        registerUnmountReceiver();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        int r3 = r2.getId();
        if (r3 != R.id.popup_external_storage) goto L5;
        int r4 = 1;
    L9:
        updatePopupSettingsViews(r4);
        setPopupMode(r4);
        return;
    L5:
        if (r3 == R.id.popup_internal_storage) goto L7;
        r4 = -1;
        goto L9
    L7:
        r4 = 0;
        goto L9
    }

    private void initViews() {
        this.preferences = getSharedPreferences(getPackageName(), 0);
        Intent r0 = getIntent();
        if (r0.hasExtra(StorageUtils.CURRENT_POSITION) == false) goto L11;
        int r4 = r0.getIntExtra(StorageUtils.CURRENT_POSITION, -1);
        this.mCurrentPosition = r4;
        if (r4 != (-1)) goto L11;
        this.mCurrentPosition = Integer.parseInt(r0.getStringExtra(StorageUtils.CURRENT_POSITION));     // Catch: NumberFormatException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
    L11:
        if (r0.hasExtra(EXTRA_FROM_BACKUP) == false) goto L13;
        this.mTitle.setCenterTitle(Utils.getPackageString(this, Constants.PKG_BACKUP, "local_backup_storage_path"));
        getIntent().getBooleanExtra("from_search", false);
    L14:
        this.mPopupInternalStorage = (SettingItemCheck) findViewById(R.id.popup_internal_storage);
        this.mPopupExternalStorage = (SettingItemCheck) findViewById(R.id.popup_external_storage);
        this.mPopupInternalStorage.setOnClickListener(this);
        this.mPopupExternalStorage.setOnClickListener(this);
        this.mPreferredStoragePathTipView = (TextView) findViewById(R.id.preferred_item_tip);
        this.mSdPreferredStoragePathTipView = (TextView) findViewById(R.id.sd_preferred_item_tip);
        updatePopupSettingsViews(getPopupMode());
        this.mPreferredStoragePathTipView.setText(this.mPreferredStoragePathTip[this.mCurrentPosition]);
        return;
    L13:
        this.mTitle.setCenterTitle(this.mPreferredCategoryTitle[this.mCurrentPosition]);
        goto L14
    }

    private void updatePopupSettingsViews(int r5) {
        SettingItemCheck r0 = this.mPopupInternalStorage;
        if (r5 != 0) goto L5;
        boolean r3 = true;
    L6:
        r0.setChecked(r3);
        SettingItemCheck r1 = this.mPopupExternalStorage;
        if (r5 != 1) goto L9;
        boolean r4 = true;
    L10:
        r1.setChecked(r4);
        if (r5 != 1) goto L13;
        this.mSdPreferredStoragePathTipView.setVisibility(0);
        return;
    L13:
        this.mSdPreferredStoragePathTipView.setVisibility(8);
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    private int getPopupMode() {
        return StorageUtils.getStoragePathValue(this, this.mCurrentPosition);
    }

    private void setPopupMode(int r3) {
        StorageUtils.putStoragePathValue(this, this.mCurrentPosition, r3, true);
    }

    private void registerUnmountReceiver() {
        IntentFilter r0 = new IntentFilter("android.intent.action.MEDIA_UNMOUNTED");
        r0.addDataScheme("file");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.sdUnmountReceiver, r0);
    }

    public void com_android_settings_deviceinfo_StoragePathDetailActivity__onDestroy$___twin___() {
        super.onDestroy();
        unregisterReceiver(this.sdUnmountReceiver);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_deviceinfo_StoragePathDetailActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(StoragePathDetailActivity r1) {
        com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_PrivacyHook_onCreate(StoragePathDetailActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        StoragePathDetailActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_deviceinfo_StoragePathDetailActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(StoragePathDetailActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(StoragePathDetailActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        StoragePathDetailActivity r5 = r4;
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
    public static void com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(StoragePathDetailActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_deviceinfo_StoragePathDetailActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(StoragePathDetailActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_deviceinfo_StoragePathDetailActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_PrivacyHook_onResume(StoragePathDetailActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        StoragePathDetailActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_deviceinfo_StoragePathDetailActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(StoragePathDetailActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_PrivacyHook_onPause(StoragePathDetailActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        StoragePathDetailActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_deviceinfo_StoragePathDetailActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(StoragePathDetailActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        StoragePathDetailActivity r5 = r3;
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
    public static void com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_PrivacyHook_onStop(StoragePathDetailActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        StoragePathDetailActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_deviceinfo_StoragePathDetailActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_deviceinfo_StoragePathDetailActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(StoragePathDetailActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        StoragePathDetailActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_deviceinfo_StoragePathDetailActivity__onDestroy$___twin___();
    }
}
