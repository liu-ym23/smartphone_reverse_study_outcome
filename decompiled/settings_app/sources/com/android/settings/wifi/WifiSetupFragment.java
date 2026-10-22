package com.android.settings.wifi;

import android.app.Dialog;
import android.app.StatusBarManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserManager;
import android.text.TextUtils;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.AdaptWifi;
import com.android.settings.HandInHandProcessor;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.SettingsFeature;
import com.android.settings.applications.utils.ODialogUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.provision.WizardManagerHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.utils.ResourceUtils;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.privacy.GrantUtil;
import com.obric.widget.SizeChangedLinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class WifiSetupFragment extends BaseFragment implements View.OnClickListener {
    protected static final String INTENT_EXTRA_CMCC_SETUP = "cmcc";
    public static final String INTENT_EXTRA_MULTI = "multi_wifi";
    public static final String INTENT_EXTRA_SETUP_ACCESS_POINT = "access_point";
    public static final String INTENT_EXTRA_SETUP_EDIT = "edit";
    protected static final String INTENT_EXTRA_SETUP_INVALID_NETWORK = "invalid_network";
    public static final String INTENT_EXTRA_SETUP_TEXT_IS_SELECTABLE = "text_is_selectable";
    public static final String KEY_WLAN_PASSWORD = "wlan_password";
    private static final int MSG_MATCH_SCAN_RESULT = 100;
    private static final String TAG = "WifiSetupFragment";
    public static final String WAPI_CERT_MANAGE_ACTION = "android.Wapi.CertManage";
    private Dialog errorDialog;
    private AccessPoint mAccessPoint;
    private boolean mCmccModified;
    WifiConfiguration mConfig;
    private WifiManager.ActionListener mConnectListener;
    private WifiConfigControllerForSetup mController;
    private boolean mEdit;
    private LayoutInflater mInflater;
    private IntentFilter mIntentFilter;
    private Dialog mLoadingDialog;
    private boolean mMultiWifi;
    private OInputLayout mPasswordEditor;
    private BroadcastReceiver mReceiver;
    private OUIFrameLayout mRightBtn;
    private OTextView mRightBtnTv;
    private WifiManager.ActionListener mSaveListener;
    private boolean mSetupWizardMode;
    private SizeChangedLinearLayout mSizeChangedLayout;
    private StatusBarManager mStatusBarManager;
    private boolean mTextIsSelectable;
    private WifiManager mWifiManager;
    private Handler matchResultHandler;
    private int rightBtnColor;
    private String rightBtnText;
    private int scanCount;
    private boolean submit;

    /* JADX INFO: renamed from: com.android.settings.wifi.WifiSetupFragment$2, reason: invalid class name */
    class AnonymousClass2 implements WifiManager.ActionListener {
        final /* synthetic */ WifiSetupFragment this$0;

        static /* synthetic */ Unit lambda$onFailure$0() {
            return null;
        }

        public void onSuccess() {
        }

        AnonymousClass2(WifiSetupFragment r1) {
            this.this$0 = r1;
        }

        public void onFailure(int r8) {
            OLog.e(WifiSetupFragment.TAG, "connect fail " + r8 + HanziToPinyin.Token.SEPARATOR + Log.getStackTraceString(new Throwable()));
            if (WifiSetupFragment.access$900(this.this$0) == null) goto L8;
            if (WifiSetupFragment.access$900(this.this$0).isShowing() == false) goto L8;
            return;
        L8:
            if (WifiSetupFragment.access$1000(this.this$0) != null) goto L10;
        L12:
            CenterLoadingDialog r9 = new CenterLoadingDialog(this.this$0.getContext(), ResourceUtils.getString(R.string.cannot_join_network), "", ResourceUtils.getString(R.string.I_know), R.drawable.settings_oic_exclamation_mark_circle, new WifiSetupFragment$2$$ExternalSyntheticLambda0());
            WifiSetupFragment.access$902(this.this$0, r9);
            r9.show();
            return;
        L10:
            if (WifiSetupFragment.access$1000(this.this$0).isShowing() == false) goto L12;
            WifiSetupFragment.access$1000(this.this$0).dismiss();
            goto L12
        }
    }

    static /* synthetic */ Unit lambda$handleEvent$2() {
        return null;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_WifiSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_WifiSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public WifiSetupFragment() {
        this.mEdit = false;
        this.mTextIsSelectable = false;
        this.mAccessPoint = null;
        this.mCmccModified = false;
        this.mConfig = null;
        this.submit = false;
        this.matchResultHandler = new AnonymousClass1(this);
    }

    static /* synthetic */ WifiConfigControllerForSetup access$000(WifiSetupFragment r0) {
        return r0.mController;
    }

    static /* synthetic */ int access$100(WifiSetupFragment r0, WifiConfiguration r1) {
        return r0.findNetworkId(r1);
    }

    static /* synthetic */ Dialog access$1000(WifiSetupFragment r0) {
        return r0.mLoadingDialog;
    }

    static /* synthetic */ void access$1100(WifiSetupFragment r0, Context r1, Intent r2) {
        r0.handleEvent(r1, r2);
    }

    static /* synthetic */ View access$1200(WifiSetupFragment r0) {
        return r0.mBackView;
    }

    static /* synthetic */ OUIFrameLayout access$1300(WifiSetupFragment r0) {
        return r0.mRightBtn;
    }

    static /* synthetic */ AccessPoint access$200(WifiSetupFragment r0) {
        return r0.mAccessPoint;
    }

    static /* synthetic */ boolean access$300(WifiSetupFragment r0) {
        return r0.mEdit;
    }

    static /* synthetic */ boolean access$400(WifiSetupFragment r0, WifiConfiguration r1) {
        return r0.matchScanResult(r1);
    }

    static /* synthetic */ int access$500(WifiSetupFragment r0) {
        return r0.scanCount;
    }

    static /* synthetic */ void access$600(WifiSetupFragment r0) {
        r0.forceScan();
    }

    static /* synthetic */ WifiManager access$700(WifiSetupFragment r0) {
        return r0.mWifiManager;
    }

    static /* synthetic */ WifiManager.ActionListener access$800(WifiSetupFragment r0) {
        return r0.mConnectListener;
    }

    static /* synthetic */ Dialog access$900(WifiSetupFragment r0) {
        return r0.errorDialog;
    }

    static /* synthetic */ Dialog access$902(WifiSetupFragment r0, Dialog r1) {
        r0.errorDialog = r1;
        return r1;
    }

    private void initialize() {
        Bundle r0 = getArguments();
        Bundle r1 = r0.getBundle("access_point");
        if (r1 == null) goto L7;
        this.mAccessPoint = new AccessPoint(this._mActivity, r1);
        if (r0.getBoolean("invalid_network", false) == false) goto L22;
        this.mAccessPoint.networkId = -1;
    L22:
        this.mEdit = r0.getBoolean("edit", false);
        this.mTextIsSelectable = r0.getBoolean("text_is_selectable", false);
        this.mCmccModified = r0.getBoolean(INTENT_EXTRA_CMCC_SETUP, false);
        return;
    L7:
        Utils.WifiEntryInfo r2 = Utils.readWifiEntryInfoFromData(r0);
        if (r2 != null) goto L10;
    L18:
        if (r2 == null) goto L22;
        if (TextUtils.isEmpty(r2.ssid) == true) goto L22;
        this.mAccessPoint = findAccessPointBySsid(r2.ssid, r2.securityTypes);
        goto L22
    L10:
        if (this.mWifiManager != null) goto L12;
        this.mWifiManager = (WifiManager) getSystemService("wifi");
    L12:
        android.net.wifi.WifiInfo r3 = this.mWifiManager.getConnectionInfo();
        if (r3 == null) goto L18;
        if (AccessPoint.removeDoubleQuotes(r3.getSSID()).equals(r2.ssid) == false) goto L18;
        Intent r4 = new Intent(getContext(), Settings.AccessPointDetailActivity.class);
        getContext().startActivity(r4);
        finish();
    }

    public void setRightBtnText(String r1) {
        this.rightBtnText = r1;
    }

    public void setRightBtnColor(int r1) {
        this.rightBtnColor = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mInflater = r2;
        this.mRootView = r2.inflate(R.layout.wifi_setup_fragment, r3, false);
        OInputLayout r5 = (OInputLayout) ((OCardListItem) this.mRootView.findViewById(R.id.password)).getCustomStartView();
        this.mPasswordEditor = r5;
        r5.setType(0);
        this.mPasswordEditor.setHint(getResources().getString(R.string.wifi_password));
        this.mPasswordEditor.setInputType(129);
        this.mPasswordEditor.showEyes(true);
        this.mPasswordEditor.setCustomStart(R.layout.layout_card_list_item_custom_start);
        this.mPasswordEditor.setCustomEnd(R.layout.input_custom_end);
        this.mPasswordEditor.showInputBackground(false);
        SizeChangedLinearLayout r6 = (SizeChangedLinearLayout) this.mRootView.findViewById(R.id.password_editor_container);
        this.mSizeChangedLayout = r6;
        r6.setSizeChangedListener(new WifiSetupFragment$$ExternalSyntheticLambda2(this));
        initialize();
        return this.mRootView;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-wifi-WifiSetupFragment, reason: not valid java name */
    /* synthetic */ void m715x6c46bb25() {
        this.mPasswordEditor.requestFocus();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r8, Bundle r9) {
        super.onViewCreated(r8, r9);
        OUIFrameLayout r10 = (OUIFrameLayout) this.mTitleView.addEndAction(getResources().getString(R.string.wifi_save), -1, null);
        this.mRightBtn = r10;
        this.mRightBtnTv = (OTextView) r10.getChildAt(0);
        this.mTitleView.setEndButtonGroupStyle(2132018103);
        if (TextUtils.isEmpty(this.rightBtnText) == true) goto L5;
        this.mRightBtnTv.setText(this.rightBtnText);
        this.mRightBtnTv.setTextColor(this.rightBtnColor);
    L5:
        this.mRightBtn.setOnClickListener(this);
        WifiConfigControllerForSetup r11 = new WifiConfigControllerForSetup(this, this.mRootView, this.mAccessPoint, this.mEdit, this.mTextIsSelectable, this.mMultiWifi);
        this.mController = r11;
        r11.enableSubmitIfAppropriate();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        this.mWifiManager = (WifiManager) getSystemService("wifi");
        this.mConnectListener = new AnonymousClass2(this);
        this.mSaveListener = new AnonymousClass3(this);
    }

    public void com_android_settings_wifi_WifiSetupFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        if (isAddWifiConfigAllowed(getContext()) == true) goto L6;
        finish();
        return;
    L6:
        IntentFilter r4 = new IntentFilter();
        this.mIntentFilter = r4;
        r4.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        this.mIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
        this.mIntentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        this.mReceiver = new AnonymousClass4(this);
        boolean r5 = !com.android.settings.Utils.isDeviceSetupComplete(this.mContext);
        this.mSetupWizardMode = r5;
        if (r5 == false) goto L11;
        getWindow().addFlags(524288);
        StatusBarManager r6 = (StatusBarManager) this.mContext.getSystemService("statusbar");
        this.mStatusBarManager = r6;
        if (r6 == null) goto L11;
        r6.disable(18939904);
    L11:
        this.mMultiWifi = getArguments().getBoolean("multi_wifi", false);
        TransitionInflater.from(this.mContext);
    }

    static boolean isAddWifiConfigAllowed(Context r1) {
        UserManager r2 = (UserManager) r1.getSystemService(UserManager.class);
        if (r2 != null) goto L5;
        return true;
    L5:
        if (r2.hasUserRestriction("no_add_wifi_config") == false) goto L10;
        OLog.e(TAG, "The user is not allowed to add Wi-Fi configuration.");
        return false;
    L10:
        return true;
    }

    @Override // com.android.settings.base.BaseFragment
    public List<String> getFragmentRequestKeys() {
        ArrayList r1 = new ArrayList();
        r1.add(AdvancedAccessPointSettingsFragment.KEY_ADVANCED_ACCESS_POINT_SETTINGS_FRAGMENT_RESULT);
        return r1;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onFragmentResult(String r1, int r2, Bundle r3) {
        super.onFragmentResult(r1, r2, r3);
        if (r3 == null) goto L6;
        this.mConfig = (WifiConfiguration) r3.getParcelable("extra_ap_configuration");
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Dialog r0 = this.errorDialog;
        if (r0 != null) goto L5;
    L7:
        unregisterReceiver(this.mReceiver);
        com.android.settings.Utils.hideInputMethod(this._mActivity);
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.errorDialog.dismiss();
        this.errorDialog = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        return this._mActivity;
    }

    public void setSubmitButton(CharSequence r1) {
        OTextView r0 = this.mRightBtnTv;
        if (r0 == null) goto L6;
        r0.setText(r1.toString());
        return;
    }

    public View getSubmitButton() {
        return this.mRightBtn;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 == this.mRightBtn) goto L5;
        return;
    L5:
        if (this.mMultiWifi == true) goto L7;
        showLoadingDialog();
    L7:
        this.mRightBtn.setEnabled(false);
        this.mBackView.setEnabled(false);
        submit();
    }

    public void com_android_settings_wifi_WifiSetupFragment__onResume$___twin___() {
        super.onResume();
        this.mIntentFilter.setPriority(1000);
        registerReceiver(this.mReceiver, this.mIntentFilter);
        if (this.mController != null) goto L5;
        return;
    L5:
        if (isAdded() == true) goto L7;
        return;
    L7:
        if (getActivity() == null) goto L12;
        this.mController.showSoftKeyguard(getActivity());
        return;
    }

    private void showSwitchConfirmDialog(Context r7, final WifiConfiguration r8, final WifiManager.ActionListener r9) {
        HandInHandProcessor r0 = new HandInHandProcessor();
        if (isWifiConnected() == false) goto L8;
        if (r0.isHandInHandle(r7) == false) goto L8;
        r0.showDialog(r7, 2, new AnonymousClass5(this), new AnonymousClass6(this, r8, r9), new AnonymousClass7(this));
        return;
    L8:
        if (this.mMultiWifi == false) goto L11;
        Intent r10 = new Intent();
        r10.putExtra(KEY_WLAN_PASSWORD, r8.preSharedKey);
        getActivity().setResult(RESULT_OK, r10);
        finish();
        return;
    L11:
        this.mWifiManager.connect(r8, r9);
        this.submit = true;
    }

    private boolean isWifiConnected() {
        ConnectivityManager r1 = (ConnectivityManager) getSystemService("connectivity");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.getNetworkInfo(1).isConnected() == false) goto L7;
        return true;
    }

    private void showLoadingDialog() {
        StatusDialog r0 = ODialogUtils.INSTANCE.showStatusDialog(getActivity(), ResourceUtils.getString(R.string.wifi_connection_loading), "", ResourceUtils.getString(android.R.string.cancel), true, new WifiSetupFragment$$ExternalSyntheticLambda0(this));
        this.mLoadingDialog = r0;
        r0.setOnDismissListener(new AnonymousClass8(this));
        this.mLoadingDialog.show();
    }

    /* JADX INFO: renamed from: lambda$showLoadingDialog$1$com-android-settings-wifi-WifiSetupFragment, reason: not valid java name */
    /* synthetic */ Unit m716x4fcede33() {
        this.mWifiManager.disconnect();
        return null;
    }

    private void startWapiCertManage() {
        OAlertDialogBuilder r0 = new OAlertDialogBuilder(this._mActivity).horizontalButton();
        r0.message(getString(R.string.wapi_no_vaild_cert));
        r0.positiveButton(R.string.apn_editor_dialog_button_text_positive, new AnonymousClass9(this));
        r0.negativeButton(R.string.apn_editor_dialog_button_text_negative, new AnonymousClass10(this));
        r0.build().show();
    }

    private void submit() {
        WifiConfiguration r0 = this.mController.getConfig();
        if (r0 != null) goto L7;
        OLog.d(TAG, "config is null");
        return;
    L7:
        if (this.mController.checkWapiParam() == true) goto L13;
        if (this.mController.getCurSecurity() != 5) goto L22;
        startWapiCertManage();
        return;
    L22:
        return;
    L13:
        if (this.mAccessPoint != null) goto L15;
        this.mWifiManager.save(r0, this.mSaveListener);
        this.scanCount = 3;
        forceScan();
        return;
    L15:
        if (this.mCmccModified == false) goto L17;
        this.mWifiManager.save(r0, this.mSaveListener);
        return;
    L17:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L24;
        showSwitchConfirmDialog(r1, r0, this.mConnectListener);
        return;
    }

    private void handleEvent(Context r12, Intent r13) {
        String r14 = r13.getAction();
        if ("android.net.wifi.supplicant.STATE_CHANGE".equals(r14) == false) goto L39;
        if (r13.hasExtra("supplicantError") == false) goto L92;
        this.mController.enableSubmitIfAppropriate();
        if (getActivity() != null) goto L9;
        return;
    L9:
        if (getActivity().isFinishing() == true) goto L94;
        int r15 = r13.getIntExtra(AdaptWifi.WIFI_MANAGER_EXTRA_SUPPLICANT_ERROR_REASON, 0);
        Dialog r2 = this.errorDialog;
        if (r2 == null) goto L15;
        if (r2.isShowing() == false) goto L15;
        return;
    L15:
        if (this.submit == true) goto L18;
        return;
    L18:
        if (r15 != 2) goto L20;
    L21:
        Dialog r16 = this.mLoadingDialog;
        if (r16 != null) goto L24;
    L26:
        AccessPoint r17 = this.mAccessPoint;
        if (r17 == null) goto L29;
        String r18 = r17.ssid;
    L30:
        StatusDialog r19 = ODialogUtils.INSTANCE.showStatusDialog(getActivity(), ResourceUtils.getString(R.string.cannot_join_network), ResourceUtils.getString(R.string.network) + HanziToPinyin.Token.SEPARATOR + AccessPoint.removeDoubleQuotes(r18) + HanziToPinyin.Token.SEPARATOR + ResourceUtils.getString(R.string.passwordError2), ResourceUtils.getString(R.string.ok2), true, new AnonymousClass11(this));
        ViewGroup r4 = (ViewGroup) r19.findViewById(R.id.status_progress_view).getParent();
        r4.removeView(r19.findViewById(R.id.status_progress_view));
        ImageView r3 = new ImageView(getActivity());
        ViewGroup.MarginLayoutParams r5 = new ViewGroup.MarginLayoutParams(com.android.settings.Utils.dp2Pixels(getActivity(), 48.0f), com.android.settings.Utils.dp2Pixels(getActivity(), 48.0f));
        r5.bottomMargin = com.android.settings.Utils.dp2Pixels(getActivity(), 12.0f);
        r5.topMargin = com.android.settings.Utils.dp2Pixels(getActivity(), 4.0f);
        r3.setLayoutParams(r5);
        r3.setImageResource(R.drawable.settings_oic_exclamation_mark_circle);
        r4.addView(r3, 0);
        this.errorDialog = r19;
        r19.show();
        this.submit = false;
    L31:
        if (r15 != 1) goto L95;
        Dialog r110 = this.mLoadingDialog;
        if (r110 != null) goto L35;
    L37:
        CenterLoadingDialog r111 = new CenterLoadingDialog(getContext(), ResourceUtils.getString(R.string.cannot_join_network), ResourceUtils.getStringFormat(R.string.connect_timeout, new Object[]{this.mAccessPoint.ssid}), ResourceUtils.getString(R.string.I_know), R.drawable.settings_oic_exclamation_mark_circle, new WifiSetupFragment$$ExternalSyntheticLambda1());
        this.errorDialog = r111;
        r111.show();
        this.submit = false;
        return;
    L35:
        if (r110.isShowing() == false) goto L37;
        this.mLoadingDialog.dismiss();
        goto L37
    L95:
        return;
    L29:
        r18 = this.mController.getConfig().SSID;
        goto L30
    L24:
        if (r16.isShowing() == false) goto L26;
        this.mLoadingDialog.dismiss();
        goto L26
    L20:
        if (SettingsFeature.isWifiFailAuth(r13) == false) goto L31;
    L94:
        return;
    L92:
        return;
    L39:
        if ("android.net.wifi.STATE_CHANGE".equals(r14) == false) goto L86;
        if (((NetworkInfo) r13.getParcelableExtra("networkInfo")).isConnected() == true) goto L43;
        return;
    L43:
        if (r13.hasExtra("wifiInfo") == false) goto L60;
        WifiConfiguration r0 = this.mController.getConfig();
        android.net.wifi.WifiInfo r112 = (android.net.wifi.WifiInfo) r13.getParcelableExtra("wifiInfo");
        if (r112 != null) goto L47;
        return;
    L47:
        String r113 = AccessPoint.removeDoubleQuotes(r112.getSSID());
        if (this.mCmccModified == false) goto L51;
        return;
    L51:
        if (r0.networkId != r112.getNetworkId()) goto L53;
        finish();
        goto L60
    L53:
        AccessPoint r114 = this.mAccessPoint;
        if (r114 == null) goto L56;
        String r115 = r114.ssid;
    L58:
        if (r113.equals(r115) == false) goto L60;
        finish();
        goto L60
    L56:
        r115 = AccessPoint.removeDoubleQuotes(r0.SSID);
    L60:
        android.net.wifi.WifiInfo r116 = this.mWifiManager.getConnectionInfo();
        if (r116 != null) goto L63;
        return;
    L63:
        if (this.mAccessPoint != null) goto L65;
    L66:
        Dialog r117 = this.mLoadingDialog;
        if (r117 != null) goto L69;
        return;
    L69:
        if (r117.isShowing() == false) goto L101;
        OLog.d(TAG, "wifi connected, finish");
        this.mLoadingDialog.dismiss();
        if ((getActivity() instanceof Settings) == false) goto L73;
    L83:
        finish();
        return;
    L73:
        if ((getActivity() instanceof WifiSettingsActivity) == true) goto L83;
        if ((getActivity() instanceof WifiDetailsSettingsActivity) == true) goto L78;
        finish();
        return;
    L78:
        if (WizardManagerHelper.isAnySetupWizard(getIntent()) == true) goto L80;
        startActivity(new Intent(getContext(), WifiSettingsActivity.class));
    L80:
        finish();
        return;
    L101:
        return;
    L65:
        if (AccessPoint.removeDoubleQuotes(r116.getSSID()).equals(this.mAccessPoint.ssid) == true) goto L66;
        return;
    L86:
        if ("android.net.wifi.SCAN_RESULTS".equals(r14) == true) goto L88;
        return;
    L88:
        if (this.scanCount <= 0) goto L104;
        this.matchResultHandler.sendEmptyMessage(100);
        this.scanCount--;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.matchResultHandler.removeCallbacksAndMessages(null);
        WifiConfigControllerForSetup r0 = this.mController;
        if (r0 == null) goto L5;
        r0.finish();
    L5:
        this.mConfig = null;
        if (this.mSetupWizardMode == false) goto L8;
        this.mStatusBarManager.disable(0);
    L8:
        Dialog r1 = this.mLoadingDialog;
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.isShowing() == false) goto L15;
        this.mLoadingDialog.dismiss();
        return;
    }

    private void onFragmentResult(Bundle r2) {
        if (r2 == null) goto L5;
        this.mConfig = (WifiConfiguration) r2.getParcelable("extra_ap_configuration");
        return;
    }

    private int findNetworkId(WifiConfiguration r5) {
        List<WifiConfiguration> r4 = this.mWifiManager.getConfiguredNetworks();     // Catch: RuntimeException -> L4
    L6:
        if (r4 == null) goto L17;
        int r0 = 0;
    L9:
        if (r0 >= r4.size()) goto L25;
        WifiConfiguration r1 = r4.get(r0);
        if (r5.SSID.equals(r1.SSID) == false) goto L16;
        if (AccessPoint.getSecurity(r1) != AccessPoint.getSecurity(r5)) goto L16;
        return r1.networkId;
    L16:
        r0 = r0 + 1;
        goto L9
    L25:
        return -1;
    L17:
        return -1;
    L4:
        e = move-exception;
        e.printStackTrace();
        r4 = null;
        goto L6
    }

    private boolean matchScanResult(WifiConfiguration r4) {
        List<ScanResult> r3 = this.mWifiManager.getScanResults();
        if (r3 == null) goto L13;
        Iterator<ScanResult> r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L21;
        ScanResult r0 = r5.next();
        if (AccessPoint.removeDoubleQuotes(r4.SSID).equals(r0.SSID) == false) goto L6;
        if (AccessPoint.getSecurity(r0) != AccessPoint.getSecurity(r4)) goto L6;
        return true;
    L21:
        return false;
    L13:
        return false;
    }

    private void forceScan() {
        this.mWifiManager.startScan();
    }

    private AccessPoint findAccessPointBySsid(String r8, int[] r9) {
        List<ScanResult> r0 = this.mWifiManager.getScanResults();     // Catch: RuntimeException -> L25
        if (r0 == null) goto L24;
        Iterator<ScanResult> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L24;
        ScanResult r2 = r1.next();
        if (AccessPoint.removeDoubleQuotes(r2.SSID).equals(r8) == false) goto L7;
        if (r9 == null) goto L22;
        if (r9.length == 0) goto L22;
        int r3 = AccessPoint.getSecurity(r2);
        int r4 = r9.length;
        int r5 = 0;
    L15:
        if (r5 >= r4) goto L7;
        if (r3 == r9[r5]) goto L19;
        r5 = r5 + 1;
        goto L15
    L19:
        return new AccessPoint(getContext(), r2);
    L22:
        return new AccessPoint(getContext(), r2);
    L24:
        return new AccessPoint(getContext(), r8, r9[0]);
    L25:
        e = move-exception;
        OLog.e(TAG, "getScanResults failed: " + e.getMessage());
        return null;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_WifiSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(WifiSetupFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_WifiSetupFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_WifiSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(WifiSetupFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_WifiSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_WifiSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(WifiSetupFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_WifiSetupFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
