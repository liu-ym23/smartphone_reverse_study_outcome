package com.android.settings.applications;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.service.voice.VoiceInteractionServiceInfo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.internal.app.AssistUtils;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.applications.DefaultAppInfo;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ManageAssist extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    private OCardListItem itemAccessScreen;
    private OCardListItem itemChoose;
    private OCardListItem itemFlashScreen;
    private OCardListItem itemScreenshot;
    private AssistUtils mAssistUtils;
    private Intent mIntent;
    protected PackageManager mPackageManager;
    protected int mUserId;
    protected UserManager mUserManager;

    public void com_android_settings_applications_ManageAssist__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_applications_ManageAssist__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_ManageAssist_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_ManageAssist_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ManageAssist() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.fragment_fake_manage_assist, r3, false);
        this.itemChoose = (OCardListItem) this.mRootView.findViewById(R.id.itemChoose);
        this.itemAccessScreen = (OCardListItem) this.mRootView.findViewById(R.id.itemAccessScreen);
        this.itemScreenshot = (OCardListItem) this.mRootView.findViewById(R.id.itemScreenshot);
        this.itemFlashScreen = (OCardListItem) this.mRootView.findViewById(R.id.itemFlashScreen);
        this.mPackageManager = this._mActivity.getPackageManager();
        this.mUserManager = (UserManager) this._mActivity.getSystemService(PickApplicationActivity.EXTRA_USER);
        this.mUserId = UserHandle.myUserId();
        this.mAssistUtils = new AssistUtils(this._mActivity);
        String r5 = this.mPackageManager.getPermissionControllerPackageName();
        if (TextUtils.isEmpty(r5) == true) goto L5;
        this.mIntent = new Intent("android.intent.action.MANAGE_DEFAULT_APP").setPackage(r5).putExtra("android.intent.extra.ROLE_NAME", "android.app.role.ASSISTANT");
    L5:
        this.itemChoose.setOnContentClickListener(new ManageAssist$$ExternalSyntheticLambda0(this));
        return this.mRootView;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-applications-ManageAssist, reason: not valid java name */
    /* synthetic */ void m303x2dd2b973(View r1) {
        if (this.mIntent == null) goto L6;
        Utils.startActivity(this._mActivity, this.mIntent);
        return;
    L6:
        if (getSettingIntent() == null) goto L10;
        Utils.startActivity(this._mActivity, getSettingIntent());
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        if (this.mTitleView == null) goto L6;
        this.mTitleView.setCenterTitle(R.string.assist_and_voice_input_title);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateUI();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateUI();
    }

    private void updateUI() {
        updateItemChoose();
        updateAccessScreen();
        updateScreenshot();
        updateFlashScreen();
        OCardListItemUtils.updateGroupContainer(new OCardListItem[]{this.itemChoose, this.itemAccessScreen, this.itemScreenshot, this.itemFlashScreen});
    }

    private void updateItemChoose() {
        DefaultAppInfo r0 = getDefaultAppInfo();
        this.itemChoose.setTitle(this._mActivity.getString(R.string.default_assist_title));
        this.itemChoose.getTitleView().setId(android.R.id.title);
        this.itemChoose.getSubTitleView().setId(android.R.id.summary);
        if (r0 != null) goto L6;
        this.itemChoose.setSubTitle(this._mActivity.getString(R.string.default_assist_none));
        this.itemChoose.showSubTitle(true);
        this.itemChoose.showIcon(false);
        this.itemAccessScreen.setEnabled(false);
        this.itemAccessScreen.setVisibility(8);
        this.itemScreenshot.setEnabled(false);
        this.itemScreenshot.setVisibility(8);
        this.itemFlashScreen.setEnabled(false);
        this.itemFlashScreen.setVisibility(8);
        return;
    L6:
        this.itemChoose.setSubTitle(r0.loadLabel());
        this.itemChoose.showSubTitle(true);
        this.itemChoose.showTitle(true);
        this.itemChoose.setIcon(r0.loadIcon());
        this.itemChoose.showIcon(true);
        this.itemAccessScreen.setVisibility(0);
        this.itemScreenshot.setVisibility(0);
        this.itemFlashScreen.setVisibility(0);
    }

    private void updateAccessScreen() {
        if (this.mAssistUtils.getAssistComponentForUser(UserHandle.myUserId()) == null) goto L5;
        boolean r0 = true;
    L6:
        this.itemAccessScreen.setEnabled(r0);
        this.itemAccessScreen.setTitle(this._mActivity.getString(R.string.assist_access_context_title));
        this.itemAccessScreen.showTitle(true);
        this.itemAccessScreen.setSubTitle(this._mActivity.getString(R.string.assist_access_context_summary));
        this.itemAccessScreen.showSubTitle(true);
        OSwitch r1 = this.itemAccessScreen.getEndSwitch();
        if (r1 == null) goto L9;
        r1.setChecked(isAccessScreenChecked(this._mActivity));
        r1.setOnCheckedChangeListener(this);
    L9:
        this.itemAccessScreen.getTitleView().setId(android.R.id.title);
        this.itemAccessScreen.getSubTitleView().setId(android.R.id.summary);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void updateScreenshot() {
        if (this.mAssistUtils.getAssistComponentForUser(UserHandle.myUserId()) != null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.itemScreenshot.setEnabled(r0);
        this.itemScreenshot.setTitle(this._mActivity.getString(R.string.assist_access_screenshot_title));
        this.itemScreenshot.showTitle(true);
        this.itemScreenshot.setSubTitle(this._mActivity.getString(R.string.assist_access_screenshot_summary));
        this.itemScreenshot.showSubTitle(true);
        OSwitch r1 = this.itemScreenshot.getEndSwitch();
        if (r1 == null) goto L11;
        r1.setChecked(isScreenshotChecked(this._mActivity));
        r1.setOnCheckedChangeListener(this);
    L11:
        this.itemScreenshot.getTitleView().setId(android.R.id.title);
        this.itemScreenshot.getSubTitleView().setId(android.R.id.summary);
        return;
    L5:
        if (isAccessScreenChecked(this._mActivity) == false) goto L7;
        r0 = true;
        goto L8
    }

    private void updateFlashScreen() {
        if (getCurrentAssist() != null) goto L5;
    L9:
        boolean r0 = false;
    L10:
        this.itemFlashScreen.setEnabled(r0);
        this.itemFlashScreen.setTitle(this._mActivity.getString(R.string.assist_flash_title));
        this.itemFlashScreen.showTitle(true);
        this.itemFlashScreen.setSubTitle(this._mActivity.getString(R.string.assist_flash_summary));
        this.itemFlashScreen.showSubTitle(true);
        OSwitch r1 = this.itemFlashScreen.getEndSwitch();
        if (r1 == null) goto L13;
        r1.setChecked(isFlashScreenChecked());
        r1.setOnCheckedChangeListener(this);
    L13:
        this.itemFlashScreen.getTitleView().setId(android.R.id.title);
        this.itemFlashScreen.getSubTitleView().setId(android.R.id.summary);
        return;
    L5:
        if (isPreInstalledAssistant(getCurrentAssist()) == false) goto L9;
        if (isAccessScreenChecked(this._mActivity) == false) goto L9;
        r0 = true;
        goto L10
    }

    static boolean isAccessScreenChecked(Context r2) {
        if (Settings.Secure.getInt(r2.getContentResolver(), "assist_structure_enabled", 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    static void setAccessScreenChecked(Context r1, boolean r2) {
        Settings.Secure.putInt(r1.getContentResolver(), "assist_structure_enabled", r2 ? 1 : 0);
    }

    static boolean isScreenshotChecked(Context r2) {
        if (Settings.Secure.getInt(r2.getContentResolver(), "assist_screenshot_enabled", 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    static void setScreenshotChecked(Context r1, boolean r2) {
        Settings.Secure.putInt(r1.getContentResolver(), "assist_screenshot_enabled", r2 ? 1 : 0);
    }

    boolean isFlashScreenChecked() {
        ComponentName r0 = getCurrentAssist();
        if (r0 != null) goto L7;
        return false;
    L7:
        return AssistUtils.shouldDisclose(this.mContext, r0);
    }

    void setFlashScreenChecked(Context r1, boolean r2) {
        if (getCurrentAssist() == null) goto L6;
        Settings.Secure.putInt(this.mContext.getContentResolver(), "assist_disclosure_enabled", r2 ? 1 : 0);
        return;
    }

    private ComponentName getCurrentAssist() {
        return this.mAssistUtils.getAssistComponentForUser(UserHandle.myUserId());
    }

    boolean allowDisablingAssistDisclosure() {
        return AssistUtils.allowDisablingAssistDisclosure(this.mContext);
    }

    boolean isPreInstalledAssistant(ComponentName r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return AssistUtils.isPreinstalledAssistant(this.mContext, r1);
    }

    boolean willShowFlash(ComponentName r1) {
        return AssistUtils.shouldDisclose(this.mContext, r1);
    }

    protected Intent getSettingIntent() {
        ComponentName r0 = this.mAssistUtils.getAssistComponentForUser(this.mUserId);
        if (r0 != null) goto L5;
        return null;
    L5:
        Intent r2 = new Intent("android.service.voice.VoiceInteractionService").setPackage(r0.getPackageName());
        List<ResolveInfo> r3 = this.mPackageManager.queryIntentServices(r2, 128);
        if (r3 != null) goto L8;
    L15:
        return null;
    L8:
        if (r3.isEmpty() == true) goto L15;
        String r5 = getAssistSettingsActivity(r0, r3.get(0), this.mPackageManager);
        if (r5 != null) goto L14;
        return null;
    L14:
        return new Intent("android.intent.action.MAIN").setComponent(new ComponentName(r0.getPackageName(), r5));
    }

    protected DefaultAppInfo getDefaultAppInfo() {
        ComponentName r0 = this.mAssistUtils.getAssistComponentForUser(this.mUserId);
        if (r0 != null) goto L7;
        return null;
    L7:
        return new DefaultAppInfo(this.mContext, this.mPackageManager, this.mUserId, r0);
    }

    String getAssistSettingsActivity(ComponentName r1, ResolveInfo r2, PackageManager r3) {
        VoiceInteractionServiceInfo r0 = new VoiceInteractionServiceInfo(r3, r2.serviceInfo);
        if (r0.getSupportsAssist() == true) goto L7;
        return null;
    L7:
        return r0.getSettingsActivity();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.itemAccessScreen.getEndSwitch()) goto L6;
        setAccessScreenChecked(this._mActivity, r3);
    L11:
        updateUI();
        return;
    L6:
        if (r2 != this.itemScreenshot.getEndSwitch()) goto L9;
        setScreenshotChecked(this._mActivity, r3);
        goto L11
    L9:
        if (r2 != this.itemFlashScreen.getEndSwitch()) goto L11;
        setFlashScreenChecked(this._mActivity, r3);
        goto L11
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_ManageAssist_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ManageAssist r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ManageAssist__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ManageAssist_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ManageAssist r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_ManageAssist_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ManageAssist_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ManageAssist r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ManageAssist__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
