package com.android.settings;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.AlertDialog;
import android.app.admin.DevicePolicyManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserManager;
import android.security.bytedance.guard.BDSettingsEvent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.autoaction.SecurityEventMonitor;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ColorButtonStyleController;
import com.android.settings.utils.NullSafe;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.android.settingslib.utils.WorkPolicyUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.cloudsync.ICloudFindService;
import com.bytedanceos.cloudsync.ICloudServerCallBack;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.lisitem.OCardListItemPositionHelper;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.text.OTextView;
import com.obric.privacy.GrantUtil;
import com.zte.wallet.aidl.IWalletInterface;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.BytedanceProgressDialog;
import obric.tablet.widget.BytedanceJustifyTextView;
import obric.widget.PasswordEditText;

/* JADX INFO: loaded from: classes2.dex */
public class MasterClear extends BaseFragment {
    private static final int CREDENTIAL_CONFIRM_REQUEST = 56;
    static final String ERASE_EXTERNAL_EXTRA = "erase_sd";
    private static final Uri FEED_BACK_URI = null;
    private static final int FREQUENT_OPERATION = 903;
    private static final int INVALID_TICKET = 1602;
    private static final int KEYGUARD_REQUEST = 55;
    private static final int REQUEST_ACCOUNT = 1000;
    private static final int REQUEST_EXIT_PRIVACY_PASSWORD = 101;
    private static final int REQUEST_RELOGIN_SMILING_CLOUD = 100;
    private static final int RESULT_SUCCESS_RELOGIN = 1;
    private static final String TAG = "MasterClear";
    static final int VERIFY_FAILED = 11;
    static final int VERIFY_FREQUENT_OPERATION = 13;
    static final int VERIFY_RELOGIN = 12;
    static final int VERIFY_SUCCESS = 10;
    private ICloudServerCallBack callback;
    private ServiceConnection conn;
    private boolean isBatteryLower;
    private OSectionSupportiveText mBatteryLowerTips;
    private BroadcastReceiver mBatteryReceiver;
    private Handler mCallbackHandler;
    private PasswordEditText mCloudPwdEditText;
    private ICloudFindService mCloudService;
    private OAlertDialog mConfirmDialog;
    private OTextView mDeviceOwnerDisableTips;
    private AlertDialog mExitPrivacyPasswordDialog;
    private CheckBox mExternalStorage;
    private OAlertDialogBuilder mFinalConfirmDialog;
    private OButton mInitiateButton;
    private final View.OnClickListener mInitiateListener;
    private boolean mIsPrivacySettings;
    private AlertDialog mVerifyCloudPasswordDialog;
    private BytedanceProgressDialog mVerifyingDialog;
    private IWalletInterface mWalletService;
    private TextView mWorkPolicyInfoText;
    private ServiceConnection walletConn;

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_MasterClear_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_MasterClear_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public MasterClear() {
        this.isBatteryLower = false;
        this.mIsPrivacySettings = false;
        this.mBatteryReceiver = new AnonymousClass1(this);
        this.conn = new AnonymousClass6(this);
        this.walletConn = new AnonymousClass7(this);
        this.mCallbackHandler = new AnonymousClass8(this);
        this.callback = new AnonymousClass9(this);
        this.mInitiateListener = new AnonymousClass12(this);
    }

    static /* synthetic */ boolean access$000(MasterClear r0) {
        return r0.isBatteryLower;
    }

    static /* synthetic */ boolean access$002(MasterClear r0, boolean r1) {
        r0.isBatteryLower = r1;
        return r1;
    }

    static /* synthetic */ boolean access$100(MasterClear r0) {
        return r0.checkFactoryResetDisabled();
    }

    static /* synthetic */ ICloudFindService access$1002(MasterClear r0, ICloudFindService r1) {
        r0.mCloudService = r1;
        return r1;
    }

    static /* synthetic */ IWalletInterface access$1100(MasterClear r0) {
        return r0.mWalletService;
    }

    static /* synthetic */ IWalletInterface access$1102(MasterClear r0, IWalletInterface r1) {
        r0.mWalletService = r1;
        return r1;
    }

