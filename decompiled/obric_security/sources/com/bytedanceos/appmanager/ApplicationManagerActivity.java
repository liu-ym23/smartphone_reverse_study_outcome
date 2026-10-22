package com.bytedanceos.appmanager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.bytedanceos.powerusage.BatteryEntry;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.Utils;
import com.bytedanceos.security.widget.UpdateButtonView;
import com.bytedanceos.utils.DeviceType;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.safecheck.dataSync.miitAntiFraud.MiitAntiFraudUpdateRequester;
import com.obric.security.R;
import com.obric.security.monitor.PerformanceScenes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class ApplicationManagerActivity extends BaseActivity implements View.OnClickListener {
    private static final String KEY_LAST_UPDATE_TIME = "last_update_time";
    private static final String SP_NAME = "miit_anti_fraud_update";
    private OCardListItem mDoppelganger;
    protected boolean mFromSecurityCenter;
    private OCardListItem mMiitAntiFraudUpdate;
    private OCardListItem mPreferredAppSettings;
    private OCardListItem mViewAppManagement;
    private OCardListItem mViewPermissions;
    private OCardListItem mViewPower;
    private OCardListItem mViewStorage;
    private OCardListItem sysAppInstall;
    private OCardListItem sysAppManager;

    @Override // com.bytedanceos.security.BaseActivity
    protected boolean enablePerformanceActivityResumePeriod() {
        return true;
    }

    @Override // com.bytedanceos.security.BaseActivity
    protected String performancePageScene() {
        return PerformanceScenes.PAGE_PERMISSION_APP_MANAGER;
    }

    @Override // com.bytedanceos.security.BaseActivity
    protected String performanceThreadsSceneOnRealShow() {
        return PerformanceScenes.THREAD_PERMISSION_APP_MANAGER_LOAD;
    }

    public ApplicationManagerActivity() {
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_manager_layout);
        this.mFromSecurityCenter = isFromSecurityCenter();
        OCardListItem r6 = (OCardListItem) findViewById(R.id.item_doppelganger);
        this.mDoppelganger = r6;
        if (r6 == null) goto L5;
        r6.setOnContentClickListener(new ApplicationManagerActivity$$ExternalSyntheticLambda1(this));
    L5:
        this.mDoppelganger.setCardPosition(1);
        this.mDoppelganger.setDefaultTailIcon(0);
        this.mDoppelganger.showTailIcon(true);
        OCardListItem r7 = (OCardListItem) findViewById(R.id.item_preferred_app);
        this.mPreferredAppSettings = r7;
        if (r7 == null) goto L8;
        r7.setOnContentClickListener(new ApplicationManagerActivity$$ExternalSyntheticLambda2(this));
    L8:
        this.mPreferredAppSettings.setDefaultTailIcon(0);
        this.mPreferredAppSettings.showTailIcon(true);
        this.sysAppManager = (OCardListItem) findViewById(R.id.system_app_manager);
        this.sysAppInstall = (OCardListItem) findViewById(R.id.system_app_install);
        this.mMiitAntiFraudUpdate = (OCardListItem) findViewById(R.id.miit_anti_fraud_update);
        if (DeviceType.isN1() == false) goto L11;
    L14:
        this.mPreferredAppSettings.setCardPosition(2);
        this.sysAppManager.setOnContentClickListener(new ApplicationManagerActivity$$ExternalSyntheticLambda3(this));
        this.sysAppManager.setCardPosition(2);
        this.sysAppManager.setDefaultTailIcon(0);
        this.sysAppManager.showTailIcon(true);
        this.sysAppInstall.setOnContentClickListener(new ApplicationManagerActivity$$ExternalSyntheticLambda4(this));
        this.sysAppInstall.setCardPosition(3);
        this.sysAppInstall.setDefaultTailIcon(0);
        this.sysAppInstall.showTailIcon(true);
        this.sysAppManager.setVisibility(0);
        this.sysAppInstall.setVisibility(0);
    L15:
        initMiitAntiFraudUpdateItem();
        OCardListItem r8 = (OCardListItem) findViewById(R.id.item_application_manage);
        this.mViewAppManagement = r8;
        if (r8 == null) goto L18;
        r8.setOnContentClickListener(new ApplicationManagerActivity$$ExternalSyntheticLambda5(this));
    L18:
        this.mViewAppManagement.setCardPosition(2);
        this.mViewAppManagement.setDefaultTailIcon(0);
        this.mViewAppManagement.showTailIcon(true);
        OCardListItem r9 = (OCardListItem) findViewById(R.id.item_permissions);
        this.mViewPermissions = r9;
        if (r9 == null) goto L21;
        r9.setOnContentClickListener(new ApplicationManagerActivity$$ExternalSyntheticLambda6(this));
    L21:
        this.mViewPermissions.setDefaultTailIcon(0);
        this.mViewPermissions.showTailIcon(true);
        OCardListItem r10 = (OCardListItem) findViewById(R.id.item_power);
        this.mViewPower = r10;
        if (r10 == null) goto L24;
        r10.setOnContentClickListener(new ApplicationManagerActivity$$ExternalSyntheticLambda7(this));
    L24:
        this.mViewPower.setDefaultTailIcon(0);
        this.mViewPower.showTailIcon(true);
        OCardListItem r11 = (OCardListItem) findViewById(R.id.item_storage);
        this.mViewStorage = r11;
        if (r11 == null) goto L27;
        r11.setOnContentClickListener(new ApplicationManagerActivity$$ExternalSyntheticLambda8(this));
    L27:
        this.mViewStorage.setDefaultTailIcon(0);
        this.mViewStorage.showTailIcon(true);
        initTitleBar(false, false);
        updateViewWidth(R.id.ll_container);
        getWindow();
        return;
    L11:
        if (DeviceType.isPike() == true) goto L14;
        this.mPreferredAppSettings.setCardPosition(3);
        this.sysAppManager.setVisibility(8);
        this.sysAppInstall.setVisibility(8);
        goto L15
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-bytedanceos-appmanager-ApplicationManagerActivity, reason: not valid java name */
    /* synthetic */ void m77x85a902a3(View r1) {
        navigate(R.id.item_doppelganger);
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-bytedanceos-appmanager-ApplicationManagerActivity, reason: not valid java name */
    /* synthetic */ void m78xaefd57e4(View r1) {
        navigate(R.id.item_preferred_app);
    }

    /* JADX INFO: renamed from: lambda$onCreate$2$com-bytedanceos-appmanager-ApplicationManagerActivity, reason: not valid java name */
    /* synthetic */ void m79xd851ad25(View r1) {
        navigate(R.id.system_app_manager);
    }

    /* JADX INFO: renamed from: lambda$onCreate$3$com-bytedanceos-appmanager-ApplicationManagerActivity, reason: not valid java name */
    /* synthetic */ void m80x1a60266(View r1) {
        navigate(R.id.system_app_install);
    }

    /* JADX INFO: renamed from: lambda$onCreate$4$com-bytedanceos-appmanager-ApplicationManagerActivity, reason: not valid java name */
    /* synthetic */ void m81x2afa57a7(View r1) {
        navigate(R.id.item_application_manage);
    }

    /* JADX INFO: renamed from: lambda$onCreate$5$com-bytedanceos-appmanager-ApplicationManagerActivity, reason: not valid java name */
    /* synthetic */ void m82x544eace8(View r1) {
        navigate(R.id.item_permissions);
    }

    /* JADX INFO: renamed from: lambda$onCreate$6$com-bytedanceos-appmanager-ApplicationManagerActivity, reason: not valid java name */
    /* synthetic */ void m83x7da30229(View r1) {
        navigate(R.id.item_power);
    }

    /* JADX INFO: renamed from: lambda$onCreate$7$com-bytedanceos-appmanager-ApplicationManagerActivity, reason: not valid java name */
    /* synthetic */ void m84xa6f7576a(View r1) {
        navigate(R.id.item_storage);
    }

    private void initMiitAntiFraudUpdateItem() {
        this.mMiitAntiFraudUpdate.setVisibility(0);
        this.mMiitAntiFraudUpdate.setCardPosition(0);
        this.mMiitAntiFraudUpdate.setCustomEndView(createMiitAntiFraudUpdateButton());
        this.mMiitAntiFraudUpdate.showCustomEnd(true);
        this.mMiitAntiFraudUpdate.setOnContentClickListener(null);
        refreshMiitAntiFraudLastUpdateSubtitle();
    }

    private View createMiitAntiFraudUpdateButton() {
        UpdateButtonView r0 = new UpdateButtonView(this);
        r0.setText(R.string.update);
        r0.setOnClickListener(new ApplicationManagerActivity$$ExternalSyntheticLambda0(this));
        return r0;
    }

    /* JADX INFO: renamed from: lambda$createMiitAntiFraudUpdateButton$8$com-bytedanceos-appmanager-ApplicationManagerActivity, reason: not valid java name */
    /* synthetic */ void m76xffa15450(View r1) {
        updateMiitAntiFraudDatabase();
    }

    private void updateMiitAntiFraudDatabase() {
        MiitAntiFraudUpdateRequester.requestUpdateList();
        getSharedPreferences(SP_NAME, 0).edit().putLong(KEY_LAST_UPDATE_TIME, System.currentTimeMillis()).apply();
        refreshMiitAntiFraudLastUpdateSubtitle();
    }

    private void refreshMiitAntiFraudLastUpdateSubtitle() {
        long r6 = getSharedPreferences(SP_NAME, 0).getLong(KEY_LAST_UPDATE_TIME, 0);
        if (r6 > 0) goto L5;
        r6 = System.currentTimeMillis();
        getSharedPreferences(SP_NAME, 0).edit().putLong(KEY_LAST_UPDATE_TIME, r6).apply();
    L5:
        String r0 = new SimpleDateFormat("HH 时 mm 分", Locale.CHINA).format(new Date(r6));
        this.mMiitAntiFraudUpdate.setSubTitle(getString(R.string.miit_anti_fraud_last_update, new Object[]{r0}));
        this.mMiitAntiFraudUpdate.showSubTitle(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        navigate(view.getId());
    }

    private void navigate(int itemId) {
        Intent r0 = new Intent();
        r0.setAction("android.intent.action.MAIN");
        r0.putExtra("back_text_res_name", "manager_application");
        r0.putExtra(Utils.INTENT_KEY_FROM_CENTER, this.mFromSecurityCenter);
        switch(itemId) {
            case 2131297153: goto L15;
            case 2131297159: goto L12;
            case 2131297161: goto L10;
            case 2131297162: goto L9;
            case 2131297163: goto L8;
            case 2131297168: goto L7;
            case 2131298065: goto L6;
            case 2131298066: goto L5;
            default: goto L21;
        };
    L5:
        r0.setAction("com.obric.action.settings.SYSAPP_UPDATE");
        goto L21
    L6:
        r0.setAction("com.obric.action.settings.RESTORE_SYSAPP");
        goto L21
    L7:
        r0.setClassName("com.obric.security", "com.bytedanceos.storage.StorageActivity");
        r0.putExtra("from_where", "3");
        goto L21
    L8:
        r0.setAction("android.settings.MANAGE_DEFAULT_APPS_SETTINGS");
        r0.setClassName(BatteryEntry.SETTING_PACKAGE, "com.android.settings.applications.PreferredActivityCategory");
        goto L21
    L9:
        r0.setClassName("com.obric.security", "com.obric.security.battertpower.BatteryPowerActivity");
        goto L21
    L10:
        r0.setClassName("com.obric.security", "com.bytedanceos.security.PermissionCategoryActivity");
        goto L21
    L15:
        r0.setClassName(BatteryEntry.SETTING_PACKAGE, "com.android.settings.applications.ManageApplicationsActivity");
    L21:
        startActivity(r0);     // Catch: Exception -> L18
        TransitionAnimHelper.overrideEnterAnim(this, TransitionAnimStyle.Standard);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L12:
        if (Utils.getSettingSupportVersion(this) <= 0) goto L14;
        r0.setClassName(BatteryEntry.SETTING_PACKAGE, "com.android.settings.Settings$DoppelgangerSettingsActivity");
        goto L21
    L14:
        r0.setClassName(BatteryEntry.SETTING_PACKAGE, "com.android.settings.AdapterActivity");
        r0.putExtra("extra_target", "start_settings_activity");
        r0.putExtra("extra_activity", "com.android.settings.Settings$DoppelgangerSettingsActivity");
        goto L21
    }

    @Override // com.bytedanceos.security.BaseActivity
    public void updateViewWidth(int viewId) {
        super.updateViewWidth(viewId);
        if (this.mFromSecurityCenter == false) goto L5;
        return;
    L5:
        if (Utils.isNeedSetWidth(this) == false) goto L9;
        this.mTitleBarBackView.setVisibility(4);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateViewWidth(R.id.ll_container);
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.bytedanceos.security.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
    }
}
