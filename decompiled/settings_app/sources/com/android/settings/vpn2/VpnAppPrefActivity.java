package com.android.settings.vpn2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.VpnManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.net.VpnConfig;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import java.util.function.Function;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class VpnAppPrefActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {
    private OCardListItem mAlwaysOn;
    private ImageView mAppIcon;
    private TextView mAppName;
    private TextView mAppVersion;
    private OButton mCancelBtn;
    private ConnectivityManager mConnectivityManager;
    private String mLabel;
    private OCardListItem mLockdownVpn;
    private PackageInfo mPackageInfo;
    private OSwitch mSwitchAlwaysOn;
    private OSwitch mSwitchLockdownVpnOn;
    private int mUserId;
    private VpnManager mVpnManager;

    public void com_android_settings_vpn2_VpnAppPrefActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_vpn2_VpnAppPrefActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_vpn2_VpnAppPrefActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_vpn2_VpnAppPrefActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public VpnAppPrefActivity() {
        this.mUserId = UserHandle.myUserId();
    }

    static /* synthetic */ void access$000(VpnAppPrefActivity r0) {
        r0.promptToCancel();
    }

    static /* synthetic */ void access$100(VpnAppPrefActivity r0) {
        r0.onForget();
    }

    public void com_android_settings_vpn2_VpnAppPrefActivity__onCreate$___twin___(Bundle r9) {
        super.onCreate(r9);
        setContentView(R.layout.vpn_app_config_activity_layout);
        this.mPackageInfo = (PackageInfo) getIntent().getParcelableExtra(VpnSettings.EXTRA_APP_PACKINFO);
        this.mConnectivityManager = (ConnectivityManager) getSystemService("connectivity");
        this.mVpnManager = (VpnManager) getSystemService("vpn_management");
        setupBackBtnOnTitle(false);
        Drawable r1 = null;
        String r2 = null;
        if (this.mBackView != null) goto L5;
        this.mBackView = this.mTitle.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
        this.mBackView.setOnClickListener(new AnonymousClass1(this));
    L5:
        this.mAppIcon = (ImageView) findViewById(R.id.app_icon);
        this.mAppName = (TextView) findViewById(R.id.app_name);
        this.mAppVersion = (TextView) findViewById(R.id.app_version);
        OCardListItem r0 = (OCardListItem) findViewById(R.id.item_vpn_always_on);
        this.mAlwaysOn = r0;
        OSwitch r3 = r0.getEndSwitch();
        this.mSwitchAlwaysOn = r3;
        r3.setClickable(true);
        this.mAlwaysOn.setEnabled(false);
        this.mSwitchAlwaysOn.setChecked(isVpnAlwaysOn());
        this.mSwitchAlwaysOn.setOnCheckedChangeListener(this);
        OCardListItem r4 = (OCardListItem) findViewById(R.id.lockdown_vpn);
        this.mLockdownVpn = r4;
        this.mSwitchLockdownVpnOn = r4.getEndSwitch();
        this.mLockdownVpn.setEnabled(false);
        this.mSwitchLockdownVpnOn.setOnCheckedChangeListener(this);
        PackageManager r5 = getPackageManager();
        PackageInfo r6 = this.mPackageInfo;     // Catch: PackageManager.NameNotFoundException -> L17
        if (r6 == null) goto L11;
        Drawable r7 = r6.applicationInfo.loadIcon(r5);     // Catch: PackageManager.NameNotFoundException -> L17
        this.mLabel = VpnConfig.getVpnLabel(this, this.mPackageInfo.packageName).toString();     // Catch: PackageManager.NameNotFoundException -> L16
        r2 = this.mPackageInfo.versionName;     // Catch: PackageManager.NameNotFoundException -> L16
        int r8 = UserHandle.getUserId(this.mPackageInfo.applicationInfo.uid);     // Catch: PackageManager.NameNotFoundException -> L16
        this.mUserId = r8;     // Catch: PackageManager.NameNotFoundException -> L16
        this.mAlwaysOn.setEnabled(this.mVpnManager.isAlwaysOnVpnPackageSupportedForUser(r8, this.mPackageInfo.packageName));     // Catch: PackageManager.NameNotFoundException -> L16
        updateUI();     // Catch: PackageManager.NameNotFoundException -> L16
    L10:
        String r10 = r2;
        r1 = r7;
    L12:
        if (r1 != null) goto L14;
        r1 = r5.getDefaultActivityIcon();
    L14:
        Glide.with(this.mContext).load(r1).transform(new CircleCrop()).into(this.mAppIcon);
        this.mAppName.setText(this.mLabel);
        this.mAppVersion.setText(getString(R.string.version_text, new Object[]{String.valueOf(r10)}));
        OButton r11 = (OButton) findViewById(R.id.cancel_vpn);
        this.mCancelBtn = r11;
        r11.setOnClickListener(new AnonymousClass2(this));
        return;
    L11:
        r10 = null;
        goto L12
    }

    private void onForget() {
        int r0 = UserHandle.getUserId(this.mPackageInfo.applicationInfo.uid);
        this.mVpnManager.setVpnPackageAuthorization(this.mPackageInfo.packageName, r0, -1);
        onDisconnect();
    }

    private void onDisconnect() {
        int r0 = UserHandle.getUserId(this.mPackageInfo.applicationInfo.uid);
        VpnConfig r1 = this.mVpnManager.getVpnConfig(r0);     // Catch: RemoteException -> L13
        if (r1 != null) goto L6;
    L11:
        setAlwaysOnVpnByUI(false);     // Catch: RemoteException -> L13
        return;
    L6:
        if (r1.legacy == true) goto L11;
        if (this.mPackageInfo.packageName.equals(getConnectedPackage(this.mVpnManager, r0)) == false) goto L17;
        MultiSDKAdapterNew.setAlwaysOnVpnPackage(this.mVpnManager, r0, null, false, null);     // Catch: RemoteException -> L13
        this.mVpnManager.prepareVpn(this.mPackageInfo.packageName, "[Legacy VPN]", r0);     // Catch: RemoteException -> L13
        return;
    L17:
        return;
    L13:
        e = move-exception;
        OLog.e(this.TAG, "Failed to disconnect package " + this.mPackageInfo.packageName + " for user " + r0, e);
    }

    private void promptToCancel() {
        new OAlertDialogBuilder(this).horizontalButton().title(this.mLabel, false).message(R.string.vpn_cancel_prompt).positiveButton(R.string.vpn_app_cancel_button_text, new AnonymousClass4(this)).negativeButton(R.string.close, new AnonymousClass3(this)).build().show();
    }

    private void onAlwaysOnVpnClick(boolean r1) {
        if (setAlwaysOnVpnByUI(r1) == false) goto L6;
        updateUI();
        return;
    }

    private boolean onAlwaysOnVpnClick(boolean r1, boolean r2) {
        isAnotherVpnActive();
        VpnUtils.isAnyLockdownActive(this);
        return setAlwaysOnVpnByUI(r1, r2);
    }

    private boolean setAlwaysOnVpnByUI(boolean r2, boolean r3) {
        if (this.mAlwaysOn.isEnabled() == true) goto L7;
        return false;
    L7:
        if (this.mUserId != 0) goto L9;
        VpnUtils.clearLockdownVpn(this);
    L9:
        boolean r4 = setAlwaysOnVpn(r2, r3);
        if (r2 == false) goto L15;
        if (r4 == true) goto L13;
    L16:
        return r4;
    L13:
        if (isVpnAlwaysOn() == false) goto L16;
    L15:
        updateUI();
        goto L16
    }

    private boolean isAnotherVpnActive() {
        VpnConfig r0 = this.mVpnManager.getVpnConfig(this.mUserId);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(r0.user, this.mPackageInfo.packageName) == true) goto L7;
        return true;
    }

    private boolean setAlwaysOnVpnByUI(boolean r2) {
        if (this.mSwitchAlwaysOn.isEnabled() == true) goto L7;
        return false;
    L7:
        if (this.mUserId != 0) goto L10;
        VpnUtils.clearLockdownVpn(this);
    L10:
        return setAlwaysOnVpn(r2);
    }

    private void updateUI() {
        if (this.mPackageInfo != null) goto L5;
        return;
    L5:
        boolean r0 = isVpnAlwaysOn();
        if (r0 == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        this.mSwitchAlwaysOn.setChecked(r0);
        this.mSwitchLockdownVpnOn.setChecked(r3);
        if (this.mVpnManager.isAlwaysOnVpnPackageSupportedForUser(this.mUserId, this.mPackageInfo.packageName) == false) goto L17;
        this.mAlwaysOn.setEnabled(true);
        if (this.mSwitchAlwaysOn.isChecked() == false) goto L16;
        this.mLockdownVpn.setEnabled(true);
        return;
    L16:
        this.mLockdownVpn.setEnabled(false);
        return;
    L17:
        this.mAlwaysOn.setEnabled(false);
        this.mLockdownVpn.setEnabled(false);
        return;
    L8:
        if (VpnUtils.isAnyLockdownActive(this) == false) goto L10;
        r3 = true;
        goto L11
    }

    private boolean setAlwaysOnVpn(boolean r4) {
        VpnManager r0 = this.mVpnManager;
        int r1 = this.mUserId;
        if (r4 == false) goto L5;
        String r3 = this.mPackageInfo.packageName;
    L7:
        return MultiSDKAdapterNew.setAlwaysOnVpnPackage(r0, r1, r3, false, null);
    L5:
        r3 = null;
        goto L7
    }

    private boolean setAlwaysOnVpn(boolean r4, boolean r5) {
        VpnManager r0 = this.mVpnManager;
        int r1 = this.mUserId;
        if (r4 == false) goto L5;
        String r3 = this.mPackageInfo.packageName;
    L7:
        return r0.setAlwaysOnVpnPackageForUser(r1, r3, r5, null);
    L5:
        r3 = null;
        goto L7
    }

    private String getAlwaysOnVpnPackage() {
        return this.mVpnManager.getAlwaysOnVpnPackageForUser(this.mUserId);
    }

    private boolean isVpnAlwaysOn() {
        return this.mPackageInfo.packageName.equals(getAlwaysOnVpnPackage());
    }

    private boolean checkTargetVersion() {
        PackageInfo r0 = this.mPackageInfo;
        if (r0 != null) goto L5;
    L15:
        return true;
    L5:
        if (r0.applicationInfo == null) goto L15;
        int r1 = this.mPackageInfo.applicationInfo.targetSdkVersion;
        if (r1 < 24) goto L11;
        return true;
    L11:
        if (Log.isLoggable(this.TAG, 3) == false) goto L16;
        OLog.d(this.TAG, "Package " + this.mPackageInfo.packageName + " targets SDK version " + r1 + "; must target at least 24 to use always-on.");
        return false;
    L16:
        return false;
    }

    private static String getConnectedPackage(VpnManager r0, int r1) throws RemoteException {
        VpnConfig r2 = r0.getVpnConfig(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.user;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, final boolean r4) {
        OSwitch r0 = this.mSwitchAlwaysOn;
        if (r3 != r0) goto L6;
        onAlwaysOnVpnClick(r4, this.mSwitchLockdownVpnOn.isChecked());
        return;
    L6:
        if (r3 == this.mSwitchLockdownVpnOn) goto L8;
        return;
    L8:
        if (shouldShow(r0.isChecked(), r4, new VpnAppPrefActivity$$ExternalSyntheticLambda0(this, r4)) == false) goto L10;
        return;
    L10:
        onAlwaysOnVpnClick(this.mSwitchAlwaysOn.isChecked(), r4);
    }

    /* JADX INFO: renamed from: lambda$onCheckedChanged$0$com-android-settings-vpn2-VpnAppPrefActivity, reason: not valid java name */
    /* synthetic */ Boolean m630xa5e7ecbd(boolean r2, Boolean r3) {
        if (r3.booleanValue() == true) goto L6;
        this.mSwitchLockdownVpnOn.setChecked(!r2);
    L6:
        return true;
    }

    public boolean shouldShow(final boolean r9, final boolean r10, final Function<Boolean, Boolean> r11) {
        boolean r0 = isAnotherVpnActive();
        boolean r1 = VpnUtils.isAnyLockdownActive(this);
        if (r0 == true) goto L8;
        if (r10 == false) goto L7;
        if (r1 == false) goto L8;
    L7:
        boolean r4 = false;
    L9:
        if (r4 == false) goto L28;
        if (r10 == false) goto L12;
        int r5 = R.string.vpn_require_connection_title;
    L15:
        if (r0 == false) goto L17;
        int r6 = R.string.vpn_replace;
    L20:
        if (r10 == false) goto L24;
        if (r0 == false) goto L23;
        int r7 = R.string.vpn_replace_always_on_vpn_enable_message;
    L27:
        new OAlertDialogBuilder(this).title(r5).message(getString(r7)).positiveButton(getString(r6), new VpnAppPrefActivity$$ExternalSyntheticLambda1(this, r11, r9, r10)).negativeButton(R.string.cancel, new VpnAppPrefActivity$$ExternalSyntheticLambda2(r11)).show();
        goto L28
    L23:
        r7 = R.string.vpn_first_always_on_vpn_message;
        goto L27
    L24:
        if (r1 == false) goto L26;
        r7 = R.string.vpn_replace_always_on_vpn_disable_message;
        goto L27
    L26:
        r7 = R.string.vpn_replace_vpn_message;
        goto L27
    L17:
        if (r10 == false) goto L19;
        r6 = R.string.vpn_turn_on;
        goto L20
    L19:
        r6 = R.string.okay;
        goto L20
    L12:
        if (r0 == false) goto L14;
        r5 = R.string.vpn_replace_vpn_title;
        goto L15
    L14:
        r5 = R.string.vpn_set_vpn_title;
    L28:
        if (r0 == true) goto L32;
        if (r10 == false) goto L33;
        if (r1 == false) goto L32;
        return false;
    L33:
        return false;
    L32:
        return true;
    L8:
        r4 = true;
        goto L9
    }

    /* JADX INFO: renamed from: lambda$shouldShow$1$com-android-settings-vpn2-VpnAppPrefActivity, reason: not valid java name */
    /* synthetic */ void m631lambda$shouldShow$1$comandroidsettingsvpn2VpnAppPrefActivity(Function r1, boolean r2, boolean r3, DialogInterface r4, int r5) {
        r4.dismiss();
        r1.apply(true);
        setAlwaysOnVpnByUI(r2, r3);
    }

    static /* synthetic */ void lambda$shouldShow$2(Function r0, DialogInterface r1, int r2) {
        r1.dismiss();
        r0.apply(false);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_vpn2_VpnAppPrefActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(VpnAppPrefActivity r1) {
        com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_PrivacyHook_onCreate(VpnAppPrefActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        VpnAppPrefActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_vpn2_VpnAppPrefActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(VpnAppPrefActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(VpnAppPrefActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        VpnAppPrefActivity r5 = r4;
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
    public static void com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(VpnAppPrefActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_vpn2_VpnAppPrefActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(VpnAppPrefActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_vpn2_VpnAppPrefActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_PrivacyHook_onResume(VpnAppPrefActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        VpnAppPrefActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_vpn2_VpnAppPrefActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(VpnAppPrefActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_PrivacyHook_onPause(VpnAppPrefActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        VpnAppPrefActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_vpn2_VpnAppPrefActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(VpnAppPrefActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        VpnAppPrefActivity r5 = r3;
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
    public static void com_android_settings_vpn2_VpnAppPrefActivity_com_obric_hook_lancet_PrivacyHook_onStop(VpnAppPrefActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        VpnAppPrefActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_vpn2_VpnAppPrefActivity__onStop$___twin___();
    }
}