    static /* synthetic */ void access$1200(MasterClear r0) {
        r0.dismissLoadingDialog();
    }

    static /* synthetic */ void access$1300(MasterClear r0, int r1) {
        r0.showGoogleFinalConfirmation(r1);
    }

    static /* synthetic */ Handler access$1400(MasterClear r0) {
        return r0.mCallbackHandler;
    }

    static /* synthetic */ AlertDialog access$1500(MasterClear r0) {
        return r0.mVerifyCloudPasswordDialog;
    }

    static /* synthetic */ void access$1600(MasterClear r0) {
        r0.showAccountLoginDialog();
    }

    static /* synthetic */ boolean access$1700(MasterClear r0, int r1) {
        return r0.runKeyguardConfirmation(r1);
    }

    static /* synthetic */ void access$1800(MasterClear r0) {
        r0.systemAccountLogin();
    }

    static /* synthetic */ void access$1900(MasterClear r0) {
        r0.startPrivacyPassword();
    }

    static /* synthetic */ OSectionSupportiveText access$200(MasterClear r0) {
        return r0.mBatteryLowerTips;
    }

    static /* synthetic */ OAlertDialog access$300(MasterClear r0) {
        return r0.mConfirmDialog;
    }

    static /* synthetic */ OAlertDialogBuilder access$400(MasterClear r0) {
        return r0.mFinalConfirmDialog;
    }

    static /* synthetic */ void access$500(MasterClear r0, int r1) {
        r0.showConfirmation(r1);
    }

    static /* synthetic */ void access$600(MasterClear r0) {
        r0.masterClearConfirm();
    }

    static /* synthetic */ void access$700(MasterClear r0) {
        r0.showLoadingDialog();
    }

    static /* synthetic */ PasswordEditText access$800(MasterClear r0) {
        return r0.mCloudPwdEditText;
    }

    static /* synthetic */ void access$900(MasterClear r0, String r1) {
        r0.closeFindPhone(r1);
    }

    static {
        FEED_BACK_URI = Uri.parse("content://com.bytedanceos.cloudsync.accountcenter");
    }

    public void com_android_settings_MasterClear__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        registerReceiver(this.mBatteryReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        bindCloudService();
        bindWalletService();
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getActivity().getIntent() == null) goto L12;
        String r5 = getActivity().getIntent().getAction();
        this.mIsPrivacySettings = "android.settings.PRIVACY_SETTINGS".equals(r5);
        if (getActivity().getIntent().hasExtra("isPrivacySettings") == false) goto L9;
        this.mIsPrivacySettings = getActivity().getIntent().getBooleanExtra("isPrivacySettings", false);
    L9:
        OLog.d(TAG, "MasterClear created with action: " + r5 + ", isPrivacySettings: " + this.mIsPrivacySettings);
        return;
    }

    private boolean runKeyguardConfirmation(int r4) {
        Resources r0 = ((FragmentActivity) NullSafe.nonNull(getActivity())).getResources();
        return new ChooseLockSettingsHelper(getActivity(), this).launchConfirmationActivity(r4, r0.getText(R.string.master_clear_title), 2, true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(final int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        OLog.d(TAG, "=====onActivityResult  requestCode " + r2 + " resultCode " + r3);
        if (r2 != 1000) goto L8;
        if (r3 != (-1)) goto L30;
        tryClearDevice(r2);
        return;
    L30:
        return;
    L8:
        if (r2 != 100) goto L14;
        if (r3 != 1) goto L31;
        tryClearDevice(r2);
        return;
    L31:
        return;
    L14:
        if (r2 != 101) goto L20;
        if (Utils.isPrivacyPasswordEnable((Context) NullSafe.nonNull(getActivity())) == true) goto L32;
        verifyCloudPasswordDialog();
        return;
    L32:
        return;
    L20:
        if (r2 != 55) goto L22;
    L24:
        if (r3 == (-1)) goto L26;
    L28:
        establishInitialState();
        return;
    L26:
        if (this.isBatteryLower == true) goto L28;
        new Handler().postDelayed(new AnonymousClass2(this, r2), 200);
        return;
    L22:
        if (r2 == 56) goto L24;
    }

    private void showConfirmation(final int r4) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        OAlertDialog r0 = this.mConfirmDialog;
        if (r0 == null) goto L12;
        if (r0.isShowing() == false) goto L10;
        this.mConfirmDialog.dismiss();
    L10:
        this.mConfirmDialog = null;
    L12:
        if (this.mConfirmDialog != null) goto L14;
        this.mConfirmDialog = new OAlertDialogBuilder(this._mActivity).title(R.string.master_clear_confirm).horizontalButton(false).overrideButtonStyleController(new MasterClear$$ExternalSyntheticLambda0()).negativeButton(getString(R.string.cancel), new MasterClear$$ExternalSyntheticLambda1(this)).positiveButton(getString(R.string.master_clear_btn_text), new MasterClear$$ExternalSyntheticLambda2(this, r4)).createDialog();
    L14:
        this.mConfirmDialog.show();
    }

    static /* synthetic */ ButtonStyleController lambda$showConfirmation$0(Context r1, Integer r2) {
        return new ColorButtonStyleController(r1, r2.intValue()).positiveColor(R.color.oui_on_accent_default, R.color.oui_red_6);
    }

    /* JADX INFO: renamed from: lambda$showConfirmation$1$com-android-settings-MasterClear, reason: not valid java name */
    /* synthetic */ void m155lambda$showConfirmation$1$comandroidsettingsMasterClear(DialogInterface r1, int r2) {
        this.mConfirmDialog.dismiss();
    }

    /* JADX INFO: renamed from: lambda$showConfirmation$2$com-android-settings-MasterClear, reason: not valid java name */
    /* synthetic */ void m156lambda$showConfirmation$2$comandroidsettingsMasterClear(int r1, DialogInterface r2, int r3) {
        tryClearDevice(r1);
        this.mConfirmDialog.dismiss();
    }

    private void tryClearDevice(int r2) {
        if (isBytedanceAccountLogin() == true) goto L5;
        showGoogleFinalConfirmation(r2);
        return;
    L5:
        if (this.mCloudService != null) goto L8;
        bindCloudService();
    L8:
        if (Utils.isPrivacyPasswordEnable((Context) NullSafe.nonNull(getActivity())) == false) goto L10;
        showPrivacyPasswordPromptDialog();
        return;
    L10:
        verifyCloudPasswordDialog();
    }

    private void showGoogleFinalConfirmation(int r3) {
        Intent r0 = getAccountConfirmationIntent();
        if (r0 != null) goto L5;
    L8:
        showFinalConfirmation();
        return;
    L5:
        if (r3 == 56) goto L8;
        showAccountCredentialConfirmation(r0);
    }

    private void showFinalConfirmation() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        final int r0 = BDSettingsEvent.EVENT_TYPE_RESTORE_FACTORY.getType();
        SecurityEventMonitor.INSTANCE.start(getActivity(), r0);
        if (this.mFinalConfirmDialog == null) goto L8;
    L12:
        this.mFinalConfirmDialog.show();
        return;
    L8:
        if (SettingsFeature.isWalletFeatureEnabled(getActivity()) == false) goto L10;
        int r1 = R.string.master_clear_final_confirm_msg_with_wallet;
    L11:
        this.mFinalConfirmDialog = new OAlertDialogBuilder(this._mActivity).autoDismiss(false).title(R.string.master_clear_title).message(r1).horizontalButton().overrideButtonStyleController(new MasterClear$$ExternalSyntheticLambda3()).negativeButton(R.string.cancel, new AnonymousClass4(this, r0)).positiveButton(R.string.master_clear_final_confirm_btn, new AnonymousClass3(this, r0));
        goto L12
    L10:
        r1 = R.string.master_clear_final_confirm_msg;
        goto L11
    }

    static /* synthetic */ ButtonStyleController lambda$showFinalConfirmation$3(Context r1, Integer r2) {
        return new ColorButtonStyleController(r1, r2.intValue()).positiveColor(R.color.oui_text_1, -1);
    }

    private void verifyCloudPasswordDialog() {
        if (this.mVerifyCloudPasswordDialog != null) goto L5;
        AlertDialog r0 = new AlertDialog.Builder(getActivity(), getResources().getInteger(R.integer.dialog_style_id)).setTitle(R.string.logout_smiling_account_title).setView(inflateVerifyCloudPasswordView()).setNegativeButton(R.string.cancel, null).setPositiveButton(R.string.master_clear_final_confirm_btn, new AnonymousClass5(this)).create();
        this.mVerifyCloudPasswordDialog = r0;
        r0.setCanceledOnTouchOutside(false);
    L5:
        this.mVerifyCloudPasswordDialog.getWindow().setSoftInputMode(37);
        PasswordEditText r1 = this.mCloudPwdEditText;
        if (r1 == null) goto L9;
        r1.setText("");
    L9:
        if (this.mVerifyCloudPasswordDialog.isShowing() == true) goto L11;
        this.mVerifyCloudPasswordDialog.show();
    L11:
        Button r5 = this.mVerifyCloudPasswordDialog.getButton(-1);
        if (r5 == null) goto L15;
        r5.setEnabled(false);
        return;
    }

    private void showLoadingDialog() {
        if (this.mVerifyingDialog != null) goto L6;
        BytedanceProgressDialog r0 = new BytedanceProgressDialog(getActivity());
        this.mVerifyingDialog = r0;
        r0.setMessage(getResources().getString(R.string.verifying));
        this.mVerifyingDialog.setCanceledOnTouchOutside(false);
    L6:
        if (this.mVerifyingDialog.isShowing() == true) goto L9;
        this.mVerifyingDialog.show();
        return;
    }

    private void dismissLoadingDialog() {
        BytedanceProgressDialog r0 = this.mVerifyingDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    public void showInvalidDialog() {
        Intent r0 = new Intent();
        r0.putExtra("bytedance_ticket_error", true);
        r0.setClassName("com.bytedanceos.cloudsync", "com.bytedanceos.accounts.AccountsActivity");
        r0.putExtra("bytedance_origin_app_tag", "from_master_clear");
        r0.putExtra("anim_resource_id", new int[]{0, 1});
        startActivityForResult(r0, 100);
        getActivity().overridePendingTransition(R.anim.pop_up_in, R.anim.fake_anim);
    }

    private boolean bindCloudService() {
        Intent r0 = new Intent("action.bind.findphone.service");
        r0.setClassName("com.bytedanceos.cloudsync", "com.bytedanceos.cloudsync.services.CloudFindPhoneService");
        return getActivity().bindService(r0, this.conn, 1);
    }

    private boolean bindWalletService() {
        Intent r0 = new Intent("com.zte.wallet.WALLET_INTERFACE");
        r0.setPackage("com.zte.wallet");
        return getActivity().bindService(r0, this.walletConn, 1);
    }

    private void closeFindPhone(String r3) {
        ICloudFindService r0 = this.mCloudService;
        if (r0 == null) goto L9;
        if (r3 == null) goto L9;
        r0.closeFindPhone(r3, this.callback);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        dismissLoadingDialog();
        return;
    L9:
        dismissLoadingDialog();
    }

    private boolean isBytedanceAccountLogin() {
        ICloudFindService r2 = this.mCloudService;
        if (r2 != null) goto L11;
    L8:
        boolean r3 = false;
    L9:
        OLog.d(TAG, "isBytedanceAccountLogin " + r3);
        return r3;
    L11:
        r3 = r2.isBytedanceAccoutLogin();     // Catch: RemoteException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private View inflateVerifyCloudPasswordView() {
        View r0 = LayoutInflater.from(getActivity()).inflate(R.layout.verify_cloud_pwd_dialog, null);
        PasswordEditText r1 = (PasswordEditText) r0.findViewById(R.id.input_pwd_edittext_for_dialog);
        this.mCloudPwdEditText = r1;
        r1.addTextChangedListener(new AnonymousClass10(this));
        r0.findViewById(R.id.find_forget_pwd_for_dialog).setOnClickListener(new AnonymousClass11(this));
        return r0;
    }

    public void launchForgetPassword() {
        Intent r2 = new Intent("android.intent.action.VIEW", Uri.parse(""));     // Catch: ActivityNotFoundException -> L9
        r2.setFlags(268435456);     // Catch: ActivityNotFoundException -> L7
        r2.putExtra("create_new_tab", true);     // Catch: ActivityNotFoundException -> L7
        r2.setComponent(new ComponentName("com.android.browser", "com.android.browser.BrowserActivity"));     // Catch: ActivityNotFoundException -> L7
        startActivity(r2);     // Catch: ActivityNotFoundException -> L7
        return;
    L7:
        e = e;
    L19:
        r2.setComponent(null);     // Catch: Exception -> L14
        startActivity(r2);     // Catch: Exception -> L14
    L12:
        e.printStackTrace();
        return;
    L9:
        e = e;
        r2 = null;
        goto L19
    }

    private void masterClearConfirm() {
        if (Utils.isMonkeyRunning() == false) goto L5;
        return;
    L5:
        getActivity().sendBroadcast(new Intent("bytedance.action.FORMAT_DEVICE"));
        Intent r0 = new Intent(MultiSDKAdapter.ACTION_FACTORY_RESET);
        r0.setPackage(RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        getActivity().sendBroadcast(r0);
    }

    private void showAccountLoginDialog() {
        new OAlertDialogBuilder(this._mActivity).autoDismiss(false).title(getString(R.string.master_clear_exit_account_tip), true).horizontalButton().overrideButtonStyleController(new MasterClear$$ExternalSyntheticLambda4()).negativeButton(R.string.system_account_logout_dialog_login_btn_cancel, new AnonymousClass14(this)).positiveButton(R.string.master_clear_jump_to_account, new AnonymousClass13(this)).show();
    }

    static /* synthetic */ ButtonStyleController lambda$showAccountLoginDialog$4(Context r1, Integer r2) {
        return new ColorButtonStyleController(r1, r2.intValue()).positiveColor(R.color.oui_text_1, -1);
    }

    private void systemAccountLogin() {
        OLog.i(TAG, "systemAccountLogout");
        OAccount.INSTANCE.startLogoutActivity(this._mActivity, 1000);
    }

    Intent getAccountConfirmationIntent() {
        FragmentActivity r6 = getActivity();
        String r0 = r6.getString(R.string.account_type);
        String r1 = r6.getString(R.string.account_confirmation_package);
        String r2 = r6.getString(R.string.account_confirmation_class);
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L23:
        OLog.i(TAG, "Resources not set for account confirmation.");
        return null;
    L5:
        if (TextUtils.isEmpty(r1) == true) goto L23;
        if (TextUtils.isEmpty(r2) == true) goto L23;
        Account[] r3 = AccountManager.get(r6).getAccountsByType(r0);
        if (r3 != null) goto L12;
    L21:
        OLog.d(TAG, "No " + r0 + " accounts installed!");
    L22:
        return null;
    L12:
        if (r3.length <= 0) goto L21;
        Intent r4 = new Intent().setPackage(r1).setComponent(new ComponentName(r1, r2));
        ResolveInfo r7 = r6.getPackageManager().resolveActivity(r4, 0);
        if (r7 != null) goto L16;
    L20:
        OLog.i(TAG, "Unable to resolve Activity: " + r1 + LibrarianImpl.Constants.SEPARATOR + r2);
        goto L22
    L16:
        if (r7.activityInfo == null) goto L20;
        if (r1.equals(r7.activityInfo.packageName) == false) goto L20;
        return r4;
    }

    void showAccountCredentialConfirmation(Intent r2) {
        startActivityForResult(r2, 56);
    }

    private void establishInitialState() {
        OButton r0 = (OButton) findViewByIdNullable(R.id.initiate_master_clear);
        this.mInitiateButton = r0;
        r0.setOnClickListener(this.mInitiateListener);
        new OCardListItemPositionHelper((FrameLayout) findViewByIdNullable(R.id.btnLayout), true, getContext().getColor(R.color.oui_fill_list_item_card), 0);
        StringBuffer r1 = new StringBuffer();
        View r2 = findViewByIdNullable(R.id.page_container);
        getContentDescription(r2, r1);
        r2.setContentDescription(r1);
        if (this.mIsPrivacySettings == false) goto L5;
        showWorkPolicyInfo();
    L5:
        checkFactoryResetDisabled();
    }

    private boolean checkFactoryResetDisabled() {
        boolean r0 = ((UserManager) this.mContext.getSystemService(PickApplicationActivity.EXTRA_USER)).hasUserRestriction("no_factory_reset");
        OButton r1 = this.mInitiateButton;
        if (r0 == false) goto L5;
        float r2 = 0.3f;
    L6:
        r1.setAlpha(r2);
        OTextView r3 = this.mDeviceOwnerDisableTips;
        if (r0 == false) goto L9;
        int r4 = 0;
    L10:
        r3.setVisibility(r4);
        return r0;
    L9:
        r4 = 8;
        goto L10
    L5:
        r2 = 1.0f;
        goto L6
    }

    private void showWorkPolicyInfo() {
        FragmentActivity r4 = getActivity();     // Catch: Exception -> L28
        DevicePolicyManager r5 = (DevicePolicyManager) r4.getSystemService("device_policy");     // Catch: Exception -> L28
        if (r5 != null) goto L7;
        OLog.w(TAG, "DevicePolicyManager is null");     // Catch: Exception -> L28
        return;
    L7:
        String r6 = r5.getDeviceOwner();     // Catch: Exception -> L28
        if (r6 != null) goto L11;
        hideWorkPolicyInfo();     // Catch: Exception -> L28
        return;
    L11:
        OLog.d(TAG, "Device owner package: " + r6);     // Catch: Exception -> L28
        if ("com.google.android.cts.deviceowner".equals(r6) == true) goto L32;
        showDefaultWorkPolicyInfo();     // Catch: Exception -> L28
        return;
    L32:
        int r3 = r4.getPackageManager().getComponentEnabledSetting(new ComponentName(r6, r6 + ".WorkPolicyInfoActivity"));     // Catch: Exception -> L25
        boolean r7 = true;
        if (r3 == 1) goto L20;
        r7 = false;
    L20:
        boolean r8 = new WorkPolicyUtils(getActivity()).hasWorkPolicy();     // Catch: Exception -> L25
        OLog.d(TAG, "WorkPolicyInfoActivity enabled: " + r7 + BytedanceJustifyTextView.TWO_BLANK + r3 + BytedanceJustifyTextView.TWO_BLANK + r8);     // Catch: Exception -> L25
        if (r8 == false) goto L23;
        showDefaultWorkPolicyInfo();     // Catch: Exception -> L25
    L31:
        return;
    L23:
        hideWorkPolicyInfo();     // Catch: Exception -> L25
    L25:
        e = move-exception;
        OLog.e(TAG, "Error checking WorkPolicyInfoActivity state", e);     // Catch: Exception -> L28
        hideWorkPolicyInfo();     // Catch: Exception -> L28
        return;
    L28:
        e = move-exception;
        OLog.e(TAG, "Error displaying work policy inzenglingwen:fo", e);
    }

    private void showDefaultWorkPolicyInfo() {
        if (getActivity().getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L5;
        String r0 = "Privacy Settings for Device Owner CTS host side app vehicle policy";
    L6:
        OLog.d(TAG, "Work policy info: ".concat(r0));
        TextView r1 = (TextView) findViewByIdNullable(R.id.work_policy_info_text);
        this.mWorkPolicyInfoText = r1;
        if (r1 == null) goto L10;
        r1.setText(r0);
        this.mWorkPolicyInfoText.setVisibility(0);
        OLog.d(TAG, "Work policy info displayed: ".concat(r0));
        return;
    L10:
        return;
    L5:
        r0 = "Your work policy info";
        goto L6
    }

    private void hideWorkPolicyInfo() {
        TextView r0 = (TextView) findViewByIdNullable(R.id.work_policy_info_text);
        this.mWorkPolicyInfoText = r0;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    private void getContentDescription(View r3, StringBuffer r4) {
        if (r3.getVisibility() == 0) goto L6;
        return;
    L6:
        if ((r3 instanceof ViewGroup) == false) goto L12;
        ViewGroup r5 = (ViewGroup) r3;
        int r0 = 0;
    L9:
        if (r0 >= r5.getChildCount()) goto L17;
        getContentDescription(r5.getChildAt(r0), r4);
        r0 = r0 + 1;
        goto L9
    L17:
        return;
    L12:
        if ((r3 instanceof TextView) == false) goto L16;
        r4.append(((TextView) r3).getText());
        r4.append(",");
        return;
    }

    private boolean isExtStorageEncrypted() {
        return !"".equals(SystemProperties.get("vold.decrypt"));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.master_clear, null);
        this.mBatteryLowerTips = (OSectionSupportiveText) findViewByIdNullable(R.id.battery_lower_tips);
        this.mDeviceOwnerDisableTips = (OTextView) findViewByIdNullable(R.id.device_owner_disable_tips);
        TextView r5 = (TextView) this.mBatteryLowerTips.findViewById(R.id.section_des);
        if (r5 == null) goto L5;
        r5.setTextColor(getResources().getColor(R.color.warning_red));
    L5:
        Bundle r6 = getArguments();
        boolean r7 = false;
        boolean r0 = r6.getBoolean("master_clear_for_crypt_keeper", false);
        String r8 = r6.getString("master_clear_for_crypt_keeper");
        if (r0 == false) goto L8;
    L9:
        r7 = true;
    L10:
        OSectionSupportiveText r9 = (OSectionSupportiveText) findViewByIdNullable(R.id.master_clear_warning_tips);
        if (r7 == false) goto L14;
        r9.setSectionDes(getString(R.string.master_clear_tips_for_crypt_keeper));
    L17:
        establishInitialState();
        return this.mRootView;
    L14:
        if (SettingsFeature.isWalletFeatureEnabled(getActivity()) == false) goto L16;
        r9.setSectionDes(getString(R.string.master_clear_warning_tips_with_wallet));
        goto L17
    L16:
        r9.setSectionDes(getString(R.string.master_clear_warning_tips));
        goto L17
    L8:
        if ("true".equals(r8) == false) goto L10;
        goto L9
    }

    public void com_android_settings_MasterClear__onResume$___twin___() {
        super.onResume();
        if (this.mIsPrivacySettings == false) goto L5;
        showWorkPolicyInfo();
    L5:
        checkFactoryResetDisabled();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        r0.unregisterReceiver(this.mBatteryReceiver);
        r0.unbindService(this.conn);
        r0.unbindService(this.walletConn);
        return;
    }

    private void showPrivacyPasswordPromptDialog() {
        if (this.mExitPrivacyPasswordDialog != null) goto L5;
        AlertDialog.Builder r0 = new AlertDialog.Builder(getActivity(), getResources().getInteger(R.integer.dialog_style_id));
        View r1 = LayoutInflater.from(getActivity()).inflate(R.layout.exit_cloud_prompt_dialog, null);
        this.mExitPrivacyPasswordDialog = r0.setTitle(R.string.dlg_title_notice).setView(r1).setNegativeButton(R.string.cancel, null).setPositiveButton(R.string.exit_privacy_password_button, new AnonymousClass15(this)).create();
    L5:
        this.mExitPrivacyPasswordDialog.setCanceledOnTouchOutside(false);
        this.mExitPrivacyPasswordDialog.show();
    }

    private void startPrivacyPassword() {
        Intent r0 = new Intent(getActivity(), ChooseLockPassword.class);
        r0.putExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, 6);
        r0.putExtra(ChooseLockPassword.PASSWORD_APPLICATIONS_LOCK_KEY, true);
        r0.putExtra(AppLockUtil.EXIT_SMILING_CLOUD, true);
        startActivityForResult(r0, 101);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_MasterClear_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(MasterClear r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_MasterClear__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MasterClear_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(MasterClear r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_MasterClear_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MasterClear_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(MasterClear r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_MasterClear__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
